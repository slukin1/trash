package f6;

import android.graphics.Bitmap;
import android.widget.ImageView;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f54470b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f54471c;

    public /* synthetic */ b(ImageView imageView, Bitmap bitmap) {
        this.f54470b = imageView;
        this.f54471c = bitmap;
    }

    public final void run() {
        this.f54470b.setImageBitmap(this.f54471c);
    }
}
