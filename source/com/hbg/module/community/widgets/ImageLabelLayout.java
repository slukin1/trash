package com.hbg.module.community.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$dimen;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$font;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.ext.c;
import com.huobi.view.roundimg.RoundedImageView;
import com.huobi.view.roundview.RoundTextView;
import com.huobi.view.roundview.RoundViewDelegate;
import kotlin.jvm.internal.r;

public final class ImageLabelLayout extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public CommunityFeedInfo.imgListBean f17681b;

    /* renamed from: c  reason: collision with root package name */
    public int f17682c;

    /* renamed from: d  reason: collision with root package name */
    public int f17683d;

    /* renamed from: e  reason: collision with root package name */
    public int f17684e;

    /* renamed from: f  reason: collision with root package name */
    public int f17685f;

    /* renamed from: g  reason: collision with root package name */
    public int f17686g;

    /* renamed from: h  reason: collision with root package name */
    public String f17687h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f17688i;

    /* renamed from: j  reason: collision with root package name */
    public Float f17689j;

    /* renamed from: k  reason: collision with root package name */
    public int f17690k;

    /* renamed from: l  reason: collision with root package name */
    public Typeface f17691l;

    /* renamed from: m  reason: collision with root package name */
    public Integer f17692m;

    /* renamed from: n  reason: collision with root package name */
    public int f17693n;

    /* renamed from: o  reason: collision with root package name */
    public int f17694o;

    /* renamed from: p  reason: collision with root package name */
    public int f17695p;

    /* renamed from: q  reason: collision with root package name */
    public int f17696q;

    /* renamed from: r  reason: collision with root package name */
    public RoundTextView f17697r;

    /* renamed from: s  reason: collision with root package name */
    public RelativeLayout.LayoutParams f17698s;

    /* renamed from: t  reason: collision with root package name */
    public RelativeLayout.LayoutParams f17699t;

    /* renamed from: u  reason: collision with root package name */
    public RoundedImageView f17700u;

    public ImageLabelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageLabelLayout(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final void a() {
        if (this.f17681b != null) {
            removeAllViews();
            removeAllViewsInLayout();
            RoundedImageView roundedImageView = new RoundedImageView(getContext());
            this.f17700u = roundedImageView;
            roundedImageView.setCornerRadius(getContext().getResources().getDimension(R$dimen.dimen_8));
            int i11 = this.f17696q;
            boolean z11 = false;
            String str = null;
            if (i11 == 0) {
                CommunityFeedInfo.imgListBean imglistbean = this.f17681b;
                float height = ((float) (imglistbean != null ? imglistbean.getHeight() : 0)) * 1.0f;
                CommunityFeedInfo.imgListBean imglistbean2 = this.f17681b;
                if (height / ((float) (imglistbean2 != null ? imglistbean2.getWidth() : 1)) > (((float) this.f17683d) * 1.0f) / ((float) this.f17682c)) {
                    RoundedImageView roundedImageView2 = this.f17700u;
                    if (roundedImageView2 != null) {
                        roundedImageView2.setScaleType(ImageView.ScaleType.FIT_START);
                    }
                } else {
                    RoundedImageView roundedImageView3 = this.f17700u;
                    if (roundedImageView3 != null) {
                        roundedImageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }
                }
            } else if (i11 == 1) {
                RoundedImageView roundedImageView4 = this.f17700u;
                if (roundedImageView4 != null) {
                    roundedImageView4.setScaleType(ImageView.ScaleType.FIT_START);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                this.f17699t = layoutParams;
                layoutParams.alignWithParent = true;
                layoutParams.addRule(11);
                RelativeLayout.LayoutParams layoutParams2 = this.f17699t;
                if (layoutParams2 != null) {
                    layoutParams2.addRule(12);
                }
                RoundTextView roundTextView = new RoundTextView(getContext());
                this.f17697r = roundTextView;
                roundTextView.setTextSize(this.f17689j.floatValue());
                RoundTextView roundTextView2 = this.f17697r;
                if (roundTextView2 != null) {
                    roundTextView2.setTextColor(this.f17690k);
                }
                RoundTextView roundTextView3 = this.f17697r;
                RoundViewDelegate delegate = roundTextView3 != null ? roundTextView3.getDelegate() : null;
                if (delegate != null) {
                    delegate.setBackgroundColor(this.f17688i.intValue());
                }
                RoundTextView roundTextView4 = this.f17697r;
                RoundViewDelegate delegate2 = roundTextView4 != null ? roundTextView4.getDelegate() : null;
                if (delegate2 != null) {
                    delegate2.setCornerRadiusTopLeft(this.f17693n);
                }
                RoundTextView roundTextView5 = this.f17697r;
                RoundViewDelegate delegate3 = roundTextView5 != null ? roundTextView5.getDelegate() : null;
                if (delegate3 != null) {
                    delegate3.setCornerRadiusBottomRight(this.f17694o);
                }
                RoundTextView roundTextView6 = this.f17697r;
                if (roundTextView6 != null) {
                    roundTextView6.setText(this.f17687h);
                }
            } else if (i11 == 2) {
                RoundedImageView roundedImageView5 = this.f17700u;
                if (roundedImageView5 != null) {
                    roundedImageView5.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            } else if (i11 == 3) {
                this.f17699t = new RelativeLayout.LayoutParams(-2, -2);
                this.f17697r = new RoundTextView(getContext());
                RoundedImageView roundedImageView6 = this.f17700u;
                if (roundedImageView6 != null) {
                    roundedImageView6.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                RelativeLayout.LayoutParams layoutParams3 = this.f17699t;
                if (layoutParams3 != null) {
                    layoutParams3.addRule(13);
                }
                RoundTextView roundTextView7 = this.f17697r;
                if (roundTextView7 != null) {
                    roundTextView7.setTextSize(this.f17689j.floatValue());
                }
                RoundTextView roundTextView8 = this.f17697r;
                if (roundTextView8 != null) {
                    roundTextView8.setTextColor(-1);
                }
                RoundTextView roundTextView9 = this.f17697r;
                if (roundTextView9 != null) {
                    roundTextView9.setBackgroundColor(this.f17688i.intValue());
                }
                RoundTextView roundTextView10 = this.f17697r;
                if (roundTextView10 != null) {
                    roundTextView10.setText(this.f17687h);
                }
                RoundedImageView roundedImageView7 = this.f17700u;
                if (roundedImageView7 != null) {
                    roundedImageView7.setColorFilter(this.f17695p);
                }
            }
            this.f17698s = new RelativeLayout.LayoutParams(this.f17682c, this.f17683d);
            if (!(indexOfChild(this.f17700u) != -1)) {
                addView(this.f17700u, this.f17698s);
            }
            RoundTextView roundTextView11 = this.f17697r;
            if (roundTextView11 != null) {
                if (indexOfChild(roundTextView11) != -1) {
                    z11 = true;
                }
                if (!z11) {
                    roundTextView11.setPadding(this.f17692m.intValue(), this.f17692m.intValue(), this.f17692m.intValue(), this.f17692m.intValue());
                    roundTextView11.setTypeface(this.f17691l);
                    addView(roundTextView11, this.f17699t);
                }
            }
            int i12 = R$drawable.bg_img_placeholder;
            if (NightHelper.e().g()) {
                i12 = R$drawable.bg_img_placeholder_night;
            }
            RoundedImageView roundedImageView8 = this.f17700u;
            CommunityFeedInfo.imgListBean imglistbean3 = this.f17681b;
            if (imglistbean3 != null) {
                str = imglistbean3.getThumbImage();
            }
            b.O(roundedImageView8, str, i12, c.d(Float.valueOf(8.0f)));
        }
    }

    public final int getImageHeight() {
        return this.f17683d;
    }

    public final RelativeLayout.LayoutParams getImageParams() {
        return this.f17698s;
    }

    public final int getImageType() {
        return this.f17696q;
    }

    public final int getImageWidth() {
        return this.f17682c;
    }

    public final CommunityFeedInfo.imgListBean getImgData() {
        return this.f17681b;
    }

    public final Integer getLabelBackground() {
        return this.f17688i;
    }

    public final int getLabelBottomRight() {
        return this.f17694o;
    }

    public final Typeface getLabelFont() {
        return this.f17691l;
    }

    public final int getLabelHeight() {
        return this.f17686g;
    }

    public final Integer getLabelPadding() {
        return this.f17692m;
    }

    public final RelativeLayout.LayoutParams getLabelParams() {
        return this.f17699t;
    }

    public final String getLabelText() {
        return this.f17687h;
    }

    public final int getLabelTextColor() {
        return this.f17690k;
    }

    public final Float getLabelTextSize() {
        return this.f17689j;
    }

    public final int getLabelTopLeftCorner() {
        return this.f17693n;
    }

    public final RoundTextView getLabelView() {
        return this.f17697r;
    }

    public final int getLabelWidth() {
        return this.f17685f;
    }

    public final int getLastImgFilterColor() {
        return this.f17695p;
    }

    public final int getMaxImageHeight() {
        return this.f17684e;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f17681b != null) {
            a();
        }
    }

    public final void setImageHeight(int i11) {
        this.f17683d = i11;
    }

    public final void setImageParams(RelativeLayout.LayoutParams layoutParams) {
        this.f17698s = layoutParams;
    }

    public final void setImageType(int i11) {
        this.f17696q = i11;
    }

    public final void setImageWidth(int i11) {
        this.f17682c = i11;
    }

    public final void setImgData(CommunityFeedInfo.imgListBean imglistbean) {
        this.f17681b = imglistbean;
    }

    public final void setLabelBackground(Integer num) {
        this.f17688i = num;
    }

    public final void setLabelBottomRight(int i11) {
        this.f17694o = i11;
    }

    public final void setLabelFont(Typeface typeface) {
        this.f17691l = typeface;
    }

    public final void setLabelHeight(int i11) {
        this.f17686g = i11;
    }

    public final void setLabelPadding(Integer num) {
        this.f17692m = num;
    }

    public final void setLabelParams(RelativeLayout.LayoutParams layoutParams) {
        this.f17699t = layoutParams;
    }

    public final void setLabelText(String str) {
        this.f17687h = str;
    }

    public final void setLabelTextColor(int i11) {
        this.f17690k = i11;
    }

    public final void setLabelTextSize(Float f11) {
        this.f17689j = f11;
    }

    public final void setLabelTopLeftCorner(int i11) {
        this.f17693n = i11;
    }

    public final void setLabelView(RoundTextView roundTextView) {
        this.f17697r = roundTextView;
    }

    public final void setLabelWidth(int i11) {
        this.f17685f = i11;
    }

    public final void setLastImgFilterColor(int i11) {
        this.f17695p = i11;
    }

    public final void setMaxImageHeight(int i11) {
        this.f17684e = i11;
    }

    public ImageLabelLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f17684e = 2000;
        this.f17687h = "";
        Resources resources = context.getResources();
        Integer num = null;
        this.f17688i = resources != null ? Integer.valueOf(resources.getColor(R$color.community_label_background)) : null;
        Resources resources2 = context.getResources();
        this.f17689j = resources2 != null ? Float.valueOf(resources2.getDimension(R$dimen.dimen_20)) : null;
        this.f17690k = -1;
        this.f17691l = ResourcesCompat.h(context, R$font.roboto_regular);
        Resources resources3 = context.getResources();
        this.f17692m = resources3 != null ? Integer.valueOf((int) resources3.getDimension(R$dimen.dimen_4)) : null;
        Resources resources4 = context.getResources();
        this.f17693n = (resources4 != null ? Integer.valueOf((int) resources4.getDimension(R$dimen.dimen_4)) : null).intValue();
        Resources resources5 = context.getResources();
        this.f17694o = (resources5 != null ? Integer.valueOf((int) resources5.getDimension(R$dimen.dimen_4)) : num).intValue();
        this.f17695p = Color.parseColor("#66000000");
    }
}
