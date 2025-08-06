package com.luck.picture.lib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.animators.AlphaInAnimationAdapter;
import com.luck.picture.lib.animators.SlideInBottomAnimationAdapter;
import com.luck.picture.lib.basic.FragmentInjectManager;
import com.luck.picture.lib.basic.IBridgeLoaderFactory;
import com.luck.picture.lib.basic.IPictureSelectorEvent;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.dialog.AlbumListPopWindow;
import com.luck.picture.lib.engine.ExtendLoaderEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnAlbumItemClickListener;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnPreviewInterceptListener;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewPreloadMoreListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewScrollListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener;
import com.luck.picture.lib.interfaces.OnRequestPermissionListener;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.loader.LocalMediaLoader;
import com.luck.picture.lib.loader.LocalMediaPageLoader;
import com.luck.picture.lib.magical.BuildRecycleItemViewParams;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.AnimUtils;
import com.luck.picture.lib.utils.DateUtils;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.utils.ToastUtils;
import com.luck.picture.lib.utils.ValueOf;
import com.luck.picture.lib.widget.BottomNavBar;
import com.luck.picture.lib.widget.CompleteSelectView;
import com.luck.picture.lib.widget.RecyclerPreloadView;
import com.luck.picture.lib.widget.SlideSelectTouchListener;
import com.luck.picture.lib.widget.SlideSelectionHandler;
import com.luck.picture.lib.widget.TitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PictureSelectorFragment extends PictureCommonFragment implements OnRecyclerViewPreloadMoreListener, IPictureSelectorEvent {
    private static final Object LOCK = new Object();
    /* access modifiers changed from: private */
    public static int SELECT_ANIM_DURATION = 135;
    public static final String TAG = PictureSelectorFragment.class.getSimpleName();
    /* access modifiers changed from: private */
    public AlbumListPopWindow albumListPopWindow;
    private int allFolderSize;
    private BottomNavBar bottomNarBar;
    private CompleteSelectView completeSelectView;
    /* access modifiers changed from: private */
    public int currentPosition = -1;
    /* access modifiers changed from: private */
    public long intervalClickTime = 0;
    private boolean isCameraCallback;
    /* access modifiers changed from: private */
    public boolean isDisplayCamera;
    private boolean isMemoryRecycling;
    /* access modifiers changed from: private */
    public PictureImageGridAdapter mAdapter;
    /* access modifiers changed from: private */
    public SlideSelectTouchListener mDragSelectTouchListener;
    /* access modifiers changed from: private */
    public RecyclerPreloadView mRecycler;
    /* access modifiers changed from: private */
    public TitleBar titleBar;
    private TextView tvCurrentDataTime;
    private TextView tvDataEmpty;

    private void addAlbumPopWindowAction() {
        this.albumListPopWindow.setOnIBridgeAlbumWidget(new OnAlbumItemClickListener() {
            public void onItemClick(int i11, LocalMediaFolder localMediaFolder) {
                PictureSelectorFragment pictureSelectorFragment = PictureSelectorFragment.this;
                boolean unused = pictureSelectorFragment.isDisplayCamera = pictureSelectorFragment.selectorConfig.isDisplayCamera && localMediaFolder.getBucketId() == -1;
                PictureSelectorFragment.this.mAdapter.setDisplayCamera(PictureSelectorFragment.this.isDisplayCamera);
                PictureSelectorFragment.this.titleBar.setTitle(localMediaFolder.getFolderName());
                LocalMediaFolder localMediaFolder2 = PictureSelectorFragment.this.selectorConfig.currentLocalMediaFolder;
                long bucketId = localMediaFolder2.getBucketId();
                if (PictureSelectorFragment.this.selectorConfig.isPageStrategy) {
                    if (localMediaFolder.getBucketId() != bucketId) {
                        localMediaFolder2.setData(PictureSelectorFragment.this.mAdapter.getData());
                        localMediaFolder2.setCurrentDataPage(PictureSelectorFragment.this.mPage);
                        localMediaFolder2.setHasMore(PictureSelectorFragment.this.mRecycler.isEnabledLoadMore());
                        if (localMediaFolder.getData().size() <= 0 || localMediaFolder.isHasMore()) {
                            int unused2 = PictureSelectorFragment.this.mPage = 1;
                            if (PictureSelectorFragment.this.selectorConfig.loaderDataEngine != null) {
                                PictureSelectorFragment.this.selectorConfig.loaderDataEngine.loadFirstPageMediaData(PictureSelectorFragment.this.getContext(), localMediaFolder.getBucketId(), PictureSelectorFragment.this.mPage, PictureSelectorFragment.this.selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() {
                                    public void onComplete(ArrayList<LocalMedia> arrayList, boolean z11) {
                                        PictureSelectorFragment.this.handleSwitchAlbum(arrayList, z11);
                                    }
                                });
                            } else {
                                PictureSelectorFragment.this.mLoader.loadPageMediaData(localMediaFolder.getBucketId(), PictureSelectorFragment.this.mPage, PictureSelectorFragment.this.selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() {
                                    public void onComplete(ArrayList<LocalMedia> arrayList, boolean z11) {
                                        PictureSelectorFragment.this.handleSwitchAlbum(arrayList, z11);
                                    }
                                });
                            }
                        } else {
                            PictureSelectorFragment.this.setAdapterData(localMediaFolder.getData());
                            int unused3 = PictureSelectorFragment.this.mPage = localMediaFolder.getCurrentDataPage();
                            PictureSelectorFragment.this.mRecycler.setEnabledLoadMore(localMediaFolder.isHasMore());
                            PictureSelectorFragment.this.mRecycler.smoothScrollToPosition(0);
                        }
                    }
                } else if (localMediaFolder.getBucketId() != bucketId) {
                    PictureSelectorFragment.this.setAdapterData(localMediaFolder.getData());
                    PictureSelectorFragment.this.mRecycler.smoothScrollToPosition(0);
                }
                PictureSelectorFragment.this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
                PictureSelectorFragment.this.albumListPopWindow.dismiss();
                if (PictureSelectorFragment.this.mDragSelectTouchListener != null && PictureSelectorFragment.this.selectorConfig.isFastSlidingSelect) {
                    PictureSelectorFragment.this.mDragSelectTouchListener.setRecyclerViewHeaderCount(PictureSelectorFragment.this.mAdapter.isDisplayCamera() ? 1 : 0);
                }
            }
        });
    }

    private void addRecyclerAction() {
        this.mAdapter.setOnItemClickListener(new PictureImageGridAdapter.OnItemClickListener() {
            public void onItemClick(View view, int i11, LocalMedia localMedia) {
                if (PictureSelectorFragment.this.selectorConfig.selectionMode == 1 && PictureSelectorFragment.this.selectorConfig.isDirectReturnSingle) {
                    PictureSelectorFragment.this.selectorConfig.selectedResult.clear();
                    if (PictureSelectorFragment.this.confirmSelect(localMedia, false) == 0) {
                        PictureSelectorFragment.this.dispatchTransformResult();
                    }
                } else if (!DoubleUtils.isFastDoubleClick()) {
                    PictureSelectorFragment.this.onStartPreview(i11, false);
                }
            }

            public void onItemLongClick(View view, int i11) {
                if (PictureSelectorFragment.this.mDragSelectTouchListener != null && PictureSelectorFragment.this.selectorConfig.isFastSlidingSelect) {
                    ((Vibrator) PictureSelectorFragment.this.getActivity().getSystemService("vibrator")).vibrate(50);
                    PictureSelectorFragment.this.mDragSelectTouchListener.startSlideSelection(i11);
                }
            }

            public int onSelected(View view, int i11, LocalMedia localMedia) {
                int confirmSelect = PictureSelectorFragment.this.confirmSelect(localMedia, view.isSelected());
                if (confirmSelect == 0) {
                    if (PictureSelectorFragment.this.selectorConfig.onSelectAnimListener != null) {
                        long onSelectAnim = PictureSelectorFragment.this.selectorConfig.onSelectAnimListener.onSelectAnim(view);
                        if (onSelectAnim > 0) {
                            int unused = PictureSelectorFragment.SELECT_ANIM_DURATION = (int) onSelectAnim;
                        }
                    } else {
                        Animation loadAnimation = AnimationUtils.loadAnimation(PictureSelectorFragment.this.getContext(), R.anim.ps_anim_modal_in);
                        int unused2 = PictureSelectorFragment.SELECT_ANIM_DURATION = (int) loadAnimation.getDuration();
                        view.startAnimation(loadAnimation);
                    }
                }
                return confirmSelect;
            }

            public void openCameraClick() {
                if (!DoubleUtils.isFastDoubleClick()) {
                    PictureSelectorFragment.this.openSelectedCamera();
                }
            }
        });
        this.mRecycler.setOnRecyclerViewScrollStateListener(new OnRecyclerViewScrollStateListener() {
            public void onScrollFast() {
                if (PictureSelectorFragment.this.selectorConfig.imageEngine != null) {
                    PictureSelectorFragment.this.selectorConfig.imageEngine.pauseRequests(PictureSelectorFragment.this.getContext());
                }
            }

            public void onScrollSlow() {
                if (PictureSelectorFragment.this.selectorConfig.imageEngine != null) {
                    PictureSelectorFragment.this.selectorConfig.imageEngine.resumeRequests(PictureSelectorFragment.this.getContext());
                }
            }
        });
        this.mRecycler.setOnRecyclerViewScrollListener(new OnRecyclerViewScrollListener() {
            public void onScrollStateChanged(int i11) {
                if (i11 == 1) {
                    PictureSelectorFragment.this.showCurrentMediaCreateTimeUI();
                } else if (i11 == 0) {
                    PictureSelectorFragment.this.hideCurrentMediaCreateTimeUI();
                }
            }

            public void onScrolled(int i11, int i12) {
                PictureSelectorFragment.this.setCurrentMediaCreateTimeText();
            }
        });
        if (this.selectorConfig.isFastSlidingSelect) {
            final HashSet hashSet = new HashSet();
            SlideSelectTouchListener withSelectListener = new SlideSelectTouchListener().setRecyclerViewHeaderCount(this.mAdapter.isDisplayCamera() ? 1 : 0).withSelectListener(new SlideSelectionHandler(new SlideSelectionHandler.ISelectionHandler() {
                public void changeSelection(int i11, int i12, boolean z11, boolean z12) {
                    ArrayList<LocalMedia> data = PictureSelectorFragment.this.mAdapter.getData();
                    if (data.size() != 0 && i11 <= data.size()) {
                        LocalMedia localMedia = data.get(i11);
                        PictureSelectorFragment pictureSelectorFragment = PictureSelectorFragment.this;
                        PictureSelectorFragment.this.mDragSelectTouchListener.setActive(pictureSelectorFragment.confirmSelect(localMedia, pictureSelectorFragment.selectorConfig.getSelectedResult().contains(localMedia)) != -1);
                    }
                }

                public HashSet<Integer> getSelection() {
                    for (int i11 = 0; i11 < PictureSelectorFragment.this.selectorConfig.getSelectCount(); i11++) {
                        hashSet.add(Integer.valueOf(PictureSelectorFragment.this.selectorConfig.getSelectedResult().get(i11).position));
                    }
                    return hashSet;
                }
            }));
            this.mDragSelectTouchListener = withSelectListener;
            this.mRecycler.addOnItemTouchListener(withSelectListener);
        }
    }

    /* access modifiers changed from: private */
    public void beginLoadData() {
        onPermissionExplainEvent(false, (String[]) null);
        if (this.selectorConfig.isOnlySandboxDir) {
            loadOnlyInAppDirectoryAllMediaData();
        } else {
            loadAllAlbumData();
        }
    }

    private boolean checkNotifyStrategy(boolean z11) {
        SelectorConfig selectorConfig = this.selectorConfig;
        if (!selectorConfig.isMaxSelectEnabledMask) {
            return false;
        }
        if (selectorConfig.isWithVideoImage) {
            if (selectorConfig.selectionMode == 1) {
                return false;
            }
            int selectCount = selectorConfig.getSelectCount();
            SelectorConfig selectorConfig2 = this.selectorConfig;
            if (selectCount != selectorConfig2.maxSelectNum && (z11 || selectorConfig2.getSelectCount() != this.selectorConfig.maxSelectNum - 1)) {
                return false;
            }
        } else if (selectorConfig.getSelectCount() != 0 && (!z11 || this.selectorConfig.getSelectCount() != 1)) {
            if (PictureMimeType.isHasVideo(this.selectorConfig.getResultFirstMimeType())) {
                SelectorConfig selectorConfig3 = this.selectorConfig;
                int i11 = selectorConfig3.maxVideoSelectNum;
                if (i11 <= 0) {
                    i11 = selectorConfig3.maxSelectNum;
                }
                if (selectorConfig3.getSelectCount() != i11 && (z11 || this.selectorConfig.getSelectCount() != i11 - 1)) {
                    return false;
                }
            } else {
                int selectCount2 = this.selectorConfig.getSelectCount();
                SelectorConfig selectorConfig4 = this.selectorConfig;
                if (selectCount2 != selectorConfig4.maxSelectNum && (z11 || selectorConfig4.getSelectCount() != this.selectorConfig.maxSelectNum - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void handleAllAlbumData(boolean z11, List<LocalMediaFolder> list) {
        LocalMediaFolder localMediaFolder;
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            if (list.size() > 0) {
                if (z11) {
                    localMediaFolder = list.get(0);
                    this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
                } else {
                    localMediaFolder = this.selectorConfig.currentLocalMediaFolder;
                    if (localMediaFolder == null) {
                        localMediaFolder = list.get(0);
                        this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
                    }
                }
                this.titleBar.setTitle(localMediaFolder.getFolderName());
                this.albumListPopWindow.bindAlbumData(list);
                SelectorConfig selectorConfig = this.selectorConfig;
                if (!selectorConfig.isPageStrategy) {
                    setAdapterData(localMediaFolder.getData());
                } else if (selectorConfig.isPreloadFirst) {
                    this.mRecycler.setEnabledLoadMore(true);
                } else {
                    loadFirstPageMediaData(localMediaFolder.getBucketId());
                }
            } else {
                showDataNull();
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleFirstPageMedia(ArrayList<LocalMedia> arrayList, boolean z11) {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            this.mRecycler.setEnabledLoadMore(z11);
            if (!this.mRecycler.isEnabledLoadMore() || arrayList.size() != 0) {
                setAdapterData(arrayList);
            } else {
                onRecyclerViewPreloadMore();
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleInAppDirAllMedia(LocalMediaFolder localMediaFolder) {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            String str = this.selectorConfig.sandboxDir;
            boolean z11 = localMediaFolder != null;
            this.titleBar.setTitle(z11 ? localMediaFolder.getFolderName() : new File(str).getName());
            if (z11) {
                this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
                setAdapterData(localMediaFolder.getData());
                return;
            }
            showDataNull();
        }
    }

    /* access modifiers changed from: private */
    public void handleMoreMediaData(List<LocalMedia> list, boolean z11) {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            this.mRecycler.setEnabledLoadMore(z11);
            if (this.mRecycler.isEnabledLoadMore()) {
                removePageCameraRepeatData(list);
                if (list.size() > 0) {
                    int size = this.mAdapter.getData().size();
                    this.mAdapter.getData().addAll(list);
                    PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
                    pictureImageGridAdapter.notifyItemRangeChanged(size, pictureImageGridAdapter.getItemCount());
                    hideDataNull();
                } else {
                    onRecyclerViewPreloadMore();
                }
                if (list.size() < 10) {
                    RecyclerPreloadView recyclerPreloadView = this.mRecycler;
                    recyclerPreloadView.onScrolled(recyclerPreloadView.getScrollX(), this.mRecycler.getScrollY());
                }
            }
        }
    }

    private void handleRecoverAlbumData(List<LocalMediaFolder> list) {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            if (list.size() > 0) {
                LocalMediaFolder localMediaFolder = this.selectorConfig.currentLocalMediaFolder;
                if (localMediaFolder == null) {
                    localMediaFolder = list.get(0);
                    this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
                }
                this.titleBar.setTitle(localMediaFolder.getFolderName());
                this.albumListPopWindow.bindAlbumData(list);
                if (this.selectorConfig.isPageStrategy) {
                    handleFirstPageMedia(new ArrayList(this.selectorConfig.dataSource), true);
                } else {
                    setAdapterData(localMediaFolder.getData());
                }
            } else {
                showDataNull();
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleSwitchAlbum(ArrayList<LocalMedia> arrayList, boolean z11) {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            this.mRecycler.setEnabledLoadMore(z11);
            if (arrayList.size() == 0) {
                this.mAdapter.getData().clear();
            }
            setAdapterData(arrayList);
            this.mRecycler.onScrolled(0, 0);
            this.mRecycler.smoothScrollToPosition(0);
        }
    }

    /* access modifiers changed from: private */
    public void hideCurrentMediaCreateTimeUI() {
        if (this.selectorConfig.isDisplayTimeAxis && this.mAdapter.getData().size() > 0) {
            this.tvCurrentDataTime.animate().setDuration(250).alpha(0.0f).start();
        }
    }

    private void hideDataNull() {
        if (this.tvDataEmpty.getVisibility() == 0) {
            this.tvDataEmpty.setVisibility(8);
        }
    }

    private void initAlbumListPopWindow() {
        AlbumListPopWindow buildPopWindow = AlbumListPopWindow.buildPopWindow(getContext(), this.selectorConfig);
        this.albumListPopWindow = buildPopWindow;
        buildPopWindow.setOnPopupWindowStatusListener(new AlbumListPopWindow.OnPopupWindowStatusListener() {
            public void onDismissPopupWindow() {
                if (!PictureSelectorFragment.this.selectorConfig.isOnlySandboxDir) {
                    AnimUtils.rotateArrow(PictureSelectorFragment.this.titleBar.getImageArrow(), false);
                }
            }

            public void onShowPopupWindow() {
                if (!PictureSelectorFragment.this.selectorConfig.isOnlySandboxDir) {
                    AnimUtils.rotateArrow(PictureSelectorFragment.this.titleBar.getImageArrow(), true);
                }
            }
        });
        addAlbumPopWindowAction();
    }

    private void initBottomNavBar() {
        this.bottomNarBar.setBottomNavBarStyle();
        this.bottomNarBar.setOnBottomNavBarListener(new BottomNavBar.OnBottomNavBarListener() {
            public void onCheckOriginalChange() {
                PictureSelectorFragment.this.sendSelectedOriginalChangeEvent();
            }

            public void onPreview() {
                PictureSelectorFragment.this.onStartPreview(0, true);
            }
        });
        this.bottomNarBar.setSelectedChange();
    }

    private void initComplete() {
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.selectionMode != 1 || !selectorConfig.isDirectReturnSingle) {
            this.completeSelectView.setCompleteSelectViewStyle();
            this.completeSelectView.setSelectedChange(false);
            if (this.selectorConfig.selectorStyle.getSelectMainStyle().isCompleteSelectRelativeTop()) {
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
            this.completeSelectView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (!PictureSelectorFragment.this.selectorConfig.isEmptyResultReturn || PictureSelectorFragment.this.selectorConfig.getSelectCount() != 0) {
                        PictureSelectorFragment.this.dispatchTransformResult();
                    } else {
                        PictureSelectorFragment.this.onExitPictureSelector();
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            return;
        }
        selectorConfig.selectorStyle.getTitleBarStyle().setHideCancelButton(false);
        this.titleBar.getTitleCancelView().setVisibility(0);
        this.completeSelectView.setVisibility(8);
    }

    private void initRecycler(View view) {
        this.mRecycler = (RecyclerPreloadView) view.findViewById(R.id.recycler);
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        int mainListBackgroundColor = selectMainStyle.getMainListBackgroundColor();
        if (StyleUtils.checkStyleValidity(mainListBackgroundColor)) {
            this.mRecycler.setBackgroundColor(mainListBackgroundColor);
        } else {
            this.mRecycler.setBackgroundColor(ContextCompat.getColor(getAppContext(), R.color.ps_color_black));
        }
        int i11 = this.selectorConfig.imageSpanCount;
        if (i11 <= 0) {
            i11 = 4;
        }
        if (this.mRecycler.getItemDecorationCount() == 0) {
            if (StyleUtils.checkSizeValidity(selectMainStyle.getAdapterItemSpacingSize())) {
                this.mRecycler.addItemDecoration(new GridSpacingItemDecoration(i11, selectMainStyle.getAdapterItemSpacingSize(), selectMainStyle.isAdapterItemIncludeEdge()));
            } else {
                this.mRecycler.addItemDecoration(new GridSpacingItemDecoration(i11, DensityUtil.dip2px(view.getContext(), 1.0f), selectMainStyle.isAdapterItemIncludeEdge()));
            }
        }
        this.mRecycler.setLayoutManager(new GridLayoutManager(getContext(), i11));
        RecyclerView.ItemAnimator itemAnimator = this.mRecycler.getItemAnimator();
        if (itemAnimator != null) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            this.mRecycler.setItemAnimator((RecyclerView.ItemAnimator) null);
        }
        if (this.selectorConfig.isPageStrategy) {
            this.mRecycler.setReachBottomRow(2);
            this.mRecycler.setOnRecyclerViewPreloadListener(this);
        } else {
            this.mRecycler.setHasFixedSize(true);
        }
        PictureImageGridAdapter pictureImageGridAdapter = new PictureImageGridAdapter(getContext(), this.selectorConfig);
        this.mAdapter = pictureImageGridAdapter;
        pictureImageGridAdapter.setDisplayCamera(this.isDisplayCamera);
        int i12 = this.selectorConfig.animationMode;
        if (i12 == 1) {
            this.mRecycler.setAdapter(new AlphaInAnimationAdapter(this.mAdapter));
        } else if (i12 != 2) {
            this.mRecycler.setAdapter(this.mAdapter);
        } else {
            this.mRecycler.setAdapter(new SlideInBottomAnimationAdapter(this.mAdapter));
        }
        addRecyclerAction();
    }

    private void initTitleBar() {
        if (this.selectorConfig.selectorStyle.getTitleBarStyle().isHideTitleBar()) {
            this.titleBar.setVisibility(8);
        }
        this.titleBar.setTitleBarStyle();
        this.titleBar.setOnTitleBarListener(new TitleBar.OnTitleBarListener() {
            public void onBackPressed() {
                if (PictureSelectorFragment.this.albumListPopWindow.isShowing()) {
                    PictureSelectorFragment.this.albumListPopWindow.dismiss();
                } else {
                    PictureSelectorFragment.this.onKeyBackFragmentFinish();
                }
            }

            public void onShowAlbumPopWindow(View view) {
                PictureSelectorFragment.this.albumListPopWindow.showAsDropDown(view);
            }

            public void onTitleDoubleClick() {
                if (!PictureSelectorFragment.this.selectorConfig.isAutomaticTitleRecyclerTop) {
                    return;
                }
                if (SystemClock.uptimeMillis() - PictureSelectorFragment.this.intervalClickTime >= ((long) 500) || PictureSelectorFragment.this.mAdapter.getItemCount() <= 0) {
                    long unused = PictureSelectorFragment.this.intervalClickTime = SystemClock.uptimeMillis();
                } else {
                    PictureSelectorFragment.this.mRecycler.scrollToPosition(0);
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r1 = r2.allFolderSize;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isAddSameImp(int r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r2.allFolderSize
            if (r1 <= 0) goto L_0x000b
            if (r1 >= r3) goto L_0x000b
            r0 = 1
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorFragment.isAddSameImp(int):boolean");
    }

    private void mergeFolder(LocalMedia localMedia) {
        LocalMediaFolder localMediaFolder;
        String str;
        List<LocalMediaFolder> albumList = this.albumListPopWindow.getAlbumList();
        if (this.albumListPopWindow.getFolderCount() == 0) {
            localMediaFolder = new LocalMediaFolder();
            if (TextUtils.isEmpty(this.selectorConfig.defaultAlbumName)) {
                str = getString(this.selectorConfig.chooseMode == SelectMimeType.ofAudio() ? R.string.ps_all_audio : R.string.ps_camera_roll);
            } else {
                str = this.selectorConfig.defaultAlbumName;
            }
            localMediaFolder.setFolderName(str);
            localMediaFolder.setFirstImagePath("");
            localMediaFolder.setBucketId(-1);
            albumList.add(0, localMediaFolder);
        } else {
            localMediaFolder = this.albumListPopWindow.getFolder(0);
        }
        localMediaFolder.setFirstImagePath(localMedia.getPath());
        localMediaFolder.setFirstMimeType(localMedia.getMimeType());
        localMediaFolder.setData(this.mAdapter.getData());
        localMediaFolder.setBucketId(-1);
        localMediaFolder.setFolderTotalNum(isAddSameImp(localMediaFolder.getFolderTotalNum()) ? localMediaFolder.getFolderTotalNum() : localMediaFolder.getFolderTotalNum() + 1);
        LocalMediaFolder localMediaFolder2 = this.selectorConfig.currentLocalMediaFolder;
        if (localMediaFolder2 == null || localMediaFolder2.getFolderTotalNum() == 0) {
            this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
        }
        LocalMediaFolder localMediaFolder3 = null;
        int i11 = 0;
        while (true) {
            if (i11 >= albumList.size()) {
                break;
            }
            LocalMediaFolder localMediaFolder4 = albumList.get(i11);
            if (TextUtils.equals(localMediaFolder4.getFolderName(), localMedia.getParentFolderName())) {
                localMediaFolder3 = localMediaFolder4;
                break;
            }
            i11++;
        }
        if (localMediaFolder3 == null) {
            localMediaFolder3 = new LocalMediaFolder();
            albumList.add(localMediaFolder3);
        }
        localMediaFolder3.setFolderName(localMedia.getParentFolderName());
        if (localMediaFolder3.getBucketId() == -1 || localMediaFolder3.getBucketId() == 0) {
            localMediaFolder3.setBucketId(localMedia.getBucketId());
        }
        if (this.selectorConfig.isPageStrategy) {
            localMediaFolder3.setHasMore(true);
        } else if (!isAddSameImp(localMediaFolder.getFolderTotalNum()) || !TextUtils.isEmpty(this.selectorConfig.outPutCameraDir) || !TextUtils.isEmpty(this.selectorConfig.outPutAudioDir)) {
            localMediaFolder3.getData().add(0, localMedia);
        }
        localMediaFolder3.setFolderTotalNum(isAddSameImp(localMediaFolder.getFolderTotalNum()) ? localMediaFolder3.getFolderTotalNum() : localMediaFolder3.getFolderTotalNum() + 1);
        localMediaFolder3.setFirstImagePath(this.selectorConfig.cameraPath);
        localMediaFolder3.setFirstMimeType(localMedia.getMimeType());
        this.albumListPopWindow.bindAlbumData(albumList);
    }

    public static PictureSelectorFragment newInstance() {
        PictureSelectorFragment pictureSelectorFragment = new PictureSelectorFragment();
        pictureSelectorFragment.setArguments(new Bundle());
        return pictureSelectorFragment;
    }

    /* access modifiers changed from: private */
    public void onStartPreview(int i11, boolean z11) {
        ArrayList arrayList;
        long j11;
        int i12;
        FragmentActivity activity = getActivity();
        String str = PictureSelectorPreviewFragment.TAG;
        if (ActivityCompatHelper.checkFragmentNonExits(activity, str)) {
            int i13 = 0;
            if (z11) {
                ArrayList arrayList2 = new ArrayList(this.selectorConfig.getSelectedResult());
                j11 = 0;
                arrayList = arrayList2;
                i12 = arrayList2.size();
            } else {
                ArrayList arrayList3 = new ArrayList(this.mAdapter.getData());
                LocalMediaFolder localMediaFolder = this.selectorConfig.currentLocalMediaFolder;
                if (localMediaFolder != null) {
                    int folderTotalNum = localMediaFolder.getFolderTotalNum();
                    arrayList = arrayList3;
                    j11 = localMediaFolder.getBucketId();
                    i12 = folderTotalNum;
                } else {
                    arrayList = arrayList3;
                    i12 = arrayList3.size();
                    j11 = arrayList3.size() > 0 ? ((LocalMedia) arrayList3.get(0)).getBucketId() : -1;
                }
            }
            if (!z11) {
                SelectorConfig selectorConfig = this.selectorConfig;
                if (selectorConfig.isPreviewZoomEffect) {
                    RecyclerPreloadView recyclerPreloadView = this.mRecycler;
                    if (!selectorConfig.isPreviewFullScreenMode) {
                        i13 = DensityUtil.getStatusBarHeight(getContext());
                    }
                    BuildRecycleItemViewParams.generateViewParams(recyclerPreloadView, i13);
                }
            }
            OnPreviewInterceptListener onPreviewInterceptListener = this.selectorConfig.onPreviewInterceptListener;
            if (onPreviewInterceptListener != null) {
                onPreviewInterceptListener.onPreview(getContext(), i11, i12, this.mPage, j11, this.titleBar.getTitleText(), this.mAdapter.isDisplayCamera(), arrayList, z11);
            } else if (ActivityCompatHelper.checkFragmentNonExits(getActivity(), str)) {
                PictureSelectorPreviewFragment newInstance = PictureSelectorPreviewFragment.newInstance();
                newInstance.setInternalPreviewData(z11, this.titleBar.getTitleText(), this.mAdapter.isDisplayCamera(), i11, i12, this.mPage, j11, arrayList);
                FragmentInjectManager.injectFragment(getActivity(), str, newInstance);
            }
        }
    }

    private boolean preloadPageFirstData() {
        int i11;
        Context context;
        SelectorConfig selectorConfig = this.selectorConfig;
        if (!selectorConfig.isPageStrategy || !selectorConfig.isPreloadFirst) {
            return false;
        }
        LocalMediaFolder localMediaFolder = new LocalMediaFolder();
        localMediaFolder.setBucketId(-1);
        if (TextUtils.isEmpty(this.selectorConfig.defaultAlbumName)) {
            TitleBar titleBar2 = this.titleBar;
            if (this.selectorConfig.chooseMode == SelectMimeType.ofAudio()) {
                context = requireContext();
                i11 = R.string.ps_all_audio;
            } else {
                context = requireContext();
                i11 = R.string.ps_camera_roll;
            }
            titleBar2.setTitle(context.getString(i11));
        } else {
            this.titleBar.setTitle(this.selectorConfig.defaultAlbumName);
        }
        localMediaFolder.setFolderName(this.titleBar.getTitleText());
        this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
        loadFirstPageMediaData(localMediaFolder.getBucketId());
        return true;
    }

    private void recoverSaveInstanceData() {
        this.mAdapter.setDisplayCamera(this.isDisplayCamera);
        setEnterAnimationDuration(0);
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.isOnlySandboxDir) {
            handleInAppDirAllMedia(selectorConfig.currentLocalMediaFolder);
        } else {
            handleRecoverAlbumData(new ArrayList(this.selectorConfig.albumDataSource));
        }
    }

    private void recoveryRecyclerPosition() {
        if (this.currentPosition > 0) {
            this.mRecycler.post(new Runnable() {
                public void run() {
                    PictureSelectorFragment.this.mRecycler.scrollToPosition(PictureSelectorFragment.this.currentPosition);
                    PictureSelectorFragment.this.mRecycler.setLastVisiblePosition(PictureSelectorFragment.this.currentPosition);
                }
            });
        }
    }

    private void removePageCameraRepeatData(List<LocalMedia> list) {
        try {
            if (this.selectorConfig.isPageStrategy && this.isCameraCallback) {
                synchronized (LOCK) {
                    Iterator<LocalMedia> it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (this.mAdapter.getData().contains(it2.next())) {
                            it2.remove();
                        }
                    }
                }
            }
        } catch (Exception e11) {
            try {
                e11.printStackTrace();
            } catch (Throwable th2) {
                this.isCameraCallback = false;
                throw th2;
            }
        }
        this.isCameraCallback = false;
    }

    private void requestLoadData() {
        this.mAdapter.setDisplayCamera(this.isDisplayCamera);
        if (PermissionChecker.isCheckReadStorage(this.selectorConfig.chooseMode, getContext())) {
            beginLoadData();
            return;
        }
        final String[] readPermissionArray = PermissionConfig.getReadPermissionArray(getAppContext(), this.selectorConfig.chooseMode);
        onPermissionExplainEvent(true, readPermissionArray);
        if (this.selectorConfig.onPermissionsEventListener != null) {
            onApplyPermissionsEvent(-1, readPermissionArray);
        } else {
            PermissionChecker.getInstance().requestPermissions((Fragment) this, readPermissionArray, (PermissionResultCallback) new PermissionResultCallback() {
                public void onDenied() {
                    PictureSelectorFragment.this.handlePermissionDenied(readPermissionArray);
                }

                public void onGranted() {
                    PictureSelectorFragment.this.beginLoadData();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public void setAdapterData(final ArrayList<LocalMedia> arrayList) {
        long enterAnimationDuration = getEnterAnimationDuration();
        if (enterAnimationDuration > 0) {
            requireView().postDelayed(new Runnable() {
                public void run() {
                    PictureSelectorFragment.this.setAdapterDataComplete(arrayList);
                }
            }, enterAnimationDuration);
        } else {
            setAdapterDataComplete(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public void setAdapterDataComplete(ArrayList<LocalMedia> arrayList) {
        setEnterAnimationDuration(0);
        sendChangeSubSelectPositionEvent(false);
        this.mAdapter.setDataAndDataSetChanged(arrayList);
        this.selectorConfig.dataSource.clear();
        this.selectorConfig.albumDataSource.clear();
        recoveryRecyclerPosition();
        if (this.mAdapter.isDataEmpty()) {
            showDataNull();
        } else {
            hideDataNull();
        }
    }

    /* access modifiers changed from: private */
    public void setCurrentMediaCreateTimeText() {
        int firstVisiblePosition;
        if (this.selectorConfig.isDisplayTimeAxis && (firstVisiblePosition = this.mRecycler.getFirstVisiblePosition()) != -1) {
            ArrayList<LocalMedia> data = this.mAdapter.getData();
            if (data.size() > firstVisiblePosition && data.get(firstVisiblePosition).getDateAddedTime() > 0) {
                this.tvCurrentDataTime.setText(DateUtils.getDataFormat(getContext(), data.get(firstVisiblePosition).getDateAddedTime()));
            }
        }
    }

    /* access modifiers changed from: private */
    public void showCurrentMediaCreateTimeUI() {
        if (this.selectorConfig.isDisplayTimeAxis && this.mAdapter.getData().size() > 0 && this.tvCurrentDataTime.getAlpha() == 0.0f) {
            this.tvCurrentDataTime.animate().setDuration(150).alphaBy(1.0f).start();
        }
    }

    private void showDataNull() {
        LocalMediaFolder localMediaFolder = this.selectorConfig.currentLocalMediaFolder;
        if (localMediaFolder == null || localMediaFolder.getBucketId() == -1) {
            if (this.tvDataEmpty.getVisibility() == 8) {
                this.tvDataEmpty.setVisibility(0);
            }
            this.tvDataEmpty.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.ps_ic_no_data, 0, 0);
            this.tvDataEmpty.setText(getString(this.selectorConfig.chooseMode == SelectMimeType.ofAudio() ? R.string.ps_audio_empty : R.string.ps_empty));
        }
    }

    public void dispatchCameraMediaResult(LocalMedia localMedia) {
        if (!isAddSameImp(this.albumListPopWindow.getFirstAlbumImageCount())) {
            this.mAdapter.getData().add(0, localMedia);
            this.isCameraCallback = true;
        }
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.selectionMode != 1 || !selectorConfig.isDirectReturnSingle) {
            confirmSelect(localMedia, false);
        } else {
            selectorConfig.selectedResult.clear();
            if (confirmSelect(localMedia, false) == 0) {
                dispatchTransformResult();
            }
        }
        this.mAdapter.notifyItemInserted(this.selectorConfig.isDisplayCamera ? 1 : 0);
        PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
        boolean z11 = this.selectorConfig.isDisplayCamera;
        pictureImageGridAdapter.notifyItemRangeChanged(z11 ? 1 : 0, pictureImageGridAdapter.getData().size());
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2.isOnlySandboxDir) {
            LocalMediaFolder localMediaFolder = selectorConfig2.currentLocalMediaFolder;
            if (localMediaFolder == null) {
                localMediaFolder = new LocalMediaFolder();
            }
            localMediaFolder.setBucketId(ValueOf.toLong(Integer.valueOf(localMedia.getParentFolderName().hashCode())));
            localMediaFolder.setFolderName(localMedia.getParentFolderName());
            localMediaFolder.setFirstMimeType(localMedia.getMimeType());
            localMediaFolder.setFirstImagePath(localMedia.getPath());
            localMediaFolder.setFolderTotalNum(this.mAdapter.getData().size());
            localMediaFolder.setCurrentDataPage(this.mPage);
            localMediaFolder.setHasMore(false);
            localMediaFolder.setData(this.mAdapter.getData());
            this.mRecycler.setEnabledLoadMore(false);
            this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
        } else {
            mergeFolder(localMedia);
        }
        this.allFolderSize = 0;
        if (this.mAdapter.getData().size() > 0 || this.selectorConfig.isDirectReturnSingle) {
            hideDataNull();
        } else {
            showDataNull();
        }
    }

    public String getFragmentTag() {
        return TAG;
    }

    public int getResourceId() {
        int layoutResource = InjectResourceSource.getLayoutResource(getContext(), 1, this.selectorConfig);
        if (layoutResource != 0) {
            return layoutResource;
        }
        return R.layout.ps_fragment_selector;
    }

    public void handlePermissionSettingResult(String[] strArr) {
        boolean z11;
        if (strArr != null) {
            onPermissionExplainEvent(false, (String[]) null);
            boolean z12 = strArr.length > 0 && TextUtils.equals(strArr[0], PermissionConfig.CAMERA[0]);
            OnPermissionsInterceptListener onPermissionsInterceptListener = this.selectorConfig.onPermissionsEventListener;
            if (onPermissionsInterceptListener != null) {
                z11 = onPermissionsInterceptListener.hasPermissions(this, strArr);
            } else {
                z11 = PermissionChecker.isCheckSelfPermission(getContext(), strArr);
            }
            if (z11) {
                if (z12) {
                    openSelectedCamera();
                } else {
                    beginLoadData();
                }
            } else if (z12) {
                ToastUtils.showToast(getContext(), getString(R.string.ps_camera));
            } else {
                ToastUtils.showToast(getContext(), getString(R.string.ps_jurisdiction));
                onKeyBackFragmentFinish();
            }
            PermissionConfig.CURRENT_REQUEST_PERMISSION = new String[0];
        }
    }

    public void loadAllAlbumData() {
        ExtendLoaderEngine extendLoaderEngine = this.selectorConfig.loaderDataEngine;
        if (extendLoaderEngine != null) {
            extendLoaderEngine.loadAllAlbumData(getContext(), new OnQueryAllAlbumListener<LocalMediaFolder>() {
                public void onComplete(List<LocalMediaFolder> list) {
                    PictureSelectorFragment.this.handleAllAlbumData(false, list);
                }
            });
            return;
        }
        final boolean preloadPageFirstData = preloadPageFirstData();
        this.mLoader.loadAllAlbum(new OnQueryAllAlbumListener<LocalMediaFolder>() {
            public void onComplete(List<LocalMediaFolder> list) {
                PictureSelectorFragment.this.handleAllAlbumData(preloadPageFirstData, list);
            }
        });
    }

    public void loadFirstPageMediaData(long j11) {
        this.mPage = 1;
        this.mRecycler.setEnabledLoadMore(true);
        SelectorConfig selectorConfig = this.selectorConfig;
        ExtendLoaderEngine extendLoaderEngine = selectorConfig.loaderDataEngine;
        if (extendLoaderEngine != null) {
            Context context = getContext();
            int i11 = this.mPage;
            extendLoaderEngine.loadFirstPageMediaData(context, j11, i11, i11 * this.selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() {
                public void onComplete(ArrayList<LocalMedia> arrayList, boolean z11) {
                    PictureSelectorFragment.this.handleFirstPageMedia(arrayList, z11);
                }
            });
            return;
        }
        IBridgeMediaLoader iBridgeMediaLoader = this.mLoader;
        int i12 = this.mPage;
        iBridgeMediaLoader.loadPageMediaData(j11, i12, i12 * selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() {
            public void onComplete(ArrayList<LocalMedia> arrayList, boolean z11) {
                PictureSelectorFragment.this.handleFirstPageMedia(arrayList, z11);
            }
        });
    }

    public void loadMoreMediaData() {
        if (this.mRecycler.isEnabledLoadMore()) {
            this.mPage++;
            LocalMediaFolder localMediaFolder = this.selectorConfig.currentLocalMediaFolder;
            long bucketId = localMediaFolder != null ? localMediaFolder.getBucketId() : 0;
            SelectorConfig selectorConfig = this.selectorConfig;
            ExtendLoaderEngine extendLoaderEngine = selectorConfig.loaderDataEngine;
            if (extendLoaderEngine != null) {
                Context context = getContext();
                int i11 = this.mPage;
                int i12 = this.selectorConfig.pageSize;
                extendLoaderEngine.loadMoreMediaData(context, bucketId, i11, i12, i12, new OnQueryDataResultListener<LocalMedia>() {
                    public void onComplete(ArrayList<LocalMedia> arrayList, boolean z11) {
                        PictureSelectorFragment.this.handleMoreMediaData(arrayList, z11);
                    }
                });
                return;
            }
            this.mLoader.loadPageMediaData(bucketId, this.mPage, selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() {
                public void onComplete(ArrayList<LocalMedia> arrayList, boolean z11) {
                    PictureSelectorFragment.this.handleMoreMediaData(arrayList, z11);
                }
            });
        }
    }

    public void loadOnlyInAppDirectoryAllMediaData() {
        ExtendLoaderEngine extendLoaderEngine = this.selectorConfig.loaderDataEngine;
        if (extendLoaderEngine != null) {
            extendLoaderEngine.loadOnlyInAppDirAllMediaData(getContext(), new OnQueryAlbumListener<LocalMediaFolder>() {
                public void onComplete(LocalMediaFolder localMediaFolder) {
                    PictureSelectorFragment.this.handleInAppDirAllMedia(localMediaFolder);
                }
            });
        } else {
            this.mLoader.loadOnlyInAppDirAllMedia(new OnQueryAlbumListener<LocalMediaFolder>() {
                public void onComplete(LocalMediaFolder localMediaFolder) {
                    PictureSelectorFragment.this.handleInAppDirAllMedia(localMediaFolder);
                }
            });
        }
    }

    public void onApplyPermissionsEvent(int i11, String[] strArr) {
        if (i11 != -1) {
            super.onApplyPermissionsEvent(i11, strArr);
        } else {
            this.selectorConfig.onPermissionsEventListener.requestPermission(this, strArr, new OnRequestPermissionListener() {
                public void onCall(String[] strArr, boolean z11) {
                    if (z11) {
                        PictureSelectorFragment.this.beginLoadData();
                    } else {
                        PictureSelectorFragment.this.handlePermissionDenied(strArr);
                    }
                }
            });
        }
    }

    public void onCheckOriginalChange() {
        this.bottomNarBar.setOriginalCheck();
    }

    public void onCreateLoader() {
        IBridgeMediaLoader iBridgeMediaLoader;
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

    public void onDestroyView() {
        super.onDestroyView();
        SlideSelectTouchListener slideSelectTouchListener = this.mDragSelectTouchListener;
        if (slideSelectTouchListener != null) {
            slideSelectTouchListener.stopAutoScroll();
        }
    }

    public void onFixedSelectedChange(LocalMedia localMedia) {
        this.mAdapter.notifyItemPositionChanged(localMedia.position);
    }

    public void onFragmentResume() {
        setRootViewKeyListener(requireView());
    }

    public void onRecyclerViewPreloadMore() {
        if (this.isMemoryRecycling) {
            requireView().postDelayed(new Runnable() {
                public void run() {
                    PictureSelectorFragment.this.loadMoreMediaData();
                }
            }, 350);
        } else {
            loadMoreMediaData();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PictureConfig.EXTRA_ALL_FOLDER_SIZE, this.allFolderSize);
        bundle.putInt(PictureConfig.EXTRA_CURRENT_PAGE, this.mPage);
        bundle.putInt(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, this.mRecycler.getLastVisiblePosition());
        bundle.putBoolean(PictureConfig.EXTRA_DISPLAY_CAMERA, this.mAdapter.isDisplayCamera());
        this.selectorConfig.addAlbumDataSource(this.albumListPopWindow.getAlbumList());
        this.selectorConfig.addDataSource(this.mAdapter.getData());
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void onSelectedChange(boolean z11, LocalMedia localMedia) {
        this.bottomNarBar.setSelectedChange();
        this.completeSelectView.setSelectedChange(false);
        if (checkNotifyStrategy(z11)) {
            this.mAdapter.notifyItemPositionChanged(localMedia.position);
            this.mRecycler.postDelayed(new Runnable() {
                public void run() {
                    PictureSelectorFragment.this.mAdapter.notifyDataSetChanged();
                }
            }, (long) SELECT_ANIM_DURATION);
        } else {
            this.mAdapter.notifyItemPositionChanged(localMedia.position);
        }
        if (!z11) {
            sendChangeSubSelectPositionEvent(true);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        reStartSavedInstance(bundle);
        this.isMemoryRecycling = bundle != null;
        this.tvDataEmpty = (TextView) view.findViewById(R.id.tv_data_empty);
        this.completeSelectView = (CompleteSelectView) view.findViewById(R.id.ps_complete_select);
        this.titleBar = (TitleBar) view.findViewById(R.id.title_bar);
        this.bottomNarBar = (BottomNavBar) view.findViewById(R.id.bottom_nar_bar);
        this.tvCurrentDataTime = (TextView) view.findViewById(R.id.tv_current_data_time);
        onCreateLoader();
        initAlbumListPopWindow();
        initTitleBar();
        initComplete();
        initRecycler(view);
        initBottomNavBar();
        if (this.isMemoryRecycling) {
            recoverSaveInstanceData();
        } else {
            requestLoadData();
        }
    }

    public void reStartSavedInstance(Bundle bundle) {
        if (bundle != null) {
            this.allFolderSize = bundle.getInt(PictureConfig.EXTRA_ALL_FOLDER_SIZE);
            this.mPage = bundle.getInt(PictureConfig.EXTRA_CURRENT_PAGE, this.mPage);
            this.currentPosition = bundle.getInt(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, this.currentPosition);
            this.isDisplayCamera = bundle.getBoolean(PictureConfig.EXTRA_DISPLAY_CAMERA, this.selectorConfig.isDisplayCamera);
            return;
        }
        this.isDisplayCamera = this.selectorConfig.isDisplayCamera;
    }

    public void sendChangeSubSelectPositionEvent(boolean z11) {
        if (this.selectorConfig.selectorStyle.getSelectMainStyle().isSelectNumberStyle()) {
            int i11 = 0;
            while (i11 < this.selectorConfig.getSelectCount()) {
                LocalMedia localMedia = this.selectorConfig.getSelectedResult().get(i11);
                i11++;
                localMedia.setNum(i11);
                if (z11) {
                    this.mAdapter.notifyItemPositionChanged(localMedia.position);
                }
            }
        }
    }
}
