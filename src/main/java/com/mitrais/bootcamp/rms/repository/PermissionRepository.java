package com.mitrais.bootcamp.rms.repository;

import com.mitrais.bootcamp.rms.domain.Permission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {
    Optional<Permission> findByName(String name);
}
