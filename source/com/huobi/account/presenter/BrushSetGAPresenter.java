package com.huobi.account.presenter;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.usercenter.data.source.bean.GaGenerateData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import java.util.HashMap;
import q6.d;
import tq.p;
import u6.g;

public class BrushSetGAPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f41025a;

    public class a extends d<GaGenerateData> {
        public a(g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(GaGenerateData gaGenerateData) {
            super.onNext(gaGenerateData);
            ((b) BrushSetGAPresenter.this.getUI()).w(gaGenerateData);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public interface b extends g {
        void w(GaGenerateData gaGenerateData);
    }

    public Bitmap Q(String str, int i11, int i12) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
                    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
                    hashMap.put(EncodeHintType.MARGIN, 0);
                    BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i11, i12, hashMap);
                    int[] iArr = new int[(i11 * i12)];
                    for (int i13 = 0; i13 < i12; i13++) {
                        for (int i14 = 0; i14 < i11; i14++) {
                            if (encode.get(i14, i13)) {
                                iArr[(i13 * i11) + i14] = -16777216;
                            } else {
                                iArr[(i13 * i11) + i14] = -1;
                            }
                        }
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.RGB_565);
                    createBitmap.setPixels(iArr, 0, i11, 0, 0, i11, i12);
                    return createBitmap;
                }
            } catch (WriterException e11) {
                i6.d.g(e11);
            }
        }
        return null;
    }

    public void R() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("auth_token", this.f41025a);
        UserCenterRemoteDataSource.A().w0(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new a((g) getUI()));
    }

    /* renamed from: S */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        this.f41025a = getActivity().getIntent().getStringExtra("AUTH_TOKEN");
        R();
    }
}
