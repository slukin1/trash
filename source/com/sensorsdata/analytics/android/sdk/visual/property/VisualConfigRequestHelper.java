package com.sensorsdata.analytics.android.sdk.visual.property;

import android.content.Context;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.visual.util.Dispatcher;
import com.sumsub.sns.internal.fingerprint.signalproviders.f;

public class VisualConfigRequestHelper {
    private static final String TAG = "SA.VP.VisualConfigRequestHelper";
    /* access modifiers changed from: private */
    public CountDownTimer mCountDownTimer;

    public interface IApiCallback {
        void onSuccess(String str);
    }

    /* access modifiers changed from: private */
    public String getRequestUrl(Context context, String str) {
        String str2;
        if (context == null) {
            SALog.i(TAG, "getRequestUrl context is null and return");
            return null;
        }
        String serverUrl = SensorsDataAPI.sharedInstance().getServerUrl();
        if (TextUtils.isEmpty(serverUrl)) {
            SALog.i(TAG, "visualConfigRequest server url is null and return");
            return null;
        }
        int lastIndexOf = serverUrl.lastIndexOf("/");
        if (lastIndexOf != -1) {
            str2 = serverUrl.substring(0, lastIndexOf) + "/config/visualized/Android.conf";
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        Uri.Builder buildUpon = Uri.parse(str2).buildUpon();
        if (!TextUtils.isEmpty(str)) {
            buildUpon.appendQueryParameter(f.f34662a, str);
        }
        String queryParameter = Uri.parse(serverUrl).getQueryParameter("project");
        if (!TextUtils.isEmpty(queryParameter)) {
            buildUpon.appendQueryParameter("project", queryParameter);
        }
        String processName = AppInfoUtils.getProcessName(context);
        if (!TextUtils.isEmpty(processName)) {
            buildUpon.appendQueryParameter("app_id", processName);
        }
        return buildUpon.build().toString();
    }

    /* access modifiers changed from: private */
    public void resetTimer() {
        try {
            CountDownTimer countDownTimer = this.mCountDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        } catch (Throwable th2) {
            this.mCountDownTimer = null;
            throw th2;
        }
        this.mCountDownTimer = null;
    }

    public void requestVisualConfig(final Context context, final String str, final IApiCallback iApiCallback) {
        Dispatcher.getInstance().post(new Runnable() {
            public void run() {
                if (VisualConfigRequestHelper.this.mCountDownTimer != null) {
                    VisualConfigRequestHelper.this.mCountDownTimer.cancel();
                    CountDownTimer unused = VisualConfigRequestHelper.this.mCountDownTimer = null;
                }
                CountDownTimer unused2 = VisualConfigRequestHelper.this.mCountDownTimer = new CountDownTimer(90000, 30000) {
                    public void onFinish() {
                    }

                    public void onTick(long j11) {
                        try {
                            if (TextUtils.isEmpty(SensorsDataAPI.sharedInstance().getServerUrl())) {
                                SALog.i(VisualConfigRequestHelper.TAG, "visualConfigRequest server url is null and return");
                                return;
                            }
                            AnonymousClass1 r32 = AnonymousClass1.this;
                            String access$100 = VisualConfigRequestHelper.this.getRequestUrl(context, str);
                            if (TextUtils.isEmpty(access$100)) {
                                SALog.i(VisualConfigRequestHelper.TAG, "visualConfigRequest request url is null and return");
                            } else {
                                new RequestHelper.Builder(HttpMethod.GET, access$100).callback(new HttpCallback.StringCallback() {
                                    public void onAfter() {
                                    }

                                    public void onFailure(int i11, String str) {
                                        if (i11 == 304 || i11 == 404 || i11 == 205) {
                                            VisualConfigRequestHelper.this.resetTimer();
                                            if (i11 == 205) {
                                                VisualPropertiesManager.getInstance().save2Cache("");
                                            }
                                            SALog.i(VisualConfigRequestHelper.TAG, "requestVisualConfig return 304 Or 404");
                                        }
                                    }

                                    public void onResponse(String str) {
                                        VisualConfigRequestHelper.this.resetTimer();
                                        IApiCallback iApiCallback = iApiCallback;
                                        if (iApiCallback != null) {
                                            iApiCallback.onSuccess(str);
                                        }
                                        SALog.i(VisualConfigRequestHelper.TAG, "requestVisualConfig success response is " + str);
                                    }
                                }).execute();
                            }
                        } catch (Exception e11) {
                            SALog.printStackTrace(e11);
                        }
                    }
                };
                VisualConfigRequestHelper.this.mCountDownTimer.start();
            }
        });
    }
}
