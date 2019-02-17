package main.com.kimput.example;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.setup.Environment;
import main.com.kimput.example.auth.DropwizardBlogAuthenticator;
import main.com.kimput.example.auth.DropwizardBlogAuthorizer;
import main.com.kimput.example.auth.User;
import main.com.kimput.example.config.ExampleDwConfiguration;
import main.com.kimput.example.health.BlogApplicationHealthCheck;
import main.com.kimput.example.resource.PartsResource;
import main.com.kimput.example.service.PartsService;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;

public class DropWizardBlogApplication extends Application<ExampleDwConfiguration> {
    public static final String SQL = "postgresql";
    public static final String SERVICE = "Example Service";
    public static final String BEARER = "Bearer";

    public static void main(String[] args) throws Exception {
        new DropWizardBlogApplication().run(args);
    }

    @Override
    public void run(ExampleDwConfiguration configuration, Environment environment) {
        final DataSource dataSource = configuration.getDataSourceFactory().build(environment.metrics(), SQL);
        DBI dbi = new DBI(dataSource);

        BlogApplicationHealthCheck healthCheck = new BlogApplicationHealthCheck(dbi.onDemand(PartsService.class));
        environment.healthChecks().register(SERVICE, healthCheck);

        environment.jersey()
                .register(new AuthDynamicFeature(new OAuthCredentialAuthFilter.Builder<User>()
                    .setAuthenticator(new DropwizardBlogAuthenticator())
                    .setAuthorizer(new DropwizardBlogAuthorizer()).setPrefix(BEARER).buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new PartsResource(dbi.onDemand(PartsService.class)));
        environment.jersey().register(new PartsResource(dbi.onDemand(PartsService.class)));
    }
}
