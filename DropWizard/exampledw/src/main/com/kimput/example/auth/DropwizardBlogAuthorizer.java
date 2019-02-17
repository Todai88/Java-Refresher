package main.com.kimput.example.auth;

import java.util.Objects;

public class DropwizardBlogAuthorizer implements io.dropwizard.auth.Authorizer<User> {
    @Override
    public boolean authorize(User principal, String role) {
        if (Objects.nonNull(principal)) {
            return true;
        }
        return false;
    }
}
