package rd;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.hbg.lib.common.utils.PixelUtils;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import java.util.List;
import n3.c;
import n3.g;
import rd.e;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f23354a = new f();

    public static final class a implements V2TIMValueCallback<List<? extends V2TIMUserFullInfo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f23355a;

        public a(e eVar) {
            this.f23355a = eVar;
        }

        /* renamed from: a */
        public void onSuccess(List<? extends V2TIMUserFullInfo> list) {
            if (list == null || list.isEmpty()) {
                e.a.b(this.f23355a, 0, (String) null, 3, (Object) null);
            } else {
                this.f23355a.b((V2TIMUserFullInfo) list.get(0));
            }
        }

        public void onError(int i11, String str) {
            this.f23355a.a(i11, str);
        }
    }

    public static final class b extends SimpleTarget<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f23356b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(n nVar, int i11, int i12) {
            super(i11, i12);
            this.f23356b = nVar;
        }

        /* renamed from: a */
        public void onResourceReady(Bitmap bitmap, com.bumptech.glide.request.transition.a<? super Bitmap> aVar) {
            this.f23356b.a(bitmap);
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            this.f23356b.a((Bitmap) null);
        }
    }

    public static final void a(String str, e eVar) {
        V2TIMManager.getInstance().getUsersInfo(CollectionsKt__CollectionsJVMKt.e(str), new a(eVar));
    }

    public static final void b(Context context, String str, int i11, float f11, float f12, n nVar) {
        CircleCrop circleCrop = new CircleCrop();
        boolean z11 = true;
        RequestOptions requestOptions = (RequestOptions) ((RequestOptions) ((RequestOptions) RequestOptions.r0(new c((g<T>[]) new g[]{new CenterCrop()})).h(DiskCacheStrategy.f63711c)).a0(i11)).l(i11);
        if (f11 == f12) {
            if (f11 != 18.0f) {
                z11 = false;
            }
            if (z11) {
                requestOptions.n0(circleCrop);
            }
        }
        boolean z12 = context instanceof Activity;
        if (z12 && ((Activity) context).isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !z12 || !((Activity) context).isDestroyed()) {
            com.bumptech.glide.a.v(context).b().M0(str).b(requestOptions).A0(new b(nVar, PixelUtils.a(f11), PixelUtils.a(f12)));
        }
    }

    public static final void c(Context context, String str, int i11, n nVar) {
        b(context, str, i11, 18.0f, 18.0f, nVar);
    }
}
