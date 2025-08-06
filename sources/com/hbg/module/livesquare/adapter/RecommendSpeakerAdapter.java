package com.hbg.module.livesquare.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.module.content.R$drawable;
import com.hbg.module.huobi.im.view.AvatarView;
import d10.l;
import he.c;
import kotlin.Unit;
import kotlin.f;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import lc.m5;
import xe.e;

public final class RecommendSpeakerAdapter extends c<RecommendSpeakerList.RecommendSpeakerBean, c.a<m5>> {

    public static final class a implements AvatarView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendSpeakerList.RecommendSpeakerBean f26435a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecommendSpeakerAdapter f26436b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f26437c;

        public a(RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean, RecommendSpeakerAdapter recommendSpeakerAdapter, int i11) {
            this.f26435a = recommendSpeakerBean;
            this.f26436b = recommendSpeakerAdapter;
            this.f26437c = i11;
        }

        public void a() {
            AvatarView.a.C0156a.b(this);
        }

        public void b(int i11, int i12) {
            AvatarView.a.C0156a.a(this, i11, i12);
            this.f26435a.setFocusStatus(i11);
            this.f26436b.notifyItemChanged(this.f26437c);
        }
    }

    public static final class b implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f26438b;

        public b(l lVar) {
            this.f26438b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f26438b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f26438b.invoke(obj);
        }
    }

    public RecommendSpeakerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        we.b.m("followStatus", (Class) null, 2, (Object) null).observe(fragmentActivity, new b(new l<e, Unit>(this) {
            public final /* synthetic */ RecommendSpeakerAdapter this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((e) obj);
                return Unit.f56620a;
            }

            public final void invoke(e eVar) {
                this.this$0.n(eVar);
            }
        }));
    }

    /* renamed from: l */
    public void onBindViewHolder(c.a<m5> aVar, int i11) {
        super.onBindViewHolder(aVar, i11);
        RecommendSpeakerList.RecommendSpeakerBean recommendSpeakerBean = (RecommendSpeakerList.RecommendSpeakerBean) g().get(i11);
        aVar.e().M(recommendSpeakerBean);
        aVar.e().B.s(recommendSpeakerBean.getHasLive(), recommendSpeakerBean.getFocusStatus(), recommendSpeakerBean.getUidUnique(), recommendSpeakerBean.getAccount(), recommendSpeakerBean.getLiveId(), i11).w(recommendSpeakerBean.getAvatar(), R$drawable.icon_community_user_header).setAvatarClickListener(new a(recommendSpeakerBean, this, i11));
    }

    /* renamed from: m */
    public c.a<m5> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(m5.K(h(), viewGroup, false));
    }

    public final void n(e eVar) {
        int size = g().size();
        for (int i11 = 0; i11 < size; i11++) {
            if (x.b(((RecommendSpeakerList.RecommendSpeakerBean) g().get(i11)).getUidUnique(), eVar.b())) {
                ((RecommendSpeakerList.RecommendSpeakerBean) g().get(i11)).setFocusStatus(eVar.a());
                notifyItemChanged(i11);
                return;
            }
        }
    }
}
