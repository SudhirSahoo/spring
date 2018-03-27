package com.skumar.iqs.configuration;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * This configuration class is necessary for "deep linking" to work with
 * an Angular SPA. We're basically redirecting any 404 - Not Found errors
 * to the root URL which will allow Angular to load. Once loaded, the
 * Angular application should load the correct view based on the referrer
 * URL of the original request.
 *
 * Check out the <a href="https://angular.io/guide/router#appendix-locationstrategy-and-browser-url-styles">Angular Routing & Navigation</a>
 * documentation for more information.
 *
 * @author Devin Spivey
 * @see <a href="https://angular.io/guide/router#appendix-locationstrategy-and-browser-url-styles">Angular Routing & Navigation</a>
 * @since 7/18/2017
 */
@Configuration
public class AngularPathLocationConfiguration {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new AngularPathLocationStrategyCustomizer();
    }

    private static class AngularPathLocationStrategyCustomizer implements EmbeddedServletContainerCustomizer {
        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/"));
        }
    }
}
