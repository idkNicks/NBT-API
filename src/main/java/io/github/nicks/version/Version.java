package io.github.nicks.version;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Version {

    v1_12_R1("1.12-R0.1", "1.12.1-R0.1", "1.12.2-R0.1"),
    v1_13_R1("1.13-R0.1"),
    v1_13_R2("1.13.1-R0.1", "1.13.2-R0.1"),
    v1_14_R1("1.14-R0.1", "1.14.1-R0.1", "1.14.2-R0.1", "1.14.3-R0.1", "1.14.4-R0.1"),
    v1_15_R1("1.15-R0.1", "1.15.1-R0.1", "1.15.2-R0.1"),
    v1_16_R1("1.16-R0.1", "1.16.1-R0.1", "1.16.2-R0.1"),
    v1_16_R2("1.16.3-R0.1"),
    v1_16_R3("1.16.4-R0.1", "1.16.5-R0.1"),
    v1_17_R1("1.17-R0.1", "1.17.1-R0.1"),
    v1_18_R1("1.18-R0.1", "1.18.1-R0.1"),
    v1_18_R2("1.18.2-R0.1"),
    v1_19_R1("1.19-R0.1", "1.19.1-R0.1", "1.19.2-R0.1"),
    v1_19_R2("1.19.3-R0.1"),
    v1_19_R3("1.19.4-R0.1"),
    v1_20_R1("1.20-R0.1", "1.20.1-R0.1");

    private final Set<String> versions;
    @Getter
    private final String version = name();

    Version(String... versions) {
        this.versions = new HashSet<>(Arrays.asList(versions));
    }

    public boolean matches(String version) {
        return this.versions.contains(version);
    }
}