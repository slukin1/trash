package ld;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.m0;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.core.bean.GroupInfoData;
import com.hbg.lib.network.hbg.core.bean.GroupUserListData;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.lib.network.hbg.core.bean.TranslateBean;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend;
import com.hbg.module.huobi.im.gift.bean.DrawGiftBean;
import com.hbg.module.huobi.im.group.bean.ChatBlockEntity;
import com.hbg.module.huobi.im.group.bean.GroupNoticeListEntity;
import com.hbg.module.huobi.im.group.bean.LiveGroupBean;
import com.hbg.module.huobi.im.group.bean.MessageNoDisturbStatus;
import com.hbg.module.huobi.im.group.bean.UserStatusEntity;
import com.hbg.module.huobi.im.group.net.ILiveImService;
import com.huobi.vulcan.model.VulcanInfo;
import com.tencent.android.tpush.common.Constants;
import com.tencent.imsdk.common.IMLog;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import java.util.List;
import java.util.Map;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final e f22892a;

    /* renamed from: b  reason: collision with root package name */
    public final String f22893b = f.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public final ILiveImService f22894c = ((ILiveImService) HbgRetrofit.request(ILiveImService.class));

    public static final class a extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22895b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ dd.a f22896c;

        public a(f fVar, dd.a aVar) {
            this.f22895b = fVar;
            this.f22896c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                IMLog.d(this.f22895b.f22893b, "blockUserInGroup Success");
                dd.a aVar = this.f22896c;
                if (aVar != null) {
                    aVar.onSuccess();
                    return;
                }
                return;
            }
            dd.a aVar2 = this.f22896c;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
            r1 = r3.getErrCode();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException r3) {
            /*
                r2 = this;
                super.onFailed(r3)
                ld.f r0 = r2.f22895b
                ld.e r0 = r0.l()
                if (r0 == 0) goto L_0x001c
                ld.f r0 = r2.f22895b
                ld.e r0 = r0.l()
                android.content.Context r0 = (android.content.Context) r0
                int r1 = com.hbg.module.huobi.im.R$string.n_service_error
                java.lang.String r0 = r0.getString(r1)
                com.tencent.qcloud.tuicore.util.ToastUtil.toastShortMessage(r0)
            L_0x001c:
                dd.a r0 = r2.f22896c
                if (r0 == 0) goto L_0x003d
                if (r3 == 0) goto L_0x002d
                java.lang.String r1 = r3.getErrCode()
                if (r1 == 0) goto L_0x002d
                int r1 = java.lang.Integer.parseInt(r1)
                goto L_0x002e
            L_0x002d:
                r1 = 0
            L_0x002e:
                if (r3 == 0) goto L_0x0035
                java.lang.String r3 = r3.getErrMsg()
                goto L_0x0036
            L_0x0035:
                r3 = 0
            L_0x0036:
                if (r3 != 0) goto L_0x003a
                java.lang.String r3 = ""
            L_0x003a:
                r0.onFailed(r1, r3)
            L_0x003d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ld.f.a.onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException):void");
        }
    }

    public static final class a0 extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22897b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kd.a<Object> f22898c;

        public a0(f fVar, kd.a<Object> aVar) {
            this.f22897b = fVar;
            this.f22898c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                IMLog.d(this.f22897b.f22893b, "setShareContract Success");
                kd.a<Object> aVar = this.f22898c;
                if (aVar != null) {
                    aVar.onSuccess(hbgIntCodeResponse);
                    return;
                }
                return;
            }
            kd.a<Object> aVar2 = this.f22898c;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode;
            String a11 = this.f22897b.f22893b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setShareContract error");
            String str = null;
            sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getMessage() : null);
            IMLog.d(a11, sb2.toString());
            kd.a<Object> aVar = this.f22898c;
            if (aVar != null) {
                int parseInt = (aPIStatusErrorException == null || (errCode = aPIStatusErrorException.getErrCode()) == null) ? 0 : Integer.parseInt(errCode);
                if (aPIStatusErrorException != null) {
                    str = aPIStatusErrorException.getErrMsg();
                }
                if (str == null) {
                    str = "";
                }
                aVar.onFailed(parseInt, str);
            }
        }
    }

    public static final class b extends EasySubscriber<HbgIntCodeResponse<LiveAppointmentData>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22899b;

        public b(f fVar) {
            this.f22899b = fVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<LiveAppointmentData> hbgIntCodeResponse) {
            e l11;
            super.onNext(hbgIntCodeResponse);
            boolean z11 = false;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                z11 = true;
            }
            if (z11 && (l11 = this.f22899b.l()) != null) {
                l11.updateCancelLiveAppointment();
            }
        }
    }

    public static final class b0 extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ dd.a f22900b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f22901c;

        public b0(dd.a aVar, f fVar) {
            this.f22900b = aVar;
            this.f22901c = fVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                dd.a aVar = this.f22900b;
                if (aVar != null) {
                    aVar.onSuccess();
                    return;
                }
                return;
            }
            dd.a aVar2 = this.f22900b;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
            r1 = r3.getErrCode();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException r3) {
            /*
                r2 = this;
                super.onFailed(r3)
                ld.f r0 = r2.f22901c
                ld.e r0 = r0.l()
                if (r0 == 0) goto L_0x001c
                ld.f r0 = r2.f22901c
                ld.e r0 = r0.l()
                android.content.Context r0 = (android.content.Context) r0
                int r1 = com.hbg.module.huobi.im.R$string.n_service_error
                java.lang.String r0 = r0.getString(r1)
                com.tencent.qcloud.tuicore.util.ToastUtil.toastShortMessage(r0)
            L_0x001c:
                dd.a r0 = r2.f22900b
                if (r0 == 0) goto L_0x003d
                if (r3 == 0) goto L_0x002d
                java.lang.String r1 = r3.getErrCode()
                if (r1 == 0) goto L_0x002d
                int r1 = java.lang.Integer.parseInt(r1)
                goto L_0x002e
            L_0x002d:
                r1 = 0
            L_0x002e:
                if (r3 == 0) goto L_0x0035
                java.lang.String r3 = r3.getErrMsg()
                goto L_0x0036
            L_0x0035:
                r3 = 0
            L_0x0036:
                if (r3 != 0) goto L_0x003a
                java.lang.String r3 = ""
            L_0x003a:
                r0.onFailed(r1, r3)
            L_0x003d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ld.f.b0.onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException):void");
        }
    }

    public static final class c extends EasySubscriber<HbgIntCodeResponse<CusMsgGiftSend>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.hbg.module.huobi.im.gift.f f22902b;

        public c(com.hbg.module.huobi.im.gift.f fVar) {
            this.f22902b = fVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<CusMsgGiftSend> hbgIntCodeResponse) {
            com.hbg.module.huobi.im.gift.f fVar;
            super.onNext(hbgIntCodeResponse);
            if (hbgIntCodeResponse.getCode() == 200 && hbgIntCodeResponse.getData() != null && (fVar = this.f22902b) != null) {
                fVar.b(hbgIntCodeResponse.getData());
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            com.hbg.module.huobi.im.gift.f fVar = this.f22902b;
            if (fVar != null) {
                fVar.a(aPIStatusErrorException.getErrCode(), aPIStatusErrorException.getErrMsg());
            }
        }
    }

    public static final class c0 extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22903b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ dd.a f22904c;

        public c0(f fVar, dd.a aVar) {
            this.f22903b = fVar;
            this.f22904c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                IMLog.d(this.f22903b.f22893b, "updatePersonalRelations Success");
                dd.a aVar = this.f22904c;
                if (aVar != null) {
                    aVar.onSuccess();
                    return;
                }
                return;
            }
            dd.a aVar2 = this.f22904c;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
            r1 = r3.getErrCode();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException r3) {
            /*
                r2 = this;
                super.onFailed(r3)
                ld.f r0 = r2.f22903b
                ld.e r0 = r0.l()
                if (r0 == 0) goto L_0x001c
                ld.f r0 = r2.f22903b
                ld.e r0 = r0.l()
                android.content.Context r0 = (android.content.Context) r0
                int r1 = com.hbg.module.huobi.im.R$string.n_service_error
                java.lang.String r0 = r0.getString(r1)
                com.tencent.qcloud.tuicore.util.ToastUtil.toastShortMessage(r0)
            L_0x001c:
                dd.a r0 = r2.f22904c
                if (r0 == 0) goto L_0x003d
                if (r3 == 0) goto L_0x002d
                java.lang.String r1 = r3.getErrCode()
                if (r1 == 0) goto L_0x002d
                int r1 = java.lang.Integer.parseInt(r1)
                goto L_0x002e
            L_0x002d:
                r1 = 0
            L_0x002e:
                if (r3 == 0) goto L_0x0035
                java.lang.String r3 = r3.getErrMsg()
                goto L_0x0036
            L_0x0035:
                r3 = 0
            L_0x0036:
                if (r3 != 0) goto L_0x003a
                java.lang.String r3 = ""
            L_0x003a:
                r0.onFailed(r1, r3)
            L_0x003d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ld.f.c0.onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException):void");
        }
    }

    public static final class d extends EasySubscriber<HbgIntCodeResponse<DrawGiftBean>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.hbg.module.huobi.im.gift.a f22905b;

        public d(com.hbg.module.huobi.im.gift.a aVar) {
            this.f22905b = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<DrawGiftBean> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            if (hbgIntCodeResponse.getCode() == 200) {
                com.hbg.module.huobi.im.gift.a aVar = this.f22905b;
                if (aVar != null) {
                    aVar.b(hbgIntCodeResponse.getData());
                    return;
                }
                return;
            }
            com.hbg.module.huobi.im.gift.a aVar2 = this.f22905b;
            if (aVar2 != null) {
                aVar2.a("" + hbgIntCodeResponse.getCode(), hbgIntCodeResponse.getMessage());
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            com.hbg.module.huobi.im.gift.a aVar = this.f22905b;
            if (aVar != null) {
                aVar.a(aPIStatusErrorException.getErrCode(), aPIStatusErrorException.getErrMsg());
            }
        }
    }

    public static final class e extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22906b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ dd.a f22907c;

        public e(f fVar, dd.a aVar) {
            this.f22906b = fVar;
            this.f22907c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                IMLog.d(this.f22906b.f22893b, "forbidInGroup Success");
                dd.a aVar = this.f22907c;
                if (aVar != null) {
                    aVar.onSuccess();
                    return;
                }
                return;
            }
            dd.a aVar2 = this.f22907c;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode;
            super.onFailed(aPIStatusErrorException);
            String a11 = this.f22906b.f22893b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("forbidInGroup error");
            String str = null;
            sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getMessage() : null);
            IMLog.d(a11, sb2.toString());
            if (this.f22906b.l() != null) {
                ToastUtil.toastShortMessage(((Context) this.f22906b.l()).getString(R$string.n_service_error));
            }
            dd.a aVar = this.f22907c;
            if (aVar != null) {
                int parseInt = (aPIStatusErrorException == null || (errCode = aPIStatusErrorException.getErrCode()) == null) ? 0 : Integer.parseInt(errCode);
                if (aPIStatusErrorException != null) {
                    str = aPIStatusErrorException.getErrMsg();
                }
                if (str == null) {
                    str = "";
                }
                aVar.onFailed(parseInt, str);
            }
        }
    }

    /* renamed from: ld.f$f  reason: collision with other inner class name */
    public static final class C0198f extends EasySubscriber<HbgIntCodeResponse<List<? extends ChatBlockEntity>>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22908b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kd.a<List<ChatBlockEntity>> f22909c;

        public C0198f(f fVar, kd.a<List<ChatBlockEntity>> aVar) {
            this.f22908b = fVar;
            this.f22909c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<List<ChatBlockEntity>> hbgIntCodeResponse) {
            kd.a<List<ChatBlockEntity>> aVar;
            super.onNext(hbgIntCodeResponse);
            IMLog.d(this.f22908b.f22893b, "getGroupTopNoticeList Success");
            if (hbgIntCodeResponse != null) {
                kd.a<List<ChatBlockEntity>> aVar2 = this.f22909c;
                if (hbgIntCodeResponse.getCode() == 200) {
                    if (aVar2 != null) {
                        if (hbgIntCodeResponse.getData() != null) {
                            aVar2.onSuccess(hbgIntCodeResponse.getData());
                        } else {
                            aVar2.onFailed(10, "");
                        }
                    }
                } else if (aVar2 != null) {
                    aVar2.onFailed(hbgIntCodeResponse.getCode(), hbgIntCodeResponse.getMessage());
                }
            }
            if (hbgIntCodeResponse == null && (aVar = this.f22909c) != null) {
                aVar.onFailed(10, "");
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode;
            String a11 = this.f22908b.f22893b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getGroupTopNoticeList error");
            String str = null;
            sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getMessage() : null);
            IMLog.d(a11, sb2.toString());
            kd.a<List<ChatBlockEntity>> aVar = this.f22909c;
            if (aVar != null) {
                int parseInt = (aPIStatusErrorException == null || (errCode = aPIStatusErrorException.getErrCode()) == null) ? 0 : Integer.parseInt(errCode);
                if (aPIStatusErrorException != null) {
                    str = aPIStatusErrorException.getErrMsg();
                }
                if (str == null) {
                    str = "";
                }
                aVar.onFailed(parseInt, str);
            }
        }
    }

    public static final class g extends BaseSubscriber<GroupUserListData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kd.a<GroupUserListData> f22910b;

        public g(kd.a<GroupUserListData> aVar) {
            this.f22910b = aVar;
        }

        /* renamed from: a */
        public void onNext(GroupUserListData groupUserListData) {
            kd.a<GroupUserListData> aVar;
            super.onNext(groupUserListData);
            if (groupUserListData != null && (aVar = this.f22910b) != null) {
                aVar.onSuccess(groupUserListData);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 != null) {
                kd.a<GroupUserListData> aVar = this.f22910b;
                String message = th2.getMessage();
                if (message != null && aVar != null) {
                    aVar.onFailed(-1, message);
                }
            }
        }
    }

    public static final class h extends EasySubscriber<HbgIntCodeResponse<GroupNoticeListEntity>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22911b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kd.a<GroupNoticeListEntity> f22912c;

        public h(f fVar, kd.a<GroupNoticeListEntity> aVar) {
            this.f22911b = fVar;
            this.f22912c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<GroupNoticeListEntity> hbgIntCodeResponse) {
            kd.a<GroupNoticeListEntity> aVar;
            super.onNext(hbgIntCodeResponse);
            IMLog.d(this.f22911b.f22893b, "getGroupNoticeList Success");
            if (hbgIntCodeResponse != null) {
                kd.a<GroupNoticeListEntity> aVar2 = this.f22912c;
                if (hbgIntCodeResponse.getCode() == 200) {
                    if (aVar2 != null) {
                        aVar2.onSuccess(hbgIntCodeResponse.getData());
                    }
                } else if (aVar2 != null) {
                    aVar2.onFailed(hbgIntCodeResponse.getCode(), hbgIntCodeResponse.getMessage());
                }
            }
            if (hbgIntCodeResponse == null && (aVar = this.f22912c) != null) {
                aVar.onFailed(0, "");
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode;
            String a11 = this.f22911b.f22893b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getGroupNoticeList error");
            String str = null;
            sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getMessage() : null);
            IMLog.d(a11, sb2.toString());
            kd.a<GroupNoticeListEntity> aVar = this.f22912c;
            if (aVar != null) {
                int parseInt = (aPIStatusErrorException == null || (errCode = aPIStatusErrorException.getErrCode()) == null) ? 0 : Integer.parseInt(errCode);
                if (aPIStatusErrorException != null) {
                    str = aPIStatusErrorException.getErrMsg();
                }
                if (str == null) {
                    str = "";
                }
                aVar.onFailed(parseInt, str);
            }
        }
    }

    public static final class i extends EasySubscriber<HbgIntCodeResponse<GroupNoticeListEntity>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22913b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kd.a<GroupNoticeListEntity> f22914c;

        public i(f fVar, kd.a<GroupNoticeListEntity> aVar) {
            this.f22913b = fVar;
            this.f22914c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<GroupNoticeListEntity> hbgIntCodeResponse) {
            kd.a<GroupNoticeListEntity> aVar;
            super.onNext(hbgIntCodeResponse);
            IMLog.d(this.f22913b.f22893b, "getGroupTopNoticeList Success");
            if (hbgIntCodeResponse != null) {
                kd.a<GroupNoticeListEntity> aVar2 = this.f22914c;
                if (hbgIntCodeResponse.getCode() == 200) {
                    if (aVar2 != null) {
                        aVar2.onSuccess(hbgIntCodeResponse.getData());
                    }
                } else if (aVar2 != null) {
                    aVar2.onFailed(hbgIntCodeResponse.getCode(), hbgIntCodeResponse.getMessage());
                }
            }
            if (hbgIntCodeResponse == null && (aVar = this.f22914c) != null) {
                aVar.onFailed(0, "");
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode;
            String a11 = this.f22913b.f22893b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getGroupTopNoticeList error");
            String str = null;
            sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getMessage() : null);
            IMLog.d(a11, sb2.toString());
            kd.a<GroupNoticeListEntity> aVar = this.f22914c;
            if (aVar != null) {
                int parseInt = (aPIStatusErrorException == null || (errCode = aPIStatusErrorException.getErrCode()) == null) ? 0 : Integer.parseInt(errCode);
                if (aPIStatusErrorException != null) {
                    str = aPIStatusErrorException.getErrMsg();
                }
                if (str == null) {
                    str = "";
                }
                aVar.onFailed(parseInt, str);
            }
        }
    }

    public static final class j extends EasySubscriber<HbgIntCodeResponse<LiveGroupBean>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22915b;

        public j(f fVar) {
            this.f22915b = fVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<LiveGroupBean> hbgIntCodeResponse) {
            e l11;
            super.onNext(hbgIntCodeResponse);
            boolean z11 = false;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                z11 = true;
            }
            if (z11) {
                IMLog.d(this.f22915b.f22893b, "getLiveDetailByGroup Success");
                if (hbgIntCodeResponse.getData() != null && (l11 = this.f22915b.l()) != null) {
                    l11.showGroupLiveFloatView(hbgIntCodeResponse.getData());
                    return;
                }
                return;
            }
            if (!sd.a.c(hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null)) {
                ToastUtil.toastShortMessage(hbgIntCodeResponse.getMessage());
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (this.f22915b.l() != null) {
                ToastUtil.toastShortMessage(((Context) this.f22915b.l()).getString(R$string.n_service_error));
            }
        }
    }

    public static final class k extends EasySubscriber<HbgIntCodeResponse<MessageNoDisturbStatus>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kd.a<MessageNoDisturbStatus> f22916b;

        public k(kd.a<MessageNoDisturbStatus> aVar) {
            this.f22916b = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<MessageNoDisturbStatus> hbgIntCodeResponse) {
            kd.a<MessageNoDisturbStatus> aVar;
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (!(hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200)) {
                kd.a<MessageNoDisturbStatus> aVar2 = this.f22916b;
                if (aVar2 != null) {
                    if (hbgIntCodeResponse != null) {
                        i11 = hbgIntCodeResponse.getCode();
                    }
                    String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                    if (message == null) {
                        message = "";
                    }
                    aVar2.onFailed(i11, message);
                }
            } else if (hbgIntCodeResponse.getData() != null && (aVar = this.f22916b) != null) {
                aVar.onSuccess(hbgIntCodeResponse.getData());
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
            r1 = r3.getErrCode();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException r3) {
            /*
                r2 = this;
                android.content.Context r0 = com.tencent.qcloud.tuicore.TUIConfig.getAppContext()
                int r1 = com.hbg.module.huobi.im.R$string.n_im_msg_translated_fail
                java.lang.String r0 = r0.getString(r1)
                com.tencent.qcloud.tuicore.util.ToastUtil.toastShortMessage(r0)
                kd.a<com.hbg.module.huobi.im.group.bean.MessageNoDisturbStatus> r0 = r2.f22916b
                if (r0 == 0) goto L_0x002e
                if (r3 == 0) goto L_0x001e
                java.lang.String r1 = r3.getErrCode()
                if (r1 == 0) goto L_0x001e
                int r1 = java.lang.Integer.parseInt(r1)
                goto L_0x001f
            L_0x001e:
                r1 = 0
            L_0x001f:
                if (r3 == 0) goto L_0x0026
                java.lang.String r3 = r3.getErrMsg()
                goto L_0x0027
            L_0x0026:
                r3 = 0
            L_0x0027:
                if (r3 != 0) goto L_0x002b
                java.lang.String r3 = ""
            L_0x002b:
                r0.onFailed(r1, r3)
            L_0x002e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ld.f.k.onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException):void");
        }
    }

    public static final class l extends BaseSubscriber<PersonalCenterInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kd.a<PersonalCenterInfo> f22917b;

        public l(kd.a<PersonalCenterInfo> aVar) {
            this.f22917b = aVar;
        }

        /* renamed from: a */
        public void onNext(PersonalCenterInfo personalCenterInfo) {
            kd.a<PersonalCenterInfo> aVar;
            super.onNext(personalCenterInfo);
            if (personalCenterInfo != null && (aVar = this.f22917b) != null) {
                aVar.onSuccess(personalCenterInfo);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public static final class m extends EasySubscriber<TranslateBean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22918b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kd.a<TranslateBean> f22919c;

        public m(f fVar, kd.a<TranslateBean> aVar) {
            this.f22918b = fVar;
            this.f22919c = aVar;
        }

        /* renamed from: a */
        public void onNext(TranslateBean translateBean) {
            super.onNext(translateBean);
            IMLog.d(this.f22918b.f22893b, "getTranslateContent Success");
            if (translateBean != null) {
                kd.a<TranslateBean> aVar = this.f22919c;
                if (aVar != null) {
                    aVar.onSuccess(translateBean);
                    return;
                }
                return;
            }
            ToastUtil.toastShortMessage(TUIConfig.getAppContext().getString(R$string.n_im_msg_translated_fail));
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode;
            String a11 = this.f22918b.f22893b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getTranslateContent error");
            String str = null;
            sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getMessage() : null);
            IMLog.d(a11, sb2.toString());
            ToastUtil.toastShortMessage(TUIConfig.getAppContext().getString(R$string.n_im_msg_translated_fail));
            kd.a<TranslateBean> aVar = this.f22919c;
            if (aVar != null) {
                int parseInt = (aPIStatusErrorException == null || (errCode = aPIStatusErrorException.getErrCode()) == null) ? 0 : Integer.parseInt(errCode);
                if (aPIStatusErrorException != null) {
                    str = aPIStatusErrorException.getErrMsg();
                }
                if (str == null) {
                    str = "";
                }
                aVar.onFailed(parseInt, str);
            }
        }
    }

    public static final class n extends EasySubscriber<HbgIntCodeResponse<UserStatusEntity>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22920b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kd.a<UserStatusEntity> f22921c;

        public n(f fVar, kd.a<UserStatusEntity> aVar) {
            this.f22920b = fVar;
            this.f22921c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<UserStatusEntity> hbgIntCodeResponse) {
            kd.a<UserStatusEntity> aVar;
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                IMLog.d(this.f22920b.f22893b, "getUserState Success");
                if (hbgIntCodeResponse.getData() != null && (aVar = this.f22921c) != null) {
                    aVar.onSuccess(hbgIntCodeResponse.getData());
                    return;
                }
                return;
            }
            kd.a<UserStatusEntity> aVar2 = this.f22921c;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
            r1 = r3.getErrCode();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException r3) {
            /*
                r2 = this;
                super.onFailed(r3)
                kd.a<com.hbg.module.huobi.im.group.bean.UserStatusEntity> r0 = r2.f22921c
                if (r0 == 0) goto L_0x0024
                if (r3 == 0) goto L_0x0014
                java.lang.String r1 = r3.getErrCode()
                if (r1 == 0) goto L_0x0014
                int r1 = java.lang.Integer.parseInt(r1)
                goto L_0x0015
            L_0x0014:
                r1 = 0
            L_0x0015:
                if (r3 == 0) goto L_0x001c
                java.lang.String r3 = r3.getErrMsg()
                goto L_0x001d
            L_0x001c:
                r3 = 0
            L_0x001d:
                if (r3 != 0) goto L_0x0021
                java.lang.String r3 = ""
            L_0x0021:
                r0.onFailed(r1, r3)
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ld.f.n.onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException):void");
        }
    }

    public static final class o extends EasySubscriber<HbgIntCodeResponse<UserStatusEntity>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22922b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kd.a<UserStatusEntity> f22923c;

        public o(f fVar, kd.a<UserStatusEntity> aVar) {
            this.f22922b = fVar;
            this.f22923c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<UserStatusEntity> hbgIntCodeResponse) {
            kd.a<UserStatusEntity> aVar;
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                IMLog.d(this.f22922b.f22893b, "getUserState Success");
                if (hbgIntCodeResponse.getData() != null && (aVar = this.f22923c) != null) {
                    aVar.onSuccess(hbgIntCodeResponse.getData());
                    return;
                }
                return;
            }
            kd.a<UserStatusEntity> aVar2 = this.f22923c;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
            r1 = r3.getErrCode();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException r3) {
            /*
                r2 = this;
                super.onFailed(r3)
                kd.a<com.hbg.module.huobi.im.group.bean.UserStatusEntity> r0 = r2.f22923c
                if (r0 == 0) goto L_0x0024
                if (r3 == 0) goto L_0x0014
                java.lang.String r1 = r3.getErrCode()
                if (r1 == 0) goto L_0x0014
                int r1 = java.lang.Integer.parseInt(r1)
                goto L_0x0015
            L_0x0014:
                r1 = 0
            L_0x0015:
                if (r3 == 0) goto L_0x001c
                java.lang.String r3 = r3.getErrMsg()
                goto L_0x001d
            L_0x001c:
                r3 = 0
            L_0x001d:
                if (r3 != 0) goto L_0x0021
                java.lang.String r3 = ""
            L_0x0021:
                r0.onFailed(r1, r3)
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ld.f.o.onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException):void");
        }
    }

    public static final class p extends BaseSubscriber<GroupInfoData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kd.a<GroupInfoData> f22924b;

        public p(kd.a<GroupInfoData> aVar) {
            this.f22924b = aVar;
        }

        /* renamed from: a */
        public void onNext(GroupInfoData groupInfoData) {
            kd.a<GroupInfoData> aVar;
            super.onNext(groupInfoData);
            if (groupInfoData != null && (aVar = this.f22924b) != null) {
                aVar.onSuccess(groupInfoData);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public static final class q extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22925b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kd.a<Object> f22926c;

        public q(f fVar, kd.a<Object> aVar) {
            this.f22925b = fVar;
            this.f22926c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                IMLog.d(this.f22925b.f22893b, "groupNoticeDelete Success");
                kd.a<Object> aVar = this.f22926c;
                if (aVar != null) {
                    aVar.onSuccess(hbgIntCodeResponse);
                    return;
                }
                return;
            }
            kd.a<Object> aVar2 = this.f22926c;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode;
            String a11 = this.f22925b.f22893b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("groupNoticeDelete error");
            String str = null;
            sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getMessage() : null);
            IMLog.d(a11, sb2.toString());
            kd.a<Object> aVar = this.f22926c;
            if (aVar != null) {
                int parseInt = (aPIStatusErrorException == null || (errCode = aPIStatusErrorException.getErrCode()) == null) ? 0 : Integer.parseInt(errCode);
                if (aPIStatusErrorException != null) {
                    str = aPIStatusErrorException.getErrMsg();
                }
                if (str == null) {
                    str = "";
                }
                aVar.onFailed(parseInt, str);
            }
        }
    }

    public static final class r extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22927b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kd.a<Object> f22928c;

        public r(f fVar, kd.a<Object> aVar) {
            this.f22927b = fVar;
            this.f22928c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                IMLog.d(this.f22927b.f22893b, "groupNoticeSettingTop Success");
                kd.a<Object> aVar = this.f22928c;
                if (aVar != null) {
                    aVar.onSuccess(hbgIntCodeResponse);
                    return;
                }
                return;
            }
            kd.a<Object> aVar2 = this.f22928c;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode;
            String a11 = this.f22927b.f22893b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("groupNoticeSettingTop error");
            String str = null;
            sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getMessage() : null);
            IMLog.d(a11, sb2.toString());
            kd.a<Object> aVar = this.f22928c;
            if (aVar != null) {
                int parseInt = (aPIStatusErrorException == null || (errCode = aPIStatusErrorException.getErrCode()) == null) ? 0 : Integer.parseInt(errCode);
                if (aPIStatusErrorException != null) {
                    str = aPIStatusErrorException.getErrMsg();
                }
                if (str == null) {
                    str = "";
                }
                aVar.onFailed(parseInt, str);
            }
        }
    }

    public static final class s extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22929b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kd.a<Object> f22930c;

        public s(f fVar, kd.a<Object> aVar) {
            this.f22929b = fVar;
            this.f22930c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                IMLog.d(this.f22929b.f22893b, "setGroupManager Success");
                kd.a<Object> aVar = this.f22930c;
                if (aVar != null) {
                    aVar.onSuccess(hbgIntCodeResponse);
                    return;
                }
                return;
            }
            kd.a<Object> aVar2 = this.f22930c;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode;
            String a11 = this.f22929b.f22893b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setGroupManager error");
            String str = null;
            sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getMessage() : null);
            IMLog.d(a11, sb2.toString());
            kd.a<Object> aVar = this.f22930c;
            if (aVar != null) {
                int parseInt = (aPIStatusErrorException == null || (errCode = aPIStatusErrorException.getErrCode()) == null) ? 0 : Integer.parseInt(errCode);
                if (aPIStatusErrorException != null) {
                    str = aPIStatusErrorException.getErrMsg();
                }
                if (str == null) {
                    str = "";
                }
                aVar.onFailed(parseInt, str);
            }
        }
    }

    public static final class t extends EasySubscriber<HbgIntCodeResponse<LiveAppointmentData>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22931b;

        public t(f fVar) {
            this.f22931b = fVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<LiveAppointmentData> hbgIntCodeResponse) {
            e l11;
            super.onNext(hbgIntCodeResponse);
            boolean z11 = false;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                z11 = true;
            }
            if (z11 && (l11 = this.f22931b.l()) != null) {
                l11.updateLiveAppointment();
            }
        }
    }

    public static final class u extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22932b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f22933c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f22934d;

        public u(f fVar, String str, String str2) {
            this.f22932b = fVar;
            this.f22933c = str;
            this.f22934d = str2;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            boolean z11 = false;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                z11 = true;
            }
            if (z11) {
                String a11 = this.f22932b.f22893b;
                IMLog.d(a11, "barrage --- recallInGroup Success" + this.f22933c + 65292 + this.f22934d);
                return;
            }
            String str = null;
            if (!sd.a.c(hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null)) {
                if (hbgIntCodeResponse != null) {
                    str = hbgIntCodeResponse.getMessage();
                }
                ToastUtil.toastShortMessage(str);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (this.f22932b.l() != null) {
                ToastUtil.toastShortMessage(((Context) this.f22932b.l()).getString(R$string.n_service_error));
            }
        }
    }

    public static final class v extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22935b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f22936c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f22937d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ kd.a<Object> f22938e;

        public v(f fVar, String str, String str2, kd.a<Object> aVar) {
            this.f22935b = fVar;
            this.f22936c = str;
            this.f22937d = str2;
            this.f22938e = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                String a11 = this.f22935b.f22893b;
                IMLog.d(a11, "barrage --- recallInGroupAll Success" + this.f22936c + 65292 + this.f22937d);
                kd.a<Object> aVar = this.f22938e;
                if (aVar != null) {
                    aVar.onSuccess(hbgIntCodeResponse);
                }
                ToastUtil.toastShortMessage(TUIConfig.getAppContext().getString(R$string.n_im_clear_msg_success));
                return;
            }
            kd.a<Object> aVar2 = this.f22938e;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ToastUtil.toastShortMessage(TUIConfig.getAppContext().getString(R$string.n_im_operation_fail));
        }
    }

    public static final class w extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22939b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ dd.a f22940c;

        public w(f fVar, dd.a aVar) {
            this.f22939b = fVar;
            this.f22940c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                IMLog.d(this.f22939b.f22893b, "removeUserInGroup Success");
                dd.a aVar = this.f22940c;
                if (aVar != null) {
                    aVar.onSuccess();
                    return;
                }
                return;
            }
            dd.a aVar2 = this.f22940c;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
            r1 = r3.getErrCode();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException r3) {
            /*
                r2 = this;
                super.onFailed(r3)
                ld.f r0 = r2.f22939b
                ld.e r0 = r0.l()
                if (r0 == 0) goto L_0x001c
                ld.f r0 = r2.f22939b
                ld.e r0 = r0.l()
                android.content.Context r0 = (android.content.Context) r0
                int r1 = com.hbg.module.huobi.im.R$string.n_service_error
                java.lang.String r0 = r0.getString(r1)
                com.tencent.qcloud.tuicore.util.ToastUtil.toastShortMessage(r0)
            L_0x001c:
                dd.a r0 = r2.f22940c
                if (r0 == 0) goto L_0x003d
                if (r3 == 0) goto L_0x002d
                java.lang.String r1 = r3.getErrCode()
                if (r1 == 0) goto L_0x002d
                int r1 = java.lang.Integer.parseInt(r1)
                goto L_0x002e
            L_0x002d:
                r1 = 0
            L_0x002e:
                if (r3 == 0) goto L_0x0035
                java.lang.String r3 = r3.getErrMsg()
                goto L_0x0036
            L_0x0035:
                r3 = 0
            L_0x0036:
                if (r3 != 0) goto L_0x003a
                java.lang.String r3 = ""
            L_0x003a:
                r0.onFailed(r1, r3)
            L_0x003d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ld.f.w.onFailed(com.hbg.lib.network.retrofit.exception.APIStatusErrorException):void");
        }
    }

    public static final class x extends EasySubscriber<HbgIntCodeResponse<Map<String, ? extends Integer>>> {
        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Map<String, Integer>> hbgIntCodeResponse) {
            Map data;
            Integer num;
            super.onNext(hbgIntCodeResponse);
            if (hbgIntCodeResponse != null && (data = hbgIntCodeResponse.getData()) != null && (num = (Integer) data.get("recallableTime")) != null) {
                dd.b.f22740a.f(num.intValue() * 60);
            }
        }
    }

    public static final class y extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22941b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kd.a<Object> f22942c;

        public y(f fVar, kd.a<Object> aVar) {
            this.f22941b = fVar;
            this.f22942c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                IMLog.d(this.f22941b.f22893b, "setGroupAllForbid Success");
                kd.a<Object> aVar = this.f22942c;
                if (aVar != null) {
                    aVar.onSuccess(hbgIntCodeResponse);
                    return;
                }
                return;
            }
            kd.a<Object> aVar2 = this.f22942c;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode;
            String a11 = this.f22941b.f22893b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setGroupAllForbid error");
            String str = null;
            sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getMessage() : null);
            IMLog.d(a11, sb2.toString());
            kd.a<Object> aVar = this.f22942c;
            if (aVar != null) {
                int parseInt = (aPIStatusErrorException == null || (errCode = aPIStatusErrorException.getErrCode()) == null) ? 0 : Integer.parseInt(errCode);
                if (aPIStatusErrorException != null) {
                    str = aPIStatusErrorException.getErrMsg();
                }
                if (str == null) {
                    str = "";
                }
                aVar.onFailed(parseInt, str);
            }
        }
    }

    public static final class z extends EasySubscriber<HbgIntCodeResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22943b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kd.a<Object> f22944c;

        public z(f fVar, kd.a<Object> aVar) {
            this.f22943b = fVar;
            this.f22944c = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
            super.onNext(hbgIntCodeResponse);
            IMLog.d(this.f22943b.f22893b, "setGroupManager Success");
            int i11 = 0;
            if (hbgIntCodeResponse != null && hbgIntCodeResponse.getCode() == 200) {
                kd.a<Object> aVar = this.f22944c;
                if (aVar != null) {
                    aVar.onSuccess(hbgIntCodeResponse);
                    return;
                }
                return;
            }
            kd.a<Object> aVar2 = this.f22944c;
            if (aVar2 != null) {
                if (hbgIntCodeResponse != null) {
                    i11 = hbgIntCodeResponse.getCode();
                }
                String message = hbgIntCodeResponse != null ? hbgIntCodeResponse.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                aVar2.onFailed(i11, message);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode;
            String a11 = this.f22943b.f22893b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setGroupManager error");
            String str = null;
            sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getMessage() : null);
            IMLog.d(a11, sb2.toString());
            kd.a<Object> aVar = this.f22944c;
            if (aVar != null) {
                int parseInt = (aPIStatusErrorException == null || (errCode = aPIStatusErrorException.getErrCode()) == null) ? 0 : Integer.parseInt(errCode);
                if (aPIStatusErrorException != null) {
                    str = aPIStatusErrorException.getErrMsg();
                }
                if (str == null) {
                    str = "";
                }
                aVar.onFailed(parseInt, str);
            }
        }
    }

    public f(e eVar) {
        this.f22892a = eVar;
    }

    public void A(String str, int i11, kd.a<Object> aVar) {
        this.f22894c.setGroupAllForbid(MapsKt__MapsKt.m(kotlin.l.a("groupId", str), kotlin.l.a("forbidAll", Integer.valueOf(i11)))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new y(this, aVar));
    }

    public void B(String str, String str2, String str3, kd.a<Object> aVar) {
        this.f22894c.setGroupManager(MapsKt__MapsKt.m(kotlin.l.a("groupId", str), kotlin.l.a(Constants.FLAG_ACCOUNT, str2), kotlin.l.a("status", str3))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new z(this, aVar));
    }

    public void C(String str, int i11, kd.a<Object> aVar) {
        this.f22894c.setGroupShareContract(MapsKt__MapsKt.m(kotlin.l.a("groupId", str), kotlin.l.a("shareContract", Integer.valueOf(i11)))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new a0(this, aVar));
    }

    public void D(int i11, String str, int i12, dd.a aVar) {
        this.f22894c.updateNoDisturbStatus(MapsKt__MapsKt.m(kotlin.l.a("type", Integer.valueOf(i11)), kotlin.l.a("toChat", str), kotlin.l.a("status", Integer.valueOf(i12)))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new b0(aVar, this));
    }

    public void E(String str, int i11, dd.a aVar) {
        this.f22894c.updatePersonalRelations(MapsKt__MapsKt.m(kotlin.l.a("toAccount", str), kotlin.l.a("action", Integer.valueOf(i11)))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new c0(this, aVar));
    }

    public void b(String str, String str2, dd.a aVar) {
        this.f22894c.blockUserInGroup(MapsKt__MapsKt.m(kotlin.l.a("groupId", str), kotlin.l.a(Constants.FLAG_ACCOUNT, str2))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new a(this, aVar));
    }

    public void c(String str) {
        this.f22894c.liveCancelAppointment(MapsKt__MapsKt.m(kotlin.l.a("liveId", str))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new b(this));
    }

    public void d(String str, String str2, com.hbg.module.huobi.im.gift.f fVar) {
        this.f22894c.countWatchTime(MapsKt__MapsKt.m(kotlin.l.a(Constants.FLAG_DEVICE_ID, m0.a()), kotlin.l.a("stepKey", str), kotlin.l.a("liveId", str2))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new c(fVar));
    }

    public void e(Context context, String str, String str2, String str3, com.hbg.module.huobi.im.gift.a aVar) {
        if (TextUtils.isEmpty(ku.b.e().d())) {
            ku.b.e().b(context);
        }
        this.f22894c.drawGift(MapsKt__MapsKt.m(kotlin.l.a("activeJackpot", str), kotlin.l.a("redPotId", str2), kotlin.l.a("liveId", str3), kotlin.l.a(Constants.FLAG_DEVICE_ID, m0.a()), kotlin.l.a(VulcanInfo.VTOKEN, ku.b.e().d()))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new d(aVar));
    }

    public void f(String str, String str2, boolean z11, dd.a aVar) {
        this.f22894c.forbidInGroup(MapsKt__MapsKt.m(kotlin.l.a("groupId", str), kotlin.l.a("memberAccount", str2), kotlin.l.a("shutUpTime", z11 ? 0 : null))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new e(this, aVar));
    }

    public void g(String str, kd.a<List<ChatBlockEntity>> aVar) {
        this.f22894c.getChatBlockList(MapsKt__MapsKt.m(kotlin.l.a("HB-PRO-TOKEN", str))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new C0198f(this, aVar));
    }

    public void h(String str, kd.a<GroupUserListData> aVar) {
        v7.b.a().getGroupUserListData(str, 1, -1, "").b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new g(aVar));
    }

    public void i(String str, kd.a<GroupNoticeListEntity> aVar) {
        this.f22894c.getGroupNoticeList(str).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new h(this, aVar));
    }

    public void j(String str, kd.a<GroupNoticeListEntity> aVar) {
        this.f22894c.getGroupNoticeTopList(str).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new i(this, aVar));
    }

    public void k(String str) {
        this.f22894c.getLiveDetailByGroup(str).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new j(this));
    }

    public final e l() {
        return this.f22892a;
    }

    public void m(int i11, String str, kd.a<MessageNoDisturbStatus> aVar) {
        this.f22894c.getNoDisturbStatus(i11, str).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new k(aVar));
    }

    public void n(String str, kd.a<PersonalCenterInfo> aVar) {
        v7.b.a().M0("", str, "").b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new l(aVar));
    }

    public void o(String str, kd.a<TranslateBean> aVar) {
        v7.b.a().translateContent((String) null, 10, str).b().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new m(this, aVar));
    }

    public void p(String str, String str2, String str3, kd.a<UserStatusEntity> aVar) {
        this.f22894c.getUserStatus(str, str2, str3).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new n(this, aVar));
    }

    public void q(String str, String str2, kd.a<UserStatusEntity> aVar) {
        this.f22894c.getUserStatusForC2C(str, str2).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new o(this, aVar));
    }

    public void r(String str, kd.a<GroupInfoData> aVar) {
        v7.b.a().getGroupInfoData(str).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new p(aVar));
    }

    public void s(String str, String str2, kd.a<Object> aVar) {
        this.f22894c.groupNoticeDelete(MapsKt__MapsKt.m(kotlin.l.a("groupId", str), kotlin.l.a("id", str2))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new q(this, aVar));
    }

    public void t(String str, String str2, String str3, kd.a<Object> aVar) {
        this.f22894c.groupNoticeSettingTop(MapsKt__MapsKt.m(kotlin.l.a("groupId", str), kotlin.l.a("id", str2), kotlin.l.a("status", str3))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new r(this, aVar));
    }

    public void u(String str, String str2, kd.a<Object> aVar) {
        this.f22894c.hideGroupNoticeHintById(MapsKt__MapsKt.m(kotlin.l.a("groupId", str), kotlin.l.a("id", str2))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new s(this, aVar));
    }

    public void v(String str) {
        this.f22894c.liveAppointment(MapsKt__MapsKt.m(kotlin.l.a("liveId", str))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new t(this));
    }

    public void w(String str, String str2) {
        this.f22894c.recallInGroup(MapsKt__MapsKt.m(kotlin.l.a("groupId", str), kotlin.l.a("msgSeq", str2))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new u(this, str, str2));
    }

    public void x(String str, String str2, kd.a<Object> aVar) {
        this.f22894c.recallInGroupAll(MapsKt__MapsKt.m(kotlin.l.a("groupId", str), kotlin.l.a(Constants.FLAG_ACCOUNT, str2))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new v(this, str, str2, aVar));
    }

    public void y(String str, String str2, dd.a aVar) {
        this.f22894c.removeUserInGroup(MapsKt__MapsKt.m(kotlin.l.a("groupId", str), kotlin.l.a(Constants.FLAG_ACCOUNT, str2))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new w(this, aVar));
    }

    public void z() {
        this.f22894c.getRecallTime().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new x());
    }
}
