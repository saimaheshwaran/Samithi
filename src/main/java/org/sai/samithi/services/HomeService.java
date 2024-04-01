package org.sai.samithi.services;

import lombok.NoArgsConstructor;
import org.sai.samithi.entities.Home;
import org.sai.samithi.repositories.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @NoArgsConstructor
public class HomeService {

    @Autowired
    HomeRepository homeRepository;

    public Home add(Home home) {
        return homeRepository.save(home);
    }

    public String get(String key) {
        return homeRepository.getValue(key);
    }

}
