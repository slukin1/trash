package f6;

import android.widget.ImageView;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f54468b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f54469c;

    public /* synthetic */ a(ImageView imageView, int i11) {
        this.f54468b = imageView;
        this.f54469c = i11;
    }

    public final void run() {
        this.f54468b.setImageResource(this.f54469c);
    }
}
