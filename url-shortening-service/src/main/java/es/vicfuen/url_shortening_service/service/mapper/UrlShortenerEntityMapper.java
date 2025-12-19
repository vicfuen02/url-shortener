package es.vicfuen.url_shortening_service.service.mapper;

import es.vicfuen.url_shortening_service.repository.entity.UrlShortenerEntity;
import es.vicfuen.url_shortening_service.service.model.UrlShortener;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UrlShortenerEntityMapper {

 UrlShortenerEntity toEntity(UrlShortener urlShortener);

 UrlShortener toModel(UrlShortenerEntity urlShortenerEntity);

}
