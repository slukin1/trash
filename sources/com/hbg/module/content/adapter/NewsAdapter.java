package com.hbg.module.content.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationCoinTags;
import com.hbg.module.community.ui.DynamicDetailActivity;
import com.hbg.module.content.R$font;
import com.hbg.module.content.utls.TipsPopDialog;
import com.hbg.module.libkt.utils.event.bean.CommentNum;
import com.hbg.module.libkt.utils.event.bean.RisePut;
import com.hbg.module.libkt.utils.event.bean.ShareNum;
import com.huochat.community.widget.expandable.StatusType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.wtree.helper.Utils;
import he.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import lc.e4;
import rd.s;

public final class NewsAdapter extends c<NewFlashInformation, c.a<e4>> {

    /* renamed from: f  reason: collision with root package name */
    public final int f17817f;

    /* renamed from: g  reason: collision with root package name */
    public com.hbg.module.content.custom.decoration.a f17818g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<Integer, String> f17819h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public final Map<Integer, StatusType> f17820i = new LinkedHashMap();

    /* renamed from: j  reason: collision with root package name */
    public String f17821j;

    /* renamed from: k  reason: collision with root package name */
    public Integer f17822k;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17823b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17824c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsAdapter f17825d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewFlashInformation f17826e;

        public a(View view, long j11, NewsAdapter newsAdapter, NewFlashInformation newFlashInformation) {
            this.f17823b = view;
            this.f17824c = j11;
            this.f17825d = newsAdapter;
            this.f17826e = newFlashInformation;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17823b) > this.f17824c || (this.f17823b instanceof Checkable)) {
                sVar.e(this.f17823b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17823b;
                NewsAdapter.x(this.f17825d, this.f17826e, false, 2, (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17827b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17828c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsAdapter f17829d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewFlashInformation f17830e;

        public b(View view, long j11, NewsAdapter newsAdapter, NewFlashInformation newFlashInformation) {
            this.f17827b = view;
            this.f17828c = j11;
            this.f17829d = newsAdapter;
            this.f17830e = newFlashInformation;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17827b) > this.f17828c || (this.f17827b instanceof Checkable)) {
                sVar.e(this.f17827b, currentTimeMillis);
                NewsAdapter.x(this.f17829d, this.f17830e, false, 2, (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public NewsAdapter(FragmentActivity fragmentActivity, int i11) {
        super(fragmentActivity);
        this.f17817f = i11;
    }

    public static /* synthetic */ void o(NewsAdapter newsAdapter, NewFlashInformation newFlashInformation, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        newsAdapter.n(newFlashInformation, i11, z11);
    }

    public static final boolean q(NewsAdapter newsAdapter, NewFlashInformation newFlashInformation, int i11, View view) {
        newsAdapter.v(newFlashInformation, i11, view);
        return false;
    }

    public static /* synthetic */ void x(NewsAdapter newsAdapter, NewFlashInformation newFlashInformation, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        newsAdapter.w(newFlashInformation, z11);
    }

    public static /* synthetic */ void z(NewsAdapter newsAdapter, String str, String str2, NewFlashInformation newFlashInformation, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            newFlashInformation = null;
        }
        newsAdapter.y(str, str2, newFlashInformation);
    }

    public final void A(CommentNum commentNum) {
        int size = g().size();
        for (int i11 = 0; i11 < size; i11++) {
            if (commentNum.h() == ((NewFlashInformation) g().get(i11)).getId()) {
                ((NewFlashInformation) g().get(i11)).setComments(commentNum.g());
                notifyItemChanged(i11);
                return;
            }
        }
    }

    public final void B() {
        this.f17819h.clear();
        int size = g().size();
        String str = null;
        for (int i11 = 0; i11 < size; i11++) {
            if (((NewFlashInformation) g().get(i11)).getRecommend() != 1) {
                String i12 = DateTimeUtils.i(((NewFlashInformation) g().get(i11)).getIssueTime(), "EEEE MM-dd", AppLanguageHelper.getInstance().getCurAppLocale());
                if (!com.hbg.module.libkt.base.ext.b.x(i12) && !x.b(i12, str)) {
                    this.f17819h.put(Integer.valueOf(i11), i12);
                    str = i12;
                }
            }
        }
        com.hbg.module.content.custom.decoration.a aVar = this.f17818g;
        if (aVar != null) {
            aVar.b(this.f17819h);
        }
        notifyDataSetChanged();
    }

    public final void C(RisePut risePut) {
        int size = g().size();
        for (int i11 = 0; i11 < size; i11++) {
            if (risePut.a() == ((NewFlashInformation) g().get(i11)).getId()) {
                NewFlashInformation newFlashInformation = (NewFlashInformation) g().get(i11);
                newFlashInformation.setBullVote(risePut.c());
                newFlashInformation.setBadVote(risePut.b());
                newFlashInformation.setVotedType(risePut.d());
                notifyItemChanged(i11);
                return;
            }
        }
    }

    public final void D(ShareNum shareNum) {
        int size = g().size();
        for (int i11 = 0; i11 < size; i11++) {
            if (shareNum.b() == ((NewFlashInformation) g().get(i11)).getId()) {
                ((NewFlashInformation) g().get(i11)).setShared(shareNum.a());
                notifyItemChanged(i11);
                return;
            }
        }
    }

    public void a(int i11, List<? extends NewFlashInformation> list) {
        super.c(i11, list, false);
        B();
    }

    public final void n(NewFlashInformation newFlashInformation, int i11, boolean z11) {
        StatusType statusType;
        String title = newFlashInformation.getTitle();
        String content = newFlashInformation.getContent();
        newFlashInformation.setTitle(newFlashInformation.getOldTitle());
        newFlashInformation.setOldTitle(title);
        newFlashInformation.setContent(newFlashInformation.getOldContent());
        newFlashInformation.setOldContent(content);
        newFlashInformation.setTrans(z11);
        Integer valueOf = Integer.valueOf(i11);
        Map<Integer, StatusType> map = this.f17820i;
        if (z11) {
            statusType = StatusType.STATUS_CONTRACT;
        } else {
            statusType = StatusType.STATUS_EXPAND;
        }
        map.put(valueOf, statusType);
        notifyItemChanged(i11);
    }

    /* renamed from: p */
    public void onBindViewHolder(c.a<e4> aVar, int i11) {
        int i12 = i11;
        super.onBindViewHolder(aVar, i11);
        NewFlashInformation newFlashInformation = (NewFlashInformation) g().get(i12);
        y("app_news_content_show", "news_state", newFlashInformation);
        aVar.e().D.setText(DateTimeUtils.A(newFlashInformation.getIssueTime()));
        aVar.e().E.setText(newFlashInformation.getTitle());
        if (AppLanguageHelper.getInstance().isEnglishLanguage()) {
            aVar.e().E.setTypeface(Utils.c(R$font.roboto_medium));
        }
        if (1 == newFlashInformation.getIsTranslateTag()) {
            aVar.e().E.setOnLongClickListener(new p(this, newFlashInformation, i12));
        }
        s sVar = s.f23381a;
        AppCompatTextView appCompatTextView = aVar.e().E;
        NewFlashInformation newFlashInformation2 = newFlashInformation;
        appCompatTextView.setOnClickListener(new a(appCompatTextView, 800, this, newFlashInformation2));
        View root = aVar.e().getRoot();
        root.setOnClickListener(new b(root, 800, this, newFlashInformation2));
        List coinTags = newFlashInformation.getCoinTags();
        if (coinTags == null) {
            coinTags = new ArrayList();
        }
        if (coinTags.isEmpty()) {
            aVar.e().C.setVisibility(8);
            return;
        }
        aVar.e().C.removeAllViews();
        for (NewFlashInformationCoinTags newFlashInformationCoinTags : CollectionsKt___CollectionsKt.B0(coinTags, 2)) {
            Context context = aVar.itemView.getContext();
            int i13 = this.f17817f;
            String str = i13 == 1 ? BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL : i13 == 2 ? "8" : BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP;
            String valueOf = String.valueOf(newFlashInformation.getId());
            String title = newFlashInformation.getTitle();
            int isTranslateTag = newFlashInformation.getIsTranslateTag();
            String str2 = this.f17821j;
            kc.a aVar2 = kc.a.f19139a;
            aVar.e().C.addView(kc.a.d(context, newFlashInformationCoinTags, str, valueOf, title, isTranslateTag, str2, aVar2.e(newFlashInformationCoinTags.getCoin()), aVar2.f(), (d10.a) null, false, 512, (Object) null));
        }
        c.a<e4> aVar3 = aVar;
        aVar.e().C.setVisibility(0);
    }

    /* renamed from: r */
    public c.a<e4> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(e4.K(h(), viewGroup, false));
    }

    public final void s(com.hbg.module.content.custom.decoration.a aVar) {
        this.f17818g = aVar;
    }

    public final void t(Integer num) {
        this.f17822k = num;
    }

    public final void u(String str) {
        this.f17821j = str;
    }

    public final void v(NewFlashInformation newFlashInformation, int i11, View view) {
        new TipsPopDialog(f(), new NewsAdapter$showTransPop$1(newFlashInformation, this, i11), (String) null, (String) null, true, newFlashInformation.getTrans() ^ true ? 1 : 0, 12, (r) null).g(view);
    }

    public final void w(NewFlashInformation newFlashInformation, boolean z11) {
        z(this, "app_news_content_click", "news_state", (NewFlashInformation) null, 4, (Object) null);
        DynamicDetailActivity.a.d(DynamicDetailActivity.H, newFlashInformation.getDynamicId(), newFlashInformation.getId(), f(), z11, false, 16, (Object) null);
    }

    public final void y(String str, String str2, NewFlashInformation newFlashInformation) {
        HashMap hashMap = new HashMap();
        int i11 = this.f17817f;
        if (i11 == 1) {
            hashMap.put(str2, "app_favorites_news");
        } else if (i11 != 2) {
            hashMap.put(str2, "app_news_news");
        } else {
            hashMap.put(str2, "app_kline_news");
        }
        Integer num = this.f17822k;
        if (num != null) {
            hashMap.put("categoryId", Integer.valueOf(num.intValue()));
        }
        if (newFlashInformation != null) {
            hashMap.put("contentid", Long.valueOf(newFlashInformation.getId()));
            hashMap.put("title", newFlashInformation.getTitle());
            hashMap.put("content", newFlashInformation.getContent());
        }
        nc.c.a(str, hashMap);
    }
}
