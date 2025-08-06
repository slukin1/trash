package com.huobi.asset.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.SpotAssertInfo;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import jp.k0;
import qh.p0;
import vh.p;

public class AssetLoadingViewNew extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f42452b;

    /* renamed from: c  reason: collision with root package name */
    public LoadingLayout f42453c;

    /* renamed from: d  reason: collision with root package name */
    public View f42454d;

    /* renamed from: e  reason: collision with root package name */
    public View f42455e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f42456f;

    public AssetLoadingViewNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void d(Context context, View view) {
        if (context instanceof Activity) {
            k0.k((Activity) context);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R$layout.layout_asset_loading_new, this, true);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        this.f42452b = findViewById(R$id.loading_layout_parent);
        LoadingLayout loadingLayout = (LoadingLayout) findViewById(R$id.loading_layout);
        this.f42453c = loadingLayout;
        loadingLayout.g();
        this.f42455e = findViewById(R$id.balance_common_error_view);
        this.f42454d = findViewById(R$id.balance_common_empty_view);
        this.f42453c.findViewById(R$id.balance_common_guide_view).setBackground((Drawable) null);
    }

    public final void c(View view, Context context) {
        TextView textView = (TextView) view.findViewById(R$id.tv_balance_guide_text);
        TextView textView2 = (TextView) view.findViewById(R$id.tv_balance_guide_to_otc);
        TextView textView3 = (TextView) view.findViewById(R$id.tv_balance_guide_to_otc_tips);
        SpotAssertInfo o11 = p0.n().o();
        if (textView != null) {
            textView.setText(context.getString(R$string.n_asset_guide_recharge) + "\n" + context.getString(R$string.n_balance_new_guide_desc));
            if (o11 != null && !TextUtils.isEmpty(o11.getDepositTag())) {
                String depositTag = o11.getDepositTag();
                if (textView3 != null) {
                    textView3.setVisibility(0);
                    textView3.setText(depositTag);
                }
            } else if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        if (textView2 != null) {
            textView2.setOnClickListener(new p(context));
        }
    }

    public View getEmptyLayout() {
        return this.f42454d;
    }

    public View getErrorLayout() {
        return this.f42455e;
    }

    public LoadingLayout getLoadingLayout() {
        return this.f42453c;
    }

    public View getLoadingLayoutParent() {
        return this.f42452b;
    }

    public void setRetryListener(View.OnClickListener onClickListener) {
        this.f42456f = onClickListener;
    }

    public void setState(int i11) {
        if (i11 == 1) {
            this.f42453c.p();
        } else if (i11 == 2) {
            this.f42453c.k();
        } else if (i11 == 3) {
            this.f42453c.i();
        } else if (i11 != 4) {
            this.f42453c.g();
        } else {
            c(this.f42453c, getContext());
            this.f42453c.m();
        }
        View.OnClickListener onClickListener = this.f42456f;
        if (onClickListener != null) {
            this.f42453c.setOnRetryClickListener(onClickListener);
        }
    }

    public AssetLoadingViewNew(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public AssetLoadingViewNew(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        b();
    }
}
