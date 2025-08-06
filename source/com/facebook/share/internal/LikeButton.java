package com.facebook.share.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import c.a;
import com.facebook.FacebookButtonBase;
import com.facebook.common.R;
import com.facebook.internal.AnalyticsEvents;

@Deprecated
public class LikeButton extends FacebookButtonBase {
    @Deprecated
    public LikeButton(Context context, boolean z11) {
        super(context, (AttributeSet) null, 0, 0, AnalyticsEvents.EVENT_LIKE_BUTTON_CREATE, AnalyticsEvents.EVENT_LIKE_BUTTON_DID_TAP);
        setSelected(z11);
    }

    private void updateForLikeStatus() {
        if (isSelected()) {
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_facebook_button_like_icon_selected, 0, 0, 0);
            setText(getResources().getString(R.string.com_facebook_like_button_liked));
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(a.b(getContext(), R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        setText(getResources().getString(R.string.com_facebook_like_button_not_liked));
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i11, int i12) {
        super.configureButton(context, attributeSet, i11, i12);
        updateForLikeStatus();
    }

    public int getDefaultRequestCode() {
        return 0;
    }

    public int getDefaultStyleResource() {
        return R.style.com_facebook_button_like;
    }

    @Deprecated
    public void setSelected(boolean z11) {
        super.setSelected(z11);
        updateForLikeStatus();
    }
}
