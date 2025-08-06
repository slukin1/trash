package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import c.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.statusbar.ImmersiveManager;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class UCropActivity extends AppCompatActivity {
    public static final int ALL = 3;
    private static final long CONTROLS_ANIMATION_DURATION = 50;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    private static final String TAG = "UCropActivity";
    private boolean isForbidCropGifWebp;
    private boolean isUseCustomBitmap;
    private int mActiveControlsWidgetColor;
    private int[] mAllowedGestures = {1, 2, 3};
    /* access modifiers changed from: private */
    public View mBlockingView;
    private Bitmap.CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    private int mCompressQuality = 90;
    private Transition mControlsTransition;
    /* access modifiers changed from: private */
    public List<ViewGroup> mCropAspectRatioViews = new ArrayList();
    /* access modifiers changed from: private */
    public GestureCropImageView mGestureCropImageView;
    private TransformImageView.TransformImageListener mImageListener = new TransformImageView.TransformImageListener() {
        public void onLoadComplete() {
            UCropActivity.this.mUCropView.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.mBlockingView.setClickable(false);
            if (UCropActivity.this.getIntent().getBooleanExtra(UCrop.Options.EXTRA_CROP_FORBID_GIF_WEBP, false)) {
                String mimeTypeFromMediaContentUri = FileUtils.getMimeTypeFromMediaContentUri(UCropActivity.this, (Uri) UCropActivity.this.getIntent().getParcelableExtra(UCrop.EXTRA_INPUT_URI));
                if (FileUtils.isGif(mimeTypeFromMediaContentUri) || FileUtils.isWebp(mimeTypeFromMediaContentUri)) {
                    UCropActivity.this.mBlockingView.setClickable(true);
                }
            }
            boolean unused = UCropActivity.this.mShowLoader = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        public void onLoadFailure(Exception exc) {
            UCropActivity.this.setResultError(exc);
            UCropActivity.this.finish();
        }

        public void onRotate(float f11) {
            UCropActivity.this.setAngleText(f11);
        }

        public void onScale(float f11) {
            UCropActivity.this.setScaleText(f11);
        }
    };
    private ViewGroup mLayoutAspectRatio;
    private ViewGroup mLayoutRotate;
    private ViewGroup mLayoutScale;
    private int mLogoColor;
    private OverlayView mOverlayView;
    private int mRootViewBackgroundColor;
    private boolean mShowBottomControls;
    /* access modifiers changed from: private */
    public boolean mShowLoader = true;
    private final View.OnClickListener mStateClickListener = new View.OnClickListener() {
        @SensorsDataInstrumented
        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropActivity.this.setWidgetState(view.getId());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    };
    private int mStatusBarColor;
    private TextView mTextViewRotateAngle;
    private TextView mTextViewScalePercent;
    private int mToolbarCancelDrawable;
    private int mToolbarColor;
    private int mToolbarCropDrawable;
    private String mToolbarTitle;
    private int mToolbarTitleSize;
    private int mToolbarWidgetColor;
    /* access modifiers changed from: private */
    public UCropView mUCropView;
    private ViewGroup mWrapperStateAspectRatio;
    private ViewGroup mWrapperStateRotate;
    private ViewGroup mWrapperStateScale;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    static {
        AppCompatDelegate.I(true);
    }

    private void addBlockingView() {
        if (this.mBlockingView == null) {
            this.mBlockingView = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.mBlockingView.setLayoutParams(layoutParams);
            this.mBlockingView.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
    }

    private void changeSelectedTab(int i11) {
        TransitionManager.b((ViewGroup) findViewById(R.id.ucrop_photobox), this.mControlsTransition);
        int i12 = 0;
        this.mWrapperStateScale.findViewById(R.id.text_view_scale).setVisibility(i11 == R.id.state_scale ? 0 : 8);
        this.mWrapperStateAspectRatio.findViewById(R.id.text_view_crop).setVisibility(i11 == R.id.state_aspect_ratio ? 0 : 8);
        View findViewById = this.mWrapperStateRotate.findViewById(R.id.text_view_rotate);
        if (i11 != R.id.state_rotate) {
            i12 = 8;
        }
        findViewById.setVisibility(i12);
    }

    private void immersive() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(UCrop.Options.EXTRA_DARK_STATUS_BAR_BLACK, false);
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.mStatusBarColor = intExtra;
        ImmersiveManager.immersiveAboveAPI23(this, intExtra, intExtra, booleanExtra);
    }

    private void initiateRootViews() {
        UCropView uCropView = (UCropView) findViewById(R.id.ucrop);
        this.mUCropView = uCropView;
        this.mGestureCropImageView = uCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
        int i11 = R.id.ucrop_frame;
        findViewById(i11).setBackgroundColor(this.mRootViewBackgroundColor);
        if (!this.mShowBottomControls) {
            ((RelativeLayout.LayoutParams) findViewById(i11).getLayoutParams()).bottomMargin = 0;
            findViewById(i11).requestLayout();
        }
    }

    private void processOptions(Intent intent) {
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_COMPRESSION_FORMAT_NAME);
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (valueOf == null) {
            valueOf = DEFAULT_COMPRESS_FORMAT;
        }
        this.mCompressFormat = valueOf;
        this.mCompressQuality = intent.getIntExtra(UCrop.Options.EXTRA_COMPRESSION_QUALITY, 90);
        int[] intArrayExtra = intent.getIntArrayExtra(UCrop.Options.EXTRA_ALLOWED_GESTURES);
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.mAllowedGestures = intArrayExtra;
        }
        this.isUseCustomBitmap = intent.getBooleanExtra(UCrop.Options.EXTRA_CROP_CUSTOM_LOADER_BITMAP, false);
        this.mGestureCropImageView.setMaxBitmapSize(intent.getIntExtra(UCrop.Options.EXTRA_MAX_BITMAP_SIZE, 0));
        this.mGestureCropImageView.setMaxScaleMultiplier(intent.getFloatExtra(UCrop.Options.EXTRA_MAX_SCALE_MULTIPLIER, 10.0f));
        this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration((long) intent.getIntExtra(UCrop.Options.EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 500));
        this.mOverlayView.setFreestyleCropEnabled(intent.getBooleanExtra(UCrop.Options.EXTRA_FREE_STYLE_CROP, false));
        this.mOverlayView.setDragSmoothToCenter(intent.getBooleanExtra(UCrop.Options.EXTRA_CROP_DRAG_CENTER, false));
        OverlayView overlayView = this.mOverlayView;
        Resources resources = getResources();
        int i11 = R.color.ucrop_color_default_dimmed;
        overlayView.setDimmedColor(intent.getIntExtra(UCrop.Options.EXTRA_DIMMED_LAYER_COLOR, resources.getColor(i11)));
        this.mOverlayView.setCircleStrokeColor(intent.getIntExtra(UCrop.Options.EXTRA_CIRCLE_STROKE_COLOR, getResources().getColor(i11)));
        this.mOverlayView.setCircleDimmedLayer(intent.getBooleanExtra(UCrop.Options.EXTRA_CIRCLE_DIMMED_LAYER, false));
        this.mOverlayView.setShowCropFrame(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_FRAME, true));
        this.mOverlayView.setCropFrameColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.mOverlayView.setCropFrameStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.mOverlayView.setShowCropGrid(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_GRID, true));
        this.mOverlayView.setCropGridRowCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_ROW_COUNT, 2));
        this.mOverlayView.setCropGridColumnCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLUMN_COUNT, 2));
        this.mOverlayView.setCropGridColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        OverlayView overlayView2 = this.mOverlayView;
        Resources resources2 = getResources();
        int i12 = R.dimen.ucrop_default_crop_grid_stoke_width;
        overlayView2.setCropGridStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_STROKE_WIDTH, resources2.getDimensionPixelSize(i12)));
        this.mOverlayView.setDimmedStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CIRCLE_STROKE_WIDTH_LAYER, getResources().getDimensionPixelSize(i12)));
        float floatExtra = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_X, -1.0f);
        float floatExtra2 = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_Y, -1.0f);
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        float f11 = 0.0f;
        if (floatExtra >= 0.0f && floatExtra2 >= 0.0f) {
            ViewGroup viewGroup = this.mWrapperStateAspectRatio;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            float f12 = floatExtra / floatExtra2;
            GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
            if (!Float.isNaN(f12)) {
                f11 = f12;
            }
            gestureCropImageView.setTargetAspectRatio(f11);
        } else if (parcelableArrayListExtra == null || intExtra >= parcelableArrayListExtra.size()) {
            this.mGestureCropImageView.setTargetAspectRatio(0.0f);
        } else {
            float aspectRatioX = ((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioX() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioY();
            GestureCropImageView gestureCropImageView2 = this.mGestureCropImageView;
            if (!Float.isNaN(aspectRatioX)) {
                f11 = aspectRatioX;
            }
            gestureCropImageView2.setTargetAspectRatio(f11);
        }
        int intExtra2 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_X, 0);
        int intExtra3 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_Y, 0);
        if (intExtra2 > 0 && intExtra3 > 0) {
            this.mGestureCropImageView.setMaxResultImageSizeX(intExtra2);
            this.mGestureCropImageView.setMaxResultImageSizeY(intExtra3);
        }
    }

    /* access modifiers changed from: private */
    public void resetRotation() {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    /* access modifiers changed from: private */
    public void rotateByAngle(int i11) {
        this.mGestureCropImageView.postRotate((float) i11);
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    private void setAllowedGestures(int i11) {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        int[] iArr = this.mAllowedGestures;
        boolean z11 = false;
        gestureCropImageView.setScaleEnabled(iArr[i11] == 3 || iArr[i11] == 1);
        GestureCropImageView gestureCropImageView2 = this.mGestureCropImageView;
        int[] iArr2 = this.mAllowedGestures;
        if (iArr2[i11] == 3 || iArr2[i11] == 2) {
            z11 = true;
        }
        gestureCropImageView2.setRotateEnabled(z11);
        this.mGestureCropImageView.setGestureEnabled(getIntent().getBooleanExtra(UCrop.Options.EXTRA_DRAG_IMAGES, true));
    }

    /* access modifiers changed from: private */
    public void setAngleText(float f11) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", new Object[]{Float.valueOf(f11)}));
        }
    }

    private void setAngleTextColor(int i11) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    private void setImageData(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(UCrop.EXTRA_INPUT_URI);
        Uri uri2 = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        processOptions(intent);
        if (uri == null || uri2 == null) {
            setResultError(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent)));
            finish();
            return;
        }
        try {
            this.mGestureCropImageView.setImageUri(uri, FileUtils.replaceOutputUri(this, this.isForbidCropGifWebp, uri, uri2), this.isUseCustomBitmap);
        } catch (Exception e11) {
            setResultError(e11);
            finish();
        }
    }

    private void setInitialState() {
        if (!this.mShowBottomControls) {
            setAllowedGestures(0);
        } else if (this.mWrapperStateAspectRatio.getVisibility() == 0) {
            setWidgetState(R.id.state_aspect_ratio);
        } else {
            setWidgetState(R.id.state_scale);
        }
    }

    /* access modifiers changed from: private */
    public void setScaleText(float f11) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf((int) (f11 * 100.0f))}));
        }
    }

    private void setScaleTextColor(int i11) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    @TargetApi(21)
    private void setStatusBarColor(int i11) {
        Window window;
        if (Build.VERSION.SDK_INT >= 21 && (window = getWindow()) != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i11);
        }
    }

    /* access modifiers changed from: private */
    public void setWidgetState(int i11) {
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = this.mWrapperStateAspectRatio;
            int i12 = R.id.state_aspect_ratio;
            viewGroup.setSelected(i11 == i12);
            ViewGroup viewGroup2 = this.mWrapperStateRotate;
            int i13 = R.id.state_rotate;
            viewGroup2.setSelected(i11 == i13);
            ViewGroup viewGroup3 = this.mWrapperStateScale;
            int i14 = R.id.state_scale;
            viewGroup3.setSelected(i11 == i14);
            int i15 = 8;
            this.mLayoutAspectRatio.setVisibility(i11 == i12 ? 0 : 8);
            this.mLayoutRotate.setVisibility(i11 == i13 ? 0 : 8);
            ViewGroup viewGroup4 = this.mLayoutScale;
            if (i11 == i14) {
                i15 = 0;
            }
            viewGroup4.setVisibility(i15);
            changeSelectedTab(i11);
            if (i11 == i14) {
                setAllowedGestures(0);
            } else if (i11 == i13) {
                setAllowedGestures(1);
            } else {
                setAllowedGestures(2);
            }
        }
    }

    private void setupAppBar() {
        setStatusBarColor(this.mStatusBarColor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.mToolbarColor);
        toolbar.setTitleTextColor(this.mToolbarWidgetColor);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.mToolbarWidgetColor);
        textView.setText(this.mToolbarTitle);
        textView.setTextSize((float) this.mToolbarTitleSize);
        Drawable mutate = a.b(this, this.mToolbarCancelDrawable).mutate();
        mutate.setColorFilter(t0.a.a(this.mToolbarWidgetColor, BlendModeCompat.SRC_ATOP));
        toolbar.setNavigationIcon(mutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void setupAspectRatioWidget(Intent intent) {
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            intExtra = 2;
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio((String) null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it2 = parcelableArrayListExtra.iterator();
        while (it2.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.mActiveControlsWidgetColor);
            aspectRatioTextView.setAspectRatio((AspectRatio) it2.next());
            linearLayout.addView(frameLayout);
            this.mCropAspectRatioViews.add(frameLayout);
        }
        this.mCropAspectRatioViews.get(intExtra).setSelected(true);
        for (ViewGroup onClickListener : this.mCropAspectRatioViews) {
            onClickListener.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    UCropActivity.this.mGestureCropImageView.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
                    UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
                    if (!view.isSelected()) {
                        for (ViewGroup viewGroup : UCropActivity.this.mCropAspectRatioViews) {
                            viewGroup.setSelected(viewGroup == view);
                        }
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
    }

    private void setupRotateWidget() {
        this.mTextViewRotateAngle = (TextView) findViewById(R.id.text_view_rotate);
        int i11 = R.id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i11)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() {
            public void onScroll(float f11, float f12) {
                UCropActivity.this.mGestureCropImageView.postRotate(f11 / 42.0f);
            }

            public void onScrollEnd() {
                UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            public void onScrollStart() {
                UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) findViewById(i11)).setMiddleLineColor(this.mActiveControlsWidgetColor);
        findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                UCropActivity.this.resetRotation();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                UCropActivity.this.rotateByAngle(90);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        setAngleTextColor(this.mActiveControlsWidgetColor);
    }

    private void setupScaleWidget() {
        this.mTextViewScalePercent = (TextView) findViewById(R.id.text_view_scale);
        int i11 = R.id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i11)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() {
            public void onScroll(float f11, float f12) {
                if (f11 > 0.0f) {
                    UCropActivity.this.mGestureCropImageView.zoomInImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f11 * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                } else {
                    UCropActivity.this.mGestureCropImageView.zoomOutImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f11 * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                }
            }

            public void onScrollEnd() {
                UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            public void onScrollStart() {
                UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) findViewById(i11)).setMiddleLineColor(this.mActiveControlsWidgetColor);
        setScaleTextColor(this.mActiveControlsWidgetColor);
    }

    private void setupStatesWrapper() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.mActiveControlsWidgetColor));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.mActiveControlsWidgetColor));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.mActiveControlsWidgetColor));
    }

    private void setupViews(Intent intent) {
        this.isForbidCropGifWebp = intent.getBooleanExtra(UCrop.Options.EXTRA_CROP_FORBID_GIF_WEBP, false);
        this.mStatusBarColor = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.mToolbarColor = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.mActiveControlsWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, ContextCompat.getColor(this, R.color.ucrop_color_active_controls_color));
        this.mToolbarWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.mToolbarCancelDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, R.drawable.ucrop_ic_cross);
        this.mToolbarCropDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_DRAWABLE, R.drawable.ucrop_ic_done);
        this.mToolbarTitle = intent.getStringExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_TOOLBAR);
        this.mToolbarTitleSize = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_SIZE_TOOLBAR, 18);
        String str = this.mToolbarTitle;
        if (str == null) {
            str = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.mToolbarTitle = str;
        this.mLogoColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_LOGO_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_default_logo));
        this.mShowBottomControls = !intent.getBooleanExtra(UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, false);
        this.mRootViewBackgroundColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_crop_background));
        setupAppBar();
        initiateRootViews();
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            LayoutInflater.from(this).inflate(R.layout.ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.mControlsTransition = autoTransition;
            autoTransition.setDuration(50);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.mWrapperStateAspectRatio = viewGroup2;
            viewGroup2.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.state_rotate);
            this.mWrapperStateRotate = viewGroup3;
            viewGroup3.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R.id.state_scale);
            this.mWrapperStateScale = viewGroup4;
            viewGroup4.setOnClickListener(this.mStateClickListener);
            this.mLayoutAspectRatio = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.mLayoutRotate = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.mLayoutScale = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            setupAspectRatioWidget(intent);
            setupRotateWidget();
            setupScaleWidget();
            setupStatesWrapper();
        }
    }

    public void cropAndSaveImage() {
        this.mBlockingView.setClickable(true);
        this.mShowLoader = true;
        supportInvalidateOptionsMenu();
        this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback() {
            public void onBitmapCropped(Uri uri, int i11, int i12, int i13, int i14) {
                UCropActivity uCropActivity = UCropActivity.this;
                uCropActivity.setResultUri(uri, uCropActivity.mGestureCropImageView.getTargetAspectRatio(), i11, i12, i13, i14);
                UCropActivity.this.finish();
            }

            public void onCropFailure(Throwable th2) {
                UCropActivity.this.setResultError(th2);
                UCropActivity.this.finish();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        immersive();
        setContentView(R.layout.ucrop_activity_photobox);
        Intent intent = getIntent();
        setupViews(intent);
        setImageData(intent);
        setInitialState();
        addBlockingView();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(R.id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(t0.a.a(this.mToolbarWidgetColor, BlendModeCompat.SRC_ATOP));
                findItem.setIcon(icon);
            } catch (IllegalStateException e11) {
                Log.i(TAG, String.format("%s - %s", new Object[]{e11.getMessage(), getString(R.string.ucrop_mutate_exception_hint)}));
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.mToolbarCropDrawable);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(t0.a.a(this.mToolbarWidgetColor, BlendModeCompat.SRC_ATOP));
            findItem2.setIcon(drawable);
        }
        return true;
    }

    public void onDestroy() {
        UCropDevelopConfig.destroy();
        super.onDestroy();
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            cropAndSaveImage();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        } else {
            boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return onOptionsItemSelected;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.mShowLoader);
        menu.findItem(R.id.menu_loader).setVisible(this.mShowLoader);
        return super.onPrepareOptionsMenu(menu);
    }

    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        if (gestureCropImageView != null) {
            gestureCropImageView.cancelAllAnimations();
        }
    }

    public void setResultError(Throwable th2) {
        setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th2));
    }

    public void setResultUri(Uri uri, float f11, int i11, int i12, int i13, int i14) {
        setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f11).putExtra("com.yalantis.ucrop.ImageWidth", i13).putExtra("com.yalantis.ucrop.ImageHeight", i14).putExtra("com.yalantis.ucrop.OffsetX", i11).putExtra("com.yalantis.ucrop.OffsetY", i12).putExtra(UCrop.EXTRA_CROP_INPUT_ORIGINAL, FileUtils.getInputPath((Uri) getIntent().getParcelableExtra(UCrop.EXTRA_INPUT_URI))));
    }
}
