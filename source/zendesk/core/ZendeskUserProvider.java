package zendesk.core;

import com.zendesk.service.ZendeskCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lz.c;
import mz.a;
import mz.f;

class ZendeskUserProvider implements UserProvider {
    private static final c.b<UserFieldResponse, List<UserField>> FIELDS_EXTRACTOR = new c.b<UserFieldResponse, List<UserField>>() {
        public List<UserField> extract(UserFieldResponse userFieldResponse) {
            return userFieldResponse.getUserFields();
        }
    };
    private static final c.b<UserResponse, Map<String, String>> FIELDS_MAP_EXTRACTOR = new c.b<UserResponse, Map<String, String>>() {
        public Map<String, String> extract(UserResponse userResponse) {
            if (userResponse == null || userResponse.getUser() == null) {
                return a.d(new HashMap());
            }
            return userResponse.getUser().getUserFields();
        }
    };
    private static final c.b<UserResponse, List<String>> TAGS_EXTRACTOR = new c.b<UserResponse, List<String>>() {
        public List<String> extract(UserResponse userResponse) {
            if (userResponse == null || userResponse.getUser() == null) {
                return a.c(new ArrayList());
            }
            return userResponse.getUser().getTags();
        }
    };
    private static final c.b<UserResponse, User> USER_EXTRACTOR = new c.b<UserResponse, User>() {
        public User extract(UserResponse userResponse) {
            return userResponse.getUser();
        }
    };
    private final UserService userService;

    public ZendeskUserProvider(UserService userService2) {
        this.userService = userService2;
    }

    public void addTags(List<String> list, final ZendeskCallback<List<String>> zendeskCallback) {
        this.userService.addTags(new UserTagRequest(a.e(list))).enqueue(new c(new PassThroughErrorZendeskCallback<List<String>>(zendeskCallback) {
            public void onSuccess(List<String> list) {
                ZendeskCallback zendeskCallback = zendeskCallback;
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(list);
                }
            }
        }, TAGS_EXTRACTOR));
    }

    public void deleteTags(List<String> list, final ZendeskCallback<List<String>> zendeskCallback) {
        this.userService.deleteTags(f.g(a.e(list))).enqueue(new c(new PassThroughErrorZendeskCallback<List<String>>(zendeskCallback) {
            public void onSuccess(List<String> list) {
                ZendeskCallback zendeskCallback = zendeskCallback;
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(list);
                }
            }
        }, TAGS_EXTRACTOR));
    }

    public void getUser(final ZendeskCallback<User> zendeskCallback) {
        this.userService.getUser().enqueue(new c(new PassThroughErrorZendeskCallback<User>(zendeskCallback) {
            public void onSuccess(User user) {
                ZendeskCallback zendeskCallback = zendeskCallback;
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(user);
                }
            }
        }, USER_EXTRACTOR));
    }

    public void getUserFields(final ZendeskCallback<List<UserField>> zendeskCallback) {
        this.userService.getUserFields().enqueue(new c(new PassThroughErrorZendeskCallback<List<UserField>>(zendeskCallback) {
            public void onSuccess(List<UserField> list) {
                ZendeskCallback zendeskCallback = zendeskCallback;
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(list);
                }
            }
        }, FIELDS_EXTRACTOR));
    }

    public void setUserFields(Map<String, String> map, final ZendeskCallback<Map<String, String>> zendeskCallback) {
        this.userService.setUserFields(new UserFieldRequest(map)).enqueue(new c(new PassThroughErrorZendeskCallback<Map<String, String>>(zendeskCallback) {
            public void onSuccess(Map<String, String> map) {
                ZendeskCallback zendeskCallback = zendeskCallback;
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(map);
                }
            }
        }, FIELDS_MAP_EXTRACTOR));
    }
}
