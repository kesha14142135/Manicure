package com.forste.manicure.contract;

import com.forste.manicure.model.User;

/**
 * Created by sergejkozin on 7/2/17.
 */

public interface AuthorizationContract {
    interface View extends BaseContract.View {
        void authorizationWasSuccessful();

    }

    interface Presenter extends BaseContract.Presenter<View> {
        void authorization(User user);
    }
}
