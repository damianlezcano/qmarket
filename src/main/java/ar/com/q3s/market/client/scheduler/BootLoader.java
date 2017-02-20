package ar.com.q3s.market.client.scheduler;

public class BootLoader extends Thread {
	
	private final static int TIME_MILLS = 10000;

	@SuppressWarnings("rawtypes")
	@Override
	public void run() {
		try {
			do {
				for(Class clazz : FactoryJobs.list()){
					Job instance = (Job) clazz.newInstance();
					//---------------------------------------
					if(instance.isTime()){
						instance.start();						
					}
				}
				Thread.sleep(TIME_MILLS);
			} while (true);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}