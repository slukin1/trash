package com.hbg.module.livesquare.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.livesquare.bean.LiveGetGiftInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import s9.c;

public class LiveDialogGetGiftHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, LiveGetGiftInfo liveGetGiftInfo, ViewGroup viewGroup) {
        r e11 = cVar.e();
        ((ImageView) e11.b(R$id.iv_item_gift)).setImageResource(liveGetGiftInfo.iconRes);
        ((TextView) e11.b(R$id.tv_item_gift_content)).setText(liveGetGiftInfo.content);
        e11.e(R$id.tv_item_gift_content_tips).setText(liveGetGiftInfo.contentTips);
        TextView e12 = e11.e(R$id.tv_item_goto_get);
        e12.setText(liveGetGiftInfo.buttonText);
        e12.setTag(R$id.item_data, liveGetGiftInfo);
        e12.setOnClickListener(this);
    }

    public int getResId() {
        return R$layout.item_live_get_gift;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        LiveGetGiftInfo.a aVar;
        LiveGetGiftInfo liveGetGiftInfo = (LiveGetGiftInfo) view.getTag(R$id.item_data);
        if (!(liveGetGiftInfo == null || (aVar = liveGetGiftInfo.callback) == null)) {
            aVar.a(view, liveGetGiftInfo);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
