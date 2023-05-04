package sg.edu.rp.c346.id22020995.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    //TextView Variables
    TextView tvAmount;
    TextView tvPax;
    TextView tvDiscount;
    TextView tvTotalBill;
    TextView tvSplitCost;

    //EditText Variables
    EditText etBillInput;
    EditText etPaxInput;
    EditText etDiscountInput;

    //Toggle Button Variables
    ToggleButton tbSVS;
    ToggleButton tbGST;

    //Radio Group Variable
    RadioGroup rgPayment;

    //Button Variables
    Button btnSplit;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView
        tvAmount = findViewById(R.id.textViewAmount);
        tvDiscount = findViewById(R.id.textViewDiscount);
        tvSplitCost = findViewById(R.id.textViewSplitCost);
        tvPax = findViewById(R.id.textViewPax);
        tvTotalBill = findViewById(R.id.textViewTotalBill);
        //EditText
        etBillInput = findViewById(R.id.billInput);
        etDiscountInput = findViewById(R.id.discountInput);
        etPaxInput = findViewById(R.id.paxInput);
        //Toggle Buttons
        tbGST = findViewById(R.id.toggleButtonGST);
        tbSVS = findViewById(R.id.toggleButtonSVS);
        //RadioGroup
        rgPayment = findViewById(R.id.radioGroupPayment);
        //Buttons
        btnReset = findViewById(R.id.buttonReset);
        btnSplit = findViewById(R.id.buttonSplit);

        btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Take bill input and display total bill
                String billInput = etBillInput.getText().toString();
                int Bill = Integer.valueOf(billInput);
                boolean SVSisChecked = tbSVS.isChecked();
                boolean GSTisChecked = tbGST.isChecked();
                String discountInput = etDiscountInput.getText().toString();
                int Discount = Integer.valueOf(discountInput);
                String paxInput = etPaxInput.getText().toString();
                int Pax = Integer.valueOf(paxInput);
                int paymentRadioId =rgPayment.getCheckedRadioButtonId();

                // Calculate bill with discount
                double DiscountedBill = Bill*((100-Discount)/100.0);


                if (SVSisChecked){
                    // If SVS is checked, multiply bill by 1.1 for billWithSVS
                    double bill = DiscountedBill*(1.1);

                    if (GSTisChecked) {
                        // If GST is checked, multiply bill by 1.08
                        double totalBill = bill * (1.08);
                        double costPerPax = totalBill/Pax;
                        tvTotalBill.setText(String.format("Total Bill: $%.2f",totalBill));

                        if (paymentRadioId == R.id.radioButtonCash){
                            // If Cash payment selected, include "in cash"
                            tvSplitCost.setText(String.format("Each Pays: $%.2f in cash",costPerPax));
                        } else {
                            // If Cash payment selected, include "via paynow to 912345678"
                            tvSplitCost.setText(String.format("Each Pays: $%.2f in via PayNow to 912345678",costPerPax));
                        }

                    } else {
                        // If GST is not checked, no need add GST
                        double totalBill = bill;
                        double costPerPax = totalBill / Pax;
                        tvTotalBill.setText(String.format("Total Bill: %.2f", totalBill));

                        if (paymentRadioId == R.id.radioButtonCash) {
                            // If Cash payment selected, include "in cash"
                            tvSplitCost.setText(String.format("Each Pays: $%.2f in cash", costPerPax));
                        } else {
                            // If Cash payment selected, include "via paynow to 912345678"
                            tvSplitCost.setText(String.format("Each Pays: $%.2f in via PayNow to 912345678", costPerPax));
                        }
                    }

                } else {
                    //If SVS is not checked, no need add SVS
                    if (GSTisChecked) {
                        // If GST is checked, multiply bill by 1.08
                        double totalBill = DiscountedBill * (1.08);
                        double costPerPax = totalBill/Pax;
                        tvTotalBill.setText(String.format("Total Bill: $%.2f",totalBill));

                        if (paymentRadioId == R.id.radioButtonCash){
                            // If Cash payment selected, include "in cash"
                            tvSplitCost.setText(String.format("Each Pays: $%.2f in cash",costPerPax));
                        } else {
                            // If Cash payment selected, include "via paynow to 912345678"
                            tvSplitCost.setText(String.format("Each Pays: $%.2f in via PayNow to 912345678",costPerPax));
                        }

                    } else {
                        // If GST is not checked, no need add GST
                        double totalBill = DiscountedBill;
                        double costPerPax = totalBill/Pax;
                        tvTotalBill.setText(String.format("Total Bill: %.2f",totalBill));

                        if (paymentRadioId == R.id.radioButtonCash){
                            // If Cash payment selected, include "in cash"
                            tvSplitCost.setText(String.format("Each Pays: $%.2f in cash",costPerPax));
                        } else {
                            // If Cash payment selected, include "via paynow to 912345678"
                            tvSplitCost.setText(String.format("Each Pays: $%.2f in via PayNow to 912345678",costPerPax));
                        }
                }

                }
                // Take pax input and display split bill


            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set bill, pax and discount input to 0
                etBillInput.setText("");
                etPaxInput.setText("");
                etDiscountInput.setText("");
                // Set toggle buttons back to default
                tbGST.setChecked(false);
                tbSVS.setChecked(false);
                // Reset payment radio button to cash default
                rgPayment.check(R.id.radioButtonCash);
                // Reset total bill and split cost displays
                tvTotalBill.setText("Total Bill:");
                tvSplitCost.setText("Each Pays:");
            }
        });
    }
}