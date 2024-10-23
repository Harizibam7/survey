package survery.survey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Match API endpoints
                .allowedOrigins("http://localhost:5173") // Allow requests from your React app
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow the necessary HTTP methods
                .allowedHeaders("*") // Allow any headers
                .allowCredentials(true); // Allow credentials (such as cookies or authentication tokens)
    }
}
