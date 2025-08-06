package okio;

import com.huochat.community.util.FileTool;
import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.jvm.internal.r;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public final class HashingSource extends ForwardingSource {
    public static final Companion Companion = new Companion((r) null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final HashingSource hmacSha1(Source source, ByteString byteString) {
            return new HashingSource(source, byteString, "HmacSHA1");
        }

        public final HashingSource hmacSha256(Source source, ByteString byteString) {
            return new HashingSource(source, byteString, "HmacSHA256");
        }

        public final HashingSource hmacSha512(Source source, ByteString byteString) {
            return new HashingSource(source, byteString, "HmacSHA512");
        }

        public final HashingSource md5(Source source) {
            return new HashingSource(source, FileTool.HASH_TYPE_MD5);
        }

        public final HashingSource sha1(Source source) {
            return new HashingSource(source, McElieceCCA2KeyGenParameterSpec.SHA1);
        }

        public final HashingSource sha256(Source source) {
            return new HashingSource(source, "SHA-256");
        }

        public final HashingSource sha512(Source source) {
            return new HashingSource(source, "SHA-512");
        }
    }

    public HashingSource(Source source, MessageDigest messageDigest2) {
        super(source);
        this.messageDigest = messageDigest2;
        this.mac = null;
    }

    public static final HashingSource hmacSha1(Source source, ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    public static final HashingSource hmacSha256(Source source, ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    public static final HashingSource hmacSha512(Source source, ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    public static final HashingSource md5(Source source) {
        return Companion.md5(source);
    }

    public static final HashingSource sha1(Source source) {
        return Companion.sha1(source);
    }

    public static final HashingSource sha256(Source source) {
        return Companion.sha256(source);
    }

    public static final HashingSource sha512(Source source) {
        return Companion.sha512(source);
    }

    /* renamed from: -deprecated_hash  reason: not valid java name */
    public final ByteString m3238deprecated_hash() {
        return hash();
    }

    public final ByteString hash() {
        MessageDigest messageDigest2 = this.messageDigest;
        return new ByteString(messageDigest2 != null ? messageDigest2.digest() : this.mac.doFinal());
    }

    public long read(Buffer buffer, long j11) throws IOException {
        long read = super.read(buffer, j11);
        if (read != -1) {
            long size = buffer.size() - read;
            long size2 = buffer.size();
            Segment segment = buffer.head;
            while (size2 > size) {
                segment = segment.prev;
                size2 -= (long) (segment.limit - segment.pos);
            }
            while (size2 < buffer.size()) {
                int i11 = (int) ((((long) segment.pos) + size) - size2);
                MessageDigest messageDigest2 = this.messageDigest;
                if (messageDigest2 != null) {
                    messageDigest2.update(segment.data, i11, segment.limit - i11);
                } else {
                    this.mac.update(segment.data, i11, segment.limit - i11);
                }
                size2 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                size = size2;
            }
        }
        return read;
    }

    public HashingSource(Source source, String str) {
        this(source, MessageDigest.getInstance(str));
    }

    public HashingSource(Source source, Mac mac2) {
        super(source);
        this.mac = mac2;
        this.messageDigest = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HashingSource(okio.Source r3, okio.ByteString r4, java.lang.String r5) {
        /*
            r2 = this;
            javax.crypto.Mac r0 = javax.crypto.Mac.getInstance(r5)     // Catch:{ InvalidKeyException -> 0x0016 }
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec     // Catch:{ InvalidKeyException -> 0x0016 }
            byte[] r4 = r4.toByteArray()     // Catch:{ InvalidKeyException -> 0x0016 }
            r1.<init>(r4, r5)     // Catch:{ InvalidKeyException -> 0x0016 }
            r0.init(r1)     // Catch:{ InvalidKeyException -> 0x0016 }
            kotlin.Unit r4 = kotlin.Unit.f56620a     // Catch:{ InvalidKeyException -> 0x0016 }
            r2.<init>((okio.Source) r3, (javax.crypto.Mac) r0)
            return
        L_0x0016:
            r3 = move-exception
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSource.<init>(okio.Source, okio.ByteString, java.lang.String):void");
    }
}
