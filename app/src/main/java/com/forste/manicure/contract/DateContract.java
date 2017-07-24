package com.forste.manicure.contract;

import com.forste.manicure.model.WorkDateTime;

import java.util.List;

/**
 * Created by sergejkozin on 7/19/17.
 */

public interface DateContract {
    interface View extends BaseContract.View {
        void showAllWorkDateTime(List<WorkDateTime> workDateTimeList);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getAllWorkDateTime();
    }
}
