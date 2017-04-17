package UberFight;

public class Fare {

	public static void main(String[] args) {
		int ride_time = 15;
		int ride_distance = 9;
		double cost_per_minute [] = { 0.2, 0.34, 0.35, 0.45, 1 };
		double cost_per_mile [] = { 1.1, 1.8, 1.9, 1.7, 5 };
		fareEstimator2(ride_time,ride_distance,cost_per_minute,cost_per_mile).toString();
		
	}
	static double[] fareEstimator(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {
		double cost_per_minute_result[] = cost_per_minute;
		double cost_per_mile_result[] = cost_per_mile;
		double result[] = new double[ cost_per_minute_result.length];

		for (int i = 0; i < cost_per_minute.length; i++) {

			cost_per_minute_result[i] = cost_per_minute[i] * ride_time;
		}
		for (int i = 0; i < cost_per_mile.length; i++) {
			cost_per_mile_result[i] = cost_per_mile[i] * ride_distance;
		}
		for (int i = 0; i < cost_per_minute_result.length; i++) {
			result[i] = cost_per_minute_result[i] + cost_per_mile_result[i];
			System.out.println("Resultado: " + result[i]);
		}
		return result;
	}
	
	static double[] fareEstimator2 (int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {
	    double[] arr = new double[cost_per_mile.length];
	    for(int i = 0; i < cost_per_mile.length; i++){
	        arr[i] = cost_per_minute[i]*ride_time + cost_per_mile[i]*ride_distance;
	        System.out.println("Resultado: " + arr[i]);
	    }
	    return arr;
	}

}
