package connection.protocols;

/**
 * This enum type represents the various states that a server can have during execution
 */
public enum ServerState {
    AVAILABLE,
    GET_VILLAGE_REQUEST_RECIEVED,
    RECEIVED_FIGHT_REQUEST,
    RECEIVED_CREATE_VILLAGE_REQUEST,
    RECEIVED_CREATE_BUILDING_REQUEST,
    RECEIVED_CREATE_WORKER_REQUEST,
    TERMINATED
}
