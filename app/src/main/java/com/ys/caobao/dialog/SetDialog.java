package com.ys.caobao.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ys.caobao.R;

/**
 * Created by Administrator on 2017/6/8.
 */

public class SetDialog implements View.OnClickListener {
    private Context context;
    private Dialog dialog;

    public SetDialog(Context context) {
        this.context = context;
        initView();
    }

    private void initView() {
        dialog = BaseDialog.getIntence(context).getDialog(R.layout.dialog_set,
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
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
