package com.tokiomarine.avaliacao.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ENDERECO")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated product ID")
	private Integer enderecoId;
	@ApiModelProperty(notes = "Endereco da pessoa")
	private String endereco;

//	@OneToOne(cascade = CascadeType.ALL, optional = true)
//	@JoinTable(name = "PESSOA", joinColumns = { @JoinColumn(name = "pessoaId") }, inverseJoinColumns = {
//			@JoinColumn(name = "enderecoId") })
//	private Pessoa pessoa;

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

//	public Pessoa getPessoa() {
//		return pessoa;
//	}
//
//	public void setPessoa(Pessoa pessoa) {
//		this.pessoa = pessoa;
//	}

}
