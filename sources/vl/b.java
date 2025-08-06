package vl;

import android.content.Context;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$string;
import com.huobi.homemarket.bean.MarketOptionFieldBean;
import com.huobi.homemarket.bean.MarketOptionItem;
import com.huobi.homemarket.bean.MarketOptionSettingBean;
import com.huobi.homemarket.bean.OptionFieldTitleEnum;
import com.huobi.homemarket.presenter.HomeMarketNewPresenter;
import com.huobi.homemarket.view.MarketOptionTopView;
import com.wtree.scrolltable.MyExpandRecycleView;
import com.wtree.scrolltable.SyncHorizontalScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rl.m;

public class b {

    /* renamed from: r  reason: collision with root package name */
    public static final int f76604r = PixelUtils.a(20.0f);

    /* renamed from: s  reason: collision with root package name */
    public static final int f76605s = PixelUtils.a(40.0f);

    /* renamed from: a  reason: collision with root package name */
    public TextView f76606a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f76607b;

    /* renamed from: c  reason: collision with root package name */
    public SyncHorizontalScrollView f76608c;

    /* renamed from: d  reason: collision with root package name */
    public SyncHorizontalScrollView f76609d;

    /* renamed from: e  reason: collision with root package name */
    public MyExpandRecycleView f76610e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f76611f;

    /* renamed from: g  reason: collision with root package name */
    public View f76612g;

    /* renamed from: h  reason: collision with root package name */
    public View f76613h;

    /* renamed from: i  reason: collision with root package name */
    public f f76614i;

    /* renamed from: j  reason: collision with root package name */
    public HomeMarketNewPresenter f76615j;

    /* renamed from: k  reason: collision with root package name */
    public FragmentActivity f76616k;

    /* renamed from: l  reason: collision with root package name */
    public MarketOptionTopView f76617l;

    /* renamed from: m  reason: collision with root package name */
    public List<MarketOptionItem> f76618m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public List<MarketOptionFieldBean> f76619n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public int f76620o = 0;

    /* renamed from: p  reason: collision with root package name */
    public RecyclerView.OnScrollListener f76621p = new a();

    /* renamed from: q  reason: collision with root package name */
    public RecyclerView.OnScrollListener f76622q = new C0823b();

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            if (recyclerView.getScrollState() != 0) {
                b.this.f76610e.removeOnScrollListener(b.this.f76622q);
                b.this.f76610e.scrollBy(i11, i12);
                b.this.f76610e.addOnScrollListener(b.this.f76622q);
            }
        }
    }

    /* renamed from: vl.b$b  reason: collision with other inner class name */
    public class C0823b extends RecyclerView.OnScrollListener {
        public C0823b() {
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            if (recyclerView.getScrollState() != 0) {
                b.this.f76611f.removeOnScrollListener(b.this.f76621p);
                b.this.f76611f.scrollBy(i11, i12);
                b.this.f76611f.addOnScrollListener(b.this.f76621p);
            }
        }
    }

    public b(Context context, View view) {
        o(context, view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(View view, int i11, int i12, int i13, int i14) {
        int i15 = f76604r;
        float f11 = 0.2f;
        float f12 = (((float) (i11 - i15)) * 0.2f) / ((float) (f76605s - i15));
        if (f12 < 0.0f) {
            f11 = 0.0f;
        } else if (f12 <= 0.2f) {
            f11 = f12;
        }
        this.f76614i.w(f11);
    }

    public void d(View view) {
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        this.f76607b.addView(view);
    }

    public final void e() {
        u(this.f76616k.getString(R$string.n_option_market_execl_affirm_price));
        this.f76619n = new ArrayList();
        for (OptionFieldTitleEnum marketOptionFieldBean : OptionFieldTitleEnum.values()) {
            this.f76619n.add(new MarketOptionFieldBean(marketOptionFieldBean));
        }
    }

    public void f() {
        this.f76607b.removeAllViews();
    }

    public RecyclerView g() {
        return this.f76611f;
    }

    public TextView h() {
        return this.f76606a;
    }

    public final SymbolPrice i(OptionMarketIndexInfo optionMarketIndexInfo) {
        HomeMarketNewPresenter homeMarketNewPresenter = this.f76615j;
        if (homeMarketNewPresenter == null || homeMarketNewPresenter.B1() == null || optionMarketIndexInfo == null) {
            return null;
        }
        return this.f76615j.B1().c(optionMarketIndexInfo.getOptionCode());
    }

    public RecyclerView j() {
        return this.f76610e;
    }

    public LinearLayout k() {
        return this.f76607b;
    }

    public final void l(List<MarketOptionItem> list) {
        TextPaint paint = h().getPaint();
        float d11 = m.d(h().getText().toString(), paint);
        float f11 = 0.0f;
        for (MarketOptionItem next : list) {
            float d12 = m.d(i6.m.m(next.getExercisePrice(), FuturePrecisionUtil.p(next.getSymbol())), paint);
            f11 = Math.max(f11, Math.max(d12, m.d("(" + next.getTradePartition().toUpperCase() + ")", paint)));
        }
        this.f76620o = (int) Math.max(f11, d11);
        h().setWidth(this.f76620o);
        this.f76614i.x(this.f76620o);
    }

    public void m(List<OptionMarketIndexInfo> list) {
        this.f76618m.clear();
        for (OptionMarketIndexInfo next : list) {
            MarketOptionItem marketOptionItem = null;
            Iterator<MarketOptionItem> it2 = this.f76618m.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                MarketOptionItem next2 = it2.next();
                if (TextUtils.equals(next2.getExercisePrice(), next.getExercisePrice())) {
                    marketOptionItem = next2;
                    break;
                }
            }
            if (marketOptionItem == null) {
                marketOptionItem = new MarketOptionItem();
                marketOptionItem.setSymbol(next.getSymbol());
                marketOptionItem.setExercisePrice(next.getExercisePrice());
                marketOptionItem.setTradePartition(next.getTradePartition());
                this.f76618m.add(marketOptionItem);
            }
            if (next.isCallType()) {
                marketOptionItem.setCallInfo(next);
            } else {
                marketOptionItem.setPutInfo(next);
            }
        }
        n(this.f76618m);
        l(this.f76618m);
        this.f76614i.h(this.f76618m);
    }

    public final void n(List<MarketOptionItem> list) {
        int size = this.f76619n.size();
        LinearLayout k11 = k();
        int direction = this.f76617l.getSelectedDirection().getDirection();
        for (int i11 = 0; i11 < size; i11++) {
            float f11 = 0.0f;
            MarketOptionFieldBean marketOptionFieldBean = this.f76619n.get(i11);
            TextView textView = (TextView) k11.getChildAt(i11);
            float d11 = m.d(this.f76616k.getString(marketOptionFieldBean.getFieldTitleEnum().getTitleRes()), textView.getPaint());
            for (MarketOptionItem next : list) {
                if (direction == 0) {
                    f11 = Math.max(f11, Math.max(m.c(this.f76616k, next.getCallInfo(), i11, i(next.getCallInfo()), textView.getPaint()), m.c(this.f76616k, next.getPutInfo(), i11, i(next.getPutInfo()), textView.getPaint())));
                } else if (direction == 2) {
                    f11 = Math.max(f11, m.c(this.f76616k, next.getPutInfo(), i11, i(next.getPutInfo()), textView.getPaint()));
                } else if (direction == 1) {
                    f11 = Math.max(f11, m.c(this.f76616k, next.getCallInfo(), i11, i(next.getCallInfo()), textView.getPaint()));
                }
            }
            marketOptionFieldBean.setWidth(Math.max(d11, f11));
        }
        z();
    }

    public final void o(Context context, View view) {
        this.f76616k = (FragmentActivity) context;
        this.f76606a = (TextView) view.findViewById(R$id.tv_left_title);
        this.f76607b = (LinearLayout) view.findViewById(R$id.lin_right_title_parent);
        this.f76608c = (SyncHorizontalScrollView) view.findViewById(R$id.scrollView_title);
        this.f76609d = (SyncHorizontalScrollView) view.findViewById(R$id.scrollView_list);
        this.f76611f = (RecyclerView) view.findViewById(R$id.listview_left);
        this.f76610e = (MyExpandRecycleView) view.findViewById(R$id.listview_right);
        this.f76612g = view.findViewById(R$id.dividerShadow);
        this.f76613h = view.findViewById(R$id.dividerTitleShadow);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f76616k);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.f76616k);
        this.f76611f.setLayoutManager(linearLayoutManager);
        this.f76610e.setLayoutManager(linearLayoutManager2);
        e();
        f fVar = new f(context, this);
        this.f76614i = fVar;
        fVar.y(this.f76619n);
        t(this.f76614i.c(), this.f76614i.d());
        x();
        y(this.f76611f, this.f76610e);
        float f11 = 0.6f;
        this.f76612g.setAlpha(NightHelper.e().g() ? 0.6f : 0.3f);
        View view2 = this.f76613h;
        if (!NightHelper.e().g()) {
            f11 = 0.3f;
        }
        view2.setAlpha(f11);
    }

    public final void p() {
        f();
        for (OptionFieldTitleEnum optionFieldTitleEnum : OptionFieldTitleEnum.values()) {
            TextView textView = new TextView(this.f76616k);
            textView.setGravity(19);
            textView.setText(this.f76616k.getString(optionFieldTitleEnum.getTitleRes()));
            textView.setTextSize(0, (float) PixelUtils.a(12.0f));
            textView.setTextColor(this.f76616k.getResources().getColor(R$color.baseColorSecondaryText));
            textView.setPadding(PixelUtils.a(12.5f), 0, 0, 0);
            Iterator<MarketOptionSettingBean> it2 = this.f76617l.getFieldSettingList().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                MarketOptionSettingBean next = it2.next();
                if (next.getFieldTitleEnum() == optionFieldTitleEnum) {
                    textView.setVisibility(next.isSelected() ? 0 : 8);
                }
            }
            d(textView);
        }
    }

    public void r(int i11) {
        this.f76614i.z(i11);
        this.f76614i.f();
    }

    public void s() {
        LinearLayout k11 = k();
        for (MarketOptionSettingBean next : this.f76617l.getFieldSettingList()) {
            k11.getChildAt(next.getFieldTitleEnum().getIndex()).setVisibility(next.isSelected() ? 0 : 8);
        }
        this.f76614i.f();
    }

    public void t(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.f76611f.setAdapter(adapter);
        this.f76610e.setAdapter(adapter2);
    }

    public void u(String str) {
        this.f76606a.setText(str);
    }

    public void v(MarketOptionTopView marketOptionTopView) {
        this.f76617l = marketOptionTopView;
        this.f76614i.v(marketOptionTopView.getFieldSettingList());
        p();
    }

    public void w(HomeMarketNewPresenter homeMarketNewPresenter) {
        this.f76615j = homeMarketNewPresenter;
        this.f76614i.A(homeMarketNewPresenter);
    }

    public void x() {
        this.f76608c.setScrollView(this.f76609d);
        this.f76609d.setScrollView(this.f76608c);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f76609d.setOnScrollChangeListener(new a(this));
        }
    }

    public final void y(RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.f76611f.addOnScrollListener(this.f76621p);
        this.f76610e.addOnScrollListener(this.f76622q);
    }

    public final void z() {
        LinearLayout k11 = k();
        int childCount = k11.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            ((TextView) k11.getChildAt(i11)).setWidth((int) this.f76619n.get(i11).getWidth());
        }
    }
}
