package br.com.orange.ProjetoOrangeTalents.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.orange.ProjetoOrangeTalents.controller.Dto.EnderecoDto;
import br.com.orange.ProjetoOrangeTalents.controller.form.Enderecoform;
import br.com.orange.ProjetoOrangeTalents.model.Endereco;
import br.com.orange.ProjetoOrangeTalents.repository.EnderecoRepository;
import br.com.orange.ProjetoOrangeTalents.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/endereco")
@Api(value="API REST ENDERECO")
@CrossOrigin(origins="*")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/cadastrar")
	@ApiOperation(value="Cadastro endereco")
	public ResponseEntity<EnderecoDto> cadastrar(@RequestBody @Valid Enderecoform form,
			UriComponentsBuilder uriBuilder) {

		Endereco endereco = form.converter(usuarioRepository);
		enderecoRepository.save(endereco);

		URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDto(endereco));

	}

	@GetMapping("/buscar/{id}")
	@ApiOperation(value="Busca endereco por id")
	public ResponseEntity<List<Endereco>> buscar(@PathVariable("id") @Valid long id) {
		List<Endereco> enderecos = enderecoRepository.findByUsuarioId(id);

		if (enderecos.isEmpty()) {

			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(enderecos);

	}

}
