package jumio.core;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.jumio.commons.camera.CameraManagerInterface;

public final class p implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public int f56291a;

    /* renamed from: b  reason: collision with root package name */
    public int f56292b;

    /* renamed from: c  reason: collision with root package name */
    public int f56293c;

    /* renamed from: d  reason: collision with root package name */
    public CameraManagerInterface f56294d;

    /* renamed from: e  reason: collision with root package name */
    public View f56295e;

    public final void a() {
        ViewTreeObserver viewTreeObserver;
        View view = this.f56295e;
        if (!(view == null || (viewTreeObserver = view.getViewTreeObserver()) == null)) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
        this.f56295e = null;
        this.f56294d = null;
    }

    public final void onGlobalLayout() {
        int i11;
        CameraManagerInterface cameraManagerInterface;
        View view = this.f56295e;
        if (view != null) {
            try {
                i11 = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            } catch (Exception unused) {
                i11 = 0;
            }
            if (view.getHeight() != this.f56292b && view.getWidth() != this.f56291a) {
                view.requestLayout();
            } else if (!(i11 == this.f56293c || (cameraManagerInterface = this.f56294d) == null)) {
                cameraManagerInterface.reinitCamera();
            }
            this.f56291a = view.getWidth();
            this.f56292b = view.getHeight();
            this.f56293c = i11;
        }
    }
}
