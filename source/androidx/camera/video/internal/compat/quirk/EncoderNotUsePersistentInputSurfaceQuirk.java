package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;

public class EncoderNotUsePersistentInputSurfaceQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f6088a = Arrays.asList(new String[]{"SM-N9208", "SM-G920V"});

    public static boolean c() {
        return Build.VERSION.SDK_INT <= 22 || f6088a.contains(Build.MODEL.toUpperCase());
    }
}
