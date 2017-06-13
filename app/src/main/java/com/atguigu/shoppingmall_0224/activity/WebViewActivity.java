package com.atguigu.shoppingmall_0224.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.shoppingmall_0224.R;
import com.atguigu.shoppingmall_0224.home.adapter.HomeAdapter;
import com.atguigu.shoppingmall_0224.home.bean.WebViewBean;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class WebViewActivity extends AppCompatActivity {

    @InjectView(R.id.ib_back)
    ImageButton ibBack;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.ib_more)
    ImageButton ibMore;
    @InjectView(R.id.webview)
    WebView webview;
    @InjectView(R.id.progressbar)
    ProgressBar progressbar;
    @InjectView(R.id.activity_web_view)
    LinearLayout activityWebView;
    private WebViewBean webViewBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.inject(this);
        getData();
        setData();
    }

    private void setData() {
        //设置标题
        tvTitle.setText(webViewBean.getName());

    }

    private void getData() {
        webViewBean = (WebViewBean) getIntent().getSerializableExtra(HomeAdapter.WEBVIEW_BEAN);
        
        //设置相关参数
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                return true;
            }
        });
    }

    @OnClick({R.id.ib_back, R.id.ib_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                finish();
                break;
            case R.id.ib_more:
                Toast.makeText(WebViewActivity.this, "更多", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
