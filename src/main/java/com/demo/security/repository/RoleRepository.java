package com.demo.security.repository;

import com.demo.security.base.BaseRepository;
import com.demo.security.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseRepository<Role,String> {

    Page<Role> findByNameLikeOrRemarkLike(String name, String remark, Pageable pageable);
}
