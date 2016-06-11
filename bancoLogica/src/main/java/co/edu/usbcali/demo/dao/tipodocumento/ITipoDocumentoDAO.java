package co.edu.usbcali.demo.dao.tipodocumento;

import java.util.List;

import co.edu.usbcali.demo.modelo.TiposDocumentos;

public interface ITipoDocumentoDAO {
	
	public void grabar(TiposDocumentos tiposDocumentos);
	public void modificar(TiposDocumentos tiposDocumentos);
	public void borrar(TiposDocumentos tiposDocumentos);
	public TiposDocumentos consultarTipoDocumentoId(long tdocCodigo);
	public List<TiposDocumentos> consultarTodos();

}
