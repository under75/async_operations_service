package ru.tfoms.asyncoperationsservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.tfoms.asyncoperationsservice.entity.AttachStart;

public interface AttachStartRepository extends JpaRepository<AttachStart, Long> {

	Collection<AttachStart> findByDtreqIsNull();

}
