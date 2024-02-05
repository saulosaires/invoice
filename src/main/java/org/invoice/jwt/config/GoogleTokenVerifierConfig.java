package org.invoice.jwt.config;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class GoogleTokenVerifierConfig {

    @Bean
    public GoogleIdTokenVerifier googleTokenVerifier() {
        NetHttpTransport transport = new NetHttpTransport();
        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        return new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList("957001662031-msgo7pbtft5s6a388r9lsumetbu8ct2k.apps.googleusercontent.com"))
                .build();
    }

}
