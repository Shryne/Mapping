package com;

public class ToBenutzer {
    private ToBenutzer() {}

    public static Benutzer map(final User other) {
        final Benutzer result = new Benutzer();
        result.setName(other.getName());
        return result;
    }
}
