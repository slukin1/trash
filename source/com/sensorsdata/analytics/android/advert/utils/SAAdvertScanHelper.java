package com.sensorsdata.analytics.android.advert.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.advert.SAAdvertConstants;
import com.sensorsdata.analytics.android.advert.oaid.SAOaidHelper;
import com.sensorsdata.analytics.android.sdk.SAEventManager;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.ServerUrl;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataLoadingDialog;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sumsub.sns.internal.core.analytics.d;
import java.util.Date;
import org.json.JSONObject;

public class SAAdvertScanHelper {
    /* access modifiers changed from: private */
    public static void requestActiveChannel(String str, String str2, String str3, String str4, String str5, boolean z11, HttpCallback httpCallback) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("monitor_id", str2);
            jSONObject.put("distinct_id", SensorsDataAPI.sharedInstance().getDistinctId());
            jSONObject.put("project_id", str3);
            jSONObject.put("account_id", str4);
            jSONObject.put("has_active", z11 ? "true" : d.f31895b);
            jSONObject.put("device_code", str5);
            HttpMethod httpMethod = HttpMethod.POST;
            new RequestHelper.Builder(httpMethod, str + "/api/sdk/channel_tool/url").jsonData(jSONObject.toString()).callback(httpCallback).execute();
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static boolean scanHandler(Activity activity, Uri uri) {
        if (!"channeldebug".equals(uri.getHost())) {
            return false;
        }
        if (ChannelUtils.hasUtmByMetaData(activity)) {
            SensorsDataDialogUtils.showDialog(activity, "当前为渠道包，无法使用联调诊断工具");
            return true;
        }
        String queryParameter = uri.getQueryParameter("monitor_id");
        if (TextUtils.isEmpty(queryParameter)) {
            SensorsDataDialogUtils.startLaunchActivity(activity);
            return true;
        }
        String serverUrl = SensorsDataAPI.sharedInstance().getServerUrl();
        if (TextUtils.isEmpty(serverUrl)) {
            SensorsDataDialogUtils.showDialog(activity, "数据接收地址错误，无法使用联调诊断工具");
            return true;
        }
        ServerUrl serverUrl2 = new ServerUrl(serverUrl);
        if (serverUrl2.getProject().equals(uri.getQueryParameter("project_name"))) {
            String queryParameter2 = uri.getQueryParameter("project_id");
            String queryParameter3 = uri.getQueryParameter("account_id");
            if (!"1".equals(uri.getQueryParameter("is_relink"))) {
                showChannelDebugDialog(activity, serverUrl2.getBaseUrl(), queryParameter, queryParameter2, queryParameter3);
            } else if (ChannelUtils.checkDeviceInfo(activity, uri.getQueryParameter("device_code"))) {
                showChannelDebugActiveDialog(activity);
            } else {
                SensorsDataDialogUtils.showDialog(activity, "无法重连，请检查是否更换了联调手机");
            }
        } else {
            SensorsDataDialogUtils.showDialog(activity, "App 集成的项目与电脑浏览器打开的项目不同，无法使用联调诊断工具");
        }
        return true;
    }

    public static void showChannelDebugActiveDialog(final Activity activity) {
        SensorsDataDialogUtils.showDialog(activity, "成功开启调试模式", "此模式下不需要卸载 App，点击“激活”按钮可反复触发激活", "激活", new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                SAAdvertScanHelper.trackChannelDebugInstallation(activity);
                SAAdvertScanHelper.showChannelDebugActiveDialog(activity);
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        }, "取消", new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                SensorsDataDialogUtils.startLaunchActivity(activity);
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        });
    }

    public static void showChannelDebugDialog(final Activity activity, String str, String str2, String str3, String str4) {
        final Activity activity2 = activity;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        SensorsDataDialogUtils.showDialog(activity, "即将开启联调模式", "", "确定", new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                Context applicationContext = activity2.getApplicationContext();
                boolean isTrackInstallation = ChannelUtils.isTrackInstallation();
                if (!isTrackInstallation || ChannelUtils.isCorrectTrackInstallation()) {
                    String androidID = SensorsDataUtils.getAndroidID(applicationContext);
                    String oaid = SAOaidHelper.getOAID(applicationContext);
                    if (isTrackInstallation && !ChannelUtils.isGetDeviceInfo(applicationContext, androidID, oaid)) {
                        SAAdvertScanHelper.showChannelDebugErrorDialog(activity2);
                        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                        return;
                    } else if (!NetworkUtils.isNetworkAvailable(applicationContext)) {
                        SensorsDataDialogUtils.showDialog(activity2, "当前网络不可用，请检查网络！");
                        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                        return;
                    } else {
                        String deviceInfo = ChannelUtils.getDeviceInfo(activity2, androidID, oaid);
                        final SensorsDataLoadingDialog sensorsDataLoadingDialog = new SensorsDataLoadingDialog(activity2);
                        SensorsDataDialogUtils.dialogShowDismissOld(sensorsDataLoadingDialog);
                        SAAdvertScanHelper.requestActiveChannel(str5, str6, str7, str8, deviceInfo, isTrackInstallation, new HttpCallback.JsonCallback() {
                            public void onFailure(int i11, String str) {
                                sensorsDataLoadingDialog.dismiss();
                                SALog.i(SAAdvertConstants.TAG, "ChannelDebug request error:" + str);
                                SensorsDataDialogUtils.showDialog(activity2, "网络异常,请求失败!");
                            }

                            public void onResponse(JSONObject jSONObject) {
                                sensorsDataLoadingDialog.dismiss();
                                if (jSONObject == null) {
                                    SALog.i(SAAdvertConstants.TAG, "ChannelDebug response error msg: response is null");
                                    SensorsDataDialogUtils.showDialog(activity2, "添加白名单请求失败，请联系神策技术支持人员排查问题!");
                                } else if (jSONObject.optInt("code", 0) == 1) {
                                    SAAdvertScanHelper.showChannelDebugActiveDialog(activity2);
                                } else {
                                    SALog.i(SAAdvertConstants.TAG, "ChannelDebug response error msg:" + jSONObject.optString("message"));
                                    SensorsDataDialogUtils.showDialog(activity2, "添加白名单请求失败，请联系神策技术支持人员排查问题!");
                                }
                            }
                        });
                    }
                } else {
                    SAAdvertScanHelper.showChannelDebugErrorDialog(activity2);
                }
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        }, "取消", new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                SensorsDataDialogUtils.startLaunchActivity(activity);
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void showChannelDebugErrorDialog(final Activity activity) {
        SensorsDataDialogUtils.showDialog(activity, "检测到 “设备码为空”，可能原因如下，请排查：", "1. 开启 App 时拒绝“电话”授权；\n2. 手机系统权限设置中是否关闭“电话”授权；\n3. 请联系研发人员确认是否“调用 trackInstallation 接口在获取“电话”授权之后。\n\n 排查修复后，请先卸载应用并重新安装，再扫码进行联调。", "确定", new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                SensorsDataDialogUtils.startLaunchActivity(activity);
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        }, (String) null, (DialogInterface.OnClickListener) null);
    }

    /* access modifiers changed from: private */
    public static void trackChannelDebugInstallation(final Activity activity) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    Activity activity = activity;
                    jSONObject.put("$ios_install_source", ChannelUtils.getDeviceInfo(activity, SAAdvertUtils.getAndroidId(activity), SAOaidHelper.getOAID(activity)));
                    SAEventManager.getInstance().trackEvent(EventType.TRACK, "$ChannelDebugInstall", jSONObject, (String) null);
                    JSONObject jSONObject2 = new JSONObject();
                    SensorsDataUtils.mergeJSONObject(jSONObject, jSONObject2);
                    jSONObject2.put("$first_visit_time", new Date());
                    SAEventManager.getInstance().trackEvent(EventType.PROFILE_SET_ONCE, (String) null, jSONObject2, (String) null);
                    SensorsDataAPI.sharedInstance().flush();
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        }).start();
    }
}
