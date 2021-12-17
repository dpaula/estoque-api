package com.dpaula.estoqueapi.error;

/**
 * @author Fernando de Lima on 13/12/21
 */
public class ItemNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -836670065912314363L;

    public ItemNotFoundException() {
    }

    public ItemNotFoundException(final String message) {
        super(message);
    }
}
