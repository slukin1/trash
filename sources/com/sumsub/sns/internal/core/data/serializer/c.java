package com.sumsub.sns.internal.core.data.serializer;

import com.sumsub.sns.internal.core.common.i;
import d10.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.g;
import kotlinx.serialization.json.h;
import kotlinx.serialization.json.k;

public final class c implements kotlinx.serialization.b<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final c f32960a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final f f32961b = SerialDescriptorsKt.a("JsonAsAnySerializer", e.i.f57638a);

    public static final class a extends Lambda implements l<JsonArrayBuilder, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f32962a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Object obj) {
            super(1);
            this.f32962a = obj;
        }

        public final void a(JsonArrayBuilder jsonArrayBuilder) {
            c.f32960a.a(jsonArrayBuilder, (Collection<?>) (Collection) this.f32962a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((JsonArrayBuilder) obj);
            return Unit.f56620a;
        }
    }

    public static final class b extends Lambda implements l<JsonObjectBuilder, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f32963a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Object obj) {
            super(1);
            this.f32963a = obj;
        }

        public final void a(JsonObjectBuilder jsonObjectBuilder) {
            c.f32960a.a(jsonObjectBuilder, (Map<?, ?>) (Map) this.f32963a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((JsonObjectBuilder) obj);
            return Unit.f56620a;
        }
    }

    public Object deserialize(kotlinx.serialization.encoding.c cVar) {
        if (cVar instanceof kotlinx.serialization.json.f) {
            g t11 = ((kotlinx.serialization.json.f) cVar).t();
            Object a11 = a(t11);
            return a11 == null ? t11.toString() : a11;
        }
        throw new IllegalStateException("JsonAsAnySerializer decoder is not JsonDecoder".toString());
    }

    public f getDescriptor() {
        return f32961b;
    }

    public void serialize(d dVar, Object obj) {
        k kVar = dVar instanceof k ? (k) dVar : null;
        if (kVar != null) {
            a(obj, kVar);
        }
    }

    public final void a(Object obj, k kVar) {
        if (obj instanceof String) {
            kVar.v((String) obj);
        } else if (obj instanceof Integer) {
            kVar.s(((Number) obj).intValue());
        } else if (obj instanceof Long) {
            kVar.A(((Number) obj).longValue());
        } else if (obj instanceof Float) {
            kVar.m(((Number) obj).floatValue());
        } else if (obj instanceof Double) {
            kVar.x(((Number) obj).doubleValue());
        } else if (obj instanceof Short) {
            kVar.k(((Number) obj).shortValue());
        } else if (obj instanceof Boolean) {
            kVar.l(((Boolean) obj).booleanValue());
        } else if (obj instanceof Collection) {
            JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
            f32960a.a(jsonArrayBuilder, (Collection<?>) (Collection) obj);
            kVar.r(jsonArrayBuilder.b());
        } else if (obj instanceof Map) {
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            f32960a.a(jsonObjectBuilder, (Map<?, ?>) (Map) obj);
            kVar.r(jsonObjectBuilder.a());
        }
    }

    public final void a(JsonArrayBuilder jsonArrayBuilder, Collection<?> collection) {
        for (Object next : CollectionsKt___CollectionsKt.X(collection)) {
            if (next instanceof String) {
                h.c(jsonArrayBuilder, (String) next);
            } else if (next instanceof Number) {
                h.b(jsonArrayBuilder, (Number) next);
            } else if (next instanceof Boolean) {
                h.a(jsonArrayBuilder, (Boolean) next);
            } else if (next instanceof Collection) {
                JsonArrayBuilder jsonArrayBuilder2 = new JsonArrayBuilder();
                f32960a.a(jsonArrayBuilder2, (Collection<?>) (Collection) next);
                jsonArrayBuilder.a(jsonArrayBuilder2.b());
            } else if (next instanceof Map) {
                JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
                f32960a.a(jsonObjectBuilder, (Map<?, ?>) (Map) next);
                jsonArrayBuilder.a(jsonObjectBuilder.a());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        r0 = kotlinx.serialization.json.i.h(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r0 = kotlinx.serialization.json.i.e(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        r0 = kotlinx.serialization.json.i.o(r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlinx.serialization.json.g r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlinx.serialization.json.JsonNull
            if (r0 == 0) goto L_0x0006
            goto L_0x0074
        L_0x0006:
            boolean r0 = r6 instanceof kotlinx.serialization.json.t
            if (r0 == 0) goto L_0x005e
            kotlinx.serialization.json.t r6 = (kotlinx.serialization.json.t) r6
            boolean r0 = r6.c()
            if (r0 == 0) goto L_0x0017
            java.lang.String r6 = r6.a()
            goto L_0x0035
        L_0x0017:
            java.lang.Integer r0 = kotlinx.serialization.json.i.k(r6)
            if (r0 != 0) goto L_0x0034
            java.lang.Long r0 = kotlinx.serialization.json.i.o(r6)
            if (r0 != 0) goto L_0x0034
            java.lang.Double r0 = kotlinx.serialization.json.i.h(r6)
            if (r0 != 0) goto L_0x0034
            java.lang.Boolean r0 = kotlinx.serialization.json.i.e(r6)
            if (r0 != 0) goto L_0x0034
            java.lang.String r6 = r6.a()
            goto L_0x0035
        L_0x0034:
            r6 = r0
        L_0x0035:
            boolean r0 = r6 instanceof java.lang.Double
            if (r0 == 0) goto L_0x0075
            r0 = r6
            java.lang.Number r0 = (java.lang.Number) r0
            double r1 = r0.doubleValue()
            r3 = 5183643170566569984(0x47efffffe0000000, double:3.4028234663852886E38)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0075
            double r1 = r0.doubleValue()
            r3 = 3936146074321813504(0x36a0000000000000, double:1.401298464324817E-45)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0075
            double r0 = r0.doubleValue()
            float r6 = (float) r0
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            goto L_0x0075
        L_0x005e:
            boolean r0 = r6 instanceof kotlinx.serialization.json.JsonObject
            if (r0 == 0) goto L_0x0069
            kotlinx.serialization.json.JsonObject r6 = (kotlinx.serialization.json.JsonObject) r6
            java.util.Map r6 = r5.a((kotlinx.serialization.json.JsonObject) r6)
            goto L_0x0075
        L_0x0069:
            boolean r0 = r6 instanceof kotlinx.serialization.json.b
            if (r0 == 0) goto L_0x0074
            kotlinx.serialization.json.b r6 = (kotlinx.serialization.json.b) r6
            java.util.List r6 = r5.a((kotlinx.serialization.json.b) r6)
            goto L_0x0075
        L_0x0074:
            r6 = 0
        L_0x0075:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.serializer.c.a(kotlinx.serialization.json.g):java.lang.Object");
    }

    public final void a(JsonObjectBuilder jsonObjectBuilder, Map<?, ?> map) {
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            Object value = next.getValue();
            if (key instanceof String) {
                if (value instanceof String) {
                    h.f(jsonObjectBuilder, (String) key, (String) value);
                } else if (value instanceof Number) {
                    h.e(jsonObjectBuilder, (String) key, (Number) value);
                } else if (value instanceof Boolean) {
                    h.d(jsonObjectBuilder, (String) key, (Boolean) value);
                } else if (value instanceof Collection) {
                    h.g(jsonObjectBuilder, (String) key, new a(value));
                } else if (value instanceof Map) {
                    h.h(jsonObjectBuilder, (String) key, new b(value));
                }
            }
        }
    }

    public final List<Object> a(kotlinx.serialization.json.b bVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = bVar.iterator();
        while (it2.hasNext()) {
            Object a11 = f32960a.a((g) it2.next());
            if (a11 != null) {
                arrayList.add(a11);
            }
        }
        return arrayList;
    }

    public final Map<String, Object> a(JsonObject jsonObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.d(jsonObject.size()));
        for (Map.Entry entry : jsonObject.entrySet()) {
            linkedHashMap.put(entry.getKey(), f32960a.a((g) entry.getValue()));
        }
        return i.a(linkedHashMap);
    }
}
