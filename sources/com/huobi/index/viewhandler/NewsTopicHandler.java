package com.huobi.index.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b2.a;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.provider.HbgBaseContentProvider;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexTopic;
import com.huobi.index.ui.e;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;

public class NewsTopicHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(LinearLayout linearLayout, View view) {
        try {
            ((HbgBaseContentProvider) a.d().a("/provider/content/jump").navigation()).l(linearLayout.getContext(), 0, "");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, HomeFeedInfoItem homeFeedInfoItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        LinearLayout linearLayout = (LinearLayout) e11.b(R.id.llTitleMore);
        TextView textView = (TextView) e11.b(R.id.tvTitle);
        textView.setText(textView.getContext().getResources().getString(R.string.n_content_hot_topic));
        RecyclerView recyclerView = (RecyclerView) e11.b(R.id.rvList);
        com.hbg.module.libkt.utils.r.f24939a.g(linearLayout, new b0(linearLayout), 800);
        IndexTopic s11 = homeFeedInfoItem.s();
        if (s11 != null) {
            recyclerView.setLayoutManager(b.t(recyclerView.getContext()));
            recyclerView.setAdapter(new e(s11.topics));
        }
    }

    public int getResId() {
        return R.layout.item_title_list;
    }
}
