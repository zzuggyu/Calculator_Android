package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnMC, btnMR, btnMP, btnMM;
    Button btnRemainer, btnRoot, btnSquare, btnReciprocal;
    Button btnCE, btnC, btnDel, btnDiv, btnMul, btnSub, btnAdd;
    Button btnSign, btnPoint, btnResult;
    TextView tvProcess, tvResult;
    double[] result = new double[100];
    double[] memory = new double[100];
    int i, j, count = 0;
    int where, end = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnMC = (Button) findViewById(R.id.btnMC);
        btnMR = (Button) findViewById(R.id.btnMR);
        btnMP = (Button) findViewById(R.id.btnMP);
        btnMM = (Button) findViewById(R.id.btnMM);

        btnRemainer = (Button) findViewById(R.id.btnRemainer);
        btnRoot = (Button) findViewById(R.id.btnRoot);
        btnSquare = (Button) findViewById(R.id.btnSquare);
        btnReciprocal = (Button) findViewById(R.id.btnReciprocal);

        btnCE = (Button) findViewById(R.id.btnCE);
        btnC = (Button) findViewById(R.id.btnC);
        btnDel = (Button) findViewById(R.id.btnDel);

        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnSign = (Button) findViewById(R.id.btnSign);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnResult = (Button) findViewById(R.id.btnResult);

        tvProcess = (TextView) findViewById(R.id.tvProcess);
        tvResult = (TextView) findViewById(R.id.tvResult);

        Button.OnClickListener c1 = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String str = editResult.getText().toString();
                if (end == 1)
                {
                    tvResult.setText("");
                    tvProcess.setText("");
                    end = 0;
                }

                if (v==btnDel | v==btnSign)
                {
                    if (tvResult.length() == 0)
                        Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    else {
                        if (v == btnDel) {
                            String del_number = tvResult.getText().toString();
                            tvProcess.setText(del_number.substring(0, del_number.length() - 1));
                            tvResult.setText(del_number.substring(0, del_number.length() - 1));
                        } else if (v == btnSign) {
                            if (Double.parseDouble(tvResult.getText().toString()) - (int) Double.parseDouble(tvResult.getText().toString()) == 0.0) {
                                tvResult.setText("" + (Integer.parseInt(tvResult.getText().toString()) * -1));
                                tvProcess.setText("" + (Integer.parseInt(tvProcess.getText().toString()) * -1));
                            } else {
                                tvResult.setText("" + (Double.parseDouble(tvResult.getText().toString()) * -1));
                                tvProcess.setText("" + (Integer.parseInt(tvProcess.getText().toString()) * -1));
                            }
                        }
                    }
                }
                else if (v == btn1 | v == btn2 | v == btn3 | v == btn4 | v == btn5 | v == btn6 | v == btn7 | v == btn8 | v == btn9 | v == btn0 | v == btnPoint | v == btnDel | v == btnSign)
                {
                    if (v == btn1) {
                        tvResult.setText(tvResult.getText().toString() + 1);
                        tvProcess.setText(tvProcess.getText().toString() + 1); }
                    else if (v == btn2) {
                        tvResult.setText(tvResult.getText().toString() + 2);
                        tvProcess.setText(tvProcess.getText().toString() + 2); }
                    else if (v == btn3) {
                        tvResult.setText(tvResult.getText().toString() + 3);
                        tvProcess.setText(tvProcess.getText().toString() + 3); }
                    else if (v == btn4) {
                        tvResult.setText(tvResult.getText().toString() + 4);
                        tvProcess.setText(tvProcess.getText().toString() + 4); }
                    else if (v == btn5) {
                        tvResult.setText(tvResult.getText().toString() + 5);
                        tvProcess.setText(tvProcess.getText().toString() + 5); }
                    else if (v == btn6) {
                        tvResult.setText(tvResult.getText().toString() + 6);
                        tvProcess.setText(tvProcess.getText().toString() + 6); }
                    else if (v == btn7) {
                        tvResult.setText(tvResult.getText().toString() + 7);
                        tvProcess.setText(tvProcess.getText().toString() + 7); }
                    else if (v == btn8) {
                        tvResult.setText(tvResult.getText().toString() + 8);
                        tvProcess.setText(tvProcess.getText().toString() + 8); }
                    else if (v == btn9) {
                        tvResult.setText(tvResult.getText().toString() + 9);
                        tvProcess.setText(tvProcess.getText().toString() + 9); }
                    else if (v == btn0) {
                        tvResult.setText(tvResult.getText().toString() + 0);
                        tvProcess.setText(tvProcess.getText().toString() + 0); }
                    else if (v == btnPoint) {
                        if (tvResult.length() == 0) {
                            tvResult.setText(tvResult.getText().toString() + "0.");
                            tvProcess.setText(tvProcess.getText().toString() + "0."); }
                        else {
                            tvResult.setText(tvResult.getText().toString() + ".");
                            tvProcess.setText(tvProcess.getText().toString() + "."); }
                    }
                }
                else if (v == btnAdd | v == btnSub | v == btnMul | v == btnDiv | v==btnRemainer)
                {
                    count++;
                    result[i] = Double.valueOf(tvResult.getText().toString().trim());
                    i++;

                    if (count > 1)
                    {
                    if (where == 1) result[i] = result[(i-2)] + result[(i-1)];
                    else if (where == 2) result[i] = result[(i-2)] - result[(i-1)];
                    else if (where == 3) result[i] = result[(i-2)] * result[(i-1)];
                    else if (where == 4) result[i] = result[(i-2)] / result[(i-1)];
                    else if (where == 5) result[i] = result[(i-2)] % result[(i-1)];

                    i ++;
                    }

                    if (tvResult.length() == 0)
                        Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    else {
                        if (v == btnAdd) {
                            tvResult.setText("");
                            tvProcess.setText(tvProcess.getText().toString() + "+");
                            where = 1; }
                        else if (v == btnSub) {
                            tvResult.setText("");
                            tvProcess.setText(tvProcess.getText().toString() + "－");
                            where = 2; }
                        else if (v == btnMul) {
                            tvResult.setText("");
                            tvProcess.setText(tvProcess.getText().toString() + "×");
                            where = 3; }
                        else if (v == btnDiv) {
                            tvResult.setText("");
                            tvProcess.setText(tvProcess.getText().toString() + "÷");
                            where = 4; }
                        else if (v == btnRemainer) {
                            tvResult.setText("");
                            tvProcess.setText(tvProcess.getText().toString() + "%");
                            where = 5; }
                    }
                }
                else if(v==btnResult | v==btnRoot | v==btnSquare | v==btnReciprocal | v==btnMP | v==btnMM)
                {
                    count = 0;
                    int r = 0;
                    result[i] = Double.valueOf(tvResult.getText().toString().trim());
                    i++;

                    if (tvResult.length() == 0)
                        Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    else {
                        if (where == 1) result[i] = result[(i-2)] + result[(i-1)];
                        else if (where == 2) result[i] = result[(i-2)] - result[(i-1)];
                        else if (where == 3) result[i] = result[(i-2)] * result[(i-1)];
                        else if (where == 4) result[i] = result[(i-2)] / result[(i-1)];
                        else if (where == 5) result[i] = result[(i-2)] % result[(i-1)];


                        if (v == btnResult) {
                            tvResult.setText(Double.toString(result[i]));
                            end = 1; }
                        else if (v == btnRoot) {
                            result[i] = Math.sqrt(result[(i-1)]);
                            tvProcess.setText("√"+tvProcess.getText().toString());
                            tvResult.setText(Double.toString((double) result[i]));
                            end = 1; }
                        else if (v == btnSquare) {
                            result[i] = Math.pow(result[(i-1)], 2);
                            tvProcess.setText(tvProcess.getText().toString()+"²");
                            tvResult.setText(Double.toString(result[i]));
                            end = 1; }
                        else if (v == btnReciprocal) {
                            result[i] = 1 / Double.valueOf(result[(i-1)]);
                            tvProcess.setText("1/"+tvProcess.getText().toString());
                            tvResult.setText(Double.toString(result[i]));
                            end = 1; }
                        else if (v == btnMP || v == btnMM) {
                            if (v == btnMP) memory[j] = result[i];
                            else if (v == btnMM) memory[j] = -result[i];
                            tvResult.setText(Double.toString(memory[j]));
                            end = 1;
                            j++; }
                    }
                }
                else
                {
                    if (v == btnCE) {
                        count = 0;
                        result[i] = 0;
                        tvProcess.setText("");
                        tvResult.setText(""); }
                    else if (v == btnC) {
                        count = 0;
                        tvResult.setText("");
                        tvProcess.setText("");
                        for (int ii = 0; ii < result.length; ii++)
                            result[ii] = NULL; }
                    else if (v == btnMC) {
                        for (int ii = 0; ii < memory.length; ii++)
                            memory[ii] = 0; }
                    else if (v == btnMR) {
                        tvResult.setText(Double.toString(memory[j]));
                        end = 1;}
                }
            }
        };

        btn0.setOnClickListener(c1);
        btn1.setOnClickListener(c1);
        btn2.setOnClickListener(c1);
        btn3.setOnClickListener(c1);
        btn4.setOnClickListener(c1);
        btn5.setOnClickListener(c1);
        btn6.setOnClickListener(c1);
        btn7.setOnClickListener(c1);
        btn8.setOnClickListener(c1);
        btn9.setOnClickListener(c1);

        btnMC.setOnClickListener(c1);
        btnMR.setOnClickListener(c1);
        btnMP.setOnClickListener(c1);
        btnMM.setOnClickListener(c1);
        btnRemainer.setOnClickListener(c1);
        btnRoot.setOnClickListener(c1);
        btnSquare.setOnClickListener(c1);
        btnReciprocal.setOnClickListener(c1);

        btnCE.setOnClickListener(c1);
        btnC.setOnClickListener(c1);
        btnDel.setOnClickListener(c1);
        btnDiv.setOnClickListener(c1);
        btnMul.setOnClickListener(c1);
        btnSub.setOnClickListener(c1);
        btnAdd.setOnClickListener(c1);
        btnSign.setOnClickListener(c1);
        btnPoint.setOnClickListener(c1);
        btnResult.setOnClickListener(c1);
    }
}