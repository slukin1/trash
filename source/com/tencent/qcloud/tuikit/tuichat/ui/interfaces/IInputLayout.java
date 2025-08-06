package com.tencent.qcloud.tuikit.tuichat.ui.interfaces;

import android.view.View;
import android.widget.EditText;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.BaseInputFragment;

public interface IInputLayout {
    void ableSendPrimeAction(boolean z11, String str);

    void addAction(InputMoreActionUnit inputMoreActionUnit);

    void disableAudioInput(boolean z11);

    void disableCaptureAction(boolean z11);

    void disableEmojiInput(boolean z11);

    void disableMoreInput(boolean z11);

    void disableSendFileAction(boolean z11);

    void disableSendPhotoAction(boolean z11);

    void disableVideoRecordAction(boolean z11);

    EditText getInputText();

    void replaceMoreInput(View.OnClickListener onClickListener);

    void replaceMoreInput(BaseInputFragment baseInputFragment);
}
