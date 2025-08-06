package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;

public class FaceMessageHolder extends MessageContentHolder {
    private static final int DEFAULT_FACE_MAX_SIZE = 80;
    private final ImageView contentImage;
    private final TextView videoDurationText;
    private final ImageView videoPlayBtn;

    public FaceMessageHolder(View view) {
        super(view);
        this.contentImage = (ImageView) view.findViewById(R.id.content_image_iv);
        this.videoPlayBtn = (ImageView) view.findViewById(R.id.video_play_btn);
        this.videoDurationText = (TextView) view.findViewById(R.id.video_duration_tv);
    }

    private void performCustomFace(FaceMessageBean faceMessageBean) {
        int dip2px = ScreenUtil.dip2px(80.0f);
        this.videoPlayBtn.setVisibility(8);
        this.videoDurationText.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        layoutParams.width = dip2px;
        layoutParams.height = dip2px;
        this.contentImage.setLayoutParams(layoutParams);
        FaceManager.loadFace(faceMessageBean.getIndex(), faceMessageBean.getData() != null ? new String(faceMessageBean.getData()) : null, this.contentImage);
    }

    public void clearHighLightBackground() {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter((ColorFilter) null);
        }
    }

    public int getVariableLayout() {
        return R.layout.message_adapter_content_image;
    }

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11) {
        performCustomFace((FaceMessageBean) tUIMessageBean);
        if (tUIMessageBean.getMessageReactBean() == null || tUIMessageBean.getMessageReactBean().getReactSize() <= 0) {
            this.msgArea.setBackground((Drawable) null);
            this.msgArea.setPadding(0, 0, 0, 0);
        }
    }

    public void setHighLightBackground(int i11) {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(i11, PorterDuff.Mode.SRC_OVER);
        }
    }
}
