package com.hbg.module.huobi.im.group.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.hbg.lib.widgets.expandable.ExpandableTextView;
import com.hbg.lib.widgets.expandable.StatusType;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.group.bean.GroupNoticeItemEntity;
import com.hbg.module.huobi.im.group.ui.GroupChatNoticeActivity;
import com.hbg.module.huobi.im.utils.HbGroupUserManager;
import com.hbg.module.huobi.im.utils.LinkMovementMethodInterceptor;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMManager;
import java.util.List;
import ld.f;
import rd.u;

public class n extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<GroupNoticeItemEntity> f20295a;

    /* renamed from: b  reason: collision with root package name */
    public Context f20296b;

    /* renamed from: c  reason: collision with root package name */
    public f f20297c = new f((ld.e) null);

    /* renamed from: d  reason: collision with root package name */
    public LinkMovementMethodInterceptor f20298d = new LinkMovementMethodInterceptor();

    /* renamed from: e  reason: collision with root package name */
    public e f20299e;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f20300b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f20301c;

        public a(GroupNoticeItemEntity groupNoticeItemEntity, int i11) {
            this.f20300b = groupNoticeItemEntity;
            this.f20301c = i11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            n.this.g(this.f20300b, this.f20301c);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements ExpandableTextView.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f20303a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f20304b;

        public b(GroupNoticeItemEntity groupNoticeItemEntity, int i11) {
            this.f20303a = groupNoticeItemEntity;
            this.f20304b = i11;
        }

        public void a(StatusType statusType) {
            n.this.g(this.f20303a, this.f20304b);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f20306b;

        public c(ExpandableTextView expandableTextView) {
            this.f20306b = expandableTextView;
        }

        public void run() {
            u.a(n.this.f20296b).c(this.f20306b);
            this.f20306b.setMovementMethod(n.this.f20298d);
        }
    }

    public class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f20308b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeItemEntity f20309c;

        public d(int i11, GroupNoticeItemEntity groupNoticeItemEntity) {
            this.f20308b = i11;
            this.f20309c = groupNoticeItemEntity;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            n.this.f20295a.remove(this.f20308b);
            n.this.notifyDataSetChanged();
            n.this.f20297c.u(this.f20309c.getGroupId(), String.valueOf(this.f20309c.getId()), (kd.a<Object>) null);
            if (n.this.f20299e != null) {
                n.this.f20299e.onItemChangeListener(n.this.f20295a.size());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface e {
        void onItemChangeListener(int i11);
    }

    public n(Context context) {
        this.f20296b = context;
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final void g(GroupNoticeItemEntity groupNoticeItemEntity, int i11) {
        Intent intent = new Intent(this.f20296b, GroupChatNoticeActivity.class);
        intent.putExtra("isAdmin", HbGroupUserManager.c().d(V2TIMManager.getInstance().getLoginUser()));
        intent.putExtra("noticeItemData", groupNoticeItemEntity);
        intent.putExtra("groupId", groupNoticeItemEntity.getGroupId());
        intent.putExtra("noticeEditMode", false);
        this.f20296b.startActivity(intent);
        this.f20295a.remove(i11);
        notifyDataSetChanged();
        e eVar = this.f20299e;
        if (eVar != null) {
            eVar.onItemChangeListener(this.f20295a.size());
        }
        this.f20297c.u(groupNoticeItemEntity.getGroupId(), String.valueOf(groupNoticeItemEntity.getId()), (kd.a<Object>) null);
    }

    public int getCount() {
        List<GroupNoticeItemEntity> list = this.f20295a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public void h(List<GroupNoticeItemEntity> list) {
        this.f20295a = list;
        notifyDataSetChanged();
    }

    public void i(e eVar) {
        this.f20299e = eVar;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        GroupNoticeItemEntity groupNoticeItemEntity = this.f20295a.get(i11);
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.layout_group_notice, viewGroup, false);
        ExpandableTextView expandableTextView = (ExpandableTextView) inflate.findViewById(R$id.tv_notice_content);
        expandableTextView.J(groupNoticeItemEntity.getNotification(), (StatusType) null);
        expandableTextView.setOnClickListener(new a(groupNoticeItemEntity, i11));
        expandableTextView.K(new b(groupNoticeItemEntity, i11), false);
        expandableTextView.post(new c(expandableTextView));
        ((ImageView) inflate.findViewById(R$id.iv_close)).setOnClickListener(new d(i11, groupNoticeItemEntity));
        viewGroup.addView(inflate);
        return inflate;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
