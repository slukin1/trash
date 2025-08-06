package okio;

import com.huochat.community.util.FileTool;
import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.jvm.internal.r;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public final class HashingSink extends ForwardingSink {
    public static final Companion Companion = new Companion((r) null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final HashingSink hmacSha1(Sink sink, ByteString byteString) {
            return new HashingSink(sink, byteString, "HmacSHA1");
        }

        public final HashingSink hmacSha256(Sink sink, ByteString byteString) {
            return new HashingSink(sink, byteString, "HmacSHA256");
        }

        public final HashingSink hmacSha512(Sink sink, ByteString byteString) {
            return new HashingSink(sink, byteString, "HmacSHA512");
        }

        public final HashingSink md5(Sink sink) {
            return new HashingSink(sink, FileTool.HASH_TYPE_MD5);
        }

        public final HashingSink sha1(Sink sink) {
            return new HashingSink(sink, McElieceCCA2KeyGenParameterSpec.SHA1);
        }

        public final HashingSink sha256(Sink sink) {
            return new HashingSink(sink, "SHA-256");
        }

        public final HashingSink sha512(Sink sink) {
            return new HashingSink(sink, "SHA-512");
        }
    }

    public HashingSink(Sink sink, MessageDigest messageDigest2) {
        super(sink);
        this.messageDigest = messageDigest2;
        this.mac = null;
    }

    public static final HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    public static final HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    public static final HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    public static final HashingSink md5(Sink sink) {
        return Companion.md5(sink);
    }

    public static final HashingSink sha1(Sink sink) {
        return Companion.sha1(sink);
    }

    public static final HashingSink sha256(Sink sink) {
        return Companion.sha256(sink);
    }

    public static final HashingSink sha512(Sink sink) {
        return Companion.sha512(sink);
    }

    /* renamed from: -deprecated_hash  reason: not valid java name */
    public final ByteString m3237deprecated_hash() {
        return hash();
    }

    public final ByteString hash() {
        MessageDigest messageDigest2 = this.messageDigest;
        return new ByteString(messageDigest2 != null ? messageDigest2.digest() : this.mac.doFinal());
    }

    public void write(Buffer buffer, long j11) throws IOException {
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0, j11);
        Segment segment = buffer.head;
        long j12 = 0;
        while (j12 < j11) {
            int min = (int) Math.min(j11 - j12, (long) (segment.limit - segment.pos));
            MessageDigest messageDigest2 = this.messageDigest;
            if (messageDigest2 != null) {
                messageDigest2.update(segment.data, segment.pos, min);
            } else {
                this.mac.update(segment.data, segment.pos, min);
            }
            j12 += (long) min;
            segment = segment.next;
        }
        super.write(buffer, j11);
    }

    public HashingSink(Sink sink, String str) {
        this(sink, MessageDigest.getInstance(str));
    }

    public HashingSink(Sink sink, Mac mac2) {
        super(sink);
        this.mac = mac2;
        this.messageDigest = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HashingSink(okio.Sink r3, okio.ByteString r4, java.lang.String r5) {
        /*
            r2 = this;
            javax.crypto.Mac r0 = javax.crypto.Mac.getInstance(r5)     // Catch:{ InvalidKeyException -> 0x0016 }
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec     // Catch:{ InvalidKeyException -> 0x0016 }
            byte[] r4 = r4.toByteArray()     // Catch:{ InvalidKeyException -> 0x0016 }
            r1.<init>(r4, r5)     // Catch:{ InvalidKeyException -> 0x0016 }
            r0.init(r1)     // Catch:{ InvalidKeyException -> 0x0016 }
            kotlin.Unit r4 = kotlin.Unit.f56620a     // Catch:{ InvalidKeyException -> 0x0016 }
            r2.<init>((okio.Sink) r3, (javax.crypto.Mac) r0)
            return
        L_0x0016:
            r3 = move-exception
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSink.<init>(okio.Sink, okio.ByteString, java.lang.String):void");
    }
}
