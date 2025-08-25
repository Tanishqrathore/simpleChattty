package com.example.Chatfinal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//configures stomp over websocket comm. for springboot
//configuration bean is processes at application startup


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //routing of requests received from client(websock waali)
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        //requests with /topic prefixes are broadcasted, this spins up a inmemory message broker: that does it;
        config.enableSimpleBroker("/topic");

        //requests with /app/xyz routing i.e. that contain /app prefix are forwarded to controller with /xyz mapping;
        config.setApplicationDestinationPrefixes("/app");


    }

    //websocket comm. with backend
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){

        //this sets-up an endpoint for client to communicate to; STOMP handshake occurs at http://localhost:8080/chat endpoint;
         registry.addEndpoint("/chat")
                 .setAllowedOrigins("http://localhost:5173")
                 .withSockJS(); //fallback for websocket
    }




}
//i still need to understand wokring and need of config beans;;;
