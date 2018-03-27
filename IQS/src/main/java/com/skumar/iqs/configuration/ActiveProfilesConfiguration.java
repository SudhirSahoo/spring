package com.skumar.iqs.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Class description goes here...
 *
 * @author Sudhir Sahoo
 * @since 3/22/2018
 */
@Configuration
public class ActiveProfilesConfiguration {
    private final String propertyFiles;
    private Environment environment;

    public ActiveProfilesConfiguration(Environment environment) {
        this.environment = environment;

        // use string joiner to append a prefix and suffix to each environment name
        StringJoiner stringJoiner = new StringJoiner(", ","application-",".properties");
        Arrays.stream(getActiveProfiles()).forEach(profile -> stringJoiner.add(profile));

        // make sure to strip out the "-default" suffix for the default profile
        this.propertyFiles = stringJoiner.toString().replace("-default", "");
    }

    public String getPropertyFiles(){
        return this.propertyFiles;
    }

    public boolean isDefaultProfile(){
        return isActive("default");
    }

    public boolean isDevelopmentProfile(){
        return isActive("dev");
    }

    public boolean isTestProfile(){
        return isActive("qa");
    }

    public boolean isProductionProfile(){
        return isActive("prod");
    }

    public boolean isActive(String profile){
        String[] activeProfiles = getActiveProfiles();

        return Arrays.stream(activeProfiles).anyMatch(p -> p.equalsIgnoreCase(profile));
    }

    public String[] getActiveProfiles(){
        return this.environment.getActiveProfiles();
    }
}
