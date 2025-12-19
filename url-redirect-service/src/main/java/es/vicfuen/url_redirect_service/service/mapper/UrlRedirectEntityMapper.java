package es.vicfuen.url_redirect_service.service.mapper;

import es.vicfuen.url_redirect_service.repository.entity.UrlShortenerEntity;
import es.vicfuen.url_redirect_service.service.model.UrlModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UrlRedirectEntityMapper {

 UrlShortenerEntity toEntity(UrlModel urlModel);

 UrlModel toModel(UrlShortenerEntity urlEntity);

}
