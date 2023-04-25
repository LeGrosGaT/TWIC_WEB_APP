package com.twic.service;

import com.twic.dto.VilleDTO;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VilleService {

	private static final String API_URL = "http://localhost:8181/ville";

    public List<VilleDTO> getAllVilles() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_URL + "/chercher")
                .build();

        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            VilleDTO[] villes = gson.fromJson(response.body().string(), VilleDTO[].class);
            return new ArrayList<>(Arrays.asList(villes));
        }
    }
    
    public VilleDTO getVilleByCode(String code) throws JsonSyntaxException, IOException {
    	OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_URL + "/chercher?code=" + code)
                .build();

        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            VilleDTO[] villes = gson.fromJson(response.body().string(), VilleDTO[].class);
            return new ArrayList<>(Arrays.asList(villes)).get(0);
        }

    }
    
    public double getDistance(String ville1, String ville2) throws IOException {
    	OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_URL + "/distance?ville1=" + ville1 + "&ville2=" + ville2)
                .build();

        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            double distance = gson.fromJson(response.body().string(), double.class);
            return distance;
        }
    }
    
    public void deleteVille(String ville) throws IOException {
        URL url = new URL(API_URL + "/retire?code=" + ville);
        System.out.println(url.toString());
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestProperty(
            "Content-Type", "application/x-www-form-urlencoded" );
        httpCon.setRequestMethod("DELETE");
        httpCon.connect();
    }
    
	public VilleDTO modifyVille(String code, String nom, String postal, String libelle, String ligne, String latitude, String longitude) throws IOException {
		OkHttpClient client = new OkHttpClient();

        /*Request request = new Request.Builder()
                .url(API_URL + "/modifier?code=" + code + "&nom=" + nom + "&postal=" + postal + "&libelle=" + libelle + "&ligne=" + ligne + "&latitude=" + latitude + "&longitude=" + longitude)
                .build();
                
         try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            return gson.fromJson(response.body().string(), VilleDTO.class);*/
		Request request = new Request.Builder()
                .url("http://localhost:8181/ville/modifier?code=01001&nom=test")
                .build();
        
        

        
            
            try (Response response = client.newCall(request).execute()) {

                ResponseBody responseBody = response.body();
                String responseBodyString = responseBody.string();
                System.out.println(responseBodyString); // Affiche le corps de la réponse en tant que chaîne de caractères

                Gson gson = new Gson();
                return gson.fromJson(responseBodyString, VilleDTO.class);
           
        }
	}
            
     public void test(String code, String nom, String postal, String libelle, String ligne, String latitude, String longitude) throws IOException {
    	 URL url = new URL(API_URL + "/modifier?code=" + code + "&nom=" + nom + "&postal=" + postal + "&libelle=" + libelle + "&ligne=" + ligne + "&latitude=" + latitude + "&longitude=" + longitude);
    	 HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
    	 System.out.println(url.toString());
    	 httpCon.setDoOutput(true);
    	 httpCon.setRequestMethod("PUT");
    	 OutputStreamWriter out = new OutputStreamWriter(
    	     httpCon.getOutputStream());
    	 out.write("Resource content");
    	 out.close();
    	 httpCon.getInputStream();
     }
}
