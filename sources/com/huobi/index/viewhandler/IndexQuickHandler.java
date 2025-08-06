package com.huobi.index.viewhandler;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.index.api.IndexService;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.woodpecker.WoodPeckerSDK;
import com.huochat.community.util.ImageLoadedrManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import gs.g;
import i6.d;
import i6.m;
import i6.r;
import is.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import pro.huobi.R;
import s9.c;
import tq.p;
import yl.o;

public class IndexQuickHandler implements c {
    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(IndexFeatureItem indexFeatureItem, View view) {
        if (view.getContext() instanceof Activity) {
            HashMap hashMap = new HashMap();
            if (999 == indexFeatureItem.jumpMode) {
                hashMap.put("ball_id", ((indexFeatureItem.index / 5) + 1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((indexFeatureItem.index % 5) + 1));
                g.i("ball_more_click", hashMap);
            } else {
                hashMap.put("ball_site", Integer.valueOf(indexFeatureItem.index + 1));
                hashMap.put("type", indexFeatureItem.groupCode);
                hashMap.put("testKey", SP.i("key_home_page_layout_type", "A"));
                if (indexFeatureItem.cornerMarkContent != null) {
                    hashMap.put("tag_id", Integer.valueOf(indexFeatureItem.f73183id));
                    hashMap.put("tag_type", indexFeatureItem.cornerMarkContent.dynamic ? "1" : "2");
                }
                g.i("ball_icon_click", hashMap);
            }
            a.i("3584", hashMap);
            IndexFeatureItem.CornerMarkContent cornerMarkContent = indexFeatureItem.cornerMarkContent;
            if (cornerMarkContent != null && cornerMarkContent.oneTime == 1) {
                h(indexFeatureItem);
            }
            d.c("user_event", indexFeatureItem.getJumpUrl());
            WoodPeckerSDK.f().g().c("HomeFunctionEvent", indexFeatureItem.getJumpUrl(), "");
            if (indexFeatureItem.getJumpUrl() != null && indexFeatureItem.getJumpMode() == 1) {
                WoodPeckerSDK.f().g().c("FunctionWebSelected", indexFeatureItem.getJumpUrl(), "");
            }
            indexFeatureItem.isHomeFunction = true;
            o.q((FragmentActivity) oa.a.g().b(), indexFeatureItem, false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(RelativeLayout relativeLayout, boolean z11, IndexFeatureItem indexFeatureItem) {
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.iv_corner_mark);
        ((TextView) relativeLayout.findViewById(R.id.tv_corner_mark)).setVisibility(8);
        imageView.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = relativeLayout.getWidth() / 2;
        imageView.setLayoutParams(layoutParams);
        String str = z11 ? indexFeatureItem.cornerMarkContent.nightImageUrl : indexFeatureItem.cornerMarkContent.imageUrl;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!indexFeatureItem.cornerMarkContent.dynamic) {
            ImageLoadedrManager.getInstance().display(relativeLayout.getContext(), str, imageView);
        } else if (str.endsWith("gif")) {
            ImageLoadedrManager.getInstance().displayGif(relativeLayout.getContext(), str, imageView);
        } else {
            String str2 = relativeLayout.getContext().getExternalCacheDir().getAbsolutePath() + File.separator + str.substring(str.lastIndexOf("/") + 1);
            if (FileUtil.i(str2)) {
                i(imageView, str2);
            }
        }
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, IndexFeatureItem indexFeatureItem, ViewGroup viewGroup) {
        int i12;
        boolean equals = TextUtils.equals(indexFeatureItem.imgUrl, "index_quick_more");
        cVar.itemView.getLayoutParams().width = (PixelUtils.g() - PixelUtils.a(2.0f)) / 5;
        if (indexFeatureItem.isEmptyPlaceholder) {
            cVar.itemView.setVisibility(4);
            return;
        }
        cVar.itemView.setVisibility(0);
        boolean g11 = NightHelper.e().g();
        if (indexFeatureItem.cornerMarkContent != null) {
            j(cVar, indexFeatureItem, g11);
        }
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.tv_title);
        if (g11) {
            i12 = textView.getContext().getResources().getColor(R.color.quick_item_title_color_night);
        } else {
            i12 = textView.getContext().getResources().getColor(R.color.quick_item_title_color_day);
        }
        textView.setTextColor(i12);
        int i13 = g11 ? R.drawable.home_ac_image_night : R.drawable.home_ac_image;
        ImageView imageView = (ImageView) e11.b(R.id.iv_icon);
        if (TextUtils.isEmpty(indexFeatureItem.imgUrl)) {
            imageView.setImageResource(i13);
        } else if (equals) {
            imageView.setImageResource(e() ? R.drawable.newyear_more_icon : g11 ? R.drawable.index_quick_more_night : R.drawable.index_quick_more);
        } else {
            ImageLoadedrManager.getInstance().display(cVar.itemView.getContext(), indexFeatureItem.imgUrl, imageView, i13);
        }
        ((TextView) e11.b(R.id.tv_title)).setText(indexFeatureItem.title);
        cVar.itemView.setOnClickListener(new n(this, indexFeatureItem));
    }

    public final boolean e() {
        String format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Calendar.getInstance().getTime());
        return m.k0(format) > 20211228 && m.k0(format) < 20220105;
    }

    public int getResId() {
        return R.layout.item_index_quick;
    }

    public final void h(IndexFeatureItem indexFeatureItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(indexFeatureItem.f73183id));
        hashMap.put("cornerMarkId", Long.valueOf(indexFeatureItem.cornerMarkContent.cornerMarkId));
        String J = tg.r.x().J();
        hashMap.put("uid", Long.valueOf(!TextUtils.isEmpty(J) ? Long.parseLong(J) : 0));
        hashMap.put("groupCode", indexFeatureItem.groupCode);
        ((IndexService) p.V(IndexService.class)).sendCornerMarkClickedMessage(hashMap).compose(RxJavaHelper.t((u6.g) null)).subscribe();
    }

    public void i(ImageView imageView, String str) {
        imageView.setImageDrawable(w5.a.i(str));
    }

    public final void j(v9.c cVar, IndexFeatureItem indexFeatureItem, boolean z11) {
        RelativeLayout relativeLayout = (RelativeLayout) cVar.itemView.findViewById(R.id.rl_icon_and_corner_mark_container);
        relativeLayout.post(new o(this, relativeLayout, z11, indexFeatureItem));
    }
}
