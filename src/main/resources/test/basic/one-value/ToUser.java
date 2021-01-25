package com;

public class ToUser {
    private ToUser() {}

    public static User map(final Benutzer other) {
        final User result = new User();
        result.setName(other.getName());
        return result;
    }
}
