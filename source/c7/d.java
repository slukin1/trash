package c7;

import com.hbg.lib.data.main.BaseDataDiffTools;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class d implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseDataDiffTools f13008b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f13009c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f13010d;

    public /* synthetic */ d(BaseDataDiffTools baseDataDiffTools, String str, String str2) {
        this.f13008b = baseDataDiffTools;
        this.f13009c = str;
        this.f13010d = str2;
    }

    public final Object call(Object obj) {
        return this.f13008b.l(this.f13009c, this.f13010d, (List) obj);
    }
}
