package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ResizeLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private OnResizeListener f13407a;

    public interface OnResizeListener {
        void OnResize(int i11, int i12, int i13, int i14);
    }

    public ResizeLayout(Context context) {
        super(context);
    }

    public void a(OnResizeListener onResizeListener) {
        this.f13407a = onResizeListener;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        OnResizeListener onResizeListener = this.f13407a;
        if (onResizeListener != null) {
            onResizeListener.OnResize(i11, i12, i13, i14);
        }
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
