package com.tencent.android.tpush;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.sumsub.sentry.c;
import com.sumsub.sentry.n0;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.twitter.sdk.android.core.identity.AuthHandler;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.ACTIVITYCHECK, EType.INTENTCHECK, EType.INTENTSCHEMECHECK})
public class InnerTpnsActivity extends Activity {
    public static final String CHECK_CODE = "checkCode";
    public static final String CUSTOM_CONTENT = "customContent";
    public static final String JUMP_type = "jumpType";
    public static final String MSG_TYPE = "msgType";
    public static final String TARGE_ACTIVITY = "targetActivity";
    public static final String TIMESTAMP = "timestamp";

    /* renamed from: a  reason: collision with root package name */
    public static Application.ActivityLifecycleCallbacks f67734a = null;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f67735b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f67736c = "";

    /* renamed from: d  reason: collision with root package name */
    public static long f67737d;

    /* renamed from: e  reason: collision with root package name */
    public static long f67738e;

    /* renamed from: f  reason: collision with root package name */
    private String f67739f = "";

    /* renamed from: g  reason: collision with root package name */
    private int f67740g = 100;

    public static void addActivityNames(String str) {
        if (!j.b(str)) {
            if (f67735b == null) {
                f67735b = new ArrayList();
            }
            if (!f67735b.contains(str)) {
                f67735b.add(str);
            }
        }
    }

    private void c(Intent intent) {
        String md5;
        if (intent != null) {
            try {
                final Uri data = intent.getData();
                if (data != null) {
                    String uri = data.toString();
                    TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity receiver otherChannelDeepLink url:" + uri);
                    String queryParameter = data.getQueryParameter("msgId");
                    String queryParameter2 = data.getQueryParameter("checkCode");
                    String queryParameter3 = data.getQueryParameter(MessageKey.MSG_PUSH_CHANNEL);
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        this.f67740g = Integer.parseInt(queryParameter3);
                    }
                    if (queryParameter != null && !TextUtils.isEmpty(queryParameter) && queryParameter2 != null && !TextUtils.isEmpty(queryParameter2) && (md5 = Md5.md5(queryParameter)) != null && queryParameter2.equals(md5)) {
                        String queryParameter4 = data.getQueryParameter("jumpType");
                        String queryParameter5 = data.getQueryParameter("targetActivity");
                        if (!(queryParameter4 == null || queryParameter5 == null)) {
                            if (!TextUtils.isEmpty(queryParameter5)) {
                                if (queryParameter5.length() > 0) {
                                    if (queryParameter4.equals("0")) {
                                        a();
                                    } else if (queryParameter4.equals("1")) {
                                        a(queryParameter5);
                                    } else if (queryParameter4.equals("2")) {
                                        b(queryParameter5);
                                    } else if (queryParameter4.equals("3")) {
                                        c(queryParameter5);
                                    }
                                }
                                CommonWorkingThread.getInstance().execute(new TTask() {
                                    public void TRun() {
                                        if (j.a(InnerTpnsActivity.this.getApplicationContext()) > 0) {
                                            TLogger.e("InnerTpnsActivity", "otherChannelDeepLink initGlobal failed");
                                        }
                                        InnerTpnsActivity.this.a(data);
                                    }
                                });
                            }
                        }
                        TLogger.i("InnerTpnsActivity", "InnerTpnsActivity receiver jumpType == null || targetIntent == null");
                        a();
                        CommonWorkingThread.getInstance().execute(new TTask() {
                            public void TRun() {
                                if (j.a(InnerTpnsActivity.this.getApplicationContext()) > 0) {
                                    TLogger.e("InnerTpnsActivity", "otherChannelDeepLink initGlobal failed");
                                }
                                InnerTpnsActivity.this.a(data);
                            }
                        });
                    }
                }
            } catch (Throwable th2) {
                TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity receiver e:" + th2);
                finish();
                return;
            }
        }
        finish();
    }

    private void d(Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getStringExtra("activity") != null ? intent.getStringExtra("activity") : "";
            if (XGPushConfig.enableDebug) {
                TLogger.i("InnerTpnsActivity", "activity intent =" + intent + "activity = " + str + "intent.getFlags()" + intent.getFlags());
            }
            f67737d = intent.getLongExtra("msgId", 0);
            f67738e = intent.getLongExtra(MessageKey.MSG_BUSI_MSG_ID, 0);
            f67736c = str;
        } else {
            str = null;
        }
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.addFlags(intent.getFlags());
            intent2.setClassName(getApplicationContext(), str);
            intent.putExtra(Constants.TAG_TPUSH_MESSAGE, "true");
            intent2.putExtras(intent);
        }
        intent2.addFlags(536870912);
        intent2.putExtra(Constants.TAG_TPUSH_NOTIFICATION, XGPushManager.a((Activity) this));
        String decrypt = Rijndael.decrypt(intent.getStringExtra("custom_content"));
        if (!TextUtils.isEmpty(decrypt)) {
            intent2.putExtra("custom_content", decrypt);
        }
        try {
            a(getApplication());
            startActivity(intent2);
        } catch (ActivityNotFoundException unused) {
        }
        finish();
    }

    private void e(Intent intent) {
        g(intent);
        ResolveInfo d11 = d(intent.getStringExtra(Constants.FLAG_PACKAGE_NAME));
        if (d11 != null) {
            ActivityInfo activityInfo = d11.activityInfo;
            String str = activityInfo.name;
            String str2 = activityInfo.packageName;
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            intent2.setComponent(new ComponentName(str2, str));
            String decrypt = Rijndael.decrypt(intent.getStringExtra("custom_content"));
            if (!TextUtils.isEmpty(decrypt)) {
                intent2.putExtra("custom_content", decrypt);
            }
            a(0, intent2);
            return;
        }
        a(1, intent);
    }

    /* access modifiers changed from: private */
    public void f(Intent intent) {
        try {
            Intent intent2 = new Intent();
            NotificationAction notificationAction = NotificationAction.intent;
            int intExtra = intent.getIntExtra("action_type", notificationAction.getType());
            if (intExtra == notificationAction.getType()) {
                int intExtra2 = intent.getIntExtra(Constants.PUSH_CHANNEL, 100);
                this.f67740g = intExtra2;
                if (intExtra2 != 101) {
                    if (intExtra2 != 99) {
                        intent2 = Intent.parseUri(intent.getStringExtra("activity"), 1);
                        intent2.setAction("android.intent.action.VIEW");
                    }
                }
                intent2 = Intent.parseUri(URLDecoder.decode(intent.getStringExtra("activity"), "UTF-8"), 1);
                intent2.setAction("android.intent.action.VIEW");
            } else if (intExtra == NotificationAction.intent_with_action.getType()) {
                intent2.setAction(intent.getStringExtra("activity"));
                intent2.setPackage(getPackageName());
                intent2.setFlags(268435456);
            }
            intent2.putExtra(MessageKey.MSG_PUSH_CHANNEL, this.f67740g);
            String decrypt = Rijndael.decrypt(intent.getStringExtra("custom_content"));
            if (!TextUtils.isEmpty(decrypt)) {
                intent2.putExtra("custom_content", decrypt);
            }
            XGPushManager.a((Activity) this);
            if (intent2.resolveActivity(getPackageManager()) != null) {
                startActivity(intent2);
            }
            finish();
        } catch (Throwable th2) {
            TLogger.e("InnerTpnsActivity", "openIntent error.", th2);
        }
    }

    /* access modifiers changed from: private */
    public void g(Intent intent) {
        XGPushManager.a(getApplicationContext(), intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034 A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getMsgIdWithIntent(android.content.Intent r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0005
            return r0
        L_0x0005:
            android.os.Bundle r2 = r6.getExtras()     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = "msgId"
            if (r2 == 0) goto L_0x0029
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0029
            boolean r4 = r2 instanceof java.lang.String     // Catch:{ all -> 0x0043 }
            if (r4 == 0) goto L_0x001e
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0043 }
            long r4 = java.lang.Long.parseLong(r2)     // Catch:{ all -> 0x0043 }
            goto L_0x002a
        L_0x001e:
            boolean r4 = r2 instanceof java.lang.Long     // Catch:{ all -> 0x0043 }
            if (r4 == 0) goto L_0x0029
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0043 }
            long r4 = r2.longValue()     // Catch:{ all -> 0x0043 }
            goto L_0x002a
        L_0x0029:
            r4 = r0
        L_0x002a:
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x0042
            android.net.Uri r6 = r6.getData()     // Catch:{ all -> 0x0043 }
            if (r6 == 0) goto L_0x0042
            java.lang.String r6 = r6.getQueryParameter(r3)     // Catch:{ all -> 0x0043 }
            boolean r2 = com.tencent.android.tpush.common.j.b((java.lang.String) r6)     // Catch:{ all -> 0x0043 }
            if (r2 != 0) goto L_0x0042
            long r4 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x0043 }
        L_0x0042:
            return r4
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.InnerTpnsActivity.getMsgIdWithIntent(android.content.Intent):long");
    }

    public static boolean isMonitorActivityNames(String str) {
        if (f67735b != null && !j.b(str) && f67735b.contains(str)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0012 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069 A[Catch:{ all -> 0x00d3, all -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cf A[Catch:{ all -> 0x00d3, all -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002e A[SYNTHETIC, Splitter:B:9:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            java.lang.String r0 = "InnerTpnsActivity"
            super.onCreate(r6)
            boolean r6 = com.tencent.android.tpush.XGPushConfig.enableActivityWindowSecFlag     // Catch:{ all -> 0x0012 }
            if (r6 == 0) goto L_0x0012
            android.view.Window r6 = r5.getWindow()     // Catch:{ all -> 0x0012 }
            r1 = 8192(0x2000, float:1.14794E-41)
            r6.setFlags(r1, r1)     // Catch:{ all -> 0x0012 }
        L_0x0012:
            android.content.Intent r6 = r5.getIntent()     // Catch:{ all -> 0x00d3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d3 }
            r1.<init>()     // Catch:{ all -> 0x00d3 }
            java.lang.String r2 = "InnerTpnsActivity receiver intent:"
            r1.append(r2)     // Catch:{ all -> 0x00d3 }
            r1.append(r6)     // Catch:{ all -> 0x00d3 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d3 }
            com.tencent.android.tpush.logging.TLogger.i(r0, r1)     // Catch:{ all -> 0x00d3 }
            java.lang.String r1 = "pushChannel"
            if (r6 == 0) goto L_0x0063
            android.os.Bundle r2 = r6.getExtras()     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x0063
            android.os.Bundle r2 = r6.getExtras()     // Catch:{ all -> 0x00d3 }
            boolean r3 = r2.containsKey(r1)     // Catch:{ all -> 0x00d3 }
            if (r3 == 0) goto L_0x0063
            java.lang.Object r3 = r2.get(r1)     // Catch:{ all -> 0x00d3 }
            boolean r3 = r3 instanceof java.lang.String     // Catch:{ all -> 0x00d3 }
            if (r3 == 0) goto L_0x0063
            java.lang.String r2 = r2.getString(r1)     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x0063
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00d3 }
            if (r3 != 0) goto L_0x0063
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00d3 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x00d3 }
            r5.f67740g = r2     // Catch:{ all -> 0x00d3 }
            r3 = 101(0x65, float:1.42E-43)
            if (r2 != r3) goto L_0x0063
            r5.b((android.content.Intent) r6)     // Catch:{ all -> 0x00d3 }
        L_0x0063:
            boolean r2 = r5.a((android.content.Intent) r6)     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x00cf
            r2 = 100
            int r1 = r6.getIntExtra(r1, r2)     // Catch:{ all -> 0x00d3 }
            r5.f67740g = r1     // Catch:{ all -> 0x00d3 }
            java.lang.String r1 = "notifaction_id"
            r2 = 0
            int r1 = r6.getIntExtra(r1, r2)     // Catch:{ all -> 0x00d3 }
            java.lang.String r3 = "isButtonClickInCustomLayout"
            boolean r3 = r6.getBooleanExtra(r3, r2)     // Catch:{ all -> 0x00d3 }
            if (r3 == 0) goto L_0x0087
            android.content.Context r3 = r5.getApplicationContext()     // Catch:{ all -> 0x00d3 }
            com.tencent.android.tpush.XGPushManager.cancelNotifaction(r3, r1)     // Catch:{ all -> 0x00d3 }
        L_0x0087:
            java.lang.String r1 = "action_type"
            com.tencent.android.tpush.NotificationAction r3 = com.tencent.android.tpush.NotificationAction.activity     // Catch:{ all -> 0x00d3 }
            int r4 = r3.getType()     // Catch:{ all -> 0x00d3 }
            int r1 = r6.getIntExtra(r1, r4)     // Catch:{ all -> 0x00d3 }
            int r3 = r3.getType()     // Catch:{ all -> 0x00d3 }
            if (r1 != r3) goto L_0x009d
            r5.d((android.content.Intent) r6)     // Catch:{ all -> 0x00d3 }
            goto L_0x00dc
        L_0x009d:
            com.tencent.android.tpush.NotificationAction r3 = com.tencent.android.tpush.NotificationAction.action_package     // Catch:{ all -> 0x00d3 }
            int r3 = r3.getType()     // Catch:{ all -> 0x00d3 }
            if (r1 != r3) goto L_0x00a9
            r5.e(r6)     // Catch:{ all -> 0x00d3 }
            goto L_0x00dc
        L_0x00a9:
            com.tencent.android.tpush.NotificationAction r3 = com.tencent.android.tpush.NotificationAction.url     // Catch:{ all -> 0x00d3 }
            int r3 = r3.getType()     // Catch:{ all -> 0x00d3 }
            if (r1 != r3) goto L_0x00b5
            r5.b((int) r2, (android.content.Intent) r6)     // Catch:{ all -> 0x00d3 }
            goto L_0x00dc
        L_0x00b5:
            com.tencent.android.tpush.NotificationAction r2 = com.tencent.android.tpush.NotificationAction.intent     // Catch:{ all -> 0x00d3 }
            int r2 = r2.getType()     // Catch:{ all -> 0x00d3 }
            if (r1 == r2) goto L_0x00ca
            com.tencent.android.tpush.NotificationAction r2 = com.tencent.android.tpush.NotificationAction.intent_with_action     // Catch:{ all -> 0x00d3 }
            int r2 = r2.getType()     // Catch:{ all -> 0x00d3 }
            if (r1 != r2) goto L_0x00c6
            goto L_0x00ca
        L_0x00c6:
            r5.finish()     // Catch:{ all -> 0x00d3 }
            goto L_0x00dc
        L_0x00ca:
            r1 = 1
            r5.b((int) r1, (android.content.Intent) r6)     // Catch:{ all -> 0x00d3 }
            goto L_0x00dc
        L_0x00cf:
            r5.c((android.content.Intent) r6)     // Catch:{ all -> 0x00d3 }
            goto L_0x00dc
        L_0x00d3:
            r6 = move-exception
            java.lang.String r1 = "warning"
            com.tencent.android.tpush.logging.TLogger.ww(r0, r1, r6)
            r5.finish()     // Catch:{ all -> 0x00dc }
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.InnerTpnsActivity.onCreate(android.os.Bundle):void");
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    private void b(Intent intent) {
        final Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
        }
        String stringExtra = intent.getStringExtra("checkCode");
        String md5 = Md5.md5(intent.getStringExtra("msgId"));
        if (md5 == null || !stringExtra.equals(md5)) {
            finish();
        } else {
            String string = extras.getString("content");
            TLogger.ii("InnerTpnsActivity", "fcmChannelDeepLink content ：" + string);
            if (string != null && !TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    JSONObject optJSONObject = jSONObject.optJSONObject("action");
                    int optInt = optJSONObject.optInt("action_type", 0);
                    String optString = optJSONObject.optString("activity");
                    String optString2 = optJSONObject.optJSONObject(c.f30298c).optString("url");
                    String optString3 = optJSONObject.optString(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                    String optString4 = jSONObject.optString("custom_content");
                    final XGPushClickedResult xGPushClickedResult = new XGPushClickedResult();
                    if (optInt != 1) {
                        if (optInt != 2) {
                            if (optInt == 3) {
                                if (optString3 != null && !TextUtils.isEmpty(optString3)) {
                                    xGPushClickedResult.activityName = optString3;
                                    c(optString3);
                                }
                            }
                        } else if (optString2 != null && !TextUtils.isEmpty(optString2)) {
                            xGPushClickedResult.activityName = optString2;
                            b(optString2);
                        }
                    } else if (optString == null || TextUtils.isEmpty(optString)) {
                        xGPushClickedResult.activityName = optString;
                        a();
                    } else {
                        xGPushClickedResult.activityName = optString;
                        a(optString);
                    }
                    xGPushClickedResult.notificationActionType = optInt;
                    xGPushClickedResult.customContent = optString4;
                    CommonWorkingThread.getInstance().execute(new TTask() {
                        public void TRun() {
                            if (j.a(InnerTpnsActivity.this.getApplicationContext()) > 0) {
                                TLogger.e("InnerTpnsActivity", "fcmChannelDeepLink initGlobal failed");
                            }
                            InnerTpnsActivity.this.a(extras, xGPushClickedResult);
                        }
                    });
                } catch (Throwable th2) {
                    TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity fcmChannelDeepLink e:" + th2);
                }
            }
        }
        finish();
    }

    private boolean a(Intent intent) {
        if (intent == null || !intent.hasExtra(MessageKey.MSG_PORTECT_TAG)) {
            return false;
        }
        String stringExtra = intent.getStringExtra(MessageKey.MSG_PORTECT_TAG);
        if (j.b(stringExtra)) {
            return false;
        }
        try {
            Long valueOf = Long.valueOf(Rijndael.decrypt(stringExtra));
            if (valueOf.longValue() <= 0 || System.currentTimeMillis() < valueOf.longValue()) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void a(Bundle bundle, XGPushClickedResult xGPushClickedResult) {
        String str;
        String str2;
        long j11;
        Bundle bundle2 = bundle;
        XGPushClickedResult xGPushClickedResult2 = xGPushClickedResult;
        try {
            String string = bundle2.getString("groupId");
            String string2 = bundle2.getString(AuthHandler.EXTRA_TOKEN_SECRET);
            String string3 = bundle2.getString(MessageKey.MSG_TARGET_TYPE);
            String string4 = bundle2.getString(MessageKey.MSG_BUSI_MSG_ID);
            String string5 = bundle2.getString("msgId");
            String string6 = bundle2.getString(MessageKey.MSG_PUSH_TIME);
            String string7 = bundle2.getString("source");
            String string8 = bundle2.getString("type");
            String string9 = bundle2.getString(MessageKey.MSG_PUSH_CHANNEL);
            String string10 = bundle2.getString(MessageKey.MSG_TEMPLATE_ID);
            String string11 = bundle2.getString(MessageKey.MSG_TRACE_ID);
            try {
                Intent intent = new Intent();
                long j12 = 0;
                if (string4 != null) {
                    long longValue = Long.valueOf(f67738e).longValue();
                    str2 = MessageKey.MSG_TRACE_ID;
                    long j13 = longValue;
                    str = MessageKey.MSG_TEMPLATE_ID;
                    j11 = j13;
                } else {
                    str2 = MessageKey.MSG_TRACE_ID;
                    str = MessageKey.MSG_TEMPLATE_ID;
                    j11 = 0;
                }
                intent.putExtra(MessageKey.MSG_BUSI_MSG_ID, j11);
                intent.putExtra("msgId", string5 != null ? Long.valueOf(string5).longValue() : 0);
                intent.putExtra("type", string8 != null ? Long.valueOf(string8).longValue() : 1);
                intent.putExtra("groupId", string);
                int i11 = 101;
                intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, string9 != null ? Integer.valueOf(string9).intValue() : 101);
                intent.putExtra(MessageKey.MSG_TARGET_TYPE, string3 != null ? Long.valueOf(string3).longValue() : 0);
                intent.putExtra(MessageKey.MSG_PUSH_TIME, string6 != null ? Long.valueOf(string6).longValue() * 1000 : 0);
                intent.putExtra("source", string7 != null ? Long.valueOf(string7).longValue() : 0);
                intent.putExtra(MessageKey.MSG_CREATE_TIMESTAMPS, string2 != null ? Long.valueOf(string2).longValue() * 1000 : 0);
                String str3 = str;
                intent.putExtra(str3, string10);
                String str4 = str2;
                intent.putExtra(str4, string11);
                Intent intent2 = intent;
                g(intent2);
                Intent intent3 = new Intent(Constants.ACTION_FEEDBACK);
                intent3.setPackage(getApplicationContext().getPackageName());
                intent3.putExtra(Constants.FEEDBACK_TAG, 4);
                intent3.putExtra(Constants.FEEDBACK_ERROR_CODE, 0);
                if (string9 != null) {
                    i11 = Integer.valueOf(string9).intValue();
                }
                intent3.putExtra(Constants.PUSH_CHANNEL, i11);
                intent3.putExtra("action", NotificationAction.clicked.getType());
                String str5 = string10;
                XGPushClickedResult xGPushClickedResult3 = xGPushClickedResult;
                int i12 = xGPushClickedResult3.notificationActionType;
                if (i12 == 0) {
                    i12 = NotificationAction.activity.getType();
                }
                intent3.putExtra("notificationActionType", i12);
                intent3.putExtra("custom_content", xGPushClickedResult3.customContent);
                if (string5 != null) {
                    j12 = Long.valueOf(string5).longValue();
                }
                intent3.putExtra("msgId", j12);
                intent3.putExtra(str3, str5);
                intent3.putExtra(str4, string11);
                String str6 = xGPushClickedResult3.activityName;
                if (str6 != null) {
                    if (!TextUtils.isEmpty(str6)) {
                        intent3.putExtra("activity", xGPushClickedResult3.activityName);
                        BroadcastAgent.sendBroadcast(getApplicationContext(), intent3);
                    }
                }
                String a11 = a((Context) this);
                this.f67739f = a11;
                intent3.putExtra("activity", a11);
                BroadcastAgent.sendBroadcast(getApplicationContext(), intent3);
            } catch (Throwable th2) {
                th = th2;
                TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity reportAndFeekbackFcmChannelDeepLink e:" + th);
            }
        } catch (Throwable th3) {
            th = th3;
            TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity reportAndFeekbackFcmChannelDeepLink e:" + th);
        }
    }

    private ResolveInfo d(String str) {
        try {
            PackageManager packageManager = getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(getPackageName());
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            Collections.sort(queryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
            for (ResolveInfo next : queryIntentActivities) {
                ActivityInfo activityInfo = next.activityInfo;
                String str2 = activityInfo.name;
                if (activityInfo.packageName.equals(str)) {
                    return next;
                }
            }
        } catch (Throwable th2) {
            TLogger.e("InnerTpnsActivity", "查找主Activity出错", th2);
        }
        return null;
    }

    private void c(String str) {
        try {
            new Intent();
            TLogger.i("InnerTpnsActivity", "InnerTpnsActivity receiver jumpOtherChannelIntent targetActivity:" + str);
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.setAction("android.intent.action.VIEW");
            parseUri.putExtra(MessageKey.MSG_PUSH_CHANNEL, this.f67740g);
            if (parseUri.resolveActivity(getPackageManager()) != null) {
                startActivity(parseUri);
            }
        } catch (Throwable th2) {
            TLogger.e("InnerTpnsActivity", "jumpOtherChannelIntent error: ", th2);
        }
    }

    private void b(String str) {
        try {
            TLogger.i("InnerTpnsActivity", "InnerTpnsActivity receiver jumpOtherChannelUrl targetActivity :" + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, this.f67740g);
            startActivity(intent);
        } catch (Throwable th2) {
            TLogger.e("InnerTpnsActivity", "openUrl error: ", th2);
        }
    }

    private void b(int i11, final Intent intent) {
        if (i11 == 0) {
            final String stringExtra = intent.getStringExtra("activity");
            if (intent.getIntExtra(Constants.FLAG_ACTION_CONFIRM, 0) == 1) {
                AlertDialog.Builder cancelable = new AlertDialog.Builder(this).setTitle("提示").setCancelable(false);
                cancelable.setMessage("是否打开网站:" + stringExtra + "?").setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        InnerTpnsActivity.this.a(stringExtra, intent);
                        InnerTpnsActivity.this.finish();
                        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        InnerTpnsActivity.this.g(intent);
                        dialogInterface.cancel();
                        InnerTpnsActivity.this.finish();
                        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                    }
                }).show();
                return;
            }
            a(stringExtra, intent);
        } else if (i11 != 1) {
        } else {
            if (intent.getIntExtra(Constants.FLAG_ACTION_CONFIRM, 0) == 1) {
                new AlertDialog.Builder(this).setTitle("提示").setCancelable(false).setMessage("继续打开Intent?").setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        InnerTpnsActivity.this.f(intent);
                        InnerTpnsActivity.this.finish();
                        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        InnerTpnsActivity.this.g(intent);
                        dialogInterface.cancel();
                        InnerTpnsActivity.this.finish();
                        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                    }
                }).show();
            } else {
                f(intent);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Uri uri) {
        String str;
        String queryParameter;
        String str2;
        String queryParameter2;
        String str3;
        String str4;
        long j11;
        long j12;
        String str5;
        Uri uri2 = uri;
        try {
            String queryParameter3 = uri2.getQueryParameter("jumpType");
            String queryParameter4 = uri2.getQueryParameter(MessageKey.MSG_BUSI_MSG_ID);
            String queryParameter5 = uri2.getQueryParameter("msgId");
            String queryParameter6 = uri2.getQueryParameter("msgType");
            String str6 = "InnerTpnsActivity";
            try {
                queryParameter = uri2.getQueryParameter("groupId");
                str2 = queryParameter3;
                queryParameter2 = uri2.getQueryParameter(MessageKey.MSG_PUSH_CHANNEL);
            } catch (Throwable th2) {
                th = th2;
                str = str6;
                TLogger.ii(str, "InnerTpnsActivity reportOtherChannelDeepLink exception:" + th);
            }
            try {
                String queryParameter7 = uri2.getQueryParameter(MessageKey.MSG_TARGET_TYPE);
                String str7 = MessageKey.MSG_TRACE_ID;
                String queryParameter8 = uri2.getQueryParameter(MessageKey.MSG_PUSH_TIME);
                String str8 = MessageKey.MSG_TEMPLATE_ID;
                String queryParameter9 = uri2.getQueryParameter("source");
                String str9 = "source";
                String queryParameter10 = uri2.getQueryParameter("timestamp");
                String queryParameter11 = uri2.getQueryParameter("customContent");
                String queryParameter12 = uri2.getQueryParameter("targetActivity");
                String queryParameter13 = uri2.getQueryParameter("tmpl");
                String queryParameter14 = uri2.getQueryParameter(n0.f30437i);
                Intent intent = new Intent();
                long j13 = 0;
                if (queryParameter4 != null) {
                    str4 = queryParameter8;
                    str3 = queryParameter9;
                    j11 = Long.valueOf(queryParameter4).longValue();
                } else {
                    str4 = queryParameter8;
                    str3 = queryParameter9;
                    j11 = 0;
                }
                intent.putExtra(MessageKey.MSG_BUSI_MSG_ID, j11);
                intent.putExtra("msgId", queryParameter5 != null ? Long.valueOf(queryParameter5).longValue() : 0);
                String str10 = queryParameter5;
                String str11 = queryParameter6;
                intent.putExtra("type", queryParameter6 != null ? Long.valueOf(queryParameter6).longValue() : 1);
                intent.putExtra("groupId", queryParameter);
                int i11 = 0;
                intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, queryParameter2 != null ? Integer.valueOf(queryParameter2).intValue() : 0);
                intent.putExtra(MessageKey.MSG_TARGET_TYPE, queryParameter7 != null ? Long.valueOf(queryParameter7).longValue() : 0);
                intent.putExtra(MessageKey.MSG_PUSH_TIME, str4 != null ? Long.valueOf(str4).longValue() * 1000 : 0);
                if (str3 != null) {
                    j12 = Long.valueOf(str3).longValue();
                    str5 = str9;
                } else {
                    str5 = str9;
                    j12 = 0;
                }
                intent.putExtra(str5, j12);
                intent.putExtra(MessageKey.MSG_CREATE_TIMESTAMPS, queryParameter10 != null ? Long.valueOf(queryParameter10).longValue() * 1000 : 0);
                String str12 = str8;
                String str13 = queryParameter13;
                intent.putExtra(str12, str13);
                String str14 = str7;
                intent.putExtra(str14, queryParameter14);
                String str15 = queryParameter7;
                g(intent);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("InnerTpnsActivity receiver params : msgBuildId ");
                sb2.append(queryParameter4);
                sb2.append(" , msgId = ");
                sb2.append(str10);
                sb2.append(" , jumpType = ");
                String str16 = str2;
                sb2.append(str16);
                sb2.append(" , msgType = ");
                sb2.append(str11);
                sb2.append(" , groupId = ");
                sb2.append(queryParameter);
                sb2.append(" , pushChannel = ");
                sb2.append(queryParameter2);
                sb2.append(" , targetType = ");
                sb2.append(str15);
                sb2.append(" , pushTime = ");
                sb2.append(str4);
                sb2.append(" , source = ");
                sb2.append(str3);
                sb2.append(" , timestamp = ");
                sb2.append(queryParameter10);
                sb2.append(" , templateId = ");
                sb2.append(str13);
                sb2.append(" , traceId = ");
                sb2.append(queryParameter14);
                str = str6;
                try {
                    TLogger.i(str, sb2.toString());
                    Intent intent2 = new Intent(Constants.ACTION_FEEDBACK);
                    intent2.setPackage(getApplicationContext().getPackageName());
                    intent2.putExtra(Constants.FEEDBACK_TAG, 4);
                    intent2.putExtra(Constants.FEEDBACK_ERROR_CODE, 0);
                    if (queryParameter2 != null) {
                        i11 = Integer.valueOf(queryParameter2).intValue();
                    }
                    intent2.putExtra(Constants.PUSH_CHANNEL, i11);
                    intent2.putExtra("action", NotificationAction.clicked.getType());
                    intent2.putExtra("notificationActionType", str16 != null ? Integer.valueOf(str16).intValue() : NotificationAction.activity.getType());
                    intent2.putExtra("custom_content", queryParameter11);
                    if (str10 != null) {
                        j13 = Long.valueOf(str10).longValue();
                    }
                    intent2.putExtra("msgId", j13);
                    intent2.putExtra(str12, str13);
                    intent2.putExtra(str14, queryParameter14);
                    if (queryParameter12 != null) {
                        if (!TextUtils.isEmpty(queryParameter12)) {
                            intent2.putExtra("activity", queryParameter12);
                            BroadcastAgent.sendBroadcast(getApplicationContext(), intent2);
                        }
                    }
                    String a11 = a((Context) this);
                    this.f67739f = a11;
                    intent2.putExtra("activity", a11);
                    BroadcastAgent.sendBroadcast(getApplicationContext(), intent2);
                } catch (Throwable th3) {
                    th = th3;
                    TLogger.ii(str, "InnerTpnsActivity reportOtherChannelDeepLink exception:" + th);
                }
            } catch (Throwable th4) {
                th = th4;
                str = str6;
                TLogger.ii(str, "InnerTpnsActivity reportOtherChannelDeepLink exception:" + th);
            }
        } catch (Throwable th5) {
            th = th5;
            str = "InnerTpnsActivity";
            TLogger.ii(str, "InnerTpnsActivity reportOtherChannelDeepLink exception:" + th);
        }
    }

    private void a(String str) {
        try {
            Intent intent = new Intent();
            TLogger.i("InnerTpnsActivity", "InnerTpnsActivity receiver  jumpOtherChannelActivitys targetActivity = " + str);
            intent.setClassName(getApplicationContext(), str);
            intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, this.f67740g);
            intent.setFlags(603979776);
            startActivity(intent);
        } catch (Throwable th2) {
            TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity receiver jumpOtherChannelActivitys = " + th2);
        }
    }

    private void a() {
        Intent intent = new Intent();
        String str = this.f67739f;
        if (str == null || TextUtils.isEmpty(str)) {
            this.f67739f = a((Context) this);
        }
        TLogger.i("InnerTpnsActivity", "InnerTpnsActivity receiver  jumpOtherChannelActivity targetActivity = " + this.f67739f);
        intent.setClassName(getApplicationContext(), this.f67739f);
        intent.setFlags(603979776);
        intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, this.f67740g);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e11) {
            TLogger.ii("InnerTpnsActivity", "InnerTpnsActivity receiver ActivityNotFoundException = " + e11);
        }
    }

    private static String a(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    return activityInfo.name;
                }
            }
        } catch (Throwable th2) {
            TLogger.e("InnerTpnsActivity", "get Activity error", th2);
        }
        return null;
    }

    public static void a(Application application) {
        if (f67734a == null) {
            f67734a = new Application.ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                public void onActivityDestroyed(Activity activity) {
                }

                public void onActivityPaused(Activity activity) {
                }

                public void onActivityResumed(Activity activity) {
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                }

                public void onActivityStopped(Activity activity) {
                }
            };
            if (application != null) {
                try {
                    ((Application) application.getApplicationContext()).registerActivityLifecycleCallbacks(f67734a);
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void a(int i11, final Intent intent) {
        if (i11 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    intent.putExtra("action", NotificationAction.open_cancel.getType());
                    InnerTpnsActivity.this.g(intent);
                    InnerTpnsActivity.this.finish();
                }
            }).setTitle("提示").setMessage("是否确定打开此应用？").setPositiveButton("打开", new DialogInterface.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(DialogInterface dialogInterface, int i11) {
                    intent.putExtra("action", NotificationAction.open.getType());
                    InnerTpnsActivity.this.g(intent);
                    try {
                        InnerTpnsActivity.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                    }
                    InnerTpnsActivity.this.finish();
                    SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(DialogInterface dialogInterface, int i11) {
                    intent.putExtra("action", NotificationAction.open_cancel.getType());
                    InnerTpnsActivity.this.g(intent);
                    dialogInterface.dismiss();
                    InnerTpnsActivity.this.finish();
                    SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                }
            });
            builder.create().show();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, Intent intent) {
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent2.setFlags(268435456);
            intent2.putExtra(MessageKey.MSG_PUSH_CHANNEL, this.f67740g);
            XGPushManager.a((Activity) this);
            startActivity(intent2);
        } catch (Throwable th2) {
            TLogger.e("InnerTpnsActivity", "openUrl error.", th2);
        }
        finish();
    }
}
