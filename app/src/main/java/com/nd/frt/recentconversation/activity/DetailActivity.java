package com.nd.frt.recentconversation.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nd.frt.recentconversation.R;
import com.nd.frt.recentconversation.model.UserInfo;

import java.io.Serializable;

public class DetailActivity extends AppCompatActivity {
    public static final String PARAM_USER_INFO = "user_info";
    public static final String PARAM_USER_INDEX = "user_index";
    public UserInfo mUserInfo;
    private int mUserIndex;
    private EditText mEditText;

    public static void start(Activity context, int index, UserInfo userInfo, int requestCode) {
        Intent starter = new Intent(context, DetailActivity.class);
        starter.putExtra(PARAM_USER_INFO, userInfo);
        starter.putExtra(PARAM_USER_INDEX, index);
        context.startActivityForResult(starter, requestCode);
    }

    public static void start(Context context, UserInfo userInfo) {

    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar supportActionBar = getSupportActionBar();
        assert supportActionBar != null;
        supportActionBar.setDefaultDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        mUserInfo = ((UserInfo) intent.getSerializableExtra(PARAM_USER_INFO));
        mUserIndex = intent.getIntExtra(PARAM_USER_INDEX, 0);
        supportActionBar.setTitle(mUserInfo.userName);
        supportActionBar.setSubtitle(mUserInfo.content);
        final EditText etUserName = findViewById(R.id.etUserName);
        ImageView imageView = findViewById(R.id.ivAvatar);
        Glide.with(this)
                .load(mUserInfo.avatarUrl)
                .into(imageView);
        findViewById(R.id.btnok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserInfo.userName = etUserName.getText().toString();
                Intent intentResult = new Intent();
                intentResult.putExtra(PARAM_USER_INDEX, mUserIndex);
                intentResult.putExtra(PARAM_USER_INFO, mUserInfo);
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
