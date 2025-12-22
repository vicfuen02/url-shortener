package es.vicfuen.ccassandraCommon.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlModel {

 private String shortUrl;
 private String url;
 private LocalDateTime createdAt;

}
