package com.tencent.qcloud.tuikit.tuibarrage.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.common.IMLog;
import com.tencent.qcloud.tuikit.tuibarrage.R;
import com.tencent.qcloud.tuikit.tuibarrage.core.BarrageConst;
import com.tencent.qcloud.tuikit.tuibarrage.manager.HbBarrageManager;
import com.tencent.qcloud.tuikit.tuibarrage.manager.IHbBarrageManager;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageModel;
import com.tencent.qcloud.tuikit.tuibarrage.view.adapter.TUIBarrageMsgEntity;
import com.tencent.qcloud.tuikit.tuibarrage.view.adapter.TUIBarrageMsgListAdapter;
import java.util.ArrayList;

public class TUIBarrageDisplayView extends FrameLayout implements ITUIBarrageDisplayView {
    private static final String TAG = "TUIBarrageDisplayView";
    /* access modifiers changed from: private */
    public TUIBarrageMsgListAdapter mAdapter;
    private String mGroupId;
    private IHbBarrageManager mManager;
    private ArrayList<TUIBarrageMsgEntity> mMsgList;
    /* access modifiers changed from: private */
    public int mNewMsgCount;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerMsg;
    /* access modifiers changed from: private */
    public TextView tvNewCount;

    public TUIBarrageDisplayView(Context context) {
        super(context);
        this.mNewMsgCount = 0;
    }

    private void initPresenter() {
        HbBarrageManager instance = HbBarrageManager.getInstance();
        this.mManager = instance;
        instance.init(this.mGroupId);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tuibarrage_view_display, this);
        this.mRecyclerMsg = (RecyclerView) findViewById(R.id.rv_msg);
        ArrayList<TUIBarrageMsgEntity> arrayList = new ArrayList<>();
        this.mMsgList = arrayList;
        this.mAdapter = new TUIBarrageMsgListAdapter(context, arrayList, (TUIBarrageMsgListAdapter.OnItemClickListener) null);
        this.mRecyclerMsg.setLayoutManager(new LinearLayoutManager(context));
        h hVar = new h(context, 1);
        hVar.setDrawable(getResources().getDrawable(R.drawable.tuibarrage_item_decoration));
        this.mRecyclerMsg.addItemDecoration(hVar);
        this.mRecyclerMsg.setAdapter(this.mAdapter);
        this.mMsgList.clear();
        TUIBarrageMsgEntity tUIBarrageMsgEntity = new TUIBarrageMsgEntity();
        tUIBarrageMsgEntity.userName = context.getResources().getString(R.string.n_live_message_alert_title);
        tUIBarrageMsgEntity.content = "";
        this.mMsgList.add(tUIBarrageMsgEntity);
        this.mAdapter.notifyDataSetChanged();
        TextView textView = (TextView) findViewById(R.id.tv_new_msg_tips);
        this.tvNewCount = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUIBarrageDisplayView.this.mRecyclerMsg.smoothScrollToPosition(TUIBarrageDisplayView.this.mAdapter.getItemCount());
                TUIBarrageDisplayView.this.tvNewCount.setVisibility(8);
                int unused = TUIBarrageDisplayView.this.mNewMsgCount = 0;
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mRecyclerMsg.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
                super.onScrollStateChanged(recyclerView, i11);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) TUIBarrageDisplayView.this.mRecyclerMsg.getLayoutManager();
                if (i11 == 0 && linearLayoutManager.findLastCompletelyVisibleItemPosition() == TUIBarrageDisplayView.this.mAdapter.getItemCount() - 1) {
                    TUIBarrageDisplayView.this.tvNewCount.setVisibility(8);
                    int unused = TUIBarrageDisplayView.this.mNewMsgCount = 0;
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                super.onScrolled(recyclerView, i11, i12);
            }
        });
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            RecyclerView recyclerView = this.mRecyclerMsg;
            if (recyclerView != null) {
                recyclerView.smoothScrollToPosition(this.mAdapter.getItemCount());
            }
        } catch (Exception e11) {
            IMLog.e("TUIBarrageDisplayView", e11.getMessage());
        }
    }

    @SuppressLint({"StringFormatMatches"})
    public void receiveBarrage(TUIBarrageMessage tUIBarrageMessage) {
        if (tUIBarrageMessage == null) {
            Log.d("TUIBarrageDisplayView", "receiveBarrage model is empty");
            return;
        }
        Log.d("TUIBarrageDisplayView", "barrageDis hashcode = " + hashCode());
        Log.d("TUIBarrageDisplayView", "receiveBarrage message = " + tUIBarrageMessage);
        if (tUIBarrageMessage.message.length() == 0) {
            Log.d("TUIBarrageDisplayView", "receiveBarrage message is empty");
            return;
        }
        TUIBarrageMsgEntity tUIBarrageMsgEntity = new TUIBarrageMsgEntity();
        String str = tUIBarrageMessage.sender;
        tUIBarrageMsgEntity.userId = str;
        tUIBarrageMsgEntity.userName = str;
        tUIBarrageMsgEntity.content = tUIBarrageMessage.message;
        TUIBarrageModel tUIBarrageModel = new TUIBarrageModel();
        tUIBarrageModel.msgId = tUIBarrageMessage.v2TIMMessage.getMsgID();
        tUIBarrageModel.timestamp = tUIBarrageMessage.v2TIMMessage.getTimestamp();
        tUIBarrageModel.groupId = tUIBarrageMessage.v2TIMMessage.getGroupID();
        tUIBarrageModel.isSelf = tUIBarrageMessage.v2TIMMessage.isSelf();
        tUIBarrageModel.sender = tUIBarrageMessage.v2TIMMessage.getSender();
        tUIBarrageModel.msgSeq = tUIBarrageMessage.v2TIMMessage.getSeq();
        tUIBarrageModel.nickName = tUIBarrageMessage.v2TIMMessage.getNickName();
        tUIBarrageModel.faceUrl = tUIBarrageMessage.v2TIMMessage.getFaceUrl();
        tUIBarrageModel.status = tUIBarrageMessage.v2TIMMessage.getStatus();
        tUIBarrageModel.message = tUIBarrageMessage.message;
        tUIBarrageMsgEntity.model = tUIBarrageModel;
        this.mMsgList.add(tUIBarrageMsgEntity);
        this.mAdapter.notifyDataSetChanged();
        if (tUIBarrageMessage.sendTime < BarrageConst.joinGroupTime) {
            this.tvNewCount.setVisibility(8);
            this.mNewMsgCount = 0;
            this.mRecyclerMsg.smoothScrollToPosition(this.mAdapter.getItemCount());
        } else if (((LinearLayoutManager) this.mRecyclerMsg.getLayoutManager()).findLastVisibleItemPosition() == this.mAdapter.getItemCount() - 2) {
            this.tvNewCount.setVisibility(8);
            this.mNewMsgCount = 0;
            this.mRecyclerMsg.smoothScrollToPosition(this.mAdapter.getItemCount());
        } else {
            this.tvNewCount.setVisibility(0);
            this.mNewMsgCount++;
            this.tvNewCount.setText(String.format(getContext().getString(R.string.n_im_new_msg_tips), new Object[]{Integer.valueOf(this.mNewMsgCount)}));
        }
    }

    public TUIBarrageDisplayView(Context context, String str) {
        this(context);
        this.mGroupId = str;
        initView(context);
        initPresenter();
    }
}
