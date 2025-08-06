package com.huobi.invite.presenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.invite.bean.InviteRankingListItem;
import com.huobi.invite.bean.InviteReturnDetail;
import com.huobi.invite.bean.InviteReturnRank;
import com.huobi.invite.helper.InviteReturnHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import q6.d;
import u6.g;

public class InviteRankingListPresenter extends ActivityPresenter<a> implements dm.a {

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f74509b = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public interface a extends g {
        void Md(List<InviteReturnDetail> list, List<s9.a> list2);

        long jc();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(InviteReturnRank inviteReturnRank) {
        List<InviteReturnDetail> rankList;
        if (inviteReturnRank != null && (rankList = inviteReturnRank.getRankList()) != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < rankList.size(); i11++) {
                InviteReturnDetail inviteReturnDetail = rankList.get(i11);
                if (i11 < 3) {
                    arrayList.add(inviteReturnDetail);
                } else {
                    InviteRankingListItem inviteRankingListItem = new InviteRankingListItem();
                    inviteRankingListItem.callback = this;
                    inviteRankingListItem.inviteReturnDetail = inviteReturnDetail;
                    arrayList2.add(inviteRankingListItem);
                }
            }
            ((a) getUI()).Md(arrayList, arrayList2);
        }
    }

    public void O(InviteReturnDetail inviteReturnDetail) {
    }

    public void R() {
        String format = this.f74509b.format(new Date(((a) getUI()).jc()));
        HashMap hashMap = new HashMap();
        hashMap.put("end-date", format);
        hashMap.put("size", "30");
        InviteReturnHelper.c(hashMap).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new em.a(this)));
    }

    /* renamed from: T */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        R();
    }
}
