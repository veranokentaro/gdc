package co.edu.usbcali.demo.dao.tiposusuarios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposUsuarios;

@Repository
@Scope("singleton")
public class TiposUsuariosHibernateDAO implements ITiposUsuariosDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void grabar(TiposUsuarios tiposUsuarios) {
		sessionFactory.getCurrentSession().save(tiposUsuarios);		
	}

	@Override
	public void modificar(TiposUsuarios tiposUsuarios) {
		sessionFactory.getCurrentSession().update(tiposUsuarios);		
	}

	@Override
	public void borrar(TiposUsuarios tiposUsuarios) {
		sessionFactory.getCurrentSession().delete(tiposUsuarios);
	}

	@Override
	public TiposUsuarios consultarUsuarioPorId(long tipoUserId) {
		return sessionFactory.getCurrentSession().get(TiposUsuarios.class, tipoUserId);
	}

	@Override
	public List<TiposUsuarios> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(TiposUsuarios.class).list();
	}

}
