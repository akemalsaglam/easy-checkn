package com.aks.easycheckn.util;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GraphQLScalars {

    @Bean
    public GraphQLScalarType uuid() {
        return ExtendedScalars.UUID;
    }
}
