package com.opensource.svgaplayer.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.d;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

public final class SpriteEntity extends Message<SpriteEntity, Builder> {
    public static final ProtoAdapter<SpriteEntity> ADAPTER = new a();
    public static final String DEFAULT_IMAGEKEY = "";
    public static final String DEFAULT_MATTEKEY = "";
    private static final long serialVersionUID = 0;
    public final List<FrameEntity> frames;
    public final String imageKey;
    public final String matteKey;

    public static final class Builder extends Message.a<SpriteEntity, Builder> {

        /* renamed from: d  reason: collision with root package name */
        public String f28673d;

        /* renamed from: e  reason: collision with root package name */
        public List<FrameEntity> f28674e = com.squareup.wire.internal.a.g();

        /* renamed from: f  reason: collision with root package name */
        public String f28675f;

        /* renamed from: g */
        public SpriteEntity c() {
            return new SpriteEntity(this.f28673d, this.f28674e, this.f28675f, super.d());
        }

        public Builder h(String str) {
            this.f28673d = str;
            return this;
        }

        public Builder i(String str) {
            this.f28675f = str;
            return this;
        }
    }

    public static final class a extends ProtoAdapter<SpriteEntity> {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, SpriteEntity.class);
        }

        /* renamed from: r */
        public SpriteEntity c(c cVar) throws IOException {
            Builder builder = new Builder();
            long c11 = cVar.c();
            while (true) {
                int f11 = cVar.f();
                if (f11 == -1) {
                    cVar.d(c11);
                    return builder.c();
                } else if (f11 == 1) {
                    builder.h(ProtoAdapter.f30185q.c(cVar));
                } else if (f11 == 2) {
                    builder.f28674e.add(FrameEntity.ADAPTER.c(cVar));
                } else if (f11 != 3) {
                    FieldEncoding g11 = cVar.g();
                    builder.a(f11, g11, g11.rawProtoAdapter().c(cVar));
                } else {
                    builder.i(ProtoAdapter.f30185q.c(cVar));
                }
            }
        }

        /* renamed from: s */
        public void g(d dVar, SpriteEntity spriteEntity) throws IOException {
            String str = spriteEntity.imageKey;
            if (str != null) {
                ProtoAdapter.f30185q.k(dVar, 1, str);
            }
            FrameEntity.ADAPTER.a().k(dVar, 2, spriteEntity.frames);
            String str2 = spriteEntity.matteKey;
            if (str2 != null) {
                ProtoAdapter.f30185q.k(dVar, 3, str2);
            }
            dVar.k(spriteEntity.unknownFields());
        }

        /* renamed from: t */
        public int l(SpriteEntity spriteEntity) {
            String str = spriteEntity.imageKey;
            int i11 = 0;
            int m11 = (str != null ? ProtoAdapter.f30185q.m(1, str) : 0) + FrameEntity.ADAPTER.a().m(2, spriteEntity.frames);
            String str2 = spriteEntity.matteKey;
            if (str2 != null) {
                i11 = ProtoAdapter.f30185q.m(3, str2);
            }
            return m11 + i11 + spriteEntity.unknownFields().size();
        }
    }

    public SpriteEntity(String str, List<FrameEntity> list, String str2) {
        this(str, list, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpriteEntity)) {
            return false;
        }
        SpriteEntity spriteEntity = (SpriteEntity) obj;
        if (!unknownFields().equals(spriteEntity.unknownFields()) || !com.squareup.wire.internal.a.d(this.imageKey, spriteEntity.imageKey) || !this.frames.equals(spriteEntity.frames) || !com.squareup.wire.internal.a.d(this.matteKey, spriteEntity.matteKey)) {
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
        String str = this.imageKey;
        int i12 = 0;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 37) + this.frames.hashCode()) * 37;
        String str2 = this.matteKey;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        int i13 = hashCode2 + i12;
        this.hashCode = i13;
        return i13;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.imageKey != null) {
            sb2.append(", imageKey=");
            sb2.append(this.imageKey);
        }
        if (!this.frames.isEmpty()) {
            sb2.append(", frames=");
            sb2.append(this.frames);
        }
        if (this.matteKey != null) {
            sb2.append(", matteKey=");
            sb2.append(this.matteKey);
        }
        StringBuilder replace = sb2.replace(0, 2, "SpriteEntity{");
        replace.append('}');
        return replace.toString();
    }

    public SpriteEntity(String str, List<FrameEntity> list, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.imageKey = str;
        this.frames = com.squareup.wire.internal.a.e("frames", list);
        this.matteKey = str2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f28673d = this.imageKey;
        builder.f28674e = com.squareup.wire.internal.a.a("frames", this.frames);
        builder.f28675f = this.matteKey;
        builder.b(unknownFields());
        return builder;
    }
}
