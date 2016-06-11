package co.edu.usbcali.demo.dao.consignacionesid;

import java.util.List;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.ConsignacionesId;
import co.edu.usbcali.demo.modelo.TiposUsuarios;

public interface IConsignacionesIdLogica {
 
 

	public void grabar(ConsignacionesId consignacionesId)throws Exception;
	public void modificar(ConsignacionesId consignacionesId)throws Exception;
	public void borrar(ConsignacionesId ConsignacionesId)throws Exception;
	public ConsignacionesId consultarConsignacionIdPorId(long consigId)throws Exception;
	public List<ConsignacionesId> consultarTodos()throws Exception;
	
	
}
