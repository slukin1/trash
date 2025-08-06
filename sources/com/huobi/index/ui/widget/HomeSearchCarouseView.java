package com.huobi.index.ui.widget;

import am.c;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;
import com.hbg.lib.widgets.BaseCarouselView;
import com.huobi.search.bean.HotSearchInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public final class HomeSearchCarouseView extends BaseCarouselView<String> {

    /* renamed from: n  reason: collision with root package name */
    public a f73998n;

    /* renamed from: o  reason: collision with root package name */
    public b f73999o;

    public interface a {
        void j(String str);
    }

    public interface b {
        void a(String str);
    }

    public HomeSearchCarouseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @SensorsDataInstrumented
    public static final void o(String str, HomeSearchCarouseView homeSearchCarouseView, View view) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (!(str == null || (aVar = homeSearchCarouseView.f73998n) == null)) {
            aVar.j(str);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void f(Context context) {
        View.inflate(context, R.layout.item_hot_search_carouse, this);
        this.f71029f = findViewById(R.id.tv_item_search_hot_word1);
        this.f71030g = findViewById(R.id.tv_item_search_hot_word2);
    }

    /* renamed from: n */
    public void i(String str, View view) {
        b bVar;
        TextView textView = (TextView) view;
        textView.setText(((HotSearchInfo.HotWordContext.HotWord) new Gson().fromJson(str, HotSearchInfo.HotWordContext.HotWord.class)).word);
        textView.setOnClickListener(new c(str, this));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str != null && (bVar = this.f73999o) != null) {
            bVar.a(str);
        }
    }

    public final void setOnItemClickListener(a aVar) {
        this.f73998n = aVar;
    }

    public final void setOnItemExposeListener(b bVar) {
        this.f73999o = bVar;
    }
}
