package oupson.apng;

import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.Unit;
import net.sf.scuba.smartcards.ISO7816;
import oupson.apng.chunks.IHDR;
import oupson.apng.chunks.fcTL;
import oupson.apng.exceptions.BadApngException;
import oupson.apng.exceptions.BadCRCException;
import oupson.apng.exceptions.NotApngException;
import oupson.apng.exceptions.NotPngException;
import oupson.apng.utils.Utils;

@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b<\u0010=J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0016\u0010%\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006>"}, d2 = {"Loupson/apng/APNGDisassembler;", "", "", "byteArray", "Loupson/apng/Apng;", "b", "Ljava/io/InputStream;", "input", "a", "Loupson/apng/chunks/IHDR;", "ihdrOfApng", "", "width", "height", "c", "", "d", "e", "Ljava/util/ArrayList;", "", "Ljava/util/ArrayList;", "png", "cover", "", "F", "delay", "I", "yOffset", "xOffset", "f", "[B", "plte", "g", "tnrs", "h", "maxWidth", "i", "maxHeight", "Loupson/apng/utils/Utils$Companion$BlendOp;", "j", "Loupson/apng/utils/Utils$Companion$BlendOp;", "blendOp", "Loupson/apng/utils/Utils$Companion$DisposeOp;", "k", "Loupson/apng/utils/Utils$Companion$DisposeOp;", "disposeOp", "l", "Loupson/apng/chunks/IHDR;", "ihdr", "", "m", "Z", "isApng", "n", "Loupson/apng/Apng;", "getApng", "()Loupson/apng/Apng;", "setApng", "(Loupson/apng/Apng;)V", "apng", "<init>", "()V", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class APNGDisassembler {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Byte> f52900a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Byte> f52901b;

    /* renamed from: c  reason: collision with root package name */
    public float f52902c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public int f52903d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f52904e = -1;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f52905f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f52906g;

    /* renamed from: h  reason: collision with root package name */
    public int f52907h;

    /* renamed from: i  reason: collision with root package name */
    public int f52908i;

    /* renamed from: j  reason: collision with root package name */
    public Utils.Companion.BlendOp f52909j = Utils.Companion.BlendOp.APNG_BLEND_OP_SOURCE;

    /* renamed from: k  reason: collision with root package name */
    public Utils.Companion.DisposeOp f52910k = Utils.Companion.DisposeOp.APNG_DISPOSE_OP_NONE;

    /* renamed from: l  reason: collision with root package name */
    public IHDR f52911l = new IHDR();

    /* renamed from: m  reason: collision with root package name */
    public boolean f52912m;

    /* renamed from: n  reason: collision with root package name */
    public Apng f52913n = new Apng();

    public final Apng a(InputStream inputStream) {
        e();
        byte[] bArr = new byte[8];
        inputStream.read(bArr);
        if (Utils.f52981j.m(bArr)) {
            byte[] bArr2 = new byte[4];
            while (inputStream.read(bArr2) != -1) {
                Utils.Companion companion = Utils.f52981j;
                ArrayList arrayList = new ArrayList(4);
                for (int i11 = 0; i11 < 4; i11++) {
                    arrayList.add(Integer.valueOf(bArr2[i11]));
                }
                byte[] bArr3 = new byte[(companion.n(arrayList) + 8)];
                int read = inputStream.read(bArr3);
                d(ArraysKt___ArraysJvmKt.q(bArr2, bArr3));
                if (read == -1) {
                    break;
                }
            }
            return this.f52913n;
        }
        throw new NotPngException();
    }

    public final Apng b(byte[] bArr) {
        e();
        if (Utils.f52981j.l(bArr)) {
            int i11 = 8;
            while (i11 < bArr.length) {
                Utils.Companion companion = Utils.f52981j;
                byte[] i12 = ArraysKt___ArraysJvmKt.i(bArr, i11, i11 + 4);
                ArrayList arrayList = new ArrayList(i12.length);
                for (byte valueOf : i12) {
                    arrayList.add(Integer.valueOf(valueOf));
                }
                int n11 = companion.n(arrayList);
                d(ArraysKt___ArraysJvmKt.i(bArr, i11, i11 + n11 + 12));
                i11 += n11 + 12;
            }
            return this.f52913n;
        }
        throw new NotApngException();
    }

    public final byte[] c(IHDR ihdr, int i11, int i12) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Utils.Companion companion = Utils.f52981j;
        arrayList.addAll(ArraysKt___ArraysJvmKt.c(companion.o(ihdr.a().length)));
        arrayList2.addAll(ArraysKt___ArraysJvmKt.c(new byte[]{(byte) 73, (byte) 72, (byte) 68, (byte) 82}));
        arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion.o(i11)));
        arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion.o(i12)));
        arrayList2.addAll(ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(ihdr.a(), 8, 13)));
        CRC32 crc32 = new CRC32();
        crc32.update(CollectionsKt___CollectionsKt.E0(arrayList2), 0, arrayList2.size());
        arrayList.addAll(arrayList2);
        arrayList.addAll(ArraysKt___ArraysJvmKt.c(companion.o((int) crc32.getValue())));
        return CollectionsKt___CollectionsKt.E0(arrayList);
    }

    public final void d(byte[] bArr) {
        ArrayList<Byte> arrayList;
        ArrayList<Byte> arrayList2;
        ArrayList<Byte> arrayList3;
        ArrayList<Byte> arrayList4;
        Utils.Companion companion = Utils.f52981j;
        byte[] i11 = ArraysKt___ArraysJvmKt.i(bArr, bArr.length - 4, bArr.length);
        ArrayList arrayList5 = new ArrayList(i11.length);
        for (byte valueOf : i11) {
            arrayList5.add(Integer.valueOf(valueOf));
        }
        int n11 = companion.n(arrayList5);
        CRC32 crc32 = new CRC32();
        crc32.update(ArraysKt___ArraysJvmKt.i(bArr, 4, bArr.length - 4));
        if (n11 == ((int) crc32.getValue())) {
            byte[] i12 = ArraysKt___ArraysJvmKt.i(bArr, 4, 8);
            Utils.Companion companion2 = Utils.f52981j;
            if (Arrays.equals(i12, companion2.d())) {
                ArrayList<Byte> arrayList6 = this.f52900a;
                if (arrayList6 == null) {
                    ArrayList<Byte> arrayList7 = this.f52901b;
                    if (arrayList7 != null) {
                        arrayList7.addAll(ArraysKt___ArraysJvmKt.c(companion2.o(0)));
                        byte[] bArr2 = {73, 69, 78, ISO7816.INS_REHABILITATE_CHV};
                        CRC32 crc322 = new CRC32();
                        crc322.update(bArr2, 0, 4);
                        arrayList7.addAll(ArraysKt___ArraysJvmKt.c(bArr2));
                        arrayList7.addAll(ArraysKt___ArraysJvmKt.c(companion2.o((int) crc322.getValue())));
                        this.f52913n.e(BitmapFactory.decodeByteArray(CollectionsKt___CollectionsKt.E0(arrayList7), 0, arrayList7.size()));
                        Unit unit = Unit.f56620a;
                    }
                    this.f52900a = new ArrayList<>();
                    fcTL fctl = new fcTL();
                    fctl.h(bArr);
                    this.f52902c = fctl.b();
                    this.f52903d = fctl.g();
                    this.f52904e = fctl.f();
                    this.f52909j = fctl.a();
                    this.f52910k = fctl.c();
                    int e11 = fctl.e();
                    int d11 = fctl.d();
                    if (this.f52904e + e11 > this.f52907h) {
                        throw new BadApngException("`yOffset` + `height` must be <= `IHDR` height");
                    } else if (this.f52903d + d11 <= this.f52908i) {
                        ArrayList<Byte> arrayList8 = this.f52900a;
                        if (arrayList8 != null) {
                            arrayList8.addAll(ArraysKt___ArraysJvmKt.c(companion2.j()));
                        }
                        ArrayList<Byte> arrayList9 = this.f52900a;
                        if (arrayList9 != null) {
                            arrayList9.addAll(ArraysKt___ArraysJvmKt.c(c(this.f52911l, e11, d11)));
                        }
                        byte[] bArr3 = this.f52905f;
                        if (!(bArr3 == null || (arrayList4 = this.f52900a) == null)) {
                            arrayList4.addAll(ArraysKt___ArraysJvmKt.c(bArr3));
                        }
                        byte[] bArr4 = this.f52906g;
                        if (bArr4 != null && (arrayList3 = this.f52900a) != null) {
                            arrayList3.addAll(ArraysKt___ArraysJvmKt.c(bArr4));
                        }
                    } else {
                        throw new BadApngException("`yOffset` + `height` must be <= `IHDR` height");
                    }
                } else {
                    if (arrayList6 != null) {
                        arrayList6.addAll(ArraysKt___ArraysJvmKt.c(companion2.o(0)));
                    }
                    byte[] bArr5 = {73, 69, 78, ISO7816.INS_REHABILITATE_CHV};
                    CRC32 crc323 = new CRC32();
                    crc323.update(bArr5, 0, 4);
                    ArrayList<Byte> arrayList10 = this.f52900a;
                    if (arrayList10 != null) {
                        arrayList10.addAll(ArraysKt___ArraysJvmKt.c(bArr5));
                    }
                    ArrayList<Byte> arrayList11 = this.f52900a;
                    if (arrayList11 != null) {
                        arrayList11.addAll(ArraysKt___ArraysJvmKt.c(companion2.o((int) crc323.getValue())));
                    }
                    this.f52913n.b().add(new b(CollectionsKt___CollectionsKt.E0(this.f52900a), this.f52902c, this.f52904e, this.f52903d, this.f52909j, this.f52910k, Integer.valueOf(this.f52907h), Integer.valueOf(this.f52908i)));
                    this.f52900a = new ArrayList<>();
                    fcTL fctl2 = new fcTL();
                    fctl2.h(bArr);
                    this.f52902c = fctl2.b();
                    this.f52903d = fctl2.g();
                    this.f52904e = fctl2.f();
                    this.f52909j = fctl2.a();
                    this.f52910k = fctl2.c();
                    int e12 = fctl2.e();
                    int d12 = fctl2.d();
                    ArrayList<Byte> arrayList12 = this.f52900a;
                    if (arrayList12 != null) {
                        arrayList12.addAll(ArraysKt___ArraysJvmKt.c(companion2.j()));
                    }
                    ArrayList<Byte> arrayList13 = this.f52900a;
                    if (arrayList13 != null) {
                        arrayList13.addAll(ArraysKt___ArraysJvmKt.c(c(this.f52911l, e12, d12)));
                    }
                    byte[] bArr6 = this.f52905f;
                    if (!(bArr6 == null || (arrayList2 = this.f52900a) == null)) {
                        arrayList2.addAll(ArraysKt___ArraysJvmKt.c(bArr6));
                    }
                    byte[] bArr7 = this.f52906g;
                    if (bArr7 != null && (arrayList = this.f52900a) != null) {
                        arrayList.addAll(ArraysKt___ArraysJvmKt.c(bArr7));
                    }
                }
            } else if (Arrays.equals(i12, companion2.g())) {
                if (this.f52912m) {
                    ArrayList<Byte> arrayList14 = this.f52900a;
                    if (arrayList14 != null) {
                        arrayList14.addAll(ArraysKt___ArraysJvmKt.c(companion2.o(0)));
                    }
                    byte[] bArr8 = {73, 69, 78, ISO7816.INS_REHABILITATE_CHV};
                    CRC32 crc324 = new CRC32();
                    crc324.update(bArr8, 0, 4);
                    ArrayList<Byte> arrayList15 = this.f52900a;
                    if (arrayList15 != null) {
                        arrayList15.addAll(ArraysKt___ArraysJvmKt.c(bArr8));
                    }
                    ArrayList<Byte> arrayList16 = this.f52900a;
                    if (arrayList16 != null) {
                        arrayList16.addAll(ArraysKt___ArraysJvmKt.c(companion2.o((int) crc324.getValue())));
                    }
                    this.f52913n.b().add(new b(CollectionsKt___CollectionsKt.E0(this.f52900a), this.f52902c, this.f52904e, this.f52903d, this.f52909j, this.f52910k, Integer.valueOf(this.f52907h), Integer.valueOf(this.f52908i)));
                    return;
                }
                ArrayList<Byte> arrayList17 = this.f52901b;
                if (arrayList17 != null) {
                    arrayList17.addAll(ArraysKt___ArraysJvmKt.c(companion2.o(0)));
                    byte[] bArr9 = {73, 69, 78, ISO7816.INS_REHABILITATE_CHV};
                    CRC32 crc325 = new CRC32();
                    crc325.update(bArr9, 0, 4);
                    arrayList17.addAll(ArraysKt___ArraysJvmKt.c(bArr9));
                    arrayList17.addAll(ArraysKt___ArraysJvmKt.c(companion2.o((int) crc325.getValue())));
                    this.f52913n.e(BitmapFactory.decodeByteArray(CollectionsKt___CollectionsKt.E0(arrayList17), 0, arrayList17.size()));
                    Unit unit2 = Unit.f56620a;
                }
                this.f52913n.d(false);
            } else if (Arrays.equals(i12, companion2.f())) {
                if (this.f52900a == null) {
                    if (this.f52901b == null) {
                        ArrayList<Byte> arrayList18 = new ArrayList<>();
                        this.f52901b = arrayList18;
                        arrayList18.addAll(ArraysKt___ArraysJvmKt.c(companion2.j()));
                        ArrayList<Byte> arrayList19 = this.f52901b;
                        if (arrayList19 != null) {
                            arrayList19.addAll(ArraysKt___ArraysJvmKt.c(c(this.f52911l, this.f52907h, this.f52908i)));
                        }
                    }
                    byte[] i13 = ArraysKt___ArraysJvmKt.i(bArr, 0, 4);
                    ArrayList arrayList20 = new ArrayList(i13.length);
                    for (byte valueOf2 : i13) {
                        arrayList20.add(Integer.valueOf(valueOf2));
                    }
                    int n12 = companion2.n(arrayList20);
                    ArrayList<Byte> arrayList21 = this.f52901b;
                    if (arrayList21 != null) {
                        arrayList21.addAll(ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(bArr, 0, 4)));
                    }
                    ArrayList arrayList22 = new ArrayList();
                    arrayList22.addAll(ArraysKt___ArraysJvmKt.c(new byte[]{73, ISO7816.INS_REHABILITATE_CHV, 65, 84}));
                    arrayList22.addAll(ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(bArr, 8, n12 + 8)));
                    CRC32 crc326 = new CRC32();
                    crc326.update(CollectionsKt___CollectionsKt.E0(arrayList22), 0, arrayList22.size());
                    ArrayList<Byte> arrayList23 = this.f52901b;
                    if (arrayList23 != null) {
                        arrayList23.addAll(arrayList22);
                    }
                    ArrayList<Byte> arrayList24 = this.f52901b;
                    if (arrayList24 != null) {
                        arrayList24.addAll(ArraysKt___ArraysJvmKt.c(Utils.f52981j.o((int) crc326.getValue())));
                        return;
                    }
                    return;
                }
                byte[] i14 = ArraysKt___ArraysJvmKt.i(bArr, 0, 4);
                ArrayList arrayList25 = new ArrayList(i14.length);
                for (byte valueOf3 : i14) {
                    arrayList25.add(Integer.valueOf(valueOf3));
                }
                int n13 = companion2.n(arrayList25);
                ArrayList<Byte> arrayList26 = this.f52900a;
                if (arrayList26 != null) {
                    arrayList26.addAll(ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(bArr, 0, 4)));
                }
                ArrayList arrayList27 = new ArrayList();
                arrayList27.addAll(ArraysKt___ArraysJvmKt.c(new byte[]{73, ISO7816.INS_REHABILITATE_CHV, 65, 84}));
                arrayList27.addAll(ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(bArr, 8, n13 + 8)));
                CRC32 crc327 = new CRC32();
                crc327.update(CollectionsKt___CollectionsKt.E0(arrayList27), 0, arrayList27.size());
                ArrayList<Byte> arrayList28 = this.f52900a;
                if (arrayList28 != null) {
                    arrayList28.addAll(arrayList27);
                }
                ArrayList<Byte> arrayList29 = this.f52900a;
                if (arrayList29 != null) {
                    arrayList29.addAll(ArraysKt___ArraysJvmKt.c(Utils.f52981j.o((int) crc327.getValue())));
                }
            } else if (Arrays.equals(i12, companion2.e())) {
                byte[] i15 = ArraysKt___ArraysJvmKt.i(bArr, 0, 4);
                ArrayList arrayList30 = new ArrayList(i15.length);
                for (byte valueOf4 : i15) {
                    arrayList30.add(Integer.valueOf(valueOf4));
                }
                int n14 = companion2.n(arrayList30);
                ArrayList<Byte> arrayList31 = this.f52900a;
                if (arrayList31 != null) {
                    arrayList31.addAll(ArraysKt___ArraysJvmKt.c(Utils.f52981j.o(n14 - 4)));
                }
                ArrayList arrayList32 = new ArrayList();
                arrayList32.addAll(ArraysKt___ArraysJvmKt.c(new byte[]{73, ISO7816.INS_REHABILITATE_CHV, 65, 84}));
                arrayList32.addAll(ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(bArr, 12, 8 + n14)));
                CRC32 crc328 = new CRC32();
                crc328.update(CollectionsKt___CollectionsKt.E0(arrayList32), 0, arrayList32.size());
                ArrayList<Byte> arrayList33 = this.f52900a;
                if (arrayList33 != null) {
                    arrayList33.addAll(arrayList32);
                }
                ArrayList<Byte> arrayList34 = this.f52900a;
                if (arrayList34 != null) {
                    arrayList34.addAll(ArraysKt___ArraysJvmKt.c(Utils.f52981j.o((int) crc328.getValue())));
                }
            } else if (Arrays.equals(i12, companion2.i())) {
                this.f52905f = bArr;
            } else if (Arrays.equals(i12, companion2.k())) {
                this.f52906g = bArr;
            } else if (Arrays.equals(i12, companion2.h())) {
                this.f52911l.d(bArr);
                this.f52907h = this.f52911l.c();
                this.f52908i = this.f52911l.b();
            } else if (Arrays.equals(i12, companion2.c())) {
                this.f52912m = true;
            }
        } else {
            throw new BadCRCException();
        }
    }

    public final void e() {
        this.f52900a = null;
        this.f52901b = null;
        this.f52902c = -1.0f;
        this.f52903d = -1;
        this.f52904e = -1;
        this.f52905f = null;
        this.f52906g = null;
        this.f52907h = 0;
        this.f52908i = 0;
        this.f52911l = new IHDR();
        this.f52913n = new Apng();
        this.f52912m = false;
    }
}
