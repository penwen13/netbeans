package AxEWTraining;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Queue;

public final class StaticMethods {

    public static void TodayOperation(
            //                                              //Simulate today's operation.

            //                                              //This simulte all daily events, they are in sequence (.Peek
            //                                              // 		is the earliest).
            //                                              //Quantity of Departures and Arrivels should be the same.
            Queue<BoatEvent> events) {
        //                                                  //Initialize accumulators
        int rides = 0;
        int cumulativeTime = 0;

        while ( //
                events.size() > 0 //
                ) {
            //                                              //To easy code
            BoatEvent eventX = events.peek();

            if ( //
                    eventX.eventType == EventType.DEPARTURE //
                    ) {
                rides++;
                cumulativeTime = cumulativeTime - eventX.timeDepartsOrArrives.toSecondOfDay();
            } //
            else {
                //                                          //It's an arrival.

                //                                          //Ride lapse time = arrival - departure
                cumulativeTime = cumulativeTime + eventX.timeDepartsOrArrives.toSecondOfDay();
            }

            //                                              //Advance to next event on queue
            events.remove();
        }

        //                                                  //Compute an display statistics
        //                                                  //To easy code
        double averageTime = (cumulativeTime / 3600) / rides;
        DecimalFormat df1 = new DecimalFormat("0.0");

        //                                                  //Show up to date statistics (a log file)
        String text = MessageFormat.format("Total Rides: {0}, Average Time: {1}hs", rides, df1.format(averageTime));

        System.out.println(text);
        System.out.println("ENTER KEY TO CONTINUE");
        //                                                  //In IDE's, "System.console()" returns null, for debugging
        //                                                  //		set a breakpoint
        String strBreakPoint = null;
    }
}
