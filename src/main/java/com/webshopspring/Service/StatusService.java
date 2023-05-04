package com.webshop.Service;

import com.webshop.Model.Category;
import com.webshop.Model.Status;
import com.webshop.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getStatuses(){
        return statusRepository.findAll();
    }

    public Status getStatus(Long statusId) {
        Optional<Status> statusOptional = statusRepository.findById(statusId);
        if (!statusOptional.isPresent()){
            return null;
        }
        return statusOptional.get();
    }

    public void addNewStatus(Status status) {
        Optional<Status> statusOptional = statusRepository.findStatusByName(status.getName());
        if (statusOptional.isPresent()){
            throw new IllegalStateException("it's already exist");
        }
        statusRepository.save(status);
    }

    public Status deleteStatus(Long id) {
        Status status = this.getStatus(id);
        if (status != null){
            statusRepository.deleteById(id);
            return status;
        }
        else {
            return null;
        }
    }

    public Status updateStatus(Long statusId, Status status) {
        Status statusFind = getStatus(statusId);
        if(statusFind != null){
            statusFind.setName(status.getName());

            statusRepository.save(statusFind);
            return status;
        }
        return null;
    }
}
