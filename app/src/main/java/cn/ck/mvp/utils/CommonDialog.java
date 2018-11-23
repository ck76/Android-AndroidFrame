package cn.ck.mvp.utils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.ck.mvp.R;


/**
 * Created by ck on 2018/10/5.
 */
public class CommonDialog {
    private View view;
    private Dialog dialog;
    private TextView tvTitle;
    private Button btOk;
    private Button btCancel;
    private TextView tvMessage;

    @SuppressLint("InflateParams")
    public CommonDialog(Context context) {
        dialog=new Dialog(context, R.style.CommonDialog);

        view= LayoutInflater.from(context).inflate(R.layout.dialog_common,null,false);
        tvTitle=view.findViewById(R.id.tv_title);
        tvMessage=view.findViewById(R.id.tv_message);
        btOk=view.findViewById(R.id.bt_ok);
        btCancel=view.findViewById(R.id.bt_cancel);
        tvTitle.setVisibility(View.GONE);
        tvMessage.setVisibility(View.GONE);
        btOk.setVisibility(View.GONE);
        btCancel.setVisibility(View.GONE);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);

    }

    public CommonDialog setTitle(String text) {
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(text);
        return this;
    }

    public CommonDialog setMessage(String text) {
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setMovementMethod(ScrollingMovementMethod.getInstance());
        tvMessage.setText(text);
        return this;
    }


    public CommonDialog setPositiveButton(final String text, View.OnClickListener onClickListener) {
        btOk.setVisibility(View.VISIBLE);
        btOk.setText(text);
        if (onClickListener != null) {
            btOk.setOnClickListener(onClickListener);
        } else {
            btOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
        }

        return this;
    }

    public CommonDialog setNegativeButton(String text, View.OnClickListener onClickListener) {
        btCancel.setVisibility(View.VISIBLE);
        btCancel.setText(text);
        if (onClickListener != null) {
            btCancel.setOnClickListener(onClickListener);
        } else {
            btCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });

        }
        return this;
    }

    public void show() {

        dialog.show();

    }

    public void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }


}
