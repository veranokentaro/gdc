package co.edu.usbcali.demo.dao.usuarios;

import java.util.List;
 
import co.edu.usbcali.demo.modelo.Usuarios;

public interface IUsuariosLogica {
 
	public void grabar(Usuarios usuarios)throws Exception;
	public void modificar(Usuarios usuarios)throws Exception;
	public void borrar(Usuarios Usuarios)throws Exception;
	public Usuarios consultarUsuarioPorId(long UserId)throws Exception;
	public List<Usuarios> consultarTodos()throws Exception;
	

}
