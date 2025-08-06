package t00;

import android.graphics.Rect;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.io.File;
import jumio.core.x0;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x0 f29290b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageSource f29291c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PreviewProperties f29292d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Frame.MetaData f29293e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Rect f29294f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ File f29295g;

    public /* synthetic */ c(x0 x0Var, ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect, File file) {
        this.f29290b = x0Var;
        this.f29291c = imageSource;
        this.f29292d = previewProperties;
        this.f29293e = metaData;
        this.f29294f = rect;
        this.f29295g = file;
    }

    public final void run() {
        x0.a(this.f29290b, this.f29291c, this.f29292d, this.f29293e, this.f29294f, this.f29295g);
    }
}
