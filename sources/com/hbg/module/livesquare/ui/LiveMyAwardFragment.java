package com.hbg.module.livesquare.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.hbg.core.bean.LiveWiningInfo;
import com.hbg.module.content.R$dimen;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.custom.decoration.WrapContentGridLayoutManager;
import com.hbg.module.livesquare.adapter.c;
import java.util.List;
import lc.w1;
import me.a;

public final class LiveMyAwardFragment extends BaseFragment<w1> {

    /* renamed from: p  reason: collision with root package name */
    public LiveWiningInfo.QueryAwardDrawResult f26582p;

    /* renamed from: Rh */
    public w1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return w1.K(layoutInflater, viewGroup, false);
    }

    public void initView() {
        Resources resources;
        List<LiveWiningInfo.DrawDetailList> drawDetailList;
        Bundle arguments = getArguments();
        List<LiveWiningInfo.DrawDetailList> list = null;
        LiveWiningInfo.QueryAwardDrawResult queryAwardDrawResult = (LiveWiningInfo.QueryAwardDrawResult) (arguments != null ? arguments.getSerializable("LiveWiningInfo") : null);
        this.f26582p = queryAwardDrawResult;
        if (queryAwardDrawResult != null) {
            if ((queryAwardDrawResult != null ? queryAwardDrawResult.getDrawDetailList() : null) != null) {
                LiveWiningInfo.QueryAwardDrawResult queryAwardDrawResult2 = this.f26582p;
                if (((queryAwardDrawResult2 == null || (drawDetailList = queryAwardDrawResult2.getDrawDetailList()) == null) ? null : Integer.valueOf(drawDetailList.size())).intValue() > 0) {
                    ((w1) uh()).B.g();
                    ((w1) uh()).C.setLayoutManager(new WrapContentGridLayoutManager(getContext(), 3));
                    ((w1) uh()).C.setItemAnimator((RecyclerView.ItemAnimator) null);
                    if (((w1) uh()).C.getItemDecorationCount() == 0) {
                        RecyclerView recyclerView = ((w1) uh()).C;
                        Context context = getContext();
                        recyclerView.addItemDecoration(new a(3, ((context == null || (resources = context.getResources()) == null) ? null : Integer.valueOf((int) resources.getDimension(R$dimen.dimen_8))).intValue(), false, false));
                    }
                    c cVar = new c(getActivity());
                    LiveWiningInfo.QueryAwardDrawResult queryAwardDrawResult3 = this.f26582p;
                    if (queryAwardDrawResult3 != null) {
                        list = queryAwardDrawResult3.getDrawDetailList();
                    }
                    cVar.a(0, list);
                    ((w1) uh()).C.setAdapter(cVar);
                    return;
                }
            }
        }
        ((w1) uh()).B.i();
    }
}
