package com.example.gpn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.concurrent.ConcurrentHashMap;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.example.gpn.wsdl");
        return marshaller;
    }

    @Bean("AddCache")
    @Scope("singleton")
    public ConcurrentHashMap<Nums, Integer> getAddCache() {
        return new ConcurrentHashMap<>();
    }

    @Bean("SubtractCache")
    @Scope("singleton")
    public ConcurrentHashMap<Nums, Integer> getSubtractCache() {
        return new ConcurrentHashMap<>();
    }

    @Bean("DivideCache")
    @Scope("singleton")
    public ConcurrentHashMap<Nums, Integer> getDivideCache() {
        return new ConcurrentHashMap<>();
    }

    @Bean("MultiplyCache")
    @Scope("singleton")
    public ConcurrentHashMap<Nums, Integer> getMultiplyCache() {
        return new ConcurrentHashMap<>();
    }
}
