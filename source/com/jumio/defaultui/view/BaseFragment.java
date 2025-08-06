package com.jumio.defaultui.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.a;
import com.google.android.material.button.MaterialButton;
import com.jumio.defaultui.R;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import kotlin.jvm.internal.Reflection;

public abstract class BaseFragment extends Fragment {
    private JumioFragmentCallback callback;
    private final Integer requestedOrientation;

    public static /* synthetic */ void fadeAndScaleTo$default(BaseFragment baseFragment, View view, int i11, long j11, long j12, int i12, Object obj) {
        if (obj == null) {
            baseFragment.fadeAndScaleTo(view, i11, (i12 & 2) != 0 ? 30 : j11, (i12 & 4) != 0 ? 30 : j12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fadeAndScaleTo");
    }

    public abstract View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r0.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dismissKeyboard() {
        /*
            r5 = this;
            android.content.Context r0 = r5.getContext()
            r1 = 0
            if (r0 == 0) goto L_0x0014
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "input_method"
            java.lang.Object r0 = r0.getSystemService(r2)
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0022
            boolean r4 = r0.isAcceptingText()
            if (r4 != r2) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r2 = r3
        L_0x0023:
            if (r2 == 0) goto L_0x0038
            androidx.fragment.app.FragmentActivity r2 = r5.getActivity()
            if (r2 == 0) goto L_0x0035
            android.view.View r2 = r2.getCurrentFocus()
            if (r2 == 0) goto L_0x0035
            android.os.IBinder r1 = r2.getWindowToken()
        L_0x0035:
            r0.hideSoftInputFromWindow(r1, r3)
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.BaseFragment.dismissKeyboard():void");
    }

    public final void fadeAndScaleTo(View view, int i11, long j11, long j12) {
        if (view != null) {
            view.setVisibility(i11);
            float f11 = (i11 == 0 || !(i11 == 4 || i11 == 8)) ? 1.0f : 0.0f;
            ViewPropertyAnimator animate = view.animate();
            animate.setInterpolator(new AccelerateDecelerateInterpolator());
            animate.alpha(f11);
            animate.scaleX(f11);
            animate.scaleY(f11);
            animate.setDuration(j11);
            animate.setStartDelay(j12);
            animate.start();
        }
    }

    public final JumioFragmentCallback getCallback() {
        return this.callback;
    }

    public Integer getRequestedOrientation() {
        return this.requestedOrientation;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getContext() instanceof JumioFragmentCallback) {
            JumioFragmentCallback jumioFragmentCallback = (JumioFragmentCallback) getContext();
            this.callback = jumioFragmentCallback;
            if (jumioFragmentCallback != null) {
                jumioFragmentCallback.setOrientation(getRequestedOrientation());
            }
            return createLayout(layoutInflater, viewGroup);
        }
        String f11 = Reflection.b(JumioFragmentCallback.class).f();
        throw new IllegalArgumentException(("Activity must extend " + f11).toString());
    }

    public void onDestroyView() {
        this.callback = null;
        super.onDestroyView();
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public final void setCallback(JumioFragmentCallback jumioFragmentCallback) {
        this.callback = jumioFragmentCallback;
    }

    public final void setShowProgress(MaterialButton materialButton, boolean z11) {
        a aVar;
        Resources.Theme theme;
        if (z11) {
            TypedValue typedValue = new TypedValue();
            Context context = materialButton.getContext();
            if (!(context == null || (theme = context.getTheme()) == null)) {
                theme.resolveAttribute(R.attr.jumio_primary_button_foreground, typedValue, true);
            }
            int i11 = typedValue.data;
            aVar = new a(materialButton.getContext());
            aVar.l(1);
            aVar.f(i11);
            aVar.start();
        } else {
            aVar = null;
        }
        materialButton.setIcon(aVar);
        if (materialButton.getIcon() != null) {
            materialButton.getIcon().setCallback(new BaseFragment$setShowProgress$2(materialButton));
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
