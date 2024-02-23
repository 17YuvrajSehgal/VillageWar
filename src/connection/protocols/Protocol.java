package connection.protocols;

import ChallengeDecision.Arbitrer;
import ChallengeDecision.ChallengeEntitySet;
import ChallengeDecision.ChallengeResource;
import ConcurrentAbstractFactory.BuildingFactoryConcurrent;
import ConcurrentAbstractFactory.WorkerFactoryConcurrent;
import ChallengeDecision.ChallengeResult;
import Controllers.VillageController;
import Game.ArmyUnit;
import Game.GameEngine;
import Models.Village;
import Utility.ArbitrerAdapter;
import Views.VillageView;
import VillageElements.*;
import concurrency.VillageControllerGenerator;
import connection.Clients.RequestType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static connection.protocols.ServerState.AVAILABLE;

public class Protocol {

    private VillageController villageController;
    GameEngine gameEngine;
    private ServerState state = AVAILABLE;
    private final ArbitrerAdapter arbitrerAdapter;
    ExecutorService executor = Executors.newCachedThreadPool();
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;


    /**
     * This method creates a new protocol instance
     * @param serverOutputStream server's output stream
     * @param inputStream server's input stream
     */
    public Protocol(ObjectOutputStream serverOutputStream, ObjectInputStream inputStream) {
        this.arbitrerAdapter = new ArbitrerAdapter();
        this.outputStream = serverOutputStream;
        this.inputStream = inputStream;
        this.gameEngine = new GameEngine();
    }

    /**
     * This method process the client's request
     */
    public void processInput(RequestType requestType) throws InvalidProtocolRequestException, IOException {
        switch (requestType) {

            //when client requests to check the status of the server, we return the current state of the server.
            case IS_AVAILABLE_CHECKUP -> {
                try {
                    outputStream.writeObject(state); // write current state of the server
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                printCurrentState();
            }

            case CHECK_USER_ID -> {
                int clientId;
                try {
                    clientId= (int) inputStream.readObject();
                    System.out.println("Client Id recieved: "+clientId);
                    if(checkDatabase(clientId).equalsIgnoreCase("NEW_USER")){
                        outputStream.writeObject("NEW_USER");
                    }else {
                        /**
                         * here goes the loading of previous state of the village of old user*
                         */
                    }
                    /**
                     * here goes the database check up to check if client already exists, as it is not required for
                     * assignment,we would like to consider the client as a new user.
                     */

                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }



            //when client requests to get the fight results of the fight, we return the fight results, but the calculation
            //is done on the server side, in this class. Also, we return the result only if the value of the army and
            //village of enemy is valid.
            case FIGHT_RANDOM_VILLAGE -> {
                try {
                    ArmyUnit armyUnit = null;
                    state = ServerState.RECEIVED_FIGHT_REQUEST;
                    printCurrentState();
                    Village randomVillage = null;
                    if(this.villageController!=null){
                        armyUnit = this.villageController.getArmyUnit();//(ArmyUnit) dataObjectInputStream.readObject();
                        randomVillage = gameEngine.getRandomVillage(this.villageController.getLevel()).getVillage();
                    }
                    if (randomVillage == null || armyUnit == null) {
                        printMsgToServer("Either village or army entity is null. Request failed -> returned null");
                        outputStream.writeObject(null);
                        break;
                    }else {
                        ChallengeResult challengeResult = getServerFightDecision(armyUnit, randomVillage);
                        outputStream.writeObject(challengeResult);
                    }
                    state = AVAILABLE;
                    printCurrentState();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }



            case RANDOM_ATTACK_ON_VILLAGE->{
                ArmyUnit randomArmy = gameEngine.getRandomArmyUnit(10);
                ChallengeResult challengeResult;
                state = ServerState.RECEIVED_FIGHT_REQUEST;
                printCurrentState();

                if (randomArmy == null || villageController == null) {
                    printMsgToServer("Either village or army entity is null. Request failed -> returned null");
                    outputStream.writeObject(null);
                    break;
                }else {
                    challengeResult = getServerFightDecision(randomArmy,villageController.getVillage());
                    outputStream.writeObject(challengeResult);
                }
            }



            case CREATE_VILLAGE_REQUEST -> {
                state = ServerState.RECEIVED_CREATE_VILLAGE_REQUEST;
                printCurrentState();
                VillageControllerGenerator villageControllerGenerator = new VillageControllerGenerator();

                Future<VillageController> futureVillageController =
                        (Future<VillageController>) executor.submit(villageControllerGenerator);

                while (!futureVillageController.isDone()){
                }

                if(futureVillageController.isDone()){
                    if(villageControllerGenerator.getVillageController()==null) System.out.println("Failed to make village");
                    this.villageController= villageControllerGenerator.getVillageController();
                    if(villageController==null){
                        printMsgToServer("Failed to create Village controller entity. Request failed -> returned null");
                        try {
                            outputStream.writeObject(null);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else {
                        try {
                            outputStream.writeObject(villageController);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                state = AVAILABLE;
                printCurrentState();
            }



            case GET_VILLAGE -> {
                state = ServerState.GET_VILLAGE_REQUEST_RECIEVED;
                printCurrentState();
                if(villageController==null){
                    try {
                        outputStream.writeObject(null);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    printMsgToServer("Village Controller entity is null. Request failed -> returned null");
                }
                else {
                    try {
                        System.out.println("Sending Updated Village Controller...");
                        outputStream.writeObject(this.villageController);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
                state=AVAILABLE;
                printCurrentState();
            }



            case CREATE_BUILDING_REQUEST -> {
                state = ServerState.RECEIVED_CREATE_BUILDING_REQUEST;
                printCurrentState();
                String buildingType;

                try {
                    buildingType = (String) inputStream.readObject();
                    printMsgToServer("Building type requested: "+buildingType);
                } catch (ClassNotFoundException | IOException e) {
                    throw new RuntimeException(e);
                }
                BuildingFactoryConcurrent buildingFactory = new BuildingFactoryConcurrent(buildingType);
                Future<Building> futureBuilding = (Future<Building>) executor.submit(buildingFactory);


                while (!futureBuilding.isDone()){

                }
                if(futureBuilding.isDone()){
                    Building building = buildingFactory.getBuilding();

                    if(villageController==null) printMsgToServer("Village is null, cannot add building");
                    else if(building==null) printMsgToServer("Worker is null, cannot add worker");
                    if(this.villageController==null || building==null){
                        printMsgToServer("Either village controller or building entity is null. Request failed -> returned null");
                        try {
                            outputStream.writeObject(null);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }else {
                        if(!villageController.addBuilding(building)){
                            System.out.println("Max Quantity Reached. Cannot add this building");
                            try {
                                outputStream.writeObject(null);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        else {
                            try {
                                outputStream.writeObject(building);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
                state = AVAILABLE;
                printCurrentState();
            }



            case CREATE_WORKER_REQUEST -> {
                state = ServerState.RECEIVED_CREATE_WORKER_REQUEST;
                printCurrentState();
                String workerType;

                try {
                    workerType = (String) inputStream.readObject();
                    printMsgToServer("Worker type requested: "+workerType);
                } catch (ClassNotFoundException | IOException e) {
                    throw new RuntimeException(e);
                }
                WorkerFactoryConcurrent workerFactory = new WorkerFactoryConcurrent(workerType);
                Future<Worker> futureWorkerFactory = (Future<Worker>) executor.submit(workerFactory);

                while (!futureWorkerFactory.isDone()){
                }

                if(futureWorkerFactory.isDone()){
                    Worker worker = workerFactory.getWorker();

                    if(villageController==null) printMsgToServer("Village is null, cannot add worker");
                    else if(worker==null) printMsgToServer("Worker is null, cannot add worker");

                    if(this.villageController==null || worker==null){
                        printMsgToServer("Either village controller or worker entity is null. Request failed -> returned null");
                        try {
                            outputStream.writeObject(null);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }else {
                        if(worker instanceof Peasant)
                            villageController.addWorker((Peasant) worker);
                        else if(worker instanceof Recruitable)
                            villageController.addArmy((Recruitable) worker);
                        try {
                            outputStream.writeObject(worker);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                state = AVAILABLE;
                printCurrentState();
            }



            case UPGRADE_VILLAGE -> {
                state = ServerState.GET_VILLAGE_REQUEST_RECIEVED;
                printCurrentState();
                if(villageController==null){
                    try {
                        outputStream.writeObject(null);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    printMsgToServer("Village Controller entity is null. Cannot update village. Request failed -> returned null");
                }
                else {
                    try {
                        if(villageController.upgradeVillage()){
                            outputStream.writeObject(villageController);
                        }
                        else {
                            printMsgToServer("Village upgrade cancelled");
                            outputStream.writeObject(null);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (UpgradeCancelledDueToMaxedOutException e) {
                        System.out.println("Village Already maxed out.");
                        outputStream.writeObject(villageController);
                    }

                }
                state=AVAILABLE;
                printCurrentState();
            }



            case TERMINATE_SERVER -> {
                state = ServerState.TERMINATED;
            }


            default -> throw new InvalidProtocolRequestException();
        }

        if(villageController!=null)
            villageController.updateView();
    }

    /**
     * This method returns the fight decision between villages
     * @param armyUnit army unit of attacking village
     * @param enemyVillage village of enemy
     * @return challenge decision
     */
    private ChallengeResult getServerFightDecision(ArmyUnit armyUnit, Village enemyVillage) {
        ArbitrerAdapter arbitrerAdapter = new ArbitrerAdapter();
        return arbitrerAdapter.judgeAttack(armyUnit,enemyVillage);
    }

    /**
     * This method check if the given user is already present in the database
     * @param clientId id of the client
     * @return NEW_USER if new user other wise OLD_USER
     */
    //this method is not implemented as the database is not the part of assignment
    private String checkDatabase(int clientId){
        if(clientId==786){
            return "OLD_USER";
        }
        else {
            return "NEW_USER";
        }
    }

    /**
     * this method prints the current state of server
     */
    private void printCurrentState(){
        System.out.println("\nCurrent Server State: "+state+"\n");
    }

    /**
     * This method prints message to the server console
     * @param msg message
     */
    private void printMsgToServer(String msg){
        System.out.println(msg);
    }


}
