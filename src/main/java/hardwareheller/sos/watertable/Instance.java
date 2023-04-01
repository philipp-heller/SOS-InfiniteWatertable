package hardwareheller.sos.watertable;

import java.lang.reflect.Field;

import script.SCRIPT.SCRIPT_INSTANCE;
import snake2d.util.file.FileGetter;
import snake2d.util.file.FilePutter;
import view.main.VIEW;

import static settlement.main.SETT.JOBS;

public class Instance implements SCRIPT_INSTANCE {

    private boolean initGamePresent = false;

    public void initGamePresent() {
        try {
            setField("waterTable", JOBS(), 589824);
            System.out.println("Water Table successfully unbound! New Table = " + getField("waterTable", JOBS()) + " size!");
        } catch (NoSuchFieldException e) {
            System.out.println("Case 1" + e);
        } catch (IllegalAccessException e) {
            System.out.println("Case 2" + e);
        }
    }

    public static int getField(String fieldName, Object instance) throws NoSuchFieldException, IllegalAccessException {
        Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.getInt(instance);
    }

    public static void setField(String fieldName, Object instance, Object newValue) throws NoSuchFieldException, IllegalAccessException {
        Field field = instance.getClass().getDeclaredField(fieldName);
        setField(field, instance, newValue);
    }

    public static void setField(Field field, Object instance, Object newValue) throws NoSuchFieldException, IllegalAccessException {
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);

        field.set(instance, newValue);
    }

    @Override
    public void load(FileGetter arg0) {

    }

    @Override
    public void save(FilePutter arg0) {

    }

    @Override
    public void update(double arg0) {
        if (!initGamePresent && !VIEW.inters().load.isActivated()) {
            initGamePresent();
            initGamePresent = true;
        }
    }

}
