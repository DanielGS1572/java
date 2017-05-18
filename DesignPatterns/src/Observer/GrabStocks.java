package Observer;

// Se usa cuando se quiere afectar a un objeto cuando otro cambia (teniendo muchos objetos)
// la desventaja es que cada que el objeto cambia el observer recibe el cambio cuando no le pudiera interesar
// se divide en subject y observer (el observer es la interfaz). el subject tiene 3 metodos [register, unregister, notifyObserver]. El observer es una interfaz

public class GrabStocks {

	public static void main(String[] args) {

		// Create the Subject object
		// It will handle updating all observers
		// as well as deleting and adding them

		StockGrabber stockGrabber = new StockGrabber();

		// Create an Observer that will be sent updates from Subject

		StockObserver observer1 = new StockObserver(stockGrabber);

		stockGrabber.setIBMPrice(197.00);
		stockGrabber.setAAPLPrice(677.60);
		stockGrabber.setGOOGPrice(676.40);

		StockObserver observer2 = new StockObserver(stockGrabber);

		stockGrabber.setIBMPrice(19733.00);
		stockGrabber.setAAPLPrice(67733.60);
		stockGrabber.setGOOGPrice(67633.40);

		// Delete one of the observers

		// stockGrabber.unregister(observer2);
/*
		stockGrabber.setIBMPrice(197.00);
		stockGrabber.setAAPLPrice(677.60);
		stockGrabber.setGOOGPrice(676.40);

		// Create 3 threads using the Runnable interface
		// GetTheStock implements Runnable, so it doesn't waste
		// its one extendable class option

		Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
		Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 677.60);
		Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 676.40);

		// Call for the code in run to execute

		new Thread(getIBM).start();
		new Thread(getAAPL).start();
		new Thread(getGOOG).start();
*/
	}

}