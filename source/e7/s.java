package e7;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.imsdk.HbgDialogPageBean;
import com.hbg.lib.network.hbg.core.bean.HbgDialogAppVersion;
import com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo;
import com.hbg.lib.network.hbg.core.bean.HbgDialogShowFrequency;
import com.hbg.lib.network.pro.core.util.Period;
import com.huobi.utils.ReviewManger;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.mipush.sdk.Constants;
import i6.d;
import i6.k;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import oa.a;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final String f70071a = "s";

    /* renamed from: b  reason: collision with root package name */
    public static final Map<Long, HbgDialogConfigInfo> f70072b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final List<HbgDialogConfigInfo> f70073c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, HbgDialogPageBean> f70074d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static Map<Integer, HbgDialogConfigInfo> f70075e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static long f70076f;

    public static void a(long j11) {
        HbgDialogConfigInfo hbgDialogConfigInfo = f70072b.get(Long.valueOf(j11));
        if (hbgDialogConfigInfo != null && hbgDialogConfigInfo.positionType != 4) {
            k(hbgDialogConfigInfo, f70076f);
        }
    }

    public static void b(HbgDialogConfigInfo hbgDialogConfigInfo) {
        List<HbgDialogConfigInfo> list = f70073c;
        list.remove(hbgDialogConfigInfo);
        list.add(0, hbgDialogConfigInfo);
        f70072b.put(Long.valueOf(hbgDialogConfigInfo.dialogId), hbgDialogConfigInfo);
    }

    public static boolean c(HbgDialogConfigInfo hbgDialogConfigInfo) {
        boolean z11 = true;
        if (hbgDialogConfigInfo.showCount == 0) {
            return true;
        }
        if (ConfigPreferences.f("user_config", hbgDialogConfigInfo.dialogId + "_" + "config_hbg_dialog_last_show_number") >= hbgDialogConfigInfo.showCount) {
            z11 = false;
        }
        if (!z11) {
            d.c(f70071a, "不满足弹出条件 : 弹出次数已满");
        }
        return z11;
    }

    public static boolean d(HbgDialogConfigInfo hbgDialogConfigInfo, long j11) {
        long j12;
        long j13;
        if (ReviewManger.a()) {
            return false;
        }
        Activity b11 = a.g().b();
        if ((b11 instanceof FragmentActivity) && g(((FragmentActivity) b11).getSupportFragmentManager())) {
            return false;
        }
        if (hbgDialogConfigInfo.localShow) {
            return true;
        }
        boolean a11 = HbgDialogManager.A().z() != null ? HbgDialogManager.A().z().a() : false;
        String curLanguageHeader = AppLanguageHelper.getInstance().getCurLanguageHeader();
        List<String> list = hbgDialogConfigInfo.languageBlacklist;
        if (list != null) {
            for (String equalsIgnoreCase : list) {
                if (curLanguageHeader.equalsIgnoreCase(equalsIgnoreCase)) {
                    d.c(f70071a, "不满足弹出条件 : 语言黑名单");
                    return false;
                }
            }
        }
        List<Integer> list2 = hbgDialogConfigInfo.deviceType;
        if (list2 == null || !list2.contains(2)) {
            d.c(f70071a, "不满足弹出条件 : 设备类型不匹配");
            return false;
        }
        HbgDialogAppVersion hbgDialogAppVersion = hbgDialogConfigInfo.appVersion;
        if (hbgDialogAppVersion != null) {
            int i11 = hbgDialogAppVersion.matchType;
            List<String> list3 = hbgDialogAppVersion.version;
            if (list3 != null && !list3.isEmpty()) {
                String e11 = BaseApplication.e();
                if (i11 == -1) {
                    try {
                        if (Integer.parseInt(e11.replace(InstructionFileId.DOT, "")) > Integer.parseInt(list3.get(0).replace(InstructionFileId.DOT, ""))) {
                            d.c(f70071a, "不满足弹出条件 : MATCH_TYPE_LOWER");
                            return false;
                        }
                    } catch (Exception unused) {
                    }
                } else if (i11 == 1) {
                    try {
                        int e12 = e(e11, list3.get(0));
                        if (e12 == -1 || e12 == 0) {
                            d.c(f70071a, "不满足弹出条件 : MATCH_TYPE_HIGHER");
                            return false;
                        }
                    } catch (Exception unused2) {
                    }
                } else if (!list3.contains(e11)) {
                    d.c(f70071a, "不满足弹出条件 : MATCH_TYPE_EQUAL");
                    return false;
                }
            }
        }
        if (hbgDialogConfigInfo.positionType == 4) {
            return true;
        }
        int i12 = hbgDialogConfigInfo.showNotLogin;
        if (i12 == 0 && !a11) {
            d.c(f70071a, "不满足弹出条件 : notLoginShow");
            return false;
        }
        if (i12 == 2 && a11) {
            d.c(f70071a, "不满足弹出条件 : loginNotShow");
            return false;
        }
        Activity f11 = i.h().f();
        Fragment g11 = i.h().g();
        ArrayList arrayList = new ArrayList();
        List<Integer> list4 = hbgDialogConfigInfo.pageIds;
        if (list4 != null) {
            for (Integer intValue : list4) {
                HbgDialogPageBean hbgDialogPageBean = f70074d.get(Integer.valueOf(intValue.intValue()));
                if (hbgDialogPageBean != null) {
                    arrayList.add(hbgDialogPageBean.name);
                }
            }
        }
        if (arrayList.size() == 0) {
            HbgDialogPageBean hbgDialogPageBean2 = f70074d.get(hbgDialogConfigInfo.pageId);
            if (hbgDialogPageBean2 == null) {
                return false;
            }
            if (!hbgDialogPageBean2.isActivity) {
                List<Integer> list5 = hbgDialogConfigInfo.pageIds;
                if (list5 == null || list5.size() <= 0) {
                    if (g11 == null || !hbgDialogPageBean2.name.equals(g11.getClass().getName())) {
                        d.c(f70071a, "不满足弹出条件 : Fragment不匹配");
                        return false;
                    }
                } else if (g11 == null || !h(g11, hbgDialogConfigInfo.pageIds)) {
                    d.c(f70071a, "不满足弹出条件 : Fragment不匹配");
                    return false;
                }
            } else if (f11 == null) {
                return false;
            } else {
                String str = hbgDialogPageBean2.name;
                Objects.requireNonNull(f.a());
                if (str.startsWith("EdgeEngine#")) {
                    String str2 = hbgDialogPageBean2.name;
                    StringBuilder sb2 = new StringBuilder();
                    Objects.requireNonNull(f.a());
                    sb2.append("EdgeEngine#");
                    sb2.append(f.a().b());
                    if (!str2.equals(sb2.toString())) {
                        d.c(f70071a, "不满足弹出条件 : 容器页面不匹配");
                        return false;
                    }
                } else if (!hbgDialogPageBean2.name.equals(f11.getClass().getName())) {
                    d.c(f70071a, "不满足弹出条件 : Activity不匹配");
                    return false;
                }
            }
        } else if (!arrayList.contains(f11.getClass().getName()) && !arrayList.contains(g11.getClass().getName())) {
            d.c(f70071a, "不满足弹出条件 : 不在指定界面不显示");
            return false;
        }
        if (hbgDialogConfigInfo.operation == 3) {
            d.c(f70071a, "不满足弹出条件 : OPERATION_DELETE");
            return false;
        } else if (j11 > hbgDialogConfigInfo.endTime || j11 < hbgDialogConfigInfo.startTime) {
            String str3 = f70071a;
            d.c(str3, "不满足弹出条件 : currentTime问题");
            d.c(str3, "currentTime : " + j11);
            d.c(str3, "startTime : " + hbgDialogConfigInfo.startTime);
            d.c(str3, "endTime : " + hbgDialogConfigInfo.endTime);
            d.c(str3, "info : " + hbgDialogConfigInfo.dialogId + Constants.ACCEPT_TIME_SEPARATOR_SP + hbgDialogConfigInfo.positionType);
            return false;
        } else {
            int i13 = hbgDialogConfigInfo.showType;
            if (i13 == 1) {
                long j14 = hbgDialogConfigInfo.showTime;
                if (j11 <= j14 || Math.abs(j11 - j14) > 1000) {
                    return false;
                }
                return true;
            } else if (i13 == 2) {
                return c(hbgDialogConfigInfo);
            } else {
                if (i13 != 3) {
                    return false;
                }
                long h11 = ConfigPreferences.h("user_config", hbgDialogConfigInfo.dialogId + "_" + "config_hbg_dialog_last_show_time");
                HbgDialogShowFrequency hbgDialogShowFrequency = hbgDialogConfigInfo.showFrequency;
                if (hbgDialogShowFrequency == null || hbgDialogShowFrequency.unitType.length() <= 0) {
                    return false;
                }
                if (MTPushConstants.NotificationTime.KEY_DAYS.equals(hbgDialogShowFrequency.unitType)) {
                    j13 = (long) (hbgDialogShowFrequency.step * com.adjust.sdk.Constants.ONE_HOUR);
                    j12 = 24;
                } else {
                    j13 = (long) hbgDialogShowFrequency.step;
                    j12 = Period.MIN60_MILLS;
                }
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(j11);
                Calendar instance2 = Calendar.getInstance();
                instance2.setTimeInMillis(h11 + (j13 * j12));
                int i14 = instance.get(1) - instance2.get(1);
                if (i14 > 0) {
                    return true;
                }
                if (i14 < 0) {
                    return false;
                }
                int i15 = instance.get(2) - instance2.get(2);
                if (i15 > 0) {
                    return true;
                }
                if (i15 < 0) {
                    return false;
                }
                int i16 = instance.get(6) - instance2.get(6);
                if (i16 > 0) {
                    return true;
                }
                if (i16 < 0) {
                    return false;
                }
                int i17 = instance.get(11) - instance2.get(11);
                if (MTPushConstants.NotificationTime.KEY_DAYS.equals(hbgDialogShowFrequency.unitType)) {
                    return true;
                }
                if (!MessageKey.MSG_ACCEPT_TIME_HOUR.equals(hbgDialogShowFrequency.unitType) || i17 < 0) {
                    return false;
                }
                return true;
            }
        }
    }

    public static int e(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("[.]");
        String[] split2 = str2.split("[.]");
        int min = Math.min(split.length, split2.length);
        int i11 = 0;
        long j11 = 0;
        while (i11 < min) {
            j11 = Long.parseLong(split[i11]) - Long.parseLong(split2[i11]);
            if (j11 != 0) {
                break;
            }
            i11++;
        }
        int i12 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i12 == 0) {
            for (int i13 = i11; i13 < split.length; i13++) {
                if (Long.parseLong(split[i13]) > 0) {
                    return 1;
                }
            }
            while (i11 < split2.length) {
                if (Long.parseLong(split2[i11]) > 0) {
                    return -1;
                }
                i11++;
            }
            return 0;
        } else if (i12 > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void f(Map<String, HbgDialogPageBean> map) {
        f70074d.putAll(map);
    }

    public static boolean g(FragmentManager fragmentManager) {
        for (Fragment next : fragmentManager.B0()) {
            if ((next instanceof DialogFragment) && next.isVisible()) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(Fragment fragment, List<Integer> list) {
        for (Integer valueOf : list) {
            HbgDialogPageBean hbgDialogPageBean = f70074d.get(String.valueOf(valueOf));
            if (hbgDialogPageBean != null && hbgDialogPageBean.name.equals(fragment.getClass().getName())) {
                return true;
            }
        }
        return false;
    }

    public static void i(List<HbgDialogConfigInfo> list) {
        d.b("receiveMessage_PUSH:" + list.toString());
        k.o("GlobalFloatData_PUSH", " size:" + list.size() + " list:" + list.toString());
        HashMap hashMap = new HashMap();
        for (HbgDialogConfigInfo next : list) {
            hashMap.put(Long.valueOf(next.dialogId), next);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            Iterator<Map.Entry<Long, HbgDialogConfigInfo>> it2 = f70072b.entrySet().iterator();
            while (it2.hasNext()) {
                if (((Long) entry.getKey()).longValue() == ((Long) it2.next().getKey()).longValue()) {
                    it2.remove();
                }
            }
        }
        f70072b.putAll(hashMap);
        for (HbgDialogConfigInfo next2 : list) {
            int i11 = next2.updateStrategy;
            String str = next2.pageId;
            long j11 = next2.dialogId;
            int i12 = next2.positionType;
            Iterator<HbgDialogConfigInfo> it3 = f70073c.iterator();
            while (it3.hasNext()) {
                HbgDialogConfigInfo next3 = it3.next();
                String str2 = next3.pageId;
                long j12 = next3.dialogId;
                int i13 = next3.positionType;
                if (i11 == 1) {
                    if (str.equals(str2) && i12 == i13) {
                        it3.remove();
                    }
                } else if (j12 == j11) {
                    it3.remove();
                }
            }
        }
        List<HbgDialogConfigInfo> list2 = f70073c;
        list2.addAll(list);
        d.b("DATA_LIST_PUSH:" + list2.size());
    }

    public static void j(List<HbgDialogConfigInfo> list, long j11) {
        if (list != null) {
            HashMap hashMap = new HashMap();
            for (HbgDialogConfigInfo next : list) {
                hashMap.put(Long.valueOf(next.dialogId), next);
            }
            List<HbgDialogConfigInfo> list2 = f70073c;
            list2.clear();
            list2.addAll(list);
            for (HbgDialogConfigInfo hbgDialogConfigInfo : list2) {
                long j12 = hbgDialogConfigInfo.dialogId;
            }
            Map<Long, HbgDialogConfigInfo> map = f70072b;
            map.clear();
            map.putAll(hashMap);
            f70076f = j11;
        }
    }

    public static void k(HbgDialogConfigInfo hbgDialogConfigInfo, long j11) {
        int i11 = hbgDialogConfigInfo.showType;
        if (i11 == 2) {
            int f11 = ConfigPreferences.f("user_config", hbgDialogConfigInfo.dialogId + "_" + "config_hbg_dialog_last_show_number");
            ConfigPreferences.k("user_config", hbgDialogConfigInfo.dialogId + "_" + "config_hbg_dialog_last_show_number", f11 + 1);
        } else if (i11 == 3) {
            ConfigPreferences.l("user_config", hbgDialogConfigInfo.dialogId + "_" + "config_hbg_dialog_last_show_time", j11);
            int f12 = ConfigPreferences.f("user_config", hbgDialogConfigInfo.dialogId + "_" + "config_hbg_dialog_last_show_number");
            ConfigPreferences.k("user_config", hbgDialogConfigInfo.dialogId + "_" + "config_hbg_dialog_last_show_number", f12 + 1);
        }
    }

    public static void l(long j11) {
        d.b(j11 + "======");
        f70076f = j11;
    }
}
