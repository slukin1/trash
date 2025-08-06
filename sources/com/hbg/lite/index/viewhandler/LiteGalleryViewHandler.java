package com.hbg.lite.index.viewhandler;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.index.bean.LiteHomeActivityEntity;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import s9.c;

public class LiteGalleryViewHandler implements c, View.OnClickListener {

    public class a implements tx.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v9.c f77173a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiteHomeActivityEntity f77174b;

        public a(v9.c cVar, LiteHomeActivityEntity liteHomeActivityEntity) {
            this.f77173a = cVar;
            this.f77174b = liteHomeActivityEntity;
        }

        public void a(String str, View view) {
        }

        public void b(String str, View view, FailReason failReason) {
        }

        public void c(String str, View view, Bitmap bitmap) {
            this.f77173a.e().e(R$id.id_index_gallery_item_title).setText(this.f77174b.getTitle());
            this.f77173a.e().e(R$id.id_index_gallery_item_content).setText(this.f77174b.getDescribe());
        }

        public void d(String str, View view) {
        }
    }

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, LiteHomeActivityEntity liteHomeActivityEntity, ViewGroup viewGroup) {
        b.c().k(cVar.e().c(R$id.id_index_gallery_item_image), liteHomeActivityEntity.getImg(), R$drawable.default_banner_image, new a(cVar, liteHomeActivityEntity));
        cVar.itemView.setTag(R$id.item_data, liteHomeActivityEntity);
        cVar.itemView.setOnClickListener(this);
        ViewGroup.LayoutParams layoutParams = cVar.itemView.getLayoutParams();
        int g11 = (PixelUtils.g() - (PixelUtils.a(10.0f) * 3)) / 2;
        layoutParams.width = g11;
        layoutParams.height = g11 / 2;
        cVar.itemView.setLayoutParams(layoutParams);
    }

    public int getResId() {
        return R$layout.lite_index_gallery_item;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        LiteHomeActivityEntity liteHomeActivityEntity = (LiteHomeActivityEntity) view.getTag(R$id.item_data);
        ra.c.a().a(view.getContext(), liteHomeActivityEntity.getUrl(), liteHomeActivityEntity.getTitle(), view.getContext().getString(R$string.head_return), false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
