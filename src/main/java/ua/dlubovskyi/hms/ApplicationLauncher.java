package ua.dlubovskyi.hms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedWebappClassLoader;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {"ua.dlubovskyi.hms"})
public class ApplicationLauncher extends SpringBootServletInitializer {



    public static void main(String[] args) {
        SpringApplication.run(ApplicationLauncher.class, args);
    }
}