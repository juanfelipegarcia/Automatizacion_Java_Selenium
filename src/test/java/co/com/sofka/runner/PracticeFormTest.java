package co.com.sofka.runner;

import co.com.sofka.model.PracticeFormModel;
import co.com.sofka.page.PracticeFormPage;
import co.com.sofka.page.common.BaseSikulix;
import co.com.sofka.setup.WebUI;
import co.com.sofka.util.Gender;
import co.com.sofka.util.Hobbies;
import co.com.sofka.util.Student;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static co.com.sofka.util.Utilities.userDir;

class PracticeFormTest extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(PracticeFormTest.class);
    private PracticeFormPage practiceFormPage;
    private PracticeFormModel maria;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados %s";

    @BeforeEach
    public void setUp(){
        try {
            generalSetUp();
            generateStudent();
            LOGGER.info("Configuracion inicial del driver");
        } catch (Exception exception){
            quietDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Test
    void practiceFormTestMandatoryFields(){
        try {
            practiceFormPage = new PracticeFormPage(maria, driver);
            practiceFormPage.fillMandatoryFields();

            Assertions.assertEquals(
                    practiceFormPage.isRegistrationDoneMandatory().toString(),
                    forSubmittedFormMandatory().toString(),
                    String.format(ASSERTION_EXCEPTION_MESSAGE, outcomeMandatory())
            );
        }catch (Exception exception){
            quietDriver();
            Assertions.fail(exception.getMessage(), exception);
        }

    }


    @Test
    void practiceFromTestAllFields(){
        try {
            practiceFormPage = new PracticeFormPage(maria, driver);
            practiceFormPage.fillAllFileds();

            Assertions.assertEquals(
                    practiceFormPage.isRegistrationDoneAll().toString(),
                    forSubmittedFormAll().toString(),
                    String.format(ASSERTION_EXCEPTION_MESSAGE, outcomeAll())
            );
        }catch (Exception exception){
            quietDriver();
            Assertions.fail(exception.getMessage(), exception);
        }
    }

    @AfterEach
    public void tearDown()  {
        quietDriver();
    }

    private void generateStudent(){
        maria = new PracticeFormModel();
        maria.setName("Maria");
        maria.setLastName("mora");
        maria.setEmail("jfgarcia@gmail.com");
        maria.setGender(Gender.MALE);
        maria.setMobile("3006467268");
        maria.setYear("1980");
        maria.setMonth("February");
        maria.setDay("14");
        maria.setSubject(Arrays.asList("Physics", "Hindi", "Maths","Biology"));
        maria.setHobbies(Arrays.asList(Hobbies.READING,Hobbies.MUSIC, Hobbies.SPORTS));
        maria.setPath(userDir()+ Student.PHOTO.getValue());
        maria.setPicture("LUCA.jpg");
        maria.setState("Uttar Pradesh");
        maria.setCity("Agra");
        maria.setCurrentAddress("Cra 65 A N?? 44-66 Bello Ant, barrio bellavista");

    }

    public List<String> forSubmittedFormMandatory(){
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(maria.getName() + " " + maria.getLastName());
        submitedFormResult.add(maria.getGender().getValue());
        submitedFormResult.add(maria.getMobile());

        return submitedFormResult;
    }

    public List<String> forSubmittedFormAll(){
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(maria.getName() + " " + maria.getLastName());
        submitedFormResult.add(maria.getEmail());
        submitedFormResult.add(maria.getGender().getValue());
        submitedFormResult.add(maria.getMobile());
        submitedFormResult.add(maria.getDay() + " " + maria.getMonth()+ "," +maria.getYear());
        submitedFormResult.addAll(maria.getSubject());
        for (int i = 0; i<maria.getHobbies().size(); i++){
            submitedFormResult.add(maria.getHobbies().get(i).getValue());
        }
        submitedFormResult.add(maria.getPicture());
        submitedFormResult.add(maria.getCurrentAddress());
        submitedFormResult.add(maria.getState() + " " + maria.getCity());


        return submitedFormResult;
    }

    private String outcomeMandatory(){
        return "\n" + practiceFormPage.isRegistrationDoneMandatory().toString() + "\n\r" + forSubmittedFormMandatory().toString();
    }

    private String outcomeAll(){
        return "\n" + practiceFormPage.isRegistrationDoneAll().toString() + "\n\r" + forSubmittedFormAll().toString();
    }
}
