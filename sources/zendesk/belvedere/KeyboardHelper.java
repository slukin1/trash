package zendesk.belvedere;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import zendesk.belvedere.ui.R$dimen;

@SuppressLint({"ViewConstructor"})
public class KeyboardHelper extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public final int f62235b = getStatusBarHeight();

    /* renamed from: c  reason: collision with root package name */
    public int f62236c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f62237d = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62238e = false;

    /* renamed from: f  reason: collision with root package name */
    public List<WeakReference<c>> f62239f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public d f62240g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f62241h;

    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EditText f62242b;

        public a(EditText editText) {
            this.f62242b = editText;
        }

        public void run() {
            InputMethodManager inputMethodManager;
            if (this.f62242b.requestFocus() && (inputMethodManager = (InputMethodManager) this.f62242b.getContext().getSystemService("input_method")) != null) {
                inputMethodManager.showSoftInput(this.f62242b, 1);
            }
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b  reason: collision with root package name */
        public final Activity f62243b;

        public /* synthetic */ b(KeyboardHelper keyboardHelper, Activity activity, a aVar) {
            this(activity);
        }

        public void onGlobalLayout() {
            int a11 = KeyboardHelper.this.j(this.f62243b);
            boolean unused = KeyboardHelper.this.f62238e = a11 > 0;
            if (a11 > 0 && KeyboardHelper.this.f62237d != a11) {
                int unused2 = KeyboardHelper.this.f62237d = a11;
                if (KeyboardHelper.this.f62240g != null) {
                    KeyboardHelper.this.f62240g.a(a11);
                }
            }
            if (KeyboardHelper.this.f62239f == null || a11 <= 0) {
                KeyboardHelper.this.m();
            } else {
                KeyboardHelper.this.n();
            }
        }

        public b(Activity activity) {
            this.f62243b = activity;
        }
    }

    public interface c {
        void onKeyboardDismissed();

        void onKeyboardVisible();
    }

    public interface d {
        void a(int i11);
    }

    public KeyboardHelper(Activity activity) {
        super(activity);
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R$dimen.belvedere_dummy_edit_text_size);
        setLayoutParams(new ViewGroup.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        EditText editText = new EditText(activity);
        this.f62241h = editText;
        editText.setFocusable(true);
        this.f62241h.setFocusableInTouchMode(true);
        this.f62241h.setVisibility(0);
        this.f62241h.setImeOptions(268435456);
        this.f62241h.setInputType(16384);
        addView(this.f62241h);
        activity.getWindow().getDecorView().findViewById(16908290).getViewTreeObserver().addOnGlobalLayoutListener(new b(this, activity, (a) null));
    }

    private int getCachedInset() {
        if (this.f62236c == -1) {
            this.f62236c = getViewInset();
        }
        return this.f62236c;
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private int getViewInset() {
        if (Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            if (obj == null) {
                return 0;
            }
            Field declaredField2 = obj.getClass().getDeclaredField("mStableInsets");
            declaredField2.setAccessible(true);
            return ((Rect) declaredField2.get(obj)).bottom;
        } catch (Exception unused) {
            return 0;
        }
    }

    private int getViewPortHeight() {
        return (getRootView().getHeight() - this.f62235b) - getCachedInset();
    }

    public static void k(Activity activity) {
        InputMethodManager inputMethodManager;
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null && (inputMethodManager = (InputMethodManager) currentFocus.getContext().getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public static KeyboardHelper l(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (viewGroup.getChildAt(i11) instanceof KeyboardHelper) {
                return (KeyboardHelper) viewGroup.getChildAt(i11);
            }
        }
        KeyboardHelper keyboardHelper = new KeyboardHelper(activity);
        viewGroup.addView(keyboardHelper);
        return keyboardHelper;
    }

    public static void o(EditText editText) {
        editText.post(new a(editText));
    }

    public EditText getInputTrap() {
        return this.f62241h;
    }

    public int getKeyboardHeight() {
        return this.f62237d;
    }

    public void i(c cVar) {
        this.f62239f.add(new WeakReference(cVar));
    }

    public final int j(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return getViewPortHeight() - (rect.bottom - rect.top);
    }

    public final void m() {
        for (WeakReference next : this.f62239f) {
            if (next.get() != null) {
                ((c) next.get()).onKeyboardDismissed();
            }
        }
    }

    public final void n() {
        for (WeakReference next : this.f62239f) {
            if (next.get() != null) {
                ((c) next.get()).onKeyboardVisible();
            }
        }
    }

    public void setKeyboardHeightListener(d dVar) {
        this.f62240g = dVar;
    }
}
