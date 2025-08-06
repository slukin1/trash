package com.tencent.android.tpush.common;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.HttpHelper;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e11) {
            Logger.e("AccountHttpHelper", "getHostName Exception :", e11);
            return "";
        }
    }

    public static void a(Context context, String str, long j11, int i11, final XGIOperateCallback xGIOperateCallback) {
        try {
            if (CloudManager.getInstance(context).shouldRefuse()) {
                Logger.i("AccountHttpHelper", "sendAccountByhttp refused by cloud");
                if (xGIOperateCallback != null) {
                    ReturnCode returnCode = ReturnCode.CODE_SERVICE_DISABLED;
                    xGIOperateCallback.onFail("", returnCode.getType(), ReturnCode.errCodeToMsg(returnCode.getType()));
                    return;
                }
                return;
            }
            JSONObject a11 = a(context, str, j11, i11);
            if (a11 != null) {
                String jSONObject = a11.toString();
                String batchOpertorServerAddr = XGApiConfig.getBatchOpertorServerAddr(context);
                String a12 = a(batchOpertorServerAddr);
                Logger.d("AccountHttpHelper", "accountReqStr:" + jSONObject + ", url:" + batchOpertorServerAddr);
                HttpHelper.sendHttpRequest(context, GuidInfoManager.getServerIPAddress(context, batchOpertorServerAddr), batchOpertorServerAddr, a12, jSONObject, new HttpRequestCallback() {
                    public void onFailure(int i11, String str) {
                        XGIOperateCallback xGIOperateCallback = XGIOperateCallback.this;
                        if (xGIOperateCallback != null) {
                            xGIOperateCallback.onFail("", i11, str);
                        }
                    }

                    public void onSuccess(String str) {
                        XGIOperateCallback xGIOperateCallback;
                        try {
                            if (!j.b(str) && new JSONObject(str).getInt("ret_code") == 0 && (xGIOperateCallback = XGIOperateCallback.this) != null) {
                                xGIOperateCallback.onSuccess("", 0);
                                return;
                            }
                        } catch (Throwable unused) {
                        }
                        XGIOperateCallback xGIOperateCallback2 = XGIOperateCallback.this;
                        if (xGIOperateCallback2 != null) {
                            ReturnCode returnCode = ReturnCode.CODE_NETWORK_INNER_EXCEPTION_OCCUR;
                            xGIOperateCallback2.onFail("", returnCode.getType(), ReturnCode.errCodeToMsg(returnCode.getType()));
                        }
                    }
                }, true);
            } else if (xGIOperateCallback != null) {
                ReturnCode returnCode2 = ReturnCode.CODE_NETWORK_INNER_EXCEPTION_OCCUR;
                xGIOperateCallback.onFail("", returnCode2.getType(), ReturnCode.errCodeToMsg(returnCode2.getType()));
            }
        } catch (Throwable th2) {
            Logger.w("AccountHttpHelper", "unexpected for sendAccountByhttp, exception:", th2);
            if (xGIOperateCallback != null) {
                ReturnCode returnCode3 = ReturnCode.CODE_NETWORK_INNER_EXCEPTION_OCCUR;
                xGIOperateCallback.onFail("", returnCode3.getType(), ReturnCode.errCodeToMsg(returnCode3.getType()));
            }
        }
    }

    private static JSONObject a(Context context, String str, long j11, int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("accessId", j11);
            jSONObject.put("sdkVersion", "1.4.4.2");
            jSONObject.put("from", 1);
            if (i11 == 6 || i11 == 2) {
                jSONObject.put("operator_type", 1);
            } else if (i11 == 1) {
                jSONObject.put("operator_type", 4);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(GuidInfoManager.getToken(context));
                jSONObject.put("token_list", jSONArray);
                return jSONObject;
            } else if (i11 == 0) {
                jSONObject.put("operator_type", 2);
            } else {
                if (i11 != 3) {
                    if (i11 != 7) {
                        Logger.w("AccountHttpHelper", "unsupport account operate type：" + i11);
                        return null;
                    }
                }
                jSONObject.put("operator_type", 3);
            }
            JSONObject jSONObject2 = new JSONObject();
            if (!j.b(str)) {
                jSONObject2.put("account_list", new JSONArray(str));
            }
            jSONObject2.put("token", GuidInfoManager.getToken(context));
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            jSONObject.put("token_accounts", jSONArray2);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
