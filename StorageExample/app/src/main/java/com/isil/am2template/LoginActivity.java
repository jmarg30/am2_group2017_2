package com.isil.am2template;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.isil.am2template.storage.PreferencesHelper;


public class LoginActivity extends AppCompatActivity {

    private Button btnLogin,btnRegister;
    private EditText eteUsername;
    private EditText etePassword;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        eteUsername=(EditText)findViewById(R.id.eteUsername);
        etePassword=(EditText)findViewById(R.id.etePassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnRegister=(Button)findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    gotoMain();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUserRegister();
            }
        });
    }

    private void gotoUserRegister() {
        Intent intent= new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    private void gotoMain() {

        savePreferences();
        Intent intent= new Intent(this,DashboardActivity.class);
        startActivity(intent);
    }

    private void savePreferences() {
        PreferencesHelper.saveSession(this,username,password);
    }

    //https://www.google.com/search?q=if+kaduken&client=firefox-b-ab&dcr=0&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjB2NHImrrWAhXMQSYKHW_RA_wQ_AUICigB&biw=1200&bih=604#imgrc=a9oiru77r4sJBM:
    private boolean validateForm() {
        username= eteUsername.getText().toString();
        password= etePassword.getText().toString();

        if(username.isEmpty())
        {
            eteUsername.setError("Error campo username");
            return false;
        }
        if(password.isEmpty())
        {
            etePassword.setError("Error campo password");
            return false;
        }
        return true;
    }

}
