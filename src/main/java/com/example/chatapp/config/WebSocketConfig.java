package com.example.chatapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //definimos un "chatroom" donde todos vemos el msj que llegue a /topic
        registry.enableSimpleBroker("/topic");
        //todos los msj que lleguen con el prefijo /app los procese
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //definimos el endpoint del chat
        registry.addEndpoint("/chat")
                .setAllowedOrigins("/http://localhost:8080")
                .withSockJS();
    }

    
}
