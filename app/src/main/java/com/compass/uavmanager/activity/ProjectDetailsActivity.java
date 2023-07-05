package com.compass.uavmanager.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.viewbinding.ViewBinding;

import com.compass.uavmanager.adapter.ProjectAirAdapter;
import com.compass.uavmanager.adapter.ProjectPerAdapter;
import com.compass.uavmanager.base.BaseActivity;
import com.compass.uavmanager.databinding.ActivityProjectDetailsBinding;
import com.compass.uavmanager.entity.HomeProject;
import com.compass.uavmanager.tools.RecyclerViewHelper;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;


public class ProjectDetailsActivity extends BaseActivity {

    private ActivityProjectDetailsBinding mBinding;
    private static String POSITION = "position";
    private static String PROJECT_INFO = "projectInfo";

    public static void actionStart(Context context, String position, String projectInfo) {
        Intent intent = new Intent(context, ProjectDetailsActivity.class);
        intent.putExtra(POSITION, position);
        intent.putExtra(PROJECT_INFO, projectInfo);
        context.startActivity(intent);
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public ViewBinding getViewBinding() {
        mBinding = ActivityProjectDetailsBinding.inflate(getLayoutInflater());
        return mBinding;
    }

    @Override
    public void initData() {
        Logger.e("ce:" + getIntent().getStringExtra(POSITION));
        Logger.e("ce111:" + getIntent().getStringExtra(PROJECT_INFO));
        ProjectAirAdapter adapter = new ProjectAirAdapter(this);
        RecyclerViewHelper.initRecyclerViewV(this, mBinding.rvAir, false, adapter);
        int position = Integer.valueOf(getIntent().getStringExtra(POSITION));
        HomeProject homeProject = new Gson().fromJson(getIntent().getStringExtra(PROJECT_INFO), HomeProject.class);
        adapter.setDatas(homeProject.getResults().get(position).getUavDataVos());

        ProjectPerAdapter projectAirAdapter = new ProjectPerAdapter(this);
        RecyclerViewHelper.initRecyclerViewV(this, mBinding.rvPer, false, projectAirAdapter);
        projectAirAdapter.setDatas(homeProject.getResults().get(position).getUserDos());
    }

    @Override
    public void initView() {
        mBinding.layoutFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
