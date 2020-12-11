package nl.nealgeilen.smartpot.src.User;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import nl.nealgeilen.smartpot.src.App;
import nl.nealgeilen.smartpot.src.Http.Api;

public class Authentication {

    public static String getToken(){
        return App.getContext().getSharedPreferences("User", 0).getString("Token", "");
    }

    public static boolean isTokenSet(){
        return !Authentication.getToken().equals("");
    }

    @SuppressLint("CommitPrefEdits")
    public static void setToken(String Token){
        SharedPreferences pref = App.getContext().getSharedPreferences("User", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("Token", Token);
        editor.apply();
    }

    public static void validate(String username, String password) throws JSONException {
        JSONObject parameters = new JSONObject();
        parameters.put("username", username);
        parameters.put("password", password);
        if (!Authentication.isTokenSet()){
            Api.Request(
                    Api.DOMAIN + "authenticate",
                    Request.Method.POST,
                    parameters,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            System.out.println("TEST");
                            try {
                                Authentication.setToken((String)response.get("Token"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            System.out.println(Authentication.getToken());
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println("TEST ERROR");
                            System.out.println(error);
                        }
                    },
                    null
            );
        } else {
            System.out.println(Authentication.getToken());
        }
    }

}
