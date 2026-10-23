package schwedler.dev.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnimePostResponse {
    private Integer id;
    private String nome;
    private LocalDateTime createdAt;
}
