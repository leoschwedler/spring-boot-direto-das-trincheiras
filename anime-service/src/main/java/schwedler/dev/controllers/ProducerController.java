package schwedler.dev.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schwedler.dev.domain.Producer;
import schwedler.dev.mapper.ProducerMapper;
import schwedler.dev.request.ProducerPostRequest;
import schwedler.dev.response.ProducerGetResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@RequestMapping("/v1/producer")
@RestController
public class ProducerController {

    private ProducerMapper mapper = ProducerMapper.INSTANCE;

    @GetMapping("/findAll")
    public ResponseEntity<List<Producer>> findAll() {
        return ResponseEntity.ok(Producer.producers);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<Producer> findById(@PathVariable Long id) {
        Producer producer = Producer.producers.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        if (producer == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(producer);
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Producer>> findByName(@RequestParam String name) {
        List<Producer> producers = Producer.producers.stream().filter(producer -> producer.getNome().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        return ResponseEntity.ok(producers);
    }


    @PostMapping("/save")
    public ResponseEntity<ProducerGetResponse> save(@RequestBody ProducerPostRequest producerPostRequest) {
        Producer domain = mapper.toDomain(producerPostRequest);
        Producer.producers.add(domain);
        ProducerGetResponse response = mapper.toResponse(domain);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
