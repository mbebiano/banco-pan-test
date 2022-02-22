package com.example.bancopan.validations.erros;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.charset.Charset;

import static feign.FeignException.errorStatus;

@Configuration
public class CustomErrorDecoder implements ErrorDecoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomErrorDecoder.class);

    @Override
    public Exception decode(String methodKey, Response response) {

        try {
            String message = Util.toString(response.body().asReader(Charset.defaultCharset()));
            String path = response.request().url();
            Integer status = response.status();

            switch (status) {
                case 400:
                    return new BadRequestError(message, status, path);
                case 404:
                    return new NotFoundError(message, status, path);
                default:
                    return new InternalServerError(message, status, path);
            }
        } catch (IOException e) {
            LOGGER.error("stage=error method=CustomErrorDecoder.decode message={}", e.getMessage());
        }

        return errorStatus(methodKey, response);

    }

}

