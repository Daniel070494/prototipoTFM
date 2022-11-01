package com.aplicacionTFM.domain;

import java.math.BigDecimal;

public class RespuestaDTO {
	
	  private BigDecimal codigo;
	  private String descripcion;
	  private Object adenda;
	  
	  
	public BigDecimal getCodigo() {
		return codigo;
	}
	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Object getAdenda() {
		return adenda;
	}
	public void setAdenda(Object adenda) {
		this.adenda = adenda;
	}

}
