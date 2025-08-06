package com.huobi.index.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.alibaba.fastjson.JSONObject;
import com.huobi.index.bean.RankingListData;
import java.util.Map;
import pro.huobi.R;
import rj.b;

public class RankingFragment extends BaseRankingFragment {

    /* renamed from: b  reason: collision with root package name */
    public View f73826b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f73827c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f73828d;

    /* renamed from: e  reason: collision with root package name */
    public View f73829e = null;

    /* renamed from: f  reason: collision with root package name */
    public b f73830f;

    /* renamed from: g  reason: collision with root package name */
    public int f73831g;

    /* renamed from: h  reason: collision with root package name */
    public int f73832h;

    /* renamed from: i  reason: collision with root package name */
    public RankingListData f73833i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f73834j;

    /* renamed from: k  reason: collision with root package name */
    public Map<String, String> f73835k;

    public void Ah(int i11) {
        this.f73831g = i11;
    }

    public View getRootView() {
        return this.f73826b;
    }

    public final void initView(View view) {
        this.f73827c = (FrameLayout) view.findViewById(R.id.rankingListRoot);
        this.f73828d = (LinearLayout) view.findViewById(R.id.id_common_empty_view);
        View th2 = th();
        this.f73829e = th2;
        if (th2 != null) {
            this.f73834j = false;
            this.f73827c.addView(th2);
            return;
        }
        this.f73834j = true;
        xh(true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_ranking_list_view, viewGroup, false);
        this.f73826b = inflate;
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
    }

    public int ph() {
        RankingListData rankingListData = this.f73833i;
        if (rankingListData == null || rankingListData.getTitleData() == null || this.f73832h < 0 || this.f73833i.getTitleData().size() <= this.f73832h || this.f73833i.getTitleData().get(this.f73832h) == null) {
            return -1;
        }
        return this.f73833i.getTitleData().get(this.f73832h).getType();
    }

    public int qh() {
        return 0;
    }

    public String rh() {
        RankingListData rankingListData = this.f73833i;
        return (rankingListData == null || rankingListData.getTitleData() == null || this.f73832h < 0 || this.f73833i.getTitleData().size() <= this.f73832h || this.f73833i.getTitleData().get(this.f73832h) == null) ? "" : this.f73833i.getTitleData().get(this.f73832h).getTitle();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        if (r0.marketValueIsEmpty() != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        if (r0.downRankDataIsEmpty() != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        if (r0.hotRankDataIsEmpty() != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0042, code lost:
        if (r0.newSymbolRankDataIsEmpty() != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004d, code lost:
        if (r0.volumeRankDataIsEmpty() != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0058, code lost:
        if (r0.upRankDataIsEmpty() != false) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean sh() {
        /*
            r4 = this;
            int r0 = r4.ph()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0050
            r3 = 2
            if (r0 == r3) goto L_0x0045
            r3 = 4
            if (r0 == r3) goto L_0x003a
            r3 = 5
            if (r0 == r3) goto L_0x002f
            r3 = 6
            if (r0 == r3) goto L_0x0024
            r3 = 10
            if (r0 == r3) goto L_0x0019
            goto L_0x005c
        L_0x0019:
            com.huobi.index.bean.RankingListData r0 = r4.f73833i
            if (r0 != 0) goto L_0x005b
            boolean r0 = r0.marketValueIsEmpty()
            if (r0 == 0) goto L_0x005b
            goto L_0x005a
        L_0x0024:
            com.huobi.index.bean.RankingListData r0 = r4.f73833i
            if (r0 != 0) goto L_0x005b
            boolean r0 = r0.downRankDataIsEmpty()
            if (r0 == 0) goto L_0x005b
            goto L_0x005a
        L_0x002f:
            com.huobi.index.bean.RankingListData r0 = r4.f73833i
            if (r0 != 0) goto L_0x005b
            boolean r0 = r0.hotRankDataIsEmpty()
            if (r0 == 0) goto L_0x005b
            goto L_0x005a
        L_0x003a:
            com.huobi.index.bean.RankingListData r0 = r4.f73833i
            if (r0 != 0) goto L_0x005b
            boolean r0 = r0.newSymbolRankDataIsEmpty()
            if (r0 == 0) goto L_0x005b
            goto L_0x005a
        L_0x0045:
            com.huobi.index.bean.RankingListData r0 = r4.f73833i
            if (r0 != 0) goto L_0x005b
            boolean r0 = r0.volumeRankDataIsEmpty()
            if (r0 == 0) goto L_0x005b
            goto L_0x005a
        L_0x0050:
            com.huobi.index.bean.RankingListData r0 = r4.f73833i
            if (r0 != 0) goto L_0x005b
            boolean r0 = r0.upRankDataIsEmpty()
            if (r0 == 0) goto L_0x005b
        L_0x005a:
            r1 = r2
        L_0x005b:
            r2 = r1
        L_0x005c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.ui.RankingFragment.sh():boolean");
    }

    public final View th() {
        RankingListData rankingListData;
        RankingListData rankingListData2 = this.f73833i;
        if (rankingListData2 == null || rankingListData2.newSymbolRankDataIsEmpty()) {
            return null;
        }
        if (ph() == 4) {
            RankingNewSymbolView rankingNewSymbolView = new RankingNewSymbolView(getContext());
            rankingNewSymbolView.setRankingListData(this.f73833i);
            rankingNewSymbolView.setEdgeEngine(this.f73830f);
            rankingNewSymbolView.c();
            return rankingNewSymbolView;
        } else if (!this.f73835k.containsKey(String.valueOf(ph())) || (rankingListData = this.f73833i) == null || rankingListData.hotRankDataIsEmpty()) {
            return null;
        } else {
            String str = this.f73835k.get(String.valueOf(ph()));
            if (str != null && !str.contains(".xml")) {
                str = str + ".xml";
            }
            return this.f73830f.E(str, getContext(), false, (JSONObject) null);
        }
    }

    public void uh() {
        View view;
        View view2;
        if (isAdded()) {
            if (this.f73831g == 4 && (view2 = this.f73829e) != null && (view2 instanceof RankingNewSymbolView)) {
                ((RankingNewSymbolView) view2).setRankingListData(this.f73833i);
            }
            if (this.f73834j) {
                View th2 = th();
                this.f73829e = th2;
                if (th2 != null) {
                    this.f73834j = false;
                    this.f73827c.addView(th2);
                }
            } else if (sh()) {
                this.f73834j = true;
                xh(true);
                View view3 = this.f73829e;
                if (view3 != null) {
                    this.f73827c.removeView(view3);
                }
            } else if (this.f73831g == 4 && (view = this.f73829e) != null && (view instanceof RankingNewSymbolView)) {
                RankingNewSymbolView rankingNewSymbolView = (RankingNewSymbolView) view;
                rankingNewSymbolView.setRankingListData(this.f73833i);
                rankingNewSymbolView.b();
            }
        }
    }

    public void vh(int i11) {
        this.f73832h = i11;
    }

    public void wh(b bVar) {
        this.f73830f = bVar;
    }

    public final void xh(boolean z11) {
        this.f73828d.setVisibility(z11 ? 0 : 8);
    }

    public void yh(Map<String, String> map) {
        this.f73835k = map;
    }

    public void zh(RankingListData rankingListData) {
        View view;
        this.f73833i = rankingListData;
        if (this.f73831g == 4 && (view = this.f73829e) != null && (view instanceof RankingNewSymbolView)) {
            ((RankingNewSymbolView) view).setRankingListData(rankingListData);
        }
    }
}
