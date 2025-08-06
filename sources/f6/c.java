package f6;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.widget.ImageView;
import c4.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.e;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.glide.SvgSoftwareLayerSetter;
import i6.i;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f68154a;

    public class a implements e<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f68155b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f68156c;

        public a(ImageView imageView, int i11) {
            this.f68155b = imageView;
            this.f68156c = i11;
        }

        /* renamed from: e */
        public boolean onResourceReady(Bitmap bitmap, Object obj, g<Bitmap> gVar, DataSource dataSource, boolean z11) {
            i.b().d(new b(this.f68155b, bitmap));
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, g<Bitmap> gVar, boolean z11) {
            i.b().d(new a(this.f68155b, this.f68156c));
            return false;
        }
    }

    public static c a() {
        if (f68154a == null) {
            synchronized (c.class) {
                if (f68154a == null) {
                    f68154a = new c();
                }
            }
        }
        return f68154a;
    }

    public final boolean b(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        if (activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    public void c(ImageView imageView, String str) {
        if (b(imageView.getContext())) {
            com.bumptech.glide.a.w(imageView).e().M0(str).b((RequestOptions) new RequestOptions().n0(new CircleCrop())).D0(imageView);
        }
    }

    public void d(ImageView imageView, String str, int i11) {
        if (b(imageView.getContext())) {
            com.bumptech.glide.a.w(imageView).e().M0(str).b((RequestOptions) new RequestOptions().n0(new m(i11))).D0(imageView);
        }
    }

    public void e(ImageView imageView, String str) {
        if (b(imageView.getContext())) {
            com.bumptech.glide.a.w(imageView).b().M0(str).b(new RequestOptions()).D0(imageView);
        }
    }

    public void f(ImageView imageView, String str, int i11) {
        if (b(imageView.getContext())) {
            com.bumptech.glide.a.w(imageView).q(str).b((RequestOptions) ((RequestOptions) new RequestOptions().a0(i11)).l(i11)).D0(imageView);
        }
    }

    public void g(ImageView imageView, String str, Drawable drawable) {
        if (b(imageView.getContext())) {
            com.bumptech.glide.a.w(imageView).q(str).b((RequestOptions) ((RequestOptions) new RequestOptions().b0(drawable)).m(drawable)).D0(imageView);
        }
    }

    public void h(ImageView imageView, String str, int i11) {
        com.bumptech.glide.a.v(BaseApplication.b()).b().M0(str).G0(new a(imageView, i11)).R0();
    }

    public void i(ImageView imageView, String str) {
        if (b(imageView.getContext())) {
            com.bumptech.glide.a.w(imageView).b().M0(str).b((RequestOptions) new RequestOptions().n0(new CircleCrop())).D0(imageView);
        }
    }

    public void j(ImageView imageView, String str, int i11) {
        if (b(imageView.getContext())) {
            com.bumptech.glide.a.w(imageView).b().M0(str).b((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().n0(new CircleCrop())).a0(i11)).l(i11)).D0(imageView);
        }
    }

    public void k(ImageView imageView, String str, int i11) {
        if (b(imageView.getContext())) {
            com.bumptech.glide.a.w(imageView).b().M0(str).b((RequestOptions) new RequestOptions().n0(new m(i11))).D0(imageView);
        }
    }

    public void l(Context context, String str, ImageView imageView, int i11) {
        if (b(context)) {
            m(context, str, imageView, new SvgSoftwareLayerSetter(), i11 != 0 ? imageView.getResources().getDrawable(i11) : null);
        }
    }

    public void m(Context context, String str, ImageView imageView, SvgSoftwareLayerSetter svgSoftwareLayerSetter, Drawable drawable) {
        if (b(context)) {
            ((com.bumptech.glide.c) com.bumptech.glide.a.v(context).a(PictureDrawable.class).x0(com.bumptech.glide.a.v(context).c().b(((RequestOptions) new RequestOptions().m(drawable)).d())).G0(svgSoftwareLayerSetter).b0(drawable)).M0(str).D0(imageView);
        }
    }

    public void n(Context context, String str, ImageView imageView, SvgSoftwareLayerSetter svgSoftwareLayerSetter) {
        if (b(context)) {
            com.bumptech.glide.a.v(context).a(PictureDrawable.class).G0(svgSoftwareLayerSetter).M0(str).b(RequestOptions.r0(new CircleCrop())).D0(imageView);
        }
    }

    public void o(Context context, String str, ImageView imageView, int i11, SvgSoftwareLayerSetter svgSoftwareLayerSetter) {
        if (b(context)) {
            com.bumptech.glide.a.v(context).a(PictureDrawable.class).G0(svgSoftwareLayerSetter).M0(str).b(RequestOptions.r0(new m(i11))).D0(imageView);
        }
    }
}
