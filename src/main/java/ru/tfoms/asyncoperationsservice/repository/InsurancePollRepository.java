package ru.tfoms.asyncoperationsservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.tfoms.asyncoperationsservice.entity.InsurancePoll;

public interface InsurancePollRepository extends JpaRepository<InsurancePoll, Long> {

	Collection<InsurancePoll> findByStatusIsNullOrStatusNotIn(Collection<String> ignoredStatuses);

}
