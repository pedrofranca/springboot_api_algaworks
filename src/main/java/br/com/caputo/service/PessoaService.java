package br.com.caputo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.caputo.model.Pessoa;
import br.com.caputo.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepo;
	
	public List<Pessoa> listar() {
		return pessoaRepo.findAll();
	}
	
	public Pessoa inserir(Pessoa pessoa) {
		return pessoaRepo.save(pessoa);
	}
	
	public Pessoa buscarPorId(Long codigo) {
		return findPessoa(codigo);
	}
	
	public void remover(Long codigo) {
		pessoaRepo.deleteById(codigo);
	}

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = findPessoa(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return pessoaRepo.save(pessoaSalva);
	}

	public Pessoa atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = findPessoa(codigo);
		pessoaSalva.setAtivo(ativo);
		return pessoaRepo.save(pessoaSalva);
	}

	private Pessoa findPessoa(Long codigo) {
		Optional<Pessoa> pessoaOpt = pessoaRepo.findById(codigo);

		if (pessoaOpt.isPresent()) {
			Pessoa pessoaSalva = pessoaOpt.get();
			return pessoaRepo.save(pessoaSalva);
		} else {
			throw new EmptyResultDataAccessException(1);
		}
	}

}
