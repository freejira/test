package com.example.middle_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nowTextView;
    private TextView resultTextView;

    // 화면에 표시할 값들


    // 10개의 메모리 슬롯
    private final String[] memoryValues = new String[10];
    // 현재 선택된 메모리 인덱스 (0~9)
    private int memIndex = 0;

    String result_pre = "0";
    String nowNum = "0";
    String nowNum_pre = "0";
    String resultNum = "";
    String enter_Num = "";
    String V_nowNum = "";
    String V_resultNum = "";

    boolean Dot_onoff = false;
    boolean Enter_onoff = false;
    boolean Enter_onoff_pre = false;
    boolean Error_Zero = false;
    String operatorValue = "";  // 연산자 값


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nowTextView = findViewById(R.id.now);
        resultTextView = findViewById(R.id.result);

        // 클릭 리스너 설정할 버튼 ID 배열
        int[] buttonIds = {
                R.id.num_0, R.id.num_1, R.id.num_2, R.id.num_3, R.id.num_4,
                R.id.num_5, R.id.num_6, R.id.num_7, R.id.num_8, R.id.num_9,
                R.id.Back, R.id.CE, R.id.C, R.id.percent,  R.id.enter,
                R.id.negation, R.id.dot,
                R.id.add, R.id.sub, R.id.mul, R.id.div,
                R.id.denominator, R.id.square, R.id.root,
                R.id.MC, R.id.MR, R.id.Mplus, R.id.Mminus, R.id.MS, R.id.Mv
        };

        // 각 버튼에 클릭 리스너를 설정
        for (int id : buttonIds) {
            Button btn = findViewById(id);
            btn.setOnClickListener(this);
        }

        Arrays.fill(memoryValues, "0");

        updateDisplay();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        Dot_onoff = nowNum.contains(".");
        Enter_onoff_pre = Enter_onoff;
        nowNum_pre = nowNum;
        Error_Zero = false;
        Enter_onoff = false;


        // 숫자 입력
        if (id == R.id.num_0) Click_NUM("0");
        else if (id == R.id.num_1) Click_NUM("1");
        else if (id == R.id.num_2) Click_NUM("2");
        else if (id == R.id.num_3) Click_NUM("3");
        else if (id == R.id.num_4) Click_NUM("4");
        else if (id == R.id.num_5) Click_NUM("5");
        else if (id == R.id.num_6) Click_NUM("6");
        else if (id == R.id.num_7) Click_NUM("7");
        else if (id == R.id.num_8) Click_NUM("8");
        else if (id == R.id.num_9) Click_NUM("9");

        // 소수점 찍기
        else if (id == R.id.dot) Click_Dot();

        // 백스페이스
        else if (id == R.id.Back) {
            nowNum = nowNum.substring(0, nowNum.length() - 1);
            if(nowNum.isEmpty()){
                nowNum = "0";
            }
            updateDisplay();
        }

        // 연산자 입력
        else if (id == R.id.add) CLick_Operator("+");
        else if (id == R.id.sub) CLick_Operator("-");
        else if (id == R.id.mul) CLick_Operator("*");
        else if (id == R.id.div) CLick_Operator("/");

        // CE: 현재 입력만 리셋
        else if (id == R.id.CE) Reset(1);

        // C: 전체 리셋
        else if (id == R.id.C) Reset(2);

        // %: 백분율 처리 (현재 값의 1%를 구함)
        else if (id == R.id.percent) Percent();


        // =
        else if (id == R.id.enter) Click_enter();


        // 1/x: 분수화 (nowNum 역수 구하기)
        else if (id == R.id.denominator) Special_calculations(1);
        // x²: 제곱
        else if (id == R.id.square) Special_calculations(2);
        // 2√x: 제곱근
        else if (id == R.id.root) Special_calculations(3);
        // +/-: 부호 전환
        else if (id == R.id.negation) Special_calculations(4);


        // 메모리 저장
        else if (id == R.id.MS) Memory("S");

        // 메모리 불러오기
        else if (id == R.id.MR) Memory("R");
        // 메모리 더하기
        else if (id == R.id.Mplus) Memory("P");
        // 메모리 빼기
        else if (id == R.id.Mminus) Memory("M");
        // 메모리 전체 초기화
        else if (id == R.id.MC) Memory("C");
        // 메모리 슬롯 변경
        else if (id == R.id.Mv)  Memory("v");


    }

    private void Reset(int i) {

        switch (i)
        {
            case 1:
                nowNum = "0";

                if(Enter_onoff_pre) {
                    resultNum = "";
                    enter_Num = "";
                    operatorValue = "";
                    Dot_onoff = false;
                    Enter_onoff = false;
                    Enter_onoff_pre = false;
                }
                break;

            case 2:
                nowNum = "0";
                resultNum = "";
                enter_Num = "";
                operatorValue = "";
                Dot_onoff = false;
                Enter_onoff = false;
                Enter_onoff_pre = false;
                break;

        }
        updateDisplay();

    }


    // 숫자 입력 처리
    private void Click_NUM(String num) {
        if (nowNum.equals("0")) {
            nowNum = num;
        }

        else {
            nowNum += num;
        }

        updateDisplay_num();
    }

    // 소수점 처리
    private void Click_Dot() {

        if(!Dot_onoff) {
            nowNum = nowNum + ".";
            Dot_onoff = true;
        }

        updateDisplay();
    }

    private void Special_calculations(int i) {

        double number = Double.parseDouble(nowNum);

        if(i == 1) { //분모화

            if (number != 0) { number = 1 / number; }
            else { number = 0; }
        }


        else if (i == 2) { // 제곱

            number = Math.pow(number, 2);
        } 
        
        else if (i == 3) { //루트

            if (number >= 0) {
                number = Math.sqrt(number);
            } else {
                number = 0; // 음수의 제곱근은 NaN으로 처리
            }
        }

        else if ( i == 4) {
            number = number * (-1);
        }

        nowNum = Check_integer(number);

        updateDisplay_num();
    }


    // 연산자 처리
    private void CLick_Operator(String operator) {

        if(operatorValue.isEmpty()){

            resultNum = nowNum_pre;
        }

        else {

            calculate();
        }

        nowNum = "0";
        operatorValue = operator;
        updateDisplay();
    }

    private void Percent() {

        double number = Double.parseDouble(nowNum);

        if (operatorValue.isEmpty()) {
            if (number != 0) {
                number /= 100;
                nowNum = Check_integer(number);
            }
        }

        else if (!resultNum.isEmpty()) {

            double a = Double.parseDouble(resultNum);
            double b = number;
            double p;

            switch (operatorValue) {
                case "+":
                case "-":
                    p = a * b / 100;
                    break;
                case "*":
                case "/":
                    p = b / 100;
                    break;
                default:
                    p = b / 100;
            }
            number = p;
            nowNum = Check_integer(number);
        }


        updateDisplay();
    }

    private void Click_enter() {

        double result = 0;
        double NUM1;
        double NUM2;
        result_pre = nowNum;


        if(operatorValue.isEmpty()){

        resultNum = nowNum_pre;
        }
        else {

            if (!Enter_onoff_pre) {
                NUM1 = Double.parseDouble(resultNum);
                NUM2 = Double.parseDouble(nowNum);
                enter_Num = nowNum;
            }
            else {
                NUM1 = Double.parseDouble(nowNum);
                NUM2 = Double.parseDouble(enter_Num);
                resultNum = result_pre;
            }

            switch (operatorValue) {
                case "+":
                    result = NUM1 + NUM2;
                    break;
                case "-":
                    result = NUM1 - NUM2;
                    break;
                case "*":
                    result = NUM1 * NUM2;
                    break;
                case "/":
                    if (NUM2 != 0) {
                        result = NUM1 / NUM2;
                    } else {
                        Error_Zero = true;
                    }
                    break;
            }
        }




        nowNum = Check_integer(result);
        Enter_onoff = true;

        updateDisplay();
    }


    private void Memory(String type) {

        double number = Double.parseDouble(nowNum);
        double m_number = Double.parseDouble(memoryValues[memIndex]);

        switch (type) {
            case "S":
                if(memIndex < memoryValues.length - 1) memIndex += 1;
                memoryValues[memIndex] = nowNum;
                break;
            case "R":
                nowNum = memoryValues[memIndex];
                break;
            case "P":
                m_number += number;
                memoryValues[memIndex] = Check_integer(m_number);
                break;
            case "M":
                m_number -= number;
                memoryValues[memIndex] = Check_integer(m_number);
                break;
            case "C":
                Arrays.fill(memoryValues, "0");
                   break;
            case "v": // 슬롯 변경
                if(memIndex > 0)    memIndex -= 1;
                nowNum = memoryValues[memIndex];
                break;
            default:
                nowNum = "";

        }

        updateDisplay();
    }


    private void calculate() {

        double result = 0;
        double NUM1 = Double.parseDouble(resultNum);
        double NUM2 = Double.parseDouble(nowNum);
        nowNum = "0";

        switch (operatorValue) {
            case "+":
                result = NUM1 + NUM2;
                break;
            case "-":
                result = NUM1 - NUM2;
                break;
            case "*":
                result = NUM1 * NUM2;
                break;
            case "/":
                if (NUM2 != 0) {
                    result = NUM1 / NUM2;
                }
                else {
                    Error_Zero = true;
                }
                break;
        }

        resultNum = Check_integer(result);

    }



    String Check_integer(double number)
    {
        double a;
        String NUM;

        a = number - Math.floor(number);

        if (a == 0) {

            DecimalFormat df = new DecimalFormat("#.##");
            NUM = df.format(number);  // df.format()을 사용하여 숫자를 포맷
        }

        else {

            NUM = String.valueOf(number);
        }

        return NUM;
    }

    // 화면 갱신

    private void updateDisplay_num() {

        V_nowNum = nowNum;

        nowTextView.setText(V_nowNum);
    }



    private void updateDisplay() {
        boolean hasValue = !memoryValues[memIndex].equals("0");
        Button BTN_MC = findViewById(R.id.MC);
        Button BTN_MR = findViewById(R.id.MR);
        Button BTN_Mv = findViewById(R.id.Mv);

        BTN_MC.setClickable(hasValue);
        BTN_MR.setClickable(hasValue);
        BTN_Mv.setClickable(hasValue);

        if(hasValue) {
            BTN_MC.setAlpha(1);
            BTN_MR.setAlpha(1);
            BTN_Mv.setAlpha(1);
        }
        else{
            BTN_MC.setAlpha(0.5f);
            BTN_MR.setAlpha(0.5f);
            BTN_Mv.setAlpha(0.5f);

        }


        if(!Error_Zero) {

            V_nowNum = nowNum;

            if(Enter_onoff)
            {
                if(!operatorValue.isEmpty())
                    V_resultNum = resultNum + operatorValue + enter_Num + " = ";
                else
                    V_resultNum = resultNum + " = ";

            }
            else {
                V_resultNum = resultNum + operatorValue;
            }
        }

        else{

            V_nowNum = "0으로 나눌 수 없습니다";
        }

        nowTextView.setText(V_nowNum);
        resultTextView.setText(V_resultNum);
    }

}


