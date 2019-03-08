package com.mitrais.bootcamp.rms.domain;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

@Data
public class Department {
    private Integer id;
    private String name;

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
