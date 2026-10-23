package schwedler.dev.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Anime {
    private Integer id;
    private String nome;
    private LocalDateTime createdAt;
    public static final List<Anime> animes = new ArrayList<>();

    static {
        var dragonBall = new Anime(1, "Dragon Ball", LocalDateTime.now());
        var naruto = new Anime(2, "Naruto",LocalDateTime.now());
        var cavaleiroDoZodiaco = new Anime(3, "Cavaleiro do Zodiaco", LocalDateTime.now());
        animes.addAll(new ArrayList<>(Arrays.asList(dragonBall,naruto,cavaleiroDoZodiaco)));
    }

}
