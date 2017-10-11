package com.caysever.java9.processes;

public class ProcessExample {

    public static void main(String[] args) {

        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("Current Process Id: = " + currentProcess.pid());
        System.out.println("Current Process Is Alive : = " + currentProcess.isAlive());
        currentProcess.parent().ifPresent(processHandle -> System.out.println("Parent pid : " + processHandle.pid()));

    }
}
