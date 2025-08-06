package com.tencent.qcloud.tuikit.timcommon.minimalistui.widget.message;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.timcommon.R;

public class MessageStatusTimeView extends FrameLayout {
    private ImageView statusIconView;
    private TextView timeView;

    public MessageStatusTimeView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.chat_minimalist_text_status_layout, this);
        this.statusIconView = (ImageView) findViewById(R.id.status_icon);
        this.timeView = (TextView) findViewById(R.id.time);
    }

    public void setStatusIcon(int i11) {
        if (i11 == 0) {
            this.statusIconView.setVisibility(8);
            return;
        }
        this.statusIconView.setBackgroundResource(i11);
        Drawable background = this.statusIconView.getBackground();
        if (background instanceof Animatable) {
            ((Animatable) background).start();
        }
        this.statusIconView.setVisibility(0);
    }

    public void setTimeColor(int i11) {
        this.timeView.setTextColor(i11);
    }

    public void setTimeText(CharSequence charSequence) {
        this.timeView.setText(charSequence);
    }

    public MessageStatusTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MessageStatusTimeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
