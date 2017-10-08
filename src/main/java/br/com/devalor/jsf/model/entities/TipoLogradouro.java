package br.com.devalor.jsf.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "TipoLogradouro")
public class TipoLogradouro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "IdTipoLogradouro")
	private Integer idTipoLogradouro;
	@Column(name = "DescricaoTipoLogradouro", nullable = false, length = 40)
	private String descricaoTipoLogradouro;

	@OneToMany(mappedBy = "TipoLogradouro", fetch = FetchType.LAZY)
	@ForeignKey(name = "Endereco_TipoLogradouro")
	private List<Endereco> enderecos;

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Integer getIdTipoLogradouro() {
		return idTipoLogradouro;
	}

	public void setIdTipoLogradouro(Integer idTipoLogradouro) {
		this.idTipoLogradouro = idTipoLogradouro;
	}

	public String getDescricaoTipoLogradouro() {
		return descricaoTipoLogradouro;
	}

	public void setDescricaoTipoLogradouro(String descricaoTipoLogradouro) {
		this.descricaoTipoLogradouro = descricaoTipoLogradouro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoLogradouro == null) ? 0 : idTipoLogradouro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoLogradouro other = (TipoLogradouro) obj;
		if (idTipoLogradouro == null) {
			if (other.idTipoLogradouro != null)
				return false;
		} else if (!idTipoLogradouro.equals(other.idTipoLogradouro))
			return false;
		return true;
	}

}
