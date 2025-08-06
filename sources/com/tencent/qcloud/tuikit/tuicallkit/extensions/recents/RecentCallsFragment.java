package com.tencent.qcloud.tuikit.tuicallkit.extensions.recents;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.TUICallKit;
import com.tencent.qcloud.tuikit.tuicallkit.extensions.recents.interfaces.ICallRecordItemListener;
import com.tencent.qcloud.tuikit.tuicallkit.view.common.SlideRecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecentCallsFragment extends Fragment {
    public static final String TYPE_ALL = "AllCall";
    public static final String TYPE_MISS = "MissedCall";
    private BottomSheetDialog mBottomSheetDialog;
    private Button mButtonClear;
    private Button mButtonEdit;
    private Button mButtonEditDone;
    private Button mButtonStartCall;
    private String mChatViewStyle = TUIConstants.TUICalling.ObjectFactory.RecentCalls.UI_STYLE_MINIMALIST;
    private TabLayout mLayoutTab;
    private ConstraintLayout mLayoutTitle;
    /* access modifiers changed from: private */
    public RecentCallsListAdapter mListAdapter;
    private SlideRecyclerView mRecyclerRecent;
    private View mRootView;
    /* access modifiers changed from: private */
    public String mType = TYPE_ALL;
    private RecentCallsViewModel mViewModel;

    public RecentCallsFragment() {
    }

    private void clearRecentCalls() {
        List<TUICallDefine.CallRecords> arrayList = new ArrayList<>();
        RecentCallsListAdapter recentCallsListAdapter = this.mListAdapter;
        if (recentCallsListAdapter != null) {
            arrayList = recentCallsListAdapter.getSelectedItem();
        }
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            for (TUICallDefine.CallRecords callRecords : arrayList) {
                if (callRecords != null && !TextUtils.isEmpty(callRecords.callId)) {
                    arrayList2.add(callRecords);
                }
            }
            RecentCallsViewModel recentCallsViewModel = this.mViewModel;
            if (recentCallsViewModel != null) {
                recentCallsViewModel.deleteRecordCalls(arrayList2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void deleteRecordCalls(List<TUICallDefine.CallRecords> list) {
        RecentCallsViewModel recentCallsViewModel = this.mViewModel;
        if (recentCallsViewModel != null) {
            recentCallsViewModel.deleteRecordCalls(list);
        }
        stopMultiSelect();
    }

    private TUICallDefine.RecentCallsFilter getFilter() {
        TUICallDefine.RecentCallsFilter recentCallsFilter = new TUICallDefine.RecentCallsFilter();
        if (TYPE_MISS.equals(this.mType)) {
            recentCallsFilter.result = TUICallDefine.CallRecords.Result.Missed;
        }
        return recentCallsFilter;
    }

    private void initData() {
        RecentCallsListAdapter recentCallsListAdapter = new RecentCallsListAdapter();
        this.mListAdapter = recentCallsListAdapter;
        recentCallsListAdapter.setHasStableIds(true);
        this.mRecyclerRecent.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mRecyclerRecent.setAdapter(this.mListAdapter);
        setAdapterListener();
        RecentCallsViewModel recentCallsViewModel = (RecentCallsViewModel) new ViewModelProvider(requireActivity()).a(RecentCallsViewModel.class);
        this.mViewModel = recentCallsViewModel;
        recentCallsViewModel.getCallHistoryList().observe(requireActivity(), new g(this));
        this.mViewModel.getCallMissedList().observe(requireActivity(), new h(this));
        RecentCallsViewModel recentCallsViewModel2 = this.mViewModel;
        if (recentCallsViewModel2 != null) {
            recentCallsViewModel2.queryRecentCalls(getFilter());
        }
    }

    private void initListener() {
        this.mButtonEdit.setOnClickListener(new a(this));
        this.mButtonStartCall.setOnClickListener(f.f48566b);
        this.mButtonEditDone.setOnClickListener(new d(this));
        this.mButtonClear.setOnClickListener(new e(this));
        this.mLayoutTab.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @SensorsDataInstrumented
            public void onTabSelected(TabLayout.Tab tab) {
                String unused = RecentCallsFragment.this.mType = tab.getPosition() == 1 ? RecentCallsFragment.TYPE_MISS : RecentCallsFragment.TYPE_ALL;
                RecentCallsFragment.this.updateTabViews(false);
                RecentCallsFragment.this.stopMultiSelect();
                RecentCallsFragment.this.refreshData();
                SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
    }

    private void initView() {
        this.mButtonEdit = (Button) this.mRootView.findViewById(R.id.btn_call_edit);
        this.mButtonStartCall = (Button) this.mRootView.findViewById(R.id.btn_start_call);
        this.mButtonEditDone = (Button) this.mRootView.findViewById(R.id.btn_edit_done);
        this.mButtonClear = (Button) this.mRootView.findViewById(R.id.btn_clear);
        this.mLayoutTab = (TabLayout) this.mRootView.findViewById(R.id.tab_layout);
        this.mRecyclerRecent = (SlideRecyclerView) this.mRootView.findViewById(R.id.recycle_view_list);
        this.mLayoutTitle = (ConstraintLayout) this.mRootView.findViewById(R.id.cl_record_title);
        if (TUIConstants.TUICalling.ObjectFactory.RecentCalls.UI_STYLE_MINIMALIST.equals(this.mChatViewStyle)) {
            this.mLayoutTitle.setBackgroundColor(getResources().getColor(R.color.tuicalling_color_white));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$0(List list) {
        if (this.mListAdapter != null && TYPE_ALL.equals(this.mType)) {
            this.mListAdapter.onDataSourceChanged(list);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$1(List list) {
        if (this.mListAdapter != null && TYPE_MISS.equals(this.mType)) {
            this.mListAdapter.onDataSourceChanged(list);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$2(View view) {
        startMultiSelect();
        updateTabViews(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$initListener$3(View view) {
        TUICore.startActivity("StartC2CChatMinimalistActivity", (Bundle) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$4(View view) {
        stopMultiSelect();
        updateTabViews(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$5(View view) {
        showDeleteHistoryDialog();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$showDeleteHistoryDialog$6(View view) {
        clearRecentCalls();
        this.mBottomSheetDialog.dismiss();
        stopMultiSelect();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$showDeleteHistoryDialog$7(View view) {
        this.mBottomSheetDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public void refreshData() {
        RecentCallsViewModel recentCallsViewModel = this.mViewModel;
        if (recentCallsViewModel != null) {
            recentCallsViewModel.queryRecentCalls(getFilter());
        }
    }

    private void setAdapterListener() {
        this.mListAdapter.setOnCallRecordItemListener(new ICallRecordItemListener() {
            public void onDetailViewClick(View view, TUICallDefine.CallRecords callRecords) {
                if (callRecords != null) {
                    if (TUICallDefine.Scene.SINGLE_CALL.equals(callRecords.scene)) {
                        RecentCallsFragment.this.startFriendProfileActivity(callRecords);
                    } else if (TUICallDefine.Scene.GROUP_CALL.equals(callRecords.scene)) {
                        RecentCallsFragment.this.startGroupInfoActivity(callRecords);
                    }
                }
            }

            public void onItemClick(View view, int i11, TUICallDefine.CallRecords callRecords) {
                if (callRecords == null || RecentCallsFragment.this.mListAdapter.isMultiSelectMode()) {
                    return;
                }
                if (callRecords.scene.equals(TUICallDefine.Scene.GROUP_CALL)) {
                    RecentCallsFragment.this.startGroupInfoActivity(callRecords);
                    Toast.makeText(RecentCallsFragment.this.getContext(), R.string.tuicallkit_group_recall_unsupport, 0).show();
                } else if (TUICallDefine.Role.Caller.equals(callRecords.role)) {
                    TUICallKit.createInstance(RecentCallsFragment.this.getContext()).call(callRecords.inviteList.get(0), callRecords.mediaType);
                } else {
                    TUICallKit.createInstance(RecentCallsFragment.this.getContext()).call(callRecords.inviter, callRecords.mediaType);
                }
            }

            public void onItemDeleteClick(View view, int i11, TUICallDefine.CallRecords callRecords) {
                if (callRecords != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(callRecords);
                    RecentCallsFragment.this.deleteRecordCalls(arrayList);
                }
            }
        });
    }

    private void showDeleteHistoryDialog() {
        if (this.mBottomSheetDialog == null) {
            this.mBottomSheetDialog = new BottomSheetDialog(getContext(), R.style.TUICallBottomSelectSheet);
        }
        this.mBottomSheetDialog.setContentView(R.layout.tuicallkit_record_dialog);
        this.mBottomSheetDialog.setCanceledOnTouchOutside(false);
        ((TextView) this.mBottomSheetDialog.findViewById(R.id.tv_clear_call_history)).setOnClickListener(new b(this));
        ((TextView) this.mBottomSheetDialog.findViewById(R.id.tv_clear_cancel)).setOnClickListener(new c(this));
        this.mBottomSheetDialog.show();
    }

    /* access modifiers changed from: private */
    public void startFriendProfileActivity(TUICallDefine.CallRecords callRecords) {
        Bundle bundle = new Bundle();
        if (TUICallDefine.Role.Caller.equals(callRecords.role)) {
            bundle.putString("chatId", callRecords.inviteList.get(0));
        } else {
            bundle.putString("chatId", callRecords.inviter);
        }
        TUICore.startActivity(TUIConstants.TUICalling.ObjectFactory.RecentCalls.UI_STYLE_MINIMALIST.equals(this.mChatViewStyle) ? "FriendProfileMinimalistActivity" : "FriendProfileActivity", bundle);
    }

    /* access modifiers changed from: private */
    public void startGroupInfoActivity(TUICallDefine.CallRecords callRecords) {
        Bundle bundle = new Bundle();
        bundle.putString("group_id", callRecords.groupId);
        TUICore.startActivity(getContext(), TUIConstants.TUICalling.ObjectFactory.RecentCalls.UI_STYLE_MINIMALIST.equals(this.mChatViewStyle) ? "GroupInfoMinimalistActivity" : "GroupInfoActivity", bundle);
    }

    private void startMultiSelect() {
        RecentCallsListAdapter recentCallsListAdapter = (RecentCallsListAdapter) this.mRecyclerRecent.getAdapter();
        if (recentCallsListAdapter != null) {
            recentCallsListAdapter.setShowMultiSelectCheckBox(true);
            recentCallsListAdapter.notifyDataSetChanged();
        }
        this.mRecyclerRecent.disableRecyclerViewSlide(true);
        this.mRecyclerRecent.closeMenu();
    }

    /* access modifiers changed from: private */
    public void stopMultiSelect() {
        RecentCallsListAdapter recentCallsListAdapter = (RecentCallsListAdapter) this.mRecyclerRecent.getAdapter();
        if (recentCallsListAdapter != null) {
            recentCallsListAdapter.setShowMultiSelectCheckBox(false);
            recentCallsListAdapter.notifyDataSetChanged();
        }
        this.mRecyclerRecent.disableRecyclerViewSlide(false);
        this.mRecyclerRecent.closeMenu();
    }

    /* access modifiers changed from: private */
    public void updateTabViews(boolean z11) {
        if (z11) {
            this.mButtonEdit.setVisibility(8);
            this.mButtonStartCall.setVisibility(8);
            this.mButtonEditDone.setVisibility(0);
            this.mButtonClear.setVisibility(0);
            return;
        }
        this.mButtonEdit.setVisibility(0);
        this.mButtonStartCall.setVisibility(8);
        this.mButtonEditDone.setVisibility(8);
        this.mButtonClear.setVisibility(8);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.tuicallkit_record_fragment_main, viewGroup, false);
        initView();
        initData();
        initListener();
        return this.mRootView;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        RecentCallsViewModel recentCallsViewModel = this.mViewModel;
        if (recentCallsViewModel != null) {
            recentCallsViewModel.queryRecentCalls(getFilter());
        }
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public RecentCallsFragment(String str) {
        this.mChatViewStyle = str;
    }
}
