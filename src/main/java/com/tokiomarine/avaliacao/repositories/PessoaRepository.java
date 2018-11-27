package com.tokiomarine.avaliacao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tokiomarine.avaliacao.domain.Endereco;
import com.tokiomarine.avaliacao.domain.Pessoa;

@RepositoryRestResource
public interface PessoaRepository extends CrudRepository<Pessoa, Integer>{

	void save(Endereco pessoa);

}
