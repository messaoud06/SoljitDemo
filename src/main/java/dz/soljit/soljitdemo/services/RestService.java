package dz.soljit.soljitdemo.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import dz.soljit.soljitdemo.model.*;
import dz.soljit.soljitdemo.repository.AuthRepository;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestService {


    @Autowired
    AuthRepository authRepository;


    public LoginResponse login() throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://soljit.my.salesforce.com/services/oauth2/token");

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("username", "soljit_algeria2@soljit.com"));
        params.add(new BasicNameValuePair("password", "entretient_1235zoLmTaUDLiouUaOAN6WhOQPi"));
        params.add(new BasicNameValuePair("client_id", "3MVG9I9urWjeUW051PumYX1mbS5HkS3kpZsbCEzYWjgivRyDno1MjvM08EfVf2be52s0vrthHamsgMpQCrm5Z"));
        params.add(new BasicNameValuePair("client_secret","EC97DAFBF9F6F2399DE5E7BADA2E9BBEF6B3B6E832DC435668AA452940AD9501" ));
        params.add(new BasicNameValuePair("grant_type", "password"));
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpResponse response = client.execute(httpPost);

        String json = EntityUtils.toString(response.getEntity());

        LoginResponse loginResponse = new ObjectMapper().readValue(json, LoginResponse.class);

        return loginResponse;

    }

    public Candidature getInfoCandidature(String id) throws IOException {

        if(authRepository.findAll().isEmpty()){
            authRepository.save(this.login());
        }

        LoginResponse loginResponse = authRepository.findAll().get(0);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(loginResponse.getInstance_url()+"/services/data/v55.0/sobjects/Candidature__c/"+id);

        httpGet.setHeader("Authorization", "Bearer " + loginResponse.getAccess_token());

        CloseableHttpResponse response = client.execute(httpGet);

        String json = EntityUtils.toString(response.getEntity());

        Candidature candidature = new ObjectMapper().readValue(json, Candidature.class);

        System.out.println(candidature.getFirst_Name__c());
        System.out.println(candidature.getLast_Name__c());
        System.out.println(candidature.getYear__c());
        System.out.println(candidature.getYear_Of_Experience__c());

        return candidature;

    }

    public CandidatureCreatedModel postMyInfo() throws IOException {

        if(authRepository.findAll().isEmpty()){
            authRepository.save(this.login());
        }

        LoginResponse loginResponse = authRepository.findAll().get(0);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(loginResponse.getInstance_url()+"/services/data/v55.0/sobjects/Candidature__c");

        httpPost.setHeader("Authorization", "Bearer " + loginResponse.getAccess_token());
        httpPost.setHeader("Content-type", "application/json");

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        CandidatureSmallInfo candidatureSmallInfo= new CandidatureSmallInfo("Messaoud","GUERNOUTI",14,2022);

        String json = new ObjectMapper().writeValueAsString(candidatureSmallInfo);

        StringEntity postingString = new StringEntity(json);

        httpPost.setEntity(postingString);
        CloseableHttpResponse response = client.execute(httpPost);

        String jsonResponse = EntityUtils.toString(response.getEntity());


        CandidatureCreatedModel candidature = new ObjectMapper().readValue(json, CandidatureCreatedModel.class);

        return candidature;
    }

    public void updateMyLastname() throws IOException {
        if(authRepository.findAll().isEmpty()){
            authRepository.save(this.login());
        }

        LoginResponse loginResponse = authRepository.findAll().get(0);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPatch httpPatch = new HttpPatch(loginResponse.getInstance_url()+"/services/data/v55.0/sobjects/Candidature__c/a004L000002gCJK");

        httpPatch.setHeader("Authorization", "Bearer " + loginResponse.getAccess_token());
        httpPatch.setHeader("Content-type", "application/json");


        StringEntity postingString = new StringEntity("{\"Last_Name__c\":\"GUERNOUTI\"}");

        httpPatch.setEntity(postingString);
        CloseableHttpResponse response = client.execute(httpPatch);

        //String jsonResponse = EntityUtils.toString(response.getEntity());

        System.out.println(response.getStatusLine().getStatusCode());

    }


    public  AllCandidature allCandidature() throws IOException {

        if(authRepository.findAll().isEmpty()){
            authRepository.save(this.login());
        }

        LoginResponse loginResponse = authRepository.findAll().get(0);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(loginResponse.getInstance_url()+"/services/data/v55.0/sobjects/Candidature__c");

        httpGet.setHeader("Authorization", "Bearer " + loginResponse.getAccess_token());

        CloseableHttpResponse response = client.execute(httpGet);

        String json = EntityUtils.toString(response.getEntity());

        System.out.println(response.getStatusLine().getStatusCode());

        AllCandidature allCandidature = new ObjectMapper().readValue(json, AllCandidature.class);


        return allCandidature;
    }
}
