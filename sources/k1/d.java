package k1;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.c;
import androidx.emoji2.text.flatbuffer.MetadataItem;

public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal<MetadataItem> f16017d = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    public final int f16018a;

    /* renamed from: b  reason: collision with root package name */
    public final c f16019b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f16020c = 0;

    public d(c cVar, int i11) {
        this.f16019b = cVar;
        this.f16018a = i11;
    }

    public void a(Canvas canvas, float f11, float f12, Paint paint) {
        Typeface g11 = this.f16019b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(g11);
        Canvas canvas2 = canvas;
        canvas2.drawText(this.f16019b.c(), this.f16018a * 2, 2, f11, f12, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i11) {
        return g().h(i11);
    }

    public int c() {
        return g().i();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int d() {
        return this.f16020c;
    }

    public short e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public final MetadataItem g() {
        ThreadLocal<MetadataItem> threadLocal = f16017d;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.f16019b.d().j(metadataItem, this.f16018a);
        return metadataItem;
    }

    public short h() {
        return g().m();
    }

    public short i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void k(boolean z11) {
        this.f16020c = z11 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        sb2.append(Integer.toHexString(f()));
        sb2.append(", codepoints:");
        int c11 = c();
        for (int i11 = 0; i11 < c11; i11++) {
            sb2.append(Integer.toHexString(b(i11)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
