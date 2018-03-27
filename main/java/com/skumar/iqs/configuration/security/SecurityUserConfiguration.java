package com.skumar.iqs.configuration.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Class description goes here...
 *
 * security.user.name=user
 * security.user.password=password
 * security.user.role[0]=USER
 * security.user.role[1]=ADMIN
 * @author Devin Spivey
 * @since 7/18/2017
 */
@Configuration
@ConfigurationProperties(prefix = "security.user")
public class SecurityUserConfiguration {
    private String name;
    private String password;
    private String[] role;

    //region Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
    }

    public String generateEmailAddress(){
        return this.name + "@hma.skumar.com";
    }

    //endregion
}
