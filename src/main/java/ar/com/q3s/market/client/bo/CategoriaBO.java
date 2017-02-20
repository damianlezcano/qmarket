package ar.com.q3s.market.client.bo;

import java.util.ArrayList;
import java.util.List;

import ar.com.q3s.market.client.dao.DAO;
import ar.com.q3s.market.client.dao.DefaultDAO;
import ar.com.q3s.market.client.model.Categoria;
import ar.com.q3s.market.client.model.EntityDomain;

public class CategoriaBO implements BO {

	private DAO dao;
	
	public CategoriaBO(){
		dao = new DefaultDAO();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> list(Class<?> clazz){
		return (List<Categoria>)dao.list(clazz);
	}

	@Override
	public Categoria get(Class<?> clazz, Long id) {
		return (Categoria)dao.get(clazz,id);
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
	public List<Categoria> findAllByIsNotificar(Boolean notificar){
		List<Categoria> resultado = new ArrayList<Categoria>();
		List<Categoria> categorias = (List<Categoria>) dao.list(Categoria.class);
		//-----------------------------------------------------------------------
		for (Categoria categoria : categorias) {
			if(notificar.equals(categoria.getNotificado())){
				resultado.add(categoria);
			}
		}
		return resultado;
	}

}