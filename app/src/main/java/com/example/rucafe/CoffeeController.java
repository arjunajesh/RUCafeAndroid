package com.example.rucafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CoffeeController extends AppCompatActivity {
    DecimalFormat df = new DecimalFormat("#.##");
    Intent dataIntent;
    private static final String [] sizeList = {"Short", "Tall", "Grande", "Venti"};
    private static final String [] quantityList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};


    private Order order;
    private ArrayList<Order> orderList;

    CheckBox mocha;
    CheckBox frenchVanilla;
    CheckBox irishCream;
    CheckBox caramel;
    Spinner sizeSelect;
    Spinner quantitySelect;

    CheckBox sweetCream;



    TextView coffeeSubTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        order = (Order) getIntent().getSerializableExtra("currentOrder");
        orderList = (ArrayList<Order>) getIntent().getSerializableExtra("allOrders");

        dataIntent = new Intent();
        dataIntent.putExtra("order", order);
        dataIntent.putExtra("allOrders", orderList);
        setResult(RESULT_OK, dataIntent);


        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, sizeList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) ;
        sizeSelect = findViewById(R.id.sizeSpinner);
        sizeSelect.setAdapter(adapter);
        sizeSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                updatePrice();
            }
            public void onNothingSelected(AdapterView<?> parent)
            {}
        });

        ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, quantityList);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) ;
        quantitySelect = findViewById(R.id.amountSpinner);
        quantitySelect.setAdapter(adapter2);
        quantitySelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                updatePrice();
            }
            public void onNothingSelected(AdapterView<?> parent)
            {}
        });

        sweetCream = findViewById(R.id.sweetCream);
        frenchVanilla = findViewById(R.id.frenchVanilla);
        mocha = findViewById(R.id.mocha);
        coffeeSubTotal = findViewById(R.id.coffeeSubTotal);
        irishCream = findViewById(R.id.irishCream);
        caramel = findViewById(R.id.caramel);
        updatePrice();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void updatePriceOnClick(View view) {
        updatePrice();
    }

    /**
     * Adds the coffee order to the current Ordering Basket when the "Add to Order" button is pressed.
     */
    public void addToOrder(View view) {
        Coffee coffee = createNewCoffee();
        order.addItem(coffee);
        Toast.makeText(getApplicationContext(), "Added to Order", Toast.LENGTH_SHORT).show();
    }

    /**
     * Updates the price of the coffee order whenever an add-in is added/removed, the amount is changed, or the size is changed.
     */
    void updatePrice() {
        Coffee coffee = createNewCoffee();
        coffeeSubTotal.setText(df.format(coffee.itemPrice() * coffee.getQauntity()));
    }



    /**
     * Creates an instance of Coffee using the attributes selected on the Coffee View
     * @return an instance of Coffee
     */
    private Coffee createNewCoffee(){
        String sizeString = sizeSelect.getSelectedItem().toString();
        String amountString = quantitySelect.getSelectedItem().toString();
        ArrayList<String> addInList = createAddIns();
        int quantity = Integer.parseInt(amountString);
        Coffee c = new Coffee(sizeString, addInList, quantity, order.getItemNum());
        return c;
    }

    /**
     * Creates the list of add-ins based on the add-ins selected on the Coffee View
     * @return an ArrayList of add-ins
     */
    private ArrayList<String> createAddIns(){
        ArrayList<String> stringList = new ArrayList<>();
        if (sweetCream.isChecked())
            stringList.add("Sweet Cream");


        if (mocha.isChecked())
            stringList.add("Mocha");

        if (frenchVanilla.isChecked())
            stringList.add("French Vanilla");


        if (caramel.isChecked())
            stringList.add("Caramel");


        if (irishCream.isChecked())
            stringList.add("Irish Cream");


        return stringList;
    }

}