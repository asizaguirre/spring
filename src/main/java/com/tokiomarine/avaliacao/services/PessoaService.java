package com.tokiomarine.avaliacao.services;

import com.tokiomarine.avaliacao.domain.Pessoa;

public interface PessoaService {
	Iterable<Pessoa> listaPessoas();

	Pessoa getPessoaById(Integer id);

	Object savePessoa(Pessoa pessoa);

	void deletePessoa(Integer id);

	void sendToQueue(Pessoa str);

	void sendToTopic(Pessoa str);

}
