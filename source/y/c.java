package y;

import android.util.Rational;
import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.x;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.i1;
import androidx.camera.video.internal.encoder.l1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class c implements EncoderProfilesProvider {

    /* renamed from: d  reason: collision with root package name */
    public static final Function<EncoderProfilesProxy.VideoProfileProxy, EncoderProfilesProxy.VideoProfileProxy> f16785d = b.f61713a;

    /* renamed from: e  reason: collision with root package name */
    public static final Timebase f16786e = Timebase.UPTIME;

    /* renamed from: a  reason: collision with root package name */
    public final EncoderProfilesProvider f16787a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<EncoderProfilesProxy.VideoProfileProxy, EncoderProfilesProxy.VideoProfileProxy> f16788b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, EncoderProfilesProxy> f16789c = new HashMap();

    public c(EncoderProfilesProvider encoderProfilesProvider, Function<EncoderProfilesProxy.VideoProfileProxy, EncoderProfilesProxy.VideoProfileProxy> function) {
        this.f16787a = encoderProfilesProvider;
        this.f16788b = function;
    }

    public static int c(int i11) {
        if (i11 == 0 || i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
            return 5;
        }
        throw new IllegalArgumentException("Unexpected HDR format: " + i11);
    }

    public static String d(int i11) {
        return x.c(i11);
    }

    public static int e(int i11) {
        if (i11 == 0) {
            return 1;
        }
        if (i11 == 1) {
            return 2;
        }
        if (i11 == 2) {
            return 4096;
        }
        if (i11 == 3) {
            return 8192;
        }
        if (i11 == 4) {
            return -1;
        }
        throw new IllegalArgumentException("Unexpected HDR format: " + i11);
    }

    public static EncoderProfilesProxy.VideoProfileProxy f(EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, int i11, int i12) {
        if (videoProfileProxy == null) {
            return null;
        }
        int codec = videoProfileProxy.getCodec();
        String mediaType = videoProfileProxy.getMediaType();
        int profile = videoProfileProxy.getProfile();
        if (i11 != videoProfileProxy.getHdrFormat()) {
            codec = c(i11);
            mediaType = d(codec);
            profile = e(i11);
        }
        return EncoderProfilesProxy.VideoProfileProxy.create(codec, mediaType, i(videoProfileProxy.getBitrate(), i12, videoProfileProxy.getBitDepth()), videoProfileProxy.getFrameRate(), videoProfileProxy.getWidth(), videoProfileProxy.getHeight(), profile, i12, videoProfileProxy.getChromaSubsampling(), i11);
    }

    public static EncoderProfilesProxy.VideoProfileProxy h(EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, int i11) {
        return EncoderProfilesProxy.VideoProfileProxy.create(videoProfileProxy.getCodec(), videoProfileProxy.getMediaType(), i11, videoProfileProxy.getFrameRate(), videoProfileProxy.getWidth(), videoProfileProxy.getHeight(), videoProfileProxy.getProfile(), videoProfileProxy.getBitDepth(), videoProfileProxy.getChromaSubsampling(), videoProfileProxy.getHdrFormat());
    }

    public static int i(int i11, int i12, int i13) {
        if (i12 == i13) {
            return i11;
        }
        int doubleValue = (int) (((double) i11) * new Rational(i12, i13).doubleValue());
        if (Logger.isDebugEnabled("BackupHdrProfileEncoderProfilesProvider")) {
            Logger.d("BackupHdrProfileEncoderProfilesProvider", String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) = %d", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(doubleValue)}));
        }
        return doubleValue;
    }

    public static i1 j(EncoderProfilesProxy.VideoProfileProxy videoProfileProxy) {
        return i1.c().h(videoProfileProxy.getMediaType()).i(videoProfileProxy.getProfile()).j(new Size(videoProfileProxy.getWidth(), videoProfileProxy.getHeight())).e(videoProfileProxy.getFrameRate()).b(videoProfileProxy.getBitrate()).g(f16786e).a();
    }

    public static EncoderProfilesProxy.VideoProfileProxy k(EncoderProfilesProxy.VideoProfileProxy videoProfileProxy) {
        if (videoProfileProxy == null) {
            return null;
        }
        i1 j11 = j(videoProfileProxy);
        try {
            l1 j12 = l1.j(j11);
            int d11 = j11.d();
            int intValue = j12.b().clamp(Integer.valueOf(d11)).intValue();
            return intValue == d11 ? videoProfileProxy : h(videoProfileProxy, intValue);
        } catch (InvalidConfigException unused) {
            return null;
        }
    }

    public final EncoderProfilesProxy b(EncoderProfilesProxy encoderProfilesProxy, int i11, int i12) {
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy;
        if (encoderProfilesProxy == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(encoderProfilesProxy.getVideoProfiles());
        Iterator<EncoderProfilesProxy.VideoProfileProxy> it2 = encoderProfilesProxy.getVideoProfiles().iterator();
        while (true) {
            if (!it2.hasNext()) {
                videoProfileProxy = null;
                break;
            }
            videoProfileProxy = it2.next();
            if (videoProfileProxy.getHdrFormat() == 0) {
                break;
            }
        }
        EncoderProfilesProxy.VideoProfileProxy apply = this.f16788b.apply(f(videoProfileProxy, i11, i12));
        if (apply != null) {
            arrayList.add(apply);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), arrayList);
    }

    public final EncoderProfilesProxy g(int i11) {
        if (this.f16789c.containsKey(Integer.valueOf(i11))) {
            return this.f16789c.get(Integer.valueOf(i11));
        }
        if (!this.f16787a.hasProfile(i11)) {
            return null;
        }
        EncoderProfilesProxy b11 = b(this.f16787a.getAll(i11), 1, 10);
        this.f16789c.put(Integer.valueOf(i11), b11);
        return b11;
    }

    public EncoderProfilesProxy getAll(int i11) {
        return g(i11);
    }

    public boolean hasProfile(int i11) {
        if (this.f16787a.hasProfile(i11) && g(i11) != null) {
            return true;
        }
        return false;
    }
}
