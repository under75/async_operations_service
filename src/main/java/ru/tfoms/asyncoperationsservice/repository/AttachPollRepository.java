package ru.tfoms.asyncoperationsservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.tfoms.asyncoperationsservice.entity.AttachPoll;

public interface AttachPollRepository extends JpaRepository<AttachPoll, Long> {

	Collection<AttachPoll> findByStatusIsNullOrStatusNotIn(Collection<String> ignoredStatuses);

}
