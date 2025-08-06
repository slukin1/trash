package oupson.apng;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import oupson.apng.chunks.IDAT;
import oupson.apng.chunks.IHDR;
import oupson.apng.exceptions.NotPngException;
import oupson.apng.utils.Utils;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020&\u0012\b\b\u0002\u0010.\u001a\u00020\f\u0012\b\b\u0002\u00101\u001a\u00020\f\u0012\b\b\u0002\u0010>\u001a\u000209\u0012\b\b\u0002\u0010E\u001a\u00020?\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\f¢\u0006\u0004\bF\u0010GJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0017\u0010*\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b\u0013\u0010)R\"\u0010.\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010\r\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\"\u00101\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011R$\u00106\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b,\u00102\u001a\u0004\b+\u00103\"\u0004\b4\u00105R$\u00108\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b/\u00102\u001a\u0004\b'\u00103\"\u0004\b7\u00105R\"\u0010>\u001a\u0002098\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010:\u001a\u0004\b\u0006\u0010;\"\u0004\b<\u0010=R\"\u0010E\u001a\u00020?8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b\u0018\u0010B\"\u0004\bC\u0010D¨\u0006H"}, d2 = {"Loupson/apng/b;", "", "", "byteArray", "", "k", "a", "[B", "b", "()[B", "setByteArray", "([B)V", "", "I", "h", "()I", "setWidth", "(I)V", "width", "c", "e", "setHeight", "height", "Loupson/apng/chunks/IHDR;", "d", "Loupson/apng/chunks/IHDR;", "getIhdr", "()Loupson/apng/chunks/IHDR;", "setIhdr", "(Loupson/apng/chunks/IHDR;)V", "ihdr", "Loupson/apng/chunks/IDAT;", "Loupson/apng/chunks/IDAT;", "getIdat", "()Loupson/apng/chunks/IDAT;", "setIdat", "(Loupson/apng/chunks/IDAT;)V", "idat", "", "f", "F", "()F", "delay", "g", "i", "setXOffsets", "xOffsets", "j", "setYOffsets", "yOffsets", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setMaxWidth", "(Ljava/lang/Integer;)V", "maxWidth", "setMaxHeight", "maxHeight", "Loupson/apng/utils/Utils$Companion$BlendOp;", "Loupson/apng/utils/Utils$Companion$BlendOp;", "()Loupson/apng/utils/Utils$Companion$BlendOp;", "setBlendOp", "(Loupson/apng/utils/Utils$Companion$BlendOp;)V", "blendOp", "Loupson/apng/utils/Utils$Companion$DisposeOp;", "l", "Loupson/apng/utils/Utils$Companion$DisposeOp;", "()Loupson/apng/utils/Utils$Companion$DisposeOp;", "setDisposeOp", "(Loupson/apng/utils/Utils$Companion$DisposeOp;)V", "disposeOp", "<init>", "([BFIILoupson/apng/utils/Utils$Companion$BlendOp;Loupson/apng/utils/Utils$Companion$DisposeOp;Ljava/lang/Integer;Ljava/lang/Integer;)V", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f52935a;

    /* renamed from: b  reason: collision with root package name */
    public int f52936b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f52937c = -1;

    /* renamed from: d  reason: collision with root package name */
    public IHDR f52938d;

    /* renamed from: e  reason: collision with root package name */
    public IDAT f52939e;

    /* renamed from: f  reason: collision with root package name */
    public final float f52940f;

    /* renamed from: g  reason: collision with root package name */
    public int f52941g;

    /* renamed from: h  reason: collision with root package name */
    public int f52942h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f52943i;

    /* renamed from: j  reason: collision with root package name */
    public Integer f52944j;

    /* renamed from: k  reason: collision with root package name */
    public Utils.Companion.BlendOp f52945k;

    /* renamed from: l  reason: collision with root package name */
    public Utils.Companion.DisposeOp f52946l;

    public b(byte[] bArr, float f11, int i11, int i12, Utils.Companion.BlendOp blendOp, Utils.Companion.DisposeOp disposeOp, Integer num, Integer num2) {
        byte[] bArr2 = bArr;
        if (Utils.f52981j.m(bArr)) {
            this.f52935a = bArr2;
            int i13 = 8;
            while (i13 < bArr2.length) {
                Utils.Companion companion = Utils.f52981j;
                int i14 = i13 + 4;
                byte[] i15 = ArraysKt___ArraysJvmKt.i(bArr, i13, i14);
                ArrayList arrayList = new ArrayList(i15.length);
                for (byte valueOf : i15) {
                    arrayList.add(Integer.valueOf(valueOf));
                }
                k(ArraysKt___ArraysJvmKt.i(bArr, i13, companion.n(arrayList) + i13 + 12));
                Utils.Companion companion2 = Utils.f52981j;
                byte[] i16 = ArraysKt___ArraysJvmKt.i(bArr, i13, i14);
                ArrayList arrayList2 = new ArrayList(i16.length);
                for (byte valueOf2 : i16) {
                    arrayList2.add(Integer.valueOf(valueOf2));
                }
                i13 += companion2.n(arrayList2) + 12;
            }
            this.f52940f = f11;
            this.f52941g = i11;
            this.f52942h = i12;
            this.f52943i = num;
            this.f52944j = num2;
            this.f52945k = blendOp;
            this.f52946l = disposeOp;
            return;
        }
        throw new NotPngException();
    }

    public final Utils.Companion.BlendOp a() {
        return this.f52945k;
    }

    public final byte[] b() {
        return this.f52935a;
    }

    public final float c() {
        return this.f52940f;
    }

    public final Utils.Companion.DisposeOp d() {
        return this.f52946l;
    }

    public final int e() {
        return this.f52937c;
    }

    public final Integer f() {
        return this.f52944j;
    }

    public final Integer g() {
        return this.f52943i;
    }

    public final int h() {
        return this.f52936b;
    }

    public final int i() {
        return this.f52941g;
    }

    public final int j() {
        return this.f52942h;
    }

    public final void k(byte[] bArr) {
        byte[] i11 = ArraysKt___ArraysJvmKt.i(bArr, 4, 8);
        Utils.Companion companion = Utils.f52981j;
        if (Arrays.equals(i11, companion.h())) {
            IHDR ihdr = new IHDR();
            this.f52938d = ihdr;
            ihdr.d(bArr);
            this.f52936b = this.f52938d.c();
            this.f52937c = this.f52938d.b();
        } else if (Arrays.equals(i11, companion.f())) {
            IDAT idat = new IDAT();
            this.f52939e = idat;
            idat.a(bArr);
        }
    }
}
