package jumio.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.jumio.commons.log.Log;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class p2 extends AppCompatImageView {

    public static final class a extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p2 f56296a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f56297b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(p2 p2Var, Bitmap bitmap) {
            super(0);
            this.f56296a = p2Var;
            this.f56297b = bitmap;
        }

        public final Object invoke() {
            p2.super.setImageBitmap(this.f56297b);
            return Unit.f56620a;
        }
    }

    public static final class b extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p2 f56298a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Drawable f56299b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(p2 p2Var, Drawable drawable) {
            super(0);
            this.f56298a = p2Var;
            this.f56299b = drawable;
        }

        public final Object invoke() {
            p2.super.setImageDrawable(this.f56299b);
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p2 f56300a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f56301b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(p2 p2Var, int i11) {
            super(0);
            this.f56300a = p2Var;
            this.f56301b = i11;
        }

        public final Object invoke() {
            p2.super.setImageResource(this.f56301b);
            return Unit.f56620a;
        }
    }

    public p2(Context context) {
        super(context);
    }

    public final void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (!x.b(view, this)) {
            return;
        }
        if (i11 == 8 || i11 == 4) {
            String a11 = n.a(i11);
            Log.d("StickyImageView", "Visibility changed to: " + a11 + ". Resetting...");
            post(new t00.b(view));
        }
    }

    public void setImageAlpha(int i11) {
        if (i11 < 255) {
            Log.d("StickyImageView", "Tried to set alpha to " + i11 + ", ignoring...");
            return;
        }
        super.setImageAlpha(i11);
    }

    public void setImageBitmap(Bitmap bitmap) {
        a aVar = new a(this, bitmap);
        if (getDrawable() != null) {
            Log.d("StickyImageView", "Tried to replace image, ignoring...");
        } else {
            aVar.invoke();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        b bVar = new b(this, drawable);
        if (getDrawable() != null) {
            Log.d("StickyImageView", "Tried to replace image, ignoring...");
        } else {
            bVar.invoke();
        }
    }

    public void setImageResource(int i11) {
        c cVar = new c(this, i11);
        if (getDrawable() != null) {
            Log.d("StickyImageView", "Tried to replace image, ignoring...");
        } else {
            cVar.invoke();
        }
    }

    public void setVisibility(int i11) {
        if (i11 == 4 || i11 == 8) {
            String a11 = n.a(i11);
            Log.d("StickyImageView", "Tried to set visibility: " + a11 + ", ignoring...");
            return;
        }
        super.setVisibility(i11);
    }

    public static final void a(View view) {
        view.setVisibility(0);
    }
}
