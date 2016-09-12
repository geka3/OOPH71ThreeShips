package net.ukr.geka3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create Port with 2 Dock
		Port port = new Port(2);

		// create three Ship that arrived to port
		Ship shipOne = new Ship("Titanic", port);
		Ship shipTwo = new Ship("Britanic", port);
		Ship shipThree = new Ship("Dnepr", port);

		for (;;) {

			Ship[] temp = port.getOrder();
			for (int i = 0; i < temp.length; i++) {
				if (temp[i] != null) {
					System.out.println("* Ship " + temp[i].name + " is waiting for upload");
				}

			}

			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
