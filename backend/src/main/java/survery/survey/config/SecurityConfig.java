package survery.survey.config;

import survery.survey.service.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors() // Enable CORS
                .and()
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/login", "/oauth2/**").permitAll() // Allow login and OAuth2 routes
                                .anyRequest().authenticated() // Secure all other routes
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login") // Custom login page
                        .defaultSuccessUrl("http://localhost:5173/", true) // Redirect to React frontend after successful login
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService)) // Use CustomOAuth2UserService to handle user info
                );

        return http.build();
    }
}
