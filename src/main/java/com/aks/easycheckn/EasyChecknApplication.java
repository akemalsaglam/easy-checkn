package com.aks.easycheckn;

import com.aks.commons.graphql.GraphQLScalars;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GraphQLScalars.class)
public class EasyChecknApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyChecknApplication.class, args);
    }

}
