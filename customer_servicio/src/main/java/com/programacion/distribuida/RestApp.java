package com.programacion.distribuida;

import com.kumuluz.ee.discovery.annotations.RegisterService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(value = "/")
@RegisterService("/api")
@ApplicationScoped
public class RestApp extends Application {


}
