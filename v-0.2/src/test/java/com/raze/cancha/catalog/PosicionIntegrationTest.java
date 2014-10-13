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
@RooIntegrationTest(entity = Posicion.class)
public class PosicionIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    PosicionDataOnDemand dod;

	@Test
    public void testCountPosicions() {
        Assert.assertNotNull("Data on demand for 'Posicion' failed to initialize correctly", dod.getRandomPosicion());
        long count = Posicion.countPosicions();
        Assert.assertTrue("Counter for 'Posicion' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindPosicion() {
        Posicion obj = dod.getRandomPosicion();
        Assert.assertNotNull("Data on demand for 'Posicion' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Posicion' failed to provide an identifier", id);
        obj = Posicion.findPosicion(id);
        Assert.assertNotNull("Find method for 'Posicion' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Posicion' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllPosicions() {
        Assert.assertNotNull("Data on demand for 'Posicion' failed to initialize correctly", dod.getRandomPosicion());
        long count = Posicion.countPosicions();
        Assert.assertTrue("Too expensive to perform a find all test for 'Posicion', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Posicion> result = Posicion.findAllPosicions();
        Assert.assertNotNull("Find all method for 'Posicion' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Posicion' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindPosicionEntries() {
        Assert.assertNotNull("Data on demand for 'Posicion' failed to initialize correctly", dod.getRandomPosicion());
        long count = Posicion.countPosicions();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Posicion> result = Posicion.findPosicionEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Posicion' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Posicion' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Posicion obj = dod.getRandomPosicion();
        Assert.assertNotNull("Data on demand for 'Posicion' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Posicion' failed to provide an identifier", id);
        obj = Posicion.findPosicion(id);
        Assert.assertNotNull("Find method for 'Posicion' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyPosicion(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Posicion' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        Posicion obj = dod.getRandomPosicion();
        Assert.assertNotNull("Data on demand for 'Posicion' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Posicion' failed to provide an identifier", id);
        obj = Posicion.findPosicion(id);
        boolean modified =  dod.modifyPosicion(obj);
        Integer currentVersion = obj.getVersion();
        Posicion merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Posicion' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'Posicion' failed to initialize correctly", dod.getRandomPosicion());
        Posicion obj = dod.getNewTransientPosicion(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Posicion' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Posicion' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'Posicion' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        Posicion obj = dod.getRandomPosicion();
        Assert.assertNotNull("Data on demand for 'Posicion' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Posicion' failed to provide an identifier", id);
        obj = Posicion.findPosicion(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Posicion' with identifier '" + id + "'", Posicion.findPosicion(id));
    }
}
