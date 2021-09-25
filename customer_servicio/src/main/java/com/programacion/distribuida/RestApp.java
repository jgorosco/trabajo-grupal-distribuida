package com.programacion.distribuida;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/")
public class RestApp extends Application {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object obj) {

    }

}
