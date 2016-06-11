 package co.edu.usbcali.demo.dao.Cuentas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 
import co.edu.usbcali.demo.dao.tipodocumento.ITipoDocumentoDAO;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;
import co.edu.usbcali.demo.modelo.Cuentas;

@Service
@Scope("singleton")
public class CuentasLogica implements ICuentasLogica {
	
	 
	@Autowired
	private ICuentasDAO cuentasDAO;
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(Cuentas cuentas) throws Exception {
		if(cuentas==null){
			throw new Exception("La cuenta es nula");
		}
		if(cuentas.getCueActiva()==null || cuentas.getCueActiva().trim().equals("")==true){
			throw new Exception("Cuenta activa es obligatorio");
		}
		
		if(cuentas.getCueClave()==null || cuentas.getCueClave().trim().equals("")==true){
			throw new Exception("Cuenta clave es obligatorio");
		}
		
		if(cuentas.getCueNumero()==null || cuentas.getCueNumero().trim().equals("")==true){
			throw new Exception("numero de la cuenta es obligatorio");
		}
		
		if(cuentas.getCueSaldo()==null){
			throw new Exception("El saldo de la cuenta es obligatorio");
		}
		
		cuentasDAO.grabar(cuentas);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(Cuentas cuentas) throws Exception {
		if(cuentas==null){
			throw new Exception("La cuenta es nula");
		}
		if(cuentas.getCueActiva()==null || cuentas.getCueActiva().trim().equals("")==true){
			throw new Exception("Cuenta activa es obligatorio");
		}
		
		if(cuentas.getCueClave()==null || cuentas.getCueClave().trim().equals("")==true){
			throw new Exception("Cuenta clave es obligatorio");
		}
		
		if(cuentas.getCueNumero()==null || cuentas.getCueNumero().trim().equals("")==true){
			throw new Exception("numero de la cuenta es obligatorio");
		}
		
		if(cuentas.getCueSaldo()==null){
			throw new Exception("El saldo de la cuenta es obligatorio");
		}
		
		cuentasDAO.modificar(cuentas);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(Cuentas cuentas) throws Exception {
		if(cuentas==null){
			throw new Exception("El tipo de usuario es null");
		}
		Cuentas entity=cuentasDAO.consultarCuentaPorId(cuentas.getCueNumero());
		if(entity==null){
			throw new Exception("El tipos de usuario que desea eliminar no existe");
		}
		
		cuentasDAO.borrar(entity);

	}

	@Override
	@Transactional(readOnly=true)
	public Cuentas consultarCuentaPorId(String numCuenta) throws Exception {
		return cuentasDAO.consultarCuentaPorId(numCuenta);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cuentas> consultarTodos() throws Exception {		
		return cuentasDAO.consultarTodos();
	}

}
