package co.edu.usbcali.demo.dao.tiposusuarios;

import java.util.List;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposUsuarios;

public interface ITiposUsuariosLogica {
 
	public void grabar(TiposUsuarios tiposUsuarios)throws Exception;
	public void modificar(TiposUsuarios tiposUsuarios)throws Exception;
	public void borrar(TiposUsuarios TiposUsuarios)throws Exception;
	public TiposUsuarios consultarTipoUsuarioPorId(long tipoUserId)throws Exception;
	public List<TiposUsuarios> consultarTodos()throws Exception;
	

}
