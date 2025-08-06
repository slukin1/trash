package pp;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.huobi.otc.pdf.PdfPageData;
import o3.d;

public class a implements d<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    public PdfPageData f84572b;

    public a(PdfPageData pdfPageData) {
        this.f84572b = pdfPageData;
    }

    public Class<Bitmap> a() {
        return Bitmap.class;
    }

    public void b() {
    }

    public DataSource c() {
        return null;
    }

    public void cancel() {
    }

    public void f(Priority priority, d.a<? super Bitmap> aVar) {
        try {
            synchronized (a.class) {
                PdfRenderer.Page openPage = this.f84572b.getRenderer().openPage(this.f84572b.getPageIndex());
                int screenWidth = this.f84572b.getScreenWidth();
                Bitmap d11 = this.f84572b.getBitmapPool().d(screenWidth, (int) (((float) (openPage.getHeight() * screenWidth)) / ((float) openPage.getWidth())), Bitmap.Config.ARGB_8888);
                openPage.render(d11, (Rect) null, (Matrix) null, 1);
                openPage.close();
                aVar.d(d11);
            }
        } catch (Exception e11) {
            aVar.e(e11);
        }
    }
}
