package com.example.bancopan.connector.factory;

import com.example.bancopan.connector.api.IBGEDataServiceAPI;
import com.example.bancopan.utils.Environments;
import com.example.bancopan.validations.erros.CustomErrorDecoder;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import static java.lang.Boolean.TRUE;
import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class IBGEDataServiceAPIFactory {

    @Bean
    public IBGEDataServiceAPI servicosDadosIbgeAPI(Environment environment) {
        String host = environment.getProperty(Environments.IBGE_API_SERVICE_HOST);
        Integer connectionTimeout = environment.getProperty(Environments.IBGE_API_SERVICE_CONNECTION_TIMEOUT, Integer.class);
        Integer readTimeout = environment.getProperty(Environments.IBGE_API_SERVICE_READ_TIMEOUT, Integer.class);
        Request.Options options = new Request.Options(connectionTimeout, SECONDS, readTimeout, SECONDS, TRUE);

        return Feign.builder()
                .options(options)
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(IBGEDataServiceAPI.class))
                .logLevel(Logger.Level.FULL)
                .errorDecoder(new CustomErrorDecoder())
                .target(IBGEDataServiceAPI.class, host);
    }

}
