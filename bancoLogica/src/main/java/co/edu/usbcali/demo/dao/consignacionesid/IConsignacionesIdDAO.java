package co.edu.usbcali.demo.dao.consignacionesid;

import java.util.List;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.ConsignacionesId;

public interface IConsignacionesIdDAO {
	
	public void grabar(ConsignacionesId consignacionesId);
	public void modificar(ConsignacionesId consignacionesId);
	public void borrar(ConsignacionesId ConsignacionesId);
	public ConsignacionesId consultarConsignacionIdPorId(long consigId);
	public List<ConsignacionesId> consultarTodos();
	

}
