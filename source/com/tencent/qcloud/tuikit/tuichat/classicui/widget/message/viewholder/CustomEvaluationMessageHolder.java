package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomEvaluationMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

public class CustomEvaluationMessageHolder extends MessageContentHolder {
    public static final String TAG = "CustomEvaluationMessageHolder";
    private TextView contentView;
    private RatingBar ratingBar;
    private TextView textView;

    public CustomEvaluationMessageHolder(View view) {
        super(view);
        this.textView = (TextView) view.findViewById(R.id.test_custom_message_tv);
        this.contentView = (TextView) view.findViewById(R.id.link_tv);
        this.ratingBar = (RatingBar) view.findViewById(R.id.opreview_ratingbar);
    }

    public int getVariableLayout() {
        return R.layout.custom_evaluation_message_layout;
    }

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11) {
        int i12;
        String str;
        if (tUIMessageBean instanceof CustomEvaluationMessageBean) {
            CustomEvaluationMessageBean customEvaluationMessageBean = (CustomEvaluationMessageBean) tUIMessageBean;
            i12 = customEvaluationMessageBean.getScore();
            str = customEvaluationMessageBean.getContent();
        } else {
            i12 = 0;
            str = "";
        }
        this.textView.setText(ServiceInitializer.getAppContext().getString(R.string.custom_evaluation_message));
        this.msgContentFrame.setClickable(true);
        if (i12 == 0) {
            this.ratingBar.setVisibility(8);
        } else {
            this.ratingBar.setRating((float) i12);
            this.ratingBar.setNumStars(i12);
            this.ratingBar.setIsIndicator(true);
        }
        String str2 = TAG;
        TUIChatLog.d(str2, "score = " + i12);
        this.contentView.setText(str);
    }
}
