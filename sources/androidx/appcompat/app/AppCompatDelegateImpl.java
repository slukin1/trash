package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.s;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.g;
import androidx.core.view.h0;
import androidx.core.view.n0;
import androidx.core.view.o0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.lang.Thread;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class AppCompatDelegateImpl extends AppCompatDelegate implements e.a, LayoutInflater.Factory2 {

    /* renamed from: k0  reason: collision with root package name */
    public static final SimpleArrayMap<String, Integer> f3821k0 = new SimpleArrayMap<>();

    /* renamed from: l0  reason: collision with root package name */
    public static final boolean f3822l0;

    /* renamed from: m0  reason: collision with root package name */
    public static final int[] f3823m0 = {16842836};

    /* renamed from: n0  reason: collision with root package name */
    public static final boolean f3824n0 = (!"robolectric".equals(Build.FINGERPRINT));

    /* renamed from: t0  reason: collision with root package name */
    public static final boolean f3825t0;

    /* renamed from: u0  reason: collision with root package name */
    public static boolean f3826u0 = true;
    public boolean A;
    public boolean B;
    public ViewGroup C;
    public TextView D;
    public View E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public PanelFeatureState[] N;
    public PanelFeatureState O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public Configuration T;
    public int U;
    public int V;
    public int W;
    public boolean X;
    public s Y;
    public s Z;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f3827a0;

    /* renamed from: b0  reason: collision with root package name */
    public int f3828b0;

    /* renamed from: c0  reason: collision with root package name */
    public final Runnable f3829c0;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f3830d0;

    /* renamed from: e0  reason: collision with root package name */
    public Rect f3831e0;

    /* renamed from: f0  reason: collision with root package name */
    public Rect f3832f0;

    /* renamed from: g0  reason: collision with root package name */
    public AppCompatViewInflater f3833g0;

    /* renamed from: h0  reason: collision with root package name */
    public h f3834h0;

    /* renamed from: i0  reason: collision with root package name */
    public OnBackInvokedDispatcher f3835i0;

    /* renamed from: j0  reason: collision with root package name */
    public OnBackInvokedCallback f3836j0;

    /* renamed from: k  reason: collision with root package name */
    public final Object f3837k;

    /* renamed from: l  reason: collision with root package name */
    public final Context f3838l;

    /* renamed from: m  reason: collision with root package name */
    public Window f3839m;

    /* renamed from: n  reason: collision with root package name */
    public q f3840n;

    /* renamed from: o  reason: collision with root package name */
    public final a f3841o;

    /* renamed from: p  reason: collision with root package name */
    public ActionBar f3842p;

    /* renamed from: q  reason: collision with root package name */
    public MenuInflater f3843q;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence f3844r;

    /* renamed from: s  reason: collision with root package name */
    public androidx.appcompat.widget.p f3845s;

    /* renamed from: t  reason: collision with root package name */
    public j f3846t;

    /* renamed from: u  reason: collision with root package name */
    public v f3847u;

    /* renamed from: v  reason: collision with root package name */
    public ActionMode f3848v;

    /* renamed from: w  reason: collision with root package name */
    public ActionBarContextView f3849w;

    /* renamed from: x  reason: collision with root package name */
    public PopupWindow f3850x;

    /* renamed from: y  reason: collision with root package name */
    public Runnable f3851y;

    /* renamed from: z  reason: collision with root package name */
    public n0 f3852z;

    public class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        public final boolean c(int i11, int i12) {
            return i11 < -5 || i12 < -5 || i11 > getWidth() + 5 || i12 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.i0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.c0(0);
            return true;
        }

        public void setBackgroundResource(int i11) {
            setBackgroundDrawable(c.a.b(getContext(), i11));
        }
    }

    public static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        public int f3854a;

        /* renamed from: b  reason: collision with root package name */
        public int f3855b;

        /* renamed from: c  reason: collision with root package name */
        public int f3856c;

        /* renamed from: d  reason: collision with root package name */
        public int f3857d;

        /* renamed from: e  reason: collision with root package name */
        public int f3858e;

        /* renamed from: f  reason: collision with root package name */
        public int f3859f;

        /* renamed from: g  reason: collision with root package name */
        public ViewGroup f3860g;

        /* renamed from: h  reason: collision with root package name */
        public View f3861h;

        /* renamed from: i  reason: collision with root package name */
        public View f3862i;

        /* renamed from: j  reason: collision with root package name */
        public androidx.appcompat.view.menu.e f3863j;

        /* renamed from: k  reason: collision with root package name */
        public androidx.appcompat.view.menu.c f3864k;

        /* renamed from: l  reason: collision with root package name */
        public Context f3865l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f3866m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f3867n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f3868o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f3869p;

        /* renamed from: q  reason: collision with root package name */
        public boolean f3870q = false;

        /* renamed from: r  reason: collision with root package name */
        public boolean f3871r;

        /* renamed from: s  reason: collision with root package name */
        public Bundle f3872s;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            public int featureId;
            public boolean isOpen;
            public Bundle menuState;

            public class a implements Parcelable.ClassLoaderCreator<SavedState> {
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.readFromParcel(parcel, (ClassLoader) null);
                }

                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.readFromParcel(parcel, classLoader);
                }

                /* renamed from: c */
                public SavedState[] newArray(int i11) {
                    return new SavedState[i11];
                }
            }

            public static SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.featureId = parcel.readInt();
                boolean z11 = true;
                if (parcel.readInt() != 1) {
                    z11 = false;
                }
                savedState.isOpen = z11;
                if (z11) {
                    savedState.menuState = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(this.featureId);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }
        }

        public PanelFeatureState(int i11) {
            this.f3854a = i11;
        }

        public androidx.appcompat.view.menu.j a(i.a aVar) {
            if (this.f3863j == null) {
                return null;
            }
            if (this.f3864k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f3865l, R$layout.abc_list_menu_item_layout);
                this.f3864k = cVar;
                cVar.setCallback(aVar);
                this.f3863j.addMenuPresenter(this.f3864k);
            }
            return this.f3864k.b(this.f3860g);
        }

        public boolean b() {
            if (this.f3861h == null) {
                return false;
            }
            if (this.f3862i != null) {
                return true;
            }
            if (this.f3864k.a().getCount() > 0) {
                return true;
            }
            return false;
        }

        public void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f3863j;
            if (eVar != eVar2) {
                if (eVar2 != null) {
                    eVar2.removeMenuPresenter(this.f3864k);
                }
                this.f3863j = eVar;
                if (eVar != null && (cVar = this.f3864k) != null) {
                    eVar.addMenuPresenter(cVar);
                }
            }
        }

        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                newTheme.applyStyle(i11, true);
            }
            newTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i12 = typedValue.resourceId;
            if (i12 != 0) {
                newTheme.applyStyle(i12, true);
            } else {
                newTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f3865l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f3855b = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f3859f = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f3873b;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f3873b = uncaughtExceptionHandler;
        }

        public final boolean a(Throwable th2) {
            String message;
            if (!(th2 instanceof Resources.NotFoundException) || (message = th2.getMessage()) == null) {
                return false;
            }
            if (message.contains("drawable") || message.contains("Drawable")) {
                return true;
            }
            return false;
        }

        public void uncaughtException(Thread thread, Throwable th2) {
            if (a(th2)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th2.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th2.getCause());
                notFoundException.setStackTrace(th2.getStackTrace());
                this.f3873b.uncaughtException(thread, notFoundException);
                return;
            }
            this.f3873b.uncaughtException(thread, th2);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.f3828b0 & 1) != 0) {
                appCompatDelegateImpl.j0(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.f3828b0 & 4096) != 0) {
                appCompatDelegateImpl2.j0(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.f3827a0 = false;
            appCompatDelegateImpl3.f3828b0 = 0;
        }
    }

    public class c implements androidx.core.view.v {
        public c() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int m11 = windowInsetsCompat.m();
            int f12 = AppCompatDelegateImpl.this.f1(windowInsetsCompat, (Rect) null);
            if (m11 != f12) {
                windowInsetsCompat = windowInsetsCompat.r(windowInsetsCompat.k(), f12, windowInsetsCompat.l(), windowInsetsCompat.j());
            }
            return h0.i0(view, windowInsetsCompat);
        }
    }

    public class d implements s.a {
        public d() {
        }

        public void a(Rect rect) {
            rect.top = AppCompatDelegateImpl.this.f1((WindowInsetsCompat) null, rect);
        }
    }

    public class e implements ContentFrameLayout.a {
        public e() {
        }

        public void a() {
        }

        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.h0();
        }
    }

    public class f implements Runnable {

        public class a extends ViewPropertyAnimatorListenerAdapter {
            public a() {
            }

            public void b(View view) {
                AppCompatDelegateImpl.this.f3849w.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f3852z.j((o0) null);
                AppCompatDelegateImpl.this.f3852z = null;
            }

            public void c(View view) {
                AppCompatDelegateImpl.this.f3849w.setVisibility(0);
            }
        }

        public f() {
        }

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.f3850x.showAtLocation(appCompatDelegateImpl.f3849w, 55, 0, 0);
            AppCompatDelegateImpl.this.k0();
            if (AppCompatDelegateImpl.this.V0()) {
                AppCompatDelegateImpl.this.f3849w.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f3852z = h0.e(appCompatDelegateImpl2.f3849w).b(1.0f);
                AppCompatDelegateImpl.this.f3852z.j(new a());
                return;
            }
            AppCompatDelegateImpl.this.f3849w.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f3849w.setVisibility(0);
        }
    }

    public class g extends ViewPropertyAnimatorListenerAdapter {
        public g() {
        }

        public void b(View view) {
            AppCompatDelegateImpl.this.f3849w.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f3852z.j((o0) null);
            AppCompatDelegateImpl.this.f3852z = null;
        }

        public void c(View view) {
            AppCompatDelegateImpl.this.f3849w.setVisibility(0);
            if (AppCompatDelegateImpl.this.f3849w.getParent() instanceof View) {
                h0.u0((View) AppCompatDelegateImpl.this.f3849w.getParent());
            }
        }
    }

    public class h implements ActionBarDrawerToggle$Delegate {
        public h() {
        }
    }

    public interface i {
        boolean a(int i11);

        View onCreatePanelView(int i11);
    }

    public final class j implements i.a {
        public j() {
        }

        public boolean a(androidx.appcompat.view.menu.e eVar) {
            Window.Callback w02 = AppCompatDelegateImpl.this.w0();
            if (w02 == null) {
                return true;
            }
            w02.onMenuOpened(108, eVar);
            return true;
        }

        public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z11) {
            AppCompatDelegateImpl.this.a0(eVar);
        }
    }

    public class k implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        public ActionMode.Callback f3883a;

        public class a extends ViewPropertyAnimatorListenerAdapter {
            public a() {
            }

            public void b(View view) {
                AppCompatDelegateImpl.this.f3849w.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f3850x;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f3849w.getParent() instanceof View) {
                    h0.u0((View) AppCompatDelegateImpl.this.f3849w.getParent());
                }
                AppCompatDelegateImpl.this.f3849w.k();
                AppCompatDelegateImpl.this.f3852z.j((o0) null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f3852z = null;
                h0.u0(appCompatDelegateImpl2.C);
            }
        }

        public k(ActionMode.Callback callback) {
            this.f3883a = callback;
        }

        public boolean a(ActionMode actionMode, Menu menu) {
            return this.f3883a.a(actionMode, menu);
        }

        public boolean b(ActionMode actionMode, MenuItem menuItem) {
            return this.f3883a.b(actionMode, menuItem);
        }

        public boolean c(ActionMode actionMode, Menu menu) {
            h0.u0(AppCompatDelegateImpl.this.C);
            return this.f3883a.c(actionMode, menu);
        }

        public void d(ActionMode actionMode) {
            this.f3883a.d(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f3850x != null) {
                appCompatDelegateImpl.f3839m.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f3851y);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f3849w != null) {
                appCompatDelegateImpl2.k0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f3852z = h0.e(appCompatDelegateImpl3.f3849w).b(0.0f);
                AppCompatDelegateImpl.this.f3852z.j(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            a aVar = appCompatDelegateImpl4.f3841o;
            if (aVar != null) {
                aVar.onSupportActionModeFinished(appCompatDelegateImpl4.f3848v);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f3848v = null;
            h0.u0(appCompatDelegateImpl5.C);
            AppCompatDelegateImpl.this.d1();
        }
    }

    public static class l {
        public static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        public static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i11 = configuration.densityDpi;
            int i12 = configuration2.densityDpi;
            if (i11 != i12) {
                configuration3.densityDpi = i12;
            }
        }

        public static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        public static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    public static class m {
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        public static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    public static class n {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }

        public static LocaleListCompat b(Configuration configuration) {
            return LocaleListCompat.c(configuration.getLocales().toLanguageTags());
        }

        public static void c(LocaleListCompat localeListCompat) {
            LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.h()));
        }

        public static void d(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.h()));
        }
    }

    public static class o {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i11 = configuration.colorMode & 3;
            int i12 = configuration2.colorMode;
            if (i11 != (i12 & 3)) {
                configuration3.colorMode |= i12 & 3;
            }
            int i13 = configuration.colorMode & 12;
            int i14 = configuration2.colorMode;
            if (i13 != (i14 & 12)) {
                configuration3.colorMode |= i14 & 12;
            }
        }
    }

    public static class p {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            c cVar = new c(appCompatDelegateImpl);
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, cVar);
            return cVar;
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public class r extends s {

        /* renamed from: c  reason: collision with root package name */
        public final PowerManager f3891c;

        public r(Context context) {
            super();
            this.f3891c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        public IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int c() {
            if (Build.VERSION.SDK_INT < 21 || !m.a(this.f3891c)) {
                return 1;
            }
            return 2;
        }

        public void d() {
            AppCompatDelegateImpl.this.d();
        }
    }

    public abstract class s {

        /* renamed from: a  reason: collision with root package name */
        public BroadcastReceiver f3893a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            public void onReceive(Context context, Intent intent) {
                s.this.d();
            }
        }

        public s() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f3893a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f3838l.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f3893a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b11 = b();
            if (b11 != null && b11.countActions() != 0) {
                if (this.f3893a == null) {
                    this.f3893a = new a();
                }
                AppCompatDelegateImpl.this.f3838l.registerReceiver(this.f3893a, b11);
            }
        }
    }

    public class t extends s {

        /* renamed from: c  reason: collision with root package name */
        public final m f3896c;

        public t(m mVar) {
            super();
            this.f3896c = mVar;
        }

        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int c() {
            return this.f3896c.d() ? 2 : 1;
        }

        public void d() {
            AppCompatDelegateImpl.this.d();
        }
    }

    public static class u {
        public static void a(android.view.ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    public final class v implements i.a {
        public v() {
        }

        public boolean a(androidx.appcompat.view.menu.e eVar) {
            Window.Callback w02;
            if (eVar != eVar.getRootMenu()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.H || (w02 = appCompatDelegateImpl.w0()) == null || AppCompatDelegateImpl.this.S) {
                return true;
            }
            w02.onMenuOpened(108, eVar);
            return true;
        }

        public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z11) {
            androidx.appcompat.view.menu.e rootMenu = eVar.getRootMenu();
            boolean z12 = rootMenu != eVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z12) {
                eVar = rootMenu;
            }
            PanelFeatureState n02 = appCompatDelegateImpl.n0(eVar);
            if (n02 == null) {
                return;
            }
            if (z12) {
                AppCompatDelegateImpl.this.Z(n02.f3854a, n02, rootMenu);
                AppCompatDelegateImpl.this.d0(n02, true);
                return;
            }
            AppCompatDelegateImpl.this.d0(n02, z11);
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        boolean z11 = false;
        boolean z12 = i11 < 21;
        f3822l0 = z12;
        if (i11 >= 17) {
            z11 = true;
        }
        f3825t0 = z11;
        if (z12 && !f3826u0) {
            Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    public AppCompatDelegateImpl(Activity activity, a aVar) {
        this(activity, (Window) null, aVar, activity);
    }

    public static Configuration o0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            float f11 = configuration.fontScale;
            float f12 = configuration2.fontScale;
            if (f11 != f12) {
                configuration3.fontScale = f12;
            }
            int i11 = configuration.mcc;
            int i12 = configuration2.mcc;
            if (i11 != i12) {
                configuration3.mcc = i12;
            }
            int i13 = configuration.mnc;
            int i14 = configuration2.mnc;
            if (i13 != i14) {
                configuration3.mnc = i14;
            }
            int i15 = Build.VERSION.SDK_INT;
            if (i15 >= 24) {
                n.a(configuration, configuration2, configuration3);
            } else if (!androidx.core.util.b.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i16 = configuration.touchscreen;
            int i17 = configuration2.touchscreen;
            if (i16 != i17) {
                configuration3.touchscreen = i17;
            }
            int i18 = configuration.keyboard;
            int i19 = configuration2.keyboard;
            if (i18 != i19) {
                configuration3.keyboard = i19;
            }
            int i21 = configuration.keyboardHidden;
            int i22 = configuration2.keyboardHidden;
            if (i21 != i22) {
                configuration3.keyboardHidden = i22;
            }
            int i23 = configuration.navigation;
            int i24 = configuration2.navigation;
            if (i23 != i24) {
                configuration3.navigation = i24;
            }
            int i25 = configuration.navigationHidden;
            int i26 = configuration2.navigationHidden;
            if (i25 != i26) {
                configuration3.navigationHidden = i26;
            }
            int i27 = configuration.orientation;
            int i28 = configuration2.orientation;
            if (i27 != i28) {
                configuration3.orientation = i28;
            }
            int i29 = configuration.screenLayout & 15;
            int i30 = configuration2.screenLayout;
            if (i29 != (i30 & 15)) {
                configuration3.screenLayout |= i30 & 15;
            }
            int i31 = configuration.screenLayout & 192;
            int i32 = configuration2.screenLayout;
            if (i31 != (i32 & 192)) {
                configuration3.screenLayout |= i32 & 192;
            }
            int i33 = configuration.screenLayout & 48;
            int i34 = configuration2.screenLayout;
            if (i33 != (i34 & 48)) {
                configuration3.screenLayout |= i34 & 48;
            }
            int i35 = configuration.screenLayout & 768;
            int i36 = configuration2.screenLayout;
            if (i35 != (i36 & 768)) {
                configuration3.screenLayout |= i36 & 768;
            }
            if (i15 >= 26) {
                o.a(configuration, configuration2, configuration3);
            }
            int i37 = configuration.uiMode & 15;
            int i38 = configuration2.uiMode;
            if (i37 != (i38 & 15)) {
                configuration3.uiMode |= i38 & 15;
            }
            int i39 = configuration.uiMode & 48;
            int i40 = configuration2.uiMode;
            if (i39 != (i40 & 48)) {
                configuration3.uiMode |= i40 & 48;
            }
            int i41 = configuration.screenWidthDp;
            int i42 = configuration2.screenWidthDp;
            if (i41 != i42) {
                configuration3.screenWidthDp = i42;
            }
            int i43 = configuration.screenHeightDp;
            int i44 = configuration2.screenHeightDp;
            if (i43 != i44) {
                configuration3.screenHeightDp = i44;
            }
            int i45 = configuration.smallestScreenWidthDp;
            int i46 = configuration2.smallestScreenWidthDp;
            if (i45 != i46) {
                configuration3.smallestScreenWidthDp = i46;
            }
            if (i15 >= 17) {
                l.b(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    public void A(Bundle bundle) {
        l0();
    }

    public final boolean A0(PanelFeatureState panelFeatureState) {
        Context context = this.f3838l;
        int i11 = panelFeatureState.f3854a;
        if ((i11 == 0 || i11 == 108) && this.f3845s != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme2);
                context = contextThemeWrapper;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.setCallback(this);
        panelFeatureState.c(eVar);
        return true;
    }

    public void B() {
        ActionBar s11 = s();
        if (s11 != null) {
            s11.setShowHideAnimationEnabled(true);
        }
    }

    public final void B0(int i11) {
        this.f3828b0 = (1 << i11) | this.f3828b0;
        if (!this.f3827a0) {
            h0.p0(this.f3839m.getDecorView(), this.f3829c0);
            this.f3827a0 = true;
        }
    }

    public void C(Bundle bundle) {
    }

    public boolean C0() {
        return this.A;
    }

    public void D() {
        U(true, false);
    }

    public int D0(Context context, int i11) {
        if (i11 == -100) {
            return -1;
        }
        if (i11 != -1) {
            if (i11 != 0) {
                if (!(i11 == 1 || i11 == 2)) {
                    if (i11 == 3) {
                        return r0(context).c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                return s0(context).c();
            } else {
                return -1;
            }
        }
        return i11;
    }

    public void E() {
        ActionBar s11 = s();
        if (s11 != null) {
            s11.setShowHideAnimationEnabled(false);
        }
    }

    public boolean E0() {
        boolean z11 = this.P;
        this.P = false;
        PanelFeatureState u02 = u0(0, false);
        if (u02 == null || !u02.f3868o) {
            ActionMode actionMode = this.f3848v;
            if (actionMode != null) {
                actionMode.a();
                return true;
            }
            ActionBar s11 = s();
            if (s11 == null || !s11.collapseActionView()) {
                return false;
            }
            return true;
        }
        if (!z11) {
            d0(u02, true);
        }
        return true;
    }

    public boolean F0(int i11, KeyEvent keyEvent) {
        boolean z11 = true;
        if (i11 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z11 = false;
            }
            this.P = z11;
        } else if (i11 == 82) {
            G0(0, keyEvent);
            return true;
        }
        return false;
    }

    public final boolean G0(int i11, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState u02 = u0(i11, true);
        if (!u02.f3868o) {
            return Q0(u02, keyEvent);
        }
        return false;
    }

    public boolean H(int i11) {
        int S0 = S0(i11);
        if (this.L && S0 == 108) {
            return false;
        }
        if (this.H && S0 == 1) {
            this.H = false;
        }
        if (S0 == 1) {
            Z0();
            this.L = true;
            return true;
        } else if (S0 == 2) {
            Z0();
            this.F = true;
            return true;
        } else if (S0 == 5) {
            Z0();
            this.G = true;
            return true;
        } else if (S0 == 10) {
            Z0();
            this.J = true;
            return true;
        } else if (S0 == 108) {
            Z0();
            this.H = true;
            return true;
        } else if (S0 != 109) {
            return this.f3839m.requestFeature(S0);
        } else {
            Z0();
            this.I = true;
            return true;
        }
    }

    public boolean H0(int i11, KeyEvent keyEvent) {
        ActionBar s11 = s();
        if (s11 != null && s11.onKeyShortcut(i11, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.O;
        if (panelFeatureState == null || !P0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.O == null) {
                PanelFeatureState u02 = u0(0, true);
                Q0(u02, keyEvent);
                boolean P0 = P0(u02, keyEvent.getKeyCode(), keyEvent, 1);
                u02.f3866m = false;
                if (P0) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.O;
        if (panelFeatureState2 != null) {
            panelFeatureState2.f3867n = true;
        }
        return true;
    }

    public boolean I0(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            if (i11 == 82) {
                J0(0, keyEvent);
                return true;
            }
        } else if (E0()) {
            return true;
        }
        return false;
    }

    public void J(int i11) {
        l0();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f3838l).inflate(i11, viewGroup);
        this.f3840n.c(this.f3839m.getCallback());
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean J0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.view.ActionMode r0 = r4.f3848v
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.u0(r5, r0)
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.p r5 = r4.f3845s
            if (r5 == 0) goto L_0x0043
            boolean r5 = r5.a()
            if (r5 == 0) goto L_0x0043
            android.content.Context r5 = r4.f3838l
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.p r5 = r4.f3845s
            boolean r5 = r5.c()
            if (r5 != 0) goto L_0x003c
            boolean r5 = r4.S
            if (r5 != 0) goto L_0x0062
            boolean r5 = r4.Q0(r2, r6)
            if (r5 == 0) goto L_0x0062
            androidx.appcompat.widget.p r5 = r4.f3845s
            boolean r0 = r5.b()
            goto L_0x0068
        L_0x003c:
            androidx.appcompat.widget.p r5 = r4.f3845s
            boolean r0 = r5.d()
            goto L_0x0068
        L_0x0043:
            boolean r5 = r2.f3868o
            if (r5 != 0) goto L_0x0064
            boolean r3 = r2.f3867n
            if (r3 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            boolean r5 = r2.f3866m
            if (r5 == 0) goto L_0x0062
            boolean r5 = r2.f3871r
            if (r5 == 0) goto L_0x005b
            r2.f3866m = r1
            boolean r5 = r4.Q0(r2, r6)
            goto L_0x005c
        L_0x005b:
            r5 = r0
        L_0x005c:
            if (r5 == 0) goto L_0x0062
            r4.N0(r2, r6)
            goto L_0x0068
        L_0x0062:
            r0 = r1
            goto L_0x0068
        L_0x0064:
            r4.d0(r2, r0)
            r0 = r5
        L_0x0068:
            if (r0 == 0) goto L_0x0085
            android.content.Context r5 = r4.f3838l
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007e
            r5.playSoundEffect(r1)
            goto L_0x0085
        L_0x007e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.J0(int, android.view.KeyEvent):boolean");
    }

    public void K(View view) {
        l0();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f3840n.c(this.f3839m.getCallback());
    }

    public void K0(int i11) {
        ActionBar s11;
        if (i11 == 108 && (s11 = s()) != null) {
            s11.dispatchMenuVisibilityChanged(true);
        }
    }

    public void L(View view, ViewGroup.LayoutParams layoutParams) {
        l0();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f3840n.c(this.f3839m.getCallback());
    }

    public void L0(int i11) {
        if (i11 == 108) {
            ActionBar s11 = s();
            if (s11 != null) {
                s11.dispatchMenuVisibilityChanged(false);
            }
        } else if (i11 == 0) {
            PanelFeatureState u02 = u0(i11, true);
            if (u02.f3868o) {
                d0(u02, false);
            }
        }
    }

    public void M0(ViewGroup viewGroup) {
    }

    public void N(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.N(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f3835i0;
        if (!(onBackInvokedDispatcher2 == null || (onBackInvokedCallback = this.f3836j0) == null)) {
            p.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f3836j0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f3837k;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.f3835i0 = p.a((Activity) this.f3837k);
                d1();
            }
        }
        this.f3835i0 = onBackInvokedDispatcher;
        d1();
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void N0(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r14, android.view.KeyEvent r15) {
        /*
            r13 = this;
            boolean r0 = r14.f3868o
            if (r0 != 0) goto L_0x00f8
            boolean r0 = r13.S
            if (r0 == 0) goto L_0x000a
            goto L_0x00f8
        L_0x000a:
            int r0 = r14.f3854a
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0027
            android.content.Context r0 = r13.f3838l
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenLayout
            r0 = r0 & 15
            r3 = 4
            if (r0 != r3) goto L_0x0023
            r0 = r2
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            if (r0 == 0) goto L_0x0027
            return
        L_0x0027:
            android.view.Window$Callback r0 = r13.w0()
            if (r0 == 0) goto L_0x003b
            int r3 = r14.f3854a
            androidx.appcompat.view.menu.e r4 = r14.f3863j
            boolean r0 = r0.onMenuOpened(r3, r4)
            if (r0 != 0) goto L_0x003b
            r13.d0(r14, r2)
            return
        L_0x003b:
            android.content.Context r0 = r13.f3838l
            java.lang.String r3 = "window"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            if (r0 != 0) goto L_0x0048
            return
        L_0x0048:
            boolean r15 = r13.Q0(r14, r15)
            if (r15 != 0) goto L_0x004f
            return
        L_0x004f:
            android.view.ViewGroup r15 = r14.f3860g
            r3 = -1
            r4 = -2
            if (r15 == 0) goto L_0x006a
            boolean r5 = r14.f3870q
            if (r5 == 0) goto L_0x005a
            goto L_0x006a
        L_0x005a:
            android.view.View r15 = r14.f3862i
            if (r15 == 0) goto L_0x00cc
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            if (r15 == 0) goto L_0x00cc
            int r15 = r15.width
            if (r15 != r3) goto L_0x00cc
            r6 = r3
            goto L_0x00cd
        L_0x006a:
            if (r15 != 0) goto L_0x0077
            boolean r15 = r13.z0(r14)
            if (r15 == 0) goto L_0x0076
            android.view.ViewGroup r15 = r14.f3860g
            if (r15 != 0) goto L_0x0086
        L_0x0076:
            return
        L_0x0077:
            boolean r3 = r14.f3870q
            if (r3 == 0) goto L_0x0086
            int r15 = r15.getChildCount()
            if (r15 <= 0) goto L_0x0086
            android.view.ViewGroup r15 = r14.f3860g
            r15.removeAllViews()
        L_0x0086:
            boolean r15 = r13.y0(r14)
            if (r15 == 0) goto L_0x00f6
            boolean r15 = r14.b()
            if (r15 != 0) goto L_0x0093
            goto L_0x00f6
        L_0x0093:
            android.view.View r15 = r14.f3861h
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            if (r15 != 0) goto L_0x00a0
            android.view.ViewGroup$LayoutParams r15 = new android.view.ViewGroup$LayoutParams
            r15.<init>(r4, r4)
        L_0x00a0:
            int r3 = r14.f3855b
            android.view.ViewGroup r5 = r14.f3860g
            r5.setBackgroundResource(r3)
            android.view.View r3 = r14.f3861h
            android.view.ViewParent r3 = r3.getParent()
            boolean r5 = r3 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x00b8
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            android.view.View r5 = r14.f3861h
            r3.removeView(r5)
        L_0x00b8:
            android.view.ViewGroup r3 = r14.f3860g
            android.view.View r5 = r14.f3861h
            r3.addView(r5, r15)
            android.view.View r15 = r14.f3861h
            boolean r15 = r15.hasFocus()
            if (r15 != 0) goto L_0x00cc
            android.view.View r15 = r14.f3861h
            r15.requestFocus()
        L_0x00cc:
            r6 = r4
        L_0x00cd:
            r14.f3867n = r1
            android.view.WindowManager$LayoutParams r15 = new android.view.WindowManager$LayoutParams
            r7 = -2
            int r8 = r14.f3857d
            int r9 = r14.f3858e
            r10 = 1002(0x3ea, float:1.404E-42)
            r11 = 8519680(0x820000, float:1.1938615E-38)
            r12 = -3
            r5 = r15
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            int r1 = r14.f3856c
            r15.gravity = r1
            int r1 = r14.f3859f
            r15.windowAnimations = r1
            android.view.ViewGroup r1 = r14.f3860g
            r0.addView(r1, r15)
            r14.f3868o = r2
            int r14 = r14.f3854a
            if (r14 != 0) goto L_0x00f5
            r13.d1()
        L_0x00f5:
            return
        L_0x00f6:
            r14.f3870q = r2
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.N0(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    public void O(Toolbar toolbar) {
        if (this.f3837k instanceof Activity) {
            ActionBar s11 = s();
            if (!(s11 instanceof WindowDecorActionBar)) {
                this.f3843q = null;
                if (s11 != null) {
                    s11.onDestroy();
                }
                this.f3842p = null;
                if (toolbar != null) {
                    ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, v0(), this.f3840n);
                    this.f3842p = toolbarActionBar;
                    this.f3840n.e(toolbarActionBar.mMenuCallback);
                    toolbar.setBackInvokedCallbackEnabled(true);
                } else {
                    this.f3840n.e((i) null);
                }
                u();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    public final ActionBar O0() {
        return this.f3842p;
    }

    public void P(int i11) {
        this.V = i11;
    }

    public final boolean P0(PanelFeatureState panelFeatureState, int i11, KeyEvent keyEvent, int i12) {
        androidx.appcompat.view.menu.e eVar;
        boolean z11 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f3866m || Q0(panelFeatureState, keyEvent)) && (eVar = panelFeatureState.f3863j) != null) {
            z11 = eVar.performShortcut(i11, keyEvent, i12);
        }
        if (z11 && (i12 & 1) == 0 && this.f3845s == null) {
            d0(panelFeatureState, true);
        }
        return z11;
    }

    public final void Q(CharSequence charSequence) {
        this.f3844r = charSequence;
        androidx.appcompat.widget.p pVar = this.f3845s;
        if (pVar != null) {
            pVar.setWindowTitle(charSequence);
        } else if (O0() != null) {
            O0().setWindowTitle(charSequence);
        } else {
            TextView textView = this.D;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public final boolean Q0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        androidx.appcompat.widget.p pVar;
        androidx.appcompat.widget.p pVar2;
        androidx.appcompat.widget.p pVar3;
        if (this.S) {
            return false;
        }
        if (panelFeatureState.f3866m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.O;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            d0(panelFeatureState2, false);
        }
        Window.Callback w02 = w0();
        if (w02 != null) {
            panelFeatureState.f3862i = w02.onCreatePanelView(panelFeatureState.f3854a);
        }
        int i11 = panelFeatureState.f3854a;
        boolean z11 = i11 == 0 || i11 == 108;
        if (z11 && (pVar3 = this.f3845s) != null) {
            pVar3.f();
        }
        if (panelFeatureState.f3862i == null && (!z11 || !(O0() instanceof ToolbarActionBar))) {
            androidx.appcompat.view.menu.e eVar = panelFeatureState.f3863j;
            if (eVar == null || panelFeatureState.f3871r) {
                if (eVar == null && (!A0(panelFeatureState) || panelFeatureState.f3863j == null)) {
                    return false;
                }
                if (z11 && this.f3845s != null) {
                    if (this.f3846t == null) {
                        this.f3846t = new j();
                    }
                    this.f3845s.e(panelFeatureState.f3863j, this.f3846t);
                }
                panelFeatureState.f3863j.stopDispatchingItemsChanged();
                if (!w02.onCreatePanelMenu(panelFeatureState.f3854a, panelFeatureState.f3863j)) {
                    panelFeatureState.c((androidx.appcompat.view.menu.e) null);
                    if (z11 && (pVar2 = this.f3845s) != null) {
                        pVar2.e((Menu) null, this.f3846t);
                    }
                    return false;
                }
                panelFeatureState.f3871r = false;
            }
            panelFeatureState.f3863j.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.f3872s;
            if (bundle != null) {
                panelFeatureState.f3863j.restoreActionViewStates(bundle);
                panelFeatureState.f3872s = null;
            }
            if (!w02.onPreparePanel(0, panelFeatureState.f3862i, panelFeatureState.f3863j)) {
                if (z11 && (pVar = this.f3845s) != null) {
                    pVar.e((Menu) null, this.f3846t);
                }
                panelFeatureState.f3863j.startDispatchingItemsChanged();
                return false;
            }
            boolean z12 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f3869p = z12;
            panelFeatureState.f3863j.setQwertyMode(z12);
            panelFeatureState.f3863j.startDispatchingItemsChanged();
        }
        panelFeatureState.f3866m = true;
        panelFeatureState.f3867n = false;
        this.O = panelFeatureState;
        return true;
    }

    public ActionMode R(ActionMode.Callback callback) {
        a aVar;
        if (callback != null) {
            ActionMode actionMode = this.f3848v;
            if (actionMode != null) {
                actionMode.a();
            }
            k kVar = new k(callback);
            ActionBar s11 = s();
            if (s11 != null) {
                ActionMode startActionMode = s11.startActionMode(kVar);
                this.f3848v = startActionMode;
                if (!(startActionMode == null || (aVar = this.f3841o) == null)) {
                    aVar.onSupportActionModeStarted(startActionMode);
                }
            }
            if (this.f3848v == null) {
                this.f3848v = Y0(kVar);
            }
            d1();
            return this.f3848v;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public final void R0(boolean z11) {
        androidx.appcompat.widget.p pVar = this.f3845s;
        if (pVar == null || !pVar.a() || (ViewConfiguration.get(this.f3838l).hasPermanentMenuKey() && !this.f3845s.g())) {
            PanelFeatureState u02 = u0(0, true);
            u02.f3870q = true;
            d0(u02, false);
            N0(u02, (KeyEvent) null);
            return;
        }
        Window.Callback w02 = w0();
        if (this.f3845s.c() && z11) {
            this.f3845s.d();
            if (!this.S) {
                w02.onPanelClosed(108, u0(0, true).f3863j);
            }
        } else if (w02 != null && !this.S) {
            if (this.f3827a0 && (this.f3828b0 & 1) != 0) {
                this.f3839m.getDecorView().removeCallbacks(this.f3829c0);
                this.f3829c0.run();
            }
            PanelFeatureState u03 = u0(0, true);
            androidx.appcompat.view.menu.e eVar = u03.f3863j;
            if (eVar != null && !u03.f3871r && w02.onPreparePanel(0, u03.f3862i, eVar)) {
                w02.onMenuOpened(108, u03.f3863j);
                this.f3845s.b();
            }
        }
    }

    public final int S0(int i11) {
        if (i11 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i11 != 9) {
            return i11;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    public final boolean T(boolean z11) {
        return U(z11, true);
    }

    public void T0(Configuration configuration, LocaleListCompat localeListCompat) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            n.d(configuration, localeListCompat);
        } else if (i11 >= 17) {
            l.d(configuration, localeListCompat.d(0));
            l.c(configuration, localeListCompat.d(0));
        } else {
            configuration.locale = localeListCompat.d(0);
        }
    }

    public final boolean U(boolean z11, boolean z12) {
        if (this.S) {
            return false;
        }
        int Y2 = Y();
        int D0 = D0(this.f3838l, Y2);
        LocaleListCompat localeListCompat = null;
        if (Build.VERSION.SDK_INT < 33) {
            localeListCompat = X(this.f3838l);
        }
        if (!z12 && localeListCompat != null) {
            localeListCompat = t0(this.f3838l.getResources().getConfiguration());
        }
        boolean c12 = c1(D0, localeListCompat, z11);
        if (Y2 == 0) {
            s0(this.f3838l).e();
        } else {
            s sVar = this.Y;
            if (sVar != null) {
                sVar.a();
            }
        }
        if (Y2 == 3) {
            r0(this.f3838l).e();
        } else {
            s sVar2 = this.Z;
            if (sVar2 != null) {
                sVar2.a();
            }
        }
        return c12;
    }

    public void U0(LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            n.c(localeListCompat);
        } else {
            Locale.setDefault(localeListCompat.d(0));
        }
    }

    public final void V() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.C.findViewById(16908290);
        View decorView = this.f3839m.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f3838l.obtainStyledAttributes(R$styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i11 = R$styleable.AppCompatTheme_windowFixedWidthMajor;
        if (obtainStyledAttributes.hasValue(i11)) {
            obtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMajor());
        }
        int i12 = R$styleable.AppCompatTheme_windowFixedWidthMinor;
        if (obtainStyledAttributes.hasValue(i12)) {
            obtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedWidthMinor());
        }
        int i13 = R$styleable.AppCompatTheme_windowFixedHeightMajor;
        if (obtainStyledAttributes.hasValue(i13)) {
            obtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMajor());
        }
        int i14 = R$styleable.AppCompatTheme_windowFixedHeightMinor;
        if (obtainStyledAttributes.hasValue(i14)) {
            obtainStyledAttributes.getValue(i14, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.C;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean V0() {
        /*
            r1 = this;
            boolean r0 = r1.B
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.C
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.view.h0.a0(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.V0():boolean");
    }

    public final void W(Window window) {
        if (this.f3839m == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof q)) {
                q qVar = new q(callback);
                this.f3840n = qVar;
                window.setCallback(qVar);
                d0 u11 = d0.u(this.f3838l, (AttributeSet) null, f3823m0);
                Drawable h11 = u11.h(0);
                if (h11 != null) {
                    window.setBackgroundDrawable(h11);
                }
                u11.w();
                this.f3839m = window;
                if (Build.VERSION.SDK_INT >= 33 && this.f3835i0 == null) {
                    N((OnBackInvokedDispatcher) null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public final boolean W0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f3839m.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || h0.Z((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public LocaleListCompat X(Context context) {
        LocaleListCompat r11;
        LocaleListCompat localeListCompat;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33 || (r11 = AppCompatDelegate.r()) == null) {
            return null;
        }
        LocaleListCompat t02 = t0(context.getApplicationContext().getResources().getConfiguration());
        if (i11 >= 24) {
            localeListCompat = i.b(r11, t02);
        } else if (r11.f()) {
            localeListCompat = LocaleListCompat.e();
        } else {
            localeListCompat = LocaleListCompat.c(r11.d(0).toString());
        }
        return localeListCompat.f() ? t02 : localeListCompat;
    }

    public boolean X0() {
        if (this.f3835i0 == null) {
            return false;
        }
        PanelFeatureState u02 = u0(0, false);
        if ((u02 == null || !u02.f3868o) && this.f3848v == null) {
            return false;
        }
        return true;
    }

    public final int Y() {
        int i11 = this.U;
        return i11 != -100 ? i11 : AppCompatDelegate.m();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.ActionMode Y0(androidx.appcompat.view.ActionMode.Callback r8) {
        /*
            r7 = this;
            r7.k0()
            androidx.appcompat.view.ActionMode r0 = r7.f3848v
            if (r0 == 0) goto L_0x000a
            r0.a()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.k
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$k r0 = new androidx.appcompat.app.AppCompatDelegateImpl$k
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.a r0 = r7.f3841o
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.S
            if (r2 != 0) goto L_0x0022
            androidx.appcompat.view.ActionMode r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.f3848v = r0
            goto L_0x015b
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f3849w
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r7.K
            if (r0 == 0) goto L_0x00b5
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f3838l
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R$attr.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.f3838l
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.ContextThemeWrapper r4 = new androidx.appcompat.view.ContextThemeWrapper
            android.content.Context r6 = r7.f3838l
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.f3838l
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.f3849w = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R$attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.f3850x = r5
            r6 = 2
            androidx.core.widget.k.b(r5, r6)
            android.widget.PopupWindow r5 = r7.f3850x
            androidx.appcompat.widget.ActionBarContextView r6 = r7.f3849w
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.f3850x
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R$attr.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f3849w
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.f3850x
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$f r0 = new androidx.appcompat.app.AppCompatDelegateImpl$f
            r0.<init>()
            r7.f3851y = r0
            goto L_0x00d4
        L_0x00b5:
            android.view.ViewGroup r0 = r7.C
            int r4 = androidx.appcompat.R$id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d4
            android.content.Context r4 = r7.p0()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.f3849w = r0
        L_0x00d4:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f3849w
            if (r0 == 0) goto L_0x015b
            r7.k0()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f3849w
            r0.k()
            androidx.appcompat.view.a r0 = new androidx.appcompat.view.a
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f3849w
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.f3849w
            android.widget.PopupWindow r6 = r7.f3850x
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r3 = r2
        L_0x00f0:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.c()
            boolean r8 = r8.a(r0, r3)
            if (r8 == 0) goto L_0x0159
            r0.i()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f3849w
            r8.h(r0)
            r7.f3848v = r0
            boolean r8 = r7.V0()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012a
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f3849w
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f3849w
            androidx.core.view.n0 r8 = androidx.core.view.h0.e(r8)
            androidx.core.view.n0 r8 = r8.b(r0)
            r7.f3852z = r8
            androidx.appcompat.app.AppCompatDelegateImpl$g r0 = new androidx.appcompat.app.AppCompatDelegateImpl$g
            r0.<init>()
            r8.j(r0)
            goto L_0x0149
        L_0x012a:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f3849w
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f3849w
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f3849w
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0149
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f3849w
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.view.h0.u0(r8)
        L_0x0149:
            android.widget.PopupWindow r8 = r7.f3850x
            if (r8 == 0) goto L_0x015b
            android.view.Window r8 = r7.f3839m
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.f3851y
            r8.post(r0)
            goto L_0x015b
        L_0x0159:
            r7.f3848v = r1
        L_0x015b:
            androidx.appcompat.view.ActionMode r8 = r7.f3848v
            if (r8 == 0) goto L_0x0166
            androidx.appcompat.app.a r0 = r7.f3841o
            if (r0 == 0) goto L_0x0166
            r0.onSupportActionModeStarted(r8)
        L_0x0166:
            r7.d1()
            androidx.appcompat.view.ActionMode r8 = r7.f3848v
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.Y0(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    public void Z(int i11, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i11 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.N;
                if (i11 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i11];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f3863j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f3868o) && !this.S) {
            this.f3840n.d(this.f3839m.getCallback(), i11, menu);
        }
    }

    public final void Z0() {
        if (this.B) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public void a0(androidx.appcompat.view.menu.e eVar) {
        if (!this.M) {
            this.M = true;
            this.f3845s.i();
            Window.Callback w02 = w0();
            if (w02 != null && !this.S) {
                w02.onPanelClosed(108, eVar);
            }
            this.M = false;
        }
    }

    public final AppCompatActivity a1() {
        Context context = this.f3838l;
        while (context != null) {
            if (!(context instanceof AppCompatActivity)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (AppCompatActivity) context;
            }
        }
        return null;
    }

    public final void b0() {
        s sVar = this.Y;
        if (sVar != null) {
            sVar.a();
        }
        s sVar2 = this.Z;
        if (sVar2 != null) {
            sVar2.a();
        }
    }

    public final void b1(Configuration configuration) {
        Activity activity = (Activity) this.f3837k;
        if (activity instanceof LifecycleOwner) {
            if (((LifecycleOwner) activity).getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else if (this.R && !this.S) {
            activity.onConfigurationChanged(configuration);
        }
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        l0();
        ((ViewGroup) this.C.findViewById(16908290)).addView(view, layoutParams);
        this.f3840n.c(this.f3839m.getCallback());
    }

    public void c0(int i11) {
        d0(u0(i11, true), true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c1(int r9, androidx.core.os.LocaleListCompat r10, boolean r11) {
        /*
            r8 = this;
            android.content.Context r1 = r8.f3838l
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            android.content.res.Configuration r0 = r0.e0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r8.f3838l
            int r1 = r8.q0(r1)
            android.content.res.Configuration r2 = r8.T
            if (r2 != 0) goto L_0x001f
            android.content.Context r2 = r8.f3838l
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L_0x001f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.LocaleListCompat r2 = r8.t0(r2)
            r5 = 0
            if (r10 != 0) goto L_0x0030
            r0 = r5
            goto L_0x0034
        L_0x0030:
            androidx.core.os.LocaleListCompat r0 = r8.t0(r0)
        L_0x0034:
            r6 = 0
            if (r3 == r4) goto L_0x003a
            r3 = 512(0x200, float:7.175E-43)
            goto L_0x003b
        L_0x003a:
            r3 = r6
        L_0x003b:
            if (r0 == 0) goto L_0x004d
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004d
            r3 = r3 | 4
            int r2 = android.os.Build.VERSION.SDK_INT
            r7 = 17
            if (r2 < r7) goto L_0x004d
            r3 = r3 | 8192(0x2000, float:1.14794E-41)
        L_0x004d:
            int r2 = ~r1
            r2 = r2 & r3
            r7 = 1
            if (r2 == 0) goto L_0x0077
            if (r11 == 0) goto L_0x0077
            boolean r11 = r8.Q
            if (r11 == 0) goto L_0x0077
            boolean r11 = f3824n0
            if (r11 != 0) goto L_0x0060
            boolean r11 = r8.R
            if (r11 == 0) goto L_0x0077
        L_0x0060:
            java.lang.Object r11 = r8.f3837k
            boolean r2 = r11 instanceof android.app.Activity
            if (r2 == 0) goto L_0x0077
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L_0x0077
            java.lang.Object r11 = r8.f3837k
            android.app.Activity r11 = (android.app.Activity) r11
            androidx.core.app.ActivityCompat.recreate(r11)
            r11 = r7
            goto L_0x0078
        L_0x0077:
            r11 = r6
        L_0x0078:
            if (r11 != 0) goto L_0x0085
            if (r3 == 0) goto L_0x0085
            r11 = r3 & r1
            if (r11 != r3) goto L_0x0081
            r6 = r7
        L_0x0081:
            r8.e1(r4, r0, r6, r5)
            goto L_0x0086
        L_0x0085:
            r7 = r11
        L_0x0086:
            if (r7 == 0) goto L_0x00a2
            java.lang.Object r11 = r8.f3837k
            boolean r1 = r11 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L_0x00a2
            r1 = r3 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0097
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            r11.onNightModeChanged(r9)
        L_0x0097:
            r9 = r3 & 4
            if (r9 == 0) goto L_0x00a2
            java.lang.Object r9 = r8.f3837k
            androidx.appcompat.app.AppCompatActivity r9 = (androidx.appcompat.app.AppCompatActivity) r9
            r9.onLocalesChanged(r10)
        L_0x00a2:
            if (r7 == 0) goto L_0x00b7
            if (r0 == 0) goto L_0x00b7
            android.content.Context r9 = r8.f3838l
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            androidx.core.os.LocaleListCompat r9 = r8.t0(r9)
            r8.U0(r9)
        L_0x00b7:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.c1(int, androidx.core.os.LocaleListCompat, boolean):boolean");
    }

    public boolean d() {
        return T(true);
    }

    public void d0(PanelFeatureState panelFeatureState, boolean z11) {
        ViewGroup viewGroup;
        androidx.appcompat.widget.p pVar;
        if (!z11 || panelFeatureState.f3854a != 0 || (pVar = this.f3845s) == null || !pVar.c()) {
            WindowManager windowManager = (WindowManager) this.f3838l.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.f3868o || (viewGroup = panelFeatureState.f3860g) == null)) {
                windowManager.removeView(viewGroup);
                if (z11) {
                    Z(panelFeatureState.f3854a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.f3866m = false;
            panelFeatureState.f3867n = false;
            panelFeatureState.f3868o = false;
            panelFeatureState.f3861h = null;
            panelFeatureState.f3870q = true;
            if (this.O == panelFeatureState) {
                this.O = null;
            }
            if (panelFeatureState.f3854a == 0) {
                d1();
                return;
            }
            return;
        }
        a0(panelFeatureState.f3863j);
    }

    public void d1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean X0 = X0();
            if (X0 && this.f3836j0 == null) {
                this.f3836j0 = p.b(this.f3835i0, this);
            } else if (!X0 && (onBackInvokedCallback = this.f3836j0) != null) {
                p.c(this.f3835i0, onBackInvokedCallback);
            }
        }
    }

    public final Configuration e0(Context context, int i11, LocaleListCompat localeListCompat, Configuration configuration, boolean z11) {
        int i12;
        if (i11 != 1) {
            i12 = i11 != 2 ? z11 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32;
        } else {
            i12 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i12 | (configuration2.uiMode & -49);
        if (localeListCompat != null) {
            T0(configuration2, localeListCompat);
        }
        return configuration2;
    }

    public final void e1(int i11, LocaleListCompat localeListCompat, boolean z11, Configuration configuration) {
        Resources resources = this.f3838l.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i11 | (resources.getConfiguration().uiMode & -49);
        if (localeListCompat != null) {
            T0(configuration2, localeListCompat);
        }
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 26) {
            k.a(resources);
        }
        int i13 = this.V;
        if (i13 != 0) {
            this.f3838l.setTheme(i13);
            if (i12 >= 23) {
                this.f3838l.getTheme().applyStyle(this.V, true);
            }
        }
        if (z11 && (this.f3837k instanceof Activity)) {
            b1(configuration2);
        }
    }

    public final ViewGroup f0() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f3838l.obtainStyledAttributes(R$styleable.AppCompatTheme);
        int i11 = R$styleable.AppCompatTheme_windowActionBar;
        if (obtainStyledAttributes.hasValue(i11)) {
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
                H(1);
            } else if (obtainStyledAttributes.getBoolean(i11, false)) {
                H(108);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                H(109);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                H(10);
            }
            this.K = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            m0();
            this.f3839m.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f3838l);
            if (this.L) {
                viewGroup = this.J ? (ViewGroup) from.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
            } else if (this.K) {
                viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
                this.I = false;
                this.H = false;
            } else if (this.H) {
                TypedValue typedValue = new TypedValue();
                this.f3838l.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new ContextThemeWrapper(this.f3838l, typedValue.resourceId);
                } else {
                    context = this.f3838l;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
                androidx.appcompat.widget.p pVar = (androidx.appcompat.widget.p) viewGroup.findViewById(R$id.decor_content_parent);
                this.f3845s = pVar;
                pVar.setWindowCallback(w0());
                if (this.I) {
                    this.f3845s.h(109);
                }
                if (this.F) {
                    this.f3845s.h(2);
                }
                if (this.G) {
                    this.f3845s.h(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    h0.O0(viewGroup, new c());
                } else if (viewGroup instanceof androidx.appcompat.widget.s) {
                    ((androidx.appcompat.widget.s) viewGroup).setOnFitSystemWindowsListener(new d());
                }
                if (this.f3845s == null) {
                    this.D = (TextView) viewGroup.findViewById(R$id.title);
                }
                androidx.appcompat.widget.o0.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f3839m.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f3839m.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new e());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.H + ", windowActionBarOverlay: " + this.I + ", android:windowIsFloating: " + this.K + ", windowActionModeOverlay: " + this.J + ", windowNoTitle: " + this.L + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    public final int f1(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        int i11;
        boolean z11;
        int i12;
        int i13;
        boolean z12;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i14;
        int i15 = 0;
        if (windowInsetsCompat != null) {
            i11 = windowInsetsCompat.m();
        } else {
            i11 = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.f3849w;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z11 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f3849w.getLayoutParams();
            boolean z13 = true;
            if (this.f3849w.isShown()) {
                if (this.f3831e0 == null) {
                    this.f3831e0 = new Rect();
                    this.f3832f0 = new Rect();
                }
                Rect rect2 = this.f3831e0;
                Rect rect3 = this.f3832f0;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.k(), windowInsetsCompat.m(), windowInsetsCompat.l(), windowInsetsCompat.j());
                }
                androidx.appcompat.widget.o0.a(this.C, rect2, rect3);
                int i16 = rect2.top;
                int i17 = rect2.left;
                int i18 = rect2.right;
                WindowInsetsCompat N2 = h0.N(this.C);
                if (N2 == null) {
                    i12 = 0;
                } else {
                    i12 = N2.k();
                }
                if (N2 == null) {
                    i13 = 0;
                } else {
                    i13 = N2.l();
                }
                if (marginLayoutParams2.topMargin == i16 && marginLayoutParams2.leftMargin == i17 && marginLayoutParams2.rightMargin == i18) {
                    z12 = false;
                } else {
                    marginLayoutParams2.topMargin = i16;
                    marginLayoutParams2.leftMargin = i17;
                    marginLayoutParams2.rightMargin = i18;
                    z12 = true;
                }
                if (i16 <= 0 || this.E != null) {
                    View view = this.E;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i14 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == i12 && marginLayoutParams.rightMargin == i13))) {
                        marginLayoutParams.height = i14;
                        marginLayoutParams.leftMargin = i12;
                        marginLayoutParams.rightMargin = i13;
                        this.E.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.f3838l);
                    this.E = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = i12;
                    layoutParams.rightMargin = i13;
                    this.C.addView(this.E, -1, layoutParams);
                }
                View view3 = this.E;
                if (view3 == null) {
                    z13 = false;
                }
                if (z13 && view3.getVisibility() != 0) {
                    g1(this.E);
                }
                if (!this.J && z13) {
                    i11 = 0;
                }
                z11 = z13;
                z13 = z12;
            } else if (marginLayoutParams2.topMargin != 0) {
                marginLayoutParams2.topMargin = 0;
                z11 = false;
            } else {
                z11 = false;
                z13 = false;
            }
            if (z13) {
                this.f3849w.setLayoutParams(marginLayoutParams2);
            }
        }
        View view4 = this.E;
        if (view4 != null) {
            if (!z11) {
                i15 = 8;
            }
            view4.setVisibility(i15);
        }
        return i11;
    }

    public Context g(Context context) {
        boolean z11 = true;
        this.Q = true;
        int D0 = D0(context, Y());
        if (AppCompatDelegate.v(context)) {
            AppCompatDelegate.S(context);
        }
        LocaleListCompat X2 = X(context);
        if (f3825t0 && (context instanceof android.view.ContextThemeWrapper)) {
            try {
                u.a((android.view.ContextThemeWrapper) context, e0(context, D0, X2, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(e0(context, D0, X2, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f3824n0) {
            return super.g(context);
        }
        Configuration configuration = null;
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = l.a(context, configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = o0(configuration3, configuration4);
            }
        }
        Configuration e02 = e0(context, D0, X2, configuration, true);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, R$style.Theme_AppCompat_Empty);
        contextThemeWrapper.applyOverrideConfiguration(e02);
        boolean z12 = false;
        try {
            if (context.getTheme() == null) {
                z11 = false;
            }
            z12 = z11;
        } catch (NullPointerException unused3) {
        }
        if (z12) {
            ResourcesCompat.f.a(contextThemeWrapper.getTheme());
        }
        return super.g(contextThemeWrapper);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
        if (((org.xmlpull.v1.XmlPullParser) r15).getDepth() > 1) goto L_0x008a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View g0(android.view.View r12, java.lang.String r13, android.content.Context r14, android.util.AttributeSet r15) {
        /*
            r11 = this;
            androidx.appcompat.app.AppCompatViewInflater r0 = r11.f3833g0
            r1 = 0
            if (r0 != 0) goto L_0x005b
            android.content.Context r0 = r11.f3838l
            int[] r2 = androidx.appcompat.R$styleable.AppCompatTheme
            android.content.res.TypedArray r0 = r0.obtainStyledAttributes(r2)
            int r2 = androidx.appcompat.R$styleable.AppCompatTheme_viewInflaterClass
            java.lang.String r0 = r0.getString(r2)
            if (r0 != 0) goto L_0x001d
            androidx.appcompat.app.AppCompatViewInflater r0 = new androidx.appcompat.app.AppCompatViewInflater
            r0.<init>()
            r11.f3833g0 = r0
            goto L_0x005b
        L_0x001d:
            android.content.Context r2 = r11.f3838l     // Catch:{ all -> 0x0038 }
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ all -> 0x0038 }
            java.lang.Class r2 = r2.loadClass(r0)     // Catch:{ all -> 0x0038 }
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ all -> 0x0038 }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ all -> 0x0038 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0038 }
            java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ all -> 0x0038 }
            androidx.appcompat.app.AppCompatViewInflater r2 = (androidx.appcompat.app.AppCompatViewInflater) r2     // Catch:{ all -> 0x0038 }
            r11.f3833g0 = r2     // Catch:{ all -> 0x0038 }
            goto L_0x005b
        L_0x0038:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to instantiate custom view inflater "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = ". Falling back to default."
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r3 = "AppCompatDelegate"
            android.util.Log.i(r3, r0, r2)
            androidx.appcompat.app.AppCompatViewInflater r0 = new androidx.appcompat.app.AppCompatViewInflater
            r0.<init>()
            r11.f3833g0 = r0
        L_0x005b:
            boolean r8 = f3822l0
            r0 = 1
            if (r8 == 0) goto L_0x008b
            androidx.appcompat.app.h r2 = r11.f3834h0
            if (r2 != 0) goto L_0x006b
            androidx.appcompat.app.h r2 = new androidx.appcompat.app.h
            r2.<init>()
            r11.f3834h0 = r2
        L_0x006b:
            androidx.appcompat.app.h r2 = r11.f3834h0
            boolean r2 = r2.a(r15)
            if (r2 == 0) goto L_0x0075
            r7 = r0
            goto L_0x008c
        L_0x0075:
            boolean r2 = r15 instanceof org.xmlpull.v1.XmlPullParser
            if (r2 == 0) goto L_0x0083
            r2 = r15
            org.xmlpull.v1.XmlPullParser r2 = (org.xmlpull.v1.XmlPullParser) r2
            int r2 = r2.getDepth()
            if (r2 <= r0) goto L_0x008b
            goto L_0x008a
        L_0x0083:
            r0 = r12
            android.view.ViewParent r0 = (android.view.ViewParent) r0
            boolean r0 = r11.W0(r0)
        L_0x008a:
            r1 = r0
        L_0x008b:
            r7 = r1
        L_0x008c:
            androidx.appcompat.app.AppCompatViewInflater r2 = r11.f3833g0
            r9 = 1
            boolean r10 = androidx.appcompat.widget.n0.d()
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            android.view.View r12 = r2.createView(r3, r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.g0(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final void g1(View view) {
        int i11;
        if ((h0.T(view) & 8192) != 0) {
            i11 = ContextCompat.getColor(this.f3838l, R$color.abc_decor_view_status_guard_light);
        } else {
            i11 = ContextCompat.getColor(this.f3838l, R$color.abc_decor_view_status_guard);
        }
        view.setBackgroundColor(i11);
    }

    public void h0() {
        androidx.appcompat.view.menu.e eVar;
        androidx.appcompat.widget.p pVar = this.f3845s;
        if (pVar != null) {
            pVar.i();
        }
        if (this.f3850x != null) {
            this.f3839m.getDecorView().removeCallbacks(this.f3851y);
            if (this.f3850x.isShowing()) {
                try {
                    this.f3850x.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f3850x = null;
        }
        k0();
        PanelFeatureState u02 = u0(0, false);
        if (u02 != null && (eVar = u02.f3863j) != null) {
            eVar.close();
        }
    }

    public boolean i0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f3837k;
        boolean z11 = true;
        if (((obj instanceof g.a) || (obj instanceof e)) && (decorView = this.f3839m.getDecorView()) != null && androidx.core.view.g.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f3840n.b(this.f3839m.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z11 = false;
        }
        return z11 ? F0(keyCode, keyEvent) : I0(keyCode, keyEvent);
    }

    public <T extends View> T j(int i11) {
        l0();
        return this.f3839m.findViewById(i11);
    }

    public void j0(int i11) {
        PanelFeatureState u02;
        PanelFeatureState u03 = u0(i11, true);
        if (u03.f3863j != null) {
            Bundle bundle = new Bundle();
            u03.f3863j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                u03.f3872s = bundle;
            }
            u03.f3863j.stopDispatchingItemsChanged();
            u03.f3863j.clear();
        }
        u03.f3871r = true;
        u03.f3870q = true;
        if ((i11 == 108 || i11 == 0) && this.f3845s != null && (u02 = u0(0, false)) != null) {
            u02.f3866m = false;
            Q0(u02, (KeyEvent) null);
        }
    }

    public void k0() {
        n0 n0Var = this.f3852z;
        if (n0Var != null) {
            n0Var.c();
        }
    }

    public Context l() {
        return this.f3838l;
    }

    public final void l0() {
        if (!this.B) {
            this.C = f0();
            CharSequence v02 = v0();
            if (!TextUtils.isEmpty(v02)) {
                androidx.appcompat.widget.p pVar = this.f3845s;
                if (pVar != null) {
                    pVar.setWindowTitle(v02);
                } else if (O0() != null) {
                    O0().setWindowTitle(v02);
                } else {
                    TextView textView = this.D;
                    if (textView != null) {
                        textView.setText(v02);
                    }
                }
            }
            V();
            M0(this.C);
            this.B = true;
            PanelFeatureState u02 = u0(0, false);
            if (this.S) {
                return;
            }
            if (u02 == null || u02.f3863j == null) {
                B0(108);
            }
        }
    }

    public final void m0() {
        if (this.f3839m == null) {
            Object obj = this.f3837k;
            if (obj instanceof Activity) {
                W(((Activity) obj).getWindow());
            }
        }
        if (this.f3839m == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final ActionBarDrawerToggle$Delegate n() {
        return new h();
    }

    public PanelFeatureState n0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.N;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i11 = 0; i11 < length; i11++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i11];
            if (panelFeatureState != null && panelFeatureState.f3863j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public int o() {
        return this.U;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return g0(view, str, context, attributeSet);
    }

    public boolean onMenuItemSelected(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        PanelFeatureState n02;
        Window.Callback w02 = w0();
        if (w02 == null || this.S || (n02 = n0(eVar.getRootMenu())) == null) {
            return false;
        }
        return w02.onMenuItemSelected(n02.f3854a, menuItem);
    }

    public void onMenuModeChange(androidx.appcompat.view.menu.e eVar) {
        R0(true);
    }

    public final Context p0() {
        ActionBar s11 = s();
        Context themedContext = s11 != null ? s11.getThemedContext() : null;
        return themedContext == null ? this.f3838l : themedContext;
    }

    public MenuInflater q() {
        if (this.f3843q == null) {
            x0();
            ActionBar actionBar = this.f3842p;
            this.f3843q = new g.c(actionBar != null ? actionBar.getThemedContext() : this.f3838l);
        }
        return this.f3843q;
    }

    public final int q0(Context context) {
        if (!this.X && (this.f3837k instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i11 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f3837k.getClass()), i11 >= 29 ? 269221888 : i11 >= 24 ? 786432 : 0);
                if (activityInfo != null) {
                    this.W = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e11) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e11);
                this.W = 0;
            }
        }
        this.X = true;
        return this.W;
    }

    public final s r0(Context context) {
        if (this.Z == null) {
            this.Z = new r(context);
        }
        return this.Z;
    }

    public ActionBar s() {
        x0();
        return this.f3842p;
    }

    public final s s0(Context context) {
        if (this.Y == null) {
            this.Y = new t(m.a(context));
        }
        return this.Y;
    }

    public void t() {
        LayoutInflater from = LayoutInflater.from(this.f3838l);
        if (from.getFactory() == null) {
            androidx.core.view.h.b(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public LocaleListCompat t0(Configuration configuration) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            return n.b(configuration);
        }
        if (i11 >= 21) {
            return LocaleListCompat.c(m.b(configuration.locale));
        }
        return LocaleListCompat.a(configuration.locale);
    }

    public void u() {
        if (O0() != null && !s().invalidateOptionsMenu()) {
            B0(0);
        }
    }

    public PanelFeatureState u0(int i11, boolean z11) {
        PanelFeatureState[] panelFeatureStateArr = this.N;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i11) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i11 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.N = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i11];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i11);
        panelFeatureStateArr[i11] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final CharSequence v0() {
        Object obj = this.f3837k;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f3844r;
    }

    public final Window.Callback w0() {
        return this.f3839m.getCallback();
    }

    public void x(Configuration configuration) {
        ActionBar s11;
        if (this.H && this.B && (s11 = s()) != null) {
            s11.onConfigurationChanged(configuration);
        }
        AppCompatDrawableManager.b().g(this.f3838l);
        this.T = new Configuration(this.f3838l.getResources().getConfiguration());
        U(false, false);
    }

    public final void x0() {
        l0();
        if (this.H && this.f3842p == null) {
            Object obj = this.f3837k;
            if (obj instanceof Activity) {
                this.f3842p = new WindowDecorActionBar((Activity) this.f3837k, this.I);
            } else if (obj instanceof Dialog) {
                this.f3842p = new WindowDecorActionBar((Dialog) this.f3837k);
            }
            ActionBar actionBar = this.f3842p;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.f3830d0);
            }
        }
    }

    public void y(Bundle bundle) {
        this.Q = true;
        T(false);
        m0();
        Object obj = this.f3837k;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = p0.j.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar O0 = O0();
                if (O0 == null) {
                    this.f3830d0 = true;
                } else {
                    O0.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            AppCompatDelegate.b(this);
        }
        this.T = new Configuration(this.f3838l.getResources().getConfiguration());
        this.R = true;
    }

    public final boolean y0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f3862i;
        if (view != null) {
            panelFeatureState.f3861h = view;
            return true;
        } else if (panelFeatureState.f3863j == null) {
            return false;
        } else {
            if (this.f3847u == null) {
                this.f3847u = new v();
            }
            View view2 = (View) panelFeatureState.a(this.f3847u);
            panelFeatureState.f3861h = view2;
            if (view2 != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void z() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f3837k
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0009
            androidx.appcompat.app.AppCompatDelegate.F(r3)
        L_0x0009:
            boolean r0 = r3.f3827a0
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r3.f3839m
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f3829c0
            r0.removeCallbacks(r1)
        L_0x0018:
            r0 = 1
            r3.S = r0
            int r0 = r3.U
            r1 = -100
            if (r0 == r1) goto L_0x0045
            java.lang.Object r0 = r3.f3837k
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0045
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0045
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = f3821k0
            java.lang.Object r1 = r3.f3837k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.U
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0054
        L_0x0045:
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = f3821k0
            java.lang.Object r1 = r3.f3837k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0054:
            androidx.appcompat.app.ActionBar r0 = r3.f3842p
            if (r0 == 0) goto L_0x005b
            r0.onDestroy()
        L_0x005b:
            r3.b0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.z():void");
    }

    public final boolean z0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(p0());
        panelFeatureState.f3860g = new ListMenuDecorView(panelFeatureState.f3865l);
        panelFeatureState.f3856c = 81;
        return true;
    }

    public AppCompatDelegateImpl(Dialog dialog, a aVar) {
        this(dialog.getContext(), dialog.getWindow(), aVar, dialog);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        r3 = f3821k0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatDelegateImpl(android.content.Context r3, android.view.Window r4, androidx.appcompat.app.a r5, java.lang.Object r6) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.f3852z = r0
            r0 = 1
            r2.A = r0
            r0 = -100
            r2.U = r0
            androidx.appcompat.app.AppCompatDelegateImpl$b r1 = new androidx.appcompat.app.AppCompatDelegateImpl$b
            r1.<init>()
            r2.f3829c0 = r1
            r2.f3838l = r3
            r2.f3841o = r5
            r2.f3837k = r6
            int r3 = r2.U
            if (r3 != r0) goto L_0x0032
            boolean r3 = r6 instanceof android.app.Dialog
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.AppCompatActivity r3 = r2.a1()
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.AppCompatDelegate r3 = r3.getDelegate()
            int r3 = r3.o()
            r2.U = r3
        L_0x0032:
            int r3 = r2.U
            if (r3 != r0) goto L_0x0059
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r3 = f3821k0
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            java.lang.Object r5 = r3.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0059
            int r5 = r5.intValue()
            r2.U = r5
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            r3.remove(r5)
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r2.W(r4)
        L_0x005e:
            androidx.appcompat.widget.AppCompatDrawableManager.h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.<init>(android.content.Context, android.view.Window, androidx.appcompat.app.a, java.lang.Object):void");
    }

    public class q extends g.d {

        /* renamed from: c  reason: collision with root package name */
        public i f3886c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3887d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3888e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f3889f;

        public q(Window.Callback callback) {
            super(callback);
        }

        /* JADX INFO: finally extract failed */
        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f3888e = true;
                boolean dispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                this.f3888e = false;
                return dispatchKeyEvent;
            } catch (Throwable th2) {
                this.f3888e = false;
                throw th2;
            }
        }

        /* JADX INFO: finally extract failed */
        public void c(Window.Callback callback) {
            try {
                this.f3887d = true;
                callback.onContentChanged();
                this.f3887d = false;
            } catch (Throwable th2) {
                this.f3887d = false;
                throw th2;
            }
        }

        /* JADX INFO: finally extract failed */
        public void d(Window.Callback callback, int i11, Menu menu) {
            try {
                this.f3889f = true;
                callback.onPanelClosed(i11, menu);
                this.f3889f = false;
            } catch (Throwable th2) {
                this.f3889f = false;
                throw th2;
            }
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.f3888e) {
                return a().dispatchKeyEvent(keyEvent);
            }
            return AppCompatDelegateImpl.this.i0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.H0(keyEvent.getKeyCode(), keyEvent);
        }

        public void e(i iVar) {
            this.f3886c = iVar;
        }

        public final android.view.ActionMode f(ActionMode.Callback callback) {
            b.a aVar = new b.a(AppCompatDelegateImpl.this.f3838l, callback);
            androidx.appcompat.view.ActionMode R = AppCompatDelegateImpl.this.R(aVar);
            if (R != null) {
                return aVar.e(R);
            }
            return null;
        }

        public void onContentChanged() {
            if (this.f3887d) {
                a().onContentChanged();
            }
        }

        public boolean onCreatePanelMenu(int i11, Menu menu) {
            if (i11 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i11, menu);
            }
            return false;
        }

        public View onCreatePanelView(int i11) {
            View onCreatePanelView;
            i iVar = this.f3886c;
            if (iVar == null || (onCreatePanelView = iVar.onCreatePanelView(i11)) == null) {
                return super.onCreatePanelView(i11);
            }
            return onCreatePanelView;
        }

        public boolean onMenuOpened(int i11, Menu menu) {
            super.onMenuOpened(i11, menu);
            AppCompatDelegateImpl.this.K0(i11);
            return true;
        }

        public void onPanelClosed(int i11, Menu menu) {
            if (this.f3889f) {
                a().onPanelClosed(i11, menu);
                return;
            }
            super.onPanelClosed(i11, menu);
            AppCompatDelegateImpl.this.L0(i11);
        }

        public boolean onPreparePanel(int i11, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i11 == 0 && eVar == null) {
                return false;
            }
            boolean z11 = true;
            if (eVar != null) {
                eVar.setOverrideVisibleItems(true);
            }
            i iVar = this.f3886c;
            if (iVar == null || !iVar.a(i11)) {
                z11 = false;
            }
            if (!z11) {
                z11 = super.onPreparePanel(i11, view, menu);
            }
            if (eVar != null) {
                eVar.setOverrideVisibleItems(false);
            }
            return z11;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i11) {
            androidx.appcompat.view.menu.e eVar;
            PanelFeatureState u02 = AppCompatDelegateImpl.this.u0(0, true);
            if (u02 == null || (eVar = u02.f3863j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i11);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i11);
            }
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.C0()) {
                return f(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i11) {
            if (!AppCompatDelegateImpl.this.C0() || i11 != 0) {
                return super.onWindowStartingActionMode(callback, i11);
            }
            return f(callback);
        }
    }
}
