package es.vicfuen.url_redirect_service.controller.mapper;

import es.vicfuen.url_redirect_service.controller.dto.UrlReqDto;
import es.vicfuen.url_redirect_service.service.model.UrlModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UrlRedirectMapper {

 UrlReqDto toDto(UrlModel urlModel);

 UrlModel toModel(UrlReqDto urlReqDto);

 List<UrlReqDto> toDtoList(List<UrlModel> urlModels);

}
