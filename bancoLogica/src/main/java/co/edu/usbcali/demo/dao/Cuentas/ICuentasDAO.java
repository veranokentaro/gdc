 package co.edu.usbcali.demo.dao.Cuentas;

import java.util.List;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.Cuentas;

public interface ICuentasDAO {
	
	public void grabar(Cuentas cuentas);
	public void modificar(Cuentas cuentas);
	public void borrar(Cuentas Cuentas);
	public Cuentas consultarCuentaPorId(String numCuenta);
	public List<Cuentas> consultarTodos();
	

}
