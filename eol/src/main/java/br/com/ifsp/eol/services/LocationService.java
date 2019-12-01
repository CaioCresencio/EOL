package br.com.ifsp.eol.services;

import br.com.ifsp.eol.model.Location;
import br.com.ifsp.eol.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location save(Location location){
        return locationRepository.save(location);
    }
}
