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
    TextView tvEachPays;

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
        tvEachPays = findViewById(R.id.textViewEachPays);
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
    }
}