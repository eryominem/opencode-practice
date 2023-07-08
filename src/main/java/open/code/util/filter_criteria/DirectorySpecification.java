package open.code.util.filter_criteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import open.code.dto.directory_dto.DirectoryFilterDto;
import open.code.model.Directory;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class DirectorySpecification implements Specification<Directory> {
    private DirectoryFilterDto criteria;
    private String directoryType;

    public DirectorySpecification(DirectoryFilterDto criteria, String directoryType) {
        this.criteria = criteria;
        this.directoryType = directoryType;
    }

    @Override
    public Predicate toPredicate(Root<Directory> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getCode() != null) {
            predicates.add(criteriaBuilder.like(root.get("code"), criteria.getCode() + "%"));
        }

        if (criteria.getName() != null) {
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + criteria.getName() + "%"));
        }

        if (criteria.getValidityEnd() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("validityStart"), criteria.getValidityStart()));
        }

        if (criteria.getValidityEnd() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("validityEnd"), criteria.getValidityEnd()));
        }

        if (criteria.getDeleted() != null) {
            predicates.add(criteriaBuilder.equal(root.get("deleted"), criteria.getDeleted()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
