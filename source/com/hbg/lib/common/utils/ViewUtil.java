package com.hbg.lib.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.TextView;
import com.hbg.lib.common.BaseApplication;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.s;
import java.util.Objects;
import lombok.NonNull;

public class ViewUtil {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f67549a;

    /* renamed from: b  reason: collision with root package name */
    public static Runnable f67550b = s.f55013b;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f67551b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c6.b f67552c;

        public a(View view, c6.b bVar) {
            this.f67551b = view;
            this.f67552c = bVar;
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f67551b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                this.f67551b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            c6.b bVar = this.f67552c;
            if (bVar != null) {
                bVar.onCallback(this.f67551b);
            }
        }
    }

    public static class b extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public String f67553b;

        /* renamed from: c  reason: collision with root package name */
        public final int f67554c;

        /* renamed from: d  reason: collision with root package name */
        public final c f67555d;

        public b(int i11, c cVar) {
            this.f67554c = i11;
            this.f67555d = cVar;
        }

        public String a() {
            return this.f67553b;
        }

        public void b(String str) {
            this.f67553b = str;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            c cVar;
            if (!TextUtils.isEmpty(a()) && (cVar = this.f67555d) != null) {
                cVar.a(view, a());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(@NonNull TextPaint textPaint) {
            Objects.requireNonNull(textPaint, "ds is marked @NonNull but is null");
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f67554c);
            textPaint.setUnderlineText(false);
        }
    }

    public interface c {
        void a(View view, String str);
    }

    public static void b(View view, c6.b<View> bVar) {
        if (view != null) {
            if (!view.isInEditMode()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view, bVar));
            } else if (bVar != null) {
                bVar.onCallback(view);
            }
        }
    }

    public static boolean c(int i11) {
        if (f67549a) {
            return true;
        }
        f67549a = true;
        i.b().h(f67550b);
        i.b().g(f67550b, i11);
        return false;
    }

    public static void d(EditText editText) {
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
            try {
                editText.setInputType(1);
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static Activity e(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static int f(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int g() {
        int identifier = BaseApplication.b().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return BaseApplication.b().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int[] h(View view, Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i11 = rect.top;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[1] = iArr[1] - i11;
        return iArr;
    }

    public static boolean i(int i11) {
        return (i11 & 80) == 80;
    }

    public static boolean j(int i11) {
        return (i11 & 5) == 5;
    }

    public static void l(TextView textView, String str, String str2, int i11, c cVar) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            textView.setText((CharSequence) null);
            if (str.contains(str2)) {
                int indexOf = str.indexOf(str2, 0);
                int length = str2.length() + indexOf;
                textView.append(str.substring(0, indexOf));
                SpannableString spannableString = new SpannableString(str2);
                b bVar = new b(i11, cVar);
                bVar.b(str2);
                spannableString.setSpan(bVar, 0, str2.length(), 33);
                textView.append(spannableString);
                textView.append(str.substring(length));
                textView.setHighlightColor(0);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setLongClickable(false);
                return;
            }
            textView.setText(str);
        }
    }

    public static void m(View view, boolean z11) {
        if (view != null) {
            if (z11) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public static void n(View view, boolean z11) {
        if (view != null) {
            if (z11) {
                view.setVisibility(0);
            } else {
                view.setVisibility(4);
            }
        }
    }

    public static void o(View view) {
        view.setVisibility(view.getVisibility() == 0 ? 8 : 0);
    }
}
