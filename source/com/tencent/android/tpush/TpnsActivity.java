package com.tencent.android.tpush;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.jg.EType;
import com.jg.JgClassChecked;
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
import com.tencent.android.tpush.service.channel.security.d;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.twitter.sdk.android.core.identity.AuthHandler;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.ACTIVITYCHECK, EType.INTENTCHECK, EType.INTENTSCHEMECHECK})
public class TpnsActivity extends Activity {
    public static final String CHECK_CODE = "checkCode";
    public static final String CUSTOM_CONTENT = "customContent";
    public static final String JUMP_type = "jumpType";
    public static final String MSG_TYPE = "msgType";
    public static final String TARGE_ACTIVITY = "targetActivity";
    public static final String TIMESTAMP = "timestamp";

    /* renamed from: a  reason: collision with root package name */
    public static Application.ActivityLifecycleCallbacks f67766a = null;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f67767b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f67768c = "";

    /* renamed from: d  reason: collision with root package name */
    public static long f67769d;

    /* renamed from: e  reason: collision with root package name */
    public static long f67770e;

    /* renamed from: f  reason: collision with root package name */
    private String f67771f = "";

    /* renamed from: g  reason: collision with root package name */
    private int f67772g = 100;

    /* renamed from: h  reason: collision with root package name */
    private RSAPublicKey f67773h = null;

    public static void addActivityNames(String str) {
        if (!j.b(str)) {
            if (f67767b == null) {
                f67767b = new ArrayList();
            }
            if (!f67767b.contains(str)) {
                f67767b.add(str);
            }
        }
    }

    private void b(Intent intent) {
        final Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
        }
        String stringExtra = intent.getStringExtra("checkCode");
        String stringExtra2 = intent.getStringExtra("msgId");
        String stringExtra3 = intent.getStringExtra("c");
        String md5 = Md5.md5(stringExtra2);
        if (md5 == null || !stringExtra.equals(md5)) {
            finish();
        } else {
            String string = extras.getString("content");
            TLogger.ii("TpnsActivity", "fcmChannelDeepLink content ：" + string);
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
                    boolean z11 = true;
                    if (optInt != 1) {
                        if (optInt != 2) {
                            if (optInt != 3) {
                                if (optInt == 5) {
                                    if (!TextUtils.isEmpty(optString3)) {
                                        xGPushClickedResult.activityName = optString3;
                                        Context applicationContext = getApplicationContext();
                                        z11 = a(applicationContext, stringExtra2, "101", optInt + "", optString3, stringExtra3);
                                        if (z11) {
                                            c(optString3, optString4);
                                        }
                                    }
                                }
                            } else if (optString3 != null && !TextUtils.isEmpty(optString3)) {
                                xGPushClickedResult.activityName = optString3;
                                Context applicationContext2 = getApplicationContext();
                                z11 = a(applicationContext2, stringExtra2, "101", optInt + "", optString3, stringExtra3);
                                if (z11) {
                                    b(optString3, optString4);
                                }
                            }
                        } else if (optString2 != null && !TextUtils.isEmpty(optString2)) {
                            xGPushClickedResult.activityName = optString2;
                            Context applicationContext3 = getApplicationContext();
                            z11 = a(applicationContext3, stringExtra2, "101", optInt + "", optString2, stringExtra3);
                            if (z11) {
                                b(optString2);
                            }
                        }
                    } else if (optString == null || TextUtils.isEmpty(optString)) {
                        Context applicationContext4 = getApplicationContext();
                        z11 = a(applicationContext4, stringExtra2, "101", optInt + "", "", stringExtra3);
                        if (z11) {
                            xGPushClickedResult.activityName = optString;
                            a(optString4);
                        }
                    } else {
                        xGPushClickedResult.activityName = optString;
                        Context applicationContext5 = getApplicationContext();
                        z11 = a(applicationContext5, stringExtra2, "101", optInt + "", optString, stringExtra3);
                        if (z11) {
                            a(optString, optString4);
                        }
                    }
                    xGPushClickedResult.notificationActionType = optInt;
                    xGPushClickedResult.customContent = optString4;
                    if (z11) {
                        CommonWorkingThread.getInstance().execute(new TTask() {
                            public void TRun() {
                                if (j.a(TpnsActivity.this.getApplicationContext()) > 0) {
                                    TLogger.e("TpnsActivity", "fcmChannelDeepLink initGlobal failed");
                                }
                                TpnsActivity.this.a(extras, xGPushClickedResult);
                            }
                        });
                    }
                } catch (Throwable th2) {
                    TLogger.ii("TpnsActivity", "TpnsActivity fcmChannelDeepLink e:" + th2);
                }
            }
        }
        finish();
    }

    private void c(Intent intent) {
        if (intent != null) {
            try {
                final Uri data = intent.getData();
                if (data != null) {
                    TLogger.ii("TpnsActivity", "TpnsActivity receiver otherChannelDeepLink url:" + data.toString());
                    String queryParameter = data.getQueryParameter("msgId");
                    String queryParameter2 = data.getQueryParameter("checkCode");
                    String queryParameter3 = data.getQueryParameter(MessageKey.MSG_PUSH_CHANNEL);
                    String queryParameter4 = data.getQueryParameter("c");
                    String queryParameter5 = data.getQueryParameter("customContent");
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        this.f67772g = Integer.parseInt(queryParameter3);
                    }
                    if (queryParameter != null && !TextUtils.isEmpty(queryParameter) && queryParameter2 != null && !TextUtils.isEmpty(queryParameter2)) {
                        Md5.md5(queryParameter);
                        String queryParameter6 = data.getQueryParameter("jumpType");
                        String queryParameter7 = data.getQueryParameter("targetActivity");
                        if (a(getApplicationContext(), queryParameter, this.f67772g + "", queryParameter6 + "", queryParameter7, queryParameter4)) {
                            if (!(queryParameter6 == null || queryParameter7 == null)) {
                                if (!TextUtils.isEmpty(queryParameter7)) {
                                    if (queryParameter7.length() > 0) {
                                        if (queryParameter6.equals("0")) {
                                            a(queryParameter5);
                                        } else if (queryParameter6.equals("1")) {
                                            a(queryParameter7, queryParameter5);
                                        } else if (queryParameter6.equals("2")) {
                                            b(queryParameter7);
                                        } else if (queryParameter6.equals("3")) {
                                            b(queryParameter7, queryParameter5);
                                        }
                                    }
                                    CommonWorkingThread.getInstance().execute(new TTask() {
                                        public void TRun() {
                                            if (j.a(TpnsActivity.this.getApplicationContext()) > 0) {
                                                TLogger.e("TpnsActivity", "otherChannelDeepLink initGlobal failed");
                                            }
                                            TpnsActivity.this.a(data);
                                        }
                                    });
                                }
                            }
                            TLogger.i("TpnsActivity", "TpnsActivity receiver jumpType == null || targetIntent == null");
                            a(queryParameter5);
                            CommonWorkingThread.getInstance().execute(new TTask() {
                                public void TRun() {
                                    if (j.a(TpnsActivity.this.getApplicationContext()) > 0) {
                                        TLogger.e("TpnsActivity", "otherChannelDeepLink initGlobal failed");
                                    }
                                    TpnsActivity.this.a(data);
                                }
                            });
                        } else {
                            TLogger.w("TpnsActivity", "checkValidRequest failed");
                        }
                    }
                }
            } catch (Throwable th2) {
                TLogger.ii("TpnsActivity", "TpnsActivity receiver e:" + th2);
                finish();
                return;
            }
        }
        finish();
    }

    private void d(Intent intent) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.TpnsActivity.getMsgIdWithIntent(android.content.Intent):long");
    }

    public static boolean isMonitorActivityNames(String str) {
        if (f67767b != null && !j.b(str) && f67767b.contains(str)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0012 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069 A[Catch:{ all -> 0x0079, all -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0075 A[Catch:{ all -> 0x0079, all -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002e A[SYNTHETIC, Splitter:B:9:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            java.lang.String r0 = "TpnsActivity"
            super.onCreate(r5)
            boolean r5 = com.tencent.android.tpush.XGPushConfig.enableActivityWindowSecFlag     // Catch:{ all -> 0x0012 }
            if (r5 == 0) goto L_0x0012
            android.view.Window r5 = r4.getWindow()     // Catch:{ all -> 0x0012 }
            r1 = 8192(0x2000, float:1.14794E-41)
            r5.setFlags(r1, r1)     // Catch:{ all -> 0x0012 }
        L_0x0012:
            android.content.Intent r5 = r4.getIntent()     // Catch:{ all -> 0x0079 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r1.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = "TpnsActivity receiver intent:"
            r1.append(r2)     // Catch:{ all -> 0x0079 }
            r1.append(r5)     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0079 }
            com.tencent.android.tpush.logging.TLogger.i(r0, r1)     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = "pushChannel"
            if (r5 == 0) goto L_0x0063
            android.os.Bundle r2 = r5.getExtras()     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x0063
            android.os.Bundle r2 = r5.getExtras()     // Catch:{ all -> 0x0079 }
            boolean r3 = r2.containsKey(r1)     // Catch:{ all -> 0x0079 }
            if (r3 == 0) goto L_0x0063
            java.lang.Object r3 = r2.get(r1)     // Catch:{ all -> 0x0079 }
            boolean r3 = r3 instanceof java.lang.String     // Catch:{ all -> 0x0079 }
            if (r3 == 0) goto L_0x0063
            java.lang.String r2 = r2.getString(r1)     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x0063
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0079 }
            if (r3 != 0) goto L_0x0063
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0079 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0079 }
            r4.f67772g = r2     // Catch:{ all -> 0x0079 }
            r3 = 101(0x65, float:1.42E-43)
            if (r2 != r3) goto L_0x0063
            r4.b((android.content.Intent) r5)     // Catch:{ all -> 0x0079 }
        L_0x0063:
            boolean r2 = r4.a((android.content.Intent) r5)     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x0075
            r2 = 100
            int r5 = r5.getIntExtra(r1, r2)     // Catch:{ all -> 0x0079 }
            r4.f67772g = r5     // Catch:{ all -> 0x0079 }
            r4.finish()     // Catch:{ all -> 0x0079 }
            goto L_0x0082
        L_0x0075:
            r4.c(r5)     // Catch:{ all -> 0x0079 }
            goto L_0x0082
        L_0x0079:
            r5 = move-exception
            java.lang.String r1 = "warning"
            com.tencent.android.tpush.logging.TLogger.ww(r0, r1, r5)
            r4.finish()     // Catch:{ all -> 0x0082 }
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.TpnsActivity.onCreate(android.os.Bundle):void");
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
                    long longValue = Long.valueOf(f67770e).longValue();
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
                d(intent2);
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
                this.f67771f = a11;
                intent3.putExtra("activity", a11);
                BroadcastAgent.sendBroadcast(getApplicationContext(), intent3);
            } catch (Throwable th2) {
                th = th2;
                TLogger.ii("TpnsActivity", "TpnsActivity reportAndFeekbackFcmChannelDeepLink e:" + th);
            }
        } catch (Throwable th3) {
            th = th3;
            TLogger.ii("TpnsActivity", "TpnsActivity reportAndFeekbackFcmChannelDeepLink e:" + th);
        }
    }

    private void c(String str, String str2) {
        try {
            Intent intent = new Intent();
            TLogger.i("TpnsActivity", "InnerTpnsActivity receiver jumpOtherChannelIntentAction targetActivity:" + str);
            intent.setAction(str);
            intent.setPackage(getPackageName());
            intent.setFlags(268435456);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("custom_content", str2);
            }
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            finish();
        } catch (Throwable th2) {
            TLogger.e("TpnsActivity", "jumpOtherChannelIntentAction error: ", th2);
        }
    }

    private void b(String str) {
        try {
            TLogger.i("TpnsActivity", "TpnsActivity receiver jumpOtherChannelUrl targetActivity :" + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, this.f67772g);
            startActivity(intent);
        } catch (Throwable th2) {
            TLogger.e("TpnsActivity", "openUrl error.", th2);
        }
    }

    private void b(String str, String str2) {
        try {
            Intent intent = new Intent();
            TLogger.i("TpnsActivity", "TpnsActivity receiver jumpOtherChannelIntent targetActivity:" + str);
            Class<?> cls = Class.forName("android.content.Intent");
            Object invoke = cls.getDeclaredMethod(new String(Base64.decode("cGFyc2VVcmk=", 0), "UTF-8"), new Class[]{String.class, Integer.TYPE}).invoke(cls, new Object[]{str, 1});
            if (invoke != null) {
                intent = (Intent) invoke;
            }
            intent.setAction("android.intent.action.VIEW");
            intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, this.f67772g);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("custom_content", str2);
            }
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } catch (Throwable th2) {
            TLogger.e("TpnsActivity", "jumpOtherChannelIntent error.", th2);
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
            String str6 = "TpnsActivity";
            try {
                queryParameter = uri2.getQueryParameter("groupId");
                str2 = queryParameter3;
                queryParameter2 = uri2.getQueryParameter(MessageKey.MSG_PUSH_CHANNEL);
            } catch (Throwable th2) {
                th = th2;
                str = str6;
                TLogger.ii(str, "TpnsActivity reportOtherChannelDeepLink exception:" + th);
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
                d(intent);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("TpnsActivity receiver params : msgBuildId ");
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
                    this.f67771f = a11;
                    intent2.putExtra("activity", a11);
                    BroadcastAgent.sendBroadcast(getApplicationContext(), intent2);
                } catch (Throwable th3) {
                    th = th3;
                    TLogger.ii(str, "TpnsActivity reportOtherChannelDeepLink exception:" + th);
                }
            } catch (Throwable th4) {
                th = th4;
                str = str6;
                TLogger.ii(str, "TpnsActivity reportOtherChannelDeepLink exception:" + th);
            }
        } catch (Throwable th5) {
            th = th5;
            str = "TpnsActivity";
            TLogger.ii(str, "TpnsActivity reportOtherChannelDeepLink exception:" + th);
        }
    }

    private void a(String str, String str2) {
        try {
            Intent intent = new Intent();
            TLogger.i("TpnsActivity", "TpnsActivity receiver  jumpOtherChannelActivitys targetActivity = " + str);
            intent.setClassName(getApplicationContext(), str);
            intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, this.f67772g);
            intent.setFlags(603979776);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("custom_content", str2);
            }
            startActivity(intent);
        } catch (Throwable th2) {
            TLogger.ii("TpnsActivity", "TpnsActivity receiver jumpOtherChannelActivitys = " + th2);
        }
    }

    private void a(String str) {
        Intent intent = new Intent();
        String str2 = this.f67771f;
        if (str2 == null || TextUtils.isEmpty(str2)) {
            this.f67771f = a((Context) this);
        }
        TLogger.i("TpnsActivity", "TpnsActivity receiver  jumpOtherChannelActivity targetActivity = " + this.f67771f);
        intent.setClassName(getApplicationContext(), this.f67771f);
        intent.setFlags(603979776);
        intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, this.f67772g);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("custom_content", str);
        }
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e11) {
            TLogger.ii("TpnsActivity", "TpnsActivity receiver ActivityNotFoundException = " + e11);
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
            TLogger.e("TpnsActivity", "get Activity error", th2);
        }
        return null;
    }

    private boolean a(Context context, String str, String str2, String str3, String str4, String str5) {
        String str6;
        String str7;
        Context context2 = context;
        String str8 = str;
        String str9 = str2;
        String str10 = str3;
        String str11 = str5;
        String str12 = "";
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("msgid:");
            sb2.append(str8);
            sb2.append("pushChannel:");
            sb2.append(str9);
            sb2.append("jumptype:");
            sb2.append(str10);
            sb2.append("target:");
            String str13 = str4;
            sb2.append(str13);
            sb2.append("checksum:");
            sb2.append(str11);
            sb2.append(str12);
            TLogger.d("TpnsActivity", sb2.toString());
            if (TextUtils.isEmpty(str5)) {
                TLogger.w("TpnsActivity", "checksum was null");
                a(context2, str8, ErrCode.CHECK_CLICK_RESULT_ERROR_CHECK_SUM_NULL, "checksum was null");
                return false;
            } else if (TextUtils.isEmpty(str)) {
                TLogger.w("TpnsActivity", "msgid was null");
                return false;
            } else {
                if (this.f67773h == null) {
                    this.f67773h = d.a("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMw0HSS1vXYrOeuXPEIKiJpe4xY9flsHmWb21O34FZVBwXnrKtDWgPQY+uV48ZJ6bVzaySwNrAa/eJo1HrOgVk8CAwEAAQ==");
                }
                str6 = d.a(Base64.decode(str11, 0), this.f67773h);
                TLogger.d("TpnsActivity", "decryptChecksum:" + str6);
                if (str6 != null) {
                    if (!TextUtils.isEmpty(str6)) {
                        int length = str6.length();
                        int i11 = length - 1;
                        int parseInt = Integer.parseInt(str6.substring(i11, length));
                        TLogger.w("TpnsActivity", "pushType:" + parseInt);
                        if (parseInt == 1) {
                            str7 = XGPushConfig.getToken(context);
                        } else if (parseInt == 2) {
                            str7 = context.getPackageName();
                        } else {
                            TLogger.w("TpnsActivity", "invalid pushType: " + parseInt);
                            a(context2, str8, ErrCode.CHECK_CLICK_RESULT_ERROR_CHECK_SUM_INVALID_PUSH_TYPE, "invalid pushType: " + parseInt);
                            return false;
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            str12 = str13;
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            if (str6.length() >= 2) {
                                String substring = str6.substring(0, i11);
                                String md5 = Md5.md5(str8 + str9 + str7 + str10 + str12);
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("decryptChecksum:");
                                sb3.append(substring);
                                sb3.append(" , md5Str:");
                                sb3.append(md5);
                                TLogger.d("TpnsActivity", sb3.toString());
                                if (substring.equalsIgnoreCase(md5)) {
                                    return true;
                                }
                                TLogger.w("TpnsActivity", "decryptChecksum was invalid");
                                a(context2, str8, ErrCode.CHECK_CLICK_RESULT_ERROR_CHECK_SUM_MISMATCH, "decryptChecksum mismatch");
                                return false;
                            }
                        }
                        TLogger.w("TpnsActivity", "decryptChecksum was invalid:" + str6);
                        a(context2, str8, ErrCode.CHECK_CLICK_RESULT_ERROR_CHECK_SUM_DECRYPT_FAILED, "decryptChecksum was null");
                        return false;
                    }
                }
                TLogger.w("TpnsActivity", "decryptChecksum was null");
                return false;
            }
        } catch (Exception e11) {
            TLogger.e("TpnsActivity", "checkValidRequest decrypt failed, err:" + e11.toString());
            a(context2, str8, ErrCode.CHECK_CLICK_RESULT_ERROR_CHECK_SUM_DECRYPT_FAILED, "decryptChecksum failed " + e11.toString());
            str6 = str12;
        } catch (Throwable th2) {
            TLogger.e("TpnsActivity", "checkValidRequest failed, err:" + th2);
            a(context2, str8, ErrCode.CHECK_CLICK_RESULT_ERROR_OTHER, "decryptChecksum other error: " + th2.toString());
            return false;
        }
    }

    private void a(Context context, String str, int i11, String str2) {
        final Context context2 = context;
        final int i12 = i11;
        final String str3 = str2;
        final String str4 = str;
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                if (j.a(TpnsActivity.this.getApplicationContext()) > 0) {
                    TLogger.e("TpnsActivity", "otherChannelDeepLink initGlobal failed");
                }
                ServiceStat.reportErrCode(context2, i12, str3, Long.parseLong(str4), ErrCode.ERROR_INNER_TYPE);
            }
        });
    }
}
