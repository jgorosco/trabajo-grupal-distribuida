package com.programacion.distribuida;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.programacion.distribuida.dto.CustomerDto;
import com.programacion.distribuida.service.WebService;
import io.helidon.common.http.Http;
import io.helidon.common.reactive.Single;
import io.helidon.config.Config;
import io.helidon.config.ConfigValue;
import io.helidon.media.jsonp.JsonpSupport;
import io.helidon.webclient.WebClient;
import io.helidon.webclient.WebClientResponse;
import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.staticcontent.StaticContentSupport;
import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.LogManager;

public class Main {

    static {
        LogManager.getLogManager().reset();
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    private static final JsonBuilderFactory JSON_BUILDER = Json.createBuilderFactory(Collections.emptyMap());
    private static final JsonObject JSON_NEW_GREETING;

    static {
        JSON_NEW_GREETING = JSON_BUILDER.createObjectBuilder()
                .add("greeting", "Hola")
                .build();
    }

    static Routing createRouting() {
        return Routing.builder()
                .any("/", (req, res) -> {
                    // showing the capability to run on any path, and redirecting from root
                    res.status(Http.Status.MOVED_PERMANENTLY_301);
                    res.headers().put(Http.Header.LOCATION, "/login");
                    res.send();
                })
                .register("/login", new WebService())
                .register("/login", StaticContentSupport.builder("WEB")
                        .welcomeFileName("index.html")
                        .build())
                .build();
    }

    public static void main(String[] args) {
        Config config = Config.create();
        String url;
        int port = 9090;
        url = "http://localhost:" + port + "/customers";

        WebClient webClient = WebClient.builder()
                .baseUri(url)
                .addMediaSupport(JsonpSupport.create())
                .config(config.get("client"))
                //Since JSON processing support is not present by default, we have to add it.
                .build();

        performGetMethod(webClient)
                .flatMapSingle(it -> getUsers(webClient)).await();

        WebServer server = WebServer.builder(createRouting())
                .port(8091)
                .addMediaSupport(JsonpSupport.create())
                .build();

        // Start the server and print some info.
        server.start().thenAccept(ws -> {
            System.out.println("WEB server is up! http://localhost:" + ws.port());
        });

        // Server threads are not demon. NO need to block. Just react.
        server.whenShutdown()
                .thenRun(() -> System.out.println("WEB server is DOWN. Good bye!"));

    }

    static Single<Http.ResponseStatus> performPutMethod(WebClient webClient) {
        System.out.println("Put request execution.");
        return webClient.put()
                .path("/greeting")
                .submit("JSON_NEW_GREETING")
                .map(WebClientResponse::status)
                .peek(status -> System.out.println("PUT request executed with status: " + status));
    }

    static Single<String> performGetMethod(WebClient webClient) {
        System.out.println("Get request execution.");
        return webClient.get().path("/test")
                .request(String.class)
                .peek(string -> {
                    System.out.println("GET request successfully executed.");
                    System.out.println(string);
                });
    }

    static Single<JsonArray> getUsers(WebClient webClient) {
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
        System.out.println("Get request execution.");
        return webClient.get()
                .request(JsonArray.class)
                .peek(string -> {
                    System.out.println("GET request successfully executed.");
                    System.out.println(Arrays.asList(gson.fromJson(string.toString(), CustomerDto[].class)));
                });
    }
}
