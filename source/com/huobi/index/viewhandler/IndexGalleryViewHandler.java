package com.huobi.index.viewhandler;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.entity.HomeActivityEntity;
import com.huobi.webview2.ui.IndexWebActivity;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import pro.huobi.R;
import s9.c;

public class IndexGalleryViewHandler implements c, View.OnClickListener {

    public class a implements tx.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v9.c f74118a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomeActivityEntity f74119b;

        public a(v9.c cVar, HomeActivityEntity homeActivityEntity) {
            this.f74118a = cVar;
            this.f74119b = homeActivityEntity;
        }

        public void a(String str, View view) {
        }

        public void b(String str, View view, FailReason failReason) {
        }

        public void c(String str, View view, Bitmap bitmap) {
            this.f74118a.e().e(R.id.id_index_gallery_item_title).setText(this.f74119b.getTitle());
            this.f74118a.e().e(R.id.id_index_gallery_item_content).setText(this.f74119b.getDescribe());
        }

        public void d(String str, View view) {
        }
    }

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, HomeActivityEntity homeActivityEntity, ViewGroup viewGroup) {
        b.c().k(cVar.e().c(R.id.id_index_gallery_item_image), homeActivityEntity.getImg(), R.drawable.default_banner_image, new a(cVar, homeActivityEntity));
        cVar.itemView.setTag(R.id.item_data, homeActivityEntity);
        cVar.itemView.setOnClickListener(this);
        ViewGroup.LayoutParams layoutParams = cVar.itemView.getLayoutParams();
        int g11 = (PixelUtils.g() - (PixelUtils.a(10.0f) * 3)) / 2;
        layoutParams.width = g11;
        layoutParams.height = g11 / 2;
        cVar.itemView.setLayoutParams(layoutParams);
    }

    public int getResId() {
        return R.layout.activity_index_gallery_item;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        HomeActivityEntity homeActivityEntity = (HomeActivityEntity) view.getTag(R.id.item_data);
        if (!TextUtils.isEmpty(homeActivityEntity.url)) {
            IndexWebActivity.xh(view.getContext(), homeActivityEntity.url, homeActivityEntity.getTitle(), view.getContext().getString(R.string.head_return), false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
