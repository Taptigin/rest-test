package hello;

import io.swagger.jaxrs.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashSet;
import java.util.Set;


@ComponentScan
@EnableAutoConfiguration
public class Application extends javax.ws.rs.core.Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public Application(){
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("hello");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;
    }
}
