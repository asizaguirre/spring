package com.tokiomarine.avaliacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.avaliacao.domain.Pessoa;
import com.tokiomarine.avaliacao.jms.JmsProducer;
import com.tokiomarine.avaliacao.repositories.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {

	private JmsProducer jmsProduce;
	private PessoaRepository pessoaRepository;

	@Autowired
	public void setJmsProduce(JmsProducer jmsProduce) {
		this.jmsProduce = jmsProduce;
	}

	@Autowired
	public void setPessoaRepository(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Override
	public Iterable<Pessoa> listaPessoas() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa getPessoaById(Integer id) {
		return pessoaRepository.findById(id).orElse(null);
	}

	@Override
	public Object savePessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public void deletePessoa(Integer id) {
		pessoaRepository.deleteById(id);
	}

	@Override
	public void sendToQueue(Pessoa str) {
		jmsProduce.sendToQueue(str);
	}

	@Override
	public void sendToTopic(Pessoa str) {
		jmsProduce.sendToTopic(str);
	}

}
