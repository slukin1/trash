package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ClearKeyUtil {
    private static final String TAG = "ClearKeyUtil";

    private ClearKeyUtil() {
    }

    public static byte[] adjustRequestData(byte[] bArr) {
        if (Util.SDK_INT >= 27) {
            return bArr;
        }
        return Util.getUtf8Bytes(base64ToBase64Url(Util.fromUtf8Bytes(bArr)));
    }

    public static byte[] adjustResponseData(byte[] bArr) {
        if (Util.SDK_INT >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(Util.fromUtf8Bytes(bArr));
            StringBuilder sb2 = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray(UserMetadata.KEYDATA_FILENAME);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                if (i11 != 0) {
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                sb2.append("{\"k\":\"");
                sb2.append(base64UrlToBase64(jSONObject2.getString("k")));
                sb2.append("\",\"kid\":\"");
                sb2.append(base64UrlToBase64(jSONObject2.getString("kid")));
                sb2.append("\",\"kty\":\"");
                sb2.append(jSONObject2.getString("kty"));
                sb2.append("\"}");
            }
            sb2.append("]}");
            return Util.getUtf8Bytes(sb2.toString());
        } catch (JSONException e11) {
            String valueOf = String.valueOf(Util.fromUtf8Bytes(bArr));
            Log.e(TAG, valueOf.length() != 0 ? "Failed to adjust response data: ".concat(valueOf) : new String("Failed to adjust response data: "), e11);
            return bArr;
        }
    }

    private static String base64ToBase64Url(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static String base64UrlToBase64(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
