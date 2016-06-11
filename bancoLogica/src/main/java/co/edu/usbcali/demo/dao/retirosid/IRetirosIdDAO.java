package co.edu.usbcali.demo.dao.retirosid;

import java.util.List;

 
import co.edu.usbcali.demo.modelo.RetirosId;

public interface IRetirosIdDAO {
	
	public void grabar(RetirosId retirosId);
	public void modificar(RetirosId retirosId);
	public void borrar(RetirosId RetirosId);
	public RetirosId consultarRetirosIdPorId(long retiroId);
	public List<RetirosId> consultarTodos();
	

}
