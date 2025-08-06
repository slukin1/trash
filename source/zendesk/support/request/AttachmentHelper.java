package zendesk.support.request;

import androidx.appcompat.app.AppCompatActivity;
import com.zendesk.sdk.R$bool;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mz.a;
import zendesk.belvedere.BelvedereUi;
import zendesk.belvedere.MediaResult;

class AttachmentHelper {
    private List<StateRequestAttachment> additionalAttachments;
    private long maxFileSize = -1;
    private List<StateRequestAttachment> selectedAttachments;
    private final int[] touchableItems;

    public AttachmentHelper(int... iArr) {
        this.touchableItems = iArr;
        this.selectedAttachments = new ArrayList();
        this.additionalAttachments = new ArrayList();
    }

    private List<MediaResult> requestAttachmentsToMediaResult(List<StateRequestAttachment> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (StateRequestAttachment convert : list) {
            arrayList.add(StateRequestAttachment.convert(convert));
        }
        return arrayList;
    }

    public List<StateRequestAttachment> getSelectedAttachments() {
        return a.c(this.selectedAttachments);
    }

    public void showImagePicker(AppCompatActivity appCompatActivity) {
        BelvedereUi.b i11 = BelvedereUi.b(appCompatActivity).g().h("*/*", true).l(requestAttachmentsToMediaResult(this.selectedAttachments)).j(appCompatActivity.getResources().getBoolean(R$bool.zs_request_image_picker_full_screen)).i(requestAttachmentsToMediaResult(this.additionalAttachments));
        int[] iArr = this.touchableItems;
        if (iArr != null && iArr.length > 0) {
            i11 = i11.m(iArr);
        }
        long j11 = this.maxFileSize;
        if (j11 > 0) {
            i11 = i11.k(j11);
        }
        i11.f(appCompatActivity);
    }

    public void updateAttachments(Collection<StateRequestAttachment> collection, Collection<StateRequestAttachment> collection2) {
        this.selectedAttachments = a.c(new ArrayList(collection));
        this.additionalAttachments = a.c(new ArrayList(collection2));
    }

    public void updateMaxFileSize(long j11) {
        this.maxFileSize = j11;
    }
}
