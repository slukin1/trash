package vl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bz.b;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.huobi.homemarket.bean.MarketOptionFieldBean;
import com.huobi.homemarket.bean.MarketOptionItem;
import com.huobi.homemarket.bean.MarketOptionSettingBean;
import com.huobi.homemarket.bean.OptionFieldTitleEnum;
import com.huobi.homemarket.presenter.HomeMarketNewPresenter;
import com.huobi.homemarket.view.decoration.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.wtree.helper.Utils;
import i6.m;
import java.util.List;

public class f extends bz.b<MarketOptionItem> {

    /* renamed from: n  reason: collision with root package name */
    public static final int f76625n = PixelUtils.a(80.0f);

    /* renamed from: o  reason: collision with root package name */
    public static final int f76626o = PixelUtils.a(55.0f);

    /* renamed from: e  reason: collision with root package name */
    public b f76627e;

    /* renamed from: f  reason: collision with root package name */
    public d f76628f;

    /* renamed from: g  reason: collision with root package name */
    public List<MarketOptionSettingBean> f76629g;

    /* renamed from: h  reason: collision with root package name */
    public List<MarketOptionFieldBean> f76630h;

    /* renamed from: i  reason: collision with root package name */
    public int f76631i = 0;

    /* renamed from: j  reason: collision with root package name */
    public HomeMarketNewPresenter f76632j;

    /* renamed from: k  reason: collision with root package name */
    public int f76633k = 0;

    /* renamed from: l  reason: collision with root package name */
    public Context f76634l;

    /* renamed from: m  reason: collision with root package name */
    public float f76635m;

    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f76636a;

        public a(View view) {
            super(view);
            this.f76636a = view.getContext().getResources().getDisplayMetrics().widthPixels / 3;
        }

        public void a(int i11) {
            if (i11 == 10) {
                this.itemView.setVisibility(8);
            } else if (i11 == 5) {
                this.itemView.setLayoutParams(new ViewGroup.LayoutParams(this.f76636a, Utils.a(this.itemView.getContext(), 36.0f)));
            }
        }
    }

    public class b extends b.a {
        public b(bz.b bVar, Context context, RecyclerView recyclerView) {
            super(bVar, context, recyclerView);
            j(false);
        }

        public void g(RecyclerView.ViewHolder viewHolder, int i11) {
            if (viewHolder instanceof c) {
                ((c) viewHolder).a((MarketOptionItem) k(i11));
            }
        }

        public RecyclerView.ViewHolder i(ViewGroup viewGroup, int i11) {
            return new c(this.f48142o.inflate(R$layout.market_option_item_left_layout, viewGroup, false));
        }
    }

    public class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f76638a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f76639b;

        /* renamed from: c  reason: collision with root package name */
        public View f76640c;

        /* renamed from: d  reason: collision with root package name */
        public View f76641d;

        /* renamed from: e  reason: collision with root package name */
        public int f76642e = -1;

        public c(View view) {
            super(view);
            this.f76638a = (TextView) view.findViewById(R$id.tv_title);
            this.f76639b = (TextView) view.findViewById(R$id.tv_title_symbol);
            this.f76640c = view.findViewById(R$id.callFlagView);
            this.f76641d = view.findViewById(R$id.putFlagView);
        }

        public void a(MarketOptionItem marketOptionItem) {
            String m11 = m.m(marketOptionItem.getExercisePrice(), FuturePrecisionUtil.k(marketOptionItem.getSymbol()));
            this.f76638a.setText(m.c(m11, m11));
            TextView textView = this.f76639b;
            textView.setText("(" + marketOptionItem.getTradePartition().toUpperCase() + ")");
            this.f76640c.setBackgroundResource(w.h());
            this.f76641d.setBackgroundResource(w.d());
            boolean z11 = this.f76642e != f.this.f76633k;
            this.f76638a.setWidth(f.this.f76631i);
            this.f76639b.setWidth(f.this.f76631i);
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            layoutParams.width = f.this.f76631i;
            int i11 = f.this.f76633k;
            this.f76642e = i11;
            if (z11) {
                if (i11 == 0) {
                    layoutParams.height = f.f76625n;
                } else {
                    layoutParams.height = f.f76626o;
                }
            }
            this.itemView.requestLayout();
            int i12 = this.f76642e;
            if (i12 == 1) {
                this.f76640c.setVisibility(0);
                this.f76641d.setVisibility(8);
                this.f76640c.setAlpha(f.this.f76635m);
            } else if (i12 == 2) {
                this.f76640c.setVisibility(8);
                this.f76641d.setVisibility(0);
                this.f76641d.setAlpha(f.this.f76635m);
            } else {
                this.f76640c.setVisibility(0);
                this.f76641d.setVisibility(0);
                this.f76640c.setAlpha(f.this.f76635m);
                this.f76641d.setAlpha(f.this.f76635m);
            }
        }
    }

    public class d extends b.a {
        public d(bz.b bVar, Context context, RecyclerView recyclerView) {
            super(bVar, context, recyclerView);
            j(false);
        }

        public void g(RecyclerView.ViewHolder viewHolder, int i11) {
            if (viewHolder instanceof e) {
                ((e) viewHolder).e((MarketOptionItem) k(i11));
            }
        }

        public RecyclerView.ViewHolder i(ViewGroup viewGroup, int i11) {
            return new e(this.f48142o.inflate(R$layout.market_option_item_right_layout, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            if (getItemViewType(i11) != 3) {
                super.onBindViewHolder(viewHolder, i11);
            } else if (viewHolder instanceof a) {
                ((a) viewHolder).a(c());
            }
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            if (i11 == 3) {
                return new a(new View(viewGroup.getContext()));
            }
            return super.onCreateViewHolder(viewGroup, i11);
        }
    }

    public class e extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f76645a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f76646b;

        /* renamed from: c  reason: collision with root package name */
        public int f76647c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f76648d = OptionFieldTitleEnum.values().length;

        public e(View view) {
            super(view);
            this.f76645a = (LinearLayout) view.findViewById(R$id.optionCallFieldLayout);
            this.f76646b = (LinearLayout) view.findViewById(R$id.optionPutFieldLayout);
            i();
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void k(MarketOptionItem marketOptionItem, View view) {
            MarketModuleConfig.a().n0(f.this.f76634l, f.this.s(marketOptionItem.getCallInfo()));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void l(MarketOptionItem marketOptionItem, View view) {
            MarketModuleConfig.a().n0(f.this.f76634l, f.this.s(marketOptionItem.getPutInfo()));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void m(MarketOptionItem marketOptionItem, View view) {
            MarketModuleConfig.a().n0(f.this.f76634l, f.this.s(marketOptionItem.getCallInfo()));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void n(MarketOptionItem marketOptionItem, View view) {
            MarketModuleConfig.a().n0(f.this.f76634l, f.this.s(marketOptionItem.getPutInfo()));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void e(MarketOptionItem marketOptionItem) {
            boolean z11 = this.f76647c != f.this.f76633k;
            this.f76647c = f.this.f76633k;
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (f.this.f76633k == 1) {
                this.f76645a.setVisibility(0);
                this.f76646b.setVisibility(8);
                g(marketOptionItem.getCallInfo());
                this.f76645a.setOnClickListener(new g(this, marketOptionItem));
                if (z11) {
                    layoutParams.height = f.f76626o;
                }
                this.itemView.requestLayout();
            } else if (f.this.f76633k == 2) {
                this.f76645a.setVisibility(8);
                this.f76646b.setVisibility(0);
                h(marketOptionItem.getPutInfo());
                this.f76646b.setOnClickListener(new i(this, marketOptionItem));
                if (z11) {
                    layoutParams.height = f.f76626o;
                }
                this.itemView.requestLayout();
            } else {
                this.f76645a.setVisibility(0);
                this.f76646b.setVisibility(0);
                f(marketOptionItem);
                this.f76645a.setOnClickListener(new j(this, marketOptionItem));
                this.f76646b.setOnClickListener(new h(this, marketOptionItem));
                if (z11) {
                    layoutParams.height = f.f76625n;
                }
                this.itemView.requestLayout();
            }
            for (MarketOptionSettingBean marketOptionSettingBean : f.this.f76629g) {
                this.f76645a.getChildAt(marketOptionSettingBean.getFieldTitleEnum().getIndex()).setVisibility(marketOptionSettingBean.isSelected() ? 0 : 8);
                this.f76646b.getChildAt(marketOptionSettingBean.getFieldTitleEnum().getIndex()).setVisibility(marketOptionSettingBean.isSelected() ? 0 : 8);
            }
        }

        public final void f(MarketOptionItem marketOptionItem) {
            int childCount = this.f76646b.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                int i12 = i11;
                rl.m.a(f.this.f76634l, marketOptionItem.getCallInfo(), i12, (TextView) this.f76645a.getChildAt(i11), ((MarketOptionFieldBean) f.this.f76630h.get(i11)).getWidth(), f.this.t(marketOptionItem.getCallInfo()));
                int i13 = i11;
                rl.m.a(f.this.f76634l, marketOptionItem.getPutInfo(), i13, (TextView) this.f76646b.getChildAt(i11), ((MarketOptionFieldBean) f.this.f76630h.get(i11)).getWidth(), f.this.t(marketOptionItem.getPutInfo()));
            }
        }

        public final void g(OptionMarketIndexInfo optionMarketIndexInfo) {
            int childCount = this.f76645a.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                OptionMarketIndexInfo optionMarketIndexInfo2 = optionMarketIndexInfo;
                int i12 = i11;
                rl.m.a(f.this.f76634l, optionMarketIndexInfo2, i12, (TextView) this.f76645a.getChildAt(i11), ((MarketOptionFieldBean) f.this.f76630h.get(i11)).getWidth(), f.this.t(optionMarketIndexInfo));
            }
        }

        public final void h(OptionMarketIndexInfo optionMarketIndexInfo) {
            int childCount = this.f76646b.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                OptionMarketIndexInfo optionMarketIndexInfo2 = optionMarketIndexInfo;
                int i12 = i11;
                rl.m.a(f.this.f76634l, optionMarketIndexInfo2, i12, (TextView) this.f76646b.getChildAt(i11), ((MarketOptionFieldBean) f.this.f76630h.get(i11)).getWidth(), f.this.t(optionMarketIndexInfo));
            }
        }

        public final void i() {
            for (int i11 = 0; i11 < this.f76648d; i11++) {
                j(this.f76645a);
                j(this.f76646b);
            }
        }

        public final TextView j(ViewGroup viewGroup) {
            TextView textView = new TextView(this.itemView.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            textView.setTextSize(0, (float) PixelUtils.a(12.0f));
            textView.setTextColor(f.this.f76634l.getResources().getColor(R$color.baseColorPrimaryText));
            textView.setGravity(19);
            textView.setPadding(PixelUtils.a(12.5f), 0, 0, 0);
            viewGroup.addView(textView, layoutParams);
            return textView;
        }
    }

    public f(Context context, b bVar) {
        super(context);
        this.f76634l = context;
        this.f76627e = bVar;
        b bVar2 = new b(this, context, bVar.g());
        d dVar = new d(this, this.f76634l, bVar.j());
        this.f76628f = dVar;
        g(bVar2, dVar);
        this.f76627e.g().addItemDecoration(u());
        this.f76627e.j().addItemDecoration(u());
    }

    public void A(HomeMarketNewPresenter homeMarketNewPresenter) {
        this.f76632j = homeMarketNewPresenter;
    }

    public final FutureContractInfo s(OptionMarketIndexInfo optionMarketIndexInfo) {
        if (optionMarketIndexInfo == null) {
            return null;
        }
        return FutureContractInfoController.n().r(optionMarketIndexInfo.getOptionCode());
    }

    public final SymbolPrice t(OptionMarketIndexInfo optionMarketIndexInfo) {
        HomeMarketNewPresenter homeMarketNewPresenter = this.f76632j;
        if (homeMarketNewPresenter == null || homeMarketNewPresenter.B1() == null || optionMarketIndexInfo == null) {
            return null;
        }
        return this.f76632j.B1().c(optionMarketIndexInfo.getOptionCode());
    }

    public com.huobi.homemarket.view.decoration.a u() {
        return ((a.C0797a) ((a.C0797a) ((a.C0797a) new a.C0797a(this.f76634l).m(this.f76634l.getResources().getColor(R$color.baseColorPrimarySeparator))).o(true)).p(PixelUtils.a(0.5f))).s();
    }

    public void v(List<MarketOptionSettingBean> list) {
        this.f76629g = list;
    }

    public void w(float f11) {
        if (this.f76635m != f11) {
            this.f76635m = f11;
            c().notifyDataSetChanged();
        }
    }

    public void x(int i11) {
        this.f76631i = i11;
    }

    public void y(List<MarketOptionFieldBean> list) {
        this.f76630h = list;
    }

    public void z(int i11) {
        this.f76633k = i11;
    }
}
