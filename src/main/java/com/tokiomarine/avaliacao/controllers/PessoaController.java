package com.tokiomarine.avaliacao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tokiomarine.avaliacao.domain.Pessoa;
import com.tokiomarine.avaliacao.services.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RestController
@RequestMapping("/pessoa")
@Api(value = "pessoas")
public class PessoaController {

	private PessoaService pessoaService;

	@Autowired
	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	
	@ApiOperation(value = "Search a Pessoa with an ID", response = Pessoa.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public Pessoa showPessoa(@PathVariable Integer id, Model model) {
		Pessoa Pessoa = pessoaService.getPessoaById(id);
		return Pessoa;
	}

	@ApiOperation(value = "Adiciona pessoas na fila")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> addPessoa(@RequestBody Pessoa Pessoa) {
		pessoaService.sendToQueue(Pessoa);
		return new ResponseEntity<String>("Pessoa saved successfully", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Lista as Pessoas do banco", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Pessoa> list(Model model) {
		Iterable<Pessoa> pessoaList = pessoaService.listaPessoas();

		return pessoaList;
	}



//	@ApiOperation(value = "Enderecos da pessoa")
//	@RequestMapping(value = "/endereco/{id}", method = RequestMethod.PUT, produces = "application/json")
//	public ResponseEntity<String> saveEndereco(@PathVariable Integer pessoaId, @RequestBody Endereco endereco) {
//		Pessoa storedPessoa = pessoaService.getPessoaById(pessoaId);
//
//		if (storedPessoa != null) {
//			storedPessoa.setEndereco(endereco);
//			pessoaService.savePessoa(storedPessoa);
//			return new ResponseEntity<String>("Endereco updated successfully", HttpStatus.OK);
//		} else {
//			return new ResponseEntity<String>("Pessoa nao encontrada", HttpStatus.I_AM_A_TEAPOT);
//		}
//	}

}
