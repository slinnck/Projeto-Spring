package projetosts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetosts.domain.Categoria;
import projetosts.repositories.CategoriaRepository;
import projetosts.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired 
	private CategoriaRepository catRepository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria>  obj = catRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID:" + id + ", Tipo: " + Categoria.class.getName()));
	}

}
