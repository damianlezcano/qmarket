package ar.com.q3s.market.client;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import ar.com.q3s.market.client.jna.GlobalKeyListener;
import ar.com.q3s.market.client.scheduler.BootLoader;

public class Main {
	
	private static String WEBAPP_PATH = "/webapp";
	private final static String WEB_XML_PATH = "/WEB-INF/web.xml";
	
	private BootLoader bootLoader;
	
	public void init(){
		bootLoader = new BootLoader();
		bootLoader.start();
		//----------------------------
		new GlobalKeyListener().start();
	}
	
	public void start() throws Exception {


	    Server server = new Server(8080);
	    WebAppContext webAppContext = new WebAppContext();
	    webAppContext.setContextPath("/");

	    /* Important: Use getResource */
	    String webxmlLocation = Main.class.getResource(WEB_XML_PATH).toString();
	    webAppContext.setDescriptor(webxmlLocation);

	    /* Important: Use getResource */
	    String resLocation = webxmlLocation.replaceFirst(WEB_XML_PATH + "$","/").toString();
	    webAppContext.setResourceBase(resLocation);
	    webAppContext.setParentLoaderPriority(true);

	    server.setHandler(webAppContext);

	    server.start();
	    server.join();
		
		
//        Server server = new Server(8080);
//
//
////        ServletContextHandler context = new ServletContextHandler();
////        context.setBaseResource(Resource.newResource(webAppUri));
//        
//		WebAppContext context = new WebAppContext();
////		context.setResourceBase(WEBAPP_PATH);
//		context.setBaseResource(Resource.newResource(WEBAPP_PATH));
//		context.setDescriptor(WEBAPP_PATH + WEB_XML_PATH);
//		context.setConfigurations(new Configuration[] {
//			new AnnotationConfiguration(), new WebXmlConfiguration(),
//			new WebInfConfiguration(), new TagLibConfiguration(),
//			new PlusConfiguration(), new MetaInfConfiguration(),
//			new FragmentConfiguration(), new EnvConfiguration() 
//		});
////
//		context.setContextPath("/");
////		context.setParentLoaderPriority(true);
//		server.setHandler(context);
//		server.start();
////		server.dump(System.err);
//		server.join();		
	}
	
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.init();
		main.start();
	}
}
