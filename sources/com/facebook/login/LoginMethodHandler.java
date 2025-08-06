package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

abstract class LoginMethodHandler implements Parcelable {
    public LoginClient loginClient;
    public Map<String, String> methodLoggingExtras;

    public LoginMethodHandler(LoginClient loginClient2) {
        this.loginClient = loginClient2;
    }

    public static AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        Bundle bundle2 = bundle;
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle2, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
        ArrayList<String> stringArrayList = bundle2.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
        String string = bundle2.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle2, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
        if (Utility.isNullOrEmpty(string)) {
            return null;
        }
        return new AccessToken(string, str, bundle2.getString(NativeProtocol.EXTRA_USER_ID), stringArrayList, (Collection<String>) null, (Collection<String>) null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle2.getString(NativeProtocol.RESULT_ARGS_GRAPH_DOMAIN));
    }

    public static AccessToken createAccessTokenFromWebBundle(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) throws FacebookException {
        Bundle bundle2 = bundle;
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle2, AccessToken.EXPIRES_IN_KEY, new Date());
        String string = bundle2.getString("access_token");
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle2, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0));
        String string2 = bundle2.getString("granted_scopes");
        ArrayList arrayList = !Utility.isNullOrEmpty(string2) ? new ArrayList(Arrays.asList(string2.split(Constants.ACCEPT_TIME_SEPARATOR_SP))) : collection;
        String string3 = bundle2.getString("denied_scopes");
        ArrayList arrayList2 = !Utility.isNullOrEmpty(string3) ? new ArrayList(Arrays.asList(string3.split(Constants.ACCEPT_TIME_SEPARATOR_SP))) : null;
        String string4 = bundle2.getString("expired_scopes");
        ArrayList arrayList3 = !Utility.isNullOrEmpty(string4) ? new ArrayList(Arrays.asList(string4.split(Constants.ACCEPT_TIME_SEPARATOR_SP))) : null;
        if (Utility.isNullOrEmpty(string)) {
            return null;
        }
        return new AccessToken(string, str, getUserIDFromSignedRequest(bundle2.getString("signed_request")), arrayList, arrayList2, arrayList3, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle2.getString(NativeProtocol.RESULT_ARGS_GRAPH_DOMAIN));
    }

    public static String getUserIDFromSignedRequest(String str) throws FacebookException {
        if (str == null || str.isEmpty()) {
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
        try {
            String[] split = str.split("\\.");
            if (split.length == 2) {
                return new JSONObject(new String(Base64.decode(split[1], 0), "UTF-8")).getString("user_id");
            }
        } catch (UnsupportedEncodingException | JSONException unused) {
        }
        throw new FacebookException("Failed to retrieve user_id from signed_request");
    }

    public void addLoggingExtra(String str, Object obj) {
        if (this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        this.methodLoggingExtras.put(str, obj == null ? null : obj.toString());
    }

    public void cancel() {
    }

    public String getClientState(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LoginLogger.EVENT_PARAM_AUTH_LOGGER_ID, str);
            jSONObject.put(LoginLogger.EVENT_PARAM_METHOD, getNameForLogging());
            putChallengeParam(jSONObject);
        } catch (JSONException e11) {
            Log.w("LoginMethodHandler", "Error creating client state json: " + e11.getMessage());
        }
        return jSONObject.toString();
    }

    public abstract String getNameForLogging();

    public void logWebLoginCompleted(String str) {
        String applicationId = this.loginClient.getPendingRequest().getApplicationId();
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(this.loginClient.getActivity(), applicationId);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_WEB_LOGIN_E2E, str);
        bundle.putLong(AnalyticsEvents.PARAMETER_WEB_LOGIN_SWITCHBACK_TIME, System.currentTimeMillis());
        bundle.putString("app_id", applicationId);
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_WEB_LOGIN_COMPLETE, (Double) null, bundle);
    }

    public boolean needsInternetPermission() {
        return false;
    }

    public boolean onActivityResult(int i11, int i12, Intent intent) {
        return false;
    }

    public void putChallengeParam(JSONObject jSONObject) throws JSONException {
    }

    public void setLoginClient(LoginClient loginClient2) {
        if (this.loginClient == null) {
            this.loginClient = loginClient2;
            return;
        }
        throw new FacebookException("Can't set LoginClient if it is already set.");
    }

    public abstract boolean tryAuthorize(LoginClient.Request request);

    public void writeToParcel(Parcel parcel, int i11) {
        Utility.writeStringMapToParcel(parcel, this.methodLoggingExtras);
    }

    public LoginMethodHandler(Parcel parcel) {
        this.methodLoggingExtras = Utility.readStringMapFromParcel(parcel);
    }
}
