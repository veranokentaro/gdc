package co.edu.usbcali.demo.dao.retirosid;

import java.util.List;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.RetirosId;
import co.edu.usbcali.demo.modelo.TiposUsuarios;

public interface IRetirosIdLogica {
 
	public void grabar(RetirosId retirosId)throws Exception;
	public void modificar(RetirosId retirosId)throws Exception;
	public void borrar(RetirosId RetirosId)throws Exception;
	public RetirosId consultarRetirosIdPorId(long retiroId)throws Exception;
	public List<RetirosId> consultarTodos()throws Exception;
	

}
