package ru.tfoms.asyncoperationsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.tfoms.asyncoperationsservice.entity.CompositeKey;
import ru.tfoms.asyncoperationsservice.entity.InsuranceContent;

public interface InsuranceContentRepository extends JpaRepository<InsuranceContent, CompositeKey> {

}
