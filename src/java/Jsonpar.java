
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class Jsonpar {
    public static ArrayList<model> json(String res){
                   
        ArrayList<model> arr=new ArrayList<model>(); 
        try {
            JSONArray a1=new JSONArray(res);
            int p=0;
            while(p<a1.length()){
            JSONObject o1=a1.getJSONObject(p);
            model m=new model();
            m.setName(o1.getString("name"));
            m.setForm(o1.getString("form"));
            m.setStandardUnits(o1.getInt("standardUnits"));
            m.setPackageForm(o1.getString("packageForm"));
            m.setPrice(o1.getInt("price"));
            m.setSize(o1.getString("size"));
            m.setManufacturer(o1.getString("manufacturer"));
            m.setMedicine_id(o1.getString("medicine_id"));
           arr.add(m);
            p++;
            
            }
            
                 } catch (JSONException ex) {
            ex.printStackTrace();
         
        }
        return arr;
    }
}
