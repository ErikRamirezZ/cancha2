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

@Configurable
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
@RooIntegrationTest(entity = Cargo.class)
public class CargoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    CargoDataOnDemand dod;

	@Test
    public void testCountCargoes() {
        Assert.assertNotNull("Data on demand for 'Cargo' failed to initialize correctly", dod.getRandomCargo());
        long count = Cargo.countCargoes();
        Assert.assertTrue("Counter for 'Cargo' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindCargo() {
        Cargo obj = dod.getRandomCargo();
        Assert.assertNotNull("Data on demand for 'Cargo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Cargo' failed to provide an identifier", id);
        obj = Cargo.findCargo(id);
        Assert.assertNotNull("Find method for 'Cargo' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Cargo' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllCargoes() {
        Assert.assertNotNull("Data on demand for 'Cargo' failed to initialize correctly", dod.getRandomCargo());
        long count = Cargo.countCargoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Cargo', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Cargo> result = Cargo.findAllCargoes();
        Assert.assertNotNull("Find all method for 'Cargo' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Cargo' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindCargoEntries() {
        Assert.assertNotNull("Data on demand for 'Cargo' failed to initialize correctly", dod.getRandomCargo());
        long count = Cargo.countCargoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Cargo> result = Cargo.findCargoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Cargo' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Cargo' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Cargo obj = dod.getRandomCargo();
        Assert.assertNotNull("Data on demand for 'Cargo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Cargo' failed to provide an identifier", id);
        obj = Cargo.findCargo(id);
        Assert.assertNotNull("Find method for 'Cargo' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyCargo(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Cargo' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        Cargo obj = dod.getRandomCargo();
        Assert.assertNotNull("Data on demand for 'Cargo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Cargo' failed to provide an identifier", id);
        obj = Cargo.findCargo(id);
        boolean modified =  dod.modifyCargo(obj);
        Integer currentVersion = obj.getVersion();
        Cargo merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Cargo' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'Cargo' failed to initialize correctly", dod.getRandomCargo());
        Cargo obj = dod.getNewTransientCargo(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Cargo' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Cargo' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'Cargo' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        Cargo obj = dod.getRandomCargo();
        Assert.assertNotNull("Data on demand for 'Cargo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Cargo' failed to provide an identifier", id);
        obj = Cargo.findCargo(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Cargo' with identifier '" + id + "'", Cargo.findCargo(id));
    }
}
