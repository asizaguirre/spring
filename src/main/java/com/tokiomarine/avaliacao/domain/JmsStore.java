package com.tokiomarine.avaliacao.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class JmsStore {
	private List<Pessoa> pessoas = new ArrayList<>();

	public void add(Pessoa pessoa) {
		pessoas.add(pessoa);
	}

	public void clear() {
		pessoas.clear();
	}

	public List<Pessoa> getAll() {
		return pessoas;
	}
}
