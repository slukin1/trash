package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;

public class t extends s {

    /* renamed from: g0  reason: collision with root package name */
    public static final f.i f19321g0 = null;

    /* renamed from: h0  reason: collision with root package name */
    public static final SparseIntArray f19322h0;

    /* renamed from: e0  reason: collision with root package name */
    public final FrameLayout f19323e0;

    /* renamed from: f0  reason: collision with root package name */
    public long f19324f0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f19322h0 = sparseIntArray;
        sparseIntArray.put(R$id.coordinatorTabLayout, 5);
        sparseIntArray.put(R$id.appbar_layout, 6);
        sparseIntArray.put(R$id.wrapCollapsingToolbarLayout, 7);
        sparseIntArray.put(R$id.rvHeader, 8);
        sparseIntArray.put(R$id.vTopV, 9);
        sparseIntArray.put(R$id.userAvatar, 10);
        sparseIntArray.put(R$id.llNickName, 11);
        sparseIntArray.put(R$id.tv_group_chat_manager, 12);
        sparseIntArray.put(R$id.btnAttention, 13);
        sparseIntArray.put(R$id.imageAttentionPlus, 14);
        sparseIntArray.put(R$id.tvARAction, 15);
        sparseIntArray.put(R$id.follow_status, 16);
        sparseIntArray.put(R$id.userSummary, 17);
        sparseIntArray.put(R$id.ll_bottom, 18);
        sparseIntArray.put(R$id.ll_follow, 19);
        sparseIntArray.put(R$id.ll_fans, 20);
        sparseIntArray.put(R$id.ll_article, 21);
        sparseIntArray.put(R$id.ivChatC2C, 22);
        sparseIntArray.put(R$id.ivChatPrivateGroup, 23);
        sparseIntArray.put(R$id.toolbar, 24);
        sparseIntArray.put(R$id.tabLayout, 25);
        sparseIntArray.put(R$id.vp_personal_center, 26);
        sparseIntArray.put(R$id.clPublished, 27);
        sparseIntArray.put(R$id.btnPublished, 28);
    }

    public t(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 29, f19321g0, f19322h0));
    }

    public void M(PersonalCenterInfo personalCenterInfo) {
        this.f19320d0 = personalCenterInfo;
        synchronized (this) {
            this.f19324f0 |= 1;
        }
        notifyPropertyChanged(BR.f17728e);
        super.B();
    }

    public void i() {
        long j11;
        String str;
        String str2;
        String str3;
        int i11;
        int i12;
        synchronized (this) {
            j11 = this.f19324f0;
            this.f19324f0 = 0;
        }
        PersonalCenterInfo personalCenterInfo = this.f19320d0;
        int i13 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        String str4 = null;
        if (i13 != 0) {
            int i14 = 0;
            if (personalCenterInfo != null) {
                i14 = personalCenterInfo.getFocusNum();
                int fansNum = personalCenterInfo.getFansNum();
                int dynamicNum = personalCenterInfo.getDynamicNum();
                i12 = fansNum;
                str4 = personalCenterInfo.getNickname();
                i11 = dynamicNum;
            } else {
                i12 = 0;
                i11 = 0;
            }
            str3 = i14 + "";
            str2 = i12 + "";
            str = str4;
            str4 = i11 + "";
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if (i13 != 0) {
            TextViewBindingAdapter.c(this.C, str4);
            TextViewBindingAdapter.c(this.H, str2);
            TextViewBindingAdapter.c(this.I, str3);
            TextViewBindingAdapter.c(this.Y, str);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.f19324f0 != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.f19324f0 = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public t(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[6], objArr[4], objArr[13], objArr[28], objArr[27], objArr[5], objArr[3], objArr[2], objArr[16], objArr[14], objArr[22], objArr[23], objArr[21], objArr[18], objArr[20], objArr[19], objArr[11], objArr[8], objArr[25], objArr[24], objArr[15], objArr[12], objArr[10], objArr[1], objArr[17], objArr[9], objArr[26], objArr[7]);
        this.f19324f0 = -1;
        this.C.setTag((Object) null);
        this.H.setTag((Object) null);
        this.I.setTag((Object) null);
        FrameLayout frameLayout = objArr[0];
        this.f19323e0 = frameLayout;
        frameLayout.setTag((Object) null);
        this.Y.setTag((Object) null);
        G(view);
        t();
    }
}
