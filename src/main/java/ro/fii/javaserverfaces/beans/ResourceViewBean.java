package ro.fii.javaserverfaces.beans;

import ro.fii.javaserverfaces.dao.ResourcesDao;
import ro.fii.javaserverfaces.entities.Resource;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;

@Named
@Stateless
@LocalBean
public class ResourceViewBean extends DataViewBean<Resource> {
    @EJB
    private ResourcesDao resourcesDao;

    @PostConstruct
    public void init() {
        entities = resourcesDao.getAll();
    }

    public List<Resource> getEntities() {
        entities = resourcesDao.getAll();
        return entities;
    }
}
