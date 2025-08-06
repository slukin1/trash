package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bumptech.glide.a;
import com.bumptech.glide.request.RequestOptions;
import com.tencent.qcloud.tuikit.tuichat.R;

public class FaceGroupIcon extends RelativeLayout {
    private ImageView faceTabIcon;

    public FaceGroupIcon(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.face_group_icon, this);
        this.faceTabIcon = (ImageView) findViewById(R.id.face_group_tab_icon);
    }

    public void setFaceTabIcon(String str) {
        a.w(this).q(str).b(new RequestOptions().l(17301579)).D0(this.faceTabIcon);
    }

    public FaceGroupIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FaceGroupIcon(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
