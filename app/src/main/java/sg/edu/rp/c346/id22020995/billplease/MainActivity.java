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
                tvTotalBill.setText("Total Bill: "+Bill);
                // Take pax input and display split bill
                String paxInput = etPaxInput.getText().toString();
                int Pax = Integer.valueOf(paxInput);
                int costPerPax = Bill/Pax;
                tvSplitCost.setText(String.format("Each Pays: %.2f",costPerPax));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set bill, pax and discount input to 0
                etBillInput.setText(0);
                etPaxInput.setText(0);
                etDiscountInput.setText(0);
                // Set toggle buttons back to default
                tbGST.setChecked(true);
                tbSVS.setChecked(true);
                // Reset payment radio button
                rgPayment.setActivated(false);
            }
        });
    }
}