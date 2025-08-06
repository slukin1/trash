package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.login.R;

public class ProfilePictureView extends FrameLayout {
    private static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
    private static final String BITMAP_KEY = "ProfilePictureView_bitmap";
    private static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
    public static final int CUSTOM = -1;
    private static final boolean IS_CROPPED_DEFAULT_VALUE = true;
    private static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
    public static final int LARGE = -4;
    private static final int MIN_SIZE = 1;
    public static final int NORMAL = -3;
    private static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
    private static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
    private static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
    public static final int SMALL = -2;
    private static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
    public static final String TAG = ProfilePictureView.class.getSimpleName();
    private Bitmap customizedDefaultProfilePicture = null;
    private ImageView image;
    private Bitmap imageContents;
    private boolean isCropped = true;
    private ImageRequest lastRequest;
    private OnErrorListener onErrorListener;
    private int presetSizeType = -1;
    private String profileId;
    private int queryHeight = 0;
    private int queryWidth = 0;

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public ProfilePictureView(Context context) {
        super(context);
        initialize(context);
    }

    private int getPresetSizeInPixels(boolean z11) {
        int i11;
        int i12 = this.presetSizeType;
        if (i12 == -4) {
            i11 = R.dimen.com_facebook_profilepictureview_preset_size_large;
        } else if (i12 == -3) {
            i11 = R.dimen.com_facebook_profilepictureview_preset_size_normal;
        } else if (i12 == -2) {
            i11 = R.dimen.com_facebook_profilepictureview_preset_size_small;
        } else if (i12 != -1 || !z11) {
            return 0;
        } else {
            i11 = R.dimen.com_facebook_profilepictureview_preset_size_normal;
        }
        return getResources().getDimensionPixelSize(i11);
    }

    private void initialize(Context context) {
        removeAllViews();
        this.image = new ImageView(context);
        this.image.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        addView(this.image);
    }

    private void parseAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_profile_picture_view);
        setPresetSize(obtainStyledAttributes.getInt(R.styleable.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
        this.isCropped = obtainStyledAttributes.getBoolean(R.styleable.com_facebook_profile_picture_view_com_facebook_is_cropped, true);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: private */
    public void processResponse(ImageResponse imageResponse) {
        if (imageResponse.getRequest() == this.lastRequest) {
            this.lastRequest = null;
            Bitmap bitmap = imageResponse.getBitmap();
            Exception error = imageResponse.getError();
            if (error != null) {
                OnErrorListener onErrorListener2 = this.onErrorListener;
                if (onErrorListener2 != null) {
                    onErrorListener2.onError(new FacebookException("Error in downloading profile picture for profileId: " + getProfileId(), (Throwable) error));
                    return;
                }
                Logger.log(LoggingBehavior.REQUESTS, 6, TAG, error.toString());
            } else if (bitmap != null) {
                setImageBitmap(bitmap);
                if (imageResponse.isCachedRedirect()) {
                    sendImageRequest(false);
                }
            }
        }
    }

    private void refreshImage(boolean z11) {
        boolean updateImageQueryParameters = updateImageQueryParameters();
        String str = this.profileId;
        if (str == null || str.length() == 0 || (this.queryWidth == 0 && this.queryHeight == 0)) {
            setBlankProfilePicture();
        } else if (updateImageQueryParameters || z11) {
            sendImageRequest(true);
        }
    }

    private void sendImageRequest(boolean z11) {
        ImageRequest build = new ImageRequest.Builder(getContext(), ImageRequest.getProfilePictureUri(this.profileId, this.queryWidth, this.queryHeight, AccessToken.isCurrentAccessTokenActive() ? AccessToken.getCurrentAccessToken().getToken() : "")).setAllowCachedRedirects(z11).setCallerTag(this).setCallback(new ImageRequest.Callback() {
            public void onCompleted(ImageResponse imageResponse) {
                ProfilePictureView.this.processResponse(imageResponse);
            }
        }).build();
        ImageRequest imageRequest = this.lastRequest;
        if (imageRequest != null) {
            ImageDownloader.cancelRequest(imageRequest);
        }
        this.lastRequest = build;
        ImageDownloader.downloadAsync(build);
    }

    private void setBlankProfilePicture() {
        ImageRequest imageRequest = this.lastRequest;
        if (imageRequest != null) {
            ImageDownloader.cancelRequest(imageRequest);
        }
        if (this.customizedDefaultProfilePicture == null) {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), isCropped() ? R.drawable.com_facebook_profile_picture_blank_square : R.drawable.com_facebook_profile_picture_blank_portrait));
            return;
        }
        updateImageQueryParameters();
        setImageBitmap(Bitmap.createScaledBitmap(this.customizedDefaultProfilePicture, this.queryWidth, this.queryHeight, false));
    }

    private void setImageBitmap(Bitmap bitmap) {
        ImageView imageView = this.image;
        if (imageView != null && bitmap != null) {
            this.imageContents = bitmap;
            imageView.setImageBitmap(bitmap);
        }
    }

    private boolean updateImageQueryParameters() {
        int height = getHeight();
        int width = getWidth();
        boolean z11 = true;
        if (width < 1 || height < 1) {
            return false;
        }
        int presetSizeInPixels = getPresetSizeInPixels(false);
        if (presetSizeInPixels != 0) {
            height = presetSizeInPixels;
            width = height;
        }
        if (width <= height) {
            height = isCropped() ? width : 0;
        } else {
            width = isCropped() ? height : 0;
        }
        if (width == this.queryWidth && height == this.queryHeight) {
            z11 = false;
        }
        this.queryWidth = width;
        this.queryHeight = height;
        return z11;
    }

    public final OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final int getPresetSize() {
        return this.presetSizeType;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final boolean isCropped() {
        return this.isCropped;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lastRequest = null;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        refreshImage(false);
    }

    public void onMeasure(int i11, int i12) {
        boolean z11;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int size = View.MeasureSpec.getSize(i12);
        int size2 = View.MeasureSpec.getSize(i11);
        boolean z12 = true;
        if (View.MeasureSpec.getMode(i12) == 1073741824 || layoutParams.height != -2) {
            z11 = false;
        } else {
            size = getPresetSizeInPixels(true);
            i12 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            z11 = true;
        }
        if (View.MeasureSpec.getMode(i11) == 1073741824 || layoutParams.width != -2) {
            z12 = z11;
        } else {
            size2 = getPresetSizeInPixels(true);
            i11 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        }
        if (z12) {
            setMeasuredDimension(size2, size);
            measureChildren(i11, i12);
            return;
        }
        super.onMeasure(i11, i12);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(SUPER_STATE_KEY));
        this.profileId = bundle.getString(PROFILE_ID_KEY);
        this.presetSizeType = bundle.getInt(PRESET_SIZE_KEY);
        this.isCropped = bundle.getBoolean(IS_CROPPED_KEY);
        this.queryWidth = bundle.getInt(BITMAP_WIDTH_KEY);
        this.queryHeight = bundle.getInt(BITMAP_HEIGHT_KEY);
        refreshImage(true);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE_KEY, onSaveInstanceState);
        bundle.putString(PROFILE_ID_KEY, this.profileId);
        bundle.putInt(PRESET_SIZE_KEY, this.presetSizeType);
        bundle.putBoolean(IS_CROPPED_KEY, this.isCropped);
        bundle.putInt(BITMAP_WIDTH_KEY, this.queryWidth);
        bundle.putInt(BITMAP_HEIGHT_KEY, this.queryHeight);
        bundle.putBoolean(PENDING_REFRESH_KEY, this.lastRequest != null);
        return bundle;
    }

    public final void setCropped(boolean z11) {
        this.isCropped = z11;
        refreshImage(false);
    }

    public final void setDefaultProfilePicture(Bitmap bitmap) {
        this.customizedDefaultProfilePicture = bitmap;
    }

    public final void setOnErrorListener(OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    public final void setPresetSize(int i11) {
        if (i11 == -4 || i11 == -3 || i11 == -2 || i11 == -1) {
            this.presetSizeType = i11;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Must use a predefined preset size");
    }

    public final void setProfileId(String str) {
        boolean z11;
        if (Utility.isNullOrEmpty(this.profileId) || !this.profileId.equalsIgnoreCase(str)) {
            setBlankProfilePicture();
            z11 = true;
        } else {
            z11 = false;
        }
        this.profileId = str;
        refreshImage(z11);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
        parseAttributes(attributeSet);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initialize(context);
        parseAttributes(attributeSet);
    }
}
