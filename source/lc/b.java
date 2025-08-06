package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import com.hbg.module.content.ui.activity.CommentDetailActivity;
import mc.a;

public class b extends a implements a.C0130a {

    /* renamed from: e0  reason: collision with root package name */
    public static final f.i f19140e0 = null;

    /* renamed from: f0  reason: collision with root package name */
    public static final SparseIntArray f19141f0;
    public final LinearLayout V;
    public final ImageView W;
    public final TextView X;
    public final AppCompatTextView Y;
    public final ImageView Z;

    /* renamed from: a0  reason: collision with root package name */
    public final TextView f19142a0;

    /* renamed from: b0  reason: collision with root package name */
    public final View.OnClickListener f19143b0;

    /* renamed from: c0  reason: collision with root package name */
    public final View.OnClickListener f19144c0;

    /* renamed from: d0  reason: collision with root package name */
    public long f19145d0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f19141f0 = sparseIntArray;
        sparseIntArray.put(R$id.vTopBar, 12);
        sparseIntArray.put(R$id.loading_layout, 13);
        sparseIntArray.put(R$id.rlRefresh, 14);
        sparseIntArray.put(R$id.ivReplyTo, 15);
        sparseIntArray.put(R$id.tvToNickName, 16);
        sparseIntArray.put(R$id.ivMore, 17);
        sparseIntArray.put(R$id.flTopImage, 18);
        sparseIntArray.put(R$id.aivTopImage, 19);
        sparseIntArray.put(R$id.atvLongPicTab, 20);
        sparseIntArray.put(R$id.tvReply, 21);
        sparseIntArray.put(R$id.llPraise, 22);
        sparseIntArray.put(R$id.rvContent, 23);
    }

    public b(androidx.databinding.b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 24, f19140e0, f19141f0));
    }

    public void M(CommentInfo commentInfo) {
        this.U = commentInfo;
        synchronized (this) {
            this.f19145d0 |= 1;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    public void N(CommentDetailActivity commentDetailActivity) {
        this.T = commentDetailActivity;
        synchronized (this) {
            this.f19145d0 |= 2;
        }
        notifyPropertyChanged(BR.f17732i);
        super.B();
    }

    public final void a(int i11, View view) {
        boolean z11 = false;
        if (i11 == 1) {
            CommentDetailActivity commentDetailActivity = this.T;
            if (commentDetailActivity != null) {
                z11 = true;
            }
            if (z11) {
                commentDetailActivity.finish();
            }
        } else if (i11 == 2) {
            CommentDetailActivity commentDetailActivity2 = this.T;
            if (commentDetailActivity2 != null) {
                z11 = true;
            }
            if (z11) {
                commentDetailActivity2.Nh();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: android.graphics.drawable.Drawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r9v10, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i() {
        /*
            r23 = this;
            r1 = r23
            monitor-enter(r23)
            long r2 = r1.f19145d0     // Catch:{ all -> 0x014c }
            r4 = 0
            r1.f19145d0 = r4     // Catch:{ all -> 0x014c }
            monitor-exit(r23)     // Catch:{ all -> 0x014c }
            com.hbg.lib.network.hbg.core.bean.CommentInfo r0 = r1.U
            r6 = 5
            long r8 = r2 & r6
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            r9 = 0
            if (r8 == 0) goto L_0x00ea
            int r11 = com.hbg.module.content.R$drawable.icon_default_avatar
            if (r0 == 0) goto L_0x002c
            java.lang.String r9 = r0.fromAvatar
            java.lang.String r12 = r0.content
            java.lang.String r13 = r0.fromNickname
            java.lang.String r14 = r0.parentComment
            int r15 = r0.parseStatus
            int r10 = r0.isAuthor
            int r4 = r0.replyNum
            int r5 = r0.parseNums
            long r6 = r0.createTime
            goto L_0x0035
        L_0x002c:
            r12 = r9
            r13 = r12
            r14 = r13
            r4 = 0
            r5 = 0
            r6 = 0
            r10 = 0
            r15 = 0
        L_0x0035:
            r0 = 1
            if (r15 != r0) goto L_0x003a
            r15 = r0
            goto L_0x003b
        L_0x003a:
            r15 = 0
        L_0x003b:
            if (r10 != r0) goto L_0x003f
            r10 = r0
            goto L_0x0040
        L_0x003f:
            r10 = 0
        L_0x0040:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r20 = r9
            android.widget.TextView r9 = r1.X
            android.content.res.Resources r9 = r9.getResources()
            r21 = r11
            int r11 = com.hbg.module.content.R$string.n_reply
            java.lang.String r9 = r9.getString(r11)
            r0.append(r9)
            java.lang.String r9 = " "
            r0.append(r9)
            r0.append(r4)
            java.lang.String r9 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r4 = ""
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            if (r5 <= 0) goto L_0x007a
            r19 = 1
            goto L_0x007c
        L_0x007a:
            r19 = 0
        L_0x007c:
            java.lang.String r4 = com.hbg.lib.common.utils.DateTimeUtils.d(r6)
            if (r8 == 0) goto L_0x0090
            if (r15 == 0) goto L_0x008a
            r5 = 64
            long r2 = r2 | r5
            r5 = 1024(0x400, double:5.06E-321)
            goto L_0x008f
        L_0x008a:
            r5 = 32
            long r2 = r2 | r5
            r5 = 512(0x200, double:2.53E-321)
        L_0x008f:
            long r2 = r2 | r5
        L_0x0090:
            r5 = 5
            long r7 = r2 & r5
            r17 = 0
            int r7 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r7 == 0) goto L_0x00a2
            if (r10 == 0) goto L_0x009f
            r7 = 16
            goto L_0x00a1
        L_0x009f:
            r7 = 8
        L_0x00a1:
            long r2 = r2 | r7
        L_0x00a2:
            long r7 = r2 & r5
            int r5 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r5 == 0) goto L_0x00b0
            if (r19 == 0) goto L_0x00ad
            r5 = 256(0x100, double:1.265E-321)
            goto L_0x00af
        L_0x00ad:
            r5 = 128(0x80, double:6.32E-322)
        L_0x00af:
            long r2 = r2 | r5
        L_0x00b0:
            android.widget.TextView r5 = r1.O
            if (r15 == 0) goto L_0x00b7
            int r6 = com.hbg.module.content.R$color.topic_symbol_color
            goto L_0x00b9
        L_0x00b7:
            int r6 = com.hbg.module.content.R$color.baseColorSecondaryText
        L_0x00b9:
            int r5 = androidx.databinding.f.p(r5, r6)
            android.widget.ImageView r6 = r1.F
            android.content.Context r6 = r6.getContext()
            if (r15 == 0) goto L_0x00c8
            int r7 = com.hbg.module.content.R$drawable.information_like_focus
            goto L_0x00ca
        L_0x00c8:
            int r7 = com.hbg.module.content.R$drawable.information_like
        L_0x00ca:
            android.graphics.drawable.Drawable r6 = c.a.b(r6, r7)
            r7 = 8
            if (r10 == 0) goto L_0x00d4
            r8 = 0
            goto L_0x00d5
        L_0x00d4:
            r8 = r7
        L_0x00d5:
            if (r19 == 0) goto L_0x00d9
            r10 = 0
            goto L_0x00da
        L_0x00d9:
            r10 = r7
        L_0x00da:
            r7 = r5
            r11 = r10
            r10 = r21
            r15 = 5
            r5 = r4
            r4 = r20
            r22 = r6
            r6 = r0
            r0 = r9
            r9 = r22
            goto L_0x00f6
        L_0x00ea:
            r15 = r6
            r0 = r9
            r4 = r0
            r5 = r4
            r6 = r5
            r12 = r6
            r13 = r12
            r14 = r13
            r7 = 0
            r8 = 0
            r10 = 0
            r11 = 0
        L_0x00f6:
            long r15 = r15 & r2
            r17 = 0
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 == 0) goto L_0x0134
            android.widget.ImageView r15 = r1.F
            androidx.databinding.adapters.ImageViewBindingAdapter.a(r15, r9)
            android.widget.TextView r9 = r1.X
            androidx.databinding.adapters.TextViewBindingAdapter.c(r9, r0)
            android.widget.ImageView r0 = r1.Z
            he.b.p(r0, r4, r10)
            android.widget.TextView r0 = r1.f19142a0
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r5)
            android.widget.TextView r0 = r1.L
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.M
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r12)
            android.widget.TextView r0 = r1.N
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r13)
            android.widget.TextView r0 = r1.O
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r6)
            android.widget.TextView r0 = r1.O
            r0.setTextColor(r7)
            android.widget.TextView r0 = r1.O
            r0.setVisibility(r11)
            android.widget.TextView r0 = r1.Q
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r14)
        L_0x0134:
            r4 = 4
            long r2 = r2 & r4
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x014b
            android.widget.ImageView r0 = r1.W
            android.view.View$OnClickListener r2 = r1.f19143b0
            r0.setOnClickListener(r2)
            androidx.appcompat.widget.AppCompatTextView r0 = r1.Y
            android.view.View$OnClickListener r2 = r1.f19144c0
            r0.setOnClickListener(r2)
        L_0x014b:
            return
        L_0x014c:
            r0 = move-exception
            monitor-exit(r23)     // Catch:{ all -> 0x014c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.b.i():void");
    }

    public boolean r() {
        synchronized (this) {
            if (this.f19145d0 != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.f19145d0 = 4;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public b(androidx.databinding.b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[19], objArr[20], objArr[18], objArr[17], objArr[8], objArr[15], objArr[22], objArr[13], objArr[14], objArr[23], objArr[4], objArr[6], objArr[3], objArr[9], objArr[21], objArr[5], objArr[16], objArr[12]);
        this.f19145d0 = -1;
        this.F.setTag((Object) null);
        LinearLayout linearLayout = objArr[0];
        this.V = linearLayout;
        linearLayout.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.W = imageView;
        imageView.setTag((Object) null);
        TextView textView = objArr[10];
        this.X = textView;
        textView.setTag((Object) null);
        AppCompatTextView appCompatTextView = objArr[11];
        this.Y = appCompatTextView;
        appCompatTextView.setTag((Object) null);
        ImageView imageView2 = objArr[2];
        this.Z = imageView2;
        imageView2.setTag((Object) null);
        TextView textView2 = objArr[7];
        this.f19142a0 = textView2;
        textView2.setTag((Object) null);
        this.L.setTag((Object) null);
        this.M.setTag((Object) null);
        this.N.setTag((Object) null);
        this.O.setTag((Object) null);
        this.Q.setTag((Object) null);
        G(view);
        this.f19143b0 = new a(this, 1);
        this.f19144c0 = new a(this, 2);
        t();
    }
}
