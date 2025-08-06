package com.tencent.qcloud.tuikit.tuicallkit.extensions.inviteuser;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.utils.ImageLoader;
import java.util.ArrayList;
import java.util.List;

public class SelectGroupMemberAdapter extends RecyclerView.Adapter<GroupMemberViewHolder> {
    /* access modifiers changed from: private */
    public Context mContext;
    private List<GroupMemberInfo> mGroupMemberList = new ArrayList();

    public class GroupMemberViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public CheckBox mCheckBox;
        private ImageView mImageAvatar;
        private TextView mTextHint;
        private TextView mTextName;

        public GroupMemberViewHolder(View view) {
            super(view);
            this.mCheckBox = (CheckBox) view.findViewById(R.id.group_user_check_box);
            this.mImageAvatar = (ImageView) view.findViewById(R.id.group_user_avatar);
            this.mTextName = (TextView) view.findViewById(R.id.group_user_name);
            this.mTextHint = (TextView) view.findViewById(R.id.group_user_hint);
        }

        public void layoutView(GroupMemberInfo groupMemberInfo) {
            if (groupMemberInfo != null && !TextUtils.isEmpty(groupMemberInfo.userId)) {
                this.itemView.setEnabled(!groupMemberInfo.isSelected);
                this.mCheckBox.setEnabled(!groupMemberInfo.isSelected);
                this.mCheckBox.setChecked(groupMemberInfo.isSelected);
                this.mCheckBox.setSelected(groupMemberInfo.isSelected);
                this.mTextName.setText(TextUtils.isEmpty(groupMemberInfo.userName) ? groupMemberInfo.userId : groupMemberInfo.userName);
                this.mTextHint.setVisibility(groupMemberInfo.userId.equals(TUILogin.getLoginUser()) ? 0 : 8);
                ImageLoader.loadImage(SelectGroupMemberAdapter.this.mContext, this.mImageAvatar, groupMemberInfo.avatar, R.drawable.tuicalling_ic_avatar);
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$onBindViewHolder$0(GroupMemberViewHolder groupMemberViewHolder, GroupMemberInfo groupMemberInfo, View view) {
        groupMemberViewHolder.mCheckBox.setChecked(!groupMemberViewHolder.mCheckBox.isChecked());
        groupMemberInfo.isSelected = groupMemberViewHolder.mCheckBox.isChecked();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getItemCount() {
        return this.mGroupMemberList.size();
    }

    public void setDataSource(List<GroupMemberInfo> list) {
        this.mGroupMemberList = list;
    }

    public void onBindViewHolder(GroupMemberViewHolder groupMemberViewHolder, int i11) {
        GroupMemberInfo groupMemberInfo = this.mGroupMemberList.get(i11);
        groupMemberViewHolder.itemView.setOnClickListener(new c(groupMemberViewHolder, groupMemberInfo));
        groupMemberViewHolder.layoutView(groupMemberInfo);
    }

    public GroupMemberViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        Context context = viewGroup.getContext();
        this.mContext = context;
        return new GroupMemberViewHolder(LayoutInflater.from(context).inflate(R.layout.tuicallkit_group_user_list_item, viewGroup, false));
    }
}
