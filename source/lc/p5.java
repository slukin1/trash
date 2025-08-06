package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;

public class p5 extends o5 {
    public static final f.i R = null;
    public static final SparseIntArray S;
    public final LinearLayout N;
    public final ImageView O;
    public final TextView P;
    public long Q;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        S = sparseIntArray;
        sparseIntArray.put(R$id.tvReplyStr, 10);
        sparseIntArray.put(R$id.tvToNickName, 11);
        sparseIntArray.put(R$id.llPraise, 12);
        sparseIntArray.put(R$id.tvReply, 13);
    }

    public p5(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 14, R, S));
    }

    public void M(CommentInfo commentInfo) {
        this.M = commentInfo;
        synchronized (this) {
            this.Q |= 1;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: android.graphics.drawable.Drawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: android.graphics.drawable.Drawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: android.graphics.drawable.Drawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: android.graphics.drawable.Drawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: android.graphics.drawable.Drawable} */
    /* JADX WARNING: type inference failed for: r9v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i() {
        /*
            r27 = this;
            r1 = r27
            monitor-enter(r27)
            long r2 = r1.Q     // Catch:{ all -> 0x015d }
            r4 = 0
            r1.Q = r4     // Catch:{ all -> 0x015d }
            monitor-exit(r27)     // Catch:{ all -> 0x015d }
            com.hbg.lib.network.hbg.core.bean.CommentInfo r0 = r1.M
            r6 = 3
            long r8 = r2 & r6
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            r9 = 0
            if (r8 == 0) goto L_0x0104
            int r11 = com.hbg.module.content.R$drawable.icon_default_avatar
            if (r0 == 0) goto L_0x003a
            java.lang.String r9 = r0.fromAvatar
            java.lang.String r12 = r0.content
            int r13 = r0.selfComment
            java.lang.String r14 = r0.fromNickname
            int r15 = r0.hasImg
            java.lang.String r10 = r0.parentComment
            java.lang.String r4 = r0.toNickname
            int r5 = r0.parseStatus
            int r6 = r0.isAuthor
            int r7 = r0.parseNums
            r21 = r4
            r22 = r5
            long r4 = r0.createTime
            r25 = r4
            r5 = r22
            r22 = r25
            goto L_0x0046
        L_0x003a:
            r10 = r9
            r12 = r10
            r14 = r12
            r21 = r14
            r5 = 0
            r6 = 0
            r7 = 0
            r13 = 0
            r15 = 0
            r22 = 0
        L_0x0046:
            r0 = 1
            if (r13 != r0) goto L_0x004b
            r4 = r0
            goto L_0x004c
        L_0x004b:
            r4 = 0
        L_0x004c:
            if (r5 != r0) goto L_0x0050
            r5 = r0
            goto L_0x0051
        L_0x0050:
            r5 = 0
        L_0x0051:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r7)
            java.lang.String r0 = ""
            r13.append(r0)
            java.lang.String r0 = r13.toString()
            if (r7 <= 0) goto L_0x0067
            r24 = 1
            goto L_0x0069
        L_0x0067:
            r24 = 0
        L_0x0069:
            java.lang.String r7 = com.hbg.lib.common.utils.DateTimeUtils.d(r22)
            if (r8 == 0) goto L_0x0080
            if (r4 == 0) goto L_0x0078
            r22 = 8
            long r2 = r2 | r22
            r22 = 2048(0x800, double:1.0118E-320)
            goto L_0x007e
        L_0x0078:
            r22 = 4
            long r2 = r2 | r22
            r22 = 1024(0x400, double:5.06E-321)
        L_0x007e:
            long r2 = r2 | r22
        L_0x0080:
            r19 = 3
            long r22 = r2 & r19
            r17 = 0
            int r8 = (r22 > r17 ? 1 : (r22 == r17 ? 0 : -1))
            if (r8 == 0) goto L_0x009b
            if (r5 == 0) goto L_0x0093
            r22 = 32
            long r2 = r2 | r22
            r22 = 128(0x80, double:6.32E-322)
            goto L_0x0099
        L_0x0093:
            r22 = 16
            long r2 = r2 | r22
            r22 = 64
        L_0x0099:
            long r2 = r2 | r22
        L_0x009b:
            r19 = 3
            long r22 = r2 & r19
            r17 = 0
            int r8 = (r22 > r17 ? 1 : (r22 == r17 ? 0 : -1))
            if (r8 == 0) goto L_0x00ae
            if (r24 == 0) goto L_0x00aa
            r22 = 512(0x200, double:2.53E-321)
            goto L_0x00ac
        L_0x00aa:
            r22 = 256(0x100, double:1.265E-321)
        L_0x00ac:
            long r2 = r2 | r22
        L_0x00ae:
            if (r4 == 0) goto L_0x00b3
            r13 = 8
            goto L_0x00b4
        L_0x00b3:
            r13 = 0
        L_0x00b4:
            if (r4 == 0) goto L_0x00b8
            r4 = 0
            goto L_0x00ba
        L_0x00b8:
            r4 = 8
        L_0x00ba:
            if (r5 == 0) goto L_0x00c7
            android.widget.TextView r8 = r1.H
            r23 = r0
            int r0 = com.hbg.module.content.R$color.baseColorMajorTheme100
            int r0 = androidx.databinding.f.p(r8, r0)
            goto L_0x00d1
        L_0x00c7:
            r23 = r0
            android.widget.TextView r0 = r1.H
            int r8 = com.hbg.module.content.R$color.baseColorPrimaryText
            int r0 = androidx.databinding.f.p(r0, r8)
        L_0x00d1:
            if (r5 == 0) goto L_0x00dc
            android.widget.ImageView r5 = r1.C
            android.content.Context r5 = r5.getContext()
            int r8 = com.hbg.module.content.R$drawable.icon_praise
            goto L_0x00e4
        L_0x00dc:
            android.widget.ImageView r5 = r1.C
            android.content.Context r5 = r5.getContext()
            int r8 = com.hbg.module.content.R$drawable.icon_praise_no
        L_0x00e4:
            android.graphics.drawable.Drawable r5 = c.a.b(r5, r8)
            if (r24 == 0) goto L_0x00ed
            r16 = 0
            goto L_0x00ef
        L_0x00ed:
            r16 = 8
        L_0x00ef:
            r8 = r4
            r4 = r14
            r19 = r15
            r14 = r16
            r15 = r0
            r0 = r9
            r16 = r12
            r9 = r5
            r12 = r6
            r6 = r10
            r10 = r13
            r13 = r21
            r5 = r23
            r20 = 3
            goto L_0x0116
        L_0x0104:
            r20 = r6
            r0 = r9
            r4 = r0
            r5 = r4
            r6 = r5
            r7 = r6
            r13 = r7
            r16 = r13
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r19 = 0
        L_0x0116:
            long r2 = r2 & r20
            r17 = 0
            int r2 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r2 == 0) goto L_0x015c
            android.widget.ImageView r2 = r1.B
            r2.setVisibility(r10)
            android.widget.ImageView r2 = r1.C
            androidx.databinding.adapters.ImageViewBindingAdapter.a(r2, r9)
            android.widget.ImageView r2 = r1.O
            he.b.p(r2, r0, r11)
            android.widget.TextView r0 = r1.P
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r7)
            android.widget.TextView r10 = r1.E
            r11 = r4
            r0 = r14
            r14 = r16
            r2 = r15
            r15 = r19
            he.b.n(r10, r11, r12, r13, r14, r15)
            android.widget.TextView r3 = r1.F
            r3.setVisibility(r8)
            android.widget.TextView r3 = r1.G
            androidx.databinding.adapters.TextViewBindingAdapter.c(r3, r4)
            android.widget.TextView r3 = r1.H
            androidx.databinding.adapters.TextViewBindingAdapter.c(r3, r5)
            android.widget.TextView r3 = r1.H
            r3.setTextColor(r2)
            android.widget.TextView r2 = r1.H
            r2.setVisibility(r0)
            android.widget.TextView r0 = r1.J
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r6)
        L_0x015c:
            return
        L_0x015d:
            r0 = move-exception
            monitor-exit(r27)     // Catch:{ all -> 0x015d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.p5.i():void");
    }

    public boolean r() {
        synchronized (this) {
            if (this.Q != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.Q = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p5(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[9], objArr[3], objArr[12], objArr[6], objArr[8], objArr[2], objArr[4], objArr[13], objArr[5], objArr[10], objArr[11]);
        this.Q = -1;
        this.B.setTag((Object) null);
        this.C.setTag((Object) null);
        LinearLayout linearLayout = objArr[0];
        this.N = linearLayout;
        linearLayout.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.O = imageView;
        imageView.setTag((Object) null);
        TextView textView = objArr[7];
        this.P = textView;
        textView.setTag((Object) null);
        this.E.setTag((Object) null);
        this.F.setTag((Object) null);
        this.G.setTag((Object) null);
        this.H.setTag((Object) null);
        this.J.setTag((Object) null);
        G(view);
        t();
    }
}
