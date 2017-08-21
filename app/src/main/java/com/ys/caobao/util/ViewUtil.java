package com.ys.caobao.util;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.ys.caobao.R;


/**
 * Created by Administrator on 2017/7/7.
 */

public class ViewUtil {

    /**
     * 多行垂直滑动RecyclerView
     *
     * @param context
     * @param recyclerView
     * @param row
     * @return
     */
    public static RecyclerView getVRows(Context context, RecyclerView recyclerView, int row) {
        //设置layoutManager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(row, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new DividerDecoration(context, R.color.gray_line, 1));
        //设置Item增加、移除动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return recyclerView;
    }

    /**
     * 多行水平滑动RecyclerView
     *
     * @param context
     * @param recyclerView
     * @param row
     * @return
     */
    public static RecyclerView getHRows(Context context, RecyclerView recyclerView, int row) {
        //设置layoutManager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(row, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.addItemDecoration(new DividerDecoration(context, R.color.white, 1));
        //设置Item增加、移除动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return recyclerView;
    }
}
