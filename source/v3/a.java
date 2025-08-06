package v3;

import com.bumptech.glide.load.engine.r;
import f4.h;

public class a implements r<byte[]> {

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f66656b;

    public a(byte[] bArr) {
        this.f66656b = (byte[]) h.d(bArr);
    }

    public Class<byte[]> a() {
        return byte[].class;
    }

    /* renamed from: b */
    public byte[] get() {
        return this.f66656b;
    }

    public int getSize() {
        return this.f66656b.length;
    }

    public void recycle() {
    }
}
