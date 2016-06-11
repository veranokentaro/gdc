package co.edu.usbcali.demo.dao.Cuentas;

import java.util.List;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.Cuentas;
import co.edu.usbcali.demo.modelo.TiposUsuarios;

public interface ICuentasLogica {
 
	 
	public void grabar(Cuentas cuentas)throws Exception;
	public void modificar(Cuentas cuentas)throws Exception;
	public void borrar(Cuentas Cuentas)throws Exception;
	public Cuentas consultarCuentaPorId(String numCuenta)throws Exception;
	public List<Cuentas> consultarTodos()throws Exception;
	

}
