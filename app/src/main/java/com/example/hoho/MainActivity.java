package com.example.hoho;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText loginemail, loginpassword;
    TextView loginreport;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view first to inflate the layout
        setContentView(R.layout.activity_main);

        // Enable Edge-to-Edge layout
        EdgeToEdge.enable(this);

        loginemail = findViewById(R.id.login_email);
        loginpassword = findViewById(R.id.login_password);
        loginreport = findViewById(R.id.login_report);

        loginbtn = findViewById(R.id.login_submit);

        verifyuserexistence();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processlogin(loginemail.getText().toString(), loginpassword.getText().toString());
            }
        });

        // Set up the TextView click listener
        tv = findViewById(R.id.login_tv);
        tv.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), register.class));
            finish();
        });
    }

    public void processlogin(String email, String password) {
        Call<login_response_model> call=apicontroller.getInstance().getapi().getlogin(email,password);

        call.enqueue(new Callback<login_response_model>() {
            @Override
            public void onResponse(Call<login_response_model> call, Response<login_response_model> response) {
                login_response_model obj=response.body();
                String result=obj.getMessage();
                if(result.equals("exist")) {
                    SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("username",email);
                    editor.putString("password",password);
                    editor.commit();
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(), dashboard.class));
                    finish();
                }
                if(result.equals("not_exist")) {
                    loginreport.setText("Invalid username or password");
                    loginemail.setText("");
                    loginpassword.setText("");
                }
            }

            @Override
            public void onFailure(Call<login_response_model> call, Throwable t) {
                loginreport.setText("Something went wrong");
            }
        });
    }

    public void verifyuserexistence() {
        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("username")) {
            startActivity(new Intent(getApplicationContext(), dashboard.class));
        }
    }
}