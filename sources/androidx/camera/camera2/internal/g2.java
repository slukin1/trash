package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.util.Size;
import android.view.Display;
import androidx.camera.camera2.internal.compat.workaround.DisplaySizeCorrector;
import androidx.camera.camera2.internal.compat.workaround.MaxPreviewSize;
import androidx.camera.core.internal.utils.SizeUtil;
import com.sumsub.sns.internal.ml.autocapture.b;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;

public class g2 {

    /* renamed from: e  reason: collision with root package name */
    public static final Size f5119e = new Size(1920, 1080);

    /* renamed from: f  reason: collision with root package name */
    public static final Size f5120f = new Size(320, 240);

    /* renamed from: g  reason: collision with root package name */
    public static final Size f5121g = new Size(b.f34944a, TXVodDownloadDataSource.QUALITY_480P);

    /* renamed from: h  reason: collision with root package name */
    public static final Object f5122h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public static volatile g2 f5123i;

    /* renamed from: a  reason: collision with root package name */
    public final DisplayManager f5124a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Size f5125b = null;

    /* renamed from: c  reason: collision with root package name */
    public final MaxPreviewSize f5126c = new MaxPreviewSize();

    /* renamed from: d  reason: collision with root package name */
    public final DisplaySizeCorrector f5127d = new DisplaySizeCorrector();

    public g2(Context context) {
        this.f5124a = (DisplayManager) context.getSystemService("display");
    }

    public static g2 c(Context context) {
        if (f5123i == null) {
            synchronized (f5122h) {
                if (f5123i == null) {
                    f5123i = new g2(context);
                }
            }
        }
        return f5123i;
    }

    public final Size a() {
        Size b11 = b();
        int width = b11.getWidth() * b11.getHeight();
        Size size = f5119e;
        if (width > size.getWidth() * size.getHeight()) {
            b11 = size;
        }
        return this.f5126c.a(b11);
    }

    public final Size b() {
        Point point = new Point();
        d(false).getRealSize(point);
        Size size = new Size(point.x, point.y);
        if (SizeUtil.isSmallerByArea(size, f5120f) && (size = this.f5127d.a()) == null) {
            size = f5121g;
        }
        return size.getHeight() > size.getWidth() ? new Size(size.getHeight(), size.getWidth()) : size;
    }

    public Display d(boolean z11) {
        Display[] displays = this.f5124a.getDisplays();
        if (displays.length == 1) {
            return displays[0];
        }
        Display e11 = e(displays, z11);
        if (e11 == null && z11) {
            e11 = e(displays, false);
        }
        if (e11 != null) {
            return e11;
        }
        throw new IllegalArgumentException("No display can be found from the input display manager!");
    }

    public final Display e(Display[] displayArr, boolean z11) {
        Display display = null;
        int i11 = -1;
        for (Display display2 : displayArr) {
            if (!z11 || display2.getState() != 1) {
                Point point = new Point();
                display2.getRealSize(point);
                int i12 = point.x;
                int i13 = point.y;
                if (i12 * i13 > i11) {
                    display = display2;
                    i11 = i12 * i13;
                }
            }
        }
        return display;
    }

    public Size f() {
        if (this.f5125b != null) {
            return this.f5125b;
        }
        this.f5125b = a();
        return this.f5125b;
    }

    public void g() {
        this.f5125b = a();
    }
}
