package com.facebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AccessToken implements Parcelable {
    public static final String ACCESS_TOKEN_KEY = "access_token";
    private static final String APPLICATION_ID_KEY = "application_id";
    public static final Parcelable.Creator<AccessToken> CREATOR = new Parcelable.Creator() {
        public AccessToken createFromParcel(Parcel parcel) {
            return new AccessToken(parcel);
        }

        public AccessToken[] newArray(int i11) {
            return new AccessToken[i11];
        }
    };
    private static final int CURRENT_JSON_FORMAT = 1;
    public static final String DATA_ACCESS_EXPIRATION_TIME = "data_access_expiration_time";
    private static final String DECLINED_PERMISSIONS_KEY = "declined_permissions";
    private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    private static final Date DEFAULT_EXPIRATION_TIME;
    private static final Date DEFAULT_LAST_REFRESH_TIME = new Date();
    private static final String EXPIRED_PERMISSIONS_KEY = "expired_permissions";
    private static final String EXPIRES_AT_KEY = "expires_at";
    public static final String EXPIRES_IN_KEY = "expires_in";
    private static final String GRAPH_DOMAIN = "graph_domain";
    private static final String LAST_REFRESH_KEY = "last_refresh";
    private static final Date MAX_DATE;
    private static final String PERMISSIONS_KEY = "permissions";
    private static final String SOURCE_KEY = "source";
    private static final String TOKEN_KEY = "token";
    public static final String USER_ID_KEY = "user_id";
    private static final String VERSION_KEY = "version";
    private final String applicationId;
    private final Date dataAccessExpirationTime;
    private final Set<String> declinedPermissions;
    private final Set<String> expiredPermissions;
    private final Date expires;
    private final String graphDomain;
    private final Date lastRefresh;
    private final Set<String> permissions;
    private final AccessTokenSource source;
    private final String token;
    private final String userId;

    public interface AccessTokenCreationCallback {
        void onError(FacebookException facebookException);

        void onSuccess(AccessToken accessToken);
    }

    public interface AccessTokenRefreshCallback {
        void OnTokenRefreshFailed(FacebookException facebookException);

        void OnTokenRefreshed(AccessToken accessToken);
    }

    static {
        Date date = new Date(Long.MAX_VALUE);
        MAX_DATE = date;
        DEFAULT_EXPIRATION_TIME = date;
    }

    public AccessToken(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        this(str, str2, str3, collection, collection2, collection3, accessTokenSource, date, date2, date3, (String) null);
    }

    private void appendPermissions(StringBuilder sb2) {
        sb2.append(" permissions:");
        if (this.permissions == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
            return;
        }
        sb2.append("[");
        sb2.append(TextUtils.join(", ", this.permissions));
        sb2.append("]");
    }

    public static AccessToken createExpired(AccessToken accessToken) {
        return new AccessToken(accessToken.token, accessToken.applicationId, accessToken.getUserId(), accessToken.getPermissions(), accessToken.getDeclinedPermissions(), accessToken.getExpiredPermissions(), accessToken.source, new Date(), new Date(), accessToken.dataAccessExpirationTime);
    }

    /* access modifiers changed from: private */
    public static AccessToken createFromBundle(List<String> list, Bundle bundle, AccessTokenSource accessTokenSource, Date date, String str) {
        Bundle bundle2 = bundle;
        String string = bundle.getString("access_token");
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, EXPIRES_IN_KEY, date);
        String string2 = bundle.getString("user_id");
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, DATA_ACCESS_EXPIRATION_TIME, new Date(0));
        if (Utility.isNullOrEmpty(string) || bundleLongAsDate == null) {
            return null;
        }
        return new AccessToken(string, str, string2, list, (Collection<String>) null, (Collection<String>) null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2);
    }

    public static AccessToken createFromJSONObject(JSONObject jSONObject) throws JSONException {
        Collection collection;
        if (jSONObject.getInt("version") <= 1) {
            String string = jSONObject.getString("token");
            Date date = new Date(jSONObject.getLong("expires_at"));
            JSONArray jSONArray = jSONObject.getJSONArray("permissions");
            JSONArray jSONArray2 = jSONObject.getJSONArray(DECLINED_PERMISSIONS_KEY);
            JSONArray optJSONArray = jSONObject.optJSONArray(EXPIRED_PERMISSIONS_KEY);
            Date date2 = new Date(jSONObject.getLong(LAST_REFRESH_KEY));
            AccessTokenSource valueOf = AccessTokenSource.valueOf(jSONObject.getString("source"));
            String string2 = jSONObject.getString(APPLICATION_ID_KEY);
            String string3 = jSONObject.getString("user_id");
            Date date3 = new Date(jSONObject.optLong(DATA_ACCESS_EXPIRATION_TIME, 0));
            String optString = jSONObject.optString("graph_domain", (String) null);
            List<String> jsonArrayToStringList = Utility.jsonArrayToStringList(jSONArray);
            List<String> jsonArrayToStringList2 = Utility.jsonArrayToStringList(jSONArray2);
            if (optJSONArray == null) {
                collection = new ArrayList();
            } else {
                collection = Utility.jsonArrayToStringList(optJSONArray);
            }
            return new AccessToken(string, string2, string3, jsonArrayToStringList, jsonArrayToStringList2, collection, valueOf, date, date2, date3, optString);
        }
        throw new FacebookException("Unknown AccessToken serialization format.");
    }

    public static AccessToken createFromLegacyCache(Bundle bundle) {
        List<String> permissionsFromBundle = getPermissionsFromBundle(bundle, LegacyTokenHelper.PERMISSIONS_KEY);
        List<String> permissionsFromBundle2 = getPermissionsFromBundle(bundle, LegacyTokenHelper.DECLINED_PERMISSIONS_KEY);
        List<String> permissionsFromBundle3 = getPermissionsFromBundle(bundle, LegacyTokenHelper.EXPIRED_PERMISSIONS_KEY);
        String applicationId2 = LegacyTokenHelper.getApplicationId(bundle);
        if (Utility.isNullOrEmpty(applicationId2)) {
            applicationId2 = FacebookSdk.getApplicationId();
        }
        String str = applicationId2;
        String token2 = LegacyTokenHelper.getToken(bundle);
        try {
            return new AccessToken(token2, str, Utility.awaitGetGraphMeRequestWithCache(token2).getString("id"), permissionsFromBundle, permissionsFromBundle2, permissionsFromBundle3, LegacyTokenHelper.getSource(bundle), LegacyTokenHelper.getDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY), LegacyTokenHelper.getDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY), (Date) null);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void createFromNativeLinkingIntent(Intent intent, final String str, final AccessTokenCreationCallback accessTokenCreationCallback) {
        Validate.notNull(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        if (intent.getExtras() == null) {
            accessTokenCreationCallback.onError(new FacebookException("No extras found on intent"));
            return;
        }
        final Bundle bundle = new Bundle(intent.getExtras());
        String string = bundle.getString("access_token");
        if (string == null || string.isEmpty()) {
            accessTokenCreationCallback.onError(new FacebookException("No access token found on intent"));
            return;
        }
        String string2 = bundle.getString("user_id");
        if (string2 == null || string2.isEmpty()) {
            Utility.getGraphMeRequestWithCacheAsync(string, new Utility.GraphMeRequestWithCacheCallback() {
                public void onFailure(FacebookException facebookException) {
                    accessTokenCreationCallback.onError(facebookException);
                }

                public void onSuccess(JSONObject jSONObject) {
                    try {
                        bundle.putString("user_id", jSONObject.getString("id"));
                        accessTokenCreationCallback.onSuccess(AccessToken.createFromBundle((List<String>) null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), str));
                    } catch (JSONException unused) {
                        accessTokenCreationCallback.onError(new FacebookException("Unable to generate access token due to missing user id"));
                    }
                }
            });
        } else {
            accessTokenCreationCallback.onSuccess(createFromBundle((List<String>) null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), str));
        }
    }

    @SuppressLint({"FieldGetter"})
    public static AccessToken createFromRefresh(AccessToken accessToken, Bundle bundle) {
        AccessToken accessToken2 = accessToken;
        Bundle bundle2 = bundle;
        AccessTokenSource accessTokenSource = accessToken2.source;
        if (accessTokenSource == AccessTokenSource.FACEBOOK_APPLICATION_WEB || accessTokenSource == AccessTokenSource.FACEBOOK_APPLICATION_NATIVE || accessTokenSource == AccessTokenSource.FACEBOOK_APPLICATION_SERVICE) {
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle2, EXPIRES_IN_KEY, new Date(0));
            String string = bundle2.getString("access_token");
            String string2 = bundle2.getString("graph_domain");
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle2, DATA_ACCESS_EXPIRATION_TIME, new Date(0));
            if (Utility.isNullOrEmpty(string)) {
                return null;
            }
            return new AccessToken(string, accessToken2.applicationId, accessToken.getUserId(), accessToken.getPermissions(), accessToken.getDeclinedPermissions(), accessToken.getExpiredPermissions(), accessToken2.source, bundleLongAsDate, new Date(), bundleLongAsDate2, string2);
        }
        throw new FacebookException("Invalid token source: " + accessToken2.source);
    }

    public static void expireCurrentAccessToken() {
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        if (currentAccessToken != null) {
            setCurrentAccessToken(createExpired(currentAccessToken));
        }
    }

    public static AccessToken getCurrentAccessToken() {
        return AccessTokenManager.getInstance().getCurrentAccessToken();
    }

    public static List<String> getPermissionsFromBundle(Bundle bundle, String str) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(stringArrayList));
    }

    public static boolean isCurrentAccessTokenActive() {
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        return currentAccessToken != null && !currentAccessToken.isExpired();
    }

    public static boolean isDataAccessActive() {
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        return currentAccessToken != null && !currentAccessToken.isDataAccessExpired();
    }

    public static void refreshCurrentAccessTokenAsync() {
        AccessTokenManager.getInstance().refreshCurrentAccessToken((AccessTokenRefreshCallback) null);
    }

    public static void setCurrentAccessToken(AccessToken accessToken) {
        AccessTokenManager.getInstance().setCurrentAccessToken(accessToken);
    }

    private String tokenToString() {
        if (this.token == null) {
            return OptionsBridge.NULL_VALUE;
        }
        return FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS) ? this.token : "ACCESS_TOKEN_REMOVED";
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        if (this.expires.equals(accessToken.expires) && this.permissions.equals(accessToken.permissions) && this.declinedPermissions.equals(accessToken.declinedPermissions) && this.expiredPermissions.equals(accessToken.expiredPermissions) && this.token.equals(accessToken.token) && this.source == accessToken.source && this.lastRefresh.equals(accessToken.lastRefresh) && ((str = this.applicationId) != null ? str.equals(accessToken.applicationId) : accessToken.applicationId == null) && this.userId.equals(accessToken.userId) && this.dataAccessExpirationTime.equals(accessToken.dataAccessExpirationTime)) {
            String str2 = this.graphDomain;
            String str3 = accessToken.graphDomain;
            if (str2 == null) {
                if (str3 == null) {
                    return true;
                }
            } else if (str2.equals(str3)) {
                return true;
            }
        }
        return false;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public Date getDataAccessExpirationTime() {
        return this.dataAccessExpirationTime;
    }

    public Set<String> getDeclinedPermissions() {
        return this.declinedPermissions;
    }

    public Set<String> getExpiredPermissions() {
        return this.expiredPermissions;
    }

    public Date getExpires() {
        return this.expires;
    }

    public String getGraphDomain() {
        return this.graphDomain;
    }

    public Date getLastRefresh() {
        return this.lastRefresh;
    }

    public Set<String> getPermissions() {
        return this.permissions;
    }

    public AccessTokenSource getSource() {
        return this.source;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode = (((((((((((((527 + this.expires.hashCode()) * 31) + this.permissions.hashCode()) * 31) + this.declinedPermissions.hashCode()) * 31) + this.expiredPermissions.hashCode()) * 31) + this.token.hashCode()) * 31) + this.source.hashCode()) * 31) + this.lastRefresh.hashCode()) * 31;
        String str = this.applicationId;
        int i11 = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.userId.hashCode()) * 31) + this.dataAccessExpirationTime.hashCode()) * 31;
        String str2 = this.graphDomain;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    public boolean isDataAccessExpired() {
        return new Date().after(this.dataAccessExpirationTime);
    }

    public boolean isExpired() {
        return new Date().after(this.expires);
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.token);
        jSONObject.put("expires_at", this.expires.getTime());
        jSONObject.put("permissions", new JSONArray(this.permissions));
        jSONObject.put(DECLINED_PERMISSIONS_KEY, new JSONArray(this.declinedPermissions));
        jSONObject.put(EXPIRED_PERMISSIONS_KEY, new JSONArray(this.expiredPermissions));
        jSONObject.put(LAST_REFRESH_KEY, this.lastRefresh.getTime());
        jSONObject.put("source", this.source.name());
        jSONObject.put(APPLICATION_ID_KEY, this.applicationId);
        jSONObject.put("user_id", this.userId);
        jSONObject.put(DATA_ACCESS_EXPIRATION_TIME, this.dataAccessExpirationTime.getTime());
        String str = this.graphDomain;
        if (str != null) {
            jSONObject.put("graph_domain", str);
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{AccessToken");
        sb2.append(" token:");
        sb2.append(tokenToString());
        appendPermissions(sb2);
        sb2.append("}");
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.expires.getTime());
        parcel.writeStringList(new ArrayList(this.permissions));
        parcel.writeStringList(new ArrayList(this.declinedPermissions));
        parcel.writeStringList(new ArrayList(this.expiredPermissions));
        parcel.writeString(this.token);
        parcel.writeString(this.source.name());
        parcel.writeLong(this.lastRefresh.getTime());
        parcel.writeString(this.applicationId);
        parcel.writeString(this.userId);
        parcel.writeLong(this.dataAccessExpirationTime.getTime());
        parcel.writeString(this.graphDomain);
    }

    public AccessToken(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3, String str4) {
        HashSet hashSet;
        HashSet hashSet2;
        HashSet hashSet3;
        Validate.notNullOrEmpty(str, "accessToken");
        Validate.notNullOrEmpty(str2, "applicationId");
        Validate.notNullOrEmpty(str3, "userId");
        this.expires = date == null ? DEFAULT_EXPIRATION_TIME : date;
        if (collection == null) {
            hashSet = new HashSet();
        }
        this.permissions = Collections.unmodifiableSet(hashSet);
        if (collection2 == null) {
            hashSet2 = new HashSet();
        }
        this.declinedPermissions = Collections.unmodifiableSet(hashSet2);
        if (collection3 == null) {
            hashSet3 = new HashSet();
        }
        this.expiredPermissions = Collections.unmodifiableSet(hashSet3);
        this.token = str;
        this.source = accessTokenSource == null ? DEFAULT_ACCESS_TOKEN_SOURCE : accessTokenSource;
        this.lastRefresh = date2 == null ? DEFAULT_LAST_REFRESH_TIME : date2;
        this.applicationId = str2;
        this.userId = str3;
        this.dataAccessExpirationTime = (date3 == null || date3.getTime() == 0) ? DEFAULT_EXPIRATION_TIME : date3;
        this.graphDomain = str4;
    }

    public static void refreshCurrentAccessTokenAsync(AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AccessTokenManager.getInstance().refreshCurrentAccessToken(accessTokenRefreshCallback);
    }

    public AccessToken(Parcel parcel) {
        this.expires = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.permissions = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.declinedPermissions = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.expiredPermissions = Collections.unmodifiableSet(new HashSet(arrayList));
        this.token = parcel.readString();
        this.source = AccessTokenSource.valueOf(parcel.readString());
        this.lastRefresh = new Date(parcel.readLong());
        this.applicationId = parcel.readString();
        this.userId = parcel.readString();
        this.dataAccessExpirationTime = new Date(parcel.readLong());
        this.graphDomain = parcel.readString();
    }
}
