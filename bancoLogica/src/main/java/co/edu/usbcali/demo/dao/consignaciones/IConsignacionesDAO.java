 package co.edu.usbcali.demo.dao.consignaciones;

import java.util.List;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.Consignaciones;

public interface IConsignacionesDAO {
	
	public void grabar(Consignaciones consignaciones);
	public void modificar(Consignaciones consignaciones);
	public void borrar(Consignaciones Consignaciones);
	public Consignaciones consultarConsignacionPor(long consig, String cuenta);
	public List<Consignaciones> consultarTodos();
	

}
