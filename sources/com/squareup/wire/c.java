package com.squareup.wire;

import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSource;
import okio.ByteString;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final BufferedSource f30194a;

    /* renamed from: b  reason: collision with root package name */
    public long f30195b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f30196c = Long.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f30197d;

    /* renamed from: e  reason: collision with root package name */
    public int f30198e = 2;

    /* renamed from: f  reason: collision with root package name */
    public int f30199f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f30200g = -1;

    /* renamed from: h  reason: collision with root package name */
    public FieldEncoding f30201h;

    public c(BufferedSource bufferedSource) {
        this.f30194a = bufferedSource;
    }

    public final void a(int i11) throws IOException {
        if (this.f30198e == i11) {
            this.f30198e = 6;
            return;
        }
        long j11 = this.f30195b;
        long j12 = this.f30196c;
        if (j11 > j12) {
            throw new IOException("Expected to end at " + this.f30196c + " but was " + this.f30195b);
        } else if (j11 == j12) {
            this.f30196c = this.f30200g;
            this.f30200g = -1;
            this.f30198e = 6;
        } else {
            this.f30198e = 7;
        }
    }

    public final long b() throws IOException {
        if (this.f30198e == 2) {
            long j11 = this.f30196c - this.f30195b;
            this.f30194a.require(j11);
            this.f30198e = 6;
            this.f30195b = this.f30196c;
            this.f30196c = this.f30200g;
            this.f30200g = -1;
            return j11;
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f30198e);
    }

    public long c() throws IOException {
        if (this.f30198e == 2) {
            int i11 = this.f30197d + 1;
            this.f30197d = i11;
            if (i11 <= 65) {
                long j11 = this.f30200g;
                this.f30200g = -1;
                this.f30198e = 6;
                return j11;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public void d(long j11) throws IOException {
        if (this.f30198e == 6) {
            int i11 = this.f30197d - 1;
            this.f30197d = i11;
            if (i11 < 0 || this.f30200g != -1) {
                throw new IllegalStateException("No corresponding call to beginMessage()");
            } else if (this.f30195b == this.f30196c || i11 == 0) {
                this.f30196c = j11;
            } else {
                throw new IOException("Expected to end at " + this.f30196c + " but was " + this.f30195b);
            }
        } else {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
    }

    public final int e() throws IOException {
        int i11;
        this.f30194a.require(1);
        this.f30195b++;
        byte readByte = this.f30194a.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        byte b11 = readByte & Ascii.DEL;
        this.f30194a.require(1);
        this.f30195b++;
        byte readByte2 = this.f30194a.readByte();
        if (readByte2 >= 0) {
            i11 = readByte2 << 7;
        } else {
            b11 |= (readByte2 & Ascii.DEL) << 7;
            this.f30194a.require(1);
            this.f30195b++;
            byte readByte3 = this.f30194a.readByte();
            if (readByte3 >= 0) {
                i11 = readByte3 << 14;
            } else {
                b11 |= (readByte3 & Ascii.DEL) << 14;
                this.f30194a.require(1);
                this.f30195b++;
                byte readByte4 = this.f30194a.readByte();
                if (readByte4 >= 0) {
                    i11 = readByte4 << 21;
                } else {
                    byte b12 = b11 | ((readByte4 & Ascii.DEL) << 21);
                    this.f30194a.require(1);
                    this.f30195b++;
                    byte readByte5 = this.f30194a.readByte();
                    byte b13 = b12 | (readByte5 << 28);
                    if (readByte5 >= 0) {
                        return b13;
                    }
                    for (int i12 = 0; i12 < 5; i12++) {
                        this.f30194a.require(1);
                        this.f30195b++;
                        if (this.f30194a.readByte() >= 0) {
                            return b13;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
            }
        }
        return b11 | i11;
    }

    public int f() throws IOException {
        int i11 = this.f30198e;
        if (i11 == 7) {
            this.f30198e = 2;
            return this.f30199f;
        } else if (i11 == 6) {
            while (this.f30195b < this.f30196c && !this.f30194a.exhausted()) {
                int e11 = e();
                if (e11 != 0) {
                    int i12 = e11 >> 3;
                    this.f30199f = i12;
                    int i13 = e11 & 7;
                    if (i13 == 0) {
                        this.f30201h = FieldEncoding.VARINT;
                        this.f30198e = 0;
                        return i12;
                    } else if (i13 == 1) {
                        this.f30201h = FieldEncoding.FIXED64;
                        this.f30198e = 1;
                        return i12;
                    } else if (i13 == 2) {
                        this.f30201h = FieldEncoding.LENGTH_DELIMITED;
                        this.f30198e = 2;
                        int e12 = e();
                        if (e12 < 0) {
                            throw new ProtocolException("Negative length: " + e12);
                        } else if (this.f30200g == -1) {
                            long j11 = this.f30196c;
                            this.f30200g = j11;
                            long j12 = this.f30195b + ((long) e12);
                            this.f30196c = j12;
                            if (j12 <= j11) {
                                return this.f30199f;
                            }
                            throw new EOFException();
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (i13 == 3) {
                        n(i12);
                    } else if (i13 == 4) {
                        throw new ProtocolException("Unexpected end group");
                    } else if (i13 == 5) {
                        this.f30201h = FieldEncoding.FIXED32;
                        this.f30198e = 5;
                        return i12;
                    } else {
                        throw new ProtocolException("Unexpected field encoding: " + i13);
                    }
                } else {
                    throw new ProtocolException("Unexpected tag 0");
                }
            }
            return -1;
        } else {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
    }

    public FieldEncoding g() {
        return this.f30201h;
    }

    public ByteString h() throws IOException {
        long b11 = b();
        this.f30194a.require(b11);
        return this.f30194a.readByteString(b11);
    }

    public int i() throws IOException {
        int i11 = this.f30198e;
        if (i11 == 5 || i11 == 2) {
            this.f30194a.require(4);
            this.f30195b += 4;
            int readIntLe = this.f30194a.readIntLe();
            a(5);
            return readIntLe;
        }
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f30198e);
    }

    public long j() throws IOException {
        int i11 = this.f30198e;
        if (i11 == 1 || i11 == 2) {
            this.f30194a.require(8);
            this.f30195b += 8;
            long readLongLe = this.f30194a.readLongLe();
            a(1);
            return readLongLe;
        }
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f30198e);
    }

    public String k() throws IOException {
        long b11 = b();
        this.f30194a.require(b11);
        return this.f30194a.readUtf8(b11);
    }

    public int l() throws IOException {
        int i11 = this.f30198e;
        if (i11 == 0 || i11 == 2) {
            int e11 = e();
            a(0);
            return e11;
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f30198e);
    }

    public long m() throws IOException {
        int i11 = this.f30198e;
        if (i11 == 0 || i11 == 2) {
            long j11 = 0;
            for (int i12 = 0; i12 < 64; i12 += 7) {
                this.f30194a.require(1);
                this.f30195b++;
                byte readByte = this.f30194a.readByte();
                j11 |= ((long) (readByte & Ascii.DEL)) << i12;
                if ((readByte & 128) == 0) {
                    a(0);
                    return j11;
                }
            }
            throw new ProtocolException("WireInput encountered a malformed varint");
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f30198e);
    }

    public final void n(int i11) throws IOException {
        while (this.f30195b < this.f30196c && !this.f30194a.exhausted()) {
            int e11 = e();
            if (e11 != 0) {
                int i12 = e11 >> 3;
                int i13 = e11 & 7;
                if (i13 == 0) {
                    this.f30198e = 0;
                    m();
                } else if (i13 == 1) {
                    this.f30198e = 1;
                    j();
                } else if (i13 == 2) {
                    long e12 = (long) e();
                    this.f30195b += e12;
                    this.f30194a.skip(e12);
                } else if (i13 == 3) {
                    n(i12);
                } else if (i13 != 4) {
                    if (i13 == 5) {
                        this.f30198e = 5;
                        i();
                    } else {
                        throw new ProtocolException("Unexpected field encoding: " + i13);
                    }
                } else if (i12 != i11) {
                    throw new ProtocolException("Unexpected end group");
                } else {
                    return;
                }
            } else {
                throw new ProtocolException("Unexpected tag 0");
            }
        }
        throw new EOFException();
    }
}
