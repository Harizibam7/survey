package survery.survey.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // Delegate to the default Spring OAuth2UserService to retrieve the user info
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // Here you can extract user information from oAuth2User
        String registrationId = userRequest.getClientRegistration().getRegistrationId(); // "google", "facebook", etc.
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        // Extract user attributes
        var attributes = oAuth2User.getAttributes();
        String email = (String) attributes.get("email");

        // Optionally, add custom logic here to save or register the user in the local database
        // Or load existing user details and enhance them

        // Create and return a new user based on the retrieved OAuth2 details
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                attributes,
                userNameAttributeName
        );
    }
}
