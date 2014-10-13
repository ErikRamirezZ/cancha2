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
@RooIntegrationTest(entity = TipoTarjeta.class)
public class TipoTarjetaIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    TipoTarjetaDataOnDemand dod;

	@Test
    public void testCountTipoTarjetas() {
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to initialize correctly", dod.getRandomTipoTarjeta());
        long count = TipoTarjeta.countTipoTarjetas();
        Assert.assertTrue("Counter for 'TipoTarjeta' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindTipoTarjeta() {
        TipoTarjeta obj = dod.getRandomTipoTarjeta();
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to provide an identifier", id);
        obj = TipoTarjeta.findTipoTarjeta(id);
        Assert.assertNotNull("Find method for 'TipoTarjeta' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'TipoTarjeta' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllTipoTarjetas() {
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to initialize correctly", dod.getRandomTipoTarjeta());
        long count = TipoTarjeta.countTipoTarjetas();
        Assert.assertTrue("Too expensive to perform a find all test for 'TipoTarjeta', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<TipoTarjeta> result = TipoTarjeta.findAllTipoTarjetas();
        Assert.assertNotNull("Find all method for 'TipoTarjeta' illegally returned null", result);
        Assert.assertTrue("Find all method for 'TipoTarjeta' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindTipoTarjetaEntries() {
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to initialize correctly", dod.getRandomTipoTarjeta());
        long count = TipoTarjeta.countTipoTarjetas();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<TipoTarjeta> result = TipoTarjeta.findTipoTarjetaEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'TipoTarjeta' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'TipoTarjeta' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        TipoTarjeta obj = dod.getRandomTipoTarjeta();
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to provide an identifier", id);
        obj = TipoTarjeta.findTipoTarjeta(id);
        Assert.assertNotNull("Find method for 'TipoTarjeta' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyTipoTarjeta(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'TipoTarjeta' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        TipoTarjeta obj = dod.getRandomTipoTarjeta();
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to provide an identifier", id);
        obj = TipoTarjeta.findTipoTarjeta(id);
        boolean modified =  dod.modifyTipoTarjeta(obj);
        Integer currentVersion = obj.getVersion();
        TipoTarjeta merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'TipoTarjeta' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to initialize correctly", dod.getRandomTipoTarjeta());
        TipoTarjeta obj = dod.getNewTransientTipoTarjeta(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'TipoTarjeta' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'TipoTarjeta' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        TipoTarjeta obj = dod.getRandomTipoTarjeta();
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoTarjeta' failed to provide an identifier", id);
        obj = TipoTarjeta.findTipoTarjeta(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'TipoTarjeta' with identifier '" + id + "'", TipoTarjeta.findTipoTarjeta(id));
    }
}
