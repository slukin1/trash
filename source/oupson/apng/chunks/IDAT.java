package oupson.apng.chunks;

import java.util.ArrayList;
import kotlin.Metadata;
import oupson.apng.utils.Utils;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R8\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u00078\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0005\u0010\b\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Loupson/apng/chunks/IDAT;", "", "", "byteArray", "", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getIDATBody", "()Ljava/util/ArrayList;", "setIDATBody", "(Ljava/util/ArrayList;)V", "getIDATBody$annotations", "()V", "IDATBody", "b", "[B", "getBody", "()[B", "setBody", "([B)V", "body", "<init>", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class IDAT {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<byte[]> f52947a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public byte[] f52948b = new byte[0];

    public void a(byte[] bArr) {
        if (bArr[4] == ((byte) 73) && bArr[5] == ((byte) 68) && bArr[6] == ((byte) 65) && bArr[7] == ((byte) 84)) {
            Utils.Companion companion = Utils.f52981j;
            byte[] i11 = ArraysKt___ArraysJvmKt.i(bArr, 0, 4);
            ArrayList arrayList = new ArrayList(i11.length);
            for (byte valueOf : i11) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            this.f52947a.add(ArraysKt___ArraysJvmKt.i(bArr, 8, companion.n(arrayList) + 8));
        }
    }
}
