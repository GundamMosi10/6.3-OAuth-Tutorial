package com.company.authorizationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration//because this is a configuration class we must annotate it with this!
@EnableAuthorizationServer //use this to turn on Authorization server features
public class OAuthConfig  extends AuthorizationServerConfigurerAdapter {

    private AuthenticationManager authenticationManager; //injected from earlier when created

    @Autowired
    public OAuthConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception { //this client is allowed to use OAuth 2 password flow

        clients.inMemory()
                .withClient("html5")//registers a client in this one it is HTML5
                .authorizedGrantTypes("password")
                .scopes("ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN") //these are authorities
                .secret("$2a$10$0Mf57EA3kipR1ej14v/tpeZ5UvV7kmcym57hfztwF79seJc.ulnHS");//this has a value of app_secret
                                                                                        //this is somewhat like a password
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager); //we pass the injected authentication manager to our
                                                                     //endpoints configuration so that the Authentication
                                                                    //Manager can be used to protect the endpoints of the
                                                                     //Authorization Server.
    }
}
