package application;

public class LinkedList
{
	// Represent the head and tail of the singly linked list
	public Node head = null;
	public Node tail = null;

	public void insertAtEnd(Node node, int data, String name, String haircut, String additional, String date,
			double totalAmount) {
		Node newNode = new Node(data, name, haircut, additional, date, totalAmount);
		// if linked list is empty initialize the head of the node with the key of 0
		if (head == null) {
			head = new Node(0, name, haircut, additional, date, totalAmount);
			return;
		}
		newNode.next = null;

		Node last = head;
		while (last.next != null) {
			last = last.next;
		}

		last.next = newNode;
		return;
	}

	// display() will display all the nodes present in the list
	public String display() {
		StringBuilder result = new StringBuilder();
		// Node current will point to head
		Node current = head;

		if (head == null) {
			System.out.println("List is empty");
			return "List is empty";
		}
		// skip past node 0
		current = current.next;

		while (current != null) {
			// Appends each node and data by incrementing pointer
			result.append(String.format(" %03d", current.data)).append(" | " + current.customerName)
					.append(" | " + current.date).append("\n\n");
			current = current.next;
		}

		return result.toString();
	}

	void delete(Node node, int position) {
		if (node == null)
			return;

		Node temp = node;

		if (position == 0) {
			node = temp.next;
			return;
		}
		// Find the key to be deleted
		for (int i = 0; temp != null && i < position - 1; i++)
			temp = temp.next;

		// If the key is not present
		if (temp == null || temp.next == null)
			return;

		// Remove the node
		Node next = temp.next.next;

		temp.next = next;
	}

	int countNodes(Node node) {

		// count initialized at 0 because the head node is hidden
		int count = 0;
		Node current = head;

		if (head == null) {
			return 0;
		}

		while (current.next != null) {
			current = current.next;
			count += 1;
		}

		return count;
	}

	public boolean updateDelete(Node node, int number) {
		// if number found in update value delete number
		if (updateValues(node, number) == 0) {
			return false;
		} else {
			delete(node, number);
			return true;
		}
	}

	public int updateValues(Node node, int number) {
		int verify = 0;

		Node current = head;

		while (current != null) {
			// check if the number to be deleted exists
			if (number == current.data) {
				verify++;
			}
			// decrement all the value greater than the number to be found
			if (number <= current.data) {
				current.data--;
			}
			current = current.next;
		}
		return verify;
	}

	public Node search(Node head, int x) {
		// Base case
		if (head == null)
			return null;

		// If key is present in current node,
		// return true
		if (head.data == x)
			return head;

		// Recur for remaining list
		return search(head.next, x);
	}

	public void clearLList() {

		head = null;

		// puts a hidden head so that the next insert node will appear
		insertAtEnd(head, 0, null, null, null, null, 0.00);

	}

	String SearchName(int number) {
		Node searchData = search(head, number);
		// if data exist get data else return "None"
		return (searchData != null) ? searchData.customerName : "None";
	}

	String SearchHaircut(int number) {
		Node searchData = search(head, number);
		return (searchData != null) ? searchData.haircut : "None";
	}

	String SearchAdditional(int number) {
		Node searchData = search(head, number);
		return (searchData != null) ? searchData.additionalServices : "None";
	}

	Double SearchTotalCost(int number) {
		Node searchData = search(head, number);
		return (searchData != null) ? searchData.totalAmount : 0.00;
	}

}

