package androidx.camera.video.internal.audio;

import android.annotation.SuppressLint;
import androidx.camera.video.internal.audio.s;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AutoValue
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final List<Integer> f6004a = Collections.unmodifiableList(Arrays.asList(new Integer[]{48000, 44100, 22050, 11025, 8000, 4800}));

    @AutoValue.Builder
    /* renamed from: androidx.camera.video.internal.audio.a$a  reason: collision with other inner class name */
    public static abstract class C0010a {
        public abstract a a();

        public final a b() {
            a a11 = a();
            String str = "";
            if (a11.c() == -1) {
                str = str + " audioSource";
            }
            if (a11.f() <= 0) {
                str = str + " sampleRate";
            }
            if (a11.e() <= 0) {
                str = str + " channelCount";
            }
            if (a11.b() == -1) {
                str = str + " audioFormat";
            }
            if (str.isEmpty()) {
                return a11;
            }
            throw new IllegalArgumentException("Required settings missing or non-positive:" + str);
        }

        public abstract C0010a c(int i11);

        public abstract C0010a d(int i11);

        public abstract C0010a e(int i11);

        public abstract C0010a f(int i11);
    }

    @SuppressLint({"Range"})
    public static C0010a a() {
        return new s.b().d(-1).f(-1).e(-1).c(-1);
    }

    public abstract int b();

    public abstract int c();

    public int d() {
        return r.e(b(), e());
    }

    public abstract int e();

    public abstract int f();
}
