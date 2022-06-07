package projetosts;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import projetosts.domain.Categoria;
import projetosts.domain.Cidade;
import projetosts.domain.Cliente;
import projetosts.domain.Endereco;
import projetosts.domain.Estado;
import projetosts.domain.Pagamento;
import projetosts.domain.PagamentoComBoleto;
import projetosts.domain.PagamentoComCartao;
import projetosts.domain.Pedido;
import projetosts.domain.Produto;
import projetosts.domain.enums.EstadoPagamento;
import projetosts.domain.enums.TipoCliente;
import projetosts.repositories.CategoriaRepository;
import projetosts.repositories.CidadeRepository;
import projetosts.repositories.ClienteRepository;
import projetosts.repositories.EnderecoRepository;
import projetosts.repositories.EstadoRepository;
import projetosts.repositories.PagamentoRepository;
import projetosts.repositories.PedidoRepository;
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
	
	@Autowired 
	private ClienteRepository clienteRepository;
	
	@Autowired 
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	

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

		Cliente cli1 = new Cliente(null, "João das Neves", "vocenaosabedenada@gmail.com", "324.965.400-00", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("99999-9999", "98888-8888"));
		
		Endereco e1 = new Endereco(null, "Rua do Norte", "99", "Casa A", "Nordeste", "59042-240", cli1, c1);
		Endereco e2 = new Endereco(null, "Travessa Galileu Galilei", "89", "Apt03", "Universidade", "68903-753", cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("21/04/2022 15:44"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("22/05/2022 10:52"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("01/06/2022 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
	}
	
}
