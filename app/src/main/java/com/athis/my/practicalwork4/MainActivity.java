package com.athis.my.practicalwork4;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity {

    String MS = "";
    TextView disInput, disOutput;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSub,
            buttonMul, buttonDiv, buttonMemSet, buttonBackSpace, buttonDot, buttonClear, buttonMemRes, buttonMemClear;

    ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("rhino");

    private void calculateOutput() {
        String input = disInput.getText()+"";
        int inputLen = input.length();
        try {
            if (input.length() > 0) {
                input = scriptEngine.eval(input)+"";
                disOutput.setText(input.replaceFirst("\\.0*$|(\\.\\d*?)0+$", ""));
            } else {
                disOutput.setText("0");
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        if (inputLen < 12) {
            disInput.setTextSize(50);
        } else if (inputLen < 48) {
            disInput.setTextSize(25);
        } else {
            disInput.setTextSize(13);
        }
        String out = disOutput.getText()+"";
        if (out.length() > 12) {
            String magnitude = "";
            if (out.contains("E")) {
                magnitude = out.substring(out.indexOf("E"));
                disOutput.setText((disOutput.getText()+"").substring(0, 12-magnitude.length()) + magnitude);
            } else {
                disOutput.setText((disOutput.getText()+"").substring(0, 12));
            }
        }
    }

    private String addOperator(String input, String oper) {
        if (input.equals("")) {
            if (oper.equals("-")) { return "-"; } else if (oper.equals(".")) { return "0."; } else { return ""; }
        } else if (input.length() == 1) {
            if (input.matches("[0-9A-Za-z]")) {
                return input + oper;
            } else if (oper.equals(".") && input.matches("[-+/*.]$")) {
                if (input.equals("-")) { return "-0."; } else { return "0."; }
            } else if (input.equals("-")) {
                if (oper.equals("+")) { return ""; } else { return "-"; }
            } else {
                return oper;
            }
        } else {
            String last = input.substring(input.length()-1);
            if (last.matches("[0-9A-Za-z]")) {
                String numTrim = input.replaceAll("[0-9A-Za-z]+$", "");
                if (!numTrim.equals("") && numTrim.substring(numTrim.length() - 1).equals(".") && oper.equals(".")) {
                    return input;
                } else {
                    return input + oper;
                }
            } else if (last.matches("[/*]") && oper.equals("-")) {
                return input + oper;
            } else {
                String noLast = input.substring(0, input.length() - 1);
                if (oper.equals(".")) {
                    String trimNum = noLast.replaceAll("[0-9A-Za-z]+$", "");
                    if (!trimNum.equals("") && trimNum.substring(trimNum.length() - 1).equals(".")) {
                        return input;
                    } else if (last.equals("-")) {
                        return input + "0.";
                    } else {
                        return noLast + ".";
                    }
                } else {
                    if (noLast.substring(noLast.length()-1).matches("[/*]")) {
                        return input;
                    } else {
                        return noLast + oper;
                    }
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonBackSpace = (Button) findViewById(R.id.buttonBackSpace);
        buttonMemSet = (Button) findViewById(R.id.buttonMemSet);
        buttonMemRes = (Button) findViewById(R.id.buttonMemRes);
        buttonMemClear = (Button) findViewById(R.id.buttonMemClear);

        disInput = (TextView) findViewById(R.id.displayInput);
        disOutput = (TextView) findViewById(R.id.displayOutput);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(disInput.getText() + "1");
                calculateOutput();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(disInput.getText() + "2");
                calculateOutput();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(disInput.getText() + "3");
                calculateOutput();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(disInput.getText() + "4");
                calculateOutput();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(disInput.getText() + "5");
                calculateOutput();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(disInput.getText() + "6");
                calculateOutput();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(disInput.getText() + "7");
                calculateOutput();
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(disInput.getText() + "8");
                calculateOutput();
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(disInput.getText() + "9");
                calculateOutput();
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(disInput.getText() + "0");
                calculateOutput();
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(addOperator(disInput.getText()+"", "/"));
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(addOperator(disInput.getText()+"", "*"));
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(addOperator(disInput.getText()+"", "-"));
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(addOperator(disInput.getText()+"", "+"));
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText(addOperator(disInput.getText()+"", "."));
            }
        });

        buttonBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = disInput.getText()+"";
                if (!text.equals("")) {
                    text = text.substring(0, text.length()-1);
                    disInput.setText(text);
                    String last = "";
                    if (!text.equals("")) {
                        last = text.substring(text.length()-1);
                    }
                    if (text.equals("") || !last.matches("[-/*+]$")) {
                        calculateOutput();
                    }
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disInput.setText("");
                calculateOutput();
            }
        });

        buttonMemSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MS = disOutput.getText()+"";
            }
        });

        buttonMemRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = disInput.getText()+"";
                if (text.equals("")) {
                    disInput.setText(MS);
                    calculateOutput();
                } else {
                    String last = text.substring(text.length()-1);
                    if (!MS.equals("")) {
                        if ((MS.charAt(0)+"").equals("-")) {
                            if (last.equals("-")) {
                                text = text.substring(0, text.length()-1);
                                disInput.setText(text + "+" + MS.substring(1));
                            } else if (last.matches("[+.]")) {
                                text = text.substring(0, text.length()-1);
                                disInput.setText(text + MS);
                            } else {
                                disInput.setText(text + MS);
                            }
                            calculateOutput();
                        } else if (last.matches("[-+/*]")) {
                            disInput.setText(text + MS);
                            calculateOutput();
                        }
                    }
                }
            }
        });

        buttonMemClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MS = "";
            }
        });

    }
}