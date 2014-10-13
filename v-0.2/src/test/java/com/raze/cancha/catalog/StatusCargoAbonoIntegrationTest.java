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
@RooIntegrationTest(entity = StatusCargoAbono.class)
public class StatusCargoAbonoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    StatusCargoAbonoDataOnDemand dod;

	@Test
    public void testCountStatusCargoAbonoes() {
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to initialize correctly", dod.getRandomStatusCargoAbono());
        long count = StatusCargoAbono.countStatusCargoAbonoes();
        Assert.assertTrue("Counter for 'StatusCargoAbono' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindStatusCargoAbono() {
        StatusCargoAbono obj = dod.getRandomStatusCargoAbono();
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to provide an identifier", id);
        obj = StatusCargoAbono.findStatusCargoAbono(id);
        Assert.assertNotNull("Find method for 'StatusCargoAbono' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'StatusCargoAbono' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllStatusCargoAbonoes() {
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to initialize correctly", dod.getRandomStatusCargoAbono());
        long count = StatusCargoAbono.countStatusCargoAbonoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'StatusCargoAbono', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<StatusCargoAbono> result = StatusCargoAbono.findAllStatusCargoAbonoes();
        Assert.assertNotNull("Find all method for 'StatusCargoAbono' illegally returned null", result);
        Assert.assertTrue("Find all method for 'StatusCargoAbono' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindStatusCargoAbonoEntries() {
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to initialize correctly", dod.getRandomStatusCargoAbono());
        long count = StatusCargoAbono.countStatusCargoAbonoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<StatusCargoAbono> result = StatusCargoAbono.findStatusCargoAbonoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'StatusCargoAbono' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'StatusCargoAbono' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        StatusCargoAbono obj = dod.getRandomStatusCargoAbono();
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to provide an identifier", id);
        obj = StatusCargoAbono.findStatusCargoAbono(id);
        Assert.assertNotNull("Find method for 'StatusCargoAbono' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyStatusCargoAbono(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'StatusCargoAbono' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        StatusCargoAbono obj = dod.getRandomStatusCargoAbono();
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to provide an identifier", id);
        obj = StatusCargoAbono.findStatusCargoAbono(id);
        boolean modified =  dod.modifyStatusCargoAbono(obj);
        Integer currentVersion = obj.getVersion();
        StatusCargoAbono merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'StatusCargoAbono' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to initialize correctly", dod.getRandomStatusCargoAbono());
        StatusCargoAbono obj = dod.getNewTransientStatusCargoAbono(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'StatusCargoAbono' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'StatusCargoAbono' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        StatusCargoAbono obj = dod.getRandomStatusCargoAbono();
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'StatusCargoAbono' failed to provide an identifier", id);
        obj = StatusCargoAbono.findStatusCargoAbono(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'StatusCargoAbono' with identifier '" + id + "'", StatusCargoAbono.findStatusCargoAbono(id));
    }
}
