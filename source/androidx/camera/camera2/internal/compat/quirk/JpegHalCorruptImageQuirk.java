package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import o.y;

public final class JpegHalCorruptImageQuirk implements SoftwareJpegEncodingPreferredQuirk {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f5061a = new HashSet(Arrays.asList(new String[]{"heroqltevzw", "heroqltetmo", "k61v1_basic_ref"}));

    public static boolean c(y yVar) {
        return f5061a.contains(Build.DEVICE.toLowerCase(Locale.US));
    }
}
