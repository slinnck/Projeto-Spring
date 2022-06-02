package projetosts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetosts.domain.Cliente;
import projetosts.repositories.ClienteRepository;
import projetosts.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired 
	private ClienteRepository cliRepository;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente>  obj = cliRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID:" + id + ", Tipo: " + Cliente.class.getName()));
	}

}
