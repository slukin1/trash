package c4;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.d;
import com.bumptech.glide.request.target.CustomTarget;

public final class e<Z> extends CustomTarget<Z> {

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f63155c = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: b  reason: collision with root package name */
    public final d f63156b;

    public class a implements Handler.Callback {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((e) message.obj).a();
            return true;
        }
    }

    public e(d dVar, int i11, int i12) {
        super(i11, i12);
        this.f63156b = dVar;
    }

    public static <Z> e<Z> b(d dVar, int i11, int i12) {
        return new e<>(dVar, i11, i12);
    }

    public void a() {
        this.f63156b.g(this);
    }

    public void onLoadCleared(Drawable drawable) {
    }

    public void onResourceReady(Z z11, com.bumptech.glide.request.transition.a<? super Z> aVar) {
        f63155c.obtainMessage(1, this).sendToTarget();
    }
}
