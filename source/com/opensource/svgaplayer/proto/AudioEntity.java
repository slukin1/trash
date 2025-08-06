package com.opensource.svgaplayer.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.d;
import java.io.IOException;
import okio.ByteString;

public final class AudioEntity extends Message<AudioEntity, Builder> {
    public static final ProtoAdapter<AudioEntity> ADAPTER = new a();
    public static final String DEFAULT_AUDIOKEY = "";
    public static final Integer DEFAULT_ENDFRAME = 0;
    public static final Integer DEFAULT_STARTFRAME = 0;
    public static final Integer DEFAULT_STARTTIME = 0;
    public static final Integer DEFAULT_TOTALTIME = 0;
    private static final long serialVersionUID = 0;
    public final String audioKey;
    public final Integer endFrame;
    public final Integer startFrame;
    public final Integer startTime;
    public final Integer totalTime;

    public static final class Builder extends Message.a<AudioEntity, Builder> {

        /* renamed from: d  reason: collision with root package name */
        public String f28609d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f28610e;

        /* renamed from: f  reason: collision with root package name */
        public Integer f28611f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f28612g;

        /* renamed from: h  reason: collision with root package name */
        public Integer f28613h;

        public Builder g(String str) {
            this.f28609d = str;
            return this;
        }

        /* renamed from: h */
        public AudioEntity c() {
            return new AudioEntity(this.f28609d, this.f28610e, this.f28611f, this.f28612g, this.f28613h, super.d());
        }

        public Builder i(Integer num) {
            this.f28611f = num;
            return this;
        }

        public Builder j(Integer num) {
            this.f28610e = num;
            return this;
        }

        public Builder k(Integer num) {
            this.f28612g = num;
            return this;
        }

        public Builder l(Integer num) {
            this.f28613h = num;
            return this;
        }
    }

    public static final class a extends ProtoAdapter<AudioEntity> {
        public a() {
            super(FieldEncoding.LENGTH_DELIMITED, AudioEntity.class);
        }

        /* renamed from: r */
        public AudioEntity c(c cVar) throws IOException {
            Builder builder = new Builder();
            long c11 = cVar.c();
            while (true) {
                int f11 = cVar.f();
                if (f11 == -1) {
                    cVar.d(c11);
                    return builder.c();
                } else if (f11 == 1) {
                    builder.g(ProtoAdapter.f30185q.c(cVar));
                } else if (f11 == 2) {
                    builder.j(ProtoAdapter.f30173e.c(cVar));
                } else if (f11 == 3) {
                    builder.i(ProtoAdapter.f30173e.c(cVar));
                } else if (f11 == 4) {
                    builder.k(ProtoAdapter.f30173e.c(cVar));
                } else if (f11 != 5) {
                    FieldEncoding g11 = cVar.g();
                    builder.a(f11, g11, g11.rawProtoAdapter().c(cVar));
                } else {
                    builder.l(ProtoAdapter.f30173e.c(cVar));
                }
            }
        }

        /* renamed from: s */
        public void g(d dVar, AudioEntity audioEntity) throws IOException {
            String str = audioEntity.audioKey;
            if (str != null) {
                ProtoAdapter.f30185q.k(dVar, 1, str);
            }
            Integer num = audioEntity.startFrame;
            if (num != null) {
                ProtoAdapter.f30173e.k(dVar, 2, num);
            }
            Integer num2 = audioEntity.endFrame;
            if (num2 != null) {
                ProtoAdapter.f30173e.k(dVar, 3, num2);
            }
            Integer num3 = audioEntity.startTime;
            if (num3 != null) {
                ProtoAdapter.f30173e.k(dVar, 4, num3);
            }
            Integer num4 = audioEntity.totalTime;
            if (num4 != null) {
                ProtoAdapter.f30173e.k(dVar, 5, num4);
            }
            dVar.k(audioEntity.unknownFields());
        }

        /* renamed from: t */
        public int l(AudioEntity audioEntity) {
            String str = audioEntity.audioKey;
            int i11 = 0;
            int m11 = str != null ? ProtoAdapter.f30185q.m(1, str) : 0;
            Integer num = audioEntity.startFrame;
            int m12 = m11 + (num != null ? ProtoAdapter.f30173e.m(2, num) : 0);
            Integer num2 = audioEntity.endFrame;
            int m13 = m12 + (num2 != null ? ProtoAdapter.f30173e.m(3, num2) : 0);
            Integer num3 = audioEntity.startTime;
            int m14 = m13 + (num3 != null ? ProtoAdapter.f30173e.m(4, num3) : 0);
            Integer num4 = audioEntity.totalTime;
            if (num4 != null) {
                i11 = ProtoAdapter.f30173e.m(5, num4);
            }
            return m14 + i11 + audioEntity.unknownFields().size();
        }
    }

    public AudioEntity(String str, Integer num, Integer num2, Integer num3, Integer num4) {
        this(str, num, num2, num3, num4, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioEntity)) {
            return false;
        }
        AudioEntity audioEntity = (AudioEntity) obj;
        if (!unknownFields().equals(audioEntity.unknownFields()) || !com.squareup.wire.internal.a.d(this.audioKey, audioEntity.audioKey) || !com.squareup.wire.internal.a.d(this.startFrame, audioEntity.startFrame) || !com.squareup.wire.internal.a.d(this.endFrame, audioEntity.endFrame) || !com.squareup.wire.internal.a.d(this.startTime, audioEntity.startTime) || !com.squareup.wire.internal.a.d(this.totalTime, audioEntity.totalTime)) {
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
        String str = this.audioKey;
        int i12 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.startFrame;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.endFrame;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.startTime;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.totalTime;
        if (num4 != null) {
            i12 = num4.hashCode();
        }
        int i13 = hashCode5 + i12;
        this.hashCode = i13;
        return i13;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.audioKey != null) {
            sb2.append(", audioKey=");
            sb2.append(this.audioKey);
        }
        if (this.startFrame != null) {
            sb2.append(", startFrame=");
            sb2.append(this.startFrame);
        }
        if (this.endFrame != null) {
            sb2.append(", endFrame=");
            sb2.append(this.endFrame);
        }
        if (this.startTime != null) {
            sb2.append(", startTime=");
            sb2.append(this.startTime);
        }
        if (this.totalTime != null) {
            sb2.append(", totalTime=");
            sb2.append(this.totalTime);
        }
        StringBuilder replace = sb2.replace(0, 2, "AudioEntity{");
        replace.append('}');
        return replace.toString();
    }

    public AudioEntity(String str, Integer num, Integer num2, Integer num3, Integer num4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.audioKey = str;
        this.startFrame = num;
        this.endFrame = num2;
        this.startTime = num3;
        this.totalTime = num4;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f28609d = this.audioKey;
        builder.f28610e = this.startFrame;
        builder.f28611f = this.endFrame;
        builder.f28612g = this.startTime;
        builder.f28613h = this.totalTime;
        builder.b(unknownFields());
        return builder;
    }
}
