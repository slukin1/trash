package l3;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifHeader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import l3.a;

public class c implements a {

    /* renamed from: u  reason: collision with root package name */
    public static final String f66479u = "c";

    /* renamed from: a  reason: collision with root package name */
    public int[] f66480a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f66481b;

    /* renamed from: c  reason: collision with root package name */
    public final a.C0722a f66482c;

    /* renamed from: d  reason: collision with root package name */
    public ByteBuffer f66483d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f66484e;

    /* renamed from: f  reason: collision with root package name */
    public short[] f66485f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f66486g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f66487h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f66488i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f66489j;

    /* renamed from: k  reason: collision with root package name */
    public int f66490k;

    /* renamed from: l  reason: collision with root package name */
    public GifHeader f66491l;

    /* renamed from: m  reason: collision with root package name */
    public Bitmap f66492m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f66493n;

    /* renamed from: o  reason: collision with root package name */
    public int f66494o;

    /* renamed from: p  reason: collision with root package name */
    public int f66495p;

    /* renamed from: q  reason: collision with root package name */
    public int f66496q;

    /* renamed from: r  reason: collision with root package name */
    public int f66497r;

    /* renamed from: s  reason: collision with root package name */
    public Boolean f66498s;

    /* renamed from: t  reason: collision with root package name */
    public Bitmap.Config f66499t;

    public c(a.C0722a aVar, GifHeader gifHeader, ByteBuffer byteBuffer, int i11) {
        this(aVar);
        q(gifHeader, byteBuffer, i11);
    }

    public void a(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.f66499t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public void b() {
        this.f66490k = -1;
    }

    public int c() {
        return this.f66490k;
    }

    public void clear() {
        this.f66491l = null;
        byte[] bArr = this.f66488i;
        if (bArr != null) {
            this.f66482c.e(bArr);
        }
        int[] iArr = this.f66489j;
        if (iArr != null) {
            this.f66482c.f(iArr);
        }
        Bitmap bitmap = this.f66492m;
        if (bitmap != null) {
            this.f66482c.c(bitmap);
        }
        this.f66492m = null;
        this.f66483d = null;
        this.f66498s = null;
        byte[] bArr2 = this.f66484e;
        if (bArr2 != null) {
            this.f66482c.e(bArr2);
        }
    }

    public int d() {
        return this.f66483d.limit() + this.f66488i.length + (this.f66489j.length * 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e3, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap e() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.bumptech.glide.gifdecoder.GifHeader r0 = r8.f66491l     // Catch:{ all -> 0x00e4 }
            int r0 = r0.f63639c     // Catch:{ all -> 0x00e4 }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r8.f66490k     // Catch:{ all -> 0x00e4 }
            if (r0 >= 0) goto L_0x0039
        L_0x000d:
            java.lang.String r0 = f66479u     // Catch:{ all -> 0x00e4 }
            boolean r3 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e4 }
            if (r3 == 0) goto L_0x0037
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r3.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.append(r4)     // Catch:{ all -> 0x00e4 }
            com.bumptech.glide.gifdecoder.GifHeader r4 = r8.f66491l     // Catch:{ all -> 0x00e4 }
            int r4 = r4.f63639c     // Catch:{ all -> 0x00e4 }
            r3.append(r4)     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x00e4 }
            int r4 = r8.f66490k     // Catch:{ all -> 0x00e4 }
            r3.append(r4)     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00e4 }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00e4 }
        L_0x0037:
            r8.f66494o = r2     // Catch:{ all -> 0x00e4 }
        L_0x0039:
            int r0 = r8.f66494o     // Catch:{ all -> 0x00e4 }
            r3 = 0
            if (r0 == r2) goto L_0x00c4
            r4 = 2
            if (r0 != r4) goto L_0x0043
            goto L_0x00c4
        L_0x0043:
            r0 = 0
            r8.f66494o = r0     // Catch:{ all -> 0x00e4 }
            byte[] r5 = r8.f66484e     // Catch:{ all -> 0x00e4 }
            if (r5 != 0) goto L_0x0054
            l3.a$a r5 = r8.f66482c     // Catch:{ all -> 0x00e4 }
            r6 = 255(0xff, float:3.57E-43)
            byte[] r5 = r5.a(r6)     // Catch:{ all -> 0x00e4 }
            r8.f66484e = r5     // Catch:{ all -> 0x00e4 }
        L_0x0054:
            com.bumptech.glide.gifdecoder.GifHeader r5 = r8.f66491l     // Catch:{ all -> 0x00e4 }
            java.util.List<l3.b> r5 = r5.f63641e     // Catch:{ all -> 0x00e4 }
            int r6 = r8.f66490k     // Catch:{ all -> 0x00e4 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00e4 }
            l3.b r5 = (l3.b) r5     // Catch:{ all -> 0x00e4 }
            int r6 = r8.f66490k     // Catch:{ all -> 0x00e4 }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0070
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.f66491l     // Catch:{ all -> 0x00e4 }
            java.util.List<l3.b> r7 = r7.f63641e     // Catch:{ all -> 0x00e4 }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x00e4 }
            l3.b r6 = (l3.b) r6     // Catch:{ all -> 0x00e4 }
            goto L_0x0071
        L_0x0070:
            r6 = r3
        L_0x0071:
            int[] r7 = r5.f66478k     // Catch:{ all -> 0x00e4 }
            if (r7 == 0) goto L_0x0076
            goto L_0x007a
        L_0x0076:
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.f66491l     // Catch:{ all -> 0x00e4 }
            int[] r7 = r7.f63637a     // Catch:{ all -> 0x00e4 }
        L_0x007a:
            r8.f66480a = r7     // Catch:{ all -> 0x00e4 }
            if (r7 != 0) goto L_0x00a0
            java.lang.String r0 = f66479u     // Catch:{ all -> 0x00e4 }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x009c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r1.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = "No valid color table found for frame #"
            r1.append(r4)     // Catch:{ all -> 0x00e4 }
            int r4 = r8.f66490k     // Catch:{ all -> 0x00e4 }
            r1.append(r4)     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e4 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00e4 }
        L_0x009c:
            r8.f66494o = r2     // Catch:{ all -> 0x00e4 }
            monitor-exit(r8)
            return r3
        L_0x00a0:
            boolean r1 = r5.f66473f     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x00be
            int[] r1 = r8.f66481b     // Catch:{ all -> 0x00e4 }
            int r2 = r7.length     // Catch:{ all -> 0x00e4 }
            java.lang.System.arraycopy(r7, r0, r1, r0, r2)     // Catch:{ all -> 0x00e4 }
            int[] r1 = r8.f66481b     // Catch:{ all -> 0x00e4 }
            r8.f66480a = r1     // Catch:{ all -> 0x00e4 }
            int r2 = r5.f66475h     // Catch:{ all -> 0x00e4 }
            r1[r2] = r0     // Catch:{ all -> 0x00e4 }
            int r0 = r5.f66474g     // Catch:{ all -> 0x00e4 }
            if (r0 != r4) goto L_0x00be
            int r0 = r8.f66490k     // Catch:{ all -> 0x00e4 }
            if (r0 != 0) goto L_0x00be
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00e4 }
            r8.f66498s = r0     // Catch:{ all -> 0x00e4 }
        L_0x00be:
            android.graphics.Bitmap r0 = r8.r(r5, r6)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r8)
            return r0
        L_0x00c4:
            java.lang.String r0 = f66479u     // Catch:{ all -> 0x00e4 }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x00e2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r1.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.append(r2)     // Catch:{ all -> 0x00e4 }
            int r2 = r8.f66494o     // Catch:{ all -> 0x00e4 }
            r1.append(r2)     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e4 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00e4 }
        L_0x00e2:
            monitor-exit(r8)
            return r3
        L_0x00e4:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.c.e():android.graphics.Bitmap");
    }

    public void f() {
        this.f66490k = (this.f66490k + 1) % this.f66491l.f63639c;
    }

    public int g() {
        return this.f66491l.f63639c;
    }

    public ByteBuffer getData() {
        return this.f66483d;
    }

    public int h() {
        int i11;
        if (this.f66491l.f63639c <= 0 || (i11 = this.f66490k) < 0) {
            return 0;
        }
        return m(i11);
    }

    public final int i(int i11, int i12, int i13) {
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = i11; i19 < this.f66495p + i11; i19++) {
            byte[] bArr = this.f66488i;
            if (i19 >= bArr.length || i19 >= i12) {
                break;
            }
            int i21 = this.f66480a[bArr[i19] & 255];
            if (i21 != 0) {
                i14 += (i21 >> 24) & 255;
                i15 += (i21 >> 16) & 255;
                i16 += (i21 >> 8) & 255;
                i17 += i21 & 255;
                i18++;
            }
        }
        int i22 = i11 + i13;
        for (int i23 = i22; i23 < this.f66495p + i22; i23++) {
            byte[] bArr2 = this.f66488i;
            if (i23 >= bArr2.length || i23 >= i12) {
                break;
            }
            int i24 = this.f66480a[bArr2[i23] & 255];
            if (i24 != 0) {
                i14 += (i24 >> 24) & 255;
                i15 += (i24 >> 16) & 255;
                i16 += (i24 >> 8) & 255;
                i17 += i24 & 255;
                i18++;
            }
        }
        if (i18 == 0) {
            return 0;
        }
        return ((i14 / i18) << 24) | ((i15 / i18) << 16) | ((i16 / i18) << 8) | (i17 / i18);
    }

    public final void j(b bVar) {
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        b bVar2 = bVar;
        int[] iArr = this.f66489j;
        int i16 = bVar2.f66471d;
        int i17 = this.f66495p;
        int i18 = i16 / i17;
        int i19 = bVar2.f66469b / i17;
        int i21 = bVar2.f66470c / i17;
        int i22 = bVar2.f66468a / i17;
        boolean z12 = this.f66490k == 0;
        int i23 = this.f66497r;
        int i24 = this.f66496q;
        byte[] bArr = this.f66488i;
        int[] iArr2 = this.f66480a;
        Boolean bool = this.f66498s;
        int i25 = 8;
        int i26 = 0;
        int i27 = 0;
        int i28 = 1;
        while (i26 < i18) {
            Boolean bool2 = bool;
            if (bVar2.f66472e) {
                if (i27 >= i18) {
                    i11 = i18;
                    int i29 = i28 + 1;
                    if (i29 == 2) {
                        i28 = i29;
                        i27 = 4;
                    } else if (i29 == 3) {
                        i28 = i29;
                        i25 = 4;
                        i27 = 2;
                    } else if (i29 != 4) {
                        i28 = i29;
                    } else {
                        i28 = i29;
                        i27 = 1;
                        i25 = 2;
                    }
                } else {
                    i11 = i18;
                }
                i12 = i27 + i25;
            } else {
                i11 = i18;
                i12 = i27;
                i27 = i26;
            }
            int i30 = i27 + i19;
            boolean z13 = i17 == 1;
            if (i30 < i24) {
                int i31 = i30 * i23;
                int i32 = i31 + i22;
                int i33 = i32 + i21;
                int i34 = i31 + i23;
                if (i34 < i33) {
                    i33 = i34;
                }
                i13 = i12;
                int i35 = i26 * i17 * bVar2.f66470c;
                if (z13) {
                    int i36 = i32;
                    while (i36 < i33) {
                        int i37 = i19;
                        int i38 = iArr2[bArr[i35] & 255];
                        if (i38 != 0) {
                            iArr[i36] = i38;
                        } else if (z12 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i35 += i17;
                        i36++;
                        i19 = i37;
                    }
                } else {
                    i15 = i19;
                    int i39 = ((i33 - i32) * i17) + i35;
                    int i40 = i32;
                    while (true) {
                        i14 = i21;
                        if (i40 >= i33) {
                            break;
                        }
                        int i41 = i(i35, i39, bVar2.f66470c);
                        if (i41 != 0) {
                            iArr[i40] = i41;
                        } else if (z12 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i35 += i17;
                        i40++;
                        i21 = i14;
                    }
                    bool = bool2;
                    i26++;
                    i19 = i15;
                    i21 = i14;
                    i18 = i11;
                    i27 = i13;
                }
            } else {
                i13 = i12;
            }
            i15 = i19;
            i14 = i21;
            bool = bool2;
            i26++;
            i19 = i15;
            i21 = i14;
            i18 = i11;
            i27 = i13;
        }
        Boolean bool3 = bool;
        if (this.f66498s == null) {
            if (bool3 == null) {
                z11 = false;
            } else {
                z11 = bool3.booleanValue();
            }
            this.f66498s = Boolean.valueOf(z11);
        }
    }

    public final void k(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.f66489j;
        int i11 = bVar2.f66471d;
        int i12 = bVar2.f66469b;
        int i13 = bVar2.f66470c;
        int i14 = bVar2.f66468a;
        boolean z11 = this.f66490k == 0;
        int i15 = this.f66497r;
        byte[] bArr = this.f66488i;
        int[] iArr2 = this.f66480a;
        int i16 = 0;
        byte b11 = -1;
        while (i16 < i11) {
            int i17 = (i16 + i12) * i15;
            int i18 = i17 + i14;
            int i19 = i18 + i13;
            int i21 = i17 + i15;
            if (i21 < i19) {
                i19 = i21;
            }
            int i22 = bVar2.f66470c * i16;
            int i23 = i18;
            while (i23 < i19) {
                byte b12 = bArr[i22];
                int i24 = i11;
                byte b13 = b12 & 255;
                if (b13 != b11) {
                    int i25 = iArr2[b13];
                    if (i25 != 0) {
                        iArr[i23] = i25;
                    } else {
                        b11 = b12;
                    }
                }
                i22++;
                i23++;
                b bVar3 = bVar;
                i11 = i24;
            }
            int i26 = i11;
            i16++;
            bVar2 = bVar;
        }
        Boolean bool = this.f66498s;
        this.f66498s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f66498s == null && z11 && b11 != -1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r7v13, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(l3.b r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.f66483d
            int r3 = r1.f66477j
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0016
            com.bumptech.glide.gifdecoder.GifHeader r1 = r0.f66491l
            int r2 = r1.f63642f
            int r1 = r1.f63643g
            goto L_0x001a
        L_0x0016:
            int r2 = r1.f66470c
            int r1 = r1.f66471d
        L_0x001a:
            int r2 = r2 * r1
            byte[] r1 = r0.f66488i
            if (r1 == 0) goto L_0x0022
            int r1 = r1.length
            if (r1 >= r2) goto L_0x002a
        L_0x0022:
            l3.a$a r1 = r0.f66482c
            byte[] r1 = r1.a(r2)
            r0.f66488i = r1
        L_0x002a:
            byte[] r1 = r0.f66488i
            short[] r3 = r0.f66485f
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0036
            short[] r3 = new short[r4]
            r0.f66485f = r3
        L_0x0036:
            short[] r3 = r0.f66485f
            byte[] r5 = r0.f66486g
            if (r5 != 0) goto L_0x0040
            byte[] r5 = new byte[r4]
            r0.f66486g = r5
        L_0x0040:
            byte[] r5 = r0.f66486g
            byte[] r6 = r0.f66487h
            if (r6 != 0) goto L_0x004c
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.f66487h = r6
        L_0x004c:
            byte[] r6 = r0.f66487h
            int r7 = r28.p()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = r13
        L_0x005f:
            if (r14 >= r9) goto L_0x0069
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x005f
        L_0x0069:
            byte[] r14 = r0.f66484e
            r15 = -1
            r23 = r7
            r21 = r11
            r22 = r12
            r16 = r13
            r17 = r16
            r18 = r17
            r19 = r18
            r20 = r19
            r25 = r20
            r26 = r25
            r24 = r15
        L_0x0082:
            if (r13 >= r2) goto L_0x014b
            if (r16 != 0) goto L_0x0093
            int r16 = r28.o()
            if (r16 > 0) goto L_0x0091
            r3 = 3
            r0.f66494o = r3
            goto L_0x014b
        L_0x0091:
            r17 = 0
        L_0x0093:
            byte r4 = r14[r17]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            int r17 = r17 + 1
            int r16 = r16 + -1
            r4 = r18
            r8 = r21
            r15 = r23
            r0 = r24
            r23 = r7
            r7 = r25
        L_0x00ad:
            if (r4 < r15) goto L_0x0135
            r24 = r11
            r11 = r19 & r22
            int r19 = r19 >> r15
            int r4 = r4 - r15
            if (r11 != r9) goto L_0x00c1
            r22 = r12
            r15 = r23
            r8 = r24
            r11 = r8
            r0 = -1
            goto L_0x00ad
        L_0x00c1:
            if (r11 != r10) goto L_0x00d8
            r18 = r4
            r25 = r7
            r21 = r8
            r7 = r23
            r11 = r24
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r24 = r0
            r23 = r15
            r15 = -1
            r0 = r28
            goto L_0x0082
        L_0x00d8:
            r25 = r4
            r4 = -1
            if (r0 != r4) goto L_0x00ec
            byte r0 = r5[r11]
            r1[r20] = r0
            int r20 = r20 + 1
            int r13 = r13 + 1
            r0 = r11
            r7 = r0
            r11 = r24
            r4 = r25
            goto L_0x00ad
        L_0x00ec:
            if (r11 < r8) goto L_0x00f5
            byte r7 = (byte) r7
            r6[r26] = r7
            int r26 = r26 + 1
            r7 = r0
            goto L_0x00f6
        L_0x00f5:
            r7 = r11
        L_0x00f6:
            if (r7 < r9) goto L_0x0101
            byte r21 = r5[r7]
            r6[r26] = r21
            int r26 = r26 + 1
            short r7 = r3[r7]
            goto L_0x00f6
        L_0x0101:
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r7
            r1[r20] = r4
        L_0x0108:
            int r20 = r20 + 1
            int r13 = r13 + 1
            if (r26 <= 0) goto L_0x0115
            int r26 = r26 + -1
            byte r27 = r6[r26]
            r1[r20] = r27
            goto L_0x0108
        L_0x0115:
            r27 = r6
            r6 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r6) goto L_0x012c
            short r0 = (short) r0
            r3[r8] = r0
            r5[r8] = r4
            int r8 = r8 + 1
            r0 = r8 & r22
            if (r0 != 0) goto L_0x012c
            if (r8 >= r6) goto L_0x012c
            int r15 = r15 + 1
            int r22 = r22 + r8
        L_0x012c:
            r0 = r11
            r11 = r24
            r4 = r25
            r6 = r27
            goto L_0x00ad
        L_0x0135:
            r25 = r4
            r24 = r0
            r21 = r8
            r18 = r25
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r0 = r28
            r25 = r7
            r7 = r23
            r23 = r15
            r15 = -1
            goto L_0x0082
        L_0x014b:
            r13 = r20
            r0 = 0
            java.util.Arrays.fill(r1, r13, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.c.l(l3.b):void");
    }

    public int m(int i11) {
        if (i11 >= 0) {
            GifHeader gifHeader = this.f66491l;
            if (i11 < gifHeader.f63639c) {
                return gifHeader.f63641e.get(i11).f66476i;
            }
        }
        return -1;
    }

    public final Bitmap n() {
        Boolean bool = this.f66498s;
        Bitmap b11 = this.f66482c.b(this.f66497r, this.f66496q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f66499t);
        b11.setHasAlpha(true);
        return b11;
    }

    public final int o() {
        int p11 = p();
        if (p11 <= 0) {
            return p11;
        }
        ByteBuffer byteBuffer = this.f66483d;
        byteBuffer.get(this.f66484e, 0, Math.min(p11, byteBuffer.remaining()));
        return p11;
    }

    public final int p() {
        return this.f66483d.get() & 255;
    }

    public synchronized void q(GifHeader gifHeader, ByteBuffer byteBuffer, int i11) {
        if (i11 > 0) {
            int highestOneBit = Integer.highestOneBit(i11);
            this.f66494o = 0;
            this.f66491l = gifHeader;
            this.f66490k = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f66483d = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f66483d.order(ByteOrder.LITTLE_ENDIAN);
            this.f66493n = false;
            Iterator<b> it2 = gifHeader.f63641e.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().f66474g == 3) {
                        this.f66493n = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f66495p = highestOneBit;
            int i12 = gifHeader.f63642f;
            this.f66497r = i12 / highestOneBit;
            int i13 = gifHeader.f63643g;
            this.f66496q = i13 / highestOneBit;
            this.f66488i = this.f66482c.a(i12 * i13);
            this.f66489j = this.f66482c.d(this.f66497r * this.f66496q);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i11);
        }
    }

    public final Bitmap r(b bVar, b bVar2) {
        int i11;
        int i12;
        Bitmap bitmap;
        int[] iArr = this.f66489j;
        int i13 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f66492m;
            if (bitmap2 != null) {
                this.f66482c.c(bitmap2);
            }
            this.f66492m = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f66474g == 3 && this.f66492m == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i12 = bVar2.f66474g) > 0) {
            if (i12 == 2) {
                if (!bVar.f66473f) {
                    GifHeader gifHeader = this.f66491l;
                    int i14 = gifHeader.f63648l;
                    if (bVar.f66478k == null || gifHeader.f63646j != bVar.f66475h) {
                        i13 = i14;
                    }
                }
                int i15 = bVar2.f66471d;
                int i16 = this.f66495p;
                int i17 = i15 / i16;
                int i18 = bVar2.f66469b / i16;
                int i19 = bVar2.f66470c / i16;
                int i21 = bVar2.f66468a / i16;
                int i22 = this.f66497r;
                int i23 = (i18 * i22) + i21;
                int i24 = (i17 * i22) + i23;
                while (i23 < i24) {
                    int i25 = i23 + i19;
                    for (int i26 = i23; i26 < i25; i26++) {
                        iArr[i26] = i13;
                    }
                    i23 += this.f66497r;
                }
            } else if (i12 == 3 && (bitmap = this.f66492m) != null) {
                int i27 = this.f66497r;
                bitmap.getPixels(iArr, 0, i27, 0, 0, i27, this.f66496q);
            }
        }
        l(bVar);
        if (bVar.f66472e || this.f66495p != 1) {
            j(bVar);
        } else {
            k(bVar);
        }
        if (this.f66493n && ((i11 = bVar.f66474g) == 0 || i11 == 1)) {
            if (this.f66492m == null) {
                this.f66492m = n();
            }
            Bitmap bitmap3 = this.f66492m;
            int i28 = this.f66497r;
            bitmap3.setPixels(iArr, 0, i28, 0, 0, i28, this.f66496q);
        }
        Bitmap n11 = n();
        int i29 = this.f66497r;
        n11.setPixels(iArr, 0, i29, 0, 0, i29, this.f66496q);
        return n11;
    }

    public c(a.C0722a aVar) {
        this.f66481b = new int[256];
        this.f66499t = Bitmap.Config.ARGB_8888;
        this.f66482c = aVar;
        this.f66491l = new GifHeader();
    }
}
