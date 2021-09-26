package com.game.handlers;

import com.game.entity.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Player> badRequest(Exception e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
