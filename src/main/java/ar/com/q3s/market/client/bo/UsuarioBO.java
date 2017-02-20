package ar.com.q3s.market.client.bo;

import java.util.List;

import ar.com.q3s.market.client.dao.DAO;
import ar.com.q3s.market.client.dao.DefaultDAO;
import ar.com.q3s.market.client.model.EntityDomain;
import ar.com.q3s.market.client.model.Usuario;

public class UsuarioBO implements BO {

	private DAO dao;
	
	public UsuarioBO(){
		dao = new DefaultDAO();
	}
	
	@Override
	public List<?> list(Class<?> clazz){
		return dao.list(clazz);
	}

	@Override
	public EntityDomain get(Class<?> clazz, Long id) {
		return dao.get(clazz,id);
	}

	@Override
	public boolean save(EntityDomain entity) {
		if(entity.getId() == null){
			return dao.persist(entity);
		}else{
			return dao.merge(entity);
		}
	}
	
	@Override
	public boolean remove(Class<?> clazz, Long id) {
		return dao.remove(clazz,id);
	}

	@SuppressWarnings("unchecked")
	public Usuario findByCode(Class<?> clazz, Long codigo){
		List<Usuario> usuarios = (List<Usuario>) dao.list(Usuario.class);
		for (Usuario usuario : usuarios) {
			if(codigo.equals(usuario.getCodigo())){
				return usuario;
			}
		}
		return null;
	}

}