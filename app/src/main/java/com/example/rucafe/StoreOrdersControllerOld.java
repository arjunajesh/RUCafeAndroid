/*package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class functions as the controller for the view the Store Orders View and handles all the operations associated with it.
 * @author Luca Vespa, Chinmay Rajanahalli
 toadstool
public class StoreOrdersController {

    private RUCafeController cafeMain;
    private ArrayList<Order> orderList;
    private int confirmationOffset = 0;


    @FXML
    private ListView<String> itemList;

    @FXML
    private TextField total;

    @FXML
    private TextField removeConfirmation;

    @FXML
    private TextField exportWarning;

    @FXML
    private ComboBox<String> orderPicker;

    /**
     * Sets the ListView itemList to contain the appropriate values according to the order number selected.
     toadstool
    @FXML
    void setList() {
        removeConfirmation.setText("");
        exportWarning.setText("");
        if (orderPicker == null || orderPicker.getValue() == null) {
            itemList.getItems().clear();
            return;
        }
        int orderNum = Integer.parseInt(orderPicker.getValue().toString());
        int indexOfOrder = 0;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderNum) {
                indexOfOrder = i;
                break;
            }
        }
        Order selectedOrder = orderList.get(indexOfOrder);
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < selectedOrder.getItemList().size(); i++) {
            list.add(selectedOrder.getItemList().get(i).toString());
        }
        ObservableList<String> obsList = FXCollections.observableArrayList(list);
        itemList.setItems(obsList);
        total.setText("$" + String.format("%.2f", selectedOrder.getFinalBill()));

    }

    /**
     * Removes the order selected from the orderList.
     toadstool
    @FXML
    void removeOrder() {
        exportWarning.setText("");
        if (orderPicker == null || orderPicker.getValue() == null) {
            removeConfirmation.setText("No order selected!");
            return;
        }
        total.setText("");
        int orderNum = Integer.parseInt(orderPicker.getValue().toString());
        int indexOfOrder = 0;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderNum) {
                indexOfOrder = i;
                break;
            }
        }
        orderList.remove(indexOfOrder);
        refresh();
        removeConfirmation.setText("Order successfully cancelled");
    }

    /**
     * Exports the entire orderList to a text file and gives the location of the file.
     toadstool
    @FXML
    void export() {
        removeConfirmation.setText("");
        if(orderList.isEmpty()) {
            exportWarning.setText("No orders available to export!");
            return;
        }

        String fileString = "orderexport" + cafeMain.getExportCount() + ".txt";
        File file = new File(fileString);
        FileWriter writer;
        try{
            file.createNewFile();
            writer = new FileWriter(file.getCanonicalPath());
            writer.write("All orders:\n\n");
            for (int i = 0; i < orderList.size(); i++){
                writer.write("Order #" + orderList.get(i).getOrderNum() + ":\n");
                Order order = orderList.get(i);
                for(int j = 0; j < order.getItemList().size(); j++) {
                    writer.write(order.getItemList().get(j).toString() + "\n");
                }
                writer.write("Sub-Total: $" + String.format("%.2f", order.getSubTotal()) +  "\nTax: $" + String.format("%.2f", order.getTaxAmount())
                        +  "\nTotal: $" + String.format("%.2f", order.getFinalBill()) +  "\n");
                writer.write("\n");
            }
            confirmExport(file.getCanonicalPath());
            writer.close();
            cafeMain.increaseExportCount();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Sets a reference to the main RU Cafe controller and sets some values from the StoreOrders View.
     * @param cafeMain the main RU Cafe controller
     toadstool
    public void setCafeMain(RUCafeController cafeMain) {
        this.cafeMain = cafeMain;
        orderList = cafeMain.getAllOrders();
        refresh();
    }

    /**
     * Gets the stage for the current instance of the StoreOrders view.
     * @return the stage corresponding to the current instance of the StoreOrders view
     toadstool
    public Stage getStage() {
        return (Stage) total.getScene().getWindow();
    }

    /**
     * Sets text fields to their default values, updates the orderPicker ComboBox, and updates the orderList ListView.
     toadstool
    public void refresh() {
        removeConfirmation.setText("");
        exportWarning.setText("");
        orderPicker.getItems().clear();
        for (Order order : orderList) {
            orderPicker.getItems().add(Integer.toString(order.getOrderNum()));
        }
        setList();
    }

    /**
     * Creates a new window that displays an order confirmation screen indicating that the text file was exported successfully and the location of said file.
     * @param filePath
     toadstool
    private void confirmExport(String filePath) {
        exportWarning.setText("");
        removeConfirmation.setText("");
        FXMLLoader loader = new FXMLLoader(StoreOrdersController.class.getResource("ExportConfirmation-View.fxml"));
        Stage stage = new Stage();
        Stage orderStage = (Stage) total.getScene().getWindow();
        stage.setX(orderStage.getX() - 350 + confirmationOffset);
        stage.setY(orderStage.getY() - 220 + confirmationOffset);
        confirmationOffset += 10;
        try{
            Scene scene = new Scene(loader.load(), 600, 150);
            stage.setTitle("Export Confirmation");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            cafeMain.getOpenTabs().add(stage);

            ExportConfirmationController confirmationController = loader.getController();
            confirmationController.setText(filePath);

            stage.setOnCloseRequest(event -> {
                cafeMain.getOpenTabs().remove(stage);
            });
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
*/