package com.huobi.sharev2.createimage.create;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import d10.l;
import pro.huobi.R;
import qr.b;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class CreateImageImpl implements b {

    public static final class a extends Subscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ qr.a f81052b;

        public a(qr.a aVar) {
            this.f81052b = aVar;
        }

        /* renamed from: a */
        public void onNext(String str) {
            if (str == null || str.length() == 0) {
                this.f81052b.result(-1, com.blankj.utilcode.util.a.c().getString(R.string.n_share_error_create_image));
            } else {
                this.f81052b.result(0, String.valueOf(c.f81058a.e(com.blankj.utilcode.util.a.c(), str)));
            }
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            this.f81052b.result(-1, th2.toString());
        }
    }

    public static final String c(l lVar, Object obj) {
        return (String) lVar.invoke(obj);
    }

    public void a(String str, qr.a aVar) {
        Observable.just(str).map(new d(new CreateImageImpl$doImageCreate$1(str, this))).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(aVar));
    }

    public final Bitmap d(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        System.out.println("Drawable转Bitmap");
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }
}
