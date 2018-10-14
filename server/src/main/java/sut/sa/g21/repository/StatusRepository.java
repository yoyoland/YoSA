package sut.sa.g21.repository;

import sut.sa.g21.entity.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
    public
    interface StatusRepository extends JpaRepository<Status, Long> {
        Status findByStatusId(long statusId);
}