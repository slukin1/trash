package com.huobi.asset.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.SpotAssertInfo;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.asset.AssetAccountType;
import com.huobi.finance.bean.BaseAssetPositionAccountData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import jp.k0;
import qh.p0;
import s9.c;
import vh.m;

public class AssetLoadingPositionViewData extends BaseAssetPositionAccountData {

    /* renamed from: b  reason: collision with root package name */
    public int f42445b = 0;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f42446c;

    public static class LoadingViewHandler implements c {
        @SensorsDataInstrumented
        public static /* synthetic */ void e(Context context, View view) {
            if (context instanceof Activity) {
                k0.k((Activity) context);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: c */
        public void handleView(v9.c cVar, int i11, AssetLoadingPositionViewData assetLoadingPositionViewData, ViewGroup viewGroup) {
            LoadingLayout loadingLayout = (LoadingLayout) cVar.e().b(R$id.loading_layout);
            loadingLayout.findViewById(R$id.balance_common_error_view).setBackground((Drawable) null);
            loadingLayout.findViewById(R$id.balance_common_empty_view).setBackground((Drawable) null);
            loadingLayout.findViewById(R$id.balance_common_guide_view).setBackground((Drawable) null);
            int d11 = assetLoadingPositionViewData.f42445b;
            if (d11 == 1) {
                loadingLayout.p();
            } else if (d11 == 2) {
                loadingLayout.k();
            } else if (d11 == 3) {
                loadingLayout.i();
            } else if (d11 != 4) {
                loadingLayout.g();
            } else {
                d(loadingLayout, cVar.itemView.getContext());
                loadingLayout.m();
            }
            loadingLayout.setOnRetryClickListener(assetLoadingPositionViewData.f42446c);
        }

        public final void d(View view, Context context) {
            TextView textView = (TextView) view.findViewById(R$id.tv_balance_guide_text);
            TextView textView2 = (TextView) view.findViewById(R$id.tv_balance_guide_to_otc);
            TextView textView3 = (TextView) view.findViewById(R$id.tv_balance_guide_to_otc_tips);
            SpotAssertInfo o11 = p0.n().o();
            if (textView != null) {
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
                textView2.setOnClickListener(new m(context));
            }
        }

        public int getResId() {
            return R$layout.layout_asset_loading;
        }
    }

    public AssetLoadingPositionViewData(View.OnClickListener onClickListener) {
        this.f42446c = onClickListener;
    }

    public AssetAccountType a() {
        return null;
    }

    public void c(int i11, boolean z11) {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AssetLoadingPositionViewData)) {
            return false;
        }
        AssetLoadingPositionViewData assetLoadingPositionViewData = (AssetLoadingPositionViewData) obj;
        if (!assetLoadingPositionViewData.f(this) || h() != assetLoadingPositionViewData.h()) {
            return false;
        }
        View.OnClickListener g11 = g();
        View.OnClickListener g12 = assetLoadingPositionViewData.g();
        return g11 != null ? g11.equals(g12) : g12 == null;
    }

    public boolean f(Object obj) {
        return obj instanceof AssetLoadingPositionViewData;
    }

    public View.OnClickListener g() {
        return this.f42446c;
    }

    public String getViewHandlerName() {
        return LoadingViewHandler.class.getName();
    }

    public int h() {
        return this.f42445b;
    }

    public int hashCode() {
        View.OnClickListener g11 = g();
        return ((h() + 59) * 59) + (g11 == null ? 43 : g11.hashCode());
    }

    public void i(int i11) {
        this.f42445b = i11;
    }

    public String toString() {
        return "AssetLoadingPositionViewData(state=" + h() + ", onRetryListener=" + g() + ")";
    }
}
