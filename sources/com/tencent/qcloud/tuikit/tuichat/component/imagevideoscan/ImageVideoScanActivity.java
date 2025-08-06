package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.List;

public class ImageVideoScanActivity extends Activity {
    /* access modifiers changed from: private */
    public static final String TAG = "ImageVideoScanActivity";
    private ImageVideoScanAdapter mAdapter;
    private TUIMessageBean mCurrentMessageBean = null;
    private ImageView mDownloadView;
    private List<TUIMessageBean> mForwardDataSource = new ArrayList();
    /* access modifiers changed from: private */
    public ImageVideoScanPresenter mImageVideoScanPresenter;
    private boolean mIsForwardMode = false;
    private ViewPagerLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    public interface OnItemClickListener {
        void onClickItem();
    }

    private void initView() {
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        ImageView imageView = (ImageView) findViewById(R.id.download_button);
        this.mDownloadView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                String[] strArr;
                TUIChatLog.d(ImageVideoScanActivity.TAG, "onClick");
                if (Build.VERSION.SDK_INT >= 33) {
                    strArr = new String[]{PermissionConfig.READ_MEDIA_IMAGES};
                } else {
                    strArr = new String[]{PermissionConfig.READ_EXTERNAL_STORAGE, PermissionConfig.WRITE_EXTERNAL_STORAGE};
                }
                if (ContextCompat.checkSelfPermission(ImageVideoScanActivity.this, PermissionConfig.WRITE_EXTERNAL_STORAGE) != 0) {
                    ActivityCompat.requestPermissions(ImageVideoScanActivity.this, strArr, 1);
                }
                ImageVideoScanActivity.this.mImageVideoScanPresenter.saveLocal(ImageVideoScanActivity.this);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mLayoutManager = new ViewPagerLayoutManager(this, 0);
        this.mAdapter = new ImageVideoScanAdapter();
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
        ImageVideoScanPresenter imageVideoScanPresenter = new ImageVideoScanPresenter();
        this.mImageVideoScanPresenter = imageVideoScanPresenter;
        imageVideoScanPresenter.setAdapter(this.mAdapter);
        this.mImageVideoScanPresenter.setRecyclerView(this.mRecyclerView);
        this.mImageVideoScanPresenter.setViewPagerLayoutManager(this.mLayoutManager);
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() {
            public void onClickItem() {
                ImageVideoScanActivity.this.finish();
            }
        });
    }

    public void initData() {
        if (getIntent() != null) {
            boolean booleanExtra = getIntent().getBooleanExtra(TUIChatConstants.FORWARD_MODE, false);
            this.mIsForwardMode = booleanExtra;
            if (booleanExtra) {
                List<TUIMessageBean> list = (List) getIntent().getSerializableExtra(TUIChatConstants.OPEN_MESSAGES_SCAN_FORWARD);
                this.mForwardDataSource = list;
                if (list == null || list.isEmpty()) {
                    TUIChatLog.e(TAG, "mForwardDataSource is null");
                    return;
                }
            }
            TUIMessageBean tUIMessageBean = (TUIMessageBean) getIntent().getSerializableExtra(TUIChatConstants.OPEN_MESSAGE_SCAN);
            this.mCurrentMessageBean = tUIMessageBean;
            if (tUIMessageBean == null) {
                TUIChatLog.e(TAG, "mCurrentMessageBean is null");
            } else {
                this.mImageVideoScanPresenter.init(tUIMessageBean, this.mForwardDataSource, this.mIsForwardMode);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.image_video_scan_layout);
        initView();
        initData();
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onPause() {
        TUIChatLog.i(TAG, "onPause");
        super.onPause();
        ImageVideoScanPresenter imageVideoScanPresenter = this.mImageVideoScanPresenter;
        if (imageVideoScanPresenter != null) {
            imageVideoScanPresenter.releaseUI();
        }
    }
}
