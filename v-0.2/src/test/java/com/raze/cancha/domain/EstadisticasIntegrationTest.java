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
@RooIntegrationTest(entity = Estadisticas.class)
public class EstadisticasIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    EstadisticasDataOnDemand dod;

	@Test
    public void testCountEstadisticases() {
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to initialize correctly", dod.getRandomEstadisticas());
        long count = Estadisticas.countEstadisticases();
        Assert.assertTrue("Counter for 'Estadisticas' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindEstadisticas() {
        Estadisticas obj = dod.getRandomEstadisticas();
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to provide an identifier", id);
        obj = Estadisticas.findEstadisticas(id);
        Assert.assertNotNull("Find method for 'Estadisticas' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Estadisticas' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllEstadisticases() {
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to initialize correctly", dod.getRandomEstadisticas());
        long count = Estadisticas.countEstadisticases();
        Assert.assertTrue("Too expensive to perform a find all test for 'Estadisticas', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Estadisticas> result = Estadisticas.findAllEstadisticases();
        Assert.assertNotNull("Find all method for 'Estadisticas' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Estadisticas' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindEstadisticasEntries() {
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to initialize correctly", dod.getRandomEstadisticas());
        long count = Estadisticas.countEstadisticases();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Estadisticas> result = Estadisticas.findEstadisticasEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Estadisticas' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Estadisticas' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Estadisticas obj = dod.getRandomEstadisticas();
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to provide an identifier", id);
        obj = Estadisticas.findEstadisticas(id);
        Assert.assertNotNull("Find method for 'Estadisticas' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyEstadisticas(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Estadisticas' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        Estadisticas obj = dod.getRandomEstadisticas();
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to provide an identifier", id);
        obj = Estadisticas.findEstadisticas(id);
        boolean modified =  dod.modifyEstadisticas(obj);
        Integer currentVersion = obj.getVersion();
        Estadisticas merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Estadisticas' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to initialize correctly", dod.getRandomEstadisticas());
        Estadisticas obj = dod.getNewTransientEstadisticas(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Estadisticas' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'Estadisticas' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        Estadisticas obj = dod.getRandomEstadisticas();
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Estadisticas' failed to provide an identifier", id);
        obj = Estadisticas.findEstadisticas(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Estadisticas' with identifier '" + id + "'", Estadisticas.findEstadisticas(id));
    }
}
