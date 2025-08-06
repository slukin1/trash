package com.huobi.sharev2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.zxing.WriterException;
import com.huobi.utils.ImageUtils;
import i6.n;
import pro.huobi.R;

public class NewShareQrLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f81148b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f81149c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f81150d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f81151e;

    public NewShareQrLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public Bitmap a(String str) {
        ImageView imageView = this.f81150d;
        if (imageView != null) {
            imageView.setImageBitmap(b(str));
        }
        measure(View.MeasureSpec.makeMeasureSpec(n.g(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        return ImageUtils.d(this);
    }

    public final Bitmap b(String str) {
        try {
            return ImageUtils.c(str, getResources().getDimensionPixelOffset(R.dimen.dimen_50));
        } catch (WriterException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final void c() {
        FrameLayout.inflate(getContext(), R.layout.asset_share_img_banner, this);
        this.f81150d = (ImageView) findViewById(R.id.share_img_qrcode);
        this.f81148b = (RelativeLayout) findViewById(R.id.share_img_bottom);
        this.f81149c = (TextView) findViewById(R.id.share_img_subtitle);
        this.f81151e = (TextView) findViewById(R.id.share_tv_invicode);
    }

    public void d(String str, String str2, String str3) {
        this.f81148b.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.f81149c.setText(str);
        }
        if (TextUtils.isEmpty(str2) && str3 != null) {
            try {
                Uri parse = Uri.parse(str3);
                str2 = parse.getQueryParameter("inviteCode");
                if (TextUtils.isEmpty(str2)) {
                    str2 = parse.getQueryParameter("invite_code");
                }
            } catch (Throwable unused) {
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f81151e.setText(String.format(getResources().getString(R.string.n_content_im_group_invitation_code), new Object[]{str2}));
            this.f81151e.setVisibility(0);
            return;
        }
        this.f81151e.setVisibility(8);
    }

    public NewShareQrLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewShareQrLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c();
    }
}
