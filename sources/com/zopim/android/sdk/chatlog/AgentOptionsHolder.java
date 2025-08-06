package com.zopim.android.sdk.chatlog;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.model.items.AgentOptions;

final class AgentOptionsHolder extends AgentHolder<AgentOptions> {
    private static final String LOG_TAG = "AgentOptionsHolder";
    /* access modifiers changed from: private */
    public OptionClickListener clickListener;
    private TextView messageView;
    public LinearLayout optionsContainer;

    public interface OptionClickListener {
        void onClick(String str);
    }

    public AgentOptionsHolder(View view) {
        super(view);
        this.optionsContainer = (LinearLayout) view.findViewById(R.id.options_container);
        this.messageView = (TextView) view.findViewById(R.id.message_text);
    }

    public void setClickListener(OptionClickListener optionClickListener) {
        this.clickListener = optionClickListener;
    }

    public void bind(AgentOptions agentOptions) {
        super.bind(agentOptions);
        this.messageView.setText(agentOptions.getMessage());
        if (agentOptions.getOptions().length != this.optionsContainer.getChildCount()) {
            Logger.l(LOG_TAG, agentOptions.getOptions().length + " item options,  " + this.optionsContainer.getChildCount() + " views.", new Object[0]);
            Logger.l(LOG_TAG, "Unexpected agent options length. Ignoring to avoid array index out bounds exception.", new Object[0]);
            return;
        }
        int length = agentOptions.getOptions().length;
        if (length == 0) {
            return;
        }
        if (length != 1) {
            for (int i11 = 0; i11 < agentOptions.getOptions().length; i11++) {
                String str = agentOptions.getOptions()[i11];
                TextView textView = (TextView) this.optionsContainer.getChildAt(i11);
                textView.setText(str);
                textView.setClickable(!agentOptions.isDisabled());
                textView.setEnabled(!agentOptions.isDisabled());
                textView.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        view.setClickable(false);
                        TextView textView = (TextView) view;
                        textView.setBackgroundResource(R.drawable.bg_chat_bubble_visitor);
                        textView.setTextAppearance(AgentOptionsHolder.this.itemView.getContext(), R.style.chat_bubble_visitor);
                        String charSequence = textView.getText().toString();
                        if (AgentOptionsHolder.this.clickListener != null) {
                            AgentOptionsHolder.this.clickListener.onClick(charSequence);
                        }
                        Logger.j(AgentOptionsHolder.LOG_TAG, "Clicked option item ", charSequence);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
            }
            return;
        }
        TextView textView2 = (TextView) this.optionsContainer.getChildAt(0);
        textView2.setText(agentOptions.getOptions()[0]);
        textView2.setBackgroundResource(R.drawable.bg_chat_bubble_visitor);
        textView2.setTextAppearance(this.itemView.getContext(), R.style.chat_bubble_visitor);
        textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}
