package es.vicfuen.ccassandraCommon.mapper;

import es.vicfuen.ccassandraCommon.entity.UrlShortenerEntity;
import es.vicfuen.ccassandraCommon.model.UrlModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UrlModelEntityMapper {

 UrlShortenerEntity toEntity(UrlModel urlModel);

 UrlModel toModel(UrlShortenerEntity urlEntity);

}
