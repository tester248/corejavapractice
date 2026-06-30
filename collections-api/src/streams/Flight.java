package streams;

public class Flight {
	private int flightNo;
	private String carrier;
	private String from;
	private String to;
	
	public Flight(int flightNo, String carrier, String from, String to) {
		this.flightNo = flightNo;
		this.carrier = carrier;
		this.from = from;
		this.to = to;
	}
	
	public int getFlightNo() { return flightNo; }
	public String getCarrier() { return carrier; }
	public String getFrom() { return from; }
	public String getTo() { return to; }
	
	@Override
	public String toString() {
		return "Flight{no=" + flightNo + ", carrier='" + carrier + "', from='" + from + "', to='" + to + "'}";
	}
}