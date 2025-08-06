package com.business.common.airdrop.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.business.common.R$drawable;
import com.business.common.R$id;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.business.common.airdrop.dialog.AirdropResultDialogFragment$onCreateView$1$4$1$1", f = "AirdropResultDialogFragment.kt", l = {123}, m = "invokeSuspend")
public final class AirdropResultDialogFragment$onCreateView$1$4$1$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ View $shareView;
    public final /* synthetic */ FragmentActivity $this_run;
    public int label;
    public final /* synthetic */ AirdropResultDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirdropResultDialogFragment$onCreateView$1$4$1$1(View view, AirdropResultDialogFragment airdropResultDialogFragment, FragmentActivity fragmentActivity, c<? super AirdropResultDialogFragment$onCreateView$1$4$1$1> cVar) {
        super(2, cVar);
        this.$shareView = view;
        this.this$0 = airdropResultDialogFragment;
        this.$this_run = fragmentActivity;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new AirdropResultDialogFragment$onCreateView$1$4$1$1(this.$shareView, this.this$0, this.$this_run, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((AirdropResultDialogFragment$onCreateView$1$4$1$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        String str = null;
        if (i11 == 0) {
            k.b(obj);
            b.J((ImageView) this.$shareView.findViewById(R$id.ivAvatar), BaseModuleConfig.a().getAvatar());
            ((TextView) this.$shareView.findViewById(R$id.tvNickname)).setText(BaseModuleConfig.a().j0());
            ImageView imageView = (ImageView) this.$shareView.findViewById(R$id.ivBg);
            AirdropMaterialBean material = this.this$0.f64286b.getMaterial();
            String shareImageUrl = material != null ? material.getShareImageUrl() : null;
            int i12 = R$drawable.bg_share_airdrop_default;
            this.label = 1;
            if (b.I(imageView, shareImageUrl, i12, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        HbgBaseShareProvider vh2 = this.this$0.vh();
        if (vh2 != null) {
            FragmentActivity fragmentActivity = this.$this_run;
            View view = this.$shareView;
            int d12 = com.hbg.module.libkt.base.ext.c.d(a.b(275.0f));
            int d13 = com.hbg.module.libkt.base.ext.c.d(a.b(420.0f));
            AirdropMaterialBean material2 = this.this$0.f64286b.getMaterial();
            String shareUrl = material2 != null ? material2.getShareUrl() : null;
            AirdropMaterialBean material3 = this.this$0.f64286b.getMaterial();
            if (material3 != null) {
                str = material3.getShareText();
            }
            vh2.k(fragmentActivity, view, d12, d13, shareUrl, str, "community_airdrop");
        }
        return Unit.f56620a;
    }
}
