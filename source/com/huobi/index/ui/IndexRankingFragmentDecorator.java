package com.huobi.index.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.network.hbg.core.bean.RankList;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.widgets.IndexRankSubTextListIndicator;
import com.huobi.index.helper.IndexRankingTrackHelper;
import com.huobi.index.helper.IndexSPHelper;
import com.huobi.index.presenter.IndexPresenter;
import com.huobi.index.ui.widget.IndexViewPager;
import java.util.ArrayList;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import tg.r;
import yl.t;

public class IndexRankingFragmentDecorator extends BaseRankingFragment {

    /* renamed from: b  reason: collision with root package name */
    public IndexRankSubTextListIndicator f73774b;

    /* renamed from: c  reason: collision with root package name */
    public IndexViewPager f73775c;

    /* renamed from: d  reason: collision with root package name */
    public IndexPresenter.s0 f73776d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f73777e;

    /* renamed from: f  reason: collision with root package name */
    public List<RankScreenBean> f73778f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f73779g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final List<IndexRankingFragment> f73780h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public List<RankScreenBean> f73781i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public am.a f73782j;

    /* renamed from: k  reason: collision with root package name */
    public RankList f73783k;

    /* renamed from: l  reason: collision with root package name */
    public int f73784l;

    public class a implements IndexRankSubTextListIndicator.b {
        public a() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            t.o((RankScreenBean) IndexRankingFragmentDecorator.this.f73781i.get(i11));
            IndexRankingFragmentDecorator.this.f73775c.setCurrentItem(i11);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            int unused = IndexRankingFragmentDecorator.this.f73784l = i11;
            if (IndexRankingFragmentDecorator.this.f73781i.size() > 0) {
                RankScreenBean rankScreenBean = (RankScreenBean) IndexRankingFragmentDecorator.this.f73781i.get(i11);
                t.o(rankScreenBean);
                IndexRankingFragmentDecorator.this.xh();
                String screenValue = rankScreenBean.getScreenValue();
                int i12 = 1;
                if (IndexRankingFragmentDecorator.this.f73783k != null) {
                    i12 = IndexRankingFragmentDecorator.this.f73783k.getType();
                }
                b7.b.h(screenValue, i12);
                if (IndexRankingFragmentDecorator.this.f73783k != null) {
                    IndexRankingTrackHelper.a(IndexRankingFragmentDecorator.this.f73783k.getType(), rankScreenBean.getScreenValue());
                }
                IndexRankingFragmentDecorator.this.Gh();
            }
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f73787a;

        public c(int i11) {
            this.f73787a = i11;
        }
    }

    public boolean Ah(RankList rankList) {
        return this.f73783k.isSameSubTab(rankList);
    }

    public void Bh() {
        xh();
    }

    public void Ch(IndexPresenter.s0 s0Var) {
        this.f73776d = s0Var;
        for (int i11 = 0; i11 < this.f73780h.size(); i11++) {
            this.f73780h.get(i11).Mh(s0Var);
        }
    }

    public void Dh(RankList rankList) {
        if (this.f73783k != null && !Ah(rankList)) {
            this.f73783k = rankList;
            zh(false);
        }
        this.f73783k = rankList;
        if (rankList.isScreen()) {
            if (this.f73778f.size() > 0) {
                this.f73778f.clear();
            }
            List<RankScreenBean> screenListObject = this.f73783k.getScreenListObject();
            if (screenListObject != null) {
                for (int i11 = 0; i11 < screenListObject.size(); i11++) {
                    RankScreenBean rankScreenBean = screenListObject.get(i11);
                    if (rankScreenBean != null && !t.q(rankScreenBean.getScreenValue())) {
                        this.f73778f.add(rankScreenBean);
                    }
                }
                this.f73783k.setScreenListObject(this.f73778f);
            }
        }
        int size = this.f73780h.size();
        int i12 = this.f73784l;
        if (size > i12) {
            this.f73780h.get(i12).Nh(this.f73783k);
        }
    }

    public void Eh(boolean z11) {
        if (this.f73774b != null) {
            int i11 = 8;
            if (this.f73783k.getType() == 9) {
                this.f73774b.setVisibility(8);
                return;
            }
            IndexRankSubTextListIndicator indexRankSubTextListIndicator = this.f73774b;
            if (z11) {
                i11 = 0;
            }
            indexRankSubTextListIndicator.setVisibility(i11);
        }
    }

    public void Fh(IndexViewPager indexViewPager, int i11) {
        indexViewPager.a(this, i11);
    }

    public void Gh() {
        List<IndexRankingFragment> list;
        int i11;
        if (this.f73776d != null && (list = this.f73780h) != null && list.size() > (i11 = this.f73784l) && this.f73780h.get(i11) != null) {
            this.f73776d.Bd(this.f73780h.get(this.f73784l).Eh());
        }
    }

    public View getRootView() {
        int size = this.f73780h.size();
        int i11 = this.f73784l;
        if (size > i11) {
            return this.f73780h.get(i11).getRootView();
        }
        return this.f73777e;
    }

    public final void initView(View view) {
        this.f73777e = (LinearLayout) view.findViewById(R.id.root_view);
        this.f73774b = (IndexRankSubTextListIndicator) view.findViewById(R.id.sub_market_tab);
        this.f73775c = (IndexViewPager) view.findViewById(R.id.sub_ranking_viewpager);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.d().p(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.index_ranking_list_view_decorator, viewGroup, false);
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(c cVar) {
        if (cVar.f73787a < this.f73781i.size()) {
            t.o(this.f73781i.get(cVar.f73787a));
            this.f73775c.setCurrentItem(cVar.f73787a);
            IndexSPHelper.g("index_rank_sp", "rank_user_select_sub_optional_position_" + r.x().s(), this.f73781i.get(cVar.f73787a).getScreenValue());
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
        zh(true);
        xh();
    }

    public int ph() {
        return this.f73783k.getType();
    }

    public int qh() {
        IndexRankSubTextListIndicator indexRankSubTextListIndicator = this.f73774b;
        if (indexRankSubTextListIndicator == null || indexRankSubTextListIndicator.getVisibility() != 0) {
            return 0;
        }
        return this.f73774b.getHeight();
    }

    public String rh() {
        RankList rankList = this.f73783k;
        if (rankList == null) {
            return "";
        }
        return rankList.getTypeTitle();
    }

    public final void xh() {
        if (this.f73781i.size() > 0) {
            t.o(this.f73781i.get(this.f73784l));
        }
        int size = this.f73780h.size();
        int i11 = this.f73784l;
        if (size > i11) {
            this.f73780h.get(i11).Bh(false);
        }
    }

    public RankList yh() {
        return this.f73783k;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0192, code lost:
        if (r9.size() > 0) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x019b, code lost:
        if (r8.f73783k.isShowUsdtSwapTab() != false) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01a4, code lost:
        if (r8.f73783k.isShowUsdtSwapTab() != false) goto L_0x01a8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zh(boolean r9) {
        /*
            r8 = this;
            com.hbg.lib.network.hbg.core.bean.RankList r0 = r8.f73783k
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            if (r9 != 0) goto L_0x000f
            am.a r9 = r8.f73782j
            if (r9 == 0) goto L_0x000f
            r9.c(r0)
        L_0x000f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "rank_user_select_sub_optional_position_"
            r9.append(r1)
            tg.r r1 = tg.r.x()
            java.lang.String r1 = r1.s()
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            java.lang.String r1 = "index_rank_sp"
            java.lang.String r2 = ""
            java.lang.String r9 = com.huobi.index.helper.IndexSPHelper.c(r1, r9, r2)
            r1 = 0
            r8.f73784l = r1
            java.util.HashMap<java.lang.String, java.lang.String> r2 = yl.t.f76860d
            r2.clear()
            java.util.List<com.huobi.index.ui.IndexRankingFragment> r2 = r8.f73780h
            r2.clear()
            java.util.List<java.lang.String> r2 = r8.f73779g
            r2.clear()
            com.hbg.lib.network.hbg.core.bean.RankList r2 = r8.f73783k
            boolean r2 = r2.isScreen()
            r3 = 9
            r4 = -1
            if (r2 == 0) goto L_0x00be
            com.hbg.lib.network.hbg.core.bean.RankList r2 = r8.f73783k
            java.util.List r2 = r2.getScreenListObject()
            if (r2 == 0) goto L_0x00be
            com.hbg.lib.network.hbg.core.bean.RankList r2 = r8.f73783k
            java.util.List r2 = r2.getScreenListObject()
            int r2 = r2.size()
            if (r2 != r0) goto L_0x0062
            goto L_0x00be
        L_0x0062:
            com.hbg.lib.network.hbg.core.bean.RankList r2 = r8.f73783k
            java.util.List r2 = r2.getScreenListObject()
            r8.f73781i = r2
            r2 = r1
            r5 = r4
        L_0x006c:
            java.util.List<com.hbg.lib.network.hbg.core.bean.RankScreenBean> r6 = r8.f73781i
            int r6 = r6.size()
            if (r2 >= r6) goto L_0x00ba
            com.huobi.index.ui.IndexRankingFragment r6 = new com.huobi.index.ui.IndexRankingFragment
            r6.<init>()
            r6.Oh(r2)
            com.hbg.lib.network.hbg.core.bean.RankList r7 = r8.f73783k
            r6.Nh(r7)
            com.huobi.index.presenter.IndexPresenter$s0 r7 = r8.f73776d
            r6.Mh(r7)
            java.util.List<com.huobi.index.ui.IndexRankingFragment> r7 = r8.f73780h
            r7.add(r6)
            java.util.List<java.lang.String> r6 = r8.f73779g
            java.util.List<com.hbg.lib.network.hbg.core.bean.RankScreenBean> r7 = r8.f73781i
            java.lang.Object r7 = r7.get(r2)
            com.hbg.lib.network.hbg.core.bean.RankScreenBean r7 = (com.hbg.lib.network.hbg.core.bean.RankScreenBean) r7
            java.lang.String r7 = r7.getScreenTitle()
            r6.add(r7)
            com.hbg.lib.network.hbg.core.bean.RankList r6 = r8.f73783k
            int r6 = r6.getType()
            if (r6 != r3) goto L_0x00b7
            java.util.List<com.hbg.lib.network.hbg.core.bean.RankScreenBean> r6 = r8.f73781i
            java.lang.Object r6 = r6.get(r2)
            com.hbg.lib.network.hbg.core.bean.RankScreenBean r6 = (com.hbg.lib.network.hbg.core.bean.RankScreenBean) r6
            java.lang.String r6 = r6.getScreenValue()
            boolean r6 = android.text.TextUtils.equals(r9, r6)
            if (r6 == 0) goto L_0x00b7
            r5 = r2
        L_0x00b7:
            int r2 = r2 + 1
            goto L_0x006c
        L_0x00ba:
            r8.Eh(r0)
            goto L_0x00e1
        L_0x00be:
            com.huobi.index.ui.IndexRankingFragment r9 = new com.huobi.index.ui.IndexRankingFragment
            r9.<init>()
            com.hbg.lib.network.hbg.core.bean.RankList r2 = r8.f73783k
            r9.Nh(r2)
            com.huobi.index.presenter.IndexPresenter$s0 r2 = r8.f73776d
            r9.Mh(r2)
            java.util.List<com.huobi.index.ui.IndexRankingFragment> r2 = r8.f73780h
            r2.add(r9)
            java.util.List<java.lang.String> r9 = r8.f73779g
            com.hbg.lib.network.hbg.core.bean.RankList r2 = r8.f73783k
            java.lang.String r2 = r2.getTypeTitle()
            r9.add(r2)
            r8.Eh(r1)
            r5 = r4
        L_0x00e1:
            com.hbg.lib.widgets.IndexRankSubTextListIndicator r9 = r8.f73774b
            android.content.res.Resources r2 = r8.getResources()
            r6 = 2131099907(0x7f060103, float:1.781218E38)
            int r2 = r2.getColor(r6)
            r9.setTitleViewSelectColor(r2)
            com.hbg.lib.widgets.IndexRankSubTextListIndicator r9 = r8.f73774b
            android.content.res.Resources r2 = r8.getResources()
            r6 = 2131100871(0x7f0604c7, float:1.7814136E38)
            int r2 = r2.getColor(r6)
            r9.setIndicatorColor(r2)
            com.hbg.lib.widgets.IndexRankSubTextListIndicator r9 = r8.f73774b
            com.huobi.index.ui.IndexRankingFragmentDecorator$a r2 = new com.huobi.index.ui.IndexRankingFragmentDecorator$a
            r2.<init>()
            r9.setCallback(r2)
            com.hbg.lib.widgets.IndexRankSubTextListIndicator r9 = r8.f73774b
            com.huobi.index.ui.widget.IndexViewPager r2 = r8.f73775c
            net.lucode.hackware.magicindicator.ViewPagerHelper.a(r9, r2)
            com.hbg.lib.widgets.IndexRankSubTextListIndicator r9 = r8.f73774b
            java.util.List<java.lang.String> r2 = r8.f73779g
            r9.setDataList(r2)
            am.a r9 = r8.f73782j
            if (r9 != 0) goto L_0x0128
            am.a r9 = new am.a
            androidx.fragment.app.FragmentManager r2 = r8.getChildFragmentManager()
            r9.<init>(r2)
            r8.f73782j = r9
        L_0x0128:
            com.huobi.index.ui.widget.IndexViewPager r9 = r8.f73775c
            am.a r2 = r8.f73782j
            r9.setAdapter(r2)
            am.a r9 = r8.f73782j
            java.util.List<com.huobi.index.ui.IndexRankingFragment> r2 = r8.f73780h
            r9.b(r2)
            am.a r9 = r8.f73782j
            r9.notifyDataSetChanged()
            com.huobi.index.ui.widget.IndexViewPager r9 = r8.f73775c
            java.util.List<com.huobi.index.ui.IndexRankingFragment> r2 = r8.f73780h
            int r2 = r2.size()
            r9.setOffscreenPageLimit(r2)
            com.huobi.index.ui.widget.IndexViewPager r9 = r8.f73775c
            com.huobi.index.ui.IndexRankingFragmentDecorator$b r2 = new com.huobi.index.ui.IndexRankingFragmentDecorator$b
            r2.<init>()
            r9.addOnPageChangeListener(r2)
            java.util.List<com.huobi.index.ui.IndexRankingFragment> r9 = r8.f73780h
            int r9 = r9.size()
            if (r9 <= r0) goto L_0x01a7
            com.hbg.lib.network.hbg.core.bean.RankList r9 = r8.f73783k
            int r9 = r9.getType()
            if (r9 != r3) goto L_0x019e
            com.hbg.lib.network.hbg.core.bean.RankList r9 = r8.f73783k
            java.util.Map r9 = r9.getMultipleMap()
            if (r5 == r4) goto L_0x016a
            r0 = r5
            goto L_0x01a8
        L_0x016a:
            if (r9 == 0) goto L_0x01a7
            java.lang.String r2 = "spot"
            java.lang.Object r3 = r9.get(r2)
            if (r3 == 0) goto L_0x01a7
            java.lang.String r3 = "usdtSwap"
            java.lang.Object r4 = r9.get(r3)
            if (r4 == 0) goto L_0x01a7
            java.lang.Object r2 = r9.get(r2)
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r9 = r9.get(r3)
            java.util.List r9 = (java.util.List) r9
            int r2 = r2.size()
            if (r2 != 0) goto L_0x0195
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x0195
            goto L_0x01a8
        L_0x0195:
            com.hbg.lib.network.hbg.core.bean.RankList r9 = r8.f73783k
            boolean r9 = r9.isShowUsdtSwapTab()
            if (r9 == 0) goto L_0x01a7
            goto L_0x01a8
        L_0x019e:
            com.hbg.lib.network.hbg.core.bean.RankList r9 = r8.f73783k
            boolean r9 = r9.isShowUsdtSwapTab()
            if (r9 == 0) goto L_0x01a7
            goto L_0x01a8
        L_0x01a7:
            r0 = r1
        L_0x01a8:
            r8.f73784l = r0
            com.huobi.index.ui.widget.IndexViewPager r9 = r8.f73775c
            r9.setCurrentItem(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.ui.IndexRankingFragmentDecorator.zh(boolean):void");
    }
}
