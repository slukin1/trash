package com.sumsub.sns.internal.core.analytics;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/sumsub/sns/internal/core/analytics/Control;", "", "Lcom/sumsub/sns/internal/core/analytics/m;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "DoneButton", "SkipButton", "NextButton", "CancelButton", "ConfirmButton", "CloseButton", "StartButton", "ContinueButton", "RotateButton", "AcceptButton", "RetakeButton", "RetryButton", "GoBackButton", "DismissButton", "InfoButton", "BottomSheet", "ListItem", "ChangeButton", "AutocaptureSegmentedControl", "EidChangeTransportPinButton", "EidProceedToIdentButton", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum Control implements m {
    DoneButton("doneButton"),
    SkipButton("skipButton"),
    NextButton("nextButton"),
    CancelButton("cancelButton"),
    ConfirmButton("confirmButton"),
    CloseButton("closeButton"),
    StartButton("startButton"),
    ContinueButton("continueButton"),
    RotateButton("rotateButton"),
    AcceptButton("acceptButton"),
    RetakeButton("retakeButton"),
    RetryButton("retryButton"),
    GoBackButton("goBackButton"),
    DismissButton("dismissButton"),
    InfoButton("infoButton"),
    BottomSheet("bottomSheet"),
    ListItem("listItem"),
    ChangeButton("changeButton"),
    AutocaptureSegmentedControl("autocaptureSegmentedControl"),
    EidChangeTransportPinButton("eidChangeTransportPinButton"),
    EidProceedToIdentButton("eidProceedToIdentButton");
    
    private final String text;

    private Control(String str) {
        this.text = str;
    }

    public String getText() {
        return this.text;
    }
}
