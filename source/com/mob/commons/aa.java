package com.mob.commons;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.cc.a;
import com.mob.tools.MobLog;
import com.mob.tools.b.d;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.i;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class aa {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f26980a = {s.a("008=elfkfdgjgielflic"), s.a("006Aelhcelelflic"), s.a("007Shcghfjfeeeegic"), s.a("007Dhcghfjglekelfk"), s.a("009 elgiedgkgigjeegcil"), s.a("008Qhcghfjfdflelflic"), s.a("008Uhcghfjidekfdgjfl")};

    /* renamed from: b  reason: collision with root package name */
    private static AtomicBoolean f26981b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private static AtomicBoolean f26982c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, MobProduct> f26983d = new HashMap<>();

    public static void a() {
        g();
        z.f27384c.execute(new i() {
            public void a() {
                MobLog.getInstance().d("init sks start", new Object[0]);
                aa.b();
                MobLog.getInstance().d("init sks over", new Object[0]);
            }
        });
    }

    public static ArrayList<MobProduct> b() {
        ArrayList<MobProduct> arrayList;
        HashMap<String, MobProduct> hashMap = f26983d;
        synchronized (hashMap) {
            if (x.h() && f26981b.compareAndSet(false, true)) {
                hashMap.putAll(h());
            }
            arrayList = new ArrayList<>();
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    public static synchronized String c() {
        String a11;
        synchronized (aa.class) {
            a11 = a(b(), 0);
        }
        return a11;
    }

    public static synchronized String d() {
        String a11;
        synchronized (aa.class) {
            a11 = a(b(), 1);
        }
        return a11;
    }

    public static synchronized String e() {
        String a11;
        synchronized (aa.class) {
            a11 = a(b(), 2);
        }
        return a11;
    }

    public static synchronized String f() {
        String a11;
        synchronized (aa.class) {
            a11 = a(b(), 3);
        }
        return a11;
    }

    private static void g() {
        if (x.h() && f26982c.compareAndSet(false, true)) {
            try {
                MOBLINK moblink = new MOBLINK();
                if (moblink instanceof MobProduct) {
                    moblink.getProductTag();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static HashMap<String, MobProduct> h() {
        Class<?> cls;
        Class<MobProduct> cls2 = MobProduct.class;
        HashMap<String, MobProduct> hashMap = new HashMap<>();
        for (Object next : t.f27341a) {
            try {
                if (next instanceof String) {
                    cls = Class.forName(String.valueOf(next).trim());
                } else {
                    cls = (Class) next;
                }
                if (cls2.isAssignableFrom(cls) && !cls2.equals(cls)) {
                    MobProduct mobProduct = (MobProduct) cls.newInstance();
                    String productTag = mobProduct.getProductTag();
                    String[] strArr = f26980a;
                    int length = strArr.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        }
                        String str = strArr[i11];
                        if (str.equals(productTag)) {
                            hashMap.put(str, mobProduct);
                            break;
                        }
                        i11++;
                    }
                } else {
                    cls.newInstance();
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static void a(MobProduct mobProduct) {
        HashMap<String, MobProduct> hashMap = f26983d;
        synchronized (hashMap) {
            if (mobProduct != null) {
                if (!hashMap.containsKey(mobProduct.getProductTag())) {
                    hashMap.put(mobProduct.getProductTag(), mobProduct);
                }
            }
        }
    }

    private static synchronized String a(final ArrayList<MobProduct> arrayList, final int i11) {
        String str;
        synchronized (aa.class) {
            final String[] strArr = {""};
            DH.RequestBuilder carrier = DH.requester(MobSDK.getContext()).getMIUIVersion().getDetailNetworkTypeForStatic().getCarrier();
            if (!x.b() || i11 == 3) {
                carrier.getDeviceKeyFromCache(true);
            } else {
                carrier.getDeviceKey();
            }
            carrier.request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) throws Throwable {
                    String str;
                    String str2;
                    String str3;
                    String str4 = "";
                    String encode = TextUtils.isEmpty(DH.SyncMtd.getPackageName()) ? str4 : URLEncoder.encode(DH.SyncMtd.getPackageName(), "utf-8");
                    String encode2 = TextUtils.isEmpty(DH.SyncMtd.getAppVersionName()) ? str4 : URLEncoder.encode(DH.SyncMtd.getAppVersionName(), "utf-8");
                    String encode3 = TextUtils.isEmpty(DH.SyncMtd.getManufacturer()) ? str4 : URLEncoder.encode(DH.SyncMtd.getManufacturer(), "utf-8");
                    String encode4 = TextUtils.isEmpty(DH.SyncMtd.getModel()) ? str4 : URLEncoder.encode(DH.SyncMtd.getModel(), "utf-8");
                    String encode5 = TextUtils.isEmpty(dHResponse.getMIUIVersion()) ? str4 : URLEncoder.encode(dHResponse.getMIUIVersion(), "utf-8");
                    String encode6 = TextUtils.isEmpty(DH.SyncMtd.getOSVersionName()) ? str4 : URLEncoder.encode(DH.SyncMtd.getOSVersionName(), "utf-8");
                    HashMap<String, Object> b11 = s.a().b();
                    String str5 = s.a("004Jfdglgl[l") + encode + ";" + encode2;
                    String str6 = s.a("012_elilel=lJfd.eFdcdjdkdidcjg") + DH.SyncMtd.getOSVersionInt() + ";" + encode6;
                    if (!x.b() || i11 == 3) {
                        str = dHResponse.getDeviceKeyFromCache(new int[0]);
                    } else {
                        str = dHResponse.getDeviceKey();
                        DH.DHResponse dHResponse2 = dHResponse;
                    }
                    String str7 = s.a("004-elfleeIl") + str;
                    String str8 = s.a("0038gchc=l") + encode3 + ";" + encode4;
                    if (!TextUtils.isEmpty(encode5)) {
                        str8 = str8 + ";" + encode5;
                    }
                    String str9 = s.a("003JeggiSl") + dHResponse.getDetailNetworkTypeForStatic() + ";" + dHResponse.getCarrier();
                    String str10 = s.a("005Jfe=deKejTl") + Locale.getDefault().toString().replace(s.a("0027hkdj"), Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    String str11 = s.a("0047edfegkOl") + MobSDK.SDK_VERSION_CODE;
                    String a11 = s.a("004Velflic1l");
                    if (!arrayList.isEmpty()) {
                        int size = arrayList.size();
                        int i11 = 0;
                        while (i11 < size) {
                            try {
                                MobProduct mobProduct = (MobProduct) arrayList.get(i11);
                                if (i11 != 0) {
                                    str3 = str4;
                                    try {
                                        a11 = a11 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                                    } catch (Throwable unused) {
                                    }
                                } else {
                                    str3 = str4;
                                }
                                try {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(a11);
                                    try {
                                        sb2.append(mobProduct.getProductTag());
                                        sb2.append(";");
                                        sb2.append(mobProduct.getSdkver());
                                        sb2.append(";");
                                        sb2.append(b11.get(mobProduct.getProductTag()));
                                        a11 = sb2.toString();
                                    } catch (Throwable unused2) {
                                        a11 = a11;
                                    }
                                } catch (Throwable unused3) {
                                    String str12 = a11;
                                }
                            } catch (Throwable unused4) {
                                str3 = str4;
                            }
                            i11++;
                            str4 = str3;
                        }
                    }
                    String str13 = str4;
                    String str14 = CSCenter.getInstance().isCusControllerNotNull() ? "DC/7" : "DC/2";
                    int i12 = i11;
                    if (i12 == 1) {
                        str14 = "DC/[DC]";
                    } else if (i12 == 2) {
                        str14 = "DC/[DC2]";
                    }
                    String timezone = DH.SyncMtd.getTimezone();
                    if (!TextUtils.isEmpty(timezone)) {
                        str2 = s.a("003Cfcijdh") + timezone;
                    } else {
                        str2 = str13;
                    }
                    String c11 = ac.a().c();
                    String str15 = "TID/";
                    if (!TextUtils.isEmpty(c11)) {
                        str15 = str15 + c11;
                    }
                    int a12 = a.a();
                    String str16 = "SVM/" + a12;
                    if (d.c()) {
                        if (!s.a("004!elflic9l").equals(a11)) {
                            a11 = a11 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                        }
                        a11 = a11 + "CS;" + a12;
                    }
                    String str17 = "RD/";
                    String f11 = y.a().f();
                    if (!TextUtils.isEmpty(f11)) {
                        str17 = str17 + f11;
                    }
                    strArr[0] = str5 + " " + str6 + " " + str7 + " " + str8 + " " + str9 + " " + str10 + " " + str11 + " " + a11 + " " + str14 + " " + str2 + " " + str15 + " " + str16 + " " + str17;
                }
            });
            str = strArr[0];
        }
        return str;
    }
}
