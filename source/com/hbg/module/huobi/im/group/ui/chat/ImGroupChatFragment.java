package com.hbg.module.huobi.im.group.ui.chat;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.google.gson.Gson;
import com.hbg.lib.network.hbg.core.bean.GroupInfoData;
import com.hbg.lib.network.hbg.core.bean.GroupUserListData;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.R$style;
import com.hbg.module.huobi.im.group.bean.GroupNoticeListEntity;
import com.hbg.module.huobi.im.group.bean.HbImageMessageBean;
import com.hbg.module.huobi.im.group.bean.HbSoundMessageBean;
import com.hbg.module.huobi.im.group.bean.HbTextMessageBean;
import com.hbg.module.huobi.im.group.bean.LiveGroupBean;
import com.hbg.module.huobi.im.group.bean.OberverData;
import com.hbg.module.huobi.im.group.bean.UserStatusEntity;
import com.hbg.module.huobi.im.group.ui.adapter.n;
import com.hbg.module.huobi.im.observer.ImObserverHelper;
import com.hbg.module.huobi.im.utils.DateUtils;
import com.hbg.module.huobi.im.utils.HbGroupUserManager;
import com.hbg.module.huobi.im.utils.LiveState;
import com.hbg.module.huobi.im.utils.MessageBusinessID;
import com.hbg.module.huobi.im.view.AvatarView;
import com.huobi.utils.StatusBarUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;
import com.tencent.qcloud.tuikit.tuichat.BusinessCallbacks;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.HbNoticeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.tencent.qcloud.tuikit.tuichat.manager.HbGroupChatManager;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import dd.a;
import i6.d;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import ld.e;
import ld.f;
import nd.b;
import rd.c;
import z9.g1;

public class ImGroupChatFragment extends TUIBaseChatFragment implements e, Observer {
    /* access modifiers changed from: private */
    public static final String TAG = ImGroupChatFragment.class.getSimpleName();
    /* access modifiers changed from: private */
    public HbGroupChatManager groupChatManager = HbGroupChatManager.getInstance();
    private BusinessCallbacks.ImGroupMessageListener groupCustomMessage;
    /* access modifiers changed from: private */
    public GroupInfo groupInfo;
    /* access modifiers changed from: private */
    public LiveGroupBean liveGroupBean;
    /* access modifiers changed from: private */
    public f liveImPresenter = new f(this);
    private Handler mHandler;
    private g1 mLoadingDialog;
    /* access modifiers changed from: private */
    public n mNoticeAdapter;
    /* access modifiers changed from: private */
    public GroupNoticeListEntity noticeListEntity;
    private TextView tvPrimeTips;
    /* access modifiers changed from: private */
    public View vLiveFloat;
    /* access modifiers changed from: private */
    public View vLiveFloatMini;
    /* access modifiers changed from: private */
    public View vNotice;
    private ViewPager viewPager;

    /* access modifiers changed from: private */
    public void dismissLoading() {
        this.mHandler.post(new x(this));
    }

    /* access modifiers changed from: private */
    public void forbidUser(String str, final boolean z11) {
        GroupInfo groupInfo2 = this.groupInfo;
        if (groupInfo2 != null) {
            this.liveImPresenter.f(groupInfo2.getId(), str, z11, new a() {
                public void onFailed(int i11, String str) {
                    ToastUtil.toastShortMessage(ImGroupChatFragment.this.getString(R$string.n_im_forbin_fail));
                }

                public void onSuccess() {
                    if (z11) {
                        ToastUtil.toastShortMessage(ImGroupChatFragment.this.getString(R$string.n_im_forbin_send_canceled));
                    } else {
                        ToastUtil.toastShortMessage(ImGroupChatFragment.this.getString(R$string.n_im_forbin_send_success));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void getForbidStatus(final TUIMessageBean tUIMessageBean) {
        this.liveImPresenter.p(this.groupInfo.getId(), tUIMessageBean.getSender(), "1", new kd.a<UserStatusEntity>() {
            public void onFailed(int i11, String str) {
                String access$000 = ImGroupChatFragment.TAG;
                TUIChatLog.d(access$000, "getForbidStatus is error code:" + i11 + " message:" + str);
            }

            public void onSuccess(UserStatusEntity userStatusEntity) {
                if (ImGroupChatFragment.this.getActivity() != null && !ImGroupChatFragment.this.getActivity().isFinishing() && !ImGroupChatFragment.this.isDetached()) {
                    ImGroupChatFragment.this.showBottomDialog(tUIMessageBean, userStatusEntity);
                }
            }
        });
    }

    private void initNoticeView() {
        this.vNotice = this.baseView.findViewById(R$id.layout_notice);
        this.viewPager = (ViewPager) this.baseView.findViewById(R$id.vp_notice);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ScreenUtil.dip2px(60.0f));
        int dip2px = ScreenUtil.dip2px(15.0f);
        layoutParams.setMargins(dip2px, StatusBarUtils.a(requireContext()) + ScreenUtil.dip2px(20.0f), dip2px, 0);
        this.viewPager.setLayoutParams(layoutParams);
        this.viewPager.setPageMargin(ScreenUtil.dip2px(8.0f));
        n nVar = new n(getContext());
        this.mNoticeAdapter = nVar;
        this.viewPager.setAdapter(nVar);
        this.viewPager.setOffscreenPageLimit(5);
        this.viewPager.setCurrentItem(0);
        this.mNoticeAdapter.i(new n.e() {
            public void onItemChangeListener(int i11) {
                ImGroupChatFragment imGroupChatFragment = ImGroupChatFragment.this;
                boolean z11 = true;
                if (i11 != 1) {
                    z11 = false;
                }
                imGroupChatFragment.changeViewPagerLayoutParams(z11);
            }
        });
    }

    private void jump2Detail(int i11, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("liveStatus", i11);
        bundle.putString("liveId", str);
        HbgRouter.i(getActivity(), "/live/room", bundle);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$dismissLoading$1() {
        g1 g1Var;
        if (getActivity() != null && !getActivity().isFinishing() && (g1Var = this.mLoadingDialog) != null && g1Var.isShowing()) {
            this.mLoadingDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$showBottomDialog$2(Dialog dialog, final TUIMessageBean tUIMessageBean, View view) {
        dialog.dismiss();
        new b(getContext()).a().c(true).b(true).j(20.0f).d(getContext().getString(R$string.n_im_clear_msg_sure)).e(0.75f).h(getContext().getString(R$string.n_sure), new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ImGroupChatFragment.this.liveImPresenter.x(tUIMessageBean.getGroupId(), tUIMessageBean.getSender(), new kd.a<Object>() {
                    public void onFailed(int i11, String str) {
                    }

                    public void onSuccess(Object obj) {
                    }
                });
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }).g(getContext().getString(R$string.n_cancel), new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }).k();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$showBottomDialog$3(Dialog dialog, final boolean z11, final TUIMessageBean tUIMessageBean, View view) {
        String str;
        dialog.dismiss();
        b j11 = new b(getContext()).a().c(true).b(true).j(20.0f);
        if (z11) {
            str = getContext().getString(R$string.n_im_cancel_manager_sure);
        } else {
            str = getContext().getString(R$string.n_im_set_manager_sure);
        }
        j11.d(str).e(0.75f).h(getContext().getString(R$string.n_sure), new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ImGroupChatFragment.this.liveImPresenter.B(tUIMessageBean.getGroupId(), tUIMessageBean.getSender(), z11 ? "0" : "1", new kd.a<Object>() {
                    public void onFailed(int i11, String str) {
                        ToastUtil.toastShortMessage(ImGroupChatFragment.this.getContext().getString(R$string.n_im_operation_fail));
                    }

                    public void onSuccess(Object obj) {
                        String str;
                        HbGroupUserManager.c().f();
                        HbGroupUserManager.c().b(tUIMessageBean.getGroupId(), new kd.a<GroupUserListData>() {
                            public void onFailed(int i11, String str) {
                            }

                            public void onSuccess(GroupUserListData groupUserListData) {
                                HbChatMessageAdapter hbChatMessageAdapter;
                                ChatView chatView = ImGroupChatFragment.this.chatView;
                                if (chatView != null && (hbChatMessageAdapter = chatView.mAdapter) != null) {
                                    hbChatMessageAdapter.notifyDataSetChanged();
                                }
                            }
                        });
                        AnonymousClass14 r32 = AnonymousClass14.this;
                        if (z11) {
                            str = ImGroupChatFragment.this.getContext().getString(R$string.n_im_cancel_manager_success);
                        } else {
                            str = ImGroupChatFragment.this.getContext().getString(R$string.n_im_set_manager_success);
                        }
                        ToastUtil.toastShortMessage(str);
                    }
                });
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }).g(getContext().getString(R$string.n_cancel), new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }).k();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$showGroupLiveFloatView$4(View view) {
        md.a aVar = md.a.f22950a;
        if (aVar.h() != null) {
            aVar.h().a(String.valueOf(this.liveGroupBean.getId()));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$showGroupLiveFloatView$5(View view) {
        this.liveImPresenter.c(String.valueOf(this.liveGroupBean.getId()));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$showGroupLiveFloatView$6(View view) {
        if (this.liveGroupBean.getAppointed().intValue() == 0) {
            this.liveImPresenter.v(String.valueOf(this.liveGroupBean.getId()));
        } else {
            new b(getContext()).a().c(true).b(true).j(20.0f).d(getString(R$string.n_live_cancel_prepare_hint_dialog)).e(0.75f).h(getContext().getString(R$string.n_sure), new u(this)).g(getContext().getString(R$string.n_cancel), new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            }).k();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoading$0() {
        if (this.mLoadingDialog == null) {
            this.mLoadingDialog = new g1(requireContext());
        }
        this.mLoadingDialog.show();
        this.mLoadingDialog.setCanceledOnTouchOutside(true);
        this.mLoadingDialog.setCancelable(true);
    }

    private void loadNoticeData() {
        GroupInfo groupInfo2 = this.groupInfo;
        if (groupInfo2 != null) {
            this.liveImPresenter.j(groupInfo2.getId(), new kd.a<GroupNoticeListEntity>() {
                public void onFailed(int i11, String str) {
                }

                public void onSuccess(GroupNoticeListEntity groupNoticeListEntity) {
                    GroupNoticeListEntity unused = ImGroupChatFragment.this.noticeListEntity = groupNoticeListEntity;
                    if (ImGroupChatFragment.this.noticeListEntity != null && ImGroupChatFragment.this.noticeListEntity.getListData() != null && ImGroupChatFragment.this.noticeListEntity.getListData().size() > 0) {
                        boolean z11 = false;
                        ImGroupChatFragment.this.vNotice.setVisibility(0);
                        ImGroupChatFragment.this.mNoticeAdapter.h(ImGroupChatFragment.this.noticeListEntity.getListData());
                        ImGroupChatFragment imGroupChatFragment = ImGroupChatFragment.this;
                        if (imGroupChatFragment.noticeListEntity.getListData().size() == 1) {
                            z11 = true;
                        }
                        imGroupChatFragment.changeViewPagerLayoutParams(z11);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void showBottomDialog(final TUIMessageBean tUIMessageBean, final UserStatusEntity userStatusEntity) {
        String str;
        if (!tUIMessageBean.isSelf()) {
            final Dialog dialog = new Dialog(getContext(), R$style.BottomDialog);
            dialog.setContentView(View.inflate(getContext(), R$layout.member_restrict_dialog, (ViewGroup) null));
            Window window = dialog.getWindow();
            window.setGravity(80);
            window.setWindowAnimations(R$style.BottomDialog_Animation);
            window.setLayout(-1, -2);
            dialog.show();
            TextView textView = (TextView) dialog.findViewById(R$id.tv_at_user);
            if (tUIMessageBean.getV2TIMMessage() != null) {
                final String sender = tUIMessageBean.getV2TIMMessage().getSender();
                final String nickName = tUIMessageBean.getV2TIMMessage().getNickName();
                String str2 = TextUtils.isEmpty(nickName) ? sender : nickName;
                textView.setText(TIMMentionEditText.TIM_MENTION_TAG + str2);
                textView.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        dialog.dismiss();
                        ImGroupChatFragment.this.chatView.getInputLayout().addInputText(nickName, sender);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
            }
            if (userStatusEntity.getSpeaker().intValue() == 0) {
                TextView textView2 = (TextView) dialog.findViewById(R$id.tv_member_mute);
                textView2.setText(getString(userStatusEntity.getForbid().intValue() == 1 ? R$string.n_im_forbin_send_cancel : R$string.n_im_forbin_send));
                textView2.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        dialog.dismiss();
                        if (userStatusEntity.getForbid().intValue() == 1) {
                            ImGroupChatFragment.this.forbidUser(tUIMessageBean.getSender(), true);
                        } else {
                            new b(ImGroupChatFragment.this.getContext()).a().c(true).b(true).j(20.0f).d(ImGroupChatFragment.this.getString(R$string.n_im_forbin_user_hint)).e(0.75f).h(ImGroupChatFragment.this.getContext().getString(R$string.n_sure), new View.OnClickListener() {
                                @SensorsDataInstrumented
                                public void onClick(View view) {
                                    AnonymousClass8 r02 = AnonymousClass8.this;
                                    ImGroupChatFragment.this.forbidUser(tUIMessageBean.getSender(), false);
                                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                                }
                            }).g(ImGroupChatFragment.this.getContext().getString(R$string.n_cancel), new View.OnClickListener() {
                                @SensorsDataInstrumented
                                public void onClick(View view) {
                                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                                }
                            }).k();
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
                dialog.findViewById(R$id.tv_member_block).setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        dialog.dismiss();
                        new b(ImGroupChatFragment.this.getContext()).a().c(true).b(true).j(20.0f).d(ImGroupChatFragment.this.getString(R$string.n_im_block_user_hint)).e(0.75f).h(ImGroupChatFragment.this.getContext().getString(R$string.n_sure), new View.OnClickListener() {
                            @SensorsDataInstrumented
                            public void onClick(View view) {
                                ImGroupChatFragment.this.liveImPresenter.b(tUIMessageBean.getGroupId(), tUIMessageBean.getSender(), new a() {
                                    public void onFailed(int i11, String str) {
                                        ToastUtil.toastShortMessage(ImGroupChatFragment.this.getString(R$string.n_im_block_user_failed));
                                    }

                                    public void onSuccess() {
                                        ToastUtil.toastShortMessage(ImGroupChatFragment.this.getString(R$string.n_im_block_user_success));
                                    }
                                });
                                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            }
                        }).g(ImGroupChatFragment.this.getContext().getString(R$string.n_cancel), new View.OnClickListener() {
                            @SensorsDataInstrumented
                            public void onClick(View view) {
                                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            }
                        }).k();
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
                dialog.findViewById(R$id.tv_member_kick).setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        dialog.dismiss();
                        new b(ImGroupChatFragment.this.getContext()).a().c(true).b(true).j(20.0f).d(ImGroupChatFragment.this.getString(R$string.n_im_kick_user_hint)).e(0.75f).h(ImGroupChatFragment.this.getContext().getString(R$string.n_sure), new View.OnClickListener() {
                            @SensorsDataInstrumented
                            public void onClick(View view) {
                                ImGroupChatFragment.this.liveImPresenter.y(tUIMessageBean.getGroupId(), tUIMessageBean.getSender(), new a() {
                                    public void onFailed(int i11, String str) {
                                        ToastUtil.toastShortMessage(ImGroupChatFragment.this.getString(R$string.n_im_kick_fail));
                                    }

                                    public void onSuccess() {
                                        ToastUtil.toastShortMessage(ImGroupChatFragment.this.getString(R$string.n_im_kick_success));
                                    }
                                });
                                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            }
                        }).g(ImGroupChatFragment.this.getContext().getString(R$string.n_cancel), new View.OnClickListener() {
                            @SensorsDataInstrumented
                            public void onClick(View view) {
                                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            }
                        }).k();
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
                ((TextView) dialog.findViewById(R$id.tv_member_clear_message)).setOnClickListener(new v(this, dialog, tUIMessageBean));
                TextView textView3 = (TextView) dialog.findViewById(R$id.tv_member_set_manager);
                boolean d11 = HbGroupUserManager.c().d(tUIMessageBean.getSender());
                String str3 = TAG;
                TUIChatLog.i(str3, "showBottomDialog: 当前消息用户是否是管理员 isManager： " + d11);
                if (d11) {
                    str = getContext().getString(R$string.n_im_cancel_manager);
                } else {
                    str = getContext().getString(R$string.n_im_set_manager);
                }
                textView3.setText(str);
                textView3.setOnClickListener(new w(this, dialog, d11, tUIMessageBean));
            } else {
                dialog.findViewById(R$id.tv_member_mute).setVisibility(8);
                dialog.findViewById(R$id.v_member_mute).setVisibility(8);
                dialog.findViewById(R$id.tv_member_block).setVisibility(8);
                dialog.findViewById(R$id.v_member_block).setVisibility(8);
                dialog.findViewById(R$id.tv_member_kick).setVisibility(8);
                dialog.findViewById(R$id.v_member_kick).setVisibility(8);
                dialog.findViewById(R$id.tv_member_clear_message).setVisibility(8);
                dialog.findViewById(R$id.v_member_clear_message).setVisibility(8);
                dialog.findViewById(R$id.tv_member_set_manager).setVisibility(8);
            }
            dialog.findViewById(R$id.tv_cancel).setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    dialog.dismiss();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void showLoading() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        this.mHandler.post(new y(this));
    }

    public void changeViewPagerLayoutParams(boolean z11) {
        if (this.viewPager == null) {
            this.viewPager = (ViewPager) this.baseView.findViewById(R$id.vp_notice);
        }
        int dip2px = ScreenUtil.dip2px(15.0f);
        if (z11) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ScreenUtil.dip2px(60.0f));
            layoutParams.setMargins(dip2px, StatusBarUtils.a(requireContext()) + ScreenUtil.dip2px(20.0f), dip2px, 0);
            this.viewPager.setLayoutParams(layoutParams);
            this.viewPager.setPageMargin(ScreenUtil.dip2px(0.0f));
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, ScreenUtil.dip2px(60.0f));
        layoutParams2.setMargins(dip2px, StatusBarUtils.a(requireContext()) + ScreenUtil.dip2px(20.0f), ScreenUtil.dip2px(28.0f), 0);
        this.viewPager.setLayoutParams(layoutParams2);
        this.viewPager.setPageMargin(ScreenUtil.dip2px(8.0f));
    }

    public ChatInfo getChatInfo() {
        return this.groupInfo;
    }

    public void initView() {
        super.initView();
        initNoticeView();
        loadNoticeData();
        this.chatView.setChatManager(this.groupChatManager);
        this.chatView.setImGroupChatFragment(this);
        this.groupChatManager.setGroupInfo(this.groupInfo);
        this.chatView.setChatInfo(this.groupInfo);
        this.chatView.getMessageLayout().setOnItemClickListener(new OnItemClickListener() {
            public void onMessageLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                ImGroupChatFragment.this.chatView.showItemPopMenu(view, i11, tUIMessageBean);
            }

            public void onReEditRevokeMessage(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null) {
                    int msgType = tUIMessageBean.getMsgType();
                    if (msgType == 1) {
                        ImGroupChatFragment.this.chatView.getInputLayout().appendText(tUIMessageBean.getV2TIMMessage().getTextElem().getText());
                        return;
                    }
                    String access$000 = ImGroupChatFragment.TAG;
                    TUIChatLog.e(access$000, "error type: " + msgType);
                }
            }

            public void onRecallClick(View view, int i11, TUIMessageBean tUIMessageBean) {
            }

            public void onTextSelected(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean instanceof TextMessageBean) {
                    String access$000 = ImGroupChatFragment.TAG;
                    TUIChatLog.d(access$000, "chatfragment onTextSelected selectedText = " + ((TextMessageBean) tUIMessageBean).getSelectText());
                }
                ImGroupChatFragment.this.chatView.getMessageLayout().setSelectedPosition(i11);
                ImGroupChatFragment.this.chatView.showItemPopMenu(view, i11, tUIMessageBean);
            }

            public void onUserIconClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null && !(tUIMessageBean instanceof HbNoticeMessageBean) && !tUIMessageBean.isSelf()) {
                    ImGroupChatFragment.this.showLoading();
                    ImGroupChatFragment.this.liveImPresenter.n(tUIMessageBean.getSender(), new kd.a<PersonalCenterInfo>() {
                        public void onFailed(int i11, String str) {
                            ImGroupChatFragment.this.dismissLoading();
                            HuobiToastUtil.i(ImGroupChatFragment.this.requireContext().getResources().getString(R$string.n_service_error));
                        }

                        public void onSuccess(PersonalCenterInfo personalCenterInfo) {
                            ImGroupChatFragment.this.dismissLoading();
                            b2.a.d().a("/content/PersonalCenter").withString("uidUnique", personalCenterInfo.getUidUnique()).navigation();
                        }
                    });
                }
            }

            public void onUserIconLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null && !(tUIMessageBean instanceof HbNoticeMessageBean)) {
                    new ChatInfo().setId(tUIMessageBean.getSender());
                    if (tUIMessageBean.isSelf() || (!ImGroupChatFragment.this.groupInfo.isOwner() && !ImGroupChatFragment.this.groupChatManager.isGroupAdmin(V2TIMManager.getInstance().getLoginUser()))) {
                        String sender = tUIMessageBean.getV2TIMMessage().getSender();
                        ImGroupChatFragment.this.chatView.getInputLayout().addInputText(tUIMessageBean.getV2TIMMessage().getNickName(), sender);
                        return;
                    }
                    ImGroupChatFragment.this.getForbidStatus(tUIMessageBean);
                }
            }
        });
        this.liveImPresenter.k(this.groupInfo.getId());
    }

    public void onChatSessionRemoveChange() {
        GroupInfo groupInfo2;
        ChatView chatView = this.chatView;
        if (chatView != null && (groupInfo2 = this.groupInfo) != null) {
            chatView.setChatInfo(groupInfo2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "oncreate view " + this);
        this.groupChatManager.initListener();
        ChatMessageParser.putCustomMessageType(1, HbTextMessageBean.class);
        ChatMessageParser.putCustomMessageType(3, HbImageMessageBean.class);
        ChatMessageParser.putCustomMessageType(4, HbSoundMessageBean.class);
        this.baseView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return this.baseView;
        }
        GroupInfo groupInfo2 = (GroupInfo) arguments.getSerializable(TUIChatConstants.CHAT_INFO);
        this.groupInfo = groupInfo2;
        this.groupChatManager.getGroupAdminMemberList(groupInfo2.getId());
        if (this.groupInfo == null) {
            return this.baseView;
        }
        AnonymousClass1 r42 = new BusinessCallbacks.ImGroupMessageListener() {
            public void onGroupMemberKick() {
                if (com.hbg.module.libkt.base.ext.b.e(ImGroupChatFragment.this.getActivity())) {
                    ImGroupChatFragment.this.getActivity().finish();
                    ToastUtil.toastShortMessage(ImGroupChatFragment.this.getString(R$string.n_im_kick_out));
                }
            }

            public void onGroupReceiveCustomMsg(TUIMessageBean tUIMessageBean) {
                String str = new String(tUIMessageBean.getV2TIMMessage().getCustomElem().getData());
                if (TextUtils.isEmpty(str)) {
                    Log.d(ImGroupChatFragment.TAG, "onRecvGroupCustomMessage customData is empty");
                    return;
                }
                try {
                    TUIBarrageMessage tUIBarrageMessage = (TUIBarrageMessage) new Gson().fromJson(str, TUIBarrageMessage.class);
                    tUIBarrageMessage.sender = tUIMessageBean.getSender();
                    tUIBarrageMessage.sendTime = tUIMessageBean.getV2TIMMessage().getTimestamp();
                    tUIBarrageMessage.v2TIMMessage = tUIMessageBean.getV2TIMMessage();
                    if (TextUtils.equals(tUIBarrageMessage.businessID, MessageBusinessID.MSG_BUSINESS_ID_LIVE_KICK.getValue()) && com.hbg.module.libkt.base.ext.b.e(ImGroupChatFragment.this.getActivity())) {
                        ImGroupChatFragment.this.getActivity().finish();
                        ToastUtil.toastShortMessage(ImGroupChatFragment.this.getString(R$string.n_im_kick_out));
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    Log.e(ImGroupChatFragment.TAG, "protocol version is not match, ignore msg");
                }
            }
        };
        this.groupCustomMessage = r42;
        this.groupChatManager.addImGroupMessageListener(r42);
        initView();
        return this.baseView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ImObserverHelper.b().deleteObserver(this);
    }

    public void onResume() {
        super.onResume();
        updateNoticeView();
    }

    public void onStart() {
        super.onStart();
        ImObserverHelper.b().addObserver(this);
    }

    public void setGroupChatManager(HbGroupChatManager hbGroupChatManager) {
        this.groupChatManager = hbGroupChatManager;
    }

    public void showGroupLiveFloatView(final LiveGroupBean liveGroupBean2) {
        HbChatMessageAdapter hbChatMessageAdapter;
        this.liveGroupBean = liveGroupBean2;
        HbGroupUserManager.c().h(liveGroupBean2);
        this.vLiveFloat = this.baseView.findViewById(R$id.layoutGroupFloat);
        this.vLiveFloatMini = this.baseView.findViewById(R$id.layoutGroupFloatMini);
        List<LiveGroupBean.Speaker> speakerList = liveGroupBean2.getSpeakerList();
        LiveGroupBean.Speaker speaker = (speakerList == null || speakerList.size() <= 0) ? null : speakerList.get(0);
        if (liveGroupBean2.getId() != null && speaker != null && speaker.getNickname() != null && liveGroupBean2.getStatus().intValue() != LiveState.PLAYBACK.getValue()) {
            speaker.getNickname();
            ChatView chatView = this.chatView;
            if (!(chatView == null || (hbChatMessageAdapter = chatView.mAdapter) == null)) {
                hbChatMessageAdapter.notifyDataSetChanged();
            }
            this.vLiveFloat.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    md.a aVar = md.a.f22950a;
                    if (aVar.h() != null) {
                        aVar.h().a(String.valueOf(ImGroupChatFragment.this.liveGroupBean.getId()));
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            AvatarView avatarView = (AvatarView) this.vLiveFloat.findViewById(R$id.ivGroupLiveHead);
            int intValue = liveGroupBean2.getStatus().intValue();
            LiveState liveState = LiveState.LIVING;
            avatarView.s(intValue == liveState.getValue() ? 1 : 0, -1, "", speaker.getShowId(), String.valueOf(liveGroupBean2.getId()), 0).w(speaker.getAvatar(), R$drawable.icon_community_user_header);
            this.vLiveFloat.findViewById(R$id.ivGroupLiveClose).setOnClickListener(new View.OnClickListener() {
                /* access modifiers changed from: private */
                @SensorsDataInstrumented
                public /* synthetic */ void lambda$onClick$0(View view) {
                    ImGroupChatFragment.this.vLiveFloat.setVisibility(0);
                    ImGroupChatFragment.this.vLiveFloatMini.setVisibility(8);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }

                @SensorsDataInstrumented
                public void onClick(View view) {
                    ImGroupChatFragment.this.vLiveFloat.setVisibility(8);
                    ImGroupChatFragment.this.vLiveFloatMini.setVisibility(0);
                    TextView textView = (TextView) ImGroupChatFragment.this.vLiveFloatMini.findViewById(R$id.tvGroupLiveState);
                    SafeLottieView safeLottieView = (SafeLottieView) ImGroupChatFragment.this.vLiveFloatMini.findViewById(R$id.lottieGroupLiveMini);
                    ImageView imageView = (ImageView) ImGroupChatFragment.this.vLiveFloatMini.findViewById(R$id.ivGroupLiveMini);
                    if (liveGroupBean2.getStatus().intValue() == LiveState.LIVING.getValue()) {
                        textView.setText(ImGroupChatFragment.this.getString(R$string.n_live_living));
                        imageView.setVisibility(4);
                        safeLottieView.setVisibility(0);
                    } else {
                        textView.setText(ImGroupChatFragment.this.getString(R$string.n_live_appoint));
                        imageView.setVisibility(0);
                        safeLottieView.setVisibility(4);
                    }
                    ImGroupChatFragment.this.vLiveFloatMini.setOnClickListener(new z(this));
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            ((TextView) this.vLiveFloat.findViewById(R$id.tvGroupLiveTitle)).setText(liveGroupBean2.getTitle());
            View findViewById = this.vLiveFloat.findViewById(R$id.groupHeadLiving);
            TextView textView = (TextView) this.vLiveFloat.findViewById(R$id.tvGroupLiveTips);
            TextView textView2 = (TextView) this.vLiveFloat.findViewById(R$id.tvGroupLiveGoto);
            if (liveGroupBean2.getStatus().intValue() == liveState.getValue()) {
                findViewById.setVisibility(0);
                textView.setText(getString(R$string.n_live_living));
                textView2.setBackgroundResource(R$drawable.im_bg_live_float_goto);
                textView2.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
                textView2.setText(getString(R$string.n_live_look_live));
                textView2.setOnClickListener(new t(this));
            } else {
                findViewById.setVisibility(8);
                if (liveGroupBean2.getStartTime() != null) {
                    String b11 = DateUtils.b(requireContext(), liveGroupBean2.getStartTime().longValue(), false);
                    textView.setText(b11 + getString(R$string.n_live_start_playing));
                }
                if (liveGroupBean2.getAppointed().intValue() == 0) {
                    textView2.setText(getString(R$string.n_live_make_appointment));
                    textView2.setTextColor(getResources().getColor(R$color.baseColorShadeButtonGreenStart));
                    textView2.setBackgroundResource(R$drawable.im_bg_live_float_regist);
                } else {
                    textView2.setText(getString(R$string.n_live_already_appointment));
                    textView2.setTextColor(getResources().getColor(R$color.im_color_group_live_float_title));
                    textView2.setBackgroundResource(R$drawable.im_bg_goto_live);
                }
                textView2.setOnClickListener(new s(this));
            }
            this.vLiveFloat.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, StatusBarUtils.a(requireContext()) + ScreenUtil.dip2px(20.0f), 0, 0);
            this.vLiveFloat.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, StatusBarUtils.a(requireContext()) + ScreenUtil.dip2px(20.0f), 0, 0);
            layoutParams2.addRule(14);
            this.vLiveFloatMini.setLayoutParams(layoutParams2);
        }
    }

    public void update(Observable observable, Object obj) {
        if ((obj instanceof OberverData) && ((OberverData) obj).getType() == 1) {
            d.j(TAG, "Observable 刷新顶部公告数据");
            loadNoticeData();
        }
    }

    public void updateCancelLiveAppointment() {
        TextView textView = (TextView) this.vLiveFloat.findViewById(R$id.tvGroupLiveGoto);
        textView.setText(getString(R$string.n_live_make_appointment));
        textView.setTextColor(getResources().getColor(R$color.baseColorShadeButtonGreenStart));
        textView.setBackgroundResource(R$drawable.im_bg_live_float_regist);
        this.liveGroupBean.setAppointed(0);
        ToastUtil.toastShortMessage(getString(R$string.n_live_cancel_success));
    }

    public void updateLiveAppointment() {
        TextView textView = (TextView) this.vLiveFloat.findViewById(R$id.tvGroupLiveGoto);
        textView.setText(getString(R$string.n_live_already_appointment));
        textView.setTextColor(getResources().getColor(R$color.im_color_group_live_float_title));
        textView.setBackgroundResource(R$drawable.im_bg_goto_live);
        this.liveGroupBean.setAppointed(1);
        ToastUtil.toastShortMessage(getString(R$string.n_live_iappointment_alert_nviteSuccess));
    }

    public void updateNoticeView() {
        loadNoticeData();
        c.b().f();
        c.b().c(new kd.a<GroupInfoData>() {
            public void onFailed(int i11, String str) {
            }

            public void onSuccess(GroupInfoData groupInfoData) {
                ChatView chatView = ImGroupChatFragment.this.chatView;
                if (chatView != null && groupInfoData != null) {
                    chatView.getTitleBar().getExtraTitle().setVisibility(0);
                    TitleBarLayout titleBar = ImGroupChatFragment.this.chatView.getTitleBar();
                    titleBar.setTitle("(" + groupInfoData.getUserCount() + ")", ITitleBarLayout.Position.EXTRAL);
                    ImGroupChatFragment.this.chatView.setChatType(groupInfoData.getType());
                    ImGroupChatFragment.this.chatView.setGroupAvatar(groupInfoData.getAvatar());
                    if (ImGroupChatFragment.this.groupInfo != null && TextUtils.isEmpty(ImGroupChatFragment.this.groupInfo.getChatName())) {
                        ImGroupChatFragment.this.groupInfo.setChatName(groupInfoData.getTitle());
                        ImGroupChatFragment.this.chatView.getTitleBar().setTitle(groupInfoData.getTitle(), ITitleBarLayout.Position.MIDDLE);
                    }
                }
            }
        });
    }

    public HbGroupChatManager getChatManager() {
        return this.groupChatManager;
    }
}
