package br.com.orange.ProjetoOrangeTalents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.ProjetoOrangeTalents.model.Usuario;
import br.com.orange.ProjetoOrangeTalents.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuario")
@Api(value="API REST USUARIO")
@CrossOrigin(origins="*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/cadastrar")
	@ApiOperation(value="Cadastra usuario")
	public void cadastrar(@RequestBody Usuario usuario) {

		usuarioRepository.save(usuario);

	}

}
