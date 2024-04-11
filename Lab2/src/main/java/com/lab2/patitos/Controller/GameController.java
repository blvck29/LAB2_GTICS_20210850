package com.lab2.patitos.Controller;

import com.lab2.patitos.Entity.GameConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "patito_hule", method = RequestMethod.GET)
public class GameController {

    @GetMapping(value = "")
    public String main(){
        return "game_config";
    }

    @PostMapping(value = "/configurando_juego")
    public String recibirConfiguraciones(GameConfig configuracion){


        configuracion.runGame();

        return "game";
    }

    @GetMapping("/game")
    public String game(Model model){
        model.addAttribute("tablero","a");

        return "game";
    }

}
