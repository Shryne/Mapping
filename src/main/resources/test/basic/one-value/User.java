package com;

import com.something.Processing.Map;
import com.something.Processing.MapPartner;

@MapPartner(Benutzer.class)
public class User {
    @Map
    private String name;

    public User() {}

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
