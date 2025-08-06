package com.sumsub.sns.internal.core.analytics;

import com.sumsub.sns.internal.core.data.model.DocumentType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.l;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Screen f31887a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31888b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Object> f31889c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, Object> f31890d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, Object> f31891e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, Object> f31892f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31893g;

    public c(Screen screen, String str, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<String, ? extends Object> map3, Map<String, ? extends Object> map4) {
        this.f31887a = screen;
        this.f31888b = str;
        this.f31889c = map;
        this.f31890d = map2;
        this.f31891e = map3;
        this.f31892f = map4;
    }

    public final boolean a() {
        return this.f31893g;
    }

    public final Screen b() {
        return this.f31887a;
    }

    public final void c() {
        a(this.f31887a, this.f31888b, this.f31890d);
    }

    public final void d() {
        if (this.f31893g) {
            b(this.f31887a, this.f31888b, this.f31892f);
        } else {
            c(this.f31887a, this.f31888b, this.f31891e);
        }
    }

    public final void e() {
        d(this.f31887a, this.f31888b, this.f31889c);
    }

    public static /* synthetic */ void b(c cVar, Screen screen, String str, Control control, Map map, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            map = MapsKt__MapsKt.h();
        }
        cVar.b(screen, str, control, map);
    }

    public static /* synthetic */ void c(c cVar, Screen screen, String str, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = MapsKt__MapsKt.h();
        }
        cVar.c(screen, str, map);
    }

    public final void a(boolean z11) {
        this.f31893g = z11;
    }

    public static /* synthetic */ void a(c cVar, Screen screen, String str, Control control, Map map, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            map = MapsKt__MapsKt.h();
        }
        cVar.a(screen, str, control, map);
    }

    public final void c(Screen screen, String str, Map<String, ? extends Object> map) {
        if (screen != Screen.Other) {
            o.a(f.a(0, 1, (Object) null).a(screen).a().o().a((Map<String, ? extends Object>) MapsKt__MapsKt.o(a(screen, str), map)), false, 1, (Object) null);
        }
    }

    public static /* synthetic */ void d(c cVar, Screen screen, String str, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = MapsKt__MapsKt.h();
        }
        cVar.d(screen, str, map);
    }

    public final void b(Screen screen, String str, Control control, Map<String, ? extends Object> map) {
        if (screen != Screen.Other) {
            o.a(f.a(0, 1, (Object) null).a(screen).a(control).g().a((Map<String, ? extends Object>) MapsKt__MapsKt.o(a(screen, str), map)), false, 1, (Object) null);
        }
    }

    public final void a(Screen screen, String str, Control control, Map<String, ? extends Object> map) {
        if (screen != Screen.Other) {
            o.a(f.a(0, 1, (Object) null).a(screen).a(control).h().a((Map<String, ? extends Object>) MapsKt__MapsKt.o(a(screen, str), map)), false, 1, (Object) null);
        }
    }

    public final void d(Screen screen, String str, Map<String, ? extends Object> map) {
        if (screen != Screen.Other) {
            o.a(f.a(0, 1, (Object) null).a(screen).a().b().a((Map<String, ? extends Object>) MapsKt__MapsKt.o(a(screen, str), map)), false, 1, (Object) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Screen screen, String str, Map map, Map map2, Map map3, Map map4, int i11, r rVar) {
        this(screen, str, (i11 & 4) != 0 ? MapsKt__MapsKt.h() : map, (i11 & 8) != 0 ? MapsKt__MapsKt.h() : map2, (i11 & 16) != 0 ? MapsKt__MapsKt.h() : map3, (i11 & 32) != 0 ? MapsKt__MapsKt.h() : map4);
    }

    public static /* synthetic */ void b(c cVar, Screen screen, String str, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = MapsKt__MapsKt.h();
        }
        cVar.b(screen, str, map);
    }

    public static /* synthetic */ void a(c cVar, Screen screen, String str, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = MapsKt__MapsKt.h();
        }
        cVar.a(screen, str, map);
    }

    public final void b(Screen screen, String str, Map<String, ? extends Object> map) {
        if (screen != Screen.Other) {
            o.a(f.a(0, 1, (Object) null).a(screen).a().m().a((Map<String, ? extends Object>) MapsKt__MapsKt.o(a(screen, str), map)), false, 1, (Object) null);
        }
    }

    public final void a(Screen screen, String str, Map<String, ? extends Object> map) {
        if (screen != Screen.Other) {
            o.a(f.a(0, 1, (Object) null).a(screen).a().j().a((Map<String, ? extends Object>) MapsKt__MapsKt.o(a(screen, str), map)), false, 1, (Object) null);
        }
    }

    public static /* synthetic */ void b(c cVar, Screen screen, Map map, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            map = MapsKt__MapsKt.h();
        }
        cVar.b(screen, map);
    }

    public static /* synthetic */ void a(c cVar, Screen screen, Map map, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            map = MapsKt__MapsKt.h();
        }
        cVar.a(screen, (Map<String, ? extends Object>) map);
    }

    public final void b(Screen screen, Map<String, ? extends Object> map) {
        if (screen != Screen.Other) {
            o.a(f.a(0, 1, (Object) null).a(screen).a(Control.BottomSheet).i().a((Map<String, ? extends Object>) MapsKt__MapsKt.o(a(screen, this.f31888b), map)), false, 1, (Object) null);
        }
    }

    public final void a(Screen screen, Map<String, ? extends Object> map) {
        if (screen != Screen.Other) {
            o.a(f.a(0, 1, (Object) null).a(screen).a(Control.BottomSheet).k().a((Map<String, ? extends Object>) MapsKt__MapsKt.o(a(screen, this.f31888b), map)), false, 1, (Object) null);
        }
    }

    public final Map<String, Object> a(Map<GlobalStatePayload, ? extends Object> map) {
        Set<Map.Entry<GlobalStatePayload, ? extends Object>> entrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.d(MapsKt__MapsJVMKt.d(CollectionsKt__IterablesKt.u(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Pair a11 = l.a(((GlobalStatePayload) entry.getKey()).getText(), entry.getValue());
            linkedHashMap.put(a11.getFirst(), a11.getSecond());
        }
        return linkedHashMap;
    }

    public final Map<String, Object> a(Screen screen, String str) {
        Map map;
        Map o11 = MapsKt__MapsKt.o(b.f31873a.f(), MapsKt__MapsJVMKt.e(l.a(GlobalStatePayload.Screen, screen.getText())));
        if (!x.b(str, DocumentType.f32355j)) {
            map = MapsKt__MapsJVMKt.e(l.a(GlobalStatePayload.IdDocSetType, str));
        } else {
            map = MapsKt__MapsKt.h();
        }
        return a((Map<GlobalStatePayload, ? extends Object>) MapsKt__MapsKt.o(o11, map));
    }
}
