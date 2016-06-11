package co.edu.usbcali.demo.dao.cliente;

import java.util.List;

import co.edu.usbcali.demo.modelo.Clientes;

public interface IClienteLogica {
	
	public void grabar(Clientes clientes)throws Exception;
	public void modificar(Clientes clientes)throws Exception;
	public void borrar(Clientes clientes)throws Exception;
	public Clientes consultarClinetePorId(long cliId)throws Exception;
	public List<Clientes> consultarTodos()throws Exception;

}
