package app.trybe.specialityapp.controller.config;

import app.trybe.specialityapp.SpecialityAppApplication;
import javax.ws.rs.ApplicationPath;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**Classe JerseryConfig. */
@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

  private Logger logger = LoggerFactory.getLogger(JerseyConfig.class);

  /**Construtor da classe JerseyConfig. */
  public JerseyConfig() {
    packages(SpecialityAppApplication.class.getPackageName());
    register(new AbstractBinder() {

      @Override
      protected void configure() {
        logger.info("Configurando binder");
      }
    });
  }
}