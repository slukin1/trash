package com.huobi.account.viewhandler;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.index.bean.IndexFeatureItem;
import com.huochat.community.util.ImageLoadedrManager;
import gs.g;
import i6.r;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import oa.a;
import pro.huobi.R;
import s9.c;
import yl.o;

public class AccountQuickHandler implements c {
    public static /* synthetic */ void d(v9.c cVar, IndexFeatureItem indexFeatureItem, Void voidR) {
        if (cVar.itemView.getContext() instanceof Activity) {
            HashMap hashMap = new HashMap();
            hashMap.put("groupCode", indexFeatureItem.groupCode);
            g.i("New_function_Me_click", hashMap);
            o.q((FragmentActivity) a.g().b(), indexFeatureItem, true);
        }
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, IndexFeatureItem indexFeatureItem, ViewGroup viewGroup) {
        cVar.itemView.getLayoutParams().width = (PixelUtils.g() - PixelUtils.a(2.0f)) / 5;
        if (indexFeatureItem.isEmptyPlaceholder) {
            cVar.itemView.setVisibility(4);
            return;
        }
        cVar.itemView.setVisibility(0);
        r e11 = cVar.e();
        ImageView imageView = (ImageView) e11.b(R.id.iv_icon);
        TextView textView = (TextView) e11.b(R.id.tv_title);
        if (!TextUtils.isEmpty(indexFeatureItem.imgUrl)) {
            ImageLoadedrManager.getInstance().display(cVar.itemView.getContext(), indexFeatureItem.imgUrl, imageView, (int) R.drawable.home_ac_image);
        } else {
            imageView.setImageResource(R.drawable.home_ac_image);
        }
        textView.setText(indexFeatureItem.title);
        dw.a.a(cVar.itemView).throttleFirst(1, TimeUnit.SECONDS).subscribe(new vg.a(cVar, indexFeatureItem));
    }

    public int getResId() {
        return R.layout.item_account_quick;
    }
}
