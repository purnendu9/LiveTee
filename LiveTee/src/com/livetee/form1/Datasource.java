package com.livetee.form1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Datasource {
	// public static final String
	// Forms_URL="http://nuziveeduservice.appspot.com/getformsforuser/userid";
	// public static final String GetFormForIDURL = "http://nuziveeduservice.appspot.com/form/";
	//public static final String Save_Form_URL = "http://nuziveeduservice.appspot.com/form/0000000012";
	public static final String Forms_URL = "http://10.0.2.2:8888/getformsforuser/";
	public static final String GetFormForIDURL = "http://10.0.2.2:8888/form/";
	public static final String Save_Form_URL = "http://10.0.2.2:8888/form/0000000012";
	
	public static String getFormDataForID(String formID)
	{
		BufferedReader in = null;
		String page = "";
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			String actualURL = GetFormForIDURL + formID;
			request.setURI(new URI(actualURL));

			HttpResponse response = client.execute(request);

			in = new BufferedReader(new InputStreamReader(response.getEntity()
					.getContent()));

			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			page = sb.toString();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return page;
	}
	

	public static String saveFormData(String formData, String userName)
			throws Exception {
		BufferedReader in = null;
		try {
			HttpClient client = new DefaultHttpClient();
			HttpPost request = new HttpPost(
					Save_Form_URL);
			List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
			postParameters.add(new BasicNameValuePair("userid", userName));
			postParameters.add(new BasicNameValuePair("formdata", formData));
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
					postParameters);
			request.setEntity(formEntity);
			HttpResponse response = client.execute(request);
			String statusCode = response.getStatusLine().getStatusCode() + "";
			return statusCode;
		} finally {
			/*
			 * if (in != null) { try { in.close(); } catch (IOException e) {
			 * e.printStackTrace(); } }
			 */
		}
	}

	public static String getListOfForms(String userName) throws Exception {
		BufferedReader in = null;
		String page;
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			String actualURL = Forms_URL + userName;
			request.setURI(new URI(actualURL));

			HttpResponse response = client.execute(request);

			in = new BufferedReader(new InputStreamReader(response.getEntity()
					.getContent()));

			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			page = sb.toString();

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return page;
	}

}
