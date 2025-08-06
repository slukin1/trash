package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.facebook.stetho.inspector.network.DecompressionHelper;
import h2.k;
import h2.n;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;

public class JSONSerializer extends SerializeFilterable {

    /* renamed from: j  reason: collision with root package name */
    public final SerializeConfig f14276j;

    /* renamed from: k  reason: collision with root package name */
    public final SerializeWriter f14277k;

    /* renamed from: l  reason: collision with root package name */
    public int f14278l;

    /* renamed from: m  reason: collision with root package name */
    public String f14279m;

    /* renamed from: n  reason: collision with root package name */
    public String f14280n;

    /* renamed from: o  reason: collision with root package name */
    public DateFormat f14281o;

    /* renamed from: p  reason: collision with root package name */
    public IdentityHashMap<Object, n> f14282p;

    /* renamed from: q  reason: collision with root package name */
    public n f14283q;

    /* renamed from: r  reason: collision with root package name */
    public TimeZone f14284r;

    /* renamed from: s  reason: collision with root package name */
    public Locale f14285s;

    public JSONSerializer() {
        this(new SerializeWriter(), SerializeConfig.d());
    }

    public void A() {
        this.f14277k.write(10);
        for (int i11 = 0; i11 < this.f14278l; i11++) {
            this.f14277k.write(this.f14279m);
        }
    }

    public void B(n nVar, Object obj, Object obj2, int i11) {
        C(nVar, obj, obj2, i11, 0);
    }

    public void C(n nVar, Object obj, Object obj2, int i11, int i12) {
        if (!this.f14277k.f14327i) {
            this.f14283q = new n(nVar, obj, obj2, i11, i12);
            if (this.f14282p == null) {
                this.f14282p = new IdentityHashMap<>();
            }
            this.f14282p.put(obj, this.f14283q);
        }
    }

    public void D(String str) {
        this.f14280n = str;
        if (this.f14281o != null) {
            this.f14281o = null;
        }
    }

    public final void E(Object obj) {
        if (obj == null) {
            this.f14277k.H();
            return;
        }
        try {
            v(obj.getClass()).c(this, obj, (Object) null, (Type) null, 0);
        } catch (IOException e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public final void F(String str) {
        StringCodec.f14336a.g(this, str);
    }

    public void G() {
        this.f14277k.H();
    }

    public void H(Object obj) {
        n nVar = this.f14283q;
        if (obj == nVar.f15924b) {
            this.f14277k.write("{\"$ref\":\"@\"}");
            return;
        }
        n nVar2 = nVar.f15923a;
        if (nVar2 == null || obj != nVar2.f15924b) {
            while (true) {
                n nVar3 = nVar.f15923a;
                if (nVar3 == null) {
                    break;
                }
                nVar = nVar3;
            }
            if (obj == nVar.f15924b) {
                this.f14277k.write("{\"$ref\":\"$\"}");
                return;
            }
            this.f14277k.write("{\"$ref\":\"");
            this.f14277k.write(this.f14282p.get(obj).toString());
            this.f14277k.write("\"}");
            return;
        }
        this.f14277k.write("{\"$ref\":\"..\"}");
    }

    public final void I(Object obj, Object obj2) {
        J(obj, obj2, (Type) null, 0);
    }

    public final void J(Object obj, Object obj2, Type type, int i11) {
        if (obj == null) {
            try {
                this.f14277k.H();
            } catch (IOException e11) {
                throw new JSONException(e11.getMessage(), e11);
            }
        } else {
            v(obj.getClass()).c(this, obj, obj2, type, i11);
        }
    }

    public final void K(Object obj, String str) {
        GZIPOutputStream gZIPOutputStream;
        if (obj instanceof Date) {
            DateFormat t11 = t();
            if (t11 == null) {
                t11 = new SimpleDateFormat(str, this.f14285s);
                t11.setTimeZone(this.f14284r);
            }
            this.f14277k.K(t11.format((Date) obj));
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (DecompressionHelper.GZIP_ENCODING.equals(str) || "gzip,base64".equals(str)) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    if (bArr.length < 512) {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream, bArr.length);
                    } else {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    }
                    GZIPOutputStream gZIPOutputStream2 = gZIPOutputStream;
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    this.f14277k.s(byteArrayOutputStream.toByteArray());
                    IOUtils.a(gZIPOutputStream2);
                } catch (IOException e11) {
                    throw new JSONException("write gzipBytes error", e11);
                } catch (Throwable th2) {
                    IOUtils.a((Closeable) null);
                    throw th2;
                }
            } else if ("hex".equals(str)) {
                this.f14277k.D(bArr);
            } else {
                this.f14277k.s(bArr);
            }
        } else {
            E(obj);
        }
    }

    public void q(SerializerFeature serializerFeature, boolean z11) {
        this.f14277k.g(serializerFeature, z11);
    }

    public boolean r(Object obj) {
        n nVar;
        IdentityHashMap<Object, n> identityHashMap = this.f14282p;
        if (identityHashMap == null || (nVar = identityHashMap.get(obj)) == null) {
            return false;
        }
        Object obj2 = nVar.f15925c;
        if (obj2 == null || (obj2 instanceof Integer) || (obj2 instanceof String)) {
            return true;
        }
        return false;
    }

    public void s() {
        this.f14278l--;
    }

    public DateFormat t() {
        if (this.f14281o == null && this.f14280n != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f14280n, this.f14285s);
            this.f14281o = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.f14284r);
        }
        return this.f14281o;
    }

    public String toString() {
        return this.f14277k.toString();
    }

    public String u() {
        DateFormat dateFormat = this.f14281o;
        if (dateFormat instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateFormat).toPattern();
        }
        return this.f14280n;
    }

    public k v(Class<?> cls) {
        return this.f14276j.e(cls);
    }

    public SerializeWriter w() {
        return this.f14277k;
    }

    public void x() {
        this.f14278l++;
    }

    public boolean y(SerializerFeature serializerFeature) {
        return this.f14277k.n(serializerFeature);
    }

    public final boolean z(Type type, Object obj) {
        return this.f14277k.n(SerializerFeature.WriteClassName) && !(type == null && this.f14277k.n(SerializerFeature.NotWriteRootClassName) && this.f14283q.f15923a == null);
    }

    public JSONSerializer(SerializeWriter serializeWriter) {
        this(serializeWriter, SerializeConfig.d());
    }

    public JSONSerializer(SerializeWriter serializeWriter, SerializeConfig serializeConfig) {
        this.f14278l = 0;
        this.f14279m = "\t";
        this.f14282p = null;
        this.f14284r = JSON.defaultTimeZone;
        this.f14285s = JSON.defaultLocale;
        this.f14277k = serializeWriter;
        this.f14276j = serializeConfig;
    }
}
