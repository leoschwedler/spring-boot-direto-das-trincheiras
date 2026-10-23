package schwedler.dev.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import schwedler.dev.domain.Anime;
import schwedler.dev.request.AnimePostRequest;
import schwedler.dev.response.AnimeGetResponse;
import schwedler.dev.response.AnimePostResponse;

@Mapper
public interface AnimeMapper {

    AnimeMapper INSTANCE = Mappers.getMapper( AnimeMapper.class );

    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(1, 1_000_000))")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Anime toDomain(AnimePostRequest request);

    AnimePostResponse toResponse(Anime anime);

    AnimeGetResponse toAnimeGetResponse(Anime anime);
}
