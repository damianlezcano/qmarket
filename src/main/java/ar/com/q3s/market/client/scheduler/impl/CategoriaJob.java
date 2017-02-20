package ar.com.q3s.market.client.scheduler.impl;

import java.util.List;

import ar.com.q3s.market.client.bo.BO;
import ar.com.q3s.market.client.bo.CategoriaBO;
import ar.com.q3s.market.client.model.Categoria;
import ar.com.q3s.market.client.scheduler.Job;

public class CategoriaJob implements Job {

	private BO bo;
	
	public CategoriaJob() {
		bo = new CategoriaBO();
	}
	
	@Override
	public boolean isTime() {
		return true;
	}

	@Override
	public void start(){
		List<Categoria> categorias = ((CategoriaBO)bo).findAllByIsNotificar(false);
//		System.out.println("Categorias " + categorias.size());
	}

}