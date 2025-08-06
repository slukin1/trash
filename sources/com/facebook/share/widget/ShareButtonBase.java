package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public abstract class ShareButtonBase extends FacebookButtonBase {
    private boolean enabledExplicitlySet = false;
    private int requestCode = 0;
    private ShareContent shareContent;

    public ShareButtonBase(Context context, AttributeSet attributeSet, int i11, String str, String str2) {
        super(context, attributeSet, i11, 0, str, str2);
        this.requestCode = isInEditMode() ? 0 : getDefaultRequestCode();
        internalSetEnabled(false);
    }

    private void internalSetEnabled(boolean z11) {
        setEnabled(z11);
        this.enabledExplicitlySet = false;
    }

    public boolean canShare() {
        return getDialog().canShow(getShareContent());
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i11, int i12) {
        super.configureButton(context, attributeSet, i11, i12);
        setInternalOnClickListener(getShareOnClickListener());
    }

    public abstract FacebookDialogBase<ShareContent, Sharer.Result> getDialog();

    public int getRequestCode() {
        return this.requestCode;
    }

    public ShareContent getShareContent() {
        return this.shareContent;
    }

    public View.OnClickListener getShareOnClickListener() {
        return new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ShareButtonBase.this.callExternalOnClickListener(view);
                ShareButtonBase.this.getDialog().show(ShareButtonBase.this.getShareContent());
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        };
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<Sharer.Result> facebookCallback) {
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManager, facebookCallback);
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        this.enabledExplicitlySet = true;
    }

    public void setRequestCode(int i11) {
        if (!FacebookSdk.isFacebookRequestCode(i11)) {
            this.requestCode = i11;
            return;
        }
        throw new IllegalArgumentException("Request code " + i11 + " cannot be within the range reserved by the Facebook SDK.");
    }

    public void setShareContent(ShareContent shareContent2) {
        this.shareContent = shareContent2;
        if (!this.enabledExplicitlySet) {
            internalSetEnabled(canShare());
        }
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<Sharer.Result> facebookCallback, int i11) {
        setRequestCode(i11);
        registerCallback(callbackManager, facebookCallback);
    }
}
