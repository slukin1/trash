package com.sumsub.sns.presentation.screen.preview.photo;

import android.graphics.Bitmap;
import java.io.File;
import kotlin.jvm.internal.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap f39947a;

    /* renamed from: b  reason: collision with root package name */
    public final File f39948b;

    /* renamed from: c  reason: collision with root package name */
    public final int f39949c;

    public b(Bitmap bitmap, File file, int i11) {
        this.f39947a = bitmap;
        this.f39948b = file;
        this.f39949c = i11;
    }

    public final Bitmap a() {
        return this.f39947a;
    }

    public final File b() {
        return this.f39948b;
    }

    public final int c() {
        return this.f39949c;
    }

    public final File d() {
        return this.f39948b;
    }

    public final Bitmap e() {
        return this.f39947a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return x.b(this.f39947a, bVar.f39947a) && x.b(this.f39948b, bVar.f39948b) && this.f39949c == bVar.f39949c;
    }

    public final int f() {
        return this.f39949c;
    }

    public int hashCode() {
        int hashCode = this.f39947a.hashCode() * 31;
        File file = this.f39948b;
        return ((hashCode + (file == null ? 0 : file.hashCode())) * 31) + this.f39949c;
    }

    public String toString() {
        return "PhotoItem(photo=" + this.f39947a + ", file=" + this.f39948b + ", rotation=" + this.f39949c + ')';
    }

    public final b a(Bitmap bitmap, File file, int i11) {
        return new b(bitmap, file, i11);
    }

    public static /* synthetic */ b a(b bVar, Bitmap bitmap, File file, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            bitmap = bVar.f39947a;
        }
        if ((i12 & 2) != 0) {
            file = bVar.f39948b;
        }
        if ((i12 & 4) != 0) {
            i11 = bVar.f39949c;
        }
        return bVar.a(bitmap, file, i11);
    }
}
