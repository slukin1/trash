package com.tencent.qcloud.tuikit.timcommon.component.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.a;
import com.bumptech.glide.c;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.e;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.R;
import java.io.File;
import java.util.concurrent.ExecutionException;

public class GlideEngine {
    public static void clear(ImageView imageView) {
        a.v(TUILogin.getAppContext()).f(imageView);
    }

    public static Bitmap loadBitmap(Object obj, int i11) throws InterruptedException, ExecutionException {
        if (obj == null) {
            return null;
        }
        return (Bitmap) a.v(TUILogin.getAppContext()).b().L0(obj).b(new RequestOptions().l(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).E0(i11, i11).get();
    }

    public static void loadCornerImageWithoutPlaceHolder(ImageView imageView, String str, e eVar, float f11) {
        int i11 = (int) f11;
        m mVar = i11 > 0 ? new m(i11) : null;
        RequestOptions requestOptions = (RequestOptions) new RequestOptions().d();
        if (mVar != null) {
            requestOptions = (RequestOptions) requestOptions.n0(mVar);
        }
        a.v(TUILogin.getAppContext()).q(str).b(requestOptions).G0(eVar).D0(imageView);
    }

    public static void loadImage(ImageView imageView, String str, e eVar) {
        a.v(TUILogin.getAppContext()).q(str).G0(eVar).b(new RequestOptions().l(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).D0(imageView);
    }

    public static void loadImageSetDefault(ImageView imageView, Object obj, int i11) {
        ((c) a.v(TUILogin.getAppContext()).p(obj).a0(i11)).b(((RequestOptions) new RequestOptions().d()).l(i11)).D0(imageView);
    }

    public static void loadUserIcon(ImageView imageView, Object obj) {
        loadUserIcon(imageView, obj, 0);
    }

    public static void loadUserIcon(ImageView imageView, Object obj, int i11) {
        c<Drawable> p11 = a.v(TUILogin.getAppContext()).p(obj);
        Context appContext = TUILogin.getAppContext();
        int i12 = R.attr.core_default_user_icon;
        ((c) p11.a0(TUIThemeManager.getAttrResId(appContext, i12))).b(((RequestOptions) new RequestOptions().d()).l(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), i12))).D0(imageView);
    }

    public static Bitmap loadBitmap(Object obj, int i11, int i12) throws InterruptedException, ExecutionException {
        if (obj == null) {
            return null;
        }
        return (Bitmap) a.v(TUILogin.getAppContext()).b().L0(obj).b(new RequestOptions().l(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).E0(i11, i12).get();
    }

    public static void loadImage(ImageView imageView, String str) {
        a.v(TUILogin.getAppContext()).q(str).b(new RequestOptions().l(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).D0(imageView);
    }

    public static void loadUserIcon(ImageView imageView, Object obj, int i11, int i12) {
        ((c) a.v(TUILogin.getAppContext()).p(obj).a0(i11)).b(((RequestOptions) new RequestOptions().d()).l(i11)).D0(imageView);
    }

    public static void loadImage(ImageView imageView, Uri uri) {
        if (uri != null) {
            a.v(TUILogin.getAppContext()).m(uri).b(new RequestOptions().l(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).D0(imageView);
        }
    }

    public static void loadImage(String str, String str2) {
        try {
            ((File) a.v(TUILogin.getAppContext()).d().M0(str2).R0().get()).renameTo(new File(str));
        } catch (InterruptedException e11) {
            e11.printStackTrace();
        } catch (ExecutionException e12) {
            e12.printStackTrace();
        }
    }

    public static void loadImage(ImageView imageView, Object obj) {
        if (obj != null) {
            a.v(TUILogin.getAppContext()).p(obj).b(new RequestOptions().l(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).D0(imageView);
        }
    }

    public void loadImage(Context context, int i11, int i12, ImageView imageView, Uri uri) {
        a.v(context).m(uri).b(((RequestOptions) ((RequestOptions) new RequestOptions().Z(i11, i12)).c0(Priority.HIGH)).o()).D0(imageView);
    }
}
