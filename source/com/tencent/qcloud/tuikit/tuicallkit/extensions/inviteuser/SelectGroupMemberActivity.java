package com.tencent.qcloud.tuikit.tuicallkit.extensions.inviteuser;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMGroupMemberFullInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfoResult;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.base.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectGroupMemberActivity extends AppCompatActivity {
    private static AppCompatActivity mActivity;
    /* access modifiers changed from: private */
    public SelectGroupMemberAdapter mAdapter;
    /* access modifiers changed from: private */
    public List<String> mAlreadySelectList = new ArrayList();
    private String mGroupId;
    /* access modifiers changed from: private */
    public List<GroupMemberInfo> mGroupMemberList = new ArrayList();
    private RecyclerView mRecyclerUserList;

    public static void finishActivity() {
        AppCompatActivity appCompatActivity = mActivity;
        if (appCompatActivity != null && !appCompatActivity.isFinishing()) {
            mActivity.finish();
            mActivity = null;
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.mGroupId = intent.getStringExtra("groupId");
        this.mAlreadySelectList = new ArrayList(intent.getStringArrayListExtra(Constants.SELECT_MEMBER_LIST));
        this.mAdapter = new SelectGroupMemberAdapter();
        this.mRecyclerUserList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.mRecyclerUserList.setAdapter(this.mAdapter);
        updateGroupUserList();
    }

    private void initStatusBar() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(9216);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } else if (i11 >= 19) {
            getWindow().addFlags(67108864);
        }
    }

    private void initView() {
        ((Toolbar) findViewById(R.id.toolbar_group)).setNavigationOnClickListener(new a(this));
        ((Button) findViewById(R.id.btn_group_ok)).setOnClickListener(new b(this));
        this.mRecyclerUserList = (RecyclerView) findViewById(R.id.rv_user_list);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$1(View view) {
        if (this.mAdapter != null) {
            ArrayList arrayList = new ArrayList();
            for (GroupMemberInfo next : this.mGroupMemberList) {
                if (next != null && !TextUtils.isEmpty(next.userId) && next.isSelected) {
                    arrayList.add(next.userId);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(Constants.SELECT_MEMBER_LIST, arrayList);
            TUICore.notifyEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_GROUP_MEMBER_SELECTED, hashMap);
        }
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void updateGroupUserList() {
        V2TIMManager.getGroupManager().getGroupMemberList(this.mGroupId, 0, 0, new V2TIMValueCallback<V2TIMGroupMemberInfoResult>() {
            public void onError(int i11, String str) {
            }

            public void onSuccess(V2TIMGroupMemberInfoResult v2TIMGroupMemberInfoResult) {
                List<V2TIMGroupMemberFullInfo> memberInfoList = v2TIMGroupMemberInfoResult.getMemberInfoList();
                SelectGroupMemberActivity.this.mGroupMemberList.clear();
                for (V2TIMGroupMemberFullInfo next : memberInfoList) {
                    GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                    groupMemberInfo.userId = next.getUserID();
                    groupMemberInfo.avatar = next.getFaceUrl();
                    groupMemberInfo.userName = next.getNickName();
                    groupMemberInfo.isSelected = SelectGroupMemberActivity.this.mAlreadySelectList.contains(groupMemberInfo.userId);
                    SelectGroupMemberActivity.this.mGroupMemberList.add(groupMemberInfo);
                }
                if (SelectGroupMemberActivity.this.mAdapter != null) {
                    SelectGroupMemberActivity.this.mAdapter.setDataSource(SelectGroupMemberActivity.this.mGroupMemberList);
                    SelectGroupMemberActivity.this.mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tuicallkit_activity_group_user);
        mActivity = this;
        initStatusBar();
        initView();
        initData();
    }
}
