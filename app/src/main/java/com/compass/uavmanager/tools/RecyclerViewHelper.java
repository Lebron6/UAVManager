package com.compass.uavmanager.tools;

import android.content.Context;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * Created by long on 2016/3/30.
 * 视图帮助类
 */
public class RecyclerViewHelper {

    private RecyclerViewHelper() {
        throw new RuntimeException("RecyclerViewHelper cannot be initialized!");
    }


    /**
     * 配置垂直列表RecyclerView
     * @param view
     */
    public static void initRecyclerViewV(Context context, RecyclerView view, boolean isDivided,
                                         RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        view.setHasFixedSize(true);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (isDivided) {
            view.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST));
        }
        view.setAdapter(adapter);
    }

    public static void initRecyclerViewV(Context context, RecyclerView view, RecyclerView.Adapter adapter) {
        initRecyclerViewV(context, view, false, adapter);
    }

    /**
     * 配置水平列表RecyclerView
     * @param view
     */
    public static void initRecyclerViewH(Context context, RecyclerView view, boolean isDivided,
                                         RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (isDivided) {
            view.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL_LIST));
        }
        view.setAdapter(adapter);
    }

    public static void initRecyclerViewH(Context context, RecyclerView view, RecyclerView.Adapter adapter) {
        initRecyclerViewH(context, view, false, adapter);
    }

    /**
     * 配置网格列表RecyclerView
     * @param view
     */
    public static void initRecyclerViewG(Context context, RecyclerView view, boolean isDivided,
                                         RecyclerView.Adapter adapter, int column) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, column, LinearLayoutManager.VERTICAL, false);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (isDivided) {
            view.addItemDecoration(new DividerGridItemDecoration(context));
        }
        view.setAdapter(adapter);
    }

    public static void initRecyclerViewG(Context context, RecyclerView view, RecyclerView.Adapter adapter, int column) {
        initRecyclerViewG(context, view, false, adapter, column);
    }


    /**
     * 配置瀑布流列表RecyclerView
     * @param view
     */
    public static void initRecyclerViewSV(Context context, RecyclerView view, boolean isDivided,
                                          RecyclerView.Adapter adapter, int column) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(column, StaggeredGridLayoutManager.VERTICAL);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (isDivided) {
            view.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST));
        }
        view.setAdapter(adapter);
    }

    public static void initRecyclerViewSV(Context context, RecyclerView view, RecyclerView.Adapter adapter, int column) {
        initRecyclerViewSV(context, view, false, adapter, column);
    }


}
