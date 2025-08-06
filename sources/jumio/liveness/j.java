package jumio.liveness;

import android.graphics.Rect;
import com.fluttercandies.photo_manager.core.entity.a;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import kotlin.jvm.internal.x;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final long f56481a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageSource f56482b;

    /* renamed from: c  reason: collision with root package name */
    public final Frame.MetaData f56483c;

    /* renamed from: d  reason: collision with root package name */
    public final PreviewProperties f56484d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f56485e;

    public j(long j11, ImageSource imageSource, Frame.MetaData metaData, PreviewProperties previewProperties, Rect rect) {
        this.f56481a = j11;
        this.f56482b = imageSource;
        this.f56483c = metaData;
        this.f56484d = previewProperties;
        this.f56485e = rect;
    }

    public final void a() {
        this.f56482b.delete();
    }

    public final Rect b() {
        return this.f56485e;
    }

    public final ImageSource c() {
        return this.f56482b;
    }

    public final Frame.MetaData d() {
        return this.f56483c;
    }

    public final PreviewProperties e() {
        return this.f56484d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f56481a == jVar.f56481a && x.b(this.f56482b, jVar.f56482b) && x.b(this.f56483c, jVar.f56483c) && x.b(this.f56484d, jVar.f56484d) && x.b(this.f56485e, jVar.f56485e);
    }

    public final long f() {
        return this.f56481a;
    }

    public final int hashCode() {
        int hashCode = this.f56482b.hashCode();
        int hashCode2 = this.f56483c.hashCode();
        int hashCode3 = this.f56484d.hashCode();
        return this.f56485e.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (a.a(this.f56481a) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        long j11 = this.f56481a;
        ImageSource imageSource = this.f56482b;
        Frame.MetaData metaData = this.f56483c;
        PreviewProperties previewProperties = this.f56484d;
        Rect rect = this.f56485e;
        return "LivenessFrame(timestamp=" + j11 + ", imageSource=" + imageSource + ", metadata=" + metaData + ", previewProperties=" + previewProperties + ", extractionArea=" + rect + ")";
    }
}
