package com.forste.manicure.contract;

import com.forste.manicure.model.WorkDateTime;

import java.util.Calendar;

/**
 * Created by sergejkozin on 7/20/17.
 */

public interface TimeContract {
    interface View extends BaseContract.View {
        void recordToMaster();

        void updateDateTime(WorkDateTime workDateTime);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void isCurrentTimeFree(Calendar date, int time);
    }
}
