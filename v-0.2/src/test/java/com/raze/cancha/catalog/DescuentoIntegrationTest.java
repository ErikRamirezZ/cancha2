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
@RooIntegrationTest(entity = Descuento.class)
public class DescuentoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    DescuentoDataOnDemand dod;

	@Test
    public void testCountDescuentoes() {
        Assert.assertNotNull("Data on demand for 'Descuento' failed to initialize correctly", dod.getRandomDescuento());
        long count = Descuento.countDescuentoes();
        Assert.assertTrue("Counter for 'Descuento' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindDescuento() {
        Descuento obj = dod.getRandomDescuento();
        Assert.assertNotNull("Data on demand for 'Descuento' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Descuento' failed to provide an identifier", id);
        obj = Descuento.findDescuento(id);
        Assert.assertNotNull("Find method for 'Descuento' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Descuento' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllDescuentoes() {
        Assert.assertNotNull("Data on demand for 'Descuento' failed to initialize correctly", dod.getRandomDescuento());
        long count = Descuento.countDescuentoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'Descuento', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Descuento> result = Descuento.findAllDescuentoes();
        Assert.assertNotNull("Find all method for 'Descuento' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Descuento' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindDescuentoEntries() {
        Assert.assertNotNull("Data on demand for 'Descuento' failed to initialize correctly", dod.getRandomDescuento());
        long count = Descuento.countDescuentoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Descuento> result = Descuento.findDescuentoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Descuento' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Descuento' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        Descuento obj = dod.getRandomDescuento();
        Assert.assertNotNull("Data on demand for 'Descuento' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Descuento' failed to provide an identifier", id);
        obj = Descuento.findDescuento(id);
        Assert.assertNotNull("Find method for 'Descuento' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyDescuento(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Descuento' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        Descuento obj = dod.getRandomDescuento();
        Assert.assertNotNull("Data on demand for 'Descuento' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Descuento' failed to provide an identifier", id);
        obj = Descuento.findDescuento(id);
        boolean modified =  dod.modifyDescuento(obj);
        Integer currentVersion = obj.getVersion();
        Descuento merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Descuento' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'Descuento' failed to initialize correctly", dod.getRandomDescuento());
        Descuento obj = dod.getNewTransientDescuento(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Descuento' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Descuento' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'Descuento' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        Descuento obj = dod.getRandomDescuento();
        Assert.assertNotNull("Data on demand for 'Descuento' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Descuento' failed to provide an identifier", id);
        obj = Descuento.findDescuento(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Descuento' with identifier '" + id + "'", Descuento.findDescuento(id));
    }
}
