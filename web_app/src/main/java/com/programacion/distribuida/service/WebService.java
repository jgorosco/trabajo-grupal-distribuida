package com.programacion.distribuida.service;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WebService implements Service {

    @Override
    public void update(Routing.Rules rules) {
        rules.post("/board", this::handlePost);
        rules.get("/board", this::handleGet);
    }

    private void handlePost(ServerRequest request, ServerResponse response) {
        request.content()
                .as(String.class)
                .thenAccept(it -> {
                    response.status(204).send();
                    System.out.println("it " + it);
                    String[] values = it.split(" ");
                });
    }

    private void handleGet(ServerRequest request, ServerResponse response) {

    }
}
