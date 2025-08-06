package com.huobi.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$dimen;
import com.huobi.view.HeavyBubbleDialog;
import g6.b;

public class HeavyPicTextBubbleDialog extends HeavyBubbleDialog {
    public int defaultWidth;
    public int picMargin;

    public HeavyPicTextBubbleDialog(boolean z11) {
        this.supportNight = z11;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.heavy_bubble_pic_horizontal_margin);
        this.picMargin = dimensionPixelOffset;
        HeavyBubbleDialog.Builder builder = this.builder;
        if (builder != null) {
            this.defaultWidth = builder.animWidth + ((dimensionPixelOffset + this.shadowWidth) * 2);
            setImage(builder.imageResId);
            setImage(this.builder.imageUrl);
            HeavyBubbleDialog.Builder builder2 = this.builder;
            setJsonAnim(builder2.animResId, builder2.animWidth, builder2.animHeight);
        }
        return this.rootView;
    }

    public void onStart() {
        super.onStart();
        autoLayoutWindowByAnchor(this.defaultWidth);
    }

    public void setImage(int i11) {
        if (i11 != 0) {
            this.ivImage.setImageResource(i11);
            this.lvAnim.setVisibility(8);
            this.ivImage.setVisibility(0);
        }
    }

    public void setJsonAnim(int i11, int i12, int i13) {
        if (i11 != 0) {
            this.lvAnim.setLottieAnimationRes(i11);
            ViewGroup.LayoutParams layoutParams = this.lvAnim.getLayoutParams();
            layoutParams.width = i12;
            layoutParams.height = i13;
            this.lvAnim.setLayoutParams(layoutParams);
            this.lvAnim.setVisibility(0);
            this.ivImage.setVisibility(8);
        }
    }

    public void setImage(String str) {
        if (!TextUtils.isEmpty(str)) {
            b.c().i(this.ivImage, str, R$color.dialog_video_default);
            this.lvAnim.setVisibility(8);
            this.ivImage.setVisibility(0);
        }
    }
}
