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
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import jp.k0;
import qh.p0;
import s9.a;
import s9.c;
import vh.u;

public class AssetPositionLoadingViewData implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f42459b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f42460c;

    public static class LoadingViewHandler implements c {
        @SensorsDataInstrumented
        public static /* synthetic */ void e(Context context, View view) {
            if (context instanceof Activity) {
                k0.k((Activity) context);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: c */
        public void handleView(v9.c cVar, int i11, AssetPositionLoadingViewData assetPositionLoadingViewData, ViewGroup viewGroup) {
            LoadingLayout loadingLayout = (LoadingLayout) cVar.e().b(R$id.loading_layout);
            loadingLayout.findViewById(R$id.balance_common_error_view).setBackground((Drawable) null);
            loadingLayout.findViewById(R$id.balance_common_empty_view).setBackground((Drawable) null);
            loadingLayout.findViewById(R$id.balance_common_guide_view).setBackground((Drawable) null);
            int a11 = assetPositionLoadingViewData.f42459b;
            if (a11 == 1) {
                loadingLayout.p();
            } else if (a11 == 2) {
                loadingLayout.k();
            } else if (a11 == 3) {
                loadingLayout.i();
            } else if (a11 != 4) {
                loadingLayout.g();
            } else {
                d(loadingLayout, cVar.itemView.getContext());
                loadingLayout.m();
            }
            loadingLayout.setOnRetryClickListener(assetPositionLoadingViewData.f42460c);
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
                textView2.setOnClickListener(new u(context));
            }
        }

        public int getResId() {
            return R$layout.layout_asset_position_loading;
        }
    }

    public boolean d(Object obj) {
        return obj instanceof AssetPositionLoadingViewData;
    }

    public View.OnClickListener e() {
        return this.f42460c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AssetPositionLoadingViewData)) {
            return false;
        }
        AssetPositionLoadingViewData assetPositionLoadingViewData = (AssetPositionLoadingViewData) obj;
        if (!assetPositionLoadingViewData.d(this) || f() != assetPositionLoadingViewData.f()) {
            return false;
        }
        View.OnClickListener e11 = e();
        View.OnClickListener e12 = assetPositionLoadingViewData.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public int f() {
        return this.f42459b;
    }

    public String getViewHandlerName() {
        return LoadingViewHandler.class.getName();
    }

    public int hashCode() {
        View.OnClickListener e11 = e();
        return ((f() + 59) * 59) + (e11 == null ? 43 : e11.hashCode());
    }

    public String toString() {
        return "AssetPositionLoadingViewData(state=" + f() + ", onRetryListener=" + e() + ")";
    }
}
