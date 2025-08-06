package com.huobi.finance.viewhandler;

import al.p;
import al.s;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.pro.core.bean.ProjectItem;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.ProjectListItem;
import i6.r;
import s9.c;

public class ProjectItemViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, ProjectListItem projectListItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.tv_profit);
        ProjectItem data = projectListItem.getData();
        String str = LegalCurrencyConfigUtil.w() + " ";
        ((TextView) e11.b(R$id.tv_name)).setText(data.getName());
        s.g((ImageView) e11.b(R$id.iv_icon), data.getIcon());
        p.g((TextView) e11.b(R$id.tv_mine_cost), str, LegalCurrencyConfigUtil.B(data.getFarmingCost()));
        String B = LegalCurrencyConfigUtil.B(data.getFarmingIncome());
        p.g(textView, str, B);
        w.n(textView, B);
    }

    public int getResId() {
        return R$layout.item_on_chain_project;
    }
}
