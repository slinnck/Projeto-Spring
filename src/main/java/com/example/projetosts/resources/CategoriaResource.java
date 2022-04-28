package com.example.projetosts.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetosts.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria obj = new Categoria(1, "Tecnologia da Informação");
		Categoria obj2 = new Categoria(2, "Cinema");
		
		List<Categoria> list = new ArrayList<>();
		list.add(obj);
		list.add(obj2);
		
		return list;
	}

}
