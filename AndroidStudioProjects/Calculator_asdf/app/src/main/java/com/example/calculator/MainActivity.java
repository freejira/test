package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String inputnum = "";          // 사용자가 입력 중인 식
    double result = 0;          // 계산 결과 저장용
    String operator = "";       // 현재 연산자
    boolean isNewOp = false;     // 새로 입력 시작 여부
    String historynum="";

    String memory="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonequal=(Button) findViewById(R.id.buttonequal);
        Button buttondot=(Button) findViewById(R.id.buttondot);
        Button buttonzerro=(Button) findViewById(R.id.buttonzerro);
        Button buttonplus=(Button) findViewById(R.id.buttonplus);
        Button buttonplusminus=(Button) findViewById(R.id.buttonplusminus);
        Button button1=(Button) findViewById(R.id.button1);
        Button button2=(Button) findViewById(R.id.button2);
        Button button3=(Button) findViewById(R.id.button3);
        Button button4=(Button) findViewById(R.id.button4);
        Button button5=(Button) findViewById(R.id.button5);
        Button button6=(Button) findViewById(R.id.button6);
        Button button7=(Button) findViewById(R.id.button7);
        Button button8=(Button) findViewById(R.id.button8);
        Button button9=(Button) findViewById(R.id.button9);
        Button buttonce=(Button) findViewById(R.id.buttonce);
        Button buttonc=(Button) findViewById(R.id.buttonc);
        Button buttondelete=(Button) findViewById(R.id.buttondelete);
        Button buttonminus=(Button) findViewById(R.id.buttonminus);
        Button buttonmultiple=(Button) findViewById(R.id.buttonmultiple);
        Button buttondivision=(Button) findViewById(R.id.buttondivision);
        Button buttonreciprocal= (Button)findViewById(R.id.buttonreciprocal);
        Button buttonxsquared= (Button)findViewById(R.id.buttonxsquared);
        Button buttonroot=(Button)findViewById(R.id.buttonroot);
        Button buttonMS=(Button)findViewById(R.id.buttonMS);
        Button buttonMC=(Button)findViewById(R.id.buttonMC);
        Button buttonMR=(Button)findViewById(R.id.buttonMR);
        Button buttonMminus=(Button)findViewById(R.id.buttonMinus);
        Button buttonMplus=(Button)findViewById(R.id.buttonMplus);
        TextView calculator =(TextView) findViewById(R.id.calculator);
        TextView historytext= (TextView) findViewById(R.id.historytext);



       buttonzerro.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               inputnum += "0";
               historynum+="0";
               calculator.setText(inputnum);
               historytext.setText(historynum);
           }
       });
       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               inputnum += "1";
               historynum+="1";
               calculator.setText(inputnum);
               historytext.setText(historynum);
           }
       });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputnum += "2";
                historynum+="2";
                calculator.setText(inputnum);
                historytext.setText(historynum);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputnum += "3";
                historynum+="3";
                calculator.setText(inputnum);
                historytext.setText(historynum);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputnum += "4";
                historynum+="4";
                calculator.setText(inputnum);
                historytext.setText(historynum);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputnum += "5";
                historynum+="5";
                calculator.setText(inputnum);
                historytext.setText(historynum);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputnum += "6";
                historynum+="6";
                calculator.setText(inputnum);
                historytext.setText(historynum);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputnum += "7";
                historynum+="7";
                calculator.setText(inputnum);
                historytext.setText(historynum);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputnum += "8";
                historynum+="8";
                calculator.setText(inputnum);
                historytext.setText(historynum);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputnum += "9";
                historynum+="9";
                calculator.setText(inputnum);
                historytext.setText(historynum);
            }
        });
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator="+";
                calculator.setText(operator);
                historynum+="+";
                historytext.setText(historynum);
                double secondNum = Double.parseDouble(inputnum);
                if(isNewOp == false)
                {
                    result = Double.parseDouble(inputnum); // 최초 입력은 그대로 저장
                    isNewOp = true;
                }
                else if (isNewOp==true)
                {
                    result += secondNum;
                }
                inputnum="";
            }
        });
        buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator="-";
                calculator.setText(operator);
                historynum+="-";
                historytext.setText(historynum);

                double secondNum = Double.parseDouble(inputnum);
                if(isNewOp == false)
                {
                    result = Double.parseDouble(inputnum); // 최초 입력은 그대로 저장
                    isNewOp = true;
                } else if (isNewOp==true)
                {
                    result -= secondNum;
                }
                inputnum="";
            }
        });
        buttonmultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator="x";
                calculator.setText(operator);
                historynum+="x";
                historytext.setText(historynum);

                double secondNum = Double.parseDouble(inputnum);
                if(isNewOp == false)
                {
                    result = Double.parseDouble(inputnum); // 최초 입력은 그대로 저장
                    isNewOp = true;
                }
                else if (isNewOp==true)
                {
                    result *= secondNum;
                }
                inputnum="";
            }
        });
        buttondivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator="%";
                calculator.setText(operator);
                historynum+="%";
                historytext.setText(historynum);

                double secondNum = Double.parseDouble(inputnum);
                if(isNewOp == false)
                {
                    result = Double.parseDouble(inputnum); // 최초 입력은 그대로 저장
                    isNewOp = true;
                }
                else if (isNewOp==true)
                {
                    result /= secondNum;
                }
                inputnum="";
            }
        });
       buttonequal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               double secondNum = Double.parseDouble(inputnum);

               switch (operator) {
                   case "+":
                       result += secondNum;
                       break;
                   case "-":
                       result -= secondNum;
                       break;
                   case "x":
                       result *= secondNum;
                       break;
                   case "/":
                       if (secondNum != 0) {
                           result /= secondNum;
                       } else {
                           calculator.setText("Error");
                           return;
                       }
                       break;
               }



               inputnum = "";
               historynum="";
               calculator.setText(Double.toString(result));
               historytext.setText(historynum);
               result=0;
               isNewOp=false;
           }
       });

      buttondelete.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if (inputnum != null && !inputnum.isEmpty()) {
                  // 마지막 문자 제거
                  inputnum = inputnum.substring(0, inputnum.length() - 1);
                  // 결과를 화면에 업데이트
                  calculator.setText(inputnum);
              }
              if (historynum != null && !historynum.isEmpty()) {
                  // 마지막 문자 제거
                  historynum = historynum.substring(0, historynum.length() - 1);
                  // 결과를 화면에 업데이트
                  historytext.setText(historynum);
              }
          }
      });
      buttonc.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              inputnum="";
              historynum+="";
              result=0;
              calculator.setText(Double.toString(result));
              historytext.setText(historynum);
              isNewOp=false;
              historynum="";
              historytext.setText(historynum);
          }
      });
      buttonce.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
                inputnum="";
                calculator.setText(inputnum);


              historynum=historytext.getText().toString();


              int lastOperatorIndex = Math.max(
                      historynum.lastIndexOf('+'),
                      Math.max( historynum.lastIndexOf('-'),
                              Math.max( historynum.lastIndexOf('x'),  historynum.lastIndexOf('/')))
              );

              if (lastOperatorIndex != -1) {
                  // 연산자 이후만 지우기
                  historynum=  historynum.substring(0, lastOperatorIndex + 1);
              } else {
                  // 연산자가 없으면 전체 지우기
                  historynum = "";
              }

             historytext.setText( historynum);



          }


      });
      buttonplusminus.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if (inputnum != null && !inputnum.isEmpty()) {
                  if (inputnum.startsWith("-")) {
                      // 이미 마이너스면 제거
                      inputnum = inputnum.substring(1);
                  } else {
                      // 아니면 마이너스 붙이기
                      inputnum = "-" + inputnum;
                  }

                  // 결과 화면에 반영
                  calculator.setText(inputnum);
              }
          }
      });
      buttondot.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              inputnum += ".";
              calculator.setText(inputnum);
          }
      });
      buttonreciprocal.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              if (inputnum != null && !inputnum.isEmpty()) {
                 {
                      double value = Double.parseDouble(inputnum);
                      if (value != 0) {
                          // 1을 해당 숫자로 나누기 (역수 계산)
                          value = 1 / value;
                          inputnum = String.valueOf(value);
                          calculator.setText(inputnum);
                      }
                  }
              }

          }
      });
      buttonxsquared.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              double value= Double.parseDouble(inputnum);
              result=value*value;
              inputnum=String.valueOf(result);
              calculator.setText(inputnum);
          }
      });
      buttonroot.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              if (inputnum != null && !inputnum.isEmpty()) {
                  try {
                      double value = Double.parseDouble(inputnum);
                      if (value >= 0) {
                          double result = Math.sqrt(value);
                          calculator.setText(String.valueOf(result));
                          inputnum = String.valueOf(result); // 이후 연산에 계속 사용 가능
                      } else {
                          calculator.setText("Error"); // 음수의 제곱근은 실수 계산 불가
                      }
                  } catch (NumberFormatException e) {
                      calculator.setText("Error"); // 숫자가 아닐 때
                  }
              }

          }
      });
    buttonMS.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            memory=inputnum;
        }
    });
    buttonMR.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            inputnum=memory;
            calculator.setText(inputnum);
        }
    });
    buttonMC.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            memory="";
            inputnum="";
            calculator.setText("");

        }
    });
    buttonMplus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double memorynum;

            memorynum = Double.parseDouble(inputnum);

            double result = Double.parseDouble(memory) + memorynum;
            memory = String.valueOf(result);

            calculator.setText(memory);


        }
    });
    buttonMminus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double memorynum;

            memorynum = Double.parseDouble(inputnum);

            double result = Double.parseDouble(memory) - memorynum;
            memory = String.valueOf(result);

            calculator.setText(memory);
        }
    });




    }
}