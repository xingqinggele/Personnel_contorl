package com.zhhl.personnel_contorl.common;

import android.app.Application;
import android.util.Log;

import com.zhhl.personnel_contorl.di.component.AppComponent;
import com.zhhl.personnel_contorl.di.component.DaggerAppComponent;
import com.zhhl.personnel_contorl.di.module.AppModule;



/**
 * Created by miao on 2019/1/18.
 */
public class OriginApp extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void setAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
//                .clientModule(new ClientModule())
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();

/////TODO 穿裙子镇不住了。。。。
        Log.e("System:", " 穿裙子镇不住了。。。。请佛祖！！");
        System.err.println("////////////////////////////////////////////////////////////////////\n" +
                "//                          _ooOoo_                               //\n" +
                "//                         o8888888o                              //\n" +
                "//                         88\" . \"88                              //\n" +
                "//                         (| ^_^ |)                              //\n" +
                "//                         O\\  =  /O                              //\n" +
                "//                      ____/`---'\\____                           //\n" +
                "//                    .'  \\\\|     |//  `.                         //\n" +
                "//                   /  \\\\|||  :  |||//  \\                        //\n" +
                "//                  /  _||||| -:- |||||-  \\                       //\n" +
                "//                  |   | \\\\\\  -  /// |   |                       //\n" +
                "//                  | \\_|  ''\\---/''  |   |                       //\n" +
                "//                  \\  .-\\__  `-`  ___/-. /                       //\n" +
                "//                ___`. .'  /--.--\\  `. . ___                     //\n" +
                "//              .\"\" '<  `.___\\_<|>_/___.'  >'\"\".                  //\n" +
                "//            | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |                 //\n" +
                "//            \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /                 //\n" +
                "//      ========`-.____`-.___\\_____/___.-`____.-'========         //\n" +
                "//                           `=---='                              //\n" +
                "//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //\n" +
                "//            佛祖保佑       永不宕机     永无BUG                 //\n" +
                "////////////////////////////////////////////////////////////////////");
        setAppComponent();
    }
}
