package com.tencent.android.tpush.service.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.e;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.inappmessage.g;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.MessageManager;
import com.tencent.android.tpush.rpc.a;
import com.tencent.android.tpush.rpc.c;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.INTENTSCHEMECHECK, EType.INTENTCHECK, EType.RECEIVERCHECK})
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f69607a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f69608b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static long f69609c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f69610d = false;

    /* renamed from: e  reason: collision with root package name */
    private static volatile boolean f69611e = false;

    /* renamed from: f  reason: collision with root package name */
    private static volatile boolean f69612f = false;

    /* renamed from: g  reason: collision with root package name */
    private static volatile boolean f69613g = false;

    /* renamed from: h  reason: collision with root package name */
    private static ConcurrentHashMap<Long, Map<String, List<Long>>> f69614h = null;

    private a() {
    }

    public static a a() {
        c();
        return f69607a;
    }

    private static synchronized void c() {
        synchronized (a.class) {
            try {
                if (f69614h == null) {
                    f69614h = new ConcurrentHashMap<>();
                    String string = PushPreferences.getString(b.e(), "ChannelGroupKeysConfig", (String) null);
                    if (!j.b(string)) {
                        JSONArray jSONArray = new JSONArray(string);
                        if (jSONArray.length() > 0) {
                            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    Long valueOf = Long.valueOf(next);
                                    JSONArray jSONArray2 = jSONObject.getJSONArray(next);
                                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                                        HashMap hashMap = new HashMap();
                                        for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i12);
                                            Iterator<String> keys2 = jSONObject2.keys();
                                            while (keys2.hasNext()) {
                                                String next2 = keys2.next();
                                                hashMap.put(next2, a(jSONObject2.getJSONArray(next2)));
                                            }
                                        }
                                        f69614h.put(valueOf, hashMap);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                TLogger.e("SrvMessageManager", "initChanellGroupKey", th2);
            }
        }
        return;
    }

    public void b(ArrayList<com.tencent.android.tpush.service.protocol.j> arrayList, long j11, com.tencent.android.tpush.service.channel.a aVar) {
        if (arrayList != null && arrayList.size() > 0) {
            if (b.e() == null) {
                Context e11 = b.e();
                ServiceStat.reportErrCode(e11, ErrCode.INNER_ERROR_RECV_PKG_NULL, "context is null, msgid:" + arrayList.get(0).f69741a, 0, ErrCode.ERROR_INNER_TYPE);
                return;
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                TLogger.ii("SrvMessageManager", "receive msg from service msgId = " + arrayList.get(i11).f69741a + " pkg = " + arrayList.get(i11).f69747g + " type = " + arrayList.get(i11).f69746f);
            }
            Iterator<com.tencent.android.tpush.service.protocol.j> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.tencent.android.tpush.service.protocol.j next = it2.next();
                TLogger.d("SrvMessageManager", "distributeFromServer : accid=" + next.f69742b + " ,channelId=" + next.f69753m + ",busiId=" + next.f69743c + ",pkg=" + next.f69747g + ",msgId=" + next.f69741a + ",type=" + next.f69746f + ",ts=" + next.f69748h + ",multi=" + next.f69749i + ",date=" + next.f69750j + ",serverTime=" + next.f69751k + ",ttl=" + next.f69752l + ", size = " + arrayList.size() + ", groupId=" + next.f69758r + ", mgroupId=" + next.f69759s + ", revokeId=" + next.f69762v);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("distributeFromServer content:");
                sb2.append(next.f69745e);
                TLogger.d("SrvMessageManager", sb2.toString());
                long j12 = next.f69746f;
                if (j12 == 3) {
                    try {
                        String str = next.f69745e;
                        if (str != null) {
                            a(str);
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        TLogger.e("SrvMessageManager", "distributeFromServerInAppMsg exception: ", th2);
                    }
                } else if (j12 == 6) {
                    try {
                        if (next.f69765y != null) {
                            g.a(b.e()).a(next);
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        TLogger.e("SrvMessageManager", "distributeFromServerInAppMsg exception:" + th3.toString());
                    }
                } else if (j12 == 1000) {
                    try {
                        if (next.f69745e != null) {
                            String optString = new JSONObject(next.f69745e).optString("custom_content", (String) null);
                            CloudManager.getInstance(b.e()).parseCloudConfig(optString, 0);
                            b(b.e(), optString);
                        } else {
                            return;
                        }
                    } catch (Throwable th4) {
                        TLogger.w("SrvMessageManager", "unexpected for type:1000", th4);
                    }
                } else if (!j.b(next.f69747g) || next.f69749i != 0 || next.f69753m > 0) {
                    a(next, j11, aVar);
                } else {
                    TLogger.d("SrvMessageManager", ">> messageDistribute, msg.appPkgName is null!");
                    Context e12 = b.e();
                    ServiceStat.reportErrCode(e12, ErrCode.INNER_ERROR_RECV_PKG_NULL, "msgId:" + next.f69741a, 0, ErrCode.ERROR_INNER_TYPE);
                }
            }
        }
    }

    public synchronized void a(Context context, Intent intent) {
        if (!(context == null || intent == null)) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                MessageId messageId = new MessageId();
                long longExtra = intent.getLongExtra("msgId", -1);
                messageId.f69316id = longExtra;
                if (longExtra < 0) {
                    TLogger.v("SrvMessageManager", "@@ msgSendSDKAck: Not add LocalMsg");
                    return;
                }
                messageId.accessId = intent.getLongExtra("accId", -1);
                messageId.host = intent.getLongExtra(MessageKey.MSG_EXTRA_HOST, -1);
                messageId.port = intent.getIntExtra(MessageKey.MSG_EXTRA_PORT, -1);
                messageId.pact = intent.getByteExtra(MessageKey.MSG_EXTRA_PACT, (byte) -1);
                messageId.apn = DeviceInfos.getNetworkType(b.e());
                messageId.isp = j.p(b.e());
                messageId.serviceHost = b.e().getPackageName();
                messageId.receivedTime = currentTimeMillis;
                messageId.pkgName = intent.getPackage();
                messageId.busiMsgId = intent.getLongExtra(MessageKey.MSG_BUSI_MSG_ID, -1);
                messageId.timestamp = intent.getLongExtra(MessageKey.MSG_CREATE_TIMESTAMPS, -1);
                messageId.msgType = intent.getLongExtra("type", -1);
                messageId.multiPkg = intent.getLongExtra(MessageKey.MSG_CREATE_MULTIPKG, -1);
                messageId.date = intent.getStringExtra(MessageKey.MSG_DATE);
                messageId.channelId = intent.getLongExtra(MessageKey.MSG_CHANNEL_ID, -1);
                String stringExtra = intent.getStringExtra("group_id");
                if (!j.b(stringExtra)) {
                    messageId.groupId = stringExtra;
                }
                String stringExtra2 = intent.getStringExtra(MessageKey.MSG_STAT_TAG);
                if (!j.b(stringExtra2)) {
                    messageId.statTag = stringExtra2;
                }
                a(context, TtmlNode.COMBINE_ALL, messageId);
                a(context, messageId);
            } catch (Throwable th2) {
                TLogger.e("SrvMessageManager", "msgSendSDKAck", th2);
            }
        }
    }

    private void b(Context context, String str) {
        int i11;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("losePkt", 0);
                long optLong = jSONObject.optLong("loseStart", 0) * 1000;
                long optLong2 = jSONObject.optLong("loseEnd", 0) * 1000;
                long currentTimeMillis = System.currentTimeMillis();
                TLogger.i("SrvMessageManager", "checkIfCloudRefuse | losePkt : " + optInt + "; loseStart : " + optLong + "; loseEnd : " + optLong2 + "; current : " + currentTimeMillis);
                if (optInt == 1) {
                    int i12 = (currentTimeMillis > optLong2 ? 1 : (currentTimeMillis == optLong2 ? 0 : -1));
                    if ((i12 <= 0 && currentTimeMillis >= optLong) || ((optLong == 0 && optLong2 == 0) || ((i12 <= 0 && i11 == 0) || (currentTimeMillis >= optLong && optLong2 == 0)))) {
                        com.tencent.android.tpush.c.a.a().f68881b.c((OnMqttCallback) null);
                        TLogger.i("SrvMessageManager", "checkIfCloudRefuse | stopConnect ");
                    }
                }
            } catch (JSONException e11) {
                TLogger.e("SrvMessageManager", "checkIfCloudRefuse", e11);
            }
        }
    }

    private synchronized void a(Context context, MessageId messageId) {
    }

    public void a(Context context, String str, MessageId messageId) {
        synchronized (f69608b) {
            if (context != null) {
                if (!j.b(str) && messageId != null) {
                    ArrayList<MessageId> a11 = a(context, str);
                    ArrayList arrayList = new ArrayList();
                    for (int i11 = 0; i11 < a11.size(); i11++) {
                        MessageId messageId2 = a11.get(i11);
                        if (messageId2.f69316id == messageId.f69316id) {
                            arrayList.add(messageId2);
                        }
                    }
                    a11.removeAll(arrayList);
                    a11.add(messageId);
                    a(context, str, a11);
                }
            }
        }
    }

    private static JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry next : f69614h.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            PrintStream printStream = System.out;
            printStream.println("Key = " + next.getKey());
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
                jSONArray2.put(jSONObject2);
            }
            jSONObject.put(((Long) next.getKey()).toString(), jSONArray2);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r2 = a(r2, r3, ".tpns.msg.id.send.sdk");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.ArrayList<com.tencent.android.tpush.data.MessageId> a(android.content.Context r2, java.lang.String r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0013
            boolean r0 = com.tencent.android.tpush.common.j.b((java.lang.String) r3)
            if (r0 != 0) goto L_0x0013
            java.lang.String r0 = ".tpns.msg.id.send.sdk"
            java.lang.Object r2 = r1.a((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r0)
            if (r2 == 0) goto L_0x0013
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            if (r2 != 0) goto L_0x001b
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x001b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.b.a.a(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    public void a(Context context, String str, ArrayList<MessageId> arrayList) {
        synchronized (f69608b) {
            if (!(context == null || arrayList == null)) {
                a(context, str, ".tpns.msg.id.send.sdk", arrayList);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v16, types: [java.lang.String[], java.io.Serializable] */
    private void a(com.tencent.android.tpush.service.protocol.j jVar, long j11, com.tencent.android.tpush.service.channel.a aVar) {
        Context context;
        Context context2;
        com.tencent.android.tpush.service.protocol.j jVar2 = jVar;
        TLogger.d("SrvMessageManager", "distribute2SDK: " + jVar.toString());
        Context e11 = b.e();
        Intent intent = new Intent(Constants.ACTION_INTERNAL_PUSH_MESSAGE);
        intent.setPackage(jVar2.f69747g);
        intent.putExtra("msgId", jVar2.f69741a);
        intent.putExtra("title", Rijndael.encrypt(jVar2.f69744d));
        intent.putExtra("content", Rijndael.encrypt(jVar2.f69745e));
        intent.putExtra(MessageKey.MSG_DATE, jVar2.f69750j);
        intent.putExtra("type", jVar2.f69746f);
        intent.putExtra("accId", jVar2.f69742b);
        intent.putExtra(MessageKey.MSG_BUSI_MSG_ID, jVar2.f69743c);
        intent.putExtra(MessageKey.MSG_CREATE_TIMESTAMPS, jVar2.f69748h);
        intent.putExtra(MessageKey.MSG_CREATE_MULTIPKG, jVar2.f69749i);
        intent.putExtra("server_time", jVar2.f69751k);
        intent.putExtra("ttl", jVar2.f69752l);
        intent.putExtra("group_id", jVar2.f69758r);
        intent.putExtra(MessageKey.MSG_TARGET_TYPE, jVar2.f69760t);
        intent.putExtra("source", jVar2.f69761u);
        intent.putExtra(MessageKey.MSG_REVOKEID, jVar2.f69762v);
        intent.putExtra(MessageKey.MSG_TEMPLATE_ID, jVar2.f69763w);
        intent.putExtra(MessageKey.MSG_TRACE_ID, jVar2.f69764x);
        intent.putExtra(MessageKey.MSG_IN_MSG, Rijndael.encrypt(jVar2.f69765y));
        if (!com.tencent.android.tpush.f.a.a(e11) || jVar2.f69747g.equals(e11.getPackageName())) {
            intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, 100);
        } else {
            intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, com.tencent.android.tpush.f.a.a());
        }
        intent.putExtra("groupId", jVar2.f69759s);
        intent.putExtra(MessageKey.MSG_SERVICE_ACK, true);
        intent.putExtra(MessageKey.MSG_SERVICE_PACKAGE_NAME, b.h());
        if (jVar2.f69762v > 0) {
            ServiceStat.appReportRevokeMessageServiceReceived(b.e(), intent);
        } else {
            ServiceStat.appReportServiceReceived(b.e(), intent);
        }
        if (jVar2.f69746f != 7 || !com.tencent.android.tpush.f.a.a(b.e())) {
            int i11 = jVar2.f69752l;
            long j12 = jVar2.f69751k;
            long j13 = jVar2.f69748h;
            long currentTimeMillis = System.currentTimeMillis();
            long j14 = 259200000;
            if (i11 > 0) {
                j14 = ((long) i11) * 1000;
                context = e11;
            } else {
                context = e11;
                if (jVar2.f69741a > 0 && i11 == 0) {
                    j14 = 30000;
                }
            }
            long j15 = (j12 <= 0 || j13 <= 0) ? currentTimeMillis + j14 : (currentTimeMillis - ((j12 / 1000) - j13)) + j14;
            TLogger.d("SrvMessageManager", "execute expireTime for msgIntent: " + j15);
            intent.putExtra(MessageKey.MSG_TIME_GAP, currentTimeMillis - (j12 / 1000));
            intent.putExtra(MessageKey.MSG_EXPIRE_TIME, j15);
            try {
                intent.putExtra("enKeySet", e.a((Serializable) new String[]{"title", "content"}));
            } catch (Throwable th2) {
                TLogger.e("SrvMessageManager", "distribute2SDK", th2);
            }
            intent.putExtra(MessageKey.MSG_EXTRA_PUSHTIME, j11);
            long j16 = jVar2.f69749i;
            long j17 = jVar2.f69742b;
            String str = null;
            if (!com.tencent.android.tpush.f.a.a(context) || jVar2.f69747g.equals(context.getPackageName())) {
                context2 = context;
                if (j16 != 0) {
                    String findValidPackageByAccessid = CacheManager.findValidPackageByAccessid(j17);
                    if (!j.b(findValidPackageByAccessid)) {
                        str = findValidPackageByAccessid;
                    } else if (!jVar2.f69747g.equals(context2.getPackageName())) {
                        str = context2.getPackageName();
                    }
                } else if (jVar2.f69747g.equals(context2.getPackageName())) {
                    str = jVar2.f69747g;
                } else {
                    TLogger.w("SrvMessageManager", "receive message but package name is not right");
                }
            } else if (j16 == 0) {
                context2 = context;
                if (com.tencent.android.tpush.f.a.a(context2, jVar2.f69742b, jVar2.f69747g)) {
                    intent.putExtra(Constants.XG_SYS_INTENT_KEY_THIRD_APP, jVar2.f69747g);
                    str = context2.getPackageName();
                }
            } else {
                context2 = context;
                String a11 = com.tencent.android.tpush.f.a.a(context2, jVar2.f69742b);
                if (a11 != null) {
                    intent.putExtra(Constants.XG_SYS_INTENT_KEY_THIRD_APP, a11);
                    str = context2.getPackageName();
                }
            }
            TLogger.i("SrvMessageManager", "distribute2SDK appPkgName: " + str);
            try {
                TLogger.i("SrvMessageManager", "distribute2SDK pkgs msgid " + jVar2.f69741a + "  pkg " + jVar2.f69747g);
                if (j.b(str)) {
                    TLogger.d("SrvMessageManager", ">> msg.appPkgName is null!");
                    ServiceStat.reportErrCode(context2, ErrCode.INNER_ERROR_RECV_PKG_NULL, "distribute2SDK msgId:" + jVar2.f69741a, 0, ErrCode.ERROR_INNER_TYPE);
                    return;
                }
                if (!com.tencent.android.tpush.f.a.a(context2)) {
                    com.tencent.android.tpush.a.a.a(b.e()).a(str);
                }
                RegisterEntity registerInfoByPkgName = CacheManager.getRegisterInfoByPkgName(str);
                if (registerInfoByPkgName == null) {
                    TLogger.v("SrvMessageManager", "RegInfo is null " + str);
                    try {
                        a(jVar2.f69750j, intent, str);
                    } catch (Throwable th3) {
                        th = th3;
                        TLogger.e("SrvMessageManager", "dispatchMessageOnTime", th);
                        ServiceStat.reportErrCode(context2, ErrCode.INNER_ERROR_MSG_SHOW_ERROR, "sendMsgByPkgName err:" + Util.getThrowableToString(th), 0, ErrCode.ERROR_INNER_TYPE);
                    }
                } else {
                    if (registerInfoByPkgName.state > 0) {
                        MessageManager.getInstance().deleteAllCachedMsgIntentByPkgName(b.e(), str);
                        ServiceStat.reportErrCode(context2, ErrCode.INNER_ERROR_MSG_SHOW_ERROR, "regInfo.state:" + registerInfoByPkgName.state, 0, ErrCode.ERROR_INNER_TYPE);
                        return;
                    }
                    intent.setPackage(str);
                    if (!com.tencent.android.tpush.a.a(b.e(), intent.getPackage(), intent)) {
                        a(jVar2.f69750j, intent, str);
                    } else {
                        a(b.e(), intent);
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                TLogger.e("SrvMessageManager", "dispatchMessageOnTime", th);
                ServiceStat.reportErrCode(context2, ErrCode.INNER_ERROR_MSG_SHOW_ERROR, "sendMsgByPkgName err:" + Util.getThrowableToString(th), 0, ErrCode.ERROR_INNER_TYPE);
            }
        } else {
            TLogger.w("SrvMessageManager", "receive inMsg but run as SysPush, discard it");
        }
    }

    public void a(String str, Intent intent, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        if (j.b(str) || (!j.b(str) && simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) == 0)) {
            if (com.tencent.android.tpush.service.util.g.a(intent)) {
                TLogger.d("SrvMessageManager", ">> send rpc message intent:" + intent);
                a(intent);
            }
        } else if (!j.b(str) && simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) < 0) {
            a(intent);
        }
    }

    public void a(final Intent intent) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public com.tencent.android.tpush.rpc.a f69617c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public c f69618d = new c();
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public ServiceConnection f69619e = new ServiceConnection() {
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    try {
                        com.tencent.android.tpush.rpc.a unused = AnonymousClass1.this.f69617c = a.C0750a.a(iBinder);
                        if (AnonymousClass1.this.f69617c != null) {
                            AnonymousClass1.this.f69617c.a(intent.toURI(), AnonymousClass1.this.f69618d);
                        }
                    } catch (Throwable th2) {
                        TLogger.e("SrvMessageManager", "SendBroadcastByRPC", th2);
                    }
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    ServiceConnection unused = AnonymousClass1.this.f69619e = null;
                    com.tencent.android.tpush.rpc.a unused2 = AnonymousClass1.this.f69617c = null;
                    c unused3 = AnonymousClass1.this.f69618d = null;
                }
            };

            public void TRun() {
                try {
                    Intent intent = intent;
                    intent.setAction(intent.getPackage() + Constants.RPC_SUFFIX);
                    this.f69618d.a(this.f69619e);
                    if (!b.e().bindService(intent, this.f69619e, 1)) {
                        TLogger.e("SrvMessageManager", "Failed Send AIDL" + intent + " failed  msgid = " + intent.getLongExtra("msgId", -1));
                        MessageManager.getInstance().addCachedMsgIntentByPkgName(b.e(), intent.getPackage(), intent);
                        ServiceStat.reportErrCode(b.e(), ErrCode.INNER_ERROR_MSG_SHOW_ERROR, "bind aidl remote service return false", 0, ErrCode.ERROR_INNER_TYPE);
                        return;
                    }
                    TLogger.d("SrvMessageManager", "Succeed Send AIDL" + intent + " success  msgid = " + intent.getLongExtra("msgId", -1));
                    a.this.a(b.e(), intent);
                } catch (Throwable th2) {
                    TLogger.e("SrvMessageManager", "SendBroadcastByRPC -> bindService", th2);
                    MessageManager.getInstance().addCachedMsgIntentByPkgName(b.e(), intent.getPackage(), intent);
                    Context e11 = b.e();
                    ServiceStat.reportErrCode(e11, ErrCode.INNER_ERROR_MSG_SHOW_ERROR, "bind aidl remote service err:" + Util.getThrowableToString(th2), 0, ErrCode.ERROR_INNER_TYPE);
                }
            }
        });
    }

    public void a(ArrayList<com.tencent.android.tpush.service.protocol.j> arrayList, long j11, com.tencent.android.tpush.service.channel.a aVar) {
        b(arrayList, j11, aVar);
    }

    private synchronized void a(String str) {
        if (!j.b(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("custom_content");
                JSONArray jSONArray = jSONObject.getJSONArray(TUIConstants.TUIPlugin.PLUGIN_EXTENSION_CONFIG);
                int i11 = jSONObject.getInt("version");
                int i12 = 0;
                if (jSONArray != null && jSONArray.length() > 0) {
                    boolean z11 = false;
                    while (i12 < jSONArray.length()) {
                        boolean a11 = a(jSONArray.getJSONObject(i12));
                        if (a11) {
                            z11 = a11;
                        }
                        i12++;
                    }
                    i12 = z11;
                }
                if (i12 != 0) {
                    JSONArray b11 = b();
                    PushPreferences.putInt(b.e(), "GroupKeysConfigVersion", i11);
                    PushPreferences.putString(b.e(), "ChannelGroupKeysConfig", b11.toString());
                }
            } catch (Throwable th2) {
                TLogger.e("SrvMessageManager", "handleGroupKeysConfig", th2);
            }
        } else {
            return;
        }
        return;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2, types: [int] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b7, code lost:
        return r2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(org.json.JSONObject r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = "channelId"
            long r0 = r11.getLong(r0)     // Catch:{ all -> 0x00b8 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x00b8 }
            long r1 = r0.longValue()     // Catch:{ all -> 0x00b8 }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 0
            if (r1 > 0) goto L_0x0018
            monitor-exit(r10)
            return r2
        L_0x0018:
            java.lang.String r1 = "infos"
            org.json.JSONArray r11 = r11.getJSONArray(r1)     // Catch:{ all -> 0x00b8 }
            if (r11 == 0) goto L_0x00b6
            int r1 = r11.length()     // Catch:{ all -> 0x00b8 }
            if (r1 <= 0) goto L_0x00b6
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.Map<java.lang.String, java.util.List<java.lang.Long>>> r1 = f69614h     // Catch:{ all -> 0x00b8 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x00b8 }
            if (r1 != 0) goto L_0x0038
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x00b8 }
            r1.<init>()     // Catch:{ all -> 0x00b8 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.Map<java.lang.String, java.util.List<java.lang.Long>>> r3 = f69614h     // Catch:{ all -> 0x00b8 }
            r3.put(r0, r1)     // Catch:{ all -> 0x00b8 }
        L_0x0038:
            r1 = r2
        L_0x0039:
            int r3 = r11.length()     // Catch:{ all -> 0x00b8 }
            if (r2 >= r3) goto L_0x00b5
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.Map<java.lang.String, java.util.List<java.lang.Long>>> r3 = f69614h     // Catch:{ all -> 0x00b8 }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x00b8 }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ all -> 0x00b8 }
            org.json.JSONObject r4 = r11.getJSONObject(r2)     // Catch:{ all -> 0x00b8 }
            java.lang.String r5 = "groupKey"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ all -> 0x00b8 }
            java.lang.String r6 = "op"
            int r6 = r4.getInt(r6)     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = "apps"
            org.json.JSONArray r4 = r4.getJSONArray(r7)     // Catch:{ all -> 0x00b8 }
            if (r4 == 0) goto L_0x00ad
            int r7 = r4.length()     // Catch:{ all -> 0x00b8 }
            if (r7 <= 0) goto L_0x00ad
            boolean r7 = r3.containsKey(r5)     // Catch:{ all -> 0x00b8 }
            if (r7 != 0) goto L_0x0073
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00b8 }
            r7.<init>()     // Catch:{ all -> 0x00b8 }
            r3.put(r5, r7)     // Catch:{ all -> 0x00b8 }
        L_0x0073:
            java.lang.Object r7 = r3.get(r5)     // Catch:{ all -> 0x00b8 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x00b8 }
            java.util.List r4 = a((org.json.JSONArray) r4)     // Catch:{ all -> 0x00b8 }
            r8 = 1
            if (r6 != r8) goto L_0x0083
            r7 = r4
        L_0x0081:
            r1 = r8
            goto L_0x00aa
        L_0x0083:
            r9 = 2
            if (r6 != r9) goto L_0x008d
            r4.removeAll(r7)     // Catch:{ all -> 0x00b8 }
            r7.addAll(r4)     // Catch:{ all -> 0x00b8 }
            goto L_0x0081
        L_0x008d:
            r9 = 3
            if (r6 != r9) goto L_0x0094
            r7.removeAll(r4)     // Catch:{ all -> 0x00b8 }
            goto L_0x0081
        L_0x0094:
            java.lang.String r4 = "SrvMessageManager"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r8.<init>()     // Catch:{ all -> 0x00b8 }
            java.lang.String r9 = "error op type "
            r8.append(r9)     // Catch:{ all -> 0x00b8 }
            r8.append(r6)     // Catch:{ all -> 0x00b8 }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x00b8 }
            com.tencent.android.tpush.logging.TLogger.e(r4, r6)     // Catch:{ all -> 0x00b8 }
        L_0x00aa:
            r3.put(r5, r7)     // Catch:{ all -> 0x00b8 }
        L_0x00ad:
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.Map<java.lang.String, java.util.List<java.lang.Long>>> r4 = f69614h     // Catch:{ all -> 0x00b8 }
            r4.put(r0, r3)     // Catch:{ all -> 0x00b8 }
            int r2 = r2 + 1
            goto L_0x0039
        L_0x00b5:
            r2 = r1
        L_0x00b6:
            monitor-exit(r10)
            return r2
        L_0x00b8:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.b.a.a(org.json.JSONObject):boolean");
    }

    private static List<Long> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add(Long.valueOf(jSONArray.getLong(i11)));
            }
        }
        return arrayList;
    }

    private void a(Context context, String str, String str2, ArrayList<?> arrayList) {
        try {
            if (arrayList.size() > 50) {
                arrayList.subList(0, 10).clear();
            }
            String encrypt = Rijndael.encrypt(e.a((Serializable) arrayList));
            com.tencent.android.tpush.service.util.e.a(context, str + str2, encrypt);
        } catch (Throwable th2) {
            TLogger.e("SrvMessageManager", "putSettings", th2);
        }
    }

    private Object a(Context context, String str, String str2) {
        try {
            return e.a(Rijndael.decrypt(com.tencent.android.tpush.service.util.e.a(context, str + str2)));
        } catch (Throwable th2) {
            TLogger.e("SrvMessageManager", "getSettings", th2);
            return null;
        }
    }
}
