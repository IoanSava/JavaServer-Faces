package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.dtos.UpdateResourceDto;
import ro.fii.javaserverfaces.entities.Resource;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;

@Stateless
public class ResourcesDao extends Dao<Resource> {
    public Resource getById(Integer id) {
        return entityManager.find(Resource.class, id);
    }

    public List getAll() {
        return entityManager.createNamedQuery("Resource.getAll").getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean updateInBulk(List<UpdateResourceDto> updateResourceDtos) {
        boolean isTransactionFailed = false;
        try {
            for (UpdateResourceDto updateResourceDto : updateResourceDtos) {
                Resource resource = getById(updateResourceDto.getId());
                int newQuantity = resource.getAvailableQuantity() - updateResourceDto.getQuantity();
                if (newQuantity < 0) {
                    throw new IllegalStateException("Resource quantity exceeded");
                }
                resource.setAvailableQuantity(newQuantity);
                entityManager.merge(resource);
            }
            entityManager.flush();
        } catch (Throwable throwable) {
            // transaction rollback
            isTransactionFailed = true;
        }
        return isTransactionFailed;
    }
}
