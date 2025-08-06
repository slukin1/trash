package androidx.camera.video;

import android.util.Range;
import androidx.camera.video.c;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Range<Integer> f5902a = new Range<>(0, Integer.MAX_VALUE);

    /* renamed from: b  reason: collision with root package name */
    public static final Range<Integer> f5903b = new Range<>(0, Integer.MAX_VALUE);

    /* renamed from: c  reason: collision with root package name */
    public static final a f5904c = a().c(0).a();

    @AutoValue.Builder
    /* renamed from: androidx.camera.video.a$a  reason: collision with other inner class name */
    public static abstract class C0009a {
        public abstract a a();

        public abstract C0009a b(Range<Integer> range);

        public abstract C0009a c(int i11);

        public abstract C0009a d(Range<Integer> range);

        public abstract C0009a e(int i11);
    }

    public static C0009a a() {
        return new c.b().f(-1).e(-1).c(-1).b(f5902a).d(f5903b);
    }

    public abstract Range<Integer> b();

    public abstract int c();

    public abstract Range<Integer> d();

    public abstract int e();

    public abstract int f();
}
