package com.huobi.trade.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.network.hbg.core.bean.MarginTitlePopMgtBean;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.huobi.store.AppConfigManager;
import com.huobi.trade.presenter.TradePresenter;
import com.huobi.view.TitleLayout;
import gj.d;
import gs.g;
import i6.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pro.huobi.R;

public class TradeFragmentTitleHelper {

    /* renamed from: a  reason: collision with root package name */
    public HorizontalScrollView f82754a;

    /* renamed from: b  reason: collision with root package name */
    public TitleLayout f82755b;

    /* renamed from: c  reason: collision with root package name */
    public int f82756c = -1;

    public class a implements TitleLayout.ItemCreator {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f82757a;

        public a(Context context) {
            this.f82757a = context;
        }

        public View createItemView(int i11) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f82757a).inflate(R.layout.layout_trade_title_text_view, (ViewGroup) null);
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.iv_red_point);
            imageView.setVisibility(8);
            if (i11 == TradeFragmentTitleHelper.this.k()) {
                View findViewById = viewGroup.findViewById(getTextViewId());
                findViewById.setPadding(PixelUtils.a(16.0f), findViewById.getPaddingTop(), findViewById.getPaddingEnd(), findViewById.getPaddingBottom());
            }
            if (i11 == TradeFragmentTitleHelper.this.m() && SP.k("couponChoose", "hasNewCoupon9", false)) {
                imageView.setVisibility(0);
            }
            TextView textView = (TextView) viewGroup.findViewById(R.id.tv_pop);
            if (i11 == TradeFragmentTitleHelper.this.l()) {
                MarginTitlePopMgtBean marginTitlePopMgtBean = (MarginTitlePopMgtBean) AppConfigManager.c(MgtConfigNumber.MARGIN_POP_STATUS.number, MarginTitlePopMgtBean.class);
                textView.setVisibility(8);
                if (SP.k("couponChoose", "hasNewCoupon9,12", false)) {
                    imageView.setVisibility(0);
                    textView.setVisibility(8);
                } else if (marginTitlePopMgtBean != null && marginTitlePopMgtBean.getIsShow() == 1) {
                    textView.setVisibility(0);
                    textView.setText(marginTitlePopMgtBean.getTag());
                }
            } else {
                textView.setVisibility(8);
            }
            return viewGroup;
        }

        public int getTextViewId() {
            return R.id.f16920tv;
        }
    }

    public class b implements TitleLayout.OnTitleListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f82759b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f82760c;

        public b(c cVar, Context context) {
            this.f82759b = cVar;
            this.f82760c = context;
        }

        public void onTitleChange(int i11) {
            if (TradeFragmentTitleHelper.this.f82756c != i11) {
                this.f82759b.a();
                int scrollX = TradeFragmentTitleHelper.this.f82754a.getScrollX();
                View childAt = TradeFragmentTitleHelper.this.f82755b.getChildAt(i11);
                int left = childAt.getLeft();
                if (left < scrollX) {
                    TradeFragmentTitleHelper.this.f82754a.smoothScrollBy(left - scrollX, 0);
                }
                int right = childAt.getRight();
                int measuredWidth = TradeFragmentTitleHelper.this.f82754a.getMeasuredWidth();
                if (measuredWidth + scrollX < right) {
                    TradeFragmentTitleHelper.this.f82754a.smoothScrollBy((right - scrollX) - measuredWidth, 0);
                }
                if (i11 == TradeFragmentTitleHelper.this.k()) {
                    this.f82759b.f2().j0();
                } else if (i11 == TradeFragmentTitleHelper.this.m()) {
                    this.f82759b.f2().i0();
                    g.i("App_targe_tab_spot_click", (HashMap) null);
                } else if (i11 == TradeFragmentTitleHelper.this.l()) {
                    this.f82759b.f2().n0();
                } else if (i11 == TradeFragmentTitleHelper.this.j()) {
                    this.f82759b.f2().p0();
                    g.i("App_targe_tab_otc_click", (HashMap) null);
                } else if (i11 == TradeFragmentTitleHelper.this.n()) {
                    this.f82759b.f2().u0(this.f82760c);
                    TradeFragmentTitleHelper.this.p("App_targe_tradebottab_click", "TransPair_current_id", this.f82759b.f2().o0());
                }
            }
        }

        public void onTitleStatueChange(int i11, boolean z11) {
        }
    }

    public interface c {
        void a();

        TradePresenter f2();
    }

    public final int j() {
        int m11;
        if (d.n().G()) {
            m11 = l();
        } else {
            m11 = m();
        }
        return m11 + 1;
    }

    public final int k() {
        return 0;
    }

    public final int l() {
        if (d.n().G()) {
            return m() + 1;
        }
        return -10;
    }

    public final int m() {
        return k() + 1;
    }

    public final int n() {
        return j() + 1;
    }

    public void o(Context context, r rVar, c cVar) {
        this.f82754a = (HorizontalScrollView) rVar.b(R.id.title_horizontal_scroll);
        this.f82755b = (TitleLayout) rVar.b(R.id.title_layout);
        ArrayList arrayList = new ArrayList();
        arrayList.add(context.getResources().getString(R.string.otc_exchange_page_title));
        arrayList.add(context.getResources().getString(R.string.n_spot));
        if (d.n().G()) {
            arrayList.add(context.getResources().getString(R.string.n_kline_loan));
        }
        arrayList.add(context.getResources().getString(R.string.n_trade_fiat_title));
        arrayList.add(context.getResources().getString(R.string.n_trade_bot));
        this.f82755b.setUnableSelectedIndex(k());
        this.f82755b.setUnableSelectedIndex(n());
        this.f82755b.setUnableSelectedIndex(j());
        this.f82755b.setNormalTextSize((float) context.getResources().getDimensionPixelSize(R.dimen.dimen_18));
        this.f82755b.setSelectedTextSize((float) context.getResources().getDimensionPixelSize(R.dimen.dimen_18));
        this.f82755b.setNormalColor(ContextCompat.getColor(context, R.color.baseColorSecondaryText));
        this.f82755b.setSelectedColor(ContextCompat.getColor(context, R.color.baseColorPrimaryText));
        this.f82755b.setTitles((List<?>) arrayList, m(), (TitleLayout.ItemCreator) new a(context));
        com.huobi.trade.helper.c.b().k(1);
        this.f82755b.setTitleListener(new b(cVar, context));
    }

    public final void p(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str3);
        g.i(str, hashMap);
    }

    public void q(int i11) {
        this.f82756c = i11;
        this.f82755b.setIndex(i11);
    }

    public void r(String str) {
        this.f82755b.setSelectedText(str);
    }
}
