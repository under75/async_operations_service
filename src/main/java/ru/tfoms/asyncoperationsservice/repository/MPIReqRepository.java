package ru.tfoms.asyncoperationsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.tfoms.asyncoperationsservice.entity.MPIReq;
import ru.tfoms.asyncoperationsservice.entity.MPIReqId;


public interface MPIReqRepository extends JpaRepository<MPIReq, MPIReqId> {
	
	MPIReq getByExtrid(String extRid);
}
