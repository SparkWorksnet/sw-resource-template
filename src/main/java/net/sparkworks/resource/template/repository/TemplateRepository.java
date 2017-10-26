package net.sparkworks.resource.template.repository;

import net.sparkworks.resource.template.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface TemplateRepository extends JpaRepository<Template, Long> {
    
    @Override
    @PostAuthorize("hasPermission(returnObject, 'ROLE_ADMIN')")
    Template findOne(Long id);
    
}
