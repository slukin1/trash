package e0;

import android.view.PixelCopy;
import androidx.camera.view.d;
import java.util.concurrent.Semaphore;

public final /* synthetic */ class j implements PixelCopy.OnPixelCopyFinishedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Semaphore f54246a;

    public /* synthetic */ j(Semaphore semaphore) {
        this.f54246a = semaphore;
    }

    public final void onPixelCopyFinished(int i11) {
        d.n(this.f54246a, i11);
    }
}
