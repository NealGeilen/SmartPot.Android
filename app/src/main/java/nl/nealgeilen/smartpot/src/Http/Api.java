package nl.nealgeilen.smartpot.src.Http;

import androidx.annotation.Nullable;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONObject;

import java.util.HashMap;

import nl.nealgeilen.smartpot.src.App;

public class Api {

    public  static String DOMAIN = "https://smartpot.nealgeilen.nl/api/user/";

    public static void executeRequest(JsonRequest jsonrequest){
       Queue.getInstance(App.getContext()).getRequestQueue().add(jsonrequest);
    }

    public static void Request(
            String url,
            int method,
            @Nullable JSONObject parameters,
            Response.Listener<JSONObject> listener,
            @Nullable Response.ErrorListener errorListener,
            @Nullable HashMap<String, String> headers
    ){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method, url, parameters, listener, errorListener){
            /**
             * Passing some request headers
             * @return
             */
            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                int mStatusCode = response.statusCode;
                System.out.println(mStatusCode);
                return super.parseNetworkResponse(response);
            }
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                if (headers == null){
//                    HashMap<String, String> headers = new HashMap<>();
//                }
//                headers.put("Content-Type", "application/json");
//                return headers;
//            }
        };
        Api.executeRequest(jsonObjectRequest);
    }
}
