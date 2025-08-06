package androidx.camera.video.internal.compat.quirk;

import android.media.MediaFormat;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class MediaCodecInfoReportIncorrectInfoQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f6089a = Arrays.asList(new String[]{"lg-k430", "redmi note 4", "m2003j15sc", "rmx3231", "v2117", "sm-a032f", "moto g(20)", "sm-a035m"});

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final MediaFormat f6090a;

        public a(MediaFormat mediaFormat) {
            this.f6090a = mediaFormat;
        }

        public final String a() {
            return this.f6090a.getString("mime");
        }

        public boolean b() {
            return "video/avc".equalsIgnoreCase(a());
        }

        public boolean c() {
            return MimeTypes.VIDEO_MP4V.equalsIgnoreCase(a());
        }

        public boolean d(int i11, int i12) {
            return this.f6090a.getInteger("width") == i11 && this.f6090a.getInteger("height") == i12;
        }

        public boolean e() {
            String a11 = a();
            return a11 != null && a11.contains("video/");
        }
    }

    public static Set<Size> c() {
        if (d()) {
            return Collections.singleton(new Size(1920, 1080));
        }
        return Collections.emptySet();
    }

    public static boolean d() {
        return f6089a.contains(Build.MODEL.toLowerCase(Locale.US));
    }

    public static boolean e() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "mha-l29".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean f() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto c".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean g() {
        return "Nokia".equalsIgnoreCase(Build.BRAND) && "Nokia 1".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean h() {
        return "positivo".equalsIgnoreCase(Build.BRAND) && "twist 2 pro".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean i() {
        return "Redmi".equalsIgnoreCase(Build.BRAND) && "Redmi Note 8 Pro".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean k() {
        return "LGE".equalsIgnoreCase(Build.BRAND) && "LG-X230".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean l() {
        return "infinix".equalsIgnoreCase(Build.BRAND) && "infinix x650".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean m() {
        return g() || f() || l() || k() || e() || i() || h() || d();
    }

    public boolean j(MediaFormat mediaFormat) {
        a aVar = new a(mediaFormat);
        if (g() || f() || l() || k() || h()) {
            return aVar.c();
        }
        if (e() || i()) {
            if (!aVar.e() || !aVar.d(3840, 2160)) {
                return false;
            }
            return true;
        } else if (!d()) {
            return false;
        } else {
            if (!aVar.b() || !aVar.d(1920, 1080)) {
                return false;
            }
            return true;
        }
    }
}
