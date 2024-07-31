package sn.gouv.dpm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.gouv.dpm.model.Role;
import sn.gouv.dpm.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{
	Optional<Role> findByName(RoleName roleName);
}
