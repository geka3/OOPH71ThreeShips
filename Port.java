package net.ukr.geka3;

public class Port {
	private Dock[] dockes = null;
	Box[] boxes = new Box[0];
	
	// order ships to port before upload, ships is in order
	private Ship[] order = new Ship[1];
	
	/**
	 * @return the boxes
	 */
	public Box[] getBoxes() {
		return boxes;
	}

	/**
	 * @return the order
	 */
	public Ship[] getOrder() {
		return order;
	}

	public Port(int numOfDocks) {
		super();
		dockes = new Dock[numOfDocks];
		for (int i = 0; i < dockes.length; i++) {
			dockes[i] = new Dock(this,i + 1);
		}

	}

	public synchronized static Ship[] addOneIndexToArray(Ship[] array) {
		Ship[] newArray = new Ship[array.length + 1];
		System.arraycopy(array, 0, newArray, 0, array.length);

		return newArray;
	}

	public synchronized static Box[] addOneIndexToArray(Box[] array) {
		Box[] newArray = new Box[array.length + 1];
		System.arraycopy(array, 0, newArray, 0, array.length);

		return newArray;
	}

	public synchronized void putShipToOrder(Ship ship) {
		for (int i = 0; i < order.length; i++) {
			if (order[i] == null) {
				order[i] = ship;
				System.out.println("* " + ship.name + " was added to index " + i );
				return;
			} 

		}
		order = addOneIndexToArray(order);
		order[order.length - 1] = ship; // if after add last in index length will be 6 that last index will be 5 because numeration is from 0
		System.out.println("* " + ship.name + " was added to indes " + (order.length - 1) );

	}

	public synchronized Ship getShipFromOrder() {
		for (int i = 0; i < order.length; i++) {
			if (order[i] != null) {
				Ship temp = order[i];
				order[i] = null;
				return temp;

			}
		}
		return null;
	}

	public synchronized void putBox(Box box) {
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == null) {
				boxes[i] = box;
				return;
			}
		}
		boxes = addOneIndexToArray(boxes);
		boxes[boxes.length - 1] = box;
		
	}

}
