package com.huobi.assetrecord.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import pro.huobi.R;
import s9.c;

public class AppleOrderHistoryItemDataHandler implements c {
    public String b(Context context, long j11, long j12) {
        return context.getString(R.string.n_asset_apply_record_date_start_to_end, new Object[]{DateTimeUtils.h(j11, "yyyy/MM/dd"), DateTimeUtils.h(j12, "yyyy/MM/dd")});
    }

    public String c(Context context, int i11) {
        if (i11 == 2) {
            return context.getString(R.string.n_asset_apply_record_reject);
        }
        if (i11 == 3) {
            return context.getString(R.string.n_asset_apply_record_accept);
        }
        if (i11 != 4) {
            return context.getString(R.string.n_asset_apply_record_applying);
        }
        return context.getString(R.string.n_asset_apply_record_done);
    }

    public int d(int i11) {
        return i11 != 2 ? i11 != 3 ? i11 != 4 ? R.color.baseColorMajorTheme100 : R.color.baseColorThreeLevelText : R.color.kColorPriceGreen : R.color.color_live_playing;
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, AppleOrderHistoryItemData appleOrderHistoryItemData, ViewGroup viewGroup) {
        View view = cVar.itemView;
        TextView textView = (TextView) view.findViewById(R.id.item_apple_status);
        ((TextView) view.findViewById(R.id.item_apple_time)).setText(view.getContext().getString(R.string.n_asset_apply_record_time, new Object[]{DateTimeUtils.h(appleOrderHistoryItemData.c().longValue(), "HH:mm MM/dd")}));
        textView.setText(c(view.getContext(), appleOrderHistoryItemData.f()));
        textView.setTextColor(view.getContext().getResources().getColor(d(appleOrderHistoryItemData.f())));
        ((TextView) view.findViewById(R.id.item_record_time_content)).setText(b(view.getContext(), appleOrderHistoryItemData.d().longValue(), appleOrderHistoryItemData.e().longValue()));
        ((TextView) view.findViewById(R.id.item_apple_email_content)).setText(appleOrderHistoryItemData.a());
    }

    public int getResId() {
        return R.layout.item_apple_history_record;
    }
}
