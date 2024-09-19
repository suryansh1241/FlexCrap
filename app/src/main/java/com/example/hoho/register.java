package com.example.hoho;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity {
    EditText regemail, regpassword, regmobile;
    Button regsubmit;
    TextView tv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regemail=(EditText)findViewById(R.id.reg_email);
        regmobile=(EditText)findViewById(R.id.reg_mobile);
        regpassword=(EditText)findViewById(R.id.reg_password);
        tv=(TextView)findViewById(R.id.signup_report_tv);

        regsubmit=(Button)findViewById(R.id.reg_submit);
        regsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userregister(regemail.getText().toString(), regmobile.getText().toString(), regpassword.getText().toString());
            }
        });
    }
    public void userregister(String email, String mobile, String password)
    {
        String name="not applicable";
        String address="not applicable";

        Call<sign_up_response_model> call = apicontroller.getInstance().getapi().getregister(name,email,password,mobile,address);

        call.enqueue(new Callback<sign_up_response_model>() {
            @Override
            public void onResponse(Call<sign_up_response_model> call, Response<sign_up_response_model> response) {
                sign_up_response_model obj =response.body();
                String result=obj.getMessage().trim();
                if(result.equals("inserted")) {
                    tv.setText("Successfully Registered");
                    tv.setTextColor(Color.GREEN);
                    regemail.setText("");
                    regmobile.setText("");
                    regpassword.setText("");
                }
                if(result.equals("exist"))
                {
                    tv.setText("Sorry...! You are already registered");
                    tv.setTextColor(Color.RED);
                    regemail.setText("");
                    regmobile.setText("");
                    regpassword.setText("");
                }
            }

            @Override
            public void onFailure(Call<sign_up_response_model> call, Throwable t) {
                tv.setText("Something went wrong");
                tv.setTextColor(Color.RED);
                regemail.setText("");
                regmobile.setText("");
                regpassword.setText("");
            }
        });
    }
}