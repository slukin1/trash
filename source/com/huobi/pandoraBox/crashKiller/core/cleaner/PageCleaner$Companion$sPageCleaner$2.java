package com.huobi.pandoraBox.crashKiller.core.cleaner;

import com.blankj.utilcode.util.Utils;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import me.weishu.reflection.Reflection;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/huobi/pandoraBox/crashKiller/core/cleaner/PageCleaner;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PageCleaner$Companion$sPageCleaner$2 extends Lambda implements a<PageCleaner> {
    public static final PageCleaner$Companion$sPageCleaner$2 INSTANCE = new PageCleaner$Companion$sPageCleaner$2();

    public PageCleaner$Companion$sPageCleaner$2() {
        super(0);
    }

    public final PageCleaner invoke() {
        try {
            Reflection.b(Utils.a());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        PageCleaner pageCleaner = new PageCleaner(PageCleaner.f80302c.c(), (r) null);
        pageCleaner.h();
        return pageCleaner;
    }
}
