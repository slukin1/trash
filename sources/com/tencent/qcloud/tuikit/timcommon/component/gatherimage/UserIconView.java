package com.tencent.qcloud.tuikit.timcommon.component.gatherimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qcloud.tuikit.timcommon.R;
import java.util.List;

public class UserIconView extends RelativeLayout {
    private int mDefaultImageResId;
    private int mIconRadius;
    private SynthesizedImageView mIconView;

    public UserIconView(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        RelativeLayout.inflate(getContext(), R.layout.profile_icon_view, this);
        if (!(attributeSet == null || (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.UserIconView)) == null)) {
            this.mDefaultImageResId = obtainStyledAttributes.getResourceId(R.styleable.UserIconView_default_image, this.mDefaultImageResId);
            this.mIconRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.UserIconView_image_radius, this.mIconRadius);
            obtainStyledAttributes.recycle();
        }
        SynthesizedImageView synthesizedImageView = (SynthesizedImageView) findViewById(R.id.profile_icon);
        this.mIconView = synthesizedImageView;
        int i11 = this.mDefaultImageResId;
        if (i11 > 0) {
            synthesizedImageView.defaultImage(i11);
        }
        int i12 = this.mIconRadius;
        if (i12 > 0) {
            this.mIconView.setRadius(i12);
        }
    }

    public void setDefaultImageResId(int i11) {
        this.mDefaultImageResId = i11;
        this.mIconView.defaultImage(i11);
    }

    public void setIconUrls(List<Object> list) {
        this.mIconView.displayImage(list).load((String) null);
    }

    public void setRadius(int i11) {
        this.mIconRadius = i11;
        this.mIconView.setRadius(i11);
    }

    public UserIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public UserIconView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(attributeSet);
    }
}
