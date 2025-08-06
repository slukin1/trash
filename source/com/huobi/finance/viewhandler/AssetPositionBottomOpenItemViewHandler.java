package com.huobi.finance.viewhandler;

import android.view.ViewGroup;
import bl.h;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.finance.bean.AssetPositionOtcData;
import java.util.List;
import s9.d;
import v9.c;

public class AssetPositionBottomOpenItemViewHandler implements d<AssetPositionOtcData> {
    /* renamed from: c */
    public void handleView(c cVar, int i11, AssetPositionOtcData assetPositionOtcData, ViewGroup viewGroup) {
        cVar.e().b(R$id.fold_view).setOnClickListener(h.f12599b);
    }

    /* renamed from: d */
    public void a(c cVar, int i11, AssetPositionOtcData assetPositionOtcData, ViewGroup viewGroup, List<Object> list) {
        if (list != null) {
            list.isEmpty();
        }
    }

    public int getResId() {
        return R$layout.item_asset_position_botton_open;
    }
}
