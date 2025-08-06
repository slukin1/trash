package com.huobi.index.viewhandler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.network.hbg.core.bean.RankListItemBean;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.widgets.CommonCheckBox;
import com.huobi.index.bean.RankDynamicItem;
import com.huobi.trade.helper.f0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.internal.core.analytics.d;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import i6.r;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import pro.huobi.R;
import yl.t;

public class IndexRankOptionalHolder {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, HashMap<Integer, String>> f74219a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<Integer, String> f74220b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public zl.a f74221c;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonCheckBox f74222b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RankScreenBean f74223c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RankDynamicItem f74224d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f74225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f74226f;

        public a(CommonCheckBox commonCheckBox, RankScreenBean rankScreenBean, RankDynamicItem rankDynamicItem, String str, int i11) {
            this.f74222b = commonCheckBox;
            this.f74223c = rankScreenBean;
            this.f74224d = rankDynamicItem;
            this.f74225e = str;
            this.f74226f = i11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            CommonCheckBox commonCheckBox = this.f74222b;
            commonCheckBox.setChecked(!commonCheckBox.isChecked());
            if (this.f74223c == null || this.f74224d.g() == null) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            if (this.f74222b.isChecked()) {
                t.f76860d.put(this.f74225e, "true");
                IndexRankOptionalHolder.this.f74220b.put(Integer.valueOf(this.f74226f), this.f74225e);
            } else if (IndexRankOptionalHolder.this.f74220b.size() > 0) {
                t.f76860d.put(this.f74225e, d.f31895b);
                IndexRankOptionalHolder.this.f74220b.remove(Integer.valueOf(this.f74226f));
            }
            IndexRankOptionalHolder indexRankOptionalHolder = IndexRankOptionalHolder.this;
            indexRankOptionalHolder.f74219a.put(RankScreenBean.SCREEN_VALUE_SPOT, indexRankOptionalHolder.f74220b);
            if (IndexRankOptionalHolder.this.f74221c != null) {
                IndexRankOptionalHolder.this.f74221c.a(IndexRankOptionalHolder.this.f74220b.size());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void c(Context context, r rVar, ConstraintLayout constraintLayout, int i11, RankDynamicItem rankDynamicItem, ViewGroup viewGroup) {
        Context context2 = context;
        r rVar2 = rVar;
        Log.d("IndexRankOptionalHolder", "position" + i11 + " data--:" + rankDynamicItem.toString() + "");
        TextView e11 = rVar2.e(R.id.item_chart_basecurrency_optional);
        TextView e12 = rVar2.e(R.id.item_chart_quotecurrency_optional);
        TextView e13 = rVar2.e(R.id.item_chart_price_optional);
        TextView e14 = rVar2.e(R.id.item_chart_percent_optional);
        CommonCheckBox commonCheckBox = (CommonCheckBox) rVar2.b(R.id.symbol_check_box);
        String e15 = rankDynamicItem.e();
        String d11 = rankDynamicItem.d();
        RankListItemBean g11 = rankDynamicItem.g();
        String symbol = g11.getSymbol();
        String baseCurrencyDisplayName = rankDynamicItem.getBaseCurrencyDisplayName();
        String quoteCurrency = g11.getQuoteCurrency();
        RankScreenBean h11 = t.h();
        if (!t.f76860d.containsKey(symbol)) {
            t.f76860d.put(symbol, "true");
            this.f74220b.put(Integer.valueOf(i11), symbol);
            this.f74219a.put(RankScreenBean.SCREEN_VALUE_SPOT, this.f74220b);
        }
        if (t.f76860d.containsKey(symbol)) {
            if (Objects.equals(t.f76860d.get(symbol), "true")) {
                commonCheckBox.setChecked(true);
            } else {
                commonCheckBox.setChecked(false);
            }
        }
        e11.setText(baseCurrencyDisplayName);
        e11.setTypeface(ResourcesCompat.h(context2, R.font.roboto_medium));
        e11.setTextSize(1, (e11.getText() == null || e11.getText().length() <= 7) ? 14.0f : 12.0f);
        if (quoteCurrency != null) {
            e12.setText("/" + quoteCurrency.toUpperCase());
        }
        e13.setTypeface(ResourcesCompat.h(context2, R.font.roboto_medium));
        e13.setText(m.c(e15, e15));
        e14.setText(d11);
        e14.setBackgroundColor(ContextCompat.getColor(context2, R.color.transparent));
        if (d11.equals("0.00%")) {
            e14.setTextColor(ContextCompat.getColor(context2, R.color.home_rank_new_symbol_percent_zero_color));
        } else {
            e14.setTextColor(f0.h(context2, !d11.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)));
        }
        constraintLayout.setOnClickListener(new a(commonCheckBox, h11, rankDynamicItem, symbol, i11));
    }

    public void d(Map<String, HashMap<Integer, String>> map, HashMap<Integer, String> hashMap) {
        this.f74219a = map;
        this.f74220b = hashMap;
    }

    public void e(zl.a aVar) {
        this.f74221c = aVar;
    }
}
