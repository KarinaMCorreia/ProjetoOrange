package br.com.orange.ProjetoOrangeTalents.repository;

import javax.validation.constraints.NotNull;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.orange.ProjetoOrangeTalents.model.Endereco;
import br.com.orange.ProjetoOrangeTalents.model.Usuario;

@Repository
public interface UsuarioRepository  extends CrudRepository<Usuario, Long>{

	Usuario findById(long usuarioid);

	Usuario findById(@NotNull(message = "Teste") Endereco usuarioid);
	
	

}
