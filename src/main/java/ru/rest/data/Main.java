package ru.rest.data;


import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ru.rest.data.config.HibernateConfig;
import ru.rest.data.config.SpringConfig;

import java.io.File;
import java.nio.file.Files;

@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8085);
        File baseDir = Files.createTempDirectory("embedded-tomcat").toFile();
        Context context = tomcat.addWebapp("",baseDir.getAbsolutePath());
        // Create a Spring application context
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(SpringConfig.class);
        appContext.register(HibernateConfig.class);
        appContext.setConfigLocation("ru.rest.data.config");
        // Create a DispatcherServlet and register it with Tomcat
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
        Tomcat.addServlet(context, "spring-mvc-dispatcher", dispatcherServlet).setLoadOnStartup(1);
        //context.addServletMappingDecoded("/*", "spring-mvc-dispatcher");
        context.addServletMapping("/*", "spring-mvc-dispatcher");
        tomcat.start();
        tomcat.getServer().await();

    }
}
