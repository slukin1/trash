package com.huobi.index.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.o0;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexAd;
import com.huobi.utils.v;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.HashMap;
import pro.huobi.R;
import rd.q;
import s9.c;
import tg.r;

public class NewsAdHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public HomeFeedInfoItem f74255b;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IndexAd f74256b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HashMap f74257c;

        public a(IndexAd indexAd, HashMap hashMap) {
            this.f74256b = indexAd;
            this.f74257c = hashMap;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            String str = this.f74256b.jumpTo;
            if (str != null && !str.equals("")) {
                v.a(view.getContext(), this.f74256b.jumpTo, "");
                q.a("app_feed_resource_click", this.f74257c);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, HomeFeedInfoItem homeFeedInfoItem, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) cVar.e().b(R.id.ivPic);
        this.f74255b = homeFeedInfoItem;
        IndexAd h11 = homeFeedInfoItem.h();
        if (h11 != null) {
            HashMap hashMap = new HashMap();
            String J = r.x().J();
            if (J == null || J.equals("")) {
                J = "0";
            }
            hashMap.put("uid", J);
            hashMap.put("location", String.valueOf(i11 + 1));
            hashMap.put("textId", String.valueOf(h11.advId));
            imageView.setOnClickListener(new a(h11, hashMap));
            o0.a().loadImage(imageView.getContext(), NightHelper.e().g() ? h11.nightImageUrl : h11.imageUrl, imageView);
        }
    }

    public int getResId() {
        return R.layout.item_home_ad;
    }
}
