package androidx.camera.video;

import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@AutoValue
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<Integer> f5908a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{2, 3, 4})));

    public static b d(int i11, Throwable th2, double d11) {
        return new d(i11, d11, th2);
    }

    public abstract double a();

    public abstract int b();

    public abstract Throwable c();
}
