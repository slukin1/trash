package com.tencent.qcloud.tuikit.timcommon.component.gatherimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.qcloud.tuikit.timcommon.R;
import java.util.List;

public class SynthesizedImageView extends ShadeImageView {
    public int defaultImageResId = 0;
    public int imageGap = 6;
    public int imageSize = 100;
    public int synthesizedBg = Color.parseColor("#cfd3d8");
    public TeamHeadSynthesizer teamHeadSynthesizer;

    public SynthesizedImageView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        TeamHeadSynthesizer teamHeadSynthesizer2 = new TeamHeadSynthesizer(context, this);
        this.teamHeadSynthesizer = teamHeadSynthesizer2;
        int i11 = this.imageSize;
        teamHeadSynthesizer2.setMaxWidthHeight(i11, i11);
        this.teamHeadSynthesizer.setDefaultImage(this.defaultImageResId);
        this.teamHeadSynthesizer.setBgColor(this.synthesizedBg);
        this.teamHeadSynthesizer.setGap(this.imageGap);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SynthesizedImageView);
        if (obtainStyledAttributes != null) {
            this.synthesizedBg = obtainStyledAttributes.getColor(R.styleable.SynthesizedImageView_synthesized_image_bg, this.synthesizedBg);
            this.defaultImageResId = obtainStyledAttributes.getResourceId(R.styleable.SynthesizedImageView_synthesized_default_image, this.defaultImageResId);
            this.imageSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SynthesizedImageView_synthesized_image_size, this.imageSize);
            this.imageGap = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SynthesizedImageView_synthesized_image_gap, this.imageGap);
            obtainStyledAttributes.recycle();
        }
    }

    public void clear() {
        this.teamHeadSynthesizer.clearImage();
    }

    public SynthesizedImageView defaultImage(int i11) {
        this.teamHeadSynthesizer.setDefaultImage(i11);
        return this;
    }

    public SynthesizedImageView displayImage(List<Object> list) {
        this.teamHeadSynthesizer.getMultiImageData().setImageUrls(list);
        return this;
    }

    public void load(String str) {
        this.teamHeadSynthesizer.load(str);
    }

    public void setImageId(String str) {
        this.teamHeadSynthesizer.setImageId(str);
    }

    public SynthesizedImageView synthesizedWidthHeight(int i11, int i12) {
        this.teamHeadSynthesizer.setMaxWidthHeight(i11, i12);
        return this;
    }

    public SynthesizedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttrs(attributeSet);
        init(context);
    }

    public SynthesizedImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initAttrs(attributeSet);
        init(context);
    }
}
