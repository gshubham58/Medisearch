
import java.util.ArrayList;
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
public class UsageJson {
     public static ArrayList<String> jsonpar(String res){
                   
        ArrayList<String> arr=new ArrayList<String>(); 
        try {
            JSONArray a1=new JSONArray(res);
            JSONObject o1=a1.getJSONObject(0);
            JSONArray a2=o1.getJSONArray("usages");
            int p=0;
            while(p<a2.length()){
            JSONObject o2=a2.getJSONObject(p);
            String m=o2.getString("term");
           arr.add(m);
            p++;
            }
                 } catch (JSONException ex) {
            ex.printStackTrace();
         
        }
        return arr;
    }
    
    
}
