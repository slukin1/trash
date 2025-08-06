package com.tencent.qcloud.tuikit.tuicallkit.extensions.inviteuser;

import android.view.View;
import com.tencent.qcloud.tuikit.tuicallkit.extensions.inviteuser.SelectGroupMemberAdapter;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelectGroupMemberAdapter.GroupMemberViewHolder f48559b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroupMemberInfo f48560c;

    public /* synthetic */ c(SelectGroupMemberAdapter.GroupMemberViewHolder groupMemberViewHolder, GroupMemberInfo groupMemberInfo) {
        this.f48559b = groupMemberViewHolder;
        this.f48560c = groupMemberInfo;
    }

    public final void onClick(View view) {
        SelectGroupMemberAdapter.lambda$onBindViewHolder$0(this.f48559b, this.f48560c, view);
    }
}
