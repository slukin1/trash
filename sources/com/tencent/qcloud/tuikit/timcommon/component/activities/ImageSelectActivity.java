package com.tencent.qcloud.tuikit.timcommon.component.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c4.g;
import com.bumptech.glide.a;
import com.bumptech.glide.c;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.e;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.gatherimage.SynthesizedImageView;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;
import java.io.File;
import java.io.Serializable;
import java.util.List;

public class ImageSelectActivity extends BaseLightActivity {
    public static final String DATA = "data";
    public static final String ITEM_HEIGHT = "itemHeight";
    public static final String ITEM_WIDTH = "itemWidth";
    public static final String NEED_DOWLOAD_LOCAL = "needdowmload";
    public static final String PLACEHOLDER = "placeholder";
    public static final int RESULT_CODE_ERROR = -1;
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final String SELECTED = "selected";
    public static final String SPAN_COUNT = "spanCount";
    /* access modifiers changed from: private */
    public static final String TAG = "ImageSelectActivity";
    public static final String TITLE = "title";
    private int columnNum;
    private List<ImageBean> data;
    private int defaultSpacing;
    private ImageGridAdapter gridAdapter;
    private GridLayoutManager gridLayoutManager;
    private RecyclerView imageGrid;
    private int itemHeight;
    private int itemWidth;
    private int placeHolder;
    /* access modifiers changed from: private */
    public ImageBean selected;
    private TitleBarLayout titleBarLayout;

    public static class GridDecoration extends RecyclerView.ItemDecoration {
        private final int columnNum;
        private final int leftRightSpace;
        private final int topBottomSpace;

        public GridDecoration(int i11, int i12, int i13) {
            this.columnNum = i11;
            this.leftRightSpace = i12;
            this.topBottomSpace = i13;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i11 = this.columnNum;
            int i12 = childAdapterPosition % i11;
            int i13 = this.leftRightSpace;
            rect.left = (i12 * i13) / i11;
            rect.right = (i13 * ((i11 - 1) - i12)) / i11;
            if (childAdapterPosition >= i11) {
                rect.top = this.topBottomSpace;
            }
        }
    }

    public static class ImageGridAdapter extends RecyclerView.Adapter<ImageViewHolder> {
        private List<ImageBean> data;
        private int itemHeight;
        private int itemWidth;
        /* access modifiers changed from: private */
        public OnItemClickListener onItemClickListener;
        private int placeHolder;
        private ImageBean selected;

        public static class ImageViewHolder extends RecyclerView.ViewHolder {
            /* access modifiers changed from: private */
            public final Button defaultLayout;
            /* access modifiers changed from: private */
            public final ImageView imageView;
            /* access modifiers changed from: private */
            public final RelativeLayout selectBorderLayout;
            /* access modifiers changed from: private */
            public final ImageView selectedBorder;

            public ImageViewHolder(View view) {
                super(view);
                this.imageView = (ImageView) view.findViewById(R.id.content_image);
                this.selectedBorder = (ImageView) view.findViewById(R.id.select_border);
                this.selectBorderLayout = (RelativeLayout) view.findViewById(R.id.selected_border_area);
                this.defaultLayout = (Button) view.findViewById(R.id.default_image_layout);
            }
        }

        private void setItemLayoutParams(ImageViewHolder imageViewHolder) {
            if (this.itemHeight > 0 && this.itemWidth > 0) {
                ViewGroup.LayoutParams layoutParams = imageViewHolder.imageView.getLayoutParams();
                layoutParams.width = this.itemWidth;
                layoutParams.height = this.itemHeight;
                imageViewHolder.imageView.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = imageViewHolder.selectBorderLayout.getLayoutParams();
                layoutParams2.width = this.itemWidth;
                layoutParams2.height = this.itemHeight;
                imageViewHolder.selectBorderLayout.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = imageViewHolder.selectedBorder.getLayoutParams();
                layoutParams3.width = this.itemWidth;
                layoutParams3.height = this.itemHeight;
                imageViewHolder.selectedBorder.setLayoutParams(layoutParams3);
            }
        }

        public int getItemCount() {
            List<ImageBean> list = this.data;
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return this.data.size();
        }

        public void setData(List<ImageBean> list) {
            this.data = list;
        }

        public void setItemHeight(int i11) {
            this.itemHeight = i11;
        }

        public void setItemWidth(int i11) {
            this.itemWidth = i11;
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener2) {
            this.onItemClickListener = onItemClickListener2;
        }

        public void setPlaceHolder(int i11) {
            this.placeHolder = i11;
        }

        public void setSelected(ImageBean imageBean) {
            List<ImageBean> list = this.data;
            if (list == null || list.isEmpty()) {
                this.selected = imageBean;
                return;
            }
            this.selected = imageBean;
            notifyDataSetChanged();
        }

        public void onBindViewHolder(ImageViewHolder imageViewHolder, int i11) {
            ImageView access$500 = imageViewHolder.imageView;
            setItemLayoutParams(imageViewHolder);
            final ImageBean imageBean = this.data.get(i11);
            ImageBean imageBean2 = this.selected;
            if (imageBean2 == null || imageBean == null || !TextUtils.equals(imageBean2.getThumbnailUri(), imageBean.getThumbnailUri())) {
                imageViewHolder.selectBorderLayout.setVisibility(8);
            } else {
                imageViewHolder.selectBorderLayout.setVisibility(0);
            }
            if (imageBean.getGroupGridAvatar() != null) {
                imageViewHolder.defaultLayout.setVisibility(8);
                if (access$500 instanceof SynthesizedImageView) {
                    SynthesizedImageView synthesizedImageView = (SynthesizedImageView) access$500;
                    String imageId = imageBean.getImageId();
                    synthesizedImageView.setImageId(imageId);
                    synthesizedImageView.displayImage(imageBean.getGroupGridAvatar()).load(imageId);
                }
            } else if (imageBean.isDefault()) {
                imageViewHolder.defaultLayout.setVisibility(0);
                access$500.setImageResource(17170445);
            } else {
                imageViewHolder.defaultLayout.setVisibility(8);
                ((c) a.v(imageViewHolder.itemView.getContext()).b().M0(imageBean.getThumbnailUri()).a0(this.placeHolder)).b(new RequestOptions().l(this.placeHolder)).D0(access$500);
            }
            imageViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (ImageGridAdapter.this.onItemClickListener != null) {
                        ImageGridAdapter.this.onItemClickListener.onClick(imageBean);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }

        public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new ImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.core_select_image_item_layout, viewGroup, false));
        }
    }

    public interface OnItemClickListener {
        void onClick(ImageBean imageBean);
    }

    /* access modifiers changed from: private */
    public void DownloadUrl() {
        ImageBean imageBean = this.selected;
        if (imageBean != null) {
            if (imageBean.isDefault()) {
                this.selected.setLocalPath(TUIConstants.TUIChat.CHAT_CONVERSATION_BACKGROUND_DEFAULT_URL);
                setResult(this.selected);
                ToastUtil.toastShortMessage(getResources().getString(R.string.setting_success));
                finish();
                return;
            }
            String imageUri = this.selected.getImageUri();
            if (TextUtils.isEmpty(imageUri)) {
                Log.d(TAG, "DownloadUrl is null");
                return;
            }
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(0);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    ImageSelectActivity.this.finish();
                }
            });
            progressDialog.setMessage(getResources().getString(R.string.setting));
            progressDialog.show();
            final ImageBean imageBean2 = this.selected;
            a.y(this).h().M0(imageUri).G0(new e<File>() {
                public boolean onLoadFailed(GlideException glideException, Object obj, g<File> gVar, boolean z11) {
                    progressDialog.cancel();
                    String access$300 = ImageSelectActivity.TAG;
                    Log.e(access$300, "DownloadUrl onLoadFailed e = " + glideException);
                    ToastUtil.toastShortMessage(ImageSelectActivity.this.getResources().getString(R.string.setting_fail));
                    return false;
                }

                public boolean onResourceReady(File file, Object obj, g<File> gVar, DataSource dataSource, boolean z11) {
                    progressDialog.cancel();
                    String absolutePath = file.getAbsolutePath();
                    String access$300 = ImageSelectActivity.TAG;
                    Log.e(access$300, "DownloadUrl resource path = " + absolutePath);
                    imageBean2.setLocalPath(absolutePath);
                    ImageSelectActivity.this.setResult(imageBean2);
                    ToastUtil.toastShortMessage(ImageSelectActivity.this.getResources().getString(R.string.setting_success));
                    return false;
                }
            }).P0();
        }
    }

    /* access modifiers changed from: private */
    public void setResult(ImageBean imageBean) {
        Intent intent = new Intent();
        intent.putExtra("data", imageBean);
        setResult(0, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public void setSelectedStatus() {
        List<ImageBean> list;
        ImageBean imageBean = this.selected;
        if (imageBean == null || (list = this.data) == null || !list.contains(imageBean)) {
            this.titleBarLayout.getRightTitle().setEnabled(false);
            this.titleBarLayout.getRightTitle().setTextColor(-10066330);
        } else {
            this.titleBarLayout.getRightTitle().setEnabled(true);
            this.titleBarLayout.getRightTitle().setTextColor(getResources().getColor(TUIThemeManager.getAttrResId(this, com.tencent.qcloud.tuicore.R.attr.core_primary_color)));
        }
        this.gridAdapter.setSelected(this.selected);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.defaultSpacing = ScreenUtil.dip2px(12.0f);
        setContentView(R.layout.core_activity_image_select_layout);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("title");
        final boolean booleanExtra = intent.getBooleanExtra("needdowmload", false);
        TitleBarLayout titleBarLayout2 = (TitleBarLayout) findViewById(R.id.image_select_title);
        this.titleBarLayout = titleBarLayout2;
        titleBarLayout2.setTitle(stringExtra, ITitleBarLayout.Position.MIDDLE);
        this.titleBarLayout.setTitle(getString(com.tencent.qcloud.tuicore.R.string.sure), ITitleBarLayout.Position.RIGHT);
        this.titleBarLayout.getRightIcon().setVisibility(8);
        this.titleBarLayout.getRightTitle().setTextColor(-16748801);
        this.titleBarLayout.setOnLeftClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ImageSelectActivity.this.setResult(-1);
                ImageSelectActivity.this.finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.titleBarLayout.setOnRightClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (ImageSelectActivity.this.selected == null) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                if (booleanExtra) {
                    ImageSelectActivity.this.DownloadUrl();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("data", ImageSelectActivity.this.selected);
                    ImageSelectActivity.this.setResult(0, intent);
                    ImageSelectActivity.this.finish();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.data = (List) intent.getSerializableExtra("data");
        this.selected = (ImageBean) intent.getSerializableExtra("selected");
        this.placeHolder = intent.getIntExtra("placeholder", 0);
        this.itemHeight = intent.getIntExtra("itemHeight", 0);
        this.itemWidth = intent.getIntExtra("itemWidth", 0);
        int intExtra = intent.getIntExtra("spanCount", 2);
        this.columnNum = intExtra;
        this.gridLayoutManager = new GridLayoutManager(this, intExtra);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.image_select_grid);
        this.imageGrid = recyclerView;
        int i11 = this.columnNum;
        int i12 = this.defaultSpacing;
        recyclerView.addItemDecoration(new GridDecoration(i11, i12, i12));
        this.imageGrid.setLayoutManager(this.gridLayoutManager);
        this.imageGrid.setItemAnimator((RecyclerView.ItemAnimator) null);
        ImageGridAdapter imageGridAdapter = new ImageGridAdapter();
        this.gridAdapter = imageGridAdapter;
        imageGridAdapter.setPlaceHolder(this.placeHolder);
        this.gridAdapter.setSelected(this.selected);
        this.gridAdapter.setOnItemClickListener(new OnItemClickListener() {
            public void onClick(ImageBean imageBean) {
                ImageBean unused = ImageSelectActivity.this.selected = imageBean;
                ImageSelectActivity.this.setSelectedStatus();
            }
        });
        this.gridAdapter.setItemWidth(this.itemWidth);
        this.gridAdapter.setItemHeight(this.itemHeight);
        this.imageGrid.setAdapter(this.gridAdapter);
        this.gridAdapter.setData(this.data);
        setSelectedStatus();
        this.gridAdapter.notifyDataSetChanged();
    }

    public static class ImageBean implements Serializable {
        public List<Object> groupGridAvatar = null;
        public String imageId;
        public String imageUri;
        public boolean isDefault = false;
        public String localPath;
        public String thumbnailUri;

        public ImageBean() {
        }

        public List<Object> getGroupGridAvatar() {
            return this.groupGridAvatar;
        }

        public String getImageId() {
            return this.imageId;
        }

        public String getImageUri() {
            return this.imageUri;
        }

        public String getLocalPath() {
            return this.localPath;
        }

        public String getThumbnailUri() {
            return this.thumbnailUri;
        }

        public boolean isDefault() {
            return this.isDefault;
        }

        public void setDefault(boolean z11) {
            this.isDefault = z11;
        }

        public void setGroupGridAvatar(List<Object> list) {
            this.groupGridAvatar = list;
        }

        public void setImageId(String str) {
            this.imageId = str;
        }

        public void setImageUri(String str) {
            this.imageUri = str;
        }

        public void setLocalPath(String str) {
            this.localPath = str;
        }

        public void setThumbnailUri(String str) {
            this.thumbnailUri = str;
        }

        public ImageBean(String str, String str2, boolean z11) {
            this.thumbnailUri = str;
            this.imageUri = str2;
            this.isDefault = z11;
        }
    }
}
