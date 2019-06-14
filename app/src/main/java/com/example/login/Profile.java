package com.example.login;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView textView;
    Button edit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        textView = (TextView) findViewById(R.id.username_profile);
        textView.setText(intent.getStringExtra(Constant.USER_NAME));
        edit_btn = (Button) findViewById(R.id.btn_edit);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityForResult();
            }
        });
    }

    private void openActivityForResult(){
        Intent intent = new Intent(Profile.this,EditUser.class);
        intent.putExtra(Constant.USER_NAME,textView.getText());
        startActivityForResult(intent,Constant.REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestcode, int resultcode, @Nullable Intent data){
        super.onActivityResult(requestcode,resultcode,data);
        if(requestcode == Constant.REQUEST_CODE && resultcode==RESULT_OK){
            textView.setText(data.getStringExtra(EditUser.USER_UPDATE));
        }
    }
}
