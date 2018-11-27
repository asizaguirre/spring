package com.tokiomarine.avaliacao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tokiomarine.avaliacao.domain.Endereco;

@RepositoryRestResource
public interface EnderecoRepository extends CrudRepository<Endereco, Integer>{

}
