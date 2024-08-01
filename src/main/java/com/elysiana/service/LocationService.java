package com.elysiana.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elysiana.entities.Event;
import com.elysiana.entities.Location;
import com.elysiana.payloads.LocationDto;

@Service
public interface LocationService {
void createLocation(LocationDto locationDto , Integer eventId);
void updateLocationById(LocationDto locationDto, Integer locationId,Integer eventId);
 void deleteLocationById(Integer locationId);
	List<LocationDto> getAllLocations();
}
