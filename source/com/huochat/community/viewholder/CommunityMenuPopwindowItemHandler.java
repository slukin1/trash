package com.huochat.community.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.model.CommunityMenuPopwindowItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import s9.b;
import s9.c;

public final class CommunityMenuPopwindowItemHandler implements c, View.OnClickListener {
    public int getResId() {
        return R.layout.item_community_menu_list;
    }

    public /* bridge */ /* synthetic */ View getView() {
        return b.a(this);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (!(view.getTag() instanceof CommunityMenuPopwindowItem)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        CommunityMenuPopwindowItem communityMenuPopwindowItem = (CommunityMenuPopwindowItem) view.getTag();
        CommunityMenuPopwindowItem.Callback callback = communityMenuPopwindowItem.getCallback();
        if (callback != null) {
            callback.onItemClick(view, communityMenuPopwindowItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void handleView(v9.c cVar, int i11, CommunityMenuPopwindowItem communityMenuPopwindowItem, ViewGroup viewGroup) {
        cVar.itemView.setTag(communityMenuPopwindowItem);
        cVar.itemView.setOnClickListener(this);
        r e11 = cVar.e();
        LinearLayout linearLayout = (LinearLayout) e11.b(R.id.ll_community_menu_item_layout);
        TextView textView = (TextView) e11.b(R.id.tv_community_menu_item_name);
        ((ImageView) e11.b(R.id.iv_community_menu_item_icon)).setImageResource(communityMenuPopwindowItem.getCommunityMenuItems().getItemRes());
        textView.setText(communityMenuPopwindowItem.getItemName());
        Context context = cVar.itemView.getContext();
        if (context != null) {
            CommunityThemeHelper.Companion companion = CommunityThemeHelper.Companion;
            ContextThemeWrapper themeContext = companion.getThemeContext(context);
            textView.setTextColor(companion.getColor(themeContext, R.attr.communityMenuItemTextColor));
            if (communityMenuPopwindowItem.isItemSelected()) {
                linearLayout.setBackgroundColor(companion.getColor(themeContext, R.attr.communityMenuItemBgSelected));
            } else {
                linearLayout.setBackgroundColor(0);
            }
        }
    }
}
