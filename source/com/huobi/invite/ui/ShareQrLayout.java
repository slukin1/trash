package com.huobi.invite.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.WriterException;
import com.huobi.invite.bean.InvitePosterItem;
import com.huobi.invite.bean.InvitePosterListItem;
import com.huobi.utils.ImageUtils;
import i6.n;
import pro.huobi.R;

public class ShareQrLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f74619b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f74620c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f74621d;

    public ShareQrLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public Bitmap a(String str) {
        ImageView imageView = this.f74619b;
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
        FrameLayout.inflate(getContext(), R.layout.share_qr_layout, this);
        this.f74620c = (TextView) findViewById(R.id.tv_title);
        this.f74621d = (TextView) findViewById(R.id.tv_content);
        this.f74619b = (ImageView) findViewById(R.id.qr_code_image);
    }

    public void d(InvitePosterListItem invitePosterListItem) {
        if (invitePosterListItem != null && invitePosterListItem.d() != null) {
            InvitePosterItem d11 = invitePosterListItem.d();
            if (TextUtils.isEmpty(d11.getMainTitle())) {
                this.f74620c.setVisibility(4);
            } else {
                this.f74620c.setVisibility(0);
                this.f74620c.setText(d11.getMainTitle());
            }
            if (TextUtils.isEmpty(d11.getSubTitle())) {
                this.f74621d.setVisibility(4);
                return;
            }
            this.f74621d.setVisibility(0);
            this.f74621d.setText(d11.getSubTitle());
        }
    }

    public ShareQrLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareQrLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c();
    }
}
