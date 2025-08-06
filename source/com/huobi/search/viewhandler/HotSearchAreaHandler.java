package com.huobi.search.viewhandler;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.search.bean.HotSearchArea;
import com.huobi.search.bean.HotSearchItem;
import fr.b;
import i6.r;
import java.util.ArrayList;
import pro.huobi.R;
import s9.a;
import s9.c;

public class HotSearchAreaHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f80783b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public v9.a<a> f80784c;

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, HotSearchArea hotSearchArea, ViewGroup viewGroup) {
        r e11 = cVar.e();
        cVar.itemView.getResources();
        RecyclerView recyclerView = (RecyclerView) e11.b(R.id.rv_hot_search);
        if (recyclerView.getAdapter() == null) {
            recyclerView.setLayoutManager(new GridLayoutManager(cVar.itemView.getContext(), 3));
            recyclerView.addItemDecoration(new b(PixelUtils.a(12.0f)));
            recyclerView.setAdapter(this.f80784c);
        }
    }

    public int getResId() {
        this.f80783b.clear();
        for (String symbol : fr.a.e()) {
            HotSearchItem hotSearchItem = new HotSearchItem();
            hotSearchItem.setSymbol(symbol);
            this.f80783b.add(hotSearchItem);
        }
        this.f80784c = new v9.a<>(this.f80783b);
        return R.layout.item_hot_search_area;
    }
}
