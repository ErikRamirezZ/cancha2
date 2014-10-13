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
@RooIntegrationTest(entity = StatusEquipoJugador.class)
public class StatusEquipoJugadorIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }

	@Autowired
    StatusEquipoJugadorDataOnDemand dod;

	@Test
    public void testCountStatusEquipoJugadors() {
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to initialize correctly", dod.getRandomStatusEquipoJugador());
        long count = StatusEquipoJugador.countStatusEquipoJugadors();
        Assert.assertTrue("Counter for 'StatusEquipoJugador' incorrectly reported there were no entries", count > 0);
    }

	@Test
    public void testFindStatusEquipoJugador() {
        StatusEquipoJugador obj = dod.getRandomStatusEquipoJugador();
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to provide an identifier", id);
        obj = StatusEquipoJugador.findStatusEquipoJugador(id);
        Assert.assertNotNull("Find method for 'StatusEquipoJugador' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'StatusEquipoJugador' returned the incorrect identifier", id, obj.getId());
    }

	@Test
    public void testFindAllStatusEquipoJugadors() {
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to initialize correctly", dod.getRandomStatusEquipoJugador());
        long count = StatusEquipoJugador.countStatusEquipoJugadors();
        Assert.assertTrue("Too expensive to perform a find all test for 'StatusEquipoJugador', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<StatusEquipoJugador> result = StatusEquipoJugador.findAllStatusEquipoJugadors();
        Assert.assertNotNull("Find all method for 'StatusEquipoJugador' illegally returned null", result);
        Assert.assertTrue("Find all method for 'StatusEquipoJugador' failed to return any data", result.size() > 0);
    }

	@Test
    public void testFindStatusEquipoJugadorEntries() {
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to initialize correctly", dod.getRandomStatusEquipoJugador());
        long count = StatusEquipoJugador.countStatusEquipoJugadors();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<StatusEquipoJugador> result = StatusEquipoJugador.findStatusEquipoJugadorEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'StatusEquipoJugador' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'StatusEquipoJugador' returned an incorrect number of entries", count, result.size());
    }

	@Test
    public void testFlush() {
        StatusEquipoJugador obj = dod.getRandomStatusEquipoJugador();
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to provide an identifier", id);
        obj = StatusEquipoJugador.findStatusEquipoJugador(id);
        Assert.assertNotNull("Find method for 'StatusEquipoJugador' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyStatusEquipoJugador(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'StatusEquipoJugador' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testMergeUpdate() {
        StatusEquipoJugador obj = dod.getRandomStatusEquipoJugador();
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to provide an identifier", id);
        obj = StatusEquipoJugador.findStatusEquipoJugador(id);
        boolean modified =  dod.modifyStatusEquipoJugador(obj);
        Integer currentVersion = obj.getVersion();
        StatusEquipoJugador merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'StatusEquipoJugador' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }

	@Test
    public void testPersist() {
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to initialize correctly", dod.getRandomStatusEquipoJugador());
        StatusEquipoJugador obj = dod.getNewTransientStatusEquipoJugador(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'StatusEquipoJugador' identifier to be null", obj.getId());
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
        Assert.assertNotNull("Expected 'StatusEquipoJugador' identifier to no longer be null", obj.getId());
    }

	@Test
    public void testRemove() {
        StatusEquipoJugador obj = dod.getRandomStatusEquipoJugador();
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'StatusEquipoJugador' failed to provide an identifier", id);
        obj = StatusEquipoJugador.findStatusEquipoJugador(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'StatusEquipoJugador' with identifier '" + id + "'", StatusEquipoJugador.findStatusEquipoJugador(id));
    }
}
