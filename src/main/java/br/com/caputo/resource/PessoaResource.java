package br.com.caputo.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.caputo.event.RecursoCriadoEvent;
import br.com.caputo.model.Pessoa;
import br.com.caputo.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		
		ResponseEntity<?> retorno;
		List<Pessoa> pessoas = pessoaService.listar();
		
		if(null == pessoas || pessoas.isEmpty()) {
			retorno = ResponseEntity.noContent().build();
		} else {
			retorno = ResponseEntity.ok(pessoas);
		}
		
		return retorno;
		
	}
	
	@PostMapping
	public ResponseEntity<?> inserir(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = pessoaService.inserir(pessoa);
		
		eventPublisher.publishEvent(new RecursoCriadoEvent(this, response, pessoa.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
	
	@GetMapping("{codigo}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long codigo) {
		Pessoa pessoa = pessoaService.buscarPorId(codigo);
		return ResponseEntity.ok(pessoa);
	}
	
	@DeleteMapping("{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo){
		pessoaService.remover(codigo);
	}
	
	@PutMapping("{codigo}")
	public ResponseEntity<?> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.atualizar(codigo, pessoa);
		return ResponseEntity.ok(pessoaSalva);
	}
	
	@PutMapping("{codigo}/ativo")
	public ResponseEntity<?> atualizarPropriedadeAtivo(@PathVariable Long codigo, @Valid @RequestBody Boolean ativo) {
		Pessoa pessoaSalva = pessoaService.atualizarPropriedadeAtivo(codigo, ativo);
		return ResponseEntity.ok(pessoaSalva);
	}
	
}
