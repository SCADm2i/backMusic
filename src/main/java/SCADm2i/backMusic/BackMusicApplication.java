package SCADm2i.backMusic;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



//Main
@SpringBootApplication
public class BackMusicApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(BackMusicApplication.class, args);
		
	}

	// Directs mapping (MusicController and PlaylistController) to localhost:4200
	@Bean
	 public WebMvcConfigurer corsConfigurer() {
	       return new WebMvcConfigurerAdapter() {
	           @Override
	           public void addCorsMappings(CorsRegistry registry) {
	               registry.addMapping("/").allowedOrigins("http://localhost:4200");
	           }
	       };
	   }
	
}
