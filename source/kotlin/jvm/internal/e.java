package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.FloatIterator;

public final class e extends FloatIterator {

    /* renamed from: b  reason: collision with root package name */
    public final float[] f56775b;

    /* renamed from: c  reason: collision with root package name */
    public int f56776c;

    public e(float[] fArr) {
        this.f56775b = fArr;
    }

    public float a() {
        try {
            float[] fArr = this.f56775b;
            int i11 = this.f56776c;
            this.f56776c = i11 + 1;
            return fArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f56776c--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    public boolean hasNext() {
        return this.f56776c < this.f56775b.length;
    }
}
