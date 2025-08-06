package ly;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import ky.h;
import ky.j;

@SuppressLint({"RestrictedApi"})
public class d implements h {

    /* renamed from: b  reason: collision with root package name */
    public View f37228b;

    /* renamed from: c  reason: collision with root package name */
    public SpinnerStyle f37229c;

    public d(View view) {
        this.f37228b = view;
    }

    public SpinnerStyle getSpinnerStyle() {
        int i11;
        View view = this.f37228b;
        if (view instanceof h) {
            return ((h) view).getSpinnerStyle();
        }
        SpinnerStyle spinnerStyle = this.f37229c;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
            SpinnerStyle spinnerStyle2 = ((SmartRefreshLayout.LayoutParams) layoutParams).f29772b;
            this.f37229c = spinnerStyle2;
            if (spinnerStyle2 != null) {
                return spinnerStyle2;
            }
        }
        if (layoutParams == null || !((i11 = layoutParams.height) == 0 || i11 == -1)) {
            SpinnerStyle spinnerStyle3 = SpinnerStyle.Translate;
            this.f37229c = spinnerStyle3;
            return spinnerStyle3;
        }
        SpinnerStyle spinnerStyle4 = SpinnerStyle.Scale;
        this.f37229c = spinnerStyle4;
        return spinnerStyle4;
    }

    public View getView() {
        return this.f37228b;
    }

    public boolean isSupportHorizontalDrag() {
        View view = this.f37228b;
        return (view instanceof h) && ((h) view).isSupportHorizontalDrag();
    }

    public int onFinish(j jVar, boolean z11) {
        View view = this.f37228b;
        if (view instanceof h) {
            return ((h) view).onFinish(jVar, z11);
        }
        return 0;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
        View view = this.f37228b;
        if (view instanceof h) {
            ((h) view).onHorizontalDrag(f11, i11, i12);
        }
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        View view = this.f37228b;
        if (view instanceof h) {
            ((h) view).onPulling(f11, i11, i12, i13);
        }
    }

    public void onReleased(j jVar, int i11, int i12) {
        View view = this.f37228b;
        if (view instanceof h) {
            ((h) view).onReleased(jVar, i11, i12);
        }
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
        View view = this.f37228b;
        if (view instanceof h) {
            ((h) view).onReleasing(f11, i11, i12, i13);
        }
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
        View view = this.f37228b;
        if (view instanceof h) {
            ((h) view).onStartAnimator(jVar, i11, i12);
        }
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        View view = this.f37228b;
        if (view instanceof h) {
            ((h) view).onStateChanged(jVar, refreshState, refreshState2);
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        View view = this.f37228b;
        if (view instanceof h) {
            ((h) view).setPrimaryColors(iArr);
        }
    }
}
