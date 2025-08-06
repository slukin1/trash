package oupson.apng;

import android.graphics.Bitmap;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R2\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Loupson/apng/Apng;", "", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "e", "(Landroid/graphics/Bitmap;)V", "cover", "Ljava/util/ArrayList;", "Loupson/apng/b;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setFrames", "(Ljava/util/ArrayList;)V", "frames", "", "c", "Z", "()Z", "d", "(Z)V", "isApng", "<init>", "()V", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class Apng {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f52914a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f52915b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f52916c = true;

    public final Bitmap a() {
        return this.f52914a;
    }

    public final ArrayList<b> b() {
        return this.f52915b;
    }

    public final boolean c() {
        return this.f52916c;
    }

    public final void d(boolean z11) {
        this.f52916c = z11;
    }

    public final void e(Bitmap bitmap) {
        this.f52914a = bitmap;
    }
}
