package schwedler.dev.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schwedler.dev.domain.Anime;
import schwedler.dev.mapper.AnimeMapper;
import schwedler.dev.request.AnimePostRequest;
import schwedler.dev.response.AnimeGetResponse;
import schwedler.dev.response.AnimePostResponse;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@RequestMapping("/v1/anime")
@RestController
public class AnimeController {

    private final AnimeMapper mapper = AnimeMapper.INSTANCE;

    @GetMapping("/findAll")
    public ResponseEntity<List<AnimeGetResponse>> findAll(){
        return ResponseEntity.ok(Anime.animes.stream().map(mapper::toAnimeGetResponse).collect(Collectors.toList()));
    }

    @GetMapping("/findByName")
    public ResponseEntity<AnimeGetResponse> findByName(@RequestParam String name) {
        Anime anime = Anime.animes.stream().filter(a -> a.getNome().toLowerCase().contains(name.toLowerCase())).findFirst().orElse(null);
        if(anime == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mapper.toAnimeGetResponse(anime));
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<AnimeGetResponse> findById(@PathVariable Integer id) {
        Anime anime = Anime.animes.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
        if (anime == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mapper.toAnimeGetResponse(anime));
    }

    @PostMapping("/save")
    public ResponseEntity<AnimePostResponse> save(@RequestBody AnimePostRequest request) {
        Anime domain = mapper.toDomain(request);
        Anime.animes.add(domain);
        AnimePostResponse response = mapper.toResponse(domain);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }
}
