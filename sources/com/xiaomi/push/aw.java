package com.xiaomi.push;

import android.net.NetworkInfo;
import java.util.concurrent.ConcurrentHashMap;

public class aw {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkInfo f51409a;

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentHashMap<String, Object> f2544a = new ConcurrentHashMap<>();

    public aw(NetworkInfo networkInfo) {
        this.f51409a = networkInfo;
    }

    private <T> T a(String str) {
        if (!this.f2544a.containsKey(str)) {
            synchronized (str) {
                if (!this.f2544a.contains(str)) {
                    Object obj = null;
                    char c11 = 65535;
                    switch (str.hashCode()) {
                        case -830707388:
                            if (str.equals("getSubtype")) {
                                c11 = 2;
                                break;
                            }
                            break;
                        case -75106384:
                            if (str.equals("getType")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case -66906641:
                            if (str.equals("getSubtypeName")) {
                                c11 = 3;
                                break;
                            }
                            break;
                        case 599209215:
                            if (str.equals("isConnected")) {
                                c11 = 4;
                                break;
                            }
                            break;
                        case 711698955:
                            if (str.equals("getDetailedState")) {
                                c11 = 6;
                                break;
                            }
                            break;
                        case 1401392731:
                            if (str.equals("getTypeName")) {
                                c11 = 1;
                                break;
                            }
                            break;
                        case 1965583067:
                            if (str.equals("getState")) {
                                c11 = 5;
                                break;
                            }
                            break;
                    }
                    switch (c11) {
                        case 0:
                            obj = Integer.valueOf(this.f51409a.getType());
                            break;
                        case 1:
                            obj = this.f51409a.getTypeName();
                            break;
                        case 2:
                            obj = Integer.valueOf(this.f51409a.getSubtype());
                            break;
                        case 3:
                            obj = this.f51409a.getSubtypeName();
                            break;
                        case 4:
                            obj = Boolean.valueOf(this.f51409a.isConnected());
                            break;
                        case 5:
                            obj = this.f51409a.getState();
                            break;
                        case 6:
                            obj = this.f51409a.getDetailedState();
                            break;
                    }
                    if (obj != null) {
                        this.f2544a.put(str, obj);
                    }
                }
            }
        }
        return this.f2544a.get(str);
    }

    public int b() {
        return ((Integer) a("getSubtype")).intValue();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m2412b() {
        return (String) a("getSubtypeName");
    }

    public int a() {
        return ((Integer) a("getType")).intValue();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2410a() {
        return (String) a("getTypeName");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2411a() {
        return ((Boolean) a("isConnected")).booleanValue();
    }

    /* renamed from: a  reason: collision with other method in class */
    public NetworkInfo.State m2409a() {
        return (NetworkInfo.State) a("getState");
    }

    /* renamed from: a  reason: collision with other method in class */
    public NetworkInfo.DetailedState m2408a() {
        return (NetworkInfo.DetailedState) a("getDetailedState");
    }
}
