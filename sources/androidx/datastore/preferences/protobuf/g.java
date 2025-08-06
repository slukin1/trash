package androidx.datastore.preferences.protobuf;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public int f9110a;

    /* renamed from: b  reason: collision with root package name */
    public int f9111b;

    /* renamed from: c  reason: collision with root package name */
    public int f9112c;

    /* renamed from: d  reason: collision with root package name */
    public h f9113d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9114e;

    public static final class b extends g {

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f9115f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f9116g;

        /* renamed from: h  reason: collision with root package name */
        public int f9117h;

        /* renamed from: i  reason: collision with root package name */
        public int f9118i;

        /* renamed from: j  reason: collision with root package name */
        public int f9119j;

        /* renamed from: k  reason: collision with root package name */
        public int f9120k;

        /* renamed from: l  reason: collision with root package name */
        public int f9121l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f9122m;

        /* renamed from: n  reason: collision with root package name */
        public int f9123n;

        public String A() throws IOException {
            int K = K();
            if (K > 0) {
                int i11 = this.f9117h;
                int i12 = this.f9119j;
                if (K <= i11 - i12) {
                    String str = new String(this.f9115f, i12, K, u.f9213a);
                    this.f9119j += K;
                    return str;
                }
            }
            if (K == 0) {
                return "";
            }
            if (K < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public String B() throws IOException {
            int K = K();
            if (K > 0) {
                int i11 = this.f9117h;
                int i12 = this.f9119j;
                if (K <= i11 - i12) {
                    String h11 = Utf8.h(this.f9115f, i12, K);
                    this.f9119j += K;
                    return h11;
                }
            }
            if (K == 0) {
                return "";
            }
            if (K <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public int C() throws IOException {
            if (e()) {
                this.f9121l = 0;
                return 0;
            }
            int K = K();
            this.f9121l = K;
            if (WireFormat.a(K) != 0) {
                return this.f9121l;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int D() throws IOException {
            return K();
        }

        public long E() throws IOException {
            return L();
        }

        public boolean F(int i11) throws IOException {
            int b11 = WireFormat.b(i11);
            if (b11 == 0) {
                Q();
                return true;
            } else if (b11 == 1) {
                P(8);
                return true;
            } else if (b11 == 2) {
                P(K());
                return true;
            } else if (b11 == 3) {
                O();
                a(WireFormat.c(WireFormat.a(i11), 4));
                return true;
            } else if (b11 == 4) {
                return false;
            } else {
                if (b11 == 5) {
                    P(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public byte G() throws IOException {
            int i11 = this.f9119j;
            if (i11 != this.f9117h) {
                byte[] bArr = this.f9115f;
                this.f9119j = i11 + 1;
                return bArr[i11];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte[] H(int i11) throws IOException {
            if (i11 > 0) {
                int i12 = this.f9117h;
                int i13 = this.f9119j;
                if (i11 <= i12 - i13) {
                    int i14 = i11 + i13;
                    this.f9119j = i14;
                    return Arrays.copyOfRange(this.f9115f, i13, i14);
                }
            }
            if (i11 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i11 == 0) {
                return u.f9215c;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public int I() throws IOException {
            int i11 = this.f9119j;
            if (this.f9117h - i11 >= 4) {
                byte[] bArr = this.f9115f;
                this.f9119j = i11 + 4;
                return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long J() throws IOException {
            int i11 = this.f9119j;
            if (this.f9117h - i11 >= 8) {
                byte[] bArr = this.f9115f;
                this.f9119j = i11 + 8;
                return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int K() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f9119j
                int r1 = r5.f9117h
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.f9115f
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.f9119j = r3
                return r0
            L_0x0012:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x0018
                goto L_0x006a
            L_0x0018:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0024
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0070
            L_0x0024:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0031
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002f:
                r1 = r3
                goto L_0x0070
            L_0x0031:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x003f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0070
            L_0x003f:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r2 = r2[r3]
                if (r2 >= 0) goto L_0x0070
            L_0x006a:
                long r0 = r5.M()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.f9119j = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.g.b.K():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long L() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.f9119j
                int r1 = r11.f9117h
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.f9115f
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.f9119j = r3
                long r0 = (long) r0
                return r0
            L_0x0014:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x001b
                goto L_0x00b6
            L_0x001b:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0029
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            L_0x0026:
                long r2 = (long) r0
                goto L_0x00bd
            L_0x0029:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003a
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto L_0x00bd
            L_0x003a:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0048
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0026
            L_0x0048:
                long r3 = (long) r0
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x005f
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L_0x005b:
                long r2 = r3 ^ r1
                r1 = r0
                goto L_0x00bd
            L_0x005f:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0074
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L_0x0071:
                long r2 = r3 ^ r5
                goto L_0x00bd
            L_0x0074:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x0087
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L_0x005b
            L_0x0087:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x009a
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L_0x0071
            L_0x009a:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x00bb
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x00bc
            L_0x00b6:
                long r0 = r11.M()
                return r0
            L_0x00bb:
                r1 = r0
            L_0x00bc:
                r2 = r3
            L_0x00bd:
                r11.f9119j = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.g.b.L():long");
        }

        public long M() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte G = G();
                j11 |= ((long) (G & Ascii.DEL)) << i11;
                if ((G & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void N() {
            int i11 = this.f9117h + this.f9118i;
            this.f9117h = i11;
            int i12 = i11 - this.f9120k;
            int i13 = this.f9123n;
            if (i12 > i13) {
                int i14 = i12 - i13;
                this.f9118i = i14;
                this.f9117h = i11 - i14;
                return;
            }
            this.f9118i = 0;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void O() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.C()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.F(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.g.b.O():void");
        }

        public void P(int i11) throws IOException {
            if (i11 >= 0) {
                int i12 = this.f9117h;
                int i13 = this.f9119j;
                if (i11 <= i12 - i13) {
                    this.f9119j = i13 + i11;
                    return;
                }
            }
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final void Q() throws IOException {
            if (this.f9117h - this.f9119j >= 10) {
                R();
            } else {
                S();
            }
        }

        public final void R() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                byte[] bArr = this.f9115f;
                int i12 = this.f9119j;
                this.f9119j = i12 + 1;
                if (bArr[i12] < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void S() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                if (G() < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public void a(int i11) throws InvalidProtocolBufferException {
            if (this.f9121l != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public int d() {
            return this.f9119j - this.f9120k;
        }

        public boolean e() throws IOException {
            return this.f9119j == this.f9117h;
        }

        public void l(int i11) {
            this.f9123n = i11;
            N();
        }

        public int m(int i11) throws InvalidProtocolBufferException {
            if (i11 >= 0) {
                int d11 = i11 + d();
                int i12 = this.f9123n;
                if (d11 <= i12) {
                    this.f9123n = d11;
                    N();
                    return i12;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean n() throws IOException {
            return L() != 0;
        }

        public ByteString o() throws IOException {
            ByteString byteString;
            int K = K();
            if (K > 0) {
                int i11 = this.f9117h;
                int i12 = this.f9119j;
                if (K <= i11 - i12) {
                    if (!this.f9116g || !this.f9122m) {
                        byteString = ByteString.copyFrom(this.f9115f, i12, K);
                    } else {
                        byteString = ByteString.wrap(this.f9115f, i12, K);
                    }
                    this.f9119j += K;
                    return byteString;
                }
            }
            if (K == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.wrap(H(K));
        }

        public double p() throws IOException {
            return Double.longBitsToDouble(J());
        }

        public int q() throws IOException {
            return K();
        }

        public int r() throws IOException {
            return I();
        }

        public long s() throws IOException {
            return J();
        }

        public float t() throws IOException {
            return Float.intBitsToFloat(I());
        }

        public int u() throws IOException {
            return K();
        }

        public long v() throws IOException {
            return L();
        }

        public int w() throws IOException {
            return I();
        }

        public long x() throws IOException {
            return J();
        }

        public int y() throws IOException {
            return g.b(K());
        }

        public long z() throws IOException {
            return g.c(L());
        }

        public b(byte[] bArr, int i11, int i12, boolean z11) {
            super();
            this.f9123n = Integer.MAX_VALUE;
            this.f9115f = bArr;
            this.f9117h = i12 + i11;
            this.f9119j = i11;
            this.f9120k = i11;
            this.f9116g = z11;
        }
    }

    public static final class c extends g {

        /* renamed from: f  reason: collision with root package name */
        public final InputStream f9124f;

        /* renamed from: g  reason: collision with root package name */
        public final byte[] f9125g;

        /* renamed from: h  reason: collision with root package name */
        public int f9126h;

        /* renamed from: i  reason: collision with root package name */
        public int f9127i;

        /* renamed from: j  reason: collision with root package name */
        public int f9128j;

        /* renamed from: k  reason: collision with root package name */
        public int f9129k;

        /* renamed from: l  reason: collision with root package name */
        public int f9130l;

        /* renamed from: m  reason: collision with root package name */
        public int f9131m;

        /* renamed from: n  reason: collision with root package name */
        public a f9132n;

        public interface a {
            void onRefill();
        }

        public String A() throws IOException {
            int N = N();
            if (N > 0) {
                int i11 = this.f9126h;
                int i12 = this.f9128j;
                if (N <= i11 - i12) {
                    String str = new String(this.f9125g, i12, N, u.f9213a);
                    this.f9128j += N;
                    return str;
                }
            }
            if (N == 0) {
                return "";
            }
            if (N > this.f9126h) {
                return new String(I(N, false), u.f9213a);
            }
            R(N);
            String str2 = new String(this.f9125g, this.f9128j, N, u.f9213a);
            this.f9128j += N;
            return str2;
        }

        public String B() throws IOException {
            byte[] bArr;
            int N = N();
            int i11 = this.f9128j;
            int i12 = this.f9126h;
            if (N <= i12 - i11 && N > 0) {
                bArr = this.f9125g;
                this.f9128j = i11 + N;
            } else if (N == 0) {
                return "";
            } else {
                if (N <= i12) {
                    R(N);
                    bArr = this.f9125g;
                    this.f9128j = N + 0;
                } else {
                    bArr = I(N, false);
                }
                i11 = 0;
            }
            return Utf8.h(bArr, i11, N);
        }

        public int C() throws IOException {
            if (e()) {
                this.f9129k = 0;
                return 0;
            }
            int N = N();
            this.f9129k = N;
            if (WireFormat.a(N) != 0) {
                return this.f9129k;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int D() throws IOException {
            return N();
        }

        public long E() throws IOException {
            return O();
        }

        public boolean F(int i11) throws IOException {
            int b11 = WireFormat.b(i11);
            if (b11 == 0) {
                V();
                return true;
            } else if (b11 == 1) {
                T(8);
                return true;
            } else if (b11 == 2) {
                T(N());
                return true;
            } else if (b11 == 3) {
                S();
                a(WireFormat.c(WireFormat.a(i11), 4));
                return true;
            } else if (b11 == 4) {
                return false;
            } else {
                if (b11 == 5) {
                    T(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final ByteString G(int i11) throws IOException {
            byte[] J = J(i11);
            if (J != null) {
                return ByteString.copyFrom(J);
            }
            int i12 = this.f9128j;
            int i13 = this.f9126h;
            int i14 = i13 - i12;
            this.f9130l += i13;
            this.f9128j = 0;
            this.f9126h = 0;
            List<byte[]> K = K(i11 - i14);
            byte[] bArr = new byte[i11];
            System.arraycopy(this.f9125g, i12, bArr, 0, i14);
            for (byte[] next : K) {
                System.arraycopy(next, 0, bArr, i14, next.length);
                i14 += next.length;
            }
            return ByteString.wrap(bArr);
        }

        public byte H() throws IOException {
            if (this.f9128j == this.f9126h) {
                R(1);
            }
            byte[] bArr = this.f9125g;
            int i11 = this.f9128j;
            this.f9128j = i11 + 1;
            return bArr[i11];
        }

        public final byte[] I(int i11, boolean z11) throws IOException {
            byte[] J = J(i11);
            if (J != null) {
                return z11 ? (byte[]) J.clone() : J;
            }
            int i12 = this.f9128j;
            int i13 = this.f9126h;
            int i14 = i13 - i12;
            this.f9130l += i13;
            this.f9128j = 0;
            this.f9126h = 0;
            List<byte[]> K = K(i11 - i14);
            byte[] bArr = new byte[i11];
            System.arraycopy(this.f9125g, i12, bArr, 0, i14);
            for (byte[] next : K) {
                System.arraycopy(next, 0, bArr, i14, next.length);
                i14 += next.length;
            }
            return bArr;
        }

        public final byte[] J(int i11) throws IOException {
            if (i11 == 0) {
                return u.f9215c;
            }
            if (i11 >= 0) {
                int i12 = this.f9130l;
                int i13 = this.f9128j;
                int i14 = i12 + i13 + i11;
                if (i14 - this.f9112c <= 0) {
                    int i15 = this.f9131m;
                    if (i14 <= i15) {
                        int i16 = this.f9126h - i13;
                        int i17 = i11 - i16;
                        if (i17 >= 4096 && i17 > this.f9124f.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i11];
                        System.arraycopy(this.f9125g, this.f9128j, bArr, 0, i16);
                        this.f9130l += this.f9126h;
                        this.f9128j = 0;
                        this.f9126h = 0;
                        while (i16 < i11) {
                            int read = this.f9124f.read(bArr, i16, i11 - i16);
                            if (read != -1) {
                                this.f9130l += read;
                                i16 += read;
                            } else {
                                throw InvalidProtocolBufferException.truncatedMessage();
                            }
                        }
                        return bArr;
                    }
                    T((i15 - i12) - i13);
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public final List<byte[]> K(int i11) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i11 > 0) {
                int min = Math.min(i11, 4096);
                byte[] bArr = new byte[min];
                int i12 = 0;
                while (i12 < min) {
                    int read = this.f9124f.read(bArr, i12, min - i12);
                    if (read != -1) {
                        this.f9130l += read;
                        i12 += read;
                    } else {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                }
                i11 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int L() throws IOException {
            int i11 = this.f9128j;
            if (this.f9126h - i11 < 4) {
                R(4);
                i11 = this.f9128j;
            }
            byte[] bArr = this.f9125g;
            this.f9128j = i11 + 4;
            return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
        }

        public long M() throws IOException {
            int i11 = this.f9128j;
            if (this.f9126h - i11 < 8) {
                R(8);
                i11 = this.f9128j;
            }
            byte[] bArr = this.f9125g;
            this.f9128j = i11 + 8;
            return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int N() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f9128j
                int r1 = r5.f9126h
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.f9125g
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.f9128j = r3
                return r0
            L_0x0012:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x0018
                goto L_0x006a
            L_0x0018:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0024
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0070
            L_0x0024:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0031
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002f:
                r1 = r3
                goto L_0x0070
            L_0x0031:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x003f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0070
            L_0x003f:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r2 = r2[r3]
                if (r2 >= 0) goto L_0x0070
            L_0x006a:
                long r0 = r5.P()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.f9128j = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.g.c.N():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long O() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.f9128j
                int r1 = r11.f9126h
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.f9125g
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.f9128j = r3
                long r0 = (long) r0
                return r0
            L_0x0014:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x001b
                goto L_0x00b6
            L_0x001b:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0029
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            L_0x0026:
                long r2 = (long) r0
                goto L_0x00bd
            L_0x0029:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003a
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto L_0x00bd
            L_0x003a:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0048
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0026
            L_0x0048:
                long r3 = (long) r0
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x005f
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L_0x005b:
                long r2 = r3 ^ r1
                r1 = r0
                goto L_0x00bd
            L_0x005f:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0074
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L_0x0071:
                long r2 = r3 ^ r5
                goto L_0x00bd
            L_0x0074:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x0087
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L_0x005b
            L_0x0087:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x009a
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L_0x0071
            L_0x009a:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x00bb
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x00bc
            L_0x00b6:
                long r0 = r11.P()
                return r0
            L_0x00bb:
                r1 = r0
            L_0x00bc:
                r2 = r3
            L_0x00bd:
                r11.f9128j = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.g.c.O():long");
        }

        public long P() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte H = H();
                j11 |= ((long) (H & Ascii.DEL)) << i11;
                if ((H & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void Q() {
            int i11 = this.f9126h + this.f9127i;
            this.f9126h = i11;
            int i12 = this.f9130l + i11;
            int i13 = this.f9131m;
            if (i12 > i13) {
                int i14 = i12 - i13;
                this.f9127i = i14;
                this.f9126h = i11 - i14;
                return;
            }
            this.f9127i = 0;
        }

        public final void R(int i11) throws IOException {
            if (Y(i11)) {
                return;
            }
            if (i11 > (this.f9112c - this.f9130l) - this.f9128j) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void S() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.C()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.F(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.g.c.S():void");
        }

        public void T(int i11) throws IOException {
            int i12 = this.f9126h;
            int i13 = this.f9128j;
            if (i11 > i12 - i13 || i11 < 0) {
                U(i11);
            } else {
                this.f9128j = i13 + i11;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
            throw new java.lang.IllegalStateException(r8.f9124f.getClass() + "#skip returned invalid result: " + r0 + "\nThe InputStream implementation is buggy.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void U(int r9) throws java.io.IOException {
            /*
                r8 = this;
                if (r9 < 0) goto L_0x0097
                int r0 = r8.f9130l
                int r1 = r8.f9128j
                int r2 = r0 + r1
                int r2 = r2 + r9
                int r3 = r8.f9131m
                if (r2 > r3) goto L_0x008d
                androidx.datastore.preferences.protobuf.g$c$a r2 = r8.f9132n
                r3 = 0
                if (r2 != 0) goto L_0x006f
                int r0 = r0 + r1
                r8.f9130l = r0
                int r0 = r8.f9126h
                int r0 = r0 - r1
                r8.f9126h = r3
                r8.f9128j = r3
                r3 = r0
            L_0x001d:
                if (r3 >= r9) goto L_0x0067
                int r0 = r9 - r3
                java.io.InputStream r1 = r8.f9124f     // Catch:{ all -> 0x005d }
                long r4 = (long) r0     // Catch:{ all -> 0x005d }
                long r0 = r1.skip(r4)     // Catch:{ all -> 0x005d }
                r6 = 0
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 < 0) goto L_0x0038
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 > 0) goto L_0x0038
                if (r2 != 0) goto L_0x0035
                goto L_0x0067
            L_0x0035:
                int r0 = (int) r0     // Catch:{ all -> 0x005d }
                int r3 = r3 + r0
                goto L_0x001d
            L_0x0038:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
                r2.<init>()     // Catch:{ all -> 0x005d }
                java.io.InputStream r4 = r8.f9124f     // Catch:{ all -> 0x005d }
                java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x005d }
                r2.append(r4)     // Catch:{ all -> 0x005d }
                java.lang.String r4 = "#skip returned invalid result: "
                r2.append(r4)     // Catch:{ all -> 0x005d }
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = "\nThe InputStream implementation is buggy."
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x005d }
                r9.<init>(r0)     // Catch:{ all -> 0x005d }
                throw r9     // Catch:{ all -> 0x005d }
            L_0x005d:
                r9 = move-exception
                int r0 = r8.f9130l
                int r0 = r0 + r3
                r8.f9130l = r0
                r8.Q()
                throw r9
            L_0x0067:
                int r0 = r8.f9130l
                int r0 = r0 + r3
                r8.f9130l = r0
                r8.Q()
            L_0x006f:
                if (r3 >= r9) goto L_0x008c
                int r0 = r8.f9126h
                int r1 = r8.f9128j
                int r1 = r0 - r1
                r8.f9128j = r0
                r0 = 1
                r8.R(r0)
            L_0x007d:
                int r2 = r9 - r1
                int r3 = r8.f9126h
                if (r2 <= r3) goto L_0x008a
                int r1 = r1 + r3
                r8.f9128j = r3
                r8.R(r0)
                goto L_0x007d
            L_0x008a:
                r8.f9128j = r2
            L_0x008c:
                return
            L_0x008d:
                int r3 = r3 - r0
                int r3 = r3 - r1
                r8.T(r3)
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r9 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
                throw r9
            L_0x0097:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r9 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.g.c.U(int):void");
        }

        public final void V() throws IOException {
            if (this.f9126h - this.f9128j >= 10) {
                W();
            } else {
                X();
            }
        }

        public final void W() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                byte[] bArr = this.f9125g;
                int i12 = this.f9128j;
                this.f9128j = i12 + 1;
                if (bArr[i12] < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void X() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                if (H() < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final boolean Y(int i11) throws IOException {
            int i12 = this.f9128j;
            if (i12 + i11 > this.f9126h) {
                int i13 = this.f9112c;
                int i14 = this.f9130l;
                if (i11 > (i13 - i14) - i12 || i14 + i12 + i11 > this.f9131m) {
                    return false;
                }
                a aVar = this.f9132n;
                if (aVar != null) {
                    aVar.onRefill();
                }
                int i15 = this.f9128j;
                if (i15 > 0) {
                    int i16 = this.f9126h;
                    if (i16 > i15) {
                        byte[] bArr = this.f9125g;
                        System.arraycopy(bArr, i15, bArr, 0, i16 - i15);
                    }
                    this.f9130l += i15;
                    this.f9126h -= i15;
                    this.f9128j = 0;
                }
                InputStream inputStream = this.f9124f;
                byte[] bArr2 = this.f9125g;
                int i17 = this.f9126h;
                int read = inputStream.read(bArr2, i17, Math.min(bArr2.length - i17, (this.f9112c - this.f9130l) - i17));
                if (read == 0 || read < -1 || read > this.f9125g.length) {
                    throw new IllegalStateException(this.f9124f.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.f9126h += read;
                    Q();
                    if (this.f9126h >= i11) {
                        return true;
                    }
                    return Y(i11);
                }
            } else {
                throw new IllegalStateException("refillBuffer() called when " + i11 + " bytes were already available in buffer");
            }
        }

        public void a(int i11) throws InvalidProtocolBufferException {
            if (this.f9129k != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public int d() {
            return this.f9130l + this.f9128j;
        }

        public boolean e() throws IOException {
            return this.f9128j == this.f9126h && !Y(1);
        }

        public void l(int i11) {
            this.f9131m = i11;
            Q();
        }

        public int m(int i11) throws InvalidProtocolBufferException {
            if (i11 >= 0) {
                int i12 = i11 + this.f9130l + this.f9128j;
                int i13 = this.f9131m;
                if (i12 <= i13) {
                    this.f9131m = i12;
                    Q();
                    return i13;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean n() throws IOException {
            return O() != 0;
        }

        public ByteString o() throws IOException {
            int N = N();
            int i11 = this.f9126h;
            int i12 = this.f9128j;
            if (N <= i11 - i12 && N > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.f9125g, i12, N);
                this.f9128j += N;
                return copyFrom;
            } else if (N == 0) {
                return ByteString.EMPTY;
            } else {
                return G(N);
            }
        }

        public double p() throws IOException {
            return Double.longBitsToDouble(M());
        }

        public int q() throws IOException {
            return N();
        }

        public int r() throws IOException {
            return L();
        }

        public long s() throws IOException {
            return M();
        }

        public float t() throws IOException {
            return Float.intBitsToFloat(L());
        }

        public int u() throws IOException {
            return N();
        }

        public long v() throws IOException {
            return O();
        }

        public int w() throws IOException {
            return L();
        }

        public long x() throws IOException {
            return M();
        }

        public int y() throws IOException {
            return g.b(N());
        }

        public long z() throws IOException {
            return g.c(O());
        }

        public c(InputStream inputStream, int i11) {
            super();
            this.f9131m = Integer.MAX_VALUE;
            this.f9132n = null;
            u.b(inputStream, "input");
            this.f9124f = inputStream;
            this.f9125g = new byte[i11];
            this.f9126h = 0;
            this.f9128j = 0;
            this.f9130l = 0;
        }
    }

    public static final class d extends g {

        /* renamed from: f  reason: collision with root package name */
        public final ByteBuffer f9133f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f9134g;

        /* renamed from: h  reason: collision with root package name */
        public final long f9135h;

        /* renamed from: i  reason: collision with root package name */
        public long f9136i;

        /* renamed from: j  reason: collision with root package name */
        public long f9137j;

        /* renamed from: k  reason: collision with root package name */
        public long f9138k;

        /* renamed from: l  reason: collision with root package name */
        public int f9139l;

        /* renamed from: m  reason: collision with root package name */
        public int f9140m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f9141n;

        /* renamed from: o  reason: collision with root package name */
        public int f9142o;

        public static boolean H() {
            return c1.H();
        }

        public String A() throws IOException {
            int L = L();
            if (L > 0 && L <= P()) {
                byte[] bArr = new byte[L];
                long j11 = (long) L;
                c1.n(this.f9137j, bArr, 0, j11);
                String str = new String(bArr, u.f9213a);
                this.f9137j += j11;
                return str;
            } else if (L == 0) {
                return "";
            } else {
                if (L < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public String B() throws IOException {
            int L = L();
            if (L > 0 && L <= P()) {
                String g11 = Utf8.g(this.f9133f, G(this.f9137j), L);
                this.f9137j += (long) L;
                return g11;
            } else if (L == 0) {
                return "";
            } else {
                if (L <= 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public int C() throws IOException {
            if (e()) {
                this.f9140m = 0;
                return 0;
            }
            int L = L();
            this.f9140m = L;
            if (WireFormat.a(L) != 0) {
                return this.f9140m;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int D() throws IOException {
            return L();
        }

        public long E() throws IOException {
            return M();
        }

        public boolean F(int i11) throws IOException {
            int b11 = WireFormat.b(i11);
            if (b11 == 0) {
                S();
                return true;
            } else if (b11 == 1) {
                R(8);
                return true;
            } else if (b11 == 2) {
                R(L());
                return true;
            } else if (b11 == 3) {
                Q();
                a(WireFormat.c(WireFormat.a(i11), 4));
                return true;
            } else if (b11 == 4) {
                return false;
            } else {
                if (b11 == 5) {
                    R(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final int G(long j11) {
            return (int) (j11 - this.f9135h);
        }

        public byte I() throws IOException {
            long j11 = this.f9137j;
            if (j11 != this.f9136i) {
                this.f9137j = 1 + j11;
                return c1.u(j11);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public int J() throws IOException {
            long j11 = this.f9137j;
            if (this.f9136i - j11 >= 4) {
                this.f9137j = 4 + j11;
                return ((c1.u(j11 + 3) & 255) << Ascii.CAN) | (c1.u(j11) & 255) | ((c1.u(1 + j11) & 255) << 8) | ((c1.u(2 + j11) & 255) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long K() throws IOException {
            long j11 = this.f9137j;
            if (this.f9136i - j11 >= 8) {
                this.f9137j = 8 + j11;
                return ((((long) c1.u(j11 + 7)) & 255) << 56) | (((long) c1.u(j11)) & 255) | ((((long) c1.u(1 + j11)) & 255) << 8) | ((((long) c1.u(2 + j11)) & 255) << 16) | ((((long) c1.u(3 + j11)) & 255) << 24) | ((((long) c1.u(4 + j11)) & 255) << 32) | ((((long) c1.u(5 + j11)) & 255) << 40) | ((((long) c1.u(6 + j11)) & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
            if (androidx.datastore.preferences.protobuf.c1.u(r4) < 0) goto L_0x0085;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int L() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.f9137j
                long r2 = r10.f9136i
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x000a
                goto L_0x0085
            L_0x000a:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = androidx.datastore.preferences.protobuf.c1.u(r0)
                if (r0 < 0) goto L_0x0017
                r10.f9137j = r4
                return r0
            L_0x0017:
                long r6 = r10.f9136i
                long r6 = r6 - r4
                r8 = 9
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x0021
                goto L_0x0085
            L_0x0021:
                long r6 = r4 + r2
                byte r1 = androidx.datastore.preferences.protobuf.c1.u(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x002f
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x008b
            L_0x002f:
                long r4 = r6 + r2
                byte r1 = androidx.datastore.preferences.protobuf.c1.u(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003e
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x003c:
                r6 = r4
                goto L_0x008b
            L_0x003e:
                long r6 = r4 + r2
                byte r1 = androidx.datastore.preferences.protobuf.c1.u(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x004e
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L_0x008b
            L_0x004e:
                long r4 = r6 + r2
                byte r1 = androidx.datastore.preferences.protobuf.c1.u(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = androidx.datastore.preferences.protobuf.c1.u(r4)
                if (r1 >= 0) goto L_0x008b
                long r4 = r6 + r2
                byte r1 = androidx.datastore.preferences.protobuf.c1.u(r6)
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = androidx.datastore.preferences.protobuf.c1.u(r4)
                if (r1 >= 0) goto L_0x008b
                long r4 = r6 + r2
                byte r1 = androidx.datastore.preferences.protobuf.c1.u(r6)
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = androidx.datastore.preferences.protobuf.c1.u(r4)
                if (r1 >= 0) goto L_0x008b
            L_0x0085:
                long r0 = r10.N()
                int r0 = (int) r0
                return r0
            L_0x008b:
                r10.f9137j = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.g.d.L():int");
        }

        public long M() throws IOException {
            long j11;
            long j12;
            long j13;
            byte b11;
            long j14 = this.f9137j;
            if (this.f9136i != j14) {
                long j15 = j14 + 1;
                byte u11 = c1.u(j14);
                if (u11 >= 0) {
                    this.f9137j = j15;
                    return (long) u11;
                } else if (this.f9136i - j15 >= 9) {
                    long j16 = j15 + 1;
                    byte u12 = u11 ^ (c1.u(j15) << 7);
                    if (u12 < 0) {
                        b11 = u12 ^ Byte.MIN_VALUE;
                    } else {
                        long j17 = j16 + 1;
                        byte u13 = u12 ^ (c1.u(j16) << 14);
                        if (u13 >= 0) {
                            j11 = (long) (u13 ^ 16256);
                        } else {
                            j16 = j17 + 1;
                            byte u14 = u13 ^ (c1.u(j17) << 21);
                            if (u14 < 0) {
                                b11 = u14 ^ -2080896;
                            } else {
                                j17 = j16 + 1;
                                long u15 = ((long) u14) ^ (((long) c1.u(j16)) << 28);
                                if (u15 >= 0) {
                                    j13 = 266354560;
                                } else {
                                    long j18 = j17 + 1;
                                    long u16 = u15 ^ (((long) c1.u(j17)) << 35);
                                    if (u16 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        j17 = j18 + 1;
                                        u15 = u16 ^ (((long) c1.u(j18)) << 42);
                                        if (u15 >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            j18 = j17 + 1;
                                            u16 = u15 ^ (((long) c1.u(j17)) << 49);
                                            if (u16 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                j17 = j18 + 1;
                                                j11 = (u16 ^ (((long) c1.u(j18)) << 56)) ^ 71499008037633920L;
                                                if (j11 < 0) {
                                                    long j19 = 1 + j17;
                                                    if (((long) c1.u(j17)) >= 0) {
                                                        j16 = j19;
                                                        this.f9137j = j16;
                                                        return j11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j11 = u16 ^ j12;
                                    j16 = j18;
                                    this.f9137j = j16;
                                    return j11;
                                }
                                j11 = u15 ^ j13;
                            }
                        }
                        j16 = j17;
                        this.f9137j = j16;
                        return j11;
                    }
                    j11 = (long) b11;
                    this.f9137j = j16;
                    return j11;
                }
            }
            return N();
        }

        public long N() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte I = I();
                j11 |= ((long) (I & Ascii.DEL)) << i11;
                if ((I & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void O() {
            long j11 = this.f9136i + ((long) this.f9139l);
            this.f9136i = j11;
            int i11 = (int) (j11 - this.f9138k);
            int i12 = this.f9142o;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f9139l = i13;
                this.f9136i = j11 - ((long) i13);
                return;
            }
            this.f9139l = 0;
        }

        public final int P() {
            return (int) (this.f9136i - this.f9137j);
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void Q() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.C()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.F(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.g.d.Q():void");
        }

        public void R(int i11) throws IOException {
            if (i11 >= 0 && i11 <= P()) {
                this.f9137j += (long) i11;
            } else if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final void S() throws IOException {
            if (P() >= 10) {
                T();
            } else {
                U();
            }
        }

        public final void T() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                long j11 = this.f9137j;
                this.f9137j = 1 + j11;
                if (c1.u(j11) < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void U() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                if (I() < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
            r3.f9133f.position(r0);
            r3.f9133f.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0031 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.nio.ByteBuffer V(long r4, long r6) throws java.io.IOException {
            /*
                r3 = this;
                java.nio.ByteBuffer r0 = r3.f9133f
                int r0 = r0.position()
                java.nio.ByteBuffer r1 = r3.f9133f
                int r1 = r1.limit()
                java.nio.ByteBuffer r2 = r3.f9133f     // Catch:{ IllegalArgumentException -> 0x0031 }
                int r4 = r3.G(r4)     // Catch:{ IllegalArgumentException -> 0x0031 }
                r2.position(r4)     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r3.f9133f     // Catch:{ IllegalArgumentException -> 0x0031 }
                int r5 = r3.G(r6)     // Catch:{ IllegalArgumentException -> 0x0031 }
                r4.limit(r5)     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r3.f9133f     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r4 = r4.slice()     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r5 = r3.f9133f
                r5.position(r0)
                java.nio.ByteBuffer r5 = r3.f9133f
                r5.limit(r1)
                return r4
            L_0x002f:
                r4 = move-exception
                goto L_0x0036
            L_0x0031:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()     // Catch:{ all -> 0x002f }
                throw r4     // Catch:{ all -> 0x002f }
            L_0x0036:
                java.nio.ByteBuffer r5 = r3.f9133f
                r5.position(r0)
                java.nio.ByteBuffer r5 = r3.f9133f
                r5.limit(r1)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.g.d.V(long, long):java.nio.ByteBuffer");
        }

        public void a(int i11) throws InvalidProtocolBufferException {
            if (this.f9140m != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public int d() {
            return (int) (this.f9137j - this.f9138k);
        }

        public boolean e() throws IOException {
            return this.f9137j == this.f9136i;
        }

        public void l(int i11) {
            this.f9142o = i11;
            O();
        }

        public int m(int i11) throws InvalidProtocolBufferException {
            if (i11 >= 0) {
                int d11 = i11 + d();
                int i12 = this.f9142o;
                if (d11 <= i12) {
                    this.f9142o = d11;
                    O();
                    return i12;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean n() throws IOException {
            return M() != 0;
        }

        public ByteString o() throws IOException {
            int L = L();
            if (L <= 0 || L > P()) {
                if (L == 0) {
                    return ByteString.EMPTY;
                }
                if (L < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (!this.f9134g || !this.f9141n) {
                byte[] bArr = new byte[L];
                long j11 = (long) L;
                c1.n(this.f9137j, bArr, 0, j11);
                this.f9137j += j11;
                return ByteString.wrap(bArr);
            } else {
                long j12 = this.f9137j;
                long j13 = (long) L;
                ByteBuffer V = V(j12, j12 + j13);
                this.f9137j += j13;
                return ByteString.wrap(V);
            }
        }

        public double p() throws IOException {
            return Double.longBitsToDouble(K());
        }

        public int q() throws IOException {
            return L();
        }

        public int r() throws IOException {
            return J();
        }

        public long s() throws IOException {
            return K();
        }

        public float t() throws IOException {
            return Float.intBitsToFloat(J());
        }

        public int u() throws IOException {
            return L();
        }

        public long v() throws IOException {
            return M();
        }

        public int w() throws IOException {
            return J();
        }

        public long x() throws IOException {
            return K();
        }

        public int y() throws IOException {
            return g.b(L());
        }

        public long z() throws IOException {
            return g.c(M());
        }

        public d(ByteBuffer byteBuffer, boolean z11) {
            super();
            this.f9142o = Integer.MAX_VALUE;
            this.f9133f = byteBuffer;
            long i11 = c1.i(byteBuffer);
            this.f9135h = i11;
            this.f9136i = ((long) byteBuffer.limit()) + i11;
            long position = i11 + ((long) byteBuffer.position());
            this.f9137j = position;
            this.f9138k = position;
            this.f9134g = z11;
        }
    }

    public static int b(int i11) {
        return (-(i11 & 1)) ^ (i11 >>> 1);
    }

    public static long c(long j11) {
        return (-(j11 & 1)) ^ (j11 >>> 1);
    }

    public static g f(InputStream inputStream) {
        return g(inputStream, 4096);
    }

    public static g g(InputStream inputStream, int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("bufferSize must be > 0");
        } else if (inputStream == null) {
            return i(u.f9215c);
        } else {
            return new c(inputStream, i11);
        }
    }

    public static g h(ByteBuffer byteBuffer, boolean z11) {
        if (byteBuffer.hasArray()) {
            return k(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z11);
        }
        if (byteBuffer.isDirect() && d.H()) {
            return new d(byteBuffer, z11);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return k(bArr, 0, remaining, true);
    }

    public static g i(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public static g j(byte[] bArr, int i11, int i12) {
        return k(bArr, i11, i12, false);
    }

    public static g k(byte[] bArr, int i11, int i12, boolean z11) {
        b bVar = new b(bArr, i11, i12, z11);
        try {
            bVar.m(i12);
            return bVar;
        } catch (InvalidProtocolBufferException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public abstract String A() throws IOException;

    public abstract String B() throws IOException;

    public abstract int C() throws IOException;

    public abstract int D() throws IOException;

    public abstract long E() throws IOException;

    public abstract boolean F(int i11) throws IOException;

    public abstract void a(int i11) throws InvalidProtocolBufferException;

    public abstract int d();

    public abstract boolean e() throws IOException;

    public abstract void l(int i11);

    public abstract int m(int i11) throws InvalidProtocolBufferException;

    public abstract boolean n() throws IOException;

    public abstract ByteString o() throws IOException;

    public abstract double p() throws IOException;

    public abstract int q() throws IOException;

    public abstract int r() throws IOException;

    public abstract long s() throws IOException;

    public abstract float t() throws IOException;

    public abstract int u() throws IOException;

    public abstract long v() throws IOException;

    public abstract int w() throws IOException;

    public abstract long x() throws IOException;

    public abstract int y() throws IOException;

    public abstract long z() throws IOException;

    public g() {
        this.f9111b = 100;
        this.f9112c = Integer.MAX_VALUE;
        this.f9114e = false;
    }
}
