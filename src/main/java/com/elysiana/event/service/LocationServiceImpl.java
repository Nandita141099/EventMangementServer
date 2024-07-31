package com.elysiana.event.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elysiana.event.entities.Event;
import com.elysiana.event.entities.Location;
import com.elysiana.event.repository.LocationRepository;
import com.elysiana.payloads.EventDto;
import com.elysiana.payloads.LocationDto;


@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository locationRepo;
	
	@Autowired
    private ModelMapper modelMapper;

//	@Override
//	public void createLocation(Location location) {
//		locationRepo.save(location);
//	}
//
//	@Override
//	public void updateLocation(Location location) {
//		locationRepo.save(location);
//
//	}
//
//	@Override
//	public void deleteLocation(Integer locationId) {
//		locationRepo.deleteById(locationId);
//
//	}

	@Override
	public List<LocationDto> getAllLocation() {
		
		 List<Location> locations = locationRepo.findAll();
	        List<LocationDto> locationDto = locations.stream().map(location -> locationToLocationDto(location)).collect(Collectors.toList());
	        return locationDto;
	}
	
	private Location locationDtoToLoaction(LocationDto locationDto) {
        Location location = modelMapper.map(locationDto, Location.class);
        return location;
    }
    public LocationDto locationToLocationDto(Location location) {
        LocationDto locationDto = modelMapper.map(location, LocationDto.class);
        return locationDto;
    }
}
