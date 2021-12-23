package co.com.sofka.stepdefinition;

import co.com.sofka.model.PracticeFormModel;
import co.com.sofka.page.PracticeFormPage;
import co.com.sofka.setup.WebUI;
import co.com.sofka.util.Gender;
import co.com.sofka.util.Hobbies;
import co.com.sofka.util.Student;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static co.com.sofka.util.Utilities.userDir;

public class PracticeFormTestCucumberStepDefinition extends WebUI {

    private PracticeFormPage practiceFormPage;
    private PracticeFormModel maria;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados %s";


    //Background
    @Given("Que el empleado asministrativo se encuentra en la pagina web de los ingresos de estudiantes")
    public void queElEmpleadoAsministrativoSeEncuentraEnLaPaginaWebDeLosIngresosDeEstudiantes() {
        try {
            generalSetUp();
        } catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            quietDriver();
        }
    }

    //Scenario I
    @When("el empleado administrativo ingresa los campos obligatorios y confirma la accion")
    public void elEmpleadoAdministrativoIngresaLosCamposObligatoriosYConfirmaLaAccion() {
        try {
            generateStudent();
            practiceFormPage = new PracticeFormPage(maria, driver);
            practiceFormPage.fillMandatoryFields();

        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            quietDriver();
        }
    }

    @Then("el sistema debera mostrar por panmtalla el registro del estudiante ingresado")
    public void elSistemaDeberaMostrarPorPanmtallaElRegistroDelEstudianteIngresado() {

       try {

           Assertions.assertEquals(
                   practiceFormPage.isRegistrationDoneMandatory().toString(),
                   forSubmittedFormMandatory().toString(),
                   String.format(ASSERTION_EXCEPTION_MESSAGE, outcomeMandatory())
           );
       }catch (Exception exception){
           quietDriver();

       }finally {
           quietDriver();
       }

    }

    //Scenario 2
    @When("el empleado administrativo ingresa todos los campos y confirma la accion")
    public void elEmpleadoAdministrativoIngresaTodosLosCamposYConfirmaLaAccion() {
        try {
            generateStudent();
            practiceFormPage = new PracticeFormPage(maria, driver);
            practiceFormPage.fillAllFileds();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            quietDriver();
        }
    }

    @Then("el sistema debera mostrar por panmtalla el registro completo del estudiante ingresado")
    public void elSistemaDeberaMostrarPorPanmtallaElRegistroCompletoDelEstudianteIngresado() {

        try {

            Assertions.assertEquals(
                    practiceFormPage.isRegistrationDoneAll().toString(),
                    forSubmittedFormAll().toString(),
                    String.format(ASSERTION_EXCEPTION_MESSAGE, outcomeAll())
            );

        }catch (Exception exception){
            quietDriver();
        }finally {
            quietDriver();
        }

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
        maria.setDay("29");
        maria.setSubject(Arrays.asList("Physics", "Hindi", "Maths"));
        maria.setHobbies(Arrays.asList(Hobbies.READING,Hobbies.MUSIC, Hobbies.SPORTS));
        maria.setPath(userDir()+ Student.PHOTO.getValue());
        maria.setPicture("LUCA.jpg");
        maria.setState("Uttar Pradesh");
        maria.setCity("Agra");
        maria.setCurrentAddress("Cra 65 A N° 44-66 Bello Ant, barrio bellavista");


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
        return "\n" + practiceFormPage.isRegistrationDoneAll() + "\n\r" + forSubmittedFormAll().toString();
    }

}
