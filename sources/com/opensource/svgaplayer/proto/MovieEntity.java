package com.opensource.svgaplayer.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.d;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

public final class MovieEntity extends Message<MovieEntity, Builder> {
    public static final ProtoAdapter<MovieEntity> ADAPTER = new a();
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    public final List<AudioEntity> audios;
    public final Map<String, ByteString> images;
    public final MovieParams params;
    public final List<SpriteEntity> sprites;
    public final String version;

    public static final class Builder extends Message.a<MovieEntity, Builder> {

        /* renamed from: d  reason: collision with root package name */
        public String f28625d;

        /* renamed from: e  reason: collision with root package name */
        public MovieParams f28626e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, ByteString> f28627f = com.squareup.wire.internal.a.h();

        /* renamed from: g  reason: collision with root package name */
        public List<SpriteEntity> f28628g = com.squareup.wire.internal.a.g();

        /* renamed from: h  reason: collision with root package name */
        public List<AudioEntity> f28629h = com.squareup.wire.internal.a.g();

        /* renamed from: g */
        public MovieEntity c() {
            return new MovieEntity(this.f28625d, this.f28626e, this.f28627f, this.f28628g, this.f28629h, super.d());
        }

        public Builder h(MovieParams movieParams) {
            this.f28626e = movieParams;
            return this;
        }

        public Builder i(String str) {
            this.f28625d = str;
            return this;
        }
    }

    public static final class a extends ProtoAdapter<MovieEntity> {

        /* renamed from: s  reason: collision with root package name */
        public final ProtoAdapter<Map<String, ByteString>> f28630s = ProtoAdapter.p(ProtoAdapter.f30185q, ProtoAdapter.f30186r);

        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, MovieEntity.class);
        }

        /* renamed from: r */
        public MovieEntity c(c cVar) throws IOException {
            Builder builder = new Builder();
            long c11 = cVar.c();
            while (true) {
                int f11 = cVar.f();
                if (f11 == -1) {
                    cVar.d(c11);
                    return builder.c();
                } else if (f11 == 1) {
                    builder.i(ProtoAdapter.f30185q.c(cVar));
                } else if (f11 == 2) {
                    builder.h(MovieParams.ADAPTER.c(cVar));
                } else if (f11 == 3) {
                    builder.f28627f.putAll(this.f28630s.c(cVar));
                } else if (f11 == 4) {
                    builder.f28628g.add(SpriteEntity.ADAPTER.c(cVar));
                } else if (f11 != 5) {
                    FieldEncoding g11 = cVar.g();
                    builder.a(f11, g11, g11.rawProtoAdapter().c(cVar));
                } else {
                    builder.f28629h.add(AudioEntity.ADAPTER.c(cVar));
                }
            }
        }

        /* renamed from: s */
        public void g(d dVar, MovieEntity movieEntity) throws IOException {
            String str = movieEntity.version;
            if (str != null) {
                ProtoAdapter.f30185q.k(dVar, 1, str);
            }
            MovieParams movieParams = movieEntity.params;
            if (movieParams != null) {
                MovieParams.ADAPTER.k(dVar, 2, movieParams);
            }
            this.f28630s.k(dVar, 3, movieEntity.images);
            SpriteEntity.ADAPTER.a().k(dVar, 4, movieEntity.sprites);
            AudioEntity.ADAPTER.a().k(dVar, 5, movieEntity.audios);
            dVar.k(movieEntity.unknownFields());
        }

        /* renamed from: t */
        public int l(MovieEntity movieEntity) {
            String str = movieEntity.version;
            int i11 = 0;
            int m11 = str != null ? ProtoAdapter.f30185q.m(1, str) : 0;
            MovieParams movieParams = movieEntity.params;
            if (movieParams != null) {
                i11 = MovieParams.ADAPTER.m(2, movieParams);
            }
            return m11 + i11 + this.f28630s.m(3, movieEntity.images) + SpriteEntity.ADAPTER.a().m(4, movieEntity.sprites) + AudioEntity.ADAPTER.a().m(5, movieEntity.audios) + movieEntity.unknownFields().size();
        }
    }

    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2) {
        this(str, movieParams, map, list, list2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MovieEntity)) {
            return false;
        }
        MovieEntity movieEntity = (MovieEntity) obj;
        if (!unknownFields().equals(movieEntity.unknownFields()) || !com.squareup.wire.internal.a.d(this.version, movieEntity.version) || !com.squareup.wire.internal.a.d(this.params, movieEntity.params) || !this.images.equals(movieEntity.images) || !this.sprites.equals(movieEntity.sprites) || !this.audios.equals(movieEntity.audios)) {
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
        String str = this.version;
        int i12 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        MovieParams movieParams = this.params;
        if (movieParams != null) {
            i12 = movieParams.hashCode();
        }
        int hashCode3 = ((((((hashCode2 + i12) * 37) + this.images.hashCode()) * 37) + this.sprites.hashCode()) * 37) + this.audios.hashCode();
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.version != null) {
            sb2.append(", version=");
            sb2.append(this.version);
        }
        if (this.params != null) {
            sb2.append(", params=");
            sb2.append(this.params);
        }
        if (!this.images.isEmpty()) {
            sb2.append(", images=");
            sb2.append(this.images);
        }
        if (!this.sprites.isEmpty()) {
            sb2.append(", sprites=");
            sb2.append(this.sprites);
        }
        if (!this.audios.isEmpty()) {
            sb2.append(", audios=");
            sb2.append(this.audios);
        }
        StringBuilder replace = sb2.replace(0, 2, "MovieEntity{");
        replace.append('}');
        return replace.toString();
    }

    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.version = str;
        this.params = movieParams;
        this.images = com.squareup.wire.internal.a.f("images", map);
        this.sprites = com.squareup.wire.internal.a.e("sprites", list);
        this.audios = com.squareup.wire.internal.a.e("audios", list2);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f28625d = this.version;
        builder.f28626e = this.params;
        builder.f28627f = com.squareup.wire.internal.a.b("images", this.images);
        builder.f28628g = com.squareup.wire.internal.a.a("sprites", this.sprites);
        builder.f28629h = com.squareup.wire.internal.a.a("audios", this.audios);
        builder.b(unknownFields());
        return builder;
    }
}
