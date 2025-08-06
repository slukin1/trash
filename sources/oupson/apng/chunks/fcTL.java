package oupson.apng.chunks;

import java.util.ArrayList;
import kotlin.Metadata;
import oupson.apng.utils.Utils;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u000e\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\"\u0010$\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\"\u0010*\u001a\u00020%8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010&\u001a\u0004\b\u0006\u0010'\"\u0004\b(\u0010)R\"\u00100\u001a\u00020+8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010,\u001a\u0004\b\u0015\u0010-\"\u0004\b.\u0010/¨\u00063"}, d2 = {"Loupson/apng/chunks/fcTL;", "", "", "byteArray", "", "h", "a", "[B", "getBody", "()[B", "i", "([B)V", "body", "", "b", "I", "e", "()I", "setPngWidth", "(I)V", "pngWidth", "c", "d", "setPngHeight", "pngHeight", "", "F", "()F", "setDelay", "(F)V", "delay", "f", "setXOffset", "xOffset", "g", "setYOffset", "yOffset", "Loupson/apng/utils/Utils$Companion$BlendOp;", "Loupson/apng/utils/Utils$Companion$BlendOp;", "()Loupson/apng/utils/Utils$Companion$BlendOp;", "setBlendOp", "(Loupson/apng/utils/Utils$Companion$BlendOp;)V", "blendOp", "Loupson/apng/utils/Utils$Companion$DisposeOp;", "Loupson/apng/utils/Utils$Companion$DisposeOp;", "()Loupson/apng/utils/Utils$Companion$DisposeOp;", "setDisposeOp", "(Loupson/apng/utils/Utils$Companion$DisposeOp;)V", "disposeOp", "<init>", "()V", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class fcTL {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f52952a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public int f52953b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f52954c = -1;

    /* renamed from: d  reason: collision with root package name */
    public float f52955d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public int f52956e;

    /* renamed from: f  reason: collision with root package name */
    public int f52957f;

    /* renamed from: g  reason: collision with root package name */
    public Utils.Companion.BlendOp f52958g = Utils.Companion.BlendOp.APNG_BLEND_OP_SOURCE;

    /* renamed from: h  reason: collision with root package name */
    public Utils.Companion.DisposeOp f52959h = Utils.Companion.DisposeOp.APNG_DISPOSE_OP_NONE;

    public final Utils.Companion.BlendOp a() {
        return this.f52958g;
    }

    public final float b() {
        return this.f52955d;
    }

    public final Utils.Companion.DisposeOp c() {
        return this.f52959h;
    }

    public final int d() {
        return this.f52954c;
    }

    public final int e() {
        return this.f52953b;
    }

    public final int f() {
        return this.f52956e;
    }

    public final int g() {
        return this.f52957f;
    }

    public void h(byte[] bArr) {
        if (bArr[4] == ((byte) 102) && bArr[5] == ((byte) 99) && bArr[6] == ((byte) 84) && bArr[7] == ((byte) 76)) {
            Utils.Companion companion = Utils.f52981j;
            byte[] i11 = ArraysKt___ArraysJvmKt.i(bArr, 0, 5);
            ArrayList arrayList = new ArrayList(i11.length);
            for (byte valueOf : i11) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            int n11 = companion.n(arrayList);
            Utils.Companion companion2 = Utils.f52981j;
            byte[] i12 = ArraysKt___ArraysJvmKt.i(bArr, 12, 16);
            ArrayList arrayList2 = new ArrayList(i12.length);
            for (byte valueOf2 : i12) {
                arrayList2.add(Integer.valueOf(valueOf2));
            }
            this.f52953b = companion2.n(arrayList2);
            Utils.Companion companion3 = Utils.f52981j;
            byte[] i13 = ArraysKt___ArraysJvmKt.i(bArr, 16, 20);
            ArrayList arrayList3 = new ArrayList(i13.length);
            for (byte valueOf3 : i13) {
                arrayList3.add(Integer.valueOf(valueOf3));
            }
            this.f52954c = companion3.n(arrayList3);
            Utils.Companion companion4 = Utils.f52981j;
            byte[] i14 = ArraysKt___ArraysJvmKt.i(bArr, 28, 30);
            ArrayList arrayList4 = new ArrayList(i14.length);
            for (byte valueOf4 : i14) {
                arrayList4.add(Integer.valueOf(valueOf4));
            }
            float p11 = (float) companion4.p(arrayList4);
            Utils.Companion companion5 = Utils.f52981j;
            byte[] i15 = ArraysKt___ArraysJvmKt.i(bArr, 30, 32);
            ArrayList arrayList5 = new ArrayList(i15.length);
            for (byte valueOf5 : i15) {
                arrayList5.add(Integer.valueOf(valueOf5));
            }
            float p12 = (float) companion5.p(arrayList5);
            if (p12 == 0.0f) {
                p12 = 100.0f;
            }
            this.f52955d = (p11 / p12) * ((float) 1000);
            Utils.Companion companion6 = Utils.f52981j;
            byte[] i16 = ArraysKt___ArraysJvmKt.i(bArr, 20, 24);
            ArrayList arrayList6 = new ArrayList(i16.length);
            for (byte valueOf6 : i16) {
                arrayList6.add(Integer.valueOf(valueOf6));
            }
            this.f52956e = companion6.n(arrayList6);
            Utils.Companion companion7 = Utils.f52981j;
            byte[] i17 = ArraysKt___ArraysJvmKt.i(bArr, 24, 28);
            ArrayList arrayList7 = new ArrayList(i17.length);
            for (byte valueOf7 : i17) {
                arrayList7.add(Integer.valueOf(valueOf7));
            }
            this.f52957f = companion7.n(arrayList7);
            i(ArraysKt___ArraysJvmKt.i(bArr, 8, n11 + 4 + 4));
            Utils.Companion companion8 = Utils.f52981j;
            this.f52958g = companion8.a(bArr[33]);
            this.f52959h = companion8.b(bArr[32]);
        }
    }

    public void i(byte[] bArr) {
        this.f52952a = bArr;
    }
}
