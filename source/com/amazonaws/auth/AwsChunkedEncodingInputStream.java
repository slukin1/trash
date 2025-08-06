package com.amazonaws.auth;

import android.support.v4.media.session.PlaybackStateCompat;
import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.jumio.commons.log.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

public final class AwsChunkedEncodingInputStream extends SdkInputStream {

    /* renamed from: n  reason: collision with root package name */
    public static final byte[] f14822n = new byte[0];

    /* renamed from: o  reason: collision with root package name */
    public static final Log f14823o = LogFactory.b(AwsChunkedEncodingInputStream.class);

    /* renamed from: b  reason: collision with root package name */
    public InputStream f14824b;

    /* renamed from: c  reason: collision with root package name */
    public final int f14825c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f14826d;

    /* renamed from: e  reason: collision with root package name */
    public final String f14827e;

    /* renamed from: f  reason: collision with root package name */
    public final String f14828f;

    /* renamed from: g  reason: collision with root package name */
    public final String f14829g;

    /* renamed from: h  reason: collision with root package name */
    public String f14830h;

    /* renamed from: i  reason: collision with root package name */
    public final AWS4Signer f14831i;

    /* renamed from: j  reason: collision with root package name */
    public ChunkContentIterator f14832j;

    /* renamed from: k  reason: collision with root package name */
    public DecodedStreamBuffer f14833k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f14834l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f14835m;

    public AwsChunkedEncodingInputStream(InputStream inputStream, byte[] bArr, String str, String str2, String str3, AWS4Signer aWS4Signer) {
        this(inputStream, 262144, bArr, str, str2, str3, aWS4Signer);
    }

    public static long g(long j11) {
        return ((long) (Long.toHexString(j11).length() + 17 + 64 + 2)) + j11 + ((long) 2);
    }

    public static long j(long j11) {
        if (j11 >= 0) {
            long j12 = j11 / 131072;
            long j13 = j11 % 131072;
            return (j12 * g(131072)) + (j13 > 0 ? g(j13) : 0) + g(0);
        }
        throw new IllegalArgumentException("Nonnegative content length expected.");
    }

    public InputStream f() {
        return this.f14824b;
    }

    public final byte[] k(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Integer.toHexString(bArr.length));
        String a11 = BinaryUtils.a(this.f14831i.sign("AWS4-HMAC-SHA256-PAYLOAD\n" + this.f14827e + "\n" + this.f14828f + "\n" + this.f14830h + "\n" + BinaryUtils.a(this.f14831i.hash("")) + "\n" + BinaryUtils.a(this.f14831i.hash(bArr)), this.f14826d, SigningAlgorithm.HmacSHA256));
        this.f14830h = a11;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(";chunk-signature=");
        sb3.append(a11);
        sb2.append(sb3.toString());
        sb2.append(LogUtils.NEW_LINE);
        try {
            String sb4 = sb2.toString();
            Charset charset = StringUtils.f15560a;
            byte[] bytes = sb4.getBytes(charset);
            byte[] bytes2 = LogUtils.NEW_LINE.getBytes(charset);
            byte[] bArr2 = new byte[(bytes.length + bArr.length + bytes2.length)];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            System.arraycopy(bytes2, 0, bArr2, bytes.length + bArr.length, bytes2.length);
            return bArr2;
        } catch (Exception e11) {
            throw new AmazonClientException("Unable to sign the chunked data. " + e11.getMessage(), e11);
        }
    }

    public final boolean l() throws IOException {
        byte[] bArr = new byte[131072];
        int i11 = 0;
        while (i11 < 131072) {
            DecodedStreamBuffer decodedStreamBuffer = this.f14833k;
            if (decodedStreamBuffer == null || !decodedStreamBuffer.b()) {
                int read = this.f14824b.read(bArr, i11, 131072 - i11);
                if (read == -1) {
                    break;
                }
                DecodedStreamBuffer decodedStreamBuffer2 = this.f14833k;
                if (decodedStreamBuffer2 != null) {
                    decodedStreamBuffer2.a(bArr, i11, read);
                }
                i11 += read;
            } else {
                bArr[i11] = this.f14833k.c();
                i11++;
            }
        }
        if (i11 == 0) {
            this.f14832j = new ChunkContentIterator(k(f14822n));
            return true;
        }
        if (i11 < 131072) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, 0, bArr2, 0, i11);
            bArr = bArr2;
        }
        this.f14832j = new ChunkContentIterator(k(bArr));
        return false;
    }

    public synchronized void mark(int i11) {
        e();
        if (!this.f14834l) {
            throw new UnsupportedOperationException("Chunk-encoded stream only supports mark() at the start of the stream.");
        } else if (this.f14824b.markSupported()) {
            Log log = f14823o;
            if (log.i()) {
                log.h("AwsChunkedEncodingInputStream marked at the start of the stream (will directly mark the wrapped stream since it's mark-supported).");
            }
            this.f14824b.mark(Integer.MAX_VALUE);
        } else {
            Log log2 = f14823o;
            if (log2.i()) {
                log2.h("AwsChunkedEncodingInputStream marked at the start of the stream (initializing the buffer since the wrapped stream is not mark-supported).");
            }
            this.f14833k = new DecodedStreamBuffer(this.f14825c);
        }
    }

    public boolean markSupported() {
        return true;
    }

    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        if (read == -1) {
            return read;
        }
        Log log = f14823o;
        if (log.i()) {
            log.h("One byte read from the stream.");
        }
        return bArr[0] & 255;
    }

    public synchronized void reset() throws IOException {
        e();
        this.f14832j = null;
        this.f14830h = this.f14829g;
        if (this.f14824b.markSupported()) {
            Log log = f14823o;
            if (log.i()) {
                log.h("AwsChunkedEncodingInputStream reset (will reset the wrapped stream because it is mark-supported).");
            }
            this.f14824b.reset();
        } else {
            Log log2 = f14823o;
            if (log2.i()) {
                log2.h("AwsChunkedEncodingInputStream reset (will use the buffer of the decoded stream).");
            }
            DecodedStreamBuffer decodedStreamBuffer = this.f14833k;
            if (decodedStreamBuffer != null) {
                decodedStreamBuffer.d();
            } else {
                throw new IOException("Cannot reset the stream because the mark is not set.");
            }
        }
        this.f14832j = null;
        this.f14834l = true;
        this.f14835m = false;
    }

    public long skip(long j11) throws IOException {
        int read;
        if (j11 <= 0) {
            return 0;
        }
        int min = (int) Math.min(PlaybackStateCompat.ACTION_SET_REPEAT_MODE, j11);
        byte[] bArr = new byte[min];
        long j12 = j11;
        while (j12 > 0 && (read = read(bArr, 0, min)) >= 0) {
            j12 -= (long) read;
        }
        return j11 - j12;
    }

    public AwsChunkedEncodingInputStream(InputStream inputStream, int i11, byte[] bArr, String str, String str2, String str3, AWS4Signer aWS4Signer) {
        this.f14824b = null;
        this.f14834l = true;
        this.f14835m = false;
        if (inputStream instanceof AwsChunkedEncodingInputStream) {
            AwsChunkedEncodingInputStream awsChunkedEncodingInputStream = (AwsChunkedEncodingInputStream) inputStream;
            i11 = Math.max(awsChunkedEncodingInputStream.f14825c, i11);
            this.f14824b = awsChunkedEncodingInputStream.f14824b;
            this.f14833k = awsChunkedEncodingInputStream.f14833k;
        } else {
            this.f14824b = inputStream;
            this.f14833k = null;
        }
        if (i11 >= 131072) {
            this.f14825c = i11;
            this.f14826d = bArr;
            this.f14827e = str;
            this.f14828f = str2;
            this.f14829g = str3;
            this.f14830h = str3;
            this.f14831i = aWS4Signer;
            return;
        }
        throw new IllegalArgumentException("Max buffer size should not be less than chunk size");
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        e();
        Objects.requireNonNull(bArr);
        if (i11 < 0 || i12 < 0 || i12 > bArr.length - i11) {
            throw new IndexOutOfBoundsException();
        } else if (i12 == 0) {
            return 0;
        } else {
            ChunkContentIterator chunkContentIterator = this.f14832j;
            if (chunkContentIterator == null || !chunkContentIterator.a()) {
                if (this.f14835m) {
                    return -1;
                }
                this.f14835m = l();
            }
            int b11 = this.f14832j.b(bArr, i11, i12);
            if (b11 > 0) {
                this.f14834l = false;
                Log log = f14823o;
                if (log.i()) {
                    log.h(b11 + " byte read from the stream.");
                }
            }
            return b11;
        }
    }
}
