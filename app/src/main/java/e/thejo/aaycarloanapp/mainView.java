package e.thejo.aaycarloanapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class mainView extends AppCompatActivity {


    private EditText carLoan;
    private EditText downPay;
    private EditText APR;
    private SeekBar loanSeek;
    private RadioButton loanRadio;
    private TextView loanText;
    private TextView paymentTatol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        carLoan = findViewById(R.id.carCost);
        downPay = findViewById(R.id.downPay);
        APR = findViewById(R.id.APR);
        loanSeek = findViewById(R.id.loadLength);
        loanRadio = findViewById((R.id.loan));
        loanText = findViewById(R.id.loanValue);
        paymentTatol = findViewById((R.id.paymentPerMonth));

        try
        {
            loanText.setText(loanSeek.getProgress() + "");
        }
        catch (Exception e)
        {

        }

        carLoan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!loanRadio.isChecked())
                {
                    loanSeek.setProgress(36);
                    loanText.setText(36 + "");
                }
                loanText.setText(loanSeek.getProgress() + "");
                try
                {
                    carCalculation(Double.parseDouble(APR.getText().toString()) / 12, Double.parseDouble(carLoan.getText().toString()), loanSeek.getProgress());
                }
                catch (Exception e)
                {

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        downPay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!loanRadio.isChecked())
                {
                    loanSeek.setProgress(36);
                    loanText.setText(36 + "");
                }
                loanText.setText(loanSeek.getProgress() + "");
                try
                {
                    carCalculation(Double.parseDouble(APR.getText().toString()) / 12, Double.parseDouble(carLoan.getText().toString()), loanSeek.getProgress());
                }
                catch (Exception e)
                {

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        APR.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!loanRadio.isChecked())
                {
                    loanSeek.setProgress(36);
                    loanText.setText(36 + "");
                }
                loanText.setText(loanSeek.getProgress() + "");
                try
                {
                    carCalculation(Double.parseDouble(APR.getText().toString()) / 12, Double.parseDouble(carLoan.getText().toString()), loanSeek.getProgress());
                }
                catch (Exception e)
                {

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        loanRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!loanRadio.isChecked())
                {
                    loanSeek.setProgress(36);
                    loanText.setText(36 + "");
                    loanSeek.setVisibility(View.INVISIBLE);
                }
                else
                    loanSeek.setVisibility(View.VISIBLE);
                loanText.setText(loanSeek.getProgress() + "");
                try
                {
                    carCalculation(Double.parseDouble(APR.getText().toString()) / 12, Double.parseDouble(carLoan.getText().toString()), loanSeek.getProgress());
                }
                catch (Exception e)
                {

                }
            }
        });

        loanSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (!loanRadio.isChecked())
                {
                    loanSeek.setProgress(36);
                    loanText.setText(36 + "");
                }
                loanText.setText(i + "");

                try
                {
                    carCalculation(Double.parseDouble(APR.getText().toString()) / 12, Double.parseDouble(carLoan.getText().toString()), i);
                }
                catch (Exception e)
                {

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        if (savedInstanceState != null)
        {
            paymentTatol.setText(savedInstanceState.getString("Total of loan"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState)
    {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putString("Total of loan", paymentTatol.getText().toString());
    }

    private void carCalculation(double mr, double L, int n)
    {
        if (loanRadio.isChecked())
        {
            double P;
            P = ((mr / 100)*(L - Double.parseDouble(downPay.getText().toString())))/(1 - Math.pow(1+(mr / 100), -n));
            paymentTatol.setText("" + String.format("%.2f", P));
        }
        else
        {
            double P;
            P = ((mr / 100)*((L / 3) - Double.parseDouble(downPay.getText().toString())))/(1 - Math.pow(1+(mr / 100), -n));
            paymentTatol.setText("" + String.format("%.2f", P));
        }
    }
}
