package com.LMS.genericUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class Utilities {

/*
    public static void loadExcels(String filename, ArrayList<ArrayList<String>> listOfLists,String sheetName) {
        ExcelRead.writeInExcel(filename, listOfLists,sheetName);
    }
*/

    /**
     *
     * @param seconds
     */
    public static void sleep(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param strText
     * @return
     */
    public static BigDecimal getDecimalValue(String strText) {

        BigDecimal b = new BigDecimal(strText);
        return b;
    }


    public static  int getColDiff(int firstNo, int secondNo){
        return firstNo-secondNo;
    }

   /* public static  List<HashMap<String, Object>> loadDataMap(String filename) {
        List<HashMap<String, Object>> listOfmaps = ExcelRead.readFromExcelGeneric(filename);

        return listOfmaps;
    }*/




    public static String readJsonFromTxtFile(String inpString, String key) {

        Object value = "";

        String jsonString = inpString;
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(jsonString);
            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject) object;

            //Reading the String
            value =  jsonObject.get(key);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return value.toString();
    }


    public static String readJsonUsingResponse(Response response, String key, String type) {
        Object value = "0";
        JSONParser jsonparser = new JSONParser();
        String strResponseJson = response.getBody().prettyPrint();
        try {
            Object object = jsonparser.parse(strResponseJson);
            JSONObject jsonObject = (JSONObject) object;
            String nodeValue = null;
            JsonPath jsonpath=JsonPath.from(String.valueOf(jsonObject));
            if (type.equals("singleNode")) {

                value =  jsonObject.get(key);
            }else if (type.equals("ListNode")){
                List<Object> node = jsonpath.get(key);
                if(node==null){
                    value = "0";
                }else{
                    value = node.get(node.size()-1);
                }


            }else if (type.equals("map")){
                value = jsonpath.get(key).toString();
            }


        } catch (ParseException e) {

            e.printStackTrace();

        }catch (NullPointerException e){
            value="0";
        }catch (Exception e){
            value="0";
        }
        if(value==null){
            value="0";
        }
        return value.toString();
    }


    public static String readJsonNew(String jsonFilePath,String key, String type) {

        Object value = "";
        JSONParser jsonparser = new JSONParser();
        try {
            Object object = jsonparser.parse(new FileReader(jsonFilePath));
            JSONObject jsonObject = (JSONObject) object;
            JsonPath jsonpath=JsonPath.from(String.valueOf(jsonObject));

            if (type.equals("singleNode")) {
                value =  jsonObject.get(key);
            }else if (type.equals("ListNode")){
                //List<Object> node = jsonpath.get(key);
                String node = jsonpath.get(key).toString();
                value = node;//.get(node.size()-1);
                List<Object> nodeList = jsonpath.get(key);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value.toString();
    }



    /**
     * @param jsonFilePath
     * @return
     */
    public static String readJson(String jsonFilePath,String key, String type) {
        Object value = "";
        JSONParser jsonparser = new JSONParser();
        try {
            Object object = jsonparser.parse(new FileReader(jsonFilePath));
            JSONObject jsonObject = (JSONObject) object;
            JsonPath jsonpath=JsonPath.from(String.valueOf(jsonObject));
            if (type.equals("singleNode")) {
                value =  jsonObject.get(key);
            }else if (type.equals("ListNode")){
                List<Object> node = jsonpath.get(key);
                value = node.get(node.size()-1);
            }else if(type.equalsIgnoreCase("map")){
                value=jsonpath.get(key).toString();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value.toString();
    }


    /*
 Validates PDF url in xml file
  */
    public  static void validatePdfURLisLoaded(String pdfUrl) {
        try {

                URL url = new URL(pdfUrl);
                URLConnection urlConnection = url.openConnection();
                Reporter.log("# pdf URL received :- " + pdfUrl, true);
                Assert.assertTrue(urlConnection.getContentType().equalsIgnoreCase("application/pdf"), "Content type differs from application/pdf");
                Reporter.log("# pdf URL opened successfully. ", true);


        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

}
