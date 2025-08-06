package com.huobi.otc.handler;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import c4.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.e;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.pdf.PdfPageData;
import java.util.List;
import s9.d;
import v9.c;

public class OtcPdfHandler implements d<PdfPageData> {

    public class a implements e<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f78782b;

        public a(ImageView imageView) {
            this.f78782b = imageView;
        }

        /* renamed from: a */
        public boolean onResourceReady(Bitmap bitmap, Object obj, g<Bitmap> gVar, DataSource dataSource, boolean z11) {
            if (bitmap == null || this.f78782b == null || bitmap.getHeight() == this.f78782b.getLayoutParams().height) {
                return false;
            }
            ViewGroup.LayoutParams layoutParams = this.f78782b.getLayoutParams();
            layoutParams.height = bitmap.getHeight();
            this.f78782b.setLayoutParams(layoutParams);
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, g<Bitmap> gVar, boolean z11) {
            return false;
        }
    }

    /* renamed from: b */
    public void handleView(c cVar, int i11, PdfPageData pdfPageData, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) cVar.e().b(R$id.iv_page);
        com.bumptech.glide.a.v(imageView.getContext()).b().G0(new a(imageView)).L0(pdfPageData).D0(imageView);
    }

    /* renamed from: c */
    public void a(c cVar, int i11, PdfPageData pdfPageData, ViewGroup viewGroup, List<Object> list) {
        handleView(cVar, i11, pdfPageData, viewGroup);
    }

    public int getResId() {
        return R$layout.item_pdf_page_layout;
    }
}
