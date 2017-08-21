package com.ys.caobao.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import com.ys.caobao.R;

/**
 * 一键客服
 * Created by Administrator on 2017/6/8.
 */

public class ServiceDialog implements View.OnClickListener {
    private Context context;
    private Dialog dialog;

    public ServiceDialog(Context context) {
        this.context = context;
        initView();
    }

    private void initView() {
        dialog = BaseDialog.getIntence(context).getDialog(R.layout.dialog_service,
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    }

    public void showDialog() {
        dialog.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }

}
