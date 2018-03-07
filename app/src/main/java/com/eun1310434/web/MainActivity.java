/*=====================================================================
□ Infomation
  ○ Data : 07.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : Do it android app Programming

□ Function
  ○ 구글 크롬 연동, 자바스크립트 구현 및 연동, WebView, WebSettings

□ Study
  ○
=====================================================================*/

package com.eun1310434.web;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // 웹뷰 객체
    private WebView webView;

    // 웹사이트 로딩을 위한 버튼
    private Button loadButton;

    //url 주소
    private EditText urlInput;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 웹뷰 객체 참조
        webView = (WebView) findViewById(R.id.webView);

        // 웹뷰 설정 정보
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // java 스크립트가 동작하게 설정

        // 구글 크롬으로 연동
        webView.setWebChromeClient(new WebBrowserClient());

        // 자바스크립트의 함수와 연동
        webView.addJavascriptInterface(new JavaScriptMethods(webView), "sample");

        // assets 폴더에 있는 메인 페이지 로딩
        webView.loadUrl("file:///android_asset/www/sample.html");

        //주소입력 창
        urlInput = (EditText) findViewById(R.id.urlInput);
        urlInput.setText("http://www.naver.com");

        // 버튼 이벤트 처리
        loadButton = (Button) findViewById(R.id.loadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 입력한 URL의 페이지 로딩
                webView.loadUrl(urlInput.getText().toString());
            }
        });

    }
}
