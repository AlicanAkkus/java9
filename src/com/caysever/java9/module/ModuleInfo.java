package com.caysever.java9.module;

import java.util.Optional;
import java.util.stream.Stream;

public class ModuleInfo {

    public static void main(String[] args) {

        ModuleInfo moduleInfo = new ModuleInfo();

        Module module = moduleInfo.getClass().getModule();

        Optional.ofNullable(module).ifPresent(m -> System.out.println(module.getName()));
        Optional.ofNullable(module.getDescriptor().requires()).ifPresent(requires -> Stream.ofNullable(requires).forEach(rs -> rs.forEach(r -> System.out.println(r.name()))));

    }

}
