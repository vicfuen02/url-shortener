package es.vicfuen.url_redirect_service.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import es.vicfuen.url_redirect_service.repository.entity.UrlShortenerEntity;

@Repository
public interface UrlRedirectRepository extends CassandraRepository<UrlShortenerEntity, String> {

}
