package com.tencent.qcloud.tuikit.tuicallkit.extensions.recents;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.view.common.RoundCornerImageView;
import com.tencent.qcloud.tuikit.tuicallkit.view.common.gridimage.GridImageSynthesizer;
import java.util.List;

public class RecordsIconView extends RoundCornerImageView {
    private int mBackground = Color.parseColor("#cfd3d8");
    private int mDefaultImageResId = 0;
    private GridImageSynthesizer mGridImageSynthesizer;
    private int mImageGap = 6;
    private int mImageSize = 100;

    public RecordsIconView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        GridImageSynthesizer gridImageSynthesizer = new GridImageSynthesizer(context, this);
        this.mGridImageSynthesizer = gridImageSynthesizer;
        int i11 = this.mImageSize;
        gridImageSynthesizer.setMaxSize(i11, i11);
        this.mGridImageSynthesizer.setDefaultImage(this.mDefaultImageResId);
        this.mGridImageSynthesizer.setBgColor(this.mBackground);
        this.mGridImageSynthesizer.setGap(this.mImageGap);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SynthesizedImageView);
        if (obtainStyledAttributes != null) {
            this.mBackground = obtainStyledAttributes.getColor(R.styleable.SynthesizedImageView_image_background, this.mBackground);
            this.mDefaultImageResId = obtainStyledAttributes.getResourceId(R.styleable.SynthesizedImageView_default_image, this.mDefaultImageResId);
            this.mImageSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SynthesizedImageView_image_size, this.mImageSize);
            this.mImageGap = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SynthesizedImageView_image_gap, this.mImageGap);
            obtainStyledAttributes.recycle();
        }
    }

    public void clear() {
        this.mGridImageSynthesizer.clearImage();
    }

    public RecordsIconView displayImage(List<Object> list) {
        this.mGridImageSynthesizer.setImageUrls(list);
        return this;
    }

    public void load(String str) {
        this.mGridImageSynthesizer.load(str);
    }

    public void setImageId(String str) {
        this.mGridImageSynthesizer.setImageId(str);
    }

    public RecordsIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttrs(attributeSet);
        init(context);
    }

    public RecordsIconView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initAttrs(attributeSet);
        init(context);
    }
}
