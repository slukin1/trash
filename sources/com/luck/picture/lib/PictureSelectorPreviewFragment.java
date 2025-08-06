package com.luck.picture.lib;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.n;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.luck.picture.lib.adapter.PicturePreviewAdapter;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.adapter.holder.PreviewGalleryAdapter;
import com.luck.picture.lib.adapter.holder.PreviewVideoHolder;
import com.luck.picture.lib.basic.IBridgeLoaderFactory;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.basic.PictureMediaScannerConnection;
import com.luck.picture.lib.config.Crop;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.decoration.HorizontalItemDecoration;
import com.luck.picture.lib.decoration.WrapContentLinearLayoutManager;
import com.luck.picture.lib.dialog.PictureCommonDialog;
import com.luck.picture.lib.engine.ExtendLoaderEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.MediaExtraInfo;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.interfaces.OnExternalPreviewEventListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.loader.LocalMediaLoader;
import com.luck.picture.lib.loader.LocalMediaPageLoader;
import com.luck.picture.lib.magical.BuildRecycleItemViewParams;
import com.luck.picture.lib.magical.MagicalView;
import com.luck.picture.lib.magical.OnMagicalViewCallback;
import com.luck.picture.lib.magical.ViewParams;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.DownloadFileUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.utils.ToastUtils;
import com.luck.picture.lib.utils.ValueOf;
import com.luck.picture.lib.widget.BottomNavBar;
import com.luck.picture.lib.widget.CompleteSelectView;
import com.luck.picture.lib.widget.PreviewBottomNavBar;
import com.luck.picture.lib.widget.PreviewTitleBar;
import com.luck.picture.lib.widget.TitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PictureSelectorPreviewFragment extends PictureCommonFragment {
    public static final String TAG = PictureSelectorPreviewFragment.class.getSimpleName();
    public PreviewBottomNavBar bottomNarBar;
    public CompleteSelectView completeSelectView;
    public int curPosition;
    public String currentAlbum;
    public boolean isAnimationStart;
    public boolean isDisplayDelete;
    public boolean isExternalPreview;
    public boolean isHasMore = true;
    public boolean isInternalBottomPreview;
    private boolean isPause = false;
    public boolean isSaveInstanceState;
    public boolean isShowCamera;
    public List<View> mAnimViews = new ArrayList();
    public long mBucketId = -1;
    public ArrayList<LocalMedia> mData = new ArrayList<>();
    public PreviewGalleryAdapter mGalleryAdapter;
    public RecyclerView mGalleryRecycle;
    public MagicalView magicalView;
    public boolean needScaleBig = true;
    public boolean needScaleSmall = false;
    private final ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        public void onPageScrolled(int i11, float f11, int i12) {
            if (PictureSelectorPreviewFragment.this.mData.size() > i11) {
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                int i13 = pictureSelectorPreviewFragment.screenWidth / 2;
                ArrayList<LocalMedia> arrayList = pictureSelectorPreviewFragment.mData;
                if (i12 >= i13) {
                    i11++;
                }
                LocalMedia localMedia = arrayList.get(i11);
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                pictureSelectorPreviewFragment2.tvSelected.setSelected(pictureSelectorPreviewFragment2.isSelected(localMedia));
                PictureSelectorPreviewFragment.this.notifyGallerySelectMedia(localMedia);
                PictureSelectorPreviewFragment.this.notifySelectNumberStyle(localMedia);
            }
        }

        public void onPageSelected(int i11) {
            PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
            pictureSelectorPreviewFragment.curPosition = i11;
            PreviewTitleBar previewTitleBar = pictureSelectorPreviewFragment.titleBar;
            previewTitleBar.setTitle((PictureSelectorPreviewFragment.this.curPosition + 1) + "/" + PictureSelectorPreviewFragment.this.totalNum);
            if (PictureSelectorPreviewFragment.this.mData.size() > i11) {
                LocalMedia localMedia = PictureSelectorPreviewFragment.this.mData.get(i11);
                PictureSelectorPreviewFragment.this.notifySelectNumberStyle(localMedia);
                if (PictureSelectorPreviewFragment.this.isHasMagicalEffect()) {
                    PictureSelectorPreviewFragment.this.changeMagicalViewParams(i11);
                }
                if (PictureSelectorPreviewFragment.this.selectorConfig.isPreviewZoomEffect) {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                    if (!pictureSelectorPreviewFragment2.isInternalBottomPreview || !pictureSelectorPreviewFragment2.selectorConfig.isAutoVideoPlay) {
                        PictureSelectorPreviewFragment.this.viewPageAdapter.setVideoPlayButtonUI(i11);
                    } else {
                        PictureSelectorPreviewFragment.this.startAutoVideoPlay(i11);
                    }
                } else if (PictureSelectorPreviewFragment.this.selectorConfig.isAutoVideoPlay) {
                    PictureSelectorPreviewFragment.this.startAutoVideoPlay(i11);
                }
                PictureSelectorPreviewFragment.this.notifyGallerySelectMedia(localMedia);
                PictureSelectorPreviewFragment.this.bottomNarBar.isDisplayEditor(PictureMimeType.isHasVideo(localMedia.getMimeType()) || PictureMimeType.isHasAudio(localMedia.getMimeType()));
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment3 = PictureSelectorPreviewFragment.this;
                if (!pictureSelectorPreviewFragment3.isExternalPreview && !pictureSelectorPreviewFragment3.isInternalBottomPreview && !pictureSelectorPreviewFragment3.selectorConfig.isOnlySandboxDir && PictureSelectorPreviewFragment.this.selectorConfig.isPageStrategy) {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment4 = PictureSelectorPreviewFragment.this;
                    if (!pictureSelectorPreviewFragment4.isHasMore) {
                        return;
                    }
                    if (i11 == (pictureSelectorPreviewFragment4.viewPageAdapter.getItemCount() - 1) - 10 || i11 == PictureSelectorPreviewFragment.this.viewPageAdapter.getItemCount() - 1) {
                        PictureSelectorPreviewFragment.this.loadMoreData();
                    }
                }
            }
        }
    };
    public int screenHeight;
    public int screenWidth;
    public View selectClickArea;
    public PreviewTitleBar titleBar;
    public int totalNum;
    public TextView tvSelected;
    public TextView tvSelectedWord;
    public PicturePreviewAdapter viewPageAdapter;
    public ViewPager2 viewPager;

    public class MyOnPreviewEventListener implements BasePreviewHolder.OnPreviewEventListener {
        private MyOnPreviewEventListener() {
        }

        public void onBackPressed() {
            if (PictureSelectorPreviewFragment.this.selectorConfig.isPreviewFullScreenMode) {
                PictureSelectorPreviewFragment.this.previewFullScreenMode();
                return;
            }
            PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
            if (pictureSelectorPreviewFragment.isExternalPreview) {
                if (pictureSelectorPreviewFragment.selectorConfig.isPreviewZoomEffect) {
                    PictureSelectorPreviewFragment.this.magicalView.backToMin();
                } else {
                    PictureSelectorPreviewFragment.this.handleExternalPreviewBack();
                }
            } else if (pictureSelectorPreviewFragment.isInternalBottomPreview || !pictureSelectorPreviewFragment.selectorConfig.isPreviewZoomEffect) {
                PictureSelectorPreviewFragment.this.onBackCurrentFragment();
            } else {
                PictureSelectorPreviewFragment.this.magicalView.backToMin();
            }
        }

        public void onLongPressDownload(LocalMedia localMedia) {
            if (!PictureSelectorPreviewFragment.this.selectorConfig.isHidePreviewDownload) {
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                if (pictureSelectorPreviewFragment.isExternalPreview) {
                    pictureSelectorPreviewFragment.onExternalLongPressDownload(localMedia);
                }
            }
        }

        public void onPreviewVideoTitle(String str) {
            if (TextUtils.isEmpty(str)) {
                PreviewTitleBar previewTitleBar = PictureSelectorPreviewFragment.this.titleBar;
                previewTitleBar.setTitle((PictureSelectorPreviewFragment.this.curPosition + 1) + "/" + PictureSelectorPreviewFragment.this.totalNum);
                return;
            }
            PictureSelectorPreviewFragment.this.titleBar.setTitle(str);
        }
    }

    /* access modifiers changed from: private */
    public void changeMagicalViewParams(final int i11) {
        LocalMedia localMedia = this.mData.get(i11);
        if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
            getVideoRealSizeFromMedia(localMedia, false, new OnCallbackListener<int[]>() {
                public void onCall(int[] iArr) {
                    PictureSelectorPreviewFragment.this.setMagicalViewParams(iArr[0], iArr[1], i11);
                }
            });
        } else {
            getImageRealSizeFromMedia(localMedia, false, new OnCallbackListener<int[]>() {
                public void onCall(int[] iArr) {
                    PictureSelectorPreviewFragment.this.setMagicalViewParams(iArr[0], iArr[1], i11);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void changeViewParams(int[] iArr) {
        ViewParams itemViewParams = BuildRecycleItemViewParams.getItemViewParams(this.isShowCamera ? this.curPosition + 1 : this.curPosition);
        if (itemViewParams == null || iArr[0] == 0 || iArr[1] == 0) {
            this.magicalView.setViewParams(0, 0, 0, 0, iArr[0], iArr[1]);
            this.magicalView.resetStartNormal(iArr[0], iArr[1], false);
            return;
        }
        this.magicalView.setViewParams(itemViewParams.left, itemViewParams.top, itemViewParams.width, itemViewParams.height, iArr[0], iArr[1]);
        this.magicalView.resetStart();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public void deletePreview() {
        OnExternalPreviewEventListener onExternalPreviewEventListener;
        if (this.isDisplayDelete && (onExternalPreviewEventListener = this.selectorConfig.onExternalPreviewEventListener) != null) {
            onExternalPreviewEventListener.onPreviewDelete(this.viewPager.getCurrentItem());
            int currentItem = this.viewPager.getCurrentItem();
            this.mData.remove(currentItem);
            if (this.mData.size() == 0) {
                handleExternalPreviewBack();
                return;
            }
            this.titleBar.setTitle(getString(R.string.ps_preview_image_num, Integer.valueOf(this.curPosition + 1), Integer.valueOf(this.mData.size())));
            this.totalNum = this.mData.size();
            this.curPosition = currentItem;
            if (this.viewPager.getAdapter() != null) {
                this.viewPager.setAdapter((RecyclerView.Adapter) null);
                this.viewPager.setAdapter(this.viewPageAdapter);
            }
            this.viewPager.setCurrentItem(this.curPosition, false);
        }
    }

    private void externalPreviewStyle() {
        this.titleBar.getImageDelete().setVisibility(this.isDisplayDelete ? 0 : 8);
        this.tvSelected.setVisibility(8);
        this.bottomNarBar.setVisibility(8);
        this.completeSelectView.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getImageRealSizeFromMedia(final com.luck.picture.lib.entity.LocalMedia r7, boolean r8, final com.luck.picture.lib.interfaces.OnCallbackListener<int[]> r9) {
        /*
            r6 = this;
            int r0 = r7.getWidth()
            int r1 = r7.getHeight()
            boolean r0 = com.luck.picture.lib.utils.MediaUtils.isLongImage(r0, r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0015
            int r8 = r6.screenWidth
            int r0 = r6.screenHeight
            goto L_0x0047
        L_0x0015:
            int r0 = r7.getWidth()
            int r3 = r7.getHeight()
            if (r8 == 0) goto L_0x0045
            if (r0 <= 0) goto L_0x0025
            if (r3 <= 0) goto L_0x0025
            if (r0 <= r3) goto L_0x0045
        L_0x0025:
            com.luck.picture.lib.config.SelectorConfig r8 = r6.selectorConfig
            boolean r8 = r8.isSyncWidthAndHeight
            if (r8 == 0) goto L_0x0045
            androidx.viewpager2.widget.ViewPager2 r8 = r6.viewPager
            r4 = 0
            r8.setAlpha(r4)
            android.content.Context r8 = r6.getContext()
            java.lang.String r4 = r7.getAvailablePath()
            com.luck.picture.lib.PictureSelectorPreviewFragment$26 r5 = new com.luck.picture.lib.PictureSelectorPreviewFragment$26
            r5.<init>(r7, r9)
            com.luck.picture.lib.utils.MediaUtils.getImageSize(r8, r4, r5)
            r8 = r0
            r0 = r3
            r3 = r1
            goto L_0x0048
        L_0x0045:
            r8 = r0
            r0 = r3
        L_0x0047:
            r3 = r2
        L_0x0048:
            boolean r4 = r7.isCut()
            if (r4 == 0) goto L_0x0062
            int r4 = r7.getCropImageWidth()
            if (r4 <= 0) goto L_0x0062
            int r4 = r7.getCropImageHeight()
            if (r4 <= 0) goto L_0x0062
            int r8 = r7.getCropImageWidth()
            int r0 = r7.getCropImageHeight()
        L_0x0062:
            if (r3 == 0) goto L_0x006e
            r7 = 2
            int[] r7 = new int[r7]
            r7[r1] = r8
            r7[r2] = r0
            r9.onCall(r7)
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorPreviewFragment.getImageRealSizeFromMedia(com.luck.picture.lib.entity.LocalMedia, boolean, com.luck.picture.lib.interfaces.OnCallbackListener):void");
    }

    private void getVideoRealSizeFromMedia(final LocalMedia localMedia, boolean z11, final OnCallbackListener<int[]> onCallbackListener) {
        boolean z12;
        if (!z11 || ((localMedia.getWidth() > 0 && localMedia.getHeight() > 0 && localMedia.getWidth() <= localMedia.getHeight()) || !this.selectorConfig.isSyncWidthAndHeight)) {
            z12 = true;
        } else {
            this.viewPager.setAlpha(0.0f);
            MediaUtils.getVideoSize(getContext(), localMedia.getAvailablePath(), new OnCallbackListener<MediaExtraInfo>() {
                public void onCall(MediaExtraInfo mediaExtraInfo) {
                    if (mediaExtraInfo.getWidth() > 0) {
                        localMedia.setWidth(mediaExtraInfo.getWidth());
                    }
                    if (mediaExtraInfo.getHeight() > 0) {
                        localMedia.setHeight(mediaExtraInfo.getHeight());
                    }
                    OnCallbackListener onCallbackListener = onCallbackListener;
                    if (onCallbackListener != null) {
                        onCallbackListener.onCall(new int[]{localMedia.getWidth(), localMedia.getHeight()});
                    }
                }
            });
            z12 = false;
        }
        if (z12) {
            onCallbackListener.onCall(new int[]{localMedia.getWidth(), localMedia.getHeight()});
        }
    }

    /* access modifiers changed from: private */
    public void handleExternalPreviewBack() {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            if (this.selectorConfig.isPreviewFullScreenMode) {
                hideFullScreenStatusBar();
            }
            onExitPictureSelector();
        }
    }

    /* access modifiers changed from: private */
    public void handleMoreData(List<LocalMedia> list, boolean z11) {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            this.isHasMore = z11;
            if (!z11) {
                return;
            }
            if (list.size() > 0) {
                int size = this.mData.size();
                this.mData.addAll(list);
                this.viewPageAdapter.notifyItemRangeChanged(size, this.mData.size());
                return;
            }
            loadMoreData();
        }
    }

    private void hideFullScreenStatusBar() {
        for (int i11 = 0; i11 < this.mAnimViews.size(); i11++) {
            this.mAnimViews.get(i11).setEnabled(true);
        }
        this.bottomNarBar.getEditor().setEnabled(true);
    }

    private void iniMagicalView() {
        float f11 = 1.0f;
        if (isHasMagicalEffect()) {
            if (!this.isSaveInstanceState) {
                f11 = 0.0f;
            }
            this.magicalView.setBackgroundAlpha(f11);
            for (int i11 = 0; i11 < this.mAnimViews.size(); i11++) {
                if (!(this.mAnimViews.get(i11) instanceof TitleBar)) {
                    this.mAnimViews.get(i11).setAlpha(f11);
                }
            }
            return;
        }
        this.magicalView.setBackgroundAlpha(1.0f);
    }

    private void initBottomNavBar() {
        this.bottomNarBar.setBottomNavBarStyle();
        this.bottomNarBar.setSelectedChange();
        this.bottomNarBar.setOnBottomNavBarListener(new BottomNavBar.OnBottomNavBarListener() {
            public void onCheckOriginalChange() {
                PictureSelectorPreviewFragment.this.sendSelectedOriginalChangeEvent();
            }

            public void onEditImage() {
                if (PictureSelectorPreviewFragment.this.selectorConfig.onEditMediaEventListener != null) {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    PictureSelectorPreviewFragment.this.selectorConfig.onEditMediaEventListener.onStartMediaEdit(PictureSelectorPreviewFragment.this, pictureSelectorPreviewFragment.mData.get(pictureSelectorPreviewFragment.viewPager.getCurrentItem()), Crop.REQUEST_EDIT_CROP);
                }
            }

            public void onFirstCheckOriginalSelectedChange() {
                int currentItem = PictureSelectorPreviewFragment.this.viewPager.getCurrentItem();
                if (PictureSelectorPreviewFragment.this.mData.size() > currentItem) {
                    PictureSelectorPreviewFragment.this.confirmSelect(PictureSelectorPreviewFragment.this.mData.get(currentItem), false);
                }
            }
        });
    }

    private void initComplete() {
        final SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        if (StyleUtils.checkStyleValidity(selectMainStyle.getPreviewSelectBackground())) {
            this.tvSelected.setBackgroundResource(selectMainStyle.getPreviewSelectBackground());
        } else if (StyleUtils.checkStyleValidity(selectMainStyle.getSelectBackground())) {
            this.tvSelected.setBackgroundResource(selectMainStyle.getSelectBackground());
        }
        if (StyleUtils.checkStyleValidity(selectMainStyle.getPreviewSelectTextResId())) {
            this.tvSelectedWord.setText(getString(selectMainStyle.getPreviewSelectTextResId()));
        } else if (StyleUtils.checkTextValidity(selectMainStyle.getPreviewSelectText())) {
            this.tvSelectedWord.setText(selectMainStyle.getPreviewSelectText());
        } else {
            this.tvSelectedWord.setText("");
        }
        if (StyleUtils.checkSizeValidity(selectMainStyle.getPreviewSelectTextSize())) {
            this.tvSelectedWord.setTextSize((float) selectMainStyle.getPreviewSelectTextSize());
        }
        if (StyleUtils.checkStyleValidity(selectMainStyle.getPreviewSelectTextColor())) {
            this.tvSelectedWord.setTextColor(selectMainStyle.getPreviewSelectTextColor());
        }
        if (StyleUtils.checkSizeValidity(selectMainStyle.getPreviewSelectMarginRight())) {
            if (this.tvSelected.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                if (this.tvSelected.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                    ((ConstraintLayout.LayoutParams) this.tvSelected.getLayoutParams()).rightMargin = selectMainStyle.getPreviewSelectMarginRight();
                }
            } else if (this.tvSelected.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.tvSelected.getLayoutParams()).rightMargin = selectMainStyle.getPreviewSelectMarginRight();
            }
        }
        this.completeSelectView.setCompleteSelectViewStyle();
        this.completeSelectView.setSelectedChange(true);
        if (selectMainStyle.isCompleteSelectRelativeTop()) {
            if (this.completeSelectView.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                int i11 = R.id.title_bar;
                ((ConstraintLayout.LayoutParams) this.completeSelectView.getLayoutParams()).f7942h = i11;
                ((ConstraintLayout.LayoutParams) this.completeSelectView.getLayoutParams()).f7948k = i11;
                if (this.selectorConfig.isPreviewFullScreenMode) {
                    ((ConstraintLayout.LayoutParams) this.completeSelectView.getLayoutParams()).topMargin = DensityUtil.getStatusBarHeight(getContext());
                }
            } else if ((this.completeSelectView.getLayoutParams() instanceof RelativeLayout.LayoutParams) && this.selectorConfig.isPreviewFullScreenMode) {
                ((RelativeLayout.LayoutParams) this.completeSelectView.getLayoutParams()).topMargin = DensityUtil.getStatusBarHeight(getContext());
            }
        }
        if (selectMainStyle.isPreviewSelectRelativeBottom()) {
            if (this.tvSelected.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                int i12 = R.id.bottom_nar_bar;
                ((ConstraintLayout.LayoutParams) this.tvSelected.getLayoutParams()).f7942h = i12;
                ((ConstraintLayout.LayoutParams) this.tvSelected.getLayoutParams()).f7948k = i12;
                ((ConstraintLayout.LayoutParams) this.tvSelectedWord.getLayoutParams()).f7942h = i12;
                ((ConstraintLayout.LayoutParams) this.tvSelectedWord.getLayoutParams()).f7948k = i12;
                ((ConstraintLayout.LayoutParams) this.selectClickArea.getLayoutParams()).f7942h = i12;
                ((ConstraintLayout.LayoutParams) this.selectClickArea.getLayoutParams()).f7948k = i12;
            }
        } else if (this.selectorConfig.isPreviewFullScreenMode) {
            if (this.tvSelectedWord.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) this.tvSelectedWord.getLayoutParams()).topMargin = DensityUtil.getStatusBarHeight(getContext());
            } else if (this.tvSelectedWord.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.tvSelectedWord.getLayoutParams()).topMargin = DensityUtil.getStatusBarHeight(getContext());
            }
        }
        this.completeSelectView.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
                if (r0.confirmSelect(r0.mData.get(r0.viewPager.getCurrentItem()), false) == 0) goto L_0x003b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
                if (com.luck.picture.lib.PictureSelectorPreviewFragment.access$300(r5.this$0).getSelectCount() > 0) goto L_0x003b;
             */
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r6) {
                /*
                    r5 = this;
                    com.luck.picture.lib.style.SelectMainStyle r0 = r0
                    boolean r0 = r0.isCompleteSelectRelativeTop()
                    r1 = 1
                    r2 = 0
                    if (r0 == 0) goto L_0x002f
                    com.luck.picture.lib.PictureSelectorPreviewFragment r0 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.config.SelectorConfig r0 = r0.selectorConfig
                    int r0 = r0.getSelectCount()
                    if (r0 != 0) goto L_0x002f
                    com.luck.picture.lib.PictureSelectorPreviewFragment r0 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    java.util.ArrayList<com.luck.picture.lib.entity.LocalMedia> r3 = r0.mData
                    androidx.viewpager2.widget.ViewPager2 r4 = r0.viewPager
                    int r4 = r4.getCurrentItem()
                    java.lang.Object r3 = r3.get(r4)
                    com.luck.picture.lib.entity.LocalMedia r3 = (com.luck.picture.lib.entity.LocalMedia) r3
                    int r0 = r0.confirmSelect(r3, r2)
                    if (r0 != 0) goto L_0x002d
                    goto L_0x003b
                L_0x002d:
                    r1 = r2
                    goto L_0x003b
                L_0x002f:
                    com.luck.picture.lib.PictureSelectorPreviewFragment r0 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.config.SelectorConfig r0 = r0.selectorConfig
                    int r0 = r0.getSelectCount()
                    if (r0 <= 0) goto L_0x002d
                L_0x003b:
                    com.luck.picture.lib.PictureSelectorPreviewFragment r0 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.config.SelectorConfig r0 = r0.selectorConfig
                    boolean r0 = r0.isEmptyResultReturn
                    if (r0 == 0) goto L_0x0057
                    com.luck.picture.lib.PictureSelectorPreviewFragment r0 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.config.SelectorConfig r0 = r0.selectorConfig
                    int r0 = r0.getSelectCount()
                    if (r0 != 0) goto L_0x0057
                    com.luck.picture.lib.PictureSelectorPreviewFragment r0 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    r0.onExitPictureSelector()
                    goto L_0x005e
                L_0x0057:
                    if (r1 == 0) goto L_0x005e
                    com.luck.picture.lib.PictureSelectorPreviewFragment r0 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    r0.dispatchTransformResult()
                L_0x005e:
                    com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorPreviewFragment.AnonymousClass6.onClick(android.view.View):void");
            }
        });
    }

    private void initTitleBar() {
        if (this.selectorConfig.selectorStyle.getTitleBarStyle().isHideTitleBar()) {
            this.titleBar.setVisibility(8);
        }
        this.titleBar.setTitleBarStyle();
        this.titleBar.setOnTitleBarListener(new TitleBar.OnTitleBarListener() {
            public void onBackPressed() {
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                if (pictureSelectorPreviewFragment.isExternalPreview) {
                    if (pictureSelectorPreviewFragment.selectorConfig.isPreviewZoomEffect) {
                        PictureSelectorPreviewFragment.this.magicalView.backToMin();
                    } else {
                        PictureSelectorPreviewFragment.this.handleExternalPreviewBack();
                    }
                } else if (pictureSelectorPreviewFragment.isInternalBottomPreview || !pictureSelectorPreviewFragment.selectorConfig.isPreviewZoomEffect) {
                    PictureSelectorPreviewFragment.this.onBackCurrentFragment();
                } else {
                    PictureSelectorPreviewFragment.this.magicalView.backToMin();
                }
            }
        });
        PreviewTitleBar previewTitleBar = this.titleBar;
        previewTitleBar.setTitle((this.curPosition + 1) + "/" + this.totalNum);
        this.titleBar.getImageDelete().setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                PictureSelectorPreviewFragment.this.deletePreview();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.selectClickArea.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                if (pictureSelectorPreviewFragment.isExternalPreview) {
                    pictureSelectorPreviewFragment.deletePreview();
                } else {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                    if (pictureSelectorPreviewFragment2.confirmSelect(pictureSelectorPreviewFragment.mData.get(pictureSelectorPreviewFragment.viewPager.getCurrentItem()), pictureSelectorPreviewFragment2.tvSelected.isSelected()) == 0) {
                        if (PictureSelectorPreviewFragment.this.selectorConfig.onSelectAnimListener != null) {
                            PictureSelectorPreviewFragment.this.selectorConfig.onSelectAnimListener.onSelectAnim(PictureSelectorPreviewFragment.this.tvSelected);
                        } else {
                            PictureSelectorPreviewFragment pictureSelectorPreviewFragment3 = PictureSelectorPreviewFragment.this;
                            pictureSelectorPreviewFragment3.tvSelected.startAnimation(AnimationUtils.loadAnimation(pictureSelectorPreviewFragment3.getContext(), R.anim.ps_anim_modal_in));
                        }
                    }
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.tvSelected.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                PictureSelectorPreviewFragment.this.selectClickArea.performClick();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void initViewPagerData(ArrayList<LocalMedia> arrayList) {
        int i11;
        PicturePreviewAdapter createAdapter = createAdapter();
        this.viewPageAdapter = createAdapter;
        createAdapter.setData(arrayList);
        this.viewPageAdapter.setOnPreviewEventListener(new MyOnPreviewEventListener());
        this.viewPager.setOrientation(0);
        this.viewPager.setAdapter(this.viewPageAdapter);
        this.selectorConfig.selectedPreviewResult.clear();
        if (arrayList.size() == 0 || this.curPosition >= arrayList.size() || (i11 = this.curPosition) < 0) {
            onKeyBackFragmentFinish();
            return;
        }
        LocalMedia localMedia = arrayList.get(i11);
        this.bottomNarBar.isDisplayEditor(PictureMimeType.isHasVideo(localMedia.getMimeType()) || PictureMimeType.isHasAudio(localMedia.getMimeType()));
        this.tvSelected.setSelected(this.selectorConfig.getSelectedResult().contains(arrayList.get(this.viewPager.getCurrentItem())));
        this.viewPager.registerOnPageChangeCallback(this.pageChangeCallback);
        this.viewPager.setPageTransformer(new MarginPageTransformer(DensityUtil.dip2px(getAppContext(), 3.0f)));
        this.viewPager.setCurrentItem(this.curPosition, false);
        sendChangeSubSelectPositionEvent(false);
        notifySelectNumberStyle(arrayList.get(this.curPosition));
        startZoomEffect(localMedia);
    }

    /* access modifiers changed from: private */
    public boolean isHasMagicalEffect() {
        return !this.isInternalBottomPreview && this.selectorConfig.isPreviewZoomEffect;
    }

    private boolean isPlaying() {
        PicturePreviewAdapter picturePreviewAdapter = this.viewPageAdapter;
        return picturePreviewAdapter != null && picturePreviewAdapter.isPlaying(this.viewPager.getCurrentItem());
    }

    /* access modifiers changed from: private */
    public void loadMoreData() {
        int i11 = this.mPage + 1;
        this.mPage = i11;
        SelectorConfig selectorConfig = this.selectorConfig;
        ExtendLoaderEngine extendLoaderEngine = selectorConfig.loaderDataEngine;
        if (extendLoaderEngine != null) {
            Context context = getContext();
            long j11 = this.mBucketId;
            int i12 = this.mPage;
            int i13 = this.selectorConfig.pageSize;
            extendLoaderEngine.loadMoreMediaData(context, j11, i12, i13, i13, new OnQueryDataResultListener<LocalMedia>() {
                public void onComplete(ArrayList<LocalMedia> arrayList, boolean z11) {
                    PictureSelectorPreviewFragment.this.handleMoreData(arrayList, z11);
                }
            });
            return;
        }
        this.mLoader.loadPageMediaData(this.mBucketId, i11, selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() {
            public void onComplete(ArrayList<LocalMedia> arrayList, boolean z11) {
                PictureSelectorPreviewFragment.this.handleMoreData(arrayList, z11);
            }
        });
    }

    public static PictureSelectorPreviewFragment newInstance() {
        PictureSelectorPreviewFragment pictureSelectorPreviewFragment = new PictureSelectorPreviewFragment();
        pictureSelectorPreviewFragment.setArguments(new Bundle());
        return pictureSelectorPreviewFragment;
    }

    /* access modifiers changed from: private */
    public void notifyGallerySelectMedia(LocalMedia localMedia) {
        if (this.mGalleryAdapter != null && this.selectorConfig.selectorStyle.getSelectMainStyle().isPreviewDisplaySelectGallery()) {
            this.mGalleryAdapter.isSelectMedia(localMedia);
        }
    }

    private void notifyPreviewGalleryData(boolean z11, LocalMedia localMedia) {
        if (this.mGalleryAdapter != null && this.selectorConfig.selectorStyle.getSelectMainStyle().isPreviewDisplaySelectGallery()) {
            if (this.mGalleryRecycle.getVisibility() == 4) {
                this.mGalleryRecycle.setVisibility(0);
            }
            if (z11) {
                if (this.selectorConfig.selectionMode == 1) {
                    this.mGalleryAdapter.clear();
                }
                this.mGalleryAdapter.addGalleryData(localMedia);
                this.mGalleryRecycle.smoothScrollToPosition(this.mGalleryAdapter.getItemCount() - 1);
                return;
            }
            this.mGalleryAdapter.removeGalleryData(localMedia);
            if (this.selectorConfig.getSelectCount() == 0) {
                this.mGalleryRecycle.setVisibility(4);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onExternalLongPressDownload(final LocalMedia localMedia) {
        String str;
        OnExternalPreviewEventListener onExternalPreviewEventListener = this.selectorConfig.onExternalPreviewEventListener;
        if (onExternalPreviewEventListener != null && !onExternalPreviewEventListener.onLongPressDownload(getContext(), localMedia)) {
            if (PictureMimeType.isHasAudio(localMedia.getMimeType()) || PictureMimeType.isUrlHasAudio(localMedia.getAvailablePath())) {
                str = getString(R.string.ps_prompt_audio_content);
            } else if (PictureMimeType.isHasVideo(localMedia.getMimeType()) || PictureMimeType.isUrlHasVideo(localMedia.getAvailablePath())) {
                str = getString(R.string.ps_prompt_video_content);
            } else {
                str = getString(R.string.ps_prompt_image_content);
            }
            PictureCommonDialog.showDialog(getContext(), getString(R.string.ps_prompt), str).setOnDialogEventListener(new PictureCommonDialog.OnDialogEventListener() {
                public void onConfirm() {
                    String availablePath = localMedia.getAvailablePath();
                    if (PictureMimeType.isHasHttp(availablePath)) {
                        PictureSelectorPreviewFragment.this.showLoading();
                    }
                    DownloadFileUtils.saveLocalFile(PictureSelectorPreviewFragment.this.getContext(), availablePath, localMedia.getMimeType(), new OnCallbackListener<String>() {
                        public void onCall(String str) {
                            String str2;
                            PictureSelectorPreviewFragment.this.dismissLoading();
                            if (TextUtils.isEmpty(str)) {
                                if (PictureMimeType.isHasAudio(localMedia.getMimeType())) {
                                    str2 = PictureSelectorPreviewFragment.this.getString(R.string.ps_save_audio_error);
                                } else if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                                    str2 = PictureSelectorPreviewFragment.this.getString(R.string.ps_save_video_error);
                                } else {
                                    str2 = PictureSelectorPreviewFragment.this.getString(R.string.ps_save_image_error);
                                }
                                ToastUtils.showToast(PictureSelectorPreviewFragment.this.getContext(), str2);
                                return;
                            }
                            new PictureMediaScannerConnection(PictureSelectorPreviewFragment.this.getActivity(), str);
                            Context context = PictureSelectorPreviewFragment.this.getContext();
                            ToastUtils.showToast(context, PictureSelectorPreviewFragment.this.getString(R.string.ps_save_success) + "\n" + str);
                        }
                    });
                }
            });
        }
    }

    private void onKeyDownBackToMin() {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        if (this.isExternalPreview) {
            if (this.selectorConfig.isPreviewZoomEffect) {
                this.magicalView.backToMin();
            } else {
                onExitPictureSelector();
            }
        } else if (this.isInternalBottomPreview) {
            onBackCurrentFragment();
        } else if (this.selectorConfig.isPreviewZoomEffect) {
            this.magicalView.backToMin();
        } else {
            onBackCurrentFragment();
        }
    }

    /* access modifiers changed from: private */
    public void previewFullScreenMode() {
        float f11;
        if (!this.isAnimationStart) {
            float f12 = 0.0f;
            final boolean z11 = this.titleBar.getTranslationY() == 0.0f;
            AnimatorSet animatorSet = new AnimatorSet();
            if (z11) {
                f11 = 0.0f;
            } else {
                f11 = (float) (-this.titleBar.getHeight());
            }
            float f13 = z11 ? (float) (-this.titleBar.getHeight()) : 0.0f;
            float f14 = z11 ? 1.0f : 0.0f;
            if (!z11) {
                f12 = 1.0f;
            }
            for (int i11 = 0; i11 < this.mAnimViews.size(); i11++) {
                View view = this.mAnimViews.get(i11);
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "alpha", new float[]{f14, f12})});
                if (view instanceof TitleBar) {
                    animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "translationY", new float[]{f11, f13})});
                }
            }
            animatorSet.setDuration(350);
            animatorSet.start();
            this.isAnimationStart = true;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                @SuppressLint({"WrongConstant"})
                public void onAnimationEnd(Animator animator) {
                    PictureSelectorPreviewFragment.this.isAnimationStart = false;
                    if (SdkVersionUtils.isP() && PictureSelectorPreviewFragment.this.isAdded()) {
                        Window window = PictureSelectorPreviewFragment.this.requireActivity().getWindow();
                        WindowManager.LayoutParams attributes = window.getAttributes();
                        if (z11) {
                            attributes.flags |= 1024;
                            attributes.layoutInDisplayCutoutMode = 1;
                            window.setAttributes(attributes);
                            window.addFlags(512);
                            return;
                        }
                        attributes.flags &= -1025;
                        window.setAttributes(attributes);
                        window.clearFlags(512);
                    }
                }
            });
            if (z11) {
                showFullScreenStatusBar();
            } else {
                hideFullScreenStatusBar();
            }
        }
    }

    private void resumePausePlay() {
        BasePreviewHolder currentHolder;
        PicturePreviewAdapter picturePreviewAdapter = this.viewPageAdapter;
        if (picturePreviewAdapter != null && (currentHolder = picturePreviewAdapter.getCurrentHolder(this.viewPager.getCurrentItem())) != null) {
            currentHolder.resumePausePlay();
        }
    }

    private void setMagicalViewBackgroundColor() {
        ArrayList<LocalMedia> arrayList;
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        if (StyleUtils.checkStyleValidity(selectMainStyle.getPreviewBackgroundColor())) {
            this.magicalView.setBackgroundColor(selectMainStyle.getPreviewBackgroundColor());
        } else if (this.selectorConfig.chooseMode == SelectMimeType.ofAudio() || ((arrayList = this.mData) != null && arrayList.size() > 0 && PictureMimeType.isHasAudio(this.mData.get(0).getMimeType()))) {
            this.magicalView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ps_color_white));
        } else {
            this.magicalView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ps_color_black));
        }
    }

    /* access modifiers changed from: private */
    public void setMagicalViewParams(int i11, int i12, int i13) {
        this.magicalView.changeRealScreenHeight(i11, i12, true);
        if (this.isShowCamera) {
            i13++;
        }
        ViewParams itemViewParams = BuildRecycleItemViewParams.getItemViewParams(i13);
        if (itemViewParams == null || i11 == 0 || i12 == 0) {
            this.magicalView.setViewParams(0, 0, 0, 0, i11, i12);
        } else {
            this.magicalView.setViewParams(itemViewParams.left, itemViewParams.top, itemViewParams.width, itemViewParams.height, i11, i12);
        }
    }

    private void showFullScreenStatusBar() {
        for (int i11 = 0; i11 < this.mAnimViews.size(); i11++) {
            this.mAnimViews.get(i11).setEnabled(false);
        }
        this.bottomNarBar.getEditor().setEnabled(false);
    }

    /* access modifiers changed from: private */
    public void start(final int[] iArr) {
        this.magicalView.changeRealScreenHeight(iArr[0], iArr[1], false);
        ViewParams itemViewParams = BuildRecycleItemViewParams.getItemViewParams(this.isShowCamera ? this.curPosition + 1 : this.curPosition);
        if (itemViewParams == null || (iArr[0] == 0 && iArr[1] == 0)) {
            this.viewPager.post(new Runnable() {
                public void run() {
                    MagicalView magicalView = PictureSelectorPreviewFragment.this.magicalView;
                    int[] iArr = iArr;
                    magicalView.startNormal(iArr[0], iArr[1], false);
                }
            });
            this.magicalView.setBackgroundAlpha(1.0f);
            for (int i11 = 0; i11 < this.mAnimViews.size(); i11++) {
                this.mAnimViews.get(i11).setAlpha(1.0f);
            }
        } else {
            this.magicalView.setViewParams(itemViewParams.left, itemViewParams.top, itemViewParams.width, itemViewParams.height, iArr[0], iArr[1]);
            this.magicalView.start(false);
        }
        ObjectAnimator.ofFloat(this.viewPager, "alpha", new float[]{0.0f, 1.0f}).setDuration(50).start();
    }

    /* access modifiers changed from: private */
    public void startAutoVideoPlay(final int i11) {
        this.viewPager.post(new Runnable() {
            public void run() {
                PictureSelectorPreviewFragment.this.viewPageAdapter.startAutoVideoPlay(i11);
            }
        });
    }

    public void addAminViews(View... viewArr) {
        Collections.addAll(this.mAnimViews, viewArr);
    }

    public PicturePreviewAdapter createAdapter() {
        return new PicturePreviewAdapter(this.selectorConfig);
    }

    public PicturePreviewAdapter getAdapter() {
        return this.viewPageAdapter;
    }

    public String getFragmentTag() {
        return TAG;
    }

    public int getResourceId() {
        int layoutResource = InjectResourceSource.getLayoutResource(getContext(), 2, this.selectorConfig);
        if (layoutResource != 0) {
            return layoutResource;
        }
        return R.layout.ps_fragment_preview;
    }

    public ViewPager2 getViewPager2() {
        return this.viewPager;
    }

    public void initPreviewSelectGallery(ViewGroup viewGroup) {
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        if (selectMainStyle.isPreviewDisplaySelectGallery()) {
            this.mGalleryRecycle = new RecyclerView(getContext());
            if (StyleUtils.checkStyleValidity(selectMainStyle.getAdapterPreviewGalleryBackgroundResource())) {
                this.mGalleryRecycle.setBackgroundResource(selectMainStyle.getAdapterPreviewGalleryBackgroundResource());
            } else {
                this.mGalleryRecycle.setBackgroundResource(R.drawable.ps_preview_gallery_bg);
            }
            viewGroup.addView(this.mGalleryRecycle);
            ViewGroup.LayoutParams layoutParams = this.mGalleryRecycle.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.width = -1;
                layoutParams2.height = -2;
                layoutParams2.f7946j = R.id.bottom_nar_bar;
                layoutParams2.f7964s = 0;
                layoutParams2.f7968u = 0;
            }
            AnonymousClass11 r72 = new WrapContentLinearLayoutManager(getContext()) {
                public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i11) {
                    super.smoothScrollToPosition(recyclerView, state, i11);
                    AnonymousClass1 r22 = new n(recyclerView.getContext()) {
                        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                            return 300.0f / ((float) displayMetrics.densityDpi);
                        }
                    };
                    r22.setTargetPosition(i11);
                    startSmoothScroll(r22);
                }
            };
            RecyclerView.ItemAnimator itemAnimator = this.mGalleryRecycle.getItemAnimator();
            if (itemAnimator != null) {
                ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            }
            if (this.mGalleryRecycle.getItemDecorationCount() == 0) {
                this.mGalleryRecycle.addItemDecoration(new HorizontalItemDecoration(Integer.MAX_VALUE, DensityUtil.dip2px(getContext(), 6.0f)));
            }
            r72.setOrientation(0);
            this.mGalleryRecycle.setLayoutManager(r72);
            if (this.selectorConfig.getSelectCount() > 0) {
                this.mGalleryRecycle.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getContext(), R.anim.ps_anim_layout_fall_enter));
            }
            this.mGalleryAdapter = new PreviewGalleryAdapter(this.selectorConfig, this.isInternalBottomPreview);
            notifyGallerySelectMedia(this.mData.get(this.curPosition));
            this.mGalleryRecycle.setAdapter(this.mGalleryAdapter);
            this.mGalleryAdapter.setItemClickListener(new PreviewGalleryAdapter.OnItemClickListener() {
                public void onItemClick(final int i11, LocalMedia localMedia, View view) {
                    if (i11 != -1) {
                        String string = TextUtils.isEmpty(PictureSelectorPreviewFragment.this.selectorConfig.defaultAlbumName) ? PictureSelectorPreviewFragment.this.getString(R.string.ps_camera_roll) : PictureSelectorPreviewFragment.this.selectorConfig.defaultAlbumName;
                        PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                        if (pictureSelectorPreviewFragment.isInternalBottomPreview || TextUtils.equals(pictureSelectorPreviewFragment.currentAlbum, string) || TextUtils.equals(localMedia.getParentFolderName(), PictureSelectorPreviewFragment.this.currentAlbum)) {
                            PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                            if (!pictureSelectorPreviewFragment2.isInternalBottomPreview) {
                                i11 = pictureSelectorPreviewFragment2.isShowCamera ? localMedia.position - 1 : localMedia.position;
                            }
                            if (i11 != pictureSelectorPreviewFragment2.viewPager.getCurrentItem() || !localMedia.isChecked()) {
                                LocalMedia item = PictureSelectorPreviewFragment.this.viewPageAdapter.getItem(i11);
                                if (item == null || (TextUtils.equals(localMedia.getPath(), item.getPath()) && localMedia.getId() == item.getId())) {
                                    if (PictureSelectorPreviewFragment.this.viewPager.getAdapter() != null) {
                                        PictureSelectorPreviewFragment.this.viewPager.setAdapter((RecyclerView.Adapter) null);
                                        PictureSelectorPreviewFragment pictureSelectorPreviewFragment3 = PictureSelectorPreviewFragment.this;
                                        pictureSelectorPreviewFragment3.viewPager.setAdapter(pictureSelectorPreviewFragment3.viewPageAdapter);
                                    }
                                    PictureSelectorPreviewFragment.this.viewPager.setCurrentItem(i11, false);
                                    PictureSelectorPreviewFragment.this.notifyGallerySelectMedia(localMedia);
                                    PictureSelectorPreviewFragment.this.viewPager.post(new Runnable() {
                                        public void run() {
                                            if (PictureSelectorPreviewFragment.this.selectorConfig.isPreviewZoomEffect) {
                                                PictureSelectorPreviewFragment.this.viewPageAdapter.setVideoPlayButtonUI(i11);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            });
            if (this.selectorConfig.getSelectCount() > 0) {
                this.mGalleryRecycle.setVisibility(0);
            } else {
                this.mGalleryRecycle.setVisibility(4);
            }
            addAminViews(this.mGalleryRecycle);
            final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
                public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    int lastCheckPosition;
                    viewHolder.itemView.setAlpha(1.0f);
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    if (pictureSelectorPreviewFragment.needScaleSmall) {
                        pictureSelectorPreviewFragment.needScaleSmall = false;
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", new float[]{1.1f, 1.0f}), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", new float[]{1.1f, 1.0f})});
                        animatorSet.setInterpolator(new LinearInterpolator());
                        animatorSet.setDuration(50);
                        animatorSet.start();
                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                PictureSelectorPreviewFragment.this.needScaleBig = true;
                            }
                        });
                    }
                    super.clearView(recyclerView, viewHolder);
                    PictureSelectorPreviewFragment.this.mGalleryAdapter.notifyItemChanged(viewHolder.getAbsoluteAdapterPosition());
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                    if (!(!pictureSelectorPreviewFragment2.isInternalBottomPreview || PictureSelectorPreviewFragment.this.viewPager.getCurrentItem() == (lastCheckPosition = pictureSelectorPreviewFragment2.mGalleryAdapter.getLastCheckPosition()) || lastCheckPosition == -1)) {
                        if (PictureSelectorPreviewFragment.this.viewPager.getAdapter() != null) {
                            PictureSelectorPreviewFragment.this.viewPager.setAdapter((RecyclerView.Adapter) null);
                            PictureSelectorPreviewFragment pictureSelectorPreviewFragment3 = PictureSelectorPreviewFragment.this;
                            pictureSelectorPreviewFragment3.viewPager.setAdapter(pictureSelectorPreviewFragment3.viewPageAdapter);
                        }
                        PictureSelectorPreviewFragment.this.viewPager.setCurrentItem(lastCheckPosition, false);
                    }
                    if (PictureSelectorPreviewFragment.this.selectorConfig.selectorStyle.getSelectMainStyle().isSelectNumberStyle() && !ActivityCompatHelper.isDestroy(PictureSelectorPreviewFragment.this.getActivity())) {
                        List<Fragment> B0 = PictureSelectorPreviewFragment.this.getActivity().getSupportFragmentManager().B0();
                        for (int i11 = 0; i11 < B0.size(); i11++) {
                            Fragment fragment = B0.get(i11);
                            if (fragment instanceof PictureCommonFragment) {
                                ((PictureCommonFragment) fragment).sendChangeSubSelectPositionEvent(true);
                            }
                        }
                    }
                }

                public long getAnimationDuration(RecyclerView recyclerView, int i11, float f11, float f12) {
                    return super.getAnimationDuration(recyclerView, i11, f11, f12);
                }

                public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    viewHolder.itemView.setAlpha(0.7f);
                    return ItemTouchHelper.Callback.makeMovementFlags(12, 0);
                }

                public boolean isLongPressDragEnabled() {
                    return true;
                }

                public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f11, float f12, int i11, boolean z11) {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    if (pictureSelectorPreviewFragment.needScaleBig) {
                        pictureSelectorPreviewFragment.needScaleBig = false;
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", new float[]{1.0f, 1.1f}), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", new float[]{1.0f, 1.1f})});
                        animatorSet.setDuration(50);
                        animatorSet.setInterpolator(new LinearInterpolator());
                        animatorSet.start();
                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                PictureSelectorPreviewFragment.this.needScaleSmall = true;
                            }
                        });
                    }
                    super.onChildDraw(canvas, recyclerView, viewHolder, f11, f12, i11, z11);
                }

                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                    try {
                        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                        int absoluteAdapterPosition2 = viewHolder2.getAbsoluteAdapterPosition();
                        if (absoluteAdapterPosition < absoluteAdapterPosition2) {
                            int i11 = absoluteAdapterPosition;
                            while (i11 < absoluteAdapterPosition2) {
                                int i12 = i11 + 1;
                                Collections.swap(PictureSelectorPreviewFragment.this.mGalleryAdapter.getData(), i11, i12);
                                Collections.swap(PictureSelectorPreviewFragment.this.selectorConfig.getSelectedResult(), i11, i12);
                                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                                if (pictureSelectorPreviewFragment.isInternalBottomPreview) {
                                    Collections.swap(pictureSelectorPreviewFragment.mData, i11, i12);
                                }
                                i11 = i12;
                            }
                        } else {
                            for (int i13 = absoluteAdapterPosition; i13 > absoluteAdapterPosition2; i13--) {
                                int i14 = i13 - 1;
                                Collections.swap(PictureSelectorPreviewFragment.this.mGalleryAdapter.getData(), i13, i14);
                                Collections.swap(PictureSelectorPreviewFragment.this.selectorConfig.getSelectedResult(), i13, i14);
                                PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                                if (pictureSelectorPreviewFragment2.isInternalBottomPreview) {
                                    Collections.swap(pictureSelectorPreviewFragment2.mData, i13, i14);
                                }
                            }
                        }
                        PictureSelectorPreviewFragment.this.mGalleryAdapter.notifyItemMoved(absoluteAdapterPosition, absoluteAdapterPosition2);
                        return true;
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        return true;
                    }
                }

                public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i11) {
                    super.onSelectedChanged(viewHolder, i11);
                }

                public void onSwiped(RecyclerView.ViewHolder viewHolder, int i11) {
                }
            });
            itemTouchHelper.b(this.mGalleryRecycle);
            this.mGalleryAdapter.setItemLongClickListener(new PreviewGalleryAdapter.OnItemLongClickListener() {
                public void onItemLongClick(RecyclerView.ViewHolder viewHolder, int i11, View view) {
                    ((Vibrator) PictureSelectorPreviewFragment.this.getActivity().getSystemService("vibrator")).vibrate(50);
                    if (PictureSelectorPreviewFragment.this.mGalleryAdapter.getItemCount() != PictureSelectorPreviewFragment.this.selectorConfig.maxSelectNum) {
                        itemTouchHelper.w(viewHolder);
                    } else if (viewHolder.getLayoutPosition() != PictureSelectorPreviewFragment.this.mGalleryAdapter.getItemCount() - 1) {
                        itemTouchHelper.w(viewHolder);
                    }
                }
            });
        }
    }

    public boolean isSelected(LocalMedia localMedia) {
        return this.selectorConfig.getSelectedResult().contains(localMedia);
    }

    public void notifySelectNumberStyle(LocalMedia localMedia) {
        if (this.selectorConfig.selectorStyle.getSelectMainStyle().isPreviewSelectNumberStyle() && this.selectorConfig.selectorStyle.getSelectMainStyle().isSelectNumberStyle()) {
            this.tvSelected.setText("");
            for (int i11 = 0; i11 < this.selectorConfig.getSelectCount(); i11++) {
                LocalMedia localMedia2 = this.selectorConfig.getSelectedResult().get(i11);
                if (TextUtils.equals(localMedia2.getPath(), localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                    localMedia.setNum(localMedia2.getNum());
                    localMedia2.setPosition(localMedia.getPosition());
                    this.tvSelected.setText(ValueOf.toString(Integer.valueOf(localMedia.getNum())));
                }
            }
        }
    }

    public void onCheckOriginalChange() {
        this.bottomNarBar.setOriginalCheck();
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i11;
        super.onConfigurationChanged(configuration);
        if (isHasMagicalEffect() && this.mData.size() > (i11 = this.curPosition)) {
            LocalMedia localMedia = this.mData.get(i11);
            if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                getVideoRealSizeFromMedia(localMedia, false, new OnCallbackListener<int[]>() {
                    public void onCall(int[] iArr) {
                        PictureSelectorPreviewFragment.this.changeViewParams(iArr);
                    }
                });
            } else {
                getImageRealSizeFromMedia(localMedia, false, new OnCallbackListener<int[]>() {
                    public void onCall(int[] iArr) {
                        PictureSelectorPreviewFragment.this.changeViewParams(iArr);
                    }
                });
            }
        }
    }

    public Animation onCreateAnimation(int i11, boolean z11, int i12) {
        if (isHasMagicalEffect()) {
            return null;
        }
        PictureWindowAnimationStyle windowAnimationStyle = this.selectorConfig.selectorStyle.getWindowAnimationStyle();
        if (windowAnimationStyle.activityPreviewEnterAnimation == 0 || windowAnimationStyle.activityPreviewExitAnimation == 0) {
            return super.onCreateAnimation(i11, z11, i12);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), z11 ? windowAnimationStyle.activityPreviewEnterAnimation : windowAnimationStyle.activityPreviewExitAnimation);
        if (z11) {
            onEnterFragment();
        } else {
            onExitFragment();
        }
        return loadAnimation;
    }

    public void onCreateLoader() {
        IBridgeMediaLoader iBridgeMediaLoader;
        if (!this.isExternalPreview) {
            SelectorConfig selectorConfig = this.selectorConfig;
            IBridgeLoaderFactory iBridgeLoaderFactory = selectorConfig.loaderFactory;
            if (iBridgeLoaderFactory != null) {
                IBridgeMediaLoader onCreateLoader = iBridgeLoaderFactory.onCreateLoader();
                this.mLoader = onCreateLoader;
                if (onCreateLoader == null) {
                    throw new NullPointerException("No available " + IBridgeMediaLoader.class + " loader found");
                }
                return;
            }
            if (selectorConfig.isPageStrategy) {
                iBridgeMediaLoader = new LocalMediaPageLoader(getAppContext(), this.selectorConfig);
            } else {
                iBridgeMediaLoader = new LocalMediaLoader(getAppContext(), this.selectorConfig);
            }
            this.mLoader = iBridgeMediaLoader;
        }
    }

    public void onDestroy() {
        PicturePreviewAdapter picturePreviewAdapter = this.viewPageAdapter;
        if (picturePreviewAdapter != null) {
            picturePreviewAdapter.destroy();
        }
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.unregisterOnPageChangeCallback(this.pageChangeCallback);
        }
        super.onDestroy();
    }

    public void onEditMedia(Intent intent) {
        if (this.mData.size() > this.viewPager.getCurrentItem()) {
            LocalMedia localMedia = this.mData.get(this.viewPager.getCurrentItem());
            Uri output = Crop.getOutput(intent);
            localMedia.setCutPath(output != null ? output.getPath() : "");
            localMedia.setCropImageWidth(Crop.getOutputImageWidth(intent));
            localMedia.setCropImageHeight(Crop.getOutputImageHeight(intent));
            localMedia.setCropOffsetX(Crop.getOutputImageOffsetX(intent));
            localMedia.setCropOffsetY(Crop.getOutputImageOffsetY(intent));
            localMedia.setCropResultAspectRatio(Crop.getOutputCropAspectRatio(intent));
            localMedia.setCut(!TextUtils.isEmpty(localMedia.getCutPath()));
            localMedia.setCustomData(Crop.getOutputCustomExtraData(intent));
            localMedia.setEditorImage(localMedia.isCut());
            localMedia.setSandboxPath(localMedia.getCutPath());
            if (this.selectorConfig.getSelectedResult().contains(localMedia)) {
                LocalMedia compareLocalMedia = localMedia.getCompareLocalMedia();
                if (compareLocalMedia != null) {
                    compareLocalMedia.setCutPath(localMedia.getCutPath());
                    compareLocalMedia.setCut(localMedia.isCut());
                    compareLocalMedia.setEditorImage(localMedia.isEditorImage());
                    compareLocalMedia.setCustomData(localMedia.getCustomData());
                    compareLocalMedia.setSandboxPath(localMedia.getCutPath());
                    compareLocalMedia.setCropImageWidth(Crop.getOutputImageWidth(intent));
                    compareLocalMedia.setCropImageHeight(Crop.getOutputImageHeight(intent));
                    compareLocalMedia.setCropOffsetX(Crop.getOutputImageOffsetX(intent));
                    compareLocalMedia.setCropOffsetY(Crop.getOutputImageOffsetY(intent));
                    compareLocalMedia.setCropResultAspectRatio(Crop.getOutputCropAspectRatio(intent));
                }
                sendFixedSelectedChangeEvent(localMedia);
            } else {
                confirmSelect(localMedia, false);
            }
            this.viewPageAdapter.notifyItemChanged(this.viewPager.getCurrentItem());
            notifyGallerySelectMedia(localMedia);
        }
    }

    public void onExitFragment() {
        if (this.selectorConfig.isPreviewFullScreenMode) {
            hideFullScreenStatusBar();
        }
    }

    public void onExitPictureSelector() {
        PicturePreviewAdapter picturePreviewAdapter = this.viewPageAdapter;
        if (picturePreviewAdapter != null) {
            picturePreviewAdapter.destroy();
        }
        super.onExitPictureSelector();
    }

    public void onKeyBackFragmentFinish() {
        onKeyDownBackToMin();
    }

    public void onMojitoBackgroundAlpha(float f11) {
        for (int i11 = 0; i11 < this.mAnimViews.size(); i11++) {
            if (!(this.mAnimViews.get(i11) instanceof TitleBar)) {
                this.mAnimViews.get(i11).setAlpha(f11);
            }
        }
    }

    public void onMojitoBeginAnimComplete(MagicalView magicalView2, boolean z11) {
        int i11;
        int i12;
        BasePreviewHolder currentHolder = this.viewPageAdapter.getCurrentHolder(this.viewPager.getCurrentItem());
        if (currentHolder != null) {
            LocalMedia localMedia = this.mData.get(this.viewPager.getCurrentItem());
            if (!localMedia.isCut() || localMedia.getCropImageWidth() <= 0 || localMedia.getCropImageHeight() <= 0) {
                i12 = localMedia.getWidth();
                i11 = localMedia.getHeight();
            } else {
                i12 = localMedia.getCropImageWidth();
                i11 = localMedia.getCropImageHeight();
            }
            if (MediaUtils.isLongImage(i12, i11)) {
                currentHolder.coverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                currentHolder.coverImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            if (currentHolder instanceof PreviewVideoHolder) {
                PreviewVideoHolder previewVideoHolder = (PreviewVideoHolder) currentHolder;
                if (this.selectorConfig.isAutoVideoPlay) {
                    startAutoVideoPlay(this.viewPager.getCurrentItem());
                } else if (previewVideoHolder.ivPlayButton.getVisibility() == 8 && !isPlaying()) {
                    previewVideoHolder.ivPlayButton.setVisibility(0);
                }
            }
        }
    }

    public void onMojitoBeginBackMinAnim() {
        BasePreviewHolder currentHolder = this.viewPageAdapter.getCurrentHolder(this.viewPager.getCurrentItem());
        if (currentHolder != null) {
            if (currentHolder.coverImageView.getVisibility() == 8) {
                currentHolder.coverImageView.setVisibility(0);
            }
            if (currentHolder instanceof PreviewVideoHolder) {
                PreviewVideoHolder previewVideoHolder = (PreviewVideoHolder) currentHolder;
                if (previewVideoHolder.ivPlayButton.getVisibility() == 0) {
                    previewVideoHolder.ivPlayButton.setVisibility(8);
                }
            }
        }
    }

    public void onMojitoBeginBackMinFinish(boolean z11) {
        BasePreviewHolder currentHolder;
        ViewParams itemViewParams = BuildRecycleItemViewParams.getItemViewParams(this.isShowCamera ? this.curPosition + 1 : this.curPosition);
        if (itemViewParams != null && (currentHolder = this.viewPageAdapter.getCurrentHolder(this.viewPager.getCurrentItem())) != null) {
            currentHolder.coverImageView.getLayoutParams().width = itemViewParams.width;
            currentHolder.coverImageView.getLayoutParams().height = itemViewParams.height;
            currentHolder.coverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void onMojitoMagicalViewFinish() {
        if (!this.isExternalPreview || !isNormalDefaultEnter() || !isHasMagicalEffect()) {
            onBackCurrentFragment();
        } else {
            onExitPictureSelector();
        }
    }

    public void onPause() {
        super.onPause();
        if (isPlaying()) {
            resumePausePlay();
            this.isPause = true;
        }
    }

    public void onResume() {
        super.onResume();
        if (this.isPause) {
            resumePausePlay();
            this.isPause = false;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PictureConfig.EXTRA_CURRENT_PAGE, this.mPage);
        bundle.putLong(PictureConfig.EXTRA_CURRENT_BUCKET_ID, this.mBucketId);
        bundle.putInt(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, this.curPosition);
        bundle.putInt(PictureConfig.EXTRA_PREVIEW_CURRENT_ALBUM_TOTAL, this.totalNum);
        bundle.putBoolean(PictureConfig.EXTRA_EXTERNAL_PREVIEW, this.isExternalPreview);
        bundle.putBoolean(PictureConfig.EXTRA_EXTERNAL_PREVIEW_DISPLAY_DELETE, this.isDisplayDelete);
        bundle.putBoolean(PictureConfig.EXTRA_DISPLAY_CAMERA, this.isShowCamera);
        bundle.putBoolean(PictureConfig.EXTRA_BOTTOM_PREVIEW, this.isInternalBottomPreview);
        bundle.putString(PictureConfig.EXTRA_CURRENT_ALBUM_NAME, this.currentAlbum);
        this.selectorConfig.addSelectedPreviewResult(this.mData);
    }

    public void onSelectedChange(boolean z11, LocalMedia localMedia) {
        this.tvSelected.setSelected(this.selectorConfig.getSelectedResult().contains(localMedia));
        this.bottomNarBar.setSelectedChange();
        this.completeSelectView.setSelectedChange(true);
        notifySelectNumberStyle(localMedia);
        notifyPreviewGalleryData(z11, localMedia);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        reStartSavedInstance(bundle);
        this.isSaveInstanceState = bundle != null;
        this.screenWidth = DensityUtil.getRealScreenWidth(getContext());
        this.screenHeight = DensityUtil.getScreenHeight(getContext());
        this.titleBar = (PreviewTitleBar) view.findViewById(R.id.title_bar);
        this.tvSelected = (TextView) view.findViewById(R.id.ps_tv_selected);
        this.tvSelectedWord = (TextView) view.findViewById(R.id.ps_tv_selected_word);
        this.selectClickArea = view.findViewById(R.id.select_click_area);
        this.completeSelectView = (CompleteSelectView) view.findViewById(R.id.ps_complete_select);
        this.magicalView = (MagicalView) view.findViewById(R.id.magical);
        this.viewPager = new ViewPager2(getContext());
        this.bottomNarBar = (PreviewBottomNavBar) view.findViewById(R.id.bottom_nar_bar);
        this.magicalView.setMagicalContent(this.viewPager);
        setMagicalViewBackgroundColor();
        setMagicalViewAction();
        addAminViews(this.titleBar, this.tvSelected, this.tvSelectedWord, this.selectClickArea, this.completeSelectView, this.bottomNarBar);
        onCreateLoader();
        initTitleBar();
        initViewPagerData(this.mData);
        if (this.isExternalPreview) {
            externalPreviewStyle();
        } else {
            initBottomNavBar();
            initPreviewSelectGallery((ViewGroup) view);
            initComplete();
        }
        iniMagicalView();
    }

    public void reStartSavedInstance(Bundle bundle) {
        if (bundle != null) {
            this.mPage = bundle.getInt(PictureConfig.EXTRA_CURRENT_PAGE, 1);
            this.mBucketId = bundle.getLong(PictureConfig.EXTRA_CURRENT_BUCKET_ID, -1);
            this.curPosition = bundle.getInt(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, this.curPosition);
            this.isShowCamera = bundle.getBoolean(PictureConfig.EXTRA_DISPLAY_CAMERA, this.isShowCamera);
            this.totalNum = bundle.getInt(PictureConfig.EXTRA_PREVIEW_CURRENT_ALBUM_TOTAL, this.totalNum);
            this.isExternalPreview = bundle.getBoolean(PictureConfig.EXTRA_EXTERNAL_PREVIEW, this.isExternalPreview);
            this.isDisplayDelete = bundle.getBoolean(PictureConfig.EXTRA_EXTERNAL_PREVIEW_DISPLAY_DELETE, this.isDisplayDelete);
            this.isInternalBottomPreview = bundle.getBoolean(PictureConfig.EXTRA_BOTTOM_PREVIEW, this.isInternalBottomPreview);
            this.currentAlbum = bundle.getString(PictureConfig.EXTRA_CURRENT_ALBUM_NAME, "");
            if (this.mData.size() == 0) {
                this.mData.addAll(new ArrayList(this.selectorConfig.selectedPreviewResult));
            }
        }
    }

    public void sendChangeSubSelectPositionEvent(boolean z11) {
        if (this.selectorConfig.selectorStyle.getSelectMainStyle().isPreviewSelectNumberStyle() && this.selectorConfig.selectorStyle.getSelectMainStyle().isSelectNumberStyle()) {
            int i11 = 0;
            while (i11 < this.selectorConfig.getSelectCount()) {
                i11++;
                this.selectorConfig.getSelectedResult().get(i11).setNum(i11);
            }
        }
    }

    public void setExternalPreviewData(int i11, int i12, ArrayList<LocalMedia> arrayList, boolean z11) {
        this.mData = arrayList;
        this.totalNum = i12;
        this.curPosition = i11;
        this.isDisplayDelete = z11;
        this.isExternalPreview = true;
    }

    public void setInternalPreviewData(boolean z11, String str, boolean z12, int i11, int i12, int i13, long j11, ArrayList<LocalMedia> arrayList) {
        this.mPage = i13;
        this.mBucketId = j11;
        this.mData = arrayList;
        this.totalNum = i12;
        this.curPosition = i11;
        this.currentAlbum = str;
        this.isShowCamera = z12;
        this.isInternalBottomPreview = z11;
    }

    public void setMagicalViewAction() {
        if (isHasMagicalEffect()) {
            this.magicalView.setOnMojitoViewCallback(new OnMagicalViewCallback() {
                public void onBackgroundAlpha(float f11) {
                    PictureSelectorPreviewFragment.this.onMojitoBackgroundAlpha(f11);
                }

                public void onBeginBackMinAnim() {
                    PictureSelectorPreviewFragment.this.onMojitoBeginBackMinAnim();
                }

                public void onBeginBackMinMagicalFinish(boolean z11) {
                    PictureSelectorPreviewFragment.this.onMojitoBeginBackMinFinish(z11);
                }

                public void onBeginMagicalAnimComplete(MagicalView magicalView, boolean z11) {
                    PictureSelectorPreviewFragment.this.onMojitoBeginAnimComplete(magicalView, z11);
                }

                public void onMagicalViewFinish() {
                    PictureSelectorPreviewFragment.this.onMojitoMagicalViewFinish();
                }
            });
        }
    }

    public void startZoomEffect(LocalMedia localMedia) {
        if (!this.isSaveInstanceState && !this.isInternalBottomPreview && this.selectorConfig.isPreviewZoomEffect) {
            this.viewPager.post(new Runnable() {
                public void run() {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    pictureSelectorPreviewFragment.viewPageAdapter.setCoverScaleType(pictureSelectorPreviewFragment.curPosition);
                }
            });
            if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                getVideoRealSizeFromMedia(localMedia, !PictureMimeType.isHasHttp(localMedia.getAvailablePath()), new OnCallbackListener<int[]>() {
                    public void onCall(int[] iArr) {
                        PictureSelectorPreviewFragment.this.start(iArr);
                    }
                });
            } else {
                getImageRealSizeFromMedia(localMedia, !PictureMimeType.isHasHttp(localMedia.getAvailablePath()), new OnCallbackListener<int[]>() {
                    public void onCall(int[] iArr) {
                        PictureSelectorPreviewFragment.this.start(iArr);
                    }
                });
            }
        }
    }
}
