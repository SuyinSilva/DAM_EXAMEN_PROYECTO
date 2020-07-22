package com.example.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.dao.MarcaModel;
import com.example.rest.dao.PedidoModel;
import com.example.rest.entidades.Marca;
import com.example.rest.entidades.Pedido;

@Path("/servicios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);

	private MarcaModel daoMarca = new MarcaModel();
	private PedidoModel daoPedido=new PedidoModel();

	// Crud de Marca
	@GET
	@Path("/marca")
	public Response listarMarcaTodos() {
		log.info("listars marca rest ");
		return Response.ok(daoMarca.listarMarcaTodos()).build();
	}

	@POST
	@Path("/marca")
	public Response registraMarca(Marca obj) {
		log.info("Registra marca " + obj.getIdMarca());
		if (daoMarca.insertaMarca(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/marca")
	public Response atualizaMarca(Marca obj) {
		log.info("Actualiza marca " + obj.getIdMarca());
		if (daoMarca.actualizaMarca(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/marca/{idMarca}")
	public Response eliminaMarca(@PathParam("idMarca") int id) {
		log.info("Elimina usuario " + id);
		if (daoMarca.eliminaMarca(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	@GET
	@Path("/pedido")
	public Response listarPedidoTodos() {
		log.info("listars Pedido rest ");
		return Response.ok(daoPedido.listaPedido()).build();
	}
	@GET
	@Path("/pedido/{idCliente}")
	public Response listaPedidoPorCliente(int idCliente) {
		log.info("listars Pedido Por Cliente rest ");
		return Response.ok(daoPedido.listaPedidoporCliente(idCliente)).build();
	}
	@POST
	@Path("/pedido")
	public Response registraPedido(Pedido obj) {
		log.info("Registra Pedido " + obj.getIdPedido());
		if (daoPedido.inserta(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}


}