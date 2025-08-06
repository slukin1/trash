package com.hbg.module.content.adapter;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.SaveImageUtils;
import com.hbg.lib.network.hbg.core.bean.CommentImageInfo;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import com.hbg.module.content.R$attr;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.hbg.module.content.interfaces.NoDoubleClickListener;
import com.hbg.module.content.ui.activity.CommentDetailActivity;
import com.hbg.module.content.utls.TipsPopDialog;
import com.hbg.module.content.utls.comment.CommentExtKt;
import com.hbg.module.content.utls.m;
import com.hbg.module.content.utls.o;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.utils.event.bean.CommentNum;
import com.huochat.community.base.CommunityConstants;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import he.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import lc.o5;
import lc.s2;
import rd.s;

public final class CommentListAdapter extends he.c<CommentInfo, c.a<s2>> {

    /* renamed from: f  reason: collision with root package name */
    public String f17758f;

    /* renamed from: g  reason: collision with root package name */
    public String f17759g;

    /* renamed from: h  reason: collision with root package name */
    public String f17760h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17761i;

    /* renamed from: j  reason: collision with root package name */
    public String f17762j;

    /* renamed from: k  reason: collision with root package name */
    public HbgBaseProvider f17763k;

    /* renamed from: l  reason: collision with root package name */
    public a f17764l;

    public interface a {
        void J7(int i11);

        void Q3(int i11);

        void be(int i11);

        void j7(int i11);
    }

    public static final class b implements rc.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommentListAdapter f17765a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f17766b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CommentInfo f17767c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f17768d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17769e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f17770f;

        public b(CommentListAdapter commentListAdapter, boolean z11, CommentInfo commentInfo, int i11, String str, String str2) {
            this.f17765a = commentListAdapter;
            this.f17766b = z11;
            this.f17767c = commentInfo;
            this.f17768d = i11;
            this.f17769e = str;
            this.f17770f = str2;
        }

        public void a(CommentInfo commentInfo, int i11) {
            CommentInfo commentInfo2 = commentInfo;
            if (this.f17765a.f() instanceof BaseActivity) {
                ((BaseActivity) this.f17765a.f()).Df();
            }
            if (commentInfo2 != null) {
                boolean z11 = this.f17766b;
                CommentListAdapter commentListAdapter = this.f17765a;
                CommentInfo commentInfo3 = this.f17767c;
                int i12 = this.f17768d;
                String str = this.f17769e;
                String str2 = this.f17770f;
                if (z11 || commentListAdapter.I()) {
                    commentInfo2.toNickname = commentInfo3.fromNickname;
                    commentInfo2.toUid = commentInfo3.fromUniqueUid;
                    commentInfo2.parentComment = commentInfo3.content;
                }
                if (commentListAdapter.I()) {
                    commentListAdapter.g().add(0, commentInfo2);
                    commentListAdapter.notifyItemRangeInserted(0, 1);
                } else {
                    CommentInfo commentInfo4 = (CommentInfo) commentListAdapter.g().get(i12);
                    if (commentInfo4.children == null) {
                        commentInfo4.children = new ArrayList();
                    }
                    commentInfo4.children.add(0, commentInfo2);
                    int i13 = commentInfo4.replyNum + 1;
                    commentInfo4.replyNum = i13;
                    if (i13 > 2) {
                        commentInfo4.isMore = 1;
                    } else {
                        commentInfo4.isMore = 0;
                    }
                    commentListAdapter.notifyItemChanged(i12);
                }
                if (!com.hbg.module.libkt.base.ext.b.x(commentListAdapter.D())) {
                    we.c cVar = we.c.f26319a;
                    int i14 = x.b(commentListAdapter.E(), "1") ? 1 : 2;
                    String D = commentListAdapter.D();
                    we.c.o(i14, (D != null ? Long.valueOf(Long.parseLong(D)) : null).longValue(), str2, i11, com.hbg.module.libkt.base.ext.b.x(str) ? -1 : i12, commentInfo, commentListAdapter.I(), false, (String) null, com.sumsub.sns.internal.ml.autocapture.b.f34945b, (Object) null);
                }
            }
        }

        public void b() {
            if (this.f17765a.f() instanceof BaseActivity) {
                ((BaseActivity) this.f17765a.f()).sh();
            }
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17771b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17772c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentListAdapter f17773d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommentImageInfo f17774e;

        public c(View view, long j11, CommentListAdapter commentListAdapter, CommentImageInfo commentImageInfo) {
            this.f17771b = view;
            this.f17772c = j11;
            this.f17773d = commentListAdapter;
            this.f17774e = commentImageInfo;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17771b) > this.f17772c || (this.f17771b instanceof Checkable)) {
                sVar.e(this.f17771b, currentTimeMillis);
                FrameLayout frameLayout = (FrameLayout) this.f17771b;
                FragmentActivity f11 = this.f17773d.f();
                CommentImageInfo commentImageInfo = this.f17774e;
                PhotoViewerUtils.a(f11, CollectionsKt__CollectionsKt.p(new ImageData(commentImageInfo.image, commentImageInfo.thumbImage)), 0);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17775b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17776c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentInfo f17777d;

        public d(View view, long j11, CommentInfo commentInfo) {
            this.f17775b = view;
            this.f17776c = j11;
            this.f17777d = commentInfo;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17775b) > this.f17776c || (this.f17775b instanceof Checkable)) {
                sVar.e(this.f17775b, currentTimeMillis);
                TextView textView = (TextView) this.f17775b;
                b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f17777d.fromUniqueUid).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17778b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17779c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentListAdapter f17780d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17781e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a f17782f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CommentInfo f17783g;

        public e(View view, long j11, CommentListAdapter commentListAdapter, int i11, c.a aVar, CommentInfo commentInfo) {
            this.f17778b = view;
            this.f17779c = j11;
            this.f17780d = commentListAdapter;
            this.f17781e = i11;
            this.f17782f = aVar;
            this.f17783g = commentInfo;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            a q11;
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17778b) > this.f17779c || (this.f17778b instanceof Checkable)) {
                sVar.e(this.f17778b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f17778b;
                if (x.b(this.f17780d.E(), "4") && (q11 = this.f17780d.f17764l) != null) {
                    q11.Q3(this.f17781e);
                }
                CommentListAdapter.P(this.f17780d, ((s2) this.f17782f.e()).F, ((s2) this.f17782f.e()).N, this.f17783g.f70229id, this.f17781e, (Integer) null, 16, (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17784b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17785c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentListAdapter f17786d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommentInfo f17787e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17788f;

        public f(View view, long j11, CommentListAdapter commentListAdapter, CommentInfo commentInfo, int i11) {
            this.f17784b = view;
            this.f17785c = j11;
            this.f17786d = commentListAdapter;
            this.f17787e = commentInfo;
            this.f17788f = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17784b) > this.f17785c || (this.f17784b instanceof Checkable)) {
                sVar.e(this.f17784b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f17784b;
                o oVar = o.f18923a;
                FragmentActivity f11 = this.f17786d.f();
                l lVar = new l(this.f17786d, this.f17788f, this.f17787e);
                boolean z11 = true;
                boolean z12 = BaseModuleConfig.a().s() == 1 || this.f17787e.selfComment == 1;
                if (this.f17787e.selfComment == 1) {
                    z11 = false;
                }
                o.f(oVar, f11, imageView, lVar, false, z12, z11, false, 72, (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17789b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17790c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentListAdapter f17791d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17792e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommentInfo f17793f;

        public g(View view, long j11, CommentListAdapter commentListAdapter, int i11, CommentInfo commentInfo) {
            this.f17789b = view;
            this.f17790c = j11;
            this.f17791d = commentListAdapter;
            this.f17792e = i11;
            this.f17793f = commentInfo;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            a q11;
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17789b) > this.f17790c || (this.f17789b instanceof Checkable)) {
                sVar.e(this.f17789b, currentTimeMillis);
                TextView textView = (TextView) this.f17789b;
                if (x.b(this.f17791d.E(), "4") && (q11 = this.f17791d.f17764l) != null) {
                    q11.J7(this.f17792e);
                }
                Intent intent = new Intent(this.f17791d.f(), CommentDetailActivity.class);
                intent.putExtra(CommunityConstants.TOPIC_ID, this.f17791d.D());
                intent.putExtra("symbols", this.f17791d.C());
                intent.putExtra("topicType", this.f17791d.E());
                intent.putExtra("commentId", this.f17793f.f70229id);
                this.f17791d.f().startActivity(intent);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class h implements View.OnLongClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17794b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17795c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentImageInfo f17796d;

        public h(View view, long j11, CommentImageInfo commentImageInfo) {
            this.f17794b = view;
            this.f17795c = j11;
            this.f17796d = commentImageInfo;
        }

        public final boolean onLongClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17794b) <= this.f17795c && !(this.f17794b instanceof Checkable)) {
                return true;
            }
            sVar.e(this.f17794b, currentTimeMillis);
            SaveImageUtils.h(((FrameLayout) this.f17794b).getContext(), this.f17796d.image);
            return true;
        }
    }

    public static final class i extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommentListAdapter f17797b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f17798c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentInfo f17799d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommentInfo f17800e;

        public i(CommentListAdapter commentListAdapter, int i11, CommentInfo commentInfo, CommentInfo commentInfo2) {
            this.f17797b = commentListAdapter;
            this.f17798c = i11;
            this.f17799d = commentInfo;
            this.f17800e = commentInfo2;
        }

        public void onViewClick(View view) {
            this.f17797b.t(this.f17798c, this.f17799d, this.f17800e.f70229id, this.f17799d.f70229id, true);
        }
    }

    public static final class j extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommentListAdapter f17801b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CommentInfo f17802c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f17803d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17804e;

        public j(CommentListAdapter commentListAdapter, CommentInfo commentInfo, int i11, int i12) {
            this.f17801b = commentListAdapter;
            this.f17802c = commentInfo;
            this.f17803d = i11;
            this.f17804e = i12;
        }

        public void onViewClick(View view) {
            this.f17801b.w(this.f17802c.f70229id, this.f17803d, Integer.valueOf(this.f17804e));
        }
    }

    public static final class k extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommentListAdapter f17805b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f17806c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentInfo f17807d;

        public k(CommentListAdapter commentListAdapter, int i11, CommentInfo commentInfo) {
            this.f17805b = commentListAdapter;
            this.f17806c = i11;
            this.f17807d = commentInfo;
        }

        public void onViewClick(View view) {
            a q11;
            if (x.b(this.f17805b.E(), "4") && (q11 = this.f17805b.f17764l) != null) {
                q11.j7(this.f17806c);
            }
            if (!this.f17805b.I() || this.f17805b.B() == null) {
                CommentListAdapter commentListAdapter = this.f17805b;
                int i11 = this.f17806c;
                CommentInfo commentInfo = this.f17807d;
                CommentListAdapter.u(commentListAdapter, i11, commentInfo, commentInfo.f70229id, (String) null, false, 24, (Object) null);
                return;
            }
            CommentListAdapter commentListAdapter2 = this.f17805b;
            CommentListAdapter.u(commentListAdapter2, this.f17806c, this.f17807d, commentListAdapter2.B(), this.f17807d.f70229id, false, 16, (Object) null);
        }
    }

    public static final class l implements com.hbg.module.content.utls.m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommentListAdapter f17808a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f17809b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CommentInfo f17810c;

        public static final class a implements DialogUtils.c {

            /* renamed from: a  reason: collision with root package name */
            public static final a f17811a = new a();

            public final void onClick(int i11) {
                nc.c.a("app_comment_complain_click", MapsKt__MapsKt.j(kotlin.l.a("comment_complain_state", "app_huobiNews_details"), kotlin.l.a("complain_item", Integer.valueOf(i11))));
            }
        }

        public l(CommentListAdapter commentListAdapter, int i11, CommentInfo commentInfo) {
            this.f17808a = commentListAdapter;
            this.f17809b = i11;
            this.f17810c = commentInfo;
        }

        public void a() {
            m.a.c(this);
            DialogUtils.T(this.f17808a.f(), a.f17811a);
        }

        public void b() {
            m.a.e(this);
        }

        public void c(int i11) {
            m.a.b(this, i11);
        }

        public void d() {
            m.a.d(this);
        }

        public void e() {
            a q11;
            m.a.a(this);
            if (x.b(this.f17808a.E(), "4") && (q11 = this.f17808a.f17764l) != null) {
                q11.be(this.f17809b);
            }
            CommentListAdapter.x(this.f17808a, this.f17810c.f70229id, this.f17809b, (Integer) null, 4, (Object) null);
        }
    }

    public static final class m extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommentListAdapter f17812b;

        public m(CommentListAdapter commentListAdapter) {
            this.f17812b = commentListAdapter;
        }

        public void onViewClick(View view) {
            DialogUtils.V(this.f17812b.f());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommentListAdapter(FragmentActivity fragmentActivity, String str, String str2, String str3, boolean z11, String str4, int i11, r rVar) {
        this(fragmentActivity, (i11 & 2) != 0 ? null : str, str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? false : z11, (i11 & 32) != 0 ? null : str4);
    }

    public static /* synthetic */ void G(CommentListAdapter commentListAdapter, CommentInfo commentInfo, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        commentListAdapter.F(commentInfo, i11, z11);
    }

    public static final boolean K(CommentListAdapter commentListAdapter, CommentInfo commentInfo, int i11, View view) {
        U(commentListAdapter, commentInfo, i11, view, (Integer) null, 8, (Object) null);
        return true;
    }

    public static final boolean L(CommentListAdapter commentListAdapter, CommentInfo commentInfo, int i11, int i12, View view) {
        commentListAdapter.T(commentInfo, i11, view, Integer.valueOf(i12));
        return true;
    }

    @SensorsDataInstrumented
    public static final void M(CommentListAdapter commentListAdapter, int i11, CommentInfo commentInfo, View view) {
        a aVar;
        if (x.b(commentListAdapter.f17759g, "4") && (aVar = commentListAdapter.f17764l) != null) {
            aVar.J7(i11);
        }
        Intent intent = new Intent(commentListAdapter.f(), CommentDetailActivity.class);
        intent.putExtra(CommunityConstants.TOPIC_ID, commentListAdapter.f17758f);
        intent.putExtra("topicType", commentListAdapter.f17759g);
        intent.putExtra("commentId", commentInfo.f70229id);
        intent.putExtra("symbols", commentListAdapter.f17760h);
        commentListAdapter.f().startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void P(CommentListAdapter commentListAdapter, ImageView imageView, TextView textView, String str, int i11, Integer num, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            num = null;
        }
        commentListAdapter.O(imageView, textView, str, i11, num);
    }

    public static /* synthetic */ void U(CommentListAdapter commentListAdapter, CommentInfo commentInfo, int i11, View view, Integer num, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            num = null;
        }
        commentListAdapter.T(commentInfo, i11, view, num);
    }

    public static /* synthetic */ void u(CommentListAdapter commentListAdapter, int i11, CommentInfo commentInfo, String str, String str2, boolean z11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        commentListAdapter.t(i11, commentInfo, str, str3, z11);
    }

    public static /* synthetic */ void x(CommentListAdapter commentListAdapter, String str, int i11, Integer num, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            num = null;
        }
        commentListAdapter.w(str, i11, num);
    }

    public static final void y(HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    public static final void z(CommentListAdapter commentListAdapter, String str, int i11, Integer num, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        commentListAdapter.R(str, i11, num);
    }

    public final void A(String str) {
        int size = g().size();
        for (int i11 = 0; i11 < size; i11++) {
            if (x.b(str, ((CommentInfo) g().get(i11)).f70229id)) {
                g().remove(i11);
                notifyItemRemoved(i11);
                return;
            }
        }
    }

    public final String B() {
        return this.f17762j;
    }

    public final String C() {
        return this.f17760h;
    }

    public final String D() {
        return this.f17758f;
    }

    public final String E() {
        return this.f17759g;
    }

    public final void F(CommentInfo commentInfo, int i11, boolean z11) {
        commentInfo.isTrans = z11;
        String str = commentInfo.content;
        commentInfo.content = commentInfo.oldContent;
        commentInfo.oldContent = str;
        notifyItemChanged(i11);
    }

    public final void H(int i11, CommentInfo commentInfo) {
        g().add(i11, commentInfo);
        notifyDataSetChanged();
    }

    public final boolean I() {
        return this.f17761i;
    }

    /* renamed from: J */
    public void onBindViewHolder(c.a<s2> aVar, int i11) {
        int i12;
        int i13 = i11;
        super.onBindViewHolder(aVar, i11);
        CommentInfo commentInfo = (CommentInfo) g().get(i13);
        aVar.e().M(this);
        aVar.e().N(commentInfo);
        aVar.e().O(Boolean.valueOf(this.f17761i));
        int i14 = 8;
        if (commentInfo.hasImg == 1) {
            List<CommentImageInfo> list = commentInfo.imgList;
            if (list != null && list.size() > 0) {
                CommentImageInfo commentImageInfo = commentInfo.imgList.get(0);
                int a11 = com.hbg.module.libkt.base.ext.c.a(120.0f);
                AppCompatImageView appCompatImageView = aVar.e().B;
                ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                layoutParams.height = CommentExtKt.j(Float.parseFloat(commentImageInfo.width), Float.parseFloat(commentImageInfo.height), a11);
                layoutParams.width = a11;
                appCompatImageView.setLayoutParams(layoutParams);
                if ((Float.parseFloat(commentImageInfo.height) / Float.parseFloat(commentImageInfo.width)) * ((float) com.hbg.module.libkt.base.ext.c.a(120.0f)) >= 2000.0f) {
                    aVar.e().C.setVisibility(0);
                } else {
                    aVar.e().C.setVisibility(8);
                }
                if (NightHelper.e().g()) {
                    f6.c.a().f(aVar.e().B, commentImageInfo.thumbImage, R$drawable.ic_community_feed_placeholder_night);
                } else {
                    f6.c.a().f(aVar.e().B, commentImageInfo.thumbImage, R$drawable.ic_community_feed_placeholder_light);
                }
                aVar.e().E.setVisibility(0);
                s sVar = s.f23381a;
                FrameLayout frameLayout = aVar.e().E;
                frameLayout.setOnClickListener(new c(frameLayout, 800, this, commentImageInfo));
                FrameLayout frameLayout2 = aVar.e().E;
                frameLayout2.setOnLongClickListener(new h(frameLayout2, 800, commentImageInfo));
            }
        } else {
            aVar.e().E.setVisibility(8);
        }
        aVar.e().P.setOnClickListener(new k(this, i13, commentInfo));
        String str = null;
        if (com.hbg.module.libkt.base.ext.b.x(commentInfo.fromAvatar)) {
            aVar.e().D.y(R$drawable.account_user_image, 0);
            AvatarView avatarView = aVar.e().D;
            if (avatarView != null) {
                PersonalCenterInfo.UcExtInfo ucExtInfo = commentInfo.fromUcExtInfo;
                if (ucExtInfo != null) {
                    str = ucExtInfo.showExtBusinessTag;
                }
                avatarView.A("BIG_V".equals(str));
            }
        } else {
            AvatarView avatarView2 = aVar.e().D;
            String str2 = commentInfo.fromAvatar;
            PersonalCenterInfo.UcExtInfo ucExtInfo2 = commentInfo.fromUcExtInfo;
            boolean b11 = x.b(ucExtInfo2 != null ? ucExtInfo2.headImageType : null, "NFT");
            PersonalCenterInfo.UcExtInfo ucExtInfo3 = commentInfo.fromUcExtInfo;
            AvatarView.t(avatarView2.u(str2, b11, ucExtInfo3 != null ? ucExtInfo3.frameUrl : null), 0, -1, commentInfo.fromUniqueUid, (String) null, (String) null, 0, 48, (Object) null);
            AvatarView avatarView3 = aVar.e().D;
            if (avatarView3 != null) {
                PersonalCenterInfo.UcExtInfo ucExtInfo4 = commentInfo.fromUcExtInfo;
                if (ucExtInfo4 != null) {
                    str = ucExtInfo4.showExtBusinessTag;
                }
                avatarView3.A("BIG_V".equals(str));
            }
        }
        s sVar2 = s.f23381a;
        TextView textView = aVar.e().O;
        textView.setOnClickListener(new d(textView, 800, commentInfo));
        Q(aVar.e().F, aVar.e().N, commentInfo.parseStatus, commentInfo.parseNums, false, i11);
        RelativeLayout relativeLayout = aVar.e().K;
        relativeLayout.setOnClickListener(new e(relativeLayout, 800, this, i11, aVar, commentInfo));
        ImageView imageView = aVar.e().G;
        imageView.setOnClickListener(new f(imageView, 800, this, commentInfo, i11));
        aVar.e().M.setVisibility(com.hbg.module.libkt.base.ext.b.x(commentInfo.content) ? 8 : 0);
        aVar.e().M.setOnLongClickListener(new b(this, commentInfo, i13));
        int i15 = 4;
        if (this.f17761i) {
            if (com.hbg.module.libkt.base.ext.b.x(commentInfo.toNickname)) {
                aVar.e().R.setVisibility(4);
                aVar.e().H.setVisibility(8);
                return;
            }
            aVar.e().R.setVisibility(0);
            aVar.e().R.setText(commentInfo.toNickname);
            aVar.e().H.setVisibility(0);
        } else if (!com.hbg.module.libkt.base.ext.b.w(commentInfo.children)) {
            aVar.e().I.removeAllViews();
            int min = Math.min(2, commentInfo.children.size());
            int i16 = 0;
            while (i16 < min) {
                o5 K = o5.K(h());
                CommentInfo commentInfo2 = commentInfo.children.get(i16);
                K.M(commentInfo2);
                com.hbg.module.libkt.base.ext.b.x(commentInfo2.parentComment);
                TextView textView2 = K.K;
                if (com.hbg.module.libkt.base.ext.b.x(commentInfo2.toNickname)) {
                    K.L.setVisibility(i15);
                    i12 = i14;
                } else {
                    K.L.setVisibility(0);
                    K.L.setText(commentInfo2.toNickname);
                    i12 = 0;
                }
                textView2.setVisibility(i12);
                K.B.setOnClickListener(new m(this));
                K.E.setOnLongClickListener(new c(this, commentInfo2, i13, i16));
                K.I.setOnClickListener(new i(this, i13, commentInfo2, commentInfo));
                K.F.setOnClickListener(new j(this, commentInfo2, i13, i16));
                s sVar3 = s.f23381a;
                TextView textView3 = K.E;
                g gVar = r0;
                g gVar2 = new g(textView3, 800, this, i11, commentInfo);
                textView3.setOnClickListener(gVar);
                aVar.e().I.addView(K.getRoot());
                i16++;
                i15 = 4;
                i14 = 8;
            }
            aVar.e().J.setVisibility(0);
            aVar.e().J.setOnClickListener(new a(this, i13, commentInfo));
        } else {
            aVar.e().J.setVisibility(8);
        }
    }

    /* renamed from: N */
    public c.a<s2> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        this.f17763k = (HbgBaseProvider) b2.a.d().a("/provider/content").navigation();
        return new c.a<>(s2.K(h(), viewGroup, false));
    }

    public final void O(ImageView imageView, TextView textView, String str, int i11, Integer num) {
        HbgBaseProvider hbgBaseProvider = this.f17763k;
        boolean z11 = false;
        if (hbgBaseProvider != null && hbgBaseProvider.j(f())) {
            z11 = true;
        }
        if (z11) {
            String str2 = str;
            RequestExtKt.d(v7.b.a().D0(str2, 1), new CommentListAdapter$praise$1(num, this, i11, str2, imageView, textView), CommentListAdapter$praise$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        }
    }

    public final void Q(ImageView imageView, TextView textView, int i11, int i12, boolean z11, int i13) {
        textView.setVisibility(i12 == 0 ? 8 : 0);
        if (i11 == 0) {
            com.hbg.module.libkt.base.ext.b.A(imageView, com.hbg.module.libkt.base.ext.b.q(textView.getContext(), R$attr.information_like));
            s.f23381a.i(textView, R$color.baseColorSecondaryTextNew);
            textView.setText(String.valueOf(i12));
            return;
        }
        com.hbg.module.libkt.base.ext.b.A(imageView, com.hbg.module.libkt.base.ext.b.q(textView.getContext(), R$attr.information_like_focus));
        s.f23381a.i(textView, R$color.baseColorMajorTheme100);
        textView.setText(String.valueOf(i12));
    }

    public final void R(String str, int i11, Integer num) {
        RequestExtKt.d(v7.b.a().C(str), new CommentListAdapter$sendDelRequest$1(num, this, i11, str), CommentListAdapter$sendDelRequest$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final void S(a aVar) {
        this.f17764l = aVar;
    }

    public final void T(CommentInfo commentInfo, int i11, View view, Integer num) {
        new TipsPopDialog(f(), new CommentListAdapter$showTransPop$1(this, commentInfo, i11, num), commentInfo.f70229id, commentInfo.fromUniqueUid, BaseModuleConfig.a().s() != 1 || commentInfo.selfComment == 1, commentInfo.isTrans ^ true ? 1 : 0).g(view);
    }

    public final void V(CommentNum commentNum) {
        CommentInfo c11 = commentNum.c();
        if (c11 == null) {
            return;
        }
        if (commentNum.b() == -1) {
            g().add(0, c11);
            notifyDataSetChanged();
            return;
        }
        int size = g().size();
        for (int i11 = 0; i11 < size; i11++) {
            if (x.b(commentNum.d(), ((CommentInfo) g().get(i11)).f70229id)) {
                CommentInfo commentInfo = (CommentInfo) g().get(i11);
                commentInfo.children.add(0, c11);
                int i12 = commentInfo.replyNum + 1;
                commentInfo.replyNum = i12;
                if (i12 > 2) {
                    commentInfo.isMore = 1;
                } else {
                    commentInfo.isMore = 0;
                }
                notifyItemChanged(i11);
                return;
            }
        }
    }

    public final void W(xe.g gVar) {
        int size = g().size();
        for (int i11 = 0; i11 < size; i11++) {
            if (x.b(gVar.b(), ((CommentInfo) g().get(i11)).f70229id)) {
                CommentInfo commentInfo = (CommentInfo) g().get(i11);
                if (com.hbg.module.libkt.base.ext.b.x(gVar.a())) {
                    commentInfo.parseNums = gVar.d();
                    commentInfo.parseStatus = gVar.e();
                } else {
                    int size2 = commentInfo.children.size();
                    for (int i12 = 0; i12 < size2; i12++) {
                        CommentInfo commentInfo2 = commentInfo.children.get(i12);
                        if (x.b(gVar.a(), commentInfo2.f70229id)) {
                            commentInfo2.parseNums = gVar.d();
                            commentInfo2.parseStatus = gVar.e();
                        }
                    }
                }
                notifyItemChanged(i11);
                return;
            }
        }
    }

    public final void t(int i11, CommentInfo commentInfo, String str, String str2, boolean z11) {
        HbgBaseProvider hbgBaseProvider = this.f17763k;
        if (hbgBaseProvider != null && hbgBaseProvider.j(f())) {
            FragmentActivity f11 = f();
            String str3 = this.f17758f;
            String str4 = this.f17759g;
            String str5 = this.f17760h;
            b bVar = new b(this, z11, commentInfo, i11, str2, str);
            d0 d0Var = d0.f56774a;
            CommentExtKt.d(f11, str3, str4, str5, bVar, str, str2, String.format(com.hbg.module.libkt.base.ext.b.j(R$string.n_reply_to), Arrays.copyOf(new Object[]{commentInfo.fromNickname}, 1)));
        }
    }

    public final void v(CommentNum commentNum) {
        int size = g().size();
        for (int i11 = 0; i11 < size; i11++) {
            if (x.b(commentNum.d(), ((CommentInfo) g().get(i11)).f70229id)) {
                CommentInfo commentInfo = (CommentInfo) g().get(i11);
                List<CommentInfo> list = commentInfo.children;
                int size2 = list.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    if (x.b(list.get(i12).f70229id, commentNum.a())) {
                        list.remove(i12);
                        int i13 = commentInfo.replyNum - 1;
                        commentInfo.replyNum = i13;
                        if (i13 > 2) {
                            commentInfo.isMore = 1;
                        } else {
                            commentInfo.isMore = 0;
                        }
                        notifyItemChanged(i11);
                        return;
                    }
                }
                return;
            }
        }
    }

    public final void w(String str, int i11, Integer num) {
        HbgBaseProvider hbgBaseProvider = this.f17763k;
        boolean z11 = true;
        if (hbgBaseProvider == null || !hbgBaseProvider.j(f())) {
            z11 = false;
        }
        if (z11) {
            DialogUtils.c0(f(), com.hbg.module.libkt.base.ext.b.j(R$string.n_comment_del_tips), (String) null, com.hbg.module.libkt.base.ext.b.j(R$string.n_cancel), com.hbg.module.libkt.base.ext.b.j(R$string.n_confirm), e.f17848a, new d(this, str, i11, num));
        }
    }

    public CommentListAdapter(FragmentActivity fragmentActivity, String str, String str2, String str3, boolean z11, String str4) {
        super(fragmentActivity);
        this.f17758f = str;
        this.f17759g = str2;
        this.f17760h = str3;
        this.f17761i = z11;
        this.f17762j = str4;
    }
}
