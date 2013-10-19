package models;

import play.data.validation.Constraints;
import play.db.jpa.JPA;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "quote_seq", sequenceName = "quote_seq")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quote_seq")
    public Long id;

    @Constraints.Required
    public String source;

    @Constraints.Required
    @Constraints.MinLength(value = 4)
    public String text;


    public static final List<Quote> findAll() {

        return JPA.em().createQuery("from Quote").getResultList();

    }

    public void save() {
        JPA.em().persist(this);
    }

}