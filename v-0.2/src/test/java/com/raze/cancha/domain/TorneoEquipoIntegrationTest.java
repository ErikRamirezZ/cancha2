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
@RooIntegrationTest(entity = TorneoEquipo.class)
public class TorneoEquipoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    TorneoEquipoDataOnDemand dod;

	@Test
    public void testCountTorneoEquipoes() {
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to initialize correctly", dod.getRandomTorneoEquipo());
        long count = TorneoEquipo.countTorneoEquipoes();
        Assert.assertTrue("Counter for 'TorneoEquipo' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindTorneoEquipo() {
        TorneoEquipo obj = dod.getRandomTorneoEquipo();
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to provide an identifier", id);
        obj = TorneoEquipo.findTorneoEquipo(id);
        Assert.assertNotNull("Find method for 'TorneoEquipo' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'TorneoEquipo' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllTorneoEquipoes() {
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to initialize correctly", dod.getRandomTorneoEquipo());
        long count = TorneoEquipo.countTorneoEquipoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'TorneoEquipo', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<TorneoEquipo> result = TorneoEquipo.findAllTorneoEquipoes();
        Assert.assertNotNull("Find all method for 'TorneoEquipo' illegally returned null", result);
        Assert.assertTrue("Find all method for 'TorneoEquipo' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindTorneoEquipoEntries() {
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to initialize correctly", dod.getRandomTorneoEquipo());
        long count = TorneoEquipo.countTorneoEquipoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<TorneoEquipo> result = TorneoEquipo.findTorneoEquipoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'TorneoEquipo' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'TorneoEquipo' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        TorneoEquipo obj = dod.getRandomTorneoEquipo();
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to provide an identifier", id);
        obj = TorneoEquipo.findTorneoEquipo(id);
        Assert.assertNotNull("Find method for 'TorneoEquipo' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyTorneoEquipo(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'TorneoEquipo' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        TorneoEquipo obj = dod.getRandomTorneoEquipo();
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to provide an identifier", id);
        obj = TorneoEquipo.findTorneoEquipo(id);
        boolean modified =  dod.modifyTorneoEquipo(obj);
        Integer currentVersion = obj.getVersion();
        TorneoEquipo merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'TorneoEquipo' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to initialize correctly", dod.getRandomTorneoEquipo());
        TorneoEquipo obj = dod.getNewTransientTorneoEquipo(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'TorneoEquipo' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'TorneoEquipo' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        TorneoEquipo obj = dod.getRandomTorneoEquipo();
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TorneoEquipo' failed to provide an identifier", id);
        obj = TorneoEquipo.findTorneoEquipo(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'TorneoEquipo' with identifier '" + id + "'", TorneoEquipo.findTorneoEquipo(id));
    }
}
