package com.zhhl.personnel_contorl.mvp.contacts;



import com.zhhl.personnel_contorl.common.IModel;
import com.zhhl.personnel_contorl.common.IView;
import com.zhhl.personnel_contorl.data.PushInfo;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by miao on 2019/4/1.
 */

public interface ConcernedWithDrugsContact {
    interface View extends IView {

        void refreshOnly();

        void dismiss();

        void changeData(List<PushInfo.DataBean> data);
    }

    interface Model extends IModel {
        Observable<PushInfo> exceptionConcernedWithDrugs();
    }

}