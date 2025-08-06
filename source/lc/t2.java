package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$string;
import com.hbg.module.content.adapter.CommentListAdapter;

public class t2 extends s2 {

    /* renamed from: a0  reason: collision with root package name */
    public static final f.i f19325a0 = null;

    /* renamed from: b0  reason: collision with root package name */
    public static final SparseIntArray f19326b0;
    public final LinearLayout W;
    public final TextView X;
    public final LinearLayout Y;
    public long Z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f19326b0 = sparseIntArray;
        sparseIntArray.put(R$id.avatar, 9);
        sparseIntArray.put(R$id.ivReplyTo, 10);
        sparseIntArray.put(R$id.tvToNickName, 11);
        sparseIntArray.put(R$id.ivMore, 12);
        sparseIntArray.put(R$id.flImage, 13);
        sparseIntArray.put(R$id.aivImage, 14);
        sparseIntArray.put(R$id.atvLongPicTab, 15);
        sparseIntArray.put(R$id.tvReply, 16);
        sparseIntArray.put(R$id.llPraise, 17);
        sparseIntArray.put(R$id.imageLike, 18);
        sparseIntArray.put(R$id.llChildContentLay, 19);
        sparseIntArray.put(R$id.llChildContent, 20);
    }

    public t2(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 21, f19325a0, f19326b0));
    }

    public void M(CommentListAdapter commentListAdapter) {
        this.T = commentListAdapter;
    }

    public void N(CommentInfo commentInfo) {
        this.U = commentInfo;
        synchronized (this) {
            this.Z |= 2;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    public void O(Boolean bool) {
        this.V = bool;
    }

    public void i() {
        long j11;
        long j12;
        int i11;
        String str;
        String str2;
        int i12;
        int i13;
        String str3;
        int i14;
        String str4;
        String str5;
        int i15;
        int i16;
        int i17;
        int i18;
        long j13;
        int i19;
        synchronized (this) {
            j11 = this.Z;
            this.Z = 0;
        }
        CommentInfo commentInfo = this.U;
        int i21 = ((j11 & 10) > 0 ? 1 : ((j11 & 10) == 0 ? 0 : -1));
        String str6 = null;
        if (i21 != 0) {
            if (commentInfo != null) {
                str6 = commentInfo.content;
                str2 = commentInfo.fromNickname;
                str = commentInfo.parentComment;
                i17 = commentInfo.isMore;
                i16 = commentInfo.parseStatus;
                i15 = commentInfo.isAuthor;
                i18 = commentInfo.replyNum;
                i19 = commentInfo.parseNums;
                j13 = commentInfo.createTime;
            } else {
                str2 = null;
                str = null;
                i19 = 0;
                j13 = 0;
                i18 = 0;
                i17 = 0;
                i16 = 0;
                i15 = 0;
            }
            boolean z11 = i17 == 1;
            boolean z12 = i16 == 1;
            boolean z13 = i15 == 1;
            String str7 = i18 + "";
            String str8 = i19 + "";
            boolean z14 = i19 > 0;
            String d11 = DateTimeUtils.d(j13);
            if (i21 != 0) {
                j11 |= z11 ? 2048 : 1024;
            }
            if ((j11 & 10) != 0) {
                j11 |= z12 ? 32 : 16;
            }
            if ((j11 & 10) != 0) {
                j11 |= z13 ? 128 : 64;
            }
            if ((j11 & 10) != 0) {
                j11 |= z14 ? 512 : 256;
            }
            int i22 = z11 ? 0 : 8;
            i13 = f.p(this.N, z12 ? R$color.topic_symbol_color : R$color.baseColorSecondaryTextNew);
            i11 = z13 ? 0 : 8;
            str3 = this.S.getResources().getString(R$string.n_content_all_comment_num, new Object[]{str7});
            int i23 = z14 ? 0 : 8;
            str4 = str8;
            str5 = str6;
            j12 = 10;
            str6 = d11;
            int i24 = i23;
            i12 = i22;
            i14 = i24;
        } else {
            j12 = 10;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i14 = 0;
            i13 = 0;
            i12 = 0;
            i11 = 0;
        }
        if ((j11 & j12) != 0) {
            TextViewBindingAdapter.c(this.X, str6);
            this.Y.setVisibility(i12);
            this.L.setVisibility(i11);
            TextViewBindingAdapter.c(this.M, str5);
            TextViewBindingAdapter.c(this.N, str4);
            this.N.setTextColor(i13);
            this.N.setVisibility(i14);
            TextViewBindingAdapter.c(this.O, str2);
            TextViewBindingAdapter.c(this.Q, str);
            TextViewBindingAdapter.c(this.S, str3);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.Z != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.Z = 8;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public t2(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[14], objArr[15], objArr[9], objArr[13], objArr[18], objArr[12], objArr[10], objArr[20], objArr[19], objArr[17], objArr[2], objArr[4], objArr[6], objArr[1], objArr[16], objArr[3], objArr[11], objArr[8]);
        this.Z = -1;
        LinearLayout linearLayout = objArr[0];
        this.W = linearLayout;
        linearLayout.setTag((Object) null);
        TextView textView = objArr[5];
        this.X = textView;
        textView.setTag((Object) null);
        LinearLayout linearLayout2 = objArr[7];
        this.Y = linearLayout2;
        linearLayout2.setTag((Object) null);
        this.L.setTag((Object) null);
        this.M.setTag((Object) null);
        this.N.setTag((Object) null);
        this.O.setTag((Object) null);
        this.Q.setTag((Object) null);
        this.S.setTag((Object) null);
        G(view);
        t();
    }
}
