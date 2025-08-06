package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class ToggleImageButton extends ImageButton {
    private static final int[] STATE_TOGGLED_ON = {R.attr.state_toggled_on};
    public String contentDescriptionOff;
    public String contentDescriptionOn;
    public boolean isToggledOn;
    public final boolean toggleOnClick;

    public ToggleImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean isToggledOn() {
        return this.isToggledOn;
    }

    public int[] onCreateDrawableState(int i11) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i11 + 2);
        if (this.isToggledOn) {
            ImageButton.mergeDrawableStates(onCreateDrawableState, STATE_TOGGLED_ON);
        }
        return onCreateDrawableState;
    }

    public boolean performClick() {
        if (this.toggleOnClick) {
            toggle();
        }
        return super.performClick();
    }

    public void setToggledOn(boolean z11) {
        this.isToggledOn = z11;
        setContentDescription(z11 ? this.contentDescriptionOn : this.contentDescriptionOff);
        refreshDrawableState();
    }

    public void toggle() {
        setToggledOn(!this.isToggledOn);
    }

    public ToggleImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: type inference failed for: r4v8, types: [java.lang.CharSequence] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ToggleImageButton(android.content.Context r4, android.util.AttributeSet r5, int r6) {
        /*
            r3 = this;
            r3.<init>(r4, r5, r6)
            r0 = 0
            android.content.res.Resources$Theme r4 = r4.getTheme()     // Catch:{ all -> 0x0040 }
            int[] r1 = com.twitter.sdk.android.tweetui.R.styleable.ToggleImageButton     // Catch:{ all -> 0x0040 }
            r2 = 0
            android.content.res.TypedArray r0 = r4.obtainStyledAttributes(r5, r1, r6, r2)     // Catch:{ all -> 0x0040 }
            int r4 = com.twitter.sdk.android.tweetui.R.styleable.ToggleImageButton_contentDescriptionOn     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0040 }
            int r5 = com.twitter.sdk.android.tweetui.R.styleable.ToggleImageButton_contentDescriptionOff     // Catch:{ all -> 0x0040 }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ all -> 0x0040 }
            if (r4 != 0) goto L_0x0023
            java.lang.CharSequence r4 = r3.getContentDescription()     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0040 }
        L_0x0023:
            r3.contentDescriptionOn = r4     // Catch:{ all -> 0x0040 }
            if (r5 != 0) goto L_0x002e
            java.lang.CharSequence r4 = r3.getContentDescription()     // Catch:{ all -> 0x0040 }
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0040 }
        L_0x002e:
            r3.contentDescriptionOff = r5     // Catch:{ all -> 0x0040 }
            int r4 = com.twitter.sdk.android.tweetui.R.styleable.ToggleImageButton_toggleOnClick     // Catch:{ all -> 0x0040 }
            r5 = 1
            boolean r4 = r0.getBoolean(r4, r5)     // Catch:{ all -> 0x0040 }
            r3.toggleOnClick = r4     // Catch:{ all -> 0x0040 }
            r3.setToggledOn(r2)     // Catch:{ all -> 0x0040 }
            r0.recycle()
            return
        L_0x0040:
            r4 = move-exception
            if (r0 == 0) goto L_0x0046
            r0.recycle()
        L_0x0046:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.ToggleImageButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
