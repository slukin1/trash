package com.huobi.utils;

import android.content.Context;
import android.text.TextUtils;
import c6.d;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.inst.bean.InstStateInfo;
import com.hbg.lib.network.newkyc.bean.AuthInfoNew;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycStepState;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.entity.UserTransInfo;
import com.huobi.kyc.util.KycProxy;
import com.huobi.login.usercenter.data.source.bean.AccountUserInfo;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.main.helper.f;
import com.iproov.sdk.bridge.OptionsBridge;
import i6.k;
import java.util.List;
import jp.l;
import pro.huobi.R;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import tg.r;
import u6.g;

public final class UserInfoUtil {

    public static class KycStepState {

        /* renamed from: a  reason: collision with root package name */
        public String f83707a;

        /* renamed from: b  reason: collision with root package name */
        public String f83708b;

        /* renamed from: c  reason: collision with root package name */
        public int f83709c;

        /* renamed from: d  reason: collision with root package name */
        public UnifyKycStepState f83710d;
    }

    public class a extends EasySubscriber<AccountUserInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f83711b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c6.c f83712c;

        public a(Context context, c6.c cVar) {
            this.f83711b = context;
            this.f83712c = cVar;
        }

        /* renamed from: a */
        public void onNext(AccountUserInfo accountUserInfo) {
            if (accountUserInfo == null || (!TextUtils.isEmpty(r.x().s()) && (accountUserInfo.e() == null || !r.x().s().equals(accountUserInfo.e().i())))) {
                k.o("kycjudge", "loadUserInfo network error");
                return;
            }
            UserInfoUtil.i(accountUserInfo.h());
            r.x().y0(accountUserInfo.d());
            r.x().D0(accountUserInfo);
            UserInfoUtil.n(this.f83711b, accountUserInfo, this.f83712c);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            c6.c cVar = this.f83712c;
            if (cVar != null) {
                cVar.a(null, null);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            c6.c cVar = this.f83712c;
            if (cVar != null) {
                cVar.a(null, null);
            }
        }
    }

    public class b extends EasySubscriber<AccountUserInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f83713b;

        public b(d dVar) {
            this.f83713b = dVar;
        }

        /* renamed from: a */
        public void onNext(AccountUserInfo accountUserInfo) {
            super.onNext(accountUserInfo);
            r.x().c0(accountUserInfo.e());
            UserInfoUtil.o(accountUserInfo.e(), accountUserInfo.f(), accountUserInfo.g(), this.f83713b);
        }
    }

    public class c implements Func1<Boolean, Observable<AccountUserInfo>> {
        public static /* synthetic */ AccountUserInfo d(UserInfoData userInfoData, UserKycInfoNew userKycInfoNew, UserVO userVO) {
            AccountUserInfo accountUserInfo = new AccountUserInfo();
            accountUserInfo.m(userInfoData);
            accountUserInfo.n(userKycInfoNew);
            accountUserInfo.o(userVO);
            return accountUserInfo;
        }

        public static /* synthetic */ AccountUserInfo e(UserInfoData userInfoData, UserKycInfoNew userKycInfoNew) {
            AccountUserInfo accountUserInfo = new AccountUserInfo();
            accountUserInfo.m(userInfoData);
            accountUserInfo.n(userKycInfoNew);
            accountUserInfo.o((UserVO) null);
            return accountUserInfo;
        }

        /* renamed from: c */
        public Observable<AccountUserInfo> call(Boolean bool) {
            Observable<UserInfoData> subscribeOn = r.x().O(true).subscribeOn(Schedulers.io());
            Observable<UserKycInfoNew> subscribeOn2 = KycProxy.l().i(true).subscribeOn(Schedulers.io());
            if (bool.booleanValue()) {
                return Observable.zip(subscribeOn, subscribeOn2, l.q(true).subscribeOn(Schedulers.io()), b1.f83718b);
            }
            return Observable.zip(subscribeOn, subscribeOn2, a1.f83716b);
        }
    }

    public static /* synthetic */ AccountUserInfo f(UserInfoData userInfoData, UserKycInfoNew userKycInfoNew, UnifyKycInfo unifyKycInfo, Boolean bool, UserOtherInfoData userOtherInfoData) {
        AccountUserInfo accountUserInfo = new AccountUserInfo();
        accountUserInfo.m(userInfoData);
        accountUserInfo.n(userKycInfoNew);
        accountUserInfo.k(unifyKycInfo);
        accountUserInfo.i(bool.booleanValue());
        accountUserInfo.j(KycProxy.l().k());
        accountUserInfo.l(userOtherInfoData);
        return accountUserInfo;
    }

    public static void g(Context context, c6.c<UserTransInfo, UnifyKycInfo> cVar) {
        Observable.zip(r.x().O(false).subscribeOn(Schedulers.io()), KycProxy.l().i(false).subscribeOn(Schedulers.io()), KycProxy.l().n(false).retry(3).subscribeOn(Schedulers.io()), KycProxy.l().q(false).retry(3).subscribeOn(Schedulers.io()).onErrorReturn(y0.f83796b), f.c().g(), z0.f83801b).retry(3).onErrorResumeNext(Observable.just(null)).compose(RxJavaHelper.t((g) null)).subscribe(new a(context, cVar));
    }

    public static void h(g gVar, d<String, Boolean, List<Integer>, Integer> dVar) {
        Observable.just(Boolean.FALSE).flatMap(new c()).compose(RxJavaHelper.t(gVar)).subscribe(new b(dVar));
    }

    public static void i(boolean z11) {
        String b11 = !TextUtils.isEmpty(r.x().J()) ? f0.b(r.x().J()) : null;
        Object[] objArr = new Object[4];
        objArr[0] = "enid:";
        if (b11 == null) {
            b11 = "";
        }
        objArr[1] = b11;
        objArr[2] = " isInst:";
        objArr[3] = Boolean.valueOf(z11);
        k.o("kycjudge", AppUtil.b(objArr));
    }

    public static String j(UserKycInfoNew userKycInfoNew, UserInfoData userInfoData, UserOtherInfoData userOtherInfoData) {
        AuthInfoNew auth_info;
        if (userOtherInfoData != null && !TextUtils.isEmpty(userOtherInfoData.getNick_name())) {
            return userOtherInfoData.getNick_name();
        }
        String str = null;
        if (!(userKycInfoNew == null || (auth_info = userKycInfoNew.getAuth_info()) == null)) {
            if (auth_info.getPro_auth_type() == 10) {
                str = auth_info.getPro_org_name();
            } else {
                if (!TextUtils.isEmpty(auth_info.getPro_first_name())) {
                    str = auth_info.getPro_first_name();
                }
                if (!TextUtils.isEmpty(auth_info.getPro_last_name())) {
                    if (!TextUtils.isEmpty(str)) {
                        str = str + " " + auth_info.getPro_last_name();
                    } else {
                        str = auth_info.getPro_last_name();
                    }
                }
            }
        }
        if (userInfoData == null) {
            return "--";
        }
        if (TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(userInfoData.h())) {
                str = userInfoData.h();
            } else {
                str = userInfoData.e();
            }
        }
        return r.x().X() ? userInfoData.b() : str;
    }

    public static String k(Context context, int i11, int i12) {
        if (i11 == 1) {
            return context.getApplicationContext().getString(R.string.n_kyc_organization_inreview);
        }
        if (i11 == 3) {
            if (i12 == 1) {
                return context.getApplicationContext().getString(R.string.n_kyc_auth_inst_lv1);
            }
            if (i12 == 2) {
                return context.getApplicationContext().getString(R.string.n_kyc_auth_inst_lv2);
            }
            return context.getApplicationContext().getString(R.string.n_kyc_organization_authed);
        } else if (i11 == 4) {
            return context.getApplicationContext().getString(R.string.n_kyc_organization_auth_failed);
        } else {
            return context.getApplicationContext().getString(R.string.n_user_center_is_not_verify);
        }
    }

    public static String l(Context context, String str, int i11) {
        if (str == null) {
            if (i11 == 3) {
                return context.getApplicationContext().getString(R.string.n_kyc_authentication_fail);
            }
            if (i11 == 1) {
                return context.getApplicationContext().getString(R.string.n_kyc_authentication_verifying);
            }
            return context.getApplicationContext().getString(R.string.n_user_center_is_not_verify);
        } else if ("C0".equals(str)) {
            return "L1";
        } else {
            return ("C1".equals(str) || "GLOBAL_C1".equals(str)) ? "L2" : "L3";
        }
    }

    public static KycStepState m(UserKycInfoNew userKycInfoNew, UnifyKycInfo unifyKycInfo) {
        UnifyKycStepState unifyKycStepState;
        UnifyKycStepState unifyKycStepState2;
        UnifyKycStepState unifyKycStepState3;
        Object obj;
        Object obj2;
        Object obj3;
        KycStepState kycStepState = new KycStepState();
        if (unifyKycInfo == null || unifyKycInfo.getStepStates() == null) {
            unifyKycStepState3 = null;
            unifyKycStepState2 = null;
            unifyKycStepState = null;
        } else {
            unifyKycStepState3 = null;
            unifyKycStepState2 = null;
            unifyKycStepState = null;
            for (UnifyKycStepState next : unifyKycInfo.getStepStates()) {
                if ("C0".equals(next.getAuthStep())) {
                    unifyKycStepState = next;
                } else if ("C1".equals(next.getAuthStep())) {
                    unifyKycStepState2 = next;
                } else if ("C2".equals(next.getAuthStep())) {
                    unifyKycStepState3 = next;
                }
            }
        }
        AuthInfoNew auth_info = userKycInfoNew != null ? userKycInfoNew.getAuth_info() : null;
        if (unifyKycStepState3 != null && unifyKycStepState3.getAuthState() == 2) {
            kycStepState.f83707a = "C2";
        } else if (unifyKycStepState2 != null && unifyKycStepState2.getAuthState() == 2) {
            kycStepState.f83707a = "C1";
            kycStepState.f83708b = "C2";
            kycStepState.f83710d = unifyKycStepState3;
            if (unifyKycStepState3 != null) {
                kycStepState.f83709c = unifyKycStepState3.getAuthState();
            }
        } else if (unifyKycStepState != null && unifyKycStepState.getAuthState() == 2) {
            kycStepState.f83707a = "C0";
            kycStepState.f83708b = "C1";
            kycStepState.f83710d = unifyKycStepState2;
            if (unifyKycStepState2 != null) {
                kycStepState.f83709c = unifyKycStepState2.getAuthState();
            }
        } else if (auth_info == null || auth_info.getPro_status() != 2) {
            kycStepState.f83707a = null;
            kycStepState.f83708b = "C0";
            kycStepState.f83710d = unifyKycStepState;
            kycStepState.f83709c = 0;
        } else {
            kycStepState.f83707a = "GLOBAL_C1";
            kycStepState.f83708b = "C2";
            kycStepState.f83710d = unifyKycStepState3;
            if (unifyKycStepState3 != null) {
                kycStepState.f83709c = unifyKycStepState3.getAuthState();
            }
        }
        Object[] objArr = new Object[8];
        objArr[0] = "unifyStepInfoC2:";
        Object obj4 = OptionsBridge.NULL_VALUE;
        if (unifyKycStepState3 == null) {
            obj = obj4;
        } else {
            obj = Integer.valueOf(unifyKycStepState3.getAuthState());
        }
        objArr[1] = obj;
        objArr[2] = " unifyStepInfoC1:";
        if (unifyKycStepState2 == null) {
            obj2 = obj4;
        } else {
            obj2 = Integer.valueOf(unifyKycStepState2.getAuthState());
        }
        objArr[3] = obj2;
        objArr[4] = " unifyStepInfoC0:";
        if (unifyKycStepState == null) {
            obj3 = obj4;
        } else {
            obj3 = Integer.valueOf(unifyKycStepState.getAuthState());
        }
        objArr[5] = obj3;
        objArr[6] = " globalStepInfo:";
        if (auth_info != null) {
            obj4 = Integer.valueOf(auth_info.getPro_status());
        }
        objArr[7] = obj4;
        k.o("kycjudge", AppUtil.b(objArr));
        k.o("kycjudge", AppUtil.b("successKycStep:", kycStepState.f83707a, " nextStep:", kycStepState.f83708b, " nextStepState:", Integer.valueOf(kycStepState.f83709c)));
        return kycStepState;
    }

    public static void n(Context context, AccountUserInfo accountUserInfo, c6.c<UserTransInfo, UnifyKycInfo> cVar) {
        String str;
        boolean z11;
        if (cVar != null) {
            k.o("kycjudge", "showUserInfo start");
            UserOtherInfoData d11 = accountUserInfo.d();
            UserKycInfoNew f11 = accountUserInfo.f();
            UnifyKycInfo c11 = accountUserInfo.c();
            boolean h11 = accountUserInfo.h();
            InstStateInfo b11 = accountUserInfo.b();
            UserTransInfo userTransInfo = new UserTransInfo();
            userTransInfo.setInst(h11);
            String j11 = j(f11, accountUserInfo.e(), d11);
            if (!h11) {
                KycStepState m11 = m(f11, c11);
                String str2 = m11.f83707a;
                z11 = str2 == null;
                userTransInfo.setKycStep(str2);
                userTransInfo.setKycStateWithNoStep(m11.f83709c);
                str = l(context, m11.f83707a, m11.f83709c);
            } else {
                z11 = b11.getState().intValue() == 4;
                str = k(context, b11.getState().intValue(), b11.getLevelType());
                userTransInfo.setInstState(b11.getState().intValue());
                userTransInfo.setInstLevelType(b11.getLevelType());
            }
            if (f11 == null && b11 == null && c11 == null) {
                z11 = false;
            }
            if (r.x().X()) {
                str = "";
                z11 = false;
            }
            userTransInfo.setTitle(j11);
            if (d11 != null) {
                userTransInfo.setAvatarUrl(d11.getHead_image());
            }
            userTransInfo.setShowKycText(z11);
            userTransInfo.setKycStateLabel(str);
            k.o("kycjudge", AppUtil.b("showUserInfo onCallback currKycStep:", userTransInfo.getKycStep(), " kycState:", Integer.valueOf(userTransInfo.getKycStateWithNoStep()), " isInst:" + h11));
            p(j11, d11, f11, c11);
            cVar.a(userTransInfo, c11);
            k.o("kycjudge", "showUserInfo end");
        }
    }

    public static void o(UserInfoData userInfoData, UserKycInfoNew userKycInfoNew, UserVO userVO, d<String, Boolean, List<Integer>, Integer> dVar) {
        int i11;
        Integer num;
        String pro_last_name;
        String str = "";
        if (userKycInfoNew != null) {
            AuthInfoNew auth_info = userKycInfoNew.getAuth_info();
            if (auth_info == null || auth_info.getPro_auth_type() != 10) {
                if (!TextUtils.isEmpty(userKycInfoNew.getAuth_info().getPro_first_name())) {
                    str = userKycInfoNew.getAuth_info().getPro_first_name();
                }
                if (!TextUtils.isEmpty(userKycInfoNew.getAuth_info().getPro_last_name())) {
                    if (!TextUtils.isEmpty(str)) {
                        pro_last_name = str + " " + userKycInfoNew.getAuth_info().getPro_last_name();
                    } else {
                        pro_last_name = userKycInfoNew.getAuth_info().getPro_last_name();
                    }
                }
                i11 = auth_info.getPro_status();
            } else {
                pro_last_name = auth_info.getPro_org_name();
            }
            str = pro_last_name;
            i11 = auth_info.getPro_status();
        } else {
            i11 = -1;
        }
        boolean z11 = true;
        if (userVO != null) {
            if (userInfoData == null || !r.x().U()) {
            }
            z11 = false;
            num = Integer.valueOf(userVO.getRealBind());
        } else {
            if (i11 != 2) {
                z11 = false;
            }
            num = null;
        }
        if (userInfoData != null) {
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(userInfoData.h())) {
                    str = userInfoData.h();
                } else {
                    str = userInfoData.e();
                }
            }
            if (r.x().X()) {
                dVar.a(userInfoData.b(), Boolean.valueOf(z11), userInfoData.d(), num);
            } else {
                dVar.a(str, Boolean.valueOf(z11), userInfoData.d(), num);
            }
        } else {
            dVar.a("--", Boolean.valueOf(z11), null, num);
        }
    }

    public static void p(String str, UserOtherInfoData userOtherInfoData, UserKycInfoNew userKycInfoNew, UnifyKycInfo unifyKycInfo) {
        String str2;
        r.x().z0(str);
        if (userOtherInfoData != null) {
            if (TextUtils.equals(userOtherInfoData.getNick_name_type(), UserOtherInfoData.NICK_NAME_TYPE_DID)) {
                str2 = userOtherInfoData.getNick_name();
            } else {
                str2 = "";
            }
            r.x().m0(str2);
            r.x().j0(userOtherInfoData.getHead_image_type());
        } else {
            r.x().m0("");
            r.x().j0("");
        }
        if (unifyKycInfo != null && unifyKycInfo.getBaseInfo() != null && unifyKycInfo.getBaseInfo().getCountryId() != 0) {
            r.x().p0(unifyKycInfo.getBaseInfo().getCountryId() + "");
        } else if (userKycInfoNew == null || userKycInfoNew.getUser_info() == null || userKycInfoNew.getUser_info().getAuth_country() == null) {
            r.x().p0((String) null);
        } else {
            r.x().p0(userKycInfoNew.getUser_info().getAuth_country().get("2"));
        }
    }
}
