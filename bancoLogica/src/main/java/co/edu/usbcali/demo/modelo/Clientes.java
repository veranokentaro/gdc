package co.edu.usbcali.demo.modelo;
// Generated 22/04/2016 07:50:35 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * Clientes generated by hbm2java
 */
public class Clientes implements java.io.Serializable {

	@NotNull
	private long cliId;
	@NotNull
	private TiposDocumentos tiposDocumentos;
	@NotNull
	//@Length(min=3,max=50)
	private String cliNombre;
	@NotNull
	private String cliDireccion;
	@NotNull
	private String cliTelefono;
	
	@NotNull
	@Email
	private String cliMail;
	
	private Set<Cuentas> cuentases = new HashSet<Cuentas>(0);

	public Clientes() {
	}

	public Clientes(long cliId, TiposDocumentos tiposDocumentos, String cliNombre, String cliDireccion,
			String cliTelefono) {
		this.cliId = cliId;
		this.tiposDocumentos = tiposDocumentos;
		this.cliNombre = cliNombre;
		this.cliDireccion = cliDireccion;
		this.cliTelefono = cliTelefono;
	}

	public Clientes(long cliId, TiposDocumentos tiposDocumentos, String cliNombre, String cliDireccion,
			String cliTelefono, String cliMail, Set<Cuentas> cuentases) {
		this.cliId = cliId;
		this.tiposDocumentos = tiposDocumentos;
		this.cliNombre = cliNombre;
		this.cliDireccion = cliDireccion;
		this.cliTelefono = cliTelefono;
		this.cliMail = cliMail;
		this.cuentases = cuentases;
	}

	public long getCliId() {
		return this.cliId;
	}

	public void setCliId(long cliId) {
		this.cliId = cliId;
	}

	public TiposDocumentos getTiposDocumentos() {
		return this.tiposDocumentos;
	}

	public void setTiposDocumentos(TiposDocumentos tiposDocumentos) {
		this.tiposDocumentos = tiposDocumentos;
	}

	public String getCliNombre() {
		return this.cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}

	public String getCliDireccion() {
		return this.cliDireccion;
	}

	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion;
	}

	public String getCliTelefono() {
		return this.cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public String getCliMail() {
		return this.cliMail;
	}

	public void setCliMail(String cliMail) {
		this.cliMail = cliMail;
	}

	public Set<Cuentas> getCuentases() {
		return this.cuentases;
	}

	public void setCuentases(Set<Cuentas> cuentases) {
		this.cuentases = cuentases;
	}

}
