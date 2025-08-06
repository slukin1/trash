package com.huobi.points.viewhandler;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adjust.sdk.Constants;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.points.activity.PointsBuyActivity;
import com.huobi.points.entity.PointsPack;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kq.b;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import s9.c;

public class PointsPackViewPendingHandler implements c, View.OnClickListener, hq.a {

    /* renamed from: b  reason: collision with root package name */
    public int f80501b = Constants.ONE_HOUR;

    /* renamed from: c  reason: collision with root package name */
    public int f80502c = 60000;

    /* renamed from: d  reason: collision with root package name */
    public int f80503d = 1000;

    /* renamed from: e  reason: collision with root package name */
    public Map<Integer, Subscription> f80504e = new HashMap();

    public class a extends BaseSubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f80505b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TextView f80506c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f80507d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f80508e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f80509f;

        public a(TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, TextView textView4) {
            this.f80505b = textView;
            this.f80506c = textView2;
            this.f80507d = textView3;
            this.f80508e = linearLayout;
            this.f80509f = textView4;
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            if (l11.longValue() > 0) {
                this.f80505b.setText(PointsPackViewPendingHandler.this.f(l11.longValue()));
                this.f80506c.setText(PointsPackViewPendingHandler.this.g(l11.longValue()));
                this.f80507d.setText(PointsPackViewPendingHandler.this.h(l11.longValue()));
                return;
            }
            this.f80508e.setVisibility(8);
            this.f80509f.setClickable(true);
            if (!isUnsubscribed()) {
                unsubscribe();
            }
        }
    }

    public final String f(long j11) {
        long j12 = j11 / ((long) this.f80501b);
        if (j12 >= 10) {
            return String.valueOf(j12);
        }
        return String.valueOf("0" + j12);
    }

    public final String g(long j11) {
        long j12 = (j11 % ((long) this.f80501b)) / ((long) this.f80502c);
        if (j12 >= 10) {
            return String.valueOf(j12);
        }
        return String.valueOf("0" + j12);
    }

    public int getResId() {
        return R.layout.item_points_pack_pending;
    }

    public final String h(long j11) {
        long j12 = ((j11 % ((long) this.f80501b)) % ((long) this.f80502c)) / ((long) this.f80503d);
        if (j12 >= 10) {
            return String.valueOf(j12);
        }
        return String.valueOf("0" + j12);
    }

    /* renamed from: i */
    public void handleView(v9.c cVar, int i11, PointsPack pointsPack, ViewGroup viewGroup) {
        PointsPack pointsPack2 = pointsPack;
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        ((TextView) e11.b(R.id.item_points_pack_title_tv)).setText(pointsPack.getName());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getString(R.string.points_pack_contains));
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(String.valueOf(pointsPack.getPoints()));
        spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(20, true), 0, spannableStringBuilder2.length(), 33);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(context.getString(R.string.points_pack_points));
        spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder3.length(), 33);
        ((TextView) e11.b(R.id.item_points_pack_points_tv)).setText(spannableStringBuilder.append(spannableStringBuilder2).append(spannableStringBuilder3));
        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(context.getString(R.string.points_pack_only_sell));
        spannableStringBuilder4.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder4.length(), 33);
        SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder(m.m(pointsPack.getPrice(), PrecisionUtil.n()));
        spannableStringBuilder5.setSpan(new AbsoluteSizeSpan(20, true), 0, spannableStringBuilder5.length(), 33);
        SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder(context.getString(R.string.points_pack_usdt));
        spannableStringBuilder6.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder6.length(), 33);
        ((TextView) e11.b(R.id.item_points_pack_price_tv)).setText(spannableStringBuilder4.append(spannableStringBuilder5).append(spannableStringBuilder6));
        String plainString = m.a(String.valueOf(pointsPack.getLimit())).multiply(m.a(String.valueOf(pointsPack.getPoints()))).toPlainString();
        ((TextView) e11.b(R.id.item_points_pack_limit_hint_tv)).setText(String.format(context.getString(R.string.points_pack_limit_points), new Object[]{plainString}));
        ((TextView) e11.b(R.id.item_points_pack_price_hint_tv)).setText(String.format(context.getString(R.string.points_pack_deductible_fee), new Object[]{String.valueOf(pointsPack.getPoints())}));
        TextView textView = (TextView) e11.b(R.id.points_pack_hour_tv);
        TextView textView2 = (TextView) e11.b(R.id.points_pack_minute_tv);
        TextView textView3 = (TextView) e11.b(R.id.points_pack_second_tv);
        LinearLayout linearLayout = (LinearLayout) e11.b(R.id.points_pack_pending_ll);
        TextView textView4 = (TextView) e11.b(R.id.item_points_pack_buy_tv);
        textView4.setOnClickListener(this);
        textView4.setTag(R.id.item_data1, pointsPack2);
        textView4.setClickable(false);
        TextView textView5 = (TextView) e11.b(R.id.item_points_pack_gift_tv);
        textView5.setText(String.format(context.getString(R.string.points_pack_gift), new Object[]{m.m(pointsPack.getGiftAmount(), PrecisionUtil.a(TradeType.PRO, pointsPack.getGiftCurrency())), pointsPack.getGiftCurrency().toUpperCase(Locale.US)}));
        if (TextUtils.isEmpty(pointsPack.getGiftAmount()) || new BigDecimal(pointsPack.getGiftAmount()).compareTo(BigDecimal.ZERO) == 0) {
            textView5.setVisibility(8);
        } else {
            textView5.setVisibility(0);
        }
        if (this.f80504e.get(Integer.valueOf(i11)) == null) {
            this.f80504e.put(Integer.valueOf(i11), Observable.interval(0, 1, TimeUnit.SECONDS).map(new b(pointsPack2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(textView, textView2, textView3, linearLayout, textView4)));
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        List<Integer> d11;
        PointsPack pointsPack = (PointsPack) view.getTag(R.id.item_data1);
        if (PointsPack.PURCHASABLE_TYPE_FORBIDDEN.equals(pointsPack.getPurchasable())) {
            HuobiToastUtil.j(R.string.points_list_buy_forbidden_hint);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (tg.r.x().M() == null || (d11 = tg.r.x().M().d()) == null || d11.isEmpty() || d11.get(0).intValue() != 183) {
            Intent intent = new Intent(view.getContext(), PointsBuyActivity.class);
            intent.putExtra("buy_points_pack", pointsPack);
            view.getContext().startActivity(intent);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            HuobiToastUtil.j(R.string.points_list_buy_forbidden_hint);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }
}
