package com.zhhl.personnel_contorl.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.zhhl.personnel_contorl.R;


/**
 * Created by miao on 2018/11/12.
 */
public class DialogUtils {
    public static ProgressDialog createProgressDialog(Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("正在加载,请稍后...");
        return dialog;
    }

    public static ProgressDialog createProgressDialog(Context context, String text) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage(text);
        return dialog;
    }

    public static AlertDialog create(Context context, int layout, String name, String sex, String minzu, String xl, String sfzh, String jtzz) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View inflate = View.inflate(context, layout, null);
        TextView sname = inflate.findViewById(R.id.name);
        TextView sexs = inflate.findViewById(R.id.sex);
        TextView minzus = inflate.findViewById(R.id.type);
        TextView xls = inflate.findViewById(R.id.xl);
        TextView sfzhs = inflate.findViewById(R.id.sfzh);
        TextView jtzzs = inflate.findViewById(R.id.jtzz);
        sname.setText(name);
        sexs.setText(sex);
        minzus.setText(minzu==null?"其它":minzu);
        xls.setText(xl==null?"其它":xl);
        sfzhs.setText(sfzh);
        jtzzs.setText(jtzz);
        return builder.setView(inflate)
                .create();

    }

}
