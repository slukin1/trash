package zendesk.belvedere;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.h0;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import f30.i;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import zendesk.belvedere.BelvedereUi;
import zendesk.belvedere.KeyboardHelper;
import zendesk.belvedere.b;
import zendesk.belvedere.ui.R$attr;
import zendesk.belvedere.ui.R$color;
import zendesk.belvedere.ui.R$dimen;
import zendesk.belvedere.ui.R$drawable;
import zendesk.belvedere.ui.R$id;
import zendesk.belvedere.ui.R$integer;
import zendesk.belvedere.ui.R$layout;
import zendesk.belvedere.ui.R$string;

public class g extends PopupWindow implements e {

    /* renamed from: b  reason: collision with root package name */
    public final f f62306b;

    /* renamed from: c  reason: collision with root package name */
    public final b f62307c = new b();

    /* renamed from: d  reason: collision with root package name */
    public final List<Integer> f62308d;

    /* renamed from: e  reason: collision with root package name */
    public KeyboardHelper f62309e;

    /* renamed from: f  reason: collision with root package name */
    public View f62310f;

    /* renamed from: g  reason: collision with root package name */
    public View f62311g;

    /* renamed from: h  reason: collision with root package name */
    public View f62312h;

    /* renamed from: i  reason: collision with root package name */
    public View f62313i;

    /* renamed from: j  reason: collision with root package name */
    public FloatingActionMenu f62314j;

    /* renamed from: k  reason: collision with root package name */
    public RecyclerView f62315k;

    /* renamed from: l  reason: collision with root package name */
    public Toolbar f62316l;

    /* renamed from: m  reason: collision with root package name */
    public BottomSheetBehavior<View> f62317m;

    /* renamed from: n  reason: collision with root package name */
    public Activity f62318n;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f62319b;

        public a(boolean z11) {
            this.f62319b = z11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (!this.f62319b) {
                g.this.f62317m.setState(4);
            } else {
                g.this.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b extends BottomSheetBehavior.BottomSheetCallback {
        public b() {
        }

        public void onSlide(View view, float f11) {
        }

        public void onStateChanged(View view, int i11) {
            if (i11 == 5) {
                g.this.dismiss();
            }
        }
    }

    public class c implements KeyboardHelper.d {
        public c() {
        }

        public void a(int i11) {
            if (i11 != g.this.f62317m.getPeekHeight()) {
                g.this.f62317m.setPeekHeight(g.this.f62310f.getPaddingTop() + g.this.f62309e.getKeyboardHeight());
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            g.this.f62306b.o();
            g.this.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f62324b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f62325c;

        public e(List list, Activity activity) {
            this.f62324b = list;
            this.f62325c = activity;
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z11;
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            Iterator it2 = this.f62324b.iterator();
            while (true) {
                z11 = false;
                if (!it2.hasNext()) {
                    z11 = true;
                    break;
                }
                View findViewById = this.f62325c.findViewById(((Integer) it2.next()).intValue());
                if (findViewById != null) {
                    Rect rect = new Rect();
                    findViewById.getGlobalVisibleRect(rect);
                    boolean z12 = rawX >= rect.left && rawX <= rect.right;
                    boolean z13 = rawY >= rect.top && rawY <= rect.bottom;
                    if (z12 && z13) {
                        this.f62325c.dispatchTouchEvent(MotionEvent.obtain(motionEvent));
                        break;
                    }
                }
            }
            if (z11) {
                g.this.dismiss();
            }
            return true;
        }
    }

    public class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Window f62327b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f62328c;

        public f(Window window, ValueAnimator valueAnimator) {
            this.f62327b = window;
            this.f62328c = valueAnimator;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f62327b.setStatusBarColor(((Integer) this.f62328c.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: zendesk.belvedere.g$g  reason: collision with other inner class name */
    public class C0684g extends CoordinatorLayout.Behavior<View> {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f62330a;

        public /* synthetic */ C0684g(g gVar, boolean z11, a aVar) {
            this(z11);
        }

        public final void b(int i11, float f11, int i12, View view) {
            float f12 = (float) i11;
            float f13 = f12 - (f11 * f12);
            float f14 = (float) i12;
            if (f13 <= f14) {
                i.g(g.this.getContentView(), true);
                view.setAlpha(1.0f - (f13 / f14));
                view.setY(f13);
            } else {
                i.g(g.this.getContentView(), false);
            }
            g.this.w(f11);
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2.getId() == R$id.bottom_sheet;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            int height = coordinatorLayout.getHeight() - g.this.f62317m.getPeekHeight();
            float height2 = ((((float) coordinatorLayout.getHeight()) - view2.getY()) - ((float) g.this.f62317m.getPeekHeight())) / ((float) height);
            b(height, height2, h0.G(g.this.f62316l), view);
            if (!this.f62330a) {
                return true;
            }
            g.this.f62306b.k(coordinatorLayout.getHeight(), height, height2);
            return true;
        }

        public C0684g(boolean z11) {
            this.f62330a = z11;
        }
    }

    public g(Activity activity, View view, ImageStream imageStream, BelvedereUi.UiConfig uiConfig) {
        super(view, -1, -1, false);
        setInputMethodMode(2);
        setFocusable(true);
        setTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        p(view);
        this.f62318n = activity;
        this.f62309e = imageStream.sh();
        this.f62308d = uiConfig.getTouchableElements();
        f fVar = new f(new d(view.getContext(), uiConfig), this, imageStream);
        this.f62306b = fVar;
        fVar.i();
    }

    public static g v(Activity activity, ViewGroup viewGroup, ImageStream imageStream, BelvedereUi.UiConfig uiConfig) {
        g gVar = new g(activity, LayoutInflater.from(activity).inflate(R$layout.belvedere_image_stream, viewGroup, false), imageStream, uiConfig);
        gVar.showAtLocation(viewGroup, 48, 0, 0);
        return gVar;
    }

    public void a(List<MediaResult> list, List<MediaResult> list2, boolean z11, boolean z12, b.C0682b bVar) {
        if (!z11) {
            KeyboardHelper.o(this.f62309e.getInputTrap());
        }
        ViewGroup.LayoutParams layoutParams = this.f62310f.getLayoutParams();
        layoutParams.height = -1;
        this.f62310f.setLayoutParams(layoutParams);
        if (z12) {
            this.f62307c.a(c.a(bVar));
        }
        this.f62307c.c(c.b(list, bVar, this.f62310f.getContext()));
        this.f62307c.d(list2);
        this.f62307c.notifyDataSetChanged();
    }

    public void b(View.OnClickListener onClickListener) {
        FloatingActionMenu floatingActionMenu = this.f62314j;
        if (floatingActionMenu != null) {
            floatingActionMenu.c(R$drawable.belvedere_ic_file, R$id.belvedere_fam_item_documents, R$string.belvedere_fam_desc_open_gallery, onClickListener);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        FloatingActionMenu floatingActionMenu = this.f62314j;
        if (floatingActionMenu != null) {
            floatingActionMenu.c(R$drawable.belvedere_ic_collections, R$id.belvedere_fam_item_google_photos, R$string.belvedere_fam_desc_open_google_photos, onClickListener);
        }
    }

    public void d(boolean z11) {
        t(this.f62307c);
        u(z11);
        q(z11);
        s(this.f62318n, this.f62308d);
        r(this.f62314j);
    }

    public void dismiss() {
        super.dismiss();
        w(0.0f);
        this.f62306b.g();
    }

    public void e(int i11) {
        if (i11 > 0) {
            String string = this.f62318n.getString(R$string.belvedere_image_stream_title);
            this.f62316l.setTitle((CharSequence) String.format(Locale.getDefault(), "%s (%d)", new Object[]{string, Integer.valueOf(i11)}));
            return;
        }
        this.f62316l.setTitle(R$string.belvedere_image_stream_title);
    }

    public void f(int i11) {
        if (i11 == 0) {
            this.f62314j.g();
        } else {
            this.f62314j.l();
        }
    }

    public void g(int i11) {
        Toast.makeText(this.f62318n, i11, 0).show();
    }

    public boolean h() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        if (Build.VERSION.SDK_INT >= 24 && (this.f62318n.isInMultiWindowMode() || this.f62318n.isInPictureInPictureMode())) {
            return true;
        }
        if (this.f62318n.getResources().getConfiguration().keyboard != 1) {
            return true;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f62318n.getSystemService("accessibility");
        if (accessibilityManager == null || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(47)) == null || enabledAccessibilityServiceList.size() <= 0) {
            return false;
        }
        return true;
    }

    public void i(MediaIntent mediaIntent, ImageStream imageStream) {
        mediaIntent.open((Fragment) imageStream);
    }

    public final void p(View view) {
        this.f62310f = view.findViewById(R$id.bottom_sheet);
        this.f62311g = view.findViewById(R$id.dismiss_area);
        this.f62315k = (RecyclerView) view.findViewById(R$id.image_list);
        this.f62316l = (Toolbar) view.findViewById(R$id.image_stream_toolbar);
        this.f62312h = view.findViewById(R$id.image_stream_toolbar_container);
        this.f62313i = view.findViewById(R$id.image_stream_compat_shadow);
        this.f62314j = (FloatingActionMenu) view.findViewById(R$id.floating_action_menu);
    }

    public final void q(boolean z11) {
        h0.F0(this.f62315k, (float) this.f62310f.getContext().getResources().getDimensionPixelSize(R$dimen.belvedere_bottom_sheet_elevation));
        BottomSheetBehavior<View> from = BottomSheetBehavior.from(this.f62310f);
        this.f62317m = from;
        from.addBottomSheetCallback(new b());
        i.g(getContentView(), false);
        if (!z11) {
            this.f62317m.setPeekHeight(this.f62310f.getPaddingTop() + this.f62309e.getKeyboardHeight());
            this.f62317m.setState(4);
            this.f62309e.setKeyboardHeightListener(new c());
        } else {
            this.f62317m.setSkipCollapsed(true);
            this.f62317m.setState(3);
            KeyboardHelper.k(this.f62318n);
        }
        this.f62315k.setClickable(true);
        this.f62310f.setVisibility(0);
    }

    public final void r(FloatingActionMenu floatingActionMenu) {
        floatingActionMenu.setOnSendClickListener(new d());
    }

    public final void s(Activity activity, List<Integer> list) {
        this.f62311g.setOnTouchListener(new e(list, activity));
    }

    public final void t(b bVar) {
        this.f62315k.setLayoutManager(new StaggeredGridLayoutManager(this.f62310f.getContext().getResources().getInteger(R$integer.belvedere_image_stream_column_count), 1));
        this.f62315k.setHasFixedSize(true);
        this.f62315k.setDrawingCacheEnabled(true);
        this.f62315k.setDrawingCacheQuality(1048576);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.f62315k.setItemAnimator(defaultItemAnimator);
        this.f62315k.setAdapter(bVar);
    }

    public final void u(boolean z11) {
        this.f62316l.setNavigationIcon(R$drawable.belvedere_ic_close);
        this.f62316l.setNavigationContentDescription(R$string.belvedere_toolbar_desc_collapse);
        this.f62316l.setBackgroundColor(-1);
        this.f62316l.setNavigationOnClickListener(new a(z11));
        if (Build.VERSION.SDK_INT < 21) {
            this.f62313i.setVisibility(0);
        }
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.f62312h.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.o(new C0684g(this, !z11, (a) null));
        }
    }

    public final void w(float f11) {
        int color = this.f62316l.getResources().getColor(R$color.belvedere_image_stream_status_bar_color);
        int a11 = i.a(this.f62316l.getContext(), R$attr.colorPrimaryDark);
        boolean z11 = f11 == 1.0f;
        Window window = this.f62318n.getWindow();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            if (!z11) {
                window.setStatusBarColor(a11);
            } else if (window.getStatusBarColor() == a11) {
                ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(a11), Integer.valueOf(color)});
                ofObject.setDuration(100);
                ofObject.addUpdateListener(new f(window, ofObject));
                ofObject.start();
            }
        }
        if (i11 >= 23) {
            View decorView = window.getDecorView();
            if (z11) {
                decorView.setSystemUiVisibility(8192);
            } else {
                decorView.setSystemUiVisibility(0);
            }
        }
    }
}
