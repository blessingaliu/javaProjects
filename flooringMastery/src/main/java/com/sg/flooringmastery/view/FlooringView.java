package com.sg.flooringmastery.view;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FlooringView {

    private UserIO io;

    public FlooringView(UserIO io) {
        this.io = io;
    }

    public int displayMenuAndGetChoice() {
        io.print("MAIN MENU");
        io.print("1. Display Orders");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Export All Data");
        io.print("6. Exit");

        int userInput = io.readInt("Select an option", 1, 6);
        return userInput;
    }

    public void displayInvalidCommandMsg() {
        io.print("Unknown Command!");
    }

    public void displayExitMsg() {
        io.print("Goodbye!");
    }

    public void displayErrorMsg(String errorMsg) {
        io.print(errorMsg);
    }

    public void displayExportMsg() {
        io.print("All orders have been successfully exported to Backup directory.");
        io.readString("Press enter to continue..");
    }

    public void displayBanner(String action) {
        io.print(action.toUpperCase());
    }

    public void displayAllOrders(List<Order> allOrders) {
        if (allOrders == null) {
            io.print("");
            io.print("No Orders Found");
            io.print("");
        } else {
            for (Order order : allOrders) {

                io.print(" Order #: " + order.getOrderNumber());
                io.print(" Date: " + order.getOrderDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
                io.print(" Name: " + order.getCustomerName());
                io.print(" State: " + order.getTax().getStateAbbreviation());
                io.print(" Tax Rate: " + order.getTax().getTaxRate().setScale(2, RoundingMode.HALF_UP) + "%");
                io.print(" Area: " + order.getArea().setScale(2, RoundingMode.HALF_UP) + " sqft");
                io.print(" Product Type: " + order.getProduct().getProductName());
                io.print(" Cost /SqFt: $" + order.getProduct().getCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP));
                io.print(" Labor Cost /SqFt: $" + order.getProduct().getLaborCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP));
                io.print(" Total Material Cost: $" + order.getMaterialCost().setScale(2, RoundingMode.HALF_UP));
                io.print(" Total Labor Cost: $" + order.getLaborCost().setScale(2, RoundingMode.HALF_UP));
                io.print(" Total Tax: $" + order.getTotalTax().setScale(2, RoundingMode.HALF_UP));
                io.print(" Grand Total: $" + order.getTotal().setScale(2, RoundingMode.HALF_UP));

            }
        }
        io.readString("Press ENTER to continue");

    }

    public LocalDate getDate() {
        return io.readLocalDate("Enter date: ");
    }

    public int getOrderNumber() {
        return io.readInt("Enter order number", 1, Integer.MAX_VALUE);
    }

    public Order getNewOrderInfo(List<Product> allProducts, List<Tax> allStates) {
        LocalDate date;
        String name;
        String state;
        String productType;
        BigDecimal areaMax = BigDecimal.valueOf(Double.MAX_VALUE);
        BigDecimal areaMin = new BigDecimal("100").setScale(2, RoundingMode.HALF_UP);
        BigDecimal area;
        Tax orderTax = new Tax();
        Product orderProduct = new Product();
        Order newOrder = new Order();

        date = io.readLocalDate("Enter Date: ", LocalDate.now(), LocalDate.MAX);
        name = io.mustReadString("Enter Name: ");
        state = io.mustReadString("Enter your State: (TI/WA/KY/CA/OH)");
        productType = io.mustReadString("Enter name of product (Carpet, Laminate, Tile, Wood): ");
        area = io.readBigDecimal("Enter area (SqFt): ", areaMin, areaMax);

        orderTax.setStateAbbrevation(state);
        orderProduct.setProductName(productType);
        newOrder.setOrderDate(date);
        newOrder.setCustomerName(name);
        newOrder.setTax(orderTax);
        newOrder.setProduct(orderProduct);
        newOrder.setArea(area);

        return newOrder;
    }

    public void displayOrder(Order order) {
        if (order != null) {

            io.print(" You have ordered: ");
            io.print(" Order #: " + order.getOrderNumber());
            io.print(" Date: " + order.getOrderDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
            io.print(" Name: " + order.getCustomerName());
            io.print(" State: " + order.getTax().getStateAbbreviation());
            io.print(" Tax Rate: " + order.getTax().getTaxRate().setScale(2, RoundingMode.HALF_UP) + "%");
            io.print(" Area: " + order.getArea().setScale(2, RoundingMode.HALF_UP) + " sqft");
            io.print(" Product Type: " + order.getProduct().getProductName());
            io.print(" Cost /SqFt: $" + order.getProduct().getCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP));
            io.print(" Labor Cost /SqFt: $" + order.getProduct().getLaborCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP));
            io.print(" Total Material Cost: $" + order.getMaterialCost().setScale(2, RoundingMode.HALF_UP));
            io.print(" Total Labor Cost: $" + order.getLaborCost().setScale(2, RoundingMode.HALF_UP));
            io.print(" Total Tax: $" + order.getTotalTax().setScale(2, RoundingMode.HALF_UP));
            io.print(" Grand Total: $" + order.getTotal().setScale(2, RoundingMode.HALF_UP));
        }
    }

    public boolean confirmChanges(String action, Order order) {
        return io.readBoolean("Are you sure you would like to continue?");
    }

    public void displaySuccessMsg(String action, Order order) {
        io.print("Order # " + order.getOrderNumber() + " has been " + action + "ed..\n");
        io.readString("Press enter to return to Main Menu..");
    }

    public void displayNoChangesMadeMsg() {
        io.print("No changes have been made. \n");
        io.readString("Press enter to return to Main Menu..");
    }

    public Order getEditOrderInfo(Order order, List<Product> allProducts, List<Tax> allTaxes) {
        String name;
        String state;
        String productType;
        String area;
        BigDecimal areaAsBd = new BigDecimal("0");
        Tax orderTax = new Tax();
        Product orderProduct = new Product();
        Order newOrder = new Order();

        if (order != null) {
            io.print("If you do not want to change a field, leave BLANK");
            io.readString("Press enter to continue");
        }

        io.print("");
        name = io.readString("Enter Name(" + order.getCustomerName() + "):");

        io.print("");
        state = io.readString("Enter your State(TI/WA/KY/CA/OH)(" + order.getTax().getStateAbbreviation() + "):");

        io.print("");
        productType = io.readString("Enter name of product(Carpet, Laminate, Tile, Wood)(" + order.getProduct().getProductName() + "):");

        if (state.isEmpty()) {
            state = order.getTax().getStateAbbreviation();
        }
        if (productType.isEmpty()) {
            productType = order.getProduct().getProductName();
        }
        if (name.isEmpty()) {
            name = order.getCustomerName();
        }
        boolean keepGoing = true;
        while (keepGoing) {
            try {
                area = io.readString("Enter area in SqFt(" + order.getArea() + "):");
                if (area.isEmpty()) {
                    areaAsBd = order.getArea().setScale(2, RoundingMode.HALF_UP);
                    keepGoing = false;
                } else {
                    areaAsBd = new BigDecimal(area).setScale(2, RoundingMode.HALF_UP);
                    keepGoing = false;
                }
            } catch (NumberFormatException e) {
                io.print("Invalid input. Area input has to be a number");
            }
        }

        newOrder.setOrderDate(order.getOrderDate());
        orderTax.setStateAbbrevation(state);
        orderProduct.setProductName(productType);
        newOrder.setCustomerName(name);
        newOrder.setTax(orderTax);
        newOrder.setProduct(orderProduct);
        newOrder.setArea(areaAsBd);
        newOrder.setOrderNumber(order.getOrderNumber());
        return newOrder;
    }

}
