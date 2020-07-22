package com.example.rest.entidades;

import java.sql.Date;
import java.util.ArrayList;

public class Pedido {

	private int idPedido;
	private Date fechaRegistro;
	private Date fechaEntrega;
	private String lugarEntrega;
	private String estado;
	private Cliente cliente;
	private Ubigeo ubigeo;
	private Usuario usuario;
	private ArrayList<PedidoDetalle> detalles;
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getLugarEntrega() {
		return lugarEntrega;
	}
	public void setLugarEntrega(String lugarEntrega) {
		this.lugarEntrega = lugarEntrega;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Ubigeo getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ArrayList<PedidoDetalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<PedidoDetalle> detalles) {
		this.detalles = detalles;
	}
	
	
}
