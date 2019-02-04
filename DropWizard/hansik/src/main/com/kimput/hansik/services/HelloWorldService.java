package main.com.kimput.hansik.services;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import main.com.kimput.hansik.HelloWorldConfiguration;
import main.com.kimput.hansik.health.TemplateHealthCheck;
import main.com.kimput.hansik.resources.HelloWorldResource;

public class HelloWorldService extends Service<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldService().run(args);
    }

    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.setName("hello-world");
    }

    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
        final String template = helloWorldConfiguration.getTemplate();
        final String defaultName = helloWorldConfiguration.getDefaultName();
        environment.addResource(new HelloWorldResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }
}
