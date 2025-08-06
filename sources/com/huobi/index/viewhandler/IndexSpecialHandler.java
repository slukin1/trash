package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.module.huobi.im.utils.DateUtils;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexSpecial;
import com.huobi.utils.HomeHelper;
import d10.l;
import dw.a;
import he.b;
import i6.r;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import s9.c;

public final class IndexSpecialHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public Context f74228b;

    public static final void e(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    public final Context c() {
        Context context = this.f74228b;
        if (context != null) {
            return context;
        }
        return null;
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, HomeFeedInfoItem homeFeedInfoItem, ViewGroup viewGroup) {
        IndexSpecial indexSpecial = homeFeedInfoItem != null ? homeFeedInfoItem.f73163n : null;
        r e11 = cVar.e();
        ImageView imageView = (ImageView) e11.b(R.id.ivImage);
        TextView textView = (TextView) e11.b(R.id.tvDate);
        TextView textView2 = (TextView) e11.b(R.id.tvRead);
        TextView textView3 = (TextView) e11.b(R.id.tvComment);
        TextView textView4 = (TextView) e11.b(R.id.tvDsc);
        TextView textView5 = (TextView) e11.b(R.id.tvTitle);
        f(textView5.getContext());
        if (indexSpecial != null) {
            b.h(imageView, indexSpecial.imgUrl);
            textView.setText(indexSpecial.updateTime > 0 ? DateUtils.e(c(), indexSpecial.updateTime) : "");
            if (indexSpecial.viewNum > 0) {
                textView2.setVisibility(0);
                textView2.setText(HomeHelper.f(indexSpecial.viewNum));
            } else {
                textView2.setVisibility(8);
            }
            if (indexSpecial.commentNum > 0) {
                textView3.setVisibility(0);
                textView3.setText(String.valueOf(indexSpecial.commentNum));
            } else {
                textView3.setVisibility(8);
            }
            String str = indexSpecial.content;
            boolean z11 = true;
            if (str == null || str.length() == 0) {
                textView4.setVisibility(8);
            } else {
                textView4.setVisibility(0);
                textView4.setText(indexSpecial.content);
            }
            String str2 = indexSpecial.title;
            if (!(str2 == null || str2.length() == 0)) {
                z11 = false;
            }
            if (z11) {
                textView5.setVisibility(8);
            } else {
                textView5.setVisibility(0);
                textView5.setText(indexSpecial.title);
            }
        }
        a.a(e11.b(R.id.item_root)).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new p(new IndexSpecialHandler$handleView$2(textView5, indexSpecial, homeFeedInfoItem)));
    }

    public final void f(Context context) {
        this.f74228b = context;
    }

    public int getResId() {
        return R.layout.item_home_feed_special;
    }
}
