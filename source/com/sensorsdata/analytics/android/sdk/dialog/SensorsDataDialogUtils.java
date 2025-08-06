package com.sensorsdata.analytics.android.sdk.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.huobi.view.roundimg.RoundedDrawable;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.ThreadNameConstants;
import com.sensorsdata.analytics.android.sdk.dialog.DebugModeSelectDialog;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import com.sensorsdata.analytics.android.sdk.util.ToastUtil;
import com.sensorsdata.analytics.android.sdk.visual.HeatMapService;
import com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService;
import com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;

public class SensorsDataDialogUtils {
    private static final String TAG = "SA.SensorsDataDialogUtils";
    /* access modifiers changed from: private */
    public static boolean isShowHttpErrorDialog = true;
    private static Dialog sDialog;

    public static class SendDebugIdThread extends Thread {
        private String distinctId;
        private String infoId;
        private String serverUrl;

        public SendDebugIdThread(String str, String str2, String str3, String str4) {
            super(str4);
            this.distinctId = str2;
            this.infoId = str3;
            this.serverUrl = str;
        }

        private void closeStream(ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream, BufferedOutputStream bufferedOutputStream, HttpURLConnection httpURLConnection) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e12) {
                    SALog.printStackTrace(e12);
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e13) {
                    SALog.printStackTrace(e13);
                }
            }
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e14) {
                    SALog.printStackTrace(e14);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: java.io.BufferedOutputStream} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void sendHttpRequest(java.lang.String r14, boolean r15) {
            /*
                r13 = this;
                java.lang.String r0 = "SA.SensorsDataDialogUtils"
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                r3.<init>()     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                r3.append(r14)     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                java.lang.String r4 = "&info_id=%s"
                r3.append(r4)     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                r4 = 1
                java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                java.lang.String r6 = r13.infoId     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                r7 = 0
                r5[r7] = r6     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                java.lang.String r3 = "DebugMode URL:%s"
                java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                r5[r7] = r2     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                com.sensorsdata.analytics.android.sdk.SALog.info(r0, r3, r1)     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                java.net.URLConnection r3 = r2.openConnection()     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x011b, all -> 0x0116 }
                if (r3 != 0) goto L_0x004f
                java.lang.String r14 = "can not connect %s,shouldn't happen"
                java.lang.Object[] r15 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
                r15[r7] = r2     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
                java.lang.String r14 = java.lang.String.format(r14, r15)     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
                com.sensorsdata.analytics.android.sdk.SALog.info(r0, r14, r1)     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
                r13.closeStream(r1, r1, r1, r3)
                return
            L_0x004f:
                com.sensorsdata.analytics.android.sdk.SAConfigOptions r2 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
                if (r2 == 0) goto L_0x0063
                javax.net.ssl.SSLSocketFactory r2 = r2.mSSLSocketFactory     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
                if (r2 == 0) goto L_0x0063
                boolean r5 = r3 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
                if (r5 == 0) goto L_0x0063
                r5 = r3
                javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
                r5.setSSLSocketFactory(r2)     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
            L_0x0063:
                r3.setInstanceFollowRedirects(r7)     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
                java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
                r2.<init>()     // Catch:{ Exception -> 0x0113, all -> 0x0110 }
                java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                r5.<init>(r2)     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                r6.<init>()     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                java.lang.String r8 = "{\"distinct_id\": \""
                r6.append(r8)     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                java.lang.String r8 = r13.distinctId     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                r6.append(r8)     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                java.lang.String r8 = "\"}"
                r6.append(r8)     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                r5.write(r6)     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                r5.flush()     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                java.lang.String r5 = "DebugMode request body : %s"
                java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                r8[r7] = r6     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                java.lang.String r5 = java.lang.String.format(r5, r8)     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                com.sensorsdata.analytics.android.sdk.SALog.info(r0, r5, r1)     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                r3.setDoOutput(r4)     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                r3.setUseCaches(r7)     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                java.lang.String r5 = "POST"
                r3.setRequestMethod(r5)     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                java.lang.String r5 = "Content-type"
                java.lang.String r6 = "text/plain"
                r3.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ Exception -> 0x010b, all -> 0x0106 }
                java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0103, all -> 0x0100 }
                r6.<init>(r5)     // Catch:{ Exception -> 0x0103, all -> 0x0100 }
                java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                java.lang.String r9 = "UTF-8"
                byte[] r8 = r8.getBytes(r9)     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                r6.write(r8)     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                r6.flush()     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                r2.close()     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                int r8 = r3.getResponseCode()     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                java.util.Locale r9 = java.util.Locale.CHINA     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                java.lang.String r10 = "DebugMode 后端的响应码是:%d"
                java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                r11[r7] = r12     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                java.lang.String r7 = java.lang.String.format(r9, r10, r11)     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                com.sensorsdata.analytics.android.sdk.SALog.info(r0, r7, r1)     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                if (r15 != 0) goto L_0x00f8
                boolean r15 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.needRedirects(r8)     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                if (r15 == 0) goto L_0x00f8
                java.lang.String r14 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getLocation(r3, r14)     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                boolean r15 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                if (r15 != 0) goto L_0x00f8
                r13.closeStream(r2, r5, r6, r3)     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
                r13.sendHttpRequest(r14, r4)     // Catch:{ Exception -> 0x00fe, all -> 0x00fc }
            L_0x00f8:
                r13.closeStream(r2, r5, r6, r3)
                goto L_0x0125
            L_0x00fc:
                r14 = move-exception
                goto L_0x0109
            L_0x00fe:
                r14 = move-exception
                goto L_0x010e
            L_0x0100:
                r14 = move-exception
                r6 = r1
                goto L_0x0109
            L_0x0103:
                r14 = move-exception
                r6 = r1
                goto L_0x010e
            L_0x0106:
                r14 = move-exception
                r5 = r1
                r6 = r5
            L_0x0109:
                r1 = r2
                goto L_0x0127
            L_0x010b:
                r14 = move-exception
                r5 = r1
                r6 = r5
            L_0x010e:
                r1 = r2
                goto L_0x011f
            L_0x0110:
                r14 = move-exception
                r5 = r1
                goto L_0x0119
            L_0x0113:
                r14 = move-exception
                r5 = r1
                goto L_0x011e
            L_0x0116:
                r14 = move-exception
                r3 = r1
                r5 = r3
            L_0x0119:
                r6 = r5
                goto L_0x0127
            L_0x011b:
                r14 = move-exception
                r3 = r1
                r5 = r3
            L_0x011e:
                r6 = r5
            L_0x011f:
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r14)     // Catch:{ all -> 0x0126 }
                r13.closeStream(r1, r5, r6, r3)
            L_0x0125:
                return
            L_0x0126:
                r14 = move-exception
            L_0x0127:
                r13.closeStream(r1, r5, r6, r3)
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.SendDebugIdThread.sendHttpRequest(java.lang.String, boolean):void");
        }

        public void run() {
            super.run();
            sendHttpRequest(this.serverUrl, false);
        }
    }

    public static void dialogShowDismissOld(Dialog dialog) {
        try {
            Dialog dialog2 = sDialog;
            if (dialog2 != null && dialog2.isShowing()) {
                try {
                    sDialog.dismiss();
                    SALog.i(TAG, "Dialog dismiss");
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
            sDialog = dialog;
            dialog.show();
        } catch (Exception e12) {
            SALog.printStackTrace(e12);
        }
    }

    public static StateListDrawable getDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#dddddd"));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-1);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842908}, gradientDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        return stateListDrawable;
    }

    public static boolean isSchemeActivity(Context context) {
        if (context == null) {
            return false;
        }
        String name = context.getClass().getName();
        if (!TextUtils.isEmpty(name) && name.endsWith(SchemeActivity.class.getSimpleName())) {
            Object findFieldRecur = ReflectUtil.findFieldRecur(context, "SCHEME_ACTIVITY_SIGN");
            if (findFieldRecur instanceof String) {
                return TextUtils.equals((String) findFieldRecur, SchemeActivity.SCHEME_ACTIVITY_SIGN);
            }
        }
        return false;
    }

    public static void showDebugModeSelectDialog(final Activity activity, final String str, final String str2, final String str3) {
        try {
            DebugModeSelectDialog debugModeSelectDialog = new DebugModeSelectDialog(activity, SensorsDataAPI.sharedInstance().getDebugMode());
            debugModeSelectDialog.setCanceledOnTouchOutside(false);
            debugModeSelectDialog.setOnDebugModeDialogClickListener(new DebugModeSelectDialog.OnDebugModeViewClickListener() {
                public void onCancel(Dialog dialog) {
                    dialog.cancel();
                }

                public void setDebugMode(Dialog dialog, SensorsDataAPI.DebugMode debugMode) {
                    SensorsDataAPI.sharedInstance().setDebugMode(debugMode);
                    dialog.cancel();
                }
            });
            debugModeSelectDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    String str;
                    String serverUrl = SensorsDataAPI.sharedInstance().getServerUrl();
                    SensorsDataAPI.DebugMode debugMode = SensorsDataAPI.sharedInstance().getDebugMode();
                    if (SensorsDataAPI.sharedInstance().isNetworkRequestEnable() && !TextUtils.isEmpty(serverUrl) && !TextUtils.isEmpty(str) && debugMode != SensorsDataAPI.DebugMode.DEBUG_OFF) {
                        if (TextUtils.isEmpty(str2)) {
                            new SendDebugIdThread(serverUrl, SensorsDataAPI.sharedInstance().getDistinctId(), str, ThreadNameConstants.THREAD_SEND_DISTINCT_ID).start();
                        } else {
                            try {
                                if (!TextUtils.isEmpty(str3)) {
                                    String str2 = str2 + "?project=" + str3;
                                    SALog.i(SensorsDataDialogUtils.TAG, "sf url:" + str2);
                                    new SendDebugIdThread(str2, SensorsDataAPI.sharedInstance().getDistinctId(), str, ThreadNameConstants.THREAD_SEND_DISTINCT_ID).start();
                                }
                            } catch (Exception e11) {
                                SALog.printStackTrace(e11);
                            }
                        }
                    }
                    if (debugMode == SensorsDataAPI.DebugMode.DEBUG_OFF) {
                        str = "已关闭调试模式，请重新扫描二维码进行开启";
                    } else if (debugMode == SensorsDataAPI.DebugMode.DEBUG_ONLY) {
                        str = "开启调试模式，校验数据，但不进行数据导入；关闭 App 进程后，将自动关闭调试模式";
                    } else {
                        str = debugMode == SensorsDataAPI.DebugMode.DEBUG_AND_TRACK ? "开启调试模式，校验数据，并将数据导入到神策分析中；关闭 App 进程后，将自动关闭调试模式" : "";
                    }
                    ToastUtil.showLong(activity, str);
                    SALog.info(SensorsDataDialogUtils.TAG, "您当前的调试模式是：" + debugMode, (Throwable) null);
                    SensorsDataDialogUtils.startLaunchActivity(activity);
                }
            });
            dialogShowDismissOld(debugModeSelectDialog);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static void showDialog(Activity activity, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        builder.setCancelable(false);
        builder.setNegativeButton(str4, onClickListener2);
        builder.setPositiveButton(str3, onClickListener);
        dialogShowDismissOld(builder.create());
    }

    public static void showHttpErrorDialog(Activity activity, String str) {
        try {
            if (!TextUtils.isEmpty(str) && isShowHttpErrorDialog) {
                if (activity != null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("提示");
                    builder.setMessage(str);
                    builder.setCancelable(false);
                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i11) {
                        }
                    });
                    builder.setPositiveButton("不再提示", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i11) {
                            boolean unused = SensorsDataDialogUtils.isShowHttpErrorDialog = false;
                        }
                    });
                    AlertDialog create = builder.create();
                    dialogShowDismissOld(create);
                    try {
                        create.getButton(-2).setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
                        create.getButton(-2).setBackgroundColor(-1);
                        create.getButton(-1).setTextColor(-65536);
                        create.getButton(-1).setBackgroundColor(-1);
                        if (Build.VERSION.SDK_INT >= 16) {
                            create.getButton(-2).setBackground(getDrawable());
                            create.getButton(-1).setBackground(getDrawable());
                            return;
                        }
                        create.getButton(-2).setBackgroundDrawable(getDrawable());
                        create.getButton(-1).setBackgroundDrawable(getDrawable());
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            }
        } catch (Exception e12) {
            SALog.printStackTrace(e12);
        }
    }

    public static void showOpenHeatMapDialog(final Activity activity, final String str, final String str2) {
        boolean z11;
        try {
            if (!SensorsDataAPI.sharedInstance().isNetworkRequestEnable()) {
                showDialog(activity, "已关闭网络请求（NetworkRequest），无法使用 App 点击分析，请开启后再试！");
            } else if (!SensorsDataAPI.sharedInstance().isHeatMapEnabled()) {
                showDialog(activity, "SDK 没有被正确集成，请联系贵方技术人员开启点击分析。");
            } else {
                try {
                    z11 = "WIFI".equals(NetworkUtils.networkType(activity));
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                    z11 = false;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("提示");
                if (z11) {
                    builder.setMessage("正在连接 App 点击分析...");
                } else {
                    builder.setMessage("正在连接 App 点击分析，建议在 WiFi 环境下使用。");
                }
                builder.setCancelable(false);
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        SensorsDataDialogUtils.startLaunchActivity(activity);
                    }
                });
                builder.setPositiveButton("继续", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        HeatMapService.getInstance().start(activity, str, str2);
                        SensorsDataDialogUtils.startLaunchActivity(activity);
                    }
                });
                AlertDialog create = builder.create();
                dialogShowDismissOld(create);
                try {
                    create.getButton(-2).setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
                    create.getButton(-2).setBackgroundColor(-1);
                    create.getButton(-1).setTextColor(-65536);
                    create.getButton(-1).setBackgroundColor(-1);
                    if (Build.VERSION.SDK_INT >= 16) {
                        create.getButton(-2).setBackground(getDrawable());
                        create.getButton(-1).setBackground(getDrawable());
                        return;
                    }
                    create.getButton(-2).setBackgroundDrawable(getDrawable());
                    create.getButton(-1).setBackgroundDrawable(getDrawable());
                } catch (Exception e12) {
                    SALog.printStackTrace(e12);
                }
            }
        } catch (Exception e13) {
            SALog.printStackTrace(e13);
        }
    }

    public static void showOpenVisualizedAutoTrackDialog(final Activity activity, final String str, final String str2) {
        boolean z11;
        try {
            if (!SensorsDataAPI.sharedInstance().isNetworkRequestEnable()) {
                showDialog(activity, "已关闭网络请求（NetworkRequest），无法使用 App 可视化全埋点，请开启后再试！");
            } else if (!SensorsDataAPI.sharedInstance().isVisualizedAutoTrackEnabled()) {
                showDialog(activity, "SDK 没有被正确集成，请联系贵方技术人员开启可视化全埋点。");
            } else {
                try {
                    z11 = "WIFI".equals(NetworkUtils.networkType(activity));
                } catch (Exception unused) {
                    z11 = false;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("提示");
                if (z11) {
                    builder.setMessage("正在连接 App 可视化全埋点...");
                } else {
                    builder.setMessage("正在连接 App 可视化全埋点，建议在 WiFi 环境下使用。");
                }
                builder.setCancelable(false);
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        SensorsDataDialogUtils.startLaunchActivity(activity);
                    }
                });
                builder.setPositiveButton("继续", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        VisualizedAutoTrackService.getInstance().start(activity, str, str2);
                        SensorsDataDialogUtils.startLaunchActivity(activity);
                    }
                });
                AlertDialog create = builder.create();
                dialogShowDismissOld(create);
                try {
                    create.getButton(-2).setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
                    create.getButton(-2).setBackgroundColor(-1);
                    create.getButton(-1).setTextColor(-65536);
                    create.getButton(-1).setBackgroundColor(-1);
                    if (Build.VERSION.SDK_INT >= 16) {
                        create.getButton(-2).setBackground(getDrawable());
                        create.getButton(-1).setBackground(getDrawable());
                        return;
                    }
                    create.getButton(-2).setBackgroundDrawable(getDrawable());
                    create.getButton(-1).setBackgroundDrawable(getDrawable());
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        } catch (Exception e12) {
            SALog.printStackTrace(e12);
        }
    }

    public static void showPairingCodeInputDialog(final Context context) {
        if (context == null) {
            SALog.i(TAG, "The argument context can't be null");
        } else if (!(context instanceof Activity)) {
            SALog.i(TAG, "The static method showPairingCodeEditDialog(Context context) only accepts Activity as a parameter");
        } else {
            ((Activity) context).runOnUiThread(new Runnable() {
                public void run() {
                    new PairingCodeEditDialog(context).show();
                }
            });
        }
    }

    public static void showPopupWindowDialog(final Activity activity, Uri uri) {
        AnonymousClass1 r02;
        try {
            Class<?> cls = Class.forName("com.sensorsdata.sf.ui.utils.PreviewUtil");
            String queryParameter = uri.getQueryParameter("sf_popup_test");
            String queryParameter2 = uri.getQueryParameter("popup_window_id");
            boolean parseBoolean = !TextUtils.isEmpty(queryParameter) ? Boolean.parseBoolean(queryParameter) : false;
            Method[] declaredMethods = cls.getDeclaredMethods();
            int length = declaredMethods.length;
            int i11 = 0;
            Method method = null;
            while (true) {
                if (i11 >= length) {
                    r02 = null;
                    break;
                }
                Method method2 = declaredMethods[i11];
                if (method2.getName().equals("showPreview")) {
                    if (method2.getParameterTypes().length == 4) {
                        r02 = new Runnable() {
                            public void run() {
                                Activity activity = activity;
                                if (activity != null) {
                                    activity.runOnUiThread(new Runnable() {
                                        public void run() {
                                            SensorsDataDialogUtils.showDialog(activity, "测试弹窗加载失败，请确认网络或项目环境是否正常！");
                                        }
                                    });
                                }
                            }
                        };
                        method = method2;
                        break;
                    }
                    method = method2;
                }
                i11++;
            }
            if (method != null) {
                if (r02 != null) {
                    method.invoke((Object) null, new Object[]{activity, Boolean.valueOf(parseBoolean), queryParameter2, r02});
                } else {
                    method.invoke((Object) null, new Object[]{activity, Boolean.valueOf(parseBoolean), queryParameter2});
                }
                SchemeActivity.isPopWindow = true;
                return;
            }
            startLaunchActivity(activity);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            startLaunchActivity(activity);
        }
    }

    public static void startLaunchActivity(Context context) {
        try {
            if (isSchemeActivity(context)) {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()));
                ((SchemeActivity) context).finish();
                SALog.i(TAG, "startLaunchActivity");
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static void showDialog(final Context context, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示").setMessage(str).setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                SensorsDataDialogUtils.startLaunchActivity(context);
            }
        });
        AlertDialog create = builder.create();
        dialogShowDismissOld(create);
        try {
            create.getButton(-1).setTextColor(-65536);
            create.getButton(-1).setBackgroundColor(-1);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }
}
