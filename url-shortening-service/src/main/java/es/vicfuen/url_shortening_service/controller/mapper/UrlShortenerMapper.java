package es.vicfuen.url_shortening_service.controller.mapper;

import es.vicfuen.url_shortening_service.controller.dto.UrlShortenerReqDto;
import es.vicfuen.url_shortening_service.controller.dto.UrlShortenerResDto;
import es.vicfuen.url_shortening_service.service.model.UrlShortener;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UrlShortenerMapper {

    @Mapping(target = "shortUrl", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    UrlShortener toModel(UrlShortenerReqDto reqDto);

    UrlShortenerResDto toResDto(UrlShortener model);

}
