package br.com.devalor.jsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.devalor.jsf.model.dao.HibernateDAO;
import br.com.devalor.jsf.model.dao.InterfaceDAO;
import br.com.devalor.jsf.model.entities.Endereco;
import br.com.devalor.jsf.model.entities.Pessoa;
import br.com.devalor.jsf.util.FacesContextUtil;

@ManagedBean
@RequestScoped
public class PessoaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();
	private Endereco endereco = new Endereco();
	private List<Pessoa> pessoas;
	private List<Endereco> enderecos;

	private InterfaceDAO<Pessoa> pessoaDAO() {
		InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<>(Pessoa.class, FacesContextUtil.getRequestSession());
		return pessoaDAO;
	}

	private InterfaceDAO<Endereco> enderecoDAO() {
		InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<>(Endereco.class, FacesContextUtil.getRequestSession());
		return enderecoDAO;
	}

	public String limpPessoa() {
		pessoa = new Pessoa();
		endereco = new Endereco();
		return editPessoa();
	}

	public String editPessoa() {
		return "/restrict/cadastrarpessoa.faces";
	}

	public String addPessoa() {
		if (pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0) {
			insertPessoa();
		} else {
			updatePessoa();
		}
		return null;
	}

	private void updatePessoa() {
		pessoaDAO().update(pessoa);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));

	}

	private void insertPessoa() {
		pessoaDAO().save(pessoa);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
	}

	public String deletePessoa() {
		pessoaDAO().remove(pessoa);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
		return "";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Pessoa> getPessoas() {
		pessoas = pessoaDAO().getEntities();
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Endereco> getEnderecos() {
		enderecos = enderecoDAO().getEntities();
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
