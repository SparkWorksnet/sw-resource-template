package net.sparkworks.gc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEMPLATE")
//@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Template {
    
    @Id
    private Long id;
    
    private String site;
    
    private String attribute;
    
}
