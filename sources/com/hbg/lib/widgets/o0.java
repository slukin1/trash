package com.hbg.lib.widgets;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.utils.ActivityCompatHelper;

public class o0 implements ImageEngine {

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final o0 f72110a = new o0();
    }

    public static o0 a() {
        return b.f72110a;
    }

    public static void b(Context context, String str, ImageView imageView, float f11, int i11, float f12) {
        try {
            com.bumptech.glide.a.v(context).q(str).b((RequestOptions) ((RequestOptions) new RequestOptions().n0(new p0(context, f11, i11, f12))).i()).D0(imageView);
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, String str, ImageView imageView, int i11, int i12) {
        try {
            int i13 = R$drawable.icon_community_user_header;
            com.bumptech.glide.a.v(context).q(str).b((RequestOptions) ((RequestOptions) ((RequestOptions) RequestOptions.r0(new n0(context, i11, i12)).h(DiskCacheStrategy.f63711c)).a0(i13)).l(i13)).D0(imageView);
        } catch (Exception unused) {
        }
    }

    public void loadAlbumCover(Context context, String str, ImageView imageView) {
        if (ActivityCompatHelper.assertValidRequest(context)) {
            ((c) ((c) ((c) ((c) com.bumptech.glide.a.v(context).b().M0(str).Z(180, 180)).j0(0.5f)).p0(new CenterCrop(), new m(8))).a0(R$drawable.ps_image_placeholder)).D0(imageView);
        }
    }

    public void loadGridImage(Context context, String str, ImageView imageView) {
        if (ActivityCompatHelper.assertValidRequest(context)) {
            ((c) ((c) ((c) com.bumptech.glide.a.v(context).q(str).Z(200, 200)).d()).a0(R$drawable.ps_image_placeholder)).D0(imageView);
        }
    }

    public void loadImage(Context context, String str, ImageView imageView) {
        if (ActivityCompatHelper.assertValidRequest(context)) {
            com.bumptech.glide.a.v(context).q(str).D0(imageView);
        }
    }

    public void pauseRequests(Context context) {
        if (ActivityCompatHelper.assertValidRequest(context)) {
            com.bumptech.glide.a.v(context).t();
        }
    }

    public void resumeRequests(Context context) {
        if (ActivityCompatHelper.assertValidRequest(context)) {
            com.bumptech.glide.a.v(context).u();
        }
    }

    public o0() {
    }

    public void loadImage(Context context, ImageView imageView, String str, int i11, int i12) {
        if (ActivityCompatHelper.assertValidRequest(context)) {
            ((c) com.bumptech.glide.a.v(context).q(str).Z(i11, i12)).D0(imageView);
        }
    }
}
