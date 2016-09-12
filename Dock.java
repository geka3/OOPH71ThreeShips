package net.ukr.geka3;

public class Dock implements Runnable {
	int num = 0; // num of dock
	Port myPort = null;
	Ship myCurrentShip = null;
	Thread th = null;

	public Dock(Port myPort, int num) {
		super();
		this.myPort = myPort;
		this.num = num;
		th = new Thread(this);
		th.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (;;) {

			// check have i ship or not
			if (myCurrentShip == null) {
				if ((myCurrentShip = myPort.getShipFromOrder()) == null) {
					try {
						th.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Dock " + num + " is waiting for ship");
					continue;
				}

			}else{
				
				//here i have Ship
				
				Box temp = myCurrentShip.getNextBox();
				//if box was ended
				if (temp == null){
					myCurrentShip = null;
					continue;
				}
				System.out.println("<- dock " + num + " Box " + temp.name + " got from " + myCurrentShip.name );
				myPort.putBox(temp);
				
				System.out.println("-> dock " + num + " Box " + temp.name + " put to port");
				try {
					th.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			

		}
	}

}
