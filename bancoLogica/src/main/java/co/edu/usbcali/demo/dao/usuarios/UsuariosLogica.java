package co.edu.usbcali.demo.dao.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 
import co.edu.usbcali.demo.dao.tipodocumento.ITipoDocumentoDAO;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;
import co.edu.usbcali.demo.modelo.Usuarios;

@Service
@Scope("singleton")
public class UsuariosLogica implements IUsuariosLogica {
	
	 
	@Autowired
	private IUsuariosDAO usuariosDAO;
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(Usuarios usuarios) throws Exception {
		if(usuarios==null){
			throw new Exception("El tipo de usuario es null");
		}
		if(usuarios.getUsuNombre()==null || usuarios.getUsuNombre().trim().equals("")==true){
			throw new Exception("El nombre es obligatorio");
		}
		if(usuarios.getConsignacioneses()==null){
			throw new Exception("La consiganaci�n es obligatoria");
		}
		if(usuarios.getRetiroses()==null){
			throw new Exception("Los retiros son obligatorios");
		}
		if(usuarios.getTiposUsuarios()==null){
			throw new Exception("Los tipo de usuarios son obligatorios");
		}
		if(usuarios.getUsuCedula()==0){
			throw new Exception("La c�dula es obligatoria");
		}
		if(usuarios.getUsuClave()==null || usuarios.getUsuClave().trim().equals("")==true){
			throw new Exception("La clave es obligatoria");
		}
		
		if(usuarios.getUsuLogin()==null || usuarios.getUsuLogin().trim().equals("")==true){
			throw new Exception("La login es obligatorio");
		}
		
 
		
		usuariosDAO.grabar(usuarios);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(Usuarios usuarios) throws Exception {
		if(usuarios==null){
			throw new Exception("El tipo de usuario es null");
		}
		if(usuarios.getUsuNombre()==null || usuarios.getUsuNombre().trim().equals("")==true){
			throw new Exception("El nombre es obligatorio");
		}
		if(usuarios.getConsignacioneses()==null){
			throw new Exception("La consiganaci�n es obligatoria");
		}
		if(usuarios.getRetiroses()==null){
			throw new Exception("Los retiros son obligatorios");
		}
		if(usuarios.getTiposUsuarios()==null){
			throw new Exception("Los tipo de usuarios son obligatorios");
		}
		if(usuarios.getUsuCedula()==0){
			throw new Exception("La c�dula es obligatoria");
		}
		if(usuarios.getUsuClave()==null || usuarios.getUsuClave().trim().equals("")==true){
			throw new Exception("La clave es obligatoria");
		}
		
		if(usuarios.getUsuLogin()==null || usuarios.getUsuLogin().trim().equals("")==true){
			throw new Exception("La login es obligatorio");
		}
		
		usuariosDAO.modificar(usuarios);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(Usuarios usuarios) throws Exception {
		if(usuarios==null){
			throw new Exception("El tipo de usuario es null");
		}
		Usuarios entity=usuariosDAO.consultarUsuarioPorId(usuarios.getUsuCedula());
		if(entity==null){
			throw new Exception("El tipo de usuario que desea eliminar no existe");
		}
		
		usuariosDAO.borrar(entity);

	}

	@Override
	@Transactional(readOnly=true)
	public Usuarios consultarUsuarioPorId(long userId) throws Exception {
		return usuariosDAO.consultarUsuarioPorId(userId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuarios> consultarTodos() throws Exception {		
		return usuariosDAO.consultarTodos();
	}

}
