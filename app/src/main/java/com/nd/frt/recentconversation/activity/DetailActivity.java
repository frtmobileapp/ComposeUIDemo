package com.nd.frt.recentconversation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nd.frt.recentconversation.R;
import com.nd.frt.recentconversation.model.UserInfo;

public class DetailActivity extends AppCompatActivity {

    public static final String PARAM_USER_INFO = "user_info";
    public static final String PARAM_USER_INDEX = "user_index";
    private UserInfo mUserInfo;
    private int mUserIndex;

    public static void start(Activity context, int index, UserInfo userInfo, int requestCode) {
        Intent starter = new Intent(context, DetailActivity.class);
        starter.putExtra(PARAM_USER_INFO,userInfo);
        starter.putExtra(PARAM_USER_INDEX,index);
        context.startActivityForResult(starter,requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar supportActionBar = getSupportActionBar();
        assert supportActionBar != null;
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        mUserInfo = ((UserInfo) intent.getSerializableExtra(PARAM_USER_INFO));
        mUserIndex = intent.getIntExtra(PARAM_USER_INDEX,0);
        supportActionBar.setTitle(mUserInfo.userName);
        supportActionBar.setSubtitle(mUserInfo.content);
        final EditText etUserName = findViewById(R.id.etUserName);
        ImageView ivAvatar = findViewById(R.id.ivAvatar);
        Glide.with(this)
                .load(mUserInfo.avatarUrl)
                .into(ivAvatar);
        findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserInfo.userName = etUserName.getText().toString();
                Intent intentResult = new Intent();
                intentResult.putExtra(PARAM_USER_INFO,mUserInfo);
                intentResult.putExtra(PARAM_USER_INDEX,mUserIndex);
                setResult(RESULT_OK,intentResult);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
