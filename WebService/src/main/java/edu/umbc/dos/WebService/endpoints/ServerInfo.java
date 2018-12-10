package edu.umbc.dos.WebService.endpoints;

public class ServerInfo {
  public String ip;
  private int port;
  private String[] serviceName;
  
 public String getIp() {
	return ip;
}

public void setIp(String ip) {
	this.ip = ip;
}

public int getPort() {
	return port;
}

public void setPort(int port) {
	this.port = port;
}

public String[] getServiceName() {
	return serviceName;
}

public void setServiceName(String[] serviceName) {
	this.serviceName = serviceName;
}
  
}
