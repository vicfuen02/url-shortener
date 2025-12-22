package es.vicfuen.url_shortening_service.controller.mapper;


import es.vicfuen.ccassandraCommon.dto.UrlShortenerResDto;
import es.vicfuen.ccassandraCommon.model.UrlModel;
import es.vicfuen.url_shortening_service.controller.dto.UrlShortenerReqDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UrlShortenerMapper {



    @Mapping(target = "shortUrl", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    UrlModel toModel(UrlShortenerReqDto reqDto);


    UrlShortenerResDto toResDto(UrlModel model);

}
