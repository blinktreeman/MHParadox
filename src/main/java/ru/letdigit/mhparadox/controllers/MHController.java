package ru.letdigit.mhparadox.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.letdigit.mhparadox.entities.GameParameter;

@Controller
@RequestMapping(path = "/")
public class MHController {

    @ModelAttribute(name = "gameParameter")
    public GameParameter gameParameter() {
        return new GameParameter();
    }

    @PostMapping
    public ResponseEntity<GameParameter> solve(@ModelAttribute GameParameter gameParameter) {
        return ResponseEntity.ok().body(gameParameter);
    }

    @GetMapping
    public String home() {
        return "index";
    }
}
