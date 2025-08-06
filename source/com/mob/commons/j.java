package com.mob.commons;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.huobi.vulcan.model.VulcanInfo;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.b.c;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ResHelper;
import com.xiaomi.mipush.sdk.Constants;
import e7.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class j {

    /* renamed from: b  reason: collision with root package name */
    private static j f27251b = new j();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f27252a = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f27253c = false;

    /* renamed from: d  reason: collision with root package name */
    private volatile long f27254d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f27255e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f27256f = new ConcurrentHashMap<>();

    private j() {
    }

    private boolean d() {
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        DH.requester(MobSDK.getContext()).getCarrier().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                String carrier = dHResponse.getCarrier();
                if (!TextUtils.isEmpty(carrier) && !TextUtils.equals("-1", carrier)) {
                    linkedBlockingQueue.offer(Boolean.valueOf(!carrier.startsWith("460")));
                }
                linkedBlockingQueue.offer(Boolean.valueOf(!j.this.a(MobSDK.getContext())));
            }
        });
        try {
            Boolean bool = (Boolean) linkedBlockingQueue.poll(120, TimeUnit.MILLISECONDS);
            if (bool == null || !bool.booleanValue()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b() {
        return a(false);
    }

    public ConcurrentHashMap<String, Object> c() {
        return this.f27255e;
    }

    private synchronized boolean b(boolean z11) {
        String str;
        long j11;
        if (z11) {
            try {
                HashMap fromJson = HashonHelper.fromJson(ab.a().d());
                if (fromJson.isEmpty()) {
                    fromJson = HashonHelper.fromJson(ab.a().c());
                }
                j11 = ((Long) ResHelper.forceCast(fromJson.get(s.a("004fcfGei")), 5L)).longValue() * 1000;
                str = (String) ResHelper.forceCast(fromJson.get(s.a("002cMdc")), s.a("006^hehehfhfhfhf"));
            } catch (Throwable th2) {
                MobLog.getInstance().e(th2);
                return true;
            }
        } else {
            j11 = ((Long) b.a(s.a("004fcfTei"), 5L)).longValue() * 1000;
            str = (String) b.a(s.a("002c+dc"), s.a("006<hehehfhfhfhf"));
        }
        if (this.f27254d == 0 || System.currentTimeMillis() - this.f27254d > j11) {
            boolean a11 = a(str);
            if (this.f27254d == 0 || a11 != this.f27253c) {
                c(a11);
            }
            this.f27254d = System.currentTimeMillis();
            this.f27253c = a11;
            return a11;
        }
        return this.f27253c;
    }

    private void c(boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put(s.a("005cgfdZdj"), Integer.valueOf(z11 ^ true ? 1 : 0));
        hashMap.put(s.a("0021dg4c"), ResHelper.forceCast(this.f27255e.get(s.a("0021dg4c")), 0));
        hashMap.put(s.a("002Edgdc"), ResHelper.forceCast(this.f27255e.get(s.a("002Edgdc")), 0));
        hashMap.put(s.a("002)ddJj"), ResHelper.forceCast(this.f27255e.get(s.a("002)ddJj")), 0));
        hashMap.put(s.a("002NfgRj"), ResHelper.forceCast(this.f27255e.get(s.a("002NfgRj")), 0));
        hashMap.put(s.a("002Cdj>i"), ResHelper.forceCast(this.f27255e.get(s.a("002Cdj>i")), 0));
        hashMap.put(s.a("002*ei'j"), ResHelper.forceCast(this.f27255e.get(s.a("002*ei'j")), 0));
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(s.a("004i@ecSjf"), "ECMT");
        hashMap2.put(s.a("004%dc did"), hashMap);
        hashMap2.put(s.a("008=dcEdifi didf?f"), Long.valueOf(currentTimeMillis));
        c.a().a(currentTimeMillis, (HashMap<String, Object>) hashMap2);
    }

    public static j a() {
        return f27251b;
    }

    public synchronized boolean a(boolean z11) {
        return !b(z11);
    }

    private boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            char[] charArray = str.toCharArray();
            HashMap hashMap = new HashMap();
            boolean z11 = false;
            for (int i11 = 0; i11 < charArray.length; i11++) {
                if (charArray[i11] == '1') {
                    z11 |= a(i11);
                } else if (charArray[i11] != '0') {
                    List list = (List) hashMap.get(Character.valueOf(charArray[i11]));
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(Integer.valueOf(i11));
                    hashMap.put(Character.valueOf(charArray[i11]), list);
                }
            }
            for (Map.Entry value : hashMap.entrySet()) {
                boolean z12 = true;
                for (Integer intValue : (List) value.getValue()) {
                    z12 &= a(intValue.intValue());
                }
                z11 |= z12;
            }
            return z11;
        } catch (Throwable th2) {
            MobLog.getInstance().e(th2);
            return true;
        }
    }

    private boolean b(String str) {
        String d11 = v.d();
        if (TextUtils.isEmpty(d11) || d11.length() < str.length()) {
            return false;
        }
        String[] split = d11.split("");
        char[] charArray = str.toCharArray();
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean z11 = false;
        for (int i11 = 0; i11 < charArray.length; i11++) {
            if (charArray[i11] == '1') {
                z11 |= TextUtils.equals(split[i11], "1");
            } else if (charArray[i11] == '2') {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        if (arrayList.size() <= 0) {
            return z11;
        }
        boolean z12 = true;
        for (Integer intValue : arrayList) {
            z12 &= TextUtils.equals(split[intValue.intValue()], "1");
        }
        return z11 | z12;
    }

    private boolean a(final int i11) {
        final boolean[] zArr = {true};
        DH.RequestBuilder requester = DH.requester(MobSDK.getContext());
        if (i11 == 0) {
            requester.checkUA();
        } else if (i11 == 1) {
            requester.usbEnable();
        } else if (i11 == 2) {
            requester.vpn();
        } else if (i11 == 3) {
            requester.isMwpy();
        } else if (i11 == 4) {
            requester.isRooted();
        } else if (i11 == 5) {
            requester.cx();
        }
        requester.request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                int i11 = i11;
                if (i11 == 0) {
                    zArr[0] = dHResponse.checkUA();
                    j.this.f27255e.put(s.a("002^dgQc"), Integer.valueOf(zArr[0] ? 1 : 0));
                } else if (i11 == 1) {
                    zArr[0] = dHResponse.usbEnable();
                    j.this.f27255e.put(s.a("002Xdgdc"), Integer.valueOf(zArr[0] ? 1 : 0));
                } else if (i11 == 2) {
                    zArr[0] = dHResponse.vpn();
                    j.this.f27255e.put(s.a("002:ddHj"), Integer.valueOf(zArr[0] ? 1 : 0));
                } else if (i11 == 3) {
                    zArr[0] = dHResponse.isMwpy();
                    j.this.f27255e.put(s.a("0027fg*j"), Integer.valueOf(zArr[0] ? 1 : 0));
                } else if (i11 == 4) {
                    zArr[0] = dHResponse.isRooted();
                    j.this.f27255e.put(s.a("002!dj^i"), Integer.valueOf(zArr[0] ? 1 : 0));
                } else if (i11 == 5) {
                    zArr[0] = dHResponse.cx();
                    j.this.f27255e.put(s.a("002Eei8j"), Integer.valueOf(zArr[0] ? 1 : 0));
                }
            }
        });
        return zArr[0];
    }

    public boolean a(HashMap<String, Object> hashMap) {
        try {
            List<String> list = (List) ResHelper.forceCast(hashMap.get("j"), null);
            if (list != null && list.size() > 0) {
                boolean z11 = false;
                boolean z12 = false;
                for (String str : list) {
                    if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        boolean z13 = true;
                        for (String a11 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            z13 &= a(a11, hashMap);
                        }
                        z12 |= z13;
                    } else {
                        z12 |= a(str, hashMap);
                    }
                }
                ConcurrentHashMap<String, Object> concurrentHashMap = this.f27255e;
                String a12 = s.a("0063ej;jBdhdj(f5fi");
                if (!z12) {
                    z11 = true;
                }
                concurrentHashMap.put(a12, Boolean.valueOf(z11));
                return !z12;
            }
        } catch (Throwable th2) {
            MobLog.getInstance().e(th2);
        }
        this.f27255e.put(s.a("006Qej*jKdhdj)f:fi"), Boolean.TRUE);
        return true;
    }

    private boolean b(final ArrayList<Boolean> arrayList, final List<String> list) {
        DH.RequestBuilder requester = DH.requester(MobSDK.getContext());
        if (list == null || list.size() == 0) {
            return false;
        }
        for (String isPackageInstalled : list) {
            requester.isPackageInstalled(isPackageInstalled);
        }
        final boolean[] zArr = {false};
        requester.request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                int i11 = 0;
                while (i11 < list.size()) {
                    boolean isPackageInstalled = dHResponse.isPackageInstalled(i11);
                    arrayList.add(Boolean.valueOf(isPackageInstalled));
                    boolean[] zArr = zArr;
                    zArr[0] = isPackageInstalled | zArr[0];
                    if (!zArr[0]) {
                        i11++;
                    } else {
                        return;
                    }
                }
            }
        });
        return zArr[0];
    }

    private boolean a(String str, HashMap<String, Object> hashMap) {
        boolean z11 = true;
        if (TextUtils.equals(str, "a")) {
            if (((Integer) ResHelper.forceCast(hashMap.get("a"), 0)).intValue() != 1 || !d()) {
                z11 = false;
            }
            this.f27256f.put("a", Boolean.valueOf(z11));
            return z11;
        } else if (TextUtils.equals(str, TtmlNode.TAG_P)) {
            ArrayList arrayList = new ArrayList();
            boolean b11 = b(arrayList, (List) ResHelper.forceCast(hashMap.get(TtmlNode.TAG_P), null));
            this.f27256f.put(TtmlNode.TAG_P, arrayList);
            return b11;
        } else if (TextUtils.equals(str, VulcanInfo.FP)) {
            ArrayList arrayList2 = new ArrayList();
            boolean b12 = b(arrayList2, (List) ResHelper.forceCast(hashMap.get(VulcanInfo.FP), null));
            this.f27256f.put(VulcanInfo.FP, arrayList2);
            return b12;
        } else if (TextUtils.equals(str, s.f70071a)) {
            boolean a11 = a((ArrayList<Boolean>) new ArrayList(), (List<String>) (List) ResHelper.forceCast(hashMap.get(s.f70071a), null));
            this.f27256f.put(s.f70071a, Boolean.valueOf(a11));
            return a11;
        } else if (TextUtils.equals(str, "fs")) {
            boolean a12 = a((ArrayList<Boolean>) new ArrayList(), (List<String>) (List) ResHelper.forceCast(hashMap.get("fs"), null));
            this.f27256f.put("fs", Boolean.valueOf(a12));
            return a12;
        } else if (TextUtils.equals(str, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
            if (((Integer) ResHelper.forceCast(hashMap.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG), 0)).intValue() != 1 || !c.a(MobSDK.getContext()).d().aw()) {
                z11 = false;
            }
            this.f27256f.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, Boolean.valueOf(z11));
            return z11;
        } else if (!TextUtils.equals(str, "bl")) {
            return false;
        } else {
            boolean b13 = b((String) ResHelper.forceCast(hashMap.get("bl"), ""));
            this.f27256f.put("bl", Boolean.valueOf(b13));
            return b13;
        }
    }

    /* access modifiers changed from: private */
    public boolean a(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return locale.getLanguage().startsWith("zh") && TextUtils.equals(locale.getCountry(), "CN");
    }

    private boolean a(ArrayList<Boolean> arrayList, final List<String> list) {
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        if (list != null && list.size() > 0) {
            DH.RequestBuilder requester = DH.requester(MobSDK.getContext());
            for (int i11 = 0; i11 < list.size(); i11++) {
                requester.queryIntentServices(new Intent(list.get(i11)), 0);
            }
            requester.request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        List<ResolveInfo> queryIntentServices = dHResponse.queryIntentServices(i11);
                        if (queryIntentServices != null && queryIntentServices.size() > 0) {
                            linkedBlockingQueue.offer(Boolean.TRUE);
                        }
                    }
                    linkedBlockingQueue.offer(Boolean.FALSE);
                }
            });
        }
        try {
            Boolean bool = (Boolean) linkedBlockingQueue.poll(150, TimeUnit.MILLISECONDS);
            if (bool == null || !bool.booleanValue()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void a(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, HashMap<String, Object> hashMap3) {
        try {
            Object obj = this.f27255e.get(s.a("006fNdfdhdjTf5fi"));
            Boolean bool = Boolean.FALSE;
            boolean booleanValue = ((Boolean) ResHelper.forceCast(obj, bool)).booleanValue();
            boolean booleanValue2 = ((Boolean) ResHelper.forceCast(this.f27255e.get(s.a("006Fej-j,dhdjUfSfi")), bool)).booleanValue();
            HashMap hashMap4 = new HashMap(4);
            hashMap4.put(s.a("003ZdjYf[fi"), Boolean.valueOf(booleanValue));
            hashMap4.put(s.a("003>djdidc"), ResHelper.forceCast(hashMap.get(s.a("003>djdidc")), null));
            if (booleanValue || hashMap2 == null) {
                hashMap4.put(s.a("003:fididc"), ResHelper.forceCast(hashMap.get(s.a("003:fididc")), null));
            } else {
                hashMap4.put(s.a("003Wfididc"), ResHelper.forceCast(hashMap2.get(s.a("003Wfididc")), null));
            }
            this.f27255e.put(s.a("006f)dfdhdj2f7fi"), HashonHelper.fromHashMap(hashMap4));
            if (booleanValue) {
                HashMap hashMap5 = new HashMap(4);
                hashMap5.put(s.a("0031dj'f2fi"), Boolean.valueOf(booleanValue2));
                hashMap5.put(s.a("003Zdjdidc"), ResHelper.forceCast(hashMap.get(s.a("003Zdjdidc")), null));
                if (booleanValue2 || hashMap3 == null) {
                    hashMap5.put(s.a("0038fididc"), ResHelper.forceCast(hashMap.get(s.a("0038fididc")), null));
                } else {
                    hashMap5.put(s.a("0030fididc"), ResHelper.forceCast(hashMap3.get(s.a("0030fididc")), null));
                }
                hashMap5.putAll(this.f27256f);
                this.f27255e.put(s.a("006[ejHjXdhdj;f$fi"), HashonHelper.fromHashMap(hashMap5));
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }
}
