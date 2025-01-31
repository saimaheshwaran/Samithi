package org.sai.samithi.services;

import lombok.NoArgsConstructor;
import org.sai.samithi.entities.Visitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.sai.samithi.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service @NoArgsConstructor
public class VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    public Page<Visitor> visitorPageRequest(int page, int pageSize) {
        return visitorRepository.findAll(
                PageRequest.of( page, pageSize,
                        Sort.by(Sort.Direction.DESC, "visitTime")));
    }

    public List<Visitor> getAll() {
        return visitorRepository.getAllByLatestDate();
    }
}
