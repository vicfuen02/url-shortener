package es.vicfuen.url_redirect_service.service.redirect;


import es.vicfuen.ccassandraCommon.model.UrlModel;

import java.util.List;
import java.util.Optional;

public interface UrlRedirectService {

 Optional<UrlModel> getLongUrl(String shortUrl);

 List<UrlModel> getUrls();

}
