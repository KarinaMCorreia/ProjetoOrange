package br.com.orange.ProjetoOrangeTalents.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.orange.ProjetoOrangeTalents.controller.form.Enderecoform;
import br.com.orange.ProjetoOrangeTalents.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

	


	List<Endereco> findByUsuarioId(long id);

}
