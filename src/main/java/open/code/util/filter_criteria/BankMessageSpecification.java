package open.code.util.filter_criteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import open.code.dto.ed807_dto.BankMessageFilterDto;
import open.code.model.BankMessage;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BankMessageSpecification implements Specification<BankMessage> {

    private BankMessageFilterDto criteria;

    public BankMessageSpecification(BankMessageFilterDto criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<BankMessage> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (criteria.getDate1() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), criteria.getDate1()));
        }
        if (criteria.getDate2() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), criteria.getDate2()));
        }
        if (criteria.getTitle() != null) {
            predicates.add(criteriaBuilder.like(root.get("title"), "%" + criteria.getTitle() + "%"));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
