package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.util.h;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import z0.c;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static Field f8736a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f8737b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f8738c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f8739d;

    public static class a {
        public static boolean a(TextView textView) {
            return textView.getIncludeFontPadding();
        }

        public static int b(TextView textView) {
            return textView.getMaxLines();
        }

        public static int c(TextView textView) {
            return textView.getMinLines();
        }
    }

    public static class b {
        public static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        public static int b(View view) {
            return view.getLayoutDirection();
        }

        public static int c(View view) {
            return view.getTextDirection();
        }

        public static Locale d(TextView textView) {
            return textView.getTextLocale();
        }

        public static void e(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        public static void f(TextView textView, int i11, int i12, int i13, int i14) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i11, i12, i13, i14);
        }

        public static void g(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        public static void h(View view, int i11) {
            view.setTextDirection(i11);
        }
    }

    public static class c {
        public static int a(TextView textView) {
            return textView.getBreakStrategy();
        }

        public static ColorStateList b(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        public static PorterDuff.Mode c(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        public static int d(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        public static void e(TextView textView, int i11) {
            textView.setBreakStrategy(i11);
        }

        public static void f(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        public static void g(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        public static void h(TextView textView, int i11) {
            textView.setHyphenationFrequency(i11);
        }
    }

    public static class d {
        public static DecimalFormatSymbols a(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    public static class e {
        public static int a(TextView textView) {
            return textView.getAutoSizeMaxTextSize();
        }

        public static int b(TextView textView) {
            return textView.getAutoSizeMinTextSize();
        }

        public static int c(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static int[] d(TextView textView) {
            return textView.getAutoSizeTextAvailableSizes();
        }

        public static int e(TextView textView) {
            return textView.getAutoSizeTextType();
        }

        public static void f(TextView textView, int i11, int i12, int i13, int i14) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i11, i12, i13, i14);
        }

        public static void g(TextView textView, int[] iArr, int i11) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i11);
        }

        public static void h(TextView textView, int i11) {
            textView.setAutoSizeTextTypeWithDefaults(i11);
        }
    }

    public static class f {
        public static CharSequence a(PrecomputedText precomputedText) {
            return precomputedText;
        }

        public static String[] b(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        public static PrecomputedText.Params c(TextView textView) {
            return textView.getTextMetricsParams();
        }

        public static void d(TextView textView, int i11) {
            textView.setFirstBaselineToTopHeight(i11);
        }
    }

    public static class g implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final ActionMode.Callback f8740a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f8741b;

        /* renamed from: c  reason: collision with root package name */
        public Class<?> f8742c;

        /* renamed from: d  reason: collision with root package name */
        public Method f8743d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8744e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8745f = false;

        public g(ActionMode.Callback callback, TextView textView) {
            this.f8740a = callback;
            this.f8741b = textView;
        }

        public final Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        public final Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent putExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !e(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        public final List<ResolveInfo> c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo next : packageManager.queryIntentActivities(a(), 0)) {
                if (f(next, context)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        public ActionMode.Callback d() {
            return this.f8740a;
        }

        public final boolean e(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        public final boolean f(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            if (str == null || context.checkSelfPermission(str) == 0) {
                return true;
            }
            return false;
        }

        public final void g(Menu menu) {
            Method method;
            Context context = this.f8741b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f8745f) {
                this.f8745f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f8742c = cls;
                    this.f8743d = cls.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                    this.f8744e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f8742c = null;
                    this.f8743d = null;
                    this.f8744e = false;
                }
            }
            try {
                if (!this.f8744e || !this.f8742c.isInstance(menu)) {
                    method = menu.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                } else {
                    method = this.f8743d;
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        method.invoke(menu, new Object[]{Integer.valueOf(size)});
                    }
                }
                List<ResolveInfo> c11 = c(context, packageManager);
                for (int i11 = 0; i11 < c11.size(); i11++) {
                    ResolveInfo resolveInfo = c11.get(i11);
                    menu.add(0, 0, i11 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f8741b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f8740a.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f8740a.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f8740a.onDestroyActionMode(actionMode);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            g(menu);
            return this.f8740a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static Drawable[] a(TextView textView) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 18) {
            return b.a(textView);
        }
        if (i11 < 17) {
            return textView.getCompoundDrawables();
        }
        boolean z11 = true;
        if (b.b(textView) != 1) {
            z11 = false;
        }
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (z11) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }

    public static int b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int d(TextView textView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return a.b(textView);
        }
        if (!f8739d) {
            f8738c = h("mMaxMode");
            f8739d = true;
        }
        Field field = f8738c;
        if (field == null || i(field, textView) != 1) {
            return -1;
        }
        if (!f8737b) {
            f8736a = h("mMaximum");
            f8737b = true;
        }
        Field field2 = f8736a;
        if (field2 != null) {
            return i(field2, textView);
        }
        return -1;
    }

    public static int e(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 7;
        }
        return 1;
    }

    public static TextDirectionHeuristic f(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z11 = false;
        if (Build.VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (b.b(textView) == 1) {
                z11 = true;
            }
            switch (b.c(textView)) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    if (z11) {
                        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        } else {
            byte directionality = Character.getDirectionality(f.b(d.a(b.d(textView)))[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                return TextDirectionHeuristics.RTL;
            }
            return TextDirectionHeuristics.LTR;
        }
    }

    public static c.a g(TextView textView) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            return new c.a(f.c(textView));
        }
        c.a.C0117a aVar = new c.a.C0117a(new TextPaint(textView.getPaint()));
        if (i11 >= 23) {
            aVar.b(c.a(textView));
            aVar.c(c.d(textView));
        }
        if (i11 >= 18) {
            aVar.d(f(textView));
        }
        return aVar.a();
    }

    public static Field h(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException unused) {
            Log.e("TextViewCompat", "Could not retrieve " + str + " field.");
            return field;
        }
    }

    public static int i(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            Log.d("TextViewCompat", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    public static void j(TextView textView, int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            e.f(textView, i11, i12, i13, i14);
        } else if (textView instanceof b) {
            ((b) textView).setAutoSizeTextTypeUniformWithConfiguration(i11, i12, i13, i14);
        }
    }

    public static void k(TextView textView, int i11) {
        if (Build.VERSION.SDK_INT >= 27) {
            e.h(textView, i11);
        } else if (textView instanceof b) {
            ((b) textView).setAutoSizeTextTypeWithDefaults(i11);
        }
    }

    public static void l(TextView textView, ColorStateList colorStateList) {
        h.g(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            c.f(textView, colorStateList);
        } else if (textView instanceof o) {
            ((o) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    public static void m(TextView textView, PorterDuff.Mode mode) {
        h.g(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            c.g(textView, mode);
        } else if (textView instanceof o) {
            ((o) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void n(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 18) {
            b.e(textView, drawable, drawable2, drawable3, drawable4);
        } else if (i11 >= 17) {
            boolean z11 = true;
            if (b.b(textView) != 1) {
                z11 = false;
            }
            Drawable drawable5 = z11 ? drawable3 : drawable;
            if (!z11) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void o(TextView textView, int i11) {
        int i12;
        h.d(i11);
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 28) {
            f.d(textView, i11);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (i13 < 16 || a.a(textView)) {
            i12 = fontMetricsInt.top;
        } else {
            i12 = fontMetricsInt.ascent;
        }
        if (i11 > Math.abs(i12)) {
            textView.setPadding(textView.getPaddingLeft(), i11 + i12, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void p(TextView textView, int i11) {
        int i12;
        h.d(i11);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || a.a(textView)) {
            i12 = fontMetricsInt.bottom;
        } else {
            i12 = fontMetricsInt.descent;
        }
        if (i11 > Math.abs(i12)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i11 - i12);
        }
    }

    public static void q(TextView textView, int i11) {
        h.d(i11);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt((Paint.FontMetricsInt) null);
        if (i11 != fontMetricsInt) {
            textView.setLineSpacing((float) (i11 - fontMetricsInt), 1.0f);
        }
    }

    public static void r(TextView textView, z0.c cVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(f.a(cVar.b()));
        } else if (g(textView).a(cVar.a())) {
            textView.setText(cVar);
        } else {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
    }

    public static void s(TextView textView, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i11);
        } else {
            textView.setTextAppearance(textView.getContext(), i11);
        }
    }

    public static void t(TextView textView, c.a aVar) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 18) {
            b.h(textView, e(aVar.d()));
        }
        if (i11 < 23) {
            float textScaleX = aVar.e().getTextScaleX();
            textView.getPaint().set(aVar.e());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(aVar.e());
        c.e(textView, aVar.b());
        c.h(textView, aVar.c());
    }

    public static ActionMode.Callback u(ActionMode.Callback callback) {
        return (!(callback instanceof g) || Build.VERSION.SDK_INT < 26) ? callback : ((g) callback).d();
    }

    public static ActionMode.Callback v(TextView textView, ActionMode.Callback callback) {
        int i11 = Build.VERSION.SDK_INT;
        return (i11 < 26 || i11 > 27 || (callback instanceof g) || callback == null) ? callback : new g(callback, textView);
    }
}
