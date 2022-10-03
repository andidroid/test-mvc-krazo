package me.andidroid.testwar;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import org.eclipse.microprofile.opentracing.Traced;

@Traced
@RequestScoped
public class TestService {

    @PersistenceContext
    private EntityManager em;

    public TestService() {

    }

    public TestService(EntityManager em) {
        this.em = em;
    }

    public Test getById(long id) {
        return em.find(Test.class, id);
    }
}
