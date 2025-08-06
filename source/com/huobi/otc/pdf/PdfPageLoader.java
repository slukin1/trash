package com.huobi.otc.pdf;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.model.f;
import pp.a;

public class PdfPageLoader implements d<PdfPageData, Bitmap> {

    public static class Factory implements s3.d<PdfPageData, Bitmap> {
        public d<PdfPageData, Bitmap> b(f fVar) {
            return new PdfPageLoader();
        }

        public void teardown() {
        }
    }

    /* renamed from: c */
    public d.a<Bitmap> a(PdfPageData pdfPageData, int i11, int i12, Options options) {
        return new d.a<>(new e4.d(pdfPageData), new a(pdfPageData));
    }

    /* renamed from: d */
    public boolean b(PdfPageData pdfPageData) {
        return true;
    }
}
