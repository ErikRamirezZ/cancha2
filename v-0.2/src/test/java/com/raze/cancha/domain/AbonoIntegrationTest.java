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
@RooIntegrationTest(entity = Abono.class)
public class AbonoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    AbonoDataOnDemand dod;

	@Test
    public void testCountAbonoes() {
        Assert.assertNotNull("Data on demand for 'Abono' failed to initialize correctly", dod.getRandomAbono());
        long count = Abono.countAbonoes();
        Assert.assertTrue("Counter for 'Abono' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindAbono() {
        Abono obj = dod.getRandomAbono();
        Assert.assertNotNull("Data on demand for 'Abono' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Abono' failed to provide an identifier", id);
        obj = Abono.findAbono(id);
        Assert.assertNotNull("Find method for 'Abono' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Abono' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllAbonoes() {
        Assert.assertNotNull("Data on demand for 'Abono' failed to initialize correctly", dod.getRandomAbono());
        long count = Abono.countAbonoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Abono', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Abono> result = Abono.findAllAbonoes();
        Assert.assertNotNull("Find all method for 'Abono' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Abono' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindAbonoEntries() {
        Assert.assertNotNull("Data on demand for 'Abono' failed to initialize correctly", dod.getRandomAbono());
        long count = Abono.countAbonoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Abono> result = Abono.findAbonoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Abono' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Abono' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Abono obj = dod.getRandomAbono();
        Assert.assertNotNull("Data on demand for 'Abono' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Abono' failed to provide an identifier", id);
        obj = Abono.findAbono(id);
        Assert.assertNotNull("Find method for 'Abono' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyAbono(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Abono' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        Abono obj = dod.getRandomAbono();
        Assert.assertNotNull("Data on demand for 'Abono' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Abono' failed to provide an identifier", id);
        obj = Abono.findAbono(id);
        boolean modified =  dod.modifyAbono(obj);
        Integer currentVersion = obj.getVersion();
        Abono merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Abono' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'Abono' failed to initialize correctly", dod.getRandomAbono());
        Abono obj = dod.getNewTransientAbono(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Abono' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Abono' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'Abono' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        Abono obj = dod.getRandomAbono();
        Assert.assertNotNull("Data on demand for 'Abono' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Abono' failed to provide an identifier", id);
        obj = Abono.findAbono(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Abono' with identifier '" + id + "'", Abono.findAbono(id));
    }
}
