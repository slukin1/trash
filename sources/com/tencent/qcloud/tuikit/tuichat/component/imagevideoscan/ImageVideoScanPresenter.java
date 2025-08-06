package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.util.ThreadUtils;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.FileUtil;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImageVideoScanPresenter {
    /* access modifiers changed from: private */
    public static final String TAG = "ImageVideoScanPresenter";
    private static MessageChangedListener messageChangedListener = new MessageChangedListener();
    /* access modifiers changed from: private */
    public ImageVideoScanAdapter mAdapter;
    /* access modifiers changed from: private */
    public String mChatID;
    /* access modifiers changed from: private */
    public int mCurrentPosition = -1;
    /* access modifiers changed from: private */
    public ImageVideoScanProvider mImageVideoScanProvider;
    /* access modifiers changed from: private */
    public int mIndex = 0;
    /* access modifiers changed from: private */
    public boolean mIsForwardMode = false;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;
    private ViewPagerLayoutManager mViewPagerLayoutManager;

    public static class MessageChangedListener implements ITUINotification {
        /* access modifiers changed from: private */
        public WeakReference<ImageVideoScanPresenter> presenterWeakReference;

        private MessageChangedListener() {
        }

        public void onNotifyEvent(String str, String str2, Map<String, Object> map) {
            WeakReference<ImageVideoScanPresenter> weakReference = this.presenterWeakReference;
            if (weakReference != null && weakReference.get() != null) {
                ((ImageVideoScanPresenter) this.presenterWeakReference.get()).onMessageStatusChanged((TUIMessageBean) map.get("messageBean"));
            }
        }
    }

    public ImageVideoScanPresenter() {
        WeakReference unused = messageChangedListener.presenterWeakReference = new WeakReference(this);
        TUICore.registerEvent(TUIChatConstants.EVENT_KEY_MESSAGE_STATUS_CHANGED, TUIChatConstants.EVENT_SUB_KEY_MESSAGE_SEND, messageChangedListener);
    }

    private void saveImage(final Context context, final String str) {
        ThreadUtils.execute(new Runnable() {
            public void run() {
                if (FileUtil.saveImageToGallery(context, str)) {
                    ToastUtil.toastShortMessage(context.getString(R.string.save_success));
                } else {
                    ToastUtil.toastShortMessage(context.getString(R.string.save_failed));
                }
            }
        });
    }

    private void saveVideo(final Context context, final String str) {
        ThreadUtils.execute(new Runnable() {
            public void run() {
                if (FileUtil.saveVideoToGallery(context, str)) {
                    ToastUtil.toastShortMessage(context.getString(R.string.save_success));
                } else {
                    ToastUtil.toastShortMessage(context.getString(R.string.save_failed));
                }
            }
        });
    }

    public void init(final TUIMessageBean tUIMessageBean, List<TUIMessageBean> list, boolean z11) {
        this.mIsForwardMode = z11;
        if (z11) {
            this.mAdapter.setDataSource(list);
            this.mAdapter.notifyDataSetChanged();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i12 >= list.size()) {
                    break;
                } else if (list.get(i12).getId().equals(tUIMessageBean.getId())) {
                    i11 = i12;
                    break;
                } else {
                    i12++;
                }
            }
            this.mRecyclerView.scrollToPosition(i11);
            this.mCurrentPosition = i11;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(tUIMessageBean);
            this.mAdapter.setDataSource(arrayList);
            this.mAdapter.notifyDataSetChanged();
            this.mImageVideoScanProvider = new ImageVideoScanProvider();
            String groupID = tUIMessageBean.isGroup() ? tUIMessageBean.getV2TIMMessage().getGroupID() : tUIMessageBean.getV2TIMMessage().getUserID();
            this.mChatID = groupID;
            this.mImageVideoScanProvider.initMessageList(groupID, tUIMessageBean.isGroup(), tUIMessageBean, new IUIKitCallback<List<TUIMessageBean>>() {
                public void onError(String str, int i11, String str2) {
                    String access$500 = ImageVideoScanPresenter.TAG;
                    TUIChatLog.e(access$500, "loadChatMessages initMessageList failed, code = " + i11 + ", desc = " + str2);
                }

                public void onSuccess(List<TUIMessageBean> list) {
                    ImageVideoScanPresenter.this.mAdapter.setDataSource(list);
                    ImageVideoScanPresenter.this.mAdapter.notifyDataSetChanged();
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (list.get(i12).getId().equals(tUIMessageBean.getId())) {
                            i11 = i12;
                            break;
                        } else {
                            i12++;
                        }
                    }
                    ImageVideoScanPresenter.this.mRecyclerView.scrollToPosition(i11);
                    int unused = ImageVideoScanPresenter.this.mCurrentPosition = i11;
                }
            });
        }
        this.mViewPagerLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            public void onInitComplete() {
                Log.i(ImageVideoScanPresenter.TAG, "onInitComplete");
            }

            public void onPageRelease(boolean z11, int i11) {
                String access$500 = ImageVideoScanPresenter.TAG;
                Log.i(access$500, "release position :" + i11 + " next page:" + z11);
                int unused = ImageVideoScanPresenter.this.mIndex = z11 ^ true ? 1 : 0;
                ImageVideoScanPresenter.this.releaseUI();
            }

            public void onPageSelected(final int i11, boolean z11, boolean z12) {
                String access$500 = ImageVideoScanPresenter.TAG;
                Log.i(access$500, "select:" + i11 + " isBottom:" + z11 + "isLeftScroll:" + z11);
                int unused = ImageVideoScanPresenter.this.mCurrentPosition = i11;
                if (!ImageVideoScanPresenter.this.mIsForwardMode) {
                    if (z12) {
                        if (i11 == 0) {
                            if (ImageVideoScanPresenter.this.mAdapter.getOldLocateMessage() != null) {
                                String access$5002 = ImageVideoScanPresenter.TAG;
                                Log.d(access$5002, "mAdapter.getOldLocateMessage() seq:" + ImageVideoScanPresenter.this.mAdapter.getOldLocateMessage().getV2TIMMessage().getSeq());
                            }
                            ImageVideoScanPresenter.this.mImageVideoScanProvider.loadLocalMediaMessageForward(ImageVideoScanPresenter.this.mChatID, tUIMessageBean.isGroup(), ImageVideoScanPresenter.this.mAdapter.getOldLocateMessage(), new IUIKitCallback<List<TUIMessageBean>>() {
                                public void onError(String str, int i11, String str2) {
                                    String access$500 = ImageVideoScanPresenter.TAG;
                                    TUIChatLog.e(access$500, "onPageSelected loadLocalMediaMessageForward failed, code = " + i11 + ", desc = " + str2);
                                }

                                public void onSuccess(List<TUIMessageBean> list) {
                                    if (list != null && !list.isEmpty()) {
                                        ImageVideoScanPresenter.this.mRecyclerView.scrollToPosition(ImageVideoScanPresenter.this.mAdapter.addDataToSource(list, 0, i11));
                                        ImageVideoScanPresenter.this.mAdapter.notifyDataSetChanged();
                                    }
                                }
                            });
                        }
                    } else if (i11 == ImageVideoScanPresenter.this.mAdapter.getItemCount() - 1) {
                        if (ImageVideoScanPresenter.this.mAdapter.getNewLocateMessage() != null) {
                            String access$5003 = ImageVideoScanPresenter.TAG;
                            Log.d(access$5003, "mAdapter.getNewLocateMessage() seq:" + ImageVideoScanPresenter.this.mAdapter.getNewLocateMessage().getV2TIMMessage().getSeq());
                        }
                        ImageVideoScanPresenter.this.mImageVideoScanProvider.loadLocalMediaMessageBackward(ImageVideoScanPresenter.this.mChatID, tUIMessageBean.isGroup(), ImageVideoScanPresenter.this.mAdapter.getNewLocateMessage(), new IUIKitCallback<List<TUIMessageBean>>() {
                            public void onError(String str, int i11, String str2) {
                                String access$500 = ImageVideoScanPresenter.TAG;
                                TUIChatLog.e(access$500, "onPageSelected loadLocalMediaMessageBackward failed, code = " + i11 + ", desc = " + str2);
                            }

                            public void onSuccess(List<TUIMessageBean> list) {
                                if (list != null && !list.isEmpty()) {
                                    ImageVideoScanPresenter.this.mRecyclerView.scrollToPosition(ImageVideoScanPresenter.this.mAdapter.addDataToSource(list, 1, i11));
                                    ImageVideoScanPresenter.this.mAdapter.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    public void onMessageStatusChanged(TUIMessageBean tUIMessageBean) {
        ImageVideoScanAdapter imageVideoScanAdapter = this.mAdapter;
        if (imageVideoScanAdapter != null) {
            imageVideoScanAdapter.onDataChanged(tUIMessageBean);
        }
    }

    public void releaseUI() {
        ImageVideoScanAdapter imageVideoScanAdapter = this.mAdapter;
        if (imageVideoScanAdapter != null) {
            imageVideoScanAdapter.destroyView(this.mRecyclerView, this.mIndex);
        }
    }

    public void saveLocal(Context context) {
        int i11;
        String str = TAG;
        TUIChatLog.d(str, "mCurrentPosition = " + this.mCurrentPosition);
        ImageVideoScanAdapter imageVideoScanAdapter = this.mAdapter;
        if (imageVideoScanAdapter != null && (i11 = this.mCurrentPosition) >= 0 && i11 < imageVideoScanAdapter.getItemCount()) {
            TUIMessageBean tUIMessageBean = this.mAdapter.getDataSource().get(this.mCurrentPosition);
            if (tUIMessageBean instanceof ImageMessageBean) {
                ImageMessageBean imageMessageBean = (ImageMessageBean) tUIMessageBean;
                String dataPath = imageMessageBean.getDataPath();
                TUIChatLog.d(str, "imagePath = " + dataPath);
                String originImagePath = TUIChatUtils.getOriginImagePath(imageMessageBean);
                TUIChatLog.d(str, "originImagePath = " + originImagePath);
                if (!TextUtils.isEmpty(originImagePath)) {
                    dataPath = originImagePath;
                }
                saveImage(context, dataPath);
            } else if (tUIMessageBean instanceof VideoMessageBean) {
                VideoMessageBean videoMessageBean = (VideoMessageBean) tUIMessageBean;
                String str2 = TUIConfig.getVideoDownloadDir() + videoMessageBean.getVideoUUID();
                File file = new File(str2);
                if (!file.exists() || file.length() != ((long) videoMessageBean.getVideoSize())) {
                    ToastUtil.toastShortMessage(context.getString(R.string.downloading));
                } else {
                    saveVideo(context, str2);
                }
            } else {
                TUIChatLog.d(str, "error message type");
            }
        }
    }

    public void setAdapter(ImageVideoScanAdapter imageVideoScanAdapter) {
        this.mAdapter = imageVideoScanAdapter;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public void setViewPagerLayoutManager(ViewPagerLayoutManager viewPagerLayoutManager) {
        this.mViewPagerLayoutManager = viewPagerLayoutManager;
    }
}
