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

@Configurable
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
@RooIntegrationTest(entity = Accion.class)
public class AccionIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    AccionDataOnDemand dod;

	@Test
    public void testCountAccions() {
        Assert.assertNotNull("Data on demand for 'Accion' failed to initialize correctly", dod.getRandomAccion());
        long count = Accion.countAccions();
        Assert.assertTrue("Counter for 'Accion' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindAccion() {
        Accion obj = dod.getRandomAccion();
        Assert.assertNotNull("Data on demand for 'Accion' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Accion' failed to provide an identifier", id);
        obj = Accion.findAccion(id);
        Assert.assertNotNull("Find method for 'Accion' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Accion' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllAccions() {
        Assert.assertNotNull("Data on demand for 'Accion' failed to initialize correctly", dod.getRandomAccion());
        long count = Accion.countAccions();
        Assert.assertTrue("Too expensive to perform a find all test for 'Accion', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Accion> result = Accion.findAllAccions();
        Assert.assertNotNull("Find all method for 'Accion' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Accion' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindAccionEntries() {
        Assert.assertNotNull("Data on demand for 'Accion' failed to initialize correctly", dod.getRandomAccion());
        long count = Accion.countAccions();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Accion> result = Accion.findAccionEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Accion' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Accion' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Accion obj = dod.getRandomAccion();
        Assert.assertNotNull("Data on demand for 'Accion' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Accion' failed to provide an identifier", id);
        obj = Accion.findAccion(id);
        Assert.assertNotNull("Find method for 'Accion' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyAccion(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Accion' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        Accion obj = dod.getRandomAccion();
        Assert.assertNotNull("Data on demand for 'Accion' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Accion' failed to provide an identifier", id);
        obj = Accion.findAccion(id);
        boolean modified =  dod.modifyAccion(obj);
        Integer currentVersion = obj.getVersion();
        Accion merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Accion' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'Accion' failed to initialize correctly", dod.getRandomAccion());
        Accion obj = dod.getNewTransientAccion(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Accion' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Accion' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'Accion' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        Accion obj = dod.getRandomAccion();
        Assert.assertNotNull("Data on demand for 'Accion' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Accion' failed to provide an identifier", id);
        obj = Accion.findAccion(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Accion' with identifier '" + id + "'", Accion.findAccion(id));
    }
}
