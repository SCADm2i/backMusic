package SCADm2i.backMusic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//TODO : to be implemented
@Configuration
public class Conf {

	@Bean
	public String helloworld() {
		String str = "Hello world";
		System.out.println(str);
		return str;
	}
}
