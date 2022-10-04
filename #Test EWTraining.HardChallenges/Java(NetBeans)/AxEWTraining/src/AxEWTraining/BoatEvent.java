package AxEWTraining;

import java.time.*;

public class BoatEvent {
	public final EventType eventType;
	public final LocalTime timeDepartsOrArrives;

	public BoatEvent(EventType eventType, LocalTime timeDepartsOrArrives) {
		this.eventType = eventType;
		this.timeDepartsOrArrives = timeDepartsOrArrives;
	}
}
