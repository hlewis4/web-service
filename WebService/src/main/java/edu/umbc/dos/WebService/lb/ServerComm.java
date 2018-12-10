package edu.umbc.dos.WebService.lb;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.umbc.dos.WebService.config.WebConfig;
import edu.umbc.dos.WebService.endpoints.ServerInfo;

public class ServerComm {
  
	private Map<Integer, ServerInfo> operations = new HashMap<Integer, ServerInfo>();
    
    public ServerInfo putInfo(String x, int y, String[] z) {
    	ServerInfo e = new ServerInfo();
    	e.setIp(x);
    	e.setPort(y);
        e.setServiceName(z);
        return e;
        
    }
    
    public void Endpoint() {
	    String[] service_list1 = new String[2];
	    service_list1[0]= "AddService";
	    service_list1[1]= "subService";
	    service_list1[0]= "divService";
	    service_list1[0]= "mulService";
	    operations.put(1, putInfo("localhost:", 8081, service_list1));
	    
	   
    }
    @Autowired
	private WebConfig config;

	@RequestMapping("/dynamic-configuration")
	public Map<Integer, ServerInfo> dynamicConfiguration() {
		// Not the best practice to use a map to store differnt types!
		Map<String, Object> map = new HashMap<>();
		map.put("message", config.findService());
		map.put("number", config.getNumber());
		map.put("key", config.isValue());
		return map;
	}
	
	
	 
	
}

