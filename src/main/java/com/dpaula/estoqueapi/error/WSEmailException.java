package com.dpaula.estoqueapi.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Fernando de Lima on 15/12/21
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WSEmailException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WSEmailException(final String mensagem) {
        super(mensagem);
    }

    public WSEmailException(final String mensagem, final Throwable origem) {
        super(mensagem, origem);
    }
}
