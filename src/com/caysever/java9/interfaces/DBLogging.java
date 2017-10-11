package com.caysever.java9.interfaces;

public interface DBLogging {

    String MONGO_DB_NAME = "ABC_Mongo_Datastore";
    String NEO4J_DB_NAME = "ABC_Neo4J_Datastore";
    String CASSANDRA_DB_NAME = "ABC_Cassandra_Datastore";

    default void logInfo(String message) {
        log(message, "INFO");
    }

    default void logWarn(String message) {
        log(message, "WARN");
    }

    default void logError(String message) {
        log(message, "ERROR");
    }

    default void logFatal(String message) {
        log(message, "FATAL");
    }

    private void log(String message, String msgPrefix) {
        //Step1: Connect to DataStore
        //Setp2: Log Message with Prefix and styles etc.
        //Setp3: Close the DataStore connection
    }
    // Any other abstract methods
}