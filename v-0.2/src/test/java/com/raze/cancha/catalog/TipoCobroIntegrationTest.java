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
@RooIntegrationTest(entity = TipoCobro.class)
public class TipoCobroIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    TipoCobroDataOnDemand dod;

	@Test
    public void testCountTipoCobroes() {
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to initialize correctly", dod.getRandomTipoCobro());
        long count = TipoCobro.countTipoCobroes();
        Assert.assertTrue("Counter for 'TipoCobro' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindTipoCobro() {
        TipoCobro obj = dod.getRandomTipoCobro();
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to provide an identifier", id);
        obj = TipoCobro.findTipoCobro(id);
        Assert.assertNotNull("Find method for 'TipoCobro' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'TipoCobro' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllTipoCobroes() {
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to initialize correctly", dod.getRandomTipoCobro());
        long count = TipoCobro.countTipoCobroes();
        Assert.assertTrue("Too expensive to perform a find all test for 'TipoCobro', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<TipoCobro> result = TipoCobro.findAllTipoCobroes();
        Assert.assertNotNull("Find all method for 'TipoCobro' illegally returned null", result);
        Assert.assertTrue("Find all method for 'TipoCobro' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindTipoCobroEntries() {
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to initialize correctly", dod.getRandomTipoCobro());
        long count = TipoCobro.countTipoCobroes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<TipoCobro> result = TipoCobro.findTipoCobroEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'TipoCobro' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'TipoCobro' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        TipoCobro obj = dod.getRandomTipoCobro();
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to provide an identifier", id);
        obj = TipoCobro.findTipoCobro(id);
        Assert.assertNotNull("Find method for 'TipoCobro' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyTipoCobro(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'TipoCobro' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        TipoCobro obj = dod.getRandomTipoCobro();
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to provide an identifier", id);
        obj = TipoCobro.findTipoCobro(id);
        boolean modified =  dod.modifyTipoCobro(obj);
        Integer currentVersion = obj.getVersion();
        TipoCobro merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'TipoCobro' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to initialize correctly", dod.getRandomTipoCobro());
        TipoCobro obj = dod.getNewTransientTipoCobro(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'TipoCobro' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'TipoCobro' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        TipoCobro obj = dod.getRandomTipoCobro();
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'TipoCobro' failed to provide an identifier", id);
        obj = TipoCobro.findTipoCobro(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'TipoCobro' with identifier '" + id + "'", TipoCobro.findTipoCobro(id));
    }
}
