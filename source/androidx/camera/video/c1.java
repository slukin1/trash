package androidx.camera.video;

import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import java.util.ArrayList;
import java.util.List;

public interface c1 {

    /* renamed from: a  reason: collision with root package name */
    public static final c1 f5927a = new a();

    public class a implements c1 {
        public /* synthetic */ v a(Size size, DynamicRange dynamicRange) {
            return b1.b(this, size, dynamicRange);
        }

        public /* synthetic */ VideoValidatedEncoderProfilesProxy b(Size size, DynamicRange dynamicRange) {
            return b1.a(this, size, dynamicRange);
        }

        public List<v> c(DynamicRange dynamicRange) {
            return new ArrayList();
        }

        public /* synthetic */ VideoValidatedEncoderProfilesProxy d(v vVar, DynamicRange dynamicRange) {
            return b1.c(this, vVar, dynamicRange);
        }
    }

    v a(Size size, DynamicRange dynamicRange);

    VideoValidatedEncoderProfilesProxy b(Size size, DynamicRange dynamicRange);

    List<v> c(DynamicRange dynamicRange);

    VideoValidatedEncoderProfilesProxy d(v vVar, DynamicRange dynamicRange);
}
