package schwedler.dev.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/v1/heroes")
@RestController
public class HeroesController {

    private static final List<String> HEROES = new ArrayList<>(Arrays.asList("Guts", "Kakashi", "Midoria", "Goku", "Goku"));

    @GetMapping("/findAll")
    public List<String> findAll(){
        return HEROES;
    }

    @GetMapping("/findByName")
    public List<String> findByName(@RequestParam(required = false ) String name){
        if(name != null){
            return  HEROES.stream().filter( hero -> hero.equalsIgnoreCase(name)).collect(Collectors.toList());
        }
        return HEROES;
    }

    @GetMapping("/findByListName")
    public List<String> findByListName(@RequestParam List<String> names){
        if(names != null){
            return  HEROES.stream().filter( heroes -> names.contains(heroes)).collect(Collectors.toList());
        }
        return HEROES;
    }

    @GetMapping("/findByName/{name}")
    public String findByListNameParam(@PathVariable String name){

        return  HEROES.stream().filter( hero -> hero.equalsIgnoreCase(name)).findFirst().orElse("Ta vazio fi");

    }


}
