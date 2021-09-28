package com.programacion.distribuida.rest;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.UUID;

@ApplicationScoped
@ApplicationPath("/")
public class RestApp extends Application {

    @Inject
    @ConfigProperty(name="server.port", defaultValue = "8080")
    private Integer port;

    public static final String NAME = "app producto";
    private String ID;

    @PostConstruct
    public void inicializar(){
        UUID uuid = UUID.randomUUID();
        ID = uuid.toString();
    }
    public void init(@Observes @Initialized(ApplicationScoped.class) Object obj){

        System.out.println("App Inicializada");

        ConsulClient cliente = new ConsulClient();
        NewService newService = new NewService();

        newService.setName(NAME);
        newService.setId(ID);
        newService.setAddress("127.0.0.1");
        newService.setPort(port);

        NewService.Check check = new NewService.Check();
        {
            check.setMethod("GET");
            check.setHttp("http://127.0.0.1:" + port + "/productos/ping");
            check.setInterval("10s");
            check.setDeregisterCriticalServiceAfter("20s");
            newService.setCheck(check);
        }

        String routerRule       = String.format("traefik.http.routers.%s.rule=PathPrefix(`/%s`)",NAME, NAME);
        String middlewaresRule  = String.format("traefik.http.middlewares.%s.stripprefix.prefixes=/%s",NAME,NAME);
        String middlewares      = String.format("traefik.http.routers.%s.middlewares=%s", NAME,NAME);

        newService.setTags(Arrays.asList(routerRule, middlewaresRule, middlewares));
        cliente.agentServiceRegister(newService);

    }

    public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object obj){
        System.out.println("App Destruida");
        ConsulClient cliente = new ConsulClient();
        cliente.agentServiceDeregister(ID);
    }

}
