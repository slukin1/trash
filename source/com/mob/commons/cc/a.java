package com.mob.commons.cc;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import com.mob.commons.cc.m;
import com.mob.commons.cc.x;
import com.mob.commons.n;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.MobPersistence;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final r f27122a = new r();

    /* renamed from: b  reason: collision with root package name */
    private static final j f27123b = new j();

    /* renamed from: c  reason: collision with root package name */
    private static final o f27124c = new o();

    /* renamed from: d  reason: collision with root package name */
    private static volatile m f27125d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static volatile m f27126e;

    static {
        try {
            f27125d = new m(new m.a() {
                public Object a(String str, ArrayList<Object> arrayList) {
                    try {
                        if (a.f27126e != null) {
                            return a.f27126e.a(str, arrayList);
                        }
                        return null;
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
            f27126e = new m(new m.a() {
                public Object a(String str, ArrayList<Object> arrayList) {
                    return str + "" + arrayList;
                }
            });
            f27125d.a(TtmlNode.TAG_TT, (ArrayList<Object>) null);
        } catch (Throwable unused) {
        }
    }

    public static int a() {
        return x.a();
    }

    public static void a(Context context, byte[] bArr, String str, Method method) throws Throwable {
        a(x.a(bArr), context, str, method);
    }

    public static void a(Context context, String str, String str2, Method method) throws Throwable {
        a(x.a(str), context, str2, method);
    }

    public static void a(Context context, String str, String str2, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) throws Throwable {
        x.c a11 = x.a(str);
        a11.a("ss_dhMap", (Object) hashMap).a("ss_dataMaps", (Object) hashMap2);
        a(a11, context, str2, (Method) null);
    }

    public static LinkedList<Object> a(Object obj, Object... objArr) throws Throwable {
        return ((z) obj).b(objArr);
    }

    private static void a(x.c cVar, Context context, String str, Method method) throws Throwable {
        Class<r> cls = r.class;
        Class<g> cls2 = g.class;
        Class<n> cls3 = n.class;
        Class<o> cls4 = o.class;
        Class<d> cls5 = d.class;
        Class<j> cls6 = j.class;
        cVar.a(com.mob.commons.m.a("012%ef hdYbh2bgAbgbi%c:cjMdg"), (Class<?>) cls6).a(com.mob.commons.m.a("003?faceda"), (Class<?>) cls5).a("SBSP", (Class<?>) cls4).a(com.mob.commons.m.a("004Tfacjejdi"), (Class<?>) cls2).a(com.mob.commons.m.a("015_cjdhdi(bcWbaTedYbhda:fHbh@db4ba"), (Class<?>) MobHandlerThread.class).a(com.mob.commons.m.a("019?cjdhdhbhbi4bGbaOab*dg1g>eh$dadGbgbbKd!bh"), (Class<?>) i.class).a(com.mob.commons.m.a("017@cjdhcbbiWcgdcg,ehJd%dgbi'e.bbSdXbh"), (Class<?>) l.class).a(com.mob.commons.m.a("0197cjdhcj,d_bhbbbg%ad<cbbi.ccdag7bgbiNc"), (Class<?>) p.class).a(com.mob.commons.m.a("017QcjdhcbbiCcgdcg1efdddgNd@bhbb2dVbh"), (Class<?>) k.class).a(com.mob.commons.m.a("017+cjdhceIdgNdebibhcfcb[beeEddSba_cf"), (Class<?>) cls3).a(com.mob.commons.m.a("009Lcjdhdi*bc)baLed!bh"), (Class<?>) m.class).a(com.mob.commons.m.a("003Ufacecb"), (Class<?>) NetCommunicator.class).a(com.mob.commons.m.a("004Sfacedaef"), (Class<?>) NetworkHelper.NetworkTimeOut.class).a("NoVaDataException", (Class<?>) MobPersistence.NoValidDataException.class).a(com.mob.commons.m.a("003Wdibicc"), (Class<?>) n.class).a(i.class, i.class).a(k.class, k.class).a(p.class, q.class).a(cls3, cls3).a(cls, cls).a(cls6, cls6).a(cls5, cls5).a(cls2, h.class).a(Context.class, c.class).a(PackageManager.class, f.class).a(NotificationManager.class, e.class).a(cls4, cls4).a(n.class, b.class).a("ss_sdh", (Object) f27124c).a("ss_opSet", (Object) f27123b).a("ss_suls", (Object) f27122a).a(com.mob.commons.m.a("015UdgdgbfIa]biKcgd.cg1g@ejZbGbhNbYbd"), (Object) context).a(com.mob.commons.m.a("014.dgdgbfdg*gbIbhJgZej?bPbhSb]bddg"), (Object) str).a(com.mob.commons.m.a("012?dgdgbfdgLgbDbhLg-dabgbdTd"), (Object) Long.valueOf(System.currentTimeMillis())).a(com.mob.commons.m.a("006^dgdgbfbdbaIh"), (Object) method).a(com.mob.commons.m.a("016aXbibdbdbi)cbh%bjdgbacfbjGa%baRa"));
        cVar.a();
    }
}
