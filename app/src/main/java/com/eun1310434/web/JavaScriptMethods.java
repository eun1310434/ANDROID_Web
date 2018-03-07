/*=====================================================================
□ Infomation
  ○ Data : 07.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : Do it android app Programming

□ Function
  ○ 자바스크립트 함수를 호출하기 위한 클래스 정의

□ Study
  ○
=====================================================================*/
package com.eun1310434.web;

import android.os.Handler;
import android.webkit.WebView;

public class JavaScriptMethods {

    // 웹뷰 객체
    private WebView webView;

    // 핸들러 객체
    private Handler handler = new Handler();
    JavaScriptMethods(WebView _webView) {
        webView = _webView;

    }

    @android.webkit.JavascriptInterface
    public void clickOnImg() { // Javascript의 메소드 호출 연결  <a onClick="window.sample.clickOnImg()">
        handler.post(new Runnable() {
            public void run() {
                // 자바스크립트 함수 호출
                webView.loadUrl("javascript:changeImg()");
            }
        });

    }
}