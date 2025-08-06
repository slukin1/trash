package androidx.camera.video;

import android.util.Range;
import androidx.camera.video.n;
import com.google.auto.value.AutoValue;
import java.util.Arrays;

@AutoValue
public abstract class w1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Range<Integer> f6383a = new Range<>(0, Integer.MAX_VALUE);

    /* renamed from: b  reason: collision with root package name */
    public static final Range<Integer> f6384b = new Range<>(0, Integer.MAX_VALUE);

    /* renamed from: c  reason: collision with root package name */
    public static final y f6385c;

    @AutoValue.Builder
    public static abstract class a {
        public abstract w1 a();

        public abstract a b(int i11);

        public abstract a c(Range<Integer> range);

        public abstract a d(Range<Integer> range);

        public abstract a e(y yVar);
    }

    static {
        v vVar = v.f6367c;
        f6385c = y.e(Arrays.asList(new v[]{vVar, v.f6366b, v.f6365a}), o.a(vVar));
    }

    public static a a() {
        return new n.b().e(f6385c).d(f6383a).c(f6384b).b(-1);
    }

    public abstract int b();

    public abstract Range<Integer> c();

    public abstract Range<Integer> d();

    public abstract y e();

    public abstract a f();
}
