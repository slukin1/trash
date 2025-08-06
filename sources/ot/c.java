package ot;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public int f84557a;

    /* renamed from: b  reason: collision with root package name */
    public a f84558b;

    /* renamed from: c  reason: collision with root package name */
    public int f84559c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f84560d;

    /* renamed from: e  reason: collision with root package name */
    public int f84561e;

    /* renamed from: f  reason: collision with root package name */
    public int f84562f;

    /* renamed from: g  reason: collision with root package name */
    public View f84563g;

    /* renamed from: h  reason: collision with root package name */
    public e f84564h;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            c.this.m();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            c.this.n();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: ot.c$c  reason: collision with other inner class name */
    public class C0882c implements View.OnClickListener {
        public C0882c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            c.this.k();
            c.this.f84558b.a();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            c.this.k();
            c.this.f84558b.a();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface e {
        void Ze(c cVar);
    }

    public c(a aVar, int i11, int i12, e eVar) {
        this.f84557a = i12;
        this.f84558b = aVar;
        this.f84559c = i11;
        this.f84564h = eVar;
        if (i11 != 0) {
            if (i11 == 1) {
                this.f84561e = 2;
                this.f84562f = 1;
                return;
            } else if (i11 == 2 || i11 == 3) {
                this.f84561e = 2;
                this.f84562f = 2;
                return;
            } else if (i11 != 4) {
                if (i11 == 5) {
                    this.f84561e = 1;
                    this.f84562f = 1;
                    return;
                }
                return;
            }
        }
        this.f84561e = 1;
        this.f84562f = 2;
    }

    public static Display e(Context context) {
        WindowManager windowManager;
        if (context instanceof Activity) {
            windowManager = ((Activity) context).getWindowManager();
        } else {
            windowManager = (WindowManager) context.getSystemService("window");
        }
        if (windowManager != null) {
            return windowManager.getDefaultDisplay();
        }
        return null;
    }

    public static int f(Context context) {
        Display e11 = e(context);
        if (e11 == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        e11.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int g(Context context) {
        Display e11 = e(context);
        if (e11 == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        e11.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int h(Context context) {
        return Math.max(f(context), g(context));
    }

    public void a() {
        this.f84564h.Ze(this);
    }

    public final int c(float f11) {
        return (int) ((f11 * this.f84558b.e().getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int d() {
        return this.f84559c;
    }

    public final void i() {
        ViewGroup e11 = this.f84558b.e();
        if (this.f84563g == null) {
            View inflate = this.f84558b.c().inflate(this.f84557a, e11, false);
            this.f84563g = inflate;
            j(inflate);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f84563g.getLayoutParams();
        int i11 = this.f84562f;
        if (i11 == 1) {
            layoutParams.gravity = 3;
        } else if (i11 == 2) {
            layoutParams.gravity = 5;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(h(e11.getContext()), 1073741824);
        this.f84563g.measure(ViewGroup.getChildMeasureSpec(makeMeasureSpec, 0, layoutParams.width), ViewGroup.getChildMeasureSpec(makeMeasureSpec, 0, layoutParams.height));
        Rect rect = this.f84560d;
        if (rect != null) {
            int i12 = this.f84561e;
            if (i12 == 1) {
                layoutParams.topMargin = (rect.top - c(12.0f)) - this.f84563g.getMeasuredHeight();
            } else if (i12 == 2) {
                layoutParams.topMargin = rect.bottom;
            }
        }
        if (this.f84563g.getParent() == null) {
            e11.addView(this.f84563g, layoutParams);
        } else {
            this.f84563g.setLayoutParams(layoutParams);
        }
    }

    public final void j(View view) {
        View findViewById = view.findViewById(R.id.tv_next);
        if (findViewById != null) {
            findViewById.setOnClickListener(new a());
        }
        View findViewById2 = view.findViewById(R.id.tv_pre);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new b());
        }
        View findViewById3 = view.findViewById(R.id.tv_start);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new C0882c());
        }
        View findViewById4 = view.findViewById(R.id.iv_close);
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(new d());
        }
    }

    public void k() {
        View view = this.f84563g;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f84563g.getParent()).removeView(this.f84563g);
        }
    }

    public void l(Rect rect) {
        this.f84560d = rect;
    }

    public void m() {
        k();
        this.f84558b.g(this.f84559c + 1);
    }

    public void n() {
        k();
        this.f84558b.g(this.f84559c - 1);
    }

    public void o() {
        this.f84558b.d().setRect(this.f84560d);
        i();
    }
}
