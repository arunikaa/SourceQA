package com.org.Utilities;

public class LoginTestData {
    private final String username;
    private final String password;

    public LoginTestData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
