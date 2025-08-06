package com.tencent.qcloud.tuikit.tuicallkit.extensions.recents;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.a;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallEngine;
import java.util.ArrayList;
import java.util.List;

public class RecentCallsViewModel extends a {
    private static final String TAG = "RecentCallsViewModel";
    /* access modifiers changed from: private */
    public final MutableLiveData<List<TUICallDefine.CallRecords>> mCallHistoryLiveData;
    /* access modifiers changed from: private */
    public final MutableLiveData<List<TUICallDefine.CallRecords>> mCallMissedLiveData;

    public RecentCallsViewModel(Application application) {
        super(application);
        MutableLiveData<List<TUICallDefine.CallRecords>> mutableLiveData = new MutableLiveData<>();
        this.mCallHistoryLiveData = mutableLiveData;
        MutableLiveData<List<TUICallDefine.CallRecords>> mutableLiveData2 = new MutableLiveData<>();
        this.mCallMissedLiveData = mutableLiveData2;
        mutableLiveData.setValue(new ArrayList());
        mutableLiveData2.setValue(new ArrayList());
    }

    public void deleteRecordCalls(List<TUICallDefine.CallRecords> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.mCallMissedLiveData.getValue());
            arrayList.removeAll(list);
            this.mCallMissedLiveData.setValue(arrayList);
            ArrayList arrayList2 = new ArrayList(this.mCallHistoryLiveData.getValue());
            arrayList2.removeAll(list);
            this.mCallHistoryLiveData.setValue(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            for (TUICallDefine.CallRecords next : list) {
                if (next != null && !TextUtils.isEmpty(next.callId)) {
                    arrayList3.add(next.callId);
                }
            }
            TUICallEngine.createInstance(getApplication()).deleteRecordCalls(arrayList3, new TUICommonDefine.ValueCallback() {
                public void onError(int i11, String str) {
                }

                public void onSuccess(Object obj) {
                }
            });
        }
    }

    public MutableLiveData<List<TUICallDefine.CallRecords>> getCallHistoryList() {
        return this.mCallHistoryLiveData;
    }

    public MutableLiveData<List<TUICallDefine.CallRecords>> getCallMissedList() {
        return this.mCallMissedLiveData;
    }

    public void queryRecentCalls(final TUICallDefine.RecentCallsFilter recentCallsFilter) {
        TUICallEngine.createInstance(getApplication()).queryRecentCalls(recentCallsFilter, new TUICommonDefine.ValueCallback() {
            public void onError(int i11, String str) {
            }

            public void onSuccess(Object obj) {
                if (obj != null && (obj instanceof List)) {
                    List list = (List) obj;
                    TUICallDefine.RecentCallsFilter recentCallsFilter = recentCallsFilter;
                    if (recentCallsFilter == null || !TUICallDefine.CallRecords.Result.Missed.equals(recentCallsFilter.result)) {
                        List list2 = (List) RecentCallsViewModel.this.mCallHistoryLiveData.getValue();
                        if (list2 != null) {
                            list2.removeAll(list);
                            list2.addAll(list);
                        }
                        RecentCallsViewModel.this.mCallHistoryLiveData.setValue(list2);
                        return;
                    }
                    List list3 = (List) RecentCallsViewModel.this.mCallMissedLiveData.getValue();
                    if (list3 != null) {
                        list3.removeAll(list);
                        list3.addAll(list);
                    }
                    RecentCallsViewModel.this.mCallMissedLiveData.setValue(list3);
                }
            }
        });
    }
}
