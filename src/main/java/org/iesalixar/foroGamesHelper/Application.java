package org.iesalixar.foroGamesHelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//            return new WebMvcConfigurer() {
//                    @Override
//                    public void addCorsMappings(CorsRegistry registry) {
//                            registry.addMapping("/**")
//                                    .allowedOrigins("http://localhost:4200")
//                                    .allowedMethods("GET", "POST", "PUT", "DELETE")
//                                    .maxAge(3600);
//                    }
//
//            };
//    }
}
