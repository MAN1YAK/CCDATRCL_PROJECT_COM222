package application;

public class Node {

    // Node properties
    int data;
    double totalAmount;
    String customerName, haircut, additionalServices, date;
    Node next;

    Node(int data, String customerName, String haircut, String additionalServices, String date ,double totalAmount) {
        this.data = data;
        this.customerName = customerName;
        this.haircut = haircut;
        this.additionalServices = additionalServices;
        this.date = date;
        this.totalAmount = totalAmount;
    }
}
