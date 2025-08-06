package com.hbg.module.huobi.im.group.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.hbg.core.bean.GroupUserItemData;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.view.AvatarView;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import rd.e;
import rd.f;

public final class GroupUserInfoAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends GroupUserItemData> f20088a;

    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public AvatarView f20089a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f20090b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f20091c;

        public a(View view) {
            super(view);
            this.f20089a = (AvatarView) view.findViewById(R$id.iv_tab_item_icon);
            this.f20090b = (TextView) view.findViewById(R$id.tv_name);
            this.f20091c = (ImageView) view.findViewById(R$id.iv_speaker_tag);
        }

        public final AvatarView e() {
            return this.f20089a;
        }

        public final TextView f() {
            return this.f20090b;
        }

        public final ImageView getIvSpeakerTag() {
            return this.f20091c;
        }
    }

    public static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<GroupUserItemData> f20092a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupUserInfoAdapter f20093b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f20094c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f20095d;

        public b(Ref$ObjectRef<GroupUserItemData> ref$ObjectRef, GroupUserInfoAdapter groupUserInfoAdapter, int i11, a aVar) {
            this.f20092a = ref$ObjectRef;
            this.f20093b = groupUserInfoAdapter;
            this.f20094c = i11;
            this.f20095d = aVar;
        }

        public void a(int i11, String str) {
            e.a.a(this, i11, str);
            this.f20095d.e().w(((GroupUserItemData) this.f20092a.element).getAvatar(), R$drawable.icon_community_user_header);
        }

        public void b(V2TIMUserFullInfo v2TIMUserFullInfo) {
            e.a.c(this, v2TIMUserFullInfo);
        }

        public void c(String str, String str2) {
            e.a.d(this, str, str2);
            GroupUserItemData groupUserItemData = (GroupUserItemData) this.f20092a.element;
            if (str == null) {
                str = "";
            }
            groupUserItemData.setAvatar(str);
            this.f20093b.notifyItemChanged(this.f20094c);
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i11) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = this.f20088a.get(i11);
        aVar.f().setText(((GroupUserItemData) ref$ObjectRef.element).getNickname());
        if (((GroupUserItemData) ref$ObjectRef.element).getRole() == 3) {
            aVar.getIvSpeakerTag().setVisibility(0);
        } else {
            aVar.getIvSpeakerTag().setVisibility(8);
        }
        if (((GroupUserItemData) ref$ObjectRef.element).getAvatar() == null) {
            f.a(((GroupUserItemData) ref$ObjectRef.element).getAccount(), new b(ref$ObjectRef, this, i11, aVar));
        } else {
            aVar.e().w(((GroupUserItemData) ref$ObjectRef.element).getAvatar(), R$drawable.icon_community_user_header);
        }
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_group_info_uset, viewGroup, false));
    }

    public final void d(List<? extends GroupUserItemData> list) {
        this.f20088a = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        List<? extends GroupUserItemData> list = this.f20088a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
