package com.tokiomarine.avaliacao.jms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.tokiomarine.avaliacao.domain.Pessoa;
import com.tokiomarine.avaliacao.repositories.PessoaRepository;

@Component
public class JmsConsumer {
	
	private PessoaRepository pessoaRepository;

	@Autowired
	public void setPessoaRepository(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@JmsListener(destination = "queue.pessoa")
	public void receive(Pessoa pessoa) {
		System.out.println("Recieved Message: " + pessoa);
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(pessoa);
		for (Pessoa p : pessoas) {
			pessoaRepository.save(p);
		}
	}
}