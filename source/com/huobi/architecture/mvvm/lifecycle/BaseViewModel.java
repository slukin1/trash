package com.huobi.architecture.mvvm.lifecycle;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0004X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/huobi/architecture/mvvm/lifecycle/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/huobi/architecture/mvvm/lifecycle/XDialogLiveData;", "a", "Lcom/huobi/architecture/mvvm/lifecycle/XDialogLiveData;", "getMShowLoading", "()Lcom/huobi/architecture/mvvm/lifecycle/XDialogLiveData;", "mShowLoading", "<init>", "()V", "DialogBean", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
public abstract class BaseViewModel extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final XDialogLiveData f42235a = new XDialogLiveData();

    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/huobi/architecture/mvvm/lifecycle/BaseViewModel$DialogBean;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isPage", "()Z", "setPage", "(Z)V", "b", "Ljava/lang/Integer;", "getState", "()Ljava/lang/Integer;", "setState", "(Ljava/lang/Integer;)V", "state", "c", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "msg", "<init>", "(ZLjava/lang/Integer;Ljava/lang/String;)V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
    public static final class DialogBean {

        /* renamed from: a  reason: collision with root package name */
        public boolean f42236a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f42237b;

        /* renamed from: c  reason: collision with root package name */
        public String f42238c;

        public DialogBean() {
            this(false, (Integer) null, (String) null, 7, (r) null);
        }

        public DialogBean(boolean z11, Integer num, String str) {
            this.f42236a = z11;
            this.f42237b = num;
            this.f42238c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DialogBean)) {
                return false;
            }
            DialogBean dialogBean = (DialogBean) obj;
            return this.f42236a == dialogBean.f42236a && x.b(this.f42237b, dialogBean.f42237b) && x.b(this.f42238c, dialogBean.f42238c);
        }

        public int hashCode() {
            boolean z11 = this.f42236a;
            if (z11) {
                z11 = true;
            }
            int i11 = (z11 ? 1 : 0) * true;
            Integer num = this.f42237b;
            return ((i11 + (num == null ? 0 : num.hashCode())) * 31) + this.f42238c.hashCode();
        }

        public String toString() {
            return "DialogBean(isPage=" + this.f42236a + ", state=" + this.f42237b + ", msg=" + this.f42238c + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DialogBean(boolean z11, Integer num, String str, int i11, r rVar) {
            this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? "" : str);
        }
    }
}
