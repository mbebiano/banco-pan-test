package com.example.bancopan.connector.factory;

import com.example.bancopan.connector.api.ServicosDadosIbgeAPI;
import com.example.bancopan.connector.api.ViaCepAPI;
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
public class ServicosDadosIbgeFactory {

    private final Environment env;

    public ServicosDadosIbgeFactory(Environment env) {
        this.env = env;
    }

    @Bean
    public ServicosDadosIbgeAPI servicosDadosIbgeAPI(Environment environment) {
        String host = environment.getProperty(Environments.SEVICO_DADOS_IBGE_API_HOST);
        Integer connectionTimeout = environment.getProperty(Environments.SEVICO_DADOS_IBGE_CONNECTION_TIMEOUT, Integer.class);
        Integer readTimeout = environment.getProperty(Environments.SEVICO_DADOS_IBGE_API_TIMEOUT, Integer.class);
        Request.Options options = new Request.Options(connectionTimeout, SECONDS, readTimeout, SECONDS, TRUE);

        return Feign.builder()
                .options(options)
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ServicosDadosIbgeAPI.class))
                .logLevel(Logger.Level.FULL)
                .errorDecoder(new CustomErrorDecoder())
                .target(ServicosDadosIbgeAPI.class, host);
    }

}
