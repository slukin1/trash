package com.sumsub.sentry;

import com.sumsub.sns.internal.core.common.x;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.l;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.f;
import kotlinx.serialization.h;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.k;

@f(with = b.class)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 12\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0002\b\u0016B\t\b\u0016¢\u0006\u0004\b-\u0010.B\u0011\b\u0016\u0012\u0006\u0010/\u001a\u00020\u0000¢\u0006\u0004\b-\u00100J-\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002¢\u0006\u0004\b\b\u0010\tR(\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\b\u0010\u000eR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0012\"\u0004\b\b\u0010\u0013R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\b\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00198F@FX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\b\u0010\u001dR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e8F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\b\u0010\"R(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#8F@FX\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b\b\u0010'R(\u0010)\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(8F@FX\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b\b\u0010,¨\u00062"}, d2 = {"Lcom/sumsub/sentry/d;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "T", "key", "Ljava/lang/Class;", "clazz", "a", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "Lcom/sumsub/sentry/n0;", "traceContext", "j", "()Lcom/sumsub/sentry/n0;", "(Lcom/sumsub/sentry/n0;)V", "trace", "Lcom/sumsub/sentry/a;", "app", "()Lcom/sumsub/sentry/a;", "(Lcom/sumsub/sentry/a;)V", "Lcom/sumsub/sentry/c;", "browser", "b", "()Lcom/sumsub/sentry/c;", "(Lcom/sumsub/sentry/c;)V", "Lcom/sumsub/sentry/Device;", "device", "c", "()Lcom/sumsub/sentry/Device;", "(Lcom/sumsub/sentry/Device;)V", "Lcom/sumsub/sentry/q;", "operatingSystem", "g", "()Lcom/sumsub/sentry/q;", "(Lcom/sumsub/sentry/q;)V", "Lcom/sumsub/sentry/f0;", "runtime", "h", "()Lcom/sumsub/sentry/f0;", "(Lcom/sumsub/sentry/f0;)V", "Lcom/sumsub/sentry/j;", "gpu", "e", "()Lcom/sumsub/sentry/j;", "(Lcom/sumsub/sentry/j;)V", "<init>", "()V", "contexts", "(Lcom/sumsub/sentry/d;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class d extends ConcurrentHashMap<String, Object> {
    public static final a Companion = new a((r) null);

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<d> serializer() {
            return b.f30313a;
        }

        public a() {
        }
    }

    public d() {
    }

    public /* bridge */ boolean a(String str) {
        return super.containsKey(str);
    }

    public /* bridge */ Object b(String str) {
        return super.get(str);
    }

    public /* bridge */ Object c(String str) {
        return super.remove(str);
    }

    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return a((String) obj);
    }

    public /* bridge */ Set<Map.Entry<String, Object>> d() {
        return super.entrySet();
    }

    public final j e() {
        return (j) a(j.f30387j, j.class);
    }

    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return d();
    }

    public /* bridge */ Set<String> f() {
        return super.keySet();
    }

    public final q g() {
        return (q) a(q.f30469g, q.class);
    }

    public final /* bridge */ Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return b((String) obj);
    }

    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : a((String) obj, obj2);
    }

    public final f0 h() {
        return (f0) a(f0.f30340d, f0.class);
    }

    public /* bridge */ int i() {
        return super.size();
    }

    public final n0 j() {
        return (n0) a(n0.f30437i, n0.class);
    }

    public /* bridge */ Collection<Object> k() {
        return super.values();
    }

    public final /* bridge */ Set<String> keySet() {
        return f();
    }

    public final /* bridge */ Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return c((String) obj);
    }

    public final /* bridge */ int size() {
        return i();
    }

    public final /* bridge */ Collection<Object> values() {
        return k();
    }

    public d(d dVar) {
        for (Map.Entry next : dVar.entrySet()) {
            Object value = next.getValue();
            if (a.f30241h.equals(next.getKey()) && (value instanceof a)) {
                a(new a((a) value));
            } else if (c.f30298c.equals(next.getKey()) && (value instanceof c)) {
                a(new c((c) value));
            } else if ("device".equals(next.getKey()) && (value instanceof Device)) {
                a(new Device((Device) value));
            } else if (q.f30469g.equals(next.getKey()) && (value instanceof q)) {
                a(new q((q) value));
            } else if (f0.f30340d.equals(next.getKey()) && (value instanceof f0)) {
                a(new f0((f0) value));
            } else if (j.f30387j.equals(next.getKey()) && (value instanceof j)) {
                a(new j((j) value));
            } else if (!n0.f30437i.equals(next.getKey()) || !(value instanceof n0)) {
                put(next.getKey(), value);
            } else {
                a(new n0((n0) value));
            }
        }
    }

    public /* bridge */ Object a(String str, Object obj) {
        return super.getOrDefault(str, obj);
    }

    public /* bridge */ boolean b(String str, Object obj) {
        return super.remove(str, obj);
    }

    public final Device c() {
        return (Device) a("device", Device.class);
    }

    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if (!(obj instanceof String)) {
            return false;
        }
        return b((String) obj, obj2);
    }

    public final <T> T a(String str, Class<T> cls) {
        Object obj = get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public final c b() {
        return (c) a(c.f30298c, c.class);
    }

    public final void a(n0 n0Var) {
        Objects.requireNonNull(n0Var, "traceContext is required");
        put(n0.f30437i, n0Var);
    }

    public final a a() {
        return (a) a(a.f30241h, a.class);
    }

    public final void a(a aVar) {
        put(a.f30241h, aVar);
    }

    public final void a(c cVar) {
        put(c.f30298c, cVar);
    }

    public final void a(Device device) {
        put("device", device);
    }

    public final void a(q qVar) {
        put(q.f30469g, qVar);
    }

    public final void a(f0 f0Var) {
        put(f0.f30340d, f0Var);
    }

    public final void a(j jVar) {
        put(j.f30387j, jVar);
    }

    public static final class b implements kotlinx.serialization.b<d> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f30313a = new b();

        /* renamed from: b  reason: collision with root package name */
        public static final kotlinx.serialization.descriptors.f f30314b = SerialDescriptorsKt.a("ContextsSerializer", e.i.f57638a);

        /* renamed from: c  reason: collision with root package name */
        public static final kotlinx.serialization.json.a f30315c = x.a(false, 1, (Object) null);

        public static final class a<T> implements Comparator {
            public final int compare(T t11, T t12) {
                return kotlin.comparisons.a.a((String) ((Map.Entry) t11).getKey(), (String) ((Map.Entry) t12).getKey());
            }
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.d deserialize(kotlinx.serialization.encoding.c r8) {
            /*
                r7 = this;
                boolean r0 = r8 instanceof kotlinx.serialization.json.f
                if (r0 != 0) goto L_0x000a
                com.sumsub.sentry.d r8 = new com.sumsub.sentry.d
                r8.<init>()
                return r8
            L_0x000a:
                com.sumsub.sentry.d r0 = new com.sumsub.sentry.d
                r0.<init>()
                kotlinx.serialization.json.f r8 = (kotlinx.serialization.json.f) r8
                kotlinx.serialization.json.g r8 = r8.t()
                boolean r1 = r8 instanceof kotlinx.serialization.json.JsonObject
                if (r1 == 0) goto L_0x015f
                kotlinx.serialization.json.JsonObject r8 = (kotlinx.serialization.json.JsonObject) r8
                java.util.Set r1 = r8.keySet()
                java.util.Iterator r1 = r1.iterator()
            L_0x0023:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x015f
                java.lang.Object r2 = r1.next()
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r3 = r8.get(r2)
                kotlinx.serialization.json.g r3 = (kotlinx.serialization.json.g) r3
                if (r3 != 0) goto L_0x0038
                goto L_0x0023
            L_0x0038:
                int r4 = r2.hashCode()
                java.lang.String r5 = "kotlinx.serialization.serializer.withModule"
                switch(r4) {
                    case -1335157162: goto L_0x012f;
                    case 3556: goto L_0x0108;
                    case 96801: goto L_0x00e1;
                    case 102572: goto L_0x00b9;
                    case 110620997: goto L_0x0091;
                    case 150940456: goto L_0x006a;
                    case 1550962648: goto L_0x0043;
                    default: goto L_0x0041;
                }
            L_0x0041:
                goto L_0x0156
            L_0x0043:
                java.lang.String r4 = "runtime"
                boolean r4 = r2.equals(r4)
                if (r4 != 0) goto L_0x004d
                goto L_0x0156
            L_0x004d:
                kotlinx.serialization.json.a r2 = f30315c
                kotlinx.serialization.modules.d r4 = r2.a()
                java.lang.Class<com.sumsub.sentry.f0> r6 = com.sumsub.sentry.f0.class
                kotlin.reflect.p r6 = kotlin.jvm.internal.Reflection.n(r6)
                kotlin.jvm.internal.MagicApiIntrinsics.a(r5)
                kotlinx.serialization.b r4 = kotlinx.serialization.h.d(r4, r6)
                java.lang.Object r2 = r2.d(r4, r3)
                com.sumsub.sentry.f0 r2 = (com.sumsub.sentry.f0) r2
                r0.a((com.sumsub.sentry.f0) r2)
                goto L_0x0023
            L_0x006a:
                java.lang.String r4 = "browser"
                boolean r4 = r2.equals(r4)
                if (r4 != 0) goto L_0x0074
                goto L_0x0156
            L_0x0074:
                kotlinx.serialization.json.a r2 = f30315c
                kotlinx.serialization.modules.d r4 = r2.a()
                java.lang.Class<com.sumsub.sentry.c> r6 = com.sumsub.sentry.c.class
                kotlin.reflect.p r6 = kotlin.jvm.internal.Reflection.n(r6)
                kotlin.jvm.internal.MagicApiIntrinsics.a(r5)
                kotlinx.serialization.b r4 = kotlinx.serialization.h.d(r4, r6)
                java.lang.Object r2 = r2.d(r4, r3)
                com.sumsub.sentry.c r2 = (com.sumsub.sentry.c) r2
                r0.a((com.sumsub.sentry.c) r2)
                goto L_0x0023
            L_0x0091:
                java.lang.String r4 = "trace"
                boolean r4 = r2.equals(r4)
                if (r4 != 0) goto L_0x009b
                goto L_0x0156
            L_0x009b:
                kotlinx.serialization.json.a r2 = f30315c
                kotlinx.serialization.modules.d r4 = r2.a()
                java.lang.Class<com.sumsub.sentry.n0> r6 = com.sumsub.sentry.n0.class
                kotlin.reflect.p r6 = kotlin.jvm.internal.Reflection.n(r6)
                kotlin.jvm.internal.MagicApiIntrinsics.a(r5)
                kotlinx.serialization.b r4 = kotlinx.serialization.h.d(r4, r6)
                java.lang.Object r2 = r2.d(r4, r3)
                com.sumsub.sentry.n0 r2 = (com.sumsub.sentry.n0) r2
                r0.a((com.sumsub.sentry.n0) r2)
                goto L_0x0023
            L_0x00b9:
                java.lang.String r4 = "gpu"
                boolean r4 = r2.equals(r4)
                if (r4 != 0) goto L_0x00c3
                goto L_0x0156
            L_0x00c3:
                kotlinx.serialization.json.a r2 = f30315c
                kotlinx.serialization.modules.d r4 = r2.a()
                java.lang.Class<com.sumsub.sentry.j> r6 = com.sumsub.sentry.j.class
                kotlin.reflect.p r6 = kotlin.jvm.internal.Reflection.n(r6)
                kotlin.jvm.internal.MagicApiIntrinsics.a(r5)
                kotlinx.serialization.b r4 = kotlinx.serialization.h.d(r4, r6)
                java.lang.Object r2 = r2.d(r4, r3)
                com.sumsub.sentry.j r2 = (com.sumsub.sentry.j) r2
                r0.a((com.sumsub.sentry.j) r2)
                goto L_0x0023
            L_0x00e1:
                java.lang.String r4 = "app"
                boolean r4 = r2.equals(r4)
                if (r4 != 0) goto L_0x00ea
                goto L_0x0156
            L_0x00ea:
                kotlinx.serialization.json.a r2 = f30315c
                kotlinx.serialization.modules.d r4 = r2.a()
                java.lang.Class<com.sumsub.sentry.a> r6 = com.sumsub.sentry.a.class
                kotlin.reflect.p r6 = kotlin.jvm.internal.Reflection.n(r6)
                kotlin.jvm.internal.MagicApiIntrinsics.a(r5)
                kotlinx.serialization.b r4 = kotlinx.serialization.h.d(r4, r6)
                java.lang.Object r2 = r2.d(r4, r3)
                com.sumsub.sentry.a r2 = (com.sumsub.sentry.a) r2
                r0.a((com.sumsub.sentry.a) r2)
                goto L_0x0023
            L_0x0108:
                java.lang.String r4 = "os"
                boolean r4 = r2.equals(r4)
                if (r4 != 0) goto L_0x0111
                goto L_0x0156
            L_0x0111:
                kotlinx.serialization.json.a r2 = f30315c
                kotlinx.serialization.modules.d r4 = r2.a()
                java.lang.Class<com.sumsub.sentry.q> r6 = com.sumsub.sentry.q.class
                kotlin.reflect.p r6 = kotlin.jvm.internal.Reflection.n(r6)
                kotlin.jvm.internal.MagicApiIntrinsics.a(r5)
                kotlinx.serialization.b r4 = kotlinx.serialization.h.d(r4, r6)
                java.lang.Object r2 = r2.d(r4, r3)
                com.sumsub.sentry.q r2 = (com.sumsub.sentry.q) r2
                r0.a((com.sumsub.sentry.q) r2)
                goto L_0x0023
            L_0x012f:
                java.lang.String r4 = "device"
                boolean r4 = r2.equals(r4)
                if (r4 != 0) goto L_0x0138
                goto L_0x0156
            L_0x0138:
                kotlinx.serialization.json.a r2 = f30315c
                kotlinx.serialization.modules.d r4 = r2.a()
                java.lang.Class<com.sumsub.sentry.Device> r6 = com.sumsub.sentry.Device.class
                kotlin.reflect.p r6 = kotlin.jvm.internal.Reflection.n(r6)
                kotlin.jvm.internal.MagicApiIntrinsics.a(r5)
                kotlinx.serialization.b r4 = kotlinx.serialization.h.d(r4, r6)
                java.lang.Object r2 = r2.d(r4, r3)
                com.sumsub.sentry.Device r2 = (com.sumsub.sentry.Device) r2
                r0.a((com.sumsub.sentry.Device) r2)
                goto L_0x0023
            L_0x0156:
                java.lang.String r3 = com.sumsub.sns.internal.core.common.x.a((kotlinx.serialization.json.g) r3)
                r0.put(r2, r3)
                goto L_0x0023
            L_0x015f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.d.b.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.d");
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30314b;
        }

        /* renamed from: a */
        public void serialize(kotlinx.serialization.encoding.d dVar, d dVar2) {
            if (dVar instanceof k) {
                List<Map.Entry> z02 = CollectionsKt___CollectionsKt.z0(dVar2.entrySet(), new a());
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.d(MapsKt__MapsJVMKt.d(CollectionsKt__IterablesKt.u(z02, 10)), 16));
                for (Map.Entry entry : z02) {
                    Pair a11 = l.a(String.valueOf(entry.getKey()), f30315c.e(h.b(entry.getValue().getClass()), entry.getValue()));
                    linkedHashMap.put(a11.getFirst(), a11.getSecond());
                }
                ((k) dVar).r(new JsonObject(MapsKt__MapsKt.y(linkedHashMap)));
            }
        }
    }
}
