package es.vicfuen.url_redirect_service.service.redirect;

import es.vicfuen.url_redirect_service.repository.UrlRedirectRepository;
import es.vicfuen.url_redirect_service.repository.entity.UrlShortenerEntity;
import es.vicfuen.url_redirect_service.service.mapper.UrlRedirectEntityMapper;
import es.vicfuen.url_redirect_service.service.model.UrlModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class UrlRedirectServiceImpl implements UrlRedirectService {

 private final UrlRedirectRepository urlRedirectRepository;
 private final UrlRedirectEntityMapper urlRedirectEntityMapper;

 @Override
 public Optional<UrlModel> getLongUrl(String shortUrl) {
  log.info("Getting long url for short url: {}", shortUrl);
  Optional<UrlShortenerEntity> url = urlRedirectRepository.findById(shortUrl);
  if (url.isPresent()) {
    log.info("Long url: {}", url.get());
  } else {
    log.info("Url not found");
  }
  return urlRedirectRepository.findById(shortUrl)
    .map(urlRedirectEntityMapper::toModel);
 }

 @Override
 public List<UrlModel> getUrls() {
  log.info("Getting all urls");
  return urlRedirectRepository.findAll().stream()
    .map(urlRedirectEntityMapper::toModel)
    .collect(Collectors.toList());
 }
}
