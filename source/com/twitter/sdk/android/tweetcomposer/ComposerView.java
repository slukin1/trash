package com.twitter.sdk.android.tweetcomposer;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.internal.UserUtils;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetcomposer.ComposerController;
import com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView;
import java.util.Locale;

public class ComposerView extends LinearLayout {
    public ImageView avatarView;
    public ComposerController.ComposerCallbacks callbacks;
    public TextView charCountView;
    public ImageView closeView;
    public View divider;
    private Picasso imageLoader;
    public ImageView imageView;
    public ColorDrawable mediaBg;
    public ObservableScrollView scrollView;
    public Button tweetButton;
    public EditText tweetEditView;

    public ComposerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init(Context context) {
        this.imageLoader = Picasso.with(getContext());
        this.mediaBg = new ColorDrawable(context.getResources().getColor(R.color.tw__composer_light_gray));
        LinearLayout.inflate(context, R.layout.tw__composer_view, this);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$onFinishInflate$0(View view) {
        this.callbacks.onCloseClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$onFinishInflate$1(View view) {
        this.callbacks.onTweetPost(getTweetText());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onFinishInflate$2(TextView textView, int i11, KeyEvent keyEvent) {
        this.callbacks.onTweetPost(getTweetText());
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onFinishInflate$3(int i11) {
        if (i11 > 0) {
            this.divider.setVisibility(0);
        } else {
            this.divider.setVisibility(4);
        }
    }

    public void findSubviews() {
        this.avatarView = (ImageView) findViewById(R.id.tw__author_avatar);
        this.closeView = (ImageView) findViewById(R.id.tw__composer_close);
        this.tweetEditView = (EditText) findViewById(R.id.tw__edit_tweet);
        this.charCountView = (TextView) findViewById(R.id.tw__char_count);
        this.tweetButton = (Button) findViewById(R.id.tw__post_tweet);
        this.scrollView = (ObservableScrollView) findViewById(R.id.tw__composer_scroll_view);
        this.divider = findViewById(R.id.tw__composer_profile_divider);
        this.imageView = (ImageView) findViewById(R.id.tw__image_view);
    }

    public String getTweetText() {
        return this.tweetEditView.getText().toString();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        findSubviews();
        this.closeView.setOnClickListener(new b(this));
        this.tweetButton.setOnClickListener(new a(this));
        this.tweetEditView.setOnEditorActionListener(new c(this));
        this.tweetEditView.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                ComposerView composerView = ComposerView.this;
                composerView.callbacks.onTextChanged(composerView.getTweetText());
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.scrollView.setScrollViewListener(new d(this));
    }

    public void postTweetEnabled(boolean z11) {
        this.tweetButton.setEnabled(z11);
    }

    public void setCallbacks(ComposerController.ComposerCallbacks composerCallbacks) {
        this.callbacks = composerCallbacks;
    }

    public void setCharCount(int i11) {
        this.charCountView.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i11)}));
    }

    public void setCharCountTextStyle(int i11) {
        this.charCountView.setTextAppearance(getContext(), i11);
    }

    public void setImageView(Uri uri) {
        if (this.imageLoader != null) {
            this.imageView.setVisibility(0);
            this.imageLoader.j(uri).g(this.imageView);
        }
    }

    public void setProfilePhotoView(User user) {
        String profileImageUrlHttps = UserUtils.getProfileImageUrlHttps(user, UserUtils.AvatarSize.REASONABLY_SMALL);
        Picasso picasso = this.imageLoader;
        if (picasso != null) {
            picasso.l(profileImageUrlHttps).l(this.mediaBg).g(this.avatarView);
        }
    }

    public void setTweetText(String str) {
        this.tweetEditView.setText(str);
    }

    public ComposerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ComposerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
