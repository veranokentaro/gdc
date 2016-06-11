package co.edu.usbcali.demo.dao.tiposusuarios;

import java.util.List;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposUsuarios;

public interface ITiposUsuariosDAO {
	
	public void grabar(TiposUsuarios tiposUsuarios);
	public void modificar(TiposUsuarios tiposUsuarios);
	public void borrar(TiposUsuarios TiposUsuarios);
	public TiposUsuarios consultarUsuarioPorId(long tipoUserId);
	public List<TiposUsuarios> consultarTodos();
	

}
