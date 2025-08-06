package y3;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import l3.a;

public final class b implements a.C0722a {

    /* renamed from: a  reason: collision with root package name */
    public final e f66673a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f66674b;

    public b(e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f66673a = eVar;
        this.f66674b = bVar;
    }

    public byte[] a(int i11) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f66674b;
        if (bVar == null) {
            return new byte[i11];
        }
        return (byte[]) bVar.c(i11, byte[].class);
    }

    public Bitmap b(int i11, int i12, Bitmap.Config config) {
        return this.f66673a.e(i11, i12, config);
    }

    public void c(Bitmap bitmap) {
        this.f66673a.c(bitmap);
    }

    public int[] d(int i11) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f66674b;
        if (bVar == null) {
            return new int[i11];
        }
        return (int[]) bVar.c(i11, int[].class);
    }

    public void e(byte[] bArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f66674b;
        if (bVar != null) {
            bVar.put(bArr);
        }
    }

    public void f(int[] iArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f66674b;
        if (bVar != null) {
            bVar.put(iArr);
        }
    }
}
