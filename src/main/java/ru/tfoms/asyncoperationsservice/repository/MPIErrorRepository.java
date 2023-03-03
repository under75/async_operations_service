package ru.tfoms.asyncoperationsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.tfoms.asyncoperationsservice.entity.CompositeKey;
import ru.tfoms.asyncoperationsservice.entity.MPIError;


public interface MPIErrorRepository extends JpaRepository<MPIError, CompositeKey> {

}
