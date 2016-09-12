package net.ukr.geka3;

public class Ship {
	protected String name;
	
	private Box [] boxes = new Box[10];
	
	private Port myPort = null;

	public Ship(String name , Port myPort) {
		super();
		
		this.name = name;
		//load ship by boxes
		for (int i = 0; i < boxes.length; i++) {
			boxes[i] = new Box(name + (i + 1
					));
		}
		this.myPort = myPort;
		
		this.myPort.putShipToOrder(this);
		
		
	}
	
	public Box getNextBox(){
		for (int i = 0; i < boxes.length; i++) {
			if(boxes[i] != null) {
				Box temp = boxes[i];
				boxes[i] = null;
				return temp;
			}
		}
		return null;
	}
	
	
}
