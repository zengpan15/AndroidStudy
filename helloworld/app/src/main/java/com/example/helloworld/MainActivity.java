package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton rb1;
    RadioButton rb2;
    TextView tvResult;
    EditText txt1;
    EditText txt2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);//判断男女
        tvResult = findViewById(R.id.tvResult);
        txt1 = findViewById(R.id.ww1);
        txt2 = findViewById(R.id.ww2);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double x = Double.parseDouble(txt1.getText().toString());//身高
        double y = Double.parseDouble(txt2.getText().toString());//体重//体重除以身高的平方
        double res;
        String str = "Your BMI is";
        if (x <= 0 || y <= 0) {
            tvResult.setText("值异常，不计算");
            return;
        }
        x = x / 100;
        res = y / (x * x);
        String str1 = String.format("%.2f", res);
        str = str + str1;
        if (rb1.isChecked())
            res -= 1;//以女性为标准进行比较
        //仅以女性作为评价标准

        str += "体型:";
       /* if(res < 19)
            str += "你的体型偏瘦，需要多吃点";
        else if(res>= 19 && res < 24)
            str += "你的体型适中，继续保持呀";
        else if(res>=24 && res<26)
            str += "你的体型超重，要注意啦";
        else if(res>=26 && res<29)
            str += "你的体型轻度偏胖，需要少吃点";
        else if(res>=29 && res<34)
            str +="你的体型中度肥胖，要注意啦";
        else
            str += "你的体型严重肥胖，需要小心了";
        tvResult.setText(str);*/
        if (rb1.isChecked()) {
            str += "体型:";
            if (res < 19)
                str += "你的体型偏瘦，需要多吃点";
            else if (res >= 19 && res < 24)
                str += "你的体型适中，继续保持呀";
            else if (res >= 24 && res < 26)
                str += "你的体型超重，要注意啦";
            else if (res >= 26 && res < 29)
                str += "你的体型轻度偏胖，需要少吃点";
            else if (res >= 29 && res < 34)
                str += "你的体型中度肥胖，要注意啦";
            else
                str += "你的体型严重肥胖，需要小心了";
            tvResult.setText(str);
        } else {
            str += "体型:";
            if (res < 20)
                str += "你的体型偏瘦，需要多吃点";
            else if (res >= 20 && res < 25)
                str += "你的体型适中，继续保持呀";
            else if (res >= 25 && res < 27)
                str += "你的体型超重，要注意啦";
            else if (res >= 27 && res < 30)
                str += "你的体型轻度偏胖，需要少吃点";
            else if (res >= 30 && res < 35)
                str += "你的体型中度肥胖，要注意啦";
            else
                str += "你的体型严重肥胖，需要小心了";
            tvResult.setText(str);
        }


    }
}