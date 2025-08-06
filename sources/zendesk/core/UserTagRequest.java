package zendesk.core;

import java.util.List;

class UserTagRequest {
    private List<String> tags;

    public UserTagRequest(List<String> list) {
        this.tags = list;
    }
}
