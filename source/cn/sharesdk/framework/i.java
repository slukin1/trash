package cn.sharesdk.framework;

import android.app.Activity;
import android.os.Handler;
import cn.sharesdk.framework.a.b.c;
import cn.sharesdk.framework.a.d;
import cn.sharesdk.framework.authorize.a;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class i {
    public static ArrayList<Platform> a() {
        ArrayList<Platform> d11 = d();
        a(d11);
        return d11;
    }

    public static Activity b() {
        return a.c().b();
    }

    public static boolean c() {
        return a.c().a();
    }

    private static ArrayList<Platform> d() {
        String[] strArr = {"cn.sharesdk.douban.Douban", "cn.sharesdk.evernote.Evernote", "cn.sharesdk.facebook.Facebook", "cn.sharesdk.renren.Renren", "cn.sharesdk.sina.weibo.SinaWeibo", "cn.sharesdk.kaixin.KaiXin", "cn.sharesdk.linkedin.LinkedIn", "cn.sharesdk.system.email.Email", "cn.sharesdk.system.text.ShortMessage", "cn.sharesdk.tencent.qq.QQ", "cn.sharesdk.tencent.qzone.QZone", "cn.sharesdk.tencent.weibo.TencentWeibo", "cn.sharesdk.twitter.Twitter", "cn.sharesdk.wechat.friends.Wechat", "cn.sharesdk.wechat.moments.WechatMoments", "cn.sharesdk.wechat.favorite.WechatFavorite", "cn.sharesdk.youdao.YouDao", "cn.sharesdk.google.GooglePlus", "cn.sharesdk.foursquare.FourSquare", "cn.sharesdk.pinterest.Pinterest", "cn.sharesdk.flickr.Flickr", "cn.sharesdk.tumblr.Tumblr", "cn.sharesdk.dropbox.Dropbox", "cn.sharesdk.vkontakte.VKontakte", "cn.sharesdk.instagram.Instagram", "cn.sharesdk.yixin.friends.Yixin", "cn.sharesdk.yixin.moments.YixinMoments", "cn.sharesdk.mingdao.Mingdao", "cn.sharesdk.line.Line", "cn.sharesdk.kakao.story.KakaoStory", "cn.sharesdk.kakao.talk.KakaoTalk", "cn.sharesdk.whatsapp.WhatsApp", "cn.sharesdk.pocket.Pocket", "cn.sharesdk.instapaper.Instapaper", "cn.sharesdk.facebookmessenger.FacebookMessenger", "cn.sharesdk.alipay.friends.Alipay", "cn.sharesdk.alipay.moments.AlipayMoments", "cn.sharesdk.dingding.friends.Dingding", "cn.sharesdk.youtube.Youtube", "cn.sharesdk.meipai.Meipai", "cn.sharesdk.telegram.Telegram", "cn.sharesdk.cmcc.Cmcc", "cn.sharesdk.reddit.Reddit", "cn.sharesdk.telecom.Telecom", "cn.sharesdk.accountkit.Accountkit", "cn.sharesdk.douyin.Douyin", "cn.sharesdk.wework.Wework", "cn.sharesdk.oasis.Oasis", "cn.sharesdk.hwaccount.HWAccount", "cn.sharesdk.xmaccount.XMAccount", "cn.sharesdk.snapchat.Snapchat", "cn.sharesdk.littleredbook.Littleredbook", "cn.sharesdk.kuaishou.Kuaishou", "cn.sharesdk.watermelonvideo.Watermelonvideo", "cn.sharesdk.tiktok.Tiktok", "cn.sharesdk.taptap.Taptap", "cn.sharesdk.honoraccount.HonorAccount", "cn.sharesdk.threads.Threads"};
        ArrayList<Platform> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < 58; i11++) {
            String str = strArr[i11];
            try {
                arrayList.add((Platform) Class.forName(str).newInstance());
            } catch (Throwable unused) {
                SSDKLog.b().a("not found:" + str, new Object[0]);
            }
        }
        return arrayList;
    }

    public static void a(ArrayList<Platform> arrayList) {
        if (arrayList != null) {
            Collections.sort(arrayList, new Comparator<Platform>() {
                /* renamed from: a */
                public int compare(Platform platform, Platform platform2) {
                    int platformId;
                    int platformId2;
                    if (platform.getSortId() != platform2.getSortId()) {
                        platformId = platform.getSortId();
                        platformId2 = platform2.getSortId();
                    } else {
                        platformId = platform.getPlatformId();
                        platformId2 = platform2.getPlatformId();
                    }
                    return platformId - platformId2;
                }
            });
        }
    }

    public static void a(Activity activity) {
        a c11 = a.c();
        if (c11 != null) {
            c11.a(activity);
        }
    }

    public static void a(boolean z11) {
        a c11 = a.c();
        if (c11 != null) {
            c11.a(z11);
        }
    }

    public static void a(Handler handler) {
        d a11 = d.a();
        if (a11 != null) {
            a11.a(handler);
            a11.c();
        }
    }

    public static void a(int i11, Platform platform) {
        cn.sharesdk.framework.a.b.d dVar = new cn.sharesdk.framework.a.b.d();
        if (i11 == 1) {
            dVar.f13348a = "SHARESDK_ENTER_SHAREMENU";
        } else if (i11 == 2) {
            dVar.f13348a = "SHARESDK_CANCEL_SHAREMENU";
        } else if (i11 == 3) {
            dVar.f13348a = "SHARESDK_EDIT_SHARE";
        } else if (i11 == 4) {
            dVar.f13348a = "SHARESDK_FAILED_SHARE";
        } else if (i11 == 5) {
            dVar.f13348a = "SHARESDK_CANCEL_SHARE";
        }
        if (platform != null) {
            dVar.f13349b = platform.getPlatformId();
        }
        d a11 = d.a();
        if (a11 != null) {
            a11.a((c) dVar);
        }
    }

    public static void a(String str, int i11) {
        d a11 = d.a();
        if (a11 != null) {
            cn.sharesdk.framework.a.b.a aVar = new cn.sharesdk.framework.a.b.a();
            aVar.f13331b = str;
            aVar.f13330a = i11;
            a11.a((c) aVar);
        }
    }

    public static HashMap<Integer, HashMap<String, Object>> a(HashMap<String, Object> hashMap) {
        int i11;
        HashMap<Integer, HashMap<String, Object>> hashMap2 = null;
        if (hashMap != null && hashMap.size() > 0) {
            ArrayList arrayList = (ArrayList) hashMap.get("fakelist");
            if (arrayList == null) {
                return null;
            }
            hashMap2 = new HashMap<>();
            EventRecorder.addBegin(OnekeyShare.SHARESDK_TAG, "parseDevInfo");
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                HashMap hashMap3 = (HashMap) it2.next();
                if (hashMap3 != null) {
                    try {
                        i11 = ResHelper.parseInt(String.valueOf(hashMap3.get("snsplat")));
                    } catch (Throwable th2) {
                        SSDKLog.b().b(th2);
                        i11 = -1;
                    }
                    if (i11 != -1) {
                        hashMap2.put(Integer.valueOf(i11), hashMap3);
                    }
                }
            }
            EventRecorder.addEnd(OnekeyShare.SHARESDK_TAG, "parseDevInfo");
        }
        return hashMap2;
    }
}
