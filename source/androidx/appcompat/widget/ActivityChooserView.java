package androidx.appcompat.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.h0;

public class ActivityChooserView extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public final f f4310b;

    /* renamed from: c  reason: collision with root package name */
    public final g f4311c;

    /* renamed from: d  reason: collision with root package name */
    public final View f4312d;

    /* renamed from: e  reason: collision with root package name */
    public final Drawable f4313e;

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f4314f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f4315g;

    /* renamed from: h  reason: collision with root package name */
    public final FrameLayout f4316h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f4317i;

    /* renamed from: j  reason: collision with root package name */
    public final int f4318j;

    /* renamed from: k  reason: collision with root package name */
    public androidx.core.view.a f4319k;

    /* renamed from: l  reason: collision with root package name */
    public final DataSetObserver f4320l;

    /* renamed from: m  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f4321m;

    /* renamed from: n  reason: collision with root package name */
    public ListPopupWindow f4322n;

    /* renamed from: o  reason: collision with root package name */
    public PopupWindow.OnDismissListener f4323o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4324p;

    /* renamed from: q  reason: collision with root package name */
    public int f4325q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4326r;

    /* renamed from: s  reason: collision with root package name */
    public int f4327s;

    public static class InnerLayout extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        public static final int[] f4328b = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            d0 u11 = d0.u(context, attributeSet, f4328b);
            setBackgroundDrawable(u11.g(0));
            u11.w();
        }
    }

    public class a extends DataSetObserver {
        public a() {
        }

        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f4310b.notifyDataSetChanged();
        }

        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f4310b.notifyDataSetInvalidated();
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        public void onGlobalLayout() {
            if (!ActivityChooserView.this.b()) {
                return;
            }
            if (!ActivityChooserView.this.isShown()) {
                ActivityChooserView.this.getListPopupWindow().dismiss();
                return;
            }
            ActivityChooserView.this.getListPopupWindow().show();
            androidx.core.view.a aVar = ActivityChooserView.this.f4319k;
            if (aVar != null) {
                aVar.k(true);
            }
        }
    }

    public class c extends View.AccessibilityDelegate {
        public c() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.U0(accessibilityNodeInfo).l0(true);
        }
    }

    public class d extends t {
        public d(View view) {
            super(view);
        }

        public h.e b() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        public boolean c() {
            ActivityChooserView.this.c();
            return true;
        }

        public boolean d() {
            ActivityChooserView.this.a();
            return true;
        }
    }

    public class e extends DataSetObserver {
        public e() {
        }

        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.e();
        }
    }

    public class f extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public b f4334b;

        /* renamed from: c  reason: collision with root package name */
        public int f4335c = 4;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4336d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4337e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4338f;

        public f() {
        }

        public int a() {
            throw null;
        }

        public b b() {
            return this.f4334b;
        }

        public ResolveInfo c() {
            throw null;
        }

        public int d() {
            throw null;
        }

        public boolean e() {
            return this.f4336d;
        }

        public void f(b bVar) {
            ActivityChooserView.this.f4310b.b();
            notifyDataSetChanged();
        }

        public int getCount() {
            throw null;
        }

        public Object getItem(int i11) {
            int itemViewType = getItemViewType(i11);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            } else if (!this.f4336d) {
                throw null;
            } else {
                throw null;
            }
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public int getItemViewType(int i11) {
            return (!this.f4338f || i11 != getCount() - 1) ? 0 : 1;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i11);
            if (itemViewType == 0) {
                if (view == null || view.getId() != R$id.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i11);
                ((ImageView) view.findViewById(R$id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R$id.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.f4336d || i11 != 0 || !this.f4337e) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R$id.title)).setText(ActivityChooserView.this.getContext().getString(R$string.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    public class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public g() {
        }

        public final void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f4323o;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f4316h) {
                activityChooserView.a();
                ActivityChooserView.this.f4310b.c();
                ActivityChooserView.this.f4310b.b();
                throw null;
            } else if (view == activityChooserView.f4314f) {
                activityChooserView.f4324p = false;
                activityChooserView.d(activityChooserView.f4325q);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            a();
            androidx.core.view.a aVar = ActivityChooserView.this.f4319k;
            if (aVar != null) {
                aVar.k(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            int itemViewType = ((f) adapterView.getAdapter()).getItemViewType(i11);
            if (itemViewType == 0) {
                ActivityChooserView.this.a();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (!activityChooserView.f4324p) {
                    activityChooserView.f4310b.e();
                    ActivityChooserView.this.f4310b.b();
                    throw null;
                } else if (i11 > 0) {
                    activityChooserView.f4310b.b();
                    throw null;
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.d(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f4316h) {
                if (activityChooserView.f4310b.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.f4324p = true;
                    activityChooserView2.d(activityChooserView2.f4325q);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean a() {
        if (!b()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f4321m);
        return true;
    }

    public boolean b() {
        return getListPopupWindow().isShowing();
    }

    public boolean c() {
        if (b() || !this.f4326r) {
            return false;
        }
        this.f4324p = false;
        d(this.f4325q);
        return true;
    }

    public void d(int i11) {
        this.f4310b.b();
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public void e() {
        if (this.f4310b.getCount() > 0) {
            this.f4314f.setEnabled(true);
        } else {
            this.f4314f.setEnabled(false);
        }
        int a11 = this.f4310b.a();
        int d11 = this.f4310b.d();
        if (a11 == 1 || (a11 > 1 && d11 > 0)) {
            this.f4316h.setVisibility(0);
            ResolveInfo c11 = this.f4310b.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f4317i.setImageDrawable(c11.loadIcon(packageManager));
            if (this.f4327s != 0) {
                CharSequence loadLabel = c11.loadLabel(packageManager);
                this.f4316h.setContentDescription(getContext().getString(this.f4327s, new Object[]{loadLabel}));
            }
        } else {
            this.f4316h.setVisibility(8);
        }
        if (this.f4316h.getVisibility() == 0) {
            this.f4312d.setBackgroundDrawable(this.f4313e);
        } else {
            this.f4312d.setBackgroundDrawable((Drawable) null);
        }
    }

    public b getDataModel() {
        return this.f4310b.b();
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.f4322n == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f4322n = listPopupWindow;
            listPopupWindow.m(this.f4310b);
            this.f4322n.A(this);
            this.f4322n.G(true);
            this.f4322n.I(this.f4311c);
            this.f4322n.H(this.f4311c);
        }
        return this.f4322n;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4310b.b();
        this.f4326r = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4310b.b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f4321m);
        }
        if (b()) {
            a();
        }
        this.f4326r = false;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.f4312d.layout(0, 0, i13 - i11, i14 - i12);
        if (!b()) {
            a();
        }
    }

    public void onMeasure(int i11, int i12) {
        View view = this.f4312d;
        if (this.f4316h.getVisibility() != 0) {
            i12 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12), 1073741824);
        }
        measureChild(view, i11, i12);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(b bVar) {
        this.f4310b.f(bVar);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i11) {
        this.f4327s = i11;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i11) {
        this.f4315g.setContentDescription(getContext().getString(i11));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f4315g.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i11) {
        this.f4325q = i11;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f4323o = onDismissListener;
    }

    public void setProvider(androidx.core.view.a aVar) {
        this.f4319k = aVar;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f4320l = new a();
        this.f4321m = new b();
        this.f4325q = 4;
        int[] iArr = R$styleable.ActivityChooserView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i11, 0);
        h0.v0(this, context, iArr, attributeSet, obtainStyledAttributes, i11, 0);
        this.f4325q = obtainStyledAttributes.getInt(R$styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.abc_activity_chooser_view, this, true);
        g gVar = new g();
        this.f4311c = gVar;
        View findViewById = findViewById(R$id.activity_chooser_view_content);
        this.f4312d = findViewById;
        this.f4313e = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.default_activity_button);
        this.f4316h = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        int i12 = R$id.image;
        this.f4317i = (ImageView) frameLayout.findViewById(i12);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.expand_activities_button);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new c());
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.f4314f = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i12);
        this.f4315g = imageView;
        imageView.setImageDrawable(drawable);
        f fVar = new f();
        this.f4310b = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        this.f4318j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
    }
}
