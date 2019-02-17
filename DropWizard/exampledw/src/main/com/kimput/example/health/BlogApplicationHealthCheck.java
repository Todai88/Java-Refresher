package main.com.kimput.example.health;

import com.codahale.metrics.health.HealthCheck;
import main.com.kimput.example.service.PartsService;

public class BlogApplicationHealthCheck extends HealthCheck {

    public static final String HEALTHY = "The Dropwizard service is healthy";
    public static final String UNHEALTHY = "The DropWizard serivce is not healthy";
    public static final String MESSAGE_PLACEHOLDER = "{}";

    private final PartsService partsService;


    public BlogApplicationHealthCheck(PartsService partsService) {
        this.partsService = partsService;
    }

    protected Result check() throws Exception {
        String postgresqlHealthStatus = partsService.performHealthCheck();

        if (postgresqlHealthStatus == null) {
            return Result.healthy(HEALTHY);
        } else {
            return Result.healthy(UNHEALTHY + MESSAGE_PLACEHOLDER, postgresqlHealthStatus);
        }
    }
}
