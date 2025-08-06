package com.hbg.module.community.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.content.utls.g;
import com.hbg.module.libkt.base.ext.b;
import com.luck.picture.lib.config.PictureMimeType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import f6.c;
import i6.m;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.d0;
import sl.f0;

public final class u extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends TopicDetailInfo.CoinInfo> f17219a;

    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final View f17220a;

        /* renamed from: b  reason: collision with root package name */
        public final AppCompatImageView f17221b;

        /* renamed from: c  reason: collision with root package name */
        public final AppCompatTextView f17222c;

        /* renamed from: d  reason: collision with root package name */
        public final AppCompatTextView f17223d;

        /* renamed from: e  reason: collision with root package name */
        public final AppCompatTextView f17224e;

        /* renamed from: f  reason: collision with root package name */
        public final AppCompatTextView f17225f;

        public a(View view) {
            super(view);
            this.f17220a = view.findViewById(R$id.cl_coin_item);
            this.f17221b = (AppCompatImageView) view.findViewById(R$id.aiv_topic_coin_icon);
            this.f17222c = (AppCompatTextView) view.findViewById(R$id.atv_topic_coin_a);
            this.f17223d = (AppCompatTextView) view.findViewById(R$id.atv_topic_coin_b);
            this.f17224e = (AppCompatTextView) view.findViewById(R$id.atv_topic_coin_price);
            this.f17225f = (AppCompatTextView) view.findViewById(R$id.atv_topic_coin_percent);
        }

        public final AppCompatTextView e() {
            return this.f17222c;
        }

        public final AppCompatTextView f() {
            return this.f17223d;
        }

        public final AppCompatImageView g() {
            return this.f17221b;
        }

        public final AppCompatTextView h() {
            return this.f17225f;
        }

        public final AppCompatTextView i() {
            return this.f17224e;
        }

        public final View j() {
            return this.f17220a;
        }
    }

    public u(List<? extends TopicDetailInfo.CoinInfo> list) {
        this.f17219a = list;
    }

    @SensorsDataInstrumented
    public static final void f(Context context, SymbolPrice symbolPrice, View view) {
        g.f18913a.a(context, symbolPrice != null ? symbolPrice.getSymbol() : null, false, TradeType.PRO, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String c(String str) {
        String str2 = "";
        if (b.x(str)) {
            return str2;
        }
        String j11 = BaseModuleConfig.a().j();
        if (!b.x(j11)) {
            str2 = j11;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append("/-/x/hb/p/api/contents/currency/icon_png/");
        sb2.append(str != null ? str.toLowerCase() : null);
        sb2.append(PictureMimeType.PNG);
        return sb2.toString();
    }

    public final String d(double d11, String str) {
        if (Double.compare(d11, 0.0d) <= 0) {
            return "--";
        }
        int x11 = PrecisionUtil.x(str);
        return m.V(m.w(d11, x11), x11);
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: e */
    public void onBindViewHolder(a aVar, int i11) {
        int i12;
        String str;
        int i13;
        int i14;
        a aVar2 = aVar;
        int i15 = i11;
        Context context = aVar2.itemView.getContext();
        c a11 = c.a();
        AppCompatImageView g11 = aVar.g();
        String c11 = c(((TopicDetailInfo.CoinInfo) this.f17219a.get(i15)).getBaseCurrency());
        if (NightHelper.e().g()) {
            i12 = R$drawable.balances_currencyicon_night;
        } else {
            i12 = R$drawable.balances_currencyicon;
        }
        a11.f(g11, c11, i12);
        SymbolPrice h11 = f0.g().h(((TopicDetailInfo.CoinInfo) this.f17219a.get(i15)).getSymbol());
        List L0 = StringsKt__StringsKt.L0(StringUtils.i(((TopicDetailInfo.CoinInfo) this.f17219a.get(i15)).getCoin()), new String[]{"/"}, false, 0, 6, (Object) null);
        int size = L0.size();
        for (int i16 = 0; i16 < size; i16++) {
            if (i16 == 0) {
                aVar.e().setText((CharSequence) L0.get(0));
            } else if (i16 == 1) {
                aVar.f().setText('/' + ((String) L0.get(1)));
            }
        }
        Double close = h11 != null ? h11.getClose() : null;
        double doubleValue = close == null ? 0.0d : close.doubleValue();
        Double open = h11 != null ? h11.getOpen() : null;
        double doubleValue2 = open == null ? 0.0d : open.doubleValue();
        double d11 = doubleValue - doubleValue2;
        if (doubleValue2 == 0.0d) {
            str = "0.00%";
        } else {
            str = m.S(d11 / doubleValue2, PrecisionUtil.v(""));
        }
        AppCompatTextView i17 = aVar.i();
        d0 d0Var = d0.f56774a;
        i17.setText(String.format("%s%s", Arrays.copyOf(new Object[]{aVar2.itemView.getContext().getString(R$string.contract_symbol_price_dollar), d(doubleValue, ((TopicDetailInfo.CoinInfo) this.f17219a.get(i15)).getSymbol())}, 2)));
        aVar.h().setText(str);
        if (StringsKt__StringsKt.g0(str, "--", 0, false, 6, (Object) null) == 0) {
            i13 = R$color.baseColorDefaultPlaceholder;
        } else if (StringsKt__StringsKt.R(str, "0.00%", false, 2, (Object) null)) {
            i13 = R$color.baseColorSecondaryTextNew;
        } else if (StringsKt__StringsKt.g0(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER, 0, false, 6, (Object) null) == 0) {
            if (w.l()) {
                i13 = R$color.base_up_color;
            } else {
                i13 = R$color.base_down_color;
            }
        } else if (w.l()) {
            i13 = R$color.base_down_color;
        } else {
            i13 = R$color.base_up_color;
        }
        if (StringsKt__StringsKt.g0(str, "--", 0, false, 6, (Object) null) == 0) {
            i14 = R$color.chat_input_bg;
        } else if (StringsKt__StringsKt.R(str, "0.00%", false, 2, (Object) null)) {
            i14 = R$color.chat_input_bg;
        } else if (StringsKt__StringsKt.g0(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER, 0, false, 6, (Object) null) == 0) {
            if (w.l()) {
                i14 = R$color.baseColorGreen005;
            } else {
                i14 = R$color.baseColorRed005;
            }
        } else if (w.l()) {
            i14 = R$color.baseColorRed005;
        } else {
            i14 = R$color.baseColorGreen005;
        }
        aVar.j().setBackgroundColor(context.getResources().getColor(i14));
        aVar.h().setTextColor(context.getResources().getColor(i13));
        aVar2.itemView.setOnClickListener(new t(context, h11));
    }

    /* renamed from: g */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        int size = this.f17219a.size();
        if (size == 1) {
            return new a(View.inflate(viewGroup.getContext(), R$layout.topic_coin_item_1, (ViewGroup) null));
        }
        if (size == 2) {
            return new a(View.inflate(viewGroup.getContext(), R$layout.topic_coin_item_2, (ViewGroup) null));
        }
        if (size != 3) {
            return new a(View.inflate(viewGroup.getContext(), R$layout.topic_coin_item_3, (ViewGroup) null));
        }
        return new a(View.inflate(viewGroup.getContext(), R$layout.topic_coin_item_3, (ViewGroup) null));
    }

    public int getItemCount() {
        return this.f17219a.size();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(List<? extends TopicDetailInfo.CoinInfo> list) {
        this.f17219a = list;
        notifyDataSetChanged();
    }
}
