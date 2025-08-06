package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError implements Parcelable {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new Parcelable.Creator<FacebookRequestError>() {
        public FacebookRequestError createFromParcel(Parcel parcel) {
            return new FacebookRequestError(parcel);
        }

        public FacebookRequestError[] newArray(int i11) {
            return new FacebookRequestError[i11];
        }
    };
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    public static final Range HTTP_RANGE_SUCCESS = new Range(200, 299);
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorRecoveryMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    public static class Range {
        private final int end;
        private final int start;

        public boolean contains(int i11) {
            return this.start <= i11 && i11 <= this.end;
        }

        private Range(int i11, int i12) {
            this.start = i11;
            this.end = i12;
        }
    }

    public static FacebookRequestError checkResponseAndCreateError(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        boolean z11;
        String str;
        String str2;
        String str3;
        String str4;
        int i11;
        int i12;
        JSONObject jSONObject2 = jSONObject;
        try {
            if (jSONObject2.has("code")) {
                int i13 = jSONObject2.getInt("code");
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject2, "body", GraphResponse.NON_JSON_RESPONSE_PROPERTY);
                if (stringPropertyAsJSON != null && (stringPropertyAsJSON instanceof JSONObject)) {
                    JSONObject jSONObject3 = (JSONObject) stringPropertyAsJSON;
                    boolean z12 = false;
                    if (jSONObject3.has("error")) {
                        JSONObject jSONObject4 = (JSONObject) Utility.getStringPropertyAsJSON(jSONObject3, "error", (String) null);
                        String optString = jSONObject4.optString("type", (String) null);
                        String optString2 = jSONObject4.optString("message", (String) null);
                        i12 = jSONObject4.optInt("code", -1);
                        int optInt = jSONObject4.optInt("error_subcode", -1);
                        str2 = jSONObject4.optString(ERROR_USER_MSG_KEY, (String) null);
                        str = jSONObject4.optString(ERROR_USER_TITLE_KEY, (String) null);
                        z11 = jSONObject4.optBoolean(ERROR_IS_TRANSIENT_KEY, false);
                        z12 = true;
                        str4 = optString;
                        int i14 = optInt;
                        str3 = optString2;
                        i11 = i14;
                    } else {
                        if (!jSONObject3.has("error_code")) {
                            if (!jSONObject3.has(ERROR_MSG_KEY)) {
                                if (!jSONObject3.has(ERROR_REASON_KEY)) {
                                    z11 = false;
                                    i12 = -1;
                                    i11 = -1;
                                    str4 = null;
                                    str3 = null;
                                    str2 = null;
                                    str = null;
                                }
                            }
                        }
                        String optString3 = jSONObject3.optString(ERROR_REASON_KEY, (String) null);
                        String optString4 = jSONObject3.optString(ERROR_MSG_KEY, (String) null);
                        int optInt2 = jSONObject3.optInt("error_code", -1);
                        i11 = jSONObject3.optInt("error_subcode", -1);
                        str3 = optString4;
                        z11 = false;
                        str2 = null;
                        str = null;
                        i12 = optInt2;
                        z12 = true;
                        str4 = optString3;
                    }
                    if (z12) {
                        return new FacebookRequestError(i13, i12, i11, str4, str3, str, str2, z11, jSONObject3, jSONObject, obj, httpURLConnection, (FacebookException) null);
                    }
                }
                if (!HTTP_RANGE_SUCCESS.contains(i13)) {
                    return new FacebookRequestError(i13, -1, -1, (String) null, (String) null, (String) null, (String) null, false, jSONObject2.has("body") ? (JSONObject) Utility.getStringPropertyAsJSON(jSONObject2, "body", GraphResponse.NON_JSON_RESPONSE_PROPERTY) : null, jSONObject, obj, httpURLConnection, (FacebookException) null);
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public static synchronized FacebookRequestErrorClassification getErrorClassification() {
        synchronized (FacebookRequestError.class) {
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                FacebookRequestErrorClassification defaultErrorClassification = FacebookRequestErrorClassification.getDefaultErrorClassification();
                return defaultErrorClassification;
            }
            FacebookRequestErrorClassification errorClassification = appSettingsWithoutQuery.getErrorClassification();
            return errorClassification;
        }
    }

    public int describeContents() {
        return 0;
    }

    public Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public Category getCategory() {
        return this.category;
    }

    public HttpURLConnection getConnection() {
        return this.connection;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        String str = this.errorMessage;
        if (str != null) {
            return str;
        }
        return this.exception.getLocalizedMessage();
    }

    public String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    public String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    public FacebookException getException() {
        return this.exception;
    }

    public JSONObject getRequestResult() {
        return this.requestResult;
    }

    public JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public int getSubErrorCode() {
        return this.subErrorCode;
    }

    public String toString() {
        return "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.requestStatusCode);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.subErrorCode);
        parcel.writeString(this.errorType);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.errorUserTitle);
        parcel.writeString(this.errorUserMessage);
    }

    private FacebookRequestError(int i11, int i12, int i13, String str, String str2, String str3, String str4, boolean z11, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        boolean z12;
        Category category2;
        this.requestStatusCode = i11;
        this.errorCode = i12;
        this.subErrorCode = i13;
        this.errorType = str;
        this.errorMessage = str2;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        if (facebookException != null) {
            this.exception = facebookException;
            z12 = true;
        } else {
            this.exception = new FacebookServiceException(this, str2);
            z12 = false;
        }
        FacebookRequestErrorClassification errorClassification = getErrorClassification();
        if (z12) {
            category2 = Category.OTHER;
        } else {
            category2 = errorClassification.classify(i12, i13, z11);
        }
        this.category = category2;
        this.errorRecoveryMessage = errorClassification.getRecoveryMessage(category2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FacebookRequestError(java.net.HttpURLConnection r17, java.lang.Exception r18) {
        /*
            r16 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.facebook.FacebookException
            if (r1 == 0) goto L_0x000a
            com.facebook.FacebookException r0 = (com.facebook.FacebookException) r0
            r15 = r0
            goto L_0x0010
        L_0x000a:
            com.facebook.FacebookException r1 = new com.facebook.FacebookException
            r1.<init>((java.lang.Throwable) r0)
            r15 = r1
        L_0x0010:
            r3 = -1
            r4 = -1
            r5 = -1
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r2 = r16
            r14 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.<init>(java.net.HttpURLConnection, java.lang.Exception):void");
    }

    public FacebookRequestError(int i11, String str, String str2) {
        this(-1, i11, -1, str, str2, (String) null, (String) null, false, (JSONObject) null, (JSONObject) null, (Object) null, (HttpURLConnection) null, (FacebookException) null);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, (JSONObject) null, (JSONObject) null, (Object) null, (HttpURLConnection) null, (FacebookException) null);
    }
}
