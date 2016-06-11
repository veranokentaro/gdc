package co.edu.usbcali.demo.dao.retiros;

import java.util.List;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.Retiros;
import co.edu.usbcali.demo.modelo.TiposUsuarios;

public interface IRetirosLogica {
 
	public void grabar(Retiros retiros)throws Exception;
	public void modificar(Retiros retiros)throws Exception;
	public void borrar(Retiros Retiros)throws Exception;
	public Retiros consultarRetirosPor(long codRetiro, String cuenta)throws Exception;
	public List<Retiros> consultarTodos()throws Exception;
	

}
