package com.dbenjumea.db.configuration;

import java.util.List;

public class MongoDBConnection {
    /**
     * The credentials user and password.
     */
    private Credentials credentials;

    /**
     * The lis of seeds.
     */
    private List<Seed> seeds;

    /**
     * The db.
     */
    private String database;

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public List<Seed> getSeeds() {
        return seeds;
    }

    public void setSeeds(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "MongoDBConnection{" +
                "credentials=" + credentials +
                ", seeds=" + seeds +
                ", database='" + database + '\'' +
                '}';
    }
}
