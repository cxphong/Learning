package android.fiot.asynchttpclientexample;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.KeyStore;

import cz.msebera.android.httpclient.Header;

/**
 * Created by caoxuanphong on 4/26/17.
 */

public class FioTRestApi {
    private static final String TAG = "FioTRestApi";

    public enum CONTENT_TYPE {
        APPLICATION_JSON,
        X_WWW_FORM_XML_URLENCODED
    }

    public interface FioTRestListener {
        void onSuccess(JSONObject jsonObject);
        void onFailure(Throwable throwable);
    }

    public static void postAsychronous(Context context,
                                       String url) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("email", "phonggamo@gmail.com");
        params.put("password", "123456");

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null, null);
        sf = new MySSLSocketFactory(trustStore);
        sf.setHostnameVerifier(MySSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        client.setSSLSocketFactory(sf);

        JsonHttpResponseHandler handler = new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                Log.i(TAG, "onSuccess: " + response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.i(TAG, "onFailure: " + errorResponse);
            }
        };

        // Make post run asynchronous
        handler.setUsePoolThread(true);
        client.post(context, url, params, handler);
    }

}
