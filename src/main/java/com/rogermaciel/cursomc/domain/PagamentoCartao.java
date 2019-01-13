package com.rogermaciel.cursomc.domain;

import javax.persistence.Entity;

import com.rogermaciel.cursomc.domain.enums.EstadoPagamento;


@Entity
public class PagamentoCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	public PagamentoCartao() {
	}

	public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido peedido, Integer numeroDeParcelas) {
		super(id, estado, peedido);
		this.numeroDeParcelas = numeroDeParcelas;	
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}