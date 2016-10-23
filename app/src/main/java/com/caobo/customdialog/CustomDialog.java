package com.caobo.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 曹博 on 2016/10/22.
 * 自定义Dialog
 */

public class CustomDialog extends Dialog {

    private TextView mYes;
    private TextView mTitle;
    private TextView mMessage;
    private EditText mImport;

    //从外界设置的title文本
    private String titleStr;
    //从外界设置的消息文本
    private String messageStr;

    //确定文本和取消文本的显示内容
    private String yesStr;

    //确定按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;

    //重写构造函数，并传入一个自定义主题
    public CustomDialog(Context context) {
        super(context,R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载自定义布局
        setContentView(R.layout.custom_dialog_layout);

        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();

    }

    /**
     * 初始化确定的监听器
     */
    private void initEvent() {
        //设置确定按钮被点击后，向外界提供监听
        mYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesClick();
                }
            }
        });
    }

    /**
     * 初始化界面的显示数据
     */
    private void initData() {
        //如果用户自定了title和message
        if (titleStr != null) {
            mTitle.setText(titleStr);
        }
        if (messageStr != null) {
            mMessage.setText(messageStr);
        }
        //如果设置按钮的文字
        if (yesStr != null) {
            mYes.setText(yesStr);
        }

    }

    /**
     * 初始化控件
     */
    private void initView() {
        mYes = (TextView) findViewById(R.id.tv_yes);
        mMessage = (TextView) findViewById(R.id.tv_message);
        mTitle = (TextView) findViewById(R.id.tv_title);
        mImport = (EditText) findViewById(R.id.et_import);
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param str
     * @param onYesOnclickListener
     */
    public void setYesOnclickListener(String str, onYesOnclickListener onYesOnclickListener) {
        if (str != null) {
            yesStr = str;
        }
        this.yesOnclickListener = onYesOnclickListener;
    }




    /**
     * 从外界Activity为Dialog设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        titleStr = title;
    }

    /**
     * 从外界Activity为Dialog设置dialog的message
     *
     * @param message
     */
    public void setMessage(String message) {
        messageStr = message;
    }

    /**
     * 设置确定按钮
     */
    public interface onYesOnclickListener {
        public void onYesClick();
    }

}
