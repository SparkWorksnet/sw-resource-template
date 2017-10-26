package net.sparkworks.resource.template.security;

import net.sparkworks.resource.template.model.Template;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;
import java.util.Objects;

public class SparksPermissionEvaluator implements PermissionEvaluator {
    
    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {
        if (o instanceof Template) {
            Template template = (Template) o;
            if (Objects.equals("foo", template.getSite())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
    
    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
