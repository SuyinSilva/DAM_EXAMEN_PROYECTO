package com.example.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.entidades.Cliente;
import com.example.rest.entidades.Pedido;
import com.example.rest.entidades.Ubigeo;
import com.example.rest.util.MySqlDBConexion;

public class PedidoModel {

	
	private static final Log log = LogFactory.getLog(PedidoModel.class);
	
	public List<Pedido> listarPedidoTodos() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Pedido> lista = new ArrayList<Pedido>();
		try {
			String sql = "select * from pedido";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Pedido bean = null;
			Ubigeo bean1= null;
			Cliente bean2=null;
			while(rs.next()){
				bean = new Pedido();
				bean.setIdPedido(rs.getInt(1));
				bean.setFechaRegistro(rs.getString(2));
				bean.setFechaEntrega(rs.getString(3));
				bean.setLugar(rs.getString(4));
				bean.setEstado(rs.getString(5));
				
				bean2= new Cliente();
				bean.setCliente(bean2);
				
				bean1=new Ubigeo();
				bean.setUbigeo(bean1);
				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}

	
	public int insertaPedido(Pedido obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into pedido values(null,?,?,?,?,?,?)";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getFechaRegistro());
			pstm.setString(2, obj.getFechaEntrega());
			pstm.setString(3, obj.getLugar());
			pstm.setString(4, obj.getEstado());
			pstm.setInt(5, obj.getCliente().getIdCliente());
			pstm.setInt(6, obj.getUbigeo().getIdUbigeo());
			log.info(pstm);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

}
