package com.luck.picture.lib.basic;

import android.app.Activity;
import android.text.TextUtils;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnQueryDataSourceListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.loader.LocalMediaLoader;
import com.luck.picture.lib.loader.LocalMediaPageLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PictureSelectionQueryModel {
    /* access modifiers changed from: private */
    public final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionQueryModel(PictureSelector pictureSelector, int i11) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.chooseMode = i11;
    }

    public IBridgeMediaLoader buildMediaLoader() {
        Activity activity = this.selector.getActivity();
        Objects.requireNonNull(activity, "Activity cannot be null");
        if (this.selectionConfig.isPageStrategy) {
            return new LocalMediaPageLoader(activity, this.selectionConfig);
        }
        return new LocalMediaLoader(activity, this.selectionConfig);
    }

    public PictureSelectionQueryModel isBmp(boolean z11) {
        this.selectionConfig.isBmp = z11;
        return this;
    }

    public PictureSelectionQueryModel isGif(boolean z11) {
        this.selectionConfig.isGif = z11;
        return this;
    }

    public PictureSelectionQueryModel isPageStrategy(boolean z11) {
        this.selectionConfig.isPageStrategy = z11;
        return this;
    }

    public PictureSelectionQueryModel isWebp(boolean z11) {
        this.selectionConfig.isWebp = z11;
        return this;
    }

    public void obtainAlbumData(final OnQueryDataSourceListener<LocalMediaFolder> onQueryDataSourceListener) {
        IBridgeMediaLoader iBridgeMediaLoader;
        Activity activity = this.selector.getActivity();
        Objects.requireNonNull(activity, "Activity cannot be null");
        Objects.requireNonNull(onQueryDataSourceListener, "OnQueryDataSourceListener cannot be null");
        if (this.selectionConfig.isPageStrategy) {
            iBridgeMediaLoader = new LocalMediaPageLoader(activity, this.selectionConfig);
        } else {
            iBridgeMediaLoader = new LocalMediaLoader(activity, this.selectionConfig);
        }
        iBridgeMediaLoader.loadAllAlbum(new OnQueryAllAlbumListener<LocalMediaFolder>() {
            public void onComplete(List<LocalMediaFolder> list) {
                onQueryDataSourceListener.onComplete(list);
            }
        });
    }

    public void obtainMediaData(final OnQueryDataSourceListener<LocalMedia> onQueryDataSourceListener) {
        final IBridgeMediaLoader iBridgeMediaLoader;
        Activity activity = this.selector.getActivity();
        Objects.requireNonNull(activity, "Activity cannot be null");
        Objects.requireNonNull(onQueryDataSourceListener, "OnQueryDataSourceListener cannot be null");
        if (this.selectionConfig.isPageStrategy) {
            iBridgeMediaLoader = new LocalMediaPageLoader(activity, this.selectionConfig);
        } else {
            iBridgeMediaLoader = new LocalMediaLoader(activity, this.selectionConfig);
        }
        iBridgeMediaLoader.loadAllAlbum(new OnQueryAllAlbumListener<LocalMediaFolder>() {
            public void onComplete(List<LocalMediaFolder> list) {
                if (list != null && list.size() > 0) {
                    LocalMediaFolder localMediaFolder = list.get(0);
                    if (PictureSelectionQueryModel.this.selectionConfig.isPageStrategy) {
                        iBridgeMediaLoader.loadPageMediaData(localMediaFolder.getBucketId(), 1, PictureSelectionQueryModel.this.selectionConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() {
                            public void onComplete(ArrayList<LocalMedia> arrayList, boolean z11) {
                                onQueryDataSourceListener.onComplete(arrayList);
                            }
                        });
                        return;
                    }
                    onQueryDataSourceListener.onComplete(localMediaFolder.getData());
                }
            }
        });
    }

    public PictureSelectionQueryModel setFilterMaxFileSize(long j11) {
        if (j11 >= 1048576) {
            this.selectionConfig.filterMaxFileSize = j11;
        } else {
            this.selectionConfig.filterMaxFileSize = j11 * 1024;
        }
        return this;
    }

    public PictureSelectionQueryModel setFilterMinFileSize(long j11) {
        if (j11 >= 1048576) {
            this.selectionConfig.filterMinFileSize = j11;
        } else {
            this.selectionConfig.filterMinFileSize = j11 * 1024;
        }
        return this;
    }

    public PictureSelectionQueryModel setFilterVideoMaxSecond(int i11) {
        this.selectionConfig.filterVideoMaxSecond = i11 * 1000;
        return this;
    }

    public PictureSelectionQueryModel setFilterVideoMinSecond(int i11) {
        this.selectionConfig.filterVideoMinSecond = i11 * 1000;
        return this;
    }

    public PictureSelectionQueryModel setQueryFilterListener(OnQueryFilterListener onQueryFilterListener) {
        this.selectionConfig.onQueryFilterListener = onQueryFilterListener;
        return this;
    }

    public PictureSelectionQueryModel setQuerySortOrder(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.selectionConfig.sortOrder = str;
        }
        return this;
    }

    public PictureSelectionQueryModel isPageStrategy(boolean z11, int i11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isPageStrategy = z11;
        if (i11 < 10) {
            i11 = 60;
        }
        selectorConfig.pageSize = i11;
        return this;
    }

    public PictureSelectionQueryModel isPageStrategy(boolean z11, int i11, boolean z12) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isPageStrategy = z11;
        if (i11 < 10) {
            i11 = 60;
        }
        selectorConfig.pageSize = i11;
        selectorConfig.isFilterInvalidFile = z12;
        return this;
    }
}
