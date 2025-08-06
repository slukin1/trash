package com.opensource.svgaplayer.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.d;
import java.io.IOException;
import okio.ByteString;

public final class Transform extends Message<Transform, Builder> {
    public static final ProtoAdapter<Transform> ADAPTER = new a();
    public static final Float DEFAULT_A;
    public static final Float DEFAULT_B;
    public static final Float DEFAULT_C;
    public static final Float DEFAULT_D;
    public static final Float DEFAULT_TX;
    public static final Float DEFAULT_TY;
    private static final long serialVersionUID = 0;

    /* renamed from: a  reason: collision with root package name */
    public final Float f28676a;

    /* renamed from: b  reason: collision with root package name */
    public final Float f28677b;

    /* renamed from: c  reason: collision with root package name */
    public final Float f28678c;

    /* renamed from: d  reason: collision with root package name */
    public final Float f28679d;

    /* renamed from: tx  reason: collision with root package name */
    public final Float f28680tx;

    /* renamed from: ty  reason: collision with root package name */
    public final Float f28681ty;

    public static final class Builder extends Message.a<Transform, Builder> {

        /* renamed from: d  reason: collision with root package name */
        public Float f28682d;

        /* renamed from: e  reason: collision with root package name */
        public Float f28683e;

        /* renamed from: f  reason: collision with root package name */
        public Float f28684f;

        /* renamed from: g  reason: collision with root package name */
        public Float f28685g;

        /* renamed from: h  reason: collision with root package name */
        public Float f28686h;

        /* renamed from: i  reason: collision with root package name */
        public Float f28687i;

        public Builder g(Float f11) {
            this.f28682d = f11;
            return this;
        }

        public Builder h(Float f11) {
            this.f28683e = f11;
            return this;
        }

        /* renamed from: i */
        public Transform c() {
            return new Transform(this.f28682d, this.f28683e, this.f28684f, this.f28685g, this.f28686h, this.f28687i, super.d());
        }

        public Builder j(Float f11) {
            this.f28684f = f11;
            return this;
        }

        public Builder k(Float f11) {
            this.f28685g = f11;
            return this;
        }

        public Builder l(Float f11) {
            this.f28686h = f11;
            return this;
        }

        public Builder m(Float f11) {
            this.f28687i = f11;
            return this;
        }
    }

    public static final class a extends ProtoAdapter<Transform> {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, Transform.class);
        }

        /* renamed from: r */
        public Transform c(c cVar) throws IOException {
            Builder builder = new Builder();
            long c11 = cVar.c();
            while (true) {
                int f11 = cVar.f();
                if (f11 != -1) {
                    switch (f11) {
                        case 1:
                            builder.g(ProtoAdapter.f30183o.c(cVar));
                            break;
                        case 2:
                            builder.h(ProtoAdapter.f30183o.c(cVar));
                            break;
                        case 3:
                            builder.j(ProtoAdapter.f30183o.c(cVar));
                            break;
                        case 4:
                            builder.k(ProtoAdapter.f30183o.c(cVar));
                            break;
                        case 5:
                            builder.l(ProtoAdapter.f30183o.c(cVar));
                            break;
                        case 6:
                            builder.m(ProtoAdapter.f30183o.c(cVar));
                            break;
                        default:
                            FieldEncoding g11 = cVar.g();
                            builder.a(f11, g11, g11.rawProtoAdapter().c(cVar));
                            break;
                    }
                } else {
                    cVar.d(c11);
                    return builder.c();
                }
            }
        }

        /* renamed from: s */
        public void g(d dVar, Transform transform) throws IOException {
            Float f11 = transform.f28676a;
            if (f11 != null) {
                ProtoAdapter.f30183o.k(dVar, 1, f11);
            }
            Float f12 = transform.f28677b;
            if (f12 != null) {
                ProtoAdapter.f30183o.k(dVar, 2, f12);
            }
            Float f13 = transform.f28678c;
            if (f13 != null) {
                ProtoAdapter.f30183o.k(dVar, 3, f13);
            }
            Float f14 = transform.f28679d;
            if (f14 != null) {
                ProtoAdapter.f30183o.k(dVar, 4, f14);
            }
            Float f15 = transform.f28680tx;
            if (f15 != null) {
                ProtoAdapter.f30183o.k(dVar, 5, f15);
            }
            Float f16 = transform.f28681ty;
            if (f16 != null) {
                ProtoAdapter.f30183o.k(dVar, 6, f16);
            }
            dVar.k(transform.unknownFields());
        }

        /* renamed from: t */
        public int l(Transform transform) {
            Float f11 = transform.f28676a;
            int i11 = 0;
            int m11 = f11 != null ? ProtoAdapter.f30183o.m(1, f11) : 0;
            Float f12 = transform.f28677b;
            int m12 = m11 + (f12 != null ? ProtoAdapter.f30183o.m(2, f12) : 0);
            Float f13 = transform.f28678c;
            int m13 = m12 + (f13 != null ? ProtoAdapter.f30183o.m(3, f13) : 0);
            Float f14 = transform.f28679d;
            int m14 = m13 + (f14 != null ? ProtoAdapter.f30183o.m(4, f14) : 0);
            Float f15 = transform.f28680tx;
            int m15 = m14 + (f15 != null ? ProtoAdapter.f30183o.m(5, f15) : 0);
            Float f16 = transform.f28681ty;
            if (f16 != null) {
                i11 = ProtoAdapter.f30183o.m(6, f16);
            }
            return m15 + i11 + transform.unknownFields().size();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_A = valueOf;
        DEFAULT_B = valueOf;
        DEFAULT_C = valueOf;
        DEFAULT_D = valueOf;
        DEFAULT_TX = valueOf;
        DEFAULT_TY = valueOf;
    }

    public Transform(Float f11, Float f12, Float f13, Float f14, Float f15, Float f16) {
        this(f11, f12, f13, f14, f15, f16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Transform)) {
            return false;
        }
        Transform transform = (Transform) obj;
        if (!unknownFields().equals(transform.unknownFields()) || !com.squareup.wire.internal.a.d(this.f28676a, transform.f28676a) || !com.squareup.wire.internal.a.d(this.f28677b, transform.f28677b) || !com.squareup.wire.internal.a.d(this.f28678c, transform.f28678c) || !com.squareup.wire.internal.a.d(this.f28679d, transform.f28679d) || !com.squareup.wire.internal.a.d(this.f28680tx, transform.f28680tx) || !com.squareup.wire.internal.a.d(this.f28681ty, transform.f28681ty)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i11 = this.hashCode;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Float f11 = this.f28676a;
        int i12 = 0;
        int hashCode2 = (hashCode + (f11 != null ? f11.hashCode() : 0)) * 37;
        Float f12 = this.f28677b;
        int hashCode3 = (hashCode2 + (f12 != null ? f12.hashCode() : 0)) * 37;
        Float f13 = this.f28678c;
        int hashCode4 = (hashCode3 + (f13 != null ? f13.hashCode() : 0)) * 37;
        Float f14 = this.f28679d;
        int hashCode5 = (hashCode4 + (f14 != null ? f14.hashCode() : 0)) * 37;
        Float f15 = this.f28680tx;
        int hashCode6 = (hashCode5 + (f15 != null ? f15.hashCode() : 0)) * 37;
        Float f16 = this.f28681ty;
        if (f16 != null) {
            i12 = f16.hashCode();
        }
        int i13 = hashCode6 + i12;
        this.hashCode = i13;
        return i13;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f28676a != null) {
            sb2.append(", a=");
            sb2.append(this.f28676a);
        }
        if (this.f28677b != null) {
            sb2.append(", b=");
            sb2.append(this.f28677b);
        }
        if (this.f28678c != null) {
            sb2.append(", c=");
            sb2.append(this.f28678c);
        }
        if (this.f28679d != null) {
            sb2.append(", d=");
            sb2.append(this.f28679d);
        }
        if (this.f28680tx != null) {
            sb2.append(", tx=");
            sb2.append(this.f28680tx);
        }
        if (this.f28681ty != null) {
            sb2.append(", ty=");
            sb2.append(this.f28681ty);
        }
        StringBuilder replace = sb2.replace(0, 2, "Transform{");
        replace.append('}');
        return replace.toString();
    }

    public Transform(Float f11, Float f12, Float f13, Float f14, Float f15, Float f16, ByteString byteString) {
        super(ADAPTER, byteString);
        this.f28676a = f11;
        this.f28677b = f12;
        this.f28678c = f13;
        this.f28679d = f14;
        this.f28680tx = f15;
        this.f28681ty = f16;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f28682d = this.f28676a;
        builder.f28683e = this.f28677b;
        builder.f28684f = this.f28678c;
        builder.f28685g = this.f28679d;
        builder.f28686h = this.f28680tx;
        builder.f28687i = this.f28681ty;
        builder.b(unknownFields());
        return builder;
    }
}
