package zendesk.support.request;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.sdk.R$attr;
import com.zendesk.sdk.R$color;
import com.zendesk.sdk.R$dimen;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$integer;
import com.zendesk.sdk.R$layout;
import java.util.LinkedList;
import java.util.List;
import mz.f;
import zendesk.belvedere.ImageStream;
import zendesk.support.UiUtils;

class ViewMessageComposer extends FrameLayout implements View.OnClickListener, View.OnFocusChangeListener, View.OnLayoutChangeListener, TextView.OnEditorActionListener, TextWatcher {
    private static final String LOG_TAG = "ViewMessageComposer";
    private ViewAttachmentsIndicator attachmentsIndicator;
    private AnimatorSet attachmentsOffCollapseAnimatorSet;
    private AnimatorSet attachmentsOffExpandAnimatorSet;
    private AnimatorSet attachmentsOnCollapseAnimatorSet;
    private AnimatorSet attachmentsOnExpandAnimatorSet;
    private ImageStream imageStream;
    private List<InputListener> inputListenerList = new LinkedList();
    private EditText inputTextField;
    private boolean isAttachmentsButtonDisabled = true;
    private boolean isSendButtonDisabled = true;
    private List<View.OnFocusChangeListener> onFocusChangeListenerList = new LinkedList();
    private OnHeightChangeListener onHeightChangeListener;
    private ImageView sendButton;
    private MessageComposerStateHelper stateHelper;

    public interface InputListener {
        void onAddAttachmentsRequested();

        void onSendMessageRequested(String str);
    }

    public static class MessageComposerState {
        public static final int BUTTON_DISABLED = 11;
        public static final int BUTTON_ENABLED = 12;
        public static final int BUTTON_HIDDEN = 10;
        public static final int FIELD_COLLAPSED = 2;
        public static final int FIELD_EXPANDED = 1;
        private final int attachmentButtonState;
        private final int fieldState;
        private final int sendButtonState;

        public MessageComposerState(int i11, int i12, int i13) {
            this.fieldState = i11;
            this.sendButtonState = i12;
            this.attachmentButtonState = i13;
        }

        public int getFieldState() {
            return this.fieldState;
        }

        public int getSendButtonState() {
            return this.sendButtonState;
        }

        public boolean isAttachmentButtonActivated() {
            return this.attachmentButtonState == 12;
        }

        public boolean isAttachmentButtonEnabled() {
            return this.attachmentButtonState != 10;
        }

        public String toString() {
            return "MessageComposerState{fieldState=" + this.fieldState + ", sendButtonState=" + this.sendButtonState + ", attachmentButtonEnabled=" + this.attachmentButtonState + '}';
        }
    }

    public static class MessageComposerStateHelper {
        private boolean hasAttachments(ViewAttachmentsIndicator viewAttachmentsIndicator) {
            return viewAttachmentsIndicator.getAttachmentsCount() > 0;
        }

        private boolean hasLength(String str) {
            return str != null && str.length() > 0;
        }

        private boolean hasValidText(String str) {
            return f.c(str);
        }

        public int getAttachmentButtonState(boolean z11, boolean z12) {
            if (z11) {
                return 10;
            }
            return z12 ? 12 : 11;
        }

        public int getFieldState(boolean z11, boolean z12, boolean z13, boolean z14) {
            return (z11 || z12 || z14 || z13) ? 1 : 2;
        }

        public int getSendButtonState(boolean z11, boolean z12, boolean z13, int i11) {
            if (z12) {
                return 12;
            }
            if (!z13 || z11) {
                return i11 == 1 ? 11 : 10;
            }
            return 12;
        }

        public MessageComposerState getState(EditText editText, EditText editText2, ViewAttachmentsIndicator viewAttachmentsIndicator, boolean z11, boolean z12, boolean z13) {
            String obj = editText.getText().toString();
            boolean hasLength = hasLength(obj);
            boolean hasValidText = hasValidText(obj);
            boolean hasFocus = editText.hasFocus();
            boolean hasFocus2 = editText2.hasFocus();
            boolean hasAttachments = hasAttachments(viewAttachmentsIndicator);
            int fieldState = getFieldState(hasFocus, hasLength, hasFocus2, hasAttachments);
            return new MessageComposerState(fieldState, getSendButtonState(z12, hasValidText, hasAttachments, fieldState), getAttachmentButtonState(z13, z11));
        }

        public MessageComposerState onAttachmentClicked(boolean z11, boolean z12, EditText editText, EditText editText2, ViewAttachmentsIndicator viewAttachmentsIndicator) {
            int i11;
            MessageComposerState state = getState(editText, editText2, viewAttachmentsIndicator, true, z11, z12);
            if (state.getSendButtonState() == 10) {
                i11 = 11;
            } else {
                i11 = state.getSendButtonState();
            }
            return new MessageComposerState(1, i11, getAttachmentButtonState(z12, true));
        }
    }

    public interface OnHeightChangeListener {
        void onHeightChange(int i11);
    }

    public ViewMessageComposer(Context context) {
        super(context);
        viewInit(context);
    }

    private void applyState(MessageComposerState messageComposerState) {
        if (messageComposerState.getFieldState() != 1 || isExpanded()) {
            if (messageComposerState.getFieldState() == 2 && isExpanded()) {
                if (this.isAttachmentsButtonDisabled) {
                    this.attachmentsOffCollapseAnimatorSet.start();
                } else {
                    this.attachmentsOnCollapseAnimatorSet.start();
                }
            }
        } else if (this.isAttachmentsButtonDisabled) {
            this.attachmentsOffExpandAnimatorSet.start();
        } else {
            this.attachmentsOnExpandAnimatorSet.start();
        }
        int i11 = 0;
        if (messageComposerState.getSendButtonState() == 10) {
            updateSendBtn(false, false);
        } else if (messageComposerState.getSendButtonState() == 11) {
            updateSendBtn(true, false);
        } else if (messageComposerState.getSendButtonState() == 12) {
            updateSendBtn(true, true);
        }
        if (!messageComposerState.isAttachmentButtonEnabled()) {
            i11 = 8;
        }
        if (this.attachmentsIndicator.getVisibility() != i11) {
            updateAttachmentButtonPosition();
            this.attachmentsIndicator.setVisibility(i11);
        }
        if (messageComposerState.isAttachmentButtonEnabled() && this.attachmentsIndicator.getAttachmentsCount() == 0) {
            this.attachmentsIndicator.enableActiveState(messageComposerState.isAttachmentButtonActivated());
            this.attachmentsIndicator.setBottomBorderVisible(messageComposerState.isAttachmentButtonActivated());
        }
    }

    private void bindViews() {
        this.inputTextField = (EditText) findViewById(R$id.message_composer_input_text);
        this.attachmentsIndicator = (ViewAttachmentsIndicator) findViewById(R$id.message_composer_attachments_indicator);
        this.sendButton = (ImageView) findViewById(R$id.message_composer_send_btn);
    }

    private void initAnimationsAndAdjustLeftMargin() {
        Resources resources = getResources();
        int integer = resources.getInteger(R$integer.zs_request_message_composer_animation_duration);
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.zs_request_message_composer_collapsed_height);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.zs_request_message_composer_expanded_min_height);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R$dimen.zs_request_message_composer_expanded_side_margin);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R$dimen.zs_request_message_composer_collapsed_side_margin);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(R$dimen.zs_request_message_composer_expanded_top_padding);
        int dimensionPixelSize6 = resources.getDimensionPixelSize(R$dimen.zs_request_message_composer_collapsed_top_padding);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.zs_request_message_composer_expanded_bottom_padding);
        this.attachmentsOnExpandAnimatorSet = new AnimatorSet();
        this.attachmentsOffExpandAnimatorSet = new AnimatorSet();
        this.attachmentsOnCollapseAnimatorSet = new AnimatorSet();
        this.attachmentsOffCollapseAnimatorSet = new AnimatorSet();
        LinearOutSlowInInterpolator linearOutSlowInInterpolator = new LinearOutSlowInInterpolator();
        FastOutSlowInInterpolator fastOutSlowInInterpolator = new FastOutSlowInInterpolator();
        this.attachmentsOnExpandAnimatorSet.setInterpolator(linearOutSlowInInterpolator);
        this.attachmentsOffExpandAnimatorSet.setInterpolator(linearOutSlowInInterpolator);
        this.attachmentsOnCollapseAnimatorSet.setInterpolator(fastOutSlowInInterpolator);
        this.attachmentsOffCollapseAnimatorSet.setInterpolator(fastOutSlowInInterpolator);
        this.attachmentsOnExpandAnimatorSet.play(UtilsAnimation.minHeightAnimator(this.inputTextField, dimensionPixelSize, dimensionPixelSize2, integer)).with(UtilsAnimation.sideMarginsAnimator(this.inputTextField, dimensionPixelSize4, dimensionPixelSize3, integer)).with(UtilsAnimation.topPaddingAnimator(this.inputTextField, dimensionPixelSize6, dimensionPixelSize5, integer)).with(UtilsAnimation.bottomPaddingAnimator(this.inputTextField, 0, dimensionPixelOffset, integer));
        this.attachmentsOnCollapseAnimatorSet.play(UtilsAnimation.sideMarginsAnimator(this.inputTextField, dimensionPixelSize3, dimensionPixelSize4, integer)).with(UtilsAnimation.topPaddingAnimator(this.inputTextField, dimensionPixelSize5, dimensionPixelSize6, integer)).with(UtilsAnimation.minHeightAnimator(this.inputTextField, dimensionPixelSize2, dimensionPixelSize, integer)).with(UtilsAnimation.bottomPaddingAnimator(this.inputTextField, dimensionPixelOffset, 0, integer));
        this.attachmentsOffExpandAnimatorSet.play(UtilsAnimation.minHeightAnimator(this.inputTextField, dimensionPixelSize, dimensionPixelSize2, integer)).with(UtilsAnimation.sideMarginsAnimator(this.inputTextField, dimensionPixelSize3, dimensionPixelSize3, integer)).with(UtilsAnimation.topPaddingAnimator(this.inputTextField, dimensionPixelSize6, dimensionPixelSize5, integer)).with(UtilsAnimation.bottomPaddingAnimator(this.inputTextField, 0, dimensionPixelOffset, integer));
        this.attachmentsOffCollapseAnimatorSet.play(UtilsAnimation.sideMarginsAnimator(this.inputTextField, dimensionPixelSize3, dimensionPixelSize3, integer)).with(UtilsAnimation.topPaddingAnimator(this.inputTextField, dimensionPixelSize5, dimensionPixelSize6, integer)).with(UtilsAnimation.minHeightAnimator(this.inputTextField, dimensionPixelSize2, dimensionPixelSize, integer)).with(UtilsAnimation.bottomPaddingAnimator(this.inputTextField, dimensionPixelOffset, 0, integer));
        updateAttachmentButtonPosition();
    }

    private void initListener() {
        this.attachmentsIndicator.setOnClickListener(this);
        this.sendButton.setOnClickListener(this);
        this.inputTextField.addTextChangedListener(this);
        this.inputTextField.setOnEditorActionListener(this);
        this.inputTextField.setOnFocusChangeListener(this);
        addOnLayoutChangeListener(this);
    }

    private boolean isExpanded() {
        return this.inputTextField.getHeight() > this.inputTextField.getResources().getDimensionPixelSize(R$dimen.zs_request_message_composer_collapsed_height);
    }

    private void notifyAddAttachmentsRequested() {
        for (InputListener onAddAttachmentsRequested : this.inputListenerList) {
            onAddAttachmentsRequested.onAddAttachmentsRequested();
        }
    }

    private void notifyOnFocusChangeListeners(View view, boolean z11) {
        for (View.OnFocusChangeListener onFocusChange : this.onFocusChangeListenerList) {
            onFocusChange.onFocusChange(view, z11);
        }
    }

    private void notifySendMessageRequested(String str) {
        for (InputListener onSendMessageRequested : this.inputListenerList) {
            onSendMessageRequested.onSendMessageRequested(str);
        }
    }

    private void updateAttachmentButtonPosition() {
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.zs_request_message_composer_expanded_side_margin);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.zs_request_message_composer_collapsed_side_margin);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.inputTextField.getLayoutParams();
        if (!this.isAttachmentsButtonDisabled) {
            dimensionPixelSize = dimensionPixelSize2;
        }
        layoutParams.leftMargin = dimensionPixelSize;
        this.inputTextField.setLayoutParams(layoutParams);
    }

    private void updateSendBtn(boolean z11, boolean z12) {
        int i11;
        Context context = getContext();
        if (z12) {
            i11 = UiUtils.themeAttributeToColor(R$attr.colorPrimary, context, R$color.zs_request_fallback_color_primary);
        } else {
            i11 = UiUtils.resolveColor(R$color.zs_request_message_composer_send_btn_color_inactive, context);
        }
        int i12 = 0;
        this.sendButton.setEnabled(z11 && z12);
        ImageView imageView = this.sendButton;
        if (!z11) {
            i12 = 4;
        }
        imageView.setVisibility(i12);
        UiUtils.setTint(i11, this.sendButton.getDrawable(), this.sendButton);
    }

    private void viewInit(Context context) {
        FrameLayout.inflate(context, R$layout.zs_view_request_message_composer, this);
        if (!isInEditMode()) {
            bindViews();
            initListener();
            initAnimationsAndAdjustLeftMargin();
            this.stateHelper = new MessageComposerStateHelper();
        }
    }

    public void addListener(InputListener inputListener) {
        this.inputListenerList.add(inputListener);
    }

    public void addOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.onFocusChangeListenerList.add(onFocusChangeListener);
    }

    public void afterTextChanged(Editable editable) {
        triggerStateUpdate();
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            this.inputTextField.clearFocus();
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public void enableAttachmentsButton(boolean z11) {
        this.isAttachmentsButtonDisabled = !z11;
        triggerStateUpdate();
    }

    public void enableSendButton(boolean z11) {
        this.isSendButtonDisabled = !z11;
        triggerStateUpdate();
    }

    public String getMessage() {
        return this.inputTextField.getText().toString();
    }

    public void hide(boolean z11) {
        if (z11) {
            setVisibility(8);
            this.onHeightChangeListener.onHeightChange(0);
            return;
        }
        setVisibility(0);
        requestLayout();
    }

    public void init(ImageStream imageStream2) {
        this.imageStream = imageStream2;
        triggerStateUpdate();
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == this.attachmentsIndicator.getId()) {
            applyState(this.stateHelper.onAttachmentClicked(this.isSendButtonDisabled, this.isAttachmentsButtonDisabled, this.inputTextField, this.imageStream.sh().getInputTrap(), this.attachmentsIndicator));
            notifyAddAttachmentsRequested();
        } else if (view.getId() == this.sendButton.getId()) {
            String trim = this.inputTextField.getText().toString().trim();
            this.inputTextField.setText("");
            this.attachmentsIndicator.reset();
            triggerStateUpdate();
            notifySendMessageRequested(trim);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        if (textView.getId() != this.inputTextField.getId() || i11 != 6) {
            return false;
        }
        this.inputTextField.clearFocus();
        UiUtils.dismissKeyboard((View) this.inputTextField);
        triggerStateUpdate();
        return false;
    }

    public void onFocusChange(View view, boolean z11) {
        if (view.getId() == this.inputTextField.getId()) {
            notifyOnFocusChangeListeners(view, z11);
            triggerStateUpdate();
        }
    }

    public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        OnHeightChangeListener onHeightChangeListener2;
        int i19 = i14 - i12;
        if (i19 != i18 - i16 && (onHeightChangeListener2 = this.onHeightChangeListener) != null) {
            onHeightChangeListener2.onHeightChange(i19);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void removeAllListener() {
        this.inputListenerList.clear();
    }

    public void requestFocusForInput() {
        this.inputTextField.requestFocus();
    }

    public void setAttachmentsCount(int i11) {
        this.attachmentsIndicator.setAttachmentsCount(i11);
        triggerStateUpdate();
    }

    public void setOnHeightChangeListener(OnHeightChangeListener onHeightChangeListener2) {
        this.onHeightChangeListener = onHeightChangeListener2;
    }

    public void triggerStateUpdate() {
        ImageStream imageStream2 = this.imageStream;
        if (imageStream2 != null) {
            applyState(this.stateHelper.getState(this.inputTextField, imageStream2.sh().getInputTrap(), this.attachmentsIndicator, this.imageStream.uh(), this.isSendButtonDisabled, this.isAttachmentsButtonDisabled));
        }
    }

    public ViewMessageComposer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        viewInit(context);
    }

    public ViewMessageComposer(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        viewInit(context);
    }

    public ViewMessageComposer(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        viewInit(context);
    }

    public ViewMessageComposer(Context context, ViewAttachmentsIndicator viewAttachmentsIndicator, EditText editText, ImageView imageView, AnimatorSet animatorSet, AnimatorSet animatorSet2, AnimatorSet animatorSet3, AnimatorSet animatorSet4) {
        super(context);
        this.attachmentsIndicator = viewAttachmentsIndicator;
        this.inputTextField = editText;
        this.sendButton = imageView;
        this.attachmentsOnExpandAnimatorSet = animatorSet;
        this.attachmentsOffExpandAnimatorSet = animatorSet3;
        this.attachmentsOnCollapseAnimatorSet = animatorSet2;
        this.attachmentsOffCollapseAnimatorSet = animatorSet4;
        this.stateHelper = new MessageComposerStateHelper();
    }
}
