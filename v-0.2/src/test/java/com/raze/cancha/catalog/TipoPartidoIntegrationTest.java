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
@RooIntegrationTest(entity = TipoPartido.class)
public class TipoPartidoIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    TipoPartidoDataOnDemand dod;

	@Test
    public void testCountTipoPartidoes() {
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to initialize correctly", dod.getRandomTipoPartido());
        long count = TipoPartido.countTipoPartidoes();
        Assert.assertTrue("Counter for 'TipoPartido' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindTipoPartido() {
        TipoPartido obj = dod.getRandomTipoPartido();
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to provide an identifier", id);
        obj = TipoPartido.findTipoPartido(id);
        Assert.assertNotNull("Find method for 'TipoPartido' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'TipoPartido' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllTipoPartidoes() {
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to initialize correctly", dod.getRandomTipoPartido());
        long count = TipoPartido.countTipoPartidoes();
        Assert.assertTrue("Too expensive to perform a find all test for 'TipoPartido', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<TipoPartido> result = TipoPartido.findAllTipoPartidoes();
        Assert.assertNotNull("Find all method for 'TipoPartido' illegally returned null", result);
        Assert.assertTrue("Find all method for 'TipoPartido' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindTipoPartidoEntries() {
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to initialize correctly", dod.getRandomTipoPartido());
        long count = TipoPartido.countTipoPartidoes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<TipoPartido> result = TipoPartido.findTipoPartidoEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'TipoPartido' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'TipoPartido' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        TipoPartido obj = dod.getRandomTipoPartido();
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to provide an identifier", id);
        obj = TipoPartido.findTipoPartido(id);
        Assert.assertNotNull("Find method for 'TipoPartido' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyTipoPartido(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'TipoPartido' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        TipoPartido obj = dod.getRandomTipoPartido();
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to provide an identifier", id);
        obj = TipoPartido.findTipoPartido(id);
        boolean modified =  dod.modifyTipoPartido(obj);
        Integer currentVersion = obj.getVersion();
        TipoPartido merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'TipoPartido' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to initialize correctly", dod.getRandomTipoPartido());
        TipoPartido obj = dod.getNewTransientTipoPartido(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'TipoPartido' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'TipoPartido' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        TipoPartido obj = dod.getRandomTipoPartido();
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoPartido' failed to provide an identifier", id);
        obj = TipoPartido.findTipoPartido(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'TipoPartido' with identifier '" + id + "'", TipoPartido.findTipoPartido(id));
    }
}
