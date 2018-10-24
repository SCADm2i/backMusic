package SCADm2i.backMusic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;


//TODO: to be implemented
@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private MyDao mydao;
	
	public void MyService() {
		System.out.println("ref autowired : " + mydao);
	}
		
	@PostConstruct
	public void init() {
		System.out.println("ref autowired : " + mydao);
	}

}
