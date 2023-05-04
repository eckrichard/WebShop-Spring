package com.webshop.Controller;

import com.webshop.Model.Category;
import com.webshop.Model.Status;
import com.webshop.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/status")
public class StatusController {
    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public List<Status> getStatuses() {
        return statusService.getStatuses();
    }

    @GetMapping(path = "{statusId}")
    public ResponseEntity<Status> getStatus(@PathVariable("statusId") Long statusId) {
        Status status = statusService.getStatus(statusId);
        return status != null ? ResponseEntity.ok(status) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Status> addNewStatus(@RequestBody Status status) {
        statusService.addNewStatus(status);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "{statusId}")
    public ResponseEntity<Status> deleteStatus(@PathVariable("statusId") Long statusId) {
        Status status = statusService.deleteStatus(statusId);
        return status != null ? ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @PutMapping(path = "{statusId}")
    public ResponseEntity<Status> updateStatus(
            @PathVariable("statusId") Long statusId,
            @RequestBody Status status)
    {
        Status statusFind = statusService.updateStatus(statusId, status);
        return statusFind != null ? ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
