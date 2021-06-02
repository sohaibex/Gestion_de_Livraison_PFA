package com.livraison.Livraison.exception;

import com.livraison.Livraison.models.User;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message)
    {
        super(message);
    }
}
