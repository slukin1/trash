package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.DeviceShareDialog;
import com.facebook.share.R;
import com.facebook.share.model.ShareContent;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public final class DeviceShareButton extends FacebookButtonBase {
    private DeviceShareDialog dialog;
    private boolean enabledExplicitlySet;
    private int requestCode;
    private ShareContent shareContent;

    public DeviceShareButton(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private boolean canShare() {
        return new DeviceShareDialog(getActivity()).canShow(getShareContent());
    }

    /* access modifiers changed from: private */
    public DeviceShareDialog getDialog() {
        DeviceShareDialog deviceShareDialog = this.dialog;
        if (deviceShareDialog != null) {
            return deviceShareDialog;
        }
        if (getFragment() != null) {
            this.dialog = new DeviceShareDialog(getFragment());
        } else if (getNativeFragment() != null) {
            this.dialog = new DeviceShareDialog(getNativeFragment());
        } else {
            this.dialog = new DeviceShareDialog(getActivity());
        }
        return this.dialog;
    }

    private void internalSetEnabled(boolean z11) {
        setEnabled(z11);
        this.enabledExplicitlySet = false;
    }

    private void setRequestCode(int i11) {
        if (!FacebookSdk.isFacebookRequestCode(i11)) {
            this.requestCode = i11;
            return;
        }
        throw new IllegalArgumentException("Request code " + i11 + " cannot be within the range reserved by the Facebook SDK.");
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i11, int i12) {
        super.configureButton(context, attributeSet, i11, i12);
        setInternalOnClickListener(getShareOnClickListener());
    }

    public int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    }

    public int getDefaultStyleResource() {
        return R.style.com_facebook_button_share;
    }

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
                DeviceShareButton.this.callExternalOnClickListener(view);
                DeviceShareButton.this.getDialog().show(DeviceShareButton.this.getShareContent());
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        };
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<DeviceShareDialog.Result> facebookCallback) {
        getDialog().registerCallback(callbackManager, facebookCallback);
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        this.enabledExplicitlySet = true;
    }

    public void setShareContent(ShareContent shareContent2) {
        this.shareContent = shareContent2;
        if (!this.enabledExplicitlySet) {
            internalSetEnabled(canShare());
        }
    }

    public DeviceShareButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<DeviceShareDialog.Result> facebookCallback, int i11) {
        setRequestCode(i11);
        getDialog().registerCallback(callbackManager, facebookCallback, i11);
    }

    private DeviceShareButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11, 0, AnalyticsEvents.EVENT_DEVICE_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_DEVICE_SHARE_BUTTON_DID_TAP);
        this.requestCode = 0;
        this.enabledExplicitlySet = false;
        this.dialog = null;
        this.requestCode = isInEditMode() ? 0 : getDefaultRequestCode();
        internalSetEnabled(false);
    }
}
