package com.shardis.domain

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "permissions")
@SequenceGenerator(allocationSize = 1, name = "sequenceIdGenerator", sequenceName = "sequence_permission")
class Permission(
    @Column(nullable = false, length = 64, unique = true) val name: String
) : BaseEntity(), GrantedAuthority {
    override fun getAuthority() = name;
}
