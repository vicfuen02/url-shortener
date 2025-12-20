package es.vicfuen.ccassandraCommon.mapper;

import es.vicfuen.ccassandraCommon.dto.UrlShortenerResDto;
import es.vicfuen.ccassandraCommon.model.UrlModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UrlModelRestMapper {

 UrlShortenerResDto toDto(UrlModel urlModel);

 UrlModel toModel(UrlShortenerResDto urlReqDto);

 List<UrlShortenerResDto> toDtoList(List<UrlModel> urlModels);

}
