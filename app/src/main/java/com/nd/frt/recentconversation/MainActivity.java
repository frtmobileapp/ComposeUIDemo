package com.nd.frt.recentconversation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.nd.frt.recentconversation.activity.DetailActivity;
import com.nd.frt.recentconversation.adapter.UserAdapter;
import com.nd.frt.recentconversation.model.UserInfo;
import com.nd.frt.recentconversation.service.UserInfoService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserAdapter mUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserInfoService userInfoService = new UserInfoService();
        List<UserInfo> userInfos = userInfoService.getUserInfos(this);
        mUserAdapter = new UserAdapter(userInfos);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mUserAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_add) {
            UserInfo userInfo = new UserInfo();
            userInfo.userName = "zw";
            userInfo.content = "850137895@qq.com";
            userInfo.avatarUrl = "";
            mUserAdapter.add(userInfo);
            Toast.makeText(this, android.R.string.ok, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null) {
                UserInfo userInfo = (UserInfo) data.getSerializableExtra(DetailActivity.PARAM_USER_INFO);
                int index = data.getIntExtra(DetailActivity.PARAM_USER_INDEX, 0);
                mUserAdapter.edit(index, userInfo);
            }
            Toast.makeText(this, android.R.string.ok, Toast.LENGTH_SHORT).show();
        }
    }
}
