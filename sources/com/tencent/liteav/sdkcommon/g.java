package com.tencent.liteav.sdkcommon;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

final class g {

    /* renamed from: a  reason: collision with root package name */
    public final DisplayMetrics f21646a = new DisplayMetrics();

    /* renamed from: b  reason: collision with root package name */
    public final WindowManager.LayoutParams f21647b = new WindowManager.LayoutParams();

    /* renamed from: c  reason: collision with root package name */
    public final Context f21648c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f21649d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayAdapter<String> f21650e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager f21651f;

    /* renamed from: g  reason: collision with root package name */
    public View f21652g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21653h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21654i;

    /* renamed from: j  reason: collision with root package name */
    public Spinner f21655j;

    /* renamed from: k  reason: collision with root package name */
    public ScrollView f21656k;

    /* renamed from: l  reason: collision with root package name */
    public String f21657l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f21658m = false;

    /* renamed from: n  reason: collision with root package name */
    public int f21659n = 1920;

    /* renamed from: o  reason: collision with root package name */
    public final a f21660o;

    /* renamed from: p  reason: collision with root package name */
    private final int f21661p = -65536;

    /* renamed from: q  reason: collision with root package name */
    private boolean f21662q = false;

    public interface a {
        void a(int i11);
    }

    public class b implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        private int f21664b;

        /* renamed from: c  reason: collision with root package name */
        private int f21665c;

        private b() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f21664b = (int) motionEvent.getRawX();
                this.f21665c = (int) motionEvent.getRawY();
            } else if (action == 2) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                WindowManager.LayoutParams layoutParams = g.this.f21647b;
                int i11 = layoutParams.x + (rawX - this.f21664b);
                layoutParams.x = i11;
                layoutParams.y += rawY - this.f21665c;
                this.f21664b = rawX;
                this.f21665c = rawY;
                layoutParams.x = Math.max(i11, 0);
                WindowManager.LayoutParams layoutParams2 = g.this.f21647b;
                layoutParams2.y = Math.max(layoutParams2.y, 0);
                g gVar = g.this;
                WindowManager.LayoutParams layoutParams3 = gVar.f21647b;
                int i12 = layoutParams3.x;
                DisplayMetrics displayMetrics = gVar.f21646a;
                int i13 = displayMetrics.widthPixels;
                if (i12 + i13 > i13) {
                    layoutParams3.width = i13 - i12;
                } else {
                    layoutParams3.width = i13;
                }
                int i14 = gVar.f21659n;
                layoutParams3.height = i14;
                if (gVar.f21658m) {
                    layoutParams3.height = i14 / 2;
                }
                int i15 = layoutParams3.y;
                int i16 = layoutParams3.height + i15;
                int i17 = displayMetrics.heightPixels;
                if (i16 > i17) {
                    layoutParams3.height = i17 - i15;
                }
                ViewGroup.LayoutParams layoutParams4 = gVar.f21656k.getLayoutParams();
                layoutParams4.height = g.this.b();
                g.this.f21656k.setLayoutParams(layoutParams4);
                g gVar2 = g.this;
                gVar2.f21651f.updateViewLayout(view, gVar2.f21647b);
            }
            view.performClick();
            return false;
        }

        public /* synthetic */ b(g gVar, byte b11) {
            this();
        }
    }

    public class c implements AdapterView.OnItemSelectedListener {
        private c() {
        }

        @SensorsDataInstrumented
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
            if (view == null) {
                SensorsDataAutoTrackHelper.trackListView(adapterView, view, i11);
                return;
            }
            ((TextView) view).setTextColor(-65536);
            g gVar = g.this;
            gVar.f21657l = gVar.f21650e.getItem(i11);
            g.this.f21660o.a(i11);
            SensorsDataAutoTrackHelper.trackListView(adapterView, view, i11);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }

        public /* synthetic */ c(g gVar, byte b11) {
            this();
        }
    }

    public g(Context context, a aVar) {
        this.f21648c = context;
        this.f21660o = aVar;
        this.f21650e = new ArrayAdapter<>(context, 17367048);
        this.f21649d = new Handler(Looper.getMainLooper());
    }

    public final void a(boolean z11) {
        if (z11 != this.f21662q) {
            if (z11) {
                this.f21651f.addView(this.f21652g, this.f21647b);
            } else {
                this.f21651f.removeView(this.f21652g);
            }
            this.f21662q = z11;
        }
    }

    public final void b(String str) {
        TextView textView = this.f21653h;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final int b() {
        return Math.max((this.f21647b.height - a(230)) - a(20), 0);
    }

    public final void a(String str) {
        TextView textView = this.f21654i;
        if (textView != null) {
            textView.setText(str);
        }
        this.f21649d.post(h.a(this));
    }

    public final void a() {
        TextView textView;
        Spinner spinner = this.f21655j;
        if (spinner != null && (textView = (TextView) spinner.getChildAt(spinner.getSelectedItemPosition())) != null) {
            textView.setTextColor(-65536);
        }
    }

    public final int a(int i11) {
        return (int) ((((float) i11) * this.f21648c.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
