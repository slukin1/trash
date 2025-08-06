package cn.sharesdk.whatsapp;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.a.b.f;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import java.io.File;
import java.util.HashMap;

public class WhatsApp extends Platform {
    public static final String NAME = "WhatsApp";

    /* renamed from: a  reason: collision with root package name */
    private a f13753a = new a(this);

    public WhatsApp() {
        this.pkgName = "com.whatsapp";
    }

    public boolean checkAuthorize(int i11, Object obj) {
        if (this.isClientValid) {
            return true;
        }
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener == null) {
            return false;
        }
        platformActionListener.onError(this, i11, new WhatsAppClientNotExistException());
        return false;
    }

    public void doAuthorize(String[] strArr) {
        if (this.isClientValid) {
            afterRegister(1, (Object) null);
            return;
        }
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onError(this, 1, new WhatsAppClientNotExistException());
        }
    }

    public void doCustomerProtocol(String str, String str2, int i11, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, i11);
        }
    }

    public void doShare(final Platform.ShareParams shareParams) {
        String text = shareParams.getText();
        String title = shareParams.getTitle();
        String filePath = shareParams.getFilePath();
        String address = shareParams.getAddress();
        try {
            String imagePath = shareParams.getImagePath();
            String imageUrl = shareParams.getImageUrl();
            AnonymousClass1 r72 = new PlatformActionListener() {
                public void onCancel(Platform platform, int i11) {
                    if (WhatsApp.this.listener != null) {
                        WhatsApp.this.listener.onCancel(platform, i11);
                    }
                }

                public void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
                    HashMap hashMap2 = new HashMap();
                    if (hashMap != null) {
                        hashMap2.putAll(hashMap);
                    }
                    hashMap2.put("ShareParams", shareParams);
                    if (WhatsApp.this.listener != null) {
                        WhatsApp.this.listener.onComplete(platform, i11, hashMap2);
                    }
                }

                public void onError(Platform platform, int i11, Throwable th2) {
                    if (WhatsApp.this.listener != null) {
                        WhatsApp.this.listener.onError(platform, i11, th2);
                    }
                }
            };
            if (!TextUtils.isEmpty(imagePath)) {
                this.f13753a.a(2, imagePath, text, r72);
            } else if (!TextUtils.isEmpty(imageUrl)) {
                File file = new File(BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl));
                if (file.exists()) {
                    imagePath = file.getAbsolutePath();
                }
                this.f13753a.a(2, imagePath, text, r72);
            } else if (!TextUtils.isEmpty(text)) {
                this.f13753a.a(text, title, r72);
            } else if (!TextUtils.isEmpty(filePath)) {
                this.f13753a.a(6, filePath, text, r72);
            } else if (!TextUtils.isEmpty(address)) {
                this.f13753a.a(address, r72);
            } else {
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this, 9, new Throwable("Missing parameters"));
                }
            }
        } catch (Throwable th2) {
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 9, th2);
            }
        }
    }

    public HashMap<String, Object> filterFriendshipInfo(int i11, HashMap<String, Object> hashMap) {
        return null;
    }

    public f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        f.a aVar = new f.a();
        String text = shareParams.getText();
        String imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        if (!TextUtils.isEmpty(text)) {
            aVar.f13363b = text;
        } else if (!TextUtils.isEmpty(imageUrl)) {
            aVar.f13365d.add(imageUrl);
        } else if (!TextUtils.isEmpty(imagePath)) {
            aVar.f13366e.add(imagePath);
        }
        if (hashMap != null) {
            aVar.f13368g = hashMap;
        }
        return aVar;
    }

    public void follow(String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 6);
        }
    }

    public HashMap<String, Object> getBilaterals(int i11, int i12, String str) {
        return null;
    }

    public HashMap<String, Object> getFollowers(int i11, int i12, String str) {
        return null;
    }

    public HashMap<String, Object> getFollowings(int i11, int i12, String str) {
        return null;
    }

    public void getFriendList(int i11, int i12, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 2);
        }
    }

    public String getName() {
        return NAME;
    }

    public int getPlatformId() {
        return 43;
    }

    public int getVersion() {
        return 1;
    }

    public boolean hasShareCallback() {
        return true;
    }

    public void initDevInfo(String str) {
    }

    public void setNetworkDevinfo() {
    }

    public void timeline(int i11, int i12, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 7);
        }
    }

    public void userInfor(String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 8);
        }
    }
}
