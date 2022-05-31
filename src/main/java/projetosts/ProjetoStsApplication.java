package projetosts;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import projetosts.domain.Categoria;
import projetosts.domain.Cidade;
import projetosts.domain.Estado;
import projetosts.domain.Produto;
import projetosts.repositories.CategoriaRepository;
import projetosts.repositories.CidadeRepository;
import projetosts.repositories.EstadoRepository;
import projetosts.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoStsApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

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
		Produto p4 = new Produto(null, "Camisa Polo", 69.90);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p3, p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		
		
	}
	
}
