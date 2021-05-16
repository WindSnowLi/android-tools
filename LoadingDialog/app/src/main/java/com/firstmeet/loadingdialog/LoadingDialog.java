package com.firstmeet.loadingdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadingDialog extends Dialog {

    private AnimationDrawable mAnimation;
    private final String mLoadingTitle;
    private final int layout;

    public LoadingDialog(Context context, String content, int layout) {
        super(context);
        this.mLoadingTitle = content;
        this.layout = layout;
        //点击外围取消
        setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置窗口布局
        setContentView(R.layout.progress_dialog);

        ImageView mImageView = findViewById(R.id.loadingIv);
        //设置动画资源
        mImageView.setImageResource(layout);
        mAnimation = (AnimationDrawable) mImageView.getDrawable();
        // 启动动态图话
        mImageView.postDelayed(mAnimation::start, 100);
        TextView mLoadingTv = findViewById(R.id.loadingTv);
        //设置加载文字
        mLoadingTv.setText(mLoadingTitle);
        // <color name="transparent">#00FFFFFF</color>
        //设置透明
        getWindow().setBackgroundDrawableResource(R.color.transparent);
    }

}