package com.hbg.module.kline.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.hbg.module.kline.R$styleable;

public class MarketInfoModelView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public Context f24393b;

    /* renamed from: c  reason: collision with root package name */
    public d f24394c;

    /* renamed from: d  reason: collision with root package name */
    public b f24395d;

    /* renamed from: e  reason: collision with root package name */
    public c f24396e;

    /* renamed from: f  reason: collision with root package name */
    public int f24397f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f24398g = -1;

    /* renamed from: h  reason: collision with root package name */
    public ViewModel f24399h = ViewModel.MODEL_A;

    public enum ViewModel {
        MODEL_A(0, "模式A：eg. Tab不悬停"),
        MODEL_B(1, "模式B：eg. Tab悬停");
        
        public String desc;
        public int type;

        private ViewModel(int i11, String str) {
            this.type = i11;
            this.desc = str;
        }

        public static ViewModel getType(int i11) {
            for (ViewModel viewModel : values()) {
                if (i11 == viewModel.type) {
                    return viewModel;
                }
            }
            return MODEL_A;
        }
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24400a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.hbg.module.kline.view.MarketInfoModelView$ViewModel[] r0 = com.hbg.module.kline.view.MarketInfoModelView.ViewModel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24400a = r0
                com.hbg.module.kline.view.MarketInfoModelView$ViewModel r1 = com.hbg.module.kline.view.MarketInfoModelView.ViewModel.MODEL_A     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24400a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.module.kline.view.MarketInfoModelView$ViewModel r1 = com.hbg.module.kline.view.MarketInfoModelView.ViewModel.MODEL_B     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.view.MarketInfoModelView.a.<clinit>():void");
        }
    }

    public interface b {
        void a(ViewModel viewModel);
    }

    public interface c {
        void a(ViewModel viewModel);
    }

    public interface d {
        void a(ViewModel viewModel, View view);

        void b();
    }

    public MarketInfoModelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i11) {
        this.f24393b = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MarketInfoModelView, i11, 0);
        if (obtainStyledAttributes != null) {
            this.f24397f = obtainStyledAttributes.getResourceId(R$styleable.MarketInfoModelView_mmv_layout_model_a_view, -1);
            this.f24398g = obtainStyledAttributes.getResourceId(R$styleable.MarketInfoModelView_mmv_layout_model_b_view, -1);
            this.f24399h = ViewModel.getType(obtainStyledAttributes.getInt(R$styleable.MarketInfoModelView_mmv_def_model, 0));
            obtainStyledAttributes.recycle();
        }
        d(this.f24399h);
    }

    public final void b(ViewModel viewModel) {
        int i11;
        removeAllViews();
        removeAllViewsInLayout();
        if (a.f24400a[viewModel.ordinal()] != 2) {
            i11 = this.f24397f;
        } else {
            i11 = this.f24398g;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this.f24393b);
        addView(frameLayout, layoutParams);
        if (i11 != -1) {
            frameLayout.addView(LayoutInflater.from(this.f24393b).inflate(i11, (ViewGroup) null), layoutParams);
        }
    }

    public void c(ViewModel viewModel, c cVar) {
        if (this.f24399h != viewModel) {
            this.f24399h = viewModel;
            this.f24396e = cVar;
            d(viewModel);
        }
    }

    public final void d(ViewModel viewModel) {
        if (this.f24397f == -1 && this.f24398g == -1) {
            Log.e("MarketInfoModelView", "####  Property Error[MarketInfoModelView]：Please set app:mmv_layout_model_a_view and app:mmv_layout_model_b_view!");
            return;
        }
        d dVar = this.f24394c;
        if (dVar != null) {
            dVar.b();
        }
        b(viewModel);
        d dVar2 = this.f24394c;
        if (dVar2 != null) {
            dVar2.a(viewModel, this);
        }
        b bVar = this.f24395d;
        if (bVar != null) {
            bVar.a(viewModel);
        }
        c cVar = this.f24396e;
        if (cVar != null) {
            cVar.a(viewModel);
            this.f24396e = null;
        }
    }

    public ViewModel getViewModel() {
        return this.f24399h;
    }

    public void setOnEventChangedCallback(b bVar) {
        this.f24395d = bVar;
    }

    public void setOnViewChangedCallback(d dVar) {
        this.f24394c = dVar;
    }

    public void setViewModel(ViewModel viewModel) {
        c(viewModel, (c) null);
    }

    public MarketInfoModelView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet, i11);
    }
}
