package com.huobi.sharev2.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.ShareConfig;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.sharev2.bean.ShareInfo;
import com.huobi.sharev2.helper.NewShareHelper;
import com.huobi.webview2.action.JsCommonActionHelper;
import com.nostra13.universalimageloader.core.assist.FailReason;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import u6.g;

public class NewCommonSharePresenter extends BaseSharePresenter<ur.b> {

    public class a extends EasySubscriber<ShareConfig> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShareInfo f81143b;

        /* renamed from: com.huobi.sharev2.presenter.NewCommonSharePresenter$a$a  reason: collision with other inner class name */
        public class C0847a implements Action1<String> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ShareConfig f81145b;

            public C0847a(ShareConfig shareConfig) {
                this.f81145b = shareConfig;
            }

            /* renamed from: a */
            public void call(String str) {
                try {
                    a.this.f81143b.setTailBitmap((Bitmap) com.bumptech.glide.a.u(com.blankj.utilcode.util.a.c()).b().M0(this.f81145b.getTailImgUrl()).R0().get());
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }

        public a(ShareInfo shareInfo) {
            this.f81143b = shareInfo;
        }

        /* renamed from: a */
        public void onNext(ShareConfig shareConfig) {
            if (NewCommonSharePresenter.this.d()) {
                if (shareConfig.getChannelList() != null && shareConfig.getChannelList().size() > 0) {
                    this.f81143b.setChannelList(shareConfig.getChannelList());
                }
                if (!NewShareHelper.p(shareConfig.getPosterSubTitle())) {
                    this.f81143b.setPosterSubtitle(shareConfig.getPosterSubTitle());
                }
                if (!NewShareHelper.p(shareConfig.getPosterTitle())) {
                    this.f81143b.setPosterTitle(shareConfig.getPosterTitle());
                }
                if (!NewShareHelper.p(shareConfig.getQrCodeUrl())) {
                    this.f81143b.setQrUrl(shareConfig.getQrCodeUrl());
                }
                if (!NewShareHelper.p(shareConfig.getShareFloatingText())) {
                    this.f81143b.setFloatContent(shareConfig.getShareFloatingText());
                }
                if (!NewShareHelper.p(shareConfig.getShareTitle())) {
                    this.f81143b.setShareText(shareConfig.getShareTitle());
                }
                if (!NewShareHelper.p(shareConfig.getShareUrl())) {
                    this.f81143b.setShareUrl(shareConfig.getShareUrl());
                }
                if (shareConfig.getShowQRCode() != null) {
                    this.f81143b.setShowNativeQr(shareConfig.getShowQRCode().booleanValue());
                }
                if (shareConfig.getShowTail() != null) {
                    this.f81143b.setShowTail(shareConfig.getShowTail().booleanValue());
                }
                if (!NewShareHelper.p(shareConfig.getTailImgUrl())) {
                    this.f81143b.setTailImgUrl(shareConfig.getTailImgUrl());
                }
                if (!NewShareHelper.p(shareConfig.getSource())) {
                    this.f81143b.setSource(shareConfig.getSource());
                }
                if (!NewShareHelper.p(shareConfig.getInviteCode())) {
                    this.f81143b.setInviteCode(shareConfig.getInviteCode());
                }
                if (!NewShareHelper.p(shareConfig.getTailImgUrl())) {
                    Observable.just("bitmap").observeOn(Schedulers.io()).subscribeOn(Schedulers.io()).subscribe(new C0847a(shareConfig));
                }
                ((ur.b) NewCommonSharePresenter.this.c()).da(shareConfig);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            String str = "";
            if (NewCommonSharePresenter.this.d()) {
                ((ur.b) NewCommonSharePresenter.this.c()).v3(th2 != null ? th2.getMessage() : str);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("request onError2 --> ");
            if (th2 != null) {
                str = th2.getMessage();
            }
            sb2.append(str);
            Log.d("NewCommonSharePresenter", sb2.toString());
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            String str = "";
            if (NewCommonSharePresenter.this.d()) {
                ((ur.b) NewCommonSharePresenter.this.c()).v3(aPIStatusErrorException != null ? aPIStatusErrorException.getMessage() : str);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("request onFailed --> ");
            if (aPIStatusErrorException != null) {
                str = aPIStatusErrorException.getMessage();
            }
            sb2.append(str);
            Log.d("NewCommonSharePresenter", sb2.toString());
        }
    }

    public class b implements tx.a {
        public b() {
        }

        public void a(String str, View view) {
            Log.d("NewCommonSharePresenter", "onLoadingStarted --> imageUri:" + str);
        }

        public void b(String str, View view, FailReason failReason) {
            Log.d("NewCommonSharePresenter", "onLoadingFailed --> imageUri:" + str);
            if (NewCommonSharePresenter.this.d()) {
                ((ur.b) NewCommonSharePresenter.this.c()).M7("");
            }
        }

        public void c(String str, View view, Bitmap bitmap) {
            Log.d("NewCommonSharePresenter", "onLoadingComplete --> imageUri:" + str);
            if (NewCommonSharePresenter.this.d()) {
                ((ur.b) NewCommonSharePresenter.this.c()).H9(bitmap);
            }
        }

        public void d(String str, View view) {
            Log.d("NewCommonSharePresenter", "onLoadingCancelled --> imageUri:" + str);
        }
    }

    public void e(ur.b bVar) {
        super.a(bVar);
    }

    public Map<String, Object> f(ShareInfo shareInfo) {
        if (shareInfo == null) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        if (!NewShareHelper.p(shareInfo.getPageId())) {
            hashMap.put("pageId", shareInfo.getPageId());
        }
        if (!NewShareHelper.p(shareInfo.getButtonId())) {
            hashMap.put("buttonId", shareInfo.getButtonId());
        }
        hashMap.put("shareTitle", shareInfo.getShareText());
        hashMap.put("shareUrl", shareInfo.getShareUrl());
        hashMap.put("showQRCode", Boolean.valueOf(shareInfo.isShowNativeQr()));
        hashMap.put("qrCodeUrl", shareInfo.getQrUrl());
        hashMap.put("posterTitle", shareInfo.getPosterTitle());
        hashMap.put("posterSubTitle", shareInfo.getPosterSubtitle());
        hashMap.put("showTail", Boolean.valueOf(shareInfo.isShowTail()));
        hashMap.put("shareFloatingText", shareInfo.getFloatContent());
        hashMap.put("source", shareInfo.getSource());
        hashMap.put("channelList", shareInfo.getChannelList());
        return hashMap;
    }

    public void g(Context context, ShareInfo shareInfo) {
        JsCommonActionHelper.loadBase64Image((g) context, shareInfo.getBase64Image(), new b());
    }

    public void h(ShareInfo shareInfo) {
        v7.b.a().postShareConfig(f(shareInfo)).b().compose(RxJavaHelper.t((g) null)).subscribe(new a(shareInfo));
    }
}
