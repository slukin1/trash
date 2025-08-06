package y;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import c0.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class e implements EncoderProfilesProvider {

    /* renamed from: a  reason: collision with root package name */
    public final EncoderProfilesProvider f16790a;

    /* renamed from: b  reason: collision with root package name */
    public final DynamicRange f16791b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, EncoderProfilesProxy> f16792c = new HashMap();

    public e(EncoderProfilesProvider encoderProfilesProvider, DynamicRange dynamicRange) {
        this.f16790a = encoderProfilesProvider;
        this.f16791b = dynamicRange;
    }

    public static EncoderProfilesProxy a(EncoderProfilesProxy encoderProfilesProxy, DynamicRange dynamicRange) {
        if (encoderProfilesProxy == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (EncoderProfilesProxy.VideoProfileProxy next : encoderProfilesProxy.getVideoProfiles()) {
            if (c(next, dynamicRange) && d(next, dynamicRange)) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), arrayList);
    }

    public static boolean c(EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, DynamicRange dynamicRange) {
        Set set = a.f12994a.get(Integer.valueOf(dynamicRange.getBitDepth()));
        return set != null && set.contains(Integer.valueOf(videoProfileProxy.getBitDepth()));
    }

    public static boolean d(EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, DynamicRange dynamicRange) {
        Set set = a.f12995b.get(Integer.valueOf(dynamicRange.getEncoding()));
        return set != null && set.contains(Integer.valueOf(videoProfileProxy.getHdrFormat()));
    }

    public final EncoderProfilesProxy b(int i11) {
        if (this.f16792c.containsKey(Integer.valueOf(i11))) {
            return this.f16792c.get(Integer.valueOf(i11));
        }
        if (!this.f16790a.hasProfile(i11)) {
            return null;
        }
        EncoderProfilesProxy a11 = a(this.f16790a.getAll(i11), this.f16791b);
        this.f16792c.put(Integer.valueOf(i11), a11);
        return a11;
    }

    public EncoderProfilesProxy getAll(int i11) {
        return b(i11);
    }

    public boolean hasProfile(int i11) {
        if (this.f16790a.hasProfile(i11) && b(i11) != null) {
            return true;
        }
        return false;
    }
}
