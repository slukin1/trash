package com.huochat.community.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.a;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.e;
import com.bumptech.glide.request.target.SimpleTarget;
import com.huochat.community.CommunityManager;
import com.huochat.community.R;
import com.huochat.community.util.glideformation.BlurTransformation;
import com.huochat.community.util.glideformation.GlideTransformCircle;
import com.huochat.community.util.glideformation.RoundedCornersTransformation;
import java.io.File;
import n3.c;
import n3.g;

public final class ImageLoadedrManager {
    private static volatile ImageLoadedrManager instance;

    private ImageLoadedrManager() {
    }

    private int getImageDefResource() {
        if (CommunityManager.Companion.getInstance().isNightModel()) {
            return R.drawable.ic_def_huobi_icon_night;
        }
        return R.drawable.ic_def_huobi_icon_light;
    }

    public static ImageLoadedrManager getInstance() {
        if (instance == null) {
            synchronized (ImageLoadedrManager.class) {
                if (instance == null) {
                    instance = new ImageLoadedrManager();
                }
            }
        }
        return instance;
    }

    public void clearImageError(Context context, ImageView imageView) {
        a.v(context).f(imageView);
    }

    public void display(Context context, String str, ImageView imageView) {
        display(context, str, (String) null, (e) null, imageView);
    }

    public void displayBlurImage(Context context, String str, ImageView imageView) {
        if (isValidContextForGlide(context)) {
            RequestOptions requestOptions = new RequestOptions();
            g[] gVarArr = {new BlurTransformation(24, 8), new CenterCrop()};
            a.v(context).q(str).b((RequestOptions) requestOptions.n0(new c((g<T>[]) gVarArr))).D0(imageView);
        }
    }

    public void displayGif(Context context, int i11, ImageView imageView) {
        if (isValidContextForGlide(context)) {
            a.v(context).o(Integer.valueOf(i11)).b((RequestOptions) new RequestOptions().h(DiskCacheStrategy.f63712d)).D0(imageView);
        }
    }

    public void displayLarge(Context context, String str, String str2, ImageView imageView) {
        displayLarge(context, str, str2, (e) null, imageView);
    }

    public void displayRound(Context context, String str, ImageView imageView) {
        displayRound(context, str, getImageDefResource(), getImageDefResource(), getImageDefResource(), imageView);
    }

    public void displayRoundRect(Context context, String str, ImageView imageView, int i11, int i12) {
        displayRoundRect(context, str, imageView, i11, i12, (e) null);
    }

    public void displayRoundedCorners(Context context, String str, ImageView imageView, int i11, RoundedCornersTransformation.CornerType cornerType) {
        displayRoundedCorners(context, str, imageView, i11, cornerType, (e) null);
    }

    public void displayRoundwithoutCache(Context context, String str, ImageView imageView) {
        displayRoundwithoutCache(context, str, imageView, getImageDefResource());
    }

    public void displayStatic(Context context, String str, e<Bitmap> eVar, ImageView imageView) {
        if (isValidContextForGlide(context)) {
            if (eVar != null) {
                a.v(context).b().M0(str).r0(eVar).D0(imageView);
            } else {
                a.v(context).b().M0(str).D0(imageView);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [n3.g<android.graphics.Bitmap>, n3.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void displayWithTransform(android.content.Context r2, java.lang.String r3, android.widget.ImageView r4, n3.g<android.graphics.Bitmap> r5) {
        /*
            r1 = this;
            boolean r0 = r1.isValidContextForGlide(r2)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            com.bumptech.glide.request.RequestOptions r0 = new com.bumptech.glide.request.RequestOptions
            r0.<init>()
            com.bumptech.glide.request.BaseRequestOptions r5 = r0.n0(r5)
            com.bumptech.glide.request.RequestOptions r5 = (com.bumptech.glide.request.RequestOptions) r5
            com.bumptech.glide.d r2 = com.bumptech.glide.a.v(r2)
            com.bumptech.glide.c r2 = r2.q(r3)
            com.bumptech.glide.c r2 = r2.b(r5)
            r2.D0(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.ImageLoadedrManager.displayWithTransform(android.content.Context, java.lang.String, android.widget.ImageView, n3.g):void");
    }

    public void downloadFile(Context context, String str, SimpleTarget<File> simpleTarget) {
        downloadFile(context, str, simpleTarget, (e<File>) null);
    }

    public boolean isValidContextForGlide(Context context) {
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

    public void preloadFile(Context context, String str) {
        if (isValidContextForGlide(context)) {
            a.v(context).d().M0(str).A0(new SimpleTarget<File>() {
                public void onResourceReady(File file, com.bumptech.glide.request.transition.a<? super File> aVar) {
                }
            });
        }
    }

    public void display(Context context, String str, e<Bitmap> eVar, ImageView imageView) {
        display(context, str, (String) null, (e) eVar, imageView);
    }

    public void displayLarge(Context context, String str, String str2, e eVar, ImageView imageView) {
        if (isValidContextForGlide(context)) {
            RequestOptions requestOptions = new RequestOptions();
            ((RequestOptions) requestOptions.Y(Integer.MIN_VALUE)).l(getImageDefResource());
            com.bumptech.glide.c<Drawable> cVar = null;
            if (!TextUtils.isEmpty(str2)) {
                cVar = a.v(context).q(str2).b(requestOptions);
            }
            if (cVar != null) {
                a.v(context).q(str).T0(cVar).G0(eVar).D0(imageView);
            } else {
                a.v(context).q(str).G0(eVar).b(requestOptions).D0(imageView);
            }
        }
    }

    public void displayRoundRect(Context context, String str, ImageView imageView, int i11, int i12, e eVar) {
        displayRoundedCorners(context, str, imageView, i11, RoundedCornersTransformation.CornerType.ALL, eVar);
    }

    public void displayRoundedCorners(Context context, String str, ImageView imageView, int i11, RoundedCornersTransformation.CornerType cornerType, e eVar) {
        displayRoundedCorners(context, str, imageView, 0, i11, cornerType, eVar);
    }

    public void displayRoundwithoutCache(Context context, String str, ImageView imageView, int i11) {
        if (isValidContextForGlide(context)) {
            a.v(context).q(str).b((RequestOptions) ((RequestOptions) ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().a0(getImageDefResource())).l(i11)).h(DiskCacheStrategy.f63710b)).k0(true)).n0(new GlideTransformCircle())).D0(imageView);
        }
    }

    public void downloadFile(Context context, String str, SimpleTarget<File> simpleTarget, e<File> eVar) {
        if (isValidContextForGlide(context)) {
            a.v(context).d().G0(eVar).M0(str).A0(simpleTarget);
        }
    }

    public void display(Context context, String str, String str2, e eVar, ImageView imageView) {
        if (isValidContextForGlide(context)) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.l(getImageDefResource());
            com.bumptech.glide.c<Drawable> cVar = null;
            if (!TextUtils.isEmpty(str2)) {
                cVar = a.v(context).q(str2).b(requestOptions);
            }
            if (cVar != null) {
                a.v(context).q(str).T0(cVar).G0(eVar).D0(imageView);
            } else {
                a.v(context).q(str).G0(eVar).b(requestOptions).D0(imageView);
            }
        }
    }

    public void displayRoundRect(Context context, String str, int i11, ImageView imageView, int i12, int i13) {
        displayRoundedCorners(context, str, imageView, i11, i12, RoundedCornersTransformation.CornerType.ALL);
    }

    public void displayRoundedCorners(Context context, String str, ImageView imageView, int i11, int i12, RoundedCornersTransformation.CornerType cornerType) {
        displayRoundedCorners(context, str, imageView, i11, i12, cornerType, (e) null);
    }

    public void displayRound(Context context, String str, int i11, ImageView imageView) {
        displayRound(context, str, i11, getImageDefResource(), getImageDefResource(), imageView);
    }

    public void displayRoundedCorners(Context context, String str, ImageView imageView, int i11, int i12, RoundedCornersTransformation.CornerType cornerType, e eVar) {
        if (isValidContextForGlide(context)) {
            RequestOptions requestOptions = (RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().a0(i11)).l(getImageDefResource())).n0(new RoundedCornersTransformation(i12, 0, cornerType));
            if (eVar == null) {
                a.v(context).q(str).b(requestOptions).D0(imageView);
            } else {
                a.v(context).q(str).G0(eVar).b(requestOptions).D0(imageView);
            }
        }
    }

    public void displayStatic(Context context, String str, e<Bitmap> eVar) {
        if (isValidContextForGlide(context)) {
            a.v(context).b().M0(str).r0(eVar).R0();
        }
    }

    public void displayGif(Context context, String str, ImageView imageView) {
        displayGif(context, str, (Drawable) null, (e<Drawable>) null, imageView);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [n3.g<android.graphics.Bitmap>, n3.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void displayWithTransform(android.content.Context r2, int r3, android.widget.ImageView r4, n3.g<android.graphics.Bitmap> r5) {
        /*
            r1 = this;
            boolean r0 = r1.isValidContextForGlide(r2)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            com.bumptech.glide.request.RequestOptions r0 = new com.bumptech.glide.request.RequestOptions
            r0.<init>()
            com.bumptech.glide.request.BaseRequestOptions r5 = r0.n0(r5)
            com.bumptech.glide.request.RequestOptions r5 = (com.bumptech.glide.request.RequestOptions) r5
            com.bumptech.glide.d r2 = com.bumptech.glide.a.v(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.bumptech.glide.c r2 = r2.o(r3)
            com.bumptech.glide.c r2 = r2.b(r5)
            r2.D0(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.ImageLoadedrManager.displayWithTransform(android.content.Context, int, android.widget.ImageView, n3.g):void");
    }

    public void displayGif(Context context, String str, Drawable drawable, ImageView imageView) {
        displayGif(context, str, drawable, (e<Drawable>) null, imageView);
    }

    public void displayRound(Context context, String str, ImageView imageView, int i11) {
        displayRound(context, str, getImageDefResource(), getImageDefResource(), i11, imageView);
    }

    public void displayGif(Context context, String str, Drawable drawable, e<Drawable> eVar, ImageView imageView) {
        if (isValidContextForGlide(context)) {
            RequestOptions requestOptions = (RequestOptions) ((RequestOptions) new RequestOptions().j()).h(DiskCacheStrategy.f63712d);
            if (drawable != null) {
                requestOptions.b0(drawable);
            }
            a.v(context).q(str).b(requestOptions).G0(eVar).D0(imageView);
        }
    }

    public void displayRound(Context context, String str, ImageView imageView, int i11, int i12) {
        displayRound(context, str, i11, i11, i12, imageView);
    }

    public void displayWithTransform(Context context, String str, int i11, ImageView imageView, g<Bitmap> gVar) {
        displayWithTransform(context, str, i11, imageView, gVar, (e) null);
    }

    public void displayRound(Context context, String str, int i11, int i12, int i13, ImageView imageView) {
        if (isValidContextForGlide(context)) {
            if (!TextUtils.isEmpty(str) || imageView == null) {
                a.v(context).q(str).b((RequestOptions) ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().a0(i11)).n(i12)).l(i13)).n0(new GlideTransformCircle())).D0(imageView);
                return;
            }
            imageView.setImageResource(i11);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [n3.g<android.graphics.Bitmap>, n3.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void displayWithTransform(android.content.Context r2, java.lang.String r3, int r4, android.widget.ImageView r5, n3.g<android.graphics.Bitmap> r6, com.bumptech.glide.request.e r7) {
        /*
            r1 = this;
            boolean r0 = r1.isValidContextForGlide(r2)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            com.bumptech.glide.request.RequestOptions r0 = new com.bumptech.glide.request.RequestOptions
            r0.<init>()
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.a0(r4)
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.n(r4)
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0
            com.bumptech.glide.request.BaseRequestOptions r4 = r0.l(r4)
            com.bumptech.glide.request.RequestOptions r4 = (com.bumptech.glide.request.RequestOptions) r4
            com.bumptech.glide.request.BaseRequestOptions r4 = r4.n0(r6)
            com.bumptech.glide.request.RequestOptions r4 = (com.bumptech.glide.request.RequestOptions) r4
            com.bumptech.glide.d r2 = com.bumptech.glide.a.v(r2)
            com.bumptech.glide.c r2 = r2.q(r3)
            com.bumptech.glide.c r2 = r2.G0(r7)
            com.bumptech.glide.c r2 = r2.b(r4)
            r2.D0(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.ImageLoadedrManager.displayWithTransform(android.content.Context, java.lang.String, int, android.widget.ImageView, n3.g, com.bumptech.glide.request.e):void");
    }

    public void display(Context context, String str, String str2, e eVar, ImageView imageView, int i11) {
        if (isValidContextForGlide(context)) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.a0(i11);
            requestOptions.n(i11);
            requestOptions.l(i11);
            com.bumptech.glide.c<Drawable> cVar = null;
            if (!TextUtils.isEmpty(str2)) {
                cVar = a.v(context).q(str2).b(requestOptions);
            }
            if (cVar != null) {
                a.v(context).q(str).T0(cVar).G0(eVar).D0(imageView);
            } else {
                a.v(context).q(str).G0(eVar).b(requestOptions).D0(imageView);
            }
        }
    }

    public void displayLarge(Context context, String str, String str2, ImageView imageView, int i11) {
        displayLarge(context, str, str2, (e) null, imageView, i11);
    }

    public void displayLarge(Context context, String str, String str2, e eVar, ImageView imageView, int i11) {
        if (isValidContextForGlide(context)) {
            RequestOptions requestOptions = new RequestOptions();
            ((RequestOptions) ((RequestOptions) ((RequestOptions) requestOptions.Y(Integer.MIN_VALUE)).a0(i11)).n(i11)).l(i11);
            com.bumptech.glide.c<Drawable> cVar = null;
            if (!TextUtils.isEmpty(str2)) {
                cVar = a.v(context).q(str2).b(requestOptions);
            }
            if (cVar != null) {
                a.v(context).q(str).T0(cVar).G0(eVar).D0(imageView);
            } else {
                a.v(context).q(str).G0(eVar).b(requestOptions).D0(imageView);
            }
        }
    }

    public void displayGif(Context context, String str, int i11, e<Drawable> eVar, ImageView imageView) {
        if (isValidContextForGlide(context)) {
            a.v(context).q(str).b((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().j()).a0(i11)).h(DiskCacheStrategy.f63712d)).G0(eVar).D0(imageView);
        }
    }

    public void displayRound(Context context, int i11, ImageView imageView) {
        if (isValidContextForGlide(context)) {
            a.v(context).o(Integer.valueOf(i11)).b((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().a0(getImageDefResource())).l(getImageDefResource())).n0(new GlideTransformCircle())).D0(imageView);
        }
    }

    public void display(Context context, String str, ImageView imageView, RequestOptions requestOptions) {
        if (isValidContextForGlide(context)) {
            a.v(context).q(str).b(requestOptions).D0(imageView);
        }
    }

    public void display(Context context, String str, ImageView imageView, int i11) {
        display(context, str, imageView, i11, i11);
    }

    public void display(Context context, String str, ImageView imageView, int i11, e eVar) {
        display(context, str, imageView, i11, i11, eVar);
    }

    public void display(Context context, String str, ImageView imageView, int i11, int i12) {
        if (isValidContextForGlide(context)) {
            a.v(context).q(str).b((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().a0(i11)).n(i11)).l(i12)).D0(imageView);
        }
    }

    public void display(Context context, String str, ImageView imageView, int i11, int i12, e eVar) {
        if (isValidContextForGlide(context)) {
            a.v(context).q(str).G0(eVar).b((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().a0(i11)).n(i11)).l(i12)).D0(imageView);
        }
    }

    public void display(Context context, int i11, ImageView imageView) {
        if (isValidContextForGlide(context)) {
            a.v(context).o(Integer.valueOf(i11)).D0(imageView);
        }
    }

    public void display(Context context, String str, SimpleTarget<Drawable> simpleTarget) {
        if (isValidContextForGlide(context)) {
            a.v(context).q(str).A0(simpleTarget);
        }
    }
}
