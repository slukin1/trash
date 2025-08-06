package com.hbg.module.market.widget.viewhandler;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.widget.bean.MarketHotSearchArea;
import com.hbg.module.market.widget.bean.MarketHotSearchItem;
import i6.r;
import java.util.ArrayList;
import java.util.List;
import jf.b;
import s9.a;
import s9.c;

public class MarketHotSearchAreaHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f26796b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public v9.a<a> f26797c;

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, MarketHotSearchArea marketHotSearchArea, ViewGroup viewGroup) {
        r e11 = cVar.e();
        cVar.itemView.getResources();
        RecyclerView recyclerView = (RecyclerView) e11.b(R$id.rv_hot_search);
        if (recyclerView.getAdapter() == null) {
            recyclerView.setLayoutManager(new GridLayoutManager(cVar.itemView.getContext(), 3));
            recyclerView.addItemDecoration(new nf.a(PixelUtils.a(12.0f)));
            recyclerView.setAdapter(this.f26797c);
        }
    }

    public int getResId() {
        List<String> list;
        this.f26796b.clear();
        b b11 = MarketModuleConfig.b();
        if (b11 == null) {
            list = null;
        } else {
            list = b11.f();
        }
        for (String symbol : list) {
            MarketHotSearchItem marketHotSearchItem = new MarketHotSearchItem();
            marketHotSearchItem.setSymbol(symbol);
            this.f26796b.add(marketHotSearchItem);
        }
        this.f26797c = new v9.a<>(this.f26796b);
        return R$layout.market_item_hot_search_area;
    }
}
