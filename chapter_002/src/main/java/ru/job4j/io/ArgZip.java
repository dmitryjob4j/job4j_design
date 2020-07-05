package ru.job4j.io;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ArgZip {
    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (Files.notExists(Paths.get(directory())) || args.length < 2) {
            throw new IllegalArgumentException("Parameters set incorrectly");
        }
        return true;
    }

    public String directory() {
        return args[0];
    }

    public String exclude() {
        return args[1];
    }

    public String output() {
        return args[2];
    }

}
