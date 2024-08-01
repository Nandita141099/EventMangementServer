package com.elysiana.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysiana.entities.Event;
import com.elysiana.entities.Location;
import com.elysiana.exceptions.ResourceNotFoundException;
import com.elysiana.payloads.EventDto;
import com.elysiana.payloads.LocationDto;
import com.elysiana.repository.EventRepository;
import com.elysiana.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository locationRepo;
	
	@Autowired
	EventRepository eventRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<LocationDto> getAllLocations() {

		List<Location> locations = locationRepo.findAll();
		List<LocationDto> locationDto = locations.stream().map(location -> locationToLocationDto(location))
				.collect(Collectors.toList());
		return locationDto;
	}
	@Override
    public void deleteLocationById(Integer locationId) {
      Location location = locationRepo.findById(locationId).orElseThrow(() -> new ResourceNotFoundException("Location", "Id", locationId));
       locationRepo.delete(location);
    }

	private Location locationDtoToLocation(LocationDto locationDto) {
		Location location = modelMapper.map(locationDto, Location.class);
		return location;
	}

	public LocationDto locationToLocationDto(Location location) {
		LocationDto locationDto = modelMapper.map(location, LocationDto.class);
		return locationDto;
	}
	@Override
	public void createLocation(LocationDto locationDto , Integer eventId) {
		Optional<Event> event = eventRepo.findById(eventId);
		Location location = locationDtoToLocation(locationDto);
		location.setEvent(event.get());
        locationRepo.save(location);
		
	}
	@Override
	public void updateLocationById(LocationDto locationDto,Integer locationId, Integer eventId) {
		Optional<Event> event = eventRepo.findById(eventId);
		Location location = locationRepo.findById(locationId).orElseThrow(() -> new ResourceNotFoundException("Loaction", "Id", locationId));
	        location.setLocationId(locationDto.getLocationId());
	        location.setPlace(locationDto.getPlace());
	        location.setCity(locationDto.getCity());
	        location.setState(locationDto.getState());
	        location.setPincode(locationDto.getPincode());
	        location.setEvent(event.get());
	        locationRepo.save(location);
		
		
	}
}
