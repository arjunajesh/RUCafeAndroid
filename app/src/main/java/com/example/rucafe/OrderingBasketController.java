package com.example.rucafe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderingBasketController extends AppCompatActivity implements AdapterView.OnItemClickListener {

    DecimalFormat df = new DecimalFormat("#.##");
    private Order order;
    private ArrayList<Order> orderList;
    private Intent dataIntent;
    private ArrayAdapter<String> adapter;

    ListView listview;

    TextView subTotal;
    TextView taxAmount;
    TextView totalPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_basket);

        order = (Order) getIntent().getSerializableExtra("currentOrder");
        orderList = (ArrayList<Order>) getIntent().getSerializableExtra("allOrders");

        dataIntent = new Intent();
        dataIntent.putExtra("order", order);
        dataIntent.putExtra("allOrders", orderList);
        setResult(RESULT_OK, dataIntent);

        subTotal = findViewById(R.id.subTotal);
        taxAmount = findViewById(R.id.taxText);
        totalPrice = findViewById(R.id.totalText);
        listview = findViewById(R.id.listview);
        setListView();
        updatePrices();


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Delete");
        alert.setMessage("Delete this Item?");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                order.getItemList().remove(i);
                setListView();
                updatePrices();
            }
        }).setNegativeButton("no", (dialog, which) -> {});
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void placeOrder(View view) {
        if (order.getItemList().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Order Cannot Be Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        orderList.add(order);
        order = new Order(order.getOrderNum() + 1);
        dataIntent.putExtra("order", order);
        setListView();
        updatePrices();
        Toast.makeText(getApplicationContext(), "Order Added", Toast.LENGTH_SHORT).show();
    }

    private void setListView() {
        String[] list = new String[order.getItemList().size()];
        for(int i = 0; i < order.getItemList().size(); i++) {
            list[i] = order.getItemList().get(i).toString();
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listview.setOnItemClickListener(this);
        listview.setAdapter(adapter);
    }

    private void updatePrices() {
        taxAmount.setText("$" + df.format(order.getTaxAmount()));
        totalPrice.setText("$" + df.format(order.getFinalPrice()));
        subTotal.setText("$" + df.format(order.getSubTotal()));
    }

}