package ru.rest.data.config;

//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletRegistration;
////if we start on Tomcat server
//public class WebAppInitializer implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) {
//        AnnotationConfigWebApplicationContext applicationContext =
//                new AnnotationConfigWebApplicationContext();
//        applicationContext.register(SpringConfig.class);
//        applicationContext.register(HibernateConfig.class);
//
//        servletContext.addListener(new ContextLoaderListener(applicationContext));
//
//        ServletRegistration.Dynamic dispatcher =
//                servletContext.addServlet("spring-mvc-dispatcher",
//                        new DispatcherServlet(applicationContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/*");
//    }
//}
