package ar.com.q3s.market.client.scheduler;

import java.util.ArrayList;
import java.util.List;

import ar.com.q3s.market.client.scheduler.impl.CategoriaJob;

public class FactoryJobs {

	@SuppressWarnings({ "rawtypes", "serial" })
	public static List<Class> list(){
		return new ArrayList<Class>() {{
		    add(CategoriaJob.class);
		}};
	}
	
}
