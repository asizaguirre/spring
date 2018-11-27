package com.tokiomarine.avaliacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.avaliacao.domain.Endereco;
import com.tokiomarine.avaliacao.domain.Pessoa;
import com.tokiomarine.avaliacao.repositories.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {

	private PessoaRepository pessoaRepository;

	@Autowired
	public void setPessoaRepository(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Override
	public Iterable<Pessoa> listaPessoas() {
		// TODO Auto-generated method stub
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa getPessoaById(Integer id) {
		// TODO Auto-generated method stub
		return pessoaRepository.findById(id).orElse(null);
	}

	@Override
	public Pessoa savePessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return pessoaRepository.save(pessoa);
	}

	@Override
	public void deletePessoa(Integer id) {
		// TODO Auto-generated method stub
		pessoaRepository.deleteById(id);
	}


}
