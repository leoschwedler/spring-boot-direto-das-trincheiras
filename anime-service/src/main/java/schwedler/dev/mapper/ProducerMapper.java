package schwedler.dev.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import schwedler.dev.domain.Producer;
import schwedler.dev.request.ProducerPostRequest;
import schwedler.dev.response.ProducerGetResponse;

@Mapper()
public interface ProducerMapper {

    ProducerMapper INSTANCE = Mappers.getMapper( ProducerMapper.class );

    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(1, 1_000_000))")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Producer toDomain(ProducerPostRequest request);

    ProducerGetResponse toResponse(Producer domain);
}
