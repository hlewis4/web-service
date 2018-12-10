package edu.umbc.dos.WebService.lb;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Clientcomm {
	
	@WebMethod
	public int findService(@WebParam(name="serviceName") String serviceName) {
		return 0;
	}
}
