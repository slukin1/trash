package com.luck.picture.lib.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureAlbumAdapter;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.decoration.WrapContentLinearLayoutManager;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnAlbumItemClickListener;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;

public class AlbumListPopWindow extends PopupWindow {
    private static final int ALBUM_MAX_COUNT = 8;
    /* access modifiers changed from: private */
    public boolean isDismiss = false;
    private PictureAlbumAdapter mAdapter;
    private final Context mContext;
    private RecyclerView mRecyclerView;
    private SelectorConfig selectorConfig;
    private View windMask;
    private int windowMaxHeight;
    private OnPopupWindowStatusListener windowStatusListener;

    public interface OnPopupWindowStatusListener {
        void onDismissPopupWindow();

        void onShowPopupWindow();
    }

    public AlbumListPopWindow(Context context, SelectorConfig selectorConfig2) {
        this.mContext = context;
        this.selectorConfig = selectorConfig2;
        setContentView(LayoutInflater.from(context).inflate(R.layout.ps_window_folder, (ViewGroup) null));
        setWidth(-1);
        setHeight(-2);
        setAnimationStyle(R.style.PictureThemeWindowStyle);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        initViews();
    }

    public static AlbumListPopWindow buildPopWindow(Context context, SelectorConfig selectorConfig2) {
        return new AlbumListPopWindow(context, selectorConfig2);
    }

    private void initViews() {
        this.windowMaxHeight = (int) (((double) DensityUtil.getScreenHeight(this.mContext)) * 0.6d);
        this.mRecyclerView = (RecyclerView) getContentView().findViewById(R.id.folder_list);
        this.windMask = getContentView().findViewById(R.id.rootViewBg);
        this.mRecyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this.mContext));
        PictureAlbumAdapter pictureAlbumAdapter = new PictureAlbumAdapter(this.selectorConfig);
        this.mAdapter = pictureAlbumAdapter;
        this.mRecyclerView.setAdapter(pictureAlbumAdapter);
        this.windMask.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                AlbumListPopWindow.this.dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        getContentView().findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (SdkVersionUtils.isMinM()) {
                    AlbumListPopWindow.this.dismiss();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void bindAlbumData(List<LocalMediaFolder> list) {
        this.mAdapter.bindAlbumData(list);
        this.mAdapter.notifyDataSetChanged();
        this.mRecyclerView.getLayoutParams().height = list.size() > 8 ? this.windowMaxHeight : -2;
    }

    public void changeSelectedAlbumStyle() {
        List<LocalMediaFolder> albumList = this.mAdapter.getAlbumList();
        for (int i11 = 0; i11 < albumList.size(); i11++) {
            LocalMediaFolder localMediaFolder = albumList.get(i11);
            localMediaFolder.setSelectTag(false);
            this.mAdapter.notifyItemChanged(i11);
            int i12 = 0;
            while (true) {
                if (i12 >= this.selectorConfig.getSelectCount()) {
                    break;
                } else if (TextUtils.equals(localMediaFolder.getFolderName(), this.selectorConfig.getSelectedResult().get(i12).getParentFolderName()) || localMediaFolder.getBucketId() == -1) {
                    localMediaFolder.setSelectTag(true);
                    this.mAdapter.notifyItemChanged(i11);
                } else {
                    i12++;
                }
            }
            localMediaFolder.setSelectTag(true);
            this.mAdapter.notifyItemChanged(i11);
        }
    }

    public void dismiss() {
        if (!this.isDismiss) {
            this.windMask.setAlpha(0.0f);
            OnPopupWindowStatusListener onPopupWindowStatusListener = this.windowStatusListener;
            if (onPopupWindowStatusListener != null) {
                onPopupWindowStatusListener.onDismissPopupWindow();
            }
            this.isDismiss = true;
            this.windMask.post(new Runnable() {
                public void run() {
                    AlbumListPopWindow.super.dismiss();
                    boolean unused = AlbumListPopWindow.this.isDismiss = false;
                }
            });
        }
    }

    public List<LocalMediaFolder> getAlbumList() {
        return this.mAdapter.getAlbumList();
    }

    public int getFirstAlbumImageCount() {
        if (getFolderCount() > 0) {
            return getFolder(0).getFolderTotalNum();
        }
        return 0;
    }

    public LocalMediaFolder getFolder(int i11) {
        if (this.mAdapter.getAlbumList().size() <= 0 || i11 >= this.mAdapter.getAlbumList().size()) {
            return null;
        }
        return this.mAdapter.getAlbumList().get(i11);
    }

    public int getFolderCount() {
        return this.mAdapter.getAlbumList().size();
    }

    public void setOnIBridgeAlbumWidget(OnAlbumItemClickListener onAlbumItemClickListener) {
        this.mAdapter.setOnIBridgeAlbumWidget(onAlbumItemClickListener);
    }

    public void setOnPopupWindowStatusListener(OnPopupWindowStatusListener onPopupWindowStatusListener) {
        this.windowStatusListener = onPopupWindowStatusListener;
    }

    public void showAsDropDown(View view) {
        if (getAlbumList() != null && getAlbumList().size() != 0) {
            if (SdkVersionUtils.isN()) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                showAtLocation(view, 0, 0, iArr[1] + view.getHeight());
            } else {
                super.showAsDropDown(view);
            }
            this.isDismiss = false;
            OnPopupWindowStatusListener onPopupWindowStatusListener = this.windowStatusListener;
            if (onPopupWindowStatusListener != null) {
                onPopupWindowStatusListener.onShowPopupWindow();
            }
            this.windMask.animate().alpha(1.0f).setDuration(250).setStartDelay(250).start();
            changeSelectedAlbumStyle();
        }
    }
}
