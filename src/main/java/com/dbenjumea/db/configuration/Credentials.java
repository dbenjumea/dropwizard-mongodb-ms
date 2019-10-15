package com.dbenjumea.db.configuration;

import com.dbenjumea.util.PasswordSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;

import java.util.Arrays;

public class Credentials {
    /** The user name.*/
    private String username;

    /** The password.*/
    @JsonSerialize(using = PasswordSerializer.class)
    private char[] password;

    //getters, setters, hashcode and equals methods.


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Credentials other = (Credentials) obj;
        return Objects.equal(this.username, other.username)
                && Arrays.equals(this.password, other.password);
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "username='" + username + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
