package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.core.util.h;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y0.c;

public final class DefaultEmojiCompatConfig {

    public static class DefaultEmojiCompatConfigHelper {
        public ProviderInfo a(ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        public Signature[] b(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        public List<ResolveInfo> c(PackageManager packageManager, Intent intent, int i11) {
            return Collections.emptyList();
        }
    }

    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        public ProviderInfo a(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        public List<ResolveInfo> c(PackageManager packageManager, Intent intent, int i11) {
            return packageManager.queryIntentContentProviders(intent, i11);
        }
    }

    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        public Signature[] b(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final DefaultEmojiCompatConfigHelper f9368a;

        public a(DefaultEmojiCompatConfigHelper defaultEmojiCompatConfigHelper) {
            this.f9368a = defaultEmojiCompatConfigHelper == null ? e() : defaultEmojiCompatConfigHelper;
        }

        public static DefaultEmojiCompatConfigHelper e() {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 28) {
                return new DefaultEmojiCompatConfigHelper_API28();
            }
            if (i11 >= 19) {
                return new DefaultEmojiCompatConfigHelper_API19();
            }
            return new DefaultEmojiCompatConfigHelper();
        }

        public final EmojiCompat.c a(Context context, c cVar) {
            if (cVar == null) {
                return null;
            }
            return new FontRequestEmojiCompatConfig(context, cVar);
        }

        public final List<List<byte[]>> b(Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature byteArray : signatureArr) {
                arrayList.add(byteArray.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        public EmojiCompat.c c(Context context) {
            return a(context, h(context));
        }

        public final c d(ProviderInfo providerInfo, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new c(str, str2, "emojicompat-emoji-font", b(this.f9368a.b(packageManager, str2)));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
            r2 = r2.applicationInfo;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean f(android.content.pm.ProviderInfo r2) {
            /*
                r1 = this;
                r0 = 1
                if (r2 == 0) goto L_0x000d
                android.content.pm.ApplicationInfo r2 = r2.applicationInfo
                if (r2 == 0) goto L_0x000d
                int r2 = r2.flags
                r2 = r2 & r0
                if (r2 != r0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                r0 = 0
            L_0x000e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.DefaultEmojiCompatConfig.a.f(android.content.pm.ProviderInfo):boolean");
        }

        public final ProviderInfo g(PackageManager packageManager) {
            for (ResolveInfo a11 : this.f9368a.c(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0)) {
                ProviderInfo a12 = this.f9368a.a(a11);
                if (f(a12)) {
                    return a12;
                }
            }
            return null;
        }

        public c h(Context context) {
            PackageManager packageManager = context.getPackageManager();
            h.h(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo g11 = g(packageManager);
            if (g11 == null) {
                return null;
            }
            try {
                return d(g11, packageManager);
            } catch (PackageManager.NameNotFoundException e11) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e11);
                return null;
            }
        }
    }

    public static FontRequestEmojiCompatConfig a(Context context) {
        return (FontRequestEmojiCompatConfig) new a((DefaultEmojiCompatConfigHelper) null).c(context);
    }
}
