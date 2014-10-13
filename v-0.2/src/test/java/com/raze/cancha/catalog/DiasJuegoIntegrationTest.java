package com.raze.cancha.catalog;
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
@RooIntegrationTest(entity = DiasJuego.class)
public class DiasJuegoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    DiasJuegoDataOnDemand dod;

	@Test
    public void testCountDiasJuegoes() {
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to initialize correctly", dod.getRandomDiasJuego());
        long count = DiasJuego.countDiasJuegoes();
        Assert.assertTrue("Counter for 'DiasJuego' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindDiasJuego() {
        DiasJuego obj = dod.getRandomDiasJuego();
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to provide an identifier", id);
        obj = DiasJuego.findDiasJuego(id);
        Assert.assertNotNull("Find method for 'DiasJuego' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'DiasJuego' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllDiasJuegoes() {
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to initialize correctly", dod.getRandomDiasJuego());
        long count = DiasJuego.countDiasJuegoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'DiasJuego', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<DiasJuego> result = DiasJuego.findAllDiasJuegoes();
        Assert.assertNotNull("Find all method for 'DiasJuego' illegally returned null", result);
        Assert.assertTrue("Find all method for 'DiasJuego' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindDiasJuegoEntries() {
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to initialize correctly", dod.getRandomDiasJuego());
        long count = DiasJuego.countDiasJuegoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<DiasJuego> result = DiasJuego.findDiasJuegoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'DiasJuego' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'DiasJuego' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        DiasJuego obj = dod.getRandomDiasJuego();
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to provide an identifier", id);
        obj = DiasJuego.findDiasJuego(id);
        Assert.assertNotNull("Find method for 'DiasJuego' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyDiasJuego(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'DiasJuego' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        DiasJuego obj = dod.getRandomDiasJuego();
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to provide an identifier", id);
        obj = DiasJuego.findDiasJuego(id);
        boolean modified =  dod.modifyDiasJuego(obj);
        Integer currentVersion = obj.getVersion();
        DiasJuego merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'DiasJuego' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to initialize correctly", dod.getRandomDiasJuego());
        DiasJuego obj = dod.getNewTransientDiasJuego(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'DiasJuego' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'DiasJuego' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        DiasJuego obj = dod.getRandomDiasJuego();
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'DiasJuego' failed to provide an identifier", id);
        obj = DiasJuego.findDiasJuego(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'DiasJuego' with identifier '" + id + "'", DiasJuego.findDiasJuego(id));
    }
}
