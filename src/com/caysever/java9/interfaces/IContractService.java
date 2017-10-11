package com.caysever.java9.interfaces;

public interface IContractService {

    void createContract();

    default void createDefaultContract() {
        Long defaultContractId = createDefaultContractID();
        displayContractDetails(defaultContractId);
    }

    private Long createDefaultContractID() {
        // Method implementation goes here.
        return 1L;
    }

    private static void displayContractDetails(Long contractId) {
        // Method implementation goes here.
        System.out.println("Contract details : " + contractId);
    }

}
