package com.caysever.java9.processes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProcessPipeExample {

    public static void main(String[] args) throws Exception {
        long pid = ProcessHandle.current().pid();
        System.out.println("Current pid : " + pid);

        ProcessHandle.allProcesses().map(p -> p.info().command()).filter(Optional::isPresent).collect(Collectors.toList()).forEach(System.out::println);

        new ProcessBuilder().command("sleep", "3").start().onExit().thenAccept(System.out::println);

        String directory = "/Users/alican.akkus";
        ProcessBuilder[] builders = {
                new ProcessBuilder("ls", directory),
                new ProcessBuilder("xargs", "grep", "-h", "^D "),
                new ProcessBuilder("awk", "{print $1;}"),
                new ProcessBuilder("sort", "-u")};


        List<Process> processes = ProcessBuilder.startPipeline(List.of(builders));

        new BufferedReader(new InputStreamReader(processes.get(processes.size() - 1).getInputStream())).lines().forEach(System.out::println);
    }
}
