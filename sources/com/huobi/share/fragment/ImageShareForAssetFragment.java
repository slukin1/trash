package com.huobi.share.fragment;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.WriterException;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.huobi.domain.DomainSwitcher;
import com.huobi.social.share.HBShareHelper;
import com.huobi.utils.ImageUtils;
import com.huobi.utils.x;
import com.nostra13.universalimageloader.core.assist.FailReason;
import i6.r;
import java.util.List;
import lr.h;
import pro.huobi.R;

public class ImageShareForAssetFragment extends BaseShareFragment {
    public ImageView A;
    public View B;
    public float C;
    public ViewGroup D;
    public boolean E;
    public ImageView F;

    /* renamed from: w  reason: collision with root package name */
    public String f80936w;

    /* renamed from: x  reason: collision with root package name */
    public String f80937x;

    /* renamed from: y  reason: collision with root package name */
    public int f80938y;

    /* renamed from: z  reason: collision with root package name */
    public ImageView f80939z;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public float f80940b;

        /* renamed from: c  reason: collision with root package name */
        public float f80941c = 300.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f80942d = -9.0E-4f;

        /* renamed from: e  reason: collision with root package name */
        public float f80943e = 1.25f;

        /* renamed from: f  reason: collision with root package name */
        public float f80944f = 1.5384615E-4f;

        /* renamed from: g  reason: collision with root package name */
        public float f80945g = 0.9338462f;

        /* renamed from: h  reason: collision with root package name */
        public float f80946h;

        /* renamed from: i  reason: collision with root package name */
        public float f80947i;

        /* renamed from: j  reason: collision with root package name */
        public float f80948j = (1.0f / 300.0f);

        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() instanceof Float) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f80940b = floatValue;
                if (Float.compare(floatValue, this.f80941c) <= 0) {
                    float f11 = this.f80948j;
                    float f12 = this.f80940b;
                    this.f80947i = f11 * f12;
                    this.f80946h = this.f80943e + (this.f80942d * f12);
                } else {
                    this.f80947i = 1.0f;
                    this.f80946h = (this.f80944f * this.f80940b) + this.f80945g;
                }
                ImageShareForAssetFragment.this.B.setAlpha(this.f80947i);
                ImageShareForAssetFragment.this.B.setScaleX(this.f80946h);
                ImageShareForAssetFragment.this.B.setScaleY(this.f80946h);
            }
        }
    }

    public class b implements tx.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f80950a;

        public b(View view) {
            this.f80950a = view;
        }

        public void a(String str, View view) {
        }

        public void b(String str, View view, FailReason failReason) {
        }

        public void c(String str, View view, Bitmap bitmap) {
            ImageShareForAssetFragment.this.Ch("", ImageUtils.b(this.f80950a));
        }

        public void d(String str, View view) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        i0(HBShareHelper.HbPlatform.TYPE_MORE);
    }

    public void Bh() {
        super.Bh();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 430.0f});
        ofFloat.addUpdateListener(new a());
        ofFloat.setDuration(430);
        ofFloat.setInterpolator(new b6.a(0.0d, 0.0d, 0.58d, 1.0d));
        ofFloat.start();
    }

    public final String Uh() {
        String str;
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            if (x.d()) {
                str = DomainSwitcher.R();
            } else {
                str = DomainSwitcher.T();
            }
        } else if (x.d()) {
            str = DomainSwitcher.S();
        } else {
            str = DomainSwitcher.U();
        }
        if (TextUtils.isEmpty(str)) {
            return AppLanguageHelper.getInstance().isChineseLanguage() ? "https://m.huobi.br.com/zh-cn/download/" : "https://m.huobi.br.com/en-us/download/";
        }
        return str;
    }

    public void Vh() {
        if (getActivity() != null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_asset_share_save, (ViewGroup) getView(), false);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_share_title);
            if (!TextUtils.isEmpty(this.f80937x)) {
                textView.setText(this.f80937x);
            }
            if (this.f80938y != 0) {
                ((ImageView) inflate.findViewById(R.id.bear_image)).setImageResource(this.f80938y);
            }
            try {
                ((ImageView) inflate.findViewById(R.id.share_img_qrcode)).setImageBitmap(ImageUtils.c(Uh(), (int) this.C));
            } catch (WriterException e11) {
                e11.printStackTrace();
            }
            g6.b.c().k((ImageView) inflate.findViewById(R.id.pine_image), this.f80936w, -1, new b(inflate));
        }
    }

    public void Wh() {
        if (this.f80936w != null) {
            g6.b.c().h(this.F, this.f80936w);
        }
    }

    public void Xh(String str) {
        this.f80936w = str;
    }

    public void Yh(int i11) {
        this.f80938y = i11;
    }

    public void addEvent(r rVar) {
        super.addEvent(rVar);
        Wh();
        this.C = getResources().getDimension(R.dimen.dimen_55);
        try {
            this.A.setImageBitmap(ImageUtils.c(Uh(), (int) this.C));
        } catch (WriterException e11) {
            e11.printStackTrace();
        }
    }

    public int getContentViewResId() {
        return R.layout.activity_asset_share;
    }

    public void i0(HBShareHelper.HbPlatform hbPlatform) {
        super.i0(hbPlatform);
        Vh();
    }

    public void initView(r rVar) {
        super.initView(rVar);
        this.F = (ImageView) rVar.b(R.id.pine_image);
        this.f80939z = (ImageView) rVar.b(R.id.index_video_guide_iv);
        this.A = (ImageView) rVar.b(R.id.share_img_qrcode);
        this.B = rVar.b(R.id.share_img_root);
        ViewGroup viewGroup = (ViewGroup) rVar.b(R.id.share_container);
        this.D = viewGroup;
        viewGroup.setVisibility(4);
        if (!TextUtils.isEmpty(this.f80937x)) {
            ((TextView) rVar.b(R.id.tv_share_title)).setText(this.f80937x);
        }
        if (this.f80938y != 0) {
            ((ImageView) rVar.b(R.id.bear_image)).setImageResource(this.f80938y);
        }
        this.E = false;
        this.D.postDelayed(new h(this), 100);
    }

    public void onPermissionsDenied(int i11, List<String> list) {
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        Vh();
    }

    public void onResume() {
        super.onResume();
        if (this.E) {
            doDismiss();
        } else {
            this.E = true;
        }
    }

    public void setTitle(String str) {
        this.f80937x = str;
    }
}
