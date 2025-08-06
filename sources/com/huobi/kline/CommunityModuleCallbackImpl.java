package com.huobi.kline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.core.content.FileProvider;
import androidx.core.util.c;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.share.fragment.ImageShareFragment;
import com.huobi.utils.ImageUtils;
import com.huobi.utils.v0;
import com.huochat.community.CommunityModuleCallback;
import com.huochat.community.enums.CommunityAnalyticsPageEnum;
import com.huochat.community.listener.ICommunityShareUI;
import gs.g;
import i6.d;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import pm.b;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

public class CommunityModuleCallbackImpl implements CommunityModuleCallback {

    public class a extends EasySubscriber<c<String, Float>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageShareFragment f74775b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ICommunityShareUI f74776c;

        public a(ImageShareFragment imageShareFragment, ICommunityShareUI iCommunityShareUI) {
            this.f74775b = imageShareFragment;
            this.f74776c = iCommunityShareUI;
        }

        /* renamed from: a */
        public void onNext(c<String, Float> cVar) {
            F f11;
            super.onNext(cVar);
            if (cVar != null && (f11 = cVar.f8468a) != null && cVar.f8469b != null) {
                this.f74775b.ci((String) f11);
                this.f74775b.bi(((Float) cVar.f8469b).floatValue());
                this.f74775b.show(((FragmentActivity) this.f74776c.getActivity()).getSupportFragmentManager(), "community_dynamic_share");
            }
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public static /* synthetic */ c c(View view, Integer num) {
        Float f11;
        float height;
        int width;
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        view.draw(canvas);
        canvas.save();
        canvas.restore();
        try {
            createBitmap = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight());
            if (createBitmap.getWidth() == 0) {
                height = (float) PixelUtils.f();
                width = PixelUtils.g();
            } else {
                height = (float) createBitmap.getHeight();
                width = createBitmap.getWidth();
            }
            f11 = Float.valueOf(height / ((float) width));
        } catch (Exception e11) {
            d.g(e11);
            f11 = null;
        }
        return new c(createBitmap, f11);
    }

    public static /* synthetic */ c d(c cVar) {
        String str;
        Bitmap bitmap = (Bitmap) cVar.f8468a;
        try {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
            File f11 = FileUtil.f(compressFormat.name(), false);
            ImageUtils.h(bitmap, compressFormat, f11);
            if (Build.VERSION.SDK_INT >= 24) {
                str = FileProvider.getUriForFile(j.c(), "pro.huobi.fileprovider", f11).toString();
            } else {
                str = Uri.fromFile(f11).toString();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        } catch (Exception e11) {
            d.g(e11);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            str = null;
        } catch (Throwable th2) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            throw th2;
        }
        return new c(str, (Float) cVar.f8469b);
    }

    public static Subscription e(ICommunityShareUI iCommunityShareUI, ImageShareFragment imageShareFragment, View view) {
        if (imageShareFragment.isVisible()) {
            imageShareFragment.dismiss();
        }
        Subscription Fh = imageShareFragment.Fh();
        if (Fh != null && !Fh.isUnsubscribed()) {
            Fh.unsubscribe();
        }
        return Observable.just(1).map(new pm.a(view)).map(b.f53172b).subscribeOn(Schedulers.io()).compose(RxJavaHelper.t(iCommunityShareUI)).subscribe(new a(imageShareFragment, iCommunityShareUI));
    }

    public void hbgAnalyticsClickData(String str, String str2) {
        is.a.j(str, (Map<String, Object>) null, str2);
    }

    public void hbgAnalyticsUtilReportClickData(String str, Map<String, ?> map, CommunityAnalyticsPageEnum communityAnalyticsPageEnum) {
        if (communityAnalyticsPageEnum == CommunityAnalyticsPageEnum.PAGE_JUMP_HUOBI_CHAT_DIALOG) {
            is.a.j(str, (Map<String, Object>) null, "1005277");
        }
    }

    public void newTrack(String str, HashMap<Object, Object> hashMap) {
        g.g(str, hashMap);
    }

    public BaseDialogFragment shareCommunityDynamic(ICommunityShareUI iCommunityShareUI, BaseDialogFragment baseDialogFragment, View view) {
        ImageShareFragment imageShareFragment;
        if (baseDialogFragment == null) {
            imageShareFragment = new ImageShareFragment();
        } else {
            imageShareFragment = (ImageShareFragment) baseDialogFragment;
        }
        imageShareFragment.Ph(e(iCommunityShareUI, imageShareFragment, view));
        return imageShareFragment;
    }

    public void showDisclaimer(Context context) {
        v0.e(context, "94870810344102");
    }

    public void track(String str, HashMap<String, Object> hashMap) {
        g.i(str, hashMap);
    }
}
