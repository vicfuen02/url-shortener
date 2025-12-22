package es.vicfuen.url_redirect_service.repository;

import es.vicfuen.ccassandraCommon.entity.UrlShortenerEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UrlRedirectRepository extends CassandraRepository<UrlShortenerEntity, String> {

}
