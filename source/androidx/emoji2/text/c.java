package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.n;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.nio.ByteBuffer;
import k1.d;
import k1.h;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final MetadataList f9435a;

    /* renamed from: b  reason: collision with root package name */
    public final char[] f9436b;

    /* renamed from: c  reason: collision with root package name */
    public final a f9437c = new a(1024);

    /* renamed from: d  reason: collision with root package name */
    public final Typeface f9438d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final SparseArray<a> f9439a;

        /* renamed from: b  reason: collision with root package name */
        public d f9440b;

        public a() {
            this(1);
        }

        public a a(int i11) {
            SparseArray<a> sparseArray = this.f9439a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i11);
        }

        public final d b() {
            return this.f9440b;
        }

        public void c(d dVar, int i11, int i12) {
            a a11 = a(dVar.b(i11));
            if (a11 == null) {
                a11 = new a();
                this.f9439a.put(dVar.b(i11), a11);
            }
            if (i12 > i11) {
                a11.c(dVar, i11 + 1, i12);
            } else {
                a11.f9440b = dVar;
            }
        }

        public a(int i11) {
            this.f9439a = new SparseArray<>(i11);
        }
    }

    public c(Typeface typeface, MetadataList metadataList) {
        this.f9438d = typeface;
        this.f9435a = metadataList;
        this.f9436b = new char[(metadataList.k() * 2)];
        a(metadataList);
    }

    public static c b(Typeface typeface, ByteBuffer byteBuffer) throws IOException {
        try {
            n.a("EmojiCompat.MetadataRepo.create");
            return new c(typeface, h.b(byteBuffer));
        } finally {
            n.b();
        }
    }

    public final void a(MetadataList metadataList) {
        int k11 = metadataList.k();
        for (int i11 = 0; i11 < k11; i11++) {
            d dVar = new d(this, i11);
            Character.toChars(dVar.f(), this.f9436b, i11 * 2);
            h(dVar);
        }
    }

    public char[] c() {
        return this.f9436b;
    }

    public MetadataList d() {
        return this.f9435a;
    }

    public int e() {
        return this.f9435a.l();
    }

    public a f() {
        return this.f9437c;
    }

    public Typeface g() {
        return this.f9438d;
    }

    public void h(d dVar) {
        androidx.core.util.h.h(dVar, "emoji metadata cannot be null");
        androidx.core.util.h.b(dVar.c() > 0, "invalid metadata codepoint length");
        this.f9437c.c(dVar, 0, dVar.c() - 1);
    }
}
