package com.twitter.sdk.android.core.identity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.R;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.CommonUtils;
import java.lang.ref.WeakReference;

public class TwitterLoginButton extends Button {
    public static final String ERROR_MSG_NO_ACTIVITY = "TwitterLoginButton requires an activity. Override getActivity to provide the activity for this button.";
    public static final String TAG = "Twitter";
    public final WeakReference<Activity> activityRef;
    public volatile TwitterAuthClient authClient;
    public Callback<TwitterSession> callback;
    public View.OnClickListener onClickListener;

    public class LoginClickListener implements View.OnClickListener {
        private LoginClickListener() {
        }

        private void checkActivity(Activity activity) {
            if (activity == null || activity.isFinishing()) {
                CommonUtils.logOrThrowIllegalStateException("Twitter", TwitterLoginButton.ERROR_MSG_NO_ACTIVITY);
            }
        }

        private void checkCallback(Callback callback) {
            if (callback == null) {
                CommonUtils.logOrThrowIllegalStateException("Twitter", "Callback must not be null, did you call setCallback?");
            }
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            checkCallback(TwitterLoginButton.this.callback);
            checkActivity((Activity) TwitterLoginButton.this.activityRef.get());
            TwitterLoginButton.this.getTwitterAuthClient().authorize((Activity) TwitterLoginButton.this.activityRef.get(), TwitterLoginButton.this.callback);
            View.OnClickListener onClickListener = TwitterLoginButton.this.onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public TwitterLoginButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private void checkTwitterCoreAndEnable() {
        if (!isInEditMode()) {
            try {
                TwitterCore.getInstance();
            } catch (IllegalStateException e11) {
                Twitter.getLogger().e("Twitter", e11.getMessage());
                setEnabled(false);
            }
        }
    }

    @TargetApi(21)
    private void setupButton() {
        Resources resources = getResources();
        super.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.tw__ic_logo_default), (Drawable) null, (Drawable) null, (Drawable) null);
        super.setCompoundDrawablePadding(resources.getDimensionPixelSize(R.dimen.tw__login_btn_drawable_padding));
        super.setText(R.string.tw__login_btn_txt);
        super.setTextColor(resources.getColor(R.color.tw__solid_white));
        super.setTextSize(0, (float) resources.getDimensionPixelSize(R.dimen.tw__login_btn_text_size));
        super.setTypeface(Typeface.DEFAULT_BOLD);
        super.setPadding(resources.getDimensionPixelSize(R.dimen.tw__login_btn_left_padding), 0, resources.getDimensionPixelSize(R.dimen.tw__login_btn_right_padding), 0);
        super.setBackgroundResource(R.drawable.tw__login_btn);
        super.setOnClickListener(new LoginClickListener());
        if (Build.VERSION.SDK_INT >= 21) {
            super.setAllCaps(false);
        }
    }

    public Activity getActivity() {
        if ((getContext() instanceof ContextThemeWrapper) && (((ContextThemeWrapper) getContext()).getBaseContext() instanceof Activity)) {
            return (Activity) ((ContextThemeWrapper) getContext()).getBaseContext();
        }
        if (getContext() instanceof Activity) {
            return (Activity) getContext();
        }
        if (isInEditMode()) {
            return null;
        }
        throw new IllegalStateException(ERROR_MSG_NO_ACTIVITY);
    }

    public Callback<TwitterSession> getCallback() {
        return this.callback;
    }

    public TwitterAuthClient getTwitterAuthClient() {
        if (this.authClient == null) {
            synchronized (TwitterLoginButton.class) {
                if (this.authClient == null) {
                    this.authClient = new TwitterAuthClient();
                }
            }
        }
        return this.authClient;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        if (i11 == getTwitterAuthClient().getRequestCode()) {
            getTwitterAuthClient().onActivityResult(i11, i12, intent);
        }
    }

    public void setCallback(Callback<TwitterSession> callback2) {
        if (callback2 != null) {
            this.callback = callback2;
            return;
        }
        throw new IllegalArgumentException("Callback cannot be null");
    }

    public void setOnClickListener(View.OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
    }

    public TwitterLoginButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842824);
    }

    public TwitterLoginButton(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, (TwitterAuthClient) null);
    }

    public TwitterLoginButton(Context context, AttributeSet attributeSet, int i11, TwitterAuthClient twitterAuthClient) {
        super(context, attributeSet, i11);
        this.activityRef = new WeakReference<>(getActivity());
        this.authClient = twitterAuthClient;
        setupButton();
        checkTwitterCoreAndEnable();
    }
}
