package jumio.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.R;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

@SuppressLint({"ViewConstructor"})
public final class m extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public final p2 f56256a;

    public static final class a extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f56257a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f56258b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(m mVar, View view) {
            super(0);
            this.f56257a = mVar;
            this.f56258b = view;
        }

        public final Object invoke() {
            m.super.addView(this.f56258b);
            return Unit.f56620a;
        }
    }

    public static final class b extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f56259a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f56260b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56261c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(m mVar, View view, int i11) {
            super(0);
            this.f56259a = mVar;
            this.f56260b = view;
            this.f56261c = i11;
        }

        public final Object invoke() {
            m.super.addView(this.f56260b, this.f56261c);
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f56262a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f56263b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f56264c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(m mVar, View view, ViewGroup.LayoutParams layoutParams) {
            super(0);
            this.f56262a = mVar;
            this.f56263b = view;
            this.f56264c = layoutParams;
        }

        public final Object invoke() {
            m.super.addView(this.f56263b, this.f56264c);
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f56265a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f56266b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56267c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f56268d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(m mVar, View view, int i11, ViewGroup.LayoutParams layoutParams) {
            super(0);
            this.f56265a = mVar;
            this.f56266b = view;
            this.f56267c = i11;
            this.f56268d = layoutParams;
        }

        public final Object invoke() {
            m.super.addView(this.f56266b, this.f56267c, this.f56268d);
            return Unit.f56620a;
        }
    }

    public static final class e extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f56269a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f56270b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56271c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f56272d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(m mVar, View view, int i11, int i12) {
            super(0);
            this.f56269a = mVar;
            this.f56270b = view;
            this.f56271c = i11;
            this.f56272d = i12;
        }

        public final Object invoke() {
            m.super.addView(this.f56270b, this.f56271c, this.f56272d);
            return Unit.f56620a;
        }
    }

    public m(Context context, int i11) {
        super(context);
        int b11 = MathKt__MathJVMKt.b(ScreenUtil.dipToPx(context, 24.0f));
        setTag("jumio_branding_view");
        setOrientation(1);
        setPadding(b11, 0, b11, 0);
        p2 p2Var = new p2(context);
        p2Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        p2Var.setAdjustViewBounds(true);
        Drawable f11 = ResourcesCompat.f(p2Var.getResources(), R.drawable.jumio_ic_powered_by_jumio, context.getTheme());
        if (f11 != null) {
            u0.a.n(u0.a.r(f11), ResourcesCompat.d(p2Var.getResources(), i11, context.getTheme()));
            p2Var.setImageDrawable(f11);
        }
        this.f56256a = p2Var;
        addView(p2Var);
    }

    public static final void b(m mVar, View view) {
        mVar.f56256a.setVisibility(0);
        view.setVisibility(0);
    }

    public final void addView(View view) {
        a aVar = new a(this, view);
        if (getChildCount() > 0) {
            Log.d("BrandingView", "Tried to add child views, ignoring...");
        } else {
            aVar.invoke();
        }
    }

    public final void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (!x.b(view, this)) {
            return;
        }
        if (i11 == 8 || i11 == 4) {
            String a11 = n.a(i11);
            Log.d("BrandingView", "Visibility changed to: " + a11 + ". Resetting...");
            post(new t00.a(this, view));
        }
    }

    public final void removeAllViews() {
        a();
    }

    public final void removeAllViewsInLayout() {
        a();
    }

    public final void removeView(View view) {
        a();
    }

    public final void removeViewAt(int i11) {
        a();
    }

    public final void removeViewInLayout(View view) {
        a();
    }

    public final void removeViews(int i11, int i12) {
        a();
    }

    public final void removeViewsInLayout(int i11, int i12) {
        a();
    }

    public void setVisibility(int i11) {
        if (i11 == 4 || i11 == 8) {
            String a11 = n.a(i11);
            Log.d("BrandingView", "Tried to set visibility: " + a11 + ", ignoring...");
            return;
        }
        super.setVisibility(i11);
    }

    public final void addView(View view, int i11) {
        b bVar = new b(this, view, i11);
        if (getChildCount() > 0) {
            Log.d("BrandingView", "Tried to add child views, ignoring...");
        } else {
            bVar.invoke();
        }
    }

    public static void a() {
        Log.d("BrandingView", "Tried to remove child views, ignoring...");
    }

    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        c cVar = new c(this, view, layoutParams);
        if (getChildCount() > 0) {
            Log.d("BrandingView", "Tried to add child views, ignoring...");
        } else {
            cVar.invoke();
        }
    }

    public final void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        d dVar = new d(this, view, i11, layoutParams);
        if (getChildCount() > 0) {
            Log.d("BrandingView", "Tried to add child views, ignoring...");
        } else {
            dVar.invoke();
        }
    }

    public final void addView(View view, int i11, int i12) {
        e eVar = new e(this, view, i11, i12);
        if (getChildCount() > 0) {
            Log.d("BrandingView", "Tried to add child views, ignoring...");
        } else {
            eVar.invoke();
        }
    }
}
