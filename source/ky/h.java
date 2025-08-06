package ky;

import android.view.View;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import ny.e;

public interface h extends e {
    SpinnerStyle getSpinnerStyle();

    View getView();

    boolean isSupportHorizontalDrag();

    int onFinish(j jVar, boolean z11);

    void onHorizontalDrag(float f11, int i11, int i12);

    void onInitialized(i iVar, int i11, int i12);

    void onPulling(float f11, int i11, int i12, int i13);

    void onReleased(j jVar, int i11, int i12);

    void onReleasing(float f11, int i11, int i12, int i13);

    void onStartAnimator(j jVar, int i11, int i12);

    void setPrimaryColors(int... iArr);
}
