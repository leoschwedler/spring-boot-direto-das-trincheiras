package schwedler.dev.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProducerGetResponse {
    private Long id;
    private String nome;
    private LocalDateTime createdAt;
}
