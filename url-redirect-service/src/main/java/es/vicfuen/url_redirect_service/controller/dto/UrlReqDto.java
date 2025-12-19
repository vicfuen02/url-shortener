package es.vicfuen.url_redirect_service.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UrlReqDto {

  private String shortUrl;
  private String url;

}
