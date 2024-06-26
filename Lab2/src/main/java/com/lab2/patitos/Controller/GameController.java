package com.lab2.patitos.Controller;

import com.lab2.patitos.Entity.GameConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "patito_hule", method = RequestMethod.GET)
public class GameController {

    GameConfig configuracion = new GameConfig();

    private String filas;
    private String columnas;
    private int cantidadCasillas;
    private int cantidadFotos;
    private List<Integer> indicesFotos = new ArrayList<>();
    private List<String> listaPosiciones = new ArrayList<>();

    @GetMapping(value = "")
    public String gameConfig(){
        return "game_config";
    }

    @PostMapping(value = "/configurando_juego")
    public String recibirConfiguraciones(@RequestParam(name = "numeroFilas") String numeroFilas,
                                         @RequestParam(name = "numeroColumnas") String numeroColumnas,
                                         @RequestParam(name = "posicionesIniciales") String posicionesIniciales,
                                         @RequestParam(name = "fotosTomadas") String fotosTomadas){

        configuracion.setNumeroFilas(Integer.parseInt(numeroFilas));
        configuracion.setNumeroColumnas(Integer.parseInt(numeroColumnas));
        configuracion.setPosicionesIniciales(posicionesIniciales);
        configuracion.setFotosTomadas(Integer.parseInt(fotosTomadas));

        filas = String.valueOf(configuracion.getNumeroFilas());
        columnas = String.valueOf(configuracion.getNumeroColumnas());

        cantidadCasillas = Integer.parseInt(filas) * Integer.parseInt(columnas);
        cantidadFotos = Integer.parseInt(fotosTomadas);

        listaPosiciones = configuracion.gameLog(Integer.parseInt(fotosTomadas));
        indicesFotos = configuracion.getIndicesFotos();

        return "redirect:game";
    }

    @GetMapping("/game")
    public String game(Model model){
        model.addAttribute("indicesFotos", indicesFotos);
        model.addAttribute("cantidadFotos", cantidadFotos);
        model.addAttribute("filas", filas);
        model.addAttribute("columnas", columnas);
        model.addAttribute("listaPosiciones",listaPosiciones);
        model.addAttribute("cantidadCasillas", cantidadCasillas);
        model.addAttribute("estadoEstable", configuracion.getEstadoEstable());
        model.addAttribute("iteracionesFaltantes", configuracion.getIteracionesFaltantes());
        return "game";
    }

}
