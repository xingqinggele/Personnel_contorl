package com.zhhl.personnel_contorl.common;

import android.widget.Toast;

public class BasePresenter<M extends IModel, V extends IView> implements IPresenter {
    protected final M mModel;
    protected final V mRootView;

    protected BasePresenter(M m, V v) {
        this.mModel = m;
        this.mRootView = v;
    }



    protected void onComplete() {

    }

    public  void onError(Throwable throwable){
        throwable.printStackTrace();
        String err = throwable.getMessage();
        if (err.contains("timeout")){
            Toast.makeText(mRootView.getContext(), "连接超时", Toast.LENGTH_SHORT).show();
        }
    }
}
