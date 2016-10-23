package com.caobo.customdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CustomDialog mCustomDialog;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomDialog = new CustomDialog(MainActivity.this);
                mCustomDialog.setTitle("型号");
                mCustomDialog.setMessage("请输入型号");
                mCustomDialog.setYesOnclickListener("确认", new CustomDialog.onYesOnclickListener() {
                    @Override
                    public void onYesClick() {
                        Toast.makeText(MainActivity.this, "点击了确认", Toast.LENGTH_SHORT).show();
                        mCustomDialog.dismiss();
                    }
                });
                mCustomDialog.show();

            }
        });
    }
}
