package com.dbenjumea;

import com.dbenjumea.db.MongoDBFactoryConnection;
import com.dbenjumea.db.MongoDBManaged;
import com.dbenjumea.db.daos.DonutDAO;
import com.dbenjumea.health.DropwizardHealthCheck;
import com.dbenjumea.resources.DonutResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldApplication.class);


    public static void main(final String[] args) throws Exception {
        LOGGER.info("Start application.");
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "Hello  tutorial";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(new SwaggerBundle<HelloWorldConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                    final HelloWorldConfiguration helloWorldConfiguration) {
                return helloWorldConfiguration.getSwaggerBundleConfiguration();
            }
        });
    }

    @Override
    public void run(final HelloWorldConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application

        final MongoDBFactoryConnection mongoDBManagerConn = new MongoDBFactoryConnection(configuration.getMongoDBConnection());

        final MongoDBManaged mongoDBManaged = new MongoDBManaged(mongoDBManagerConn.getClient());

        final DonutDAO donutDAO = new DonutDAO(mongoDBManagerConn.getClient()
                .getDatabase(configuration.getMongoDBConnection().getDatabase())
                .getCollection("donuts"));

        environment.lifecycle().manage(mongoDBManaged);
        environment.jersey().register(new DonutResource(donutDAO));
        environment.healthChecks().register("DropwizardMongoDBHealthCheck",
                new DropwizardHealthCheck(mongoDBManagerConn.getClient()));
    }

}
