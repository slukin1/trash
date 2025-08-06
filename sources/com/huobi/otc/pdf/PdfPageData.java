package com.huobi.otc.pdf;

import android.graphics.pdf.PdfRenderer;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.huobi.otc.handler.OtcPdfHandler;
import java.io.Serializable;
import java.util.Objects;
import s9.a;

public class PdfPageData implements Serializable, a {
    private e bitmapPool;
    private int pageIndex;
    private String pdfPath;
    private PdfRenderer renderer;
    private int screenWidth;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PdfPageData pdfPageData = (PdfPageData) obj;
        if (this.pageIndex != pdfPageData.pageIndex || !Objects.equals(this.pdfPath, pdfPageData.pdfPath)) {
            return false;
        }
        return true;
    }

    public e getBitmapPool() {
        return this.bitmapPool;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public String getPdfPath() {
        return this.pdfPath;
    }

    public PdfRenderer getRenderer() {
        return this.renderer;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public String getViewHandlerName() {
        return OtcPdfHandler.class.getName();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.pdfPath, Integer.valueOf(this.pageIndex)});
    }

    public void setBitmapPool(e eVar) {
        this.bitmapPool = eVar;
    }

    public void setPageIndex(int i11) {
        this.pageIndex = i11;
    }

    public void setPdfPath(String str) {
        this.pdfPath = str;
    }

    public void setRenderer(PdfRenderer pdfRenderer) {
        this.renderer = pdfRenderer;
    }

    public void setScreenWidth(int i11) {
        this.screenWidth = i11;
    }

    public String toString() {
        return "PdfPageData(pdfPath=" + getPdfPath() + ", pageIndex=" + getPageIndex() + ", screenWidth=" + getScreenWidth() + ", renderer=" + getRenderer() + ", bitmapPool=" + getBitmapPool() + ")";
    }
}
