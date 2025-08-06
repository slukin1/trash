package cn.sharesdk.onekeyshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.kakao.story.KakaoStory;
import cn.sharesdk.kakao.talk.KakaoTalk;
import cn.sharesdk.line.Line;
import cn.sharesdk.telegram.Telegram;
import cn.sharesdk.whatsapp.WhatsApp;
import com.luck.picture.lib.config.PictureMimeType;
import com.mob.MobSDK;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class OnekeyShareThemeImpl implements PlatformActionListener, Handler.Callback {
    public PlatformActionListener callback = this;
    public Context context;
    public ArrayList<CustomerLogo> customerLogos;
    public ShareContentCustomizeCallback customizeCallback;
    public boolean dialogMode;
    public boolean disableSSO;
    public HashMap<String, String> hiddenPlatforms;
    public HashMap<String, Object> shareParamsMap;
    public boolean silent;

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0064, code lost:
        if (r13 != false) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0098, code lost:
        if (r13 != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ff, code lost:
        if (r13 != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0150, code lost:
        if (r13 != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x019a, code lost:
        if (r13 != false) goto L_0x009a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dealShareParamsMap(boolean r13) {
        /*
            r12 = this;
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            java.lang.String r1 = "shareType"
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x01a7
            r0 = 1
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r12.shareParamsMap
            java.lang.String r3 = "imagePath"
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r12.shareParamsMap
            java.lang.String r4 = "videoPath"
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r12.shareParamsMap
            java.lang.String r5 = "filePath"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.io.File r5 = new java.io.File
            r5.<init>(r2)
            boolean r5 = r5.exists()
            r6 = 9
            java.lang.String r7 = ".gif"
            r8 = 5
            r9 = 2
            r10 = 4
            java.lang.String r11 = "url"
            if (r5 == 0) goto L_0x006a
            boolean r0 = r2.endsWith(r7)
            if (r0 == 0) goto L_0x004e
            if (r13 == 0) goto L_0x004e
        L_0x004b:
            r0 = r6
            goto L_0x019e
        L_0x004e:
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto L_0x0067
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            java.lang.Object r0 = r0.get(r11)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0067
            if (r13 == 0) goto L_0x0067
            goto L_0x009d
        L_0x0067:
            r0 = r9
            goto L_0x019e
        L_0x006a:
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r12.shareParamsMap
            boolean r2 = r2.containsKey(r11)
            java.lang.String r5 = "musicUrl"
            if (r2 == 0) goto L_0x00a0
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r12.shareParamsMap
            java.lang.Object r2 = r2.get(r11)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00a0
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            boolean r0 = r0.containsKey(r5)
            if (r0 == 0) goto L_0x009d
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x009d
            if (r13 == 0) goto L_0x009d
        L_0x009a:
            r0 = r8
            goto L_0x019e
        L_0x009d:
            r0 = r10
            goto L_0x019e
        L_0x00a0:
            java.io.File r2 = new java.io.File
            r2.<init>(r3)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x00ae
            r0 = 6
            goto L_0x019e
        L_0x00ae:
            java.io.File r2 = new java.io.File
            r2.<init>(r4)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x00bd
            r0 = 8
            goto L_0x019e
        L_0x00bd:
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r12.shareParamsMap
            java.lang.String r3 = "viewToShare"
            java.lang.Object r2 = r2.get(r3)
            java.lang.Object r2 = com.mob.tools.utils.ResHelper.forceCast(r2)
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            if (r2 == 0) goto L_0x0102
            boolean r2 = r2.isRecycled()
            if (r2 != 0) goto L_0x0102
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto L_0x0067
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            java.lang.Object r0 = r0.get(r11)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0067
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            boolean r0 = r0.containsKey(r5)
            if (r0 == 0) goto L_0x009d
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x009d
            if (r13 == 0) goto L_0x009d
        L_0x0101:
            goto L_0x009a
        L_0x0102:
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r12.shareParamsMap
            java.lang.String r3 = "imageUrl"
            java.lang.Object r2 = r2.get(r3)
            if (r2 == 0) goto L_0x0154
            java.lang.String r3 = java.lang.String.valueOf(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0154
            java.lang.String r0 = java.lang.String.valueOf(r2)
            boolean r0 = r0.endsWith(r7)
            if (r0 == 0) goto L_0x0124
            if (r13 == 0) goto L_0x0124
            goto L_0x004b
        L_0x0124:
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto L_0x0067
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            java.lang.Object r0 = r0.get(r11)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0067
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            boolean r0 = r0.containsKey(r5)
            if (r0 == 0) goto L_0x009d
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x009d
            if (r13 == 0) goto L_0x009d
            goto L_0x009a
        L_0x0154:
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r12.shareParamsMap
            java.lang.String r4 = "imageData"
            java.lang.Object r3 = r3.get(r4)
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3
            if (r3 == 0) goto L_0x019e
            java.lang.String r0 = java.lang.String.valueOf(r2)
            boolean r0 = r0.endsWith(r7)
            if (r0 == 0) goto L_0x016e
            if (r13 == 0) goto L_0x016e
            goto L_0x004b
        L_0x016e:
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto L_0x0067
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            java.lang.Object r0 = r0.get(r11)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0067
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            boolean r0 = r0.containsKey(r5)
            if (r0 == 0) goto L_0x009d
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r12.shareParamsMap
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x009d
            if (r13 == 0) goto L_0x009d
            goto L_0x0101
        L_0x019e:
            java.util.HashMap<java.lang.String, java.lang.Object> r13 = r12.shareParamsMap
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r13.put(r1, r0)
        L_0x01a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.dealShareParamsMap(boolean):void");
    }

    /* access modifiers changed from: private */
    public void prepareForEditPage(final Platform platform) {
        formateShareData(platform, new ShareSDKCallback<Boolean>() {
            public void onCallback(Boolean bool) {
                Platform.ShareParams shareDataToShareParams;
                if (bool.booleanValue() && (shareDataToShareParams = OnekeyShareThemeImpl.this.shareDataToShareParams(platform)) != null) {
                    ShareSDK.logDemoEvent(3, platform);
                    shareDataToShareParams.setOpenCustomEven(true);
                    ShareContentCustomizeCallback shareContentCustomizeCallback = OnekeyShareThemeImpl.this.customizeCallback;
                    if (shareContentCustomizeCallback != null) {
                        shareContentCustomizeCallback.onShare(platform, shareDataToShareParams);
                    }
                    OnekeyShareThemeImpl onekeyShareThemeImpl = OnekeyShareThemeImpl.this;
                    onekeyShareThemeImpl.showEditPage(onekeyShareThemeImpl.context, platform, shareDataToShareParams);
                    OnekeyShareThemeImpl.this.customizeCallback = null;
                }
            }
        });
    }

    private void realCallback(Platform platform, final ShareSDKCallback<Boolean> shareSDKCallback, final boolean z11, final String str) {
        platform.isClientValid(new ShareSDKCallback<Boolean>() {
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    OnekeyShareThemeImpl.this.dealShareParamsMap(z11);
                    ShareSDKCallback shareSDKCallback = shareSDKCallback;
                    if (shareSDKCallback != null) {
                        shareSDKCallback.onCallback(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                OnekeyShareThemeImpl.this.toast(str);
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(Boolean.FALSE);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void toast(final String str) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() {
            public boolean handleMessage(Message message) {
                int stringRes = ResHelper.getStringRes(OnekeyShareThemeImpl.this.context, str);
                if (stringRes > 0) {
                    Toast.makeText(OnekeyShareThemeImpl.this.context, stringRes, 0).show();
                } else {
                    Toast.makeText(OnekeyShareThemeImpl.this.context, str, 0).show();
                }
                return false;
            }
        });
    }

    public final void disableSSO() {
        this.disableSSO = true;
    }

    public final void formateShareData(Platform platform, ShareSDKCallback<Boolean> shareSDKCallback) {
        String name = platform.getName();
        if ("Alipay".equals(name) || "AlipayMoments".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_alipay_client_inavailable");
        } else if (KakaoTalk.NAME.equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_kakaotalk_client_inavailable");
        } else if (KakaoStory.NAME.equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_kakaostory_client_inavailable");
        } else if (Line.NAME.equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_line_client_inavailable");
        } else if (WhatsApp.NAME.equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_whatsapp_client_inavailable");
        } else if ("Pinterest".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_pinterest_client_inavailable");
        } else if ("Instagram".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_instagram_client_inavailable");
        } else if ("QZone".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_qq_client_inavailable");
        } else if ("Laiwang".equals(name) || "LaiwangMoments".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_laiwang_client_inavailable");
        } else if ("YixinMoments".equals(name) || "Yixin".equals(name)) {
            realCallback(platform, shareSDKCallback, false, "ssdk_yixin_client_inavailable");
        } else if ("WechatFavorite".equals(name) || "Wechat".equals(name) || "WechatMoments".equals(name)) {
            realCallback(platform, shareSDKCallback, true, "ssdk_wechat_client_inavailable");
        } else if ("FacebookMessenger".equals(name)) {
            realCallback(platform, shareSDKCallback, true, "ssdk_facebookmessenger_client_inavailable");
        } else if (Telegram.NAME.equals(name)) {
            realCallback(platform, shareSDKCallback, true, "ssdk_telegram_client_inavailable");
        } else {
            dealShareParamsMap(false);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.TRUE);
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i11 = message.arg1;
        if (i11 == 1) {
            int stringRes = ResHelper.getStringRes(this.context, "ssdk_oks_share_completed");
            if (stringRes <= 0) {
                return false;
            }
            toast(this.context.getString(stringRes));
            return false;
        } else if (i11 == 2) {
            String simpleName = message.obj.getClass().getSimpleName();
            if ("WechatClientNotExistException".equals(simpleName) || "WechatTimelineNotSupportedException".equals(simpleName) || "WechatFavoriteNotSupportedException".equals(simpleName)) {
                toast("ssdk_wechat_client_inavailable");
                return false;
            } else if ("GooglePlusClientNotExistException".equals(simpleName)) {
                toast("ssdk_google_plus_client_inavailable");
                return false;
            } else if ("QQClientNotExistException".equals(simpleName)) {
                toast("ssdk_qq_client_inavailable");
                return false;
            } else if ("YixinClientNotExistException".equals(simpleName) || "YixinTimelineNotSupportedException".equals(simpleName)) {
                toast("ssdk_yixin_client_inavailable");
                return false;
            } else if ("KakaoTalkClientNotExistException".equals(simpleName)) {
                toast("ssdk_kakaotalk_client_inavailable");
                return false;
            } else if ("KakaoStoryClientNotExistException".equals(simpleName)) {
                toast("ssdk_kakaostory_client_inavailable");
                return false;
            } else if ("WhatsAppClientNotExistException".equals(simpleName)) {
                toast("ssdk_whatsapp_client_inavailable");
                return false;
            } else if ("FacebookMessengerClientNotExistException".equals(simpleName)) {
                toast("ssdk_facebookmessenger_client_inavailable");
                return false;
            } else {
                toast("ssdk_oks_share_failed");
                return false;
            }
        } else if (i11 != 3) {
            return false;
        } else {
            toast("ssdk_oks_share_canceled");
            return false;
        }
    }

    public final void isUseClientToShare(Platform platform, final ShareSDKCallback<Boolean> shareSDKCallback) {
        if (platform != null) {
            String name = platform.getName();
            if ("SinaWeibo".equals(name) || "Wechat".equals(name) || "WechatMoments".equals(name) || "WechatFavorite".equals(name) || "ShortMessage".equals(name) || "Email".equals(name) || "Qzone".equals(name) || "QQ".equals(name) || "Pinterest".equals(name) || "Instagram".equals(name) || "Yixin".equals(name) || "YixinMoments".equals(name) || "QZone".equals(name) || "Mingdao".equals(name) || Line.NAME.equals(name) || KakaoStory.NAME.equals(name) || KakaoTalk.NAME.equals(name) || "Bluetooth".equals(name) || WhatsApp.NAME.equals(name) || "BaiduTieba".equals(name) || "Laiwang".equals(name) || "LaiwangMoments".equals(name) || "Alipay".equals(name) || "AlipayMoments".equals(name) || "FacebookMessenger".equals(name) || "GooglePlus".equals(name) || "Dingding".equals(name) || "Youtube".equals(name) || "Meipai".equals(name) || Telegram.NAME.equals(name) || "Douyin".equals(name) || "Oasis".equals(name) || "Tiktok".equals(name) || "Pocket".equals(name)) {
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.TRUE);
                }
            } else if ("Evernote".equals(name)) {
                if ("true".equals(platform.getDevinfo("ShareByAppClient"))) {
                    if (shareSDKCallback != null) {
                        shareSDKCallback.onCallback(Boolean.TRUE);
                    }
                } else if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.FALSE);
                }
            } else if ("Facebook".equals(name)) {
                final boolean equals = "true".equals(platform.getDevinfo("ShareByAppClient"));
                platform.isClientValid(new ShareSDKCallback<Boolean>() {
                    public void onCallback(Boolean bool) {
                        if (equals && bool.booleanValue()) {
                            ShareSDKCallback shareSDKCallback = shareSDKCallback;
                            if (shareSDKCallback != null) {
                                shareSDKCallback.onCallback(Boolean.TRUE);
                            }
                        } else if (!OnekeyShareThemeImpl.this.shareParamsMap.containsKey("url") || TextUtils.isEmpty((String) OnekeyShareThemeImpl.this.shareParamsMap.get("url"))) {
                            ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                            if (shareSDKCallback2 != null) {
                                shareSDKCallback2.onCallback(Boolean.FALSE);
                            }
                        } else {
                            ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                            if (shareSDKCallback3 != null) {
                                shareSDKCallback3.onCallback(Boolean.TRUE);
                            }
                        }
                    }
                });
            } else if ("LinkedIn".equals(name)) {
                final boolean equals2 = "true".equals(platform.getDevinfo("ShareByAppClient"));
                platform.isClientValid(new ShareSDKCallback<Boolean>() {
                    public void onCallback(Boolean bool) {
                        if (!equals2 || !bool.booleanValue()) {
                            ShareSDKCallback shareSDKCallback = shareSDKCallback;
                            if (shareSDKCallback != null) {
                                shareSDKCallback.onCallback(Boolean.FALSE);
                                return;
                            }
                            return;
                        }
                        ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                        if (shareSDKCallback2 != null) {
                            shareSDKCallback2.onCallback(Boolean.TRUE);
                        }
                    }
                });
            } else if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        } else if (shareSDKCallback != null) {
            shareSDKCallback.onCallback(Boolean.FALSE);
        }
    }

    public final void onCancel(Platform platform, int i11) {
        Message message = new Message();
        message.arg1 = 3;
        message.arg2 = i11;
        message.obj = platform;
        UIHandler.sendMessage(message, this);
        ShareSDK.logDemoEvent(5, platform);
    }

    public final void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
        Message message = new Message();
        message.arg1 = 1;
        message.arg2 = i11;
        message.obj = platform;
        UIHandler.sendMessage(message, this);
    }

    public final void onError(Platform platform, int i11, Throwable th2) {
        th2.printStackTrace();
        Message message = new Message();
        message.arg1 = 2;
        message.arg2 = i11;
        message.obj = th2;
        UIHandler.sendMessage(message, this);
        ShareSDK.logDemoEvent(4, platform);
    }

    public final void setCustomerLogos(ArrayList<CustomerLogo> arrayList) {
        this.customerLogos = arrayList;
    }

    public final void setDialogMode(boolean z11) {
        this.dialogMode = z11;
    }

    public final void setHiddenPlatforms(HashMap<String, String> hashMap) {
        this.hiddenPlatforms = hashMap;
    }

    public final void setPlatformActionListener(PlatformActionListener platformActionListener) {
        if (platformActionListener == null) {
            platformActionListener = this;
        }
        this.callback = platformActionListener;
    }

    public final void setShareContentCustomizeCallback(ShareContentCustomizeCallback shareContentCustomizeCallback) {
        this.customizeCallback = shareContentCustomizeCallback;
    }

    public final void setShareParamsMap(HashMap<String, Object> hashMap) {
        this.shareParamsMap = hashMap;
    }

    public final void setSilent(boolean z11) {
        this.silent = z11;
    }

    public final Platform.ShareParams shareDataToShareParams(Platform platform) {
        HashMap<String, Object> hashMap;
        if (platform == null || (hashMap = this.shareParamsMap) == null) {
            toast("ssdk_oks_share_failed");
            return null;
        }
        try {
            Bitmap bitmap = (Bitmap) ResHelper.forceCast(this.shareParamsMap.get("viewToShare"));
            if (TextUtils.isEmpty((String) ResHelper.forceCast(hashMap.get(InnerShareParams.IMAGE_PATH))) && bitmap != null && !bitmap.isRecycled()) {
                String cachePath = ResHelper.getCachePath(MobSDK.getContext(), "screenshot");
                File file = new File(cachePath, String.valueOf(System.currentTimeMillis()) + PictureMimeType.JPG);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                this.shareParamsMap.put(InnerShareParams.IMAGE_PATH, file.getAbsolutePath());
            }
            return new Platform.ShareParams(this.shareParamsMap);
        } catch (Throwable th2) {
            th2.printStackTrace();
            toast("ssdk_oks_share_failed");
            return null;
        }
    }

    public final void shareSilently(final Platform platform) {
        formateShareData(platform, new ShareSDKCallback<Boolean>() {
            public void onCallback(Boolean bool) {
                Platform.ShareParams shareDataToShareParams;
                if (bool.booleanValue() && (shareDataToShareParams = OnekeyShareThemeImpl.this.shareDataToShareParams(platform)) != null) {
                    HashMap<String, Object> hashMap = OnekeyShareThemeImpl.this.shareParamsMap;
                    if (hashMap != null) {
                        if (!Boolean.valueOf(hashMap.containsKey("disappearsharetoast") ? ((Boolean) OnekeyShareThemeImpl.this.shareParamsMap.get("disappearsharetoast")).booleanValue() : false).booleanValue()) {
                            OnekeyShareThemeImpl.this.toast("ssdk_oks_sharing");
                        }
                    }
                    ShareContentCustomizeCallback shareContentCustomizeCallback = OnekeyShareThemeImpl.this.customizeCallback;
                    if (shareContentCustomizeCallback != null) {
                        shareContentCustomizeCallback.onShare(platform, shareDataToShareParams);
                    }
                    boolean z11 = OnekeyShareThemeImpl.this.disableSSO;
                    if (z11) {
                        platform.SSOSetting(z11);
                    }
                    platform.setPlatformActionListener(OnekeyShareThemeImpl.this.callback);
                    platform.share(shareDataToShareParams);
                    OnekeyShareThemeImpl onekeyShareThemeImpl = OnekeyShareThemeImpl.this;
                    onekeyShareThemeImpl.callback = null;
                    onekeyShareThemeImpl.customizeCallback = null;
                }
            }
        });
    }

    public final void show(Context context2) {
        this.context = context2;
        if (this.shareParamsMap.containsKey("platform")) {
            final Platform platform = null;
            try {
                platform = ShareSDK.getPlatform(String.valueOf(this.shareParamsMap.get("platform")));
            } catch (Throwable unused) {
            }
            final boolean z11 = platform instanceof CustomPlatform;
            isUseClientToShare(platform, new ShareSDKCallback<Boolean>() {
                public void onCallback(Boolean bool) {
                    if (OnekeyShareThemeImpl.this.silent || z11 || bool.booleanValue()) {
                        OnekeyShareThemeImpl.this.shareSilently(platform);
                    } else {
                        OnekeyShareThemeImpl.this.prepareForEditPage(platform);
                    }
                }
            });
            return;
        }
        showPlatformPage(context2);
    }

    public abstract void showEditPage(Context context2, Platform platform, Platform.ShareParams shareParams);

    public abstract void showPlatformPage(Context context2);
}
