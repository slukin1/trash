package com.opensource.svgaplayer.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.d;
import com.squareup.wire.f;
import java.io.IOException;
import okio.ByteString;

public final class ShapeEntity extends Message<ShapeEntity, Builder> {
    public static final ProtoAdapter<ShapeEntity> ADAPTER = new a();
    public static final ShapeType DEFAULT_TYPE = ShapeType.SHAPE;
    private static final long serialVersionUID = 0;
    public final EllipseArgs ellipse;
    public final RectArgs rect;
    public final ShapeArgs shape;
    public final ShapeStyle styles;
    public final Transform transform;
    public final ShapeType type;

    public static final class Builder extends Message.a<ShapeEntity, Builder> {

        /* renamed from: d  reason: collision with root package name */
        public ShapeType f28635d;

        /* renamed from: e  reason: collision with root package name */
        public ShapeStyle f28636e;

        /* renamed from: f  reason: collision with root package name */
        public Transform f28637f;

        /* renamed from: g  reason: collision with root package name */
        public ShapeArgs f28638g;

        /* renamed from: h  reason: collision with root package name */
        public RectArgs f28639h;

        /* renamed from: i  reason: collision with root package name */
        public EllipseArgs f28640i;

        /* renamed from: g */
        public ShapeEntity c() {
            return new ShapeEntity(this.f28635d, this.f28636e, this.f28637f, this.f28638g, this.f28639h, this.f28640i, super.d());
        }

        public Builder h(EllipseArgs ellipseArgs) {
            this.f28640i = ellipseArgs;
            this.f28638g = null;
            this.f28639h = null;
            return this;
        }

        public Builder i(RectArgs rectArgs) {
            this.f28639h = rectArgs;
            this.f28638g = null;
            this.f28640i = null;
            return this;
        }

        public Builder j(ShapeArgs shapeArgs) {
            this.f28638g = shapeArgs;
            this.f28639h = null;
            this.f28640i = null;
            return this;
        }

        public Builder k(ShapeStyle shapeStyle) {
            this.f28636e = shapeStyle;
            return this;
        }

        public Builder l(Transform transform) {
            this.f28637f = transform;
            return this;
        }

        public Builder m(ShapeType shapeType) {
            this.f28635d = shapeType;
            return this;
        }
    }

    public static final class EllipseArgs extends Message<EllipseArgs, Builder> {
        public static final ProtoAdapter<EllipseArgs> ADAPTER = new a();
        public static final Float DEFAULT_RADIUSX;
        public static final Float DEFAULT_RADIUSY;
        public static final Float DEFAULT_X;
        public static final Float DEFAULT_Y;
        private static final long serialVersionUID = 0;
        public final Float radiusX;
        public final Float radiusY;

        /* renamed from: x  reason: collision with root package name */
        public final Float f28641x;

        /* renamed from: y  reason: collision with root package name */
        public final Float f28642y;

        public static final class Builder extends Message.a<EllipseArgs, Builder> {

            /* renamed from: d  reason: collision with root package name */
            public Float f28643d;

            /* renamed from: e  reason: collision with root package name */
            public Float f28644e;

            /* renamed from: f  reason: collision with root package name */
            public Float f28645f;

            /* renamed from: g  reason: collision with root package name */
            public Float f28646g;

            /* renamed from: g */
            public EllipseArgs c() {
                return new EllipseArgs(this.f28643d, this.f28644e, this.f28645f, this.f28646g, super.d());
            }

            public Builder h(Float f11) {
                this.f28645f = f11;
                return this;
            }

            public Builder i(Float f11) {
                this.f28646g = f11;
                return this;
            }

            public Builder j(Float f11) {
                this.f28643d = f11;
                return this;
            }

            public Builder k(Float f11) {
                this.f28644e = f11;
                return this;
            }
        }

        public static final class a extends ProtoAdapter<EllipseArgs> {
            public a() {
                super(FieldEncoding.LENGTH_DELIMITED, EllipseArgs.class);
            }

            /* renamed from: r */
            public EllipseArgs c(c cVar) throws IOException {
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
                        builder.h(ProtoAdapter.f30183o.c(cVar));
                    } else if (f11 != 4) {
                        FieldEncoding g11 = cVar.g();
                        builder.a(f11, g11, g11.rawProtoAdapter().c(cVar));
                    } else {
                        builder.i(ProtoAdapter.f30183o.c(cVar));
                    }
                }
            }

            /* renamed from: s */
            public void g(d dVar, EllipseArgs ellipseArgs) throws IOException {
                Float f11 = ellipseArgs.f28641x;
                if (f11 != null) {
                    ProtoAdapter.f30183o.k(dVar, 1, f11);
                }
                Float f12 = ellipseArgs.f28642y;
                if (f12 != null) {
                    ProtoAdapter.f30183o.k(dVar, 2, f12);
                }
                Float f13 = ellipseArgs.radiusX;
                if (f13 != null) {
                    ProtoAdapter.f30183o.k(dVar, 3, f13);
                }
                Float f14 = ellipseArgs.radiusY;
                if (f14 != null) {
                    ProtoAdapter.f30183o.k(dVar, 4, f14);
                }
                dVar.k(ellipseArgs.unknownFields());
            }

            /* renamed from: t */
            public int l(EllipseArgs ellipseArgs) {
                Float f11 = ellipseArgs.f28641x;
                int i11 = 0;
                int m11 = f11 != null ? ProtoAdapter.f30183o.m(1, f11) : 0;
                Float f12 = ellipseArgs.f28642y;
                int m12 = m11 + (f12 != null ? ProtoAdapter.f30183o.m(2, f12) : 0);
                Float f13 = ellipseArgs.radiusX;
                int m13 = m12 + (f13 != null ? ProtoAdapter.f30183o.m(3, f13) : 0);
                Float f14 = ellipseArgs.radiusY;
                if (f14 != null) {
                    i11 = ProtoAdapter.f30183o.m(4, f14);
                }
                return m13 + i11 + ellipseArgs.unknownFields().size();
            }
        }

        static {
            Float valueOf = Float.valueOf(0.0f);
            DEFAULT_X = valueOf;
            DEFAULT_Y = valueOf;
            DEFAULT_RADIUSX = valueOf;
            DEFAULT_RADIUSY = valueOf;
        }

        public EllipseArgs(Float f11, Float f12, Float f13, Float f14) {
            this(f11, f12, f13, f14, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EllipseArgs)) {
                return false;
            }
            EllipseArgs ellipseArgs = (EllipseArgs) obj;
            if (!unknownFields().equals(ellipseArgs.unknownFields()) || !com.squareup.wire.internal.a.d(this.f28641x, ellipseArgs.f28641x) || !com.squareup.wire.internal.a.d(this.f28642y, ellipseArgs.f28642y) || !com.squareup.wire.internal.a.d(this.radiusX, ellipseArgs.radiusX) || !com.squareup.wire.internal.a.d(this.radiusY, ellipseArgs.radiusY)) {
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
            Float f11 = this.f28641x;
            int i12 = 0;
            int hashCode2 = (hashCode + (f11 != null ? f11.hashCode() : 0)) * 37;
            Float f12 = this.f28642y;
            int hashCode3 = (hashCode2 + (f12 != null ? f12.hashCode() : 0)) * 37;
            Float f13 = this.radiusX;
            int hashCode4 = (hashCode3 + (f13 != null ? f13.hashCode() : 0)) * 37;
            Float f14 = this.radiusY;
            if (f14 != null) {
                i12 = f14.hashCode();
            }
            int i13 = hashCode4 + i12;
            this.hashCode = i13;
            return i13;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.f28641x != null) {
                sb2.append(", x=");
                sb2.append(this.f28641x);
            }
            if (this.f28642y != null) {
                sb2.append(", y=");
                sb2.append(this.f28642y);
            }
            if (this.radiusX != null) {
                sb2.append(", radiusX=");
                sb2.append(this.radiusX);
            }
            if (this.radiusY != null) {
                sb2.append(", radiusY=");
                sb2.append(this.radiusY);
            }
            StringBuilder replace = sb2.replace(0, 2, "EllipseArgs{");
            replace.append('}');
            return replace.toString();
        }

        public EllipseArgs(Float f11, Float f12, Float f13, Float f14, ByteString byteString) {
            super(ADAPTER, byteString);
            this.f28641x = f11;
            this.f28642y = f12;
            this.radiusX = f13;
            this.radiusY = f14;
        }

        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.f28643d = this.f28641x;
            builder.f28644e = this.f28642y;
            builder.f28645f = this.radiusX;
            builder.f28646g = this.radiusY;
            builder.b(unknownFields());
            return builder;
        }
    }

    public static final class RectArgs extends Message<RectArgs, Builder> {
        public static final ProtoAdapter<RectArgs> ADAPTER = new a();
        public static final Float DEFAULT_CORNERRADIUS;
        public static final Float DEFAULT_HEIGHT;
        public static final Float DEFAULT_WIDTH;
        public static final Float DEFAULT_X;
        public static final Float DEFAULT_Y;
        private static final long serialVersionUID = 0;
        public final Float cornerRadius;
        public final Float height;
        public final Float width;

        /* renamed from: x  reason: collision with root package name */
        public final Float f28647x;

        /* renamed from: y  reason: collision with root package name */
        public final Float f28648y;

        public static final class Builder extends Message.a<RectArgs, Builder> {

            /* renamed from: d  reason: collision with root package name */
            public Float f28649d;

            /* renamed from: e  reason: collision with root package name */
            public Float f28650e;

            /* renamed from: f  reason: collision with root package name */
            public Float f28651f;

            /* renamed from: g  reason: collision with root package name */
            public Float f28652g;

            /* renamed from: h  reason: collision with root package name */
            public Float f28653h;

            /* renamed from: g */
            public RectArgs c() {
                return new RectArgs(this.f28649d, this.f28650e, this.f28651f, this.f28652g, this.f28653h, super.d());
            }

            public Builder h(Float f11) {
                this.f28653h = f11;
                return this;
            }

            public Builder i(Float f11) {
                this.f28652g = f11;
                return this;
            }

            public Builder j(Float f11) {
                this.f28651f = f11;
                return this;
            }

            public Builder k(Float f11) {
                this.f28649d = f11;
                return this;
            }

            public Builder l(Float f11) {
                this.f28650e = f11;
                return this;
            }
        }

        public static final class a extends ProtoAdapter<RectArgs> {
            public a() {
                super(FieldEncoding.LENGTH_DELIMITED, RectArgs.class);
            }

            /* renamed from: r */
            public RectArgs c(c cVar) throws IOException {
                Builder builder = new Builder();
                long c11 = cVar.c();
                while (true) {
                    int f11 = cVar.f();
                    if (f11 == -1) {
                        cVar.d(c11);
                        return builder.c();
                    } else if (f11 == 1) {
                        builder.k(ProtoAdapter.f30183o.c(cVar));
                    } else if (f11 == 2) {
                        builder.l(ProtoAdapter.f30183o.c(cVar));
                    } else if (f11 == 3) {
                        builder.j(ProtoAdapter.f30183o.c(cVar));
                    } else if (f11 == 4) {
                        builder.i(ProtoAdapter.f30183o.c(cVar));
                    } else if (f11 != 5) {
                        FieldEncoding g11 = cVar.g();
                        builder.a(f11, g11, g11.rawProtoAdapter().c(cVar));
                    } else {
                        builder.h(ProtoAdapter.f30183o.c(cVar));
                    }
                }
            }

            /* renamed from: s */
            public void g(d dVar, RectArgs rectArgs) throws IOException {
                Float f11 = rectArgs.f28647x;
                if (f11 != null) {
                    ProtoAdapter.f30183o.k(dVar, 1, f11);
                }
                Float f12 = rectArgs.f28648y;
                if (f12 != null) {
                    ProtoAdapter.f30183o.k(dVar, 2, f12);
                }
                Float f13 = rectArgs.width;
                if (f13 != null) {
                    ProtoAdapter.f30183o.k(dVar, 3, f13);
                }
                Float f14 = rectArgs.height;
                if (f14 != null) {
                    ProtoAdapter.f30183o.k(dVar, 4, f14);
                }
                Float f15 = rectArgs.cornerRadius;
                if (f15 != null) {
                    ProtoAdapter.f30183o.k(dVar, 5, f15);
                }
                dVar.k(rectArgs.unknownFields());
            }

            /* renamed from: t */
            public int l(RectArgs rectArgs) {
                Float f11 = rectArgs.f28647x;
                int i11 = 0;
                int m11 = f11 != null ? ProtoAdapter.f30183o.m(1, f11) : 0;
                Float f12 = rectArgs.f28648y;
                int m12 = m11 + (f12 != null ? ProtoAdapter.f30183o.m(2, f12) : 0);
                Float f13 = rectArgs.width;
                int m13 = m12 + (f13 != null ? ProtoAdapter.f30183o.m(3, f13) : 0);
                Float f14 = rectArgs.height;
                int m14 = m13 + (f14 != null ? ProtoAdapter.f30183o.m(4, f14) : 0);
                Float f15 = rectArgs.cornerRadius;
                if (f15 != null) {
                    i11 = ProtoAdapter.f30183o.m(5, f15);
                }
                return m14 + i11 + rectArgs.unknownFields().size();
            }
        }

        static {
            Float valueOf = Float.valueOf(0.0f);
            DEFAULT_X = valueOf;
            DEFAULT_Y = valueOf;
            DEFAULT_WIDTH = valueOf;
            DEFAULT_HEIGHT = valueOf;
            DEFAULT_CORNERRADIUS = valueOf;
        }

        public RectArgs(Float f11, Float f12, Float f13, Float f14, Float f15) {
            this(f11, f12, f13, f14, f15, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RectArgs)) {
                return false;
            }
            RectArgs rectArgs = (RectArgs) obj;
            if (!unknownFields().equals(rectArgs.unknownFields()) || !com.squareup.wire.internal.a.d(this.f28647x, rectArgs.f28647x) || !com.squareup.wire.internal.a.d(this.f28648y, rectArgs.f28648y) || !com.squareup.wire.internal.a.d(this.width, rectArgs.width) || !com.squareup.wire.internal.a.d(this.height, rectArgs.height) || !com.squareup.wire.internal.a.d(this.cornerRadius, rectArgs.cornerRadius)) {
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
            Float f11 = this.f28647x;
            int i12 = 0;
            int hashCode2 = (hashCode + (f11 != null ? f11.hashCode() : 0)) * 37;
            Float f12 = this.f28648y;
            int hashCode3 = (hashCode2 + (f12 != null ? f12.hashCode() : 0)) * 37;
            Float f13 = this.width;
            int hashCode4 = (hashCode3 + (f13 != null ? f13.hashCode() : 0)) * 37;
            Float f14 = this.height;
            int hashCode5 = (hashCode4 + (f14 != null ? f14.hashCode() : 0)) * 37;
            Float f15 = this.cornerRadius;
            if (f15 != null) {
                i12 = f15.hashCode();
            }
            int i13 = hashCode5 + i12;
            this.hashCode = i13;
            return i13;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.f28647x != null) {
                sb2.append(", x=");
                sb2.append(this.f28647x);
            }
            if (this.f28648y != null) {
                sb2.append(", y=");
                sb2.append(this.f28648y);
            }
            if (this.width != null) {
                sb2.append(", width=");
                sb2.append(this.width);
            }
            if (this.height != null) {
                sb2.append(", height=");
                sb2.append(this.height);
            }
            if (this.cornerRadius != null) {
                sb2.append(", cornerRadius=");
                sb2.append(this.cornerRadius);
            }
            StringBuilder replace = sb2.replace(0, 2, "RectArgs{");
            replace.append('}');
            return replace.toString();
        }

        public RectArgs(Float f11, Float f12, Float f13, Float f14, Float f15, ByteString byteString) {
            super(ADAPTER, byteString);
            this.f28647x = f11;
            this.f28648y = f12;
            this.width = f13;
            this.height = f14;
            this.cornerRadius = f15;
        }

        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.f28649d = this.f28647x;
            builder.f28650e = this.f28648y;
            builder.f28651f = this.width;
            builder.f28652g = this.height;
            builder.f28653h = this.cornerRadius;
            builder.b(unknownFields());
            return builder;
        }
    }

    public static final class ShapeArgs extends Message<ShapeArgs, Builder> {
        public static final ProtoAdapter<ShapeArgs> ADAPTER = new a();
        public static final String DEFAULT_D = "";
        private static final long serialVersionUID = 0;

        /* renamed from: d  reason: collision with root package name */
        public final String f28654d;

        public static final class Builder extends Message.a<ShapeArgs, Builder> {

            /* renamed from: d  reason: collision with root package name */
            public String f28655d;

            /* renamed from: g */
            public ShapeArgs c() {
                return new ShapeArgs(this.f28655d, super.d());
            }

            public Builder h(String str) {
                this.f28655d = str;
                return this;
            }
        }

        public static final class a extends ProtoAdapter<ShapeArgs> {
            public a() {
                super(FieldEncoding.LENGTH_DELIMITED, ShapeArgs.class);
            }

            /* renamed from: r */
            public ShapeArgs c(c cVar) throws IOException {
                Builder builder = new Builder();
                long c11 = cVar.c();
                while (true) {
                    int f11 = cVar.f();
                    if (f11 == -1) {
                        cVar.d(c11);
                        return builder.c();
                    } else if (f11 != 1) {
                        FieldEncoding g11 = cVar.g();
                        builder.a(f11, g11, g11.rawProtoAdapter().c(cVar));
                    } else {
                        builder.h(ProtoAdapter.f30185q.c(cVar));
                    }
                }
            }

            /* renamed from: s */
            public void g(d dVar, ShapeArgs shapeArgs) throws IOException {
                String str = shapeArgs.f28654d;
                if (str != null) {
                    ProtoAdapter.f30185q.k(dVar, 1, str);
                }
                dVar.k(shapeArgs.unknownFields());
            }

            /* renamed from: t */
            public int l(ShapeArgs shapeArgs) {
                String str = shapeArgs.f28654d;
                return (str != null ? ProtoAdapter.f30185q.m(1, str) : 0) + shapeArgs.unknownFields().size();
            }
        }

        public ShapeArgs(String str) {
            this(str, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShapeArgs)) {
                return false;
            }
            ShapeArgs shapeArgs = (ShapeArgs) obj;
            if (!unknownFields().equals(shapeArgs.unknownFields()) || !com.squareup.wire.internal.a.d(this.f28654d, shapeArgs.f28654d)) {
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
            String str = this.f28654d;
            int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.f28654d != null) {
                sb2.append(", d=");
                sb2.append(this.f28654d);
            }
            StringBuilder replace = sb2.replace(0, 2, "ShapeArgs{");
            replace.append('}');
            return replace.toString();
        }

        public ShapeArgs(String str, ByteString byteString) {
            super(ADAPTER, byteString);
            this.f28654d = str;
        }

        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.f28655d = this.f28654d;
            builder.b(unknownFields());
            return builder;
        }
    }

    public static final class ShapeStyle extends Message<ShapeStyle, Builder> {
        public static final ProtoAdapter<ShapeStyle> ADAPTER = new a();
        public static final LineCap DEFAULT_LINECAP = LineCap.LineCap_BUTT;
        public static final Float DEFAULT_LINEDASHI;
        public static final Float DEFAULT_LINEDASHII;
        public static final Float DEFAULT_LINEDASHIII;
        public static final LineJoin DEFAULT_LINEJOIN = LineJoin.LineJoin_MITER;
        public static final Float DEFAULT_MITERLIMIT;
        public static final Float DEFAULT_STROKEWIDTH;
        private static final long serialVersionUID = 0;
        public final RGBAColor fill;
        public final LineCap lineCap;
        public final Float lineDashI;
        public final Float lineDashII;
        public final Float lineDashIII;
        public final LineJoin lineJoin;
        public final Float miterLimit;
        public final RGBAColor stroke;
        public final Float strokeWidth;

        public static final class Builder extends Message.a<ShapeStyle, Builder> {

            /* renamed from: d  reason: collision with root package name */
            public RGBAColor f28656d;

            /* renamed from: e  reason: collision with root package name */
            public RGBAColor f28657e;

            /* renamed from: f  reason: collision with root package name */
            public Float f28658f;

            /* renamed from: g  reason: collision with root package name */
            public LineCap f28659g;

            /* renamed from: h  reason: collision with root package name */
            public LineJoin f28660h;

            /* renamed from: i  reason: collision with root package name */
            public Float f28661i;

            /* renamed from: j  reason: collision with root package name */
            public Float f28662j;

            /* renamed from: k  reason: collision with root package name */
            public Float f28663k;

            /* renamed from: l  reason: collision with root package name */
            public Float f28664l;

            /* renamed from: g */
            public ShapeStyle c() {
                return new ShapeStyle(this.f28656d, this.f28657e, this.f28658f, this.f28659g, this.f28660h, this.f28661i, this.f28662j, this.f28663k, this.f28664l, super.d());
            }

            public Builder h(RGBAColor rGBAColor) {
                this.f28656d = rGBAColor;
                return this;
            }

            public Builder i(LineCap lineCap) {
                this.f28659g = lineCap;
                return this;
            }

            public Builder j(Float f11) {
                this.f28662j = f11;
                return this;
            }

            public Builder k(Float f11) {
                this.f28663k = f11;
                return this;
            }

            public Builder l(Float f11) {
                this.f28664l = f11;
                return this;
            }

            public Builder m(LineJoin lineJoin) {
                this.f28660h = lineJoin;
                return this;
            }

            public Builder n(Float f11) {
                this.f28661i = f11;
                return this;
            }

            public Builder o(RGBAColor rGBAColor) {
                this.f28657e = rGBAColor;
                return this;
            }

            public Builder p(Float f11) {
                this.f28658f = f11;
                return this;
            }
        }

        public enum LineCap implements f {
            LineCap_BUTT(0),
            LineCap_ROUND(1),
            LineCap_SQUARE(2);
            
            public static final ProtoAdapter<LineCap> ADAPTER = null;
            private final int value;

            /* access modifiers changed from: public */
            static {
                ADAPTER = ProtoAdapter.o(LineCap.class);
            }

            private LineCap(int i11) {
                this.value = i11;
            }

            public static LineCap fromValue(int i11) {
                if (i11 == 0) {
                    return LineCap_BUTT;
                }
                if (i11 == 1) {
                    return LineCap_ROUND;
                }
                if (i11 != 2) {
                    return null;
                }
                return LineCap_SQUARE;
            }

            public int getValue() {
                return this.value;
            }
        }

        public enum LineJoin implements f {
            LineJoin_MITER(0),
            LineJoin_ROUND(1),
            LineJoin_BEVEL(2);
            
            public static final ProtoAdapter<LineJoin> ADAPTER = null;
            private final int value;

            /* access modifiers changed from: public */
            static {
                ADAPTER = ProtoAdapter.o(LineJoin.class);
            }

            private LineJoin(int i11) {
                this.value = i11;
            }

            public static LineJoin fromValue(int i11) {
                if (i11 == 0) {
                    return LineJoin_MITER;
                }
                if (i11 == 1) {
                    return LineJoin_ROUND;
                }
                if (i11 != 2) {
                    return null;
                }
                return LineJoin_BEVEL;
            }

            public int getValue() {
                return this.value;
            }
        }

        public static final class RGBAColor extends Message<RGBAColor, Builder> {
            public static final ProtoAdapter<RGBAColor> ADAPTER = new a();
            public static final Float DEFAULT_A;
            public static final Float DEFAULT_B;
            public static final Float DEFAULT_G;
            public static final Float DEFAULT_R;
            private static final long serialVersionUID = 0;

            /* renamed from: a  reason: collision with root package name */
            public final Float f28665a;

            /* renamed from: b  reason: collision with root package name */
            public final Float f28666b;

            /* renamed from: g  reason: collision with root package name */
            public final Float f28667g;

            /* renamed from: r  reason: collision with root package name */
            public final Float f28668r;

            public static final class Builder extends Message.a<RGBAColor, Builder> {

                /* renamed from: d  reason: collision with root package name */
                public Float f28669d;

                /* renamed from: e  reason: collision with root package name */
                public Float f28670e;

                /* renamed from: f  reason: collision with root package name */
                public Float f28671f;

                /* renamed from: g  reason: collision with root package name */
                public Float f28672g;

                public Builder g(Float f11) {
                    this.f28672g = f11;
                    return this;
                }

                public Builder h(Float f11) {
                    this.f28671f = f11;
                    return this;
                }

                /* renamed from: i */
                public RGBAColor c() {
                    return new RGBAColor(this.f28669d, this.f28670e, this.f28671f, this.f28672g, super.d());
                }

                public Builder j(Float f11) {
                    this.f28670e = f11;
                    return this;
                }

                public Builder k(Float f11) {
                    this.f28669d = f11;
                    return this;
                }
            }

            public static final class a extends ProtoAdapter<RGBAColor> {
                public a() {
                    super(FieldEncoding.LENGTH_DELIMITED, RGBAColor.class);
                }

                /* renamed from: r */
                public RGBAColor c(c cVar) throws IOException {
                    Builder builder = new Builder();
                    long c11 = cVar.c();
                    while (true) {
                        int f11 = cVar.f();
                        if (f11 == -1) {
                            cVar.d(c11);
                            return builder.c();
                        } else if (f11 == 1) {
                            builder.k(ProtoAdapter.f30183o.c(cVar));
                        } else if (f11 == 2) {
                            builder.j(ProtoAdapter.f30183o.c(cVar));
                        } else if (f11 == 3) {
                            builder.h(ProtoAdapter.f30183o.c(cVar));
                        } else if (f11 != 4) {
                            FieldEncoding g11 = cVar.g();
                            builder.a(f11, g11, g11.rawProtoAdapter().c(cVar));
                        } else {
                            builder.g(ProtoAdapter.f30183o.c(cVar));
                        }
                    }
                }

                /* renamed from: s */
                public void g(d dVar, RGBAColor rGBAColor) throws IOException {
                    Float f11 = rGBAColor.f28668r;
                    if (f11 != null) {
                        ProtoAdapter.f30183o.k(dVar, 1, f11);
                    }
                    Float f12 = rGBAColor.f28667g;
                    if (f12 != null) {
                        ProtoAdapter.f30183o.k(dVar, 2, f12);
                    }
                    Float f13 = rGBAColor.f28666b;
                    if (f13 != null) {
                        ProtoAdapter.f30183o.k(dVar, 3, f13);
                    }
                    Float f14 = rGBAColor.f28665a;
                    if (f14 != null) {
                        ProtoAdapter.f30183o.k(dVar, 4, f14);
                    }
                    dVar.k(rGBAColor.unknownFields());
                }

                /* renamed from: t */
                public int l(RGBAColor rGBAColor) {
                    Float f11 = rGBAColor.f28668r;
                    int i11 = 0;
                    int m11 = f11 != null ? ProtoAdapter.f30183o.m(1, f11) : 0;
                    Float f12 = rGBAColor.f28667g;
                    int m12 = m11 + (f12 != null ? ProtoAdapter.f30183o.m(2, f12) : 0);
                    Float f13 = rGBAColor.f28666b;
                    int m13 = m12 + (f13 != null ? ProtoAdapter.f30183o.m(3, f13) : 0);
                    Float f14 = rGBAColor.f28665a;
                    if (f14 != null) {
                        i11 = ProtoAdapter.f30183o.m(4, f14);
                    }
                    return m13 + i11 + rGBAColor.unknownFields().size();
                }
            }

            static {
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_R = valueOf;
                DEFAULT_G = valueOf;
                DEFAULT_B = valueOf;
                DEFAULT_A = valueOf;
            }

            public RGBAColor(Float f11, Float f12, Float f13, Float f14) {
                this(f11, f12, f13, f14, ByteString.EMPTY);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof RGBAColor)) {
                    return false;
                }
                RGBAColor rGBAColor = (RGBAColor) obj;
                if (!unknownFields().equals(rGBAColor.unknownFields()) || !com.squareup.wire.internal.a.d(this.f28668r, rGBAColor.f28668r) || !com.squareup.wire.internal.a.d(this.f28667g, rGBAColor.f28667g) || !com.squareup.wire.internal.a.d(this.f28666b, rGBAColor.f28666b) || !com.squareup.wire.internal.a.d(this.f28665a, rGBAColor.f28665a)) {
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
                Float f11 = this.f28668r;
                int i12 = 0;
                int hashCode2 = (hashCode + (f11 != null ? f11.hashCode() : 0)) * 37;
                Float f12 = this.f28667g;
                int hashCode3 = (hashCode2 + (f12 != null ? f12.hashCode() : 0)) * 37;
                Float f13 = this.f28666b;
                int hashCode4 = (hashCode3 + (f13 != null ? f13.hashCode() : 0)) * 37;
                Float f14 = this.f28665a;
                if (f14 != null) {
                    i12 = f14.hashCode();
                }
                int i13 = hashCode4 + i12;
                this.hashCode = i13;
                return i13;
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder();
                if (this.f28668r != null) {
                    sb2.append(", r=");
                    sb2.append(this.f28668r);
                }
                if (this.f28667g != null) {
                    sb2.append(", g=");
                    sb2.append(this.f28667g);
                }
                if (this.f28666b != null) {
                    sb2.append(", b=");
                    sb2.append(this.f28666b);
                }
                if (this.f28665a != null) {
                    sb2.append(", a=");
                    sb2.append(this.f28665a);
                }
                StringBuilder replace = sb2.replace(0, 2, "RGBAColor{");
                replace.append('}');
                return replace.toString();
            }

            public RGBAColor(Float f11, Float f12, Float f13, Float f14, ByteString byteString) {
                super(ADAPTER, byteString);
                this.f28668r = f11;
                this.f28667g = f12;
                this.f28666b = f13;
                this.f28665a = f14;
            }

            public Builder newBuilder() {
                Builder builder = new Builder();
                builder.f28669d = this.f28668r;
                builder.f28670e = this.f28667g;
                builder.f28671f = this.f28666b;
                builder.f28672g = this.f28665a;
                builder.b(unknownFields());
                return builder;
            }
        }

        public static final class a extends ProtoAdapter<ShapeStyle> {
            public a() {
                super(FieldEncoding.LENGTH_DELIMITED, ShapeStyle.class);
            }

            /* renamed from: r */
            public ShapeStyle c(c cVar) throws IOException {
                Builder builder = new Builder();
                long c11 = cVar.c();
                while (true) {
                    int f11 = cVar.f();
                    if (f11 != -1) {
                        switch (f11) {
                            case 1:
                                builder.h(RGBAColor.ADAPTER.c(cVar));
                                break;
                            case 2:
                                builder.o(RGBAColor.ADAPTER.c(cVar));
                                break;
                            case 3:
                                builder.p(ProtoAdapter.f30183o.c(cVar));
                                break;
                            case 4:
                                try {
                                    builder.i(LineCap.ADAPTER.c(cVar));
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e11) {
                                    builder.a(f11, FieldEncoding.VARINT, Long.valueOf((long) e11.value));
                                    break;
                                }
                            case 5:
                                try {
                                    builder.m(LineJoin.ADAPTER.c(cVar));
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e12) {
                                    builder.a(f11, FieldEncoding.VARINT, Long.valueOf((long) e12.value));
                                    break;
                                }
                            case 6:
                                builder.n(ProtoAdapter.f30183o.c(cVar));
                                break;
                            case 7:
                                builder.j(ProtoAdapter.f30183o.c(cVar));
                                break;
                            case 8:
                                builder.k(ProtoAdapter.f30183o.c(cVar));
                                break;
                            case 9:
                                builder.l(ProtoAdapter.f30183o.c(cVar));
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
            public void g(d dVar, ShapeStyle shapeStyle) throws IOException {
                RGBAColor rGBAColor = shapeStyle.fill;
                if (rGBAColor != null) {
                    RGBAColor.ADAPTER.k(dVar, 1, rGBAColor);
                }
                RGBAColor rGBAColor2 = shapeStyle.stroke;
                if (rGBAColor2 != null) {
                    RGBAColor.ADAPTER.k(dVar, 2, rGBAColor2);
                }
                Float f11 = shapeStyle.strokeWidth;
                if (f11 != null) {
                    ProtoAdapter.f30183o.k(dVar, 3, f11);
                }
                LineCap lineCap = shapeStyle.lineCap;
                if (lineCap != null) {
                    LineCap.ADAPTER.k(dVar, 4, lineCap);
                }
                LineJoin lineJoin = shapeStyle.lineJoin;
                if (lineJoin != null) {
                    LineJoin.ADAPTER.k(dVar, 5, lineJoin);
                }
                Float f12 = shapeStyle.miterLimit;
                if (f12 != null) {
                    ProtoAdapter.f30183o.k(dVar, 6, f12);
                }
                Float f13 = shapeStyle.lineDashI;
                if (f13 != null) {
                    ProtoAdapter.f30183o.k(dVar, 7, f13);
                }
                Float f14 = shapeStyle.lineDashII;
                if (f14 != null) {
                    ProtoAdapter.f30183o.k(dVar, 8, f14);
                }
                Float f15 = shapeStyle.lineDashIII;
                if (f15 != null) {
                    ProtoAdapter.f30183o.k(dVar, 9, f15);
                }
                dVar.k(shapeStyle.unknownFields());
            }

            /* renamed from: t */
            public int l(ShapeStyle shapeStyle) {
                RGBAColor rGBAColor = shapeStyle.fill;
                int i11 = 0;
                int m11 = rGBAColor != null ? RGBAColor.ADAPTER.m(1, rGBAColor) : 0;
                RGBAColor rGBAColor2 = shapeStyle.stroke;
                int m12 = m11 + (rGBAColor2 != null ? RGBAColor.ADAPTER.m(2, rGBAColor2) : 0);
                Float f11 = shapeStyle.strokeWidth;
                int m13 = m12 + (f11 != null ? ProtoAdapter.f30183o.m(3, f11) : 0);
                LineCap lineCap = shapeStyle.lineCap;
                int m14 = m13 + (lineCap != null ? LineCap.ADAPTER.m(4, lineCap) : 0);
                LineJoin lineJoin = shapeStyle.lineJoin;
                int m15 = m14 + (lineJoin != null ? LineJoin.ADAPTER.m(5, lineJoin) : 0);
                Float f12 = shapeStyle.miterLimit;
                int m16 = m15 + (f12 != null ? ProtoAdapter.f30183o.m(6, f12) : 0);
                Float f13 = shapeStyle.lineDashI;
                int m17 = m16 + (f13 != null ? ProtoAdapter.f30183o.m(7, f13) : 0);
                Float f14 = shapeStyle.lineDashII;
                int m18 = m17 + (f14 != null ? ProtoAdapter.f30183o.m(8, f14) : 0);
                Float f15 = shapeStyle.lineDashIII;
                if (f15 != null) {
                    i11 = ProtoAdapter.f30183o.m(9, f15);
                }
                return m18 + i11 + shapeStyle.unknownFields().size();
            }
        }

        static {
            Float valueOf = Float.valueOf(0.0f);
            DEFAULT_STROKEWIDTH = valueOf;
            DEFAULT_MITERLIMIT = valueOf;
            DEFAULT_LINEDASHI = valueOf;
            DEFAULT_LINEDASHII = valueOf;
            DEFAULT_LINEDASHIII = valueOf;
        }

        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f11, LineCap lineCap2, LineJoin lineJoin2, Float f12, Float f13, Float f14, Float f15) {
            this(rGBAColor, rGBAColor2, f11, lineCap2, lineJoin2, f12, f13, f14, f15, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShapeStyle)) {
                return false;
            }
            ShapeStyle shapeStyle = (ShapeStyle) obj;
            if (!unknownFields().equals(shapeStyle.unknownFields()) || !com.squareup.wire.internal.a.d(this.fill, shapeStyle.fill) || !com.squareup.wire.internal.a.d(this.stroke, shapeStyle.stroke) || !com.squareup.wire.internal.a.d(this.strokeWidth, shapeStyle.strokeWidth) || !com.squareup.wire.internal.a.d(this.lineCap, shapeStyle.lineCap) || !com.squareup.wire.internal.a.d(this.lineJoin, shapeStyle.lineJoin) || !com.squareup.wire.internal.a.d(this.miterLimit, shapeStyle.miterLimit) || !com.squareup.wire.internal.a.d(this.lineDashI, shapeStyle.lineDashI) || !com.squareup.wire.internal.a.d(this.lineDashII, shapeStyle.lineDashII) || !com.squareup.wire.internal.a.d(this.lineDashIII, shapeStyle.lineDashIII)) {
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
            RGBAColor rGBAColor = this.fill;
            int i12 = 0;
            int hashCode2 = (hashCode + (rGBAColor != null ? rGBAColor.hashCode() : 0)) * 37;
            RGBAColor rGBAColor2 = this.stroke;
            int hashCode3 = (hashCode2 + (rGBAColor2 != null ? rGBAColor2.hashCode() : 0)) * 37;
            Float f11 = this.strokeWidth;
            int hashCode4 = (hashCode3 + (f11 != null ? f11.hashCode() : 0)) * 37;
            LineCap lineCap2 = this.lineCap;
            int hashCode5 = (hashCode4 + (lineCap2 != null ? lineCap2.hashCode() : 0)) * 37;
            LineJoin lineJoin2 = this.lineJoin;
            int hashCode6 = (hashCode5 + (lineJoin2 != null ? lineJoin2.hashCode() : 0)) * 37;
            Float f12 = this.miterLimit;
            int hashCode7 = (hashCode6 + (f12 != null ? f12.hashCode() : 0)) * 37;
            Float f13 = this.lineDashI;
            int hashCode8 = (hashCode7 + (f13 != null ? f13.hashCode() : 0)) * 37;
            Float f14 = this.lineDashII;
            int hashCode9 = (hashCode8 + (f14 != null ? f14.hashCode() : 0)) * 37;
            Float f15 = this.lineDashIII;
            if (f15 != null) {
                i12 = f15.hashCode();
            }
            int i13 = hashCode9 + i12;
            this.hashCode = i13;
            return i13;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.fill != null) {
                sb2.append(", fill=");
                sb2.append(this.fill);
            }
            if (this.stroke != null) {
                sb2.append(", stroke=");
                sb2.append(this.stroke);
            }
            if (this.strokeWidth != null) {
                sb2.append(", strokeWidth=");
                sb2.append(this.strokeWidth);
            }
            if (this.lineCap != null) {
                sb2.append(", lineCap=");
                sb2.append(this.lineCap);
            }
            if (this.lineJoin != null) {
                sb2.append(", lineJoin=");
                sb2.append(this.lineJoin);
            }
            if (this.miterLimit != null) {
                sb2.append(", miterLimit=");
                sb2.append(this.miterLimit);
            }
            if (this.lineDashI != null) {
                sb2.append(", lineDashI=");
                sb2.append(this.lineDashI);
            }
            if (this.lineDashII != null) {
                sb2.append(", lineDashII=");
                sb2.append(this.lineDashII);
            }
            if (this.lineDashIII != null) {
                sb2.append(", lineDashIII=");
                sb2.append(this.lineDashIII);
            }
            StringBuilder replace = sb2.replace(0, 2, "ShapeStyle{");
            replace.append('}');
            return replace.toString();
        }

        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f11, LineCap lineCap2, LineJoin lineJoin2, Float f12, Float f13, Float f14, Float f15, ByteString byteString) {
            super(ADAPTER, byteString);
            this.fill = rGBAColor;
            this.stroke = rGBAColor2;
            this.strokeWidth = f11;
            this.lineCap = lineCap2;
            this.lineJoin = lineJoin2;
            this.miterLimit = f12;
            this.lineDashI = f13;
            this.lineDashII = f14;
            this.lineDashIII = f15;
        }

        public Builder newBuilder() {
            Builder builder = new Builder();
            builder.f28656d = this.fill;
            builder.f28657e = this.stroke;
            builder.f28658f = this.strokeWidth;
            builder.f28659g = this.lineCap;
            builder.f28660h = this.lineJoin;
            builder.f28661i = this.miterLimit;
            builder.f28662j = this.lineDashI;
            builder.f28663k = this.lineDashII;
            builder.f28664l = this.lineDashIII;
            builder.b(unknownFields());
            return builder;
        }
    }

    public enum ShapeType implements f {
        SHAPE(0),
        RECT(1),
        ELLIPSE(2),
        KEEP(3);
        
        public static final ProtoAdapter<ShapeType> ADAPTER = null;
        private final int value;

        /* access modifiers changed from: public */
        static {
            ADAPTER = ProtoAdapter.o(ShapeType.class);
        }

        private ShapeType(int i11) {
            this.value = i11;
        }

        public static ShapeType fromValue(int i11) {
            if (i11 == 0) {
                return SHAPE;
            }
            if (i11 == 1) {
                return RECT;
            }
            if (i11 == 2) {
                return ELLIPSE;
            }
            if (i11 != 3) {
                return null;
            }
            return KEEP;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final class a extends ProtoAdapter<ShapeEntity> {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, ShapeEntity.class);
        }

        /* renamed from: r */
        public ShapeEntity c(c cVar) throws IOException {
            Builder builder = new Builder();
            long c11 = cVar.c();
            while (true) {
                int f11 = cVar.f();
                if (f11 == -1) {
                    cVar.d(c11);
                    return builder.c();
                } else if (f11 == 1) {
                    try {
                        builder.m(ShapeType.ADAPTER.c(cVar));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e11) {
                        builder.a(f11, FieldEncoding.VARINT, Long.valueOf((long) e11.value));
                    }
                } else if (f11 == 2) {
                    builder.j(ShapeArgs.ADAPTER.c(cVar));
                } else if (f11 == 3) {
                    builder.i(RectArgs.ADAPTER.c(cVar));
                } else if (f11 == 4) {
                    builder.h(EllipseArgs.ADAPTER.c(cVar));
                } else if (f11 == 10) {
                    builder.k(ShapeStyle.ADAPTER.c(cVar));
                } else if (f11 != 11) {
                    FieldEncoding g11 = cVar.g();
                    builder.a(f11, g11, g11.rawProtoAdapter().c(cVar));
                } else {
                    builder.l(Transform.ADAPTER.c(cVar));
                }
            }
        }

        /* renamed from: s */
        public void g(d dVar, ShapeEntity shapeEntity) throws IOException {
            ShapeType shapeType = shapeEntity.type;
            if (shapeType != null) {
                ShapeType.ADAPTER.k(dVar, 1, shapeType);
            }
            ShapeStyle shapeStyle = shapeEntity.styles;
            if (shapeStyle != null) {
                ShapeStyle.ADAPTER.k(dVar, 10, shapeStyle);
            }
            Transform transform = shapeEntity.transform;
            if (transform != null) {
                Transform.ADAPTER.k(dVar, 11, transform);
            }
            ShapeArgs shapeArgs = shapeEntity.shape;
            if (shapeArgs != null) {
                ShapeArgs.ADAPTER.k(dVar, 2, shapeArgs);
            }
            RectArgs rectArgs = shapeEntity.rect;
            if (rectArgs != null) {
                RectArgs.ADAPTER.k(dVar, 3, rectArgs);
            }
            EllipseArgs ellipseArgs = shapeEntity.ellipse;
            if (ellipseArgs != null) {
                EllipseArgs.ADAPTER.k(dVar, 4, ellipseArgs);
            }
            dVar.k(shapeEntity.unknownFields());
        }

        /* renamed from: t */
        public int l(ShapeEntity shapeEntity) {
            ShapeType shapeType = shapeEntity.type;
            int i11 = 0;
            int m11 = shapeType != null ? ShapeType.ADAPTER.m(1, shapeType) : 0;
            ShapeStyle shapeStyle = shapeEntity.styles;
            int m12 = m11 + (shapeStyle != null ? ShapeStyle.ADAPTER.m(10, shapeStyle) : 0);
            Transform transform = shapeEntity.transform;
            int m13 = m12 + (transform != null ? Transform.ADAPTER.m(11, transform) : 0);
            ShapeArgs shapeArgs = shapeEntity.shape;
            int m14 = m13 + (shapeArgs != null ? ShapeArgs.ADAPTER.m(2, shapeArgs) : 0);
            RectArgs rectArgs = shapeEntity.rect;
            int m15 = m14 + (rectArgs != null ? RectArgs.ADAPTER.m(3, rectArgs) : 0);
            EllipseArgs ellipseArgs = shapeEntity.ellipse;
            if (ellipseArgs != null) {
                i11 = EllipseArgs.ADAPTER.m(4, ellipseArgs);
            }
            return m15 + i11 + shapeEntity.unknownFields().size();
        }
    }

    public ShapeEntity(ShapeType shapeType, ShapeStyle shapeStyle, Transform transform2, ShapeArgs shapeArgs, RectArgs rectArgs, EllipseArgs ellipseArgs) {
        this(shapeType, shapeStyle, transform2, shapeArgs, rectArgs, ellipseArgs, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShapeEntity)) {
            return false;
        }
        ShapeEntity shapeEntity = (ShapeEntity) obj;
        if (!unknownFields().equals(shapeEntity.unknownFields()) || !com.squareup.wire.internal.a.d(this.type, shapeEntity.type) || !com.squareup.wire.internal.a.d(this.styles, shapeEntity.styles) || !com.squareup.wire.internal.a.d(this.transform, shapeEntity.transform) || !com.squareup.wire.internal.a.d(this.shape, shapeEntity.shape) || !com.squareup.wire.internal.a.d(this.rect, shapeEntity.rect) || !com.squareup.wire.internal.a.d(this.ellipse, shapeEntity.ellipse)) {
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
        ShapeType shapeType = this.type;
        int i12 = 0;
        int hashCode2 = (hashCode + (shapeType != null ? shapeType.hashCode() : 0)) * 37;
        ShapeStyle shapeStyle = this.styles;
        int hashCode3 = (hashCode2 + (shapeStyle != null ? shapeStyle.hashCode() : 0)) * 37;
        Transform transform2 = this.transform;
        int hashCode4 = (hashCode3 + (transform2 != null ? transform2.hashCode() : 0)) * 37;
        ShapeArgs shapeArgs = this.shape;
        int hashCode5 = (hashCode4 + (shapeArgs != null ? shapeArgs.hashCode() : 0)) * 37;
        RectArgs rectArgs = this.rect;
        int hashCode6 = (hashCode5 + (rectArgs != null ? rectArgs.hashCode() : 0)) * 37;
        EllipseArgs ellipseArgs = this.ellipse;
        if (ellipseArgs != null) {
            i12 = ellipseArgs.hashCode();
        }
        int i13 = hashCode6 + i12;
        this.hashCode = i13;
        return i13;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.type != null) {
            sb2.append(", type=");
            sb2.append(this.type);
        }
        if (this.styles != null) {
            sb2.append(", styles=");
            sb2.append(this.styles);
        }
        if (this.transform != null) {
            sb2.append(", transform=");
            sb2.append(this.transform);
        }
        if (this.shape != null) {
            sb2.append(", shape=");
            sb2.append(this.shape);
        }
        if (this.rect != null) {
            sb2.append(", rect=");
            sb2.append(this.rect);
        }
        if (this.ellipse != null) {
            sb2.append(", ellipse=");
            sb2.append(this.ellipse);
        }
        StringBuilder replace = sb2.replace(0, 2, "ShapeEntity{");
        replace.append('}');
        return replace.toString();
    }

    public ShapeEntity(ShapeType shapeType, ShapeStyle shapeStyle, Transform transform2, ShapeArgs shapeArgs, RectArgs rectArgs, EllipseArgs ellipseArgs, ByteString byteString) {
        super(ADAPTER, byteString);
        if (com.squareup.wire.internal.a.c(shapeArgs, rectArgs, ellipseArgs) <= 1) {
            this.type = shapeType;
            this.styles = shapeStyle;
            this.transform = transform2;
            this.shape = shapeArgs;
            this.rect = rectArgs;
            this.ellipse = ellipseArgs;
            return;
        }
        throw new IllegalArgumentException("at most one of shape, rect, ellipse may be non-null");
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f28635d = this.type;
        builder.f28636e = this.styles;
        builder.f28637f = this.transform;
        builder.f28638g = this.shape;
        builder.f28639h = this.rect;
        builder.f28640i = this.ellipse;
        builder.b(unknownFields());
        return builder;
    }
}
