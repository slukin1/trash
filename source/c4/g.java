package c4;

import a4.e;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.c;
import com.bumptech.glide.request.transition.a;

public interface g<R> extends e {
    c getRequest();

    void getSize(f fVar);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r11, a<? super R> aVar);

    void removeCallback(f fVar);

    void setRequest(c cVar);
}
