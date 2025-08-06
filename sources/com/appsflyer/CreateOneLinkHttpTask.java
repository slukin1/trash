package com.appsflyer;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.appsflyer.internal.ae;
import com.appsflyer.internal.ak;
import com.appsflyer.internal.m;
import com.appsflyer.share.LinkGenerator;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class CreateOneLinkHttpTask extends ak {
    private final Map<String, String> AFLogger$LogLevel;
    private String AFVersionDeclaration = "";
    private final String init;
    public String valueOf;
    public ResponseListener values;

    public interface ResponseListener {
        void onResponse(String str);

        void onResponseError(String str);
    }

    public CreateOneLinkHttpTask(String str, Map<String, String> map, ae aeVar, Context context) {
        super(aeVar, context, "POST");
        if (context != null) {
            this.AFVersionDeclaration = context.getPackageName();
        } else {
            AFLogger.init("CreateOneLinkHttpTask: context can't be null");
        }
        this.AFKeystoreWrapper = str;
        this.init = "-1";
        this.AFLogger$LogLevel = map;
    }

    public final void AFInAppEventParameterName(HttpsURLConnection httpsURLConnection) throws IOException {
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setUseCaches(false);
        HashMap hashMap = new HashMap();
        hashMap.put("ttl", this.init);
        hashMap.put(ZendeskIdentityStorage.UUID_KEY, this.AppsFlyer2dXConversionCallback);
        hashMap.put("data", this.AFLogger$LogLevel);
        hashMap.put(Constants.REFERRER_API_META, this.getLevel);
        String str = this.valueOf;
        if (str != null) {
            hashMap.put("brand_domain", str);
        }
        String jSONObject = m.AFInAppEventType((Map<String, ?>) hashMap).toString();
        values(httpsURLConnection, this.AFInAppEventType, jSONObject);
        httpsURLConnection.connect();
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.writeBytes(jSONObject);
        dataOutputStream.flush();
        dataOutputStream.close();
    }

    public final void AFInAppEventType() {
        LinkGenerator addParameters = new LinkGenerator("af_app_invites").setBaseURL(this.AFKeystoreWrapper, AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_DOMAIN), this.AFVersionDeclaration).addParameter("af_siteid", this.AFVersionDeclaration).addParameters(this.AFLogger$LogLevel);
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string != null) {
            addParameters.setReferrerCustomerId(string);
        }
        this.values.onResponse(addParameters.generateLink());
    }

    public final void AFKeystoreWrapper(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                this.values.onResponse(jSONObject.optString(keys.next()));
            }
        } catch (JSONException e11) {
            this.values.onResponseError("Can't parse one link data");
            AFLogger.AFInAppEventType("Error while parsing to json ".concat(String.valueOf(str)), (Throwable) e11);
        }
    }

    public final String AFInAppEventParameterName() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format(ak.AFInAppEventParameterName, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName()}));
        sb2.append("/");
        sb2.append(this.AFKeystoreWrapper);
        return sb2.toString();
    }
}
