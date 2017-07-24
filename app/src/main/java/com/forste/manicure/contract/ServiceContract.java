package com.forste.manicure.contract;


/**
 * Created by sergejkozin on 7/20/17.
 */

public interface ServiceContract {
    interface View extends BaseContract.View {

    }

    interface Presenter extends BaseContract.Presenter<View> {

    }
}
