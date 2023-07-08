package open.code.util.filter_criteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import open.code.model.BicDirectoryEntry;
import org.springframework.data.jpa.domain.Specification;

public class BicEntrySpecification implements Specification<BicDirectoryEntry> {
    @Override
    public Predicate toPredicate(Root<BicDirectoryEntry> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }


}
