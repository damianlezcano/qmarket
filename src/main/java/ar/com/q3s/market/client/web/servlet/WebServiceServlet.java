package ar.com.q3s.market.client.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import ar.com.q3s.market.client.model.EntityDomain;
import ar.com.q3s.market.client.util.ClassFinder;
import ar.com.q3s.market.client.ws.DefaultWebService;
import ar.com.q3s.market.client.ws.WebService;

public class WebServiceServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3324097373661605976L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		//get context URI
    		Map<String,String> contextMap = getContextPath(req.getPathInfo().split("/"));
    		String entityParam = contextMap.get("entity");
    		String actionParam = contextMap.get("action");
//    		String contextParam = req.getServletPath();
    		Long idParam = contextMap.get("id") == null ? null : Long.valueOf(contextMap.get("id"));
    		//--------------------------------------------------------------
    		Class<?> clazz = Class.forName(ClassFinder.PACK_FULL_PATH + ClassFinder.PACK_MODEL_TYPE + "." + entityParam);
    		//--------------------------------------------------------------
    		System.out.println("############### [GET] url: " + req.getPathInfo() + " - id:"+ idParam);
    		//--------------------------------------------------------------
        	WebService webService = null;
        	try {
        		webService = (WebService) Class.forName(ClassFinder.PACK_FULL_PATH + ClassFinder.PACK_WEBSERVICE_TYPE + "." + entityParam + "WebService").newInstance();
			} catch (Exception e) {
				webService = new DefaultWebService(clazz);
			}
        	//--------------------------------------------------------------
        	Method method = webService.getClass().getMethod(actionParam,Class.class,Long.class,EntityDomain.class);
        	Object response = method.invoke(webService,clazz,idParam,null);
	    	//--------------------------------------------------------------
//        	String json = "";
//        	for(Object entity : (List<?>) response){
//        		json+=entity+";";
//        	}
        	

        	
        	
        	
        	
    		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
    		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    		// output pretty printed
    		StringWriter sw = new StringWriter();
    		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    		jaxbMarshaller.marshal(response, sw);
    		String xmlString = sw.toString();
        	
        	
        	
        	
        	
        	
            
        	resp.setContentType("text/xml"); 
        	resp.getWriter().print(xmlString);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			resp.getWriter().print(errors);
		}    	
    }

	private Map<String, String> getContextPath(String[] urlPathInfo) {
		int cdor = 1;
		Map<String,String> map = new HashMap<String,String>();
		for (String item : new String[]{"entity","action","id"}) {
			try {
				map.put(item, urlPathInfo[cdor++]);
			} catch (Exception e) {
				map.put(item, null);
			}
		}
		return map;
	}
	
}