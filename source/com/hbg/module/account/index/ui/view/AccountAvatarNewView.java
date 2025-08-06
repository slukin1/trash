package com.hbg.module.account.index.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.hbg.module.huobi.im.R$drawable;
import kotlin.jvm.internal.r;
import zb.a;

public final class AccountAvatarNewView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public AccountAvatarView f77679b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f77680c;

    /* renamed from: d  reason: collision with root package name */
    public int f77681d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f77682e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f77683f;

    public AccountAvatarNewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public AccountAvatarNewView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountAvatarNewView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public final float a(float f11, float f12) {
        int i11 = this.f77681d;
        return i11 > 0 ? ((float) i11) * f11 : f12;
    }

    public final AccountAvatarNewView b(AccountAvatarView accountAvatarView) {
        this.f77679b = accountAvatarView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.getRules()[13] = -1;
        accountAvatarView.setLayoutParams(layoutParams);
        accountAvatarView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(accountAvatarView);
        return this;
    }

    public final AccountAvatarNewView c(boolean z11) {
        this.f77682e = z11;
        if (z11) {
            e(12);
        } else {
            ImageView imageView = this.f77680c;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        return this;
    }

    public final AccountAvatarNewView d(int i11) {
        this.f77681d = i11;
        return this;
    }

    public final AccountAvatarNewView e(int i11) {
        this.f77682e = true;
        if (this.f77680c == null) {
            this.f77680c = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.b(Float.valueOf(a(this.f77683f ? 0.4f : 0.327f, 19.0f))), a.b(Float.valueOf(a(this.f77683f ? 0.28f : 0.224f, 13.0f))));
            layoutParams.getRules()[11] = -1;
            if (!this.f77683f) {
                layoutParams.setMarginEnd(a.b(Float.valueOf(6.0f)));
            }
            ImageView imageView = this.f77680c;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            addView(this.f77680c);
        }
        ViewGroup.LayoutParams layoutParams2 = null;
        if (i11 == 10) {
            ImageView imageView2 = this.f77680c;
            ((RelativeLayout.LayoutParams) (imageView2 != null ? imageView2.getLayoutParams() : null)).getRules()[10] = -1;
            ImageView imageView3 = this.f77680c;
            if (imageView3 != null) {
                layoutParams2 = imageView3.getLayoutParams();
            }
            ((RelativeLayout.LayoutParams) layoutParams2).getRules()[12] = 0;
        } else {
            ImageView imageView4 = this.f77680c;
            ((RelativeLayout.LayoutParams) (imageView4 != null ? imageView4.getLayoutParams() : null)).getRules()[10] = 0;
            ImageView imageView5 = this.f77680c;
            if (imageView5 != null) {
                layoutParams2 = imageView5.getLayoutParams();
            }
            ((RelativeLayout.LayoutParams) layoutParams2).getRules()[12] = -1;
        }
        ImageView imageView6 = this.f77680c;
        if (imageView6 != null) {
            imageView6.setImageResource(R$drawable.account_user_v_tag);
        }
        ImageView imageView7 = this.f77680c;
        if (imageView7 != null) {
            imageView7.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        ImageView imageView8 = this.f77680c;
        if (imageView8 != null) {
            imageView8.setVisibility(0);
        }
        return this;
    }

    public final AccountAvatarView getAvatar() {
        return this.f77679b;
    }

    public AccountAvatarNewView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }
}
