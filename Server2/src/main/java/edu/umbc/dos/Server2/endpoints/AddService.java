package edu.umbc.dos.Server2.endpoints;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import edu.umbc.dos.Server2.config.WebConfig;


@WebService(serviceName="add", targetNamespace=.NAMESPACE_URI)
public class AddService {
		
	@WebMethod
	public int add(@WebParam(name="args1") int arg1, @WebParam(name="args2") int arg2) {
		return arg1 + arg2;
	}	
	
 
}
