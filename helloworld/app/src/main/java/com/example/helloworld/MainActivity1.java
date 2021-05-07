package com.example.helloworld;

import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
public class MainActivity1 extends AppCompatActivity implements  View.OnClickListener{
    private EditText main_et_result;
    boolean clear_flag;//清空

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_et_result = findViewById(R.id.tv_result);
    }


    public void doSubmit(View view) {
        int id = view.getId();
        String input = main_et_result.getText().toString();
        switch (id){
            case R.id.btn_0:
                main_et_result.setText(main_et_result.getText().toString()+"0");
                break;
            case R.id.btn_1:
                main_et_result.setText(main_et_result.getText().toString()+"1");
                break;
            case R.id.btn_2:
                main_et_result.setText(main_et_result.getText().toString()+"2");
                break;
            case R.id.btn_3:
                main_et_result.setText(main_et_result.getText().toString()+"3");
                break;
            case R.id.btn_4:
                main_et_result.setText(main_et_result.getText().toString()+"4");
                break;
            case R.id.btn_5:
                main_et_result.setText(main_et_result.getText().toString()+"5");
                break;
            case R.id.btn_6:
                main_et_result.setText(main_et_result.getText().toString()+"6");
                break;
            case R.id.btn_7:
                main_et_result.setText(main_et_result.getText().toString()+"7");
                break;
            case R.id.btn_8:
                main_et_result.setText(main_et_result.getText().toString()+"8");
                break;
            case R.id.btn_9:
                main_et_result.setText(main_et_result.getText().toString()+"9");
                break;
            case R.id.btn_minus:
                main_et_result.setText(main_et_result.getText().toString()+"*");
                break;
            case R.id.btn_back:
                main_et_result.setText(main_et_result.getText().toString()+"/");
                if(clear_flag){
                    clear_flag = false;
                    input = "";
                    main_et_result.setText("");
                }
                main_et_result.setText(input+((Button) view).getText().toString());
                break;
            case R.id.btn_equal:
                main_et_result.setText(main_et_result.getText().toString()+"+");
                break;
            case R.id.btn_add:
                main_et_result.setText(main_et_result.getText().toString()+"-");
                break;
            case R.id.btn_point:
                main_et_result.setText(main_et_result.getText().toString()+".");
                if(clear_flag){
                    clear_flag = false;
                    main_et_result.setText("");
                }
                main_et_result.setText(input+((Button) view).getText().toString());
                break;
            case R.id.btn_equal1:
                main_et_result.setText("=");
                getResult();
                break;
            case R.id.btn_back1:
                main_et_result.setText("退格");
                if(clear_flag){
                    clear_flag = false;
                    main_et_result.setText("");
                }else if(input != null || !input.equals("")){
                    main_et_result.setText(input.substring(0,input.length()-1));
                }
                break;
            case R.id.btn_multipy1:
                main_et_result.setText("C");
                clear_flag = false;
                input = "";
                main_et_result.setText("");
                break;
        }
    }

    private void getResult() {
        String exp = main_et_result.getText().toString();
        if(exp==null||exp.equals(""))
            return;
        if(!exp.contains(""))
            return;
        if(clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        double result = 0;
        //运算符前的数字
        String s1 = exp.substring(0,exp.indexOf(" "));
        //运算符
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        //运算符后的数字
        String s2 = exp.substring(exp.indexOf(" ")+3);
        if(!s1.equals("")&&!s2.equals("")){
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if(op.equals("+")){
                result = d1+d2;
            }else if(op.equals("-")){
                result = d1-d2;
            }else if(op.equals("*")){
                result = d1*d2;
            }else if(op.equals("/")){
                if(d2==0){
                    result = 0;
                }else{
                    result = d1/d2;
                }
            }
            if(!s1.contains(".")&& !s2.contains(".")&&!op.equals("/")){
                int r =(int) result;
                main_et_result.setText(r+"");
            }else{
                main_et_result.setText(result+"");
            }
        }else if(!s1.equals("")&&s2.equals("")){
            main_et_result.setText(exp);
        }else if(s1.equals("")&& !s2.equals("")){
            double d2 = Double.parseDouble(s2);
            if(op.equals("+")){
                result = 0+d2;
            }else if(op.equals("-")){
                result = 0-d2;
            }else if(op.equals("*")){
                result = 0;
            }else if(op.equals("/")){
                result = 0;
            }
            if(!s1.contains(".")&&!s2.contains(".")){
                int r = (int)result;
                main_et_result.setText(r+"");
            }else{
                main_et_result.setText(result+"");
            }
        }else{
            main_et_result.setText("");
        }
    }

    @Override
    public void onClick(View view) {

    }
}
