package es.vicfuen.url_shortening_service.service.shortener;

import es.vicfuen.ccassandraCommon.model.UrlModel;

public interface UrlShortenerService {

    UrlModel urlShortener(UrlModel urlShortener);

}
