package com.business.common.red_packet;

import android.graphics.drawable.Drawable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.request.target.CustomTarget;
import com.business.common.R$string;
import com.business.common.red_packet.dialog.RedPacketTipsDialogFragment;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.hbg.lib.network.hbg.core.bean.RedPacketInfoBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.g;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;
import z9.g1;

@d(c = "com.business.common.red_packet.RedPacketManager$actualRequest$1", f = "RedPacketManager.kt", l = {95}, m = "invokeSuspend")
public final class RedPacketManager$actualRequest$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ String $codeWord;
    public final /* synthetic */ FragmentActivity $context;
    public final /* synthetic */ FragmentManager $manager;
    public int label;

    public static final class a extends CustomTarget<Drawable> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g1 f64340b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RedPacketInfoBean f64341c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FragmentManager f64342d;

        public a(g1 g1Var, RedPacketInfoBean redPacketInfoBean, FragmentManager fragmentManager) {
            this.f64340b = g1Var;
            this.f64341c = redPacketInfoBean;
            this.f64342d = fragmentManager;
        }

        /* renamed from: a */
        public void onResourceReady(Drawable drawable, com.bumptech.glide.request.transition.a<? super Drawable> aVar) {
            this.f64340b.dismiss();
            new RedPacketTipsDialogFragment(this.f64341c).uh(this.f64342d);
        }

        public void onLoadCleared(Drawable drawable) {
        }

        public void onLoadFailed(Drawable drawable) {
            HuobiToastUtil.j(R$string.n_security_network_fail);
            this.f64340b.dismiss();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedPacketManager$actualRequest$1(FragmentActivity fragmentActivity, String str, FragmentManager fragmentManager, c<? super RedPacketManager$actualRequest$1> cVar) {
        super(2, cVar);
        this.$context = fragmentActivity;
        this.$codeWord = str;
        this.$manager = fragmentManager;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RedPacketManager$actualRequest$1(this.$context, this.$codeWord, this.$manager, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((RedPacketManager$actualRequest$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            CoroutineDispatcher b11 = v0.b();
            RedPacketManager$actualRequest$1$result$1 redPacketManager$actualRequest$1$result$1 = new RedPacketManager$actualRequest$1$result$1(this.$codeWord, (c<? super RedPacketManager$actualRequest$1$result$1>) null);
            this.label = 1;
            obj = g.g(b11, redPacketManager$actualRequest$1$result$1, this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        com.hbg.module.libkt.base.ext.g gVar = (com.hbg.module.libkt.base.ext.g) obj;
        if (gVar instanceof g.b) {
            RedPacketInfoBean redPacketInfoBean = (RedPacketInfoBean) ((g.b) gVar).a();
            if (redPacketInfoBean != null) {
                g1 g1Var = new g1(this.$context);
                g1Var.show();
                g1Var.setCanceledOnTouchOutside(true);
                g1Var.setCancelable(true);
                String wholeUrl = redPacketInfoBean.getWholeUrl();
                if (wholeUrl == null) {
                    wholeUrl = "";
                }
                com.bumptech.glide.a.y(this.$context).q(wholeUrl).A0(new a(g1Var, redPacketInfoBean, this.$manager));
            } else {
                LogAndWoodRecorder.a("RedPacket", "actualRequest-Data is null");
            }
        } else if (gVar instanceof g.a) {
            g.a aVar = (g.a) gVar;
            APIStatusErrorException a11 = aVar.a();
            if (a11 != null) {
                HuobiToastUtil.m(a11.getErrMsg());
                LogAndWoodRecorder.a("RedPacket", "actualRequest-APIError(Code:" + a11.getErrCode() + ",Msg:" + a11.getErrMsg() + ')');
            }
            Throwable b12 = aVar.b();
            if (b12 != null) {
                HuobiToastUtil.j(R$string.n_service_error);
                LogAndWoodRecorder.a("RedPacket", "actualRequest-OtherError(Msg:" + b12.getMessage() + ')');
            }
        }
        return Unit.f56620a;
    }
}
