package androidx.test.espresso.util;

import android.content.res.Resources;
import android.os.Build;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Joiner;
import androidx.test.espresso.core.internal.deps.guava.base.MoreObjects;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Strings;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.util.TreeIterables;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.List;

public final class HumanReadables {
    public static String a(View view) {
        if (view == null) {
            return OptionsBridge.NULL_VALUE;
        }
        MoreObjects.ToStringHelper b11 = MoreObjects.b(view).b("id", view.getId());
        if (!(view.getId() == -1 || view.getResources() == null)) {
            try {
                b11.d("res-name", view.getResources().getResourceEntryName(view.getId()));
            } catch (Resources.NotFoundException unused) {
            }
        }
        if (view.getContentDescription() != null) {
            b11.d("desc", view.getContentDescription());
        }
        int visibility = view.getVisibility();
        if (visibility == 0) {
            b11.d("visibility", "VISIBLE");
        } else if (visibility == 4) {
            b11.d("visibility", "INVISIBLE");
        } else if (visibility != 8) {
            b11.b("visibility", view.getVisibility());
        } else {
            b11.d("visibility", "GONE");
        }
        b11.b("width", view.getWidth()).b("height", view.getHeight()).e("has-focus", view.hasFocus()).e("has-focusable", view.hasFocusable()).e("has-window-focus", view.hasWindowFocus()).e("is-clickable", view.isClickable()).e("is-enabled", view.isEnabled()).e("is-focused", view.isFocused()).e("is-focusable", view.isFocusable()).e("is-layout-requested", view.isLayoutRequested()).e("is-selected", view.isSelected()).d("layout-params", view.getLayoutParams()).d("tag", view.getTag());
        if (view.getRootView() != null) {
            b11.e("root-is-layout-requested", view.getRootView().isLayoutRequested());
        }
        EditorInfo editorInfo = new EditorInfo();
        boolean z11 = view.onCreateInputConnection(editorInfo) != null;
        b11.e("has-input-connection", z11);
        if (z11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            editorInfo.dump(new StringBuilderPrinter(sb2), "");
            sb2.append("]");
            b11.d("editor-info", sb2.toString().replace("\n", " "));
        }
        if (Build.VERSION.SDK_INT > 10) {
            b11.a("x", view.getX()).a("y", view.getY());
        }
        if (view instanceof TextView) {
            e((TextView) view, b11);
        }
        if (view instanceof Checkable) {
            d((Checkable) view, b11);
        }
        if (view instanceof ViewGroup) {
            c((ViewGroup) view, b11);
        }
        return b11.toString();
    }

    public static String b(View view, final List<View> list, String str, final String str2) {
        Preconditions.d(list == null || str2 != null);
        StringBuilder sb2 = new StringBuilder(str);
        if (str2 != null) {
            sb2.append(String.format("\nProblem views are marked with '%s' below.", new Object[]{str2}));
        }
        sb2.append("\n\nView Hierarchy:\n");
        Joiner.f("\n").b(sb2, Iterables.d(TreeIterables.b(view), new Function<TreeIterables.ViewAndDistance, String>() {
            /* renamed from: a */
            public String apply(TreeIterables.ViewAndDistance viewAndDistance) {
                List list = list;
                String str = "+%s%s ";
                if (list != null && list.contains(viewAndDistance.b())) {
                    String valueOf = String.valueOf(str2);
                    str = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
                }
                return String.format(String.valueOf(str).concat("\n|"), new Object[]{Strings.c(">", viewAndDistance.a() + 1, '-'), HumanReadables.a(viewAndDistance.b())});
            }
        }));
        return sb2.toString();
    }

    public static void c(ViewGroup viewGroup, MoreObjects.ToStringHelper toStringHelper) {
        toStringHelper.b("child-count", viewGroup.getChildCount());
    }

    public static void d(Checkable checkable, MoreObjects.ToStringHelper toStringHelper) {
        toStringHelper.e("is-checked", checkable.isChecked());
    }

    public static void e(TextView textView, MoreObjects.ToStringHelper toStringHelper) {
        if (textView.getText() != null) {
            toStringHelper.d("text", textView.getText());
        }
        if (textView.getError() != null) {
            toStringHelper.d("error-text", textView.getError());
        }
        if (textView.getHint() != null) {
            toStringHelper.d("hint", textView.getHint());
        }
        toStringHelper.b("input-type", textView.getInputType());
        toStringHelper.e("ime-target", textView.isInputMethodTarget());
        toStringHelper.e("has-links", textView.getUrls().length > 0);
    }
}
