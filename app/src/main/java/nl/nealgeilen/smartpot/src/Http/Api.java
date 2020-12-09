package nl.nealgeilen.smartpot.src.Http;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

import nl.nealgeilen.smartpot.src.App;

public class Api {

    protected String Domain = "https://smartpot.nealgeilen.nl";
    protected String Path="api/";
    protected String Endpoint = "user/";
    protected ArrayList Headers = new ArrayList();
    protected String Type = "GET";

    public static void executeRequest(JsonRequest jsonrequest){
       Queue.getInstance(App.getContext()).getRequestQueue().add(jsonrequest);
    }


    public String getDomain() {
        return Domain;
    }

    public Api setDomain(String domain) {
        Domain = domain;
        return this;
    }

    public String getPath() {
        return Path;
    }

    public Api setPath(String path) {
        Path = path;
        return this;
    }

    public String getEndpoint() {
        return Endpoint;
    }

    public Api setEndpoint(String endpoint) {
        Endpoint = endpoint;
        return this;
    }

    public ArrayList getHeaders() {
        return Headers;
    }

    public Api setHeaders(ArrayList headers) {
        Headers = headers;
        return this;
    }

    public String getType() {
        return Type;
    }

    public Api setType(String type) {
        Type = type;
        return this;
    }
}
