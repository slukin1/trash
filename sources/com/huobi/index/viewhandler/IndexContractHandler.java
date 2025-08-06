package com.huobi.index.viewhandler;

import al.p;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.q;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.module.libkt.base.ext.b;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexContract;
import com.huobi.index.ui.FeedFragment;
import com.huobi.utils.HomeSensorsHelper;
import com.huochat.community.util.DisplayTool;
import com.xiaomi.mipush.sdk.Constants;
import gs.g;
import i6.m;
import i8.k;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import s9.c;
import sn.f;

public class IndexContractHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public boolean f74111b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f74112a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f74113b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f74114c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f74115d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f74116e;

        public a(View view) {
            this.f74112a = view;
            this.f74113b = (ImageView) view.findViewById(R.id.aiv_topic_coin_icon);
            this.f74114c = (TextView) view.findViewById(R.id.atv_topic_coin_a);
            this.f74115d = (TextView) view.findViewById(R.id.atv_topic_coin_price);
            this.f74116e = (TextView) view.findViewById(R.id.atv_topic_coin_percent);
        }
    }

    public static /* synthetic */ void g(IndexContract.ElemsDTO elemsDTO, LinearLayout linearLayout, Void voidR) {
        String str;
        if (!TextUtils.isEmpty(elemsDTO.a())) {
            String substring = elemsDTO.a().contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? elemsDTO.a().substring(0, elemsDTO.a().indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) : "";
            if (elemsDTO.a().contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                str = elemsDTO.a().substring(elemsDTO.a().indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER), elemsDTO.a().length());
            } else {
                str = "";
            }
            String replace = str.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            FutureContractInfo futureContractInfo = new FutureContractInfo();
            futureContractInfo.setSymbol(substring);
            futureContractInfo.setQuoteCurrency(replace);
            futureContractInfo.setContractCode(elemsDTO.a());
            futureContractInfo.setContractShortType(elemsDTO.a());
            futureContractInfo.setContractType("swap");
            f.G(linearLayout.getContext(), futureContractInfo);
            g.i("app_feed_derivatives_click", HomeSensorsHelper.a(0, elemsDTO.b(), elemsDTO.a()));
        }
    }

    public final void c(HomeFeedInfoItem homeFeedInfoItem, LinearLayout linearLayout) {
        IndexContract j11;
        if (homeFeedInfoItem != null && linearLayout != null && (j11 = homeFeedInfoItem.j()) != null) {
            ArrayList<IndexContract.ElemsDTO> elems = j11.getElems();
            linearLayout.removeAllViews();
            if (elems != null && elems.size() > 0) {
                int size = elems.size();
                for (int i11 = 0; i11 < size; i11++) {
                    IndexContract.ElemsDTO elemsDTO = elems.get(i11);
                    if (elemsDTO != null) {
                        View inflate = LayoutInflater.from(linearLayout.getContext()).inflate(e(size), (ViewGroup) null, false);
                        a aVar = new a(inflate);
                        dw.a.a(inflate).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new c(elemsDTO, linearLayout));
                        i(inflate, size, i11);
                        j(aVar, elemsDTO);
                        linearLayout.addView(inflate);
                    }
                }
            }
        }
    }

    public String d(String str, double d11, Context context) {
        String tradeType = TradeType.CONTRACT.toString();
        int y11 = FuturePrecisionUtil.y(str, str, (String) null);
        if (d11 == 0.0d || m.h0(m.i(d11, y11)) == 0.0d) {
            return "--";
        }
        String str2 = (TradeType.isContract(tradeType) || TradeType.isSwap(tradeType) || TradeType.isContractIndex(tradeType)) ? "$" : "";
        return str2 + m.k(d11, y11, true);
    }

    public final int e(int i11) {
        return i11 == 3 ? R.layout.home_feed_contract_3 : i11 == 2 ? R.layout.home_feed_contract_2 : R.layout.home_feed_contract_1;
    }

    /* renamed from: f */
    public void handleView(v9.c cVar, int i11, HomeFeedInfoItem homeFeedInfoItem, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) cVar.e().b(R.id.item_content);
        FeedFragment.H.b(true);
        try {
            c(homeFeedInfoItem, linearLayout);
            g.g("app_recome_content_show", HomeSensorsHelper.d(0, homeFeedInfoItem.d(), "", "derivatives", homeFeedInfoItem.r(), (String) null, 100));
        } catch (Exception unused) {
        }
        this.f74111b = true;
    }

    public int getResId() {
        return R.layout.item_home_contract;
    }

    public void h(View view, HomeFeedInfoItem homeFeedInfoItem) {
        LinearLayout linearLayout;
        IndexContract j11;
        if (view != null && homeFeedInfoItem != null && (linearLayout = (LinearLayout) view.findViewById(R.id.item_content)) != null && (j11 = homeFeedInfoItem.j()) != null) {
            ArrayList<IndexContract.ElemsDTO> elems = j11.getElems();
            for (int i11 = 0; i11 < elems.size(); i11++) {
                try {
                    j(new a(linearLayout.getChildAt(i11)), elems.get(i11));
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void i(View view, int i11, int i12) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        if (i11 == 3) {
            if (i12 == 0 || i12 == 1) {
                layoutParams.setMargins(0, 0, DisplayTool.dp2px(7.0f), 0);
            }
        } else if (i11 == 2 && i12 == 0) {
            layoutParams.setMargins(0, 0, DisplayTool.dp2px(7.0f), 0);
        }
        view.findViewById(R.id.cl_coin_item).setLayoutParams(layoutParams);
    }

    public final void j(a aVar, IndexContract.ElemsDTO elemsDTO) {
        String str;
        String str2;
        if (elemsDTO != null) {
            aVar.f74114c.setText(elemsDTO.a() != null ? elemsDTO.a().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "") : "");
            if (elemsDTO.a().contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                str = elemsDTO.a().substring(0, elemsDTO.a().indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER));
            } else {
                str = "";
            }
            f6.c.a().f(aVar.f74113b, p.l(str), p.m());
            SymbolPrice symbolPrice = k.g().h().get(elemsDTO.a());
            Double valueOf = Double.valueOf(q.a(symbolPrice) ? 0.0d : symbolPrice.getClose().doubleValue());
            Double valueOf2 = Double.valueOf(q.a(symbolPrice) ? 0.0d : symbolPrice.getOpen().doubleValue());
            double doubleValue = valueOf.doubleValue() - valueOf2.doubleValue();
            if (valueOf2.doubleValue() == 0.0d) {
                str2 = "0.00%";
            } else {
                str2 = m.S(doubleValue / valueOf2.doubleValue(), PrecisionUtil.v(""));
            }
            aVar.f74116e.setText(str2);
            aVar.f74115d.setText(d(elemsDTO.a(), valueOf.doubleValue(), aVar.f74114c.getContext()));
            int indexOf = str2.indexOf("--");
            int i11 = R.color.base_down_color;
            if (indexOf == 0) {
                i11 = R.color.baseColorDefaultPlaceholder;
            } else if (str2.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) != 0 ? !w.l() : w.l()) {
                i11 = R.color.base_up_color;
            }
            aVar.f74116e.setTextColor(b.h(i11));
        }
    }
}
