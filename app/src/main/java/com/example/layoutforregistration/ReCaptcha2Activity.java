package com.example.layoutforregistration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.layoutforregistration.CaptchaImageView2;


/**
 * Created by D on 4/9/2018.
 */

public class ReCaptcha2Activity extends AppCompatActivity{
    //Gd One

    //Template
    ImageView refreshButton;
    EditText captchaInput;
    Button submitButton;
    CaptchaImageView2 captchaImageView2;

    //Real
    CaptchaImageView2 captcha_image;
    Button captcha_submit;
    EditText captcha_input;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Template
        setContentView(R.layout.testing_recaptcha2);
        refreshButton= (ImageView) findViewById(R.id.regen);
        captchaInput= (EditText) findViewById(R.id.captchaInput);
        submitButton= (Button) findViewById(R.id.submitButton);
        captchaImageView2= (CaptchaImageView2) findViewById(R.id.image);

        //# captcha letter
        captchaImageView2.setCaptchaLength(6);

        // 1=letter,2=#,3=both
        captchaImageView2.setCaptchaType(2);


        captchaImageView2.setIsDotNeeded(true); //do this if you need dotted background
        captchaImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //refresh
                captchaImageView2.regenerate();
            }
        });
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captchaImageView2.regenerate();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checking match or not(string)
                if(captchaInput.getText().toString().equals(captchaImageView2.getCaptchaCode())){
                    Toast.makeText(ReCaptcha2Activity.this, "Matched", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ReCaptcha2Activity.this, "Not Matching", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //Real
        captcha_image = findViewById(R.id.captcha_image);
        captcha_input = findViewById(R.id.captcha_input);
        captcha_submit = findViewById(R.id.captcha_submit);
        captcha_image.setCaptchaLength(4);
        captcha_image.setCaptchaType(2);
        //captcha_image.setIsDotNeeded(true);
        captcha_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captcha_image.regenerate();
            }
        });

        captcha_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(captcha_input.getText().toString().equals(captcha_image.getCaptchaCode())){
                    Toast.makeText(ReCaptcha2Activity.this, "Matched", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ReCaptcha2Activity.this, "Not Matching", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
