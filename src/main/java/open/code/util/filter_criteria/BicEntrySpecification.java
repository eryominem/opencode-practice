package open.code.util.filter_criteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import open.code.dto.bic_dto.BicDirectoryFilterDto;
import open.code.model.BicDirectoryEntry;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BicEntrySpecification implements Specification<BicDirectoryEntry> {
    private BicDirectoryFilterDto criteria;

    public BicEntrySpecification(BicDirectoryFilterDto criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<BicDirectoryEntry> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (criteria.getBic() != null) {
            predicates.add(criteriaBuilder.like(root.get("bic"), criteria.getBic() + "%"));
        }
        if (criteria.getPtType() != null) {
            predicates.add(criteriaBuilder.like(root.get("participantInfo").get("ptType"), criteria.getPtType() + "%"));
        }
        if (criteria.getNameP() != null) {
            predicates.add(criteriaBuilder.like(root.get("participantInfo").get("nameP"), "%" + criteria.getNameP() + "%"));
        }
        if (criteria.getMsgId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("bankMessage").get("id"), criteria.getMsgId()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
