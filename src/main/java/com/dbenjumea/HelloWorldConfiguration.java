package com.dbenjumea;

import com.dbenjumea.db.configuration.MongoDBConnection;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class HelloWorldConfiguration extends Configuration {
    /**
     * The data configuration for MongoDB.
     */

    private MongoDBConnection mongoDBConnection;

    @JsonProperty("swagger")
    private SwaggerBundleConfiguration swaggerBundleConfiguration;

    //Getters and setters

    public MongoDBConnection getMongoDBConnection() {
        return mongoDBConnection;
    }

    public void setMongoDBConnection(MongoDBConnection mongoDBConnection) {
        this.mongoDBConnection = mongoDBConnection;
    }

    public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
        return swaggerBundleConfiguration;
    }

    public void setSwaggerBundleConfiguration(SwaggerBundleConfiguration swaggerBundleConfiguration) {
        this.swaggerBundleConfiguration = swaggerBundleConfiguration;
    }
}
