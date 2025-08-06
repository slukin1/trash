package com.hbg.module.huobi.im.group.ui.adapter;

import android.view.View;
import com.tencent.imsdk.v2.V2TIMConversation;
import kotlin.jvm.internal.Ref$ObjectRef;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f20127b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f20128c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ V2TIMConversation f20129d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ GroupChatListMyAdapter f20130e;

    public /* synthetic */ f(Ref$ObjectRef ref$ObjectRef, int i11, V2TIMConversation v2TIMConversation, GroupChatListMyAdapter groupChatListMyAdapter) {
        this.f20127b = ref$ObjectRef;
        this.f20128c = i11;
        this.f20129d = v2TIMConversation;
        this.f20130e = groupChatListMyAdapter;
    }

    public final void onClick(View view) {
        GroupChatListMyAdapter.i(this.f20127b, this.f20128c, this.f20129d, this.f20130e, view);
    }
}
