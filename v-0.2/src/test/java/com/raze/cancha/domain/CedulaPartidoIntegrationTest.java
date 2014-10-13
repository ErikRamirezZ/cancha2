package com.raze.cancha.domain;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
@Configurable
@RooIntegrationTest(entity = CedulaPartido.class)
public class CedulaPartidoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    CedulaPartidoDataOnDemand dod;

	@Test
    public void testCountCedulaPartidoes() {
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to initialize correctly", dod.getRandomCedulaPartido());
        long count = CedulaPartido.countCedulaPartidoes();
        Assert.assertTrue("Counter for 'CedulaPartido' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindCedulaPartido() {
        CedulaPartido obj = dod.getRandomCedulaPartido();
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to provide an identifier", id);
        obj = CedulaPartido.findCedulaPartido(id);
        Assert.assertNotNull("Find method for 'CedulaPartido' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'CedulaPartido' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllCedulaPartidoes() {
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to initialize correctly", dod.getRandomCedulaPartido());
        long count = CedulaPartido.countCedulaPartidoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'CedulaPartido', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<CedulaPartido> result = CedulaPartido.findAllCedulaPartidoes();
        Assert.assertNotNull("Find all method for 'CedulaPartido' illegally returned null", result);
        Assert.assertTrue("Find all method for 'CedulaPartido' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindCedulaPartidoEntries() {
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to initialize correctly", dod.getRandomCedulaPartido());
        long count = CedulaPartido.countCedulaPartidoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<CedulaPartido> result = CedulaPartido.findCedulaPartidoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'CedulaPartido' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'CedulaPartido' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        CedulaPartido obj = dod.getRandomCedulaPartido();
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to provide an identifier", id);
        obj = CedulaPartido.findCedulaPartido(id);
        Assert.assertNotNull("Find method for 'CedulaPartido' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyCedulaPartido(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'CedulaPartido' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        CedulaPartido obj = dod.getRandomCedulaPartido();
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to provide an identifier", id);
        obj = CedulaPartido.findCedulaPartido(id);
        boolean modified =  dod.modifyCedulaPartido(obj);
        Integer currentVersion = obj.getVersion();
        CedulaPartido merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'CedulaPartido' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to initialize correctly", dod.getRandomCedulaPartido());
        CedulaPartido obj = dod.getNewTransientCedulaPartido(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'CedulaPartido' identifier to be null", obj.getId());
        try {
            obj.persist();
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        obj.flush();
        Assert.assertNotNull("Expected 'CedulaPartido' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        CedulaPartido obj = dod.getRandomCedulaPartido();
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'CedulaPartido' failed to provide an identifier", id);
        obj = CedulaPartido.findCedulaPartido(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'CedulaPartido' with identifier '" + id + "'", CedulaPartido.findCedulaPartido(id));
    }
}
