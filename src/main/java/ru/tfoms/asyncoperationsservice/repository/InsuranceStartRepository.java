package ru.tfoms.asyncoperationsservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.tfoms.asyncoperationsservice.entity.InsuranceStart;

public interface InsuranceStartRepository extends JpaRepository<InsuranceStart, Long> {

	Collection<InsuranceStart> findByDtreqIsNull();

}
