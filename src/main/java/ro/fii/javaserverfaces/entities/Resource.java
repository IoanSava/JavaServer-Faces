package ro.fii.javaserverfaces.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "resources")
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Resource.getAll", query = "SELECT resource FROM Resource resource")
})
public class Resource extends AbstractEntity {
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "available_quantity")
    private Integer availableQuantity;

    public Resource(String name, Integer availableQuantity) {
        this.name = name;
        this.availableQuantity = availableQuantity;
    }
}
