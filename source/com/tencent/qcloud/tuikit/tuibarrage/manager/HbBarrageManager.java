package com.tencent.qcloud.tuikit.tuibarrage.manager;

import android.util.Log;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageIMService;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HbBarrageManager implements IHbBarrageManager {
    /* access modifiers changed from: private */
    public static final String TAG = "HbBarrageManager";
    private static HbBarrageManager sInstance;
    private List<WeakReference<TUIBarrageCallBack>> barrageCallbacks = new ArrayList();
    public String mGroupId;
    private TUIBarrageIMService mImService;

    public static HbBarrageManager getInstance() {
        if (sInstance == null) {
            sInstance = new HbBarrageManager();
        }
        return sInstance;
    }

    private void initIMService() {
        if (this.mImService == null) {
            this.mImService = new TUIBarrageIMService(this);
        }
        this.mImService.setGroupId(this.mGroupId);
    }

    public void addBarrageCallBack(TUIBarrageCallBack tUIBarrageCallBack) {
        this.barrageCallbacks.add(new WeakReference(tUIBarrageCallBack));
    }

    public void init(String str) {
        this.mGroupId = str;
        initIMService();
    }

    public void receiveCustomBarrage(TUIBarrageMessage tUIBarrageMessage) {
        if (tUIBarrageMessage == null) {
            Log.d(TAG, "receiveCustomBarrage groupId or barrage is empty");
            return;
        }
        String str = TAG;
        Log.d(str, "receiveCustomBarrage" + tUIBarrageMessage);
        Iterator<WeakReference<TUIBarrageCallBack>> it2 = this.barrageCallbacks.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            if (next == null || next.get() == null) {
                Log.d(TAG, "receiveCustomBarrage移除BarragePresenter的Listener");
                it2.remove();
            } else {
                ((TUIBarrageCallBack) next.get()).onCustomCallback(0, tUIBarrageMessage);
            }
        }
    }

    public void receiveTextBarrage(TUIBarrageMessage tUIBarrageMessage) {
        if (tUIBarrageMessage == null) {
            Log.d(TAG, "receiveTextBarrage groupId or barrage is empty");
            return;
        }
        Iterator<WeakReference<TUIBarrageCallBack>> it2 = this.barrageCallbacks.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            if (next == null || next.get() == null) {
                Log.d(TAG, "receiveCustomBarrage移除BarragePresenter的Listener");
                it2.remove();
            } else {
                ((TUIBarrageCallBack) next.get()).onTextCallback(0, tUIBarrageMessage);
            }
        }
    }

    public void sendCustomBarrage(TUIBarrageMessage tUIBarrageMessage, final TUIBarrageCallBack tUIBarrageCallBack) {
        if (tUIBarrageMessage == null) {
            Log.d(TAG, "sendBarrage data is empty");
            return;
        }
        String str = TAG;
        Log.d(str, "sendBarrage: data = " + tUIBarrageMessage + " , mGroupId = " + this.mGroupId);
        this.mImService.sendCustomBarrage(tUIBarrageMessage, new TUIBarrageCallBack() {
            public void onCustomCallback(int i11, TUIBarrageMessage tUIBarrageMessage) {
                tUIBarrageCallBack.onCustomCallback(i11, tUIBarrageMessage);
            }

            public void onFailed(int i11, String str) {
                tUIBarrageCallBack.onFailed(i11, str);
            }
        });
    }

    public void sendTextBarrage(String str, final TUIBarrageCallBack tUIBarrageCallBack) {
        this.mImService.sendTextBarrage(str, new TUIBarrageCallBack() {
            public void onFailed(int i11, String str) {
                String access$000 = HbBarrageManager.TAG;
                Log.d(access$000, "sendBarrage failed errorCode = " + i11 + " , errorMsg = " + str);
                tUIBarrageCallBack.onFailed(i11, str);
            }

            public void onTextCallback(int i11, TUIBarrageMessage tUIBarrageMessage) {
                tUIBarrageCallBack.onTextCallback(i11, tUIBarrageMessage);
            }
        });
    }
}
