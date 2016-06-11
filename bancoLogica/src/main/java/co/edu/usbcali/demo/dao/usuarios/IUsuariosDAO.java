package co.edu.usbcali.demo.dao.usuarios;

import java.util.List;
 
import co.edu.usbcali.demo.modelo.Usuarios;

public interface IUsuariosDAO {
	
	public void grabar(Usuarios usuarios);
	public void modificar(Usuarios usuarios);
	public void borrar(Usuarios Usuarios);
	public Usuarios consultarUsuarioPorId(long userId);
	public List<Usuarios> consultarTodos();
	

}
