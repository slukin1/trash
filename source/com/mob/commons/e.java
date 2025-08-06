package com.mob.commons;

import android.content.Context;
import android.text.TextUtils;
import com.mob.tools.MobLog;
import com.mob.tools.b.c;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.utils.i;
import java.util.HashMap;
import java.util.HashSet;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f27200a = null;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Boolean f27201b = null;

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f27202c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f27203d = false;

    /* renamed from: e  reason: collision with root package name */
    private static HashSet<String> f27204e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private static final a f27205f = new a();

    public static String b() {
        if (a()) {
            return null;
        }
        if (TextUtils.isEmpty(f27200a)) {
            String a11 = d().a();
            if (!TextUtils.isEmpty(a11) && TextUtils.isEmpty(f27200a)) {
                f27200a = a11;
            }
        }
        return f27200a;
    }

    /* access modifiers changed from: private */
    public static a d() {
        return f27205f;
    }

    public static boolean a() {
        return !b.a();
    }

    public static String a(Context context) {
        return c.a(context).d().ai();
    }

    public static synchronized String a(MobProduct mobProduct) {
        synchronized (e.class) {
            HashMap<String, Object> b11 = b(mobProduct);
            if (b11 == null) {
                return null;
            }
            String str = (String) b11.get(NetCommunicator.KEY_DUID);
            return str;
        }
    }

    public static synchronized HashMap<String, Object> b(final MobProduct mobProduct) {
        boolean z11;
        HashMap<String, Object> hashMap;
        synchronized (e.class) {
            boolean z12 = true;
            if (mobProduct != null) {
                aa.a(mobProduct);
                z11 = !f27204e.contains(mobProduct.getProductTag());
                if (z11) {
                    f27204e.add(mobProduct.getProductTag());
                }
            } else {
                z11 = false;
            }
            if (TextUtils.isEmpty(f27200a)) {
                f27200a = d().b();
            } else {
                z12 = z11;
            }
            MobLog.getInstance().d("aut pro: " + mobProduct + ", ndReg: " + z12 + ", hsReged: " + f27203d, new Object[0]);
            if (z12 || !f27203d) {
                z.f27384c.execute(new i() {
                    public void a() {
                        if (b.a(C0891r.b("0026cbch"))) {
                            boolean unused = e.f27203d = true;
                            if (!b.d()) {
                                int i11 = 0;
                                while (i11 < 5) {
                                    i11++;
                                    try {
                                        Thread.sleep(5000);
                                        if (b.d()) {
                                            break;
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                            if (b.d()) {
                                e.d().a(MobProduct.this, (com.mob.tools.utils.e<Void>) new com.mob.tools.utils.e<Void>() {
                                    public void a(Void voidR) {
                                    }
                                });
                            }
                        }
                    }
                });
            }
            if (f27201b == null) {
                String b11 = ab.a().b("key_curr_passed_duid", (String) null);
                f27202c = b11;
                if (TextUtils.isEmpty(b11) || b11.equals(f27200a)) {
                    f27201b = Boolean.FALSE;
                } else {
                    f27201b = Boolean.TRUE;
                }
            }
            ab.a().a("key_curr_passed_duid", f27200a);
            hashMap = new HashMap<>();
            hashMap.put(NetCommunicator.KEY_DUID, f27200a);
            hashMap.put(NetCommunicator.KEY_IS_MODIFIED, Boolean.valueOf(f27201b.booleanValue()));
            hashMap.put(NetCommunicator.KEY_DUID_PREVIOUS, f27202c);
        }
        return hashMap;
    }
}
