package com.zhhl.personnel_contorl.mvp.presenter;


import com.zhhl.personnel_contorl.common.BasePresenter;
import com.zhhl.personnel_contorl.common.OriginApp;
import com.zhhl.personnel_contorl.data.ChangQuDiData;
import com.zhhl.personnel_contorl.data.GuijiCQDWrapper;
import com.zhhl.personnel_contorl.data.GxclData;
import com.zhhl.personnel_contorl.data.GxrData2;
import com.zhhl.personnel_contorl.data.HunyinGuiji;
import com.zhhl.personnel_contorl.data.PersonTrajectory;
import com.zhhl.personnel_contorl.data.Trajectory;
import com.zhhl.personnel_contorl.di.ActivityScope;
import com.zhhl.personnel_contorl.mvp.contacts.PersonTrajectoryAnalysisContract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@ActivityScope
public class PersonTrajectoryAnalysisPresenter extends BasePresenter<PersonTrajectoryAnalysisContract.Model, PersonTrajectoryAnalysisContract.View> {
    private int requestCounter = 0;
    private String idNumber;
    private List<Trajectory.RenkouBean> renkouBean;

    @Inject
    public PersonTrajectoryAnalysisPresenter(PersonTrajectoryAnalysisContract.Model model, PersonTrajectoryAnalysisContract.View rootView
            , OriginApp application) {
        super(model, rootView);
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void getDataRangeWx(String start, String end) {

    }

    public void getMyTrajectory(String start, String end) {
        requestCreate();
        mModel.selfTrajectory(idNumber, start, end, "0")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::selfTrajectory, this::onError, this::onComplete)
                .isDisposed();
    }


    public void getChangQuDi(String start, String end) {

        requestCreate();
        mModel.frequented(idNumber, start, end, "3")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::setCQD, this::onError, this::onComplete)
                .isDisposed();
    }

    private void requestCreate() {
        requestCounter++;
        if (requestCounter > 0) {
            mRootView.showRequestDialog();
        }
    }

    private void requestDistroy() {
        requestCounter--;
        if (requestCounter <= 0) {
            mRootView.dismissRequestDialog();
        }
    }

    private void selfTrajectory(Trajectory guiji) {
        requestDistroy();
        ArrayList<PersonTrajectory> wrappers = transitionWrapper(guiji);
        if (guiji.getRenkou().size() > 0)
            mRootView.setTrajectoryName(guiji.getRenkou().get(0).getXm());
        this.renkouBean = guiji.getRenkou();
//        if (mProgress != null && mProgress.isShowing()) {
//            mProgress.dismiss();
//            showUserData();
//        }
        mRootView.addData(wrappers);
    }


    @Override
    public void onError(Throwable throwable) {
        super.onError(throwable);
        requestDistroy();
    }

    private ArrayList<PersonTrajectory> transitionWrapper(Trajectory zaitaoguiji) {
        ArrayList<PersonTrajectory> wrappers = new ArrayList<>();
        List<Trajectory.CheliangBean> cheliang = zaitaoguiji.getCheliang();
        List<Trajectory.KecheBean> keche = zaitaoguiji.getKeche();
        List<Trajectory.MinhangBean> minhang = zaitaoguiji.getMinhang();
        List<Trajectory.ShangwangBean> shangwang = zaitaoguiji.getShangwang();
        List<Trajectory.TielugoupiaoBean> tielugoupiao = zaitaoguiji.getTielugoupiao();
        List<Trajectory.ZhudianBean> zhudian = zaitaoguiji.getZhudian();
        List<Trajectory.KakouBean> kakou = zaitaoguiji.getKakou();

//        if (cheliang != null)
//            for (Trajectory.CheliangBean c : cheliang) {
//                SimpleCarInfo simpleCarInfo = new SimpleCarInfo();
//                simpleCarInfo.setCarCode(c.getGajtglfzjgslmc() + c.getJdchphm().substring(1));
//                simpleCarInfo.setCarName(c.getZwppmc());
//                simpleCarInfo.setCompany(c.getZzcDwmc());
//                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(simpleCarInfo);
//                wrappers.add(zaitaoguijiWrapper);
//            }
        if (keche != null)
            for (Trajectory.KecheBean c : keche) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        if (minhang != null)
            for (Trajectory.MinhangBean c : minhang) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        if (shangwang != null)
            for (Trajectory.ShangwangBean c : shangwang) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        if (tielugoupiao != null)
            for (Trajectory.TielugoupiaoBean c : tielugoupiao) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        if (zhudian != null)
            for (Trajectory.ZhudianBean c : zhudian) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        if (kakou != null)
            for (Trajectory.KakouBean c : kakou) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        return wrappers;
    }

    private ArrayList<PersonTrajectory> transitionWrapper(HunyinGuiji zaitaoguiji) {
        ArrayList<PersonTrajectory> wrappers = new ArrayList<>();
        List<Trajectory.KecheBean> keche = zaitaoguiji.getKeche();
        List<Trajectory.MinhangBean> minhang = zaitaoguiji.getMinhang();
        List<Trajectory.TielugoupiaoBean> tielugoupiao = zaitaoguiji.getTielugoupiao();

        if (keche != null)
            for (Trajectory.KecheBean c : keche) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        if (minhang != null)
            for (Trajectory.MinhangBean c : minhang) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        if (tielugoupiao != null)
            for (Trajectory.TielugoupiaoBean c : tielugoupiao) {
                PersonTrajectory zaitaoguijiWrapper = new PersonTrajectory(c);
                wrappers.add(zaitaoguijiWrapper);
            }
        return wrappers;
    }

    public List<Trajectory.RenkouBean> getRenkou() {
        return renkouBean;
    }

    private void setCQD(ChangQuDiData guiji3) {
        requestDistroy();
        ArrayList<GuijiCQDWrapper> shangwang = new ArrayList<>();
        ArrayList<GuijiCQDWrapper> zhudian = new ArrayList<>();
        List<ChangQuDiData.ShangwangBean> sshangwang = guiji3.getShangwang();
        for (ChangQuDiData.ShangwangBean sw : sshangwang) {
            GuijiCQDWrapper guijiCQDWrapper = new GuijiCQDWrapper();
            guijiCQDWrapper.ldmc = sw.getYycsDwmc();
            guijiCQDWrapper.tj = sw.getTj();
            shangwang.add((guijiCQDWrapper));
        }

        List<ChangQuDiData.ZhudianTongjiBean> szhudian = guiji3.getZhudian();
        for (ChangQuDiData.ZhudianTongjiBean sw : szhudian) {
            GuijiCQDWrapper guijiCQDWrapper = new GuijiCQDWrapper();
            guijiCQDWrapper.ldmc = sw.getLdMc();
            guijiCQDWrapper.tj = sw.getTj();
            zhudian.add((guijiCQDWrapper));
        }
        Collections.sort(shangwang);
        Collections.sort(zhudian);
        if (shangwang.size() > 3) {
            shangwang = new ArrayList<>(shangwang.subList(0, 3));
        }
        if (zhudian.size() > 3) {
            zhudian = new ArrayList<>(zhudian.subList(0, 3));
        }

        mRootView.addData(toTrajectory(shangwang));
        mRootView.addData(toTrajectory(zhudian));
    }

    private ArrayList<PersonTrajectory> toTrajectory(List<GuijiCQDWrapper> source) {
        ArrayList<PersonTrajectory> dest = new ArrayList<>();
        for (GuijiCQDWrapper gj : source) {
            dest.add(new PersonTrajectory(gj));
        }
        return dest;
    }

    public void getGxclTrajectory() {
        requestCreate();
        mModel.trajectoryGxcl(idNumber)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::gxclRes, this::onError, this::onComplete)
                .isDisposed();
    }

    private void gxclRes(GxclData o) {
        requestDistroy();
        mRootView.setGxclAdapter(o);

    }

    public void getGxrTrajectory2(String start, String end) {
        requestCreate();
        mModel.trajectoryGxr(idNumber, start, end)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::gxrRes, this::onError, this::onComplete)
                .isDisposed();
    }

    private void gxrRes(GxrData2 o) {
        requestDistroy();
        mRootView.setGxrAdapter(transitionWrapper(o));

    }


    private ArrayList<PersonTrajectory> transitionWrapper(GxrData2 gxrData) {
        ArrayList<PersonTrajectory> wrappers = new ArrayList<>();
        List<GxrData2.HunyinBean> hunyin = gxrData.getHunyin();
        List<GxrData2.QinshuBean> qinshu = gxrData.getQinshu();

        List<GxrData2.KctxBean> keche = gxrData.getKctx();
        List<GxrData2.HbtxBean> minhang = gxrData.getHbtx();
        List<GxrData2.HclzBean> hclz = gxrData.getHclz();
        List<GxrData2.HctxBean> hctx = gxrData.getHctx();
        List<GxrData2.ZstxBean> zhudian = gxrData.getZstx();


        if (keche != null) {
            HashMap<String, ArrayList<GxrData2.KctxBean>> kc = new HashMap<>();
            for (GxrData2.KctxBean c : keche) {
                ArrayList<GxrData2.KctxBean> kctxBeans = kc.get(c.getZjqfZjhm());
                if (kctxBeans == null) {
                    kctxBeans = new ArrayList<>();
                    kc.put(c.getZjqfZjhm(), kctxBeans);
                }
                kctxBeans.add(c);
            }
            for (String key : kc.keySet()) {
                wrappers.add(new PersonTrajectory().setKctx(kc.get(key)));
            }
        }
        if (minhang != null) {
            HashMap<String, ArrayList<GxrData2.HbtxBean>> hb = new HashMap<>();
            for (GxrData2.HbtxBean c : minhang) {
                ArrayList<GxrData2.HbtxBean> kctxBeans = hb.get(c.getZjhm());
                if (kctxBeans == null) {
                    kctxBeans = new ArrayList<>();
                    hb.put(c.getZjhm(), kctxBeans);
                }
                kctxBeans.add(c);
            }

            for (String key : hb.keySet()) {
                wrappers.add(new PersonTrajectory().setHbtx(hb.get(key)));
            }

        }

        if (hclz != null) {
            HashMap<String, ArrayList<GxrData2.HclzBean>> hc = new HashMap<>();
            for (GxrData2.HclzBean c : hclz) {
                ArrayList<GxrData2.HclzBean> kctxBeans = hc.get(c.getGmsfhm());
                if (kctxBeans == null) {
                    kctxBeans = new ArrayList<>();
                    hc.put(c.getGmsfhm(), kctxBeans);
                }
                kctxBeans.add(c);
            }
            for (String key : hc.keySet()) {
                wrappers.add(new PersonTrajectory().setHclz(hc.get(key)));
            }
        }
        if (hctx != null) {
            HashMap<String, ArrayList<GxrData2.HctxBean>> hc = new HashMap<>();
            for (GxrData2.HctxBean c : hctx) {
                ArrayList<GxrData2.HctxBean> kctxBeans = hc.get(c.getGmsfhm());
                if (kctxBeans == null) {
                    kctxBeans = new ArrayList<>();
                    hc.put(c.getGmsfhm(), kctxBeans);
                }
                kctxBeans.add(c);
            }
            for (String key : hc.keySet()) {
                wrappers.add(new PersonTrajectory().setHctx(hc.get(key)));
            }
        }
        if (zhudian != null) {
            HashMap<String, ArrayList<GxrData2.ZstxBean>> hc = new HashMap<>();
            for (GxrData2.ZstxBean c : zhudian) {
                ArrayList<GxrData2.ZstxBean> kctxBeans = hc.get(c.getGmsfhm());
                if (kctxBeans == null) {
                    kctxBeans = new ArrayList<>();
                    hc.put(c.getGmsfhm(), kctxBeans);
                }
                kctxBeans.add(c);
            }
            for (String key : hc.keySet()) {
                wrappers.add(new PersonTrajectory().setZstx(hc.get(key)));
            }
        }
        if (qinshu != null)
            for (GxrData2.QinshuBean c : qinshu) {
                PersonTrajectory trajectory = new PersonTrajectory(c);
                wrappers.add(trajectory);
            }
        if (hunyin != null)
            for (GxrData2.HunyinBean c : hunyin) {
                PersonTrajectory trajectory = new PersonTrajectory(c);
                wrappers.add(trajectory);
            }
        return wrappers;
    }

    private ArrayList<PersonTrajectory> transitionWrapper(GxclData gxrData) {
        ArrayList<PersonTrajectory> wrappers = new ArrayList<>();
        List<GxclData.QsclBean> gxcl = gxrData.getQscl();
        if (gxcl != null)
            for (GxclData.QsclBean c : gxcl) {
                PersonTrajectory trajectory = new PersonTrajectory(c);
                wrappers.add(trajectory);
            }
        return wrappers;
    }
}
