package com.zopim.android.sdk.chatlog;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.items.ChatRating;
import mz.f;

final class ChatRatingHolder extends RecyclerView.ViewHolder implements ViewBinder<ChatRating> {
    private static final String LOG_TAG = "ChatRatingHolder";
    private View addCommentButton;
    /* access modifiers changed from: private */
    public TextView commentMessageView;
    private View editCommentButton;
    /* access modifiers changed from: private */
    public RatingListener listener;
    public View.OnClickListener mAddCommentClickListener = new View.OnClickListener() {
        @SensorsDataInstrumented
        public void onClick(View view) {
            ChatRatingHolder.this.itemView.getContext().startActivity(new Intent(ChatRatingHolder.this.itemView.getContext(), ZopimCommentActivity.class));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    };
    public View.OnClickListener mEditCommentClickListener = new View.OnClickListener() {
        @SensorsDataInstrumented
        public void onClick(View view) {
            Intent intent = new Intent(ChatRatingHolder.this.itemView.getContext(), ZopimCommentActivity.class);
            intent.putExtra(ZopimCommentActivity.EXTRA_COMMENT, ChatRatingHolder.this.commentMessageView.getText().toString());
            ChatRatingHolder.this.itemView.getContext().startActivity(intent);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    };
    public View.OnClickListener mNegativeClickListener = new View.OnClickListener() {
        @SensorsDataInstrumented
        public void onClick(View view) {
            ChatLog.Rating rating = ChatRatingHolder.this.ratingItem.getRating();
            ChatLog.Rating rating2 = ChatLog.Rating.BAD;
            if (rating == rating2) {
                ChatRatingHolder.this.radioGroup.clearCheck();
                if (ChatRatingHolder.this.listener != null) {
                    ChatRatingHolder.this.listener.onRated(ChatLog.Rating.UNRATED);
                }
            } else if (ChatRatingHolder.this.listener != null) {
                ChatRatingHolder.this.listener.onRated(rating2);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    };
    public View.OnClickListener mPositiveClickListener = new View.OnClickListener() {
        @SensorsDataInstrumented
        public void onClick(View view) {
            ChatLog.Rating rating = ChatRatingHolder.this.ratingItem.getRating();
            ChatLog.Rating rating2 = ChatLog.Rating.GOOD;
            if (rating == rating2) {
                ChatRatingHolder.this.radioGroup.clearCheck();
                if (ChatRatingHolder.this.listener != null) {
                    ChatRatingHolder.this.listener.onRated(ChatLog.Rating.UNRATED);
                }
            } else if (ChatRatingHolder.this.listener != null) {
                ChatRatingHolder.this.listener.onRated(rating2);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    };
    private RadioButton negativeButton;
    private RadioButton positiveButton;
    /* access modifiers changed from: private */
    public RadioGroup radioGroup;
    /* access modifiers changed from: private */
    public ChatRating ratingItem;

    /* renamed from: com.zopim.android.sdk.chatlog.ChatRatingHolder$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$ChatLog$Rating;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.zopim.android.sdk.model.ChatLog$Rating[] r0 = com.zopim.android.sdk.model.ChatLog.Rating.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$model$ChatLog$Rating = r0
                com.zopim.android.sdk.model.ChatLog$Rating r1 = com.zopim.android.sdk.model.ChatLog.Rating.GOOD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Rating     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.model.ChatLog$Rating r1 = com.zopim.android.sdk.model.ChatLog.Rating.BAD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Rating     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zopim.android.sdk.model.ChatLog$Rating r1 = com.zopim.android.sdk.model.ChatLog.Rating.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.chatlog.ChatRatingHolder.AnonymousClass5.<clinit>():void");
        }
    }

    public interface RatingListener {
        void onRated(ChatLog.Rating rating);
    }

    public ChatRatingHolder(View view) {
        super(view);
        this.radioGroup = (RadioGroup) view.findViewById(R.id.rating_button_group);
        this.positiveButton = (RadioButton) view.findViewById(R.id.positive_button);
        this.negativeButton = (RadioButton) view.findViewById(R.id.negative_button);
        this.addCommentButton = view.findViewById(R.id.add_comment_button);
        this.editCommentButton = view.findViewById(R.id.edit_comment_button);
        this.commentMessageView = (TextView) view.findViewById(R.id.comment_message);
        this.positiveButton.setOnClickListener(this.mPositiveClickListener);
        this.negativeButton.setOnClickListener(this.mNegativeClickListener);
        this.addCommentButton.setOnClickListener(this.mAddCommentClickListener);
        this.editCommentButton.setOnClickListener(this.mEditCommentClickListener);
    }

    public void setRatingListener(RatingListener ratingListener) {
        this.listener = ratingListener;
    }

    public void bind(ChatRating chatRating) {
        if (chatRating == null) {
            Logger.d(LOG_TAG, "Item must not be null", new Object[0]);
            return;
        }
        this.ratingItem = chatRating;
        int i11 = AnonymousClass5.$SwitchMap$com$zopim$android$sdk$model$ChatLog$Rating[chatRating.getRating().ordinal()];
        if (i11 == 1) {
            this.positiveButton.setChecked(true);
            this.negativeButton.setChecked(false);
            this.addCommentButton.setVisibility(0);
        } else if (i11 != 2) {
            this.positiveButton.setChecked(false);
            this.negativeButton.setChecked(false);
            this.addCommentButton.setVisibility(4);
        } else {
            this.positiveButton.setChecked(false);
            this.negativeButton.setChecked(true);
            this.addCommentButton.setVisibility(0);
        }
        if (f.c(chatRating.getComment())) {
            this.addCommentButton.setVisibility(8);
            this.editCommentButton.setVisibility(0);
            this.commentMessageView.setVisibility(0);
            this.commentMessageView.setText(chatRating.getComment());
        } else {
            this.editCommentButton.setVisibility(8);
            this.commentMessageView.setVisibility(8);
        }
        boolean z11 = !chatRating.isDisabled();
        this.positiveButton.setClickable(z11);
        this.positiveButton.setEnabled(z11);
        this.negativeButton.setClickable(z11);
        this.negativeButton.setEnabled(z11);
        this.addCommentButton.setClickable(z11);
        this.addCommentButton.setEnabled(z11);
        this.editCommentButton.setClickable(z11);
        this.editCommentButton.setEnabled(z11);
    }
}
