package projetosts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import projetosts.domain.Categoria;

@SpringBootApplication
public class ProjetoStsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoStsApplication.class, args);
		
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		
//		Categoria cat1 = new Categoria(null, "Gamer");
//		Categoria cat2 = new Categoria(null, "Educação");
//	}
	
}
