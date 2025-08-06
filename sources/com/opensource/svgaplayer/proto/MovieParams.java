package com.opensource.svgaplayer.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.d;
import java.io.IOException;
import okio.ByteString;

public final class MovieParams extends Message<MovieParams, Builder> {
    public static final ProtoAdapter<MovieParams> ADAPTER = new a();
    public static final Integer DEFAULT_FPS = 0;
    public static final Integer DEFAULT_FRAMES = 0;
    public static final Float DEFAULT_VIEWBOXHEIGHT;
    public static final Float DEFAULT_VIEWBOXWIDTH;
    private static final long serialVersionUID = 0;
    public final Integer fps;
    public final Integer frames;
    public final Float viewBoxHeight;
    public final Float viewBoxWidth;

    public static final class Builder extends Message.a<MovieParams, Builder> {

        /* renamed from: d  reason: collision with root package name */
        public Float f28631d;

        /* renamed from: e  reason: collision with root package name */
        public Float f28632e;

        /* renamed from: f  reason: collision with root package name */
        public Integer f28633f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f28634g;

        /* renamed from: g */
        public MovieParams c() {
            return new MovieParams(this.f28631d, this.f28632e, this.f28633f, this.f28634g, super.d());
        }

        public Builder h(Integer num) {
            this.f28633f = num;
            return this;
        }

        public Builder i(Integer num) {
            this.f28634g = num;
            return this;
        }

        public Builder j(Float f11) {
            this.f28632e = f11;
            return this;
        }

        public Builder k(Float f11) {
            this.f28631d = f11;
            return this;
        }
    }

    public static final class a extends ProtoAdapter<MovieParams> {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, MovieParams.class);
        }

        /* renamed from: r */
        public MovieParams c(c cVar) throws IOException {
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
                    builder.h(ProtoAdapter.f30173e.c(cVar));
                } else if (f11 != 4) {
                    FieldEncoding g11 = cVar.g();
                    builder.a(f11, g11, g11.rawProtoAdapter().c(cVar));
                } else {
                    builder.i(ProtoAdapter.f30173e.c(cVar));
                }
            }
        }

        /* renamed from: s */
        public void g(d dVar, MovieParams movieParams) throws IOException {
            Float f11 = movieParams.viewBoxWidth;
            if (f11 != null) {
                ProtoAdapter.f30183o.k(dVar, 1, f11);
            }
            Float f12 = movieParams.viewBoxHeight;
            if (f12 != null) {
                ProtoAdapter.f30183o.k(dVar, 2, f12);
            }
            Integer num = movieParams.fps;
            if (num != null) {
                ProtoAdapter.f30173e.k(dVar, 3, num);
            }
            Integer num2 = movieParams.frames;
            if (num2 != null) {
                ProtoAdapter.f30173e.k(dVar, 4, num2);
            }
            dVar.k(movieParams.unknownFields());
        }

        /* renamed from: t */
        public int l(MovieParams movieParams) {
            Float f11 = movieParams.viewBoxWidth;
            int i11 = 0;
            int m11 = f11 != null ? ProtoAdapter.f30183o.m(1, f11) : 0;
            Float f12 = movieParams.viewBoxHeight;
            int m12 = m11 + (f12 != null ? ProtoAdapter.f30183o.m(2, f12) : 0);
            Integer num = movieParams.fps;
            int m13 = m12 + (num != null ? ProtoAdapter.f30173e.m(3, num) : 0);
            Integer num2 = movieParams.frames;
            if (num2 != null) {
                i11 = ProtoAdapter.f30173e.m(4, num2);
            }
            return m13 + i11 + movieParams.unknownFields().size();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_VIEWBOXWIDTH = valueOf;
        DEFAULT_VIEWBOXHEIGHT = valueOf;
    }

    public MovieParams(Float f11, Float f12, Integer num, Integer num2) {
        this(f11, f12, num, num2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MovieParams)) {
            return false;
        }
        MovieParams movieParams = (MovieParams) obj;
        if (!unknownFields().equals(movieParams.unknownFields()) || !com.squareup.wire.internal.a.d(this.viewBoxWidth, movieParams.viewBoxWidth) || !com.squareup.wire.internal.a.d(this.viewBoxHeight, movieParams.viewBoxHeight) || !com.squareup.wire.internal.a.d(this.fps, movieParams.fps) || !com.squareup.wire.internal.a.d(this.frames, movieParams.frames)) {
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
        Float f11 = this.viewBoxWidth;
        int i12 = 0;
        int hashCode2 = (hashCode + (f11 != null ? f11.hashCode() : 0)) * 37;
        Float f12 = this.viewBoxHeight;
        int hashCode3 = (hashCode2 + (f12 != null ? f12.hashCode() : 0)) * 37;
        Integer num = this.fps;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.frames;
        if (num2 != null) {
            i12 = num2.hashCode();
        }
        int i13 = hashCode4 + i12;
        this.hashCode = i13;
        return i13;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.viewBoxWidth != null) {
            sb2.append(", viewBoxWidth=");
            sb2.append(this.viewBoxWidth);
        }
        if (this.viewBoxHeight != null) {
            sb2.append(", viewBoxHeight=");
            sb2.append(this.viewBoxHeight);
        }
        if (this.fps != null) {
            sb2.append(", fps=");
            sb2.append(this.fps);
        }
        if (this.frames != null) {
            sb2.append(", frames=");
            sb2.append(this.frames);
        }
        StringBuilder replace = sb2.replace(0, 2, "MovieParams{");
        replace.append('}');
        return replace.toString();
    }

    public MovieParams(Float f11, Float f12, Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.viewBoxWidth = f11;
        this.viewBoxHeight = f12;
        this.fps = num;
        this.frames = num2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f28631d = this.viewBoxWidth;
        builder.f28632e = this.viewBoxHeight;
        builder.f28633f = this.fps;
        builder.f28634g = this.frames;
        builder.b(unknownFields());
        return builder;
    }
}
