package main.com.kimput.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import main.com.kimput.example.config.ExampleDwConfiguration;
import main.com.kimput.example.health.ExampleDwHealthCheck;
import main.com.kimput.example.service.ExampleService;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;

public class ExampleDwApplication extends Application {
    public static final String SQL = "postgresql";
    public static final String SERVICE = "Example Service";
    public static final String BEARER = "Bearer";

    @Override
    public void run(ExampleDwConfiguration configuration, Environment environment) {
        final DataSource dataSource = configuration.getDataSourceFactory().build(environment.metrics(), SQL);
        DBI dbi = new DBI(dataSource);

        var healthCheck = new ExampleDwHealthCheck(dbi.onDemand(ExampleService.class));
        environment.healthChecks().register(SERVICE, healthCheck);
    }
}
