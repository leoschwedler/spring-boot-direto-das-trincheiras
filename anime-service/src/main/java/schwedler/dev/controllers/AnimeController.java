package schwedler.dev.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schwedler.dev.model.Anime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/v1")
@RestController
public class AnimeController {

    @GetMapping("/animes")
    public List<Anime> findAll(){
        List<Anime> animes = new ArrayList<>(Arrays.asList(new Anime("Jujutsu"), new Anime("Pokemon"), new Anime("Dragon Ball")));
        return animes;
    }
}
