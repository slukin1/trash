package zendesk.belvedere;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.v;
import f30.i;
import java.util.concurrent.atomic.AtomicBoolean;
import zendesk.belvedere.ui.R$dimen;

public class FixedWidthImageView extends AppCompatImageView implements v {

    /* renamed from: b  reason: collision with root package name */
    public int f62201b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f62202c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f62203d;

    /* renamed from: e  reason: collision with root package name */
    public int f62204e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f62205f = null;

    /* renamed from: g  reason: collision with root package name */
    public Picasso f62206g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f62207h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    public c f62208i;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            FixedWidthImageView.this.requestLayout();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f62210a;

        /* renamed from: b  reason: collision with root package name */
        public final int f62211b;

        /* renamed from: c  reason: collision with root package name */
        public final int f62212c;

        /* renamed from: d  reason: collision with root package name */
        public final int f62213d;

        public b(int i11, int i12, int i13, int i14) {
            this.f62210a = i11;
            this.f62211b = i12;
            this.f62212c = i13;
            this.f62213d = i14;
        }
    }

    public interface c {
        void a(b bVar);
    }

    public FixedWidthImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void c(Picasso picasso, int i11, int i12, Uri uri) {
        this.f62202c = i12;
        post(new a());
        c cVar = this.f62208i;
        if (cVar != null) {
            cVar.a(new b(this.f62204e, this.f62203d, this.f62202c, this.f62201b));
            this.f62208i = null;
        }
        picasso.j(uri).m(i11, i12).n(i.e(getContext(), R$dimen.belvedere_image_stream_item_radius)).g(this);
    }

    public final Pair<Integer, Integer> d(int i11, int i12, int i13) {
        return Pair.create(Integer.valueOf(i11), Integer.valueOf((int) (((float) i13) * (((float) i11) / ((float) i12)))));
    }

    public void e(Picasso picasso, Uri uri, long j11, long j12, c cVar) {
        if (uri == null || uri.equals(this.f62205f)) {
            h.a("FixedWidthImageView", "Image already loaded. " + uri);
            return;
        }
        Picasso picasso2 = this.f62206g;
        if (picasso2 != null) {
            picasso2.c(this);
            this.f62206g.b(this);
        }
        this.f62205f = uri;
        this.f62206g = picasso;
        int i11 = (int) j11;
        this.f62203d = i11;
        int i12 = (int) j12;
        this.f62204e = i12;
        this.f62208i = cVar;
        int i13 = this.f62201b;
        if (i13 > 0) {
            g(picasso, uri, i13, i11, i12);
        } else {
            this.f62207h.set(true);
        }
    }

    public void f(Picasso picasso, Uri uri, b bVar) {
        if (uri == null || uri.equals(this.f62205f)) {
            h.a("FixedWidthImageView", "Image already loaded. " + uri);
            return;
        }
        Picasso picasso2 = this.f62206g;
        if (picasso2 != null) {
            picasso2.c(this);
            this.f62206g.b(this);
        }
        this.f62205f = uri;
        this.f62206g = picasso;
        this.f62203d = bVar.f62211b;
        this.f62204e = bVar.f62210a;
        this.f62202c = bVar.f62212c;
        int d11 = bVar.f62213d;
        this.f62201b = d11;
        g(picasso, uri, d11, this.f62203d, this.f62204e);
    }

    public final void g(Picasso picasso, Uri uri, int i11, int i12, int i13) {
        h.a("FixedWidthImageView", "Start loading image: " + i11 + " " + i12 + " " + i13);
        if (i12 <= 0 || i13 <= 0) {
            picasso.j(uri).i(this);
            return;
        }
        Pair<Integer, Integer> d11 = d(i11, i12, i13);
        c(picasso, ((Integer) d11.first).intValue(), ((Integer) d11.second).intValue(), uri);
    }

    public void init() {
        this.f62202c = getResources().getDimensionPixelOffset(R$dimen.belvedere_image_stream_image_height);
    }

    public void onBitmapFailed(Exception exc, Drawable drawable) {
    }

    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        this.f62204e = bitmap.getHeight();
        int width = bitmap.getWidth();
        this.f62203d = width;
        Pair<Integer, Integer> d11 = d(this.f62201b, width, this.f62204e);
        c(this.f62206g, ((Integer) d11.first).intValue(), ((Integer) d11.second).intValue(), this.f62205f);
    }

    public void onMeasure(int i11, int i12) {
        int size = View.MeasureSpec.getSize(i11);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f62202c, 1073741824);
        if (this.f62201b == -1) {
            this.f62201b = size;
        }
        int i13 = this.f62201b;
        if (i13 > 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
            if (this.f62207h.compareAndSet(true, false)) {
                g(this.f62206g, this.f62205f, this.f62201b, this.f62203d, this.f62204e);
            }
        }
        super.onMeasure(i11, makeMeasureSpec);
    }

    public void onPrepareLoad(Drawable drawable) {
    }

    public FixedWidthImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
