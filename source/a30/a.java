package a30;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.h0;

@TargetApi(19)
public class a {
    public static View a(Activity activity, int i11, int i12) {
        View view = new View(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i12);
        layoutParams.gravity = 48;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i11);
        view.setTag("statusBarView");
        ((ViewGroup) activity.getWindow().getDecorView()).addView(view);
        return view;
    }

    public static void b(View view, int i11) {
        if (view != null && !"marginAdded".equals(view.getTag())) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin += i11;
            view.setLayoutParams(layoutParams);
            view.setTag("marginAdded");
        }
    }

    public static int c(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    public static void d(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewWithTag = viewGroup.findViewWithTag("statusBarView");
        if (findViewWithTag != null) {
            viewGroup.removeView(findViewWithTag);
        }
    }

    public static void e(View view, int i11) {
        if (view != null && "marginAdded".equals(view.getTag())) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin -= i11;
            view.setLayoutParams(layoutParams);
            view.setTag((Object) null);
        }
    }

    public static void f(Activity activity, int i11) {
        Window window = activity.getWindow();
        window.addFlags(67108864);
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        int c11 = c(activity);
        d(activity);
        a(activity, i11, c11);
        b(childAt, c11);
        if (childAt != null) {
            h0.G0(childAt, false);
        }
    }

    public static void g(Activity activity) {
        activity.getWindow().addFlags(67108864);
        View childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        d(activity);
        e(childAt, c(activity));
        if (childAt != null) {
            h0.G0(childAt, false);
        }
    }
}
