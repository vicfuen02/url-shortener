package es.vicfuen.url_shortening_service.repository;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import es.vicfuen.url_shortening_service.repository.entity.UrlShortenerEntity;

@Repository
public interface UrlShorteningRepository extends CassandraRepository<UrlShortenerEntity, String> {



}

