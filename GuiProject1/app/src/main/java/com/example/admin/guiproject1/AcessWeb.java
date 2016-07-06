package com.example.admin.guiproject1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by admin on 7/4/2016.
 */
public class AcessWeb extends Activity implements View.OnClickListener{
    private WebView webView;
    private EditText edtNameWebsite;
    private ProgressDialog dialog;
    private Button btnLogout,btnAcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webaccess);
        initView();
    }

    private void initView() {
        webView = (WebView) this.findViewById(R.id.webView);
        edtNameWebsite = (EditText) this.findViewById(R.id.edtWebsite);
        btnLogout = (Button) this.findViewById(R.id.btnLogout);
        btnAcess = (Button) this.findViewById(R.id.btnAccess);
        btnAcess.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
        dialog = new ProgressDialog(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAccess :
                if (edtNameWebsite.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),R.string.inputDataError,Toast.LENGTH_LONG).show();
                    return;
                }
                webView.loadUrl("http://"+edtNameWebsite.getText().toString());
                webView.setWebViewClient(new WebViewClient(){
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        dialog.dismiss();
                        btnAcess.setEnabled(false);
                    }

                    @Override
                    public void onLoadResource(WebView view, String url) {
                        super.onLoadResource(view, url);
                        dialog.show();
                    }
                });

                break;
            case R.id.btnLogout:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle(R.string.yesorno);
                dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                dialog.create();
                dialog.show();
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       webView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        webView.restoreState(savedInstanceState);
    }
}
