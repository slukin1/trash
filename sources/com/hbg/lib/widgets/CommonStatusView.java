package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class CommonStatusView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f71200b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f71201c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f71202d;

    /* renamed from: e  reason: collision with root package name */
    public View f71203e;

    /* renamed from: f  reason: collision with root package name */
    public int f71204f;

    /* renamed from: g  reason: collision with root package name */
    public a f71205g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<b> f71206h;

    public interface a {
        void a(int i11, b bVar);
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f71207a;

        /* renamed from: b  reason: collision with root package name */
        public String f71208b;

        /* renamed from: c  reason: collision with root package name */
        public String f71209c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f71210d;

        public b(int i11, String str, String str2, boolean z11) {
            this.f71207a = i11;
            this.f71208b = str;
            this.f71209c = str2;
            this.f71210d = z11;
        }

        public boolean b(Object obj) {
            return obj instanceof b;
        }

        public String c() {
            return this.f71209c;
        }

        public String d() {
            return this.f71208b;
        }

        public int e() {
            return this.f71207a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!bVar.b(this) || e() != bVar.e()) {
                return false;
            }
            String d11 = d();
            String d12 = bVar.d();
            if (d11 != null ? !d11.equals(d12) : d12 != null) {
                return false;
            }
            String c11 = c();
            String c12 = bVar.c();
            if (c11 != null ? c11.equals(c12) : c12 == null) {
                return f() == bVar.f();
            }
            return false;
        }

        public boolean f() {
            return this.f71210d;
        }

        public void g(String str) {
            this.f71209c = str;
        }

        public void h(boolean z11) {
            this.f71210d = z11;
        }

        public int hashCode() {
            String d11 = d();
            int i11 = 43;
            int e11 = ((e() + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
            String c11 = c();
            int i12 = e11 * 59;
            if (c11 != null) {
                i11 = c11.hashCode();
            }
            return ((i12 + i11) * 59) + (f() ? 79 : 97);
        }

        public void i(String str) {
            this.f71208b = str;
        }

        public void j(int i11) {
            this.f71207a = i11;
        }

        public String toString() {
            return "CommonStatusView.Status(imgResId=" + e() + ", content=" + d() + ", btnText=" + c() + ", btnVisible=" + f() + ")";
        }
    }

    public CommonStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(View view) {
        g();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void b() {
        setVisibility(8);
        View view = this.f71203e;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void c(Context context) {
        setGravity(17);
        setOrientation(1);
        d();
        e(context);
        this.f71202d.setOnClickListener(new v(this));
        q(this.f71206h.get(this.f71204f));
    }

    public final void d() {
    }

    public final void e(Context context) {
        this.f71200b = new ImageView(context);
        this.f71200b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f71200b);
        this.f71201c = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R$dimen.dimen_10);
        this.f71201c.setLayoutParams(layoutParams);
        this.f71201c.setTextColor(getResources().getColor(R$color.baseColorThreeLevelText));
        this.f71201c.setTextSize(0, (float) getResources().getDimensionPixelOffset(R$dimen.global_text_size_12));
        addView(this.f71201c);
        this.f71202d = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = getResources().getDimensionPixelOffset(R$dimen.dimen_15);
        this.f71202d.setLayoutParams(layoutParams2);
        TextView textView = this.f71202d;
        Resources resources = getResources();
        int i11 = R$dimen.dimen_35;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(i11);
        Resources resources2 = getResources();
        int i12 = R$dimen.dimen_13;
        textView.setPadding(dimensionPixelOffset, resources2.getDimensionPixelOffset(i12), getResources().getDimensionPixelOffset(i11), getResources().getDimensionPixelOffset(i12));
        this.f71202d.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
        this.f71202d.setTextSize(0, (float) getResources().getDimensionPixelOffset(R$dimen.global_text_size_14));
        this.f71202d.setBackgroundColor(getResources().getColor(R$color.baseColorMajorTheme006));
        addView(this.f71202d);
    }

    public final void g() {
        a aVar = this.f71205g;
        if (aVar != null) {
            int i11 = this.f71204f;
            aVar.a(i11, this.f71206h.get(i11));
        }
    }

    public final void h(int i11, String str) {
        b bVar = this.f71206h.get(i11);
        if (bVar != null) {
            bVar.g(str);
        }
        q(bVar);
    }

    public final void i(int i11, boolean z11) {
        b bVar = this.f71206h.get(i11);
        if (bVar != null) {
            bVar.h(z11);
        }
        q(bVar);
    }

    public final void j(int i11, String str) {
        b bVar = this.f71206h.get(i11);
        if (bVar != null) {
            bVar.i(str);
        }
        q(bVar);
    }

    public final void k(int i11, int i12) {
        b bVar = this.f71206h.get(i11);
        if (bVar != null) {
            bVar.j(i12);
        }
        q(bVar);
    }

    public void l() {
        setVisibility(0);
        View view = this.f71203e;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void m(int i11) {
        this.f71204f = i11;
        q(this.f71206h.get(i11));
        l();
    }

    public void n() {
        m(-1);
    }

    public void o() {
        m(-2);
    }

    public void p() {
        m(-3);
    }

    public final void q(b bVar) {
        if (bVar != null) {
            this.f71200b.setImageResource(bVar.f71207a);
            this.f71201c.setText(bVar.d());
            this.f71202d.setText(bVar.c());
            this.f71202d.setVisibility(bVar.f() ? 0 : 8);
        }
    }

    public void setCallback(a aVar) {
        this.f71205g = aVar;
    }

    public void setEmptyBtnText(String str) {
        h(-1, str);
    }

    public void setEmptyBtnVisible(boolean z11) {
        i(-1, z11);
    }

    public void setEmptyContentText(String str) {
        j(-1, str);
    }

    public void setEmptyImgResId(int i11) {
        k(-1, i11);
    }

    public void setNoNetworkBtnText(String str) {
        h(-2, str);
    }

    public void setNoNetworkBtnVisible(boolean z11) {
        i(-2, z11);
    }

    public void setNoNetworkContentText(String str) {
        j(-2, str);
    }

    public void setNoNetworkImgResId(int i11) {
        k(-2, i11);
    }

    public void setRelatedView(View view) {
        this.f71203e = view;
    }

    public void setServerErrorBtnText(String str) {
        h(-3, str);
    }

    public void setServerErrorBtnVisible(boolean z11) {
        i(-3, z11);
    }

    public void setServerErrorContentText(String str) {
        j(-3, str);
    }

    public void setServerErrorImgResId(int i11) {
        k(-3, i11);
    }

    @Keep
    public void updateImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.f71200b.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonStatusView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        int i12;
        CommonStatusView commonStatusView;
        this.f71204f = -1;
        SparseArray<b> sparseArray = new SparseArray<>();
        this.f71206h = sparseArray;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonStatusView, i11, 0);
        int i13 = obtainStyledAttributes.getInt(R$styleable.CommonStatusView_default_status, -1);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.CommonStatusView_empty_img_res, R$drawable.common_empty_icon);
        String string = obtainStyledAttributes.getString(R$styleable.CommonStatusView_empty_content_text);
        string = string == null ? getResources().getString(R$string.trade_no_record) : string;
        String string2 = obtainStyledAttributes.getString(R$styleable.CommonStatusView_empty_btn_text);
        boolean z11 = obtainStyledAttributes.getBoolean(R$styleable.CommonStatusView_empty_btn_visible, false);
        int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.CommonStatusView_no_network_img_res, R$drawable.common_no_network_icon);
        String string3 = obtainStyledAttributes.getString(R$styleable.CommonStatusView_no_network_content_text);
        String string4 = string3 == null ? getResources().getString(R$string.common_no_internet_access) : string3;
        String string5 = obtainStyledAttributes.getString(R$styleable.CommonStatusView_no_network_btn_text);
        String string6 = string5 == null ? getResources().getString(R$string.common_reloading) : string5;
        boolean z12 = obtainStyledAttributes.getBoolean(R$styleable.CommonStatusView_no_network_btn_visible, true);
        int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.CommonStatusView_server_error_img_res, R$drawable.empty_pic_busy);
        String string7 = obtainStyledAttributes.getString(R$styleable.CommonStatusView_server_error_content_text);
        String string8 = string7 == null ? getResources().getString(R$string.common_tips_server_error) : string7;
        String string9 = obtainStyledAttributes.getString(R$styleable.CommonStatusView_server_error_btn_text);
        String string10 = string9 == null ? getResources().getString(R$string.common_reloading) : string9;
        boolean z13 = obtainStyledAttributes.getBoolean(R$styleable.CommonStatusView_server_error_btn_visible, true);
        obtainStyledAttributes.recycle();
        int i14 = i13;
        b bVar = r0;
        b bVar2 = new b(resourceId, string, string2, z11);
        sparseArray.put(-1, bVar);
        b bVar3 = r0;
        b bVar4 = new b(resourceId2, string4, string6, z12);
        sparseArray.put(-2, bVar3);
        sparseArray.put(-3, new b(resourceId3, string8, string10, z13));
        int i15 = i14;
        if (sparseArray.indexOfKey(i15) < 0) {
            commonStatusView = this;
            i12 = -1;
        } else {
            i12 = i15;
            commonStatusView = this;
        }
        commonStatusView.f71204f = i12;
        c(context);
    }
}
