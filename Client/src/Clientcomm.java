

	
	import java.io.BufferedReader;
	import java.io.DataOutputStream;
	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	import java.net.URL;


	public class Clientcomm {

		private final String USER_AGENT = "Mozilla/5.0";

		public static void main(String[] args) throws Exception {

			Clientcomm http = new Clientcomm();

			
			
			System.out.println("\nTesting 2 - Send Http POST request");
			http.sendPost();

		}
		private void sendPost() throws Exception {

			String url = "http://localhost:8081";
			URL obj = new URL(url);
			HttpURLConnection c = (HttpURLConnection) obj.openConnection();

			//add reuqest header
			c.setRequestMethod("POST");
			c.setRequestProperty("Accept", "*/");
			c.setRequestProperty("User-Agent", USER_AGENT);
			c.setRequestProperty("ctent-Type", "text/xml");
			c.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			
			
			// Send post request
			c.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(c.getOutputStream());
			wr.writeBytes("NEED TO MAKE CHANGES		<SOAP-ENV:Envelope\r\n" + 
					"   xmlns:SOAP-ENV = \"http://www.w3.org/2001/12/soap-envelope\"\r\n" + 
					"   SOAP-ENV:encodingStyle = \"http://www.w3.org/2001/12/soap-encoding\">\r\n" + 
					"\r\n" + 
					"   <SOAP-ENV:Body xmlns:m = \"http://www.xyz.org/quotations\">\r\n" + 
					"      <m:GetQuotation>\r\n" + 
					"         <m:QuotationsName>MiscroSoft</m:QuotationsName>\r\n" + 
					"      </m:GetQuotation>\r\n" + 
					"   </SOAP-ENV:Body>\r\n" + 
					"</SOAP-ENV:Envelope>");
			wr.flush();
			wr.close();

			int responseCode = c.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(c.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());

		}

	}

