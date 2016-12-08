package com.example.resttest;

import java.io.IOException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		// Gson gson = new Gson();
		// String url =
		// "http://192.168.20.222:8080/uni2/rest/portal/consultaLogisticaEntrega?idProveedor=6f68b728-ee13-9b45-4a6d-564231cf5779";
		// System.out.println(url);
		// InputStream test = null;
		//
		// HttpClient httpclient = HttpClientBuilder.create().build();
		// HttpGet get = new HttpGet(url);
		// try {
		// HttpResponse response=httpclient.execute(get);
		// if(response!=null){
		// test=response.getEntity().getContent();
		// }
		// } catch (ClientProtocolException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// String myString = IOUtils.toString(test, "UTF-8");
		// System.out.println("xxxx " + myString);
		//
		// JsonObject obj = gson.fromJson(myString,
		// JsonElement.class).getAsJsonObject();
		// System.out.println("yyy " + obj.get("idLogisticaEntrega"));

		String url = "http://192.168.20.222:8080/uni2/rest/portal/agregarActualizarLogisticaEntregaProveedor";

		JsonObject json = new JsonObject();
		
		
		json.addProperty("idLogisticaEntrega", "62");
		json.addProperty("accion", "2");
		json.addProperty("idProveedor", "6f68b728-ee13-9b45-4a6d-564231cf5779");
		json.addProperty("tipoEntrega", "12");
		json.addProperty("paisesEntrega", "x");
		json.addProperty("estados", "aaa");
		json.addProperty("comentario", "test");
		System.out.println(json.toString());
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
			HttpPost request = new HttpPost(url);
			StringEntity params = new StringEntity(json.toString());
			request.addHeader("Content-Type", "application/json");
			request.setEntity(params);
			httpClient.execute(request);
			System.out.println("aaaaaaa");
		} catch (Exception ex) {
			System.out.println("Ha ocurrido una excepción");
		} finally {
			httpClient.close();
		}

	}
}
