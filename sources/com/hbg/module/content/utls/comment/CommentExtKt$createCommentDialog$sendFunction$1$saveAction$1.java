package com.hbg.module.content.utls.comment;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.lib.network.hbg.core.bean.CommentSaveBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import d10.l;
import d10.p;
import d10.u;
import i6.d;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import rc.a;
import v7.b;

public final class CommentExtKt$createCommentDialog$sendFunction$1$saveAction$1 extends Lambda implements u<String, String, String, String, String, String, String, Unit> {
    public final /* synthetic */ Dialog $dialog;
    public final /* synthetic */ a $listener;
    public final /* synthetic */ FragmentActivity $this_createCommentDialog;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentExtKt$createCommentDialog$sendFunction$1$saveAction$1(Dialog dialog, FragmentActivity fragmentActivity, a aVar) {
        super(7);
        this.$dialog = dialog;
        this.$this_createCommentDialog = fragmentActivity;
        this.$listener = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        invoke((String) obj, (String) obj2, (String) obj3, (String) obj4, (String) obj5, (String) obj6, (String) obj7);
        return Unit.f56620a;
    }

    public final void invoke(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        d9.a<CommentSaveBean> i02 = b.a().i0(str, str2, str3, str4, str5, str6, str7);
        final Dialog dialog = this.$dialog;
        final FragmentActivity fragmentActivity = this.$this_createCommentDialog;
        final a aVar = this.$listener;
        AnonymousClass1 r102 = new l<CommentSaveBean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CommentSaveBean) obj);
                return Unit.f56620a;
            }

            public final void invoke(CommentSaveBean commentSaveBean) {
                dialog.dismiss();
                d.c("SendComment", "commentSave :onSuccess");
                com.hbg.module.libkt.base.ext.b.v(fragmentActivity);
                if (commentSaveBean != null) {
                    CommentInfo commentInfo = new CommentInfo();
                    commentInfo.f70229id = commentSaveBean.f70230id;
                    commentInfo.content = commentSaveBean.content;
                    commentInfo.fromNickname = commentSaveBean.fromNickname;
                    commentInfo.fromUniqueUid = commentSaveBean.fromUniqueUid;
                    commentInfo.fromAvatar = commentSaveBean.fromAvatar;
                    commentInfo.selfComment = 1;
                    commentInfo.isAuthor = commentSaveBean.isAuthor;
                    commentInfo.createTime = commentSaveBean.createTime;
                    commentInfo.hasImg = commentSaveBean.hasImg;
                    commentInfo.imgList = commentSaveBean.imgList;
                    commentInfo.fromUcExtInfo = commentSaveBean.ucExtInfo;
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(commentInfo, commentSaveBean.commentNum);
                        return;
                    }
                    return;
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    a.C0133a.a(aVar2, (CommentInfo) null, 0, 2, (Object) null);
                }
            }
        };
        final a aVar2 = this.$listener;
        RequestExtKt.d(i02, r102, new p<Throwable, APIStatusErrorException, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Throwable) obj, (APIStatusErrorException) obj2);
                return Unit.f56620a;
            }

            public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
                d.c("SendComment", "commentSave :onError");
                if (aPIStatusErrorException != null) {
                    HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
                }
                a aVar = aVar2;
                if (aVar != null) {
                    a.C0133a.a(aVar, (CommentInfo) null, 0, 2, (Object) null);
                }
            }
        }, (MutableLiveData) null, 4, (Object) null);
    }
}
