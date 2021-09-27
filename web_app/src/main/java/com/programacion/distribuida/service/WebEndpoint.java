package com.programacion.distribuida.service;

import javax.websocket.*;

public class WebEndpoint extends Endpoint {

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        session.addMessageHandler((MessageHandler.Whole<String>) message -> {
            try {
                // Send all messages in the queue
                if (message.equals("SEND")) {
                    session.getBasicRemote().sendObject("HOLA");

                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        });
    }

    public static class UppercaseEncoder implements Encoder.Text<String> {

        @Override
        public String encode(String s) {
            return s.toUpperCase();
        }

        @Override
        public void init(EndpointConfig config) {
        }

        @Override
        public void destroy() {
        }
    }
}
