package com.tencent.qcloud.tuikit.tuicallkit.extensions.recents;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecentCallsItemHolder extends RecyclerView.ViewHolder {
    public RecordsIconView mCallIconView;
    public CheckBox mCheckBoxSelectCall;
    public ImageView mImageDetails;
    public ImageView mImageMediaType;
    public RelativeLayout mLayoutDelete;
    public ConstraintLayout mLayoutView;
    public TextView mTextCallStatus;
    public TextView mTextCallTime;
    public TextView mTextUserTitle;

    public RecentCallsItemHolder(View view) {
        super(view);
        initView();
    }

    private void initView() {
        this.mLayoutDelete = (RelativeLayout) this.itemView.findViewById(R.id.ll_call_delete);
        this.mCheckBoxSelectCall = (CheckBox) this.itemView.findViewById(R.id.cb_call_select);
        this.mCallIconView = (RecordsIconView) this.itemView.findViewById(R.id.call_icon);
        this.mTextUserTitle = (TextView) this.itemView.findViewById(R.id.tv_call_user_id);
        this.mImageMediaType = (ImageView) this.itemView.findViewById(R.id.call_media_type);
        this.mTextCallStatus = (TextView) this.itemView.findViewById(R.id.tv_call_status);
        this.mTextCallTime = (TextView) this.itemView.findViewById(R.id.tv_call_time);
        this.mImageDetails = (ImageView) this.itemView.findViewById(R.id.img_call_details);
        this.mLayoutView = (ConstraintLayout) this.itemView.findViewById(R.id.cl_info_layout);
    }

    public void layoutViews(Context context, final TUICallDefine.CallRecords callRecords, int i11) {
        if (callRecords != null) {
            this.mTextUserTitle.setTextColor(context.getResources().getColor(TUICallDefine.CallRecords.Result.Missed.equals(callRecords.result) ? R.color.tuicallkit_record_text_red : R.color.tuicalling_color_black));
            this.mImageMediaType.setImageDrawable(context.getResources().getDrawable(TUICallDefine.MediaType.Video.equals(callRecords.mediaType) ? R.drawable.tuicallkit_record_ic_video_call : R.drawable.tuicallkit_ic_audio_call));
            this.mTextCallStatus.setText(String.valueOf(callRecords.result));
            this.mTextCallTime.setText(DateTimeUtil.getTimeFormatText(new Date(callRecords.beginTime)));
            ArrayList arrayList = new ArrayList();
            List<String> list = callRecords.inviteList;
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(callRecords.inviter.trim());
            arrayList.remove(TUILogin.getLoginUser());
            this.mCallIconView.setTag(arrayList);
            V2TIMManager.getInstance().getUsersInfo(arrayList, new V2TIMValueCallback<List<V2TIMUserFullInfo>>() {
                public void onError(int i11, String str) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(TUILogin.getFaceUrl());
                    RecentCallsItemHolder.this.mCallIconView.displayImage(arrayList).load(callRecords.callId);
                    RecentCallsItemHolder.this.mTextUserTitle.setText(TUILogin.getNickName());
                }

                public void onSuccess(List<V2TIMUserFullInfo> list) {
                    if (list != null && !list.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        for (int i11 = 0; i11 < list.size(); i11++) {
                            arrayList.add(list.get(i11).getFaceUrl());
                            arrayList2.add(list.get(i11).getUserID());
                            arrayList3.add(TextUtils.isEmpty(list.get(i11).getNickName()) ? list.get(i11).getUserID() : list.get(i11).getNickName());
                        }
                        ArrayList arrayList4 = new ArrayList((List) RecentCallsItemHolder.this.mCallIconView.getTag());
                        if (arrayList4.size() == arrayList2.size() && arrayList4.containsAll(arrayList2)) {
                            RecentCallsItemHolder.this.mCallIconView.setImageId(callRecords.callId);
                            RecentCallsItemHolder.this.mCallIconView.displayImage(arrayList).load(callRecords.callId);
                            RecentCallsItemHolder.this.mTextUserTitle.setText(String.valueOf(arrayList3).replaceAll("[\\[\\]]", ""));
                        }
                    }
                }
            });
        }
    }
}
