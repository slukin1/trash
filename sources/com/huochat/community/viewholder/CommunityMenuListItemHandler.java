package com.huochat.community.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.model.CommunityMenuListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.b;
import s9.c;
import tv.t;

public final class CommunityMenuListItemHandler implements c {
    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void handleView$lambda$1$lambda$0(CommunityMenuListItem.Callback callback, CommunityMenuListItem communityMenuListItem, View view) {
        callback.onItemClick(communityMenuListItem);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getResId() {
        return R.layout.item_community_menu_dialog_list;
    }

    public /* bridge */ /* synthetic */ View getView() {
        return b.a(this);
    }

    public void handleView(v9.c cVar, int i11, CommunityMenuListItem communityMenuListItem, ViewGroup viewGroup) {
        if (cVar != null && communityMenuListItem != null) {
            TextView textView = (TextView) cVar.itemView;
            Context context = textView.getContext();
            CommunityThemeHelper.Companion companion = CommunityThemeHelper.Companion;
            ContextThemeWrapper themeContext = companion.getThemeContext(context);
            textView.setText(communityMenuListItem.getText());
            CommunityMenuListItem.Callback callback = communityMenuListItem.getCallback();
            if (callback != null) {
                if (callback.isChecked(communityMenuListItem)) {
                    textView.setTextColor(communityMenuListItem.getCheckedTextColor(themeContext));
                    textView.setBackgroundColor(companion.getColor(themeContext, R.attr.communityMenuItemBgSelected));
                } else {
                    textView.setTextColor(communityMenuListItem.getUnCheckedTextColor(themeContext));
                    textView.setBackgroundColor(0);
                }
                textView.setOnClickListener(new t(callback, communityMenuListItem));
            }
        }
    }
}
