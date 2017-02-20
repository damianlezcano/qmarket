package ar.com.q3s.market.client.scheduler;

public interface Job {

	boolean isTime();
	void start();
	
}
