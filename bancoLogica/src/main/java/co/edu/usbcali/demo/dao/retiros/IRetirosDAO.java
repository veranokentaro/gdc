package co.edu.usbcali.demo.dao.retiros;

import java.util.List;

 
import co.edu.usbcali.demo.modelo.Retiros;

public interface IRetirosDAO {
	
	public void grabar(Retiros retiros);
	public void modificar(Retiros retiros);
	public void borrar(Retiros Retiros);
	public Retiros consultarRetirosPor(long codRetiro, String cuenta);
	public List<Retiros> consultarTodos();
	

}
