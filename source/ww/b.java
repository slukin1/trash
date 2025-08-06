package ww;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f26321a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f26322b;

    public b(int i11, byte[] bArr) {
        this.f26321a = i11;
        this.f26322b = bArr;
    }

    public int a() {
        return this.f26321a;
    }

    public String b() {
        byte[] bArr = this.f26322b;
        if (bArr == null) {
            return null;
        }
        return new String(bArr);
    }
}
