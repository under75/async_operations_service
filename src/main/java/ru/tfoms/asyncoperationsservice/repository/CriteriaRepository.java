package ru.tfoms.asyncoperationsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.tfoms.asyncoperationsservice.entity.Criteria;
import ru.tfoms.asyncoperationsservice.entity.CompositeKey;

public interface CriteriaRepository extends JpaRepository<Criteria, CompositeKey> {

}
