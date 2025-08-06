package com.zopim.android.sdk.chatlog;

import android.view.View;
import android.widget.TextView;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.model.items.VisitorMessage;

final class VisitorMessageHolder extends VisitorHolder<VisitorMessage> {
    private TextView messageView;

    public VisitorMessageHolder(View view) {
        super(view);
        this.messageView = (TextView) view.findViewById(R.id.message_text);
    }

    public void bind(VisitorMessage visitorMessage) {
        super.bind(visitorMessage);
        this.messageView.setText(visitorMessage.getMessage());
    }
}
