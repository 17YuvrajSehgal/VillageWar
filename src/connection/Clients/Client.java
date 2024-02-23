package connection.Clients;

import ConcurrentAbstractFactory.BuildingFactoryConcurrent;
import ConcurrentAbstractFactory.WorkerFactoryConcurrent;
import ChallengeDecision.ChallengeResult;
import Controllers.VillageController;
import Models.Village;
import VillageElements.Building;
import VillageElements.Worker;

import java.io.*;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the client class of the game that represents a user on the server
 */
public class Client extends Thread {
    private Random random;
    private final int PLAYER_ID;
    private VillageController villageController;
    private String HOST_NAME;
    private final int PORT_NUMBER;
    private boolean isVillageAvailable = false;
    Socket socket;
    ObjectInputStream clientInputStream;
    ObjectOutputStream clientOutputStream;


    /**
     * This constructor creates a new instance of client at given port number and host name
     * @param PORT_NUMBER Port number
     * @param HOST_NAME host name
     */
    public Client(int PORT_NUMBER, String HOST_NAME) {
        this.PORT_NUMBER = PORT_NUMBER;
        this.HOST_NAME = HOST_NAME;
        random = new SecureRandom();
        PLAYER_ID = random.nextInt(0, Integer.MAX_VALUE);
    }

    /**
     * This method sets up the client on given port and host
     * @throws IOException throw IO exception if there was an error connecting to the server
     */
    public void setupClient() throws IOException {


        try {
                socket = new Socket(HOST_NAME, PORT_NUMBER);
                clientOutputStream = new ObjectOutputStream(socket.getOutputStream());
                clientInputStream = new ObjectInputStream(socket.getInputStream());



            checkConnectivity();
            verifyUser();

            boolean condition = true;
            while (condition) {

                if (isVillageAvailable) {
                    villageController = getVillage();
                    villageController.updateView();
                }


                printMenu();

                int input;
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();

                switch (input) {
                    case 0 -> {
                        condition = false;
                    }

                    //create a new Village
                    case 1 -> {
                        VillageController villageController1 = createVillage();
                        if (villageController1 == null) {
                            System.out.println("Cannot create a village at the moment");
                        } else {
                            System.out.println("Village created Successfully");
                            villageController = villageController1;
                            isVillageAvailable = true;
                            System.out.println(villageController1);
                        }
                    }

                    //print the created village on screen
                    case 2 -> {
                        villageController = upgradeVillage();
                        if (villageController == null) {
                            System.out.println("Upgrade Failed");
                        } else if (villageController.getLevel() == villageController.getLevel()) {
                            System.out.println("Level is maxed out.");
                        } else {
                            System.out.println("Upgrade Successful");
                        }
                    }

                    //fight a random Village
                    case 3 -> {
                        ChallengeResult challengeResult = fightRandomVillage();
                        if (challengeResult == null)
                            System.out.println("Cannot process this Request");
                        else {
                            System.out.println("Result of challenge is: ");
                            challengeResult.print();
                        }
                    }

                    //add lumber mill
                    case 4 -> {
                        Building building = addBuilding(BuildingFactoryConcurrent.LUMBER_MILL);
                        if (building == null)
                            System.out.println("Failed to add Lumber Mill to village");
                        else {
                            System.out.println("Building was successfully added to the village");
                            System.out.println(building + "\n\n");
                        }
                    }

                    //add iron mill
                    case 5 -> {
                        Building building = addBuilding(BuildingFactoryConcurrent.IRON_MINE);
                        if (building == null)
                            System.out.println("Failed to add Iron Mine to village");
                        else {
                            System.out.println("Building was successfully added to the village");
                            System.out.println(building + "\n\n");
                        }
                    }

                    //add gold mine
                    case 6 -> {
                        Building building = addBuilding(BuildingFactoryConcurrent.GOLD_MINE);
                        if (building == null)
                            System.out.println("Failed to add Gold Mine to village");
                        else {
                            System.out.println("Building was successfully added to the village");
                            System.out.println(building + "\n\n");
                        }
                    }

                    //add farm
                    case 7 -> {
                        Building building = addBuilding(BuildingFactoryConcurrent.FARM);
                        if (building == null)
                            System.out.println("Failed to add Farm to village");
                        else {
                            System.out.println("Building was successfully added to the village");
                            System.out.println(building + "\n\n");
                        }
                    }

                    //add catapult
                    case 8 -> {
                        Building building = addBuilding(BuildingFactoryConcurrent.CATAPULT);
                        if (building == null)
                            System.out.println("Failed to add Catapult to village");
                        else {
                            System.out.println("Building was successfully added to the village");
                            System.out.println(building + "\n\n");
                        }
                    }

                    //add cannon
                    case 9 -> {
                        Building building = addBuilding(BuildingFactoryConcurrent.CANNON);
                        if (building == null)
                            System.out.println("Failed to add Cannon Mine to village");
                        else {
                            System.out.println("Building was successfully added to the village");
                            System.out.println(building + "\n\n");
                        }
                    }

                    //add archer tower
                    case 10 -> {
                        Building building = addBuilding(BuildingFactoryConcurrent.ARCHER_TOWER);
                        if (building == null)
                            System.out.println("Failed to add Archer Tower to village");
                        else {
                            System.out.println("Building was successfully added to the village");
                            System.out.println(building + "\n\n");
                        }
                    }

                    //add soldier
                    case 11 -> {
                        Worker worker = addWorker(WorkerFactoryConcurrent.SOLDIER);
                        if (worker == null) {
                            System.out.println("Cannot add this worker currently.");
                        } else {
                            System.out.println("Worker was successfully added to the village");
                            System.out.println(worker + "\n\n");
                        }
                    }

                    //add knight
                    case 12 -> {
                        Worker worker = addWorker(WorkerFactoryConcurrent.KNIGHT);
                        if (worker == null) {
                            System.out.println("Cannot add this worker currently.");
                        } else {
                            System.out.println("Worker was successfully added to the village");
                            System.out.println(worker + "\n\n");
                        }
                    }

                    //add miner
                    case 13 -> {
                        Worker worker = addWorker(WorkerFactoryConcurrent.MINER);
                        if (worker == null) {
                            System.out.println("Cannot add this worker currently.");
                        } else {
                            System.out.println("Worker was successfully added to the village");
                            System.out.println(worker + "\n\n");
                        }
                    }

                    //add farmer
                    case 14 -> {
                        Worker worker = addWorker(WorkerFactoryConcurrent.FARMER);
                        if (worker == null) {
                            System.out.println("Cannot add this worker currently.");
                        } else {
                            System.out.println("Worker was successfully added to the village");
                            System.out.println(worker + "\n\n");
                        }
                    }

                    //add collector
                    case 15 -> {
                        Worker worker = addWorker(WorkerFactoryConcurrent.COLLECTOR);
                        if (worker == null) {
                            System.out.println("Cannot add this worker currently.");
                        } else {
                            System.out.println("Worker was successfully added to the village");
                            System.out.println(worker + "\n\n");
                        }
                    }

                    //add builder
                    case 16 -> {
                        Worker worker = addWorker(WorkerFactoryConcurrent.BUILDER);
                        if (worker == null) {
                            System.out.println("Cannot add this worker currently.");
                        } else {
                            System.out.println("Worker was successfully added to the village");
                            System.out.println(worker + "\n\n");
                        }
                    }

                    //add archer
                    case 17 -> {
                        Worker worker = addWorker(WorkerFactoryConcurrent.ARCHER);
                        if (worker == null) {
                            System.out.println("Cannot add this worker currently.");
                        } else {
                            System.out.println("Worker was successfully added to the village");
                            System.out.println(worker + "\n\n");
                        }
                    }

                    //random attack on village
                    case 18 -> {
                        ChallengeResult challengeResult = randomAttackOnYourVillage();
                        if (challengeResult == null)
                            System.out.println("Cannot process this Request");
                        else {
                            System.out.println("Result of challenge is: ");
                            challengeResult.print();
                            System.out.println();
                        }
                    }

                    default -> System.out.println("Invalid Option, Please try again.");

                }

            }
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    /**
     * This method creates a random army and attacks the clients village.
     * @return the challenge result of fight
     */
    private ChallengeResult randomAttackOnYourVillage() {
        try {
            clientOutputStream.writeObject(RequestType.RANDOM_ATTACK_ON_VILLAGE);

            return (ChallengeResult) clientInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method verify the user identity
     */
    private void verifyUser() {
        try {
            System.out.print("Verifying user identity:\t");
            clientOutputStream.writeObject(RequestType.CHECK_USER_ID);
            clientOutputStream.writeObject(PLAYER_ID);
            String msgReceived = (String) clientInputStream.readObject();
            if (msgReceived.equalsIgnoreCase("NEW_USER")) {
                System.out.print("You are a new user. Please create a new village to start the game.\n");
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method checks the connectivity with server
     */
    private void checkConnectivity() {
        System.out.print("Server Connection Status:\t");
        try {
            clientOutputStream.writeObject(RequestType.IS_AVAILABLE_CHECKUP);
            System.out.print(clientInputStream.readObject()+"\n");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method cretes a new village
     * @return village controller of the village
     */
    private VillageController createVillage() {
        VillageController villageController;
        try {
            clientOutputStream.writeObject(RequestType.CREATE_VILLAGE_REQUEST);
            villageController = (VillageController) clientInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return villageController;
    }

    /**
     * This method get the latest village copy from the server
     * @return Village controller copy of village
     */
    private VillageController getVillage() {
        VillageController villageController1;
        try {
            clientOutputStream.writeObject(RequestType.GET_VILLAGE);
            villageController1 = (VillageController) clientInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return villageController1;
    }

    /**
     * Fights a random village and prints the result on screen
     * @return challenge result of fight
     */
    private ChallengeResult fightRandomVillage() {
        try {
            clientOutputStream.writeObject(RequestType.FIGHT_RANDOM_VILLAGE);
            ChallengeResult outcome = (ChallengeResult) clientInputStream.readObject();

            if (outcome != null) {
                return outcome;
            } else {
                return null;
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method add the given building type to the village
     * @param buildingType name of building
     * @return reference of the building
     */
    private Building addBuilding(String buildingType) {

        Building building;
        try {
            clientOutputStream.writeObject(RequestType.CREATE_BUILDING_REQUEST);
            clientOutputStream.writeObject(buildingType);

            building = (Building) clientInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return building;
    }

    /**
     * This method adds a new worker to the village
     * @param workerType name of the worker
     * @return reference to worker
     */
    private Worker addWorker(String workerType) {

        Worker worker;
        try {
            clientOutputStream.writeObject(RequestType.CREATE_WORKER_REQUEST);
            clientOutputStream.writeObject(workerType);

            worker = (Worker) clientInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return worker;
    }

    /**
     * This method upgrades the worker
     * @return upgrades controller of village
     */
    private VillageController upgradeVillage() {
        VillageController villageController1;

        try {
            clientOutputStream.writeObject(RequestType.UPGRADE_VILLAGE);
            villageController1 = (VillageController) clientInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return villageController1;
    }

    /**
     * This method prints the available option to the console
     */
    private void printMenu() {
        System.out.println("\nWhat do you want to do?");

        String options1 =
                        """
                        0. Exit.                    4. Add Lumber Mill     8. Add Catapult        12. Add Knight         16. Add Builder
                        1. Create a new Village     5. Add Iron Mine       9. Add Cannon          13. Add Miner          17. Add Archer
                        2. Upgrade Village          6. Add Gold Mine       10. Add Archer Tower   14. Add Farmer         18. Random attack on your village
                        3. Attack a random Village  7. Add Farm            11. Add Soldier        15. Add Collector
                        """;
        System.out.println(options1);


    }

}
