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
@RooIntegrationTest(entity = FechaVencimientoTC.class)
public class FechaVencimientoTCIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    FechaVencimientoTCDataOnDemand dod;

	@Test
    public void testCountFechaVencimientoTCs() {
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to initialize correctly", dod.getRandomFechaVencimientoTC());
        long count = FechaVencimientoTC.countFechaVencimientoTCs();
        Assert.assertTrue("Counter for 'FechaVencimientoTC' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindFechaVencimientoTC() {
        FechaVencimientoTC obj = dod.getRandomFechaVencimientoTC();
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to provide an identifier", id);
        obj = FechaVencimientoTC.findFechaVencimientoTC(id);
        Assert.assertNotNull("Find method for 'FechaVencimientoTC' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'FechaVencimientoTC' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllFechaVencimientoTCs() {
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to initialize correctly", dod.getRandomFechaVencimientoTC());
        long count = FechaVencimientoTC.countFechaVencimientoTCs();
        Assert.assertTrue("Too expensive to perform a find all test for 'FechaVencimientoTC', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<FechaVencimientoTC> result = FechaVencimientoTC.findAllFechaVencimientoTCs();
        Assert.assertNotNull("Find all method for 'FechaVencimientoTC' illegally returned null", result);
        Assert.assertTrue("Find all method for 'FechaVencimientoTC' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindFechaVencimientoTCEntries() {
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to initialize correctly", dod.getRandomFechaVencimientoTC());
        long count = FechaVencimientoTC.countFechaVencimientoTCs();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<FechaVencimientoTC> result = FechaVencimientoTC.findFechaVencimientoTCEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'FechaVencimientoTC' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'FechaVencimientoTC' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        FechaVencimientoTC obj = dod.getRandomFechaVencimientoTC();
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to provide an identifier", id);
        obj = FechaVencimientoTC.findFechaVencimientoTC(id);
        Assert.assertNotNull("Find method for 'FechaVencimientoTC' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyFechaVencimientoTC(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'FechaVencimientoTC' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        FechaVencimientoTC obj = dod.getRandomFechaVencimientoTC();
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to provide an identifier", id);
        obj = FechaVencimientoTC.findFechaVencimientoTC(id);
        boolean modified =  dod.modifyFechaVencimientoTC(obj);
        Integer currentVersion = obj.getVersion();
        FechaVencimientoTC merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'FechaVencimientoTC' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to initialize correctly", dod.getRandomFechaVencimientoTC());
        FechaVencimientoTC obj = dod.getNewTransientFechaVencimientoTC(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'FechaVencimientoTC' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'FechaVencimientoTC' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        FechaVencimientoTC obj = dod.getRandomFechaVencimientoTC();
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'FechaVencimientoTC' failed to provide an identifier", id);
        obj = FechaVencimientoTC.findFechaVencimientoTC(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'FechaVencimientoTC' with identifier '" + id + "'", FechaVencimientoTC.findFechaVencimientoTC(id));
    }
}
