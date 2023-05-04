package com.webshop.Repository;

import com.webshop.Model.Category;
import com.webshop.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    @Query("SELECT s FROM Status s where s.name = ?1")
    Optional<Status> findStatusByName(String name);
}
