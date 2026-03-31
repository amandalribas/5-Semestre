package org.example.apirestful.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(LocalDateTime localDateTime,
                            int errorCode,
                            String error,
                            String metodo,
                            String requestUri, //endereço dentro do servidor
                            Map<String, String> map, //usar quando tiver um Spring Validator
                            String message)
{


}
