package com.tencent.android.tpush.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.protocol.m;
import com.tencent.android.tpush.service.protocol.n;
import com.tencent.android.tpush.service.protocol.r;
import com.tencent.android.tpush.service.util.g;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CacheHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttConfig;
import com.tencent.tpns.mqttchannel.api.MqttConnectState;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.INTENTCHECK})
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f69505a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile C0753a f69506b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f69507c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile d f69508d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f69509e = false;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Intent> f69510f = new ArrayList<>();

    /* renamed from: com.tencent.android.tpush.service.a$1  reason: invalid class name */
    public class AnonymousClass1 extends TTask {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f69511a;

        public void TRun() {
            j.f(this.f69511a);
        }
    }

    /* renamed from: com.tencent.android.tpush.service.a$a  reason: collision with other inner class name */
    public class C0753a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f69555a;

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            TLogger.d("PushServiceBroadcastHandler", "PackageChangesReceiver - onReceiver");
            if (intent != null && context != null) {
                if (this.f69555a.f69509e) {
                    CommonWorkingThread.getInstance().execute(new b(context, intent));
                } else if (this.f69555a.f69510f.size() < 10) {
                    this.f69555a.f69510f.add(intent);
                    TLogger.ii("PushServiceBroadcastHandler", "PackageChangesReceiver add intend to beforeInitedIntents,action:" + intent.getAction() + ", size:" + this.f69555a.f69510f.size());
                } else {
                    TLogger.ee("PushServiceBroadcastHandler", "Too much beforeInitedIntents. discard it");
                }
            }
        }
    }

    @JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.INTENTCHECK})
    public class b extends TTask {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Context f69583b = null;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Intent f69584c = null;

        public b(Context context, Intent intent) {
            this.f69583b = context;
            this.f69584c = intent;
        }

        public void TRun() {
            try {
                String action = this.f69584c.getAction();
                if (action != null) {
                    String replace = action.replace(this.f69583b.getPackageName(), "");
                    TLogger.d("PushServiceBroadcastHandler", "PushServiceRannable, intent action:" + replace);
                    if ("com.tencent.android.xg.vip.action.CHECK_CONNECT_STATE.V4".equals(replace)) {
                        a.this.a(this.f69583b, this.f69584c);
                    } else if ("com.tencent.android.xg.vip.action.REGISTER.V4".equals(replace)) {
                        a.this.b(this.f69583b, this.f69584c);
                    } else if ("com.tencent.android.xg.vip.action.UNREGISTER.V4".equals(replace)) {
                        a.this.g(this.f69583b, this.f69584c);
                    } else if ("com.tencent.android.xg.vip.action.ENABLE_DEBUG.V4".equals(replace)) {
                        a.this.k(this.f69583b, this.f69584c);
                    } else if ("com.tencent.android.xg.vip.action.SET_HTINTERVALMS.V4".equals(replace)) {
                        a.this.j(this.f69583b, this.f69584c);
                    } else if (!"com.tencent.android.xg.vip.action.MSG_ACK.V4".equals(replace)) {
                        if ("com.tencent.android.xg.vip.action.ACCOUNT.V4".equals(replace)) {
                            a.this.c(this.f69583b, this.f69584c);
                        } else if ("com.tencent.android.xg.vip.action.TAG.V4".equals(replace)) {
                            a.this.f(this.f69583b, this.f69584c);
                        } else if ("com.tencent.android.xg.vip.action.QUERYTAGS.V4".equals(replace)) {
                            a.this.e(this.f69583b, this.f69584c);
                        } else if (!"com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4".equals(replace)) {
                            if (!"com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4".equals(replace)) {
                                if (!"com.tencent.android.xg.vip.action.ack.sdk2srv.V4".equals(replace)) {
                                    if ("com.tencent.android.xg.vip.action.UPDATE_OTHER_PUSH_TOKEN.V4".equals(replace)) {
                                        a.this.h(this.f69583b, this.f69584c);
                                    } else if ("com.tencent.android.xg.vip.action.COMM_REPORT.V4".equals(replace)) {
                                        a.this.i(this.f69583b, this.f69584c);
                                    } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(replace)) {
                                        NetworkInfo networkInfo = (NetworkInfo) this.f69584c.getParcelableExtra("networkInfo");
                                        if (networkInfo != null) {
                                            TLogger.d("PushServiceBroadcastHandler", "Connection state changed to --- " + networkInfo.toString());
                                            if (!this.f69584c.getBooleanExtra("noConnectivity", false)) {
                                                if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                                                    TLogger.v("PushServiceBroadcastHandler", "network connected and start XGService 3s later");
                                                    b.a(this.f69583b, 3000);
                                                } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                                                    TLogger.v("PushServiceBroadcastHandler", "Network is disconnected.");
                                                    com.tencent.android.tpush.c.a.a().f68881b.c((OnMqttCallback) null);
                                                } else {
                                                    TLogger.v("PushServiceBroadcastHandler", "other network state - " + networkInfo.getState() + ". Do nothing.");
                                                }
                                            }
                                        }
                                    } else if ("com.tencent.android.xg.vip.action.FLUSH.V4".equals(replace)) {
                                        TBaseLogger.flush(new TBaseLogger.WriteFileCallback() {
                                            public void onFinished() {
                                                TLogger.ii("PushServiceBroadcastHandler", "xg process log flush finished");
                                                String decrypt = Rijndael.decrypt(b.this.f69584c.getStringExtra(Constants.FLAG_PACK_NAME));
                                                if (!TextUtils.isEmpty(decrypt) && decrypt.equals(b.this.f69583b.getPackageName())) {
                                                    BroadcastAgent.sendBroadcast(b.e(), new Intent("com.tencent.android.xg.vip.action.FLUSH.RESULT.V4"));
                                                }
                                            }
                                        });
                                    } else if ("com.tencent.android.xg.vip.action.ATTRIBUTE.V4".equals(replace)) {
                                        a.this.d(this.f69583b, this.f69584c);
                                    } else if ("com.tencent.android.xg.vip.action.KILLSERVICEPROCESS.V4".equals(replace)) {
                                        TLogger.d("PushServiceBroadcastHandler", "receive kill process");
                                        b.b().c();
                                        Util.killPushProcess(this.f69583b);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                TLogger.e("PushServiceBroadcastHandler", "PushServiceBroadcastHandler run error.", th2);
            }
        }
    }

    public class c extends BroadcastReceiver {
        private c() {
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            TLogger.d("PushServiceBroadcastHandler", "TPushAppReceiver - onReceiver");
            if (intent != null && context != null) {
                if (a.this.f69509e) {
                    CommonWorkingThread.getInstance().execute(new b(context, intent));
                    return;
                }
                final Context applicationContext = context.getApplicationContext();
                CommonWorkingThread.getInstance().execute(new TTask() {
                    public void TRun() {
                        try {
                            if (XGApiConfig.isEnableService(applicationContext)) {
                                TLogger.d("PushServiceBroadcastHandler", "already registered but service not init, try start service again");
                                Intent intent = new Intent();
                                intent.setClass(applicationContext, XGVipPushService.class);
                                intent.setAction(Constants.ACTION_KEEPALIVE);
                                applicationContext.startService(intent);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
                if (a.this.f69510f.size() < 10) {
                    a.this.f69510f.add(intent);
                    TLogger.ii("PushServiceBroadcastHandler", "TPushAppReceiver add intend to beforeInitedIntents,action:" + intent.getAction() + ", size:" + a.this.f69510f.size());
                    return;
                }
                TLogger.ee("PushServiceBroadcastHandler", "Too much beforeInitedIntents. discard it");
            }
        }

        public /* synthetic */ c(a aVar, AnonymousClass1 r22) {
            this();
        }
    }

    private a() {
    }

    private static boolean a(Object obj) {
        return false;
    }

    public class d extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public long f69589a;

        private d() {
            this.f69589a = 0;
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (intent != null && context != null) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (networkInfo != null) {
                        TLogger.v("PushServiceBroadcastHandler", "Connection state changed to - " + networkInfo.toString());
                        if (!intent.getBooleanExtra("noConnectivity", false)) {
                            if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                                TLogger.v("PushServiceBroadcastHandler", "Internl network connected and call MqttChannel.startConnect on 5s later");
                                CommonWorkingThread.getInstance().execute(new TTask() {
                                    public void TRun() {
                                        TLogger.dd("PushServiceBroadcastHandler", "Internl network connected, restart");
                                        com.tencent.android.tpush.c.a.a().f68881b.a((OnMqttCallback) null);
                                    }
                                }, 5000);
                            } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                                TLogger.v("PushServiceBroadcastHandler", "Network is disconnected.");
                                com.tencent.android.tpush.c.a.a().f68881b.c((OnMqttCallback) null);
                            } else {
                                TLogger.v("PushServiceBroadcastHandler", "other network state - " + networkInfo.getState() + ". Do nothing.");
                            }
                        }
                    }
                } else {
                    TLogger.d("PushServiceBroadcastHandler", "--UserPresentReceiver--");
                    if (Math.abs(System.currentTimeMillis() - this.f69589a) > 8000) {
                        final Context applicationContext = context.getApplicationContext();
                        CommonWorkingThread.getInstance().execute(new TTask() {
                            public void TRun() {
                                TLogger.dd("PushServiceBroadcastHandler", "--start Connect UserPresentReceiver--");
                                com.tencent.android.tpush.c.a.a().f68881b.a((OnMqttCallback) null);
                                com.tencent.android.tpush.a.b(applicationContext);
                            }
                        }, 2000);
                        this.f69589a = System.currentTimeMillis();
                    }
                }
            }
        }

        public /* synthetic */ d(a aVar, AnonymousClass1 r22) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public void d(Context context, Intent intent) {
        Intent intent2 = intent;
        if (context != null && intent2 != null) {
            long longExtra = intent2.getLongExtra("accId", -1);
            String decrypt = Rijndael.decrypt(intent2.getStringExtra(Constants.FLAG_ACC_KEY));
            String decrypt2 = Rijndael.decrypt(intent2.getStringExtra(Constants.FLAG_PACK_NAME));
            int intExtra = intent2.getIntExtra(Constants.FLAG_ATTRIBUTES_TYPE, -1);
            String decrypt3 = Rijndael.decrypt(intent2.getStringExtra(Constants.FLAG_ATTRIBUTES_NAME));
            final String stringExtra = intent2.getStringExtra(Constants.FLAG_ATTRIBUTES_OPER_NAME);
            try {
                final long j11 = longExtra;
                final int i11 = intExtra;
                final String str = decrypt3;
                final String str2 = decrypt2;
                c.a().b(longExtra, decrypt, decrypt2, intExtra, decrypt3, new com.tencent.android.tpush.service.c.a() {
                    public void a(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        if (i11 == 0) {
                            TLogger.ii("PushServiceBroadcastHandler", "Set attributes ack success  [accId = " + j11 + " ,attributesType = " + i11 + " ,attributesName = " + str + " ,packName = " + str2 + "]");
                            a.this.a(i11, str, i11, str2, stringExtra, str);
                            return;
                        }
                        TLogger.ee("PushServiceBroadcastHandler", "Set attributes ack failed with responseCode = " + i11 + " , attributesName = " + str);
                        a.this.a(i11, "服务器处理失败，返回错误", str, i11, str2, stringExtra);
                    }

                    public void b(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        TLogger.ee("PushServiceBroadcastHandler", "@@ attributesHandler onMessageSendFailed: " + i11 + ", " + str);
                        a.this.a(i11, str, str, i11, str2, stringExtra);
                    }
                });
            } catch (Throwable th2) {
                TLogger.e("PushServiceBroadcastHandler", ">> attributes Handler error " + th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void e(Context context, Intent intent) {
        Intent intent2 = intent;
        if (context != null && intent2 != null) {
            long longExtra = intent2.getLongExtra("accId", -1);
            String decrypt = Rijndael.decrypt(intent2.getStringExtra(Constants.FLAG_ACC_KEY));
            String decrypt2 = Rijndael.decrypt(intent2.getStringExtra(Constants.FLAG_PACK_NAME));
            int intExtra = intent2.getIntExtra(Constants.FLAG_TAG_OFFSET, -1);
            int intExtra2 = intent2.getIntExtra("limit", -1);
            String stringExtra = intent2.getStringExtra(Constants.FLAG_TAG_QUERY_TYPE);
            final String stringExtra2 = intent2.getStringExtra(Constants.FLAG_QUERY_TAGS_OPER_NAME);
            try {
                final long j11 = longExtra;
                final int i11 = intExtra;
                final int i12 = intExtra2;
                final String str = decrypt2;
                final String str2 = stringExtra;
                c.a().a(longExtra, decrypt, decrypt2, intExtra, intExtra2, stringExtra, new com.tencent.android.tpush.service.c.a() {
                    public void a(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        if (i11 == 0) {
                            TLogger.ii("PushServiceBroadcastHandler", "Get tags ack success  [accId = " + j11 + " , offset = " + i11 + " , limit = " + i12 + ", response = " + str + "]");
                            a.this.a(i11, i11, i12, str, str, stringExtra2);
                            return;
                        }
                        TLogger.ee("PushServiceBroadcastHandler", "Set tag ack failed with responseCode = " + i11 + " , tagName = " + str2);
                        a.this.b(i11, i11, i12, str, str, stringExtra2);
                    }

                    public void b(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        TLogger.ee("PushServiceBroadcastHandler", "@@ QueryTagsHandler onMessageSendFailed: " + i11 + ", " + str);
                        a.this.b(i11, i11, i12, str, str, stringExtra2);
                    }
                });
            } catch (Throwable th2) {
                TLogger.e("PushServiceBroadcastHandler", ">> QueryTagsHandler error " + th2);
                TLogger.e("PushServiceBroadcastHandler", ">> QueryTagsHandler error-> " + TLogger.getStackTraceString(th2));
            }
        }
    }

    /* access modifiers changed from: private */
    public void f(Context context, Intent intent) {
        Intent intent2 = intent;
        if (context != null && intent2 != null) {
            long longExtra = intent2.getLongExtra("accId", -1);
            String decrypt = Rijndael.decrypt(intent2.getStringExtra(Constants.FLAG_ACC_KEY));
            String decrypt2 = Rijndael.decrypt(intent2.getStringExtra(Constants.FLAG_PACK_NAME));
            int intExtra = intent2.getIntExtra(Constants.FLAG_TAG_TYPE, -1);
            String decrypt3 = Rijndael.decrypt(intent2.getStringExtra(Constants.FLAG_TAG_NAME));
            final String stringExtra = intent2.getStringExtra(Constants.FLAG_TAG_OPER_NAME);
            try {
                final long j11 = longExtra;
                final int i11 = intExtra;
                final String str = decrypt3;
                final String str2 = decrypt2;
                c.a().a(longExtra, decrypt, decrypt2, intExtra, decrypt3, (com.tencent.android.tpush.service.c.a) new com.tencent.android.tpush.service.c.a() {
                    public void a(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        if (i11 == 0) {
                            TLogger.ii("PushServiceBroadcastHandler", "Set tag ack success  [accId = " + j11 + " , tagtype = " + i11 + " , tagName = " + str + ", packName = " + str2 + "]");
                            a.this.c(i11, str, i11, str2, stringExtra);
                            return;
                        }
                        TLogger.ee("PushServiceBroadcastHandler", "Set tag ack failed with responseCode = " + i11 + " , tagName = " + str);
                        a.this.b(i11, "服务器处理失败，返回错误", str, i11, str2, stringExtra);
                    }

                    public void b(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        TLogger.ee("PushServiceBroadcastHandler", "@@ TagHandler onMessageSendFailed: " + i11 + ", " + str);
                        a.this.b(i11, str, str, i11, str2, stringExtra);
                    }
                });
            } catch (Throwable th2) {
                TLogger.e("PushServiceBroadcastHandler", ">> TagHandler error " + th2);
                TLogger.e("PushServiceBroadcastHandler", ">> TagHandler error-> " + TLogger.getStackTraceString(th2));
            }
        }
    }

    /* access modifiers changed from: private */
    public void g(Context context, Intent intent) {
        if (context != null && intent != null) {
            final String decrypt = Rijndael.decrypt(intent.getStringExtra("accId"));
            String decrypt2 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACC_KEY));
            final String decrypt3 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_PACK_NAME));
            String decrypt4 = Rijndael.decrypt(intent.getStringExtra("token"));
            CacheManager.UnregisterInfoByPkgName(decrypt3);
            try {
                c.a().a(decrypt4, com.tencent.android.tpush.service.util.a.a(), Long.parseLong(decrypt), decrypt2, decrypt3, (com.tencent.android.tpush.service.c.a) new com.tencent.android.tpush.service.c.a() {
                    public void a(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        if (i11 == 0) {
                            TLogger.ii("PushServiceBroadcastHandler", ">> UnRegister ack with [accId = " + decrypt + " , packName = " + decrypt3 + " , rsp = ]");
                            a.this.a(i11, (r) dVar, decrypt3);
                            return;
                        }
                        TLogger.e("PushServiceBroadcastHandler", ">> unregeister ack failed responseCode=" + i11);
                        a.this.a(i11, "服务器处理失败，返回错误", (r) dVar, decrypt3);
                    }

                    public void b(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        TLogger.e("PushServiceBroadcastHandler", "@@ unregister onMessageSendFailed " + i11 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str);
                        a.this.a(i11, str, (r) dVar, decrypt3);
                    }
                });
            } catch (Throwable th2) {
                TLogger.e("PushServiceBroadcastHandler", ">>> unregister error " + th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void h(Context context, Intent intent) {
        if (context != null && intent != null) {
            final String decrypt = Rijndael.decrypt(intent.getStringExtra("accId"));
            String decrypt2 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACC_KEY));
            final String decrypt3 = Rijndael.decrypt(intent.getStringExtra("token"));
            String decrypt4 = Rijndael.decrypt(intent.getStringExtra("other_push_type"));
            String decrypt5 = Rijndael.decrypt(intent.getStringExtra(Constants.OTHER_PUSH_TOKEN));
            String decrypt6 = Rijndael.decrypt(intent.getStringExtra("other_push_region"));
            TLogger.i("PushServiceBroadcastHandler", "binding OtherPush token with accessId = " + decrypt + "  token = " + decrypt3 + " otherPushType = " + decrypt4 + " otherPushToken = " + decrypt5 + " other push region: " + decrypt6);
            final String str = decrypt4;
            final String str2 = decrypt5;
            c.a().a(Long.parseLong(decrypt), decrypt2, decrypt4, decrypt5, decrypt6, (com.tencent.android.tpush.service.c.a) new com.tencent.android.tpush.service.c.a() {
                public void a(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    if (i11 == 0) {
                        TLogger.ii("PushServiceBroadcastHandler", ">> bind OtherPushToken success ack with [accessId = " + decrypt + "  , rsp = " + i11 + "]  token = " + decrypt3 + " otherPushType = " + str + " otherPushToken = " + str2);
                        a.this.b();
                        return;
                    }
                    TLogger.ee("PushServiceBroadcastHandler", ">> updateOtherPushToken ack failed responseCode=" + i11);
                }

                public void b(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    TLogger.ee("PushServiceBroadcastHandler", "@@ updateOtherPushToken onMessageSendFailed " + i11 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void i(Context context, Intent intent) {
        if (context != null && intent != null) {
            final String decrypt = Rijndael.decrypt(intent.getStringExtra("accessId"));
            final String stringExtra = intent.getStringExtra("pkgName");
            final Context context2 = context;
            final Intent intent2 = intent;
            c.a().a(intent, new com.tencent.android.tpush.service.c.a() {
                public void a(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    if (i11 == 0) {
                        TLogger.ii("PushServiceBroadcastHandler", ">> sendCommReportMessage ack with [accId = " + decrypt + "  , rsp = " + i11 + "]");
                        com.tencent.android.tpush.a.b(context2, stringExtra, intent2.toURI());
                        return;
                    }
                    TLogger.ee("PushServiceBroadcastHandler", ">> sendCommReportMessage ack failed responseCode=" + i11);
                }

                public void b(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    TLogger.ee("PushServiceBroadcastHandler", "@@ sendCommReportMessage onMessageSendFailed " + i11 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void j(Context context, Intent intent) {
        int intExtra;
        if (intent != null && context != null && (intExtra = intent.getIntExtra(MTPushConstants.Geofence.KEY_INTERVAL, -1)) >= 10 && intExtra < 36000) {
            MqttConfig.setKeepAliveInterval(context, intExtra);
        }
    }

    /* access modifiers changed from: private */
    public void k(Context context, Intent intent) {
        if (intent != null && context != null) {
            boolean booleanExtra = intent.getBooleanExtra("debugMode", false);
            XGPushConfig.enableDebug = booleanExtra;
            TLogger.enableDebug(context, booleanExtra);
        }
    }

    public synchronized void c(Context context) {
        this.f69510f.clear();
        if (context != null) {
            if (f69506b != null) {
                j.a(context, (BroadcastReceiver) f69506b);
                f69506b = null;
            }
            if (f69507c != null) {
                j.a(context, (BroadcastReceiver) f69507c);
                f69507c = null;
            }
            if (f69508d != null) {
                j.a(context, (BroadcastReceiver) f69508d);
                f69508d = null;
            }
        }
    }

    public synchronized void b(Context context) {
        TLogger.d("PushServiceBroadcastHandler", "action - registerReceiver");
        if (context != null) {
            try {
                if (f69507c == null) {
                    f69507c = new c(this, (AnonymousClass1) null);
                    IntentFilter intentFilter = new IntentFilter();
                    String packageName = context.getPackageName();
                    intentFilter.addAction("com.tencent.android.xg.vip.action.CHECK_CONNECT_STATE.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.REGISTER.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.UNREGISTER.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.ENABLE_DEBUG.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.SET_HTINTERVALMS.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.MSG_ACK.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.ACCOUNT.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.TAG.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.QUERYTAGS.V4");
                    intentFilter.addAction("com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4");
                    intentFilter.addAction("com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.ack.sdk2srv.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.reserved.act.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.UPDATE_OTHER_PUSH_TOKEN.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.COMM_REPORT.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.FLUSH.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.ATTRIBUTE.V4");
                    intentFilter.addAction(packageName + "com.tencent.android.xg.vip.action.KILLSERVICEPROCESS.V4");
                    BroadcastAgent.registerReceiver(context, f69507c, intentFilter, 4);
                }
            } catch (Throwable th2) {
                TLogger.e("PushServiceBroadcastHandler", "registerReceiver", th2);
            }
            try {
                if (f69508d == null) {
                    f69508d = new d(this, (AnonymousClass1) null);
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("android.intent.action.USER_PRESENT");
                    intentFilter2.addAction("android.intent.action.SCREEN_ON");
                    intentFilter2.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                    intentFilter2.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                    intentFilter2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    if (Build.VERSION.SDK_INT >= 33) {
                        context.getApplicationContext().registerReceiver(f69508d, intentFilter2, 4);
                    } else {
                        context.getApplicationContext().registerReceiver(f69508d, intentFilter2);
                    }
                }
            } catch (Throwable th3) {
                TLogger.e("PushServiceBroadcastHandler", "registerReceiver userPresentReceiver error:", th3);
            }
        }
        return;
    }

    public synchronized void a(Context context) {
        TLogger.ii("PushServiceBroadcastHandler", "handleServiceInited, beforeInitedIntents size:" + this.f69510f.size());
        this.f69509e = true;
        try {
            Intent intent = new Intent("com.tencent.android.xg.vip.action.SERVICE_START.V4");
            intent.putExtra("pkg", b.e().getPackageName());
            intent.putExtra("ver", "1.4.4.2");
            BroadcastAgent.sendBroadcast(b.e(), intent);
        } catch (Throwable th2) {
            TLogger.e("PushServiceBroadcastHandler", "sendBroadcast", th2);
        }
        Iterator<Intent> it2 = this.f69510f.iterator();
        while (it2.hasNext()) {
            TLogger.ii("PushServiceBroadcastHandler", "excute, beforeInitedIntents size:" + this.f69510f.size());
            CommonWorkingThread.getInstance().execute(new b(context, it2.next()));
        }
        this.f69510f.clear();
    }

    /* access modifiers changed from: private */
    public void c(Context context, Intent intent) {
        if (context != null && intent != null) {
            long longExtra = intent.getLongExtra("accId", -1);
            String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACC_KEY));
            int intExtra = intent.getIntExtra(Constants.FLAG_ACCOUNT_OP_TYPE, -1);
            String decrypt2 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACCOUNT));
            final String stringExtra = intent.getStringExtra(Constants.FLAG_ACCOUNT_FEEDBACK);
            final String decrypt3 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_PACK_NAME));
            try {
                final long j11 = longExtra;
                final String str = decrypt2;
                final int i11 = intExtra;
                c.a().a(longExtra, decrypt, decrypt2, intExtra, new com.tencent.android.tpush.service.c.a() {
                    public void a(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        if (i11 == 0) {
                            if (XGPushConfig.enableDebug) {
                                TLogger.d("PushServiceBroadcastHandler", ">> AccountHandler [accId = " + j11 + ", packageNme: " + decrypt3 + "]");
                            }
                            a.this.b(i11, str, stringExtra, i11, decrypt3);
                            return;
                        }
                        TLogger.e("PushServiceBroadcastHandler", ">> AccountHandler ack fail responseCode = " + i11);
                        a.this.a(i11, "服务器处理失败，返回错误", str, stringExtra, i11, decrypt3);
                    }

                    public void b(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        TLogger.ee("PushServiceBroadcastHandler", "@@ AccountHandler onMessageSendFailed: " + i11 + ", " + str);
                        a.this.a(i11, str, str, stringExtra, i11, decrypt3);
                    }
                });
            } catch (Throwable th2) {
                TLogger.e("PushServiceBroadcastHandler", ">> AccountHandler error " + th2);
                TLogger.e("PushServiceBroadcastHandler", ">> AccountHandler error-> " + TLogger.getStackTraceString(th2));
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(int i11, String str, int i12, String str2, String str3) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.TAG.RESULT.V4");
        intent.putExtra("flag", i12);
        intent.putExtra("operation", 0);
        if (!j.b(str2)) {
            intent.setPackage(str2);
        }
        BroadcastAgent.sendBroadcast(b.e(), intent);
        a(i11, str, i12, str2, str3);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f69505a == null) {
                f69505a = new a();
            }
            aVar = f69505a;
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public void a(final Context context, Intent intent) {
        com.tencent.android.tpush.c.a.a().f68881b.d(new OnMqttCallback() {
            public void callback(int i11, String str) {
                Intent intent = new Intent("com.tencent.android.xg.vip.action.CHECK_CONNECT_STATE.RESULT.V4");
                if (i11 == 0 && (MqttConnectState.valueOf(str) == MqttConnectState.CONNECTED || MqttConnectState.valueOf(str) == MqttConnectState.SUBTOPICS)) {
                    intent.putExtra("connectState", true);
                } else {
                    intent.putExtra("connectState", false);
                }
                BroadcastAgent.sendBroadcast(context, intent);
            }
        });
    }

    private void a(int i11, String str, int i12, String str2) {
        if (!j.b(str)) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.FLAG_ACCOUNT, str);
                jSONObject.put("accountType", i12);
                jSONArray.put(jSONObject);
                a(i11, jSONArray.toString(), str, 0, str2);
            } catch (Throwable th2) {
                TLogger.ww("PushServiceBroadcastHandler", "getTypeAccountsJsonArrayStr:", th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, String str, int i12, String str2, String str3, String str4) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.ATTRIBUTE.RESULT.V4");
        intent.putExtra("flag", i12);
        intent.putExtra("operation", 0);
        if (!j.b(str2)) {
            intent.setPackage(str2);
        }
        if (!j.b(str4)) {
            intent.putExtra("data", str4);
        }
        BroadcastAgent.sendBroadcast(b.e(), intent);
        b(i11, str, i12, str2, str3);
    }

    /* access modifiers changed from: private */
    public void b(final Context context, Intent intent) {
        final m a11 = m.a(context, intent, false);
        if (context != null && intent != null) {
            try {
                c.a().a(context, a11, new com.tencent.android.tpush.service.c.a() {
                    public void a(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        if (i11 == 0) {
                            n nVar = new n();
                            try {
                                if (j.b(str)) {
                                    str = j.e((String) CacheHelper.get(context, com.tencent.android.tpush.e.b.a.b()));
                                } else {
                                    CacheHelper.set(context, com.tencent.android.tpush.e.b.a.b().set(j.f(str)));
                                }
                                nVar.a(str);
                                TLogger.dd("PushServiceBroadcastHandler", ">> Register onResponse [accId = " + a11.f69775a + ", token:" + nVar.f69802b + ", otherPushType:" + nVar.f69804d + ", otherToken:" + nVar.f69805e + " , packName = " + a11.K + "]");
                                m mVar = a11;
                                a.this.a(i11, nVar, (m) dVar, mVar.K, mVar.J, mVar.N);
                                XGApiConfig.setRegisterSuccess(context);
                            } catch (Throwable unused) {
                                TLogger.ee("PushServiceBroadcastHandler", ">> Register onResponse fail, 解析返回内容格式错误 " + i11);
                                a.this.a((int) ErrCode.INNER_ERROR_JSON, "解析服务器返回内容失败", (m) dVar, a11.K);
                            }
                        } else {
                            TLogger.ww("PushServiceBroadcastHandler", ">> Register ack fail, 服务器处理失败,返回错误; responseCode = " + i11);
                            a.this.a(i11, "服务器处理失败，返回错误", (m) dVar, a11.K);
                        }
                    }

                    public void b(int i11, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        TLogger.ee("PushServiceBroadcastHandler", "@@ registetr onMessageSendFailed: " + i11 + ", " + str);
                        a.this.a(i11, str, (m) dVar, a11.K);
                    }
                });
            } catch (Throwable th2) {
                TLogger.e("PushServiceBroadcastHandler", ">> register error " + th2);
                TLogger.e("PushServiceBroadcastHandler", ">> register error-> " + TLogger.getStackTraceString(th2));
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        try {
            Intent intent = new Intent("com.tencent.android.xg.vip.action.UPDATE.OTHER.TOKEN.RESULT.V4");
            intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
            intent.putExtra("operation", 0);
            intent.setPackage(b.e().getPackageName());
            BroadcastAgent.sendBroadcast(b.e(), intent);
        } catch (Throwable th2) {
            TLogger.ee("PushServiceBroadcastHandler", "updateOtherPushTokenSuccessHandler error: " + th2.toString());
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, String str, String str2, int i12, String str3, String str4) {
        TLogger.e("PushServiceBroadcastHandler", "attributesFailHandler failed with (" + i11 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str3 + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.ATTRIBUTE.RESULT.V4");
        intent.putExtra("flag", i12);
        intent.putExtra("code", i11);
        intent.putExtra(RemoteMessageConst.MessageBody.MSG, str);
        intent.putExtra("operation", 1);
        if (!j.b(str3)) {
            intent.setPackage(str3);
        }
        BroadcastAgent.sendBroadcast(b.e(), intent);
        b(i11, str2, i12, str3, str4);
    }

    private void b(int i11, String str, int i12, String str2, String str3) {
        Intent a11 = g.a(i11, str2, 7);
        a11.putExtra(Constants.FLAG_ATTRIBUTES_NAME, Rijndael.encrypt(str));
        a11.putExtra(Constants.FLAG_ATTRIBUTES_TYPE, i12);
        a11.putExtra(Constants.FLAG_ATTRIBUTES_OPER_NAME, str3);
        BroadcastAgent.sendBroadcast(b.e(), a11);
    }

    /* access modifiers changed from: private */
    public void b(int i11, String str, String str2, int i12, String str3) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.ACCOUNT.RESULT.V4");
        intent.putExtra("flag", i12);
        intent.putExtra("operation", 0);
        if (!j.b(str3)) {
            intent.setPackage(str3);
        }
        BroadcastAgent.sendBroadcast(b.e(), intent);
        a(i11, str, str2, i12, str3);
    }

    private void a(int i11, m mVar, String str, String str2, long j11, String str3) {
        Intent a11 = g.a(i11, str2, 1);
        a11.putExtra("accId", mVar.f69775a);
        if (!(str == null || str.length() == 0)) {
            a11.putExtra("token", str);
        }
        String str4 = mVar.f69779e;
        if (!(str4 == null || str4.length() == 0)) {
            a11.putExtra(Constants.FLAG_TICKET, mVar.f69779e);
            a11.putExtra(Constants.FLAG_TICKET_TYPE, mVar.f69780f);
        }
        String str5 = mVar.f69777c;
        if (!(str5 == null || str5.length() == 0)) {
            a11.putExtra(Constants.FLAG_DEVICE_ID, mVar.f69777c);
        }
        if (j11 >= 0) {
            a11.putExtra("otherPushType", j11);
            if (!j.b(str3)) {
                a11.putExtra("otherPushToken", str3);
            }
        }
        if (a((Object) mVar)) {
            a11.putExtra(Constants.FLAG_REGISTER_FROM_CLOUDCTRL, true);
        }
        BroadcastAgent.sendBroadcast(b.e(), a11);
    }

    /* access modifiers changed from: private */
    public void b(int i11, String str, String str2, int i12, String str3, String str4) {
        TLogger.e("PushServiceBroadcastHandler", "tagFailHandler failed with (" + i11 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str3 + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.TAG.RESULT.V4");
        intent.putExtra("flag", i12);
        intent.putExtra("code", i11);
        intent.putExtra(RemoteMessageConst.MessageBody.MSG, str);
        intent.putExtra("operation", 1);
        if (!j.b(str3)) {
            intent.setPackage(str3);
        }
        BroadcastAgent.sendBroadcast(b.e(), intent);
        a(i11, str2, i12, str3, str4);
    }

    private void a(int i11, String str) {
        BroadcastAgent.sendBroadcast(b.e(), g.a(i11, str, 2));
    }

    /* access modifiers changed from: private */
    public void b(int i11, int i12, int i13, String str, String str2, String str3) {
        TLogger.e("PushServiceBroadcastHandler", "tagFailHandler failed with (" + i11 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.TAG.RESULT.V4");
        intent.putExtra("code", i11);
        intent.putExtra(RemoteMessageConst.MessageBody.MSG, str2);
        intent.putExtra("operation", 1);
        if (!j.b(str)) {
            intent.setPackage(str);
        }
        BroadcastAgent.sendBroadcast(b.e(), intent);
        a(i11, str, str2, str3);
    }

    private void a(int i11, String str, String str2, int i12, String str3) {
        Intent a11 = g.a(i11, str3, 6);
        a11.putExtra(Constants.FLAG_ACCOUNT_NAME, Rijndael.encrypt(str));
        a11.putExtra(Constants.FLAG_ACCOUNT_FEEDBACK, str2);
        a11.putExtra(Constants.FLAG_ACCOUNT_OP_TYPE, i12);
        BroadcastAgent.sendBroadcast(b.e(), a11);
    }

    private void a(int i11, String str, int i12, String str2, String str3) {
        Intent a11 = g.a(i11, str2, 3);
        a11.putExtra(Constants.FLAG_TAG_NAME, Rijndael.encrypt(str));
        a11.putExtra(Constants.FLAG_TAG_TYPE, i12);
        a11.putExtra(Constants.FLAG_TAG_OPER_NAME, str3);
        BroadcastAgent.sendBroadcast(b.e(), a11);
    }

    private void a(int i11, String str, String str2, String str3) {
        Intent a11 = g.a(i11, str, 8);
        if (!TextUtils.isEmpty(str2)) {
            a11.putExtra("data", Rijndael.encrypt(str2));
        }
        a11.putExtra(Constants.FLAG_QUERY_TAGS_OPER_NAME, str3);
        BroadcastAgent.sendBroadcast(b.e(), a11);
    }

    /* access modifiers changed from: private */
    public void a(int i11, n nVar, m mVar, String str, boolean z11, String str2) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.REGISTER.RESULT.V4");
        intent.putExtra("accId", mVar.f69775a);
        intent.putExtra("data", nVar.f69802b);
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("code", i11);
        intent.putExtra("operation", 0);
        intent.putExtra("otherPushType", nVar.f69804d);
        intent.putExtra("otherPushToken", nVar.f69805e);
        intent.putExtra("lastNMd5str", str2);
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.accessId = mVar.f69775a;
        registerEntity.accessKey = mVar.f69776b;
        registerEntity.token = nVar.f69802b;
        registerEntity.channelId = mVar.f69793s;
        registerEntity.packageName = str;
        registerEntity.timestamp = System.currentTimeMillis() / 1000;
        CacheManager.addRegisterInfo(registerEntity);
        registerEntity.guid = nVar.f69803c;
        if (!j.b(str)) {
            intent.setPackage(str);
        }
        BroadcastAgent.sendBroadcast(b.e(), intent);
        try {
            String str3 = nVar.f69809i;
            if (j.b(str3)) {
                a(i11, mVar, nVar.f69802b, str, nVar.f69804d, nVar.f69805e);
            } else {
                a(i11, str3, nVar.f69810j, str);
            }
        } catch (Throwable unused) {
            TLogger.w("PushServiceBroadcastHandler", "unexpected for registerSuccessHandler");
        }
        if (b.e() != null) {
            com.tencent.android.tpush.a.b(b.e());
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, String str, m mVar, String str2) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.REGISTER.RESULT.V4");
        intent.putExtra("data", "");
        intent.putExtra("code", i11);
        intent.putExtra(RemoteMessageConst.MessageBody.MSG, str);
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("operation", 1);
        if (!j.b(str2)) {
            intent.setPackage(str2);
        }
        try {
            BroadcastAgent.sendBroadcast(b.e(), intent);
            if (mVar != null) {
                String str3 = mVar.f69779e;
                if (j.b(str3)) {
                    a(i11, mVar, GuidInfoManager.getToken(b.e()), str2, -1, (String) null);
                    return;
                }
                a(i11, str3, (int) mVar.f69780f, str2);
            }
        } catch (Throwable unused) {
            TLogger.w("PushServiceBroadcastHandler", "unexpected for registerFailHandler");
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, r rVar, String str) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.UNREGISTER.RESULT.V4");
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("operation", 0);
        CacheManager.UnregisterInfoSuccessByPkgName(str);
        CacheManager.removeRegisterInfos(str);
        if (!j.b(str)) {
            intent.setPackage(str);
        }
        BroadcastAgent.sendBroadcast(b.e(), intent);
        a(i11, str);
    }

    /* access modifiers changed from: private */
    public void a(int i11, String str, r rVar, String str2) {
        TLogger.e("PushServiceBroadcastHandler", "unregisterFailHandler failed with (" + i11 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + rVar + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.UNREGISTER.RESULT.V4");
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("code", i11);
        intent.putExtra(RemoteMessageConst.MessageBody.MSG, str);
        intent.putExtra("operation", 1);
        if (!j.b(str2)) {
            intent.setPackage(str2);
        }
        BroadcastAgent.sendBroadcast(b.e(), intent);
        a(i11, str2);
    }

    /* access modifiers changed from: private */
    public void a(int i11, String str, String str2, String str3, int i12, String str4) {
        TLogger.e("PushServiceBroadcastHandler", "accountFailHandler failed with (" + i11 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str4 + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.ACCOUNT.RESULT.V4");
        intent.putExtra("flag", i12);
        intent.putExtra("code", i11);
        intent.putExtra(RemoteMessageConst.MessageBody.MSG, str);
        intent.putExtra("operation", 1);
        if (!j.b(str4)) {
            intent.setPackage(str4);
        }
        BroadcastAgent.sendBroadcast(b.e(), intent);
        a(i11, str2, str3, i12, str4);
    }

    /* access modifiers changed from: private */
    public void a(int i11, int i12, int i13, String str, String str2, String str3) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.QUERYTAGS.RESULT.V4");
        intent.putExtra("data", str2);
        intent.putExtra("operation", 0);
        if (!j.b(str)) {
            intent.setPackage(str);
        }
        BroadcastAgent.sendBroadcast(b.e(), intent);
        a(i11, str, str2, str3);
    }
}
