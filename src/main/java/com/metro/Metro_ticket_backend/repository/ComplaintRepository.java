package com.metro.Metro_ticket_backend.repository;

import com.metro.Metro_ticket_backend.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
    List<Complaint> findByUser_Id(Long userId);

    List<Complaint> findByReplyIsNull();
}
