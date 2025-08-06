package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FaceReplyQuoteBean;

public class FaceReplyQuoteView extends TUIReplyQuoteView {
    private final ImageView contentImage = ((ImageView) findViewById(R.id.content_image_iv));

    public FaceReplyQuoteView(Context context) {
        super(context);
    }

    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_face_layout;
    }

    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        FaceReplyQuoteBean faceReplyQuoteBean = (FaceReplyQuoteBean) tUIReplyQuoteBean;
        String str = new String(faceReplyQuoteBean.getData());
        ViewGroup.LayoutParams layoutParams = this.contentImage.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.reply_message_image_size);
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            this.contentImage.setLayoutParams(layoutParams);
        }
        FaceManager.loadFace(faceReplyQuoteBean.getIndex(), str, this.contentImage);
    }
}
