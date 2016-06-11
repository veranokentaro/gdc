package co.edu.usbcali.demo.dao.tipodocumento;

import java.util.List;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;

public interface ITipoDocumentoLogica {
	
	public void grabar(TiposDocumentos tiposDocumentos)throws Exception;
	public void modificar(TiposDocumentos tiposDocumentos)throws Exception;
	public void borrar(TiposDocumentos tiposDocumentos)throws Exception;
	public TiposDocumentos consultarTipoDocumentoPorId(long tipoDocId)throws Exception;
	public List<TiposDocumentos> consultarTodos()throws Exception;

}
