package com.example.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText billAmount;
    private Button fifteenPercent;
    private Button eighteenPercent;
    private Button twentyPercent;
    private TextView finalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmount = findViewById(R.id.enterBillAmount);
        fifteenPercent = findViewById(R.id.fifteenPercent);
        eighteenPercent = findViewById(R.id.eighteenPercent);
        twentyPercent = findViewById(R.id.twentyPercent);
        finalAmount = findViewById(R.id.finalAmount);

        fifteenPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!billAmount.getText().toString().isEmpty()) {
                    tipCalculate(15);
                }
            }
        });

        eighteenPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!billAmount.getText().toString().isEmpty()) {
                    tipCalculate(18);
                }
            }
        });

        twentyPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!billAmount.getText().toString().isEmpty()) {
                    tipCalculate(20);
                }
            }
        });

    }

    private void tipCalculate(int percentage) {
        double bill_amount = Double.parseDouble(billAmount.getText().toString());
        double tip_amount = (bill_amount * percentage) / 100.0;
        double total_bill = bill_amount + tip_amount;
        finalAmount.setText(String.format("Tip: $%.2f, Total Bill: $%.2f", tip_amount, total_bill));

    }
}
