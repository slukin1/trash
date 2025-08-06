package com.mob.tools.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.mob.commons.CSCenter;
import com.mob.commons.s;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.b.e;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DH;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class NtFetcher implements PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private static NtFetcher f28124a;

    /* renamed from: b  reason: collision with root package name */
    private Context f28125b;

    /* renamed from: c  reason: collision with root package name */
    private BroadcastReceiver f28126c;

    /* renamed from: d  reason: collision with root package name */
    private String f28127d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f28128e;

    private NtFetcher(Context context) {
        this.f28125b = context;
        a();
    }

    @TargetApi(21)
    private ConnectivityManager.NetworkCallback b() {
        return new ConnectivityManager.NetworkCallback() {
            public void onAvailable(Network network) {
                super.onAvailable(network);
                NtFetcher.this.c();
            }

            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                super.onCapabilitiesChanged(network, networkCapabilities);
            }

            public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                super.onLinkPropertiesChanged(network, linkProperties);
            }

            public void onLosing(Network network, int i11) {
                super.onLosing(network, i11);
            }

            public void onLost(Network network) {
                super.onLost(network);
                NtFetcher.this.c();
            }

            public void onUnavailable() {
                super.onUnavailable();
            }
        };
    }

    private boolean b(int i11) {
        return i11 == 20;
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f28127d = g();
        this.f28128e = Integer.valueOf(d());
    }

    private boolean c(int i11) {
        return i11 == 13;
    }

    private int d() {
        if (DH.SyncMtd.getSystemServiceSafe(PlaceFields.PHONE) == null || !DH.SyncMtd.checkPermission(s.a("035deYdcdjdkdidcdl_jf2djdfdififididk(e4dlgjgifdfldhglfkgheggidhelfcfdfcgi"))) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return e.a(this.f28125b).c();
        }
        return e.a(this.f28125b).b();
    }

    private boolean d(int i11) {
        switch (i11) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }

    private void e() {
        this.f28126c = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                try {
                    if (intent.getAction().equalsIgnoreCase(s.a("036de@dcdjdkdidcdlSefi.dlPc(dk-ee(dledghegeggiedfceegkeefcildhedfkfdegidgi"))) {
                        NtFetcher.this.c();
                    }
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(s.a("036de[dcdjdkdidcdlSefi^dlAc9dk1ee?dledghegeggiedfceegkeefcildhedfkfdegidgi"));
        v.a(this.f28126c, intentFilter);
    }

    private void f() {
        BroadcastReceiver broadcastReceiver = this.f28126c;
        if (broadcastReceiver != null) {
            v.a(broadcastReceiver);
            this.f28126c = null;
        }
    }

    private String g() {
        if (!DH.SyncMtd.checkPermission(s.a("035de=dcdjdkdidcdl'jfMdjdfdififididkYe,dlgjgifdfldhglfkgheggidhelfcfdfcgi")) || !CSCenter.getInstance().isPhoneStateDataEnable()) {
            return getNetworkTypeDesensitized();
        }
        return h();
    }

    public static NtFetcher getInstance(Context context) {
        if (f28124a == null) {
            synchronized (NtFetcher.class) {
                if (f28124a == null) {
                    f28124a = new NtFetcher(context);
                }
            }
        }
        return f28124a;
    }

    private String h() {
        Object systemServiceSafe;
        NetworkInfo activeNetworkInfo;
        try {
            if (DH.SyncMtd.checkPermission(s.a("039de(dcdjdkdidcdlMjf)djdfdififididkVeNdlfdededgieleldheggifcgfghgjicdhelfcfdfcgi")) && (systemServiceSafe = DH.SyncMtd.getSystemServiceSafe("connectivity")) != null && (activeNetworkInfo = ((ConnectivityManager) systemServiceSafe).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    int b11 = e.a(this.f28125b).b();
                    if (a(b11)) {
                        return s.a("002;hiid");
                    }
                    if (c(b11)) {
                        return s.a("002Ihlid");
                    }
                    return s.a(d(b11) ? "002Ljfid" : "002Gheid");
                } else if (type == 1) {
                    return s.a("004Qfgdiefdi");
                } else {
                    switch (type) {
                        case 6:
                            return s.a("005'fgdidf3d9ei");
                        case 7:
                            return s.a("009>ffLg,dg=fi0dkdkLih");
                        case 8:
                            return s.a("005$dcdgdfdfec");
                        case 9:
                            return s.a("008fihf=djXefi");
                        default:
                            return String.valueOf(type);
                    }
                }
            }
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
        return s.a("004e4dk]ef");
    }

    public synchronized int getDtNtType() {
        if (this.f28128e == null) {
            this.f28128e = Integer.valueOf(d());
        }
        return this.f28128e.intValue();
    }

    @SuppressLint({"MissingPermission"})
    public String getNetworkTypeDesensitized() {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo = null;
        try {
            if (DH.SyncMtd.checkPermission(s.a("039deTdcdjdkdidcdl)jf)djdfdififididk'e_dlfdededgieleldheggifcgfghgjicdhelfcfdfcgi")) && (connectivityManager = (ConnectivityManager) DH.SyncMtd.getSystemServiceSafe("connectivity")) != null) {
                networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return s.a("004Jfgdiefdi");
                }
                networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                    networkInfo = connectivityManager.getNetworkInfo(7);
                    if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                        networkInfo = connectivityManager.getNetworkInfo(8);
                        if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                            networkInfo = connectivityManager.getNetworkInfo(9);
                            if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                                networkInfo = connectivityManager.getNetworkInfo(6);
                                if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                                    String a11 = s.a("005Ffgdidf(dYei");
                                    NLog instance = MobLog.getInstance();
                                    instance.d("networkInfo: " + networkInfo, new Object[0]);
                                    return a11;
                                }
                            } else {
                                String a12 = s.a("008fihf]djLefi");
                                NLog instance2 = MobLog.getInstance();
                                instance2.d("networkInfo: " + networkInfo, new Object[0]);
                                return a12;
                            }
                        } else {
                            String a13 = s.a("005]dcdgdfdfec");
                            NLog instance3 = MobLog.getInstance();
                            instance3.d("networkInfo: " + networkInfo, new Object[0]);
                            return a13;
                        }
                    } else {
                        String a14 = s.a("009VffDg$dg4fiHdkdk^ih");
                        NLog instance4 = MobLog.getInstance();
                        instance4.d("networkInfo: " + networkInfo, new Object[0]);
                        return a14;
                    }
                } else {
                    String subtypeName = networkInfo.getSubtypeName();
                    if (s.a("002Ceggj").equalsIgnoreCase(subtypeName)) {
                        String a15 = s.a("002Ohiid");
                        NLog instance5 = MobLog.getInstance();
                        instance5.d("networkInfo: " + networkInfo, new Object[0]);
                        return a15;
                    } else if (s.a("003Vfefcgi").equalsIgnoreCase(subtypeName)) {
                        String a16 = s.a("002Thlid");
                        NLog instance6 = MobLog.getInstance();
                        instance6.d("networkInfo: " + networkInfo, new Object[0]);
                        return a16;
                    } else if (a(subtypeName)) {
                        String a17 = s.a("002@jfid");
                        NLog instance7 = MobLog.getInstance();
                        instance7.d("networkInfo: " + networkInfo, new Object[0]);
                        return a17;
                    } else if (b(subtypeName)) {
                        String a18 = s.a("0028heid");
                        NLog instance8 = MobLog.getInstance();
                        instance8.d("networkInfo: " + networkInfo, new Object[0]);
                        return a18;
                    } else {
                        NLog instance9 = MobLog.getInstance();
                        instance9.d("networkInfo: " + networkInfo, new Object[0]);
                        return subtypeName;
                    }
                }
            }
            NLog instance10 = MobLog.getInstance();
            instance10.d("networkInfo: " + networkInfo, new Object[0]);
        } catch (Throwable th2) {
            MobLog.getInstance().e(th2);
        } finally {
            NLog instance11 = MobLog.getInstance();
            instance11.d("networkInfo: " + networkInfo, new Object[0]);
        }
        return s.a("004e6dk*ef");
    }

    public synchronized String getNtType() {
        if (TextUtils.isEmpty(this.f28127d)) {
            this.f28127d = g();
        }
        return this.f28127d;
    }

    public void recycle() {
        f();
    }

    @SuppressLint({"MissingPermission"})
    private void a() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) DH.SyncMtd.getSystemServiceSafe("connectivity");
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 26 && DH.SyncMtd.checkPermission(s.a("039de_dcdjdkdidcdl!jf*djdfdififididk<e>dlfdededgieleldheggifcgfghgjicdhelfcfdfcgi"))) {
                connectivityManager.registerDefaultNetworkCallback(b());
            } else if (i11 < 21 || !DH.SyncMtd.checkPermission(s.a("039deCdcdjdkdidcdl<jfYdjdfdififididk)e%dlfdededgieleldheggifcgfghgjicdhelfcfdfcgi"))) {
                e();
            } else {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), b());
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }

    private boolean b(Object obj) {
        Object obj2;
        if (obj != null && DH.SyncMtd.checkPermission(s.a("035de8dcdjdkdidcdl3jfKdjdfdififididk e]dlgjgifdfldhglfkgheggidhelfcfdfcgi")) && Build.VERSION.SDK_INT >= 26) {
            if (CSCenter.getInstance().isPhoneStateDataEnable()) {
                obj2 = ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("0157ejOfi)el=fKdjdddi,cfYel:idif"), null, new Object[0]);
            } else {
                obj2 = CSCenter.getInstance().getServiceState();
            }
            if (obj2 == null || ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj2, s.a("010:ejYfi^egdjel6idif"), 0, new Object[0])).intValue() != 3) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean b(String str) {
        return s.a("0046eeflgieg").equalsIgnoreCase(str) | ((s.a("004Pedflhcfd").equalsIgnoreCase(str) | s.a("0041giflidgi").equalsIgnoreCase(str)) | s.a("004Yidglgjel").equalsIgnoreCase(str));
    }

    private boolean a(int i11) {
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(PlaceFields.PHONE);
        if (systemServiceSafe == null) {
            return false;
        }
        if (!a(systemServiceSafe) && !b(systemServiceSafe)) {
            return b(i11);
        }
        return true;
    }

    private boolean a(Object obj) {
        Object obj2;
        if (obj != null && DH.SyncMtd.checkPermission(s.a("035de]dcdjdkdidcdl^jf8djdfdififididk=eZdlgjgifdfldhglfkgheggidhelfcfdfcgi"))) {
            if (CSCenter.getInstance().isPhoneStateDataEnable()) {
                String manufacturer = DH.SyncMtd.getManufacturer();
                obj2 = null;
                if (!TextUtils.isEmpty(manufacturer) && ((manufacturer.contains(s.a("006hPdgQdWfg]f5di")) || manufacturer.contains(s.a("006KfkdgYd^fgHfBdi")) || manufacturer.contains(s.a("006%fkekfdgfgiee"))) && Build.VERSION.SDK_INT >= 29)) {
                    obj2 = ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("015AejPfi:elVfUdjdddi(cf.elYidif"), null, new Object[0]);
                }
            } else {
                obj2 = CSCenter.getInstance().getServiceState();
            }
            if (obj2 == null || ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj2, s.a("016Gej9fi:fkfgeg-fi4fgdkdjehfcec.jf"), 0, new Object[0])).intValue() != 20) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean a(String str) {
        return s.a("005Lfkelglfdgl").equalsIgnoreCase(str) | (((((((s.a("006Ygigkflghdhfh").equalsIgnoreCase(str) | s.a("006Ogigkflghdhfd").equalsIgnoreCase(str)) | s.a("005+fkelflglfd").equalsIgnoreCase(str)) | s.a("004>fkelglfd").equalsIgnoreCase(str)) | s.a("0059fkelekglfd").equalsIgnoreCase(str)) | s.a("0048ekhcfcel").equalsIgnoreCase(str)) | s.a("0055gifkgjglfl").equalsIgnoreCase(str)) | s.a("006Vgigkflghdhfj").equalsIgnoreCase(str));
    }
}
