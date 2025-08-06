package oupson.apng.chunks;

import java.util.ArrayList;
import kotlin.Metadata;
import oupson.apng.utils.Utils;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\r\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Loupson/apng/chunks/IHDR;", "", "", "byteArray", "", "d", "a", "[B", "()[B", "e", "([B)V", "body", "", "b", "I", "c", "()I", "setPngWidth", "(I)V", "pngWidth", "setPngHeight", "pngHeight", "<init>", "()V", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class IHDR {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f52949a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public int f52950b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f52951c = -1;

    public byte[] a() {
        return this.f52949a;
    }

    public final int b() {
        return this.f52951c;
    }

    public final int c() {
        return this.f52950b;
    }

    public void d(byte[] bArr) {
        int length = bArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (bArr[i11] == ((byte) 73) && bArr[i11 + 1] == ((byte) 72) && bArr[i11 + 2] == ((byte) 68) && bArr[i11 + 3] == ((byte) 82)) {
                Utils.Companion companion = Utils.f52981j;
                byte[] i12 = ArraysKt___ArraysJvmKt.i(bArr, i11 - 4, i11);
                ArrayList arrayList = new ArrayList(i12.length);
                for (byte valueOf : i12) {
                    arrayList.add(Integer.valueOf(valueOf));
                }
                int n11 = companion.n(arrayList);
                Utils.Companion companion2 = Utils.f52981j;
                int i13 = i11 + 4;
                int i14 = i11 + 8;
                byte[] i15 = ArraysKt___ArraysJvmKt.i(bArr, i13, i14);
                ArrayList arrayList2 = new ArrayList(i15.length);
                for (byte valueOf2 : i15) {
                    arrayList2.add(Integer.valueOf(valueOf2));
                }
                this.f52950b = companion2.n(arrayList2);
                Utils.Companion companion3 = Utils.f52981j;
                byte[] i16 = ArraysKt___ArraysJvmKt.i(bArr, i14, i11 + 12);
                ArrayList arrayList3 = new ArrayList(i16.length);
                for (byte valueOf3 : i16) {
                    arrayList3.add(Integer.valueOf(valueOf3));
                }
                this.f52951c = companion3.n(arrayList3);
                e(ArraysKt___ArraysJvmKt.i(bArr, i13, n11 + i11 + 4));
            }
        }
    }

    public void e(byte[] bArr) {
        this.f52949a = bArr;
    }
}
