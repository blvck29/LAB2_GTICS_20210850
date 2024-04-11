package com.lab2.patitos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class gameController {

    @GetMapping(value = "/patito_hule")
    public String main(){
        return "game_config";
    }

}
