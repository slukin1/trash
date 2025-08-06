package rd;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.core.view.h0;
import com.huobi.view.roundview.RoundViewDelegate;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final s f23381a = new s();

    public static /* synthetic */ void l(s sVar, View view, View.OnClickListener onClickListener, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 800;
        }
        sVar.k(view, onClickListener, j11);
    }

    @SensorsDataInstrumented
    public static final void m(View view, long j11, View.OnClickListener onClickListener, View view2) {
        long currentTimeMillis = System.currentTimeMillis();
        s sVar = f23381a;
        if (currentTimeMillis - sVar.b(view) > j11 || (view instanceof Checkable)) {
            sVar.e(view, currentTimeMillis);
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view2);
    }

    public final <T extends View> long b(T t11) {
        Object tag = t11.getTag(1766613352);
        Long l11 = tag instanceof Long ? (Long) tag : null;
        if (l11 != null) {
            return l11.longValue();
        }
        return 0;
    }

    public final void c(RoundViewDelegate roundViewDelegate, int i11) {
        roundViewDelegate.setBackgroundColor(roundViewDelegate.getView().getResources().getColor(i11));
    }

    public final void d(RoundViewDelegate roundViewDelegate, int i11) {
        roundViewDelegate.setBackgroundPressColor(roundViewDelegate.getView().getResources().getColor(i11));
    }

    public final <T extends View> void e(T t11, long j11) {
        t11.setTag(1766613352, Long.valueOf(j11));
    }

    public final void f(RoundViewDelegate roundViewDelegate, int i11) {
        roundViewDelegate.setStrokeColor(roundViewDelegate.getView().getResources().getColor(i11));
    }

    public final void g(RoundViewDelegate roundViewDelegate, int i11) {
        roundViewDelegate.setStrokePressColor(roundViewDelegate.getView().getResources().getColor(i11));
    }

    public final void h(RoundViewDelegate roundViewDelegate, int i11) {
        roundViewDelegate.setStrokeWidth((int) roundViewDelegate.getView().getResources().getDimension(i11));
    }

    public final void i(TextView textView, int i11) {
        textView.setTextColor(textView.getContext().getResources().getColor(i11));
    }

    public final void j(TextView textView, int i11) {
        textView.setText(textView.getContext().getResources().getString(i11));
    }

    public final <T extends View> void k(T t11, View.OnClickListener onClickListener, long j11) {
        t11.setOnClickListener(new r(t11, j11, onClickListener));
    }

    public final void n(Window window, boolean z11) {
        window.addFlags(Integer.MIN_VALUE);
        if (z11) {
            window.clearFlags(67108864);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(0);
        } else {
            window.clearFlags(67108864);
            window.setNavigationBarColor(0);
            window.getDecorView().setSystemUiVisibility(Params.POLY_BYTES);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        if (childAt != null) {
            h0.G0(childAt, false);
            h0.u0(childAt);
        }
    }
}
