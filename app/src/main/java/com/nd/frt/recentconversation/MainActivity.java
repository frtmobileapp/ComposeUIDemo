package com.nd.frt.recentconversation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.nd.frt.recentconversation.activity.DetailActivity;
import com.nd.frt.recentconversation.adapter.UserAdapter;
import com.nd.frt.recentconversation.model.UserInfo;
import com.nd.frt.recentconversation.service.UserInfoService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserInfoService userInfoService = new UserInfoService();
        List<UserInfo> userInfos = userInfoService.getUserInfos(this);
        RecyclerView rvUsers = (RecyclerView) findViewById(R.id.rvUsers);
        rvUsers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        UserAdapter mUserAdapter = new UserAdapter(userInfos);
        rvUsers.setAdapter(mUserAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_add){
            UserInfo userInfo = new UserInfo();
            userInfo.userName = "chenxuling";
            userInfo.content = "1051106490@qq.com";
            userInfo.avatarUrl = "https://randomuser.me/api/portraits/women/64.jpg";
            ArrayList<UserInfo> mUserAdapter = null;
            mUserAdapter.add(userInfo);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (data != null) {
                UserInfo userInfo = (UserInfo) data.getSerializableExtra(DetailActivity.PARAM_USER_INFO);
                int index = data.getIntExtra(DetailActivity.PARAM_USER_INDEX,0);
                UserAdapter mUserAdapter = null;
                mUserAdapter.edit(index,userInfo);
            }
        }
    }
}
