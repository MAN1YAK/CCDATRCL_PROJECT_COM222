package application;

import java.util.Calendar;

public class DataSingleton {

	private static final DataSingleton instance = new DataSingleton();

	private String userName, hairCut, additional ,date;
	private Double totalCost = 0.00;
	private LinkedList linkedList;
	private Calendar calendar;

	private DataSingleton() {
		linkedList = new LinkedList();
		calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		calendar.set(Calendar.HOUR, 7);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.AM_PM, Calendar.AM );
	}

	public static DataSingleton getInstance() {
		return instance;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHairCut() {
		return hairCut;
	}

	public void setHairCut(String hairCut) {
		this.hairCut = hairCut;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public LinkedList getLinkedList() {
		return linkedList;
	}

	public Calendar getCal() {
		return calendar;
	}

	public void setCal(Calendar calendar) {
		this.calendar = calendar;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
