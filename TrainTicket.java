package jdbc;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.TreeMap;

public class TrainTicket 
{
		private int counter=100;
		private String pnr;
		private LocalDate travelDate;
		private Train train;
		private TreeMap<Passenger,Integer>Passenger;
		
		public TrainTicket(LocalDate travelDate, Train train) 
		{
			super();
			this.travelDate = travelDate;
			this.train = train;
		}
		public int getCounter() 
		{
			return counter;
		}
		public void setCount(int counter)
		{
			this.counter = counter;
		}
		public String getPnr() 
		{
			return pnr;
		}
		public void setPnr(String pnr) 
		{
			this.pnr = pnr;
		}
		public LocalDate getTravelDate()
		{
			return travelDate;
		}
		public void setTravelDate(LocalDate travelDate)
		{
			this.travelDate = travelDate;
		}
		public Train getTrain()
		{
			return train;
		}
		public void setTrain(Train train) 
		{
			this.train = train;
		}
		
	@Override
		public String toString() 
		{
			return "Ticket [count=" + counter + ", pnr=" + pnr + ", TravelDate=" + travelDate + ", train=" + train
					+ ", Passenger=" + Passenger + "]";
		}
		public String generatePNR()
		{
		String S=String.valueOf(train.getSource().charAt(0));
		String D=String.valueOf(train.getDestination().charAt(0));
		String date=travelDate.format(DateTimeFormatter.ofPattern("YYYYMMDD"));
		String pnr=S+D+"_"+date+"_"+counter++;
		
		if(travelDate.isAfter(LocalDate.now()))
		{
			return pnr;
		}
		else
		{
			return "please enter valid date";

			
		}
		}	
		double calPassengerFare(Passenger Passenger)
		{
			if(Passenger.getAge()<=12)
			{
				return 0.5*(train.getTicketPrice());
			}
			else if(Passenger.getAge()>=60)
			{
				return 0.6*(train.getTicketPrice());
			}
			else if(Passenger.getGender()=='F')
			{
				return 2.5*(train.getTicketPrice());
			}
			else
			{
				return train.getTicketPrice();
			}
		}
		public void addPassenger(String name,int age,char gender)throws NullPointerException
		{
			Passenger=new TreeMap();
			Integer fare=(int)calPassengerFare(new Passenger(name,age,gender));
			Passenger.put(new Passenger(name,age,gender), fare);	
		}
		double calculateTotalTicketPrice()
		{
			int totalPrice=0;
			Collection<Integer> price=Passenger.values();
			for(Integer values:price)
			{
				totalPrice=totalPrice+values;
			}
			return (double)totalPrice;
		}
		StringBuilder generateTicket()
		{
			StringBuilder sb=new StringBuilder();
			sb.append("PNR    :"+generatePNR()).append("travelDate  :"+travelDate).append("trainNo :"+train.getTrainNo()).append("trainName  :"+train.getTrainName()).append("Source  :"+train.getSource()).append("destination   :"+train.getDestination());
		    return sb;
		}
		public TreeMap<Passenger, Integer> getPassenger()
		{
			return Passenger;
		}

		public void setPassenger(TreeMap<Passenger, Integer> passenger)
		{
			Passenger = passenger;
		}
		public void writeTicket()
		{
			File file=new File(" ");
		}
}
