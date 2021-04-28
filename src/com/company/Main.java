package com.company;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jdk.internal.org.objectweb.asm.TypeReference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    /**
     * skip
     * limit
     * sorted
     */

    public static void main(String[] args) {
        List<String> carList = new ArrayList<>();
       /* carList.add("BMW");
        carList.add("RR");
        carList.add("Maserati");*/
       /* carList.add("Ferrari");
        carList.add("Lada");
        carList.add("Volga");
        carList.add("Dodge");
        carList.add("BMW");
        carList.add("BMW");
        carList.add("BMW");
        for (int i =0;i<carList.size(); i++){
            System.out.println(carList.get(i));
        }
        System.out.println("______________________________________");
        System.out.println("**************************************");
        carList.stream().forEach(System.out::println);

        for (int i=0;i<carList.size();i++){
            if (carList.get(i).equals("BMW")) {
                System.out.println(carList.get(i));
            }
        }
        carList.stream().filter(car->car.equals("BMW")).forEach(System.out::println);
*/
        /*try {
            String url = "https://jsonplaceholder.typicode.com/posts";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent","Mozilla/5.0");
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println(responseCode);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while((line=bufferedReader.readLine())!=null){
                response.append(line);
            }
            System.out.println(response.toString());
            Gson gson = new Gson();
            FrontData[] frontData = new Gson().fromJson(String.valueOf(response),FrontData[].class);
            for (FrontData f:frontData){
                System.out.println(f);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        try {
            String url = "https://cat-fact.herokuapp.com/facts";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println(responseCode);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Json from url");
            System.out.println("-----------------------------------");
            System.out.println(response.toString());
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<Cat> catList = new ArrayList<>();
//            catList = Arrays.asList(objectMapper.readValue(response.toString(), Cat[].class));
            catList = objectMapper.readValue(response.toString(),objectMapper.getTypeFactory().constructCollectionType(List.class,Cat.class));
            for (Cat cat:catList){
                System.out.println("**************");
                System.out.println(cat.getStatus());
                System.out.println(cat);
                System.out.println("_________________________________");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





































}
