package com.huobi.finance.viewhandler;

import al.l;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bl.q0;
import bl.r0;
import bl.s0;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.adapter.recyclerview.EasyAssetRecyclerView;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import gi.a;
import i6.r;
import java.util.HashMap;
import java.util.List;
import s9.d;
import v9.c;
import vk.i;

public class AssetPositionRecyclerItemViewHandler implements d<i> {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f67594b;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(i iVar, EasyAssetRecyclerView easyAssetRecyclerView, Context context, TextView textView, ImageView imageView, View view) {
        l.f().b(iVar.a());
        iVar.f();
        easyAssetRecyclerView.setData(iVar.h());
        j(context, textView, imageView, iVar.l());
        a.s(iVar.a(), iVar.l());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void i(View view) {
        BaseModuleConfig.a().w("app_assets_auto_transfer_switch_click", (HashMap) null);
        HBBaseWebActivity.showWebView(view.getContext(), BaseModuleConfig.a().W() + "financial/earn/h5/saveings", (String) null, (String) null, true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: e */
    public void handleView(c cVar, int i11, i iVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        EasyAssetRecyclerView easyAssetRecyclerView = (EasyAssetRecyclerView) e11.b(R$id.asset_recycler);
        easyAssetRecyclerView.setDataRangeChanged(iVar.h());
        boolean z11 = false;
        easyAssetRecyclerView.setNestedScrollingEnabled(false);
        View b11 = e11.b(R$id.fold_view);
        TextView textView = (TextView) e11.b(R$id.tv_fold);
        ImageView imageView = (ImageView) e11.b(R$id.iv_fold_icon);
        ViewUtil.m(b11, !iVar.k());
        j(context, textView, imageView, iVar.l());
        l.f().j(iVar.a(), new q0(easyAssetRecyclerView));
        b11.setOnClickListener(new r0(this, iVar, easyAssetRecyclerView, context, textView, imageView));
        View b12 = e11.b(R$id.btn_ybb_open);
        if (iVar.a() == AssetAccountType.SPOT && uh.i.d().f()) {
            z11 = true;
        }
        ViewUtil.m(b12, z11);
        if (z11 && !f67594b) {
            BaseModuleConfig.a().w("app_assets_auto_transfer_switch_exposure", (HashMap) null);
            f67594b = true;
        }
        b12.setOnClickListener(s0.f12730b);
    }

    /* renamed from: f */
    public void a(c cVar, int i11, i iVar, ViewGroup viewGroup, List<Object> list) {
        if (list != null && !list.isEmpty()) {
            EasyAssetRecyclerView easyAssetRecyclerView = (EasyAssetRecyclerView) cVar.e().b(R$id.asset_recycler);
            if (list.get(0).equals(TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_ENABLE_NOTIFICATION)) {
                easyAssetRecyclerView.setDataRangeChanged(iVar.h());
            }
        }
    }

    public int getResId() {
        return R$layout.item_asset_position_recycler;
    }

    public final void j(Context context, TextView textView, ImageView imageView, boolean z11) {
        if (z11) {
            textView.setText(context.getString(R$string.n_fold_all));
            imageView.setRotation(180.0f);
            return;
        }
        textView.setText(context.getString(R$string.n_unfold_all));
        imageView.setRotation(0.0f);
    }
}
