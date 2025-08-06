package com.huobi.invite.bean;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cm.a;
import com.blankj.utilcode.util.ToastUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.sharev2.helper.NewShareHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.wtree.helper.Utils;
import i6.l;
import i6.n;
import i6.r;
import java.math.BigDecimal;
import pro.huobi.R;
import s9.c;

public class SharePlatformHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(SharePlatformItem sharePlatformItem, View view) {
        if (!l.i(view.getContext())) {
            ToastUtils.r(R.string.n_check_network);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (sharePlatformItem.getCallback() != null) {
            sharePlatformItem.getCallback().i0(sharePlatformItem.getPlatform());
            NewShareHelper.j().s(sharePlatformItem.getPlatform().toString());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, SharePlatformItem sharePlatformItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        ((ImageView) e11.b(R.id.iv_common_share_channel)).setImageResource(sharePlatformItem.getResourceId());
        ((TextView) e11.b(R.id.tv_title)).setText(sharePlatformItem.getTitle());
        int a11 = PixelUtils.a(2.0f);
        ViewGroup viewGroup2 = (ViewGroup) e11.b(R.id.clyt_share_root);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewGroup2.getLayoutParams();
        if (sharePlatformItem.isMain()) {
            layoutParams.setMargins(Utils.a(viewGroup2.getContext(), 16.0f), 0, Utils.a(viewGroup2.getContext(), 16.0f), 0);
            viewGroup2.setLayoutParams(layoutParams);
        } else {
            int i12 = a11 * 2;
            layoutParams.width = BigDecimal.valueOf((long) (n.g(cVar.itemView.getContext()) - (i12 * 6))).divide(BigDecimal.valueOf(5.5d), 0, 5).intValue();
            if (i11 == 0) {
                layoutParams.leftMargin = i12;
                layoutParams.rightMargin = a11;
            } else if (i11 == sharePlatformItem.getCount() - 1) {
                layoutParams.leftMargin = a11;
                layoutParams.rightMargin = i12;
            } else {
                layoutParams.leftMargin = a11;
                layoutParams.rightMargin = a11;
            }
            viewGroup2.setLayoutParams(layoutParams);
        }
        cVar.itemView.setOnClickListener(new a(sharePlatformItem));
    }

    public int getResId() {
        return R.layout.layout_item_common_share;
    }
}
