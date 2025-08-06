package com.luck.picture.lib.basic;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.luck.picture.lib.R;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.config.Crop;
import com.luck.picture.lib.config.CustomIntentKey;
import com.luck.picture.lib.config.PermissionEvent;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.dialog.PhotoItemSelectedDialog;
import com.luck.picture.lib.dialog.PictureLoadingDialog;
import com.luck.picture.lib.dialog.RemindDialog;
import com.luck.picture.lib.engine.PictureSelectorEngine;
import com.luck.picture.lib.engine.SandboxFileEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.immersive.ImmersiveManager;
import com.luck.picture.lib.interfaces.OnCallbackIndexListener;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnItemClickListener;
import com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener;
import com.luck.picture.lib.interfaces.OnPermissionDescriptionListener;
import com.luck.picture.lib.interfaces.OnRecordAudioInterceptListener;
import com.luck.picture.lib.interfaces.OnRequestPermissionListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.interfaces.OnSelectFilterListener;
import com.luck.picture.lib.interfaces.OnSelectLimitTipsListener;
import com.luck.picture.lib.language.PictureLanguageUtils;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.permissions.PermissionUtil;
import com.luck.picture.lib.service.ForegroundService;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.BitmapUtils;
import com.luck.picture.lib.utils.DateUtils;
import com.luck.picture.lib.utils.FileDirMap;
import com.luck.picture.lib.utils.MediaStoreUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.PictureFileUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.SpUtils;
import com.luck.picture.lib.utils.ToastUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class PictureCommonFragment extends Fragment implements IPictureSelectorCommonEvent {
    public static final String TAG = PictureCommonFragment.class.getSimpleName();
    private Context context;
    private long enterAnimDuration;
    public IBridgePictureBehavior iBridgePictureBehavior;
    public IBridgeMediaLoader mLoader;
    private Dialog mLoadingDialog;
    public int mPage = 1;
    private PermissionResultCallback mPermissionResultCallback;
    public SelectorConfig selectorConfig;
    private int soundID;
    private SoundPool soundPool;
    public Dialog tipsDialog;

    public static class SelectorResult {
        public int mResultCode;
        public Intent mResultData;

        public SelectorResult(int i11, Intent intent) {
            this.mResultCode = i11;
            this.mResultData = intent;
        }
    }

    private void addBitmapWatermark(final ArrayList<LocalMedia> arrayList) {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            LocalMedia localMedia = arrayList.get(i11);
            if (!PictureMimeType.isHasAudio(localMedia.getMimeType())) {
                concurrentHashMap.put(localMedia.getAvailablePath(), localMedia);
            }
        }
        if (concurrentHashMap.size() == 0) {
            dispatchWatermarkResult(arrayList);
            return;
        }
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            this.selectorConfig.onBitmapWatermarkListener.onAddBitmapWatermark(getAppContext(), (String) entry.getKey(), ((LocalMedia) entry.getValue()).getMimeType(), new OnKeyValueResultCallbackListener() {
                public void onCallback(String str, String str2) {
                    if (TextUtils.isEmpty(str)) {
                        PictureCommonFragment.this.dispatchWatermarkResult(arrayList);
                        return;
                    }
                    LocalMedia localMedia = (LocalMedia) concurrentHashMap.get(str);
                    if (localMedia != null) {
                        localMedia.setWatermarkPath(str2);
                        concurrentHashMap.remove(str);
                    }
                    if (concurrentHashMap.size() == 0) {
                        PictureCommonFragment.this.dispatchWatermarkResult(arrayList);
                    }
                }
            });
        }
    }

    private boolean checkCompleteSelectLimit() {
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2.selectionMode == 2 && !selectorConfig2.isOnlyCamera) {
            if (selectorConfig2.isWithVideoImage) {
                ArrayList<LocalMedia> selectedResult = selectorConfig2.getSelectedResult();
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 0; i13 < selectedResult.size(); i13++) {
                    if (PictureMimeType.isHasVideo(selectedResult.get(i13).getMimeType())) {
                        i12++;
                    } else {
                        i11++;
                    }
                }
                SelectorConfig selectorConfig3 = this.selectorConfig;
                int i14 = selectorConfig3.minSelectNum;
                if (i14 <= 0 || i11 >= i14) {
                    int i15 = selectorConfig3.minVideoSelectNum;
                    if (i15 > 0 && i12 < i15) {
                        OnSelectLimitTipsListener onSelectLimitTipsListener = selectorConfig3.onSelectLimitTipsListener;
                        if (onSelectLimitTipsListener != null && onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), (LocalMedia) null, this.selectorConfig, 7)) {
                            return true;
                        }
                        showTipsDialog(getString(R.string.ps_min_video_num, String.valueOf(this.selectorConfig.minVideoSelectNum)));
                        return true;
                    }
                } else {
                    OnSelectLimitTipsListener onSelectLimitTipsListener2 = selectorConfig3.onSelectLimitTipsListener;
                    if (onSelectLimitTipsListener2 != null && onSelectLimitTipsListener2.onSelectLimitTips(getAppContext(), (LocalMedia) null, this.selectorConfig, 5)) {
                        return true;
                    }
                    showTipsDialog(getString(R.string.ps_min_img_num, String.valueOf(this.selectorConfig.minSelectNum)));
                    return true;
                }
            } else {
                String resultFirstMimeType = selectorConfig2.getResultFirstMimeType();
                if (PictureMimeType.isHasImage(resultFirstMimeType)) {
                    SelectorConfig selectorConfig4 = this.selectorConfig;
                    if (selectorConfig4.minSelectNum > 0) {
                        int selectCount = selectorConfig4.getSelectCount();
                        SelectorConfig selectorConfig5 = this.selectorConfig;
                        if (selectCount < selectorConfig5.minSelectNum) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener3 = selectorConfig5.onSelectLimitTipsListener;
                            if (onSelectLimitTipsListener3 != null && onSelectLimitTipsListener3.onSelectLimitTips(getAppContext(), (LocalMedia) null, this.selectorConfig, 5)) {
                                return true;
                            }
                            showTipsDialog(getString(R.string.ps_min_img_num, String.valueOf(this.selectorConfig.minSelectNum)));
                            return true;
                        }
                    }
                }
                if (PictureMimeType.isHasVideo(resultFirstMimeType)) {
                    SelectorConfig selectorConfig6 = this.selectorConfig;
                    if (selectorConfig6.minVideoSelectNum > 0) {
                        int selectCount2 = selectorConfig6.getSelectCount();
                        SelectorConfig selectorConfig7 = this.selectorConfig;
                        if (selectCount2 < selectorConfig7.minVideoSelectNum) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener4 = selectorConfig7.onSelectLimitTipsListener;
                            if (onSelectLimitTipsListener4 != null && onSelectLimitTipsListener4.onSelectLimitTips(getAppContext(), (LocalMedia) null, this.selectorConfig, 7)) {
                                return true;
                            }
                            showTipsDialog(getString(R.string.ps_min_video_num, String.valueOf(this.selectorConfig.minVideoSelectNum)));
                            return true;
                        }
                    }
                }
                if (PictureMimeType.isHasAudio(resultFirstMimeType)) {
                    SelectorConfig selectorConfig8 = this.selectorConfig;
                    if (selectorConfig8.minAudioSelectNum > 0) {
                        int selectCount3 = selectorConfig8.getSelectCount();
                        SelectorConfig selectorConfig9 = this.selectorConfig;
                        if (selectCount3 < selectorConfig9.minAudioSelectNum) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener5 = selectorConfig9.onSelectLimitTipsListener;
                            if (onSelectLimitTipsListener5 != null && onSelectLimitTipsListener5.onSelectLimitTips(getAppContext(), (LocalMedia) null, this.selectorConfig, 12)) {
                                return true;
                            }
                            showTipsDialog(getString(R.string.ps_min_audio_num, String.valueOf(this.selectorConfig.minAudioSelectNum)));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Deprecated
    private void copyExternalPathToAppInDirFor29(final ArrayList<LocalMedia> arrayList) {
        showLoading();
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<ArrayList<LocalMedia>>() {
            public ArrayList<LocalMedia> doInBackground() {
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    PictureCommonFragment pictureCommonFragment = PictureCommonFragment.this;
                    SandboxFileEngine sandboxFileEngine = pictureCommonFragment.selectorConfig.sandboxFileEngine;
                    Context appContext = pictureCommonFragment.getAppContext();
                    sandboxFileEngine.onStartSandboxFileTransform(appContext, PictureCommonFragment.this.selectorConfig.isCheckOriginalImage, i11, (LocalMedia) arrayList.get(i11), new OnCallbackIndexListener<LocalMedia>() {
                        public void onCall(LocalMedia localMedia, int i11) {
                            LocalMedia localMedia2 = (LocalMedia) arrayList.get(i11);
                            localMedia2.setSandboxPath(localMedia.getSandboxPath());
                            if (PictureCommonFragment.this.selectorConfig.isCheckOriginalImage) {
                                localMedia2.setOriginalPath(localMedia.getOriginalPath());
                                localMedia2.setOriginal(!TextUtils.isEmpty(localMedia.getOriginalPath()));
                            }
                        }
                    });
                }
                return arrayList;
            }

            public void onSuccess(ArrayList<LocalMedia> arrayList) {
                PictureThreadUtils.cancel((PictureThreadUtils.Task) this);
                PictureCommonFragment.this.dispatchUriToFileTransformResult(arrayList);
            }
        });
    }

    /* access modifiers changed from: private */
    public void copyOutputAudioToDir() {
        String str;
        try {
            if (!TextUtils.isEmpty(this.selectorConfig.outPutAudioDir)) {
                InputStream openInputStream = PictureMimeType.isContent(this.selectorConfig.cameraPath) ? PictureContentResolver.openInputStream(getAppContext(), Uri.parse(this.selectorConfig.cameraPath)) : new FileInputStream(this.selectorConfig.cameraPath);
                if (TextUtils.isEmpty(this.selectorConfig.outPutAudioFileName)) {
                    str = "";
                } else {
                    SelectorConfig selectorConfig2 = this.selectorConfig;
                    if (selectorConfig2.isOnlyCamera) {
                        str = selectorConfig2.outPutAudioFileName;
                    } else {
                        str = System.currentTimeMillis() + "_" + this.selectorConfig.outPutAudioFileName;
                    }
                }
                Context appContext = getAppContext();
                SelectorConfig selectorConfig3 = this.selectorConfig;
                File createCameraFile = PictureFileUtils.createCameraFile(appContext, selectorConfig3.chooseMode, str, "", selectorConfig3.outPutAudioDir);
                if (PictureFileUtils.writeFileFromIS(openInputStream, new FileOutputStream(createCameraFile.getAbsolutePath()))) {
                    MediaUtils.deleteUri(getAppContext(), this.selectorConfig.cameraPath);
                    this.selectorConfig.cameraPath = createCameraFile.getAbsolutePath();
                }
            }
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
        }
    }

    private void createCompressEngine() {
        PictureSelectorEngine pictureSelectorEngine;
        PictureSelectorEngine pictureSelectorEngine2;
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2.isCompressEngine) {
            if (selectorConfig2.compressFileEngine == null && (pictureSelectorEngine2 = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
                this.selectorConfig.compressFileEngine = pictureSelectorEngine2.createCompressFileEngine();
            }
            if (this.selectorConfig.compressEngine == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
                this.selectorConfig.compressEngine = pictureSelectorEngine.createCompressEngine();
            }
        }
    }

    private void createImageLoaderEngine() {
        PictureSelectorEngine pictureSelectorEngine;
        if (this.selectorConfig.imageEngine == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            this.selectorConfig.imageEngine = pictureSelectorEngine.createImageLoaderEngine();
        }
    }

    private void createLayoutResourceListener() {
        PictureSelectorEngine pictureSelectorEngine;
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2.isInjectLayoutResource && selectorConfig2.onLayoutResourceListener == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            this.selectorConfig.onLayoutResourceListener = pictureSelectorEngine.createLayoutResourceListener();
        }
    }

    private void createLoaderDataEngine() {
        PictureSelectorEngine pictureSelectorEngine;
        PictureSelectorEngine pictureSelectorEngine2;
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2.isLoaderDataEngine && selectorConfig2.loaderDataEngine == null && (pictureSelectorEngine2 = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            this.selectorConfig.loaderDataEngine = pictureSelectorEngine2.createLoaderDataEngine();
        }
        SelectorConfig selectorConfig3 = this.selectorConfig;
        if (selectorConfig3.isLoaderFactoryEngine && selectorConfig3.loaderFactory == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            this.selectorConfig.loaderFactory = pictureSelectorEngine.onCreateLoader();
        }
    }

    private void createResultCallbackListener() {
        PictureSelectorEngine pictureSelectorEngine;
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2.isResultListenerBack && selectorConfig2.onResultCallListener == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            this.selectorConfig.onResultCallListener = pictureSelectorEngine.getResultCallbackListener();
        }
    }

    private void createSandboxFileEngine() {
        PictureSelectorEngine pictureSelectorEngine;
        PictureSelectorEngine pictureSelectorEngine2;
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2.isSandboxFileEngine) {
            if (selectorConfig2.uriToFileTransformEngine == null && (pictureSelectorEngine2 = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
                this.selectorConfig.uriToFileTransformEngine = pictureSelectorEngine2.createUriToFileTransformEngine();
            }
            if (this.selectorConfig.sandboxFileEngine == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
                this.selectorConfig.sandboxFileEngine = pictureSelectorEngine.createSandboxFileEngine();
            }
        }
    }

    private void createVideoPlayerEngine() {
        PictureSelectorEngine pictureSelectorEngine;
        if (this.selectorConfig.videoPlayerEngine == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            this.selectorConfig.videoPlayerEngine = pictureSelectorEngine.createVideoPlayerEngine();
        }
    }

    private void dispatchHandleCamera(final Intent intent) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<LocalMedia>() {
            public LocalMedia doInBackground() {
                String outputPath = PictureCommonFragment.this.getOutputPath(intent);
                if (!TextUtils.isEmpty(outputPath)) {
                    PictureCommonFragment.this.selectorConfig.cameraPath = outputPath;
                }
                if (TextUtils.isEmpty(PictureCommonFragment.this.selectorConfig.cameraPath)) {
                    return null;
                }
                if (PictureCommonFragment.this.selectorConfig.chooseMode == SelectMimeType.ofAudio()) {
                    PictureCommonFragment.this.copyOutputAudioToDir();
                }
                PictureCommonFragment pictureCommonFragment = PictureCommonFragment.this;
                LocalMedia buildLocalMedia = pictureCommonFragment.buildLocalMedia(pictureCommonFragment.selectorConfig.cameraPath);
                buildLocalMedia.setCameraSource(true);
                return buildLocalMedia;
            }

            public void onSuccess(LocalMedia localMedia) {
                PictureThreadUtils.cancel((PictureThreadUtils.Task) this);
                if (localMedia != null) {
                    PictureCommonFragment.this.onScannerScanFile(localMedia);
                    PictureCommonFragment.this.dispatchCameraMediaResult(localMedia);
                }
                PictureCommonFragment.this.selectorConfig.cameraPath = "";
            }
        });
    }

    /* access modifiers changed from: private */
    public void dispatchUriToFileTransformResult(ArrayList<LocalMedia> arrayList) {
        showLoading();
        if (checkAddBitmapWatermark()) {
            addBitmapWatermark(arrayList);
        } else if (checkVideoThumbnail()) {
            videoThumbnail(arrayList);
        } else {
            onCallBackResult(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public void dispatchWatermarkResult(ArrayList<LocalMedia> arrayList) {
        if (checkVideoThumbnail()) {
            videoThumbnail(arrayList);
        } else {
            onCallBackResult(arrayList);
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    private static String getTipsMsg(Context context2, String str, int i11) {
        if (PictureMimeType.isHasVideo(str)) {
            return context2.getString(R.string.ps_message_video_max_num, new Object[]{String.valueOf(i11)});
        } else if (PictureMimeType.isHasAudio(str)) {
            return context2.getString(R.string.ps_message_audio_max_num, new Object[]{String.valueOf(i11)});
        } else {
            return context2.getString(R.string.ps_message_max_num, new Object[]{String.valueOf(i11)});
        }
    }

    private void mergeOriginalImage(ArrayList<LocalMedia> arrayList) {
        if (this.selectorConfig.isCheckOriginalImage) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                LocalMedia localMedia = arrayList.get(i11);
                localMedia.setOriginal(true);
                localMedia.setOriginalPath(localMedia.getPath());
            }
        }
    }

    /* access modifiers changed from: private */
    public void onCallBackResult(ArrayList<LocalMedia> arrayList) {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            dismissLoading();
            SelectorConfig selectorConfig2 = this.selectorConfig;
            if (selectorConfig2.isActivityResultBack) {
                getActivity().setResult(-1, PictureSelector.putIntentResult(arrayList));
                onSelectFinish(-1, arrayList);
            } else {
                OnResultCallbackListener<LocalMedia> onResultCallbackListener = selectorConfig2.onResultCallListener;
                if (onResultCallbackListener != null) {
                    onResultCallbackListener.onResult(arrayList);
                }
            }
            onExitPictureSelector();
        }
    }

    /* access modifiers changed from: private */
    public void onScannerScanFile(LocalMedia localMedia) {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            if (!SdkVersionUtils.isQ()) {
                String realPath = PictureMimeType.isContent(localMedia.getPath()) ? localMedia.getRealPath() : localMedia.getPath();
                new PictureMediaScannerConnection(getActivity(), realPath);
                if (PictureMimeType.isHasImage(localMedia.getMimeType())) {
                    int dCIMLastImageId = MediaUtils.getDCIMLastImageId(getAppContext(), new File(realPath).getParent());
                    if (dCIMLastImageId != -1) {
                        MediaUtils.removeMedia(getAppContext(), dCIMLastImageId);
                    }
                }
            } else if (PictureMimeType.isHasVideo(localMedia.getMimeType()) && PictureMimeType.isContent(localMedia.getPath())) {
                new PictureMediaScannerConnection(getActivity(), localMedia.getRealPath());
            }
        }
    }

    private void playClickEffect() {
        SoundPool soundPool2 = this.soundPool;
        if (soundPool2 != null && this.selectorConfig.isOpenClickSound) {
            soundPool2.play(this.soundID, 0.1f, 0.5f, 0, 1, 1.0f);
        }
    }

    private void releaseSoundPool() {
        try {
            SoundPool soundPool2 = this.soundPool;
            if (soundPool2 != null) {
                soundPool2.release();
                this.soundPool = null;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void setTranslucentStatusBar() {
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2.isPreviewFullScreenMode) {
            ImmersiveManager.translucentStatusBar(requireActivity(), selectorConfig2.selectorStyle.getSelectMainStyle().isDarkStatusBarBlack());
        }
    }

    private void showTipsDialog(String str) {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            try {
                Dialog dialog = this.tipsDialog;
                if (dialog == null || !dialog.isShowing()) {
                    RemindDialog buildDialog = RemindDialog.buildDialog(getAppContext(), str);
                    this.tipsDialog = buildDialog;
                    buildDialog.show();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    private void uriToFileTransform29(final ArrayList<LocalMedia> arrayList) {
        showLoading();
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            LocalMedia localMedia = arrayList.get(i11);
            concurrentHashMap.put(localMedia.getPath(), localMedia);
        }
        if (concurrentHashMap.size() == 0) {
            dispatchUriToFileTransformResult(arrayList);
        } else {
            PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<ArrayList<LocalMedia>>() {
                public ArrayList<LocalMedia> doInBackground() {
                    for (Map.Entry value : concurrentHashMap.entrySet()) {
                        LocalMedia localMedia = (LocalMedia) value.getValue();
                        if (PictureCommonFragment.this.selectorConfig.isCheckOriginalImage || TextUtils.isEmpty(localMedia.getSandboxPath())) {
                            PictureCommonFragment pictureCommonFragment = PictureCommonFragment.this;
                            pictureCommonFragment.selectorConfig.uriToFileTransformEngine.onUriToFileAsyncTransform(pictureCommonFragment.getAppContext(), localMedia.getPath(), localMedia.getMimeType(), new OnKeyValueResultCallbackListener() {
                                public void onCallback(String str, String str2) {
                                    LocalMedia localMedia;
                                    if (!TextUtils.isEmpty(str) && (localMedia = (LocalMedia) concurrentHashMap.get(str)) != null) {
                                        if (TextUtils.isEmpty(localMedia.getSandboxPath())) {
                                            localMedia.setSandboxPath(str2);
                                        }
                                        if (PictureCommonFragment.this.selectorConfig.isCheckOriginalImage) {
                                            localMedia.setOriginalPath(str2);
                                            localMedia.setOriginal(!TextUtils.isEmpty(str2));
                                        }
                                        concurrentHashMap.remove(str);
                                    }
                                }
                            });
                        }
                    }
                    return arrayList;
                }

                public void onSuccess(ArrayList<LocalMedia> arrayList) {
                    PictureThreadUtils.cancel((PictureThreadUtils.Task) this);
                    PictureCommonFragment.this.dispatchUriToFileTransformResult(arrayList);
                }
            });
        }
    }

    private void videoThumbnail(final ArrayList<LocalMedia> arrayList) {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            LocalMedia localMedia = arrayList.get(i11);
            String availablePath = localMedia.getAvailablePath();
            if (PictureMimeType.isHasVideo(localMedia.getMimeType()) || PictureMimeType.isUrlHasVideo(availablePath)) {
                concurrentHashMap.put(availablePath, localMedia);
            }
        }
        if (concurrentHashMap.size() == 0) {
            onCallBackResult(arrayList);
            return;
        }
        for (Map.Entry key : concurrentHashMap.entrySet()) {
            this.selectorConfig.onVideoThumbnailEventListener.onVideoThumbnail(getAppContext(), (String) key.getKey(), new OnKeyValueResultCallbackListener() {
                public void onCallback(String str, String str2) {
                    LocalMedia localMedia = (LocalMedia) concurrentHashMap.get(str);
                    if (localMedia != null) {
                        localMedia.setVideoThumbnailPath(str2);
                        concurrentHashMap.remove(str);
                    }
                    if (concurrentHashMap.size() == 0) {
                        PictureCommonFragment.this.onCallBackResult(arrayList);
                    }
                }
            });
        }
    }

    public LocalMedia buildLocalMedia(String str) {
        LocalMedia generateLocalMedia = LocalMedia.generateLocalMedia(getAppContext(), str);
        generateLocalMedia.setChooseModel(this.selectorConfig.chooseMode);
        if (!SdkVersionUtils.isQ() || PictureMimeType.isContent(str)) {
            generateLocalMedia.setSandboxPath((String) null);
        } else {
            generateLocalMedia.setSandboxPath(str);
        }
        if (this.selectorConfig.isCameraRotateImage && PictureMimeType.isHasImage(generateLocalMedia.getMimeType())) {
            BitmapUtils.rotateImage(getAppContext(), str);
        }
        return generateLocalMedia;
    }

    public boolean checkAddBitmapWatermark() {
        return this.selectorConfig.onBitmapWatermarkListener != null;
    }

    public boolean checkCompressValidity() {
        if (this.selectorConfig.compressFileEngine != null) {
            for (int i11 = 0; i11 < this.selectorConfig.getSelectCount(); i11++) {
                if (PictureMimeType.isHasImage(this.selectorConfig.getSelectedResult().get(i11).getMimeType())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCropValidity() {
        if (this.selectorConfig.cropFileEngine == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        List<String> list = this.selectorConfig.skipCropList;
        if (list != null && list.size() > 0) {
            hashSet.addAll(list);
        }
        if (this.selectorConfig.getSelectCount() == 1) {
            String resultFirstMimeType = this.selectorConfig.getResultFirstMimeType();
            boolean isHasImage = PictureMimeType.isHasImage(resultFirstMimeType);
            if (!isHasImage || !hashSet.contains(resultFirstMimeType)) {
                return isHasImage;
            }
            return false;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.selectorConfig.getSelectCount(); i12++) {
            LocalMedia localMedia = this.selectorConfig.getSelectedResult().get(i12);
            if (PictureMimeType.isHasImage(localMedia.getMimeType()) && hashSet.contains(localMedia.getMimeType())) {
                i11++;
            }
        }
        if (i11 != this.selectorConfig.getSelectCount()) {
            return true;
        }
        return false;
    }

    public boolean checkOldCompressValidity() {
        if (this.selectorConfig.compressEngine != null) {
            for (int i11 = 0; i11 < this.selectorConfig.getSelectCount(); i11++) {
                if (PictureMimeType.isHasImage(this.selectorConfig.getSelectedResult().get(i11).getMimeType())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkOldCropValidity() {
        if (this.selectorConfig.cropEngine == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        List<String> list = this.selectorConfig.skipCropList;
        if (list != null && list.size() > 0) {
            hashSet.addAll(list);
        }
        if (this.selectorConfig.getSelectCount() == 1) {
            String resultFirstMimeType = this.selectorConfig.getResultFirstMimeType();
            boolean isHasImage = PictureMimeType.isHasImage(resultFirstMimeType);
            if (!isHasImage || !hashSet.contains(resultFirstMimeType)) {
                return isHasImage;
            }
            return false;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.selectorConfig.getSelectCount(); i12++) {
            LocalMedia localMedia = this.selectorConfig.getSelectedResult().get(i12);
            if (PictureMimeType.isHasImage(localMedia.getMimeType()) && hashSet.contains(localMedia.getMimeType())) {
                i11++;
            }
        }
        if (i11 != this.selectorConfig.getSelectCount()) {
            return true;
        }
        return false;
    }

    public boolean checkOldTransformSandboxFile() {
        return SdkVersionUtils.isQ() && this.selectorConfig.sandboxFileEngine != null;
    }

    @SuppressLint({"StringFormatInvalid"})
    public boolean checkOnlyMimeTypeValidity(LocalMedia localMedia, boolean z11, String str, String str2, long j11, long j12) {
        if (PictureMimeType.isMimeTypeSame(str2, str)) {
            SelectorConfig selectorConfig2 = this.selectorConfig;
            long j13 = selectorConfig2.selectMaxFileSize;
            if (j13 <= 0 || j11 <= j13) {
                long j14 = selectorConfig2.selectMinFileSize;
                if (j14 <= 0 || j11 >= j14) {
                    if (PictureMimeType.isHasVideo(str)) {
                        SelectorConfig selectorConfig3 = this.selectorConfig;
                        if (selectorConfig3.selectionMode == 2) {
                            int i11 = selectorConfig3.maxVideoSelectNum;
                            if (i11 <= 0) {
                                i11 = selectorConfig3.maxSelectNum;
                            }
                            selectorConfig3.maxVideoSelectNum = i11;
                            if (!z11) {
                                int selectCount = selectorConfig3.getSelectCount();
                                SelectorConfig selectorConfig4 = this.selectorConfig;
                                if (selectCount >= selectorConfig4.maxVideoSelectNum) {
                                    OnSelectLimitTipsListener onSelectLimitTipsListener = selectorConfig4.onSelectLimitTipsListener;
                                    if (onSelectLimitTipsListener != null && onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 6)) {
                                        return true;
                                    }
                                    showTipsDialog(getTipsMsg(getAppContext(), str, this.selectorConfig.maxVideoSelectNum));
                                    return true;
                                }
                            }
                        }
                        if (!z11 && this.selectorConfig.selectMinDurationSecond > 0) {
                            long millisecondToSecond = DateUtils.millisecondToSecond(j12);
                            SelectorConfig selectorConfig5 = this.selectorConfig;
                            if (millisecondToSecond < ((long) selectorConfig5.selectMinDurationSecond)) {
                                OnSelectLimitTipsListener onSelectLimitTipsListener2 = selectorConfig5.onSelectLimitTipsListener;
                                if (onSelectLimitTipsListener2 != null && onSelectLimitTipsListener2.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 9)) {
                                    return true;
                                }
                                showTipsDialog(getString(R.string.ps_select_video_min_second, Integer.valueOf(this.selectorConfig.selectMinDurationSecond / 1000)));
                                return true;
                            }
                        }
                        if (!z11 && this.selectorConfig.selectMaxDurationSecond > 0) {
                            long millisecondToSecond2 = DateUtils.millisecondToSecond(j12);
                            SelectorConfig selectorConfig6 = this.selectorConfig;
                            if (millisecondToSecond2 > ((long) selectorConfig6.selectMaxDurationSecond)) {
                                OnSelectLimitTipsListener onSelectLimitTipsListener3 = selectorConfig6.onSelectLimitTipsListener;
                                if (onSelectLimitTipsListener3 != null && onSelectLimitTipsListener3.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 8)) {
                                    return true;
                                }
                                showTipsDialog(getString(R.string.ps_select_video_max_second, Integer.valueOf(this.selectorConfig.selectMaxDurationSecond / 1000)));
                                return true;
                            }
                        }
                    } else if (PictureMimeType.isHasAudio(str)) {
                        SelectorConfig selectorConfig7 = this.selectorConfig;
                        if (selectorConfig7.selectionMode == 2 && !z11) {
                            int size = selectorConfig7.getSelectedResult().size();
                            SelectorConfig selectorConfig8 = this.selectorConfig;
                            if (size >= selectorConfig8.maxSelectNum) {
                                OnSelectLimitTipsListener onSelectLimitTipsListener4 = selectorConfig8.onSelectLimitTipsListener;
                                if (onSelectLimitTipsListener4 != null && onSelectLimitTipsListener4.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 4)) {
                                    return true;
                                }
                                showTipsDialog(getTipsMsg(getAppContext(), str, this.selectorConfig.maxSelectNum));
                                return true;
                            }
                        }
                        if (!z11 && this.selectorConfig.selectMinDurationSecond > 0) {
                            long millisecondToSecond3 = DateUtils.millisecondToSecond(j12);
                            SelectorConfig selectorConfig9 = this.selectorConfig;
                            if (millisecondToSecond3 < ((long) selectorConfig9.selectMinDurationSecond)) {
                                OnSelectLimitTipsListener onSelectLimitTipsListener5 = selectorConfig9.onSelectLimitTipsListener;
                                if (onSelectLimitTipsListener5 != null && onSelectLimitTipsListener5.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 11)) {
                                    return true;
                                }
                                showTipsDialog(getString(R.string.ps_select_audio_min_second, Integer.valueOf(this.selectorConfig.selectMinDurationSecond / 1000)));
                                return true;
                            }
                        }
                        if (!z11 && this.selectorConfig.selectMaxDurationSecond > 0) {
                            long millisecondToSecond4 = DateUtils.millisecondToSecond(j12);
                            SelectorConfig selectorConfig10 = this.selectorConfig;
                            if (millisecondToSecond4 > ((long) selectorConfig10.selectMaxDurationSecond)) {
                                OnSelectLimitTipsListener onSelectLimitTipsListener6 = selectorConfig10.onSelectLimitTipsListener;
                                if (onSelectLimitTipsListener6 != null && onSelectLimitTipsListener6.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 10)) {
                                    return true;
                                }
                                showTipsDialog(getString(R.string.ps_select_audio_max_second, Integer.valueOf(this.selectorConfig.selectMaxDurationSecond / 1000)));
                                return true;
                            }
                        }
                    } else {
                        SelectorConfig selectorConfig11 = this.selectorConfig;
                        if (selectorConfig11.selectionMode == 2 && !z11) {
                            int size2 = selectorConfig11.getSelectedResult().size();
                            SelectorConfig selectorConfig12 = this.selectorConfig;
                            if (size2 >= selectorConfig12.maxSelectNum) {
                                OnSelectLimitTipsListener onSelectLimitTipsListener7 = selectorConfig12.onSelectLimitTipsListener;
                                if (onSelectLimitTipsListener7 != null && onSelectLimitTipsListener7.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 4)) {
                                    return true;
                                }
                                showTipsDialog(getTipsMsg(getAppContext(), str, this.selectorConfig.maxSelectNum));
                                return true;
                            }
                        }
                    }
                    return false;
                }
                OnSelectLimitTipsListener onSelectLimitTipsListener8 = selectorConfig2.onSelectLimitTipsListener;
                if (onSelectLimitTipsListener8 != null && onSelectLimitTipsListener8.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 2)) {
                    return true;
                }
                String formatFileSize = PictureFileUtils.formatFileSize(this.selectorConfig.selectMinFileSize);
                showTipsDialog(getString(R.string.ps_select_min_size, formatFileSize));
                return true;
            }
            OnSelectLimitTipsListener onSelectLimitTipsListener9 = selectorConfig2.onSelectLimitTipsListener;
            if (onSelectLimitTipsListener9 != null && onSelectLimitTipsListener9.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 1)) {
                return true;
            }
            String formatFileSize2 = PictureFileUtils.formatFileSize(this.selectorConfig.selectMaxFileSize);
            showTipsDialog(getString(R.string.ps_select_max_size, formatFileSize2));
            return true;
        }
        OnSelectLimitTipsListener onSelectLimitTipsListener10 = this.selectorConfig.onSelectLimitTipsListener;
        if (onSelectLimitTipsListener10 != null && onSelectLimitTipsListener10.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 3)) {
            return true;
        }
        showTipsDialog(getString(R.string.ps_rule));
        return true;
    }

    public boolean checkTransformSandboxFile() {
        return SdkVersionUtils.isQ() && this.selectorConfig.uriToFileTransformEngine != null;
    }

    public boolean checkVideoThumbnail() {
        return this.selectorConfig.onVideoThumbnailEventListener != null;
    }

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    public boolean checkWithMimeTypeValidity(LocalMedia localMedia, boolean z11, String str, int i11, long j11, long j12) {
        LocalMedia localMedia2 = localMedia;
        SelectorConfig selectorConfig2 = this.selectorConfig;
        long j13 = selectorConfig2.selectMaxFileSize;
        if (j13 <= 0 || j11 <= j13) {
            long j14 = selectorConfig2.selectMinFileSize;
            if (j14 <= 0 || j11 >= j14) {
                if (PictureMimeType.isHasVideo(str)) {
                    SelectorConfig selectorConfig3 = this.selectorConfig;
                    if (selectorConfig3.selectionMode == 2) {
                        if (selectorConfig3.maxVideoSelectNum <= 0) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener = selectorConfig3.onSelectLimitTipsListener;
                            if (onSelectLimitTipsListener != null && onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 3)) {
                                return true;
                            }
                            showTipsDialog(getString(R.string.ps_rule));
                            return true;
                        }
                        if (!z11) {
                            int size = selectorConfig3.getSelectedResult().size();
                            SelectorConfig selectorConfig4 = this.selectorConfig;
                            if (size >= selectorConfig4.maxSelectNum) {
                                OnSelectLimitTipsListener onSelectLimitTipsListener2 = selectorConfig4.onSelectLimitTipsListener;
                                if (onSelectLimitTipsListener2 != null && onSelectLimitTipsListener2.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 4)) {
                                    return true;
                                }
                                showTipsDialog(getString(R.string.ps_message_max_num, Integer.valueOf(this.selectorConfig.maxSelectNum)));
                                return true;
                            }
                        }
                        if (!z11) {
                            SelectorConfig selectorConfig5 = this.selectorConfig;
                            if (i11 >= selectorConfig5.maxVideoSelectNum) {
                                OnSelectLimitTipsListener onSelectLimitTipsListener3 = selectorConfig5.onSelectLimitTipsListener;
                                if (onSelectLimitTipsListener3 != null && onSelectLimitTipsListener3.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 6)) {
                                    return true;
                                }
                                String str2 = str;
                                showTipsDialog(getTipsMsg(getAppContext(), str, this.selectorConfig.maxVideoSelectNum));
                                return true;
                            }
                        }
                    }
                    if (!z11 && this.selectorConfig.selectMinDurationSecond > 0) {
                        long millisecondToSecond = DateUtils.millisecondToSecond(j12);
                        SelectorConfig selectorConfig6 = this.selectorConfig;
                        if (millisecondToSecond < ((long) selectorConfig6.selectMinDurationSecond)) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener4 = selectorConfig6.onSelectLimitTipsListener;
                            if (onSelectLimitTipsListener4 != null && onSelectLimitTipsListener4.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 9)) {
                                return true;
                            }
                            showTipsDialog(getString(R.string.ps_select_video_min_second, Integer.valueOf(this.selectorConfig.selectMinDurationSecond / 1000)));
                            return true;
                        }
                    }
                    if (!z11 && this.selectorConfig.selectMaxDurationSecond > 0) {
                        long millisecondToSecond2 = DateUtils.millisecondToSecond(j12);
                        SelectorConfig selectorConfig7 = this.selectorConfig;
                        if (millisecondToSecond2 > ((long) selectorConfig7.selectMaxDurationSecond)) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener5 = selectorConfig7.onSelectLimitTipsListener;
                            if (onSelectLimitTipsListener5 != null && onSelectLimitTipsListener5.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 8)) {
                                return true;
                            }
                            showTipsDialog(getString(R.string.ps_select_video_max_second, Integer.valueOf(this.selectorConfig.selectMaxDurationSecond / 1000)));
                            return true;
                        }
                    }
                } else {
                    SelectorConfig selectorConfig8 = this.selectorConfig;
                    if (selectorConfig8.selectionMode == 2 && !z11) {
                        int size2 = selectorConfig8.getSelectedResult().size();
                        SelectorConfig selectorConfig9 = this.selectorConfig;
                        if (size2 >= selectorConfig9.maxSelectNum) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener6 = selectorConfig9.onSelectLimitTipsListener;
                            if (onSelectLimitTipsListener6 != null && onSelectLimitTipsListener6.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 4)) {
                                return true;
                            }
                            showTipsDialog(getString(R.string.ps_message_max_num, Integer.valueOf(this.selectorConfig.maxSelectNum)));
                            return true;
                        }
                    }
                }
                return false;
            }
            OnSelectLimitTipsListener onSelectLimitTipsListener7 = selectorConfig2.onSelectLimitTipsListener;
            if (onSelectLimitTipsListener7 != null && onSelectLimitTipsListener7.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 2)) {
                return true;
            }
            String formatFileSize = PictureFileUtils.formatFileSize(this.selectorConfig.selectMinFileSize);
            showTipsDialog(getString(R.string.ps_select_min_size, formatFileSize));
            return true;
        }
        OnSelectLimitTipsListener onSelectLimitTipsListener8 = selectorConfig2.onSelectLimitTipsListener;
        if (onSelectLimitTipsListener8 != null && onSelectLimitTipsListener8.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 1)) {
            return true;
        }
        String formatFileSize2 = PictureFileUtils.formatFileSize(this.selectorConfig.selectMaxFileSize);
        showTipsDialog(getString(R.string.ps_select_max_size, formatFileSize2));
        return true;
    }

    public int confirmSelect(LocalMedia localMedia, boolean z11) {
        OnSelectFilterListener onSelectFilterListener = this.selectorConfig.onSelectFilterListener;
        boolean z12 = false;
        if (onSelectFilterListener != null && onSelectFilterListener.onSelectFilter(localMedia)) {
            OnSelectLimitTipsListener onSelectLimitTipsListener = this.selectorConfig.onSelectLimitTipsListener;
            if (onSelectLimitTipsListener != null) {
                z12 = onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 13);
            }
            if (!z12) {
                ToastUtils.showToast(getAppContext(), getString(R.string.ps_select_no_support));
            }
            return -1;
        } else if (isCheckSelectValidity(localMedia, z11) != 200) {
            return -1;
        } else {
            ArrayList<LocalMedia> selectedResult = this.selectorConfig.getSelectedResult();
            if (z11) {
                selectedResult.remove(localMedia);
                z12 = true;
            } else {
                if (this.selectorConfig.selectionMode == 1 && selectedResult.size() > 0) {
                    sendFixedSelectedChangeEvent(selectedResult.get(0));
                    selectedResult.clear();
                }
                selectedResult.add(localMedia);
                localMedia.setNum(selectedResult.size());
                playClickEffect();
            }
            sendSelectedChangeEvent(!z12, localMedia);
            return z12 ? 1 : 0;
        }
    }

    public void dismissLoading() {
        try {
            if (!ActivityCompatHelper.isDestroy(getActivity()) && this.mLoadingDialog.isShowing()) {
                this.mLoadingDialog.dismiss();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void dispatchCameraMediaResult(LocalMedia localMedia) {
    }

    public void dispatchTransformResult() {
        if (!checkCompleteSelectLimit() && isAdded()) {
            ArrayList arrayList = new ArrayList(this.selectorConfig.getSelectedResult());
            if (checkCropValidity()) {
                onCrop(arrayList);
            } else if (checkOldCropValidity()) {
                onOldCrop(arrayList);
            } else if (checkCompressValidity()) {
                onCompress(arrayList);
            } else if (checkOldCompressValidity()) {
                onOldCompress(arrayList);
            } else {
                onResultEvent(arrayList);
            }
        }
    }

    public Context getAppContext() {
        Context context2 = getContext();
        if (context2 != null) {
            return context2;
        }
        Context appContext = PictureAppMaster.getInstance().getAppContext();
        if (appContext != null) {
            return appContext;
        }
        return this.context;
    }

    public long getEnterAnimationDuration() {
        long j11 = this.enterAnimDuration;
        if (j11 > 50) {
            j11 -= 50;
        }
        if (j11 >= 0) {
            return j11;
        }
        return 0;
    }

    public String getFragmentTag() {
        return TAG;
    }

    public String getOutputPath(Intent intent) {
        if (intent == null) {
            return null;
        }
        Uri uri = (Uri) intent.getParcelableExtra("output");
        String str = this.selectorConfig.cameraPath;
        boolean z11 = TextUtils.isEmpty(str) || PictureMimeType.isContent(str) || new File(str).exists();
        if ((this.selectorConfig.chooseMode == SelectMimeType.ofAudio() || !z11) && uri == null) {
            uri = intent.getData();
        }
        if (uri == null) {
            return null;
        }
        return PictureMimeType.isContent(uri.toString()) ? uri.toString() : uri.getPath();
    }

    public int getResourceId() {
        return 0;
    }

    public SelectorResult getResult(int i11, ArrayList<LocalMedia> arrayList) {
        return new SelectorResult(i11, arrayList != null ? PictureSelector.putIntentResult(arrayList) : null);
    }

    public void handlePermissionDenied(String[] strArr) {
        PermissionConfig.CURRENT_REQUEST_PERMISSION = strArr;
        if (strArr != null && strArr.length > 0) {
            SpUtils.putBoolean(getAppContext(), strArr[0], true);
        }
        if (this.selectorConfig.onPermissionDeniedListener != null) {
            onPermissionExplainEvent(false, (String[]) null);
            this.selectorConfig.onPermissionDeniedListener.onDenied(this, strArr, 1102, new OnCallbackListener<Boolean>() {
                public void onCall(Boolean bool) {
                    if (bool.booleanValue()) {
                        PictureCommonFragment.this.handlePermissionSettingResult(PermissionConfig.CURRENT_REQUEST_PERMISSION);
                    }
                }
            });
            return;
        }
        PermissionUtil.goIntentSetting(this, 1102);
    }

    public void handlePermissionSettingResult(String[] strArr) {
    }

    public void initAppLanguage() {
        if (this.selectorConfig == null) {
            this.selectorConfig = SelectorProviders.getInstance().getSelectorConfig();
        }
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2 != null && selectorConfig2.language != -2) {
            FragmentActivity activity = getActivity();
            SelectorConfig selectorConfig3 = this.selectorConfig;
            PictureLanguageUtils.setAppLanguage(activity, selectorConfig3.language, selectorConfig3.defaultLanguage);
        }
    }

    public int isCheckSelectValidity(LocalMedia localMedia, boolean z11) {
        String mimeType = localMedia.getMimeType();
        long duration = localMedia.getDuration();
        long size = localMedia.getSize();
        ArrayList<LocalMedia> selectedResult = this.selectorConfig.getSelectedResult();
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2.isWithVideoImage) {
            int i11 = 0;
            for (int i12 = 0; i12 < selectedResult.size(); i12++) {
                if (PictureMimeType.isHasVideo(selectedResult.get(i12).getMimeType())) {
                    i11++;
                }
            }
            if (checkWithMimeTypeValidity(localMedia, z11, mimeType, i11, size, duration)) {
                return -1;
            }
            return 200;
        }
        if (checkOnlyMimeTypeValidity(localMedia, z11, mimeType, selectorConfig2.getResultFirstMimeType(), size, duration)) {
            return -1;
        }
        return 200;
    }

    public boolean isNormalDefaultEnter() {
        return (getActivity() instanceof PictureSelectorSupporterActivity) || (getActivity() instanceof PictureSelectorTransparentActivity);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        ForegroundService.stopService(getAppContext());
        String str = "";
        if (i12 == -1) {
            if (i11 == 909) {
                dispatchHandleCamera(intent);
            } else if (i11 == 696) {
                onEditMedia(intent);
            } else if (i11 == 69) {
                ArrayList<LocalMedia> selectedResult = this.selectorConfig.getSelectedResult();
                try {
                    boolean z11 = false;
                    if (selectedResult.size() == 1) {
                        LocalMedia localMedia = selectedResult.get(0);
                        Uri output = Crop.getOutput(intent);
                        if (output != null) {
                            str = output.getPath();
                        }
                        localMedia.setCutPath(str);
                        if (!TextUtils.isEmpty(localMedia.getCutPath())) {
                            z11 = true;
                        }
                        localMedia.setCut(z11);
                        localMedia.setCropImageWidth(Crop.getOutputImageWidth(intent));
                        localMedia.setCropImageHeight(Crop.getOutputImageHeight(intent));
                        localMedia.setCropOffsetX(Crop.getOutputImageOffsetX(intent));
                        localMedia.setCropOffsetY(Crop.getOutputImageOffsetY(intent));
                        localMedia.setCropResultAspectRatio(Crop.getOutputCropAspectRatio(intent));
                        localMedia.setCustomData(Crop.getOutputCustomExtraData(intent));
                        localMedia.setSandboxPath(localMedia.getCutPath());
                    } else {
                        String stringExtra = intent.getStringExtra("output");
                        if (TextUtils.isEmpty(stringExtra)) {
                            stringExtra = intent.getStringExtra("com.yalantis.ucrop.OutputUri");
                        }
                        JSONArray jSONArray = new JSONArray(stringExtra);
                        if (jSONArray.length() == selectedResult.size()) {
                            for (int i13 = 0; i13 < selectedResult.size(); i13++) {
                                LocalMedia localMedia2 = selectedResult.get(i13);
                                JSONObject optJSONObject = jSONArray.optJSONObject(i13);
                                localMedia2.setCutPath(optJSONObject.optString("outPutPath"));
                                localMedia2.setCut(!TextUtils.isEmpty(localMedia2.getCutPath()));
                                localMedia2.setCropImageWidth(optJSONObject.optInt("imageWidth"));
                                localMedia2.setCropImageHeight(optJSONObject.optInt("imageHeight"));
                                localMedia2.setCropOffsetX(optJSONObject.optInt("offsetX"));
                                localMedia2.setCropOffsetY(optJSONObject.optInt("offsetY"));
                                localMedia2.setCropResultAspectRatio((float) optJSONObject.optDouble("aspectRatio"));
                                localMedia2.setCustomData(optJSONObject.optString(CustomIntentKey.EXTRA_CUSTOM_EXTRA_DATA));
                                localMedia2.setSandboxPath(localMedia2.getCutPath());
                            }
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    ToastUtils.showToast(getAppContext(), e11.getMessage());
                }
                ArrayList arrayList = new ArrayList(selectedResult);
                if (checkCompressValidity()) {
                    onCompress(arrayList);
                } else if (checkOldCompressValidity()) {
                    onOldCompress(arrayList);
                } else {
                    onResultEvent(arrayList);
                }
            }
        } else if (i12 == 96) {
            Throwable error = intent != null ? Crop.getError(intent) : new Throwable("image crop error");
            if (error != null) {
                ToastUtils.showToast(getAppContext(), error.getMessage());
            }
        } else if (i12 != 0) {
        } else {
            if (i11 == 909) {
                if (!TextUtils.isEmpty(this.selectorConfig.cameraPath)) {
                    MediaUtils.deleteUri(getAppContext(), this.selectorConfig.cameraPath);
                    this.selectorConfig.cameraPath = str;
                }
            } else if (i11 == 1102) {
                handlePermissionSettingResult(PermissionConfig.CURRENT_REQUEST_PERMISSION);
            }
        }
    }

    public void onApplyPermissionsEvent(final int i11, String[] strArr) {
        this.selectorConfig.onPermissionsEventListener.requestPermission(this, strArr, new OnRequestPermissionListener() {
            public void onCall(String[] strArr, boolean z11) {
                if (!z11) {
                    PictureCommonFragment.this.handlePermissionDenied(strArr);
                } else if (i11 == PermissionEvent.EVENT_VIDEO_CAMERA) {
                    PictureCommonFragment.this.startCameraVideoCapture();
                } else {
                    PictureCommonFragment.this.startCameraImageCapture();
                }
            }
        });
    }

    public void onAttach(Context context2) {
        initAppLanguage();
        onRecreateEngine();
        super.onAttach(context2);
        this.context = context2;
        if (getParentFragment() instanceof IBridgePictureBehavior) {
            this.iBridgePictureBehavior = (IBridgePictureBehavior) getParentFragment();
        } else if (context2 instanceof IBridgePictureBehavior) {
            this.iBridgePictureBehavior = (IBridgePictureBehavior) context2;
        }
    }

    public void onBackCurrentFragment() {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            if (!isStateSaved()) {
                IBridgeViewLifecycle iBridgeViewLifecycle = this.selectorConfig.viewLifecycle;
                if (iBridgeViewLifecycle != null) {
                    iBridgeViewLifecycle.onDestroy(this);
                }
                getActivity().getSupportFragmentManager().j1();
            }
            List<Fragment> B0 = getActivity().getSupportFragmentManager().B0();
            for (int i11 = 0; i11 < B0.size(); i11++) {
                Fragment fragment = B0.get(i11);
                if (fragment instanceof PictureCommonFragment) {
                    ((PictureCommonFragment) fragment).onFragmentResume();
                }
            }
        }
    }

    public void onCheckOriginalChange() {
    }

    public void onCompress(final ArrayList<LocalMedia> arrayList) {
        showLoading();
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            LocalMedia localMedia = arrayList.get(i11);
            String availablePath = localMedia.getAvailablePath();
            if (!PictureMimeType.isHasHttp(availablePath)) {
                SelectorConfig selectorConfig2 = this.selectorConfig;
                if ((!selectorConfig2.isCheckOriginalImage || !selectorConfig2.isOriginalSkipCompress) && PictureMimeType.isHasImage(localMedia.getMimeType())) {
                    arrayList2.add(PictureMimeType.isContent(availablePath) ? Uri.parse(availablePath) : Uri.fromFile(new File(availablePath)));
                    concurrentHashMap.put(availablePath, localMedia);
                }
            }
        }
        if (concurrentHashMap.size() == 0) {
            onResultEvent(arrayList);
        } else {
            this.selectorConfig.compressFileEngine.onStartCompress(getAppContext(), arrayList2, new OnKeyValueResultCallbackListener() {
                public void onCallback(String str, String str2) {
                    if (TextUtils.isEmpty(str)) {
                        PictureCommonFragment.this.onResultEvent(arrayList);
                        return;
                    }
                    LocalMedia localMedia = (LocalMedia) concurrentHashMap.get(str);
                    if (localMedia != null) {
                        if (!SdkVersionUtils.isQ()) {
                            localMedia.setCompressPath(str2);
                            localMedia.setCompressed(!TextUtils.isEmpty(str2));
                        } else if (!TextUtils.isEmpty(str2) && (str2.contains("Android/data/") || str2.contains("data/user/"))) {
                            localMedia.setCompressPath(str2);
                            localMedia.setCompressed(!TextUtils.isEmpty(str2));
                            localMedia.setSandboxPath(localMedia.getCompressPath());
                        }
                        concurrentHashMap.remove(str);
                    }
                    if (concurrentHashMap.size() == 0) {
                        PictureCommonFragment.this.onResultEvent(arrayList);
                    }
                }
            });
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        initAppLanguage();
    }

    public Animation onCreateAnimation(int i11, boolean z11, int i12) {
        Animation animation;
        Animation loadAnimation;
        PictureWindowAnimationStyle windowAnimationStyle = this.selectorConfig.selectorStyle.getWindowAnimationStyle();
        if (z11) {
            if (windowAnimationStyle.activityEnterAnimation != 0) {
                animation = AnimationUtils.loadAnimation(getAppContext(), windowAnimationStyle.activityEnterAnimation);
            } else {
                animation = AnimationUtils.loadAnimation(getAppContext(), R.anim.ps_anim_alpha_enter);
            }
            setEnterAnimationDuration(animation.getDuration());
            onEnterFragment();
        } else {
            if (windowAnimationStyle.activityExitAnimation != 0) {
                loadAnimation = AnimationUtils.loadAnimation(getAppContext(), windowAnimationStyle.activityExitAnimation);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getAppContext(), R.anim.ps_anim_alpha_exit);
            }
            onExitFragment();
        }
        return animation;
    }

    public void onCreateLoader() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getResourceId() != 0) {
            return layoutInflater.inflate(getResourceId(), viewGroup, false);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onCrop(ArrayList<LocalMedia> arrayList) {
        Uri uri;
        ArrayList arrayList2 = new ArrayList();
        Uri uri2 = null;
        Uri uri3 = null;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            LocalMedia localMedia = arrayList.get(i11);
            arrayList2.add(localMedia.getAvailablePath());
            if (uri2 == null && PictureMimeType.isHasImage(localMedia.getMimeType())) {
                String availablePath = localMedia.getAvailablePath();
                if (PictureMimeType.isContent(availablePath) || PictureMimeType.isHasHttp(availablePath)) {
                    uri = Uri.parse(availablePath);
                } else {
                    uri = Uri.fromFile(new File(availablePath));
                }
                uri2 = uri;
                uri3 = Uri.fromFile(new File(new File(FileDirMap.getFileDirPath(getAppContext(), 1)).getAbsolutePath(), DateUtils.getCreateFileName("CROP_") + PictureMimeType.JPG));
            }
        }
        this.selectorConfig.cropFileEngine.onStartCrop(this, uri2, uri3, arrayList2, 69);
    }

    public void onDestroy() {
        releaseSoundPool();
        super.onDestroy();
    }

    public void onEditMedia(Intent intent) {
    }

    public void onEnterFragment() {
    }

    public void onExitFragment() {
    }

    public void onExitPictureSelector() {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            if (isNormalDefaultEnter()) {
                IBridgeViewLifecycle iBridgeViewLifecycle = this.selectorConfig.viewLifecycle;
                if (iBridgeViewLifecycle != null) {
                    iBridgeViewLifecycle.onDestroy(this);
                }
                getActivity().finish();
            } else {
                List<Fragment> B0 = getActivity().getSupportFragmentManager().B0();
                for (int i11 = 0; i11 < B0.size(); i11++) {
                    if (B0.get(i11) instanceof PictureCommonFragment) {
                        onBackCurrentFragment();
                    }
                }
            }
        }
        SelectorProviders.getInstance().destroy();
    }

    public void onFixedSelectedChange(LocalMedia localMedia) {
    }

    public void onFragmentResume() {
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    public void onInterceptCameraEvent(int i11) {
        ForegroundService.startForegroundService(getAppContext(), this.selectorConfig.isCameraForegroundService);
        this.selectorConfig.onCameraInterceptListener.openCamera(this, i11, PictureConfig.REQUEST_CAMERA);
    }

    public void onKeyBackFragmentFinish() {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            SelectorConfig selectorConfig2 = this.selectorConfig;
            if (selectorConfig2.isActivityResultBack) {
                getActivity().setResult(0);
                onSelectFinish(0, (ArrayList<LocalMedia>) null);
            } else {
                OnResultCallbackListener<LocalMedia> onResultCallbackListener = selectorConfig2.onResultCallListener;
                if (onResultCallbackListener != null) {
                    onResultCallbackListener.onCancel();
                }
            }
            onExitPictureSelector();
        }
    }

    public void onOldCompress(ArrayList<LocalMedia> arrayList) {
        showLoading();
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (!selectorConfig2.isCheckOriginalImage || !selectorConfig2.isOriginalSkipCompress) {
            selectorConfig2.compressEngine.onStartCompress(getAppContext(), arrayList, new OnCallbackListener<ArrayList<LocalMedia>>() {
                public void onCall(ArrayList<LocalMedia> arrayList) {
                    PictureCommonFragment.this.onResultEvent(arrayList);
                }
            });
        } else {
            onResultEvent(arrayList);
        }
    }

    public void onOldCrop(ArrayList<LocalMedia> arrayList) {
        LocalMedia localMedia;
        int i11 = 0;
        while (true) {
            if (i11 >= arrayList.size()) {
                localMedia = null;
                break;
            }
            localMedia = arrayList.get(i11);
            if (PictureMimeType.isHasImage(arrayList.get(i11).getMimeType())) {
                break;
            }
            i11++;
        }
        this.selectorConfig.cropEngine.onStartCrop(this, localMedia, arrayList, 69);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    public void onPermissionExplainEvent(boolean z11, String[] strArr) {
        OnPermissionDescriptionListener onPermissionDescriptionListener = this.selectorConfig.onPermissionDescriptionListener;
        if (onPermissionDescriptionListener == null) {
            return;
        }
        if (!z11) {
            onPermissionDescriptionListener.onDismiss(this);
        } else if (PermissionChecker.isCheckSelfPermission(getAppContext(), strArr)) {
            SpUtils.putBoolean(getAppContext(), strArr[0], false);
        } else if (!SpUtils.getBoolean(getAppContext(), strArr[0], false)) {
            this.selectorConfig.onPermissionDescriptionListener.onPermissionDescription(this, strArr);
        }
    }

    public void onRecreateEngine() {
        createImageLoaderEngine();
        createVideoPlayerEngine();
        createCompressEngine();
        createSandboxFileEngine();
        createLoaderDataEngine();
        createResultCallbackListener();
        createLayoutResourceListener();
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        if (this.mPermissionResultCallback != null) {
            PermissionChecker.getInstance().onRequestPermissionsResult(iArr, this.mPermissionResultCallback);
            this.mPermissionResultCallback = null;
        }
    }

    public void onResultEvent(ArrayList<LocalMedia> arrayList) {
        if (checkTransformSandboxFile()) {
            uriToFileTransform29(arrayList);
        } else if (checkOldTransformSandboxFile()) {
            copyExternalPathToAppInDirFor29(arrayList);
        } else {
            mergeOriginalImage(arrayList);
            dispatchUriToFileTransformResult(arrayList);
        }
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onSelectFinish(int i11, ArrayList<LocalMedia> arrayList) {
        if (this.iBridgePictureBehavior != null) {
            this.iBridgePictureBehavior.onSelectFinish(getResult(i11, arrayList));
        }
    }

    public void onSelectedChange(boolean z11, LocalMedia localMedia) {
    }

    public void onSelectedOnlyCamera() {
        PhotoItemSelectedDialog newInstance = PhotoItemSelectedDialog.newInstance();
        newInstance.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(View view, int i11) {
                if (i11 == 0) {
                    PictureCommonFragment pictureCommonFragment = PictureCommonFragment.this;
                    if (pictureCommonFragment.selectorConfig.onCameraInterceptListener != null) {
                        pictureCommonFragment.onInterceptCameraEvent(1);
                    } else {
                        pictureCommonFragment.openImageCamera();
                    }
                } else if (i11 == 1) {
                    PictureCommonFragment pictureCommonFragment2 = PictureCommonFragment.this;
                    if (pictureCommonFragment2.selectorConfig.onCameraInterceptListener != null) {
                        pictureCommonFragment2.onInterceptCameraEvent(2);
                    } else {
                        pictureCommonFragment2.openVideoCamera();
                    }
                }
            }
        });
        newInstance.setOnDismissListener(new PhotoItemSelectedDialog.OnDismissListener() {
            public void onDismiss(boolean z11, DialogInterface dialogInterface) {
                PictureCommonFragment pictureCommonFragment = PictureCommonFragment.this;
                if (pictureCommonFragment.selectorConfig.isOnlyCamera && z11) {
                    pictureCommonFragment.onKeyBackFragmentFinish();
                }
            }
        });
        newInstance.show(getChildFragmentManager(), "PhotoItemSelectedDialog");
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.selectorConfig = SelectorProviders.getInstance().getSelectorConfig();
        FileDirMap.init(view.getContext());
        IBridgeViewLifecycle iBridgeViewLifecycle = this.selectorConfig.viewLifecycle;
        if (iBridgeViewLifecycle != null) {
            iBridgeViewLifecycle.onViewCreated(this, view, bundle);
        }
        OnCustomLoadingListener onCustomLoadingListener = this.selectorConfig.onCustomLoadingListener;
        if (onCustomLoadingListener != null) {
            this.mLoadingDialog = onCustomLoadingListener.create(getAppContext());
        } else {
            this.mLoadingDialog = new PictureLoadingDialog(getAppContext());
        }
        setRequestedOrientation();
        setTranslucentStatusBar();
        setRootViewKeyListener(requireView());
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2.isOpenClickSound && !selectorConfig2.isOnlyCamera) {
            SoundPool soundPool2 = new SoundPool(1, 3, 0);
            this.soundPool = soundPool2;
            this.soundID = soundPool2.load(getAppContext(), R.raw.ps_click_music, 1);
        }
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void openImageCamera() {
        String[] strArr = PermissionConfig.CAMERA;
        onPermissionExplainEvent(true, strArr);
        if (this.selectorConfig.onPermissionsEventListener != null) {
            onApplyPermissionsEvent(PermissionEvent.EVENT_IMAGE_CAMERA, strArr);
        } else {
            PermissionChecker.getInstance().requestPermissions((Fragment) this, strArr, (PermissionResultCallback) new PermissionResultCallback() {
                public void onDenied() {
                    PictureCommonFragment.this.handlePermissionDenied(PermissionConfig.CAMERA);
                }

                public void onGranted() {
                    PictureCommonFragment.this.startCameraImageCapture();
                }
            });
        }
    }

    public void openSelectedCamera() {
        SelectorConfig selectorConfig2 = this.selectorConfig;
        int i11 = selectorConfig2.chooseMode;
        if (i11 != 0) {
            if (i11 == 1) {
                openImageCamera();
            } else if (i11 == 2) {
                openVideoCamera();
            } else if (i11 == 3) {
                openSoundRecording();
            }
        } else if (selectorConfig2.ofAllCameraType == SelectMimeType.ofImage()) {
            openImageCamera();
        } else if (this.selectorConfig.ofAllCameraType == SelectMimeType.ofVideo()) {
            openVideoCamera();
        } else {
            onSelectedOnlyCamera();
        }
    }

    public void openSoundRecording() {
        if (this.selectorConfig.onRecordAudioListener != null) {
            ForegroundService.startForegroundService(getAppContext(), this.selectorConfig.isCameraForegroundService);
            this.selectorConfig.onRecordAudioListener.onRecordAudio(this, PictureConfig.REQUEST_CAMERA);
            return;
        }
        throw new NullPointerException(OnRecordAudioInterceptListener.class.getSimpleName() + " interface needs to be implemented for recording");
    }

    public void openVideoCamera() {
        String[] strArr = PermissionConfig.CAMERA;
        onPermissionExplainEvent(true, strArr);
        if (this.selectorConfig.onPermissionsEventListener != null) {
            onApplyPermissionsEvent(PermissionEvent.EVENT_VIDEO_CAMERA, strArr);
        } else {
            PermissionChecker.getInstance().requestPermissions((Fragment) this, strArr, (PermissionResultCallback) new PermissionResultCallback() {
                public void onDenied() {
                    PictureCommonFragment.this.handlePermissionDenied(PermissionConfig.CAMERA);
                }

                public void onGranted() {
                    PictureCommonFragment.this.startCameraVideoCapture();
                }
            });
        }
    }

    public void reStartSavedInstance(Bundle bundle) {
    }

    public void sendChangeSubSelectPositionEvent(boolean z11) {
    }

    public void sendFixedSelectedChangeEvent(LocalMedia localMedia) {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            List<Fragment> B0 = getActivity().getSupportFragmentManager().B0();
            for (int i11 = 0; i11 < B0.size(); i11++) {
                Fragment fragment = B0.get(i11);
                if (fragment instanceof PictureCommonFragment) {
                    ((PictureCommonFragment) fragment).onFixedSelectedChange(localMedia);
                }
            }
        }
    }

    public void sendSelectedChangeEvent(boolean z11, LocalMedia localMedia) {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            List<Fragment> B0 = getActivity().getSupportFragmentManager().B0();
            for (int i11 = 0; i11 < B0.size(); i11++) {
                Fragment fragment = B0.get(i11);
                if (fragment instanceof PictureCommonFragment) {
                    ((PictureCommonFragment) fragment).onSelectedChange(z11, localMedia);
                }
            }
        }
    }

    public void sendSelectedOriginalChangeEvent() {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            List<Fragment> B0 = getActivity().getSupportFragmentManager().B0();
            for (int i11 = 0; i11 < B0.size(); i11++) {
                Fragment fragment = B0.get(i11);
                if (fragment instanceof PictureCommonFragment) {
                    ((PictureCommonFragment) fragment).onCheckOriginalChange();
                }
            }
        }
    }

    public void setEnterAnimationDuration(long j11) {
        this.enterAnimDuration = j11;
    }

    public void setPermissionsResultAction(PermissionResultCallback permissionResultCallback) {
        this.mPermissionResultCallback = permissionResultCallback;
    }

    public void setRequestedOrientation() {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            getActivity().setRequestedOrientation(this.selectorConfig.requestedOrientation);
        }
    }

    public void setRootViewKeyListener(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i11, KeyEvent keyEvent) {
                if (i11 != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                PictureCommonFragment.this.onKeyBackFragmentFinish();
                return true;
            }
        });
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void showLoading() {
        try {
            if (!ActivityCompatHelper.isDestroy(getActivity()) && !this.mLoadingDialog.isShowing()) {
                this.mLoadingDialog.show();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void startCameraImageCapture() {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            onPermissionExplainEvent(false, (String[]) null);
            if (this.selectorConfig.onCameraInterceptListener != null) {
                onInterceptCameraEvent(1);
                return;
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                ForegroundService.startForegroundService(getAppContext(), this.selectorConfig.isCameraForegroundService);
                Uri createCameraOutImageUri = MediaStoreUtils.createCameraOutImageUri(getAppContext(), this.selectorConfig);
                if (createCameraOutImageUri != null) {
                    if (this.selectorConfig.isCameraAroundState) {
                        intent.putExtra(PictureConfig.CAMERA_FACING, 1);
                    }
                    intent.putExtra("output", createCameraOutImageUri);
                    startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
                }
            }
        }
    }

    public void startCameraVideoCapture() {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            onPermissionExplainEvent(false, (String[]) null);
            if (this.selectorConfig.onCameraInterceptListener != null) {
                onInterceptCameraEvent(2);
                return;
            }
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                ForegroundService.startForegroundService(getAppContext(), this.selectorConfig.isCameraForegroundService);
                Uri createCameraOutVideoUri = MediaStoreUtils.createCameraOutVideoUri(getAppContext(), this.selectorConfig);
                if (createCameraOutVideoUri != null) {
                    intent.putExtra("output", createCameraOutVideoUri);
                    if (this.selectorConfig.isCameraAroundState) {
                        intent.putExtra(PictureConfig.CAMERA_FACING, 1);
                    }
                    intent.putExtra(PictureConfig.EXTRA_QUICK_CAPTURE, this.selectorConfig.isQuickCapture);
                    intent.putExtra("android.intent.extra.durationLimit", this.selectorConfig.recordVideoMaxSecond);
                    intent.putExtra("android.intent.extra.videoQuality", this.selectorConfig.videoQuality);
                    startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
                }
            }
        }
    }
}
