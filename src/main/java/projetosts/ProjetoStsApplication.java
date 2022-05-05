package projetosts;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import projetosts.domain.Categoria;
import projetosts.domain.Produto;
import projetosts.repositories.CategoriaRepository;
import projetosts.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoStsApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoStsApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Geek");
		Categoria cat2 = new Categoria(null, "Roupas");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		Produto p1 = new Produto(null, "FunkoPop", 259.90);
		Produto p2 = new Produto(null, "Quadro Personalizado", 59.90);
		Produto p3 = new Produto(null, "Camisa Jujutsu Kaisen", 79.90);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
	}
	
}
