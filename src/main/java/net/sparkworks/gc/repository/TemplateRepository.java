package net.sparkworks.gc.repository;

import net.sparkworks.gc.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface TemplateRepository extends JpaRepository<Template, Long> {
    
    @Override
    @PostAuthorize("hasPermission(returnObject, 'ROLE_ADMIN')")
    Template findOne(Long id);
    
}
