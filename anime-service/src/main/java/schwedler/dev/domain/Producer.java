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
public class Producer {
    private Long id;
    private String nome;
    private LocalDateTime createdAt;
    public static List<Producer> producers = new ArrayList<>();

    static {
        var mappa = new Producer(1l, "Mappa", LocalDateTime.now());
        var kyotoAnimation = new Producer(2l, "kyotoAnimation",LocalDateTime.now());
        var madhouse = new Producer(3l, "MadHouse", LocalDateTime.now());
        producers.addAll(new ArrayList<>(Arrays.asList(mappa,kyotoAnimation,madhouse)));
    }
}
