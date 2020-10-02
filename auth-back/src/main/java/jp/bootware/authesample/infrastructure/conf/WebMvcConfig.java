package jp.bootware.authesample.infrastructure.conf;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: TCMALTUNKAN - MEHMET ANIL ALTUNKAN
 * @Date: 30.12.2019:09:26, Pzt
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  private static final long MAXAGESECS = 3600;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods(GET.name(), POST.name(), PUT.name(), PATCH.name(), DELETE.name(),
            OPTIONS.name())
        .allowedHeaders("*")
        .allowCredentials(true)
        .maxAge(MAXAGESECS);
  }
}
