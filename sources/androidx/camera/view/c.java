package androidx.camera.view;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public Size f6451a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f6452b;

    /* renamed from: c  reason: collision with root package name */
    public final b f6453c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6454d = false;

    public interface a {
        void a();
    }

    public c(FrameLayout frameLayout, b bVar) {
        this.f6452b = frameLayout;
        this.f6453c = bVar;
    }

    public Bitmap a() {
        Bitmap c11 = c();
        if (c11 == null) {
            return null;
        }
        return this.f6453c.a(c11, new Size(this.f6452b.getWidth(), this.f6452b.getHeight()), this.f6452b.getLayoutDirection());
    }

    public abstract View b();

    public abstract Bitmap c();

    public abstract void d();

    public abstract void e();

    public void f() {
        this.f6454d = true;
        h();
    }

    public abstract void g(SurfaceRequest surfaceRequest, a aVar);

    public void h() {
        View b11 = b();
        if (b11 != null && this.f6454d) {
            this.f6453c.s(new Size(this.f6452b.getWidth(), this.f6452b.getHeight()), this.f6452b.getLayoutDirection(), b11);
        }
    }

    public abstract void i(Executor executor, PreviewView.d dVar);

    public abstract ListenableFuture<Void> j();
}
