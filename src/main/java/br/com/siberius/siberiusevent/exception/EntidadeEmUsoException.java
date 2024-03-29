package br.com.siberius.siberiusevent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntidadeEmUsoException extends NegocioException {

    public EntidadeEmUsoException(String message) {
        super(message);
    }
}
