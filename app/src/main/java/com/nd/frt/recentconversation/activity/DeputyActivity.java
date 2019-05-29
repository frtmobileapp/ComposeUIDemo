package com.nd.frt.recentconversation.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nd.frt.recentconversation.R;
import com.nd.frt.recentconversation.model.UserInfo;

public class DeputyActivity extends AppCompatActivity {

    public static final String PARAM_USER_INFO = "user_info";
    public static final String PARAM_USER_INDEX = "user_index";
    private UserInfo mUserInfo;
    private int mIndex;
    private EditText mEditText;

    public static void start(Activity context, int index, UserInfo userInfo, int requestCode) {
        Intent starter = new Intent(context, DeputyActivity.class);
        starter.putExtra(PARAM_USER_INFO, userInfo);
        starter.putExtra(PARAM_USER_INDEX, index);
        context.startActivityForResult(starter, requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deputy);
        ActionBar supportActionBar = getSupportActionBar();
        Intent intent = getIntent();
        mUserInfo = (UserInfo) intent.getSerializableExtra(PARAM_USER_INFO);
        mIndex = intent.getIntExtra(PARAM_USER_INDEX, 0);
        assert supportActionBar != null;
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setTitle(mUserInfo.userName);
        supportActionBar.setSubtitle(mUserInfo.content);
        mEditText = findViewById(R.id.et_username);
        findViewById(R.id.bt_modify)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Editable text = mEditText.getText();
                        mUserInfo.userName = text.toString();
                        Intent intentResult = new Intent();
                        intentResult.putExtra(PARAM_USER_INDEX, mIndex);
                        intentResult.putExtra(PARAM_USER_INFO, mUserInfo);
                        setResult(R.string.txt_modify, intentResult);
                        Toast.makeText(DeputyActivity.this, R.string.txt_modify, Toast.LENGTH_SHORT).show();
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
