package es.vicfuen.ccassandraCommon.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UrlModel {

 private String shortUrl;
 private String url;
 private LocalDateTime createdAt;

}
