package com.opensource.svgaplayer.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.d;
import java.io.IOException;
import okio.ByteString;

public final class Layout extends Message<Layout, Builder> {
    public static final ProtoAdapter<Layout> ADAPTER = new a();
    public static final Float DEFAULT_HEIGHT;
    public static final Float DEFAULT_WIDTH;
    public static final Float DEFAULT_X;
    public static final Float DEFAULT_Y;
    private static final long serialVersionUID = 0;
    public final Float height;
    public final Float width;

    /* renamed from: x  reason: collision with root package name */
    public final Float f28619x;

    /* renamed from: y  reason: collision with root package name */
    public final Float f28620y;

    public static final class Builder extends Message.a<Layout, Builder> {

        /* renamed from: d  reason: collision with root package name */
        public Float f28621d;

        /* renamed from: e  reason: collision with root package name */
        public Float f28622e;

        /* renamed from: f  reason: collision with root package name */
        public Float f28623f;

        /* renamed from: g  reason: collision with root package name */
        public Float f28624g;

        /* renamed from: g */
        public Layout c() {
            return new Layout(this.f28621d, this.f28622e, this.f28623f, this.f28624g, super.d());
        }

        public Builder h(Float f11) {
            this.f28624g = f11;
            return this;
        }

        public Builder i(Float f11) {
            this.f28623f = f11;
            return this;
        }

        public Builder j(Float f11) {
            this.f28621d = f11;
            return this;
        }

        public Builder k(Float f11) {
            this.f28622e = f11;
            return this;
        }
    }

    public static final class a extends ProtoAdapter<Layout> {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, Layout.class);
        }

        /* renamed from: r */
        public Layout c(c cVar) throws IOException {
            Builder builder = new Builder();
            long c11 = cVar.c();
            while (true) {
                int f11 = cVar.f();
                if (f11 == -1) {
                    cVar.d(c11);
                    return builder.c();
                } else if (f11 == 1) {
                    builder.j(ProtoAdapter.f30183o.c(cVar));
                } else if (f11 == 2) {
                    builder.k(ProtoAdapter.f30183o.c(cVar));
                } else if (f11 == 3) {
                    builder.i(ProtoAdapter.f30183o.c(cVar));
                } else if (f11 != 4) {
                    FieldEncoding g11 = cVar.g();
                    builder.a(f11, g11, g11.rawProtoAdapter().c(cVar));
                } else {
                    builder.h(ProtoAdapter.f30183o.c(cVar));
                }
            }
        }

        /* renamed from: s */
        public void g(d dVar, Layout layout) throws IOException {
            Float f11 = layout.f28619x;
            if (f11 != null) {
                ProtoAdapter.f30183o.k(dVar, 1, f11);
            }
            Float f12 = layout.f28620y;
            if (f12 != null) {
                ProtoAdapter.f30183o.k(dVar, 2, f12);
            }
            Float f13 = layout.width;
            if (f13 != null) {
                ProtoAdapter.f30183o.k(dVar, 3, f13);
            }
            Float f14 = layout.height;
            if (f14 != null) {
                ProtoAdapter.f30183o.k(dVar, 4, f14);
            }
            dVar.k(layout.unknownFields());
        }

        /* renamed from: t */
        public int l(Layout layout) {
            Float f11 = layout.f28619x;
            int i11 = 0;
            int m11 = f11 != null ? ProtoAdapter.f30183o.m(1, f11) : 0;
            Float f12 = layout.f28620y;
            int m12 = m11 + (f12 != null ? ProtoAdapter.f30183o.m(2, f12) : 0);
            Float f13 = layout.width;
            int m13 = m12 + (f13 != null ? ProtoAdapter.f30183o.m(3, f13) : 0);
            Float f14 = layout.height;
            if (f14 != null) {
                i11 = ProtoAdapter.f30183o.m(4, f14);
            }
            return m13 + i11 + layout.unknownFields().size();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
        DEFAULT_WIDTH = valueOf;
        DEFAULT_HEIGHT = valueOf;
    }

    public Layout(Float f11, Float f12, Float f13, Float f14) {
        this(f11, f12, f13, f14, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Layout)) {
            return false;
        }
        Layout layout = (Layout) obj;
        if (!unknownFields().equals(layout.unknownFields()) || !com.squareup.wire.internal.a.d(this.f28619x, layout.f28619x) || !com.squareup.wire.internal.a.d(this.f28620y, layout.f28620y) || !com.squareup.wire.internal.a.d(this.width, layout.width) || !com.squareup.wire.internal.a.d(this.height, layout.height)) {
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
        Float f11 = this.f28619x;
        int i12 = 0;
        int hashCode2 = (hashCode + (f11 != null ? f11.hashCode() : 0)) * 37;
        Float f12 = this.f28620y;
        int hashCode3 = (hashCode2 + (f12 != null ? f12.hashCode() : 0)) * 37;
        Float f13 = this.width;
        int hashCode4 = (hashCode3 + (f13 != null ? f13.hashCode() : 0)) * 37;
        Float f14 = this.height;
        if (f14 != null) {
            i12 = f14.hashCode();
        }
        int i13 = hashCode4 + i12;
        this.hashCode = i13;
        return i13;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f28619x != null) {
            sb2.append(", x=");
            sb2.append(this.f28619x);
        }
        if (this.f28620y != null) {
            sb2.append(", y=");
            sb2.append(this.f28620y);
        }
        if (this.width != null) {
            sb2.append(", width=");
            sb2.append(this.width);
        }
        if (this.height != null) {
            sb2.append(", height=");
            sb2.append(this.height);
        }
        StringBuilder replace = sb2.replace(0, 2, "Layout{");
        replace.append('}');
        return replace.toString();
    }

    public Layout(Float f11, Float f12, Float f13, Float f14, ByteString byteString) {
        super(ADAPTER, byteString);
        this.f28619x = f11;
        this.f28620y = f12;
        this.width = f13;
        this.height = f14;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f28621d = this.f28619x;
        builder.f28622e = this.f28620y;
        builder.f28623f = this.width;
        builder.f28624g = this.height;
        builder.b(unknownFields());
        return builder;
    }
}
