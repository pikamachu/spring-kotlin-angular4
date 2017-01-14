package com.shardis.domain

import org.hibernate.envers.Audited
import org.springframework.security.core.GrantedAuthority
import java.io.Serializable
import javax.persistence.*

@Entity
@Audited
@Table(name = "roles")
@SequenceGenerator(allocationSize = 1, name = "sequenceIdGenerator", sequenceName = "sequence_roles")
class Role(
    @Column(nullable = false, length = 64, unique = true) val name: String,
    @OneToMany(fetch = FetchType.LAZY) val permissions: MutableSet<Role> = mutableSetOf()
) : AuditedEntity(), Serializable, GrantedAuthority {
    override fun getAuthority() = name
}
