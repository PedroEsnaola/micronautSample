package com.example.model;

public enum Role{
    ADMIN("ROLE_ADMIN"),USER("ROLE_USER");

    String role;

    @Override
    public String toString() {
        return role;
    }

    Role(String role) {
        this.role = role;
    }
}
