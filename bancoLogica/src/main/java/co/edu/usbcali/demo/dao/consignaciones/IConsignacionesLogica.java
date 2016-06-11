 package co.edu.usbcali.demo.dao.consignaciones;

import java.util.List;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.Consignaciones;
import co.edu.usbcali.demo.modelo.TiposUsuarios;

public interface IConsignacionesLogica {
 
 

	public void grabar(Consignaciones consignaciones)throws Exception;
	public void modificar(Consignaciones consignaciones)throws Exception;
	public void borrar(Consignaciones Consignaciones)throws Exception;
	public Consignaciones consultarConsignacionPor(long consig, String cuenta)throws Exception;
	public List<Consignaciones> consultarTodos()throws Exception;
	
	
}
