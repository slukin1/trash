package og;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.hbg.lib.network.hbg.core.bean.AccountChallengeTask;
import com.huobi.account.widget.BoxChallengeTaskView;
import com.huobi.account.widget.BoxSignInView;

public class c extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final Context f47665a;

    /* renamed from: b  reason: collision with root package name */
    public final AccountChallengeTask f47666b;

    public c(Context context, AccountChallengeTask accountChallengeTask) {
        this.f47665a = context;
        this.f47666b = accountChallengeTask;
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        int i11 = this.f47666b.getCheckInResp() != null ? 1 : 0;
        return this.f47666b.getList() != null ? i11 + this.f47666b.getList().size() : i11;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        if (this.f47666b.getCheckInResp() == null) {
            BoxChallengeTaskView boxChallengeTaskView = new BoxChallengeTaskView(this.f47665a);
            boxChallengeTaskView.setData(this.f47666b.getList().get(i11));
            boxChallengeTaskView.setTag(Integer.valueOf(i11));
            viewGroup.addView(boxChallengeTaskView);
            return boxChallengeTaskView;
        } else if (i11 == 0) {
            BoxSignInView boxSignInView = new BoxSignInView(this.f47665a);
            boxSignInView.setData(this.f47666b.getCheckInResp());
            boxSignInView.setTag(Integer.valueOf(i11));
            viewGroup.addView(boxSignInView);
            return boxSignInView;
        } else {
            BoxChallengeTaskView boxChallengeTaskView2 = new BoxChallengeTaskView(this.f47665a);
            boxChallengeTaskView2.setData(this.f47666b.getList().get(i11 - 1));
            boxChallengeTaskView2.setTag(Integer.valueOf(i11));
            viewGroup.addView(boxChallengeTaskView2);
            return boxChallengeTaskView2;
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
