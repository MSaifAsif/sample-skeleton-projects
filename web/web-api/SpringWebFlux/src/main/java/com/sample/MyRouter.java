package com.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author saifasif
 */
@Component
public class MyRouter {
    @Bean
    public RouterFunction<ServerResponse> route(MyHandler myHandler) {

        return RouterFunctions
                .route(RequestPredicates.GET("/handle")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), myHandler::handle);
    }
}
