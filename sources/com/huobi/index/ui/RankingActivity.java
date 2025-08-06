package com.huobi.index.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.pro.socket.bean.SymbolPriceV2;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListenerV2;
import com.hbg.lib.network.pro.socket.response.MarketOverviewV2Response;
import com.hbg.lib.widgets.IndexTextListIndicator;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.index.bean.RankingListData;
import com.huobi.index.presenter.RankingPresenter;
import com.huobi.index.ui.widget.IndexViewPager;
import com.huochat.community.util.JsonTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import pro.huobi.R;

@Route(path = "/ranking/index")
public class RankingActivity extends BaseActivity<RankingPresenter, RankingPresenter.a> implements RankingPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public IndexTextListIndicator f73805b;

    /* renamed from: c  reason: collision with root package name */
    public IndexViewPager f73806c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f73807d;

    /* renamed from: e  reason: collision with root package name */
    public View f73808e;

    /* renamed from: f  reason: collision with root package name */
    public LoadingLayout f73809f;

    /* renamed from: g  reason: collision with root package name */
    public am.a f73810g;

    /* renamed from: h  reason: collision with root package name */
    public rj.b f73811h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f73812i = true;

    /* renamed from: j  reason: collision with root package name */
    public List<y9.b> f73813j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public List<RankingFragment> f73814k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public HashMap<Integer, Integer> f73815l = new HashMap<>();

    /* renamed from: m  reason: collision with root package name */
    public boolean f73816m = true;

    /* renamed from: n  reason: collision with root package name */
    public int f73817n = 0;

    /* renamed from: o  reason: collision with root package name */
    public MarketOverviewListenerV2 f73818o;

    public class a implements IndexTextListIndicator.d {
        public a() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            RankingActivity.this.f73805b.c(i11);
            RankingActivity.this.f73806c.setCurrentItem(i11);
            for (Map.Entry entry : RankingActivity.this.f73815l.entrySet()) {
                if (((Integer) entry.getValue()).intValue() == i11) {
                    RankingActivity.this.oh(((Integer) entry.getKey()).intValue());
                }
            }
        }
    }

    public class b extends MarketOverviewListenerV2 {
        public b() {
        }

        /* renamed from: j */
        public void f(MarketOverviewV2Response marketOverviewV2Response) {
            if (marketOverviewV2Response != null && marketOverviewV2Response.getData() != null) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : ((Map) marketOverviewV2Response.getData()).entrySet()) {
                    if (entry.getValue() != null) {
                        SymbolPriceV2 symbolPriceV2 = (SymbolPriceV2) entry.getValue();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("decimalcPrice", (Object) symbolPriceV2.getClose());
                        jSONObject2.put("decimalDelta", (Object) Double.valueOf(symbolPriceV2.getRise().doubleValue() * 100.0d));
                        jSONObject2.put("strAmount", (Object) symbolPriceV2.getAmount());
                        jSONObject2.put("symbol", (Object) symbolPriceV2.getSymbol());
                        jSONObject.put((String) entry.getKey(), (Object) jSONObject2);
                    }
                }
                if (RankingActivity.this.f73811h != null) {
                    rj.b Pg = RankingActivity.this.f73811h;
                    Pg.I("sendSocketData(" + JsonTool.toJSONString(jSONObject) + ")");
                }
            }
        }
    }

    public interface c {
        void a(String str, RankingListData rankingListData);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        th();
        LoadingLayout loadingLayout = this.f73809f;
        if (loadingLayout != null) {
            loadingLayout.p();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sh(String str, RankingListData rankingListData) {
        str.hashCode();
        if (str.equals("setRankingRequestError")) {
            this.f73807d.setVisibility(0);
            this.f73809f.g();
        } else if (str.equals("setRankingData")) {
            if (this.f73812i) {
                this.f73812i = false;
                this.f73813j.clear();
                this.f73814k.clear();
                this.f73815l.clear();
                Map hashMap = new HashMap();
                if (!rankingListData.getRankingXmlConfig().isEmpty()) {
                    hashMap = (Map) JSON.parseObject(rankingListData.getRankingXmlConfig(), Map.class);
                }
                for (int i11 = 0; i11 < rankingListData.getTitleData().size(); i11++) {
                    RankingListData.TitleData titleData = rankingListData.getTitleData().get(i11);
                    this.f73813j.add(new y9.b(titleData.getTitle(), "", false));
                    RankingFragment rankingFragment = new RankingFragment();
                    rankingFragment.wh(this.f73811h);
                    rankingFragment.vh(i11);
                    rankingFragment.zh(rankingListData);
                    rankingFragment.Ah(titleData.getType());
                    rankingFragment.yh(hashMap);
                    this.f73814k.add(rankingFragment);
                    this.f73815l.put(Integer.valueOf(titleData.getType()), Integer.valueOf(i11));
                    this.f73806c.a(rankingFragment, i11);
                }
                this.f73810g.b(this.f73814k);
                this.f73806c.setAdapter(this.f73810g);
                this.f73810g.notifyDataSetChanged();
                this.f73805b.n(this.f73813j, false);
                this.f73805b.c(ph(this.f73817n));
                this.f73806c.setCurrentItem(ph(this.f73817n));
                oh(this.f73817n);
                vh();
            } else {
                for (RankingFragment next : this.f73814k) {
                    next.zh(rankingListData);
                    next.uh();
                }
            }
            this.f73807d.setVisibility(8);
            this.f73809f.g();
        }
    }

    public static void uh(Activity activity, int i11) {
        Intent intent = new Intent(activity, RankingActivity.class);
        intent.putExtra(RankingListData.RANK_TYPE, i11);
        activity.startActivity(intent);
    }

    /* renamed from: Qg */
    public RankingPresenter createPresenter() {
        return new RankingPresenter();
    }

    public void addEvent() {
        this.f73808e.setOnClickListener(new q1(this));
        this.f73805b.setCallback(new a());
        if (this.f73818o == null) {
            this.f73818o = new b();
        }
        x8.a.a().t(true, this.f73818o);
    }

    public int getContentView() {
        return R.layout.activity_ranking;
    }

    public void initExtra() {
        super.initExtra();
        Intent intent = getIntent();
        if (intent != null) {
            this.f73817n = intent.getIntExtra(RankingListData.RANK_TYPE, 0);
        }
    }

    public void initView() {
        this.f73807d = (LinearLayout) this.viewFinder.b(R.id.ranking_error_ll);
        this.f73808e = this.viewFinder.b(R.id.viewErrorRetry);
        this.f73805b = (IndexTextListIndicator) this.viewFinder.b(R.id.ranking_tab);
        IndexViewPager indexViewPager = (IndexViewPager) this.viewFinder.b(R.id.ranking_viewpager);
        this.f73806c = indexViewPager;
        indexViewPager.setIsAutoHeight(Boolean.FALSE);
        this.f73810g = new am.a(getSupportFragmentManager());
        ViewPagerHelper.a(this.f73805b, this.f73806c);
        LoadingLayout loadingLayout = (LoadingLayout) this.viewFinder.b(R.id.ranking_loading_layout);
        this.f73809f = loadingLayout;
        loadingLayout.p();
        rh();
        this.f73811h.H();
    }

    public final void oh(int i11) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) Integer.valueOf(i11));
        rj.b bVar = this.f73811h;
        if (bVar != null) {
            bVar.I("displayList(" + JsonTool.toJSONString(jSONObject) + ")");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f73811h != null) {
            wh();
            this.f73811h.B();
            this.f73811h = null;
        }
        RankingBridgeAbility.f73821a = null;
        this.f73816m = false;
        if (this.f73818o != null) {
            x8.a.a().t(false, this.f73818o);
        }
        this.f73818o = null;
    }

    public void onPointerCaptureChanged(boolean z11) {
        super.onPointerCaptureChanged(z11);
    }

    public void onResume() {
        super.onResume();
        vh();
    }

    public void onStop() {
        super.onStop();
        wh();
    }

    public final int ph(int i11) {
        HashMap<Integer, Integer> hashMap = this.f73815l;
        if (hashMap != null) {
            return hashMap.get(Integer.valueOf(i11)).intValue();
        }
        return -1;
    }

    /* renamed from: qh */
    public RankingPresenter.a getUI() {
        return this;
    }

    public final void rh() {
        this.f73811h = new rj.b(this, "ranking");
        RankingBridgeAbility.f73821a = new r1(this);
        this.f73811h.t("rankingBridge", RankingBridgeAbility.class);
    }

    public final void th() {
        rj.b bVar = this.f73811h;
        if (bVar != null) {
            bVar.I("requestRankingList()");
        }
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public final void vh() {
        rj.b bVar = this.f73811h;
        if (bVar != null) {
            bVar.I("startTimer()");
        }
    }

    public final void wh() {
        rj.b bVar = this.f73811h;
        if (bVar != null) {
            bVar.I("stopTimer()");
        }
    }
}
