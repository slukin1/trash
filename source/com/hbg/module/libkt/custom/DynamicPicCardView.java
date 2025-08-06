package com.hbg.module.libkt.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.libkt.R$drawable;
import com.hbg.module.libkt.R$id;
import com.hbg.module.libkt.R$layout;
import com.hbg.module.libkt.custom.PicView;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.d0;

public final class DynamicPicCardView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f24665b;

    /* renamed from: c  reason: collision with root package name */
    public final PicView f24666c;

    /* renamed from: d  reason: collision with root package name */
    public final AppCompatTextView f24667d;

    /* renamed from: e  reason: collision with root package name */
    public int f24668e = 344;

    /* renamed from: f  reason: collision with root package name */
    public int f24669f = 220;

    /* renamed from: g  reason: collision with root package name */
    public int f24670g = 430;

    /* renamed from: h  reason: collision with root package name */
    public int f24671h;

    public DynamicPicCardView(Context context) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_pic_card_view, this, true);
        this.f24665b = (ConstraintLayout) inflate.findViewById(R$id.clRoot);
        this.f24666c = (PicView) inflate.findViewById(R$id.picView);
        this.f24667d = (AppCompatTextView) inflate.findViewById(R$id.tvPicNum);
    }

    public final void setHeightMaxRadio(int i11) {
        this.f24670g = i11;
    }

    public final void setHeightMinRadio(int i11) {
        this.f24669f = i11;
    }

    public final void setImageClickListener(PicView.a aVar) {
        this.f24666c.setImageClickListener(aVar);
    }

    public final void setImageResList(ArrayList<CommunityFeedInfo.imgListBean> arrayList) {
        String str;
        if (arrayList.size() > 4) {
            AppCompatTextView appCompatTextView = this.f24667d;
            d0 d0Var = d0.f56774a;
            appCompatTextView.setText(String.format("+%s", Arrays.copyOf(new Object[]{Integer.valueOf(arrayList.size() - 4)}, 1)));
            this.f24667d.setVisibility(0);
        } else {
            this.f24667d.setVisibility(4);
        }
        if (arrayList.size() != 1) {
            str = "W," + this.f24668e + ':' + this.f24669f;
        } else if (this.f24671h == 2) {
            str = "W,16:9";
        } else {
            int height = (arrayList.get(0).getHeight() * this.f24668e) / (arrayList.get(0).getWidth() > 0 ? arrayList.get(0).getWidth() : this.f24668e);
            int i11 = this.f24669f;
            if (height < i11 || height > (i11 = this.f24670g)) {
                height = i11;
            }
            str = "W," + this.f24668e + ':' + height;
        }
        ViewGroup.LayoutParams layoutParams = this.f24666c.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.H = str;
        }
        this.f24666c.setShowType(this.f24671h);
        this.f24666c.setImageResList(arrayList);
        invalidate();
    }

    public final void setShowType(int i11) {
        this.f24671h = i11;
        this.f24665b.setBackgroundResource(i11 == 0 ? R$drawable.pic_card_view_bg : 0);
    }

    public final void setWidthRadio(int i11) {
        this.f24668e = i11;
    }

    public DynamicPicCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_pic_card_view, this, true);
        this.f24665b = (ConstraintLayout) inflate.findViewById(R$id.clRoot);
        this.f24666c = (PicView) inflate.findViewById(R$id.picView);
        this.f24667d = (AppCompatTextView) inflate.findViewById(R$id.tvPicNum);
    }

    public DynamicPicCardView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_pic_card_view, this, true);
        this.f24665b = (ConstraintLayout) inflate.findViewById(R$id.clRoot);
        this.f24666c = (PicView) inflate.findViewById(R$id.picView);
        this.f24667d = (AppCompatTextView) inflate.findViewById(R$id.tvPicNum);
    }
}
