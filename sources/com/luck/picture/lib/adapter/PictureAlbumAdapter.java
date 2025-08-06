package com.luck.picture.lib.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnAlbumItemClickListener;
import com.luck.picture.lib.style.AlbumWindowStyle;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;

public class PictureAlbumAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<LocalMediaFolder> albumList;
    /* access modifiers changed from: private */
    public OnAlbumItemClickListener onAlbumItemClickListener;
    /* access modifiers changed from: private */
    public final SelectorConfig selectorConfig;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivFirstImage;
        public TextView tvFolderName;
        public TextView tvSelectTag;

        public ViewHolder(View view) {
            super(view);
            this.ivFirstImage = (ImageView) view.findViewById(R.id.first_image);
            this.tvFolderName = (TextView) view.findViewById(R.id.tv_folder_name);
            this.tvSelectTag = (TextView) view.findViewById(R.id.tv_select_tag);
            AlbumWindowStyle albumWindowStyle = PictureAlbumAdapter.this.selectorConfig.selectorStyle.getAlbumWindowStyle();
            int albumAdapterItemBackground = albumWindowStyle.getAlbumAdapterItemBackground();
            if (albumAdapterItemBackground != 0) {
                view.setBackgroundResource(albumAdapterItemBackground);
            }
            int albumAdapterItemSelectStyle = albumWindowStyle.getAlbumAdapterItemSelectStyle();
            if (albumAdapterItemSelectStyle != 0) {
                this.tvSelectTag.setBackgroundResource(albumAdapterItemSelectStyle);
            }
            int albumAdapterItemTitleColor = albumWindowStyle.getAlbumAdapterItemTitleColor();
            if (albumAdapterItemTitleColor != 0) {
                this.tvFolderName.setTextColor(albumAdapterItemTitleColor);
            }
            int albumAdapterItemTitleSize = albumWindowStyle.getAlbumAdapterItemTitleSize();
            if (albumAdapterItemTitleSize > 0) {
                this.tvFolderName.setTextSize((float) albumAdapterItemTitleSize);
            }
        }
    }

    public PictureAlbumAdapter(SelectorConfig selectorConfig2) {
        this.selectorConfig = selectorConfig2;
    }

    public void bindAlbumData(List<LocalMediaFolder> list) {
        this.albumList = new ArrayList(list);
    }

    public List<LocalMediaFolder> getAlbumList() {
        List<LocalMediaFolder> list = this.albumList;
        return list != null ? list : new ArrayList();
    }

    public int getItemCount() {
        return this.albumList.size();
    }

    public void setOnIBridgeAlbumWidget(OnAlbumItemClickListener onAlbumItemClickListener2) {
        this.onAlbumItemClickListener = onAlbumItemClickListener2;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void onBindViewHolder(ViewHolder viewHolder, final int i11) {
        final LocalMediaFolder localMediaFolder = this.albumList.get(i11);
        String folderName = localMediaFolder.getFolderName();
        int folderTotalNum = localMediaFolder.getFolderTotalNum();
        String firstImagePath = localMediaFolder.getFirstImagePath();
        viewHolder.tvSelectTag.setVisibility(localMediaFolder.isSelectTag() ? 0 : 4);
        LocalMediaFolder localMediaFolder2 = this.selectorConfig.currentLocalMediaFolder;
        viewHolder.itemView.setSelected(localMediaFolder2 != null && localMediaFolder.getBucketId() == localMediaFolder2.getBucketId());
        if (PictureMimeType.isHasAudio(localMediaFolder.getFirstMimeType())) {
            viewHolder.ivFirstImage.setImageResource(R.drawable.ps_audio_placeholder);
        } else {
            ImageEngine imageEngine = this.selectorConfig.imageEngine;
            if (imageEngine != null) {
                imageEngine.loadAlbumCover(viewHolder.itemView.getContext(), firstImagePath, viewHolder.ivFirstImage);
            }
        }
        viewHolder.tvFolderName.setText(viewHolder.itemView.getContext().getString(R.string.ps_camera_roll_num, new Object[]{folderName, Integer.valueOf(folderTotalNum)}));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (PictureAlbumAdapter.this.onAlbumItemClickListener == null) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                PictureAlbumAdapter.this.onAlbumItemClickListener.onItemClick(i11, localMediaFolder);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        int layoutResource = InjectResourceSource.getLayoutResource(viewGroup.getContext(), 6, this.selectorConfig);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (layoutResource == 0) {
            layoutResource = R.layout.ps_album_folder_item;
        }
        return new ViewHolder(from.inflate(layoutResource, viewGroup, false));
    }
}
