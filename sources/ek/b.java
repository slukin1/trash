package ek;

import android.content.Context;
import com.huobi.edgeengine.ability.s;
import com.huobi.edgeengine.template.widget.Widget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Pair;
import rj.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f47515a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static WeakHashMap<String, rj.b> f47516b = new WeakHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f47517c = new HashMap<>();

    public final void a(String str) {
        Integer num = f47517c.get(str);
        c("更新生命周期 : " + str + "   " + num);
        if (num != null && num.intValue() == 0) {
            c("销毁" + str + " edgeEngine对象");
            h(str);
        }
    }

    public final rj.b b(Context context, String str) {
        rj.b bVar = f47516b.containsKey(str) ? f47516b.get(str) : null;
        if (bVar == null) {
            bVar = new rj.b(context, str);
            bVar.H();
            f47516b.put(str, bVar);
            f(bVar, str);
        }
        d(str);
        System.out.println("EdgeEngine=====>>> " + bVar + ", scene = " + str + ", count = " + f47517c.get(str));
        return bVar;
    }

    public final void c(String str) {
    }

    public final void d(String str) {
        HashMap<String, Integer> hashMap = f47517c;
        Integer num = hashMap.get(str);
        if (num == null) {
            num = 0;
        }
        hashMap.put(str, Integer.valueOf(num.intValue() + 1));
    }

    public final void e(String str) {
        HashMap<String, Integer> hashMap = f47517c;
        Integer num = hashMap.get(str);
        if (num == null) {
            num = 0;
        }
        hashMap.put(str, Integer.valueOf(num.intValue() - 1));
        a(str);
    }

    public final void f(rj.b bVar, String str) {
        c cVar = c.f47785a;
        ArrayList<Pair<String, Class<? extends s>>> b11 = cVar.b();
        b11.addAll(cVar.a(str));
        for (Pair pair : b11) {
            bVar.t((String) pair.getFirst(), (Class) pair.getSecond());
        }
        c cVar2 = c.f47785a;
        ArrayList<Pair<String, Class<? extends Widget>>> c11 = cVar2.c();
        c11.addAll(cVar2.e(str));
        for (Pair pair2 : c11) {
            bVar.A((String) pair2.getFirst(), (Class) pair2.getSecond());
        }
        for (Pair pair3 : c.f47785a.d(str)) {
            bVar.z((String) pair3.getFirst(), (Class) pair3.getSecond());
        }
    }

    public final void g() {
        for (Map.Entry<String, rj.b> value : f47516b.entrySet()) {
            try {
                ((rj.b) value.getValue()).B();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        f47516b.clear();
    }

    public final void h(String str) {
        if (f47516b.containsKey(str)) {
            rj.b bVar = f47516b.get(str);
            if (bVar != null) {
                bVar.B();
            }
            f47516b.remove(str);
        }
    }

    public final void i(String str) {
        rj.b bVar;
        if (f47516b.containsKey(str) && (bVar = f47516b.get(str)) != null) {
            bVar.C();
        }
    }
}
