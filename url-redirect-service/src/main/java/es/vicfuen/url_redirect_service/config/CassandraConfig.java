package es.vicfuen.url_redirect_service.config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.api.core.config.DefaultDriverOption;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.SessionBuilderConfigurer;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.time.Duration;
import java.util.List;

@Configuration
@EnableCassandraRepositories(basePackages = "es.vicfuen.url_redirect_service.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {

  @Value("${spring.cassandra.keyspace-name:urlShortenerDB}")
  private String keyspaceName;

  @Value("${spring.cassandra.contact-points:localhost}")
  private String contactPoints;

  @Value("${spring.cassandra.port:9042}")
  private int port;

  @Value("${spring.cassandra.local-datacenter:datacenter1}")
  private String localDatacenter;

  // @Value("${spring.cassandra.username}")
  // private String username;
  //
  // @Value("${spring.cassandra.password}")
  // private String password;

  @Override
  protected String getKeyspaceName() {
    return keyspaceName;
  }

  @Override
  protected String getContactPoints() {
    return contactPoints;
  }

  @Override
  protected int getPort() {
    return port;
  }

  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.CREATE_IF_NOT_EXISTS;
  }

  @Override
  protected String getLocalDataCenter() {
    return localDatacenter;
  }

  @Override
  public String[] getEntityBasePackages() {
    return new String[] { "es.vicfuen.url_redirect_service.repository.entity" };
  }

  @Bean
  @Override
  public CqlSessionFactoryBean cassandraSession() {
    CqlSessionFactoryBean cassandraSession = super.cassandraSession();// super session should be called only once
    // cassandraSession.setUsername(username);
    // cassandraSession.setPassword(password);
    cassandraSession.setContactPoints(contactPoints);
    cassandraSession.setPort(port);
    cassandraSession.setLocalDatacenter(localDatacenter);
    cassandraSession.setKeyspaceName(keyspaceName);
    return cassandraSession;
  }

  // @Bean
  // public CassandraTemplate cassandraTemplate(CqlSession cqlSession,
  // CassandraConverter converter) {
  // return new CassandraTemplate(cqlSession, converter);
  // }

  @Override
  protected SessionBuilderConfigurer getSessionBuilderConfigurer() {
    return new SessionBuilderConfigurer() {

      @Override
      public CqlSessionBuilder configure(CqlSessionBuilder cqlSessionBuilder) {
        return cqlSessionBuilder
            // .withAuthCredentials(username, password)
            .withConfigLoader(DriverConfigLoader.programmaticBuilder()
                // Resolves the timeout query 'SELECT * FROM system_schema.tables' timed out
                // after PT2S
                .withDuration(DefaultDriverOption.METADATA_SCHEMA_REQUEST_TIMEOUT, Duration.ofMillis(60000))
                .withDuration(DefaultDriverOption.CONNECTION_INIT_QUERY_TIMEOUT, Duration.ofMillis(60000))
                .withDuration(DefaultDriverOption.REQUEST_TIMEOUT, Duration.ofMillis(15000))
                .build());
      }
    };
  }

  @Override
  protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
    return List.of(CreateKeyspaceSpecification
        .createKeyspace(keyspaceName)
        .ifNotExists()
        .withSimpleReplication(1));
  }

  // @Bean
  // public DriverConfigLoader driverConfigLoader() {
  // return DriverConfigLoader.programmaticBuilder()
  // .withDuration(DefaultDriverOption.METADATA_SCHEMA_REQUEST_TIMEOUT,
  // Duration.ofMillis(60000))
  // .withDuration(DefaultDriverOption.CONNECTION_INIT_QUERY_TIMEOUT,
  // Duration.ofMillis(60000))
  // .withDuration(DefaultDriverOption.REQUEST_TIMEOUT, Duration.ofMillis(15000))
  // .build();
  // }

  // @Override
  // protected com.datastax.oss.driver.api.core.CqlSessionBuilder
  // getSessionBuilderConfigurer() {
  // return new com.datastax.oss.driver.api.core.CqlSessionBuilder() {
  // @Override
  // public com.datastax.oss.driver.api.core.CqlSessionBuilder
  // withAuthCredentials(String username, String password) {
  // return super.withAuthCredentials(username, password);
  // }
  // }.withAuthCredentials(username, password);
  // }
}
