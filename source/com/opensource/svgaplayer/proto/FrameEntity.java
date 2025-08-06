package com.opensource.svgaplayer.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.d;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

public final class FrameEntity extends Message<FrameEntity, Builder> {
    public static final ProtoAdapter<FrameEntity> ADAPTER = new a();
    public static final Float DEFAULT_ALPHA = Float.valueOf(0.0f);
    public static final String DEFAULT_CLIPPATH = "";
    private static final long serialVersionUID = 0;
    public final Float alpha;
    public final String clipPath;
    public final Layout layout;
    public final List<ShapeEntity> shapes;
    public final Transform transform;

    public static final class Builder extends Message.a<FrameEntity, Builder> {

        /* renamed from: d  reason: collision with root package name */
        public Float f28614d;

        /* renamed from: e  reason: collision with root package name */
        public Layout f28615e;

        /* renamed from: f  reason: collision with root package name */
        public Transform f28616f;

        /* renamed from: g  reason: collision with root package name */
        public String f28617g;

        /* renamed from: h  reason: collision with root package name */
        public List<ShapeEntity> f28618h = com.squareup.wire.internal.a.g();

        public Builder g(Float f11) {
            this.f28614d = f11;
            return this;
        }

        /* renamed from: h */
        public FrameEntity c() {
            return new FrameEntity(this.f28614d, this.f28615e, this.f28616f, this.f28617g, this.f28618h, super.d());
        }

        public Builder i(String str) {
            this.f28617g = str;
            return this;
        }

        public Builder j(Layout layout) {
            this.f28615e = layout;
            return this;
        }

        public Builder k(Transform transform) {
            this.f28616f = transform;
            return this;
        }
    }

    public static final class a extends ProtoAdapter<FrameEntity> {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, FrameEntity.class);
        }

        /* renamed from: r */
        public FrameEntity c(c cVar) throws IOException {
            Builder builder = new Builder();
            long c11 = cVar.c();
            while (true) {
                int f11 = cVar.f();
                if (f11 == -1) {
                    cVar.d(c11);
                    return builder.c();
                } else if (f11 == 1) {
                    builder.g(ProtoAdapter.f30183o.c(cVar));
                } else if (f11 == 2) {
                    builder.j(Layout.ADAPTER.c(cVar));
                } else if (f11 == 3) {
                    builder.k(Transform.ADAPTER.c(cVar));
                } else if (f11 == 4) {
                    builder.i(ProtoAdapter.f30185q.c(cVar));
                } else if (f11 != 5) {
                    FieldEncoding g11 = cVar.g();
                    builder.a(f11, g11, g11.rawProtoAdapter().c(cVar));
                } else {
                    builder.f28618h.add(ShapeEntity.ADAPTER.c(cVar));
                }
            }
        }

        /* renamed from: s */
        public void g(d dVar, FrameEntity frameEntity) throws IOException {
            Float f11 = frameEntity.alpha;
            if (f11 != null) {
                ProtoAdapter.f30183o.k(dVar, 1, f11);
            }
            Layout layout = frameEntity.layout;
            if (layout != null) {
                Layout.ADAPTER.k(dVar, 2, layout);
            }
            Transform transform = frameEntity.transform;
            if (transform != null) {
                Transform.ADAPTER.k(dVar, 3, transform);
            }
            String str = frameEntity.clipPath;
            if (str != null) {
                ProtoAdapter.f30185q.k(dVar, 4, str);
            }
            ShapeEntity.ADAPTER.a().k(dVar, 5, frameEntity.shapes);
            dVar.k(frameEntity.unknownFields());
        }

        /* renamed from: t */
        public int l(FrameEntity frameEntity) {
            Float f11 = frameEntity.alpha;
            int i11 = 0;
            int m11 = f11 != null ? ProtoAdapter.f30183o.m(1, f11) : 0;
            Layout layout = frameEntity.layout;
            int m12 = m11 + (layout != null ? Layout.ADAPTER.m(2, layout) : 0);
            Transform transform = frameEntity.transform;
            int m13 = m12 + (transform != null ? Transform.ADAPTER.m(3, transform) : 0);
            String str = frameEntity.clipPath;
            if (str != null) {
                i11 = ProtoAdapter.f30185q.m(4, str);
            }
            return m13 + i11 + ShapeEntity.ADAPTER.a().m(5, frameEntity.shapes) + frameEntity.unknownFields().size();
        }
    }

    public FrameEntity(Float f11, Layout layout2, Transform transform2, String str, List<ShapeEntity> list) {
        this(f11, layout2, transform2, str, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FrameEntity)) {
            return false;
        }
        FrameEntity frameEntity = (FrameEntity) obj;
        if (!unknownFields().equals(frameEntity.unknownFields()) || !com.squareup.wire.internal.a.d(this.alpha, frameEntity.alpha) || !com.squareup.wire.internal.a.d(this.layout, frameEntity.layout) || !com.squareup.wire.internal.a.d(this.transform, frameEntity.transform) || !com.squareup.wire.internal.a.d(this.clipPath, frameEntity.clipPath) || !this.shapes.equals(frameEntity.shapes)) {
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
        Float f11 = this.alpha;
        int i12 = 0;
        int hashCode2 = (hashCode + (f11 != null ? f11.hashCode() : 0)) * 37;
        Layout layout2 = this.layout;
        int hashCode3 = (hashCode2 + (layout2 != null ? layout2.hashCode() : 0)) * 37;
        Transform transform2 = this.transform;
        int hashCode4 = (hashCode3 + (transform2 != null ? transform2.hashCode() : 0)) * 37;
        String str = this.clipPath;
        if (str != null) {
            i12 = str.hashCode();
        }
        int hashCode5 = ((hashCode4 + i12) * 37) + this.shapes.hashCode();
        this.hashCode = hashCode5;
        return hashCode5;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.alpha != null) {
            sb2.append(", alpha=");
            sb2.append(this.alpha);
        }
        if (this.layout != null) {
            sb2.append(", layout=");
            sb2.append(this.layout);
        }
        if (this.transform != null) {
            sb2.append(", transform=");
            sb2.append(this.transform);
        }
        if (this.clipPath != null) {
            sb2.append(", clipPath=");
            sb2.append(this.clipPath);
        }
        if (!this.shapes.isEmpty()) {
            sb2.append(", shapes=");
            sb2.append(this.shapes);
        }
        StringBuilder replace = sb2.replace(0, 2, "FrameEntity{");
        replace.append('}');
        return replace.toString();
    }

    public FrameEntity(Float f11, Layout layout2, Transform transform2, String str, List<ShapeEntity> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.alpha = f11;
        this.layout = layout2;
        this.transform = transform2;
        this.clipPath = str;
        this.shapes = com.squareup.wire.internal.a.e("shapes", list);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f28614d = this.alpha;
        builder.f28615e = this.layout;
        builder.f28616f = this.transform;
        builder.f28617g = this.clipPath;
        builder.f28618h = com.squareup.wire.internal.a.a("shapes", this.shapes);
        builder.b(unknownFields());
        return builder;
    }
}
