package com.huobi.account.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.huobi.index.bean.IndexFeatureItem;
import com.huochat.community.util.ImageLoadedrManager;
import gs.g;
import i6.r;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import oa.a;
import pro.huobi.R;
import yl.o;

public class AccountFixedQuickView extends LinearLayout {
    public AccountFixedQuickView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(IndexFeatureItem indexFeatureItem, Void voidR) {
        if (getContext() instanceof Activity) {
            HashMap hashMap = new HashMap();
            hashMap.put("groupCode", indexFeatureItem.groupCode);
            g.i("New_function_Me_click", hashMap);
            o.q((FragmentActivity) a.g().b(), indexFeatureItem, true);
        }
    }

    public final void b() {
        setOrientation(0);
    }

    public final void d(View view, IndexFeatureItem indexFeatureItem) {
        r rVar = new r(view);
        ImageView imageView = (ImageView) rVar.b(R.id.iv_icon);
        ((TextView) rVar.b(R.id.tv_title)).setText(indexFeatureItem.title);
        if (!TextUtils.isEmpty(indexFeatureItem.imgUrl)) {
            ImageLoadedrManager.getInstance().display(getContext(), indexFeatureItem.imgUrl, imageView, (int) R.drawable.home_ac_image);
        } else {
            imageView.setImageResource(R.drawable.home_ac_image);
        }
        dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new wg.a(this, indexFeatureItem));
    }

    public void setData(List<IndexFeatureItem> list) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        int i11 = 0;
        while (i11 < list.size() && i11 < 5) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.part_home_account_fixed_quick_item, (ViewGroup) null, false);
            addView(inflate, new LinearLayout.LayoutParams(0, -1, 1.0f));
            d(inflate, list.get(i11));
            i11++;
        }
    }

    public AccountFixedQuickView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }
}
