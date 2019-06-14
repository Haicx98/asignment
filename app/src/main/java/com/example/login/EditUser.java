package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditUser extends AppCompatActivity {
    public static String USER_UPDATE = "USER_UPDATE";
    EditText edUserProfile;
    Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        edUserProfile = (EditText) findViewById(R.id.edit_user);
        btn_save = (Button) findViewById(R.id.btn_save);
        final Intent intent = getIntent();
        edUserProfile.setText(intent.getStringExtra(Constant.USER_NAME));
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent.putExtra(USER_UPDATE,edUserProfile.getText().toString());
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
    }

}
