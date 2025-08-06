package com.hbg.module.huobi.im.group.ui.adapter;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.e;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.IMConversationHelper;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.utils.DateUtils;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.huobi.framework.im.common.ImManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuikit.timcommon.component.impl.CornerTransform;
import d10.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;
import kotlin.l;

public final class GroupChatListMyAdapter extends RecyclerView.Adapter<a> implements IMConversationHelper.h {

    /* renamed from: b  reason: collision with root package name */
    public Context f20070b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<V2TIMConversation> f20071c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f20072d = new Handler(this.f20070b.getMainLooper());

    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final LinearLayout f20073a;

        /* renamed from: b  reason: collision with root package name */
        public final ImageView f20074b;

        /* renamed from: c  reason: collision with root package name */
        public final TextView f20075c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f20076d;

        /* renamed from: e  reason: collision with root package name */
        public final TextView f20077e;

        /* renamed from: f  reason: collision with root package name */
        public final TextView f20078f;

        /* renamed from: g  reason: collision with root package name */
        public final TextView f20079g;

        /* renamed from: h  reason: collision with root package name */
        public final ImageView f20080h;

        /* renamed from: i  reason: collision with root package name */
        public final ImageView f20081i;

        /* renamed from: j  reason: collision with root package name */
        public final LinearLayout f20082j;

        /* renamed from: k  reason: collision with root package name */
        public final FrameLayout f20083k;

        /* renamed from: l  reason: collision with root package name */
        public final ImageView f20084l;

        /* renamed from: m  reason: collision with root package name */
        public final TextView f20085m;

        public a(View view) {
            super(view);
            this.f20073a = (LinearLayout) view.findViewById(R$id.llChatItem);
            this.f20074b = (ImageView) view.findViewById(R$id.iv_group_chat_avatar);
            this.f20075c = (TextView) view.findViewById(R$id.tv_group_chat_title);
            this.f20076d = (TextView) view.findViewById(R$id.tvSbAt);
            this.f20077e = (TextView) view.findViewById(R$id.tv_group_last_msg);
            this.f20078f = (TextView) view.findViewById(R$id.tv_group_msg_time);
            this.f20079g = (TextView) view.findViewById(R$id.tv_group_msg_count);
            this.f20080h = (ImageView) view.findViewById(R$id.ivPin);
            this.f20081i = (ImageView) view.findViewById(R$id.iv_manager_tag);
            this.f20082j = (LinearLayout) view.findViewById(R$id.llDelChat);
            this.f20083k = (FrameLayout) view.findViewById(R$id.fl_message_count_dot_container);
            this.f20084l = (ImageView) view.findViewById(R$id.iv_no_disturb);
            this.f20085m = (TextView) view.findViewById(R$id.tv_group_chat_manager);
        }

        public final FrameLayout e() {
            return this.f20083k;
        }

        public final ImageView f() {
            return this.f20074b;
        }

        public final ImageView g() {
            return this.f20081i;
        }

        public final ImageView h() {
            return this.f20084l;
        }

        public final ImageView i() {
            return this.f20080h;
        }

        public final LinearLayout j() {
            return this.f20082j;
        }

        public final TextView k() {
            return this.f20077e;
        }

        public final TextView l() {
            return this.f20085m;
        }

        public final TextView m() {
            return this.f20079g;
        }

        public final TextView n() {
            return this.f20078f;
        }

        public final TextView o() {
            return this.f20076d;
        }

        public final TextView p() {
            return this.f20075c;
        }
    }

    public static final class b implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupChatListMyAdapter f20086a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20087b;

        public b(GroupChatListMyAdapter groupChatListMyAdapter, a aVar) {
            this.f20086a = groupChatListMyAdapter;
            this.f20087b = aVar;
        }

        public static final void b(a aVar, GroupChatListMyAdapter groupChatListMyAdapter) {
            int absoluteAdapterPosition = aVar.getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition >= 0 && absoluteAdapterPosition < groupChatListMyAdapter.e().size()) {
                groupChatListMyAdapter.e().remove(absoluteAdapterPosition);
                groupChatListMyAdapter.notifyItemRemoved(absoluteAdapterPosition);
                groupChatListMyAdapter.notifyItemRangeChanged(absoluteAdapterPosition, groupChatListMyAdapter.e().size() - absoluteAdapterPosition);
            }
        }

        public void onError(int i11, String str) {
            HuobiToastUtil.g(R$string.string_network_disconnect);
        }

        public void onSuccess() {
            this.f20086a.f().post(new h(this.f20087b, this.f20086a));
        }
    }

    public GroupChatListMyAdapter(Context context, ArrayList<V2TIMConversation> arrayList) {
        this.f20070b = context;
        this.f20071c = arrayList;
        IMConversationHelper.o().G(this);
    }

    @SensorsDataInstrumented
    public static final void i(Ref$ObjectRef ref$ObjectRef, int i11, V2TIMConversation v2TIMConversation, GroupChatListMyAdapter groupChatListMyAdapter, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "message");
        hashMap.put("type", V2TIMConversation.CONVERSATION_GROUP_TYPE);
        String str = (String) ref$ObjectRef.element;
        if (str == null) {
            str = "";
        }
        hashMap.put("name", str);
        SensorsDataHelper.track("appClick_messgeCenter", hashMap);
        Pair[] pairArr = new Pair[2];
        int i12 = 0;
        pairArr[0] = l.a("business_category", "chatlist");
        if (i11 > 0) {
            i12 = 1;
        }
        pairArr[1] = l.a("exist_mention", Integer.valueOf(i12));
        SensorsDataHelper.track("webclick_app_activity", MapsKt__MapsKt.j(pairArr));
        if (v2TIMConversation.getType() == 1) {
            dd.b.f22740a.h(groupChatListMyAdapter.f20070b, v2TIMConversation.getUserID(), v2TIMConversation.getShowName());
        } else {
            dd.b.k(dd.b.f22740a, groupChatListMyAdapter.f20070b, v2TIMConversation.getGroupID(), v2TIMConversation.getShowName(), (String) null, 8, (Object) null);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void j(String str, boolean z11, GroupChatListMyAdapter groupChatListMyAdapter, a aVar, View view) {
        ImManager.INSTANCE.deleteConversation(str, z11, new b(groupChatListMyAdapter, aVar));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final int k(p pVar, Object obj, Object obj2) {
        return ((Number) pVar.invoke(obj, obj2)).intValue();
    }

    public void b(List<V2TIMConversation> list) {
        boolean z11;
        int size = list != null ? list.size() : 0;
        if (size == 0) {
            notifyDataSetChanged();
            return;
        }
        for (int i11 = 0; i11 < size; i11++) {
            V2TIMConversation v2TIMConversation = list.get(i11);
            int size2 = this.f20071c.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size2) {
                    z11 = false;
                    break;
                } else if (x.b(this.f20071c.get(i12).getConversationID(), v2TIMConversation.getConversationID())) {
                    this.f20071c.set(i12, v2TIMConversation);
                    z11 = true;
                    break;
                } else {
                    i12++;
                }
            }
            if (!z11) {
                this.f20071c.add(v2TIMConversation);
            }
        }
        CollectionsKt__MutableCollectionsJVMKt.z(this.f20071c, new g(GroupChatListMyAdapter$onConversationListUpdate$1.INSTANCE));
        notifyDataSetChanged();
    }

    public final ArrayList<V2TIMConversation> e() {
        return this.f20071c;
    }

    public final Handler f() {
        return this.f20072d;
    }

    public final void g(ImageView imageView, String str) {
        imageView.getDrawable();
        CornerTransform cornerTransform = new CornerTransform(TUILogin.getAppContext(), 100.0f);
        if (imageView.getDrawable() == null) {
            com.bumptech.glide.a.v(TUILogin.getAppContext()).q(str).b(((RequestOptions) ((RequestOptions) new RequestOptions().d()).a0(R$drawable.icon_community_user_header)).n0(cornerTransform)).G0((e) null).D0(imageView);
        } else {
            com.bumptech.glide.a.v(TUILogin.getAppContext()).q(str).b(((RequestOptions) ((RequestOptions) new RequestOptions().d()).b0(imageView.getDrawable())).n0(cornerTransform)).G0((e) null).D0(imageView);
        }
    }

    public int getItemCount() {
        return this.f20071c.size();
    }

    /* renamed from: h */
    public void onBindViewHolder(a aVar, int i11) {
        boolean z11;
        String str;
        String str2;
        String str3;
        V2TIMConversation v2TIMConversation = this.f20071c.get(i11);
        boolean z12 = true;
        if (v2TIMConversation.getType() == 2) {
            str = v2TIMConversation.getGroupID();
            z11 = true;
        } else {
            str = v2TIMConversation.getUserID();
            z11 = false;
        }
        g(aVar.f(), v2TIMConversation.getFaceUrl());
        if (IMConversationHelper.o().t(str)) {
            aVar.l().setVisibility(0);
            aVar.g().setVisibility(0);
        } else {
            aVar.l().setVisibility(8);
            aVar.g().setVisibility(8);
        }
        T p11 = IMConversationHelper.o().p(str);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = p11;
        if (TextUtils.isEmpty(p11)) {
            aVar.p().setText(v2TIMConversation.getShowName());
            ref$ObjectRef.element = v2TIMConversation.getShowName();
        } else {
            aVar.p().setText(p11);
        }
        int size = v2TIMConversation.getGroupAtInfoList().size();
        if (size > 0) {
            TextView o11 = aVar.o();
            d0 d0Var = d0.f56774a;
            o11.setText(String.format("[%s] ", Arrays.copyOf(new Object[]{this.f20070b.getResources().getString(R$string.n_group_at_tip)}, 1)));
            aVar.o().setVisibility(0);
        } else {
            aVar.o().setVisibility(8);
        }
        aVar.itemView.setOnClickListener(new f(ref$ObjectRef, size, v2TIMConversation, this));
        aVar.i().setVisibility(v2TIMConversation.isPinned() ? 0 : 8);
        String str4 = "";
        if (v2TIMConversation.getLastMessage() == null) {
            aVar.k().setText(str4);
            aVar.n().setVisibility(8);
        } else {
            int elemType = v2TIMConversation.getLastMessage().getElemType();
            if (elemType == 1) {
                str3 = v2TIMConversation.getLastMessage().getNickName() + ':' + v2TIMConversation.getLastMessage().getTextElem().getText();
            } else if (elemType == 3) {
                str3 = this.f20070b.getString(R$string.n_im_receive_img);
            } else if (elemType != 4) {
                str3 = str4;
            } else {
                str3 = this.f20070b.getString(R$string.n_im_receive_voice);
            }
            if (v2TIMConversation.getLastMessage().getTimestamp() != 0) {
                str4 = DateUtils.a(this.f20070b, v2TIMConversation.getLastMessage().getTimestamp());
            }
            aVar.k().setText(str3);
            if (str4.length() != 0) {
                z12 = false;
            }
            if (z12) {
                aVar.n().setVisibility(8);
            } else {
                aVar.n().setVisibility(0);
                aVar.n().setText(str4);
            }
        }
        if (IMConversationHelper.o().u(str)) {
            aVar.m().setVisibility(8);
            aVar.h().setVisibility(0);
            if (v2TIMConversation.getUnreadCount() > 0) {
                aVar.e().setVisibility(0);
            } else {
                aVar.e().setVisibility(8);
            }
        } else {
            aVar.h().setVisibility(8);
            aVar.e().setVisibility(8);
            if (v2TIMConversation.getUnreadCount() > 0) {
                aVar.m().setVisibility(0);
                TextView m11 = aVar.m();
                if (v2TIMConversation.getUnreadCount() > 99) {
                    str2 = "99+";
                } else {
                    str2 = String.valueOf(v2TIMConversation.getUnreadCount());
                }
                m11.setText(str2);
            } else {
                aVar.m().setVisibility(8);
            }
        }
        aVar.j().setOnClickListener(new e(str, z11, this, aVar));
    }

    /* renamed from: l */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(View.inflate(this.f20070b, R$layout.im_item_group_chat_my, (ViewGroup) null));
    }
}
