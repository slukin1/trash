package h2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.DoubleSerializer;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.MapSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import d2.b;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class f implements Comparable<f> {

    /* renamed from: b  reason: collision with root package name */
    public final i2.a f15904b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f15905c;

    /* renamed from: d  reason: collision with root package name */
    public int f15906d;

    /* renamed from: e  reason: collision with root package name */
    public final String f15907e;

    /* renamed from: f  reason: collision with root package name */
    public String f15908f;

    /* renamed from: g  reason: collision with root package name */
    public String f15909g;

    /* renamed from: h  reason: collision with root package name */
    public c f15910h;

    /* renamed from: i  reason: collision with root package name */
    public String f15911i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f15912j = false;

    /* renamed from: k  reason: collision with root package name */
    public boolean f15913k = false;

    /* renamed from: l  reason: collision with root package name */
    public boolean f15914l = false;

    /* renamed from: m  reason: collision with root package name */
    public boolean f15915m = false;

    /* renamed from: n  reason: collision with root package name */
    public boolean f15916n = false;

    /* renamed from: o  reason: collision with root package name */
    public a f15917o;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final k f15918a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<?> f15919b;

        public a(k kVar, Class<?> cls) {
            this.f15918a = kVar;
            this.f15919b = cls;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [int] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(java.lang.Class<?> r8, i2.a r9) {
        /*
            r7 = this;
            r7.<init>()
            r0 = 0
            r7.f15912j = r0
            r7.f15913k = r0
            r7.f15914l = r0
            r7.f15915m = r0
            r7.f15916n = r0
            r7.f15904b = r9
            h2.c r1 = new h2.c
            r1.<init>(r8, r9)
            r7.f15910h = r1
            r1 = 1
            if (r8 == 0) goto L_0x0049
            boolean r2 = r9.f15978r
            if (r2 == 0) goto L_0x0049
            java.lang.Class<d2.d> r2 = d2.d.class
            java.lang.annotation.Annotation r8 = r8.getAnnotation(r2)
            d2.d r8 = (d2.d) r8
            if (r8 == 0) goto L_0x0049
            com.alibaba.fastjson.serializer.SerializerFeature[] r8 = r8.serialzeFeatures()
            int r2 = r8.length
            r3 = r0
        L_0x002e:
            if (r3 >= r2) goto L_0x0049
            r4 = r8[r3]
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString
            if (r4 != r5) goto L_0x0039
            r7.f15912j = r1
            goto L_0x0046
        L_0x0039:
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingName
            if (r4 != r5) goto L_0x0040
            r7.f15913k = r1
            goto L_0x0046
        L_0x0040:
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            if (r4 != r5) goto L_0x0046
            r7.f15914l = r1
        L_0x0046:
            int r3 = r3 + 1
            goto L_0x002e
        L_0x0049:
            r9.m()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r2 = 34
            r8.append(r2)
            java.lang.String r2 = r9.f15962b
            r8.append(r2)
            java.lang.String r2 = "\":"
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r7.f15907e = r8
            d2.b r8 = r9.e()
            if (r8 == 0) goto L_0x00c3
            com.alibaba.fastjson.serializer.SerializerFeature[] r2 = r8.serialzeFeatures()
            int r3 = r2.length
            r4 = r0
        L_0x0072:
            if (r4 >= r3) goto L_0x0084
            r5 = r2[r4]
            int r5 = r5.getMask()
            int r6 = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES
            r5 = r5 & r6
            if (r5 == 0) goto L_0x0081
            r2 = r1
            goto L_0x0085
        L_0x0081:
            int r4 = r4 + 1
            goto L_0x0072
        L_0x0084:
            r2 = r0
        L_0x0085:
            java.lang.String r3 = r8.format()
            r7.f15911i = r3
            java.lang.String r3 = r3.trim()
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0098
            r3 = 0
            r7.f15911i = r3
        L_0x0098:
            com.alibaba.fastjson.serializer.SerializerFeature[] r3 = r8.serialzeFeatures()
            int r4 = r3.length
        L_0x009d:
            if (r0 >= r4) goto L_0x00b8
            r5 = r3[r0]
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString
            if (r5 != r6) goto L_0x00a8
            r7.f15912j = r1
            goto L_0x00b5
        L_0x00a8:
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingName
            if (r5 != r6) goto L_0x00af
            r7.f15913k = r1
            goto L_0x00b5
        L_0x00af:
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            if (r5 != r6) goto L_0x00b5
            r7.f15914l = r1
        L_0x00b5:
            int r0 = r0 + 1
            goto L_0x009d
        L_0x00b8:
            com.alibaba.fastjson.serializer.SerializerFeature[] r8 = r8.serialzeFeatures()
            int r8 = com.alibaba.fastjson.serializer.SerializerFeature.of(r8)
            r7.f15906d = r8
            r0 = r2
        L_0x00c3:
            r7.f15905c = r0
            java.lang.reflect.Method r8 = r9.f15963c
            boolean r8 = com.alibaba.fastjson.util.TypeUtils.O(r8)
            r7.f15916n = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.f.<init>(java.lang.Class, i2.a):void");
    }

    /* renamed from: a */
    public int compareTo(f fVar) {
        return this.f15904b.compareTo(fVar.f15904b);
    }

    public Object b(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object c11 = this.f15904b.c(obj);
        if (this.f15911i == null || c11 == null || this.f15904b.f15966f != Date.class) {
            return c11;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f15911i);
        simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
        return simpleDateFormat.format(c11);
    }

    public Object c(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object c11 = this.f15904b.c(obj);
        if (!this.f15916n || !TypeUtils.Q(c11)) {
            return c11;
        }
        return null;
    }

    public void e(JSONSerializer jSONSerializer) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (!serializeWriter.f14325g) {
            if (this.f15909g == null) {
                this.f15909g = this.f15904b.f15962b + ":";
            }
            serializeWriter.write(this.f15909g);
        } else if (serializeWriter.f14324f) {
            if (this.f15908f == null) {
                this.f15908f = '\'' + this.f15904b.f15962b + "':";
            }
            serializeWriter.write(this.f15908f);
        } else {
            serializeWriter.write(this.f15907e);
        }
    }

    public void f(JSONSerializer jSONSerializer, Object obj) throws Exception {
        k kVar;
        Class<?> cls;
        if (this.f15917o == null) {
            if (obj == null) {
                cls = this.f15904b.f15966f;
            } else {
                cls = obj.getClass();
            }
            k kVar2 = null;
            b e11 = this.f15904b.e();
            if (e11 == null || e11.serializeUsing() == Void.class) {
                if (this.f15911i != null) {
                    if (cls == Double.TYPE || cls == Double.class) {
                        kVar2 = new DoubleSerializer(this.f15911i);
                    } else if (cls == Float.TYPE || cls == Float.class) {
                        kVar2 = new FloatCodec(this.f15911i);
                    }
                }
                if (kVar2 == null) {
                    kVar2 = jSONSerializer.v(cls);
                }
            } else {
                kVar2 = (k) e11.serializeUsing().newInstance();
                this.f15915m = true;
            }
            this.f15917o = new a(kVar2, cls);
        }
        a aVar = this.f15917o;
        int mask = this.f15914l ? this.f15904b.f15970j | SerializerFeature.DisableCircularReferenceDetect.getMask() : this.f15904b.f15970j;
        if (obj == null) {
            Class<?> cls2 = aVar.f15919b;
            SerializeWriter serializeWriter = jSONSerializer.f14277k;
            if (Number.class.isAssignableFrom(cls2)) {
                serializeWriter.I(this.f15906d, SerializerFeature.WriteNullNumberAsZero.mask);
            } else if (String.class == cls2) {
                serializeWriter.I(this.f15906d, SerializerFeature.WriteNullStringAsEmpty.mask);
            } else if (Boolean.class == cls2) {
                serializeWriter.I(this.f15906d, SerializerFeature.WriteNullBooleanAsFalse.mask);
            } else if (Collection.class.isAssignableFrom(cls2)) {
                serializeWriter.I(this.f15906d, SerializerFeature.WriteNullListAsEmpty.mask);
            } else {
                k kVar3 = aVar.f15918a;
                if (!serializeWriter.m(SerializerFeature.WRITE_MAP_NULL_FEATURES) || !(kVar3 instanceof h)) {
                    i2.a aVar2 = this.f15904b;
                    kVar3.c(jSONSerializer, (Object) null, aVar2.f15962b, aVar2.f15967g, mask);
                    return;
                }
                serializeWriter.H();
            }
        } else {
            if (this.f15904b.f15978r) {
                if (this.f15913k) {
                    jSONSerializer.f14277k.K(((Enum) obj).name());
                    return;
                } else if (this.f15912j) {
                    jSONSerializer.f14277k.K(((Enum) obj).toString());
                    return;
                }
            }
            Class<?> cls3 = obj.getClass();
            if (cls3 == aVar.f15919b || this.f15915m) {
                kVar = aVar.f15918a;
            } else {
                kVar = jSONSerializer.v(cls3);
            }
            k kVar4 = kVar;
            String str = this.f15911i;
            if (str == null || (kVar4 instanceof DoubleSerializer) || (kVar4 instanceof FloatCodec)) {
                i2.a aVar3 = this.f15904b;
                if (aVar3.f15980t) {
                    if (kVar4 instanceof h) {
                        ((h) kVar4).x(jSONSerializer, obj, aVar3.f15962b, aVar3.f15967g, mask, true);
                        return;
                    } else if (kVar4 instanceof MapSerializer) {
                        ((MapSerializer) kVar4).q(jSONSerializer, obj, aVar3.f15962b, aVar3.f15967g, mask, true);
                        return;
                    }
                }
                kVar4.c(jSONSerializer, obj, aVar3.f15962b, aVar3.f15967g, mask);
            } else if (kVar4 instanceof d) {
                ((d) kVar4).d(jSONSerializer, obj, this.f15910h);
            } else {
                jSONSerializer.K(obj, str);
            }
        }
    }
}
