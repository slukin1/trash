package com.geetest.core;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.geetest.core.GeeGuardConfiguration;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GeeGuard {

    public interface CallbackHandler {
        void onCompletion(Integer num, GeeGuardReceipt geeGuardReceipt);
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f65284a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GeeGuardReceipt f65285b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f65286c;

        public a(String str, GeeGuardReceipt geeGuardReceipt, CallbackHandler callbackHandler) {
            this.f65284a = str;
            this.f65285b = geeGuardReceipt;
            this.f65286c = callbackHandler;
        }

        public void run() {
            Pair pair;
            HashMap hashMap = new HashMap();
            hashMap.put("API-Version", "1");
            hashMap.put("AppID", this.f65284a);
            hashMap.put("GeeID", this.f65285b.geeID);
            hashMap.put("Client-Type", "1");
            String str = this.f65285b.geeToken;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://riskct.geetest.com/g2/api/v1/client_report").openConnection();
                httpURLConnection.setConnectTimeout(8000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                if (hashMap.size() > 0) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (Build.VERSION.SDK_INT >= 19) {
                        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
                    } else {
                        outputStream.write(str.getBytes());
                    }
                    outputStream.flush();
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                Pair<Boolean, String> a11 = a.a(httpURLConnection.getInputStream());
                if (((Boolean) a11.first).booleanValue()) {
                    pair = new Pair(Integer.valueOf(responseCode), (String) a11.second);
                } else {
                    pair = new Pair(Integer.valueOf(-responseCode), (String) a11.second);
                }
            } catch (ProtocolException e11) {
                e11.printStackTrace();
                pair = new Pair(-12, e11.toString());
            } catch (MalformedURLException e12) {
                e12.printStackTrace();
                pair = new Pair(-11, e12.toString());
            } catch (IOException e13) {
                e13.printStackTrace();
                pair = new Pair(-13, e13.toString());
            } catch (Exception e14) {
                e14.printStackTrace();
                pair = new Pair(-14, e14.toString());
            }
            if (((Integer) pair.first).intValue() == 200) {
                this.f65285b.originalResponse = (String) pair.second;
                try {
                    JSONObject jSONObject = new JSONObject((String) pair.second);
                    if (jSONObject.getInt("code") == 0) {
                        this.f65285b.geeQueryToken = jSONObject.getJSONObject("data").getString("query_token");
                        this.f65286c.onCompletion(200, this.f65285b);
                        return;
                    }
                    this.f65286c.onCompletion(-200, this.f65285b);
                } catch (JSONException e15) {
                    e15.printStackTrace();
                    this.f65286c.onCompletion(-200, this.f65285b);
                }
            } else {
                this.f65286c.onCompletion(-300, (GeeGuardReceipt) null);
            }
        }
    }

    public static GeeGuardReceipt fetchReceipt(Context context, String str, String str2) {
        String data = Core.getData(context.getApplicationContext(), new GeeGuardConfiguration.Builder().setAppId(str).addSignature(str2).build());
        String string = context.getSharedPreferences("gt_core", 0).getString("gt_gid3", (String) null);
        GeeGuardReceipt geeGuardReceipt = new GeeGuardReceipt();
        geeGuardReceipt.geeToken = data;
        geeGuardReceipt.geeID = string;
        if (string.length() > 0) {
            String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 4) {
                geeGuardReceipt.geeIDTimestamp = split[1];
            }
        }
        return geeGuardReceipt;
    }

    public static String getData(Context context, GeeGuardConfiguration geeGuardConfiguration) {
        return Core.getData(context.getApplicationContext(), geeGuardConfiguration);
    }

    public static String getVersion() {
        return "2.1.1";
    }

    public static void submitReceipt(Context context, String str, String str2, CallbackHandler callbackHandler) {
        new Thread(new a(str, fetchReceipt(context, str, str2), callbackHandler)).start();
    }
}
