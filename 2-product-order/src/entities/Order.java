package entities;

import enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date Moment;
    private OrderStatus status;

    private Client client = new Client();
    private List<OrderItem> items = new ArrayList<>();

    public Order() {

    }

    public Order(Date moment, OrderStatus status, Client client) {
        Moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return Moment;
    }

    public void setMoment(Date moment) {
        Moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        Double total = 0.0;

        for (OrderItem item: items) {
            total += item.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY: \n");
        sb.append("Order moment: ");
        sb.append(getMoment() + "\n");
        sb.append("Order status: ");
        sb.append(getStatus() + "\n");
        sb.append("Client: ");
        sb.append(getClient().getName() + getClient().getBithDate() + " - " + getClient().getEmail());
        sb.append("Order items: \n");
        for (int i = 0; i < items.size(); i++) {
            sb.append(getItems().get(i).getProduct().getName() + ", $" + getItems().get(i).getPrice() + ", Quantity: " + getItems().get(i).getQuantity() + ", Subtotal: $" + getItems().get(i).subTotal() + "\n");
        }

        return sb.toString();
    }
}
