package fa;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import com.hbg.lib.widgets.expandable.ExpandableTextView;
import com.hbg.lib.widgets.expandable.TextLinkSpan;
import java.util.List;

public class f extends LinkMovementMethod {

    /* renamed from: a  reason: collision with root package name */
    public long f76182a = 0;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f76183b;

    public f(List<String> list) {
        this.f76183b = list;
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        List<String> list;
        int action = motionEvent.getAction();
        if (action != 1 && action != 0) {
            return Touch.onTouchEvent(textView, spannable, motionEvent);
        }
        int x11 = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y11 = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x11 + textView.getScrollX();
        int scrollY = y11 + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
        TextLinkSpan[] textLinkSpanArr = (TextLinkSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, TextLinkSpan.class);
        if (textLinkSpanArr.length != 0 && (list = this.f76183b) != null && !list.isEmpty()) {
            String url = textLinkSpanArr[0].getURL();
            for (String next : this.f76183b) {
                if (!TextUtils.isEmpty(next) && next.contains(url)) {
                    break;
                }
            }
        }
        if (textLinkSpanArr.length != 0) {
            if (action == 1) {
                if (System.currentTimeMillis() - this.f76182a < 500) {
                    textLinkSpanArr[0].onClick(textView);
                }
            } else if (action == 0) {
                this.f76182a = System.currentTimeMillis();
                Selection.setSelection(spannable, spannable.getSpanStart(textLinkSpanArr[0]), spannable.getSpanEnd(textLinkSpanArr[0]));
            }
            if (textView instanceof ExpandableTextView) {
                ((ExpandableTextView) textView).f71965d = true;
            }
            Touch.onTouchEvent(textView, spannable, motionEvent);
            return true;
        }
        Selection.removeSelection(spannable);
        Touch.onTouchEvent(textView, spannable, motionEvent);
        return false;
    }
}
