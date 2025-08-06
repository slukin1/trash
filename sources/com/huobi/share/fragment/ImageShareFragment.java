package com.huobi.share.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.google.zxing.WriterException;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.huobi.domain.DomainSwitcher;
import com.huobi.share.helper.CaptureShareHelper;
import com.huobi.social.share.HBShareHelper;
import com.huobi.utils.ImageUtils;
import com.huobi.utils.x;
import g6.b;
import gj.d;
import i6.k;
import i6.r;
import java.util.List;
import lr.i;
import pro.huobi.R;

public class ImageShareFragment extends BaseShareFragment {
    public View A;
    public View B;
    public float C;
    public float D;
    public float E;
    public boolean F = true;
    public Bitmap G;
    public ViewGroup H;
    public boolean I;

    /* renamed from: w  reason: collision with root package name */
    public String f80952w;

    /* renamed from: x  reason: collision with root package name */
    public float f80953x;

    /* renamed from: y  reason: collision with root package name */
    public ImageView f80954y;

    /* renamed from: z  reason: collision with root package name */
    public ImageView f80955z;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public float f80956b;

        /* renamed from: c  reason: collision with root package name */
        public float f80957c = 300.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f80958d = -9.0E-4f;

        /* renamed from: e  reason: collision with root package name */
        public float f80959e = 1.25f;

        /* renamed from: f  reason: collision with root package name */
        public float f80960f = 1.5384615E-4f;

        /* renamed from: g  reason: collision with root package name */
        public float f80961g = 0.9338462f;

        /* renamed from: h  reason: collision with root package name */
        public float f80962h;

        /* renamed from: i  reason: collision with root package name */
        public float f80963i;

        /* renamed from: j  reason: collision with root package name */
        public float f80964j = (1.0f / 300.0f);

        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() instanceof Float) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f80956b = floatValue;
                if (Float.compare(floatValue, this.f80957c) <= 0) {
                    float f11 = this.f80964j;
                    float f12 = this.f80956b;
                    this.f80963i = f11 * f12;
                    this.f80962h = this.f80959e + (this.f80958d * f12);
                } else {
                    this.f80963i = 1.0f;
                    this.f80962h = (this.f80960f * this.f80956b) + this.f80961g;
                }
                ImageShareFragment.this.A.setAlpha(this.f80963i);
                ImageShareFragment.this.A.setScaleX(this.f80962h);
                ImageShareFragment.this.A.setScaleY(this.f80962h);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yh() {
        i0(HBShareHelper.HbPlatform.TYPE_MORE);
    }

    public void Ah() {
        super.Ah();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.A, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(260);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
    }

    public void Bh() {
        super.Bh();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 430.0f});
        ofFloat.addUpdateListener(new a());
        ofFloat.setDuration(430);
        ofFloat.setInterpolator(new b6.a(0.0d, 0.0d, 0.58d, 1.0d));
        ofFloat.start();
    }

    public final Bitmap Uh() {
        Bitmap bitmap;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_share_image_preview, (ViewGroup) null, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.share_img_qrcode);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.pine_image);
        try {
            Bitmap c11 = ImageUtils.c(Vh(), (int) getResources().getDimension(R.dimen.dimen_67));
            if (!(imageView == null || c11 == null)) {
                imageView.setImageBitmap(c11);
            }
            if (!(imageView2 == null || (bitmap = this.G) == null)) {
                imageView2.setImageBitmap(bitmap);
            }
        } catch (WriterException e11) {
            k.f("ImageShareFragment", e11.getMessage());
        }
        return ImageUtils.b(inflate);
    }

    public String Vh() {
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

    public float Wh() {
        return this.f80953x;
    }

    public void Xh() {
        if (AppLanguageHelper.getInstance().isChineseLanguage() && this.F && !d.n().D()) {
            this.F = false;
        }
    }

    public void Zh() {
        Bitmap bitmap = this.G;
        if (bitmap != null) {
            this.f80954y.setImageBitmap(bitmap);
        } else if (this.f80952w != null) {
            b.c().h(this.f80954y, this.f80952w);
        }
    }

    public void addEvent(r rVar) {
        super.addEvent(rVar);
        Zh();
        this.C = ((float) PixelUtils.g()) - (getResources().getDimension(R.dimen.dimen_37_5) * 2.0f);
        this.E = getResources().getDimension(R.dimen.dimen_55);
        if (Float.compare(this.f80953x, 0.0f) > 0) {
            this.D = this.f80953x * this.C;
            ViewGroup.LayoutParams layoutParams = this.f80954y.getLayoutParams();
            layoutParams.height = (int) this.D;
            this.f80954y.setLayoutParams(layoutParams);
        }
        try {
            this.f80955z.setImageBitmap(ImageUtils.c(Vh(), (int) this.E));
        } catch (WriterException e11) {
            k.f("ImageShareFragment", e11.getMessage());
        }
        this.H.postDelayed(new i(this), 100);
    }

    public void ai(Bitmap bitmap) {
        this.G = bitmap;
    }

    public void bi(float f11) {
        this.f80953x = f11;
    }

    public void ci(String str) {
        this.f80952w = str;
    }

    public void di(boolean z11) {
        this.F = z11;
        Xh();
        ViewUtil.m(this.B, this.F);
    }

    public int getContentViewResId() {
        return R.layout.activity_invite_share;
    }

    public void i0(HBShareHelper.HbPlatform hbPlatform) {
        super.i0(hbPlatform);
        Bitmap bitmap = this.G;
        if (bitmap == null) {
            bitmap = CaptureShareHelper.e(this.A);
        } else if (this.F) {
            bitmap = Uh();
        }
        Ch("", bitmap);
    }

    public void initView(r rVar) {
        super.initView(rVar);
        this.B = rVar.b(R.id.share_img_bottom);
        this.f80954y = (ImageView) rVar.b(R.id.share_img);
        this.f80955z = (ImageView) rVar.b(R.id.share_img_qrcode);
        this.A = rVar.b(R.id.share_img_root);
        this.H = (ViewGroup) rVar.b(R.id.share_container);
        this.A.setVisibility(0);
        this.H.setVisibility(4);
        ViewUtil.m(rVar.b(R.id.poster_layout), false);
        ViewUtil.m(rVar.b(R.id.share_post_indicator_layout), false);
        ViewUtil.m(this.B, this.F);
        this.I = false;
    }

    public void onPermissionsDenied(int i11, List<String> list) {
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        Bitmap bitmap = this.G;
        if (bitmap == null) {
            bitmap = CaptureShareHelper.e(this.A);
        } else if (this.F) {
            bitmap = Uh();
        }
        Ch("", bitmap);
    }

    public void onResume() {
        super.onResume();
        if (this.I) {
            doDismiss();
        } else {
            this.I = true;
        }
    }
}
