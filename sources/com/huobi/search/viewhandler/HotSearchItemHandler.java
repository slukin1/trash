package com.huobi.search.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.StringUtils;
import com.huobi.search.bean.HotSearchItem;
import com.huobi.search.bean.SearchHistoryItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.r;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import s9.c;

public class HotSearchItemHandler implements c {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f80785b;

        public a(TextView textView) {
            this.f80785b = textView;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SearchHistoryItem searchHistoryItem = new SearchHistoryItem();
            String charSequence = this.f80785b.getText().toString();
            searchHistoryItem.setSearchKeyWord(charSequence);
            cr.a aVar = new cr.a(searchHistoryItem);
            aVar.b(true);
            EventBus.d().k(aVar);
            try {
                is.a.k("3340", StringUtils.g(charSequence));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, HotSearchItem hotSearchItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        cVar.itemView.getResources();
        TextView e12 = e11.e(R.id.tv_title);
        e12.setText(k.C().z(hotSearchItem.getSymbol()));
        ((RelativeLayout) e11.b(R.id.rl_hot_area)).setOnClickListener(new a(e12));
    }

    public int getResId() {
        return R.layout.item_hot_search;
    }
}
