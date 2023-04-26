/*package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;


/**
 * This class functions as the controller for the view the Ordering Basket View and handles all the operations associated with it.
 * @author Luca Vespa, Chinmay Rajanahalli
 toadstool
public class OrderingBasketController {

    private RUCafeController cafeMain;
    Order order;


    @FXML
    private ListView<String> itemList;

    @FXML
    private TextField subTotal;

    @FXML
    private TextField tax;

    @FXML
    private TextField total;

    @FXML
    private TextField addConfirmation;

    @FXML
    private TextField removeConfirmation;

    /**
     * Refreshes all TextFields to their default values and sets the itemList ListView to its appropriate values.
     toadstool
    @FXML
    void refresh() {
        addConfirmation.setText("");
        removeConfirmation.setText("");
        order = cafeMain.getCurrentOrder();
        setList();
    }

    /**
     * Removes an item from the order and calls a refresh of the view.
     toadstool
    @FXML
    void removeItem() {
        int index = itemList.getSelectionModel().getSelectedIndex();
        if (index >= 0 && index < order.getItemList().size()) {
            order.getItemList().remove(index);
            refresh();
            removeConfirmation.setText("Item Successfully Removed");
            return;
        }
        removeConfirmation.setText("No item selected!");
    }

    /**
     * Finalizes the order and adds it to the Store's Orders.
     toadstool
    @FXML
    void addOrder() {
        if (order.getItemList().isEmpty()) {
            addConfirmation.setText("Order cannot be empty!");
            return;
        }
        cafeMain.getAllOrders().add(order);
        cafeMain.createNewOrder();
        if (cafeMain.getStoreOrdersIsOpen()) {
            cafeMain.getOpenedStoreOrders().refresh();
        }
        refresh();
        addConfirmation.setText("Order Successfully Added");
    }

    /**
     * Sets a reference to the main RU Cafe controller and sets some values from the OrderingBasket View.
     * @param cafeMain the main RU Cafe controller
     toadstool
    public void setCafeMain(RUCafeController cafeMain) {
        this.cafeMain = cafeMain;
        order = cafeMain.getCurrentOrder();
        setList();
    }

    /**
     * Gets the stage for the current instance of the OrderingBasket view.
     * @return the stage corresponding to the current instance of the OrderingBasket view
     toadstool
    public Stage getStage() {
        return (Stage) total.getScene().getWindow();
    }

    /**
     * Sets the itemList ListView to represent the appropriate values and accordingly updates costs.
     toadstool
    private void setList() {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < order.getItemList().size(); i++) {
            list.add(order.getItemList().get(i).toString());
        }
        ObservableList<String> obsList = FXCollections.observableArrayList(list);
        itemList.setItems(obsList);
        subTotal.setText("$" + String.format("%.2f", order.getSubTotal()));
        tax.setText("$" + String.format("%.2f", order.getTaxAmount()));
        total.setText("$" + String.format("%.2f", order.getFinalBill()));

    }

}
*/