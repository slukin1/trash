package androidx.camera.camera2.internal;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import androidx.camera.camera2.internal.compat.quirk.InvalidVideoProfilesQuirk;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.compat.EncoderProfilesProxyCompat;
import java.util.HashMap;
import java.util.Map;
import q.d;

public class m1 implements EncoderProfilesProvider {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5199a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5200b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5201c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Integer, EncoderProfilesProxy> f5202d = new HashMap();

    public static class a {
        public static EncoderProfiles a(String str, int i11) {
            return CamcorderProfile.getAll(str, i11);
        }
    }

    public m1(String str) {
        int i11;
        boolean z11;
        this.f5200b = str;
        try {
            i11 = Integer.parseInt(str);
            z11 = true;
        } catch (NumberFormatException unused) {
            Logger.w("Camera2EncoderProfilesProvider", "Camera id is not an integer: " + str + ", unable to create Camera2EncoderProfilesProvider");
            z11 = false;
            i11 = -1;
        }
        this.f5199a = z11;
        this.f5201c = i11;
    }

    public final EncoderProfilesProxy a(int i11) {
        CamcorderProfile camcorderProfile;
        try {
            camcorderProfile = CamcorderProfile.get(this.f5201c, i11);
        } catch (RuntimeException e11) {
            Logger.w("Camera2EncoderProfilesProvider", "Unable to get CamcorderProfile by quality: " + i11, e11);
            camcorderProfile = null;
        }
        if (camcorderProfile != null) {
            return EncoderProfilesProxyCompat.from(camcorderProfile);
        }
        return null;
    }

    public final EncoderProfilesProxy b(int i11) {
        if (Build.VERSION.SDK_INT >= 31) {
            EncoderProfiles a11 = a.a(this.f5200b, i11);
            if (a11 == null) {
                return null;
            }
            if (d.a(InvalidVideoProfilesQuirk.class) != null) {
                Logger.d("Camera2EncoderProfilesProvider", "EncoderProfiles contains invalid video profiles, use CamcorderProfile to create EncoderProfilesProxy.");
            } else {
                try {
                    return EncoderProfilesProxyCompat.from(a11);
                } catch (NullPointerException e11) {
                    Logger.w("Camera2EncoderProfilesProvider", "Failed to create EncoderProfilesProxy, EncoderProfiles might  contain invalid video profiles. Use CamcorderProfile instead.", e11);
                }
            }
        }
        return a(i11);
    }

    public EncoderProfilesProxy getAll(int i11) {
        if (!this.f5199a || !CamcorderProfile.hasProfile(this.f5201c, i11)) {
            return null;
        }
        if (this.f5202d.containsKey(Integer.valueOf(i11))) {
            return this.f5202d.get(Integer.valueOf(i11));
        }
        EncoderProfilesProxy b11 = b(i11);
        this.f5202d.put(Integer.valueOf(i11), b11);
        return b11;
    }

    public boolean hasProfile(int i11) {
        if (!this.f5199a) {
            return false;
        }
        return CamcorderProfile.hasProfile(this.f5201c, i11);
    }
}
