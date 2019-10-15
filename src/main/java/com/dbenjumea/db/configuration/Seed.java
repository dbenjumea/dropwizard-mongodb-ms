package com.dbenjumea.db.configuration;

import com.google.common.base.Objects;

public class Seed {

    /** The host.*/
    private String host;

    /** The port.*/
    private int port;
    //getters, setters, hashcode and equals methods.


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(host, port);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Seed other = (Seed) obj;
        return Objects.equal(this.host, other.host)
                && Objects.equal(this.port, other.port);
    }

    @Override
    public String toString() {
        return "Seed{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
