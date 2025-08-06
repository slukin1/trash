package com.huobi.index.viewhandler;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b2.a;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.DeepNews;
import com.huobi.index.bean.IndexInformationItem;
import gs.g;
import he.b;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import s9.c;
import tg.r;

public class IndexDeepHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public IndexInformationItem f74117b;

    /* access modifiers changed from: private */
    public /* synthetic */ void f(DeepNews deepNews, Context context, Void voidR) {
        g.i("app_news_rechome_nrkp", d());
        long dynamicId = deepNews.getDynamicId();
        long id2 = deepNews.getId();
        if (0 != dynamicId) {
            a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(dynamicId)).navigation();
        } else if (0 != id2) {
            Intent intent = new Intent();
            BaseModuleConfig.a a11 = BaseModuleConfig.a();
            intent.putExtra("url", a11.k("pretender/news-detail-long?id=" + id2));
            intent.setClass(context, HBBaseWebActivity.class);
            context.startActivity(intent);
        }
    }

    public final HashMap<String, Object> d() {
        return new HashMap<String, Object>() {
            {
                String J = r.x().J();
                put("uid", (J == null || J.equals("")) ? "0" : J);
                put("type", 2);
                put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (!(IndexDeepHandler.this.f74117b == null || IndexDeepHandler.this.f74117b.g() == null)) {
                    put("contentid", Long.valueOf(IndexDeepHandler.this.f74117b.g().getId()));
                    put("title", IndexDeepHandler.this.f74117b.g().getTitle());
                }
                put("category", "homefeeds");
                put("recom_base_info", IndexDeepHandler.this.f74117b.d());
            }
        };
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, IndexInformationItem indexInformationItem, ViewGroup viewGroup) {
        this.f74117b = indexInformationItem;
        i6.r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        DeepNews g11 = indexInformationItem.g();
        if (g11 != null) {
            ((TextView) e11.b(R.id.tvTitle)).setText(g11.getTitle());
            ((TextView) e11.b(R.id.tvSource)).setText(g11.getSource());
            ((TextView) e11.b(R.id.tvTime)).setText(DateTimeUtils.h(g11.getIssueTime(), "yyyy-MM-dd HH:mm"));
            b.i((ImageView) e11.b(R.id.ivPic), g11.getImgUrl());
            dw.a.a(e11.b(R.id.llDeepNews)).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new d(this, g11, context));
        }
    }

    public int getResId() {
        return R.layout.item_deep_news;
    }
}
