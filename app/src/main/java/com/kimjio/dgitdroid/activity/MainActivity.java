package com.kimjio.dgitdroid.activity;

import android.os.Bundle;
import android.view.Menu;

import com.kimjio.dgitdroid.R;
import com.kimjio.dgitdroid.api.DGitApi;
import com.kimjio.dgitdroid.databinding.MainActivityBinding;
import com.kimjio.dgitdroid.recycler.RankAdapter;
import com.kimjio.dgitdroid.util.RetrofitUtil;

public class MainActivity extends BaseActivity<MainActivityBinding> {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(binding.appBar);
        DGitApi api = RetrofitUtil.getInstance(DGitApi.DGIT).create(DGitApi.class);
        api.totalRank().observe(this, value -> binding.list.setAdapter(new RankAdapter(value.getData().getTotalRank())));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}