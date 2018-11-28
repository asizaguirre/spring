package com.tokiomarine.avaliacao.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endereco(String endereco) {
		super();
		this.endereco = endereco;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (enderecoId == null) {
			if (other.enderecoId != null)
				return false;
		} else if (!enderecoId.equals(other.enderecoId))
			return false;
		return true;
	}

	public String getEndereco() {
		return endereco;
	}

	public Integer getEnderecoId() {
		return enderecoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((enderecoId == null) ? 0 : enderecoId.hashCode());
		return result;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}

	@Override
	public String toString() {
		return "Endereco [enderecoId=" + enderecoId + ", endereco=" + endereco + "]";
	}

}
