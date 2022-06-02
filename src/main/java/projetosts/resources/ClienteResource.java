package projetosts.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projetosts.domain.Cliente;
import projetosts.services.CategoriaService;
import projetosts.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
//		Categoria cat1 = new Categoria(1, "Tecnologia da Informação");
//		Categoria cat2 = new Categoria(2, "Cinema");
//		
//		List<Categoria> list = new ArrayList<>();
//		list.add(cat1);
//		list.add(cat2);
//		
//		return list;
	}

}
